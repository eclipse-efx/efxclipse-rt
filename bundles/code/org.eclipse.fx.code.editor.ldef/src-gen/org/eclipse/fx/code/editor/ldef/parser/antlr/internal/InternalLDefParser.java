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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'.'", "'*'", "'import'", "'{'", "'}'", "'integration'", "'javafx'", "'java'", "'e4'", "'partitioning'", "'partition'", "'script'", "'rule'", "'single_line'", "'=>'", "'escaped'", "'by'", "'multi_line'", "'lexical_highlighting'", "'default'", "'keywords'", "'['", "','", "']'", "'since'", "'character'", "'whitespace'", "'javawhitespace'"
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:594:1: ruleJavaCodeGeneration returns [EObject current=null] : (otherlv_0= 'java' ( (lv_name_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleJavaCodeGeneration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:597:28: ( (otherlv_0= 'java' ( (lv_name_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:598:1: (otherlv_0= 'java' ( (lv_name_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:598:1: (otherlv_0= 'java' ( (lv_name_1_0= RULE_STRING ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:598:3: otherlv_0= 'java' ( (lv_name_1_0= RULE_STRING ) )
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:628:1: entryRuleE4CodeGeneration returns [EObject current=null] : iv_ruleE4CodeGeneration= ruleE4CodeGeneration EOF ;
    public final EObject entryRuleE4CodeGeneration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleE4CodeGeneration = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:629:2: (iv_ruleE4CodeGeneration= ruleE4CodeGeneration EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:630:2: iv_ruleE4CodeGeneration= ruleE4CodeGeneration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getE4CodeGenerationRule()); 
            }
            pushFollow(FOLLOW_ruleE4CodeGeneration_in_entryRuleE4CodeGeneration1464);
            iv_ruleE4CodeGeneration=ruleE4CodeGeneration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleE4CodeGeneration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleE4CodeGeneration1474); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:637:1: ruleE4CodeGeneration returns [EObject current=null] : (otherlv_0= 'e4' ( (lv_iconPath_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleE4CodeGeneration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_iconPath_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:640:28: ( (otherlv_0= 'e4' ( (lv_iconPath_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:641:1: (otherlv_0= 'e4' ( (lv_iconPath_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:641:1: (otherlv_0= 'e4' ( (lv_iconPath_1_0= RULE_STRING ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:641:3: otherlv_0= 'e4' ( (lv_iconPath_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleE4CodeGeneration1511); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getE4CodeGenerationAccess().getE4Keyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:645:1: ( (lv_iconPath_1_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:646:1: (lv_iconPath_1_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:646:1: (lv_iconPath_1_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:647:3: lv_iconPath_1_0= RULE_STRING
            {
            lv_iconPath_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleE4CodeGeneration1528); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_iconPath_1_0, grammarAccess.getE4CodeGenerationAccess().getIconPathSTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getE4CodeGenerationRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"iconPath",
                      		lv_iconPath_1_0, 
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
    // $ANTLR end "ruleE4CodeGeneration"


    // $ANTLR start "entryRuleParitioning"
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:671:1: entryRuleParitioning returns [EObject current=null] : iv_ruleParitioning= ruleParitioning EOF ;
    public final EObject entryRuleParitioning() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParitioning = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:672:2: (iv_ruleParitioning= ruleParitioning EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:673:2: iv_ruleParitioning= ruleParitioning EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParitioningRule()); 
            }
            pushFollow(FOLLOW_ruleParitioning_in_entryRuleParitioning1569);
            iv_ruleParitioning=ruleParitioning();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParitioning; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParitioning1579); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:680:1: ruleParitioning returns [EObject current=null] : (otherlv_0= 'partitioning' otherlv_1= '{' ( (lv_partitions_2_0= rulePartition ) )+ ( (lv_partitioner_3_0= rulePartitioner ) ) otherlv_4= '}' ) ;
    public final EObject ruleParitioning() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_partitions_2_0 = null;

        EObject lv_partitioner_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:683:28: ( (otherlv_0= 'partitioning' otherlv_1= '{' ( (lv_partitions_2_0= rulePartition ) )+ ( (lv_partitioner_3_0= rulePartitioner ) ) otherlv_4= '}' ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:684:1: (otherlv_0= 'partitioning' otherlv_1= '{' ( (lv_partitions_2_0= rulePartition ) )+ ( (lv_partitioner_3_0= rulePartitioner ) ) otherlv_4= '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:684:1: (otherlv_0= 'partitioning' otherlv_1= '{' ( (lv_partitions_2_0= rulePartition ) )+ ( (lv_partitioner_3_0= rulePartitioner ) ) otherlv_4= '}' )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:684:3: otherlv_0= 'partitioning' otherlv_1= '{' ( (lv_partitions_2_0= rulePartition ) )+ ( (lv_partitioner_3_0= rulePartitioner ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleParitioning1616); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getParitioningAccess().getPartitioningKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleParitioning1628); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getParitioningAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:692:1: ( (lv_partitions_2_0= rulePartition ) )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==22) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:693:1: (lv_partitions_2_0= rulePartition )
            	    {
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:693:1: (lv_partitions_2_0= rulePartition )
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:694:3: lv_partitions_2_0= rulePartition
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getParitioningAccess().getPartitionsPartitionParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulePartition_in_ruleParitioning1649);
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
            	    if ( cnt8 >= 1 ) break loop8;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:710:3: ( (lv_partitioner_3_0= rulePartitioner ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:711:1: (lv_partitioner_3_0= rulePartitioner )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:711:1: (lv_partitioner_3_0= rulePartitioner )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:712:3: lv_partitioner_3_0= rulePartitioner
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParitioningAccess().getPartitionerPartitionerParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePartitioner_in_ruleParitioning1671);
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

            otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleParitioning1683); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:740:1: entryRulePartition returns [EObject current=null] : iv_rulePartition= rulePartition EOF ;
    public final EObject entryRulePartition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartition = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:741:2: (iv_rulePartition= rulePartition EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:742:2: iv_rulePartition= rulePartition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPartitionRule()); 
            }
            pushFollow(FOLLOW_rulePartition_in_entryRulePartition1719);
            iv_rulePartition=rulePartition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePartition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePartition1729); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:749:1: rulePartition returns [EObject current=null] : (otherlv_0= 'partition' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject rulePartition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:752:28: ( (otherlv_0= 'partition' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:753:1: (otherlv_0= 'partition' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:753:1: (otherlv_0= 'partition' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:753:3: otherlv_0= 'partition' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,22,FOLLOW_22_in_rulePartition1766); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getPartitionAccess().getPartitionKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:757:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:758:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:758:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:759:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePartition1783); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:783:1: entryRulePartitioner returns [EObject current=null] : iv_rulePartitioner= rulePartitioner EOF ;
    public final EObject entryRulePartitioner() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartitioner = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:784:2: (iv_rulePartitioner= rulePartitioner EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:785:2: iv_rulePartitioner= rulePartitioner EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPartitionerRule()); 
            }
            pushFollow(FOLLOW_rulePartitioner_in_entryRulePartitioner1824);
            iv_rulePartitioner=rulePartitioner();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePartitioner; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePartitioner1834); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:792:1: rulePartitioner returns [EObject current=null] : (this_Partitioner_Rule_0= rulePartitioner_Rule | this_Paritioner_JS_1= ruleParitioner_JS ) ;
    public final EObject rulePartitioner() throws RecognitionException {
        EObject current = null;

        EObject this_Partitioner_Rule_0 = null;

        EObject this_Paritioner_JS_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:795:28: ( (this_Partitioner_Rule_0= rulePartitioner_Rule | this_Paritioner_JS_1= ruleParitioner_JS ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:796:1: (this_Partitioner_Rule_0= rulePartitioner_Rule | this_Paritioner_JS_1= ruleParitioner_JS )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:796:1: (this_Partitioner_Rule_0= rulePartitioner_Rule | this_Paritioner_JS_1= ruleParitioner_JS )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==24) ) {
                alt9=1;
            }
            else if ( (LA9_0==23) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:797:5: this_Partitioner_Rule_0= rulePartitioner_Rule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPartitionerAccess().getPartitioner_RuleParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_rulePartitioner_Rule_in_rulePartitioner1881);
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:807:5: this_Paritioner_JS_1= ruleParitioner_JS
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPartitionerAccess().getParitioner_JSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleParitioner_JS_in_rulePartitioner1908);
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:823:1: entryRuleParitioner_JS returns [EObject current=null] : iv_ruleParitioner_JS= ruleParitioner_JS EOF ;
    public final EObject entryRuleParitioner_JS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParitioner_JS = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:824:2: (iv_ruleParitioner_JS= ruleParitioner_JS EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:825:2: iv_ruleParitioner_JS= ruleParitioner_JS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParitioner_JSRule()); 
            }
            pushFollow(FOLLOW_ruleParitioner_JS_in_entryRuleParitioner_JS1943);
            iv_ruleParitioner_JS=ruleParitioner_JS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParitioner_JS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParitioner_JS1953); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:832:1: ruleParitioner_JS returns [EObject current=null] : (otherlv_0= 'script' ( (lv_scriptURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleParitioner_JS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_scriptURI_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:835:28: ( (otherlv_0= 'script' ( (lv_scriptURI_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:836:1: (otherlv_0= 'script' ( (lv_scriptURI_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:836:1: (otherlv_0= 'script' ( (lv_scriptURI_1_0= RULE_STRING ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:836:3: otherlv_0= 'script' ( (lv_scriptURI_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,23,FOLLOW_23_in_ruleParitioner_JS1990); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getParitioner_JSAccess().getScriptKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:840:1: ( (lv_scriptURI_1_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:841:1: (lv_scriptURI_1_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:841:1: (lv_scriptURI_1_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:842:3: lv_scriptURI_1_0= RULE_STRING
            {
            lv_scriptURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleParitioner_JS2007); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:866:1: entryRulePartitioner_Rule returns [EObject current=null] : iv_rulePartitioner_Rule= rulePartitioner_Rule EOF ;
    public final EObject entryRulePartitioner_Rule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartitioner_Rule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:867:2: (iv_rulePartitioner_Rule= rulePartitioner_Rule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:868:2: iv_rulePartitioner_Rule= rulePartitioner_Rule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPartitioner_RuleRule()); 
            }
            pushFollow(FOLLOW_rulePartitioner_Rule_in_entryRulePartitioner_Rule2048);
            iv_rulePartitioner_Rule=rulePartitioner_Rule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePartitioner_Rule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePartitioner_Rule2058); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:875:1: rulePartitioner_Rule returns [EObject current=null] : (otherlv_0= 'rule' otherlv_1= '{' ( (lv_ruleList_2_0= rulePartition_Rule ) )+ otherlv_3= '}' ) ;
    public final EObject rulePartitioner_Rule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ruleList_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:878:28: ( (otherlv_0= 'rule' otherlv_1= '{' ( (lv_ruleList_2_0= rulePartition_Rule ) )+ otherlv_3= '}' ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:879:1: (otherlv_0= 'rule' otherlv_1= '{' ( (lv_ruleList_2_0= rulePartition_Rule ) )+ otherlv_3= '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:879:1: (otherlv_0= 'rule' otherlv_1= '{' ( (lv_ruleList_2_0= rulePartition_Rule ) )+ otherlv_3= '}' )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:879:3: otherlv_0= 'rule' otherlv_1= '{' ( (lv_ruleList_2_0= rulePartition_Rule ) )+ otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_rulePartitioner_Rule2095); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getPartitioner_RuleAccess().getRuleKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,15,FOLLOW_15_in_rulePartitioner_Rule2107); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getPartitioner_RuleAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:887:1: ( (lv_ruleList_2_0= rulePartition_Rule ) )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==25||LA10_0==29) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:888:1: (lv_ruleList_2_0= rulePartition_Rule )
            	    {
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:888:1: (lv_ruleList_2_0= rulePartition_Rule )
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:889:3: lv_ruleList_2_0= rulePartition_Rule
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPartitioner_RuleAccess().getRuleListPartition_RuleParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulePartition_Rule_in_rulePartitioner_Rule2128);
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
            	    if ( cnt10 >= 1 ) break loop10;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);

            otherlv_3=(Token)match(input,16,FOLLOW_16_in_rulePartitioner_Rule2141); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:917:1: entryRulePartition_Rule returns [EObject current=null] : iv_rulePartition_Rule= rulePartition_Rule EOF ;
    public final EObject entryRulePartition_Rule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartition_Rule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:918:2: (iv_rulePartition_Rule= rulePartition_Rule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:919:2: iv_rulePartition_Rule= rulePartition_Rule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPartition_RuleRule()); 
            }
            pushFollow(FOLLOW_rulePartition_Rule_in_entryRulePartition_Rule2177);
            iv_rulePartition_Rule=rulePartition_Rule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePartition_Rule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePartition_Rule2187); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:926:1: rulePartition_Rule returns [EObject current=null] : (this_Partition_SingleLineRule_0= rulePartition_SingleLineRule | this_Partition_MultiLineRule_1= rulePartition_MultiLineRule ) ;
    public final EObject rulePartition_Rule() throws RecognitionException {
        EObject current = null;

        EObject this_Partition_SingleLineRule_0 = null;

        EObject this_Partition_MultiLineRule_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:929:28: ( (this_Partition_SingleLineRule_0= rulePartition_SingleLineRule | this_Partition_MultiLineRule_1= rulePartition_MultiLineRule ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:930:1: (this_Partition_SingleLineRule_0= rulePartition_SingleLineRule | this_Partition_MultiLineRule_1= rulePartition_MultiLineRule )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:930:1: (this_Partition_SingleLineRule_0= rulePartition_SingleLineRule | this_Partition_MultiLineRule_1= rulePartition_MultiLineRule )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==25) ) {
                alt11=1;
            }
            else if ( (LA11_0==29) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:931:5: this_Partition_SingleLineRule_0= rulePartition_SingleLineRule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPartition_RuleAccess().getPartition_SingleLineRuleParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_rulePartition_SingleLineRule_in_rulePartition_Rule2234);
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:941:5: this_Partition_MultiLineRule_1= rulePartition_MultiLineRule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPartition_RuleAccess().getPartition_MultiLineRuleParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_rulePartition_MultiLineRule_in_rulePartition_Rule2261);
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:957:1: entryRulePartition_SingleLineRule returns [EObject current=null] : iv_rulePartition_SingleLineRule= rulePartition_SingleLineRule EOF ;
    public final EObject entryRulePartition_SingleLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartition_SingleLineRule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:958:2: (iv_rulePartition_SingleLineRule= rulePartition_SingleLineRule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:959:2: iv_rulePartition_SingleLineRule= rulePartition_SingleLineRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPartition_SingleLineRuleRule()); 
            }
            pushFollow(FOLLOW_rulePartition_SingleLineRule_in_entryRulePartition_SingleLineRule2296);
            iv_rulePartition_SingleLineRule=rulePartition_SingleLineRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePartition_SingleLineRule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePartition_SingleLineRule2306); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:966:1: rulePartition_SingleLineRule returns [EObject current=null] : (otherlv_0= 'single_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) )? (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) ;
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
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:969:28: ( (otherlv_0= 'single_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) )? (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:970:1: (otherlv_0= 'single_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) )? (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:970:1: (otherlv_0= 'single_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) )? (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:970:3: otherlv_0= 'single_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) )? (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_rulePartition_SingleLineRule2343); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getPartition_SingleLineRuleAccess().getSingle_lineKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:974:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:975:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:975:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:976:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getPartition_SingleLineRuleRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePartition_SingleLineRule2363); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getPartition_SingleLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
              	
            }

            }


            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:987:2: ( (lv_startSeq_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:988:1: (lv_startSeq_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:988:1: (lv_startSeq_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:989:3: lv_startSeq_2_0= RULE_STRING
            {
            lv_startSeq_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartition_SingleLineRule2380); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,26,FOLLOW_26_in_rulePartition_SingleLineRule2397); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getPartition_SingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1009:1: ( (lv_endSeq_4_0= RULE_STRING ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_STRING) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1010:1: (lv_endSeq_4_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1010:1: (lv_endSeq_4_0= RULE_STRING )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1011:3: lv_endSeq_4_0= RULE_STRING
                    {
                    lv_endSeq_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartition_SingleLineRule2414); if (state.failed) return current;
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

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1027:3: (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==27) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1027:5: otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,27,FOLLOW_27_in_rulePartition_SingleLineRule2433); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getPartition_SingleLineRuleAccess().getEscapedKeyword_5_0());
                          
                    }
                    otherlv_6=(Token)match(input,28,FOLLOW_28_in_rulePartition_SingleLineRule2445); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getPartition_SingleLineRuleAccess().getByKeyword_5_1());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1035:1: ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1036:1: (lv_escapeSeq_7_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1036:1: (lv_escapeSeq_7_0= RULE_STRING )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1037:3: lv_escapeSeq_7_0= RULE_STRING
                    {
                    lv_escapeSeq_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartition_SingleLineRule2462); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1061:1: entryRulePartition_MultiLineRule returns [EObject current=null] : iv_rulePartition_MultiLineRule= rulePartition_MultiLineRule EOF ;
    public final EObject entryRulePartition_MultiLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartition_MultiLineRule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1062:2: (iv_rulePartition_MultiLineRule= rulePartition_MultiLineRule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1063:2: iv_rulePartition_MultiLineRule= rulePartition_MultiLineRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPartition_MultiLineRuleRule()); 
            }
            pushFollow(FOLLOW_rulePartition_MultiLineRule_in_entryRulePartition_MultiLineRule2505);
            iv_rulePartition_MultiLineRule=rulePartition_MultiLineRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePartition_MultiLineRule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePartition_MultiLineRule2515); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1070:1: rulePartition_MultiLineRule returns [EObject current=null] : (otherlv_0= 'multi_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) ;
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
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1073:28: ( (otherlv_0= 'multi_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1074:1: (otherlv_0= 'multi_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1074:1: (otherlv_0= 'multi_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1074:3: otherlv_0= 'multi_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,29,FOLLOW_29_in_rulePartition_MultiLineRule2552); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getPartition_MultiLineRuleAccess().getMulti_lineKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1078:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1079:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1079:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1080:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getPartition_MultiLineRuleRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePartition_MultiLineRule2572); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getPartition_MultiLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
              	
            }

            }


            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1091:2: ( (lv_startSeq_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1092:1: (lv_startSeq_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1092:1: (lv_startSeq_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1093:3: lv_startSeq_2_0= RULE_STRING
            {
            lv_startSeq_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartition_MultiLineRule2589); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,26,FOLLOW_26_in_rulePartition_MultiLineRule2606); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getPartition_MultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1113:1: ( (lv_endSeq_4_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1114:1: (lv_endSeq_4_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1114:1: (lv_endSeq_4_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1115:3: lv_endSeq_4_0= RULE_STRING
            {
            lv_endSeq_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartition_MultiLineRule2623); if (state.failed) return current;
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

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1131:2: (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==27) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1131:4: otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,27,FOLLOW_27_in_rulePartition_MultiLineRule2641); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getPartition_MultiLineRuleAccess().getEscapedKeyword_5_0());
                          
                    }
                    otherlv_6=(Token)match(input,28,FOLLOW_28_in_rulePartition_MultiLineRule2653); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getPartition_MultiLineRuleAccess().getByKeyword_5_1());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1139:1: ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1140:1: (lv_escapeSeq_7_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1140:1: (lv_escapeSeq_7_0= RULE_STRING )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1141:3: lv_escapeSeq_7_0= RULE_STRING
                    {
                    lv_escapeSeq_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartition_MultiLineRule2670); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1165:1: entryRuleLexicalHighlighting returns [EObject current=null] : iv_ruleLexicalHighlighting= ruleLexicalHighlighting EOF ;
    public final EObject entryRuleLexicalHighlighting() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLexicalHighlighting = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1166:2: (iv_ruleLexicalHighlighting= ruleLexicalHighlighting EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1167:2: iv_ruleLexicalHighlighting= ruleLexicalHighlighting EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLexicalHighlightingRule()); 
            }
            pushFollow(FOLLOW_ruleLexicalHighlighting_in_entryRuleLexicalHighlighting2713);
            iv_ruleLexicalHighlighting=ruleLexicalHighlighting();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLexicalHighlighting; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexicalHighlighting2723); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1174:1: ruleLexicalHighlighting returns [EObject current=null] : (otherlv_0= 'lexical_highlighting' otherlv_1= '{' ( (lv_list_2_0= ruleLexicalPartitionHighlighting ) )+ otherlv_3= '}' ) ;
    public final EObject ruleLexicalHighlighting() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_list_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1177:28: ( (otherlv_0= 'lexical_highlighting' otherlv_1= '{' ( (lv_list_2_0= ruleLexicalPartitionHighlighting ) )+ otherlv_3= '}' ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1178:1: (otherlv_0= 'lexical_highlighting' otherlv_1= '{' ( (lv_list_2_0= ruleLexicalPartitionHighlighting ) )+ otherlv_3= '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1178:1: (otherlv_0= 'lexical_highlighting' otherlv_1= '{' ( (lv_list_2_0= ruleLexicalPartitionHighlighting ) )+ otherlv_3= '}' )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1178:3: otherlv_0= 'lexical_highlighting' otherlv_1= '{' ( (lv_list_2_0= ruleLexicalPartitionHighlighting ) )+ otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleLexicalHighlighting2760); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLexicalHighlightingAccess().getLexical_highlightingKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleLexicalHighlighting2772); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLexicalHighlightingAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1186:1: ( (lv_list_2_0= ruleLexicalPartitionHighlighting ) )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=23 && LA15_0<=24)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1187:1: (lv_list_2_0= ruleLexicalPartitionHighlighting )
            	    {
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1187:1: (lv_list_2_0= ruleLexicalPartitionHighlighting )
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1188:3: lv_list_2_0= ruleLexicalPartitionHighlighting
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLexicalHighlightingAccess().getListLexicalPartitionHighlightingParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_in_ruleLexicalHighlighting2793);
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
            	    if ( cnt15 >= 1 ) break loop15;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);

            otherlv_3=(Token)match(input,16,FOLLOW_16_in_ruleLexicalHighlighting2806); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1216:1: entryRuleLexicalPartitionHighlighting returns [EObject current=null] : iv_ruleLexicalPartitionHighlighting= ruleLexicalPartitionHighlighting EOF ;
    public final EObject entryRuleLexicalPartitionHighlighting() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLexicalPartitionHighlighting = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1217:2: (iv_ruleLexicalPartitionHighlighting= ruleLexicalPartitionHighlighting EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1218:2: iv_ruleLexicalPartitionHighlighting= ruleLexicalPartitionHighlighting EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLexicalPartitionHighlightingRule()); 
            }
            pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_in_entryRuleLexicalPartitionHighlighting2842);
            iv_ruleLexicalPartitionHighlighting=ruleLexicalPartitionHighlighting();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLexicalPartitionHighlighting; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting2852); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1225:1: ruleLexicalPartitionHighlighting returns [EObject current=null] : (this_LexicalPartitionHighlighting_Rule_0= ruleLexicalPartitionHighlighting_Rule | this_LexicalPartitionHighlighting_JS_1= ruleLexicalPartitionHighlighting_JS ) ;
    public final EObject ruleLexicalPartitionHighlighting() throws RecognitionException {
        EObject current = null;

        EObject this_LexicalPartitionHighlighting_Rule_0 = null;

        EObject this_LexicalPartitionHighlighting_JS_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1228:28: ( (this_LexicalPartitionHighlighting_Rule_0= ruleLexicalPartitionHighlighting_Rule | this_LexicalPartitionHighlighting_JS_1= ruleLexicalPartitionHighlighting_JS ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1229:1: (this_LexicalPartitionHighlighting_Rule_0= ruleLexicalPartitionHighlighting_Rule | this_LexicalPartitionHighlighting_JS_1= ruleLexicalPartitionHighlighting_JS )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1229:1: (this_LexicalPartitionHighlighting_Rule_0= ruleLexicalPartitionHighlighting_Rule | this_LexicalPartitionHighlighting_JS_1= ruleLexicalPartitionHighlighting_JS )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==24) ) {
                alt16=1;
            }
            else if ( (LA16_0==23) ) {
                alt16=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1230:5: this_LexicalPartitionHighlighting_Rule_0= ruleLexicalPartitionHighlighting_Rule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLexicalPartitionHighlightingAccess().getLexicalPartitionHighlighting_RuleParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_Rule_in_ruleLexicalPartitionHighlighting2899);
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1240:5: this_LexicalPartitionHighlighting_JS_1= ruleLexicalPartitionHighlighting_JS
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLexicalPartitionHighlightingAccess().getLexicalPartitionHighlighting_JSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_JS_in_ruleLexicalPartitionHighlighting2926);
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1256:1: entryRuleLexicalPartitionHighlighting_JS returns [EObject current=null] : iv_ruleLexicalPartitionHighlighting_JS= ruleLexicalPartitionHighlighting_JS EOF ;
    public final EObject entryRuleLexicalPartitionHighlighting_JS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLexicalPartitionHighlighting_JS = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1257:2: (iv_ruleLexicalPartitionHighlighting_JS= ruleLexicalPartitionHighlighting_JS EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1258:2: iv_ruleLexicalPartitionHighlighting_JS= ruleLexicalPartitionHighlighting_JS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLexicalPartitionHighlighting_JSRule()); 
            }
            pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_JS_in_entryRuleLexicalPartitionHighlighting_JS2961);
            iv_ruleLexicalPartitionHighlighting_JS=ruleLexicalPartitionHighlighting_JS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLexicalPartitionHighlighting_JS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting_JS2971); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1265:1: ruleLexicalPartitionHighlighting_JS returns [EObject current=null] : (otherlv_0= 'script' ( (otherlv_1= RULE_ID ) ) ( (lv_scriptURI_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleLexicalPartitionHighlighting_JS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_scriptURI_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1268:28: ( (otherlv_0= 'script' ( (otherlv_1= RULE_ID ) ) ( (lv_scriptURI_2_0= RULE_STRING ) ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1269:1: (otherlv_0= 'script' ( (otherlv_1= RULE_ID ) ) ( (lv_scriptURI_2_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1269:1: (otherlv_0= 'script' ( (otherlv_1= RULE_ID ) ) ( (lv_scriptURI_2_0= RULE_STRING ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1269:3: otherlv_0= 'script' ( (otherlv_1= RULE_ID ) ) ( (lv_scriptURI_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,23,FOLLOW_23_in_ruleLexicalPartitionHighlighting_JS3008); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLexicalPartitionHighlighting_JSAccess().getScriptKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1273:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1274:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1274:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1275:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getLexicalPartitionHighlighting_JSRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLexicalPartitionHighlighting_JS3028); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getLexicalPartitionHighlighting_JSAccess().getPartitionPartitionCrossReference_1_0()); 
              	
            }

            }


            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1286:2: ( (lv_scriptURI_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1287:1: (lv_scriptURI_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1287:1: (lv_scriptURI_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1288:3: lv_scriptURI_2_0= RULE_STRING
            {
            lv_scriptURI_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLexicalPartitionHighlighting_JS3045); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1312:1: entryRuleLexicalPartitionHighlighting_Rule returns [EObject current=null] : iv_ruleLexicalPartitionHighlighting_Rule= ruleLexicalPartitionHighlighting_Rule EOF ;
    public final EObject entryRuleLexicalPartitionHighlighting_Rule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLexicalPartitionHighlighting_Rule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1313:2: (iv_ruleLexicalPartitionHighlighting_Rule= ruleLexicalPartitionHighlighting_Rule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1314:2: iv_ruleLexicalPartitionHighlighting_Rule= ruleLexicalPartitionHighlighting_Rule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLexicalPartitionHighlighting_RuleRule()); 
            }
            pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_Rule_in_entryRuleLexicalPartitionHighlighting_Rule3086);
            iv_ruleLexicalPartitionHighlighting_Rule=ruleLexicalPartitionHighlighting_Rule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLexicalPartitionHighlighting_Rule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting_Rule3096); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1321:1: ruleLexicalPartitionHighlighting_Rule returns [EObject current=null] : (otherlv_0= 'rule' ( (otherlv_1= RULE_ID ) ) ( (lv_whitespace_2_0= ruleWhitespaceRule ) )? otherlv_3= '{' ( (lv_tokenList_4_0= ruleToken ) )+ otherlv_5= '}' ) ;
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
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1324:28: ( (otherlv_0= 'rule' ( (otherlv_1= RULE_ID ) ) ( (lv_whitespace_2_0= ruleWhitespaceRule ) )? otherlv_3= '{' ( (lv_tokenList_4_0= ruleToken ) )+ otherlv_5= '}' ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1325:1: (otherlv_0= 'rule' ( (otherlv_1= RULE_ID ) ) ( (lv_whitespace_2_0= ruleWhitespaceRule ) )? otherlv_3= '{' ( (lv_tokenList_4_0= ruleToken ) )+ otherlv_5= '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1325:1: (otherlv_0= 'rule' ( (otherlv_1= RULE_ID ) ) ( (lv_whitespace_2_0= ruleWhitespaceRule ) )? otherlv_3= '{' ( (lv_tokenList_4_0= ruleToken ) )+ otherlv_5= '}' )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1325:3: otherlv_0= 'rule' ( (otherlv_1= RULE_ID ) ) ( (lv_whitespace_2_0= ruleWhitespaceRule ) )? otherlv_3= '{' ( (lv_tokenList_4_0= ruleToken ) )+ otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleLexicalPartitionHighlighting_Rule3133); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getRuleKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1329:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1330:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1330:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1331:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getLexicalPartitionHighlighting_RuleRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLexicalPartitionHighlighting_Rule3153); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getPartitionPartitionCrossReference_1_0()); 
              	
            }

            }


            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1342:2: ( (lv_whitespace_2_0= ruleWhitespaceRule ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==38) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1343:1: (lv_whitespace_2_0= ruleWhitespaceRule )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1343:1: (lv_whitespace_2_0= ruleWhitespaceRule )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1344:3: lv_whitespace_2_0= ruleWhitespaceRule
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getWhitespaceWhitespaceRuleParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleWhitespaceRule_in_ruleLexicalPartitionHighlighting_Rule3174);
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

            otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleLexicalPartitionHighlighting_Rule3187); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1364:1: ( (lv_tokenList_4_0= ruleToken ) )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_ID||LA18_0==31) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1365:1: (lv_tokenList_4_0= ruleToken )
            	    {
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1365:1: (lv_tokenList_4_0= ruleToken )
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1366:3: lv_tokenList_4_0= ruleToken
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getTokenListTokenParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleToken_in_ruleLexicalPartitionHighlighting_Rule3208);
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
            	    if ( cnt18 >= 1 ) break loop18;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);

            otherlv_5=(Token)match(input,16,FOLLOW_16_in_ruleLexicalPartitionHighlighting_Rule3221); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1394:1: entryRuleToken returns [EObject current=null] : iv_ruleToken= ruleToken EOF ;
    public final EObject entryRuleToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleToken = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1395:2: (iv_ruleToken= ruleToken EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1396:2: iv_ruleToken= ruleToken EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTokenRule()); 
            }
            pushFollow(FOLLOW_ruleToken_in_entryRuleToken3257);
            iv_ruleToken=ruleToken();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleToken; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleToken3267); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1403:1: ruleToken returns [EObject current=null] : ( ( (lv_default_0_0= 'default' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_scannerList_3_0= ruleScanner ) )+ otherlv_4= '}' )? ) ;
    public final EObject ruleToken() throws RecognitionException {
        EObject current = null;

        Token lv_default_0_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_scannerList_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1406:28: ( ( ( (lv_default_0_0= 'default' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_scannerList_3_0= ruleScanner ) )+ otherlv_4= '}' )? ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1407:1: ( ( (lv_default_0_0= 'default' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_scannerList_3_0= ruleScanner ) )+ otherlv_4= '}' )? )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1407:1: ( ( (lv_default_0_0= 'default' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_scannerList_3_0= ruleScanner ) )+ otherlv_4= '}' )? )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1407:2: ( (lv_default_0_0= 'default' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_scannerList_3_0= ruleScanner ) )+ otherlv_4= '}' )?
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1407:2: ( (lv_default_0_0= 'default' ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==31) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1408:1: (lv_default_0_0= 'default' )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1408:1: (lv_default_0_0= 'default' )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1409:3: lv_default_0_0= 'default'
                    {
                    lv_default_0_0=(Token)match(input,31,FOLLOW_31_in_ruleToken3310); if (state.failed) return current;
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

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1422:3: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1423:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1423:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1424:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleToken3341); if (state.failed) return current;
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

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1440:2: (otherlv_2= '{' ( (lv_scannerList_3_0= ruleScanner ) )+ otherlv_4= '}' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==15) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1440:4: otherlv_2= '{' ( (lv_scannerList_3_0= ruleScanner ) )+ otherlv_4= '}'
                    {
                    otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleToken3359); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getTokenAccess().getLeftCurlyBracketKeyword_2_0());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1444:1: ( (lv_scannerList_3_0= ruleScanner ) )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==23||LA20_0==25||LA20_0==29||LA20_0==32||LA20_0==37) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1445:1: (lv_scannerList_3_0= ruleScanner )
                    	    {
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1445:1: (lv_scannerList_3_0= ruleScanner )
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1446:3: lv_scannerList_3_0= ruleScanner
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getTokenAccess().getScannerListScannerParserRuleCall_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleScanner_in_ruleToken3380);
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
                    	    if ( cnt20 >= 1 ) break loop20;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(20, input);
                                throw eee;
                        }
                        cnt20++;
                    } while (true);

                    otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleToken3393); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1474:1: entryRuleScanner returns [EObject current=null] : iv_ruleScanner= ruleScanner EOF ;
    public final EObject entryRuleScanner() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1475:2: (iv_ruleScanner= ruleScanner EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1476:2: iv_ruleScanner= ruleScanner EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScannerRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_in_entryRuleScanner3431);
            iv_ruleScanner=ruleScanner();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner3441); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1483:1: ruleScanner returns [EObject current=null] : (this_Scanner_Keyword_0= ruleScanner_Keyword | this_Scanner_Rule_1= ruleScanner_Rule ) ;
    public final EObject ruleScanner() throws RecognitionException {
        EObject current = null;

        EObject this_Scanner_Keyword_0 = null;

        EObject this_Scanner_Rule_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1486:28: ( (this_Scanner_Keyword_0= ruleScanner_Keyword | this_Scanner_Rule_1= ruleScanner_Rule ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1487:1: (this_Scanner_Keyword_0= ruleScanner_Keyword | this_Scanner_Rule_1= ruleScanner_Rule )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1487:1: (this_Scanner_Keyword_0= ruleScanner_Keyword | this_Scanner_Rule_1= ruleScanner_Rule )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==32) ) {
                alt22=1;
            }
            else if ( (LA22_0==23||LA22_0==25||LA22_0==29||LA22_0==37) ) {
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1488:5: this_Scanner_Keyword_0= ruleScanner_Keyword
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getScannerAccess().getScanner_KeywordParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleScanner_Keyword_in_ruleScanner3488);
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1498:5: this_Scanner_Rule_1= ruleScanner_Rule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getScannerAccess().getScanner_RuleParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleScanner_Rule_in_ruleScanner3515);
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1514:1: entryRuleScanner_Keyword returns [EObject current=null] : iv_ruleScanner_Keyword= ruleScanner_Keyword EOF ;
    public final EObject entryRuleScanner_Keyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner_Keyword = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1515:2: (iv_ruleScanner_Keyword= ruleScanner_Keyword EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1516:2: iv_ruleScanner_Keyword= ruleScanner_Keyword EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScanner_KeywordRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_Keyword_in_entryRuleScanner_Keyword3550);
            iv_ruleScanner_Keyword=ruleScanner_Keyword();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner_Keyword; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_Keyword3560); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1523:1: ruleScanner_Keyword returns [EObject current=null] : (otherlv_0= 'keywords' otherlv_1= '[' ( (lv_keywords_2_0= ruleKeyword ) ) (otherlv_3= ',' ( (lv_keywords_4_0= ruleKeyword ) ) )* otherlv_5= ']' ) ;
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
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1526:28: ( (otherlv_0= 'keywords' otherlv_1= '[' ( (lv_keywords_2_0= ruleKeyword ) ) (otherlv_3= ',' ( (lv_keywords_4_0= ruleKeyword ) ) )* otherlv_5= ']' ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1527:1: (otherlv_0= 'keywords' otherlv_1= '[' ( (lv_keywords_2_0= ruleKeyword ) ) (otherlv_3= ',' ( (lv_keywords_4_0= ruleKeyword ) ) )* otherlv_5= ']' )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1527:1: (otherlv_0= 'keywords' otherlv_1= '[' ( (lv_keywords_2_0= ruleKeyword ) ) (otherlv_3= ',' ( (lv_keywords_4_0= ruleKeyword ) ) )* otherlv_5= ']' )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1527:3: otherlv_0= 'keywords' otherlv_1= '[' ( (lv_keywords_2_0= ruleKeyword ) ) (otherlv_3= ',' ( (lv_keywords_4_0= ruleKeyword ) ) )* otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleScanner_Keyword3597); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getScanner_KeywordAccess().getKeywordsKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,33,FOLLOW_33_in_ruleScanner_Keyword3609); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getScanner_KeywordAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1535:1: ( (lv_keywords_2_0= ruleKeyword ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1536:1: (lv_keywords_2_0= ruleKeyword )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1536:1: (lv_keywords_2_0= ruleKeyword )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1537:3: lv_keywords_2_0= ruleKeyword
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getScanner_KeywordAccess().getKeywordsKeywordParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleKeyword_in_ruleScanner_Keyword3630);
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

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1553:2: (otherlv_3= ',' ( (lv_keywords_4_0= ruleKeyword ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==34) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1553:4: otherlv_3= ',' ( (lv_keywords_4_0= ruleKeyword ) )
            	    {
            	    otherlv_3=(Token)match(input,34,FOLLOW_34_in_ruleScanner_Keyword3643); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getScanner_KeywordAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1557:1: ( (lv_keywords_4_0= ruleKeyword ) )
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1558:1: (lv_keywords_4_0= ruleKeyword )
            	    {
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1558:1: (lv_keywords_4_0= ruleKeyword )
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1559:3: lv_keywords_4_0= ruleKeyword
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getScanner_KeywordAccess().getKeywordsKeywordParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleKeyword_in_ruleScanner_Keyword3664);
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
            	    break loop23;
                }
            } while (true);

            otherlv_5=(Token)match(input,35,FOLLOW_35_in_ruleScanner_Keyword3678); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1587:1: entryRuleKeyword returns [EObject current=null] : iv_ruleKeyword= ruleKeyword EOF ;
    public final EObject entryRuleKeyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyword = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1588:2: (iv_ruleKeyword= ruleKeyword EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1589:2: iv_ruleKeyword= ruleKeyword EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getKeywordRule()); 
            }
            pushFollow(FOLLOW_ruleKeyword_in_entryRuleKeyword3714);
            iv_ruleKeyword=ruleKeyword();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleKeyword; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyword3724); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1596:1: ruleKeyword returns [EObject current=null] : ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_version_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1599:28: ( ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1600:1: ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1600:1: ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1600:2: ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )?
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1600:2: ( (lv_name_0_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1601:1: (lv_name_0_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1601:1: (lv_name_0_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1602:3: lv_name_0_0= RULE_STRING
            {
            lv_name_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword3766); if (state.failed) return current;
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

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1618:2: (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==36) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1618:4: otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) )
                    {
                    otherlv_1=(Token)match(input,36,FOLLOW_36_in_ruleKeyword3784); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getKeywordAccess().getSinceKeyword_1_0());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1622:1: ( (lv_version_2_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1623:1: (lv_version_2_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1623:1: (lv_version_2_0= RULE_STRING )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1624:3: lv_version_2_0= RULE_STRING
                    {
                    lv_version_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword3801); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1648:1: entryRuleScanner_Rule returns [EObject current=null] : iv_ruleScanner_Rule= ruleScanner_Rule EOF ;
    public final EObject entryRuleScanner_Rule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner_Rule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1649:2: (iv_ruleScanner_Rule= ruleScanner_Rule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1650:2: iv_ruleScanner_Rule= ruleScanner_Rule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScanner_RuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_Rule_in_entryRuleScanner_Rule3844);
            iv_ruleScanner_Rule=ruleScanner_Rule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner_Rule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_Rule3854); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1657:1: ruleScanner_Rule returns [EObject current=null] : (this_Scanner_SingleLineRule_0= ruleScanner_SingleLineRule | this_Scanner_MultiLineRule_1= ruleScanner_MultiLineRule | this_Scanner_CharacterRule_2= ruleScanner_CharacterRule | this_Scanner_JSRule_3= ruleScanner_JSRule ) ;
    public final EObject ruleScanner_Rule() throws RecognitionException {
        EObject current = null;

        EObject this_Scanner_SingleLineRule_0 = null;

        EObject this_Scanner_MultiLineRule_1 = null;

        EObject this_Scanner_CharacterRule_2 = null;

        EObject this_Scanner_JSRule_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1660:28: ( (this_Scanner_SingleLineRule_0= ruleScanner_SingleLineRule | this_Scanner_MultiLineRule_1= ruleScanner_MultiLineRule | this_Scanner_CharacterRule_2= ruleScanner_CharacterRule | this_Scanner_JSRule_3= ruleScanner_JSRule ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1661:1: (this_Scanner_SingleLineRule_0= ruleScanner_SingleLineRule | this_Scanner_MultiLineRule_1= ruleScanner_MultiLineRule | this_Scanner_CharacterRule_2= ruleScanner_CharacterRule | this_Scanner_JSRule_3= ruleScanner_JSRule )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1661:1: (this_Scanner_SingleLineRule_0= ruleScanner_SingleLineRule | this_Scanner_MultiLineRule_1= ruleScanner_MultiLineRule | this_Scanner_CharacterRule_2= ruleScanner_CharacterRule | this_Scanner_JSRule_3= ruleScanner_JSRule )
            int alt25=4;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt25=1;
                }
                break;
            case 29:
                {
                alt25=2;
                }
                break;
            case 37:
                {
                alt25=3;
                }
                break;
            case 23:
                {
                alt25=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1662:5: this_Scanner_SingleLineRule_0= ruleScanner_SingleLineRule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getScanner_RuleAccess().getScanner_SingleLineRuleParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleScanner_SingleLineRule_in_ruleScanner_Rule3901);
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1672:5: this_Scanner_MultiLineRule_1= ruleScanner_MultiLineRule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getScanner_RuleAccess().getScanner_MultiLineRuleParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleScanner_MultiLineRule_in_ruleScanner_Rule3928);
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1682:5: this_Scanner_CharacterRule_2= ruleScanner_CharacterRule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getScanner_RuleAccess().getScanner_CharacterRuleParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleScanner_CharacterRule_in_ruleScanner_Rule3955);
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1692:5: this_Scanner_JSRule_3= ruleScanner_JSRule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getScanner_RuleAccess().getScanner_JSRuleParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleScanner_JSRule_in_ruleScanner_Rule3982);
                    this_Scanner_JSRule_3=ruleScanner_JSRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Scanner_JSRule_3; 
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1708:1: entryRuleScanner_SingleLineRule returns [EObject current=null] : iv_ruleScanner_SingleLineRule= ruleScanner_SingleLineRule EOF ;
    public final EObject entryRuleScanner_SingleLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner_SingleLineRule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1709:2: (iv_ruleScanner_SingleLineRule= ruleScanner_SingleLineRule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1710:2: iv_ruleScanner_SingleLineRule= ruleScanner_SingleLineRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScanner_SingleLineRuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_SingleLineRule_in_entryRuleScanner_SingleLineRule4017);
            iv_ruleScanner_SingleLineRule=ruleScanner_SingleLineRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner_SingleLineRule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_SingleLineRule4027); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1717:1: ruleScanner_SingleLineRule returns [EObject current=null] : (otherlv_0= 'single_line' ( (lv_startSeq_1_0= RULE_STRING ) ) otherlv_2= '=>' ( (lv_endSeq_3_0= RULE_STRING ) )? (otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) ) )? ) ;
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
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1720:28: ( (otherlv_0= 'single_line' ( (lv_startSeq_1_0= RULE_STRING ) ) otherlv_2= '=>' ( (lv_endSeq_3_0= RULE_STRING ) )? (otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1721:1: (otherlv_0= 'single_line' ( (lv_startSeq_1_0= RULE_STRING ) ) otherlv_2= '=>' ( (lv_endSeq_3_0= RULE_STRING ) )? (otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1721:1: (otherlv_0= 'single_line' ( (lv_startSeq_1_0= RULE_STRING ) ) otherlv_2= '=>' ( (lv_endSeq_3_0= RULE_STRING ) )? (otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1721:3: otherlv_0= 'single_line' ( (lv_startSeq_1_0= RULE_STRING ) ) otherlv_2= '=>' ( (lv_endSeq_3_0= RULE_STRING ) )? (otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleScanner_SingleLineRule4064); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getScanner_SingleLineRuleAccess().getSingle_lineKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1725:1: ( (lv_startSeq_1_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1726:1: (lv_startSeq_1_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1726:1: (lv_startSeq_1_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1727:3: lv_startSeq_1_0= RULE_STRING
            {
            lv_startSeq_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_SingleLineRule4081); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,26,FOLLOW_26_in_ruleScanner_SingleLineRule4098); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getScanner_SingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_2());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1747:1: ( (lv_endSeq_3_0= RULE_STRING ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_STRING) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1748:1: (lv_endSeq_3_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1748:1: (lv_endSeq_3_0= RULE_STRING )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1749:3: lv_endSeq_3_0= RULE_STRING
                    {
                    lv_endSeq_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_SingleLineRule4115); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_endSeq_3_0, grammarAccess.getScanner_SingleLineRuleAccess().getEndSeqSTRINGTerminalRuleCall_3_0()); 
                      		
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

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1765:3: (otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==27) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1765:5: otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,27,FOLLOW_27_in_ruleScanner_SingleLineRule4134); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getScanner_SingleLineRuleAccess().getEscapedKeyword_4_0());
                          
                    }
                    otherlv_5=(Token)match(input,28,FOLLOW_28_in_ruleScanner_SingleLineRule4146); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getScanner_SingleLineRuleAccess().getByKeyword_4_1());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1773:1: ( (lv_escapeSeq_6_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1774:1: (lv_escapeSeq_6_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1774:1: (lv_escapeSeq_6_0= RULE_STRING )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1775:3: lv_escapeSeq_6_0= RULE_STRING
                    {
                    lv_escapeSeq_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_SingleLineRule4163); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_escapeSeq_6_0, grammarAccess.getScanner_SingleLineRuleAccess().getEscapeSeqSTRINGTerminalRuleCall_4_2_0()); 
                      		
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1799:1: entryRuleScanner_MultiLineRule returns [EObject current=null] : iv_ruleScanner_MultiLineRule= ruleScanner_MultiLineRule EOF ;
    public final EObject entryRuleScanner_MultiLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner_MultiLineRule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1800:2: (iv_ruleScanner_MultiLineRule= ruleScanner_MultiLineRule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1801:2: iv_ruleScanner_MultiLineRule= ruleScanner_MultiLineRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScanner_MultiLineRuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_MultiLineRule_in_entryRuleScanner_MultiLineRule4206);
            iv_ruleScanner_MultiLineRule=ruleScanner_MultiLineRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner_MultiLineRule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_MultiLineRule4216); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1808:1: ruleScanner_MultiLineRule returns [EObject current=null] : (otherlv_0= 'multi_line' ( (lv_startSeq_1_0= RULE_STRING ) ) otherlv_2= '=>' ( (lv_endSeq_3_0= RULE_STRING ) ) (otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) ) )? ) ;
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
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1811:28: ( (otherlv_0= 'multi_line' ( (lv_startSeq_1_0= RULE_STRING ) ) otherlv_2= '=>' ( (lv_endSeq_3_0= RULE_STRING ) ) (otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1812:1: (otherlv_0= 'multi_line' ( (lv_startSeq_1_0= RULE_STRING ) ) otherlv_2= '=>' ( (lv_endSeq_3_0= RULE_STRING ) ) (otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1812:1: (otherlv_0= 'multi_line' ( (lv_startSeq_1_0= RULE_STRING ) ) otherlv_2= '=>' ( (lv_endSeq_3_0= RULE_STRING ) ) (otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1812:3: otherlv_0= 'multi_line' ( (lv_startSeq_1_0= RULE_STRING ) ) otherlv_2= '=>' ( (lv_endSeq_3_0= RULE_STRING ) ) (otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,29,FOLLOW_29_in_ruleScanner_MultiLineRule4253); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getScanner_MultiLineRuleAccess().getMulti_lineKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1816:1: ( (lv_startSeq_1_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1817:1: (lv_startSeq_1_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1817:1: (lv_startSeq_1_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1818:3: lv_startSeq_1_0= RULE_STRING
            {
            lv_startSeq_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_MultiLineRule4270); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,26,FOLLOW_26_in_ruleScanner_MultiLineRule4287); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getScanner_MultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_2());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1838:1: ( (lv_endSeq_3_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1839:1: (lv_endSeq_3_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1839:1: (lv_endSeq_3_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1840:3: lv_endSeq_3_0= RULE_STRING
            {
            lv_endSeq_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_MultiLineRule4304); if (state.failed) return current;
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

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1856:2: (otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==27) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1856:4: otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,27,FOLLOW_27_in_ruleScanner_MultiLineRule4322); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getScanner_MultiLineRuleAccess().getEscapedKeyword_4_0());
                          
                    }
                    otherlv_5=(Token)match(input,28,FOLLOW_28_in_ruleScanner_MultiLineRule4334); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getScanner_MultiLineRuleAccess().getByKeyword_4_1());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1864:1: ( (lv_escapeSeq_6_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1865:1: (lv_escapeSeq_6_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1865:1: (lv_escapeSeq_6_0= RULE_STRING )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1866:3: lv_escapeSeq_6_0= RULE_STRING
                    {
                    lv_escapeSeq_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_MultiLineRule4351); if (state.failed) return current;
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


    // $ANTLR start "entryRuleScanner_CharacterRule"
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1890:1: entryRuleScanner_CharacterRule returns [EObject current=null] : iv_ruleScanner_CharacterRule= ruleScanner_CharacterRule EOF ;
    public final EObject entryRuleScanner_CharacterRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner_CharacterRule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1891:2: (iv_ruleScanner_CharacterRule= ruleScanner_CharacterRule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1892:2: iv_ruleScanner_CharacterRule= ruleScanner_CharacterRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScanner_CharacterRuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_CharacterRule_in_entryRuleScanner_CharacterRule4394);
            iv_ruleScanner_CharacterRule=ruleScanner_CharacterRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner_CharacterRule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_CharacterRule4404); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1899:1: ruleScanner_CharacterRule returns [EObject current=null] : (otherlv_0= 'character' otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' ) ;
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
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1902:28: ( (otherlv_0= 'character' otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1903:1: (otherlv_0= 'character' otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1903:1: (otherlv_0= 'character' otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1903:3: otherlv_0= 'character' otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,37,FOLLOW_37_in_ruleScanner_CharacterRule4441); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getScanner_CharacterRuleAccess().getCharacterKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,33,FOLLOW_33_in_ruleScanner_CharacterRule4453); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getScanner_CharacterRuleAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1911:1: ( (lv_characters_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1912:1: (lv_characters_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1912:1: (lv_characters_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1913:3: lv_characters_2_0= RULE_STRING
            {
            lv_characters_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_CharacterRule4470); if (state.failed) return current;
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

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1929:2: (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==34) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1929:4: otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) )
            	    {
            	    otherlv_3=(Token)match(input,34,FOLLOW_34_in_ruleScanner_CharacterRule4488); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getScanner_CharacterRuleAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1933:1: ( (lv_characters_4_0= RULE_STRING ) )
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1934:1: (lv_characters_4_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1934:1: (lv_characters_4_0= RULE_STRING )
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1935:3: lv_characters_4_0= RULE_STRING
            	    {
            	    lv_characters_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_CharacterRule4505); if (state.failed) return current;
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
            	    break loop29;
                }
            } while (true);

            otherlv_5=(Token)match(input,35,FOLLOW_35_in_ruleScanner_CharacterRule4524); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1963:1: entryRuleScanner_JSRule returns [EObject current=null] : iv_ruleScanner_JSRule= ruleScanner_JSRule EOF ;
    public final EObject entryRuleScanner_JSRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner_JSRule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1964:2: (iv_ruleScanner_JSRule= ruleScanner_JSRule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1965:2: iv_ruleScanner_JSRule= ruleScanner_JSRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScanner_JSRuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_JSRule_in_entryRuleScanner_JSRule4560);
            iv_ruleScanner_JSRule=ruleScanner_JSRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner_JSRule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_JSRule4570); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1972:1: ruleScanner_JSRule returns [EObject current=null] : (otherlv_0= 'script' ( (lv_fileURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleScanner_JSRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_fileURI_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1975:28: ( (otherlv_0= 'script' ( (lv_fileURI_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1976:1: (otherlv_0= 'script' ( (lv_fileURI_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1976:1: (otherlv_0= 'script' ( (lv_fileURI_1_0= RULE_STRING ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1976:3: otherlv_0= 'script' ( (lv_fileURI_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,23,FOLLOW_23_in_ruleScanner_JSRule4607); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getScanner_JSRuleAccess().getScriptKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1980:1: ( (lv_fileURI_1_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1981:1: (lv_fileURI_1_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1981:1: (lv_fileURI_1_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1982:3: lv_fileURI_1_0= RULE_STRING
            {
            lv_fileURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_JSRule4624); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2006:1: entryRuleWhitespaceRule returns [EObject current=null] : iv_ruleWhitespaceRule= ruleWhitespaceRule EOF ;
    public final EObject entryRuleWhitespaceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhitespaceRule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2007:2: (iv_ruleWhitespaceRule= ruleWhitespaceRule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2008:2: iv_ruleWhitespaceRule= ruleWhitespaceRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWhitespaceRuleRule()); 
            }
            pushFollow(FOLLOW_ruleWhitespaceRule_in_entryRuleWhitespaceRule4665);
            iv_ruleWhitespaceRule=ruleWhitespaceRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWhitespaceRule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleWhitespaceRule4675); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2015:1: ruleWhitespaceRule returns [EObject current=null] : (otherlv_0= 'whitespace' ( (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' ) | ( (lv_javawhitespace_6_0= 'javawhitespace' ) ) | ( (lv_fileURI_7_0= RULE_STRING ) ) ) ) ;
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
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2018:28: ( (otherlv_0= 'whitespace' ( (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' ) | ( (lv_javawhitespace_6_0= 'javawhitespace' ) ) | ( (lv_fileURI_7_0= RULE_STRING ) ) ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2019:1: (otherlv_0= 'whitespace' ( (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' ) | ( (lv_javawhitespace_6_0= 'javawhitespace' ) ) | ( (lv_fileURI_7_0= RULE_STRING ) ) ) )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2019:1: (otherlv_0= 'whitespace' ( (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' ) | ( (lv_javawhitespace_6_0= 'javawhitespace' ) ) | ( (lv_fileURI_7_0= RULE_STRING ) ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2019:3: otherlv_0= 'whitespace' ( (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' ) | ( (lv_javawhitespace_6_0= 'javawhitespace' ) ) | ( (lv_fileURI_7_0= RULE_STRING ) ) )
            {
            otherlv_0=(Token)match(input,38,FOLLOW_38_in_ruleWhitespaceRule4712); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getWhitespaceRuleAccess().getWhitespaceKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2023:1: ( (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' ) | ( (lv_javawhitespace_6_0= 'javawhitespace' ) ) | ( (lv_fileURI_7_0= RULE_STRING ) ) )
            int alt31=3;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt31=1;
                }
                break;
            case 39:
                {
                alt31=2;
                }
                break;
            case RULE_STRING:
                {
                alt31=3;
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2023:2: (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2023:2: (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2023:4: otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']'
                    {
                    otherlv_1=(Token)match(input,33,FOLLOW_33_in_ruleWhitespaceRule4726); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getWhitespaceRuleAccess().getLeftSquareBracketKeyword_1_0_0());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2027:1: ( (lv_characters_2_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2028:1: (lv_characters_2_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2028:1: (lv_characters_2_0= RULE_STRING )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2029:3: lv_characters_2_0= RULE_STRING
                    {
                    lv_characters_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleWhitespaceRule4743); if (state.failed) return current;
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

                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2045:2: (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==34) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2045:4: otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) )
                    	    {
                    	    otherlv_3=(Token)match(input,34,FOLLOW_34_in_ruleWhitespaceRule4761); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getWhitespaceRuleAccess().getCommaKeyword_1_0_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2049:1: ( (lv_characters_4_0= RULE_STRING ) )
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2050:1: (lv_characters_4_0= RULE_STRING )
                    	    {
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2050:1: (lv_characters_4_0= RULE_STRING )
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2051:3: lv_characters_4_0= RULE_STRING
                    	    {
                    	    lv_characters_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleWhitespaceRule4778); if (state.failed) return current;
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
                    	    break loop30;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,35,FOLLOW_35_in_ruleWhitespaceRule4797); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getWhitespaceRuleAccess().getRightSquareBracketKeyword_1_0_3());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2072:6: ( (lv_javawhitespace_6_0= 'javawhitespace' ) )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2072:6: ( (lv_javawhitespace_6_0= 'javawhitespace' ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2073:1: (lv_javawhitespace_6_0= 'javawhitespace' )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2073:1: (lv_javawhitespace_6_0= 'javawhitespace' )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2074:3: lv_javawhitespace_6_0= 'javawhitespace'
                    {
                    lv_javawhitespace_6_0=(Token)match(input,39,FOLLOW_39_in_ruleWhitespaceRule4822); if (state.failed) return current;
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2088:6: ( (lv_fileURI_7_0= RULE_STRING ) )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2088:6: ( (lv_fileURI_7_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2089:1: (lv_fileURI_7_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2089:1: (lv_fileURI_7_0= RULE_STRING )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2090:3: lv_fileURI_7_0= RULE_STRING
                    {
                    lv_fileURI_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleWhitespaceRule4858); if (state.failed) return current;
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
    public static final BitSet FOLLOW_15_in_ruleLanguageDef780 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ruleParitioning_in_ruleLanguageDef801 = new BitSet(new long[]{0x0000000040000000L});
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
    public static final BitSet FOLLOW_RULE_STRING_in_ruleJavaCodeGeneration1423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleE4CodeGeneration_in_entryRuleE4CodeGeneration1464 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleE4CodeGeneration1474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleE4CodeGeneration1511 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleE4CodeGeneration1528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParitioning_in_entryRuleParitioning1569 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParitioning1579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleParitioning1616 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleParitioning1628 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rulePartition_in_ruleParitioning1649 = new BitSet(new long[]{0x0000000001C00000L});
    public static final BitSet FOLLOW_rulePartitioner_in_ruleParitioning1671 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleParitioning1683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_in_entryRulePartition1719 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartition1729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rulePartition1766 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePartition1783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitioner_in_entryRulePartitioner1824 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartitioner1834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitioner_Rule_in_rulePartitioner1881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParitioner_JS_in_rulePartitioner1908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParitioner_JS_in_entryRuleParitioner_JS1943 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParitioner_JS1953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleParitioner_JS1990 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleParitioner_JS2007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitioner_Rule_in_entryRulePartitioner_Rule2048 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartitioner_Rule2058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rulePartitioner_Rule2095 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_rulePartitioner_Rule2107 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_rulePartition_Rule_in_rulePartitioner_Rule2128 = new BitSet(new long[]{0x0000000022010000L});
    public static final BitSet FOLLOW_16_in_rulePartitioner_Rule2141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_Rule_in_entryRulePartition_Rule2177 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartition_Rule2187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_SingleLineRule_in_rulePartition_Rule2234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_MultiLineRule_in_rulePartition_Rule2261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_SingleLineRule_in_entryRulePartition_SingleLineRule2296 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartition_SingleLineRule2306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rulePartition_SingleLineRule2343 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePartition_SingleLineRule2363 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartition_SingleLineRule2380 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_rulePartition_SingleLineRule2397 = new BitSet(new long[]{0x0000000008000022L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartition_SingleLineRule2414 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_rulePartition_SingleLineRule2433 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_rulePartition_SingleLineRule2445 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartition_SingleLineRule2462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_MultiLineRule_in_entryRulePartition_MultiLineRule2505 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartition_MultiLineRule2515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rulePartition_MultiLineRule2552 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePartition_MultiLineRule2572 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartition_MultiLineRule2589 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_rulePartition_MultiLineRule2606 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartition_MultiLineRule2623 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_rulePartition_MultiLineRule2641 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_rulePartition_MultiLineRule2653 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartition_MultiLineRule2670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalHighlighting_in_entryRuleLexicalHighlighting2713 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexicalHighlighting2723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleLexicalHighlighting2760 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleLexicalHighlighting2772 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_in_ruleLexicalHighlighting2793 = new BitSet(new long[]{0x0000000001810000L});
    public static final BitSet FOLLOW_16_in_ruleLexicalHighlighting2806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_in_entryRuleLexicalPartitionHighlighting2842 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting2852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_Rule_in_ruleLexicalPartitionHighlighting2899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_JS_in_ruleLexicalPartitionHighlighting2926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_JS_in_entryRuleLexicalPartitionHighlighting_JS2961 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting_JS2971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleLexicalPartitionHighlighting_JS3008 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLexicalPartitionHighlighting_JS3028 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLexicalPartitionHighlighting_JS3045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_Rule_in_entryRuleLexicalPartitionHighlighting_Rule3086 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting_Rule3096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleLexicalPartitionHighlighting_Rule3133 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLexicalPartitionHighlighting_Rule3153 = new BitSet(new long[]{0x0000004000008000L});
    public static final BitSet FOLLOW_ruleWhitespaceRule_in_ruleLexicalPartitionHighlighting_Rule3174 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleLexicalPartitionHighlighting_Rule3187 = new BitSet(new long[]{0x0000000080000010L});
    public static final BitSet FOLLOW_ruleToken_in_ruleLexicalPartitionHighlighting_Rule3208 = new BitSet(new long[]{0x0000000080010010L});
    public static final BitSet FOLLOW_16_in_ruleLexicalPartitionHighlighting_Rule3221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleToken_in_entryRuleToken3257 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleToken3267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleToken3310 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleToken3341 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleToken3359 = new BitSet(new long[]{0x0000002122800000L});
    public static final BitSet FOLLOW_ruleScanner_in_ruleToken3380 = new BitSet(new long[]{0x0000002122810000L});
    public static final BitSet FOLLOW_16_in_ruleToken3393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_in_entryRuleScanner3431 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner3441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_Keyword_in_ruleScanner3488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_Rule_in_ruleScanner3515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_Keyword_in_entryRuleScanner_Keyword3550 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_Keyword3560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleScanner_Keyword3597 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleScanner_Keyword3609 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleScanner_Keyword3630 = new BitSet(new long[]{0x0000000C00000000L});
    public static final BitSet FOLLOW_34_in_ruleScanner_Keyword3643 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleScanner_Keyword3664 = new BitSet(new long[]{0x0000000C00000000L});
    public static final BitSet FOLLOW_35_in_ruleScanner_Keyword3678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword3714 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyword3724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword3766 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_36_in_ruleKeyword3784 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword3801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_Rule_in_entryRuleScanner_Rule3844 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_Rule3854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_SingleLineRule_in_ruleScanner_Rule3901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_MultiLineRule_in_ruleScanner_Rule3928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_CharacterRule_in_ruleScanner_Rule3955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_JSRule_in_ruleScanner_Rule3982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_SingleLineRule_in_entryRuleScanner_SingleLineRule4017 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_SingleLineRule4027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleScanner_SingleLineRule4064 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_SingleLineRule4081 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleScanner_SingleLineRule4098 = new BitSet(new long[]{0x0000000008000022L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_SingleLineRule4115 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ruleScanner_SingleLineRule4134 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleScanner_SingleLineRule4146 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_SingleLineRule4163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_MultiLineRule_in_entryRuleScanner_MultiLineRule4206 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_MultiLineRule4216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleScanner_MultiLineRule4253 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_MultiLineRule4270 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleScanner_MultiLineRule4287 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_MultiLineRule4304 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ruleScanner_MultiLineRule4322 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleScanner_MultiLineRule4334 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_MultiLineRule4351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_CharacterRule_in_entryRuleScanner_CharacterRule4394 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_CharacterRule4404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleScanner_CharacterRule4441 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleScanner_CharacterRule4453 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_CharacterRule4470 = new BitSet(new long[]{0x0000000C00000000L});
    public static final BitSet FOLLOW_34_in_ruleScanner_CharacterRule4488 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_CharacterRule4505 = new BitSet(new long[]{0x0000000C00000000L});
    public static final BitSet FOLLOW_35_in_ruleScanner_CharacterRule4524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_JSRule_in_entryRuleScanner_JSRule4560 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_JSRule4570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleScanner_JSRule4607 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_JSRule4624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhitespaceRule_in_entryRuleWhitespaceRule4665 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWhitespaceRule4675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleWhitespaceRule4712 = new BitSet(new long[]{0x0000008200000020L});
    public static final BitSet FOLLOW_33_in_ruleWhitespaceRule4726 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleWhitespaceRule4743 = new BitSet(new long[]{0x0000000C00000000L});
    public static final BitSet FOLLOW_34_in_ruleWhitespaceRule4761 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleWhitespaceRule4778 = new BitSet(new long[]{0x0000000C00000000L});
    public static final BitSet FOLLOW_35_in_ruleWhitespaceRule4797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleWhitespaceRule4822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleWhitespaceRule4858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_synpred1_InternalLDef395 = new BitSet(new long[]{0x0000000000000002L});

}