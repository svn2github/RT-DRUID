package com.eu.evidence.rtdruid.oil.xtext.parser.antlr.internal; 

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
import com.eu.evidence.rtdruid.oil.xtext.services.OilGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalOilParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_NON_ZERO_INT", "RULE_ZERO_INT", "RULE_HEX", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'OIL_VERSION'", "'='", "';'", "'IMPLEMENTATION'", "'{'", "'}'", "':'", "'CPU'", "'WITH_AUTO'", "'['", "'..'", "','", "']'", "'[]'", "'AUTO'", "'STRING'", "'UINT32'", "'INT32'", "'UINT64'", "'INT64'", "'FLOAT'", "'DOUBLE'", "'BOOLEAN'", "'ENUM'", "'OS'", "'ALARM'", "'APPMODE'", "'COUNTER'", "'COM'", "'EVENT'", "'IPDU'", "'ISR'", "'MESSAGE'", "'NETWORKMESSAGE'", "'NM'", "'RESOURCE'", "'TASK'", "'OS_TYPE'", "'ALARM_TYPE'", "'APPMODE_TYPE'", "'COUNTER_TYPE'", "'COM_TYPE'", "'EVENT_TYPE'", "'IPDU_TYPE'", "'ISR_TYPE'", "'MESSAGE_TYPE'", "'NETWORKMESSAGE_TYPE'", "'NM_TYPE'", "'RESOURCE_TYPE'", "'TASK_TYPE'", "'+'", "'-'", "'.'", "'APPLICATION'", "'APPLICATION_TYPE'"
    };
    public static final int RULE_ID=5;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__29=29;
    public static final int T__65=65;
    public static final int T__28=28;
    public static final int T__62=62;
    public static final int T__27=27;
    public static final int T__63=63;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__21=21;
    public static final int RULE_ZERO_INT=7;
    public static final int T__20=20;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__19=19;
    public static final int T__57=57;
    public static final int RULE_HEX=8;
    public static final int T__58=58;
    public static final int T__16=16;
    public static final int T__51=51;
    public static final int T__15=15;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__18=18;
    public static final int T__54=54;
    public static final int T__17=17;
    public static final int RULE_NON_ZERO_INT=6;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__59=59;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_SL_COMMENT=10;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=4;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=11;

    // delegates
    // delegators


        public InternalOilParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalOilParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalOilParser.tokenNames; }
    public String getGrammarFileName() { return "../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g"; }



     	private OilGrammarAccess grammarAccess;
     	
        public InternalOilParser(TokenStream input, OilGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "OilFile";	
       	}
       	
       	@Override
       	protected OilGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleOilFile"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:68:1: entryRuleOilFile returns [EObject current=null] : iv_ruleOilFile= ruleOilFile EOF ;
    public final EObject entryRuleOilFile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOilFile = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:69:2: (iv_ruleOilFile= ruleOilFile EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:70:2: iv_ruleOilFile= ruleOilFile EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOilFileRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOilFile_in_entryRuleOilFile75);
            iv_ruleOilFile=ruleOilFile();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOilFile; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOilFile85); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOilFile"


    // $ANTLR start "ruleOilFile"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:77:1: ruleOilFile returns [EObject current=null] : ( () (otherlv_1= 'OIL_VERSION' otherlv_2= '=' ( (lv_OilVersion_3_0= RULE_STRING ) ) otherlv_4= ';' )? ( (lv_Implementation_5_0= ruleOilImplementation ) )? ( (lv_Application_6_0= ruleOilApplication ) )? ) ;
    public final EObject ruleOilFile() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_OilVersion_3_0=null;
        Token otherlv_4=null;
        EObject lv_Implementation_5_0 = null;

        EObject lv_Application_6_0 = null;


         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:80:28: ( ( () (otherlv_1= 'OIL_VERSION' otherlv_2= '=' ( (lv_OilVersion_3_0= RULE_STRING ) ) otherlv_4= ';' )? ( (lv_Implementation_5_0= ruleOilImplementation ) )? ( (lv_Application_6_0= ruleOilApplication ) )? ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:81:1: ( () (otherlv_1= 'OIL_VERSION' otherlv_2= '=' ( (lv_OilVersion_3_0= RULE_STRING ) ) otherlv_4= ';' )? ( (lv_Implementation_5_0= ruleOilImplementation ) )? ( (lv_Application_6_0= ruleOilApplication ) )? )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:81:1: ( () (otherlv_1= 'OIL_VERSION' otherlv_2= '=' ( (lv_OilVersion_3_0= RULE_STRING ) ) otherlv_4= ';' )? ( (lv_Implementation_5_0= ruleOilImplementation ) )? ( (lv_Application_6_0= ruleOilApplication ) )? )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:81:2: () (otherlv_1= 'OIL_VERSION' otherlv_2= '=' ( (lv_OilVersion_3_0= RULE_STRING ) ) otherlv_4= ';' )? ( (lv_Implementation_5_0= ruleOilImplementation ) )? ( (lv_Application_6_0= ruleOilApplication ) )?
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:81:2: ()
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:82:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getOilFileAccess().getOilFileAction_0(),
                          current);
                  
            }

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:87:2: (otherlv_1= 'OIL_VERSION' otherlv_2= '=' ( (lv_OilVersion_3_0= RULE_STRING ) ) otherlv_4= ';' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==13) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:87:4: otherlv_1= 'OIL_VERSION' otherlv_2= '=' ( (lv_OilVersion_3_0= RULE_STRING ) ) otherlv_4= ';'
                    {
                    otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleOilFile132); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getOilFileAccess().getOIL_VERSIONKeyword_1_0());
                          
                    }
                    otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleOilFile144); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getOilFileAccess().getEqualsSignKeyword_1_1());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:95:1: ( (lv_OilVersion_3_0= RULE_STRING ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:96:1: (lv_OilVersion_3_0= RULE_STRING )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:96:1: (lv_OilVersion_3_0= RULE_STRING )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:97:3: lv_OilVersion_3_0= RULE_STRING
                    {
                    lv_OilVersion_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleOilFile161); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_OilVersion_3_0, grammarAccess.getOilFileAccess().getOilVersionSTRINGTerminalRuleCall_1_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getOilFileRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"OilVersion",
                              		lv_OilVersion_3_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleOilFile178); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getOilFileAccess().getSemicolonKeyword_1_3());
                          
                    }

                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:117:3: ( (lv_Implementation_5_0= ruleOilImplementation ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==16) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:118:1: (lv_Implementation_5_0= ruleOilImplementation )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:118:1: (lv_Implementation_5_0= ruleOilImplementation )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:119:3: lv_Implementation_5_0= ruleOilImplementation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOilFileAccess().getImplementationOilImplementationParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleOilImplementation_in_ruleOilFile201);
                    lv_Implementation_5_0=ruleOilImplementation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getOilFileRule());
                      	        }
                             		set(
                             			current, 
                             			"Implementation",
                              		lv_Implementation_5_0, 
                              		"OilImplementation");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:135:3: ( (lv_Application_6_0= ruleOilApplication ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==20) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:136:1: (lv_Application_6_0= ruleOilApplication )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:136:1: (lv_Application_6_0= ruleOilApplication )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:137:3: lv_Application_6_0= ruleOilApplication
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOilFileAccess().getApplicationOilApplicationParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleOilApplication_in_ruleOilFile223);
                    lv_Application_6_0=ruleOilApplication();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getOilFileRule());
                      	        }
                             		set(
                             			current, 
                             			"Application",
                              		lv_Application_6_0, 
                              		"OilApplication");
                      	        afterParserOrEnumRuleCall();
                      	    
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
    // $ANTLR end "ruleOilFile"


    // $ANTLR start "entryRuleOilImplementation"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:161:1: entryRuleOilImplementation returns [EObject current=null] : iv_ruleOilImplementation= ruleOilImplementation EOF ;
    public final EObject entryRuleOilImplementation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOilImplementation = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:162:2: (iv_ruleOilImplementation= ruleOilImplementation EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:163:2: iv_ruleOilImplementation= ruleOilImplementation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOilImplementationRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOilImplementation_in_entryRuleOilImplementation260);
            iv_ruleOilImplementation=ruleOilImplementation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOilImplementation; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOilImplementation270); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOilImplementation"


    // $ANTLR start "ruleOilImplementation"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:170:1: ruleOilImplementation returns [EObject current=null] : (otherlv_0= 'IMPLEMENTATION' ( (lv_Name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_OilObjects_3_0= ruleOilObjectImpl ) )* otherlv_4= '}' otherlv_5= ';' ) ;
    public final EObject ruleOilImplementation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_Name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_OilObjects_3_0 = null;


         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:173:28: ( (otherlv_0= 'IMPLEMENTATION' ( (lv_Name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_OilObjects_3_0= ruleOilObjectImpl ) )* otherlv_4= '}' otherlv_5= ';' ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:174:1: (otherlv_0= 'IMPLEMENTATION' ( (lv_Name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_OilObjects_3_0= ruleOilObjectImpl ) )* otherlv_4= '}' otherlv_5= ';' )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:174:1: (otherlv_0= 'IMPLEMENTATION' ( (lv_Name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_OilObjects_3_0= ruleOilObjectImpl ) )* otherlv_4= '}' otherlv_5= ';' )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:174:3: otherlv_0= 'IMPLEMENTATION' ( (lv_Name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_OilObjects_3_0= ruleOilObjectImpl ) )* otherlv_4= '}' otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleOilImplementation307); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getOilImplementationAccess().getIMPLEMENTATIONKeyword_0());
                  
            }
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:178:1: ( (lv_Name_1_0= RULE_ID ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:179:1: (lv_Name_1_0= RULE_ID )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:179:1: (lv_Name_1_0= RULE_ID )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:180:3: lv_Name_1_0= RULE_ID
            {
            lv_Name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOilImplementation324); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_Name_1_0, grammarAccess.getOilImplementationAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getOilImplementationRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"Name",
                      		lv_Name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleOilImplementation341); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getOilImplementationAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:200:1: ( (lv_OilObjects_3_0= ruleOilObjectImpl ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=37 && LA4_0<=49)||LA4_0==66) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:201:1: (lv_OilObjects_3_0= ruleOilObjectImpl )
            	    {
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:201:1: (lv_OilObjects_3_0= ruleOilObjectImpl )
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:202:3: lv_OilObjects_3_0= ruleOilObjectImpl
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOilImplementationAccess().getOilObjectsOilObjectImplParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleOilObjectImpl_in_ruleOilImplementation362);
            	    lv_OilObjects_3_0=ruleOilObjectImpl();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getOilImplementationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"OilObjects",
            	              		lv_OilObjects_3_0, 
            	              		"OilObjectImpl");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleOilImplementation375); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getOilImplementationAccess().getRightCurlyBracketKeyword_4());
                  
            }
            otherlv_5=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleOilImplementation387); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getOilImplementationAccess().getSemicolonKeyword_5());
                  
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
    // $ANTLR end "ruleOilImplementation"


    // $ANTLR start "entryRuleOilObjectImpl"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:234:1: entryRuleOilObjectImpl returns [EObject current=null] : iv_ruleOilObjectImpl= ruleOilObjectImpl EOF ;
    public final EObject entryRuleOilObjectImpl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOilObjectImpl = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:235:2: (iv_ruleOilObjectImpl= ruleOilObjectImpl EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:236:2: iv_ruleOilObjectImpl= ruleOilObjectImpl EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOilObjectImplRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOilObjectImpl_in_entryRuleOilObjectImpl423);
            iv_ruleOilObjectImpl=ruleOilObjectImpl();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOilObjectImpl; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOilObjectImpl433); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOilObjectImpl"


    // $ANTLR start "ruleOilObjectImpl"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:243:1: ruleOilObjectImpl returns [EObject current=null] : ( ( (lv_Type_0_0= ruleObjectType ) ) otherlv_1= '{' ( (lv_Parameters_2_0= ruleParameterType ) )* otherlv_3= '}' (otherlv_4= ':' ( (lv_Description_5_0= RULE_STRING ) ) )? otherlv_6= ';' ) ;
    public final EObject ruleOilObjectImpl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_Description_5_0=null;
        Token otherlv_6=null;
        Enumerator lv_Type_0_0 = null;

        EObject lv_Parameters_2_0 = null;


         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:246:28: ( ( ( (lv_Type_0_0= ruleObjectType ) ) otherlv_1= '{' ( (lv_Parameters_2_0= ruleParameterType ) )* otherlv_3= '}' (otherlv_4= ':' ( (lv_Description_5_0= RULE_STRING ) ) )? otherlv_6= ';' ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:247:1: ( ( (lv_Type_0_0= ruleObjectType ) ) otherlv_1= '{' ( (lv_Parameters_2_0= ruleParameterType ) )* otherlv_3= '}' (otherlv_4= ':' ( (lv_Description_5_0= RULE_STRING ) ) )? otherlv_6= ';' )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:247:1: ( ( (lv_Type_0_0= ruleObjectType ) ) otherlv_1= '{' ( (lv_Parameters_2_0= ruleParameterType ) )* otherlv_3= '}' (otherlv_4= ':' ( (lv_Description_5_0= RULE_STRING ) ) )? otherlv_6= ';' )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:247:2: ( (lv_Type_0_0= ruleObjectType ) ) otherlv_1= '{' ( (lv_Parameters_2_0= ruleParameterType ) )* otherlv_3= '}' (otherlv_4= ':' ( (lv_Description_5_0= RULE_STRING ) ) )? otherlv_6= ';'
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:247:2: ( (lv_Type_0_0= ruleObjectType ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:248:1: (lv_Type_0_0= ruleObjectType )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:248:1: (lv_Type_0_0= ruleObjectType )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:249:3: lv_Type_0_0= ruleObjectType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOilObjectImplAccess().getTypeObjectTypeEnumRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleObjectType_in_ruleOilObjectImpl479);
            lv_Type_0_0=ruleObjectType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getOilObjectImplRule());
              	        }
                     		set(
                     			current, 
                     			"Type",
                      		lv_Type_0_0, 
                      		"ObjectType");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleOilObjectImpl491); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getOilObjectImplAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:269:1: ( (lv_Parameters_2_0= ruleParameterType ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=28 && LA5_0<=36)||(LA5_0>=50 && LA5_0<=62)||LA5_0==67) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:270:1: (lv_Parameters_2_0= ruleParameterType )
            	    {
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:270:1: (lv_Parameters_2_0= ruleParameterType )
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:271:3: lv_Parameters_2_0= ruleParameterType
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOilObjectImplAccess().getParametersParameterTypeParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleParameterType_in_ruleOilObjectImpl512);
            	    lv_Parameters_2_0=ruleParameterType();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getOilObjectImplRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"Parameters",
            	              		lv_Parameters_2_0, 
            	              		"ParameterType");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_3=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleOilObjectImpl525); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getOilObjectImplAccess().getRightCurlyBracketKeyword_3());
                  
            }
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:291:1: (otherlv_4= ':' ( (lv_Description_5_0= RULE_STRING ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==19) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:291:3: otherlv_4= ':' ( (lv_Description_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleOilObjectImpl538); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getOilObjectImplAccess().getColonKeyword_4_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:295:1: ( (lv_Description_5_0= RULE_STRING ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:296:1: (lv_Description_5_0= RULE_STRING )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:296:1: (lv_Description_5_0= RULE_STRING )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:297:3: lv_Description_5_0= RULE_STRING
                    {
                    lv_Description_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleOilObjectImpl555); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_Description_5_0, grammarAccess.getOilObjectImplAccess().getDescriptionSTRINGTerminalRuleCall_4_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getOilObjectImplRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"Description",
                              		lv_Description_5_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleOilObjectImpl574); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getOilObjectImplAccess().getSemicolonKeyword_5());
                  
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
    // $ANTLR end "ruleOilObjectImpl"


    // $ANTLR start "entryRuleOilApplication"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:325:1: entryRuleOilApplication returns [EObject current=null] : iv_ruleOilApplication= ruleOilApplication EOF ;
    public final EObject entryRuleOilApplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOilApplication = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:326:2: (iv_ruleOilApplication= ruleOilApplication EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:327:2: iv_ruleOilApplication= ruleOilApplication EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOilApplicationRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOilApplication_in_entryRuleOilApplication610);
            iv_ruleOilApplication=ruleOilApplication();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOilApplication; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOilApplication620); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOilApplication"


    // $ANTLR start "ruleOilApplication"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:334:1: ruleOilApplication returns [EObject current=null] : (otherlv_0= 'CPU' ( (lv_Name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_OilObjects_3_0= ruleOilObject ) )* otherlv_4= '}' (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )? otherlv_7= ';' ) ;
    public final EObject ruleOilApplication() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_Name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_Description_6_0=null;
        Token otherlv_7=null;
        EObject lv_OilObjects_3_0 = null;


         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:337:28: ( (otherlv_0= 'CPU' ( (lv_Name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_OilObjects_3_0= ruleOilObject ) )* otherlv_4= '}' (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )? otherlv_7= ';' ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:338:1: (otherlv_0= 'CPU' ( (lv_Name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_OilObjects_3_0= ruleOilObject ) )* otherlv_4= '}' (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )? otherlv_7= ';' )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:338:1: (otherlv_0= 'CPU' ( (lv_Name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_OilObjects_3_0= ruleOilObject ) )* otherlv_4= '}' (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )? otherlv_7= ';' )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:338:3: otherlv_0= 'CPU' ( (lv_Name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_OilObjects_3_0= ruleOilObject ) )* otherlv_4= '}' (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )? otherlv_7= ';'
            {
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleOilApplication657); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getOilApplicationAccess().getCPUKeyword_0());
                  
            }
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:342:1: ( (lv_Name_1_0= RULE_ID ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:343:1: (lv_Name_1_0= RULE_ID )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:343:1: (lv_Name_1_0= RULE_ID )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:344:3: lv_Name_1_0= RULE_ID
            {
            lv_Name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOilApplication674); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_Name_1_0, grammarAccess.getOilApplicationAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getOilApplicationRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"Name",
                      		lv_Name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleOilApplication691); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getOilApplicationAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:364:1: ( (lv_OilObjects_3_0= ruleOilObject ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=37 && LA7_0<=49)||LA7_0==66) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:365:1: (lv_OilObjects_3_0= ruleOilObject )
            	    {
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:365:1: (lv_OilObjects_3_0= ruleOilObject )
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:366:3: lv_OilObjects_3_0= ruleOilObject
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOilApplicationAccess().getOilObjectsOilObjectParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleOilObject_in_ruleOilApplication712);
            	    lv_OilObjects_3_0=ruleOilObject();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getOilApplicationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"OilObjects",
            	              		lv_OilObjects_3_0, 
            	              		"OilObject");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleOilApplication725); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getOilApplicationAccess().getRightCurlyBracketKeyword_4());
                  
            }
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:386:1: (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==19) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:386:3: otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleOilApplication738); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getOilApplicationAccess().getColonKeyword_5_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:390:1: ( (lv_Description_6_0= RULE_STRING ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:391:1: (lv_Description_6_0= RULE_STRING )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:391:1: (lv_Description_6_0= RULE_STRING )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:392:3: lv_Description_6_0= RULE_STRING
                    {
                    lv_Description_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleOilApplication755); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_Description_6_0, grammarAccess.getOilApplicationAccess().getDescriptionSTRINGTerminalRuleCall_5_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getOilApplicationRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"Description",
                              		lv_Description_6_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleOilApplication774); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getOilApplicationAccess().getSemicolonKeyword_6());
                  
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
    // $ANTLR end "ruleOilApplication"


    // $ANTLR start "entryRuleParameterType"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:420:1: entryRuleParameterType returns [EObject current=null] : iv_ruleParameterType= ruleParameterType EOF ;
    public final EObject entryRuleParameterType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterType = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:421:2: (iv_ruleParameterType= ruleParameterType EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:422:2: iv_ruleParameterType= ruleParameterType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameterType_in_entryRuleParameterType810);
            iv_ruleParameterType=ruleParameterType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterType; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParameterType820); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterType"


    // $ANTLR start "ruleParameterType"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:429:1: ruleParameterType returns [EObject current=null] : (this_ValueType_0= ruleValueType | this_VariantType_1= ruleVariantType | this_ReferenceType_2= ruleReferenceType ) ;
    public final EObject ruleParameterType() throws RecognitionException {
        EObject current = null;

        EObject this_ValueType_0 = null;

        EObject this_VariantType_1 = null;

        EObject this_ReferenceType_2 = null;


         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:432:28: ( (this_ValueType_0= ruleValueType | this_VariantType_1= ruleVariantType | this_ReferenceType_2= ruleReferenceType ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:433:1: (this_ValueType_0= ruleValueType | this_VariantType_1= ruleVariantType | this_ReferenceType_2= ruleReferenceType )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:433:1: (this_ValueType_0= ruleValueType | this_VariantType_1= ruleVariantType | this_ReferenceType_2= ruleReferenceType )
            int alt9=3;
            switch ( input.LA(1) ) {
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
                {
                alt9=1;
                }
                break;
            case 35:
            case 36:
                {
                alt9=2;
                }
                break;
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 67:
                {
                alt9=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:434:5: this_ValueType_0= ruleValueType
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getParameterTypeAccess().getValueTypeParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleValueType_in_ruleParameterType867);
                    this_ValueType_0=ruleValueType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ValueType_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:444:5: this_VariantType_1= ruleVariantType
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getParameterTypeAccess().getVariantTypeParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleVariantType_in_ruleParameterType894);
                    this_VariantType_1=ruleVariantType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_VariantType_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:454:5: this_ReferenceType_2= ruleReferenceType
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getParameterTypeAccess().getReferenceTypeParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleReferenceType_in_ruleParameterType921);
                    this_ReferenceType_2=ruleReferenceType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ReferenceType_2; 
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
    // $ANTLR end "ruleParameterType"


    // $ANTLR start "entryRuleValueType"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:470:1: entryRuleValueType returns [EObject current=null] : iv_ruleValueType= ruleValueType EOF ;
    public final EObject entryRuleValueType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueType = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:471:2: (iv_ruleValueType= ruleValueType EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:472:2: iv_ruleValueType= ruleValueType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleValueType_in_entryRuleValueType956);
            iv_ruleValueType=ruleValueType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValueType; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleValueType966); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValueType"


    // $ANTLR start "ruleValueType"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:479:1: ruleValueType returns [EObject current=null] : ( () ( (lv_Type_1_0= ruleVType ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? (otherlv_3= '[' ( ( ( ruleINT | ruleDOUBLE ) otherlv_6= '..' ( ruleINT | ruleDOUBLE ) ) | ( ( ruleINT | ruleDOUBLE ) (otherlv_11= ',' ( ruleINT | ruleDOUBLE ) )* ) ) otherlv_14= ']' )? ( (lv_Name_15_0= ruleSpecialId ) ) ( (lv_MultiValue_16_0= '[]' ) )? (otherlv_17= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_18_0= 'AUTO' ) ) | ( ( (lv_DefaultValue_19_1= ruleGenericValue | lv_DefaultValue_19_2= RULE_ID ) ) ) ) )? (otherlv_20= ':' ( (lv_Description_21_0= RULE_STRING ) ) )? otherlv_22= ';' ) ;
    public final EObject ruleValueType() throws RecognitionException {
        EObject current = null;

        Token lv_WithAuto_2_0=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        Token otherlv_11=null;
        Token otherlv_14=null;
        Token lv_MultiValue_16_0=null;
        Token otherlv_17=null;
        Token lv_DefaultAuto_18_0=null;
        Token lv_DefaultValue_19_2=null;
        Token otherlv_20=null;
        Token lv_Description_21_0=null;
        Token otherlv_22=null;
        Enumerator lv_Type_1_0 = null;

        AntlrDatatypeRuleToken lv_Name_15_0 = null;

        AntlrDatatypeRuleToken lv_DefaultValue_19_1 = null;


         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:482:28: ( ( () ( (lv_Type_1_0= ruleVType ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? (otherlv_3= '[' ( ( ( ruleINT | ruleDOUBLE ) otherlv_6= '..' ( ruleINT | ruleDOUBLE ) ) | ( ( ruleINT | ruleDOUBLE ) (otherlv_11= ',' ( ruleINT | ruleDOUBLE ) )* ) ) otherlv_14= ']' )? ( (lv_Name_15_0= ruleSpecialId ) ) ( (lv_MultiValue_16_0= '[]' ) )? (otherlv_17= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_18_0= 'AUTO' ) ) | ( ( (lv_DefaultValue_19_1= ruleGenericValue | lv_DefaultValue_19_2= RULE_ID ) ) ) ) )? (otherlv_20= ':' ( (lv_Description_21_0= RULE_STRING ) ) )? otherlv_22= ';' ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:483:1: ( () ( (lv_Type_1_0= ruleVType ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? (otherlv_3= '[' ( ( ( ruleINT | ruleDOUBLE ) otherlv_6= '..' ( ruleINT | ruleDOUBLE ) ) | ( ( ruleINT | ruleDOUBLE ) (otherlv_11= ',' ( ruleINT | ruleDOUBLE ) )* ) ) otherlv_14= ']' )? ( (lv_Name_15_0= ruleSpecialId ) ) ( (lv_MultiValue_16_0= '[]' ) )? (otherlv_17= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_18_0= 'AUTO' ) ) | ( ( (lv_DefaultValue_19_1= ruleGenericValue | lv_DefaultValue_19_2= RULE_ID ) ) ) ) )? (otherlv_20= ':' ( (lv_Description_21_0= RULE_STRING ) ) )? otherlv_22= ';' )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:483:1: ( () ( (lv_Type_1_0= ruleVType ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? (otherlv_3= '[' ( ( ( ruleINT | ruleDOUBLE ) otherlv_6= '..' ( ruleINT | ruleDOUBLE ) ) | ( ( ruleINT | ruleDOUBLE ) (otherlv_11= ',' ( ruleINT | ruleDOUBLE ) )* ) ) otherlv_14= ']' )? ( (lv_Name_15_0= ruleSpecialId ) ) ( (lv_MultiValue_16_0= '[]' ) )? (otherlv_17= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_18_0= 'AUTO' ) ) | ( ( (lv_DefaultValue_19_1= ruleGenericValue | lv_DefaultValue_19_2= RULE_ID ) ) ) ) )? (otherlv_20= ':' ( (lv_Description_21_0= RULE_STRING ) ) )? otherlv_22= ';' )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:483:2: () ( (lv_Type_1_0= ruleVType ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? (otherlv_3= '[' ( ( ( ruleINT | ruleDOUBLE ) otherlv_6= '..' ( ruleINT | ruleDOUBLE ) ) | ( ( ruleINT | ruleDOUBLE ) (otherlv_11= ',' ( ruleINT | ruleDOUBLE ) )* ) ) otherlv_14= ']' )? ( (lv_Name_15_0= ruleSpecialId ) ) ( (lv_MultiValue_16_0= '[]' ) )? (otherlv_17= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_18_0= 'AUTO' ) ) | ( ( (lv_DefaultValue_19_1= ruleGenericValue | lv_DefaultValue_19_2= RULE_ID ) ) ) ) )? (otherlv_20= ':' ( (lv_Description_21_0= RULE_STRING ) ) )? otherlv_22= ';'
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:483:2: ()
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:484:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getValueTypeAccess().getValueTypeAction_0(),
                          current);
                  
            }

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:489:2: ( (lv_Type_1_0= ruleVType ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:490:1: (lv_Type_1_0= ruleVType )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:490:1: (lv_Type_1_0= ruleVType )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:491:3: lv_Type_1_0= ruleVType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getValueTypeAccess().getTypeVTypeEnumRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVType_in_ruleValueType1021);
            lv_Type_1_0=ruleVType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getValueTypeRule());
              	        }
                     		set(
                     			current, 
                     			"Type",
                      		lv_Type_1_0, 
                      		"VType");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:507:2: ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==21) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:508:1: (lv_WithAuto_2_0= 'WITH_AUTO' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:508:1: (lv_WithAuto_2_0= 'WITH_AUTO' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:509:3: lv_WithAuto_2_0= 'WITH_AUTO'
                    {
                    lv_WithAuto_2_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleValueType1039); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_WithAuto_2_0, grammarAccess.getValueTypeAccess().getWithAutoWITH_AUTOKeyword_2_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getValueTypeRule());
                      	        }
                             		setWithLastConsumed(current, "WithAuto", true, "WITH_AUTO");
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:522:3: (otherlv_3= '[' ( ( ( ruleINT | ruleDOUBLE ) otherlv_6= '..' ( ruleINT | ruleDOUBLE ) ) | ( ( ruleINT | ruleDOUBLE ) (otherlv_11= ',' ( ruleINT | ruleDOUBLE ) )* ) ) otherlv_14= ']' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==22) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:522:5: otherlv_3= '[' ( ( ( ruleINT | ruleDOUBLE ) otherlv_6= '..' ( ruleINT | ruleDOUBLE ) ) | ( ( ruleINT | ruleDOUBLE ) (otherlv_11= ',' ( ruleINT | ruleDOUBLE ) )* ) ) otherlv_14= ']'
                    {
                    otherlv_3=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleValueType1066); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getValueTypeAccess().getLeftSquareBracketKeyword_3_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:526:1: ( ( ( ruleINT | ruleDOUBLE ) otherlv_6= '..' ( ruleINT | ruleDOUBLE ) ) | ( ( ruleINT | ruleDOUBLE ) (otherlv_11= ',' ( ruleINT | ruleDOUBLE ) )* ) )
                    int alt16=2;
                    alt16 = dfa16.predict(input);
                    switch (alt16) {
                        case 1 :
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:526:2: ( ( ruleINT | ruleDOUBLE ) otherlv_6= '..' ( ruleINT | ruleDOUBLE ) )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:526:2: ( ( ruleINT | ruleDOUBLE ) otherlv_6= '..' ( ruleINT | ruleDOUBLE ) )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:526:3: ( ruleINT | ruleDOUBLE ) otherlv_6= '..' ( ruleINT | ruleDOUBLE )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:526:3: ( ruleINT | ruleDOUBLE )
                            int alt11=2;
                            alt11 = dfa11.predict(input);
                            switch (alt11) {
                                case 1 :
                                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:527:5: ruleINT
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                              newCompositeNode(grammarAccess.getValueTypeAccess().getINTParserRuleCall_3_1_0_0_0()); 
                                          
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleINT_in_ruleValueType1085);
                                    ruleINT();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {
                                       
                                              afterParserOrEnumRuleCall();
                                          
                                    }

                                    }
                                    break;
                                case 2 :
                                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:536:5: ruleDOUBLE
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                              newCompositeNode(grammarAccess.getValueTypeAccess().getDOUBLEParserRuleCall_3_1_0_0_1()); 
                                          
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleDOUBLE_in_ruleValueType1106);
                                    ruleDOUBLE();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {
                                       
                                              afterParserOrEnumRuleCall();
                                          
                                    }

                                    }
                                    break;

                            }

                            otherlv_6=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleValueType1118); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_6, grammarAccess.getValueTypeAccess().getFullStopFullStopKeyword_3_1_0_1());
                                  
                            }
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:547:1: ( ruleINT | ruleDOUBLE )
                            int alt12=2;
                            alt12 = dfa12.predict(input);
                            switch (alt12) {
                                case 1 :
                                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:548:5: ruleINT
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                              newCompositeNode(grammarAccess.getValueTypeAccess().getINTParserRuleCall_3_1_0_2_0()); 
                                          
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleINT_in_ruleValueType1135);
                                    ruleINT();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {
                                       
                                              afterParserOrEnumRuleCall();
                                          
                                    }

                                    }
                                    break;
                                case 2 :
                                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:557:5: ruleDOUBLE
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                              newCompositeNode(grammarAccess.getValueTypeAccess().getDOUBLEParserRuleCall_3_1_0_2_1()); 
                                          
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleDOUBLE_in_ruleValueType1156);
                                    ruleDOUBLE();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {
                                       
                                              afterParserOrEnumRuleCall();
                                          
                                    }

                                    }
                                    break;

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:565:6: ( ( ruleINT | ruleDOUBLE ) (otherlv_11= ',' ( ruleINT | ruleDOUBLE ) )* )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:565:6: ( ( ruleINT | ruleDOUBLE ) (otherlv_11= ',' ( ruleINT | ruleDOUBLE ) )* )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:565:7: ( ruleINT | ruleDOUBLE ) (otherlv_11= ',' ( ruleINT | ruleDOUBLE ) )*
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:565:7: ( ruleINT | ruleDOUBLE )
                            int alt13=2;
                            alt13 = dfa13.predict(input);
                            switch (alt13) {
                                case 1 :
                                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:566:5: ruleINT
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                              newCompositeNode(grammarAccess.getValueTypeAccess().getINTParserRuleCall_3_1_1_0_0()); 
                                          
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleINT_in_ruleValueType1181);
                                    ruleINT();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {
                                       
                                              afterParserOrEnumRuleCall();
                                          
                                    }

                                    }
                                    break;
                                case 2 :
                                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:575:5: ruleDOUBLE
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                              newCompositeNode(grammarAccess.getValueTypeAccess().getDOUBLEParserRuleCall_3_1_1_0_1()); 
                                          
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleDOUBLE_in_ruleValueType1202);
                                    ruleDOUBLE();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {
                                       
                                              afterParserOrEnumRuleCall();
                                          
                                    }

                                    }
                                    break;

                            }

                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:582:2: (otherlv_11= ',' ( ruleINT | ruleDOUBLE ) )*
                            loop15:
                            do {
                                int alt15=2;
                                int LA15_0 = input.LA(1);

                                if ( (LA15_0==24) ) {
                                    alt15=1;
                                }


                                switch (alt15) {
                            	case 1 :
                            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:582:4: otherlv_11= ',' ( ruleINT | ruleDOUBLE )
                            	    {
                            	    otherlv_11=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleValueType1215); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_11, grammarAccess.getValueTypeAccess().getCommaKeyword_3_1_1_1_0());
                            	          
                            	    }
                            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:586:1: ( ruleINT | ruleDOUBLE )
                            	    int alt14=2;
                            	    alt14 = dfa14.predict(input);
                            	    switch (alt14) {
                            	        case 1 :
                            	            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:587:5: ruleINT
                            	            {
                            	            if ( state.backtracking==0 ) {
                            	               
                            	                      newCompositeNode(grammarAccess.getValueTypeAccess().getINTParserRuleCall_3_1_1_1_1_0()); 
                            	                  
                            	            }
                            	            pushFollow(FollowSets000.FOLLOW_ruleINT_in_ruleValueType1232);
                            	            ruleINT();

                            	            state._fsp--;
                            	            if (state.failed) return current;
                            	            if ( state.backtracking==0 ) {
                            	               
                            	                      afterParserOrEnumRuleCall();
                            	                  
                            	            }

                            	            }
                            	            break;
                            	        case 2 :
                            	            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:596:5: ruleDOUBLE
                            	            {
                            	            if ( state.backtracking==0 ) {
                            	               
                            	                      newCompositeNode(grammarAccess.getValueTypeAccess().getDOUBLEParserRuleCall_3_1_1_1_1_1()); 
                            	                  
                            	            }
                            	            pushFollow(FollowSets000.FOLLOW_ruleDOUBLE_in_ruleValueType1253);
                            	            ruleDOUBLE();

                            	            state._fsp--;
                            	            if (state.failed) return current;
                            	            if ( state.backtracking==0 ) {
                            	               
                            	                      afterParserOrEnumRuleCall();
                            	                  
                            	            }

                            	            }
                            	            break;

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop15;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    otherlv_14=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleValueType1269); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getValueTypeAccess().getRightSquareBracketKeyword_3_2());
                          
                    }

                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:607:3: ( (lv_Name_15_0= ruleSpecialId ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:608:1: (lv_Name_15_0= ruleSpecialId )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:608:1: (lv_Name_15_0= ruleSpecialId )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:609:3: lv_Name_15_0= ruleSpecialId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getValueTypeAccess().getNameSpecialIdParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_ruleValueType1292);
            lv_Name_15_0=ruleSpecialId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getValueTypeRule());
              	        }
                     		set(
                     			current, 
                     			"Name",
                      		lv_Name_15_0, 
                      		"SpecialId");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:625:2: ( (lv_MultiValue_16_0= '[]' ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==26) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:626:1: (lv_MultiValue_16_0= '[]' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:626:1: (lv_MultiValue_16_0= '[]' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:627:3: lv_MultiValue_16_0= '[]'
                    {
                    lv_MultiValue_16_0=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleValueType1310); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_MultiValue_16_0, grammarAccess.getValueTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_5_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getValueTypeRule());
                      	        }
                             		setWithLastConsumed(current, "MultiValue", true, "[]");
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:640:3: (otherlv_17= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_18_0= 'AUTO' ) ) | ( ( (lv_DefaultValue_19_1= ruleGenericValue | lv_DefaultValue_19_2= RULE_ID ) ) ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==14) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:640:5: otherlv_17= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_18_0= 'AUTO' ) ) | ( ( (lv_DefaultValue_19_1= ruleGenericValue | lv_DefaultValue_19_2= RULE_ID ) ) ) )
                    {
                    otherlv_17=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleValueType1337); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_17, grammarAccess.getValueTypeAccess().getEqualsSignKeyword_6_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:644:1: ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_18_0= 'AUTO' ) ) | ( ( (lv_DefaultValue_19_1= ruleGenericValue | lv_DefaultValue_19_2= RULE_ID ) ) ) )
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==27) && (synpred1_InternalOil())) {
                        alt20=1;
                    }
                    else if ( ((LA20_0>=RULE_STRING && LA20_0<=RULE_HEX)||(LA20_0>=63 && LA20_0<=64)) ) {
                        alt20=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 20, 0, input);

                        throw nvae;
                    }
                    switch (alt20) {
                        case 1 :
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:644:2: ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_18_0= 'AUTO' ) )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:644:2: ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_18_0= 'AUTO' ) )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:644:3: ( ( 'AUTO' ) )=> (lv_DefaultAuto_18_0= 'AUTO' )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:651:1: (lv_DefaultAuto_18_0= 'AUTO' )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:652:3: lv_DefaultAuto_18_0= 'AUTO'
                            {
                            lv_DefaultAuto_18_0=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleValueType1371); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_DefaultAuto_18_0, grammarAccess.getValueTypeAccess().getDefaultAutoAUTOKeyword_6_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getValueTypeRule());
                              	        }
                                     		setWithLastConsumed(current, "DefaultAuto", true, "AUTO");
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:666:6: ( ( (lv_DefaultValue_19_1= ruleGenericValue | lv_DefaultValue_19_2= RULE_ID ) ) )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:666:6: ( ( (lv_DefaultValue_19_1= ruleGenericValue | lv_DefaultValue_19_2= RULE_ID ) ) )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:667:1: ( (lv_DefaultValue_19_1= ruleGenericValue | lv_DefaultValue_19_2= RULE_ID ) )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:667:1: ( (lv_DefaultValue_19_1= ruleGenericValue | lv_DefaultValue_19_2= RULE_ID ) )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:668:1: (lv_DefaultValue_19_1= ruleGenericValue | lv_DefaultValue_19_2= RULE_ID )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:668:1: (lv_DefaultValue_19_1= ruleGenericValue | lv_DefaultValue_19_2= RULE_ID )
                            int alt19=2;
                            int LA19_0 = input.LA(1);

                            if ( (LA19_0==RULE_STRING||(LA19_0>=RULE_NON_ZERO_INT && LA19_0<=RULE_HEX)||(LA19_0>=63 && LA19_0<=64)) ) {
                                alt19=1;
                            }
                            else if ( (LA19_0==RULE_ID) ) {
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
                                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:669:3: lv_DefaultValue_19_1= ruleGenericValue
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getValueTypeAccess().getDefaultValueGenericValueParserRuleCall_6_1_1_0_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleGenericValue_in_ruleValueType1413);
                                    lv_DefaultValue_19_1=ruleGenericValue();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElementForParent(grammarAccess.getValueTypeRule());
                                      	        }
                                             		set(
                                             			current, 
                                             			"DefaultValue",
                                              		lv_DefaultValue_19_1, 
                                              		"GenericValue");
                                      	        afterParserOrEnumRuleCall();
                                      	    
                                    }

                                    }
                                    break;
                                case 2 :
                                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:684:8: lv_DefaultValue_19_2= RULE_ID
                                    {
                                    lv_DefaultValue_19_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleValueType1428); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      			newLeafNode(lv_DefaultValue_19_2, grammarAccess.getValueTypeAccess().getDefaultValueIDTerminalRuleCall_6_1_1_0_1()); 
                                      		
                                    }
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElement(grammarAccess.getValueTypeRule());
                                      	        }
                                             		setWithLastConsumed(
                                             			current, 
                                             			"DefaultValue",
                                              		lv_DefaultValue_19_2, 
                                              		"ID");
                                      	    
                                    }

                                    }
                                    break;

                            }


                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:702:5: (otherlv_20= ':' ( (lv_Description_21_0= RULE_STRING ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==19) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:702:7: otherlv_20= ':' ( (lv_Description_21_0= RULE_STRING ) )
                    {
                    otherlv_20=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleValueType1452); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_20, grammarAccess.getValueTypeAccess().getColonKeyword_7_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:706:1: ( (lv_Description_21_0= RULE_STRING ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:707:1: (lv_Description_21_0= RULE_STRING )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:707:1: (lv_Description_21_0= RULE_STRING )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:708:3: lv_Description_21_0= RULE_STRING
                    {
                    lv_Description_21_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleValueType1469); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_Description_21_0, grammarAccess.getValueTypeAccess().getDescriptionSTRINGTerminalRuleCall_7_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getValueTypeRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"Description",
                              		lv_Description_21_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_22=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleValueType1488); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_22, grammarAccess.getValueTypeAccess().getSemicolonKeyword_8());
                  
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
    // $ANTLR end "ruleValueType"


    // $ANTLR start "entryRuleVariantType"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:736:1: entryRuleVariantType returns [EObject current=null] : iv_ruleVariantType= ruleVariantType EOF ;
    public final EObject entryRuleVariantType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariantType = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:737:2: (iv_ruleVariantType= ruleVariantType EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:738:2: iv_ruleVariantType= ruleVariantType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariantTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVariantType_in_entryRuleVariantType1524);
            iv_ruleVariantType=ruleVariantType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariantType; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVariantType1534); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariantType"


    // $ANTLR start "ruleVariantType"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:745:1: ruleVariantType returns [EObject current=null] : ( () ( (lv_Type_1_0= ruleEType ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? (otherlv_3= '[' ( ( (lv_Values_4_0= ruleEnumeratorType ) ) (otherlv_5= ',' ( (lv_Values_6_0= ruleEnumeratorType ) ) )* )? otherlv_7= ']' )? ( (lv_Name_8_0= ruleSpecialId ) ) ( (lv_MultiValue_9_0= '[]' ) )? (otherlv_10= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_11_0= 'AUTO' ) ) | ( (lv_DefaultValue_12_0= RULE_ID ) ) ) )? (otherlv_13= ':' ( (lv_Description_14_0= RULE_STRING ) ) )? otherlv_15= ';' ) ;
    public final EObject ruleVariantType() throws RecognitionException {
        EObject current = null;

        Token lv_WithAuto_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_MultiValue_9_0=null;
        Token otherlv_10=null;
        Token lv_DefaultAuto_11_0=null;
        Token lv_DefaultValue_12_0=null;
        Token otherlv_13=null;
        Token lv_Description_14_0=null;
        Token otherlv_15=null;
        Enumerator lv_Type_1_0 = null;

        EObject lv_Values_4_0 = null;

        EObject lv_Values_6_0 = null;

        AntlrDatatypeRuleToken lv_Name_8_0 = null;


         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:748:28: ( ( () ( (lv_Type_1_0= ruleEType ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? (otherlv_3= '[' ( ( (lv_Values_4_0= ruleEnumeratorType ) ) (otherlv_5= ',' ( (lv_Values_6_0= ruleEnumeratorType ) ) )* )? otherlv_7= ']' )? ( (lv_Name_8_0= ruleSpecialId ) ) ( (lv_MultiValue_9_0= '[]' ) )? (otherlv_10= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_11_0= 'AUTO' ) ) | ( (lv_DefaultValue_12_0= RULE_ID ) ) ) )? (otherlv_13= ':' ( (lv_Description_14_0= RULE_STRING ) ) )? otherlv_15= ';' ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:749:1: ( () ( (lv_Type_1_0= ruleEType ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? (otherlv_3= '[' ( ( (lv_Values_4_0= ruleEnumeratorType ) ) (otherlv_5= ',' ( (lv_Values_6_0= ruleEnumeratorType ) ) )* )? otherlv_7= ']' )? ( (lv_Name_8_0= ruleSpecialId ) ) ( (lv_MultiValue_9_0= '[]' ) )? (otherlv_10= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_11_0= 'AUTO' ) ) | ( (lv_DefaultValue_12_0= RULE_ID ) ) ) )? (otherlv_13= ':' ( (lv_Description_14_0= RULE_STRING ) ) )? otherlv_15= ';' )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:749:1: ( () ( (lv_Type_1_0= ruleEType ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? (otherlv_3= '[' ( ( (lv_Values_4_0= ruleEnumeratorType ) ) (otherlv_5= ',' ( (lv_Values_6_0= ruleEnumeratorType ) ) )* )? otherlv_7= ']' )? ( (lv_Name_8_0= ruleSpecialId ) ) ( (lv_MultiValue_9_0= '[]' ) )? (otherlv_10= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_11_0= 'AUTO' ) ) | ( (lv_DefaultValue_12_0= RULE_ID ) ) ) )? (otherlv_13= ':' ( (lv_Description_14_0= RULE_STRING ) ) )? otherlv_15= ';' )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:749:2: () ( (lv_Type_1_0= ruleEType ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? (otherlv_3= '[' ( ( (lv_Values_4_0= ruleEnumeratorType ) ) (otherlv_5= ',' ( (lv_Values_6_0= ruleEnumeratorType ) ) )* )? otherlv_7= ']' )? ( (lv_Name_8_0= ruleSpecialId ) ) ( (lv_MultiValue_9_0= '[]' ) )? (otherlv_10= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_11_0= 'AUTO' ) ) | ( (lv_DefaultValue_12_0= RULE_ID ) ) ) )? (otherlv_13= ':' ( (lv_Description_14_0= RULE_STRING ) ) )? otherlv_15= ';'
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:749:2: ()
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:750:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getVariantTypeAccess().getVariantTypeAction_0(),
                          current);
                  
            }

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:755:2: ( (lv_Type_1_0= ruleEType ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:756:1: (lv_Type_1_0= ruleEType )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:756:1: (lv_Type_1_0= ruleEType )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:757:3: lv_Type_1_0= ruleEType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariantTypeAccess().getTypeETypeEnumRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleEType_in_ruleVariantType1589);
            lv_Type_1_0=ruleEType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVariantTypeRule());
              	        }
                     		set(
                     			current, 
                     			"Type",
                      		lv_Type_1_0, 
                      		"EType");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:773:2: ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==21) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:774:1: (lv_WithAuto_2_0= 'WITH_AUTO' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:774:1: (lv_WithAuto_2_0= 'WITH_AUTO' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:775:3: lv_WithAuto_2_0= 'WITH_AUTO'
                    {
                    lv_WithAuto_2_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleVariantType1607); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_WithAuto_2_0, grammarAccess.getVariantTypeAccess().getWithAutoWITH_AUTOKeyword_2_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getVariantTypeRule());
                      	        }
                             		setWithLastConsumed(current, "WithAuto", true, "WITH_AUTO");
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:788:3: (otherlv_3= '[' ( ( (lv_Values_4_0= ruleEnumeratorType ) ) (otherlv_5= ',' ( (lv_Values_6_0= ruleEnumeratorType ) ) )* )? otherlv_7= ']' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==22) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:788:5: otherlv_3= '[' ( ( (lv_Values_4_0= ruleEnumeratorType ) ) (otherlv_5= ',' ( (lv_Values_6_0= ruleEnumeratorType ) ) )* )? otherlv_7= ']'
                    {
                    otherlv_3=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleVariantType1634); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getVariantTypeAccess().getLeftSquareBracketKeyword_3_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:792:1: ( ( (lv_Values_4_0= ruleEnumeratorType ) ) (otherlv_5= ',' ( (lv_Values_6_0= ruleEnumeratorType ) ) )* )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==RULE_ID||(LA25_0>=28 && LA25_0<=62)) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:792:2: ( (lv_Values_4_0= ruleEnumeratorType ) ) (otherlv_5= ',' ( (lv_Values_6_0= ruleEnumeratorType ) ) )*
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:792:2: ( (lv_Values_4_0= ruleEnumeratorType ) )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:793:1: (lv_Values_4_0= ruleEnumeratorType )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:793:1: (lv_Values_4_0= ruleEnumeratorType )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:794:3: lv_Values_4_0= ruleEnumeratorType
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getVariantTypeAccess().getValuesEnumeratorTypeParserRuleCall_3_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleEnumeratorType_in_ruleVariantType1656);
                            lv_Values_4_0=ruleEnumeratorType();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getVariantTypeRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"Values",
                                      		lv_Values_4_0, 
                                      		"EnumeratorType");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:810:2: (otherlv_5= ',' ( (lv_Values_6_0= ruleEnumeratorType ) ) )*
                            loop24:
                            do {
                                int alt24=2;
                                int LA24_0 = input.LA(1);

                                if ( (LA24_0==24) ) {
                                    alt24=1;
                                }


                                switch (alt24) {
                            	case 1 :
                            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:810:4: otherlv_5= ',' ( (lv_Values_6_0= ruleEnumeratorType ) )
                            	    {
                            	    otherlv_5=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleVariantType1669); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_5, grammarAccess.getVariantTypeAccess().getCommaKeyword_3_1_1_0());
                            	          
                            	    }
                            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:814:1: ( (lv_Values_6_0= ruleEnumeratorType ) )
                            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:815:1: (lv_Values_6_0= ruleEnumeratorType )
                            	    {
                            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:815:1: (lv_Values_6_0= ruleEnumeratorType )
                            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:816:3: lv_Values_6_0= ruleEnumeratorType
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getVariantTypeAccess().getValuesEnumeratorTypeParserRuleCall_3_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleEnumeratorType_in_ruleVariantType1690);
                            	    lv_Values_6_0=ruleEnumeratorType();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getVariantTypeRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"Values",
                            	              		lv_Values_6_0, 
                            	              		"EnumeratorType");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop24;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_7=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleVariantType1706); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getVariantTypeAccess().getRightSquareBracketKeyword_3_2());
                          
                    }

                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:836:3: ( (lv_Name_8_0= ruleSpecialId ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:837:1: (lv_Name_8_0= ruleSpecialId )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:837:1: (lv_Name_8_0= ruleSpecialId )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:838:3: lv_Name_8_0= ruleSpecialId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariantTypeAccess().getNameSpecialIdParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_ruleVariantType1729);
            lv_Name_8_0=ruleSpecialId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVariantTypeRule());
              	        }
                     		set(
                     			current, 
                     			"Name",
                      		lv_Name_8_0, 
                      		"SpecialId");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:854:2: ( (lv_MultiValue_9_0= '[]' ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==26) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:855:1: (lv_MultiValue_9_0= '[]' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:855:1: (lv_MultiValue_9_0= '[]' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:856:3: lv_MultiValue_9_0= '[]'
                    {
                    lv_MultiValue_9_0=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleVariantType1747); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_MultiValue_9_0, grammarAccess.getVariantTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_5_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getVariantTypeRule());
                      	        }
                             		setWithLastConsumed(current, "MultiValue", true, "[]");
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:869:3: (otherlv_10= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_11_0= 'AUTO' ) ) | ( (lv_DefaultValue_12_0= RULE_ID ) ) ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==14) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:869:5: otherlv_10= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_11_0= 'AUTO' ) ) | ( (lv_DefaultValue_12_0= RULE_ID ) ) )
                    {
                    otherlv_10=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleVariantType1774); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getVariantTypeAccess().getEqualsSignKeyword_6_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:873:1: ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_11_0= 'AUTO' ) ) | ( (lv_DefaultValue_12_0= RULE_ID ) ) )
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==27) && (synpred2_InternalOil())) {
                        alt28=1;
                    }
                    else if ( (LA28_0==RULE_ID) ) {
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
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:873:2: ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_11_0= 'AUTO' ) )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:873:2: ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_11_0= 'AUTO' ) )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:873:3: ( ( 'AUTO' ) )=> (lv_DefaultAuto_11_0= 'AUTO' )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:880:1: (lv_DefaultAuto_11_0= 'AUTO' )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:881:3: lv_DefaultAuto_11_0= 'AUTO'
                            {
                            lv_DefaultAuto_11_0=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleVariantType1808); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_DefaultAuto_11_0, grammarAccess.getVariantTypeAccess().getDefaultAutoAUTOKeyword_6_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getVariantTypeRule());
                              	        }
                                     		setWithLastConsumed(current, "DefaultAuto", true, "AUTO");
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:895:6: ( (lv_DefaultValue_12_0= RULE_ID ) )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:895:6: ( (lv_DefaultValue_12_0= RULE_ID ) )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:896:1: (lv_DefaultValue_12_0= RULE_ID )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:896:1: (lv_DefaultValue_12_0= RULE_ID )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:897:3: lv_DefaultValue_12_0= RULE_ID
                            {
                            lv_DefaultValue_12_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleVariantType1844); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_DefaultValue_12_0, grammarAccess.getVariantTypeAccess().getDefaultValueIDTerminalRuleCall_6_1_1_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getVariantTypeRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"DefaultValue",
                                      		lv_DefaultValue_12_0, 
                                      		"ID");
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:913:5: (otherlv_13= ':' ( (lv_Description_14_0= RULE_STRING ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==19) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:913:7: otherlv_13= ':' ( (lv_Description_14_0= RULE_STRING ) )
                    {
                    otherlv_13=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleVariantType1865); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getVariantTypeAccess().getColonKeyword_7_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:917:1: ( (lv_Description_14_0= RULE_STRING ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:918:1: (lv_Description_14_0= RULE_STRING )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:918:1: (lv_Description_14_0= RULE_STRING )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:919:3: lv_Description_14_0= RULE_STRING
                    {
                    lv_Description_14_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleVariantType1882); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_Description_14_0, grammarAccess.getVariantTypeAccess().getDescriptionSTRINGTerminalRuleCall_7_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getVariantTypeRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"Description",
                              		lv_Description_14_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_15=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleVariantType1901); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_15, grammarAccess.getVariantTypeAccess().getSemicolonKeyword_8());
                  
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
    // $ANTLR end "ruleVariantType"


    // $ANTLR start "entryRuleEnumeratorType"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:947:1: entryRuleEnumeratorType returns [EObject current=null] : iv_ruleEnumeratorType= ruleEnumeratorType EOF ;
    public final EObject entryRuleEnumeratorType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumeratorType = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:948:2: (iv_ruleEnumeratorType= ruleEnumeratorType EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:949:2: iv_ruleEnumeratorType= ruleEnumeratorType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumeratorTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEnumeratorType_in_entryRuleEnumeratorType1937);
            iv_ruleEnumeratorType=ruleEnumeratorType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumeratorType; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumeratorType1947); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumeratorType"


    // $ANTLR start "ruleEnumeratorType"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:956:1: ruleEnumeratorType returns [EObject current=null] : ( () ( (lv_Name_1_0= ruleSpecialId ) ) (otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameterType ) )* otherlv_4= '}' )? (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleEnumeratorType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_Description_6_0=null;
        AntlrDatatypeRuleToken lv_Name_1_0 = null;

        EObject lv_Parameters_3_0 = null;


         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:959:28: ( ( () ( (lv_Name_1_0= ruleSpecialId ) ) (otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameterType ) )* otherlv_4= '}' )? (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )? ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:960:1: ( () ( (lv_Name_1_0= ruleSpecialId ) ) (otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameterType ) )* otherlv_4= '}' )? (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )? )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:960:1: ( () ( (lv_Name_1_0= ruleSpecialId ) ) (otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameterType ) )* otherlv_4= '}' )? (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )? )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:960:2: () ( (lv_Name_1_0= ruleSpecialId ) ) (otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameterType ) )* otherlv_4= '}' )? (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )?
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:960:2: ()
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:961:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getEnumeratorTypeAccess().getEnumeratorTypeAction_0(),
                          current);
                  
            }

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:966:2: ( (lv_Name_1_0= ruleSpecialId ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:967:1: (lv_Name_1_0= ruleSpecialId )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:967:1: (lv_Name_1_0= ruleSpecialId )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:968:3: lv_Name_1_0= ruleSpecialId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEnumeratorTypeAccess().getNameSpecialIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_ruleEnumeratorType2002);
            lv_Name_1_0=ruleSpecialId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getEnumeratorTypeRule());
              	        }
                     		set(
                     			current, 
                     			"Name",
                      		lv_Name_1_0, 
                      		"SpecialId");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:984:2: (otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameterType ) )* otherlv_4= '}' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==17) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:984:4: otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameterType ) )* otherlv_4= '}'
                    {
                    otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleEnumeratorType2015); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getEnumeratorTypeAccess().getLeftCurlyBracketKeyword_2_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:988:1: ( (lv_Parameters_3_0= ruleParameterType ) )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( ((LA31_0>=28 && LA31_0<=36)||(LA31_0>=50 && LA31_0<=62)||LA31_0==67) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:989:1: (lv_Parameters_3_0= ruleParameterType )
                    	    {
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:989:1: (lv_Parameters_3_0= ruleParameterType )
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:990:3: lv_Parameters_3_0= ruleParameterType
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getEnumeratorTypeAccess().getParametersParameterTypeParserRuleCall_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleParameterType_in_ruleEnumeratorType2036);
                    	    lv_Parameters_3_0=ruleParameterType();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getEnumeratorTypeRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"Parameters",
                    	              		lv_Parameters_3_0, 
                    	              		"ParameterType");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleEnumeratorType2049); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getEnumeratorTypeAccess().getRightCurlyBracketKeyword_2_2());
                          
                    }

                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1010:3: (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==19) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1010:5: otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleEnumeratorType2064); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getEnumeratorTypeAccess().getColonKeyword_3_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1014:1: ( (lv_Description_6_0= RULE_STRING ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1015:1: (lv_Description_6_0= RULE_STRING )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1015:1: (lv_Description_6_0= RULE_STRING )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1016:3: lv_Description_6_0= RULE_STRING
                    {
                    lv_Description_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEnumeratorType2081); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_Description_6_0, grammarAccess.getEnumeratorTypeAccess().getDescriptionSTRINGTerminalRuleCall_3_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getEnumeratorTypeRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"Description",
                              		lv_Description_6_0, 
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
    // $ANTLR end "ruleEnumeratorType"


    // $ANTLR start "entryRuleReferenceType"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1040:1: entryRuleReferenceType returns [EObject current=null] : iv_ruleReferenceType= ruleReferenceType EOF ;
    public final EObject entryRuleReferenceType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceType = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1041:2: (iv_ruleReferenceType= ruleReferenceType EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1042:2: iv_ruleReferenceType= ruleReferenceType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReferenceTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleReferenceType_in_entryRuleReferenceType2124);
            iv_ruleReferenceType=ruleReferenceType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReferenceType; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceType2134); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReferenceType"


    // $ANTLR start "ruleReferenceType"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1049:1: ruleReferenceType returns [EObject current=null] : ( () ( (lv_Type_1_0= ruleObjectTypeRef ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? ( (lv_Name_3_0= ruleSpecialId ) ) ( (lv_MultiValue_4_0= '[]' ) )? (otherlv_5= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( (lv_DefaultValue_7_0= RULE_ID ) ) ) )? (otherlv_8= ':' ( (lv_Description_9_0= RULE_STRING ) ) )? otherlv_10= ';' ) ;
    public final EObject ruleReferenceType() throws RecognitionException {
        EObject current = null;

        Token lv_WithAuto_2_0=null;
        Token lv_MultiValue_4_0=null;
        Token otherlv_5=null;
        Token lv_DefaultAuto_6_0=null;
        Token lv_DefaultValue_7_0=null;
        Token otherlv_8=null;
        Token lv_Description_9_0=null;
        Token otherlv_10=null;
        Enumerator lv_Type_1_0 = null;

        AntlrDatatypeRuleToken lv_Name_3_0 = null;


         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1052:28: ( ( () ( (lv_Type_1_0= ruleObjectTypeRef ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? ( (lv_Name_3_0= ruleSpecialId ) ) ( (lv_MultiValue_4_0= '[]' ) )? (otherlv_5= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( (lv_DefaultValue_7_0= RULE_ID ) ) ) )? (otherlv_8= ':' ( (lv_Description_9_0= RULE_STRING ) ) )? otherlv_10= ';' ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1053:1: ( () ( (lv_Type_1_0= ruleObjectTypeRef ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? ( (lv_Name_3_0= ruleSpecialId ) ) ( (lv_MultiValue_4_0= '[]' ) )? (otherlv_5= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( (lv_DefaultValue_7_0= RULE_ID ) ) ) )? (otherlv_8= ':' ( (lv_Description_9_0= RULE_STRING ) ) )? otherlv_10= ';' )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1053:1: ( () ( (lv_Type_1_0= ruleObjectTypeRef ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? ( (lv_Name_3_0= ruleSpecialId ) ) ( (lv_MultiValue_4_0= '[]' ) )? (otherlv_5= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( (lv_DefaultValue_7_0= RULE_ID ) ) ) )? (otherlv_8= ':' ( (lv_Description_9_0= RULE_STRING ) ) )? otherlv_10= ';' )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1053:2: () ( (lv_Type_1_0= ruleObjectTypeRef ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? ( (lv_Name_3_0= ruleSpecialId ) ) ( (lv_MultiValue_4_0= '[]' ) )? (otherlv_5= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( (lv_DefaultValue_7_0= RULE_ID ) ) ) )? (otherlv_8= ':' ( (lv_Description_9_0= RULE_STRING ) ) )? otherlv_10= ';'
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1053:2: ()
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1054:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getReferenceTypeAccess().getReferenceTypeAction_0(),
                          current);
                  
            }

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1059:2: ( (lv_Type_1_0= ruleObjectTypeRef ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1060:1: (lv_Type_1_0= ruleObjectTypeRef )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1060:1: (lv_Type_1_0= ruleObjectTypeRef )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1061:3: lv_Type_1_0= ruleObjectTypeRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getReferenceTypeAccess().getTypeObjectTypeRefEnumRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleObjectTypeRef_in_ruleReferenceType2189);
            lv_Type_1_0=ruleObjectTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getReferenceTypeRule());
              	        }
                     		set(
                     			current, 
                     			"Type",
                      		lv_Type_1_0, 
                      		"ObjectTypeRef");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1077:2: ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==21) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1078:1: (lv_WithAuto_2_0= 'WITH_AUTO' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1078:1: (lv_WithAuto_2_0= 'WITH_AUTO' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1079:3: lv_WithAuto_2_0= 'WITH_AUTO'
                    {
                    lv_WithAuto_2_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleReferenceType2207); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_WithAuto_2_0, grammarAccess.getReferenceTypeAccess().getWithAutoWITH_AUTOKeyword_2_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getReferenceTypeRule());
                      	        }
                             		setWithLastConsumed(current, "WithAuto", true, "WITH_AUTO");
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1092:3: ( (lv_Name_3_0= ruleSpecialId ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1093:1: (lv_Name_3_0= ruleSpecialId )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1093:1: (lv_Name_3_0= ruleSpecialId )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1094:3: lv_Name_3_0= ruleSpecialId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getReferenceTypeAccess().getNameSpecialIdParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_ruleReferenceType2242);
            lv_Name_3_0=ruleSpecialId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getReferenceTypeRule());
              	        }
                     		set(
                     			current, 
                     			"Name",
                      		lv_Name_3_0, 
                      		"SpecialId");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1110:2: ( (lv_MultiValue_4_0= '[]' ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==26) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1111:1: (lv_MultiValue_4_0= '[]' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1111:1: (lv_MultiValue_4_0= '[]' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1112:3: lv_MultiValue_4_0= '[]'
                    {
                    lv_MultiValue_4_0=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleReferenceType2260); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_MultiValue_4_0, grammarAccess.getReferenceTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_4_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getReferenceTypeRule());
                      	        }
                             		setWithLastConsumed(current, "MultiValue", true, "[]");
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1125:3: (otherlv_5= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( (lv_DefaultValue_7_0= RULE_ID ) ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==14) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1125:5: otherlv_5= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( (lv_DefaultValue_7_0= RULE_ID ) ) )
                    {
                    otherlv_5=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleReferenceType2287); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getReferenceTypeAccess().getEqualsSignKeyword_5_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1129:1: ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( (lv_DefaultValue_7_0= RULE_ID ) ) )
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==27) && (synpred3_InternalOil())) {
                        alt36=1;
                    }
                    else if ( (LA36_0==RULE_ID) ) {
                        alt36=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 36, 0, input);

                        throw nvae;
                    }
                    switch (alt36) {
                        case 1 :
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1129:2: ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1129:2: ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1129:3: ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1136:1: (lv_DefaultAuto_6_0= 'AUTO' )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1137:3: lv_DefaultAuto_6_0= 'AUTO'
                            {
                            lv_DefaultAuto_6_0=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleReferenceType2321); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_DefaultAuto_6_0, grammarAccess.getReferenceTypeAccess().getDefaultAutoAUTOKeyword_5_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getReferenceTypeRule());
                              	        }
                                     		setWithLastConsumed(current, "DefaultAuto", true, "AUTO");
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1151:6: ( (lv_DefaultValue_7_0= RULE_ID ) )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1151:6: ( (lv_DefaultValue_7_0= RULE_ID ) )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1152:1: (lv_DefaultValue_7_0= RULE_ID )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1152:1: (lv_DefaultValue_7_0= RULE_ID )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1153:3: lv_DefaultValue_7_0= RULE_ID
                            {
                            lv_DefaultValue_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceType2357); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_DefaultValue_7_0, grammarAccess.getReferenceTypeAccess().getDefaultValueIDTerminalRuleCall_5_1_1_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getReferenceTypeRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"DefaultValue",
                                      		lv_DefaultValue_7_0, 
                                      		"ID");
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1169:5: (otherlv_8= ':' ( (lv_Description_9_0= RULE_STRING ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==19) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1169:7: otherlv_8= ':' ( (lv_Description_9_0= RULE_STRING ) )
                    {
                    otherlv_8=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleReferenceType2378); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getReferenceTypeAccess().getColonKeyword_6_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1173:1: ( (lv_Description_9_0= RULE_STRING ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1174:1: (lv_Description_9_0= RULE_STRING )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1174:1: (lv_Description_9_0= RULE_STRING )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1175:3: lv_Description_9_0= RULE_STRING
                    {
                    lv_Description_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleReferenceType2395); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_Description_9_0, grammarAccess.getReferenceTypeAccess().getDescriptionSTRINGTerminalRuleCall_6_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getReferenceTypeRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"Description",
                              		lv_Description_9_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleReferenceType2414); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getReferenceTypeAccess().getSemicolonKeyword_7());
                  
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
    // $ANTLR end "ruleReferenceType"


    // $ANTLR start "entryRuleOilObject"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1203:1: entryRuleOilObject returns [EObject current=null] : iv_ruleOilObject= ruleOilObject EOF ;
    public final EObject entryRuleOilObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOilObject = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1204:2: (iv_ruleOilObject= ruleOilObject EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1205:2: iv_ruleOilObject= ruleOilObject EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOilObjectRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOilObject_in_entryRuleOilObject2450);
            iv_ruleOilObject=ruleOilObject();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOilObject; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOilObject2460); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOilObject"


    // $ANTLR start "ruleOilObject"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1212:1: ruleOilObject returns [EObject current=null] : ( ( (lv_Type_0_0= ruleObjectType ) ) ( (lv_Name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameter ) )* otherlv_4= '}' )? (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )? otherlv_7= ';' ) ;
    public final EObject ruleOilObject() throws RecognitionException {
        EObject current = null;

        Token lv_Name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_Description_6_0=null;
        Token otherlv_7=null;
        Enumerator lv_Type_0_0 = null;

        EObject lv_Parameters_3_0 = null;


         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1215:28: ( ( ( (lv_Type_0_0= ruleObjectType ) ) ( (lv_Name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameter ) )* otherlv_4= '}' )? (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )? otherlv_7= ';' ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1216:1: ( ( (lv_Type_0_0= ruleObjectType ) ) ( (lv_Name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameter ) )* otherlv_4= '}' )? (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )? otherlv_7= ';' )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1216:1: ( ( (lv_Type_0_0= ruleObjectType ) ) ( (lv_Name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameter ) )* otherlv_4= '}' )? (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )? otherlv_7= ';' )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1216:2: ( (lv_Type_0_0= ruleObjectType ) ) ( (lv_Name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameter ) )* otherlv_4= '}' )? (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )? otherlv_7= ';'
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1216:2: ( (lv_Type_0_0= ruleObjectType ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1217:1: (lv_Type_0_0= ruleObjectType )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1217:1: (lv_Type_0_0= ruleObjectType )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1218:3: lv_Type_0_0= ruleObjectType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOilObjectAccess().getTypeObjectTypeEnumRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleObjectType_in_ruleOilObject2506);
            lv_Type_0_0=ruleObjectType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getOilObjectRule());
              	        }
                     		set(
                     			current, 
                     			"Type",
                      		lv_Type_0_0, 
                      		"ObjectType");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1234:2: ( (lv_Name_1_0= RULE_ID ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1235:1: (lv_Name_1_0= RULE_ID )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1235:1: (lv_Name_1_0= RULE_ID )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1236:3: lv_Name_1_0= RULE_ID
            {
            lv_Name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOilObject2523); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_Name_1_0, grammarAccess.getOilObjectAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getOilObjectRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"Name",
                      		lv_Name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1252:2: (otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameter ) )* otherlv_4= '}' )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==17) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1252:4: otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameter ) )* otherlv_4= '}'
                    {
                    otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleOilObject2541); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getOilObjectAccess().getLeftCurlyBracketKeyword_2_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1256:1: ( (lv_Parameters_3_0= ruleParameter ) )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==RULE_ID||(LA39_0>=28 && LA39_0<=62)) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1257:1: (lv_Parameters_3_0= ruleParameter )
                    	    {
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1257:1: (lv_Parameters_3_0= ruleParameter )
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1258:3: lv_Parameters_3_0= ruleParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getOilObjectAccess().getParametersParameterParserRuleCall_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleParameter_in_ruleOilObject2562);
                    	    lv_Parameters_3_0=ruleParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getOilObjectRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"Parameters",
                    	              		lv_Parameters_3_0, 
                    	              		"Parameter");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop39;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleOilObject2575); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getOilObjectAccess().getRightCurlyBracketKeyword_2_2());
                          
                    }

                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1278:3: (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==19) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1278:5: otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleOilObject2590); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getOilObjectAccess().getColonKeyword_3_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1282:1: ( (lv_Description_6_0= RULE_STRING ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1283:1: (lv_Description_6_0= RULE_STRING )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1283:1: (lv_Description_6_0= RULE_STRING )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1284:3: lv_Description_6_0= RULE_STRING
                    {
                    lv_Description_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleOilObject2607); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_Description_6_0, grammarAccess.getOilObjectAccess().getDescriptionSTRINGTerminalRuleCall_3_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getOilObjectRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"Description",
                              		lv_Description_6_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleOilObject2626); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getOilObjectAccess().getSemicolonKeyword_4());
                  
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
    // $ANTLR end "ruleOilObject"


    // $ANTLR start "entryRuleParameter"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1312:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1313:2: (iv_ruleParameter= ruleParameter EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1314:2: iv_ruleParameter= ruleParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_entryRuleParameter2662);
            iv_ruleParameter=ruleParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameter; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParameter2672); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1321:1: ruleParameter returns [EObject current=null] : ( () ( ( ruleSpecialId ) ) otherlv_2= '=' ( ( ( ( 'AUTO' ) )=> (lv_Auto_3_0= 'AUTO' ) ) | ( (lv_Value_4_0= ruleGenericValue ) ) | ( ( ruleSpecialId ) ) ) (otherlv_6= '{' ( (lv_Parameters_7_0= ruleParameter ) )* otherlv_8= '}' )? (otherlv_9= ':' ( (lv_Description_10_0= RULE_STRING ) ) )? otherlv_11= ';' ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_Auto_3_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token lv_Description_10_0=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_Value_4_0 = null;

        EObject lv_Parameters_7_0 = null;


         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1324:28: ( ( () ( ( ruleSpecialId ) ) otherlv_2= '=' ( ( ( ( 'AUTO' ) )=> (lv_Auto_3_0= 'AUTO' ) ) | ( (lv_Value_4_0= ruleGenericValue ) ) | ( ( ruleSpecialId ) ) ) (otherlv_6= '{' ( (lv_Parameters_7_0= ruleParameter ) )* otherlv_8= '}' )? (otherlv_9= ':' ( (lv_Description_10_0= RULE_STRING ) ) )? otherlv_11= ';' ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1325:1: ( () ( ( ruleSpecialId ) ) otherlv_2= '=' ( ( ( ( 'AUTO' ) )=> (lv_Auto_3_0= 'AUTO' ) ) | ( (lv_Value_4_0= ruleGenericValue ) ) | ( ( ruleSpecialId ) ) ) (otherlv_6= '{' ( (lv_Parameters_7_0= ruleParameter ) )* otherlv_8= '}' )? (otherlv_9= ':' ( (lv_Description_10_0= RULE_STRING ) ) )? otherlv_11= ';' )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1325:1: ( () ( ( ruleSpecialId ) ) otherlv_2= '=' ( ( ( ( 'AUTO' ) )=> (lv_Auto_3_0= 'AUTO' ) ) | ( (lv_Value_4_0= ruleGenericValue ) ) | ( ( ruleSpecialId ) ) ) (otherlv_6= '{' ( (lv_Parameters_7_0= ruleParameter ) )* otherlv_8= '}' )? (otherlv_9= ':' ( (lv_Description_10_0= RULE_STRING ) ) )? otherlv_11= ';' )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1325:2: () ( ( ruleSpecialId ) ) otherlv_2= '=' ( ( ( ( 'AUTO' ) )=> (lv_Auto_3_0= 'AUTO' ) ) | ( (lv_Value_4_0= ruleGenericValue ) ) | ( ( ruleSpecialId ) ) ) (otherlv_6= '{' ( (lv_Parameters_7_0= ruleParameter ) )* otherlv_8= '}' )? (otherlv_9= ':' ( (lv_Description_10_0= RULE_STRING ) ) )? otherlv_11= ';'
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1325:2: ()
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1326:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getParameterAccess().getParameterAction_0(),
                          current);
                  
            }

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1331:2: ( ( ruleSpecialId ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1332:1: ( ruleSpecialId )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1332:1: ( ruleSpecialId )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1333:3: ruleSpecialId
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getParameterRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterAccess().getTypeParameterTypeCrossReference_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_ruleParameter2729);
            ruleSpecialId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleParameter2741); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getEqualsSignKeyword_2());
                  
            }
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1350:1: ( ( ( ( 'AUTO' ) )=> (lv_Auto_3_0= 'AUTO' ) ) | ( (lv_Value_4_0= ruleGenericValue ) ) | ( ( ruleSpecialId ) ) )
            int alt42=3;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==27) && (synpred4_InternalOil())) {
                alt42=1;
            }
            else if ( (LA42_0==RULE_STRING||(LA42_0>=RULE_NON_ZERO_INT && LA42_0<=RULE_HEX)||(LA42_0>=63 && LA42_0<=64)) ) {
                alt42=2;
            }
            else if ( (LA42_0==RULE_ID||(LA42_0>=28 && LA42_0<=62)) ) {
                alt42=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1350:2: ( ( ( 'AUTO' ) )=> (lv_Auto_3_0= 'AUTO' ) )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1350:2: ( ( ( 'AUTO' ) )=> (lv_Auto_3_0= 'AUTO' ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1350:3: ( ( 'AUTO' ) )=> (lv_Auto_3_0= 'AUTO' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1357:1: (lv_Auto_3_0= 'AUTO' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1358:3: lv_Auto_3_0= 'AUTO'
                    {
                    lv_Auto_3_0=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleParameter2775); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_Auto_3_0, grammarAccess.getParameterAccess().getAutoAUTOKeyword_3_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getParameterRule());
                      	        }
                             		setWithLastConsumed(current, "Auto", true, "AUTO");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1372:6: ( (lv_Value_4_0= ruleGenericValue ) )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1372:6: ( (lv_Value_4_0= ruleGenericValue ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1373:1: (lv_Value_4_0= ruleGenericValue )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1373:1: (lv_Value_4_0= ruleGenericValue )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1374:3: lv_Value_4_0= ruleGenericValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParameterAccess().getValueGenericValueParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleGenericValue_in_ruleParameter2815);
                    lv_Value_4_0=ruleGenericValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getParameterRule());
                      	        }
                             		set(
                             			current, 
                             			"Value",
                              		lv_Value_4_0, 
                              		"GenericValue");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1391:6: ( ( ruleSpecialId ) )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1391:6: ( ( ruleSpecialId ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1392:1: ( ruleSpecialId )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1392:1: ( ruleSpecialId )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1393:3: ruleSpecialId
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getParameterRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParameterAccess().getValueRefParameterRefCrossReference_3_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_ruleParameter2844);
                    ruleSpecialId();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1406:3: (otherlv_6= '{' ( (lv_Parameters_7_0= ruleParameter ) )* otherlv_8= '}' )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==17) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1406:5: otherlv_6= '{' ( (lv_Parameters_7_0= ruleParameter ) )* otherlv_8= '}'
                    {
                    otherlv_6=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleParameter2858); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getParameterAccess().getLeftCurlyBracketKeyword_4_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1410:1: ( (lv_Parameters_7_0= ruleParameter ) )*
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( (LA43_0==RULE_ID||(LA43_0>=28 && LA43_0<=62)) ) {
                            alt43=1;
                        }


                        switch (alt43) {
                    	case 1 :
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1411:1: (lv_Parameters_7_0= ruleParameter )
                    	    {
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1411:1: (lv_Parameters_7_0= ruleParameter )
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1412:3: lv_Parameters_7_0= ruleParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getParameterAccess().getParametersParameterParserRuleCall_4_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleParameter_in_ruleParameter2879);
                    	    lv_Parameters_7_0=ruleParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getParameterRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"Parameters",
                    	              		lv_Parameters_7_0, 
                    	              		"Parameter");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop43;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleParameter2892); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getParameterAccess().getRightCurlyBracketKeyword_4_2());
                          
                    }

                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1432:3: (otherlv_9= ':' ( (lv_Description_10_0= RULE_STRING ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==19) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1432:5: otherlv_9= ':' ( (lv_Description_10_0= RULE_STRING ) )
                    {
                    otherlv_9=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleParameter2907); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getParameterAccess().getColonKeyword_5_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1436:1: ( (lv_Description_10_0= RULE_STRING ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1437:1: (lv_Description_10_0= RULE_STRING )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1437:1: (lv_Description_10_0= RULE_STRING )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1438:3: lv_Description_10_0= RULE_STRING
                    {
                    lv_Description_10_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleParameter2924); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_Description_10_0, grammarAccess.getParameterAccess().getDescriptionSTRINGTerminalRuleCall_5_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getParameterRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"Description",
                              		lv_Description_10_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleParameter2943); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getParameterAccess().getSemicolonKeyword_6());
                  
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
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleSpecialId"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1466:1: entryRuleSpecialId returns [String current=null] : iv_ruleSpecialId= ruleSpecialId EOF ;
    public final String entryRuleSpecialId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSpecialId = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1467:2: (iv_ruleSpecialId= ruleSpecialId EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1468:2: iv_ruleSpecialId= ruleSpecialId EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSpecialIdRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_entryRuleSpecialId2980);
            iv_ruleSpecialId=ruleSpecialId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSpecialId.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpecialId2991); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSpecialId"


    // $ANTLR start "ruleSpecialId"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1475:1: ruleSpecialId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | kw= 'STRING' | kw= 'UINT32' | kw= 'INT32' | kw= 'UINT64' | kw= 'INT64' | kw= 'FLOAT' | kw= 'DOUBLE' | kw= 'BOOLEAN' | kw= 'ENUM' | kw= 'OS' | kw= 'ALARM' | kw= 'APPMODE' | kw= 'COUNTER' | kw= 'COM' | kw= 'EVENT' | kw= 'IPDU' | kw= 'ISR' | kw= 'MESSAGE' | kw= 'NETWORKMESSAGE' | kw= 'NM' | kw= 'RESOURCE' | kw= 'TASK' | kw= 'OS_TYPE' | kw= 'ALARM_TYPE' | kw= 'APPMODE_TYPE' | kw= 'COUNTER_TYPE' | kw= 'COM_TYPE' | kw= 'EVENT_TYPE' | kw= 'IPDU_TYPE' | kw= 'ISR_TYPE' | kw= 'MESSAGE_TYPE' | kw= 'NETWORKMESSAGE_TYPE' | kw= 'NM_TYPE' | kw= 'RESOURCE_TYPE' | kw= 'TASK_TYPE' ) ;
    public final AntlrDatatypeRuleToken ruleSpecialId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1478:28: ( (this_ID_0= RULE_ID | kw= 'STRING' | kw= 'UINT32' | kw= 'INT32' | kw= 'UINT64' | kw= 'INT64' | kw= 'FLOAT' | kw= 'DOUBLE' | kw= 'BOOLEAN' | kw= 'ENUM' | kw= 'OS' | kw= 'ALARM' | kw= 'APPMODE' | kw= 'COUNTER' | kw= 'COM' | kw= 'EVENT' | kw= 'IPDU' | kw= 'ISR' | kw= 'MESSAGE' | kw= 'NETWORKMESSAGE' | kw= 'NM' | kw= 'RESOURCE' | kw= 'TASK' | kw= 'OS_TYPE' | kw= 'ALARM_TYPE' | kw= 'APPMODE_TYPE' | kw= 'COUNTER_TYPE' | kw= 'COM_TYPE' | kw= 'EVENT_TYPE' | kw= 'IPDU_TYPE' | kw= 'ISR_TYPE' | kw= 'MESSAGE_TYPE' | kw= 'NETWORKMESSAGE_TYPE' | kw= 'NM_TYPE' | kw= 'RESOURCE_TYPE' | kw= 'TASK_TYPE' ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1479:1: (this_ID_0= RULE_ID | kw= 'STRING' | kw= 'UINT32' | kw= 'INT32' | kw= 'UINT64' | kw= 'INT64' | kw= 'FLOAT' | kw= 'DOUBLE' | kw= 'BOOLEAN' | kw= 'ENUM' | kw= 'OS' | kw= 'ALARM' | kw= 'APPMODE' | kw= 'COUNTER' | kw= 'COM' | kw= 'EVENT' | kw= 'IPDU' | kw= 'ISR' | kw= 'MESSAGE' | kw= 'NETWORKMESSAGE' | kw= 'NM' | kw= 'RESOURCE' | kw= 'TASK' | kw= 'OS_TYPE' | kw= 'ALARM_TYPE' | kw= 'APPMODE_TYPE' | kw= 'COUNTER_TYPE' | kw= 'COM_TYPE' | kw= 'EVENT_TYPE' | kw= 'IPDU_TYPE' | kw= 'ISR_TYPE' | kw= 'MESSAGE_TYPE' | kw= 'NETWORKMESSAGE_TYPE' | kw= 'NM_TYPE' | kw= 'RESOURCE_TYPE' | kw= 'TASK_TYPE' )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1479:1: (this_ID_0= RULE_ID | kw= 'STRING' | kw= 'UINT32' | kw= 'INT32' | kw= 'UINT64' | kw= 'INT64' | kw= 'FLOAT' | kw= 'DOUBLE' | kw= 'BOOLEAN' | kw= 'ENUM' | kw= 'OS' | kw= 'ALARM' | kw= 'APPMODE' | kw= 'COUNTER' | kw= 'COM' | kw= 'EVENT' | kw= 'IPDU' | kw= 'ISR' | kw= 'MESSAGE' | kw= 'NETWORKMESSAGE' | kw= 'NM' | kw= 'RESOURCE' | kw= 'TASK' | kw= 'OS_TYPE' | kw= 'ALARM_TYPE' | kw= 'APPMODE_TYPE' | kw= 'COUNTER_TYPE' | kw= 'COM_TYPE' | kw= 'EVENT_TYPE' | kw= 'IPDU_TYPE' | kw= 'ISR_TYPE' | kw= 'MESSAGE_TYPE' | kw= 'NETWORKMESSAGE_TYPE' | kw= 'NM_TYPE' | kw= 'RESOURCE_TYPE' | kw= 'TASK_TYPE' )
            int alt46=36;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt46=1;
                }
                break;
            case 28:
                {
                alt46=2;
                }
                break;
            case 29:
                {
                alt46=3;
                }
                break;
            case 30:
                {
                alt46=4;
                }
                break;
            case 31:
                {
                alt46=5;
                }
                break;
            case 32:
                {
                alt46=6;
                }
                break;
            case 33:
                {
                alt46=7;
                }
                break;
            case 34:
                {
                alt46=8;
                }
                break;
            case 35:
                {
                alt46=9;
                }
                break;
            case 36:
                {
                alt46=10;
                }
                break;
            case 37:
                {
                alt46=11;
                }
                break;
            case 38:
                {
                alt46=12;
                }
                break;
            case 39:
                {
                alt46=13;
                }
                break;
            case 40:
                {
                alt46=14;
                }
                break;
            case 41:
                {
                alt46=15;
                }
                break;
            case 42:
                {
                alt46=16;
                }
                break;
            case 43:
                {
                alt46=17;
                }
                break;
            case 44:
                {
                alt46=18;
                }
                break;
            case 45:
                {
                alt46=19;
                }
                break;
            case 46:
                {
                alt46=20;
                }
                break;
            case 47:
                {
                alt46=21;
                }
                break;
            case 48:
                {
                alt46=22;
                }
                break;
            case 49:
                {
                alt46=23;
                }
                break;
            case 50:
                {
                alt46=24;
                }
                break;
            case 51:
                {
                alt46=25;
                }
                break;
            case 52:
                {
                alt46=26;
                }
                break;
            case 53:
                {
                alt46=27;
                }
                break;
            case 54:
                {
                alt46=28;
                }
                break;
            case 55:
                {
                alt46=29;
                }
                break;
            case 56:
                {
                alt46=30;
                }
                break;
            case 57:
                {
                alt46=31;
                }
                break;
            case 58:
                {
                alt46=32;
                }
                break;
            case 59:
                {
                alt46=33;
                }
                break;
            case 60:
                {
                alt46=34;
                }
                break;
            case 61:
                {
                alt46=35;
                }
                break;
            case 62:
                {
                alt46=36;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1479:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSpecialId3031); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_0, grammarAccess.getSpecialIdAccess().getIDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1488:2: kw= 'STRING'
                    {
                    kw=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleSpecialId3055); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getSTRINGKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1495:2: kw= 'UINT32'
                    {
                    kw=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleSpecialId3074); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getUINT32Keyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1502:2: kw= 'INT32'
                    {
                    kw=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleSpecialId3093); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getINT32Keyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1509:2: kw= 'UINT64'
                    {
                    kw=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleSpecialId3112); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getUINT64Keyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1516:2: kw= 'INT64'
                    {
                    kw=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleSpecialId3131); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getINT64Keyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1523:2: kw= 'FLOAT'
                    {
                    kw=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleSpecialId3150); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getFLOATKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1530:2: kw= 'DOUBLE'
                    {
                    kw=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleSpecialId3169); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getDOUBLEKeyword_7()); 
                          
                    }

                    }
                    break;
                case 9 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1537:2: kw= 'BOOLEAN'
                    {
                    kw=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleSpecialId3188); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getBOOLEANKeyword_8()); 
                          
                    }

                    }
                    break;
                case 10 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1544:2: kw= 'ENUM'
                    {
                    kw=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleSpecialId3207); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getENUMKeyword_9()); 
                          
                    }

                    }
                    break;
                case 11 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1551:2: kw= 'OS'
                    {
                    kw=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleSpecialId3226); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getOSKeyword_10()); 
                          
                    }

                    }
                    break;
                case 12 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1558:2: kw= 'ALARM'
                    {
                    kw=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleSpecialId3245); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getALARMKeyword_11()); 
                          
                    }

                    }
                    break;
                case 13 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1565:2: kw= 'APPMODE'
                    {
                    kw=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleSpecialId3264); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getAPPMODEKeyword_12()); 
                          
                    }

                    }
                    break;
                case 14 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1572:2: kw= 'COUNTER'
                    {
                    kw=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleSpecialId3283); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getCOUNTERKeyword_13()); 
                          
                    }

                    }
                    break;
                case 15 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1579:2: kw= 'COM'
                    {
                    kw=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleSpecialId3302); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getCOMKeyword_14()); 
                          
                    }

                    }
                    break;
                case 16 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1586:2: kw= 'EVENT'
                    {
                    kw=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleSpecialId3321); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getEVENTKeyword_15()); 
                          
                    }

                    }
                    break;
                case 17 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1593:2: kw= 'IPDU'
                    {
                    kw=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleSpecialId3340); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getIPDUKeyword_16()); 
                          
                    }

                    }
                    break;
                case 18 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1600:2: kw= 'ISR'
                    {
                    kw=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleSpecialId3359); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getISRKeyword_17()); 
                          
                    }

                    }
                    break;
                case 19 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1607:2: kw= 'MESSAGE'
                    {
                    kw=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleSpecialId3378); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getMESSAGEKeyword_18()); 
                          
                    }

                    }
                    break;
                case 20 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1614:2: kw= 'NETWORKMESSAGE'
                    {
                    kw=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleSpecialId3397); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getNETWORKMESSAGEKeyword_19()); 
                          
                    }

                    }
                    break;
                case 21 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1621:2: kw= 'NM'
                    {
                    kw=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleSpecialId3416); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getNMKeyword_20()); 
                          
                    }

                    }
                    break;
                case 22 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1628:2: kw= 'RESOURCE'
                    {
                    kw=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleSpecialId3435); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getRESOURCEKeyword_21()); 
                          
                    }

                    }
                    break;
                case 23 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1635:2: kw= 'TASK'
                    {
                    kw=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleSpecialId3454); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getTASKKeyword_22()); 
                          
                    }

                    }
                    break;
                case 24 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1642:2: kw= 'OS_TYPE'
                    {
                    kw=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleSpecialId3473); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getOS_TYPEKeyword_23()); 
                          
                    }

                    }
                    break;
                case 25 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1649:2: kw= 'ALARM_TYPE'
                    {
                    kw=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleSpecialId3492); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getALARM_TYPEKeyword_24()); 
                          
                    }

                    }
                    break;
                case 26 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1656:2: kw= 'APPMODE_TYPE'
                    {
                    kw=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleSpecialId3511); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getAPPMODE_TYPEKeyword_25()); 
                          
                    }

                    }
                    break;
                case 27 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1663:2: kw= 'COUNTER_TYPE'
                    {
                    kw=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleSpecialId3530); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getCOUNTER_TYPEKeyword_26()); 
                          
                    }

                    }
                    break;
                case 28 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1670:2: kw= 'COM_TYPE'
                    {
                    kw=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleSpecialId3549); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getCOM_TYPEKeyword_27()); 
                          
                    }

                    }
                    break;
                case 29 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1677:2: kw= 'EVENT_TYPE'
                    {
                    kw=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleSpecialId3568); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getEVENT_TYPEKeyword_28()); 
                          
                    }

                    }
                    break;
                case 30 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1684:2: kw= 'IPDU_TYPE'
                    {
                    kw=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleSpecialId3587); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getIPDU_TYPEKeyword_29()); 
                          
                    }

                    }
                    break;
                case 31 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1691:2: kw= 'ISR_TYPE'
                    {
                    kw=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleSpecialId3606); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getISR_TYPEKeyword_30()); 
                          
                    }

                    }
                    break;
                case 32 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1698:2: kw= 'MESSAGE_TYPE'
                    {
                    kw=(Token)match(input,58,FollowSets000.FOLLOW_58_in_ruleSpecialId3625); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getMESSAGE_TYPEKeyword_31()); 
                          
                    }

                    }
                    break;
                case 33 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1705:2: kw= 'NETWORKMESSAGE_TYPE'
                    {
                    kw=(Token)match(input,59,FollowSets000.FOLLOW_59_in_ruleSpecialId3644); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getNETWORKMESSAGE_TYPEKeyword_32()); 
                          
                    }

                    }
                    break;
                case 34 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1712:2: kw= 'NM_TYPE'
                    {
                    kw=(Token)match(input,60,FollowSets000.FOLLOW_60_in_ruleSpecialId3663); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getNM_TYPEKeyword_33()); 
                          
                    }

                    }
                    break;
                case 35 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1719:2: kw= 'RESOURCE_TYPE'
                    {
                    kw=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleSpecialId3682); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getRESOURCE_TYPEKeyword_34()); 
                          
                    }

                    }
                    break;
                case 36 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1726:2: kw= 'TASK_TYPE'
                    {
                    kw=(Token)match(input,62,FollowSets000.FOLLOW_62_in_ruleSpecialId3701); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getTASK_TYPEKeyword_35()); 
                          
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
    // $ANTLR end "ruleSpecialId"


    // $ANTLR start "entryRuleGenericValue"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1739:1: entryRuleGenericValue returns [String current=null] : iv_ruleGenericValue= ruleGenericValue EOF ;
    public final String entryRuleGenericValue() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleGenericValue = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1740:2: (iv_ruleGenericValue= ruleGenericValue EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1741:2: iv_ruleGenericValue= ruleGenericValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGenericValueRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleGenericValue_in_entryRuleGenericValue3742);
            iv_ruleGenericValue=ruleGenericValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGenericValue.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGenericValue3753); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGenericValue"


    // $ANTLR start "ruleGenericValue"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1748:1: ruleGenericValue returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_INT_1= ruleINT | this_DOUBLE_2= ruleDOUBLE ) ;
    public final AntlrDatatypeRuleToken ruleGenericValue() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        AntlrDatatypeRuleToken this_INT_1 = null;

        AntlrDatatypeRuleToken this_DOUBLE_2 = null;


         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1751:28: ( (this_STRING_0= RULE_STRING | this_INT_1= ruleINT | this_DOUBLE_2= ruleDOUBLE ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1752:1: (this_STRING_0= RULE_STRING | this_INT_1= ruleINT | this_DOUBLE_2= ruleDOUBLE )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1752:1: (this_STRING_0= RULE_STRING | this_INT_1= ruleINT | this_DOUBLE_2= ruleDOUBLE )
            int alt47=3;
            alt47 = dfa47.predict(input);
            switch (alt47) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1752:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleGenericValue3793); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_STRING_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_STRING_0, grammarAccess.getGenericValueAccess().getSTRINGTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1761:5: this_INT_1= ruleINT
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getGenericValueAccess().getINTParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleINT_in_ruleGenericValue3826);
                    this_INT_1=ruleINT();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_INT_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1773:5: this_DOUBLE_2= ruleDOUBLE
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getGenericValueAccess().getDOUBLEParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleDOUBLE_in_ruleGenericValue3859);
                    this_DOUBLE_2=ruleDOUBLE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_DOUBLE_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
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
    // $ANTLR end "ruleGenericValue"


    // $ANTLR start "entryRuleINT"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1791:1: entryRuleINT returns [String current=null] : iv_ruleINT= ruleINT EOF ;
    public final String entryRuleINT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINT = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1792:2: (iv_ruleINT= ruleINT EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1793:2: iv_ruleINT= ruleINT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getINTRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleINT_in_entryRuleINT3905);
            iv_ruleINT=ruleINT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleINT.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleINT3916); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleINT"


    // $ANTLR start "ruleINT"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1800:1: ruleINT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? ( (this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )* ) | this_ZERO_INT_5= RULE_ZERO_INT | this_HEX_6= RULE_HEX ) ) ;
    public final AntlrDatatypeRuleToken ruleINT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_NON_ZERO_INT_2=null;
        Token this_ZERO_INT_3=null;
        Token this_NON_ZERO_INT_4=null;
        Token this_ZERO_INT_5=null;
        Token this_HEX_6=null;

         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1803:28: ( ( (kw= '+' | kw= '-' )? ( (this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )* ) | this_ZERO_INT_5= RULE_ZERO_INT | this_HEX_6= RULE_HEX ) ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1804:1: ( (kw= '+' | kw= '-' )? ( (this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )* ) | this_ZERO_INT_5= RULE_ZERO_INT | this_HEX_6= RULE_HEX ) )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1804:1: ( (kw= '+' | kw= '-' )? ( (this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )* ) | this_ZERO_INT_5= RULE_ZERO_INT | this_HEX_6= RULE_HEX ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1804:2: (kw= '+' | kw= '-' )? ( (this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )* ) | this_ZERO_INT_5= RULE_ZERO_INT | this_HEX_6= RULE_HEX )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1804:2: (kw= '+' | kw= '-' )?
            int alt48=3;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==63) ) {
                alt48=1;
            }
            else if ( (LA48_0==64) ) {
                alt48=2;
            }
            switch (alt48) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1805:2: kw= '+'
                    {
                    kw=(Token)match(input,63,FollowSets000.FOLLOW_63_in_ruleINT3955); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getINTAccess().getPlusSignKeyword_0_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1812:2: kw= '-'
                    {
                    kw=(Token)match(input,64,FollowSets000.FOLLOW_64_in_ruleINT3974); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getINTAccess().getHyphenMinusKeyword_0_1()); 
                          
                    }

                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1817:3: ( (this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )* ) | this_ZERO_INT_5= RULE_ZERO_INT | this_HEX_6= RULE_HEX )
            int alt50=3;
            switch ( input.LA(1) ) {
            case RULE_NON_ZERO_INT:
                {
                alt50=1;
                }
                break;
            case RULE_ZERO_INT:
                {
                alt50=2;
                }
                break;
            case RULE_HEX:
                {
                alt50=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1817:4: (this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )* )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1817:4: (this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )* )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1817:9: this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )*
                    {
                    this_NON_ZERO_INT_2=(Token)match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_ruleINT3993); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_NON_ZERO_INT_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_NON_ZERO_INT_2, grammarAccess.getINTAccess().getNON_ZERO_INTTerminalRuleCall_1_0_0()); 
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1824:1: (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )*
                    loop49:
                    do {
                        int alt49=3;
                        int LA49_0 = input.LA(1);

                        if ( (LA49_0==RULE_ZERO_INT) ) {
                            alt49=1;
                        }
                        else if ( (LA49_0==RULE_NON_ZERO_INT) ) {
                            alt49=2;
                        }


                        switch (alt49) {
                    	case 1 :
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1824:6: this_ZERO_INT_3= RULE_ZERO_INT
                    	    {
                    	    this_ZERO_INT_3=(Token)match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_ruleINT4014); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		current.merge(this_ZERO_INT_3);
                    	          
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_ZERO_INT_3, grammarAccess.getINTAccess().getZERO_INTTerminalRuleCall_1_0_1_0()); 
                    	          
                    	    }

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1832:10: this_NON_ZERO_INT_4= RULE_NON_ZERO_INT
                    	    {
                    	    this_NON_ZERO_INT_4=(Token)match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_ruleINT4040); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		current.merge(this_NON_ZERO_INT_4);
                    	          
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_NON_ZERO_INT_4, grammarAccess.getINTAccess().getNON_ZERO_INTTerminalRuleCall_1_0_1_1()); 
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop49;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1840:10: this_ZERO_INT_5= RULE_ZERO_INT
                    {
                    this_ZERO_INT_5=(Token)match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_ruleINT4069); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ZERO_INT_5);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ZERO_INT_5, grammarAccess.getINTAccess().getZERO_INTTerminalRuleCall_1_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1848:10: this_HEX_6= RULE_HEX
                    {
                    this_HEX_6=(Token)match(input,RULE_HEX,FollowSets000.FOLLOW_RULE_HEX_in_ruleINT4095); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_HEX_6);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_HEX_6, grammarAccess.getINTAccess().getHEXTerminalRuleCall_1_2()); 
                          
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
    // $ANTLR end "ruleINT"


    // $ANTLR start "entryRuleDOUBLE"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1863:1: entryRuleDOUBLE returns [String current=null] : iv_ruleDOUBLE= ruleDOUBLE EOF ;
    public final String entryRuleDOUBLE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDOUBLE = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1864:2: (iv_ruleDOUBLE= ruleDOUBLE EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1865:2: iv_ruleDOUBLE= ruleDOUBLE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDOUBLERule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleDOUBLE_in_entryRuleDOUBLE4142);
            iv_ruleDOUBLE=ruleDOUBLE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDOUBLE.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDOUBLE4153); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDOUBLE"


    // $ANTLR start "ruleDOUBLE"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1872:1: ruleDOUBLE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? (this_ZERO_INT_2= RULE_ZERO_INT | (this_NON_ZERO_INT_3= RULE_NON_ZERO_INT (this_ZERO_INT_4= RULE_ZERO_INT | this_NON_ZERO_INT_5= RULE_NON_ZERO_INT )* ) ) ( ( '.' )=>kw= '.' ) (this_ZERO_INT_7= RULE_ZERO_INT | this_NON_ZERO_INT_8= RULE_NON_ZERO_INT )+ ) ;
    public final AntlrDatatypeRuleToken ruleDOUBLE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ZERO_INT_2=null;
        Token this_NON_ZERO_INT_3=null;
        Token this_ZERO_INT_4=null;
        Token this_NON_ZERO_INT_5=null;
        Token this_ZERO_INT_7=null;
        Token this_NON_ZERO_INT_8=null;

         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1875:28: ( ( (kw= '+' | kw= '-' )? (this_ZERO_INT_2= RULE_ZERO_INT | (this_NON_ZERO_INT_3= RULE_NON_ZERO_INT (this_ZERO_INT_4= RULE_ZERO_INT | this_NON_ZERO_INT_5= RULE_NON_ZERO_INT )* ) ) ( ( '.' )=>kw= '.' ) (this_ZERO_INT_7= RULE_ZERO_INT | this_NON_ZERO_INT_8= RULE_NON_ZERO_INT )+ ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1876:1: ( (kw= '+' | kw= '-' )? (this_ZERO_INT_2= RULE_ZERO_INT | (this_NON_ZERO_INT_3= RULE_NON_ZERO_INT (this_ZERO_INT_4= RULE_ZERO_INT | this_NON_ZERO_INT_5= RULE_NON_ZERO_INT )* ) ) ( ( '.' )=>kw= '.' ) (this_ZERO_INT_7= RULE_ZERO_INT | this_NON_ZERO_INT_8= RULE_NON_ZERO_INT )+ )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1876:1: ( (kw= '+' | kw= '-' )? (this_ZERO_INT_2= RULE_ZERO_INT | (this_NON_ZERO_INT_3= RULE_NON_ZERO_INT (this_ZERO_INT_4= RULE_ZERO_INT | this_NON_ZERO_INT_5= RULE_NON_ZERO_INT )* ) ) ( ( '.' )=>kw= '.' ) (this_ZERO_INT_7= RULE_ZERO_INT | this_NON_ZERO_INT_8= RULE_NON_ZERO_INT )+ )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1876:2: (kw= '+' | kw= '-' )? (this_ZERO_INT_2= RULE_ZERO_INT | (this_NON_ZERO_INT_3= RULE_NON_ZERO_INT (this_ZERO_INT_4= RULE_ZERO_INT | this_NON_ZERO_INT_5= RULE_NON_ZERO_INT )* ) ) ( ( '.' )=>kw= '.' ) (this_ZERO_INT_7= RULE_ZERO_INT | this_NON_ZERO_INT_8= RULE_NON_ZERO_INT )+
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1876:2: (kw= '+' | kw= '-' )?
            int alt51=3;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==63) ) {
                alt51=1;
            }
            else if ( (LA51_0==64) ) {
                alt51=2;
            }
            switch (alt51) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1877:2: kw= '+'
                    {
                    kw=(Token)match(input,63,FollowSets000.FOLLOW_63_in_ruleDOUBLE4192); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getDOUBLEAccess().getPlusSignKeyword_0_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1884:2: kw= '-'
                    {
                    kw=(Token)match(input,64,FollowSets000.FOLLOW_64_in_ruleDOUBLE4211); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getDOUBLEAccess().getHyphenMinusKeyword_0_1()); 
                          
                    }

                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1889:3: (this_ZERO_INT_2= RULE_ZERO_INT | (this_NON_ZERO_INT_3= RULE_NON_ZERO_INT (this_ZERO_INT_4= RULE_ZERO_INT | this_NON_ZERO_INT_5= RULE_NON_ZERO_INT )* ) )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==RULE_ZERO_INT) ) {
                alt53=1;
            }
            else if ( (LA53_0==RULE_NON_ZERO_INT) ) {
                alt53=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1889:8: this_ZERO_INT_2= RULE_ZERO_INT
                    {
                    this_ZERO_INT_2=(Token)match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_ruleDOUBLE4229); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ZERO_INT_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ZERO_INT_2, grammarAccess.getDOUBLEAccess().getZERO_INTTerminalRuleCall_1_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1897:6: (this_NON_ZERO_INT_3= RULE_NON_ZERO_INT (this_ZERO_INT_4= RULE_ZERO_INT | this_NON_ZERO_INT_5= RULE_NON_ZERO_INT )* )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1897:6: (this_NON_ZERO_INT_3= RULE_NON_ZERO_INT (this_ZERO_INT_4= RULE_ZERO_INT | this_NON_ZERO_INT_5= RULE_NON_ZERO_INT )* )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1897:11: this_NON_ZERO_INT_3= RULE_NON_ZERO_INT (this_ZERO_INT_4= RULE_ZERO_INT | this_NON_ZERO_INT_5= RULE_NON_ZERO_INT )*
                    {
                    this_NON_ZERO_INT_3=(Token)match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_ruleDOUBLE4256); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_NON_ZERO_INT_3);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_NON_ZERO_INT_3, grammarAccess.getDOUBLEAccess().getNON_ZERO_INTTerminalRuleCall_1_1_0()); 
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1904:1: (this_ZERO_INT_4= RULE_ZERO_INT | this_NON_ZERO_INT_5= RULE_NON_ZERO_INT )*
                    loop52:
                    do {
                        int alt52=3;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==RULE_ZERO_INT) ) {
                            alt52=1;
                        }
                        else if ( (LA52_0==RULE_NON_ZERO_INT) ) {
                            alt52=2;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1904:6: this_ZERO_INT_4= RULE_ZERO_INT
                    	    {
                    	    this_ZERO_INT_4=(Token)match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_ruleDOUBLE4277); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		current.merge(this_ZERO_INT_4);
                    	          
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_ZERO_INT_4, grammarAccess.getDOUBLEAccess().getZERO_INTTerminalRuleCall_1_1_1_0()); 
                    	          
                    	    }

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1912:10: this_NON_ZERO_INT_5= RULE_NON_ZERO_INT
                    	    {
                    	    this_NON_ZERO_INT_5=(Token)match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_ruleDOUBLE4303); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		current.merge(this_NON_ZERO_INT_5);
                    	          
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_NON_ZERO_INT_5, grammarAccess.getDOUBLEAccess().getNON_ZERO_INTTerminalRuleCall_1_1_1_1()); 
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop52;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1919:5: ( ( '.' )=>kw= '.' )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1919:6: ( '.' )=>kw= '.'
            {
            kw=(Token)match(input,65,FollowSets000.FOLLOW_65_in_ruleDOUBLE4334); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getDOUBLEAccess().getFullStopKeyword_2()); 
                  
            }

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1927:2: (this_ZERO_INT_7= RULE_ZERO_INT | this_NON_ZERO_INT_8= RULE_NON_ZERO_INT )+
            int cnt54=0;
            loop54:
            do {
                int alt54=3;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==RULE_ZERO_INT) ) {
                    alt54=1;
                }
                else if ( (LA54_0==RULE_NON_ZERO_INT) ) {
                    alt54=2;
                }


                switch (alt54) {
            	case 1 :
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1927:7: this_ZERO_INT_7= RULE_ZERO_INT
            	    {
            	    this_ZERO_INT_7=(Token)match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_ruleDOUBLE4351); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ZERO_INT_7);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ZERO_INT_7, grammarAccess.getDOUBLEAccess().getZERO_INTTerminalRuleCall_3_0()); 
            	          
            	    }

            	    }
            	    break;
            	case 2 :
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1935:10: this_NON_ZERO_INT_8= RULE_NON_ZERO_INT
            	    {
            	    this_NON_ZERO_INT_8=(Token)match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_ruleDOUBLE4377); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_NON_ZERO_INT_8);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NON_ZERO_INT_8, grammarAccess.getDOUBLEAccess().getNON_ZERO_INTTerminalRuleCall_3_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt54 >= 1 ) break loop54;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(54, input);
                        throw eee;
                }
                cnt54++;
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
    // $ANTLR end "ruleDOUBLE"


    // $ANTLR start "ruleVType"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1950:1: ruleVType returns [Enumerator current=null] : ( (enumLiteral_0= 'STRING' ) | (enumLiteral_1= 'UINT32' ) | (enumLiteral_2= 'INT32' ) | (enumLiteral_3= 'UINT64' ) | (enumLiteral_4= 'INT64' ) | (enumLiteral_5= 'FLOAT' ) | (enumLiteral_6= 'DOUBLE' ) ) ;
    public final Enumerator ruleVType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;

         enterRule(); 
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1952:28: ( ( (enumLiteral_0= 'STRING' ) | (enumLiteral_1= 'UINT32' ) | (enumLiteral_2= 'INT32' ) | (enumLiteral_3= 'UINT64' ) | (enumLiteral_4= 'INT64' ) | (enumLiteral_5= 'FLOAT' ) | (enumLiteral_6= 'DOUBLE' ) ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1953:1: ( (enumLiteral_0= 'STRING' ) | (enumLiteral_1= 'UINT32' ) | (enumLiteral_2= 'INT32' ) | (enumLiteral_3= 'UINT64' ) | (enumLiteral_4= 'INT64' ) | (enumLiteral_5= 'FLOAT' ) | (enumLiteral_6= 'DOUBLE' ) )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1953:1: ( (enumLiteral_0= 'STRING' ) | (enumLiteral_1= 'UINT32' ) | (enumLiteral_2= 'INT32' ) | (enumLiteral_3= 'UINT64' ) | (enumLiteral_4= 'INT64' ) | (enumLiteral_5= 'FLOAT' ) | (enumLiteral_6= 'DOUBLE' ) )
            int alt55=7;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt55=1;
                }
                break;
            case 29:
                {
                alt55=2;
                }
                break;
            case 30:
                {
                alt55=3;
                }
                break;
            case 31:
                {
                alt55=4;
                }
                break;
            case 32:
                {
                alt55=5;
                }
                break;
            case 33:
                {
                alt55=6;
                }
                break;
            case 34:
                {
                alt55=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }

            switch (alt55) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1953:2: (enumLiteral_0= 'STRING' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1953:2: (enumLiteral_0= 'STRING' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1953:4: enumLiteral_0= 'STRING'
                    {
                    enumLiteral_0=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleVType4438); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVTypeAccess().getSTRINGEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getVTypeAccess().getSTRINGEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1959:6: (enumLiteral_1= 'UINT32' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1959:6: (enumLiteral_1= 'UINT32' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1959:8: enumLiteral_1= 'UINT32'
                    {
                    enumLiteral_1=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleVType4455); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVTypeAccess().getUINT32EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getVTypeAccess().getUINT32EnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1965:6: (enumLiteral_2= 'INT32' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1965:6: (enumLiteral_2= 'INT32' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1965:8: enumLiteral_2= 'INT32'
                    {
                    enumLiteral_2=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleVType4472); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVTypeAccess().getINT32EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getVTypeAccess().getINT32EnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1971:6: (enumLiteral_3= 'UINT64' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1971:6: (enumLiteral_3= 'UINT64' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1971:8: enumLiteral_3= 'UINT64'
                    {
                    enumLiteral_3=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleVType4489); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVTypeAccess().getUINT64EnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getVTypeAccess().getUINT64EnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1977:6: (enumLiteral_4= 'INT64' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1977:6: (enumLiteral_4= 'INT64' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1977:8: enumLiteral_4= 'INT64'
                    {
                    enumLiteral_4=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleVType4506); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVTypeAccess().getINT64EnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getVTypeAccess().getINT64EnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1983:6: (enumLiteral_5= 'FLOAT' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1983:6: (enumLiteral_5= 'FLOAT' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1983:8: enumLiteral_5= 'FLOAT'
                    {
                    enumLiteral_5=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleVType4523); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVTypeAccess().getFLOATEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getVTypeAccess().getFLOATEnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1989:6: (enumLiteral_6= 'DOUBLE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1989:6: (enumLiteral_6= 'DOUBLE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1989:8: enumLiteral_6= 'DOUBLE'
                    {
                    enumLiteral_6=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleVType4540); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVTypeAccess().getDOUBLEEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_6, grammarAccess.getVTypeAccess().getDOUBLEEnumLiteralDeclaration_6()); 
                          
                    }

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
    // $ANTLR end "ruleVType"


    // $ANTLR start "ruleEType"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1999:1: ruleEType returns [Enumerator current=null] : ( (enumLiteral_0= 'BOOLEAN' ) | (enumLiteral_1= 'ENUM' ) ) ;
    public final Enumerator ruleEType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2001:28: ( ( (enumLiteral_0= 'BOOLEAN' ) | (enumLiteral_1= 'ENUM' ) ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2002:1: ( (enumLiteral_0= 'BOOLEAN' ) | (enumLiteral_1= 'ENUM' ) )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2002:1: ( (enumLiteral_0= 'BOOLEAN' ) | (enumLiteral_1= 'ENUM' ) )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==35) ) {
                alt56=1;
            }
            else if ( (LA56_0==36) ) {
                alt56=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2002:2: (enumLiteral_0= 'BOOLEAN' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2002:2: (enumLiteral_0= 'BOOLEAN' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2002:4: enumLiteral_0= 'BOOLEAN'
                    {
                    enumLiteral_0=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleEType4585); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getETypeAccess().getBOOLEANEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getETypeAccess().getBOOLEANEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2008:6: (enumLiteral_1= 'ENUM' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2008:6: (enumLiteral_1= 'ENUM' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2008:8: enumLiteral_1= 'ENUM'
                    {
                    enumLiteral_1=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleEType4602); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getETypeAccess().getENUMEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getETypeAccess().getENUMEnumLiteralDeclaration_1()); 
                          
                    }

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
    // $ANTLR end "ruleEType"


    // $ANTLR start "ruleObjectType"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2018:1: ruleObjectType returns [Enumerator current=null] : ( (enumLiteral_0= 'OS' ) | (enumLiteral_1= 'ALARM' ) | (enumLiteral_2= 'APPMODE' ) | (enumLiteral_3= 'COUNTER' ) | (enumLiteral_4= 'COM' ) | (enumLiteral_5= 'EVENT' ) | (enumLiteral_6= 'IPDU' ) | (enumLiteral_7= 'ISR' ) | (enumLiteral_8= 'MESSAGE' ) | (enumLiteral_9= 'NETWORKMESSAGE' ) | (enumLiteral_10= 'NM' ) | (enumLiteral_11= 'RESOURCE' ) | (enumLiteral_12= 'TASK' ) | (enumLiteral_13= 'APPLICATION' ) ) ;
    public final Enumerator ruleObjectType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;
        Token enumLiteral_11=null;
        Token enumLiteral_12=null;
        Token enumLiteral_13=null;

         enterRule(); 
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2020:28: ( ( (enumLiteral_0= 'OS' ) | (enumLiteral_1= 'ALARM' ) | (enumLiteral_2= 'APPMODE' ) | (enumLiteral_3= 'COUNTER' ) | (enumLiteral_4= 'COM' ) | (enumLiteral_5= 'EVENT' ) | (enumLiteral_6= 'IPDU' ) | (enumLiteral_7= 'ISR' ) | (enumLiteral_8= 'MESSAGE' ) | (enumLiteral_9= 'NETWORKMESSAGE' ) | (enumLiteral_10= 'NM' ) | (enumLiteral_11= 'RESOURCE' ) | (enumLiteral_12= 'TASK' ) | (enumLiteral_13= 'APPLICATION' ) ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2021:1: ( (enumLiteral_0= 'OS' ) | (enumLiteral_1= 'ALARM' ) | (enumLiteral_2= 'APPMODE' ) | (enumLiteral_3= 'COUNTER' ) | (enumLiteral_4= 'COM' ) | (enumLiteral_5= 'EVENT' ) | (enumLiteral_6= 'IPDU' ) | (enumLiteral_7= 'ISR' ) | (enumLiteral_8= 'MESSAGE' ) | (enumLiteral_9= 'NETWORKMESSAGE' ) | (enumLiteral_10= 'NM' ) | (enumLiteral_11= 'RESOURCE' ) | (enumLiteral_12= 'TASK' ) | (enumLiteral_13= 'APPLICATION' ) )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2021:1: ( (enumLiteral_0= 'OS' ) | (enumLiteral_1= 'ALARM' ) | (enumLiteral_2= 'APPMODE' ) | (enumLiteral_3= 'COUNTER' ) | (enumLiteral_4= 'COM' ) | (enumLiteral_5= 'EVENT' ) | (enumLiteral_6= 'IPDU' ) | (enumLiteral_7= 'ISR' ) | (enumLiteral_8= 'MESSAGE' ) | (enumLiteral_9= 'NETWORKMESSAGE' ) | (enumLiteral_10= 'NM' ) | (enumLiteral_11= 'RESOURCE' ) | (enumLiteral_12= 'TASK' ) | (enumLiteral_13= 'APPLICATION' ) )
            int alt57=14;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt57=1;
                }
                break;
            case 38:
                {
                alt57=2;
                }
                break;
            case 39:
                {
                alt57=3;
                }
                break;
            case 40:
                {
                alt57=4;
                }
                break;
            case 41:
                {
                alt57=5;
                }
                break;
            case 42:
                {
                alt57=6;
                }
                break;
            case 43:
                {
                alt57=7;
                }
                break;
            case 44:
                {
                alt57=8;
                }
                break;
            case 45:
                {
                alt57=9;
                }
                break;
            case 46:
                {
                alt57=10;
                }
                break;
            case 47:
                {
                alt57=11;
                }
                break;
            case 48:
                {
                alt57=12;
                }
                break;
            case 49:
                {
                alt57=13;
                }
                break;
            case 66:
                {
                alt57=14;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }

            switch (alt57) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2021:2: (enumLiteral_0= 'OS' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2021:2: (enumLiteral_0= 'OS' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2021:4: enumLiteral_0= 'OS'
                    {
                    enumLiteral_0=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleObjectType4647); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getOSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getObjectTypeAccess().getOSEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2027:6: (enumLiteral_1= 'ALARM' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2027:6: (enumLiteral_1= 'ALARM' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2027:8: enumLiteral_1= 'ALARM'
                    {
                    enumLiteral_1=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleObjectType4664); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getALARMEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getObjectTypeAccess().getALARMEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2033:6: (enumLiteral_2= 'APPMODE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2033:6: (enumLiteral_2= 'APPMODE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2033:8: enumLiteral_2= 'APPMODE'
                    {
                    enumLiteral_2=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleObjectType4681); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getAPPMODEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getObjectTypeAccess().getAPPMODEEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2039:6: (enumLiteral_3= 'COUNTER' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2039:6: (enumLiteral_3= 'COUNTER' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2039:8: enumLiteral_3= 'COUNTER'
                    {
                    enumLiteral_3=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleObjectType4698); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getCOUNTEREnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getObjectTypeAccess().getCOUNTEREnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2045:6: (enumLiteral_4= 'COM' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2045:6: (enumLiteral_4= 'COM' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2045:8: enumLiteral_4= 'COM'
                    {
                    enumLiteral_4=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleObjectType4715); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getCOMEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getObjectTypeAccess().getCOMEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2051:6: (enumLiteral_5= 'EVENT' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2051:6: (enumLiteral_5= 'EVENT' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2051:8: enumLiteral_5= 'EVENT'
                    {
                    enumLiteral_5=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleObjectType4732); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getEVENTEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getObjectTypeAccess().getEVENTEnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2057:6: (enumLiteral_6= 'IPDU' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2057:6: (enumLiteral_6= 'IPDU' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2057:8: enumLiteral_6= 'IPDU'
                    {
                    enumLiteral_6=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleObjectType4749); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getIPDUEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_6, grammarAccess.getObjectTypeAccess().getIPDUEnumLiteralDeclaration_6()); 
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2063:6: (enumLiteral_7= 'ISR' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2063:6: (enumLiteral_7= 'ISR' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2063:8: enumLiteral_7= 'ISR'
                    {
                    enumLiteral_7=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleObjectType4766); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getISREnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_7, grammarAccess.getObjectTypeAccess().getISREnumLiteralDeclaration_7()); 
                          
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2069:6: (enumLiteral_8= 'MESSAGE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2069:6: (enumLiteral_8= 'MESSAGE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2069:8: enumLiteral_8= 'MESSAGE'
                    {
                    enumLiteral_8=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleObjectType4783); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getMESSAGEEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_8, grammarAccess.getObjectTypeAccess().getMESSAGEEnumLiteralDeclaration_8()); 
                          
                    }

                    }


                    }
                    break;
                case 10 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2075:6: (enumLiteral_9= 'NETWORKMESSAGE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2075:6: (enumLiteral_9= 'NETWORKMESSAGE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2075:8: enumLiteral_9= 'NETWORKMESSAGE'
                    {
                    enumLiteral_9=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleObjectType4800); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getNETWORKMESSAGEEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_9, grammarAccess.getObjectTypeAccess().getNETWORKMESSAGEEnumLiteralDeclaration_9()); 
                          
                    }

                    }


                    }
                    break;
                case 11 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2081:6: (enumLiteral_10= 'NM' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2081:6: (enumLiteral_10= 'NM' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2081:8: enumLiteral_10= 'NM'
                    {
                    enumLiteral_10=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleObjectType4817); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getNMEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_10, grammarAccess.getObjectTypeAccess().getNMEnumLiteralDeclaration_10()); 
                          
                    }

                    }


                    }
                    break;
                case 12 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2087:6: (enumLiteral_11= 'RESOURCE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2087:6: (enumLiteral_11= 'RESOURCE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2087:8: enumLiteral_11= 'RESOURCE'
                    {
                    enumLiteral_11=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleObjectType4834); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getRESOURCEEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_11, grammarAccess.getObjectTypeAccess().getRESOURCEEnumLiteralDeclaration_11()); 
                          
                    }

                    }


                    }
                    break;
                case 13 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2093:6: (enumLiteral_12= 'TASK' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2093:6: (enumLiteral_12= 'TASK' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2093:8: enumLiteral_12= 'TASK'
                    {
                    enumLiteral_12=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleObjectType4851); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getTASKEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_12, grammarAccess.getObjectTypeAccess().getTASKEnumLiteralDeclaration_12()); 
                          
                    }

                    }


                    }
                    break;
                case 14 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2099:6: (enumLiteral_13= 'APPLICATION' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2099:6: (enumLiteral_13= 'APPLICATION' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2099:8: enumLiteral_13= 'APPLICATION'
                    {
                    enumLiteral_13=(Token)match(input,66,FollowSets000.FOLLOW_66_in_ruleObjectType4868); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getAPPLICATIONEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_13, grammarAccess.getObjectTypeAccess().getAPPLICATIONEnumLiteralDeclaration_13()); 
                          
                    }

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
    // $ANTLR end "ruleObjectType"


    // $ANTLR start "ruleObjectTypeRef"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2109:1: ruleObjectTypeRef returns [Enumerator current=null] : ( (enumLiteral_0= 'OS_TYPE' ) | (enumLiteral_1= 'ALARM_TYPE' ) | (enumLiteral_2= 'APPMODE_TYPE' ) | (enumLiteral_3= 'COUNTER_TYPE' ) | (enumLiteral_4= 'COM_TYPE' ) | (enumLiteral_5= 'EVENT_TYPE' ) | (enumLiteral_6= 'IPDU_TYPE' ) | (enumLiteral_7= 'ISR_TYPE' ) | (enumLiteral_8= 'MESSAGE_TYPE' ) | (enumLiteral_9= 'NETWORKMESSAGE_TYPE' ) | (enumLiteral_10= 'NM_TYPE' ) | (enumLiteral_11= 'RESOURCE_TYPE' ) | (enumLiteral_12= 'TASK_TYPE' ) | (enumLiteral_13= 'APPLICATION_TYPE' ) ) ;
    public final Enumerator ruleObjectTypeRef() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;
        Token enumLiteral_11=null;
        Token enumLiteral_12=null;
        Token enumLiteral_13=null;

         enterRule(); 
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2111:28: ( ( (enumLiteral_0= 'OS_TYPE' ) | (enumLiteral_1= 'ALARM_TYPE' ) | (enumLiteral_2= 'APPMODE_TYPE' ) | (enumLiteral_3= 'COUNTER_TYPE' ) | (enumLiteral_4= 'COM_TYPE' ) | (enumLiteral_5= 'EVENT_TYPE' ) | (enumLiteral_6= 'IPDU_TYPE' ) | (enumLiteral_7= 'ISR_TYPE' ) | (enumLiteral_8= 'MESSAGE_TYPE' ) | (enumLiteral_9= 'NETWORKMESSAGE_TYPE' ) | (enumLiteral_10= 'NM_TYPE' ) | (enumLiteral_11= 'RESOURCE_TYPE' ) | (enumLiteral_12= 'TASK_TYPE' ) | (enumLiteral_13= 'APPLICATION_TYPE' ) ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2112:1: ( (enumLiteral_0= 'OS_TYPE' ) | (enumLiteral_1= 'ALARM_TYPE' ) | (enumLiteral_2= 'APPMODE_TYPE' ) | (enumLiteral_3= 'COUNTER_TYPE' ) | (enumLiteral_4= 'COM_TYPE' ) | (enumLiteral_5= 'EVENT_TYPE' ) | (enumLiteral_6= 'IPDU_TYPE' ) | (enumLiteral_7= 'ISR_TYPE' ) | (enumLiteral_8= 'MESSAGE_TYPE' ) | (enumLiteral_9= 'NETWORKMESSAGE_TYPE' ) | (enumLiteral_10= 'NM_TYPE' ) | (enumLiteral_11= 'RESOURCE_TYPE' ) | (enumLiteral_12= 'TASK_TYPE' ) | (enumLiteral_13= 'APPLICATION_TYPE' ) )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2112:1: ( (enumLiteral_0= 'OS_TYPE' ) | (enumLiteral_1= 'ALARM_TYPE' ) | (enumLiteral_2= 'APPMODE_TYPE' ) | (enumLiteral_3= 'COUNTER_TYPE' ) | (enumLiteral_4= 'COM_TYPE' ) | (enumLiteral_5= 'EVENT_TYPE' ) | (enumLiteral_6= 'IPDU_TYPE' ) | (enumLiteral_7= 'ISR_TYPE' ) | (enumLiteral_8= 'MESSAGE_TYPE' ) | (enumLiteral_9= 'NETWORKMESSAGE_TYPE' ) | (enumLiteral_10= 'NM_TYPE' ) | (enumLiteral_11= 'RESOURCE_TYPE' ) | (enumLiteral_12= 'TASK_TYPE' ) | (enumLiteral_13= 'APPLICATION_TYPE' ) )
            int alt58=14;
            switch ( input.LA(1) ) {
            case 50:
                {
                alt58=1;
                }
                break;
            case 51:
                {
                alt58=2;
                }
                break;
            case 52:
                {
                alt58=3;
                }
                break;
            case 53:
                {
                alt58=4;
                }
                break;
            case 54:
                {
                alt58=5;
                }
                break;
            case 55:
                {
                alt58=6;
                }
                break;
            case 56:
                {
                alt58=7;
                }
                break;
            case 57:
                {
                alt58=8;
                }
                break;
            case 58:
                {
                alt58=9;
                }
                break;
            case 59:
                {
                alt58=10;
                }
                break;
            case 60:
                {
                alt58=11;
                }
                break;
            case 61:
                {
                alt58=12;
                }
                break;
            case 62:
                {
                alt58=13;
                }
                break;
            case 67:
                {
                alt58=14;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }

            switch (alt58) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2112:2: (enumLiteral_0= 'OS_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2112:2: (enumLiteral_0= 'OS_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2112:4: enumLiteral_0= 'OS_TYPE'
                    {
                    enumLiteral_0=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleObjectTypeRef4913); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getOSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getObjectTypeRefAccess().getOSEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2118:6: (enumLiteral_1= 'ALARM_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2118:6: (enumLiteral_1= 'ALARM_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2118:8: enumLiteral_1= 'ALARM_TYPE'
                    {
                    enumLiteral_1=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleObjectTypeRef4930); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getALARMEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getObjectTypeRefAccess().getALARMEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2124:6: (enumLiteral_2= 'APPMODE_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2124:6: (enumLiteral_2= 'APPMODE_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2124:8: enumLiteral_2= 'APPMODE_TYPE'
                    {
                    enumLiteral_2=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleObjectTypeRef4947); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getAPPMODEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getObjectTypeRefAccess().getAPPMODEEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2130:6: (enumLiteral_3= 'COUNTER_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2130:6: (enumLiteral_3= 'COUNTER_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2130:8: enumLiteral_3= 'COUNTER_TYPE'
                    {
                    enumLiteral_3=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleObjectTypeRef4964); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getCOUNTEREnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getObjectTypeRefAccess().getCOUNTEREnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2136:6: (enumLiteral_4= 'COM_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2136:6: (enumLiteral_4= 'COM_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2136:8: enumLiteral_4= 'COM_TYPE'
                    {
                    enumLiteral_4=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleObjectTypeRef4981); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getCOMEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getObjectTypeRefAccess().getCOMEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2142:6: (enumLiteral_5= 'EVENT_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2142:6: (enumLiteral_5= 'EVENT_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2142:8: enumLiteral_5= 'EVENT_TYPE'
                    {
                    enumLiteral_5=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleObjectTypeRef4998); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getEVENTEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getObjectTypeRefAccess().getEVENTEnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2148:6: (enumLiteral_6= 'IPDU_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2148:6: (enumLiteral_6= 'IPDU_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2148:8: enumLiteral_6= 'IPDU_TYPE'
                    {
                    enumLiteral_6=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleObjectTypeRef5015); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getIPDUEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_6, grammarAccess.getObjectTypeRefAccess().getIPDUEnumLiteralDeclaration_6()); 
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2154:6: (enumLiteral_7= 'ISR_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2154:6: (enumLiteral_7= 'ISR_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2154:8: enumLiteral_7= 'ISR_TYPE'
                    {
                    enumLiteral_7=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleObjectTypeRef5032); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getISREnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_7, grammarAccess.getObjectTypeRefAccess().getISREnumLiteralDeclaration_7()); 
                          
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2160:6: (enumLiteral_8= 'MESSAGE_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2160:6: (enumLiteral_8= 'MESSAGE_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2160:8: enumLiteral_8= 'MESSAGE_TYPE'
                    {
                    enumLiteral_8=(Token)match(input,58,FollowSets000.FOLLOW_58_in_ruleObjectTypeRef5049); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getMESSAGEEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_8, grammarAccess.getObjectTypeRefAccess().getMESSAGEEnumLiteralDeclaration_8()); 
                          
                    }

                    }


                    }
                    break;
                case 10 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2166:6: (enumLiteral_9= 'NETWORKMESSAGE_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2166:6: (enumLiteral_9= 'NETWORKMESSAGE_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2166:8: enumLiteral_9= 'NETWORKMESSAGE_TYPE'
                    {
                    enumLiteral_9=(Token)match(input,59,FollowSets000.FOLLOW_59_in_ruleObjectTypeRef5066); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getNETWORKMESSAGEEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_9, grammarAccess.getObjectTypeRefAccess().getNETWORKMESSAGEEnumLiteralDeclaration_9()); 
                          
                    }

                    }


                    }
                    break;
                case 11 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2172:6: (enumLiteral_10= 'NM_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2172:6: (enumLiteral_10= 'NM_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2172:8: enumLiteral_10= 'NM_TYPE'
                    {
                    enumLiteral_10=(Token)match(input,60,FollowSets000.FOLLOW_60_in_ruleObjectTypeRef5083); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getNMEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_10, grammarAccess.getObjectTypeRefAccess().getNMEnumLiteralDeclaration_10()); 
                          
                    }

                    }


                    }
                    break;
                case 12 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2178:6: (enumLiteral_11= 'RESOURCE_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2178:6: (enumLiteral_11= 'RESOURCE_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2178:8: enumLiteral_11= 'RESOURCE_TYPE'
                    {
                    enumLiteral_11=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleObjectTypeRef5100); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getRESOURCEEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_11, grammarAccess.getObjectTypeRefAccess().getRESOURCEEnumLiteralDeclaration_11()); 
                          
                    }

                    }


                    }
                    break;
                case 13 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2184:6: (enumLiteral_12= 'TASK_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2184:6: (enumLiteral_12= 'TASK_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2184:8: enumLiteral_12= 'TASK_TYPE'
                    {
                    enumLiteral_12=(Token)match(input,62,FollowSets000.FOLLOW_62_in_ruleObjectTypeRef5117); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getTASKEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_12, grammarAccess.getObjectTypeRefAccess().getTASKEnumLiteralDeclaration_12()); 
                          
                    }

                    }


                    }
                    break;
                case 14 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2190:6: (enumLiteral_13= 'APPLICATION_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2190:6: (enumLiteral_13= 'APPLICATION_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2190:8: enumLiteral_13= 'APPLICATION_TYPE'
                    {
                    enumLiteral_13=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleObjectTypeRef5134); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getAPPLICATIONEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_13, grammarAccess.getObjectTypeRefAccess().getAPPLICATIONEnumLiteralDeclaration_13()); 
                          
                    }

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
    // $ANTLR end "ruleObjectTypeRef"

    // $ANTLR start synpred1_InternalOil
    public final void synpred1_InternalOil_fragment() throws RecognitionException {   
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:644:3: ( ( 'AUTO' ) )
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:645:1: ( 'AUTO' )
        {
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:645:1: ( 'AUTO' )
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:646:2: 'AUTO'
        {
        match(input,27,FollowSets000.FOLLOW_27_in_synpred1_InternalOil1353); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred1_InternalOil

    // $ANTLR start synpred2_InternalOil
    public final void synpred2_InternalOil_fragment() throws RecognitionException {   
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:873:3: ( ( 'AUTO' ) )
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:874:1: ( 'AUTO' )
        {
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:874:1: ( 'AUTO' )
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:875:2: 'AUTO'
        {
        match(input,27,FollowSets000.FOLLOW_27_in_synpred2_InternalOil1790); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred2_InternalOil

    // $ANTLR start synpred3_InternalOil
    public final void synpred3_InternalOil_fragment() throws RecognitionException {   
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1129:3: ( ( 'AUTO' ) )
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1130:1: ( 'AUTO' )
        {
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1130:1: ( 'AUTO' )
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1131:2: 'AUTO'
        {
        match(input,27,FollowSets000.FOLLOW_27_in_synpred3_InternalOil2303); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred3_InternalOil

    // $ANTLR start synpred4_InternalOil
    public final void synpred4_InternalOil_fragment() throws RecognitionException {   
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1350:3: ( ( 'AUTO' ) )
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1351:1: ( 'AUTO' )
        {
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1351:1: ( 'AUTO' )
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1352:2: 'AUTO'
        {
        match(input,27,FollowSets000.FOLLOW_27_in_synpred4_InternalOil2757); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred4_InternalOil

    // Delegated rules

    public final boolean synpred2_InternalOil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalOil_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalOil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalOil_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalOil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalOil_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalOil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalOil_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA16 dfa16 = new DFA16(this);
    protected DFA11 dfa11 = new DFA11(this);
    protected DFA12 dfa12 = new DFA12(this);
    protected DFA13 dfa13 = new DFA13(this);
    protected DFA14 dfa14 = new DFA14(this);
    protected DFA47 dfa47 = new DFA47(this);
    static final String DFA16_eotS =
        "\15\uffff";
    static final String DFA16_eofS =
        "\15\uffff";
    static final String DFA16_minS =
        "\4\6\2\27\3\6\2\uffff\2\6";
    static final String DFA16_maxS =
        "\1\100\2\10\2\101\1\31\2\101\1\7\2\uffff\2\31";
    static final String DFA16_acceptS =
        "\11\uffff\1\2\1\1\2\uffff";
    static final String DFA16_specialS =
        "\15\uffff}>";
    static final String[] DFA16_transitionS = {
            "\1\3\1\4\1\5\66\uffff\1\1\1\2",
            "\1\3\1\4\1\5",
            "\1\3\1\4\1\5",
            "\1\7\1\6\17\uffff\1\12\2\11\47\uffff\1\10",
            "\1\12\2\11\47\uffff\1\10",
            "\1\12\2\11",
            "\1\7\1\6\17\uffff\1\12\2\11\47\uffff\1\10",
            "\1\7\1\6\17\uffff\1\12\2\11\47\uffff\1\10",
            "\1\14\1\13",
            "",
            "",
            "\1\14\1\13\17\uffff\1\12\2\11",
            "\1\14\1\13\17\uffff\1\12\2\11"
    };

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "526:1: ( ( ( ruleINT | ruleDOUBLE ) otherlv_6= '..' ( ruleINT | ruleDOUBLE ) ) | ( ( ruleINT | ruleDOUBLE ) (otherlv_11= ',' ( ruleINT | ruleDOUBLE ) )* ) )";
        }
    }
    static final String DFA11_eotS =
        "\11\uffff";
    static final String DFA11_eofS =
        "\11\uffff";
    static final String DFA11_minS =
        "\4\6\1\27\1\uffff\2\6\1\uffff";
    static final String DFA11_maxS =
        "\1\100\2\10\2\101\1\uffff\2\101\1\uffff";
    static final String DFA11_acceptS =
        "\5\uffff\1\1\2\uffff\1\2";
    static final String DFA11_specialS =
        "\11\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\3\1\4\1\5\66\uffff\1\1\1\2",
            "\1\3\1\4\1\5",
            "\1\3\1\4\1\5",
            "\1\7\1\6\17\uffff\1\5\51\uffff\1\10",
            "\1\5\51\uffff\1\10",
            "",
            "\1\7\1\6\17\uffff\1\5\51\uffff\1\10",
            "\1\7\1\6\17\uffff\1\5\51\uffff\1\10",
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "526:3: ( ruleINT | ruleDOUBLE )";
        }
    }
    static final String DFA12_eotS =
        "\11\uffff";
    static final String DFA12_eofS =
        "\11\uffff";
    static final String DFA12_minS =
        "\4\6\1\31\1\uffff\2\6\1\uffff";
    static final String DFA12_maxS =
        "\1\100\2\10\2\101\1\uffff\2\101\1\uffff";
    static final String DFA12_acceptS =
        "\5\uffff\1\1\2\uffff\1\2";
    static final String DFA12_specialS =
        "\11\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\3\1\4\1\5\66\uffff\1\1\1\2",
            "\1\3\1\4\1\5",
            "\1\3\1\4\1\5",
            "\1\7\1\6\21\uffff\1\5\47\uffff\1\10",
            "\1\5\47\uffff\1\10",
            "",
            "\1\7\1\6\21\uffff\1\5\47\uffff\1\10",
            "\1\7\1\6\21\uffff\1\5\47\uffff\1\10",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "547:1: ( ruleINT | ruleDOUBLE )";
        }
    }
    static final String DFA13_eotS =
        "\11\uffff";
    static final String DFA13_eofS =
        "\11\uffff";
    static final String DFA13_minS =
        "\4\6\1\30\1\uffff\2\6\1\uffff";
    static final String DFA13_maxS =
        "\1\100\2\10\2\101\1\uffff\2\101\1\uffff";
    static final String DFA13_acceptS =
        "\5\uffff\1\1\2\uffff\1\2";
    static final String DFA13_specialS =
        "\11\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\3\1\4\1\5\66\uffff\1\1\1\2",
            "\1\3\1\4\1\5",
            "\1\3\1\4\1\5",
            "\1\7\1\6\20\uffff\2\5\47\uffff\1\10",
            "\2\5\47\uffff\1\10",
            "",
            "\1\7\1\6\20\uffff\2\5\47\uffff\1\10",
            "\1\7\1\6\20\uffff\2\5\47\uffff\1\10",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "565:7: ( ruleINT | ruleDOUBLE )";
        }
    }
    static final String DFA14_eotS =
        "\11\uffff";
    static final String DFA14_eofS =
        "\11\uffff";
    static final String DFA14_minS =
        "\4\6\1\30\1\uffff\2\6\1\uffff";
    static final String DFA14_maxS =
        "\1\100\2\10\2\101\1\uffff\2\101\1\uffff";
    static final String DFA14_acceptS =
        "\5\uffff\1\1\2\uffff\1\2";
    static final String DFA14_specialS =
        "\11\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\3\1\4\1\5\66\uffff\1\1\1\2",
            "\1\3\1\4\1\5",
            "\1\3\1\4\1\5",
            "\1\7\1\6\20\uffff\2\5\47\uffff\1\10",
            "\2\5\47\uffff\1\10",
            "",
            "\1\7\1\6\20\uffff\2\5\47\uffff\1\10",
            "\1\7\1\6\20\uffff\2\5\47\uffff\1\10",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "586:1: ( ruleINT | ruleDOUBLE )";
        }
    }
    static final String DFA47_eotS =
        "\12\uffff";
    static final String DFA47_eofS =
        "\4\uffff\2\6\1\uffff\2\6\1\uffff";
    static final String DFA47_minS =
        "\1\4\1\uffff\3\6\1\17\1\uffff\2\6\1\uffff";
    static final String DFA47_maxS =
        "\1\100\1\uffff\2\10\2\101\1\uffff\2\101\1\uffff";
    static final String DFA47_acceptS =
        "\1\uffff\1\1\4\uffff\1\2\2\uffff\1\3";
    static final String DFA47_specialS =
        "\12\uffff}>";
    static final String[] DFA47_transitionS = {
            "\1\1\1\uffff\1\4\1\5\1\6\66\uffff\1\2\1\3",
            "",
            "\1\4\1\5\1\6",
            "\1\4\1\5\1\6",
            "\1\10\1\7\7\uffff\1\6\1\uffff\1\6\1\uffff\1\6\55\uffff\1\11",
            "\1\6\1\uffff\1\6\1\uffff\1\6\55\uffff\1\11",
            "",
            "\1\10\1\7\7\uffff\1\6\1\uffff\1\6\1\uffff\1\6\55\uffff\1\11",
            "\1\10\1\7\7\uffff\1\6\1\uffff\1\6\1\uffff\1\6\55\uffff\1\11",
            ""
    };

    static final short[] DFA47_eot = DFA.unpackEncodedString(DFA47_eotS);
    static final short[] DFA47_eof = DFA.unpackEncodedString(DFA47_eofS);
    static final char[] DFA47_min = DFA.unpackEncodedStringToUnsignedChars(DFA47_minS);
    static final char[] DFA47_max = DFA.unpackEncodedStringToUnsignedChars(DFA47_maxS);
    static final short[] DFA47_accept = DFA.unpackEncodedString(DFA47_acceptS);
    static final short[] DFA47_special = DFA.unpackEncodedString(DFA47_specialS);
    static final short[][] DFA47_transition;

    static {
        int numStates = DFA47_transitionS.length;
        DFA47_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA47_transition[i] = DFA.unpackEncodedString(DFA47_transitionS[i]);
        }
    }

    class DFA47 extends DFA {

        public DFA47(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 47;
            this.eot = DFA47_eot;
            this.eof = DFA47_eof;
            this.min = DFA47_min;
            this.max = DFA47_max;
            this.accept = DFA47_accept;
            this.special = DFA47_special;
            this.transition = DFA47_transition;
        }
        public String getDescription() {
            return "1752:1: (this_STRING_0= RULE_STRING | this_INT_1= ruleINT | this_DOUBLE_2= ruleDOUBLE )";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleOilFile_in_entryRuleOilFile75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOilFile85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleOilFile132 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleOilFile144 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleOilFile161 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleOilFile178 = new BitSet(new long[]{0x0000000000110002L});
        public static final BitSet FOLLOW_ruleOilImplementation_in_ruleOilFile201 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_ruleOilApplication_in_ruleOilFile223 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilImplementation_in_entryRuleOilImplementation260 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOilImplementation270 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleOilImplementation307 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOilImplementation324 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleOilImplementation341 = new BitSet(new long[]{0x0003FFE000040000L,0x0000000000000004L});
        public static final BitSet FOLLOW_ruleOilObjectImpl_in_ruleOilImplementation362 = new BitSet(new long[]{0x0003FFE000040000L,0x0000000000000004L});
        public static final BitSet FOLLOW_18_in_ruleOilImplementation375 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleOilImplementation387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilObjectImpl_in_entryRuleOilObjectImpl423 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOilObjectImpl433 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectType_in_ruleOilObjectImpl479 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleOilObjectImpl491 = new BitSet(new long[]{0x7FFC001FF0040000L,0x0000000000000008L});
        public static final BitSet FOLLOW_ruleParameterType_in_ruleOilObjectImpl512 = new BitSet(new long[]{0x7FFC001FF0040000L,0x0000000000000008L});
        public static final BitSet FOLLOW_18_in_ruleOilObjectImpl525 = new BitSet(new long[]{0x0000000000088000L});
        public static final BitSet FOLLOW_19_in_ruleOilObjectImpl538 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleOilObjectImpl555 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleOilObjectImpl574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilApplication_in_entryRuleOilApplication610 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOilApplication620 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleOilApplication657 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOilApplication674 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleOilApplication691 = new BitSet(new long[]{0x0003FFE000040000L,0x0000000000000004L});
        public static final BitSet FOLLOW_ruleOilObject_in_ruleOilApplication712 = new BitSet(new long[]{0x0003FFE000040000L,0x0000000000000004L});
        public static final BitSet FOLLOW_18_in_ruleOilApplication725 = new BitSet(new long[]{0x0000000000088000L});
        public static final BitSet FOLLOW_19_in_ruleOilApplication738 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleOilApplication755 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleOilApplication774 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameterType_in_entryRuleParameterType810 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParameterType820 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueType_in_ruleParameterType867 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariantType_in_ruleParameterType894 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceType_in_ruleParameterType921 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueType_in_entryRuleValueType956 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleValueType966 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVType_in_ruleValueType1021 = new BitSet(new long[]{0x7FFFFFFFF0600020L});
        public static final BitSet FOLLOW_21_in_ruleValueType1039 = new BitSet(new long[]{0x7FFFFFFFF0600020L});
        public static final BitSet FOLLOW_22_in_ruleValueType1066 = new BitSet(new long[]{0x80000000000001C0L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleINT_in_ruleValueType1085 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_ruleDOUBLE_in_ruleValueType1106 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleValueType1118 = new BitSet(new long[]{0x80000000000001C0L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleINT_in_ruleValueType1135 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_ruleDOUBLE_in_ruleValueType1156 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_ruleINT_in_ruleValueType1181 = new BitSet(new long[]{0x0000000003000000L});
        public static final BitSet FOLLOW_ruleDOUBLE_in_ruleValueType1202 = new BitSet(new long[]{0x0000000003000000L});
        public static final BitSet FOLLOW_24_in_ruleValueType1215 = new BitSet(new long[]{0x80000000000001C0L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleINT_in_ruleValueType1232 = new BitSet(new long[]{0x0000000003000000L});
        public static final BitSet FOLLOW_ruleDOUBLE_in_ruleValueType1253 = new BitSet(new long[]{0x0000000003000000L});
        public static final BitSet FOLLOW_25_in_ruleValueType1269 = new BitSet(new long[]{0x7FFFFFFFF0600020L});
        public static final BitSet FOLLOW_ruleSpecialId_in_ruleValueType1292 = new BitSet(new long[]{0x000000000408C000L});
        public static final BitSet FOLLOW_26_in_ruleValueType1310 = new BitSet(new long[]{0x000000000008C000L});
        public static final BitSet FOLLOW_14_in_ruleValueType1337 = new BitSet(new long[]{0x80000000080001F0L,0x0000000000000001L});
        public static final BitSet FOLLOW_27_in_ruleValueType1371 = new BitSet(new long[]{0x0000000000088000L});
        public static final BitSet FOLLOW_ruleGenericValue_in_ruleValueType1413 = new BitSet(new long[]{0x0000000000088000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleValueType1428 = new BitSet(new long[]{0x0000000000088000L});
        public static final BitSet FOLLOW_19_in_ruleValueType1452 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleValueType1469 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleValueType1488 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariantType_in_entryRuleVariantType1524 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVariantType1534 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEType_in_ruleVariantType1589 = new BitSet(new long[]{0x7FFFFFFFF0600020L});
        public static final BitSet FOLLOW_21_in_ruleVariantType1607 = new BitSet(new long[]{0x7FFFFFFFF0600020L});
        public static final BitSet FOLLOW_22_in_ruleVariantType1634 = new BitSet(new long[]{0x7FFFFFFFF2600020L});
        public static final BitSet FOLLOW_ruleEnumeratorType_in_ruleVariantType1656 = new BitSet(new long[]{0x0000000003000000L});
        public static final BitSet FOLLOW_24_in_ruleVariantType1669 = new BitSet(new long[]{0x7FFFFFFFF0600020L});
        public static final BitSet FOLLOW_ruleEnumeratorType_in_ruleVariantType1690 = new BitSet(new long[]{0x0000000003000000L});
        public static final BitSet FOLLOW_25_in_ruleVariantType1706 = new BitSet(new long[]{0x7FFFFFFFF0600020L});
        public static final BitSet FOLLOW_ruleSpecialId_in_ruleVariantType1729 = new BitSet(new long[]{0x000000000408C000L});
        public static final BitSet FOLLOW_26_in_ruleVariantType1747 = new BitSet(new long[]{0x000000000008C000L});
        public static final BitSet FOLLOW_14_in_ruleVariantType1774 = new BitSet(new long[]{0x0000000008000020L});
        public static final BitSet FOLLOW_27_in_ruleVariantType1808 = new BitSet(new long[]{0x0000000000088000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleVariantType1844 = new BitSet(new long[]{0x0000000000088000L});
        public static final BitSet FOLLOW_19_in_ruleVariantType1865 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleVariantType1882 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleVariantType1901 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumeratorType_in_entryRuleEnumeratorType1937 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumeratorType1947 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecialId_in_ruleEnumeratorType2002 = new BitSet(new long[]{0x00000000000A0002L});
        public static final BitSet FOLLOW_17_in_ruleEnumeratorType2015 = new BitSet(new long[]{0x7FFC001FF0040000L,0x0000000000000008L});
        public static final BitSet FOLLOW_ruleParameterType_in_ruleEnumeratorType2036 = new BitSet(new long[]{0x7FFC001FF0040000L,0x0000000000000008L});
        public static final BitSet FOLLOW_18_in_ruleEnumeratorType2049 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleEnumeratorType2064 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEnumeratorType2081 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceType_in_entryRuleReferenceType2124 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceType2134 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectTypeRef_in_ruleReferenceType2189 = new BitSet(new long[]{0x7FFFFFFFF0600020L});
        public static final BitSet FOLLOW_21_in_ruleReferenceType2207 = new BitSet(new long[]{0x7FFFFFFFF0600020L});
        public static final BitSet FOLLOW_ruleSpecialId_in_ruleReferenceType2242 = new BitSet(new long[]{0x000000000408C000L});
        public static final BitSet FOLLOW_26_in_ruleReferenceType2260 = new BitSet(new long[]{0x000000000008C000L});
        public static final BitSet FOLLOW_14_in_ruleReferenceType2287 = new BitSet(new long[]{0x0000000008000020L});
        public static final BitSet FOLLOW_27_in_ruleReferenceType2321 = new BitSet(new long[]{0x0000000000088000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceType2357 = new BitSet(new long[]{0x0000000000088000L});
        public static final BitSet FOLLOW_19_in_ruleReferenceType2378 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleReferenceType2395 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleReferenceType2414 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilObject_in_entryRuleOilObject2450 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOilObject2460 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectType_in_ruleOilObject2506 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOilObject2523 = new BitSet(new long[]{0x00000000000A8000L});
        public static final BitSet FOLLOW_17_in_ruleOilObject2541 = new BitSet(new long[]{0x7FFFFFFFF0640020L});
        public static final BitSet FOLLOW_ruleParameter_in_ruleOilObject2562 = new BitSet(new long[]{0x7FFFFFFFF0640020L});
        public static final BitSet FOLLOW_18_in_ruleOilObject2575 = new BitSet(new long[]{0x0000000000088000L});
        public static final BitSet FOLLOW_19_in_ruleOilObject2590 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleOilObject2607 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleOilObject2626 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter2662 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParameter2672 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecialId_in_ruleParameter2729 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleParameter2741 = new BitSet(new long[]{0xFFFFFFFFF86001F0L,0x0000000000000001L});
        public static final BitSet FOLLOW_27_in_ruleParameter2775 = new BitSet(new long[]{0x00000000000A8000L});
        public static final BitSet FOLLOW_ruleGenericValue_in_ruleParameter2815 = new BitSet(new long[]{0x00000000000A8000L});
        public static final BitSet FOLLOW_ruleSpecialId_in_ruleParameter2844 = new BitSet(new long[]{0x00000000000A8000L});
        public static final BitSet FOLLOW_17_in_ruleParameter2858 = new BitSet(new long[]{0x7FFFFFFFF0640020L});
        public static final BitSet FOLLOW_ruleParameter_in_ruleParameter2879 = new BitSet(new long[]{0x7FFFFFFFF0640020L});
        public static final BitSet FOLLOW_18_in_ruleParameter2892 = new BitSet(new long[]{0x0000000000088000L});
        public static final BitSet FOLLOW_19_in_ruleParameter2907 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleParameter2924 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleParameter2943 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecialId_in_entryRuleSpecialId2980 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpecialId2991 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSpecialId3031 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleSpecialId3055 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleSpecialId3074 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleSpecialId3093 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleSpecialId3112 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleSpecialId3131 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleSpecialId3150 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleSpecialId3169 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleSpecialId3188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleSpecialId3207 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleSpecialId3226 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleSpecialId3245 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleSpecialId3264 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleSpecialId3283 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleSpecialId3302 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleSpecialId3321 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleSpecialId3340 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleSpecialId3359 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleSpecialId3378 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_ruleSpecialId3397 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_ruleSpecialId3416 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_ruleSpecialId3435 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_ruleSpecialId3454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleSpecialId3473 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_ruleSpecialId3492 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_ruleSpecialId3511 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_ruleSpecialId3530 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_ruleSpecialId3549 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_ruleSpecialId3568 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_ruleSpecialId3587 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_ruleSpecialId3606 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_ruleSpecialId3625 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_59_in_ruleSpecialId3644 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_ruleSpecialId3663 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_ruleSpecialId3682 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_ruleSpecialId3701 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGenericValue_in_entryRuleGenericValue3742 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGenericValue3753 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleGenericValue3793 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleINT_in_ruleGenericValue3826 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDOUBLE_in_ruleGenericValue3859 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleINT_in_entryRuleINT3905 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleINT3916 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_63_in_ruleINT3955 = new BitSet(new long[]{0x00000000000001C0L});
        public static final BitSet FOLLOW_64_in_ruleINT3974 = new BitSet(new long[]{0x00000000000001C0L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_ruleINT3993 = new BitSet(new long[]{0x00000000000000C2L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_ruleINT4014 = new BitSet(new long[]{0x00000000000000C2L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_ruleINT4040 = new BitSet(new long[]{0x00000000000000C2L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_ruleINT4069 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_HEX_in_ruleINT4095 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDOUBLE_in_entryRuleDOUBLE4142 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDOUBLE4153 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_63_in_ruleDOUBLE4192 = new BitSet(new long[]{0x00000000000000C0L});
        public static final BitSet FOLLOW_64_in_ruleDOUBLE4211 = new BitSet(new long[]{0x00000000000000C0L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_ruleDOUBLE4229 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_ruleDOUBLE4256 = new BitSet(new long[]{0x00000000000000C0L,0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_ruleDOUBLE4277 = new BitSet(new long[]{0x00000000000000C0L,0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_ruleDOUBLE4303 = new BitSet(new long[]{0x00000000000000C0L,0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_ruleDOUBLE4334 = new BitSet(new long[]{0x00000000000000C0L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_ruleDOUBLE4351 = new BitSet(new long[]{0x00000000000000C2L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_ruleDOUBLE4377 = new BitSet(new long[]{0x00000000000000C2L});
        public static final BitSet FOLLOW_28_in_ruleVType4438 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleVType4455 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleVType4472 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleVType4489 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleVType4506 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleVType4523 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleVType4540 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleEType4585 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleEType4602 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleObjectType4647 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleObjectType4664 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleObjectType4681 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleObjectType4698 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleObjectType4715 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleObjectType4732 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleObjectType4749 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleObjectType4766 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleObjectType4783 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_ruleObjectType4800 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_ruleObjectType4817 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_ruleObjectType4834 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_ruleObjectType4851 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_ruleObjectType4868 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleObjectTypeRef4913 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_ruleObjectTypeRef4930 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_ruleObjectTypeRef4947 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_ruleObjectTypeRef4964 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_ruleObjectTypeRef4981 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_ruleObjectTypeRef4998 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_ruleObjectTypeRef5015 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_ruleObjectTypeRef5032 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_ruleObjectTypeRef5049 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_59_in_ruleObjectTypeRef5066 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_ruleObjectTypeRef5083 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_ruleObjectTypeRef5100 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_ruleObjectTypeRef5117 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_67_in_ruleObjectTypeRef5134 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_synpred1_InternalOil1353 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_synpred2_InternalOil1790 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_synpred3_InternalOil2303 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_synpred4_InternalOil2757 = new BitSet(new long[]{0x0000000000000002L});
    }


}