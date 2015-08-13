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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'.'", "'*'", "'import'", "'{'", "'}'", "'integration'", "'javafx'", "'java'", "'e4'", "':'", "'partitioning'", "'partition'", "'script'", "'rule'", "'single_line'", "'=>'", "'escaped'", "'by'", "'multi_line'", "'lexical_highlighting'", "'default'", "'keywords'", "'['", "','", "']'", "'since'", "'pattern'", "'containing'", "'character'", "'whitespace'", "'javawhitespace'"
    };
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__17=17;
    public static final int T__39=39;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__35=35;
    public static final int T__14=14;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
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
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__20=20;
    public static final int T__42=42;
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

                if ( (LA16_0==26||LA16_0==30) ) {
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
            else if ( (LA17_0==30) ) {
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1106:1: rulePartition_SingleLineRule returns [EObject current=null] : (otherlv_0= 'single_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) )? (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) ;
    public final EObject rulePartition_SingleLineRule() throws RecognitionException {
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
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1109:28: ( (otherlv_0= 'single_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) )? (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1110:1: (otherlv_0= 'single_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) )? (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1110:1: (otherlv_0= 'single_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) )? (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1110:3: otherlv_0= 'single_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) )? (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
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

            otherlv_3=(Token)match(input,27,FOLLOW_27_in_rulePartition_SingleLineRule2678); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getPartition_SingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1149:1: ( (lv_endSeq_4_0= RULE_STRING ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_STRING) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1150:1: (lv_endSeq_4_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1150:1: (lv_endSeq_4_0= RULE_STRING )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1151:3: lv_endSeq_4_0= RULE_STRING
                    {
                    lv_endSeq_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartition_SingleLineRule2695); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_endSeq_4_0, grammarAccess.getPartition_SingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPartition_SingleLineRuleRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"endSeq",
                              		lv_endSeq_4_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1167:3: (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==28) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1167:5: otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,28,FOLLOW_28_in_rulePartition_SingleLineRule2714); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getPartition_SingleLineRuleAccess().getEscapedKeyword_5_0());
                          
                    }
                    otherlv_6=(Token)match(input,29,FOLLOW_29_in_rulePartition_SingleLineRule2726); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getPartition_SingleLineRuleAccess().getByKeyword_5_1());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1175:1: ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1176:1: (lv_escapeSeq_7_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1176:1: (lv_escapeSeq_7_0= RULE_STRING )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1177:3: lv_escapeSeq_7_0= RULE_STRING
                    {
                    lv_escapeSeq_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartition_SingleLineRule2743); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_escapeSeq_7_0, grammarAccess.getPartition_SingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPartition_SingleLineRuleRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"escapeSeq",
                              		lv_escapeSeq_7_0, 
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1201:1: entryRulePartition_MultiLineRule returns [EObject current=null] : iv_rulePartition_MultiLineRule= rulePartition_MultiLineRule EOF ;
    public final EObject entryRulePartition_MultiLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartition_MultiLineRule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1202:2: (iv_rulePartition_MultiLineRule= rulePartition_MultiLineRule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1203:2: iv_rulePartition_MultiLineRule= rulePartition_MultiLineRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPartition_MultiLineRuleRule()); 
            }
            pushFollow(FOLLOW_rulePartition_MultiLineRule_in_entryRulePartition_MultiLineRule2786);
            iv_rulePartition_MultiLineRule=rulePartition_MultiLineRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePartition_MultiLineRule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePartition_MultiLineRule2796); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1210:1: rulePartition_MultiLineRule returns [EObject current=null] : (otherlv_0= 'multi_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) ;
    public final EObject rulePartition_MultiLineRule() throws RecognitionException {
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
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1213:28: ( (otherlv_0= 'multi_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1214:1: (otherlv_0= 'multi_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1214:1: (otherlv_0= 'multi_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1214:3: otherlv_0= 'multi_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_rulePartition_MultiLineRule2833); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getPartition_MultiLineRuleAccess().getMulti_lineKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1218:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1219:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1219:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1220:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getPartition_MultiLineRuleRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePartition_MultiLineRule2853); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getPartition_MultiLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
              	
            }

            }


            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1231:2: ( (lv_startSeq_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1232:1: (lv_startSeq_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1232:1: (lv_startSeq_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1233:3: lv_startSeq_2_0= RULE_STRING
            {
            lv_startSeq_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartition_MultiLineRule2870); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,27,FOLLOW_27_in_rulePartition_MultiLineRule2887); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getPartition_MultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1253:1: ( (lv_endSeq_4_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1254:1: (lv_endSeq_4_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1254:1: (lv_endSeq_4_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1255:3: lv_endSeq_4_0= RULE_STRING
            {
            lv_endSeq_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartition_MultiLineRule2904); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_endSeq_4_0, grammarAccess.getPartition_MultiLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_4_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getPartition_MultiLineRuleRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"endSeq",
                      		lv_endSeq_4_0, 
                      		"STRING");
              	    
            }

            }


            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1271:2: (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==28) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1271:4: otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,28,FOLLOW_28_in_rulePartition_MultiLineRule2922); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getPartition_MultiLineRuleAccess().getEscapedKeyword_5_0());
                          
                    }
                    otherlv_6=(Token)match(input,29,FOLLOW_29_in_rulePartition_MultiLineRule2934); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getPartition_MultiLineRuleAccess().getByKeyword_5_1());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1279:1: ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1280:1: (lv_escapeSeq_7_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1280:1: (lv_escapeSeq_7_0= RULE_STRING )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1281:3: lv_escapeSeq_7_0= RULE_STRING
                    {
                    lv_escapeSeq_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartition_MultiLineRule2951); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_escapeSeq_7_0, grammarAccess.getPartition_MultiLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_5_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPartition_MultiLineRuleRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"escapeSeq",
                              		lv_escapeSeq_7_0, 
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1305:1: entryRuleLexicalHighlighting returns [EObject current=null] : iv_ruleLexicalHighlighting= ruleLexicalHighlighting EOF ;
    public final EObject entryRuleLexicalHighlighting() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLexicalHighlighting = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1306:2: (iv_ruleLexicalHighlighting= ruleLexicalHighlighting EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1307:2: iv_ruleLexicalHighlighting= ruleLexicalHighlighting EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLexicalHighlightingRule()); 
            }
            pushFollow(FOLLOW_ruleLexicalHighlighting_in_entryRuleLexicalHighlighting2994);
            iv_ruleLexicalHighlighting=ruleLexicalHighlighting();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLexicalHighlighting; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexicalHighlighting3004); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1314:1: ruleLexicalHighlighting returns [EObject current=null] : (otherlv_0= 'lexical_highlighting' otherlv_1= '{' ( (lv_list_2_0= ruleLexicalPartitionHighlighting ) )+ otherlv_3= '}' ) ;
    public final EObject ruleLexicalHighlighting() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_list_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1317:28: ( (otherlv_0= 'lexical_highlighting' otherlv_1= '{' ( (lv_list_2_0= ruleLexicalPartitionHighlighting ) )+ otherlv_3= '}' ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1318:1: (otherlv_0= 'lexical_highlighting' otherlv_1= '{' ( (lv_list_2_0= ruleLexicalPartitionHighlighting ) )+ otherlv_3= '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1318:1: (otherlv_0= 'lexical_highlighting' otherlv_1= '{' ( (lv_list_2_0= ruleLexicalPartitionHighlighting ) )+ otherlv_3= '}' )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1318:3: otherlv_0= 'lexical_highlighting' otherlv_1= '{' ( (lv_list_2_0= ruleLexicalPartitionHighlighting ) )+ otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleLexicalHighlighting3041); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLexicalHighlightingAccess().getLexical_highlightingKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleLexicalHighlighting3053); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLexicalHighlightingAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1326:1: ( (lv_list_2_0= ruleLexicalPartitionHighlighting ) )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=24 && LA21_0<=25)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1327:1: (lv_list_2_0= ruleLexicalPartitionHighlighting )
            	    {
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1327:1: (lv_list_2_0= ruleLexicalPartitionHighlighting )
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1328:3: lv_list_2_0= ruleLexicalPartitionHighlighting
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLexicalHighlightingAccess().getListLexicalPartitionHighlightingParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_in_ruleLexicalHighlighting3074);
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
            	    if ( cnt21 >= 1 ) break loop21;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
            } while (true);

            otherlv_3=(Token)match(input,16,FOLLOW_16_in_ruleLexicalHighlighting3087); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLexicalHighlightingAccess().getRightCurlyBracketKeyword_3());
                  
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


    // $ANTLR start "entryRuleLexicalPartitionHighlighting"
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1356:1: entryRuleLexicalPartitionHighlighting returns [EObject current=null] : iv_ruleLexicalPartitionHighlighting= ruleLexicalPartitionHighlighting EOF ;
    public final EObject entryRuleLexicalPartitionHighlighting() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLexicalPartitionHighlighting = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1357:2: (iv_ruleLexicalPartitionHighlighting= ruleLexicalPartitionHighlighting EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1358:2: iv_ruleLexicalPartitionHighlighting= ruleLexicalPartitionHighlighting EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLexicalPartitionHighlightingRule()); 
            }
            pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_in_entryRuleLexicalPartitionHighlighting3123);
            iv_ruleLexicalPartitionHighlighting=ruleLexicalPartitionHighlighting();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLexicalPartitionHighlighting; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting3133); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1365:1: ruleLexicalPartitionHighlighting returns [EObject current=null] : (this_LexicalPartitionHighlighting_Rule_0= ruleLexicalPartitionHighlighting_Rule | this_LexicalPartitionHighlighting_JS_1= ruleLexicalPartitionHighlighting_JS ) ;
    public final EObject ruleLexicalPartitionHighlighting() throws RecognitionException {
        EObject current = null;

        EObject this_LexicalPartitionHighlighting_Rule_0 = null;

        EObject this_LexicalPartitionHighlighting_JS_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1368:28: ( (this_LexicalPartitionHighlighting_Rule_0= ruleLexicalPartitionHighlighting_Rule | this_LexicalPartitionHighlighting_JS_1= ruleLexicalPartitionHighlighting_JS ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1369:1: (this_LexicalPartitionHighlighting_Rule_0= ruleLexicalPartitionHighlighting_Rule | this_LexicalPartitionHighlighting_JS_1= ruleLexicalPartitionHighlighting_JS )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1369:1: (this_LexicalPartitionHighlighting_Rule_0= ruleLexicalPartitionHighlighting_Rule | this_LexicalPartitionHighlighting_JS_1= ruleLexicalPartitionHighlighting_JS )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==25) ) {
                alt22=1;
            }
            else if ( (LA22_0==24) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1370:5: this_LexicalPartitionHighlighting_Rule_0= ruleLexicalPartitionHighlighting_Rule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLexicalPartitionHighlightingAccess().getLexicalPartitionHighlighting_RuleParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_Rule_in_ruleLexicalPartitionHighlighting3180);
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1380:5: this_LexicalPartitionHighlighting_JS_1= ruleLexicalPartitionHighlighting_JS
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLexicalPartitionHighlightingAccess().getLexicalPartitionHighlighting_JSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_JS_in_ruleLexicalPartitionHighlighting3207);
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1396:1: entryRuleLexicalPartitionHighlighting_JS returns [EObject current=null] : iv_ruleLexicalPartitionHighlighting_JS= ruleLexicalPartitionHighlighting_JS EOF ;
    public final EObject entryRuleLexicalPartitionHighlighting_JS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLexicalPartitionHighlighting_JS = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1397:2: (iv_ruleLexicalPartitionHighlighting_JS= ruleLexicalPartitionHighlighting_JS EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1398:2: iv_ruleLexicalPartitionHighlighting_JS= ruleLexicalPartitionHighlighting_JS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLexicalPartitionHighlighting_JSRule()); 
            }
            pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_JS_in_entryRuleLexicalPartitionHighlighting_JS3242);
            iv_ruleLexicalPartitionHighlighting_JS=ruleLexicalPartitionHighlighting_JS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLexicalPartitionHighlighting_JS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting_JS3252); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1405:1: ruleLexicalPartitionHighlighting_JS returns [EObject current=null] : (otherlv_0= 'script' ( (otherlv_1= RULE_ID ) ) ( (lv_scriptURI_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleLexicalPartitionHighlighting_JS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_scriptURI_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1408:28: ( (otherlv_0= 'script' ( (otherlv_1= RULE_ID ) ) ( (lv_scriptURI_2_0= RULE_STRING ) ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1409:1: (otherlv_0= 'script' ( (otherlv_1= RULE_ID ) ) ( (lv_scriptURI_2_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1409:1: (otherlv_0= 'script' ( (otherlv_1= RULE_ID ) ) ( (lv_scriptURI_2_0= RULE_STRING ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1409:3: otherlv_0= 'script' ( (otherlv_1= RULE_ID ) ) ( (lv_scriptURI_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleLexicalPartitionHighlighting_JS3289); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLexicalPartitionHighlighting_JSAccess().getScriptKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1413:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1414:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1414:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1415:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getLexicalPartitionHighlighting_JSRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLexicalPartitionHighlighting_JS3309); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getLexicalPartitionHighlighting_JSAccess().getPartitionPartitionCrossReference_1_0()); 
              	
            }

            }


            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1426:2: ( (lv_scriptURI_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1427:1: (lv_scriptURI_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1427:1: (lv_scriptURI_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1428:3: lv_scriptURI_2_0= RULE_STRING
            {
            lv_scriptURI_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLexicalPartitionHighlighting_JS3326); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1452:1: entryRuleLexicalPartitionHighlighting_Rule returns [EObject current=null] : iv_ruleLexicalPartitionHighlighting_Rule= ruleLexicalPartitionHighlighting_Rule EOF ;
    public final EObject entryRuleLexicalPartitionHighlighting_Rule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLexicalPartitionHighlighting_Rule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1453:2: (iv_ruleLexicalPartitionHighlighting_Rule= ruleLexicalPartitionHighlighting_Rule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1454:2: iv_ruleLexicalPartitionHighlighting_Rule= ruleLexicalPartitionHighlighting_Rule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLexicalPartitionHighlighting_RuleRule()); 
            }
            pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_Rule_in_entryRuleLexicalPartitionHighlighting_Rule3367);
            iv_ruleLexicalPartitionHighlighting_Rule=ruleLexicalPartitionHighlighting_Rule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLexicalPartitionHighlighting_Rule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting_Rule3377); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1461:1: ruleLexicalPartitionHighlighting_Rule returns [EObject current=null] : (otherlv_0= 'rule' ( (otherlv_1= RULE_ID ) ) ( (lv_whitespace_2_0= ruleWhitespaceRule ) )? otherlv_3= '{' ( (lv_tokenList_4_0= ruleToken ) )+ otherlv_5= '}' ) ;
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
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1464:28: ( (otherlv_0= 'rule' ( (otherlv_1= RULE_ID ) ) ( (lv_whitespace_2_0= ruleWhitespaceRule ) )? otherlv_3= '{' ( (lv_tokenList_4_0= ruleToken ) )+ otherlv_5= '}' ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1465:1: (otherlv_0= 'rule' ( (otherlv_1= RULE_ID ) ) ( (lv_whitespace_2_0= ruleWhitespaceRule ) )? otherlv_3= '{' ( (lv_tokenList_4_0= ruleToken ) )+ otherlv_5= '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1465:1: (otherlv_0= 'rule' ( (otherlv_1= RULE_ID ) ) ( (lv_whitespace_2_0= ruleWhitespaceRule ) )? otherlv_3= '{' ( (lv_tokenList_4_0= ruleToken ) )+ otherlv_5= '}' )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1465:3: otherlv_0= 'rule' ( (otherlv_1= RULE_ID ) ) ( (lv_whitespace_2_0= ruleWhitespaceRule ) )? otherlv_3= '{' ( (lv_tokenList_4_0= ruleToken ) )+ otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleLexicalPartitionHighlighting_Rule3414); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getRuleKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1469:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1470:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1470:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1471:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getLexicalPartitionHighlighting_RuleRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLexicalPartitionHighlighting_Rule3434); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getPartitionPartitionCrossReference_1_0()); 
              	
            }

            }


            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1482:2: ( (lv_whitespace_2_0= ruleWhitespaceRule ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==41) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1483:1: (lv_whitespace_2_0= ruleWhitespaceRule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1483:1: (lv_whitespace_2_0= ruleWhitespaceRule )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1484:3: lv_whitespace_2_0= ruleWhitespaceRule
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getWhitespaceWhitespaceRuleParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleWhitespaceRule_in_ruleLexicalPartitionHighlighting_Rule3455);
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

            otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleLexicalPartitionHighlighting_Rule3468); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1504:1: ( (lv_tokenList_4_0= ruleToken ) )+
            int cnt24=0;
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_ID||LA24_0==32) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1505:1: (lv_tokenList_4_0= ruleToken )
            	    {
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1505:1: (lv_tokenList_4_0= ruleToken )
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1506:3: lv_tokenList_4_0= ruleToken
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getTokenListTokenParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleToken_in_ruleLexicalPartitionHighlighting_Rule3489);
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
            	    if ( cnt24 >= 1 ) break loop24;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
            } while (true);

            otherlv_5=(Token)match(input,16,FOLLOW_16_in_ruleLexicalPartitionHighlighting_Rule3502); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1534:1: entryRuleToken returns [EObject current=null] : iv_ruleToken= ruleToken EOF ;
    public final EObject entryRuleToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleToken = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1535:2: (iv_ruleToken= ruleToken EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1536:2: iv_ruleToken= ruleToken EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTokenRule()); 
            }
            pushFollow(FOLLOW_ruleToken_in_entryRuleToken3538);
            iv_ruleToken=ruleToken();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleToken; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleToken3548); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1543:1: ruleToken returns [EObject current=null] : ( ( (lv_default_0_0= 'default' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_scannerList_3_0= ruleScanner ) )+ otherlv_4= '}' )? ) ;
    public final EObject ruleToken() throws RecognitionException {
        EObject current = null;

        Token lv_default_0_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_scannerList_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1546:28: ( ( ( (lv_default_0_0= 'default' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_scannerList_3_0= ruleScanner ) )+ otherlv_4= '}' )? ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1547:1: ( ( (lv_default_0_0= 'default' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_scannerList_3_0= ruleScanner ) )+ otherlv_4= '}' )? )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1547:1: ( ( (lv_default_0_0= 'default' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_scannerList_3_0= ruleScanner ) )+ otherlv_4= '}' )? )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1547:2: ( (lv_default_0_0= 'default' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_scannerList_3_0= ruleScanner ) )+ otherlv_4= '}' )?
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1547:2: ( (lv_default_0_0= 'default' ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==32) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1548:1: (lv_default_0_0= 'default' )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1548:1: (lv_default_0_0= 'default' )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1549:3: lv_default_0_0= 'default'
                    {
                    lv_default_0_0=(Token)match(input,32,FOLLOW_32_in_ruleToken3591); if (state.failed) return current;
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

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1562:3: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1563:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1563:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1564:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleToken3622); if (state.failed) return current;
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

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1580:2: (otherlv_2= '{' ( (lv_scannerList_3_0= ruleScanner ) )+ otherlv_4= '}' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==15) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1580:4: otherlv_2= '{' ( (lv_scannerList_3_0= ruleScanner ) )+ otherlv_4= '}'
                    {
                    otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleToken3640); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getTokenAccess().getLeftCurlyBracketKeyword_2_0());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1584:1: ( (lv_scannerList_3_0= ruleScanner ) )+
                    int cnt26=0;
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==24||LA26_0==26||LA26_0==30||LA26_0==33||LA26_0==38||LA26_0==40) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1585:1: (lv_scannerList_3_0= ruleScanner )
                    	    {
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1585:1: (lv_scannerList_3_0= ruleScanner )
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1586:3: lv_scannerList_3_0= ruleScanner
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getTokenAccess().getScannerListScannerParserRuleCall_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleScanner_in_ruleToken3661);
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
                    	    if ( cnt26 >= 1 ) break loop26;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(26, input);
                                throw eee;
                        }
                        cnt26++;
                    } while (true);

                    otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleToken3674); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1614:1: entryRuleScanner returns [EObject current=null] : iv_ruleScanner= ruleScanner EOF ;
    public final EObject entryRuleScanner() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1615:2: (iv_ruleScanner= ruleScanner EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1616:2: iv_ruleScanner= ruleScanner EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScannerRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_in_entryRuleScanner3712);
            iv_ruleScanner=ruleScanner();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner3722); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1623:1: ruleScanner returns [EObject current=null] : (this_Scanner_Keyword_0= ruleScanner_Keyword | this_Scanner_Rule_1= ruleScanner_Rule ) ;
    public final EObject ruleScanner() throws RecognitionException {
        EObject current = null;

        EObject this_Scanner_Keyword_0 = null;

        EObject this_Scanner_Rule_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1626:28: ( (this_Scanner_Keyword_0= ruleScanner_Keyword | this_Scanner_Rule_1= ruleScanner_Rule ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1627:1: (this_Scanner_Keyword_0= ruleScanner_Keyword | this_Scanner_Rule_1= ruleScanner_Rule )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1627:1: (this_Scanner_Keyword_0= ruleScanner_Keyword | this_Scanner_Rule_1= ruleScanner_Rule )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==33) ) {
                alt28=1;
            }
            else if ( (LA28_0==24||LA28_0==26||LA28_0==30||LA28_0==38||LA28_0==40) ) {
                alt28=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1628:5: this_Scanner_Keyword_0= ruleScanner_Keyword
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getScannerAccess().getScanner_KeywordParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleScanner_Keyword_in_ruleScanner3769);
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1638:5: this_Scanner_Rule_1= ruleScanner_Rule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getScannerAccess().getScanner_RuleParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleScanner_Rule_in_ruleScanner3796);
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1654:1: entryRuleScanner_Keyword returns [EObject current=null] : iv_ruleScanner_Keyword= ruleScanner_Keyword EOF ;
    public final EObject entryRuleScanner_Keyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner_Keyword = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1655:2: (iv_ruleScanner_Keyword= ruleScanner_Keyword EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1656:2: iv_ruleScanner_Keyword= ruleScanner_Keyword EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScanner_KeywordRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_Keyword_in_entryRuleScanner_Keyword3831);
            iv_ruleScanner_Keyword=ruleScanner_Keyword();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner_Keyword; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_Keyword3841); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1663:1: ruleScanner_Keyword returns [EObject current=null] : (otherlv_0= 'keywords' otherlv_1= '[' ( (lv_keywords_2_0= ruleKeyword ) ) (otherlv_3= ',' ( (lv_keywords_4_0= ruleKeyword ) ) )* otherlv_5= ']' ) ;
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
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1666:28: ( (otherlv_0= 'keywords' otherlv_1= '[' ( (lv_keywords_2_0= ruleKeyword ) ) (otherlv_3= ',' ( (lv_keywords_4_0= ruleKeyword ) ) )* otherlv_5= ']' ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1667:1: (otherlv_0= 'keywords' otherlv_1= '[' ( (lv_keywords_2_0= ruleKeyword ) ) (otherlv_3= ',' ( (lv_keywords_4_0= ruleKeyword ) ) )* otherlv_5= ']' )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1667:1: (otherlv_0= 'keywords' otherlv_1= '[' ( (lv_keywords_2_0= ruleKeyword ) ) (otherlv_3= ',' ( (lv_keywords_4_0= ruleKeyword ) ) )* otherlv_5= ']' )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1667:3: otherlv_0= 'keywords' otherlv_1= '[' ( (lv_keywords_2_0= ruleKeyword ) ) (otherlv_3= ',' ( (lv_keywords_4_0= ruleKeyword ) ) )* otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_33_in_ruleScanner_Keyword3878); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getScanner_KeywordAccess().getKeywordsKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,34,FOLLOW_34_in_ruleScanner_Keyword3890); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getScanner_KeywordAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1675:1: ( (lv_keywords_2_0= ruleKeyword ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1676:1: (lv_keywords_2_0= ruleKeyword )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1676:1: (lv_keywords_2_0= ruleKeyword )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1677:3: lv_keywords_2_0= ruleKeyword
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getScanner_KeywordAccess().getKeywordsKeywordParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleKeyword_in_ruleScanner_Keyword3911);
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

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1693:2: (otherlv_3= ',' ( (lv_keywords_4_0= ruleKeyword ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==35) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1693:4: otherlv_3= ',' ( (lv_keywords_4_0= ruleKeyword ) )
            	    {
            	    otherlv_3=(Token)match(input,35,FOLLOW_35_in_ruleScanner_Keyword3924); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getScanner_KeywordAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1697:1: ( (lv_keywords_4_0= ruleKeyword ) )
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1698:1: (lv_keywords_4_0= ruleKeyword )
            	    {
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1698:1: (lv_keywords_4_0= ruleKeyword )
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1699:3: lv_keywords_4_0= ruleKeyword
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getScanner_KeywordAccess().getKeywordsKeywordParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleKeyword_in_ruleScanner_Keyword3945);
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
            	    break loop29;
                }
            } while (true);

            otherlv_5=(Token)match(input,36,FOLLOW_36_in_ruleScanner_Keyword3959); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1727:1: entryRuleKeyword returns [EObject current=null] : iv_ruleKeyword= ruleKeyword EOF ;
    public final EObject entryRuleKeyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyword = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1728:2: (iv_ruleKeyword= ruleKeyword EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1729:2: iv_ruleKeyword= ruleKeyword EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getKeywordRule()); 
            }
            pushFollow(FOLLOW_ruleKeyword_in_entryRuleKeyword3995);
            iv_ruleKeyword=ruleKeyword();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleKeyword; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyword4005); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1736:1: ruleKeyword returns [EObject current=null] : ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_version_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1739:28: ( ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1740:1: ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1740:1: ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1740:2: ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )?
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1740:2: ( (lv_name_0_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1741:1: (lv_name_0_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1741:1: (lv_name_0_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1742:3: lv_name_0_0= RULE_STRING
            {
            lv_name_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword4047); if (state.failed) return current;
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

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1758:2: (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==37) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1758:4: otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) )
                    {
                    otherlv_1=(Token)match(input,37,FOLLOW_37_in_ruleKeyword4065); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getKeywordAccess().getSinceKeyword_1_0());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1762:1: ( (lv_version_2_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1763:1: (lv_version_2_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1763:1: (lv_version_2_0= RULE_STRING )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1764:3: lv_version_2_0= RULE_STRING
                    {
                    lv_version_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword4082); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1788:1: entryRuleScanner_Rule returns [EObject current=null] : iv_ruleScanner_Rule= ruleScanner_Rule EOF ;
    public final EObject entryRuleScanner_Rule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner_Rule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1789:2: (iv_ruleScanner_Rule= ruleScanner_Rule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1790:2: iv_ruleScanner_Rule= ruleScanner_Rule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScanner_RuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_Rule_in_entryRuleScanner_Rule4125);
            iv_ruleScanner_Rule=ruleScanner_Rule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner_Rule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_Rule4135); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1797:1: ruleScanner_Rule returns [EObject current=null] : (this_Scanner_SingleLineRule_0= ruleScanner_SingleLineRule | this_Scanner_MultiLineRule_1= ruleScanner_MultiLineRule | this_Scanner_CharacterRule_2= ruleScanner_CharacterRule | this_Scanner_JSRule_3= ruleScanner_JSRule | this_Scanner_PatternRule_4= ruleScanner_PatternRule ) ;
    public final EObject ruleScanner_Rule() throws RecognitionException {
        EObject current = null;

        EObject this_Scanner_SingleLineRule_0 = null;

        EObject this_Scanner_MultiLineRule_1 = null;

        EObject this_Scanner_CharacterRule_2 = null;

        EObject this_Scanner_JSRule_3 = null;

        EObject this_Scanner_PatternRule_4 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1800:28: ( (this_Scanner_SingleLineRule_0= ruleScanner_SingleLineRule | this_Scanner_MultiLineRule_1= ruleScanner_MultiLineRule | this_Scanner_CharacterRule_2= ruleScanner_CharacterRule | this_Scanner_JSRule_3= ruleScanner_JSRule | this_Scanner_PatternRule_4= ruleScanner_PatternRule ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1801:1: (this_Scanner_SingleLineRule_0= ruleScanner_SingleLineRule | this_Scanner_MultiLineRule_1= ruleScanner_MultiLineRule | this_Scanner_CharacterRule_2= ruleScanner_CharacterRule | this_Scanner_JSRule_3= ruleScanner_JSRule | this_Scanner_PatternRule_4= ruleScanner_PatternRule )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1801:1: (this_Scanner_SingleLineRule_0= ruleScanner_SingleLineRule | this_Scanner_MultiLineRule_1= ruleScanner_MultiLineRule | this_Scanner_CharacterRule_2= ruleScanner_CharacterRule | this_Scanner_JSRule_3= ruleScanner_JSRule | this_Scanner_PatternRule_4= ruleScanner_PatternRule )
            int alt31=5;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt31=1;
                }
                break;
            case 30:
                {
                alt31=2;
                }
                break;
            case 40:
                {
                alt31=3;
                }
                break;
            case 24:
                {
                alt31=4;
                }
                break;
            case 38:
                {
                alt31=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1802:5: this_Scanner_SingleLineRule_0= ruleScanner_SingleLineRule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getScanner_RuleAccess().getScanner_SingleLineRuleParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleScanner_SingleLineRule_in_ruleScanner_Rule4182);
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1812:5: this_Scanner_MultiLineRule_1= ruleScanner_MultiLineRule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getScanner_RuleAccess().getScanner_MultiLineRuleParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleScanner_MultiLineRule_in_ruleScanner_Rule4209);
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1822:5: this_Scanner_CharacterRule_2= ruleScanner_CharacterRule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getScanner_RuleAccess().getScanner_CharacterRuleParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleScanner_CharacterRule_in_ruleScanner_Rule4236);
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1832:5: this_Scanner_JSRule_3= ruleScanner_JSRule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getScanner_RuleAccess().getScanner_JSRuleParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleScanner_JSRule_in_ruleScanner_Rule4263);
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1842:5: this_Scanner_PatternRule_4= ruleScanner_PatternRule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getScanner_RuleAccess().getScanner_PatternRuleParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleScanner_PatternRule_in_ruleScanner_Rule4290);
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1858:1: entryRuleScanner_SingleLineRule returns [EObject current=null] : iv_ruleScanner_SingleLineRule= ruleScanner_SingleLineRule EOF ;
    public final EObject entryRuleScanner_SingleLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner_SingleLineRule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1859:2: (iv_ruleScanner_SingleLineRule= ruleScanner_SingleLineRule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1860:2: iv_ruleScanner_SingleLineRule= ruleScanner_SingleLineRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScanner_SingleLineRuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_SingleLineRule_in_entryRuleScanner_SingleLineRule4325);
            iv_ruleScanner_SingleLineRule=ruleScanner_SingleLineRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner_SingleLineRule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_SingleLineRule4335); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1867:1: ruleScanner_SingleLineRule returns [EObject current=null] : (otherlv_0= 'single_line' ( (lv_startSeq_1_0= RULE_STRING ) ) (otherlv_2= '=>' ( (lv_endSeq_3_0= RULE_STRING ) )? )? (otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleScanner_SingleLineRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_startSeq_1_0=null;
        Token otherlv_2=null;
        Token lv_endSeq_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_escapeSeq_6_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1870:28: ( (otherlv_0= 'single_line' ( (lv_startSeq_1_0= RULE_STRING ) ) (otherlv_2= '=>' ( (lv_endSeq_3_0= RULE_STRING ) )? )? (otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1871:1: (otherlv_0= 'single_line' ( (lv_startSeq_1_0= RULE_STRING ) ) (otherlv_2= '=>' ( (lv_endSeq_3_0= RULE_STRING ) )? )? (otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1871:1: (otherlv_0= 'single_line' ( (lv_startSeq_1_0= RULE_STRING ) ) (otherlv_2= '=>' ( (lv_endSeq_3_0= RULE_STRING ) )? )? (otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1871:3: otherlv_0= 'single_line' ( (lv_startSeq_1_0= RULE_STRING ) ) (otherlv_2= '=>' ( (lv_endSeq_3_0= RULE_STRING ) )? )? (otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,26,FOLLOW_26_in_ruleScanner_SingleLineRule4372); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getScanner_SingleLineRuleAccess().getSingle_lineKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1875:1: ( (lv_startSeq_1_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1876:1: (lv_startSeq_1_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1876:1: (lv_startSeq_1_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1877:3: lv_startSeq_1_0= RULE_STRING
            {
            lv_startSeq_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_SingleLineRule4389); if (state.failed) return current;
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

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1893:2: (otherlv_2= '=>' ( (lv_endSeq_3_0= RULE_STRING ) )? )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==27) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1893:4: otherlv_2= '=>' ( (lv_endSeq_3_0= RULE_STRING ) )?
                    {
                    otherlv_2=(Token)match(input,27,FOLLOW_27_in_ruleScanner_SingleLineRule4407); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getScanner_SingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_2_0());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1897:1: ( (lv_endSeq_3_0= RULE_STRING ) )?
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==RULE_STRING) ) {
                        alt32=1;
                    }
                    switch (alt32) {
                        case 1 :
                            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1898:1: (lv_endSeq_3_0= RULE_STRING )
                            {
                            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1898:1: (lv_endSeq_3_0= RULE_STRING )
                            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1899:3: lv_endSeq_3_0= RULE_STRING
                            {
                            lv_endSeq_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_SingleLineRule4424); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_endSeq_3_0, grammarAccess.getScanner_SingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_2_1_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getScanner_SingleLineRuleRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"endSeq",
                                      		lv_endSeq_3_0, 
                                      		"STRING");
                              	    
                            }

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1915:5: (otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==28) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1915:7: otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,28,FOLLOW_28_in_ruleScanner_SingleLineRule4445); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getScanner_SingleLineRuleAccess().getEscapedKeyword_3_0());
                          
                    }
                    otherlv_5=(Token)match(input,29,FOLLOW_29_in_ruleScanner_SingleLineRule4457); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getScanner_SingleLineRuleAccess().getByKeyword_3_1());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1923:1: ( (lv_escapeSeq_6_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1924:1: (lv_escapeSeq_6_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1924:1: (lv_escapeSeq_6_0= RULE_STRING )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1925:3: lv_escapeSeq_6_0= RULE_STRING
                    {
                    lv_escapeSeq_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_SingleLineRule4474); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_escapeSeq_6_0, grammarAccess.getScanner_SingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_3_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getScanner_SingleLineRuleRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"escapeSeq",
                              		lv_escapeSeq_6_0, 
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1949:1: entryRuleScanner_MultiLineRule returns [EObject current=null] : iv_ruleScanner_MultiLineRule= ruleScanner_MultiLineRule EOF ;
    public final EObject entryRuleScanner_MultiLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner_MultiLineRule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1950:2: (iv_ruleScanner_MultiLineRule= ruleScanner_MultiLineRule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1951:2: iv_ruleScanner_MultiLineRule= ruleScanner_MultiLineRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScanner_MultiLineRuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_MultiLineRule_in_entryRuleScanner_MultiLineRule4517);
            iv_ruleScanner_MultiLineRule=ruleScanner_MultiLineRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner_MultiLineRule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_MultiLineRule4527); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1958:1: ruleScanner_MultiLineRule returns [EObject current=null] : (otherlv_0= 'multi_line' ( (lv_startSeq_1_0= RULE_STRING ) ) otherlv_2= '=>' ( (lv_endSeq_3_0= RULE_STRING ) ) (otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleScanner_MultiLineRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_startSeq_1_0=null;
        Token otherlv_2=null;
        Token lv_endSeq_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_escapeSeq_6_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1961:28: ( (otherlv_0= 'multi_line' ( (lv_startSeq_1_0= RULE_STRING ) ) otherlv_2= '=>' ( (lv_endSeq_3_0= RULE_STRING ) ) (otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1962:1: (otherlv_0= 'multi_line' ( (lv_startSeq_1_0= RULE_STRING ) ) otherlv_2= '=>' ( (lv_endSeq_3_0= RULE_STRING ) ) (otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1962:1: (otherlv_0= 'multi_line' ( (lv_startSeq_1_0= RULE_STRING ) ) otherlv_2= '=>' ( (lv_endSeq_3_0= RULE_STRING ) ) (otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1962:3: otherlv_0= 'multi_line' ( (lv_startSeq_1_0= RULE_STRING ) ) otherlv_2= '=>' ( (lv_endSeq_3_0= RULE_STRING ) ) (otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleScanner_MultiLineRule4564); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getScanner_MultiLineRuleAccess().getMulti_lineKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1966:1: ( (lv_startSeq_1_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1967:1: (lv_startSeq_1_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1967:1: (lv_startSeq_1_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1968:3: lv_startSeq_1_0= RULE_STRING
            {
            lv_startSeq_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_MultiLineRule4581); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,27,FOLLOW_27_in_ruleScanner_MultiLineRule4598); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getScanner_MultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_2());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1988:1: ( (lv_endSeq_3_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1989:1: (lv_endSeq_3_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1989:1: (lv_endSeq_3_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1990:3: lv_endSeq_3_0= RULE_STRING
            {
            lv_endSeq_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_MultiLineRule4615); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_endSeq_3_0, grammarAccess.getScanner_MultiLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getScanner_MultiLineRuleRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"endSeq",
                      		lv_endSeq_3_0, 
                      		"STRING");
              	    
            }

            }


            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2006:2: (otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==28) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2006:4: otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,28,FOLLOW_28_in_ruleScanner_MultiLineRule4633); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getScanner_MultiLineRuleAccess().getEscapedKeyword_4_0());
                          
                    }
                    otherlv_5=(Token)match(input,29,FOLLOW_29_in_ruleScanner_MultiLineRule4645); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getScanner_MultiLineRuleAccess().getByKeyword_4_1());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2014:1: ( (lv_escapeSeq_6_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2015:1: (lv_escapeSeq_6_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2015:1: (lv_escapeSeq_6_0= RULE_STRING )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2016:3: lv_escapeSeq_6_0= RULE_STRING
                    {
                    lv_escapeSeq_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_MultiLineRule4662); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_escapeSeq_6_0, grammarAccess.getScanner_MultiLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_4_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getScanner_MultiLineRuleRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"escapeSeq",
                              		lv_escapeSeq_6_0, 
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2040:1: entryRuleScanner_PatternRule returns [EObject current=null] : iv_ruleScanner_PatternRule= ruleScanner_PatternRule EOF ;
    public final EObject entryRuleScanner_PatternRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner_PatternRule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2041:2: (iv_ruleScanner_PatternRule= ruleScanner_PatternRule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2042:2: iv_ruleScanner_PatternRule= ruleScanner_PatternRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScanner_PatternRuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_PatternRule_in_entryRuleScanner_PatternRule4705);
            iv_ruleScanner_PatternRule=ruleScanner_PatternRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner_PatternRule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_PatternRule4715); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2049:1: ruleScanner_PatternRule returns [EObject current=null] : (otherlv_0= 'pattern' ( (lv_startPattern_1_0= RULE_STRING ) ) ( (lv_length_2_0= RULE_INT ) )? otherlv_3= 'containing' ( (lv_contentPattern_4_0= RULE_STRING ) ) ) ;
    public final EObject ruleScanner_PatternRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_startPattern_1_0=null;
        Token lv_length_2_0=null;
        Token otherlv_3=null;
        Token lv_contentPattern_4_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2052:28: ( (otherlv_0= 'pattern' ( (lv_startPattern_1_0= RULE_STRING ) ) ( (lv_length_2_0= RULE_INT ) )? otherlv_3= 'containing' ( (lv_contentPattern_4_0= RULE_STRING ) ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2053:1: (otherlv_0= 'pattern' ( (lv_startPattern_1_0= RULE_STRING ) ) ( (lv_length_2_0= RULE_INT ) )? otherlv_3= 'containing' ( (lv_contentPattern_4_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2053:1: (otherlv_0= 'pattern' ( (lv_startPattern_1_0= RULE_STRING ) ) ( (lv_length_2_0= RULE_INT ) )? otherlv_3= 'containing' ( (lv_contentPattern_4_0= RULE_STRING ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2053:3: otherlv_0= 'pattern' ( (lv_startPattern_1_0= RULE_STRING ) ) ( (lv_length_2_0= RULE_INT ) )? otherlv_3= 'containing' ( (lv_contentPattern_4_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,38,FOLLOW_38_in_ruleScanner_PatternRule4752); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getScanner_PatternRuleAccess().getPatternKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2057:1: ( (lv_startPattern_1_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2058:1: (lv_startPattern_1_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2058:1: (lv_startPattern_1_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2059:3: lv_startPattern_1_0= RULE_STRING
            {
            lv_startPattern_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_PatternRule4769); if (state.failed) return current;
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

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2075:2: ( (lv_length_2_0= RULE_INT ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_INT) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2076:1: (lv_length_2_0= RULE_INT )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2076:1: (lv_length_2_0= RULE_INT )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2077:3: lv_length_2_0= RULE_INT
                    {
                    lv_length_2_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleScanner_PatternRule4791); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,39,FOLLOW_39_in_ruleScanner_PatternRule4809); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getScanner_PatternRuleAccess().getContainingKeyword_3());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2097:1: ( (lv_contentPattern_4_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2098:1: (lv_contentPattern_4_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2098:1: (lv_contentPattern_4_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2099:3: lv_contentPattern_4_0= RULE_STRING
            {
            lv_contentPattern_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_PatternRule4826); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_contentPattern_4_0, grammarAccess.getScanner_PatternRuleAccess().getContentPatternSTRINGTerminalRuleCall_4_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getScanner_PatternRuleRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"contentPattern",
                      		lv_contentPattern_4_0, 
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2123:1: entryRuleScanner_CharacterRule returns [EObject current=null] : iv_ruleScanner_CharacterRule= ruleScanner_CharacterRule EOF ;
    public final EObject entryRuleScanner_CharacterRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner_CharacterRule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2124:2: (iv_ruleScanner_CharacterRule= ruleScanner_CharacterRule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2125:2: iv_ruleScanner_CharacterRule= ruleScanner_CharacterRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScanner_CharacterRuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_CharacterRule_in_entryRuleScanner_CharacterRule4867);
            iv_ruleScanner_CharacterRule=ruleScanner_CharacterRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner_CharacterRule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_CharacterRule4877); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2132:1: ruleScanner_CharacterRule returns [EObject current=null] : (otherlv_0= 'character' otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' ) ;
    public final EObject ruleScanner_CharacterRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_characters_2_0=null;
        Token otherlv_3=null;
        Token lv_characters_4_0=null;
        Token otherlv_5=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2135:28: ( (otherlv_0= 'character' otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2136:1: (otherlv_0= 'character' otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2136:1: (otherlv_0= 'character' otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2136:3: otherlv_0= 'character' otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_40_in_ruleScanner_CharacterRule4914); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getScanner_CharacterRuleAccess().getCharacterKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,34,FOLLOW_34_in_ruleScanner_CharacterRule4926); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getScanner_CharacterRuleAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2144:1: ( (lv_characters_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2145:1: (lv_characters_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2145:1: (lv_characters_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2146:3: lv_characters_2_0= RULE_STRING
            {
            lv_characters_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_CharacterRule4943); if (state.failed) return current;
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

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2162:2: (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==35) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2162:4: otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) )
            	    {
            	    otherlv_3=(Token)match(input,35,FOLLOW_35_in_ruleScanner_CharacterRule4961); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getScanner_CharacterRuleAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2166:1: ( (lv_characters_4_0= RULE_STRING ) )
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2167:1: (lv_characters_4_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2167:1: (lv_characters_4_0= RULE_STRING )
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2168:3: lv_characters_4_0= RULE_STRING
            	    {
            	    lv_characters_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_CharacterRule4978); if (state.failed) return current;
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
            	    break loop37;
                }
            } while (true);

            otherlv_5=(Token)match(input,36,FOLLOW_36_in_ruleScanner_CharacterRule4997); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getScanner_CharacterRuleAccess().getRightSquareBracketKeyword_4());
                  
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2196:1: entryRuleScanner_JSRule returns [EObject current=null] : iv_ruleScanner_JSRule= ruleScanner_JSRule EOF ;
    public final EObject entryRuleScanner_JSRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner_JSRule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2197:2: (iv_ruleScanner_JSRule= ruleScanner_JSRule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2198:2: iv_ruleScanner_JSRule= ruleScanner_JSRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScanner_JSRuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_JSRule_in_entryRuleScanner_JSRule5033);
            iv_ruleScanner_JSRule=ruleScanner_JSRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner_JSRule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_JSRule5043); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2205:1: ruleScanner_JSRule returns [EObject current=null] : (otherlv_0= 'script' ( (lv_fileURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleScanner_JSRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_fileURI_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2208:28: ( (otherlv_0= 'script' ( (lv_fileURI_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2209:1: (otherlv_0= 'script' ( (lv_fileURI_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2209:1: (otherlv_0= 'script' ( (lv_fileURI_1_0= RULE_STRING ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2209:3: otherlv_0= 'script' ( (lv_fileURI_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleScanner_JSRule5080); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getScanner_JSRuleAccess().getScriptKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2213:1: ( (lv_fileURI_1_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2214:1: (lv_fileURI_1_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2214:1: (lv_fileURI_1_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2215:3: lv_fileURI_1_0= RULE_STRING
            {
            lv_fileURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_JSRule5097); if (state.failed) return current;
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


    // $ANTLR start "entryRuleWhitespaceRule"
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2239:1: entryRuleWhitespaceRule returns [EObject current=null] : iv_ruleWhitespaceRule= ruleWhitespaceRule EOF ;
    public final EObject entryRuleWhitespaceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhitespaceRule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2240:2: (iv_ruleWhitespaceRule= ruleWhitespaceRule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2241:2: iv_ruleWhitespaceRule= ruleWhitespaceRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWhitespaceRuleRule()); 
            }
            pushFollow(FOLLOW_ruleWhitespaceRule_in_entryRuleWhitespaceRule5138);
            iv_ruleWhitespaceRule=ruleWhitespaceRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWhitespaceRule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleWhitespaceRule5148); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2248:1: ruleWhitespaceRule returns [EObject current=null] : (otherlv_0= 'whitespace' ( (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' ) | ( (lv_javawhitespace_6_0= 'javawhitespace' ) ) | ( (lv_fileURI_7_0= RULE_STRING ) ) ) ) ;
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
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2251:28: ( (otherlv_0= 'whitespace' ( (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' ) | ( (lv_javawhitespace_6_0= 'javawhitespace' ) ) | ( (lv_fileURI_7_0= RULE_STRING ) ) ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2252:1: (otherlv_0= 'whitespace' ( (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' ) | ( (lv_javawhitespace_6_0= 'javawhitespace' ) ) | ( (lv_fileURI_7_0= RULE_STRING ) ) ) )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2252:1: (otherlv_0= 'whitespace' ( (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' ) | ( (lv_javawhitespace_6_0= 'javawhitespace' ) ) | ( (lv_fileURI_7_0= RULE_STRING ) ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2252:3: otherlv_0= 'whitespace' ( (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' ) | ( (lv_javawhitespace_6_0= 'javawhitespace' ) ) | ( (lv_fileURI_7_0= RULE_STRING ) ) )
            {
            otherlv_0=(Token)match(input,41,FOLLOW_41_in_ruleWhitespaceRule5185); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getWhitespaceRuleAccess().getWhitespaceKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2256:1: ( (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' ) | ( (lv_javawhitespace_6_0= 'javawhitespace' ) ) | ( (lv_fileURI_7_0= RULE_STRING ) ) )
            int alt39=3;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt39=1;
                }
                break;
            case 42:
                {
                alt39=2;
                }
                break;
            case RULE_STRING:
                {
                alt39=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2256:2: (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2256:2: (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2256:4: otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']'
                    {
                    otherlv_1=(Token)match(input,34,FOLLOW_34_in_ruleWhitespaceRule5199); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getWhitespaceRuleAccess().getLeftSquareBracketKeyword_1_0_0());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2260:1: ( (lv_characters_2_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2261:1: (lv_characters_2_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2261:1: (lv_characters_2_0= RULE_STRING )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2262:3: lv_characters_2_0= RULE_STRING
                    {
                    lv_characters_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleWhitespaceRule5216); if (state.failed) return current;
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

                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2278:2: (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )*
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==35) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2278:4: otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) )
                    	    {
                    	    otherlv_3=(Token)match(input,35,FOLLOW_35_in_ruleWhitespaceRule5234); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getWhitespaceRuleAccess().getCommaKeyword_1_0_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2282:1: ( (lv_characters_4_0= RULE_STRING ) )
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2283:1: (lv_characters_4_0= RULE_STRING )
                    	    {
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2283:1: (lv_characters_4_0= RULE_STRING )
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2284:3: lv_characters_4_0= RULE_STRING
                    	    {
                    	    lv_characters_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleWhitespaceRule5251); if (state.failed) return current;
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
                    	    break loop38;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,36,FOLLOW_36_in_ruleWhitespaceRule5270); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getWhitespaceRuleAccess().getRightSquareBracketKeyword_1_0_3());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2305:6: ( (lv_javawhitespace_6_0= 'javawhitespace' ) )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2305:6: ( (lv_javawhitespace_6_0= 'javawhitespace' ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2306:1: (lv_javawhitespace_6_0= 'javawhitespace' )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2306:1: (lv_javawhitespace_6_0= 'javawhitespace' )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2307:3: lv_javawhitespace_6_0= 'javawhitespace'
                    {
                    lv_javawhitespace_6_0=(Token)match(input,42,FOLLOW_42_in_ruleWhitespaceRule5295); if (state.failed) return current;
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2321:6: ( (lv_fileURI_7_0= RULE_STRING ) )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2321:6: ( (lv_fileURI_7_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2322:1: (lv_fileURI_7_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2322:1: (lv_fileURI_7_0= RULE_STRING )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2323:3: lv_fileURI_7_0= RULE_STRING
                    {
                    lv_fileURI_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleWhitespaceRule5331); if (state.failed) return current;
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
    public static final BitSet FOLLOW_ruleParitioning_in_ruleLanguageDef801 = new BitSet(new long[]{0x0000000080000000L});
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
    public static final BitSet FOLLOW_15_in_rulePartitioner_Rule2388 = new BitSet(new long[]{0x0000000044000000L});
    public static final BitSet FOLLOW_rulePartition_Rule_in_rulePartitioner_Rule2409 = new BitSet(new long[]{0x0000000044010000L});
    public static final BitSet FOLLOW_16_in_rulePartitioner_Rule2422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_Rule_in_entryRulePartition_Rule2458 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartition_Rule2468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_SingleLineRule_in_rulePartition_Rule2515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_MultiLineRule_in_rulePartition_Rule2542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_SingleLineRule_in_entryRulePartition_SingleLineRule2577 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartition_SingleLineRule2587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rulePartition_SingleLineRule2624 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePartition_SingleLineRule2644 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartition_SingleLineRule2661 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_rulePartition_SingleLineRule2678 = new BitSet(new long[]{0x0000000010000022L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartition_SingleLineRule2695 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_rulePartition_SingleLineRule2714 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_rulePartition_SingleLineRule2726 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartition_SingleLineRule2743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_MultiLineRule_in_entryRulePartition_MultiLineRule2786 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartition_MultiLineRule2796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rulePartition_MultiLineRule2833 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePartition_MultiLineRule2853 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartition_MultiLineRule2870 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_rulePartition_MultiLineRule2887 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartition_MultiLineRule2904 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_rulePartition_MultiLineRule2922 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_rulePartition_MultiLineRule2934 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartition_MultiLineRule2951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalHighlighting_in_entryRuleLexicalHighlighting2994 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexicalHighlighting3004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleLexicalHighlighting3041 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleLexicalHighlighting3053 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_in_ruleLexicalHighlighting3074 = new BitSet(new long[]{0x0000000003010000L});
    public static final BitSet FOLLOW_16_in_ruleLexicalHighlighting3087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_in_entryRuleLexicalPartitionHighlighting3123 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting3133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_Rule_in_ruleLexicalPartitionHighlighting3180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_JS_in_ruleLexicalPartitionHighlighting3207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_JS_in_entryRuleLexicalPartitionHighlighting_JS3242 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting_JS3252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleLexicalPartitionHighlighting_JS3289 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLexicalPartitionHighlighting_JS3309 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLexicalPartitionHighlighting_JS3326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_Rule_in_entryRuleLexicalPartitionHighlighting_Rule3367 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting_Rule3377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleLexicalPartitionHighlighting_Rule3414 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLexicalPartitionHighlighting_Rule3434 = new BitSet(new long[]{0x0000020000008000L});
    public static final BitSet FOLLOW_ruleWhitespaceRule_in_ruleLexicalPartitionHighlighting_Rule3455 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleLexicalPartitionHighlighting_Rule3468 = new BitSet(new long[]{0x0000000100000010L});
    public static final BitSet FOLLOW_ruleToken_in_ruleLexicalPartitionHighlighting_Rule3489 = new BitSet(new long[]{0x0000000100010010L});
    public static final BitSet FOLLOW_16_in_ruleLexicalPartitionHighlighting_Rule3502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleToken_in_entryRuleToken3538 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleToken3548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleToken3591 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleToken3622 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleToken3640 = new BitSet(new long[]{0x0000014245000000L});
    public static final BitSet FOLLOW_ruleScanner_in_ruleToken3661 = new BitSet(new long[]{0x0000014245010000L});
    public static final BitSet FOLLOW_16_in_ruleToken3674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_in_entryRuleScanner3712 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner3722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_Keyword_in_ruleScanner3769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_Rule_in_ruleScanner3796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_Keyword_in_entryRuleScanner_Keyword3831 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_Keyword3841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleScanner_Keyword3878 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleScanner_Keyword3890 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleScanner_Keyword3911 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_35_in_ruleScanner_Keyword3924 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleScanner_Keyword3945 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_36_in_ruleScanner_Keyword3959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword3995 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyword4005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword4047 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_ruleKeyword4065 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword4082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_Rule_in_entryRuleScanner_Rule4125 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_Rule4135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_SingleLineRule_in_ruleScanner_Rule4182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_MultiLineRule_in_ruleScanner_Rule4209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_CharacterRule_in_ruleScanner_Rule4236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_JSRule_in_ruleScanner_Rule4263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_PatternRule_in_ruleScanner_Rule4290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_SingleLineRule_in_entryRuleScanner_SingleLineRule4325 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_SingleLineRule4335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleScanner_SingleLineRule4372 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_SingleLineRule4389 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_27_in_ruleScanner_SingleLineRule4407 = new BitSet(new long[]{0x0000000010000022L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_SingleLineRule4424 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_ruleScanner_SingleLineRule4445 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleScanner_SingleLineRule4457 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_SingleLineRule4474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_MultiLineRule_in_entryRuleScanner_MultiLineRule4517 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_MultiLineRule4527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleScanner_MultiLineRule4564 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_MultiLineRule4581 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleScanner_MultiLineRule4598 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_MultiLineRule4615 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_ruleScanner_MultiLineRule4633 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleScanner_MultiLineRule4645 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_MultiLineRule4662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_PatternRule_in_entryRuleScanner_PatternRule4705 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_PatternRule4715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleScanner_PatternRule4752 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_PatternRule4769 = new BitSet(new long[]{0x0000008000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleScanner_PatternRule4791 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleScanner_PatternRule4809 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_PatternRule4826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_CharacterRule_in_entryRuleScanner_CharacterRule4867 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_CharacterRule4877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleScanner_CharacterRule4914 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleScanner_CharacterRule4926 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_CharacterRule4943 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_35_in_ruleScanner_CharacterRule4961 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_CharacterRule4978 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_36_in_ruleScanner_CharacterRule4997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_JSRule_in_entryRuleScanner_JSRule5033 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_JSRule5043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleScanner_JSRule5080 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_JSRule5097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhitespaceRule_in_entryRuleWhitespaceRule5138 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWhitespaceRule5148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleWhitespaceRule5185 = new BitSet(new long[]{0x0000040400000020L});
    public static final BitSet FOLLOW_34_in_ruleWhitespaceRule5199 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleWhitespaceRule5216 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_35_in_ruleWhitespaceRule5234 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleWhitespaceRule5251 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_36_in_ruleWhitespaceRule5270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleWhitespaceRule5295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleWhitespaceRule5331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_synpred1_InternalLDef395 = new BitSet(new long[]{0x0000000000000002L});

}