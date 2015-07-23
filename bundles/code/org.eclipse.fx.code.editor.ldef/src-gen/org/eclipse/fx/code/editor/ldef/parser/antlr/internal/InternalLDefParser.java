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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'.'", "'*'", "'import'", "'{'", "'}'", "'integration'", "'javafx'", "'codegeneration'", "'e4'", "'swt'", "'partitioning'", "'partition'", "'script'", "'rule'", "'single_line'", "'=>'", "'escaped'", "'by'", "'multi_line'", "'lexical_highlighting'", "'default'", "'keywords'", "'['", "','", "']'", "'since'", "'character'", "'whitespace'", "'javawhitespace'"
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

                if ( (LA5_0==18||LA5_0==21) ) {
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:473:1: ruleCodeIntegration returns [EObject current=null] : (this_JavaFXIntegration_0= ruleJavaFXIntegration | this_SWTIntegration_1= ruleSWTIntegration ) ;
    public final EObject ruleCodeIntegration() throws RecognitionException {
        EObject current = null;

        EObject this_JavaFXIntegration_0 = null;

        EObject this_SWTIntegration_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:476:28: ( (this_JavaFXIntegration_0= ruleJavaFXIntegration | this_SWTIntegration_1= ruleSWTIntegration ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:477:1: (this_JavaFXIntegration_0= ruleJavaFXIntegration | this_SWTIntegration_1= ruleSWTIntegration )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:477:1: (this_JavaFXIntegration_0= ruleJavaFXIntegration | this_SWTIntegration_1= ruleSWTIntegration )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==18) ) {
                alt6=1;
            }
            else if ( (LA6_0==21) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:478:5: this_JavaFXIntegration_0= ruleJavaFXIntegration
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getCodeIntegrationAccess().getJavaFXIntegrationParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJavaFXIntegration_in_ruleCodeIntegration1078);
                    this_JavaFXIntegration_0=ruleJavaFXIntegration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_JavaFXIntegration_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:488:5: this_SWTIntegration_1= ruleSWTIntegration
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getCodeIntegrationAccess().getSWTIntegrationParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleSWTIntegration_in_ruleCodeIntegration1105);
                    this_SWTIntegration_1=ruleSWTIntegration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_SWTIntegration_1; 
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
    // $ANTLR end "ruleCodeIntegration"


    // $ANTLR start "entryRuleJavaFXIntegration"
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:504:1: entryRuleJavaFXIntegration returns [EObject current=null] : iv_ruleJavaFXIntegration= ruleJavaFXIntegration EOF ;
    public final EObject entryRuleJavaFXIntegration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaFXIntegration = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:505:2: (iv_ruleJavaFXIntegration= ruleJavaFXIntegration EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:506:2: iv_ruleJavaFXIntegration= ruleJavaFXIntegration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJavaFXIntegrationRule()); 
            }
            pushFollow(FOLLOW_ruleJavaFXIntegration_in_entryRuleJavaFXIntegration1140);
            iv_ruleJavaFXIntegration=ruleJavaFXIntegration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJavaFXIntegration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJavaFXIntegration1150); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:513:1: ruleJavaFXIntegration returns [EObject current=null] : (otherlv_0= 'javafx' otherlv_1= '{' () ( (lv_codegen_3_0= 'codegeneration' ) )? ( (lv_e4_4_0= 'e4' ) )? otherlv_5= '}' ) ;
    public final EObject ruleJavaFXIntegration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_codegen_3_0=null;
        Token lv_e4_4_0=null;
        Token otherlv_5=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:516:28: ( (otherlv_0= 'javafx' otherlv_1= '{' () ( (lv_codegen_3_0= 'codegeneration' ) )? ( (lv_e4_4_0= 'e4' ) )? otherlv_5= '}' ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:517:1: (otherlv_0= 'javafx' otherlv_1= '{' () ( (lv_codegen_3_0= 'codegeneration' ) )? ( (lv_e4_4_0= 'e4' ) )? otherlv_5= '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:517:1: (otherlv_0= 'javafx' otherlv_1= '{' () ( (lv_codegen_3_0= 'codegeneration' ) )? ( (lv_e4_4_0= 'e4' ) )? otherlv_5= '}' )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:517:3: otherlv_0= 'javafx' otherlv_1= '{' () ( (lv_codegen_3_0= 'codegeneration' ) )? ( (lv_e4_4_0= 'e4' ) )? otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_18_in_ruleJavaFXIntegration1187); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJavaFXIntegrationAccess().getJavafxKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleJavaFXIntegration1199); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getJavaFXIntegrationAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:525:1: ()
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:526:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getJavaFXIntegrationAccess().getJavaFXIntegrationAction_2(),
                          current);
                  
            }

            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:531:2: ( (lv_codegen_3_0= 'codegeneration' ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==19) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:532:1: (lv_codegen_3_0= 'codegeneration' )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:532:1: (lv_codegen_3_0= 'codegeneration' )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:533:3: lv_codegen_3_0= 'codegeneration'
                    {
                    lv_codegen_3_0=(Token)match(input,19,FOLLOW_19_in_ruleJavaFXIntegration1226); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_codegen_3_0, grammarAccess.getJavaFXIntegrationAccess().getCodegenCodegenerationKeyword_3_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getJavaFXIntegrationRule());
                      	        }
                             		setWithLastConsumed(current, "codegen", true, "codegeneration");
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:546:3: ( (lv_e4_4_0= 'e4' ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==20) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:547:1: (lv_e4_4_0= 'e4' )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:547:1: (lv_e4_4_0= 'e4' )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:548:3: lv_e4_4_0= 'e4'
                    {
                    lv_e4_4_0=(Token)match(input,20,FOLLOW_20_in_ruleJavaFXIntegration1258); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_e4_4_0, grammarAccess.getJavaFXIntegrationAccess().getE4E4Keyword_4_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getJavaFXIntegrationRule());
                      	        }
                             		setWithLastConsumed(current, "e4", true, "e4");
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,16,FOLLOW_16_in_ruleJavaFXIntegration1284); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getJavaFXIntegrationAccess().getRightCurlyBracketKeyword_5());
                  
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


    // $ANTLR start "entryRuleSWTIntegration"
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:573:1: entryRuleSWTIntegration returns [EObject current=null] : iv_ruleSWTIntegration= ruleSWTIntegration EOF ;
    public final EObject entryRuleSWTIntegration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSWTIntegration = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:574:2: (iv_ruleSWTIntegration= ruleSWTIntegration EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:575:2: iv_ruleSWTIntegration= ruleSWTIntegration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSWTIntegrationRule()); 
            }
            pushFollow(FOLLOW_ruleSWTIntegration_in_entryRuleSWTIntegration1320);
            iv_ruleSWTIntegration=ruleSWTIntegration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSWTIntegration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSWTIntegration1330); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSWTIntegration"


    // $ANTLR start "ruleSWTIntegration"
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:582:1: ruleSWTIntegration returns [EObject current=null] : (otherlv_0= 'swt' otherlv_1= '{' () ( (lv_codegen_3_0= 'codegeneration' ) )? ( (lv_e4_4_0= 'e4' ) )? otherlv_5= '}' ) ;
    public final EObject ruleSWTIntegration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_codegen_3_0=null;
        Token lv_e4_4_0=null;
        Token otherlv_5=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:585:28: ( (otherlv_0= 'swt' otherlv_1= '{' () ( (lv_codegen_3_0= 'codegeneration' ) )? ( (lv_e4_4_0= 'e4' ) )? otherlv_5= '}' ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:586:1: (otherlv_0= 'swt' otherlv_1= '{' () ( (lv_codegen_3_0= 'codegeneration' ) )? ( (lv_e4_4_0= 'e4' ) )? otherlv_5= '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:586:1: (otherlv_0= 'swt' otherlv_1= '{' () ( (lv_codegen_3_0= 'codegeneration' ) )? ( (lv_e4_4_0= 'e4' ) )? otherlv_5= '}' )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:586:3: otherlv_0= 'swt' otherlv_1= '{' () ( (lv_codegen_3_0= 'codegeneration' ) )? ( (lv_e4_4_0= 'e4' ) )? otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleSWTIntegration1367); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSWTIntegrationAccess().getSwtKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleSWTIntegration1379); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSWTIntegrationAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:594:1: ()
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:595:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getSWTIntegrationAccess().getSWTIntegrationAction_2(),
                          current);
                  
            }

            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:600:2: ( (lv_codegen_3_0= 'codegeneration' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:601:1: (lv_codegen_3_0= 'codegeneration' )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:601:1: (lv_codegen_3_0= 'codegeneration' )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:602:3: lv_codegen_3_0= 'codegeneration'
                    {
                    lv_codegen_3_0=(Token)match(input,19,FOLLOW_19_in_ruleSWTIntegration1406); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_codegen_3_0, grammarAccess.getSWTIntegrationAccess().getCodegenCodegenerationKeyword_3_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSWTIntegrationRule());
                      	        }
                             		setWithLastConsumed(current, "codegen", true, "codegeneration");
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:615:3: ( (lv_e4_4_0= 'e4' ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==20) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:616:1: (lv_e4_4_0= 'e4' )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:616:1: (lv_e4_4_0= 'e4' )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:617:3: lv_e4_4_0= 'e4'
                    {
                    lv_e4_4_0=(Token)match(input,20,FOLLOW_20_in_ruleSWTIntegration1438); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_e4_4_0, grammarAccess.getSWTIntegrationAccess().getE4E4Keyword_4_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSWTIntegrationRule());
                      	        }
                             		setWithLastConsumed(current, "e4", true, "e4");
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,16,FOLLOW_16_in_ruleSWTIntegration1464); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getSWTIntegrationAccess().getRightCurlyBracketKeyword_5());
                  
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
    // $ANTLR end "ruleSWTIntegration"


    // $ANTLR start "entryRuleParitioning"
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:642:1: entryRuleParitioning returns [EObject current=null] : iv_ruleParitioning= ruleParitioning EOF ;
    public final EObject entryRuleParitioning() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParitioning = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:643:2: (iv_ruleParitioning= ruleParitioning EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:644:2: iv_ruleParitioning= ruleParitioning EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParitioningRule()); 
            }
            pushFollow(FOLLOW_ruleParitioning_in_entryRuleParitioning1500);
            iv_ruleParitioning=ruleParitioning();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParitioning; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParitioning1510); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:651:1: ruleParitioning returns [EObject current=null] : (otherlv_0= 'partitioning' otherlv_1= '{' ( (lv_partitions_2_0= rulePartition ) )+ ( (lv_partitioner_3_0= rulePartitioner ) ) otherlv_4= '}' ) ;
    public final EObject ruleParitioning() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_partitions_2_0 = null;

        EObject lv_partitioner_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:654:28: ( (otherlv_0= 'partitioning' otherlv_1= '{' ( (lv_partitions_2_0= rulePartition ) )+ ( (lv_partitioner_3_0= rulePartitioner ) ) otherlv_4= '}' ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:655:1: (otherlv_0= 'partitioning' otherlv_1= '{' ( (lv_partitions_2_0= rulePartition ) )+ ( (lv_partitioner_3_0= rulePartitioner ) ) otherlv_4= '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:655:1: (otherlv_0= 'partitioning' otherlv_1= '{' ( (lv_partitions_2_0= rulePartition ) )+ ( (lv_partitioner_3_0= rulePartitioner ) ) otherlv_4= '}' )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:655:3: otherlv_0= 'partitioning' otherlv_1= '{' ( (lv_partitions_2_0= rulePartition ) )+ ( (lv_partitioner_3_0= rulePartitioner ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_22_in_ruleParitioning1547); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getParitioningAccess().getPartitioningKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleParitioning1559); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getParitioningAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:663:1: ( (lv_partitions_2_0= rulePartition ) )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==23) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:664:1: (lv_partitions_2_0= rulePartition )
            	    {
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:664:1: (lv_partitions_2_0= rulePartition )
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:665:3: lv_partitions_2_0= rulePartition
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getParitioningAccess().getPartitionsPartitionParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulePartition_in_ruleParitioning1580);
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
            	    if ( cnt11 >= 1 ) break loop11;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:681:3: ( (lv_partitioner_3_0= rulePartitioner ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:682:1: (lv_partitioner_3_0= rulePartitioner )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:682:1: (lv_partitioner_3_0= rulePartitioner )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:683:3: lv_partitioner_3_0= rulePartitioner
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParitioningAccess().getPartitionerPartitionerParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePartitioner_in_ruleParitioning1602);
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

            otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleParitioning1614); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:711:1: entryRulePartition returns [EObject current=null] : iv_rulePartition= rulePartition EOF ;
    public final EObject entryRulePartition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartition = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:712:2: (iv_rulePartition= rulePartition EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:713:2: iv_rulePartition= rulePartition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPartitionRule()); 
            }
            pushFollow(FOLLOW_rulePartition_in_entryRulePartition1650);
            iv_rulePartition=rulePartition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePartition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePartition1660); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:720:1: rulePartition returns [EObject current=null] : (otherlv_0= 'partition' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject rulePartition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:723:28: ( (otherlv_0= 'partition' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:724:1: (otherlv_0= 'partition' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:724:1: (otherlv_0= 'partition' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:724:3: otherlv_0= 'partition' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,23,FOLLOW_23_in_rulePartition1697); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getPartitionAccess().getPartitionKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:728:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:729:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:729:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:730:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePartition1714); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:754:1: entryRulePartitioner returns [EObject current=null] : iv_rulePartitioner= rulePartitioner EOF ;
    public final EObject entryRulePartitioner() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartitioner = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:755:2: (iv_rulePartitioner= rulePartitioner EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:756:2: iv_rulePartitioner= rulePartitioner EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPartitionerRule()); 
            }
            pushFollow(FOLLOW_rulePartitioner_in_entryRulePartitioner1755);
            iv_rulePartitioner=rulePartitioner();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePartitioner; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePartitioner1765); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:763:1: rulePartitioner returns [EObject current=null] : (this_Partitioner_Rule_0= rulePartitioner_Rule | this_Paritioner_JS_1= ruleParitioner_JS ) ;
    public final EObject rulePartitioner() throws RecognitionException {
        EObject current = null;

        EObject this_Partitioner_Rule_0 = null;

        EObject this_Paritioner_JS_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:766:28: ( (this_Partitioner_Rule_0= rulePartitioner_Rule | this_Paritioner_JS_1= ruleParitioner_JS ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:767:1: (this_Partitioner_Rule_0= rulePartitioner_Rule | this_Paritioner_JS_1= ruleParitioner_JS )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:767:1: (this_Partitioner_Rule_0= rulePartitioner_Rule | this_Paritioner_JS_1= ruleParitioner_JS )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==25) ) {
                alt12=1;
            }
            else if ( (LA12_0==24) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:768:5: this_Partitioner_Rule_0= rulePartitioner_Rule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPartitionerAccess().getPartitioner_RuleParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_rulePartitioner_Rule_in_rulePartitioner1812);
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:778:5: this_Paritioner_JS_1= ruleParitioner_JS
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPartitionerAccess().getParitioner_JSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleParitioner_JS_in_rulePartitioner1839);
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:794:1: entryRuleParitioner_JS returns [EObject current=null] : iv_ruleParitioner_JS= ruleParitioner_JS EOF ;
    public final EObject entryRuleParitioner_JS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParitioner_JS = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:795:2: (iv_ruleParitioner_JS= ruleParitioner_JS EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:796:2: iv_ruleParitioner_JS= ruleParitioner_JS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParitioner_JSRule()); 
            }
            pushFollow(FOLLOW_ruleParitioner_JS_in_entryRuleParitioner_JS1874);
            iv_ruleParitioner_JS=ruleParitioner_JS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParitioner_JS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParitioner_JS1884); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:803:1: ruleParitioner_JS returns [EObject current=null] : (otherlv_0= 'script' ( (lv_scriptURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleParitioner_JS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_scriptURI_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:806:28: ( (otherlv_0= 'script' ( (lv_scriptURI_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:807:1: (otherlv_0= 'script' ( (lv_scriptURI_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:807:1: (otherlv_0= 'script' ( (lv_scriptURI_1_0= RULE_STRING ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:807:3: otherlv_0= 'script' ( (lv_scriptURI_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleParitioner_JS1921); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getParitioner_JSAccess().getScriptKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:811:1: ( (lv_scriptURI_1_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:812:1: (lv_scriptURI_1_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:812:1: (lv_scriptURI_1_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:813:3: lv_scriptURI_1_0= RULE_STRING
            {
            lv_scriptURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleParitioner_JS1938); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:837:1: entryRulePartitioner_Rule returns [EObject current=null] : iv_rulePartitioner_Rule= rulePartitioner_Rule EOF ;
    public final EObject entryRulePartitioner_Rule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartitioner_Rule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:838:2: (iv_rulePartitioner_Rule= rulePartitioner_Rule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:839:2: iv_rulePartitioner_Rule= rulePartitioner_Rule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPartitioner_RuleRule()); 
            }
            pushFollow(FOLLOW_rulePartitioner_Rule_in_entryRulePartitioner_Rule1979);
            iv_rulePartitioner_Rule=rulePartitioner_Rule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePartitioner_Rule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePartitioner_Rule1989); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:846:1: rulePartitioner_Rule returns [EObject current=null] : (otherlv_0= 'rule' otherlv_1= '{' ( (lv_ruleList_2_0= rulePartition_Rule ) )+ otherlv_3= '}' ) ;
    public final EObject rulePartitioner_Rule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ruleList_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:849:28: ( (otherlv_0= 'rule' otherlv_1= '{' ( (lv_ruleList_2_0= rulePartition_Rule ) )+ otherlv_3= '}' ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:850:1: (otherlv_0= 'rule' otherlv_1= '{' ( (lv_ruleList_2_0= rulePartition_Rule ) )+ otherlv_3= '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:850:1: (otherlv_0= 'rule' otherlv_1= '{' ( (lv_ruleList_2_0= rulePartition_Rule ) )+ otherlv_3= '}' )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:850:3: otherlv_0= 'rule' otherlv_1= '{' ( (lv_ruleList_2_0= rulePartition_Rule ) )+ otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_rulePartitioner_Rule2026); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getPartitioner_RuleAccess().getRuleKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,15,FOLLOW_15_in_rulePartitioner_Rule2038); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getPartitioner_RuleAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:858:1: ( (lv_ruleList_2_0= rulePartition_Rule ) )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==26||LA13_0==30) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:859:1: (lv_ruleList_2_0= rulePartition_Rule )
            	    {
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:859:1: (lv_ruleList_2_0= rulePartition_Rule )
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:860:3: lv_ruleList_2_0= rulePartition_Rule
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPartitioner_RuleAccess().getRuleListPartition_RuleParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulePartition_Rule_in_rulePartitioner_Rule2059);
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
            	    if ( cnt13 >= 1 ) break loop13;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);

            otherlv_3=(Token)match(input,16,FOLLOW_16_in_rulePartitioner_Rule2072); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:888:1: entryRulePartition_Rule returns [EObject current=null] : iv_rulePartition_Rule= rulePartition_Rule EOF ;
    public final EObject entryRulePartition_Rule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartition_Rule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:889:2: (iv_rulePartition_Rule= rulePartition_Rule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:890:2: iv_rulePartition_Rule= rulePartition_Rule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPartition_RuleRule()); 
            }
            pushFollow(FOLLOW_rulePartition_Rule_in_entryRulePartition_Rule2108);
            iv_rulePartition_Rule=rulePartition_Rule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePartition_Rule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePartition_Rule2118); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:897:1: rulePartition_Rule returns [EObject current=null] : (this_Partition_SingleLineRule_0= rulePartition_SingleLineRule | this_Partition_MultiLineRule_1= rulePartition_MultiLineRule ) ;
    public final EObject rulePartition_Rule() throws RecognitionException {
        EObject current = null;

        EObject this_Partition_SingleLineRule_0 = null;

        EObject this_Partition_MultiLineRule_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:900:28: ( (this_Partition_SingleLineRule_0= rulePartition_SingleLineRule | this_Partition_MultiLineRule_1= rulePartition_MultiLineRule ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:901:1: (this_Partition_SingleLineRule_0= rulePartition_SingleLineRule | this_Partition_MultiLineRule_1= rulePartition_MultiLineRule )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:901:1: (this_Partition_SingleLineRule_0= rulePartition_SingleLineRule | this_Partition_MultiLineRule_1= rulePartition_MultiLineRule )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==26) ) {
                alt14=1;
            }
            else if ( (LA14_0==30) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:902:5: this_Partition_SingleLineRule_0= rulePartition_SingleLineRule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPartition_RuleAccess().getPartition_SingleLineRuleParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_rulePartition_SingleLineRule_in_rulePartition_Rule2165);
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:912:5: this_Partition_MultiLineRule_1= rulePartition_MultiLineRule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPartition_RuleAccess().getPartition_MultiLineRuleParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_rulePartition_MultiLineRule_in_rulePartition_Rule2192);
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:928:1: entryRulePartition_SingleLineRule returns [EObject current=null] : iv_rulePartition_SingleLineRule= rulePartition_SingleLineRule EOF ;
    public final EObject entryRulePartition_SingleLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartition_SingleLineRule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:929:2: (iv_rulePartition_SingleLineRule= rulePartition_SingleLineRule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:930:2: iv_rulePartition_SingleLineRule= rulePartition_SingleLineRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPartition_SingleLineRuleRule()); 
            }
            pushFollow(FOLLOW_rulePartition_SingleLineRule_in_entryRulePartition_SingleLineRule2227);
            iv_rulePartition_SingleLineRule=rulePartition_SingleLineRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePartition_SingleLineRule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePartition_SingleLineRule2237); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:937:1: rulePartition_SingleLineRule returns [EObject current=null] : (otherlv_0= 'single_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) )? (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) ;
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
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:940:28: ( (otherlv_0= 'single_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) )? (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:941:1: (otherlv_0= 'single_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) )? (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:941:1: (otherlv_0= 'single_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) )? (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:941:3: otherlv_0= 'single_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) )? (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,26,FOLLOW_26_in_rulePartition_SingleLineRule2274); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getPartition_SingleLineRuleAccess().getSingle_lineKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:945:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:946:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:946:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:947:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getPartition_SingleLineRuleRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePartition_SingleLineRule2294); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getPartition_SingleLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
              	
            }

            }


            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:958:2: ( (lv_startSeq_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:959:1: (lv_startSeq_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:959:1: (lv_startSeq_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:960:3: lv_startSeq_2_0= RULE_STRING
            {
            lv_startSeq_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartition_SingleLineRule2311); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,27,FOLLOW_27_in_rulePartition_SingleLineRule2328); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getPartition_SingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:980:1: ( (lv_endSeq_4_0= RULE_STRING ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_STRING) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:981:1: (lv_endSeq_4_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:981:1: (lv_endSeq_4_0= RULE_STRING )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:982:3: lv_endSeq_4_0= RULE_STRING
                    {
                    lv_endSeq_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartition_SingleLineRule2345); if (state.failed) return current;
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

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:998:3: (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==28) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:998:5: otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,28,FOLLOW_28_in_rulePartition_SingleLineRule2364); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getPartition_SingleLineRuleAccess().getEscapedKeyword_5_0());
                          
                    }
                    otherlv_6=(Token)match(input,29,FOLLOW_29_in_rulePartition_SingleLineRule2376); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getPartition_SingleLineRuleAccess().getByKeyword_5_1());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1006:1: ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1007:1: (lv_escapeSeq_7_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1007:1: (lv_escapeSeq_7_0= RULE_STRING )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1008:3: lv_escapeSeq_7_0= RULE_STRING
                    {
                    lv_escapeSeq_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartition_SingleLineRule2393); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1032:1: entryRulePartition_MultiLineRule returns [EObject current=null] : iv_rulePartition_MultiLineRule= rulePartition_MultiLineRule EOF ;
    public final EObject entryRulePartition_MultiLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartition_MultiLineRule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1033:2: (iv_rulePartition_MultiLineRule= rulePartition_MultiLineRule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1034:2: iv_rulePartition_MultiLineRule= rulePartition_MultiLineRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPartition_MultiLineRuleRule()); 
            }
            pushFollow(FOLLOW_rulePartition_MultiLineRule_in_entryRulePartition_MultiLineRule2436);
            iv_rulePartition_MultiLineRule=rulePartition_MultiLineRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePartition_MultiLineRule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePartition_MultiLineRule2446); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1041:1: rulePartition_MultiLineRule returns [EObject current=null] : (otherlv_0= 'multi_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) ;
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
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1044:28: ( (otherlv_0= 'multi_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1045:1: (otherlv_0= 'multi_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1045:1: (otherlv_0= 'multi_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1045:3: otherlv_0= 'multi_line' ( (otherlv_1= RULE_ID ) ) ( (lv_startSeq_2_0= RULE_STRING ) ) otherlv_3= '=>' ( (lv_endSeq_4_0= RULE_STRING ) ) (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_rulePartition_MultiLineRule2483); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getPartition_MultiLineRuleAccess().getMulti_lineKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1049:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1050:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1050:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1051:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getPartition_MultiLineRuleRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePartition_MultiLineRule2503); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getPartition_MultiLineRuleAccess().getParitionPartitionCrossReference_1_0()); 
              	
            }

            }


            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1062:2: ( (lv_startSeq_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1063:1: (lv_startSeq_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1063:1: (lv_startSeq_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1064:3: lv_startSeq_2_0= RULE_STRING
            {
            lv_startSeq_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartition_MultiLineRule2520); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,27,FOLLOW_27_in_rulePartition_MultiLineRule2537); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getPartition_MultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_3());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1084:1: ( (lv_endSeq_4_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1085:1: (lv_endSeq_4_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1085:1: (lv_endSeq_4_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1086:3: lv_endSeq_4_0= RULE_STRING
            {
            lv_endSeq_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartition_MultiLineRule2554); if (state.failed) return current;
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

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1102:2: (otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==28) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1102:4: otherlv_5= 'escaped' otherlv_6= 'by' ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,28,FOLLOW_28_in_rulePartition_MultiLineRule2572); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getPartition_MultiLineRuleAccess().getEscapedKeyword_5_0());
                          
                    }
                    otherlv_6=(Token)match(input,29,FOLLOW_29_in_rulePartition_MultiLineRule2584); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getPartition_MultiLineRuleAccess().getByKeyword_5_1());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1110:1: ( (lv_escapeSeq_7_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1111:1: (lv_escapeSeq_7_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1111:1: (lv_escapeSeq_7_0= RULE_STRING )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1112:3: lv_escapeSeq_7_0= RULE_STRING
                    {
                    lv_escapeSeq_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePartition_MultiLineRule2601); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1136:1: entryRuleLexicalHighlighting returns [EObject current=null] : iv_ruleLexicalHighlighting= ruleLexicalHighlighting EOF ;
    public final EObject entryRuleLexicalHighlighting() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLexicalHighlighting = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1137:2: (iv_ruleLexicalHighlighting= ruleLexicalHighlighting EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1138:2: iv_ruleLexicalHighlighting= ruleLexicalHighlighting EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLexicalHighlightingRule()); 
            }
            pushFollow(FOLLOW_ruleLexicalHighlighting_in_entryRuleLexicalHighlighting2644);
            iv_ruleLexicalHighlighting=ruleLexicalHighlighting();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLexicalHighlighting; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexicalHighlighting2654); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1145:1: ruleLexicalHighlighting returns [EObject current=null] : (otherlv_0= 'lexical_highlighting' otherlv_1= '{' ( (lv_list_2_0= ruleLexicalPartitionHighlighting ) )+ otherlv_3= '}' ) ;
    public final EObject ruleLexicalHighlighting() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_list_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1148:28: ( (otherlv_0= 'lexical_highlighting' otherlv_1= '{' ( (lv_list_2_0= ruleLexicalPartitionHighlighting ) )+ otherlv_3= '}' ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1149:1: (otherlv_0= 'lexical_highlighting' otherlv_1= '{' ( (lv_list_2_0= ruleLexicalPartitionHighlighting ) )+ otherlv_3= '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1149:1: (otherlv_0= 'lexical_highlighting' otherlv_1= '{' ( (lv_list_2_0= ruleLexicalPartitionHighlighting ) )+ otherlv_3= '}' )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1149:3: otherlv_0= 'lexical_highlighting' otherlv_1= '{' ( (lv_list_2_0= ruleLexicalPartitionHighlighting ) )+ otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleLexicalHighlighting2691); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLexicalHighlightingAccess().getLexical_highlightingKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleLexicalHighlighting2703); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLexicalHighlightingAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1157:1: ( (lv_list_2_0= ruleLexicalPartitionHighlighting ) )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=24 && LA18_0<=25)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1158:1: (lv_list_2_0= ruleLexicalPartitionHighlighting )
            	    {
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1158:1: (lv_list_2_0= ruleLexicalPartitionHighlighting )
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1159:3: lv_list_2_0= ruleLexicalPartitionHighlighting
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLexicalHighlightingAccess().getListLexicalPartitionHighlightingParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_in_ruleLexicalHighlighting2724);
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
            	    if ( cnt18 >= 1 ) break loop18;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);

            otherlv_3=(Token)match(input,16,FOLLOW_16_in_ruleLexicalHighlighting2737); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1187:1: entryRuleLexicalPartitionHighlighting returns [EObject current=null] : iv_ruleLexicalPartitionHighlighting= ruleLexicalPartitionHighlighting EOF ;
    public final EObject entryRuleLexicalPartitionHighlighting() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLexicalPartitionHighlighting = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1188:2: (iv_ruleLexicalPartitionHighlighting= ruleLexicalPartitionHighlighting EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1189:2: iv_ruleLexicalPartitionHighlighting= ruleLexicalPartitionHighlighting EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLexicalPartitionHighlightingRule()); 
            }
            pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_in_entryRuleLexicalPartitionHighlighting2773);
            iv_ruleLexicalPartitionHighlighting=ruleLexicalPartitionHighlighting();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLexicalPartitionHighlighting; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting2783); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1196:1: ruleLexicalPartitionHighlighting returns [EObject current=null] : (this_LexicalPartitionHighlighting_Rule_0= ruleLexicalPartitionHighlighting_Rule | this_LexicalPartitionHighlighting_JS_1= ruleLexicalPartitionHighlighting_JS ) ;
    public final EObject ruleLexicalPartitionHighlighting() throws RecognitionException {
        EObject current = null;

        EObject this_LexicalPartitionHighlighting_Rule_0 = null;

        EObject this_LexicalPartitionHighlighting_JS_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1199:28: ( (this_LexicalPartitionHighlighting_Rule_0= ruleLexicalPartitionHighlighting_Rule | this_LexicalPartitionHighlighting_JS_1= ruleLexicalPartitionHighlighting_JS ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1200:1: (this_LexicalPartitionHighlighting_Rule_0= ruleLexicalPartitionHighlighting_Rule | this_LexicalPartitionHighlighting_JS_1= ruleLexicalPartitionHighlighting_JS )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1200:1: (this_LexicalPartitionHighlighting_Rule_0= ruleLexicalPartitionHighlighting_Rule | this_LexicalPartitionHighlighting_JS_1= ruleLexicalPartitionHighlighting_JS )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==25) ) {
                alt19=1;
            }
            else if ( (LA19_0==24) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1201:5: this_LexicalPartitionHighlighting_Rule_0= ruleLexicalPartitionHighlighting_Rule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLexicalPartitionHighlightingAccess().getLexicalPartitionHighlighting_RuleParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_Rule_in_ruleLexicalPartitionHighlighting2830);
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1211:5: this_LexicalPartitionHighlighting_JS_1= ruleLexicalPartitionHighlighting_JS
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLexicalPartitionHighlightingAccess().getLexicalPartitionHighlighting_JSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_JS_in_ruleLexicalPartitionHighlighting2857);
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1227:1: entryRuleLexicalPartitionHighlighting_JS returns [EObject current=null] : iv_ruleLexicalPartitionHighlighting_JS= ruleLexicalPartitionHighlighting_JS EOF ;
    public final EObject entryRuleLexicalPartitionHighlighting_JS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLexicalPartitionHighlighting_JS = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1228:2: (iv_ruleLexicalPartitionHighlighting_JS= ruleLexicalPartitionHighlighting_JS EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1229:2: iv_ruleLexicalPartitionHighlighting_JS= ruleLexicalPartitionHighlighting_JS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLexicalPartitionHighlighting_JSRule()); 
            }
            pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_JS_in_entryRuleLexicalPartitionHighlighting_JS2892);
            iv_ruleLexicalPartitionHighlighting_JS=ruleLexicalPartitionHighlighting_JS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLexicalPartitionHighlighting_JS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting_JS2902); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1236:1: ruleLexicalPartitionHighlighting_JS returns [EObject current=null] : (otherlv_0= 'script' ( (otherlv_1= RULE_ID ) ) ( (lv_scriptURI_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleLexicalPartitionHighlighting_JS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_scriptURI_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1239:28: ( (otherlv_0= 'script' ( (otherlv_1= RULE_ID ) ) ( (lv_scriptURI_2_0= RULE_STRING ) ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1240:1: (otherlv_0= 'script' ( (otherlv_1= RULE_ID ) ) ( (lv_scriptURI_2_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1240:1: (otherlv_0= 'script' ( (otherlv_1= RULE_ID ) ) ( (lv_scriptURI_2_0= RULE_STRING ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1240:3: otherlv_0= 'script' ( (otherlv_1= RULE_ID ) ) ( (lv_scriptURI_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleLexicalPartitionHighlighting_JS2939); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLexicalPartitionHighlighting_JSAccess().getScriptKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1244:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1245:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1245:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1246:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getLexicalPartitionHighlighting_JSRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLexicalPartitionHighlighting_JS2959); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getLexicalPartitionHighlighting_JSAccess().getPartitionPartitionCrossReference_1_0()); 
              	
            }

            }


            }

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1257:2: ( (lv_scriptURI_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1258:1: (lv_scriptURI_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1258:1: (lv_scriptURI_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1259:3: lv_scriptURI_2_0= RULE_STRING
            {
            lv_scriptURI_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLexicalPartitionHighlighting_JS2976); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1283:1: entryRuleLexicalPartitionHighlighting_Rule returns [EObject current=null] : iv_ruleLexicalPartitionHighlighting_Rule= ruleLexicalPartitionHighlighting_Rule EOF ;
    public final EObject entryRuleLexicalPartitionHighlighting_Rule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLexicalPartitionHighlighting_Rule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1284:2: (iv_ruleLexicalPartitionHighlighting_Rule= ruleLexicalPartitionHighlighting_Rule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1285:2: iv_ruleLexicalPartitionHighlighting_Rule= ruleLexicalPartitionHighlighting_Rule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLexicalPartitionHighlighting_RuleRule()); 
            }
            pushFollow(FOLLOW_ruleLexicalPartitionHighlighting_Rule_in_entryRuleLexicalPartitionHighlighting_Rule3017);
            iv_ruleLexicalPartitionHighlighting_Rule=ruleLexicalPartitionHighlighting_Rule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLexicalPartitionHighlighting_Rule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting_Rule3027); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1292:1: ruleLexicalPartitionHighlighting_Rule returns [EObject current=null] : (otherlv_0= 'rule' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_tokenList_3_0= ruleToken ) )+ otherlv_4= '}' ) ;
    public final EObject ruleLexicalPartitionHighlighting_Rule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_tokenList_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1295:28: ( (otherlv_0= 'rule' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_tokenList_3_0= ruleToken ) )+ otherlv_4= '}' ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1296:1: (otherlv_0= 'rule' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_tokenList_3_0= ruleToken ) )+ otherlv_4= '}' )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1296:1: (otherlv_0= 'rule' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_tokenList_3_0= ruleToken ) )+ otherlv_4= '}' )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1296:3: otherlv_0= 'rule' ( (otherlv_1= RULE_ID ) ) otherlv_2= '{' ( (lv_tokenList_3_0= ruleToken ) )+ otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleLexicalPartitionHighlighting_Rule3064); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getRuleKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1300:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1301:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1301:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1302:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getLexicalPartitionHighlighting_RuleRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLexicalPartitionHighlighting_Rule3084); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getPartitionPartitionCrossReference_1_0()); 
              	
            }

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleLexicalPartitionHighlighting_Rule3096); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1317:1: ( (lv_tokenList_3_0= ruleToken ) )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_ID||LA20_0==32) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1318:1: (lv_tokenList_3_0= ruleToken )
            	    {
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1318:1: (lv_tokenList_3_0= ruleToken )
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1319:3: lv_tokenList_3_0= ruleToken
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getTokenListTokenParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleToken_in_ruleLexicalPartitionHighlighting_Rule3117);
            	    lv_tokenList_3_0=ruleToken();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getLexicalPartitionHighlighting_RuleRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"tokenList",
            	              		lv_tokenList_3_0, 
            	              		"Token");
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

            otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleLexicalPartitionHighlighting_Rule3130); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLexicalPartitionHighlighting_RuleAccess().getRightCurlyBracketKeyword_4());
                  
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1347:1: entryRuleToken returns [EObject current=null] : iv_ruleToken= ruleToken EOF ;
    public final EObject entryRuleToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleToken = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1348:2: (iv_ruleToken= ruleToken EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1349:2: iv_ruleToken= ruleToken EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTokenRule()); 
            }
            pushFollow(FOLLOW_ruleToken_in_entryRuleToken3166);
            iv_ruleToken=ruleToken();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleToken; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleToken3176); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1356:1: ruleToken returns [EObject current=null] : ( ( (lv_default_0_0= 'default' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_scannerList_3_0= ruleScanner ) )+ otherlv_4= '}' )? ) ;
    public final EObject ruleToken() throws RecognitionException {
        EObject current = null;

        Token lv_default_0_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_scannerList_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1359:28: ( ( ( (lv_default_0_0= 'default' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_scannerList_3_0= ruleScanner ) )+ otherlv_4= '}' )? ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1360:1: ( ( (lv_default_0_0= 'default' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_scannerList_3_0= ruleScanner ) )+ otherlv_4= '}' )? )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1360:1: ( ( (lv_default_0_0= 'default' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_scannerList_3_0= ruleScanner ) )+ otherlv_4= '}' )? )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1360:2: ( (lv_default_0_0= 'default' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_scannerList_3_0= ruleScanner ) )+ otherlv_4= '}' )?
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1360:2: ( (lv_default_0_0= 'default' ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==32) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1361:1: (lv_default_0_0= 'default' )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1361:1: (lv_default_0_0= 'default' )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1362:3: lv_default_0_0= 'default'
                    {
                    lv_default_0_0=(Token)match(input,32,FOLLOW_32_in_ruleToken3219); if (state.failed) return current;
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

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1375:3: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1376:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1376:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1377:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleToken3250); if (state.failed) return current;
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

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1393:2: (otherlv_2= '{' ( (lv_scannerList_3_0= ruleScanner ) )+ otherlv_4= '}' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==15) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1393:4: otherlv_2= '{' ( (lv_scannerList_3_0= ruleScanner ) )+ otherlv_4= '}'
                    {
                    otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleToken3268); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getTokenAccess().getLeftCurlyBracketKeyword_2_0());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1397:1: ( (lv_scannerList_3_0= ruleScanner ) )+
                    int cnt22=0;
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==24||LA22_0==26||LA22_0==30||LA22_0==33||(LA22_0>=38 && LA22_0<=39)) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1398:1: (lv_scannerList_3_0= ruleScanner )
                    	    {
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1398:1: (lv_scannerList_3_0= ruleScanner )
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1399:3: lv_scannerList_3_0= ruleScanner
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getTokenAccess().getScannerListScannerParserRuleCall_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleScanner_in_ruleToken3289);
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
                    	    if ( cnt22 >= 1 ) break loop22;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(22, input);
                                throw eee;
                        }
                        cnt22++;
                    } while (true);

                    otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleToken3302); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1427:1: entryRuleScanner returns [EObject current=null] : iv_ruleScanner= ruleScanner EOF ;
    public final EObject entryRuleScanner() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1428:2: (iv_ruleScanner= ruleScanner EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1429:2: iv_ruleScanner= ruleScanner EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScannerRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_in_entryRuleScanner3340);
            iv_ruleScanner=ruleScanner();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner3350); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1436:1: ruleScanner returns [EObject current=null] : (this_Scanner_Keyword_0= ruleScanner_Keyword | this_Scanner_Rule_1= ruleScanner_Rule ) ;
    public final EObject ruleScanner() throws RecognitionException {
        EObject current = null;

        EObject this_Scanner_Keyword_0 = null;

        EObject this_Scanner_Rule_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1439:28: ( (this_Scanner_Keyword_0= ruleScanner_Keyword | this_Scanner_Rule_1= ruleScanner_Rule ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1440:1: (this_Scanner_Keyword_0= ruleScanner_Keyword | this_Scanner_Rule_1= ruleScanner_Rule )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1440:1: (this_Scanner_Keyword_0= ruleScanner_Keyword | this_Scanner_Rule_1= ruleScanner_Rule )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==33) ) {
                alt24=1;
            }
            else if ( (LA24_0==24||LA24_0==26||LA24_0==30||(LA24_0>=38 && LA24_0<=39)) ) {
                alt24=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1441:5: this_Scanner_Keyword_0= ruleScanner_Keyword
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getScannerAccess().getScanner_KeywordParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleScanner_Keyword_in_ruleScanner3397);
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1451:5: this_Scanner_Rule_1= ruleScanner_Rule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getScannerAccess().getScanner_RuleParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleScanner_Rule_in_ruleScanner3424);
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1467:1: entryRuleScanner_Keyword returns [EObject current=null] : iv_ruleScanner_Keyword= ruleScanner_Keyword EOF ;
    public final EObject entryRuleScanner_Keyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner_Keyword = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1468:2: (iv_ruleScanner_Keyword= ruleScanner_Keyword EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1469:2: iv_ruleScanner_Keyword= ruleScanner_Keyword EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScanner_KeywordRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_Keyword_in_entryRuleScanner_Keyword3459);
            iv_ruleScanner_Keyword=ruleScanner_Keyword();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner_Keyword; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_Keyword3469); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1476:1: ruleScanner_Keyword returns [EObject current=null] : (otherlv_0= 'keywords' otherlv_1= '[' ( (lv_keywords_2_0= ruleKeyword ) ) (otherlv_3= ',' ( (lv_keywords_4_0= ruleKeyword ) ) )* otherlv_5= ']' ) ;
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
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1479:28: ( (otherlv_0= 'keywords' otherlv_1= '[' ( (lv_keywords_2_0= ruleKeyword ) ) (otherlv_3= ',' ( (lv_keywords_4_0= ruleKeyword ) ) )* otherlv_5= ']' ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1480:1: (otherlv_0= 'keywords' otherlv_1= '[' ( (lv_keywords_2_0= ruleKeyword ) ) (otherlv_3= ',' ( (lv_keywords_4_0= ruleKeyword ) ) )* otherlv_5= ']' )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1480:1: (otherlv_0= 'keywords' otherlv_1= '[' ( (lv_keywords_2_0= ruleKeyword ) ) (otherlv_3= ',' ( (lv_keywords_4_0= ruleKeyword ) ) )* otherlv_5= ']' )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1480:3: otherlv_0= 'keywords' otherlv_1= '[' ( (lv_keywords_2_0= ruleKeyword ) ) (otherlv_3= ',' ( (lv_keywords_4_0= ruleKeyword ) ) )* otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_33_in_ruleScanner_Keyword3506); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getScanner_KeywordAccess().getKeywordsKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,34,FOLLOW_34_in_ruleScanner_Keyword3518); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getScanner_KeywordAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1488:1: ( (lv_keywords_2_0= ruleKeyword ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1489:1: (lv_keywords_2_0= ruleKeyword )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1489:1: (lv_keywords_2_0= ruleKeyword )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1490:3: lv_keywords_2_0= ruleKeyword
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getScanner_KeywordAccess().getKeywordsKeywordParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleKeyword_in_ruleScanner_Keyword3539);
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

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1506:2: (otherlv_3= ',' ( (lv_keywords_4_0= ruleKeyword ) ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==35) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1506:4: otherlv_3= ',' ( (lv_keywords_4_0= ruleKeyword ) )
            	    {
            	    otherlv_3=(Token)match(input,35,FOLLOW_35_in_ruleScanner_Keyword3552); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getScanner_KeywordAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1510:1: ( (lv_keywords_4_0= ruleKeyword ) )
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1511:1: (lv_keywords_4_0= ruleKeyword )
            	    {
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1511:1: (lv_keywords_4_0= ruleKeyword )
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1512:3: lv_keywords_4_0= ruleKeyword
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getScanner_KeywordAccess().getKeywordsKeywordParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleKeyword_in_ruleScanner_Keyword3573);
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
            	    break loop25;
                }
            } while (true);

            otherlv_5=(Token)match(input,36,FOLLOW_36_in_ruleScanner_Keyword3587); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1540:1: entryRuleKeyword returns [EObject current=null] : iv_ruleKeyword= ruleKeyword EOF ;
    public final EObject entryRuleKeyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyword = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1541:2: (iv_ruleKeyword= ruleKeyword EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1542:2: iv_ruleKeyword= ruleKeyword EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getKeywordRule()); 
            }
            pushFollow(FOLLOW_ruleKeyword_in_entryRuleKeyword3623);
            iv_ruleKeyword=ruleKeyword();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleKeyword; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyword3633); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1549:1: ruleKeyword returns [EObject current=null] : ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_version_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1552:28: ( ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1553:1: ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1553:1: ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1553:2: ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )?
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1553:2: ( (lv_name_0_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1554:1: (lv_name_0_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1554:1: (lv_name_0_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1555:3: lv_name_0_0= RULE_STRING
            {
            lv_name_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword3675); if (state.failed) return current;
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

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1571:2: (otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==37) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1571:4: otherlv_1= 'since' ( (lv_version_2_0= RULE_STRING ) )
                    {
                    otherlv_1=(Token)match(input,37,FOLLOW_37_in_ruleKeyword3693); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getKeywordAccess().getSinceKeyword_1_0());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1575:1: ( (lv_version_2_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1576:1: (lv_version_2_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1576:1: (lv_version_2_0= RULE_STRING )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1577:3: lv_version_2_0= RULE_STRING
                    {
                    lv_version_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword3710); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1601:1: entryRuleScanner_Rule returns [EObject current=null] : iv_ruleScanner_Rule= ruleScanner_Rule EOF ;
    public final EObject entryRuleScanner_Rule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner_Rule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1602:2: (iv_ruleScanner_Rule= ruleScanner_Rule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1603:2: iv_ruleScanner_Rule= ruleScanner_Rule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScanner_RuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_Rule_in_entryRuleScanner_Rule3753);
            iv_ruleScanner_Rule=ruleScanner_Rule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner_Rule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_Rule3763); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1610:1: ruleScanner_Rule returns [EObject current=null] : (this_Scanner_SingleLineRule_0= ruleScanner_SingleLineRule | this_Scanner_MultiLineRule_1= ruleScanner_MultiLineRule | this_Scanner_CharacterRule_2= ruleScanner_CharacterRule | this_Scanner_JSRule_3= ruleScanner_JSRule | this_Scanner_WhitespaceRule_4= ruleScanner_WhitespaceRule ) ;
    public final EObject ruleScanner_Rule() throws RecognitionException {
        EObject current = null;

        EObject this_Scanner_SingleLineRule_0 = null;

        EObject this_Scanner_MultiLineRule_1 = null;

        EObject this_Scanner_CharacterRule_2 = null;

        EObject this_Scanner_JSRule_3 = null;

        EObject this_Scanner_WhitespaceRule_4 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1613:28: ( (this_Scanner_SingleLineRule_0= ruleScanner_SingleLineRule | this_Scanner_MultiLineRule_1= ruleScanner_MultiLineRule | this_Scanner_CharacterRule_2= ruleScanner_CharacterRule | this_Scanner_JSRule_3= ruleScanner_JSRule | this_Scanner_WhitespaceRule_4= ruleScanner_WhitespaceRule ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1614:1: (this_Scanner_SingleLineRule_0= ruleScanner_SingleLineRule | this_Scanner_MultiLineRule_1= ruleScanner_MultiLineRule | this_Scanner_CharacterRule_2= ruleScanner_CharacterRule | this_Scanner_JSRule_3= ruleScanner_JSRule | this_Scanner_WhitespaceRule_4= ruleScanner_WhitespaceRule )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1614:1: (this_Scanner_SingleLineRule_0= ruleScanner_SingleLineRule | this_Scanner_MultiLineRule_1= ruleScanner_MultiLineRule | this_Scanner_CharacterRule_2= ruleScanner_CharacterRule | this_Scanner_JSRule_3= ruleScanner_JSRule | this_Scanner_WhitespaceRule_4= ruleScanner_WhitespaceRule )
            int alt27=5;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt27=1;
                }
                break;
            case 30:
                {
                alt27=2;
                }
                break;
            case 38:
                {
                alt27=3;
                }
                break;
            case 24:
                {
                alt27=4;
                }
                break;
            case 39:
                {
                alt27=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1615:5: this_Scanner_SingleLineRule_0= ruleScanner_SingleLineRule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getScanner_RuleAccess().getScanner_SingleLineRuleParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleScanner_SingleLineRule_in_ruleScanner_Rule3810);
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1625:5: this_Scanner_MultiLineRule_1= ruleScanner_MultiLineRule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getScanner_RuleAccess().getScanner_MultiLineRuleParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleScanner_MultiLineRule_in_ruleScanner_Rule3837);
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1635:5: this_Scanner_CharacterRule_2= ruleScanner_CharacterRule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getScanner_RuleAccess().getScanner_CharacterRuleParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleScanner_CharacterRule_in_ruleScanner_Rule3864);
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1645:5: this_Scanner_JSRule_3= ruleScanner_JSRule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getScanner_RuleAccess().getScanner_JSRuleParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleScanner_JSRule_in_ruleScanner_Rule3891);
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
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1655:5: this_Scanner_WhitespaceRule_4= ruleScanner_WhitespaceRule
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getScanner_RuleAccess().getScanner_WhitespaceRuleParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleScanner_WhitespaceRule_in_ruleScanner_Rule3918);
                    this_Scanner_WhitespaceRule_4=ruleScanner_WhitespaceRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Scanner_WhitespaceRule_4; 
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1671:1: entryRuleScanner_SingleLineRule returns [EObject current=null] : iv_ruleScanner_SingleLineRule= ruleScanner_SingleLineRule EOF ;
    public final EObject entryRuleScanner_SingleLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner_SingleLineRule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1672:2: (iv_ruleScanner_SingleLineRule= ruleScanner_SingleLineRule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1673:2: iv_ruleScanner_SingleLineRule= ruleScanner_SingleLineRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScanner_SingleLineRuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_SingleLineRule_in_entryRuleScanner_SingleLineRule3953);
            iv_ruleScanner_SingleLineRule=ruleScanner_SingleLineRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner_SingleLineRule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_SingleLineRule3963); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1680:1: ruleScanner_SingleLineRule returns [EObject current=null] : (otherlv_0= 'single_line' ( (lv_startSeq_1_0= RULE_STRING ) ) otherlv_2= '=>' ( (lv_endSeq_3_0= RULE_STRING ) )? (otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) ) )? ) ;
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
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1683:28: ( (otherlv_0= 'single_line' ( (lv_startSeq_1_0= RULE_STRING ) ) otherlv_2= '=>' ( (lv_endSeq_3_0= RULE_STRING ) )? (otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1684:1: (otherlv_0= 'single_line' ( (lv_startSeq_1_0= RULE_STRING ) ) otherlv_2= '=>' ( (lv_endSeq_3_0= RULE_STRING ) )? (otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1684:1: (otherlv_0= 'single_line' ( (lv_startSeq_1_0= RULE_STRING ) ) otherlv_2= '=>' ( (lv_endSeq_3_0= RULE_STRING ) )? (otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1684:3: otherlv_0= 'single_line' ( (lv_startSeq_1_0= RULE_STRING ) ) otherlv_2= '=>' ( (lv_endSeq_3_0= RULE_STRING ) )? (otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,26,FOLLOW_26_in_ruleScanner_SingleLineRule4000); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getScanner_SingleLineRuleAccess().getSingle_lineKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1688:1: ( (lv_startSeq_1_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1689:1: (lv_startSeq_1_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1689:1: (lv_startSeq_1_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1690:3: lv_startSeq_1_0= RULE_STRING
            {
            lv_startSeq_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_SingleLineRule4017); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,27,FOLLOW_27_in_ruleScanner_SingleLineRule4034); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getScanner_SingleLineRuleAccess().getEqualsSignGreaterThanSignKeyword_2());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1710:1: ( (lv_endSeq_3_0= RULE_STRING ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_STRING) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1711:1: (lv_endSeq_3_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1711:1: (lv_endSeq_3_0= RULE_STRING )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1712:3: lv_endSeq_3_0= RULE_STRING
                    {
                    lv_endSeq_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_SingleLineRule4051); if (state.failed) return current;
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

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1728:3: (otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==28) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1728:5: otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,28,FOLLOW_28_in_ruleScanner_SingleLineRule4070); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getScanner_SingleLineRuleAccess().getEscapedKeyword_4_0());
                          
                    }
                    otherlv_5=(Token)match(input,29,FOLLOW_29_in_ruleScanner_SingleLineRule4082); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getScanner_SingleLineRuleAccess().getByKeyword_4_1());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1736:1: ( (lv_escapeSeq_6_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1737:1: (lv_escapeSeq_6_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1737:1: (lv_escapeSeq_6_0= RULE_STRING )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1738:3: lv_escapeSeq_6_0= RULE_STRING
                    {
                    lv_escapeSeq_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_SingleLineRule4099); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1762:1: entryRuleScanner_MultiLineRule returns [EObject current=null] : iv_ruleScanner_MultiLineRule= ruleScanner_MultiLineRule EOF ;
    public final EObject entryRuleScanner_MultiLineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner_MultiLineRule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1763:2: (iv_ruleScanner_MultiLineRule= ruleScanner_MultiLineRule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1764:2: iv_ruleScanner_MultiLineRule= ruleScanner_MultiLineRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScanner_MultiLineRuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_MultiLineRule_in_entryRuleScanner_MultiLineRule4142);
            iv_ruleScanner_MultiLineRule=ruleScanner_MultiLineRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner_MultiLineRule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_MultiLineRule4152); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1771:1: ruleScanner_MultiLineRule returns [EObject current=null] : (otherlv_0= 'multi_line' ( (lv_startSeq_1_0= RULE_STRING ) ) otherlv_2= '=>' ( (lv_endSeq_3_0= RULE_STRING ) ) (otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) ) )? ) ;
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
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1774:28: ( (otherlv_0= 'multi_line' ( (lv_startSeq_1_0= RULE_STRING ) ) otherlv_2= '=>' ( (lv_endSeq_3_0= RULE_STRING ) ) (otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) ) )? ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1775:1: (otherlv_0= 'multi_line' ( (lv_startSeq_1_0= RULE_STRING ) ) otherlv_2= '=>' ( (lv_endSeq_3_0= RULE_STRING ) ) (otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) ) )? )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1775:1: (otherlv_0= 'multi_line' ( (lv_startSeq_1_0= RULE_STRING ) ) otherlv_2= '=>' ( (lv_endSeq_3_0= RULE_STRING ) ) (otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) ) )? )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1775:3: otherlv_0= 'multi_line' ( (lv_startSeq_1_0= RULE_STRING ) ) otherlv_2= '=>' ( (lv_endSeq_3_0= RULE_STRING ) ) (otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleScanner_MultiLineRule4189); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getScanner_MultiLineRuleAccess().getMulti_lineKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1779:1: ( (lv_startSeq_1_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1780:1: (lv_startSeq_1_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1780:1: (lv_startSeq_1_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1781:3: lv_startSeq_1_0= RULE_STRING
            {
            lv_startSeq_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_MultiLineRule4206); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,27,FOLLOW_27_in_ruleScanner_MultiLineRule4223); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getScanner_MultiLineRuleAccess().getEqualsSignGreaterThanSignKeyword_2());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1801:1: ( (lv_endSeq_3_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1802:1: (lv_endSeq_3_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1802:1: (lv_endSeq_3_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1803:3: lv_endSeq_3_0= RULE_STRING
            {
            lv_endSeq_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_MultiLineRule4240); if (state.failed) return current;
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

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1819:2: (otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==28) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1819:4: otherlv_4= 'escaped' otherlv_5= 'by' ( (lv_escapeSeq_6_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,28,FOLLOW_28_in_ruleScanner_MultiLineRule4258); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getScanner_MultiLineRuleAccess().getEscapedKeyword_4_0());
                          
                    }
                    otherlv_5=(Token)match(input,29,FOLLOW_29_in_ruleScanner_MultiLineRule4270); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getScanner_MultiLineRuleAccess().getByKeyword_4_1());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1827:1: ( (lv_escapeSeq_6_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1828:1: (lv_escapeSeq_6_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1828:1: (lv_escapeSeq_6_0= RULE_STRING )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1829:3: lv_escapeSeq_6_0= RULE_STRING
                    {
                    lv_escapeSeq_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_MultiLineRule4287); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1853:1: entryRuleScanner_CharacterRule returns [EObject current=null] : iv_ruleScanner_CharacterRule= ruleScanner_CharacterRule EOF ;
    public final EObject entryRuleScanner_CharacterRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner_CharacterRule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1854:2: (iv_ruleScanner_CharacterRule= ruleScanner_CharacterRule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1855:2: iv_ruleScanner_CharacterRule= ruleScanner_CharacterRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScanner_CharacterRuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_CharacterRule_in_entryRuleScanner_CharacterRule4330);
            iv_ruleScanner_CharacterRule=ruleScanner_CharacterRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner_CharacterRule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_CharacterRule4340); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1862:1: ruleScanner_CharacterRule returns [EObject current=null] : (otherlv_0= 'character' otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' ) ;
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
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1865:28: ( (otherlv_0= 'character' otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1866:1: (otherlv_0= 'character' otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1866:1: (otherlv_0= 'character' otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1866:3: otherlv_0= 'character' otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_38_in_ruleScanner_CharacterRule4377); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getScanner_CharacterRuleAccess().getCharacterKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,34,FOLLOW_34_in_ruleScanner_CharacterRule4389); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getScanner_CharacterRuleAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1874:1: ( (lv_characters_2_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1875:1: (lv_characters_2_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1875:1: (lv_characters_2_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1876:3: lv_characters_2_0= RULE_STRING
            {
            lv_characters_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_CharacterRule4406); if (state.failed) return current;
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

            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1892:2: (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==35) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1892:4: otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) )
            	    {
            	    otherlv_3=(Token)match(input,35,FOLLOW_35_in_ruleScanner_CharacterRule4424); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getScanner_CharacterRuleAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1896:1: ( (lv_characters_4_0= RULE_STRING ) )
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1897:1: (lv_characters_4_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1897:1: (lv_characters_4_0= RULE_STRING )
            	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1898:3: lv_characters_4_0= RULE_STRING
            	    {
            	    lv_characters_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_CharacterRule4441); if (state.failed) return current;
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
            	    break loop31;
                }
            } while (true);

            otherlv_5=(Token)match(input,36,FOLLOW_36_in_ruleScanner_CharacterRule4460); if (state.failed) return current;
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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1926:1: entryRuleScanner_JSRule returns [EObject current=null] : iv_ruleScanner_JSRule= ruleScanner_JSRule EOF ;
    public final EObject entryRuleScanner_JSRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner_JSRule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1927:2: (iv_ruleScanner_JSRule= ruleScanner_JSRule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1928:2: iv_ruleScanner_JSRule= ruleScanner_JSRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScanner_JSRuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_JSRule_in_entryRuleScanner_JSRule4496);
            iv_ruleScanner_JSRule=ruleScanner_JSRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner_JSRule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_JSRule4506); if (state.failed) return current;

            }

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
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1935:1: ruleScanner_JSRule returns [EObject current=null] : (otherlv_0= 'script' ( (lv_fileURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleScanner_JSRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_fileURI_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1938:28: ( (otherlv_0= 'script' ( (lv_fileURI_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1939:1: (otherlv_0= 'script' ( (lv_fileURI_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1939:1: (otherlv_0= 'script' ( (lv_fileURI_1_0= RULE_STRING ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1939:3: otherlv_0= 'script' ( (lv_fileURI_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleScanner_JSRule4543); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getScanner_JSRuleAccess().getScriptKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1943:1: ( (lv_fileURI_1_0= RULE_STRING ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1944:1: (lv_fileURI_1_0= RULE_STRING )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1944:1: (lv_fileURI_1_0= RULE_STRING )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1945:3: lv_fileURI_1_0= RULE_STRING
            {
            lv_fileURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_JSRule4560); if (state.failed) return current;
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


    // $ANTLR start "entryRuleScanner_WhitespaceRule"
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1969:1: entryRuleScanner_WhitespaceRule returns [EObject current=null] : iv_ruleScanner_WhitespaceRule= ruleScanner_WhitespaceRule EOF ;
    public final EObject entryRuleScanner_WhitespaceRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScanner_WhitespaceRule = null;


        try {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1970:2: (iv_ruleScanner_WhitespaceRule= ruleScanner_WhitespaceRule EOF )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1971:2: iv_ruleScanner_WhitespaceRule= ruleScanner_WhitespaceRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScanner_WhitespaceRuleRule()); 
            }
            pushFollow(FOLLOW_ruleScanner_WhitespaceRule_in_entryRuleScanner_WhitespaceRule4601);
            iv_ruleScanner_WhitespaceRule=ruleScanner_WhitespaceRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScanner_WhitespaceRule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScanner_WhitespaceRule4611); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScanner_WhitespaceRule"


    // $ANTLR start "ruleScanner_WhitespaceRule"
    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1978:1: ruleScanner_WhitespaceRule returns [EObject current=null] : (otherlv_0= 'whitespace' ( (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' ) | ( (lv_javawhitespace_6_0= 'javawhitespace' ) ) | ( (lv_fileURI_7_0= RULE_STRING ) ) ) ) ;
    public final EObject ruleScanner_WhitespaceRule() throws RecognitionException {
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
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1981:28: ( (otherlv_0= 'whitespace' ( (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' ) | ( (lv_javawhitespace_6_0= 'javawhitespace' ) ) | ( (lv_fileURI_7_0= RULE_STRING ) ) ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1982:1: (otherlv_0= 'whitespace' ( (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' ) | ( (lv_javawhitespace_6_0= 'javawhitespace' ) ) | ( (lv_fileURI_7_0= RULE_STRING ) ) ) )
            {
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1982:1: (otherlv_0= 'whitespace' ( (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' ) | ( (lv_javawhitespace_6_0= 'javawhitespace' ) ) | ( (lv_fileURI_7_0= RULE_STRING ) ) ) )
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1982:3: otherlv_0= 'whitespace' ( (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' ) | ( (lv_javawhitespace_6_0= 'javawhitespace' ) ) | ( (lv_fileURI_7_0= RULE_STRING ) ) )
            {
            otherlv_0=(Token)match(input,39,FOLLOW_39_in_ruleScanner_WhitespaceRule4648); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getScanner_WhitespaceRuleAccess().getWhitespaceKeyword_0());
                  
            }
            // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1986:1: ( (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' ) | ( (lv_javawhitespace_6_0= 'javawhitespace' ) ) | ( (lv_fileURI_7_0= RULE_STRING ) ) )
            int alt33=3;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt33=1;
                }
                break;
            case 40:
                {
                alt33=2;
                }
                break;
            case RULE_STRING:
                {
                alt33=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1986:2: (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1986:2: (otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']' )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1986:4: otherlv_1= '[' ( (lv_characters_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )* otherlv_5= ']'
                    {
                    otherlv_1=(Token)match(input,34,FOLLOW_34_in_ruleScanner_WhitespaceRule4662); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getScanner_WhitespaceRuleAccess().getLeftSquareBracketKeyword_1_0_0());
                          
                    }
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1990:1: ( (lv_characters_2_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1991:1: (lv_characters_2_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1991:1: (lv_characters_2_0= RULE_STRING )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:1992:3: lv_characters_2_0= RULE_STRING
                    {
                    lv_characters_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_WhitespaceRule4679); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_characters_2_0, grammarAccess.getScanner_WhitespaceRuleAccess().getCharactersSTRINGTerminalRuleCall_1_0_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getScanner_WhitespaceRuleRule());
                      	        }
                             		addWithLastConsumed(
                             			current, 
                             			"characters",
                              		lv_characters_2_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2008:2: (otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) ) )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==35) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2008:4: otherlv_3= ',' ( (lv_characters_4_0= RULE_STRING ) )
                    	    {
                    	    otherlv_3=(Token)match(input,35,FOLLOW_35_in_ruleScanner_WhitespaceRule4697); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getScanner_WhitespaceRuleAccess().getCommaKeyword_1_0_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2012:1: ( (lv_characters_4_0= RULE_STRING ) )
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2013:1: (lv_characters_4_0= RULE_STRING )
                    	    {
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2013:1: (lv_characters_4_0= RULE_STRING )
                    	    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2014:3: lv_characters_4_0= RULE_STRING
                    	    {
                    	    lv_characters_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_WhitespaceRule4714); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      			newLeafNode(lv_characters_4_0, grammarAccess.getScanner_WhitespaceRuleAccess().getCharactersSTRINGTerminalRuleCall_1_0_2_1_0()); 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getScanner_WhitespaceRuleRule());
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
                    	    break loop32;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,36,FOLLOW_36_in_ruleScanner_WhitespaceRule4733); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getScanner_WhitespaceRuleAccess().getRightSquareBracketKeyword_1_0_3());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2035:6: ( (lv_javawhitespace_6_0= 'javawhitespace' ) )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2035:6: ( (lv_javawhitespace_6_0= 'javawhitespace' ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2036:1: (lv_javawhitespace_6_0= 'javawhitespace' )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2036:1: (lv_javawhitespace_6_0= 'javawhitespace' )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2037:3: lv_javawhitespace_6_0= 'javawhitespace'
                    {
                    lv_javawhitespace_6_0=(Token)match(input,40,FOLLOW_40_in_ruleScanner_WhitespaceRule4758); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_javawhitespace_6_0, grammarAccess.getScanner_WhitespaceRuleAccess().getJavawhitespaceJavawhitespaceKeyword_1_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getScanner_WhitespaceRuleRule());
                      	        }
                             		setWithLastConsumed(current, "javawhitespace", true, "javawhitespace");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2051:6: ( (lv_fileURI_7_0= RULE_STRING ) )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2051:6: ( (lv_fileURI_7_0= RULE_STRING ) )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2052:1: (lv_fileURI_7_0= RULE_STRING )
                    {
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2052:1: (lv_fileURI_7_0= RULE_STRING )
                    // ../org.eclipse.fx.code.editor.ldef/src-gen/org/eclipse/fx/code/editor/ldef/parser/antlr/internal/InternalLDef.g:2053:3: lv_fileURI_7_0= RULE_STRING
                    {
                    lv_fileURI_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScanner_WhitespaceRule4794); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_fileURI_7_0, grammarAccess.getScanner_WhitespaceRuleAccess().getFileURISTRINGTerminalRuleCall_1_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getScanner_WhitespaceRuleRule());
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
    // $ANTLR end "ruleScanner_WhitespaceRule"

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
    public static final BitSet FOLLOW_15_in_ruleIntegration951 = new BitSet(new long[]{0x0000000000240000L});
    public static final BitSet FOLLOW_ruleCodeIntegration_in_ruleIntegration972 = new BitSet(new long[]{0x0000000000250000L});
    public static final BitSet FOLLOW_16_in_ruleIntegration985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCodeIntegration_in_entryRuleCodeIntegration1021 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCodeIntegration1031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaFXIntegration_in_ruleCodeIntegration1078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSWTIntegration_in_ruleCodeIntegration1105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaFXIntegration_in_entryRuleJavaFXIntegration1140 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJavaFXIntegration1150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleJavaFXIntegration1187 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleJavaFXIntegration1199 = new BitSet(new long[]{0x0000000000190000L});
    public static final BitSet FOLLOW_19_in_ruleJavaFXIntegration1226 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_20_in_ruleJavaFXIntegration1258 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleJavaFXIntegration1284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSWTIntegration_in_entryRuleSWTIntegration1320 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSWTIntegration1330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleSWTIntegration1367 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSWTIntegration1379 = new BitSet(new long[]{0x0000000000190000L});
    public static final BitSet FOLLOW_19_in_ruleSWTIntegration1406 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_20_in_ruleSWTIntegration1438 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleSWTIntegration1464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParitioning_in_entryRuleParitioning1500 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParitioning1510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleParitioning1547 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleParitioning1559 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rulePartition_in_ruleParitioning1580 = new BitSet(new long[]{0x0000000003800000L});
    public static final BitSet FOLLOW_rulePartitioner_in_ruleParitioning1602 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleParitioning1614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_in_entryRulePartition1650 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartition1660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rulePartition1697 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePartition1714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitioner_in_entryRulePartitioner1755 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartitioner1765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitioner_Rule_in_rulePartitioner1812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParitioner_JS_in_rulePartitioner1839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParitioner_JS_in_entryRuleParitioner_JS1874 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParitioner_JS1884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleParitioner_JS1921 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleParitioner_JS1938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartitioner_Rule_in_entryRulePartitioner_Rule1979 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartitioner_Rule1989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rulePartitioner_Rule2026 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_rulePartitioner_Rule2038 = new BitSet(new long[]{0x0000000044000000L});
    public static final BitSet FOLLOW_rulePartition_Rule_in_rulePartitioner_Rule2059 = new BitSet(new long[]{0x0000000044010000L});
    public static final BitSet FOLLOW_16_in_rulePartitioner_Rule2072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_Rule_in_entryRulePartition_Rule2108 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartition_Rule2118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_SingleLineRule_in_rulePartition_Rule2165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_MultiLineRule_in_rulePartition_Rule2192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_SingleLineRule_in_entryRulePartition_SingleLineRule2227 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartition_SingleLineRule2237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rulePartition_SingleLineRule2274 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePartition_SingleLineRule2294 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartition_SingleLineRule2311 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_rulePartition_SingleLineRule2328 = new BitSet(new long[]{0x0000000010000022L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartition_SingleLineRule2345 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_rulePartition_SingleLineRule2364 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_rulePartition_SingleLineRule2376 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartition_SingleLineRule2393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartition_MultiLineRule_in_entryRulePartition_MultiLineRule2436 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartition_MultiLineRule2446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rulePartition_MultiLineRule2483 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePartition_MultiLineRule2503 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartition_MultiLineRule2520 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_rulePartition_MultiLineRule2537 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartition_MultiLineRule2554 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_rulePartition_MultiLineRule2572 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_rulePartition_MultiLineRule2584 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePartition_MultiLineRule2601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalHighlighting_in_entryRuleLexicalHighlighting2644 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexicalHighlighting2654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleLexicalHighlighting2691 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleLexicalHighlighting2703 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_in_ruleLexicalHighlighting2724 = new BitSet(new long[]{0x0000000003010000L});
    public static final BitSet FOLLOW_16_in_ruleLexicalHighlighting2737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_in_entryRuleLexicalPartitionHighlighting2773 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting2783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_Rule_in_ruleLexicalPartitionHighlighting2830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_JS_in_ruleLexicalPartitionHighlighting2857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_JS_in_entryRuleLexicalPartitionHighlighting_JS2892 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting_JS2902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleLexicalPartitionHighlighting_JS2939 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLexicalPartitionHighlighting_JS2959 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLexicalPartitionHighlighting_JS2976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexicalPartitionHighlighting_Rule_in_entryRuleLexicalPartitionHighlighting_Rule3017 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexicalPartitionHighlighting_Rule3027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleLexicalPartitionHighlighting_Rule3064 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLexicalPartitionHighlighting_Rule3084 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleLexicalPartitionHighlighting_Rule3096 = new BitSet(new long[]{0x0000000100000010L});
    public static final BitSet FOLLOW_ruleToken_in_ruleLexicalPartitionHighlighting_Rule3117 = new BitSet(new long[]{0x0000000100010010L});
    public static final BitSet FOLLOW_16_in_ruleLexicalPartitionHighlighting_Rule3130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleToken_in_entryRuleToken3166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleToken3176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleToken3219 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleToken3250 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleToken3268 = new BitSet(new long[]{0x000000C245000000L});
    public static final BitSet FOLLOW_ruleScanner_in_ruleToken3289 = new BitSet(new long[]{0x000000C245010000L});
    public static final BitSet FOLLOW_16_in_ruleToken3302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_in_entryRuleScanner3340 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner3350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_Keyword_in_ruleScanner3397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_Rule_in_ruleScanner3424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_Keyword_in_entryRuleScanner_Keyword3459 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_Keyword3469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleScanner_Keyword3506 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleScanner_Keyword3518 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleScanner_Keyword3539 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_35_in_ruleScanner_Keyword3552 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleScanner_Keyword3573 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_36_in_ruleScanner_Keyword3587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword3623 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyword3633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword3675 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_ruleKeyword3693 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword3710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_Rule_in_entryRuleScanner_Rule3753 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_Rule3763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_SingleLineRule_in_ruleScanner_Rule3810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_MultiLineRule_in_ruleScanner_Rule3837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_CharacterRule_in_ruleScanner_Rule3864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_JSRule_in_ruleScanner_Rule3891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_WhitespaceRule_in_ruleScanner_Rule3918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_SingleLineRule_in_entryRuleScanner_SingleLineRule3953 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_SingleLineRule3963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleScanner_SingleLineRule4000 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_SingleLineRule4017 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleScanner_SingleLineRule4034 = new BitSet(new long[]{0x0000000010000022L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_SingleLineRule4051 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_ruleScanner_SingleLineRule4070 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleScanner_SingleLineRule4082 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_SingleLineRule4099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_MultiLineRule_in_entryRuleScanner_MultiLineRule4142 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_MultiLineRule4152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleScanner_MultiLineRule4189 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_MultiLineRule4206 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleScanner_MultiLineRule4223 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_MultiLineRule4240 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_ruleScanner_MultiLineRule4258 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleScanner_MultiLineRule4270 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_MultiLineRule4287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_CharacterRule_in_entryRuleScanner_CharacterRule4330 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_CharacterRule4340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleScanner_CharacterRule4377 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleScanner_CharacterRule4389 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_CharacterRule4406 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_35_in_ruleScanner_CharacterRule4424 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_CharacterRule4441 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_36_in_ruleScanner_CharacterRule4460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_JSRule_in_entryRuleScanner_JSRule4496 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_JSRule4506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleScanner_JSRule4543 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_JSRule4560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScanner_WhitespaceRule_in_entryRuleScanner_WhitespaceRule4601 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScanner_WhitespaceRule4611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleScanner_WhitespaceRule4648 = new BitSet(new long[]{0x0000010400000020L});
    public static final BitSet FOLLOW_34_in_ruleScanner_WhitespaceRule4662 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_WhitespaceRule4679 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_35_in_ruleScanner_WhitespaceRule4697 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_WhitespaceRule4714 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_36_in_ruleScanner_WhitespaceRule4733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleScanner_WhitespaceRule4758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScanner_WhitespaceRule4794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_synpred1_InternalLDef395 = new BitSet(new long[]{0x0000000000000002L});

}