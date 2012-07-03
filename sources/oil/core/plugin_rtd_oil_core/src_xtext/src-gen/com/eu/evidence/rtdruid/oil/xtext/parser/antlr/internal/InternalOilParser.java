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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_NON_ZERO_INT", "RULE_ZERO_INT", "RULE_HEX", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'OIL_VERSION'", "'='", "';'", "'IMPLEMENTATION'", "'{'", "'}'", "':'", "'CPU'", "'WITH_AUTO'", "'[]'", "'AUTO'", "'['", "','", "']'", "'STRING'", "'UINT32'", "'INT32'", "'UINT64'", "'INT64'", "'FLOAT'", "'DOUBLE'", "'BOOLEAN'", "'ENUM'", "'OS'", "'ALARM'", "'APPMODE'", "'COUNTER'", "'COM'", "'EVENT'", "'IPDU'", "'ISR'", "'MESSAGE'", "'NETWORKMESSAGE'", "'NM'", "'RESOURCE'", "'TASK'", "'OS_TYPE'", "'ALARM_TYPE'", "'APPMODE_TYPE'", "'COUNTER_TYPE'", "'COM_TYPE'", "'EVENT_TYPE'", "'IPDU_TYPE'", "'ISR_TYPE'", "'MESSAGE_TYPE'", "'NETWORKMESSAGE_TYPE'", "'NM_TYPE'", "'RESOURCE_TYPE'", "'TASK_TYPE'", "'+'", "'-'", "'.'"
    };
    public static final int RULE_ID=5;
    public static final int T__64=64;
    public static final int T__29=29;
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

                if ( ((LA4_0>=36 && LA4_0<=48)) ) {
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

                if ( ((LA5_0>=27 && LA5_0<=35)||(LA5_0>=49 && LA5_0<=61)) ) {
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

                if ( ((LA7_0>=36 && LA7_0<=48)) ) {
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
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
                {
                alt9=1;
                }
                break;
            case 34:
            case 35:
                {
                alt9=2;
                }
                break;
            case 49:
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:479:1: ruleValueType returns [EObject current=null] : ( () ( (lv_Type_1_0= ruleVType ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? ( (lv_Name_3_0= ruleSpecialId ) ) ( (lv_MultiValue_4_0= '[]' ) )? (otherlv_5= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( ( (lv_DefaultValue_7_1= ruleGenericValue | lv_DefaultValue_7_2= RULE_ID ) ) ) ) )? (otherlv_8= ':' ( (lv_Description_9_0= RULE_STRING ) ) )? otherlv_10= ';' ) ;
    public final EObject ruleValueType() throws RecognitionException {
        EObject current = null;

        Token lv_WithAuto_2_0=null;
        Token lv_MultiValue_4_0=null;
        Token otherlv_5=null;
        Token lv_DefaultAuto_6_0=null;
        Token lv_DefaultValue_7_2=null;
        Token otherlv_8=null;
        Token lv_Description_9_0=null;
        Token otherlv_10=null;
        Enumerator lv_Type_1_0 = null;

        AntlrDatatypeRuleToken lv_Name_3_0 = null;

        AntlrDatatypeRuleToken lv_DefaultValue_7_1 = null;


         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:482:28: ( ( () ( (lv_Type_1_0= ruleVType ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? ( (lv_Name_3_0= ruleSpecialId ) ) ( (lv_MultiValue_4_0= '[]' ) )? (otherlv_5= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( ( (lv_DefaultValue_7_1= ruleGenericValue | lv_DefaultValue_7_2= RULE_ID ) ) ) ) )? (otherlv_8= ':' ( (lv_Description_9_0= RULE_STRING ) ) )? otherlv_10= ';' ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:483:1: ( () ( (lv_Type_1_0= ruleVType ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? ( (lv_Name_3_0= ruleSpecialId ) ) ( (lv_MultiValue_4_0= '[]' ) )? (otherlv_5= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( ( (lv_DefaultValue_7_1= ruleGenericValue | lv_DefaultValue_7_2= RULE_ID ) ) ) ) )? (otherlv_8= ':' ( (lv_Description_9_0= RULE_STRING ) ) )? otherlv_10= ';' )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:483:1: ( () ( (lv_Type_1_0= ruleVType ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? ( (lv_Name_3_0= ruleSpecialId ) ) ( (lv_MultiValue_4_0= '[]' ) )? (otherlv_5= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( ( (lv_DefaultValue_7_1= ruleGenericValue | lv_DefaultValue_7_2= RULE_ID ) ) ) ) )? (otherlv_8= ':' ( (lv_Description_9_0= RULE_STRING ) ) )? otherlv_10= ';' )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:483:2: () ( (lv_Type_1_0= ruleVType ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? ( (lv_Name_3_0= ruleSpecialId ) ) ( (lv_MultiValue_4_0= '[]' ) )? (otherlv_5= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( ( (lv_DefaultValue_7_1= ruleGenericValue | lv_DefaultValue_7_2= RULE_ID ) ) ) ) )? (otherlv_8= ':' ( (lv_Description_9_0= RULE_STRING ) ) )? otherlv_10= ';'
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

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:522:3: ( (lv_Name_3_0= ruleSpecialId ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:523:1: (lv_Name_3_0= ruleSpecialId )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:523:1: (lv_Name_3_0= ruleSpecialId )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:524:3: lv_Name_3_0= ruleSpecialId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getValueTypeAccess().getNameSpecialIdParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_ruleValueType1074);
            lv_Name_3_0=ruleSpecialId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getValueTypeRule());
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

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:540:2: ( (lv_MultiValue_4_0= '[]' ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==22) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:541:1: (lv_MultiValue_4_0= '[]' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:541:1: (lv_MultiValue_4_0= '[]' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:542:3: lv_MultiValue_4_0= '[]'
                    {
                    lv_MultiValue_4_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleValueType1092); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_MultiValue_4_0, grammarAccess.getValueTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_4_0());
                          
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

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:555:3: (otherlv_5= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( ( (lv_DefaultValue_7_1= ruleGenericValue | lv_DefaultValue_7_2= RULE_ID ) ) ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==14) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:555:5: otherlv_5= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( ( (lv_DefaultValue_7_1= ruleGenericValue | lv_DefaultValue_7_2= RULE_ID ) ) ) )
                    {
                    otherlv_5=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleValueType1119); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getValueTypeAccess().getEqualsSignKeyword_5_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:559:1: ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( ( (lv_DefaultValue_7_1= ruleGenericValue | lv_DefaultValue_7_2= RULE_ID ) ) ) )
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==23) && (synpred1_InternalOil())) {
                        alt13=1;
                    }
                    else if ( ((LA13_0>=RULE_STRING && LA13_0<=RULE_HEX)||(LA13_0>=62 && LA13_0<=63)) ) {
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
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:559:2: ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:559:2: ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:559:3: ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:566:1: (lv_DefaultAuto_6_0= 'AUTO' )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:567:3: lv_DefaultAuto_6_0= 'AUTO'
                            {
                            lv_DefaultAuto_6_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleValueType1153); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_DefaultAuto_6_0, grammarAccess.getValueTypeAccess().getDefaultAutoAUTOKeyword_5_1_0_0());
                                  
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
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:581:6: ( ( (lv_DefaultValue_7_1= ruleGenericValue | lv_DefaultValue_7_2= RULE_ID ) ) )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:581:6: ( ( (lv_DefaultValue_7_1= ruleGenericValue | lv_DefaultValue_7_2= RULE_ID ) ) )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:582:1: ( (lv_DefaultValue_7_1= ruleGenericValue | lv_DefaultValue_7_2= RULE_ID ) )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:582:1: ( (lv_DefaultValue_7_1= ruleGenericValue | lv_DefaultValue_7_2= RULE_ID ) )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:583:1: (lv_DefaultValue_7_1= ruleGenericValue | lv_DefaultValue_7_2= RULE_ID )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:583:1: (lv_DefaultValue_7_1= ruleGenericValue | lv_DefaultValue_7_2= RULE_ID )
                            int alt12=2;
                            int LA12_0 = input.LA(1);

                            if ( (LA12_0==RULE_STRING||(LA12_0>=RULE_NON_ZERO_INT && LA12_0<=RULE_HEX)||(LA12_0>=62 && LA12_0<=63)) ) {
                                alt12=1;
                            }
                            else if ( (LA12_0==RULE_ID) ) {
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
                                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:584:3: lv_DefaultValue_7_1= ruleGenericValue
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getValueTypeAccess().getDefaultValueGenericValueParserRuleCall_5_1_1_0_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleGenericValue_in_ruleValueType1195);
                                    lv_DefaultValue_7_1=ruleGenericValue();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElementForParent(grammarAccess.getValueTypeRule());
                                      	        }
                                             		set(
                                             			current, 
                                             			"DefaultValue",
                                              		lv_DefaultValue_7_1, 
                                              		"GenericValue");
                                      	        afterParserOrEnumRuleCall();
                                      	    
                                    }

                                    }
                                    break;
                                case 2 :
                                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:599:8: lv_DefaultValue_7_2= RULE_ID
                                    {
                                    lv_DefaultValue_7_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleValueType1210); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      			newLeafNode(lv_DefaultValue_7_2, grammarAccess.getValueTypeAccess().getDefaultValueIDTerminalRuleCall_5_1_1_0_1()); 
                                      		
                                    }
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElement(grammarAccess.getValueTypeRule());
                                      	        }
                                             		setWithLastConsumed(
                                             			current, 
                                             			"DefaultValue",
                                              		lv_DefaultValue_7_2, 
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

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:617:5: (otherlv_8= ':' ( (lv_Description_9_0= RULE_STRING ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==19) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:617:7: otherlv_8= ':' ( (lv_Description_9_0= RULE_STRING ) )
                    {
                    otherlv_8=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleValueType1234); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getValueTypeAccess().getColonKeyword_6_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:621:1: ( (lv_Description_9_0= RULE_STRING ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:622:1: (lv_Description_9_0= RULE_STRING )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:622:1: (lv_Description_9_0= RULE_STRING )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:623:3: lv_Description_9_0= RULE_STRING
                    {
                    lv_Description_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleValueType1251); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_Description_9_0, grammarAccess.getValueTypeAccess().getDescriptionSTRINGTerminalRuleCall_6_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getValueTypeRule());
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

            otherlv_10=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleValueType1270); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getValueTypeAccess().getSemicolonKeyword_7());
                  
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:651:1: entryRuleVariantType returns [EObject current=null] : iv_ruleVariantType= ruleVariantType EOF ;
    public final EObject entryRuleVariantType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariantType = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:652:2: (iv_ruleVariantType= ruleVariantType EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:653:2: iv_ruleVariantType= ruleVariantType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariantTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVariantType_in_entryRuleVariantType1306);
            iv_ruleVariantType=ruleVariantType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariantType; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVariantType1316); if (state.failed) return current;

            }

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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:660:1: ruleVariantType returns [EObject current=null] : ( () ( (lv_Type_1_0= ruleEType ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? (otherlv_3= '[' ( ( (lv_Values_4_0= ruleEnumeratorType ) ) (otherlv_5= ',' ( (lv_Values_6_0= ruleEnumeratorType ) ) )* )? otherlv_7= ']' )? ( (lv_Name_8_0= ruleSpecialId ) ) ( (lv_MultiValue_9_0= '[]' ) )? (otherlv_10= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_11_0= 'AUTO' ) ) | ( (lv_DefaultValue_12_0= RULE_ID ) ) ) )? (otherlv_13= ':' ( (lv_Description_14_0= RULE_STRING ) ) )? otherlv_15= ';' ) ;
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
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:663:28: ( ( () ( (lv_Type_1_0= ruleEType ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? (otherlv_3= '[' ( ( (lv_Values_4_0= ruleEnumeratorType ) ) (otherlv_5= ',' ( (lv_Values_6_0= ruleEnumeratorType ) ) )* )? otherlv_7= ']' )? ( (lv_Name_8_0= ruleSpecialId ) ) ( (lv_MultiValue_9_0= '[]' ) )? (otherlv_10= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_11_0= 'AUTO' ) ) | ( (lv_DefaultValue_12_0= RULE_ID ) ) ) )? (otherlv_13= ':' ( (lv_Description_14_0= RULE_STRING ) ) )? otherlv_15= ';' ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:664:1: ( () ( (lv_Type_1_0= ruleEType ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? (otherlv_3= '[' ( ( (lv_Values_4_0= ruleEnumeratorType ) ) (otherlv_5= ',' ( (lv_Values_6_0= ruleEnumeratorType ) ) )* )? otherlv_7= ']' )? ( (lv_Name_8_0= ruleSpecialId ) ) ( (lv_MultiValue_9_0= '[]' ) )? (otherlv_10= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_11_0= 'AUTO' ) ) | ( (lv_DefaultValue_12_0= RULE_ID ) ) ) )? (otherlv_13= ':' ( (lv_Description_14_0= RULE_STRING ) ) )? otherlv_15= ';' )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:664:1: ( () ( (lv_Type_1_0= ruleEType ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? (otherlv_3= '[' ( ( (lv_Values_4_0= ruleEnumeratorType ) ) (otherlv_5= ',' ( (lv_Values_6_0= ruleEnumeratorType ) ) )* )? otherlv_7= ']' )? ( (lv_Name_8_0= ruleSpecialId ) ) ( (lv_MultiValue_9_0= '[]' ) )? (otherlv_10= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_11_0= 'AUTO' ) ) | ( (lv_DefaultValue_12_0= RULE_ID ) ) ) )? (otherlv_13= ':' ( (lv_Description_14_0= RULE_STRING ) ) )? otherlv_15= ';' )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:664:2: () ( (lv_Type_1_0= ruleEType ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? (otherlv_3= '[' ( ( (lv_Values_4_0= ruleEnumeratorType ) ) (otherlv_5= ',' ( (lv_Values_6_0= ruleEnumeratorType ) ) )* )? otherlv_7= ']' )? ( (lv_Name_8_0= ruleSpecialId ) ) ( (lv_MultiValue_9_0= '[]' ) )? (otherlv_10= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_11_0= 'AUTO' ) ) | ( (lv_DefaultValue_12_0= RULE_ID ) ) ) )? (otherlv_13= ':' ( (lv_Description_14_0= RULE_STRING ) ) )? otherlv_15= ';'
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:664:2: ()
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:665:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getVariantTypeAccess().getVariantTypeAction_0(),
                          current);
                  
            }

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:670:2: ( (lv_Type_1_0= ruleEType ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:671:1: (lv_Type_1_0= ruleEType )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:671:1: (lv_Type_1_0= ruleEType )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:672:3: lv_Type_1_0= ruleEType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariantTypeAccess().getTypeETypeEnumRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleEType_in_ruleVariantType1371);
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

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:688:2: ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==21) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:689:1: (lv_WithAuto_2_0= 'WITH_AUTO' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:689:1: (lv_WithAuto_2_0= 'WITH_AUTO' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:690:3: lv_WithAuto_2_0= 'WITH_AUTO'
                    {
                    lv_WithAuto_2_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleVariantType1389); if (state.failed) return current;
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

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:703:3: (otherlv_3= '[' ( ( (lv_Values_4_0= ruleEnumeratorType ) ) (otherlv_5= ',' ( (lv_Values_6_0= ruleEnumeratorType ) ) )* )? otherlv_7= ']' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==24) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:703:5: otherlv_3= '[' ( ( (lv_Values_4_0= ruleEnumeratorType ) ) (otherlv_5= ',' ( (lv_Values_6_0= ruleEnumeratorType ) ) )* )? otherlv_7= ']'
                    {
                    otherlv_3=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleVariantType1416); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getVariantTypeAccess().getLeftSquareBracketKeyword_3_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:707:1: ( ( (lv_Values_4_0= ruleEnumeratorType ) ) (otherlv_5= ',' ( (lv_Values_6_0= ruleEnumeratorType ) ) )* )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==RULE_ID||(LA18_0>=27 && LA18_0<=61)) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:707:2: ( (lv_Values_4_0= ruleEnumeratorType ) ) (otherlv_5= ',' ( (lv_Values_6_0= ruleEnumeratorType ) ) )*
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:707:2: ( (lv_Values_4_0= ruleEnumeratorType ) )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:708:1: (lv_Values_4_0= ruleEnumeratorType )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:708:1: (lv_Values_4_0= ruleEnumeratorType )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:709:3: lv_Values_4_0= ruleEnumeratorType
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getVariantTypeAccess().getValuesEnumeratorTypeParserRuleCall_3_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleEnumeratorType_in_ruleVariantType1438);
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

                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:725:2: (otherlv_5= ',' ( (lv_Values_6_0= ruleEnumeratorType ) ) )*
                            loop17:
                            do {
                                int alt17=2;
                                int LA17_0 = input.LA(1);

                                if ( (LA17_0==25) ) {
                                    alt17=1;
                                }


                                switch (alt17) {
                            	case 1 :
                            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:725:4: otherlv_5= ',' ( (lv_Values_6_0= ruleEnumeratorType ) )
                            	    {
                            	    otherlv_5=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleVariantType1451); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_5, grammarAccess.getVariantTypeAccess().getCommaKeyword_3_1_1_0());
                            	          
                            	    }
                            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:729:1: ( (lv_Values_6_0= ruleEnumeratorType ) )
                            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:730:1: (lv_Values_6_0= ruleEnumeratorType )
                            	    {
                            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:730:1: (lv_Values_6_0= ruleEnumeratorType )
                            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:731:3: lv_Values_6_0= ruleEnumeratorType
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getVariantTypeAccess().getValuesEnumeratorTypeParserRuleCall_3_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleEnumeratorType_in_ruleVariantType1472);
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
                            	    break loop17;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_7=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleVariantType1488); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getVariantTypeAccess().getRightSquareBracketKeyword_3_2());
                          
                    }

                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:751:3: ( (lv_Name_8_0= ruleSpecialId ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:752:1: (lv_Name_8_0= ruleSpecialId )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:752:1: (lv_Name_8_0= ruleSpecialId )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:753:3: lv_Name_8_0= ruleSpecialId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariantTypeAccess().getNameSpecialIdParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_ruleVariantType1511);
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

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:769:2: ( (lv_MultiValue_9_0= '[]' ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==22) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:770:1: (lv_MultiValue_9_0= '[]' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:770:1: (lv_MultiValue_9_0= '[]' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:771:3: lv_MultiValue_9_0= '[]'
                    {
                    lv_MultiValue_9_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleVariantType1529); if (state.failed) return current;
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

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:784:3: (otherlv_10= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_11_0= 'AUTO' ) ) | ( (lv_DefaultValue_12_0= RULE_ID ) ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==14) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:784:5: otherlv_10= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_11_0= 'AUTO' ) ) | ( (lv_DefaultValue_12_0= RULE_ID ) ) )
                    {
                    otherlv_10=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleVariantType1556); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getVariantTypeAccess().getEqualsSignKeyword_6_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:788:1: ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_11_0= 'AUTO' ) ) | ( (lv_DefaultValue_12_0= RULE_ID ) ) )
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==23) && (synpred2_InternalOil())) {
                        alt21=1;
                    }
                    else if ( (LA21_0==RULE_ID) ) {
                        alt21=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 21, 0, input);

                        throw nvae;
                    }
                    switch (alt21) {
                        case 1 :
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:788:2: ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_11_0= 'AUTO' ) )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:788:2: ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_11_0= 'AUTO' ) )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:788:3: ( ( 'AUTO' ) )=> (lv_DefaultAuto_11_0= 'AUTO' )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:795:1: (lv_DefaultAuto_11_0= 'AUTO' )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:796:3: lv_DefaultAuto_11_0= 'AUTO'
                            {
                            lv_DefaultAuto_11_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleVariantType1590); if (state.failed) return current;
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
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:810:6: ( (lv_DefaultValue_12_0= RULE_ID ) )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:810:6: ( (lv_DefaultValue_12_0= RULE_ID ) )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:811:1: (lv_DefaultValue_12_0= RULE_ID )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:811:1: (lv_DefaultValue_12_0= RULE_ID )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:812:3: lv_DefaultValue_12_0= RULE_ID
                            {
                            lv_DefaultValue_12_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleVariantType1626); if (state.failed) return current;
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

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:828:5: (otherlv_13= ':' ( (lv_Description_14_0= RULE_STRING ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==19) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:828:7: otherlv_13= ':' ( (lv_Description_14_0= RULE_STRING ) )
                    {
                    otherlv_13=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleVariantType1647); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getVariantTypeAccess().getColonKeyword_7_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:832:1: ( (lv_Description_14_0= RULE_STRING ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:833:1: (lv_Description_14_0= RULE_STRING )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:833:1: (lv_Description_14_0= RULE_STRING )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:834:3: lv_Description_14_0= RULE_STRING
                    {
                    lv_Description_14_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleVariantType1664); if (state.failed) return current;
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

            otherlv_15=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleVariantType1683); if (state.failed) return current;
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:862:1: entryRuleEnumeratorType returns [EObject current=null] : iv_ruleEnumeratorType= ruleEnumeratorType EOF ;
    public final EObject entryRuleEnumeratorType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumeratorType = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:863:2: (iv_ruleEnumeratorType= ruleEnumeratorType EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:864:2: iv_ruleEnumeratorType= ruleEnumeratorType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumeratorTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEnumeratorType_in_entryRuleEnumeratorType1719);
            iv_ruleEnumeratorType=ruleEnumeratorType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumeratorType; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumeratorType1729); if (state.failed) return current;

            }

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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:871:1: ruleEnumeratorType returns [EObject current=null] : ( () ( (lv_Name_1_0= ruleSpecialId ) ) (otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameterType ) )* otherlv_4= '}' )? (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )? ) ;
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
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:874:28: ( ( () ( (lv_Name_1_0= ruleSpecialId ) ) (otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameterType ) )* otherlv_4= '}' )? (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )? ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:875:1: ( () ( (lv_Name_1_0= ruleSpecialId ) ) (otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameterType ) )* otherlv_4= '}' )? (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )? )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:875:1: ( () ( (lv_Name_1_0= ruleSpecialId ) ) (otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameterType ) )* otherlv_4= '}' )? (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )? )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:875:2: () ( (lv_Name_1_0= ruleSpecialId ) ) (otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameterType ) )* otherlv_4= '}' )? (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )?
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:875:2: ()
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:876:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getEnumeratorTypeAccess().getEnumeratorTypeAction_0(),
                          current);
                  
            }

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:881:2: ( (lv_Name_1_0= ruleSpecialId ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:882:1: (lv_Name_1_0= ruleSpecialId )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:882:1: (lv_Name_1_0= ruleSpecialId )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:883:3: lv_Name_1_0= ruleSpecialId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEnumeratorTypeAccess().getNameSpecialIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_ruleEnumeratorType1784);
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

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:899:2: (otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameterType ) )* otherlv_4= '}' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==17) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:899:4: otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameterType ) )* otherlv_4= '}'
                    {
                    otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleEnumeratorType1797); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getEnumeratorTypeAccess().getLeftCurlyBracketKeyword_2_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:903:1: ( (lv_Parameters_3_0= ruleParameterType ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( ((LA24_0>=27 && LA24_0<=35)||(LA24_0>=49 && LA24_0<=61)) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:904:1: (lv_Parameters_3_0= ruleParameterType )
                    	    {
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:904:1: (lv_Parameters_3_0= ruleParameterType )
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:905:3: lv_Parameters_3_0= ruleParameterType
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getEnumeratorTypeAccess().getParametersParameterTypeParserRuleCall_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleParameterType_in_ruleEnumeratorType1818);
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
                    	    break loop24;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleEnumeratorType1831); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getEnumeratorTypeAccess().getRightCurlyBracketKeyword_2_2());
                          
                    }

                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:925:3: (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==19) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:925:5: otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleEnumeratorType1846); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getEnumeratorTypeAccess().getColonKeyword_3_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:929:1: ( (lv_Description_6_0= RULE_STRING ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:930:1: (lv_Description_6_0= RULE_STRING )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:930:1: (lv_Description_6_0= RULE_STRING )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:931:3: lv_Description_6_0= RULE_STRING
                    {
                    lv_Description_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEnumeratorType1863); if (state.failed) return current;
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:955:1: entryRuleReferenceType returns [EObject current=null] : iv_ruleReferenceType= ruleReferenceType EOF ;
    public final EObject entryRuleReferenceType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceType = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:956:2: (iv_ruleReferenceType= ruleReferenceType EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:957:2: iv_ruleReferenceType= ruleReferenceType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReferenceTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleReferenceType_in_entryRuleReferenceType1906);
            iv_ruleReferenceType=ruleReferenceType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReferenceType; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceType1916); if (state.failed) return current;

            }

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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:964:1: ruleReferenceType returns [EObject current=null] : ( () ( (lv_Type_1_0= ruleObjectTypeRef ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? ( (lv_Name_3_0= ruleSpecialId ) ) ( (lv_MultiValue_4_0= '[]' ) )? (otherlv_5= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( (lv_DefaultValue_7_0= RULE_ID ) ) ) )? (otherlv_8= ':' ( (lv_Description_9_0= RULE_STRING ) ) )? otherlv_10= ';' ) ;
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
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:967:28: ( ( () ( (lv_Type_1_0= ruleObjectTypeRef ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? ( (lv_Name_3_0= ruleSpecialId ) ) ( (lv_MultiValue_4_0= '[]' ) )? (otherlv_5= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( (lv_DefaultValue_7_0= RULE_ID ) ) ) )? (otherlv_8= ':' ( (lv_Description_9_0= RULE_STRING ) ) )? otherlv_10= ';' ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:968:1: ( () ( (lv_Type_1_0= ruleObjectTypeRef ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? ( (lv_Name_3_0= ruleSpecialId ) ) ( (lv_MultiValue_4_0= '[]' ) )? (otherlv_5= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( (lv_DefaultValue_7_0= RULE_ID ) ) ) )? (otherlv_8= ':' ( (lv_Description_9_0= RULE_STRING ) ) )? otherlv_10= ';' )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:968:1: ( () ( (lv_Type_1_0= ruleObjectTypeRef ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? ( (lv_Name_3_0= ruleSpecialId ) ) ( (lv_MultiValue_4_0= '[]' ) )? (otherlv_5= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( (lv_DefaultValue_7_0= RULE_ID ) ) ) )? (otherlv_8= ':' ( (lv_Description_9_0= RULE_STRING ) ) )? otherlv_10= ';' )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:968:2: () ( (lv_Type_1_0= ruleObjectTypeRef ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? ( (lv_Name_3_0= ruleSpecialId ) ) ( (lv_MultiValue_4_0= '[]' ) )? (otherlv_5= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( (lv_DefaultValue_7_0= RULE_ID ) ) ) )? (otherlv_8= ':' ( (lv_Description_9_0= RULE_STRING ) ) )? otherlv_10= ';'
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:968:2: ()
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:969:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getReferenceTypeAccess().getReferenceTypeAction_0(),
                          current);
                  
            }

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:974:2: ( (lv_Type_1_0= ruleObjectTypeRef ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:975:1: (lv_Type_1_0= ruleObjectTypeRef )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:975:1: (lv_Type_1_0= ruleObjectTypeRef )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:976:3: lv_Type_1_0= ruleObjectTypeRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getReferenceTypeAccess().getTypeObjectTypeRefEnumRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleObjectTypeRef_in_ruleReferenceType1971);
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

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:992:2: ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==21) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:993:1: (lv_WithAuto_2_0= 'WITH_AUTO' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:993:1: (lv_WithAuto_2_0= 'WITH_AUTO' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:994:3: lv_WithAuto_2_0= 'WITH_AUTO'
                    {
                    lv_WithAuto_2_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleReferenceType1989); if (state.failed) return current;
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

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1007:3: ( (lv_Name_3_0= ruleSpecialId ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1008:1: (lv_Name_3_0= ruleSpecialId )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1008:1: (lv_Name_3_0= ruleSpecialId )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1009:3: lv_Name_3_0= ruleSpecialId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getReferenceTypeAccess().getNameSpecialIdParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_ruleReferenceType2024);
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

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1025:2: ( (lv_MultiValue_4_0= '[]' ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==22) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1026:1: (lv_MultiValue_4_0= '[]' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1026:1: (lv_MultiValue_4_0= '[]' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1027:3: lv_MultiValue_4_0= '[]'
                    {
                    lv_MultiValue_4_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleReferenceType2042); if (state.failed) return current;
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

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1040:3: (otherlv_5= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( (lv_DefaultValue_7_0= RULE_ID ) ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==14) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1040:5: otherlv_5= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( (lv_DefaultValue_7_0= RULE_ID ) ) )
                    {
                    otherlv_5=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleReferenceType2069); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getReferenceTypeAccess().getEqualsSignKeyword_5_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1044:1: ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( (lv_DefaultValue_7_0= RULE_ID ) ) )
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==23) && (synpred3_InternalOil())) {
                        alt29=1;
                    }
                    else if ( (LA29_0==RULE_ID) ) {
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
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1044:2: ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1044:2: ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1044:3: ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1051:1: (lv_DefaultAuto_6_0= 'AUTO' )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1052:3: lv_DefaultAuto_6_0= 'AUTO'
                            {
                            lv_DefaultAuto_6_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleReferenceType2103); if (state.failed) return current;
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
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1066:6: ( (lv_DefaultValue_7_0= RULE_ID ) )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1066:6: ( (lv_DefaultValue_7_0= RULE_ID ) )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1067:1: (lv_DefaultValue_7_0= RULE_ID )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1067:1: (lv_DefaultValue_7_0= RULE_ID )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1068:3: lv_DefaultValue_7_0= RULE_ID
                            {
                            lv_DefaultValue_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceType2139); if (state.failed) return current;
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

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1084:5: (otherlv_8= ':' ( (lv_Description_9_0= RULE_STRING ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==19) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1084:7: otherlv_8= ':' ( (lv_Description_9_0= RULE_STRING ) )
                    {
                    otherlv_8=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleReferenceType2160); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getReferenceTypeAccess().getColonKeyword_6_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1088:1: ( (lv_Description_9_0= RULE_STRING ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1089:1: (lv_Description_9_0= RULE_STRING )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1089:1: (lv_Description_9_0= RULE_STRING )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1090:3: lv_Description_9_0= RULE_STRING
                    {
                    lv_Description_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleReferenceType2177); if (state.failed) return current;
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

            otherlv_10=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleReferenceType2196); if (state.failed) return current;
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1118:1: entryRuleOilObject returns [EObject current=null] : iv_ruleOilObject= ruleOilObject EOF ;
    public final EObject entryRuleOilObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOilObject = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1119:2: (iv_ruleOilObject= ruleOilObject EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1120:2: iv_ruleOilObject= ruleOilObject EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOilObjectRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOilObject_in_entryRuleOilObject2232);
            iv_ruleOilObject=ruleOilObject();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOilObject; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOilObject2242); if (state.failed) return current;

            }

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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1127:1: ruleOilObject returns [EObject current=null] : ( ( (lv_Type_0_0= ruleObjectType ) ) ( (lv_Name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameter ) )* otherlv_4= '}' (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )? otherlv_7= ';' ) ;
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
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1130:28: ( ( ( (lv_Type_0_0= ruleObjectType ) ) ( (lv_Name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameter ) )* otherlv_4= '}' (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )? otherlv_7= ';' ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1131:1: ( ( (lv_Type_0_0= ruleObjectType ) ) ( (lv_Name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameter ) )* otherlv_4= '}' (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )? otherlv_7= ';' )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1131:1: ( ( (lv_Type_0_0= ruleObjectType ) ) ( (lv_Name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameter ) )* otherlv_4= '}' (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )? otherlv_7= ';' )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1131:2: ( (lv_Type_0_0= ruleObjectType ) ) ( (lv_Name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameter ) )* otherlv_4= '}' (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )? otherlv_7= ';'
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1131:2: ( (lv_Type_0_0= ruleObjectType ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1132:1: (lv_Type_0_0= ruleObjectType )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1132:1: (lv_Type_0_0= ruleObjectType )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1133:3: lv_Type_0_0= ruleObjectType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOilObjectAccess().getTypeObjectTypeEnumRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleObjectType_in_ruleOilObject2288);
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

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1149:2: ( (lv_Name_1_0= RULE_ID ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1150:1: (lv_Name_1_0= RULE_ID )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1150:1: (lv_Name_1_0= RULE_ID )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1151:3: lv_Name_1_0= RULE_ID
            {
            lv_Name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOilObject2305); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleOilObject2322); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getOilObjectAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1171:1: ( (lv_Parameters_3_0= ruleParameter ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_ID||(LA32_0>=27 && LA32_0<=61)) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1172:1: (lv_Parameters_3_0= ruleParameter )
            	    {
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1172:1: (lv_Parameters_3_0= ruleParameter )
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1173:3: lv_Parameters_3_0= ruleParameter
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOilObjectAccess().getParametersParameterParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleParameter_in_ruleOilObject2343);
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
            	    break loop32;
                }
            } while (true);

            otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleOilObject2356); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getOilObjectAccess().getRightCurlyBracketKeyword_4());
                  
            }
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1193:1: (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==19) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1193:3: otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleOilObject2369); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getOilObjectAccess().getColonKeyword_5_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1197:1: ( (lv_Description_6_0= RULE_STRING ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1198:1: (lv_Description_6_0= RULE_STRING )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1198:1: (lv_Description_6_0= RULE_STRING )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1199:3: lv_Description_6_0= RULE_STRING
                    {
                    lv_Description_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleOilObject2386); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_Description_6_0, grammarAccess.getOilObjectAccess().getDescriptionSTRINGTerminalRuleCall_5_1_0()); 
                      		
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

            otherlv_7=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleOilObject2405); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getOilObjectAccess().getSemicolonKeyword_6());
                  
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1227:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1228:2: (iv_ruleParameter= ruleParameter EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1229:2: iv_ruleParameter= ruleParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_entryRuleParameter2441);
            iv_ruleParameter=ruleParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameter; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParameter2451); if (state.failed) return current;

            }

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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1236:1: ruleParameter returns [EObject current=null] : ( () ( ( ruleSpecialId ) ) otherlv_2= '=' ( ( ( ( 'AUTO' ) )=> (lv_Auto_3_0= 'AUTO' ) ) | ( (lv_Value_4_0= ruleGenericValue ) ) | ( ( ruleSpecialId ) ) ) (otherlv_6= '{' ( (lv_Parameters_7_0= ruleParameter ) )* otherlv_8= '}' )? (otherlv_9= ':' ( (lv_Description_10_0= RULE_STRING ) ) )? otherlv_11= ';' ) ;
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
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1239:28: ( ( () ( ( ruleSpecialId ) ) otherlv_2= '=' ( ( ( ( 'AUTO' ) )=> (lv_Auto_3_0= 'AUTO' ) ) | ( (lv_Value_4_0= ruleGenericValue ) ) | ( ( ruleSpecialId ) ) ) (otherlv_6= '{' ( (lv_Parameters_7_0= ruleParameter ) )* otherlv_8= '}' )? (otherlv_9= ':' ( (lv_Description_10_0= RULE_STRING ) ) )? otherlv_11= ';' ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1240:1: ( () ( ( ruleSpecialId ) ) otherlv_2= '=' ( ( ( ( 'AUTO' ) )=> (lv_Auto_3_0= 'AUTO' ) ) | ( (lv_Value_4_0= ruleGenericValue ) ) | ( ( ruleSpecialId ) ) ) (otherlv_6= '{' ( (lv_Parameters_7_0= ruleParameter ) )* otherlv_8= '}' )? (otherlv_9= ':' ( (lv_Description_10_0= RULE_STRING ) ) )? otherlv_11= ';' )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1240:1: ( () ( ( ruleSpecialId ) ) otherlv_2= '=' ( ( ( ( 'AUTO' ) )=> (lv_Auto_3_0= 'AUTO' ) ) | ( (lv_Value_4_0= ruleGenericValue ) ) | ( ( ruleSpecialId ) ) ) (otherlv_6= '{' ( (lv_Parameters_7_0= ruleParameter ) )* otherlv_8= '}' )? (otherlv_9= ':' ( (lv_Description_10_0= RULE_STRING ) ) )? otherlv_11= ';' )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1240:2: () ( ( ruleSpecialId ) ) otherlv_2= '=' ( ( ( ( 'AUTO' ) )=> (lv_Auto_3_0= 'AUTO' ) ) | ( (lv_Value_4_0= ruleGenericValue ) ) | ( ( ruleSpecialId ) ) ) (otherlv_6= '{' ( (lv_Parameters_7_0= ruleParameter ) )* otherlv_8= '}' )? (otherlv_9= ':' ( (lv_Description_10_0= RULE_STRING ) ) )? otherlv_11= ';'
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1240:2: ()
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1241:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getParameterAccess().getParameterAction_0(),
                          current);
                  
            }

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1246:2: ( ( ruleSpecialId ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1247:1: ( ruleSpecialId )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1247:1: ( ruleSpecialId )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1248:3: ruleSpecialId
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getParameterRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterAccess().getTypeParameterTypeCrossReference_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_ruleParameter2508);
            ruleSpecialId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleParameter2520); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getEqualsSignKeyword_2());
                  
            }
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1265:1: ( ( ( ( 'AUTO' ) )=> (lv_Auto_3_0= 'AUTO' ) ) | ( (lv_Value_4_0= ruleGenericValue ) ) | ( ( ruleSpecialId ) ) )
            int alt34=3;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==23) && (synpred4_InternalOil())) {
                alt34=1;
            }
            else if ( (LA34_0==RULE_STRING||(LA34_0>=RULE_NON_ZERO_INT && LA34_0<=RULE_HEX)||(LA34_0>=62 && LA34_0<=63)) ) {
                alt34=2;
            }
            else if ( (LA34_0==RULE_ID||(LA34_0>=27 && LA34_0<=61)) ) {
                alt34=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1265:2: ( ( ( 'AUTO' ) )=> (lv_Auto_3_0= 'AUTO' ) )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1265:2: ( ( ( 'AUTO' ) )=> (lv_Auto_3_0= 'AUTO' ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1265:3: ( ( 'AUTO' ) )=> (lv_Auto_3_0= 'AUTO' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1272:1: (lv_Auto_3_0= 'AUTO' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1273:3: lv_Auto_3_0= 'AUTO'
                    {
                    lv_Auto_3_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleParameter2554); if (state.failed) return current;
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
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1287:6: ( (lv_Value_4_0= ruleGenericValue ) )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1287:6: ( (lv_Value_4_0= ruleGenericValue ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1288:1: (lv_Value_4_0= ruleGenericValue )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1288:1: (lv_Value_4_0= ruleGenericValue )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1289:3: lv_Value_4_0= ruleGenericValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParameterAccess().getValueGenericValueParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleGenericValue_in_ruleParameter2594);
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
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1306:6: ( ( ruleSpecialId ) )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1306:6: ( ( ruleSpecialId ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1307:1: ( ruleSpecialId )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1307:1: ( ruleSpecialId )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1308:3: ruleSpecialId
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getParameterRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParameterAccess().getValueRefParameterRefCrossReference_3_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_ruleParameter2623);
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

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1321:3: (otherlv_6= '{' ( (lv_Parameters_7_0= ruleParameter ) )* otherlv_8= '}' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==17) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1321:5: otherlv_6= '{' ( (lv_Parameters_7_0= ruleParameter ) )* otherlv_8= '}'
                    {
                    otherlv_6=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleParameter2637); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getParameterAccess().getLeftCurlyBracketKeyword_4_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1325:1: ( (lv_Parameters_7_0= ruleParameter ) )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==RULE_ID||(LA35_0>=27 && LA35_0<=61)) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1326:1: (lv_Parameters_7_0= ruleParameter )
                    	    {
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1326:1: (lv_Parameters_7_0= ruleParameter )
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1327:3: lv_Parameters_7_0= ruleParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getParameterAccess().getParametersParameterParserRuleCall_4_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleParameter_in_ruleParameter2658);
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
                    	    break loop35;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleParameter2671); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getParameterAccess().getRightCurlyBracketKeyword_4_2());
                          
                    }

                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1347:3: (otherlv_9= ':' ( (lv_Description_10_0= RULE_STRING ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==19) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1347:5: otherlv_9= ':' ( (lv_Description_10_0= RULE_STRING ) )
                    {
                    otherlv_9=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleParameter2686); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getParameterAccess().getColonKeyword_5_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1351:1: ( (lv_Description_10_0= RULE_STRING ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1352:1: (lv_Description_10_0= RULE_STRING )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1352:1: (lv_Description_10_0= RULE_STRING )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1353:3: lv_Description_10_0= RULE_STRING
                    {
                    lv_Description_10_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleParameter2703); if (state.failed) return current;
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

            otherlv_11=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleParameter2722); if (state.failed) return current;
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1381:1: entryRuleSpecialId returns [String current=null] : iv_ruleSpecialId= ruleSpecialId EOF ;
    public final String entryRuleSpecialId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSpecialId = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1382:2: (iv_ruleSpecialId= ruleSpecialId EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1383:2: iv_ruleSpecialId= ruleSpecialId EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSpecialIdRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_entryRuleSpecialId2759);
            iv_ruleSpecialId=ruleSpecialId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSpecialId.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpecialId2770); if (state.failed) return current;

            }

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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1390:1: ruleSpecialId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | kw= 'STRING' | kw= 'UINT32' | kw= 'INT32' | kw= 'UINT64' | kw= 'INT64' | kw= 'FLOAT' | kw= 'DOUBLE' | kw= 'BOOLEAN' | kw= 'ENUM' | kw= 'OS' | kw= 'ALARM' | kw= 'APPMODE' | kw= 'COUNTER' | kw= 'COM' | kw= 'EVENT' | kw= 'IPDU' | kw= 'ISR' | kw= 'MESSAGE' | kw= 'NETWORKMESSAGE' | kw= 'NM' | kw= 'RESOURCE' | kw= 'TASK' | kw= 'OS_TYPE' | kw= 'ALARM_TYPE' | kw= 'APPMODE_TYPE' | kw= 'COUNTER_TYPE' | kw= 'COM_TYPE' | kw= 'EVENT_TYPE' | kw= 'IPDU_TYPE' | kw= 'ISR_TYPE' | kw= 'MESSAGE_TYPE' | kw= 'NETWORKMESSAGE_TYPE' | kw= 'NM_TYPE' | kw= 'RESOURCE_TYPE' | kw= 'TASK_TYPE' ) ;
    public final AntlrDatatypeRuleToken ruleSpecialId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1393:28: ( (this_ID_0= RULE_ID | kw= 'STRING' | kw= 'UINT32' | kw= 'INT32' | kw= 'UINT64' | kw= 'INT64' | kw= 'FLOAT' | kw= 'DOUBLE' | kw= 'BOOLEAN' | kw= 'ENUM' | kw= 'OS' | kw= 'ALARM' | kw= 'APPMODE' | kw= 'COUNTER' | kw= 'COM' | kw= 'EVENT' | kw= 'IPDU' | kw= 'ISR' | kw= 'MESSAGE' | kw= 'NETWORKMESSAGE' | kw= 'NM' | kw= 'RESOURCE' | kw= 'TASK' | kw= 'OS_TYPE' | kw= 'ALARM_TYPE' | kw= 'APPMODE_TYPE' | kw= 'COUNTER_TYPE' | kw= 'COM_TYPE' | kw= 'EVENT_TYPE' | kw= 'IPDU_TYPE' | kw= 'ISR_TYPE' | kw= 'MESSAGE_TYPE' | kw= 'NETWORKMESSAGE_TYPE' | kw= 'NM_TYPE' | kw= 'RESOURCE_TYPE' | kw= 'TASK_TYPE' ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1394:1: (this_ID_0= RULE_ID | kw= 'STRING' | kw= 'UINT32' | kw= 'INT32' | kw= 'UINT64' | kw= 'INT64' | kw= 'FLOAT' | kw= 'DOUBLE' | kw= 'BOOLEAN' | kw= 'ENUM' | kw= 'OS' | kw= 'ALARM' | kw= 'APPMODE' | kw= 'COUNTER' | kw= 'COM' | kw= 'EVENT' | kw= 'IPDU' | kw= 'ISR' | kw= 'MESSAGE' | kw= 'NETWORKMESSAGE' | kw= 'NM' | kw= 'RESOURCE' | kw= 'TASK' | kw= 'OS_TYPE' | kw= 'ALARM_TYPE' | kw= 'APPMODE_TYPE' | kw= 'COUNTER_TYPE' | kw= 'COM_TYPE' | kw= 'EVENT_TYPE' | kw= 'IPDU_TYPE' | kw= 'ISR_TYPE' | kw= 'MESSAGE_TYPE' | kw= 'NETWORKMESSAGE_TYPE' | kw= 'NM_TYPE' | kw= 'RESOURCE_TYPE' | kw= 'TASK_TYPE' )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1394:1: (this_ID_0= RULE_ID | kw= 'STRING' | kw= 'UINT32' | kw= 'INT32' | kw= 'UINT64' | kw= 'INT64' | kw= 'FLOAT' | kw= 'DOUBLE' | kw= 'BOOLEAN' | kw= 'ENUM' | kw= 'OS' | kw= 'ALARM' | kw= 'APPMODE' | kw= 'COUNTER' | kw= 'COM' | kw= 'EVENT' | kw= 'IPDU' | kw= 'ISR' | kw= 'MESSAGE' | kw= 'NETWORKMESSAGE' | kw= 'NM' | kw= 'RESOURCE' | kw= 'TASK' | kw= 'OS_TYPE' | kw= 'ALARM_TYPE' | kw= 'APPMODE_TYPE' | kw= 'COUNTER_TYPE' | kw= 'COM_TYPE' | kw= 'EVENT_TYPE' | kw= 'IPDU_TYPE' | kw= 'ISR_TYPE' | kw= 'MESSAGE_TYPE' | kw= 'NETWORKMESSAGE_TYPE' | kw= 'NM_TYPE' | kw= 'RESOURCE_TYPE' | kw= 'TASK_TYPE' )
            int alt38=36;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt38=1;
                }
                break;
            case 27:
                {
                alt38=2;
                }
                break;
            case 28:
                {
                alt38=3;
                }
                break;
            case 29:
                {
                alt38=4;
                }
                break;
            case 30:
                {
                alt38=5;
                }
                break;
            case 31:
                {
                alt38=6;
                }
                break;
            case 32:
                {
                alt38=7;
                }
                break;
            case 33:
                {
                alt38=8;
                }
                break;
            case 34:
                {
                alt38=9;
                }
                break;
            case 35:
                {
                alt38=10;
                }
                break;
            case 36:
                {
                alt38=11;
                }
                break;
            case 37:
                {
                alt38=12;
                }
                break;
            case 38:
                {
                alt38=13;
                }
                break;
            case 39:
                {
                alt38=14;
                }
                break;
            case 40:
                {
                alt38=15;
                }
                break;
            case 41:
                {
                alt38=16;
                }
                break;
            case 42:
                {
                alt38=17;
                }
                break;
            case 43:
                {
                alt38=18;
                }
                break;
            case 44:
                {
                alt38=19;
                }
                break;
            case 45:
                {
                alt38=20;
                }
                break;
            case 46:
                {
                alt38=21;
                }
                break;
            case 47:
                {
                alt38=22;
                }
                break;
            case 48:
                {
                alt38=23;
                }
                break;
            case 49:
                {
                alt38=24;
                }
                break;
            case 50:
                {
                alt38=25;
                }
                break;
            case 51:
                {
                alt38=26;
                }
                break;
            case 52:
                {
                alt38=27;
                }
                break;
            case 53:
                {
                alt38=28;
                }
                break;
            case 54:
                {
                alt38=29;
                }
                break;
            case 55:
                {
                alt38=30;
                }
                break;
            case 56:
                {
                alt38=31;
                }
                break;
            case 57:
                {
                alt38=32;
                }
                break;
            case 58:
                {
                alt38=33;
                }
                break;
            case 59:
                {
                alt38=34;
                }
                break;
            case 60:
                {
                alt38=35;
                }
                break;
            case 61:
                {
                alt38=36;
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
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1394:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSpecialId2810); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_0, grammarAccess.getSpecialIdAccess().getIDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1403:2: kw= 'STRING'
                    {
                    kw=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleSpecialId2834); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getSTRINGKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1410:2: kw= 'UINT32'
                    {
                    kw=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleSpecialId2853); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getUINT32Keyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1417:2: kw= 'INT32'
                    {
                    kw=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleSpecialId2872); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getINT32Keyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1424:2: kw= 'UINT64'
                    {
                    kw=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleSpecialId2891); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getUINT64Keyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1431:2: kw= 'INT64'
                    {
                    kw=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleSpecialId2910); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getINT64Keyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1438:2: kw= 'FLOAT'
                    {
                    kw=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleSpecialId2929); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getFLOATKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1445:2: kw= 'DOUBLE'
                    {
                    kw=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleSpecialId2948); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getDOUBLEKeyword_7()); 
                          
                    }

                    }
                    break;
                case 9 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1452:2: kw= 'BOOLEAN'
                    {
                    kw=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleSpecialId2967); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getBOOLEANKeyword_8()); 
                          
                    }

                    }
                    break;
                case 10 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1459:2: kw= 'ENUM'
                    {
                    kw=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleSpecialId2986); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getENUMKeyword_9()); 
                          
                    }

                    }
                    break;
                case 11 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1466:2: kw= 'OS'
                    {
                    kw=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleSpecialId3005); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getOSKeyword_10()); 
                          
                    }

                    }
                    break;
                case 12 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1473:2: kw= 'ALARM'
                    {
                    kw=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleSpecialId3024); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getALARMKeyword_11()); 
                          
                    }

                    }
                    break;
                case 13 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1480:2: kw= 'APPMODE'
                    {
                    kw=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleSpecialId3043); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getAPPMODEKeyword_12()); 
                          
                    }

                    }
                    break;
                case 14 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1487:2: kw= 'COUNTER'
                    {
                    kw=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleSpecialId3062); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getCOUNTERKeyword_13()); 
                          
                    }

                    }
                    break;
                case 15 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1494:2: kw= 'COM'
                    {
                    kw=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleSpecialId3081); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getCOMKeyword_14()); 
                          
                    }

                    }
                    break;
                case 16 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1501:2: kw= 'EVENT'
                    {
                    kw=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleSpecialId3100); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getEVENTKeyword_15()); 
                          
                    }

                    }
                    break;
                case 17 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1508:2: kw= 'IPDU'
                    {
                    kw=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleSpecialId3119); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getIPDUKeyword_16()); 
                          
                    }

                    }
                    break;
                case 18 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1515:2: kw= 'ISR'
                    {
                    kw=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleSpecialId3138); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getISRKeyword_17()); 
                          
                    }

                    }
                    break;
                case 19 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1522:2: kw= 'MESSAGE'
                    {
                    kw=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleSpecialId3157); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getMESSAGEKeyword_18()); 
                          
                    }

                    }
                    break;
                case 20 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1529:2: kw= 'NETWORKMESSAGE'
                    {
                    kw=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleSpecialId3176); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getNETWORKMESSAGEKeyword_19()); 
                          
                    }

                    }
                    break;
                case 21 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1536:2: kw= 'NM'
                    {
                    kw=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleSpecialId3195); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getNMKeyword_20()); 
                          
                    }

                    }
                    break;
                case 22 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1543:2: kw= 'RESOURCE'
                    {
                    kw=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleSpecialId3214); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getRESOURCEKeyword_21()); 
                          
                    }

                    }
                    break;
                case 23 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1550:2: kw= 'TASK'
                    {
                    kw=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleSpecialId3233); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getTASKKeyword_22()); 
                          
                    }

                    }
                    break;
                case 24 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1557:2: kw= 'OS_TYPE'
                    {
                    kw=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleSpecialId3252); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getOS_TYPEKeyword_23()); 
                          
                    }

                    }
                    break;
                case 25 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1564:2: kw= 'ALARM_TYPE'
                    {
                    kw=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleSpecialId3271); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getALARM_TYPEKeyword_24()); 
                          
                    }

                    }
                    break;
                case 26 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1571:2: kw= 'APPMODE_TYPE'
                    {
                    kw=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleSpecialId3290); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getAPPMODE_TYPEKeyword_25()); 
                          
                    }

                    }
                    break;
                case 27 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1578:2: kw= 'COUNTER_TYPE'
                    {
                    kw=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleSpecialId3309); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getCOUNTER_TYPEKeyword_26()); 
                          
                    }

                    }
                    break;
                case 28 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1585:2: kw= 'COM_TYPE'
                    {
                    kw=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleSpecialId3328); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getCOM_TYPEKeyword_27()); 
                          
                    }

                    }
                    break;
                case 29 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1592:2: kw= 'EVENT_TYPE'
                    {
                    kw=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleSpecialId3347); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getEVENT_TYPEKeyword_28()); 
                          
                    }

                    }
                    break;
                case 30 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1599:2: kw= 'IPDU_TYPE'
                    {
                    kw=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleSpecialId3366); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getIPDU_TYPEKeyword_29()); 
                          
                    }

                    }
                    break;
                case 31 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1606:2: kw= 'ISR_TYPE'
                    {
                    kw=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleSpecialId3385); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getISR_TYPEKeyword_30()); 
                          
                    }

                    }
                    break;
                case 32 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1613:2: kw= 'MESSAGE_TYPE'
                    {
                    kw=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleSpecialId3404); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getMESSAGE_TYPEKeyword_31()); 
                          
                    }

                    }
                    break;
                case 33 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1620:2: kw= 'NETWORKMESSAGE_TYPE'
                    {
                    kw=(Token)match(input,58,FollowSets000.FOLLOW_58_in_ruleSpecialId3423); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getNETWORKMESSAGE_TYPEKeyword_32()); 
                          
                    }

                    }
                    break;
                case 34 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1627:2: kw= 'NM_TYPE'
                    {
                    kw=(Token)match(input,59,FollowSets000.FOLLOW_59_in_ruleSpecialId3442); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getNM_TYPEKeyword_33()); 
                          
                    }

                    }
                    break;
                case 35 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1634:2: kw= 'RESOURCE_TYPE'
                    {
                    kw=(Token)match(input,60,FollowSets000.FOLLOW_60_in_ruleSpecialId3461); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getRESOURCE_TYPEKeyword_34()); 
                          
                    }

                    }
                    break;
                case 36 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1641:2: kw= 'TASK_TYPE'
                    {
                    kw=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleSpecialId3480); if (state.failed) return current;
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1654:1: entryRuleGenericValue returns [String current=null] : iv_ruleGenericValue= ruleGenericValue EOF ;
    public final String entryRuleGenericValue() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleGenericValue = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1655:2: (iv_ruleGenericValue= ruleGenericValue EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1656:2: iv_ruleGenericValue= ruleGenericValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGenericValueRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleGenericValue_in_entryRuleGenericValue3521);
            iv_ruleGenericValue=ruleGenericValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGenericValue.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGenericValue3532); if (state.failed) return current;

            }

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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1663:1: ruleGenericValue returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_INT_1= ruleINT | this_DOUBLE_2= ruleDOUBLE ) ;
    public final AntlrDatatypeRuleToken ruleGenericValue() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        AntlrDatatypeRuleToken this_INT_1 = null;

        AntlrDatatypeRuleToken this_DOUBLE_2 = null;


         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1666:28: ( (this_STRING_0= RULE_STRING | this_INT_1= ruleINT | this_DOUBLE_2= ruleDOUBLE ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1667:1: (this_STRING_0= RULE_STRING | this_INT_1= ruleINT | this_DOUBLE_2= ruleDOUBLE )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1667:1: (this_STRING_0= RULE_STRING | this_INT_1= ruleINT | this_DOUBLE_2= ruleDOUBLE )
            int alt39=3;
            alt39 = dfa39.predict(input);
            switch (alt39) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1667:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleGenericValue3572); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_STRING_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_STRING_0, grammarAccess.getGenericValueAccess().getSTRINGTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1676:5: this_INT_1= ruleINT
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getGenericValueAccess().getINTParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleINT_in_ruleGenericValue3605);
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
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1688:5: this_DOUBLE_2= ruleDOUBLE
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getGenericValueAccess().getDOUBLEParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleDOUBLE_in_ruleGenericValue3638);
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1706:1: entryRuleINT returns [String current=null] : iv_ruleINT= ruleINT EOF ;
    public final String entryRuleINT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINT = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1707:2: (iv_ruleINT= ruleINT EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1708:2: iv_ruleINT= ruleINT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getINTRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleINT_in_entryRuleINT3684);
            iv_ruleINT=ruleINT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleINT.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleINT3695); if (state.failed) return current;

            }

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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1715:1: ruleINT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? ( (this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )* ) | this_ZERO_INT_5= RULE_ZERO_INT | this_HEX_6= RULE_HEX ) ) ;
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
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1718:28: ( ( (kw= '+' | kw= '-' )? ( (this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )* ) | this_ZERO_INT_5= RULE_ZERO_INT | this_HEX_6= RULE_HEX ) ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1719:1: ( (kw= '+' | kw= '-' )? ( (this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )* ) | this_ZERO_INT_5= RULE_ZERO_INT | this_HEX_6= RULE_HEX ) )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1719:1: ( (kw= '+' | kw= '-' )? ( (this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )* ) | this_ZERO_INT_5= RULE_ZERO_INT | this_HEX_6= RULE_HEX ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1719:2: (kw= '+' | kw= '-' )? ( (this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )* ) | this_ZERO_INT_5= RULE_ZERO_INT | this_HEX_6= RULE_HEX )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1719:2: (kw= '+' | kw= '-' )?
            int alt40=3;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==62) ) {
                alt40=1;
            }
            else if ( (LA40_0==63) ) {
                alt40=2;
            }
            switch (alt40) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1720:2: kw= '+'
                    {
                    kw=(Token)match(input,62,FollowSets000.FOLLOW_62_in_ruleINT3734); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getINTAccess().getPlusSignKeyword_0_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1727:2: kw= '-'
                    {
                    kw=(Token)match(input,63,FollowSets000.FOLLOW_63_in_ruleINT3753); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getINTAccess().getHyphenMinusKeyword_0_1()); 
                          
                    }

                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1732:3: ( (this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )* ) | this_ZERO_INT_5= RULE_ZERO_INT | this_HEX_6= RULE_HEX )
            int alt42=3;
            switch ( input.LA(1) ) {
            case RULE_NON_ZERO_INT:
                {
                alt42=1;
                }
                break;
            case RULE_ZERO_INT:
                {
                alt42=2;
                }
                break;
            case RULE_HEX:
                {
                alt42=3;
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
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1732:4: (this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )* )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1732:4: (this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )* )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1732:9: this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )*
                    {
                    this_NON_ZERO_INT_2=(Token)match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_ruleINT3772); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_NON_ZERO_INT_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_NON_ZERO_INT_2, grammarAccess.getINTAccess().getNON_ZERO_INTTerminalRuleCall_1_0_0()); 
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1739:1: (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )*
                    loop41:
                    do {
                        int alt41=3;
                        int LA41_0 = input.LA(1);

                        if ( (LA41_0==RULE_ZERO_INT) ) {
                            alt41=1;
                        }
                        else if ( (LA41_0==RULE_NON_ZERO_INT) ) {
                            alt41=2;
                        }


                        switch (alt41) {
                    	case 1 :
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1739:6: this_ZERO_INT_3= RULE_ZERO_INT
                    	    {
                    	    this_ZERO_INT_3=(Token)match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_ruleINT3793); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		current.merge(this_ZERO_INT_3);
                    	          
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_ZERO_INT_3, grammarAccess.getINTAccess().getZERO_INTTerminalRuleCall_1_0_1_0()); 
                    	          
                    	    }

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1747:10: this_NON_ZERO_INT_4= RULE_NON_ZERO_INT
                    	    {
                    	    this_NON_ZERO_INT_4=(Token)match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_ruleINT3819); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		current.merge(this_NON_ZERO_INT_4);
                    	          
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_NON_ZERO_INT_4, grammarAccess.getINTAccess().getNON_ZERO_INTTerminalRuleCall_1_0_1_1()); 
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop41;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1755:10: this_ZERO_INT_5= RULE_ZERO_INT
                    {
                    this_ZERO_INT_5=(Token)match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_ruleINT3848); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ZERO_INT_5);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ZERO_INT_5, grammarAccess.getINTAccess().getZERO_INTTerminalRuleCall_1_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1763:10: this_HEX_6= RULE_HEX
                    {
                    this_HEX_6=(Token)match(input,RULE_HEX,FollowSets000.FOLLOW_RULE_HEX_in_ruleINT3874); if (state.failed) return current;
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1778:1: entryRuleDOUBLE returns [String current=null] : iv_ruleDOUBLE= ruleDOUBLE EOF ;
    public final String entryRuleDOUBLE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDOUBLE = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1779:2: (iv_ruleDOUBLE= ruleDOUBLE EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1780:2: iv_ruleDOUBLE= ruleDOUBLE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDOUBLERule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleDOUBLE_in_entryRuleDOUBLE3921);
            iv_ruleDOUBLE=ruleDOUBLE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDOUBLE.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDOUBLE3932); if (state.failed) return current;

            }

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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1787:1: ruleDOUBLE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? (this_ZERO_INT_2= RULE_ZERO_INT | (this_NON_ZERO_INT_3= RULE_NON_ZERO_INT (this_ZERO_INT_4= RULE_ZERO_INT | this_NON_ZERO_INT_5= RULE_NON_ZERO_INT )* ) ) ( ( '.' )=>kw= '.' ) (this_ZERO_INT_7= RULE_ZERO_INT | this_NON_ZERO_INT_8= RULE_NON_ZERO_INT )+ ) ;
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
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1790:28: ( ( (kw= '+' | kw= '-' )? (this_ZERO_INT_2= RULE_ZERO_INT | (this_NON_ZERO_INT_3= RULE_NON_ZERO_INT (this_ZERO_INT_4= RULE_ZERO_INT | this_NON_ZERO_INT_5= RULE_NON_ZERO_INT )* ) ) ( ( '.' )=>kw= '.' ) (this_ZERO_INT_7= RULE_ZERO_INT | this_NON_ZERO_INT_8= RULE_NON_ZERO_INT )+ ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1791:1: ( (kw= '+' | kw= '-' )? (this_ZERO_INT_2= RULE_ZERO_INT | (this_NON_ZERO_INT_3= RULE_NON_ZERO_INT (this_ZERO_INT_4= RULE_ZERO_INT | this_NON_ZERO_INT_5= RULE_NON_ZERO_INT )* ) ) ( ( '.' )=>kw= '.' ) (this_ZERO_INT_7= RULE_ZERO_INT | this_NON_ZERO_INT_8= RULE_NON_ZERO_INT )+ )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1791:1: ( (kw= '+' | kw= '-' )? (this_ZERO_INT_2= RULE_ZERO_INT | (this_NON_ZERO_INT_3= RULE_NON_ZERO_INT (this_ZERO_INT_4= RULE_ZERO_INT | this_NON_ZERO_INT_5= RULE_NON_ZERO_INT )* ) ) ( ( '.' )=>kw= '.' ) (this_ZERO_INT_7= RULE_ZERO_INT | this_NON_ZERO_INT_8= RULE_NON_ZERO_INT )+ )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1791:2: (kw= '+' | kw= '-' )? (this_ZERO_INT_2= RULE_ZERO_INT | (this_NON_ZERO_INT_3= RULE_NON_ZERO_INT (this_ZERO_INT_4= RULE_ZERO_INT | this_NON_ZERO_INT_5= RULE_NON_ZERO_INT )* ) ) ( ( '.' )=>kw= '.' ) (this_ZERO_INT_7= RULE_ZERO_INT | this_NON_ZERO_INT_8= RULE_NON_ZERO_INT )+
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1791:2: (kw= '+' | kw= '-' )?
            int alt43=3;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==62) ) {
                alt43=1;
            }
            else if ( (LA43_0==63) ) {
                alt43=2;
            }
            switch (alt43) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1792:2: kw= '+'
                    {
                    kw=(Token)match(input,62,FollowSets000.FOLLOW_62_in_ruleDOUBLE3971); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getDOUBLEAccess().getPlusSignKeyword_0_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1799:2: kw= '-'
                    {
                    kw=(Token)match(input,63,FollowSets000.FOLLOW_63_in_ruleDOUBLE3990); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getDOUBLEAccess().getHyphenMinusKeyword_0_1()); 
                          
                    }

                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1804:3: (this_ZERO_INT_2= RULE_ZERO_INT | (this_NON_ZERO_INT_3= RULE_NON_ZERO_INT (this_ZERO_INT_4= RULE_ZERO_INT | this_NON_ZERO_INT_5= RULE_NON_ZERO_INT )* ) )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_ZERO_INT) ) {
                alt45=1;
            }
            else if ( (LA45_0==RULE_NON_ZERO_INT) ) {
                alt45=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1804:8: this_ZERO_INT_2= RULE_ZERO_INT
                    {
                    this_ZERO_INT_2=(Token)match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_ruleDOUBLE4008); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ZERO_INT_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ZERO_INT_2, grammarAccess.getDOUBLEAccess().getZERO_INTTerminalRuleCall_1_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1812:6: (this_NON_ZERO_INT_3= RULE_NON_ZERO_INT (this_ZERO_INT_4= RULE_ZERO_INT | this_NON_ZERO_INT_5= RULE_NON_ZERO_INT )* )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1812:6: (this_NON_ZERO_INT_3= RULE_NON_ZERO_INT (this_ZERO_INT_4= RULE_ZERO_INT | this_NON_ZERO_INT_5= RULE_NON_ZERO_INT )* )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1812:11: this_NON_ZERO_INT_3= RULE_NON_ZERO_INT (this_ZERO_INT_4= RULE_ZERO_INT | this_NON_ZERO_INT_5= RULE_NON_ZERO_INT )*
                    {
                    this_NON_ZERO_INT_3=(Token)match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_ruleDOUBLE4035); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_NON_ZERO_INT_3);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_NON_ZERO_INT_3, grammarAccess.getDOUBLEAccess().getNON_ZERO_INTTerminalRuleCall_1_1_0()); 
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1819:1: (this_ZERO_INT_4= RULE_ZERO_INT | this_NON_ZERO_INT_5= RULE_NON_ZERO_INT )*
                    loop44:
                    do {
                        int alt44=3;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==RULE_ZERO_INT) ) {
                            alt44=1;
                        }
                        else if ( (LA44_0==RULE_NON_ZERO_INT) ) {
                            alt44=2;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1819:6: this_ZERO_INT_4= RULE_ZERO_INT
                    	    {
                    	    this_ZERO_INT_4=(Token)match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_ruleDOUBLE4056); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		current.merge(this_ZERO_INT_4);
                    	          
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_ZERO_INT_4, grammarAccess.getDOUBLEAccess().getZERO_INTTerminalRuleCall_1_1_1_0()); 
                    	          
                    	    }

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1827:10: this_NON_ZERO_INT_5= RULE_NON_ZERO_INT
                    	    {
                    	    this_NON_ZERO_INT_5=(Token)match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_ruleDOUBLE4082); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		current.merge(this_NON_ZERO_INT_5);
                    	          
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_NON_ZERO_INT_5, grammarAccess.getDOUBLEAccess().getNON_ZERO_INTTerminalRuleCall_1_1_1_1()); 
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop44;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1834:5: ( ( '.' )=>kw= '.' )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1834:6: ( '.' )=>kw= '.'
            {
            kw=(Token)match(input,64,FollowSets000.FOLLOW_64_in_ruleDOUBLE4113); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getDOUBLEAccess().getFullStopKeyword_2()); 
                  
            }

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1842:2: (this_ZERO_INT_7= RULE_ZERO_INT | this_NON_ZERO_INT_8= RULE_NON_ZERO_INT )+
            int cnt46=0;
            loop46:
            do {
                int alt46=3;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==RULE_ZERO_INT) ) {
                    alt46=1;
                }
                else if ( (LA46_0==RULE_NON_ZERO_INT) ) {
                    alt46=2;
                }


                switch (alt46) {
            	case 1 :
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1842:7: this_ZERO_INT_7= RULE_ZERO_INT
            	    {
            	    this_ZERO_INT_7=(Token)match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_ruleDOUBLE4130); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ZERO_INT_7);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ZERO_INT_7, grammarAccess.getDOUBLEAccess().getZERO_INTTerminalRuleCall_3_0()); 
            	          
            	    }

            	    }
            	    break;
            	case 2 :
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1850:10: this_NON_ZERO_INT_8= RULE_NON_ZERO_INT
            	    {
            	    this_NON_ZERO_INT_8=(Token)match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_ruleDOUBLE4156); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_NON_ZERO_INT_8);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NON_ZERO_INT_8, grammarAccess.getDOUBLEAccess().getNON_ZERO_INTTerminalRuleCall_3_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt46 >= 1 ) break loop46;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(46, input);
                        throw eee;
                }
                cnt46++;
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1865:1: ruleVType returns [Enumerator current=null] : ( (enumLiteral_0= 'STRING' ) | (enumLiteral_1= 'UINT32' ) | (enumLiteral_2= 'INT32' ) | (enumLiteral_3= 'UINT64' ) | (enumLiteral_4= 'INT64' ) | (enumLiteral_5= 'FLOAT' ) | (enumLiteral_6= 'DOUBLE' ) ) ;
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
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1867:28: ( ( (enumLiteral_0= 'STRING' ) | (enumLiteral_1= 'UINT32' ) | (enumLiteral_2= 'INT32' ) | (enumLiteral_3= 'UINT64' ) | (enumLiteral_4= 'INT64' ) | (enumLiteral_5= 'FLOAT' ) | (enumLiteral_6= 'DOUBLE' ) ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1868:1: ( (enumLiteral_0= 'STRING' ) | (enumLiteral_1= 'UINT32' ) | (enumLiteral_2= 'INT32' ) | (enumLiteral_3= 'UINT64' ) | (enumLiteral_4= 'INT64' ) | (enumLiteral_5= 'FLOAT' ) | (enumLiteral_6= 'DOUBLE' ) )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1868:1: ( (enumLiteral_0= 'STRING' ) | (enumLiteral_1= 'UINT32' ) | (enumLiteral_2= 'INT32' ) | (enumLiteral_3= 'UINT64' ) | (enumLiteral_4= 'INT64' ) | (enumLiteral_5= 'FLOAT' ) | (enumLiteral_6= 'DOUBLE' ) )
            int alt47=7;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt47=1;
                }
                break;
            case 28:
                {
                alt47=2;
                }
                break;
            case 29:
                {
                alt47=3;
                }
                break;
            case 30:
                {
                alt47=4;
                }
                break;
            case 31:
                {
                alt47=5;
                }
                break;
            case 32:
                {
                alt47=6;
                }
                break;
            case 33:
                {
                alt47=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1868:2: (enumLiteral_0= 'STRING' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1868:2: (enumLiteral_0= 'STRING' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1868:4: enumLiteral_0= 'STRING'
                    {
                    enumLiteral_0=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleVType4217); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVTypeAccess().getSTRINGEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getVTypeAccess().getSTRINGEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1874:6: (enumLiteral_1= 'UINT32' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1874:6: (enumLiteral_1= 'UINT32' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1874:8: enumLiteral_1= 'UINT32'
                    {
                    enumLiteral_1=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleVType4234); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVTypeAccess().getUINT32EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getVTypeAccess().getUINT32EnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1880:6: (enumLiteral_2= 'INT32' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1880:6: (enumLiteral_2= 'INT32' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1880:8: enumLiteral_2= 'INT32'
                    {
                    enumLiteral_2=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleVType4251); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVTypeAccess().getINT32EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getVTypeAccess().getINT32EnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1886:6: (enumLiteral_3= 'UINT64' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1886:6: (enumLiteral_3= 'UINT64' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1886:8: enumLiteral_3= 'UINT64'
                    {
                    enumLiteral_3=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleVType4268); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVTypeAccess().getUINT64EnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getVTypeAccess().getUINT64EnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1892:6: (enumLiteral_4= 'INT64' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1892:6: (enumLiteral_4= 'INT64' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1892:8: enumLiteral_4= 'INT64'
                    {
                    enumLiteral_4=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleVType4285); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVTypeAccess().getINT64EnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getVTypeAccess().getINT64EnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1898:6: (enumLiteral_5= 'FLOAT' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1898:6: (enumLiteral_5= 'FLOAT' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1898:8: enumLiteral_5= 'FLOAT'
                    {
                    enumLiteral_5=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleVType4302); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVTypeAccess().getFLOATEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getVTypeAccess().getFLOATEnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1904:6: (enumLiteral_6= 'DOUBLE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1904:6: (enumLiteral_6= 'DOUBLE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1904:8: enumLiteral_6= 'DOUBLE'
                    {
                    enumLiteral_6=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleVType4319); if (state.failed) return current;
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1914:1: ruleEType returns [Enumerator current=null] : ( (enumLiteral_0= 'BOOLEAN' ) | (enumLiteral_1= 'ENUM' ) ) ;
    public final Enumerator ruleEType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1916:28: ( ( (enumLiteral_0= 'BOOLEAN' ) | (enumLiteral_1= 'ENUM' ) ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1917:1: ( (enumLiteral_0= 'BOOLEAN' ) | (enumLiteral_1= 'ENUM' ) )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1917:1: ( (enumLiteral_0= 'BOOLEAN' ) | (enumLiteral_1= 'ENUM' ) )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==34) ) {
                alt48=1;
            }
            else if ( (LA48_0==35) ) {
                alt48=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1917:2: (enumLiteral_0= 'BOOLEAN' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1917:2: (enumLiteral_0= 'BOOLEAN' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1917:4: enumLiteral_0= 'BOOLEAN'
                    {
                    enumLiteral_0=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleEType4364); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getETypeAccess().getBOOLEANEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getETypeAccess().getBOOLEANEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1923:6: (enumLiteral_1= 'ENUM' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1923:6: (enumLiteral_1= 'ENUM' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1923:8: enumLiteral_1= 'ENUM'
                    {
                    enumLiteral_1=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleEType4381); if (state.failed) return current;
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1933:1: ruleObjectType returns [Enumerator current=null] : ( (enumLiteral_0= 'OS' ) | (enumLiteral_1= 'ALARM' ) | (enumLiteral_2= 'APPMODE' ) | (enumLiteral_3= 'COUNTER' ) | (enumLiteral_4= 'COM' ) | (enumLiteral_5= 'EVENT' ) | (enumLiteral_6= 'IPDU' ) | (enumLiteral_7= 'ISR' ) | (enumLiteral_8= 'MESSAGE' ) | (enumLiteral_9= 'NETWORKMESSAGE' ) | (enumLiteral_10= 'NM' ) | (enumLiteral_11= 'RESOURCE' ) | (enumLiteral_12= 'TASK' ) ) ;
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

         enterRule(); 
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1935:28: ( ( (enumLiteral_0= 'OS' ) | (enumLiteral_1= 'ALARM' ) | (enumLiteral_2= 'APPMODE' ) | (enumLiteral_3= 'COUNTER' ) | (enumLiteral_4= 'COM' ) | (enumLiteral_5= 'EVENT' ) | (enumLiteral_6= 'IPDU' ) | (enumLiteral_7= 'ISR' ) | (enumLiteral_8= 'MESSAGE' ) | (enumLiteral_9= 'NETWORKMESSAGE' ) | (enumLiteral_10= 'NM' ) | (enumLiteral_11= 'RESOURCE' ) | (enumLiteral_12= 'TASK' ) ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1936:1: ( (enumLiteral_0= 'OS' ) | (enumLiteral_1= 'ALARM' ) | (enumLiteral_2= 'APPMODE' ) | (enumLiteral_3= 'COUNTER' ) | (enumLiteral_4= 'COM' ) | (enumLiteral_5= 'EVENT' ) | (enumLiteral_6= 'IPDU' ) | (enumLiteral_7= 'ISR' ) | (enumLiteral_8= 'MESSAGE' ) | (enumLiteral_9= 'NETWORKMESSAGE' ) | (enumLiteral_10= 'NM' ) | (enumLiteral_11= 'RESOURCE' ) | (enumLiteral_12= 'TASK' ) )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1936:1: ( (enumLiteral_0= 'OS' ) | (enumLiteral_1= 'ALARM' ) | (enumLiteral_2= 'APPMODE' ) | (enumLiteral_3= 'COUNTER' ) | (enumLiteral_4= 'COM' ) | (enumLiteral_5= 'EVENT' ) | (enumLiteral_6= 'IPDU' ) | (enumLiteral_7= 'ISR' ) | (enumLiteral_8= 'MESSAGE' ) | (enumLiteral_9= 'NETWORKMESSAGE' ) | (enumLiteral_10= 'NM' ) | (enumLiteral_11= 'RESOURCE' ) | (enumLiteral_12= 'TASK' ) )
            int alt49=13;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt49=1;
                }
                break;
            case 37:
                {
                alt49=2;
                }
                break;
            case 38:
                {
                alt49=3;
                }
                break;
            case 39:
                {
                alt49=4;
                }
                break;
            case 40:
                {
                alt49=5;
                }
                break;
            case 41:
                {
                alt49=6;
                }
                break;
            case 42:
                {
                alt49=7;
                }
                break;
            case 43:
                {
                alt49=8;
                }
                break;
            case 44:
                {
                alt49=9;
                }
                break;
            case 45:
                {
                alt49=10;
                }
                break;
            case 46:
                {
                alt49=11;
                }
                break;
            case 47:
                {
                alt49=12;
                }
                break;
            case 48:
                {
                alt49=13;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1936:2: (enumLiteral_0= 'OS' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1936:2: (enumLiteral_0= 'OS' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1936:4: enumLiteral_0= 'OS'
                    {
                    enumLiteral_0=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleObjectType4426); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getOSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getObjectTypeAccess().getOSEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1942:6: (enumLiteral_1= 'ALARM' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1942:6: (enumLiteral_1= 'ALARM' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1942:8: enumLiteral_1= 'ALARM'
                    {
                    enumLiteral_1=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleObjectType4443); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getALARMEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getObjectTypeAccess().getALARMEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1948:6: (enumLiteral_2= 'APPMODE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1948:6: (enumLiteral_2= 'APPMODE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1948:8: enumLiteral_2= 'APPMODE'
                    {
                    enumLiteral_2=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleObjectType4460); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getAPPMODEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getObjectTypeAccess().getAPPMODEEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1954:6: (enumLiteral_3= 'COUNTER' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1954:6: (enumLiteral_3= 'COUNTER' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1954:8: enumLiteral_3= 'COUNTER'
                    {
                    enumLiteral_3=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleObjectType4477); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getCOUNTEREnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getObjectTypeAccess().getCOUNTEREnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1960:6: (enumLiteral_4= 'COM' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1960:6: (enumLiteral_4= 'COM' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1960:8: enumLiteral_4= 'COM'
                    {
                    enumLiteral_4=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleObjectType4494); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getCOMEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getObjectTypeAccess().getCOMEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1966:6: (enumLiteral_5= 'EVENT' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1966:6: (enumLiteral_5= 'EVENT' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1966:8: enumLiteral_5= 'EVENT'
                    {
                    enumLiteral_5=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleObjectType4511); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getEVENTEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getObjectTypeAccess().getEVENTEnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1972:6: (enumLiteral_6= 'IPDU' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1972:6: (enumLiteral_6= 'IPDU' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1972:8: enumLiteral_6= 'IPDU'
                    {
                    enumLiteral_6=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleObjectType4528); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getIPDUEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_6, grammarAccess.getObjectTypeAccess().getIPDUEnumLiteralDeclaration_6()); 
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1978:6: (enumLiteral_7= 'ISR' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1978:6: (enumLiteral_7= 'ISR' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1978:8: enumLiteral_7= 'ISR'
                    {
                    enumLiteral_7=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleObjectType4545); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getISREnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_7, grammarAccess.getObjectTypeAccess().getISREnumLiteralDeclaration_7()); 
                          
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1984:6: (enumLiteral_8= 'MESSAGE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1984:6: (enumLiteral_8= 'MESSAGE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1984:8: enumLiteral_8= 'MESSAGE'
                    {
                    enumLiteral_8=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleObjectType4562); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getMESSAGEEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_8, grammarAccess.getObjectTypeAccess().getMESSAGEEnumLiteralDeclaration_8()); 
                          
                    }

                    }


                    }
                    break;
                case 10 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1990:6: (enumLiteral_9= 'NETWORKMESSAGE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1990:6: (enumLiteral_9= 'NETWORKMESSAGE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1990:8: enumLiteral_9= 'NETWORKMESSAGE'
                    {
                    enumLiteral_9=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleObjectType4579); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getNETWORKMESSAGEEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_9, grammarAccess.getObjectTypeAccess().getNETWORKMESSAGEEnumLiteralDeclaration_9()); 
                          
                    }

                    }


                    }
                    break;
                case 11 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1996:6: (enumLiteral_10= 'NM' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1996:6: (enumLiteral_10= 'NM' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1996:8: enumLiteral_10= 'NM'
                    {
                    enumLiteral_10=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleObjectType4596); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getNMEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_10, grammarAccess.getObjectTypeAccess().getNMEnumLiteralDeclaration_10()); 
                          
                    }

                    }


                    }
                    break;
                case 12 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2002:6: (enumLiteral_11= 'RESOURCE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2002:6: (enumLiteral_11= 'RESOURCE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2002:8: enumLiteral_11= 'RESOURCE'
                    {
                    enumLiteral_11=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleObjectType4613); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getRESOURCEEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_11, grammarAccess.getObjectTypeAccess().getRESOURCEEnumLiteralDeclaration_11()); 
                          
                    }

                    }


                    }
                    break;
                case 13 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2008:6: (enumLiteral_12= 'TASK' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2008:6: (enumLiteral_12= 'TASK' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2008:8: enumLiteral_12= 'TASK'
                    {
                    enumLiteral_12=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleObjectType4630); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getTASKEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_12, grammarAccess.getObjectTypeAccess().getTASKEnumLiteralDeclaration_12()); 
                          
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2018:1: ruleObjectTypeRef returns [Enumerator current=null] : ( (enumLiteral_0= 'OS_TYPE' ) | (enumLiteral_1= 'ALARM_TYPE' ) | (enumLiteral_2= 'APPMODE_TYPE' ) | (enumLiteral_3= 'COUNTER_TYPE' ) | (enumLiteral_4= 'COM_TYPE' ) | (enumLiteral_5= 'EVENT_TYPE' ) | (enumLiteral_6= 'IPDU_TYPE' ) | (enumLiteral_7= 'ISR_TYPE' ) | (enumLiteral_8= 'MESSAGE_TYPE' ) | (enumLiteral_9= 'NETWORKMESSAGE_TYPE' ) | (enumLiteral_10= 'NM_TYPE' ) | (enumLiteral_11= 'RESOURCE_TYPE' ) | (enumLiteral_12= 'TASK_TYPE' ) ) ;
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

         enterRule(); 
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2020:28: ( ( (enumLiteral_0= 'OS_TYPE' ) | (enumLiteral_1= 'ALARM_TYPE' ) | (enumLiteral_2= 'APPMODE_TYPE' ) | (enumLiteral_3= 'COUNTER_TYPE' ) | (enumLiteral_4= 'COM_TYPE' ) | (enumLiteral_5= 'EVENT_TYPE' ) | (enumLiteral_6= 'IPDU_TYPE' ) | (enumLiteral_7= 'ISR_TYPE' ) | (enumLiteral_8= 'MESSAGE_TYPE' ) | (enumLiteral_9= 'NETWORKMESSAGE_TYPE' ) | (enumLiteral_10= 'NM_TYPE' ) | (enumLiteral_11= 'RESOURCE_TYPE' ) | (enumLiteral_12= 'TASK_TYPE' ) ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2021:1: ( (enumLiteral_0= 'OS_TYPE' ) | (enumLiteral_1= 'ALARM_TYPE' ) | (enumLiteral_2= 'APPMODE_TYPE' ) | (enumLiteral_3= 'COUNTER_TYPE' ) | (enumLiteral_4= 'COM_TYPE' ) | (enumLiteral_5= 'EVENT_TYPE' ) | (enumLiteral_6= 'IPDU_TYPE' ) | (enumLiteral_7= 'ISR_TYPE' ) | (enumLiteral_8= 'MESSAGE_TYPE' ) | (enumLiteral_9= 'NETWORKMESSAGE_TYPE' ) | (enumLiteral_10= 'NM_TYPE' ) | (enumLiteral_11= 'RESOURCE_TYPE' ) | (enumLiteral_12= 'TASK_TYPE' ) )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2021:1: ( (enumLiteral_0= 'OS_TYPE' ) | (enumLiteral_1= 'ALARM_TYPE' ) | (enumLiteral_2= 'APPMODE_TYPE' ) | (enumLiteral_3= 'COUNTER_TYPE' ) | (enumLiteral_4= 'COM_TYPE' ) | (enumLiteral_5= 'EVENT_TYPE' ) | (enumLiteral_6= 'IPDU_TYPE' ) | (enumLiteral_7= 'ISR_TYPE' ) | (enumLiteral_8= 'MESSAGE_TYPE' ) | (enumLiteral_9= 'NETWORKMESSAGE_TYPE' ) | (enumLiteral_10= 'NM_TYPE' ) | (enumLiteral_11= 'RESOURCE_TYPE' ) | (enumLiteral_12= 'TASK_TYPE' ) )
            int alt50=13;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt50=1;
                }
                break;
            case 50:
                {
                alt50=2;
                }
                break;
            case 51:
                {
                alt50=3;
                }
                break;
            case 52:
                {
                alt50=4;
                }
                break;
            case 53:
                {
                alt50=5;
                }
                break;
            case 54:
                {
                alt50=6;
                }
                break;
            case 55:
                {
                alt50=7;
                }
                break;
            case 56:
                {
                alt50=8;
                }
                break;
            case 57:
                {
                alt50=9;
                }
                break;
            case 58:
                {
                alt50=10;
                }
                break;
            case 59:
                {
                alt50=11;
                }
                break;
            case 60:
                {
                alt50=12;
                }
                break;
            case 61:
                {
                alt50=13;
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
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2021:2: (enumLiteral_0= 'OS_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2021:2: (enumLiteral_0= 'OS_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2021:4: enumLiteral_0= 'OS_TYPE'
                    {
                    enumLiteral_0=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleObjectTypeRef4675); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getOSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getObjectTypeRefAccess().getOSEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2027:6: (enumLiteral_1= 'ALARM_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2027:6: (enumLiteral_1= 'ALARM_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2027:8: enumLiteral_1= 'ALARM_TYPE'
                    {
                    enumLiteral_1=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleObjectTypeRef4692); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getALARMEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getObjectTypeRefAccess().getALARMEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2033:6: (enumLiteral_2= 'APPMODE_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2033:6: (enumLiteral_2= 'APPMODE_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2033:8: enumLiteral_2= 'APPMODE_TYPE'
                    {
                    enumLiteral_2=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleObjectTypeRef4709); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getAPPMODEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getObjectTypeRefAccess().getAPPMODEEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2039:6: (enumLiteral_3= 'COUNTER_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2039:6: (enumLiteral_3= 'COUNTER_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2039:8: enumLiteral_3= 'COUNTER_TYPE'
                    {
                    enumLiteral_3=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleObjectTypeRef4726); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getCOUNTEREnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getObjectTypeRefAccess().getCOUNTEREnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2045:6: (enumLiteral_4= 'COM_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2045:6: (enumLiteral_4= 'COM_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2045:8: enumLiteral_4= 'COM_TYPE'
                    {
                    enumLiteral_4=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleObjectTypeRef4743); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getCOMEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getObjectTypeRefAccess().getCOMEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2051:6: (enumLiteral_5= 'EVENT_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2051:6: (enumLiteral_5= 'EVENT_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2051:8: enumLiteral_5= 'EVENT_TYPE'
                    {
                    enumLiteral_5=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleObjectTypeRef4760); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getEVENTEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getObjectTypeRefAccess().getEVENTEnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2057:6: (enumLiteral_6= 'IPDU_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2057:6: (enumLiteral_6= 'IPDU_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2057:8: enumLiteral_6= 'IPDU_TYPE'
                    {
                    enumLiteral_6=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleObjectTypeRef4777); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getIPDUEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_6, grammarAccess.getObjectTypeRefAccess().getIPDUEnumLiteralDeclaration_6()); 
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2063:6: (enumLiteral_7= 'ISR_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2063:6: (enumLiteral_7= 'ISR_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2063:8: enumLiteral_7= 'ISR_TYPE'
                    {
                    enumLiteral_7=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleObjectTypeRef4794); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getISREnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_7, grammarAccess.getObjectTypeRefAccess().getISREnumLiteralDeclaration_7()); 
                          
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2069:6: (enumLiteral_8= 'MESSAGE_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2069:6: (enumLiteral_8= 'MESSAGE_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2069:8: enumLiteral_8= 'MESSAGE_TYPE'
                    {
                    enumLiteral_8=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleObjectTypeRef4811); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getMESSAGEEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_8, grammarAccess.getObjectTypeRefAccess().getMESSAGEEnumLiteralDeclaration_8()); 
                          
                    }

                    }


                    }
                    break;
                case 10 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2075:6: (enumLiteral_9= 'NETWORKMESSAGE_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2075:6: (enumLiteral_9= 'NETWORKMESSAGE_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2075:8: enumLiteral_9= 'NETWORKMESSAGE_TYPE'
                    {
                    enumLiteral_9=(Token)match(input,58,FollowSets000.FOLLOW_58_in_ruleObjectTypeRef4828); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getNETWORKMESSAGEEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_9, grammarAccess.getObjectTypeRefAccess().getNETWORKMESSAGEEnumLiteralDeclaration_9()); 
                          
                    }

                    }


                    }
                    break;
                case 11 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2081:6: (enumLiteral_10= 'NM_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2081:6: (enumLiteral_10= 'NM_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2081:8: enumLiteral_10= 'NM_TYPE'
                    {
                    enumLiteral_10=(Token)match(input,59,FollowSets000.FOLLOW_59_in_ruleObjectTypeRef4845); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getNMEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_10, grammarAccess.getObjectTypeRefAccess().getNMEnumLiteralDeclaration_10()); 
                          
                    }

                    }


                    }
                    break;
                case 12 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2087:6: (enumLiteral_11= 'RESOURCE_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2087:6: (enumLiteral_11= 'RESOURCE_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2087:8: enumLiteral_11= 'RESOURCE_TYPE'
                    {
                    enumLiteral_11=(Token)match(input,60,FollowSets000.FOLLOW_60_in_ruleObjectTypeRef4862); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getRESOURCEEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_11, grammarAccess.getObjectTypeRefAccess().getRESOURCEEnumLiteralDeclaration_11()); 
                          
                    }

                    }


                    }
                    break;
                case 13 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2093:6: (enumLiteral_12= 'TASK_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2093:6: (enumLiteral_12= 'TASK_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2093:8: enumLiteral_12= 'TASK_TYPE'
                    {
                    enumLiteral_12=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleObjectTypeRef4879); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getTASKEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_12, grammarAccess.getObjectTypeRefAccess().getTASKEnumLiteralDeclaration_12()); 
                          
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
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:559:3: ( ( 'AUTO' ) )
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:560:1: ( 'AUTO' )
        {
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:560:1: ( 'AUTO' )
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:561:2: 'AUTO'
        {
        match(input,23,FollowSets000.FOLLOW_23_in_synpred1_InternalOil1135); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred1_InternalOil

    // $ANTLR start synpred2_InternalOil
    public final void synpred2_InternalOil_fragment() throws RecognitionException {   
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:788:3: ( ( 'AUTO' ) )
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:789:1: ( 'AUTO' )
        {
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:789:1: ( 'AUTO' )
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:790:2: 'AUTO'
        {
        match(input,23,FollowSets000.FOLLOW_23_in_synpred2_InternalOil1572); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred2_InternalOil

    // $ANTLR start synpred3_InternalOil
    public final void synpred3_InternalOil_fragment() throws RecognitionException {   
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1044:3: ( ( 'AUTO' ) )
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1045:1: ( 'AUTO' )
        {
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1045:1: ( 'AUTO' )
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1046:2: 'AUTO'
        {
        match(input,23,FollowSets000.FOLLOW_23_in_synpred3_InternalOil2085); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred3_InternalOil

    // $ANTLR start synpred4_InternalOil
    public final void synpred4_InternalOil_fragment() throws RecognitionException {   
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1265:3: ( ( 'AUTO' ) )
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1266:1: ( 'AUTO' )
        {
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1266:1: ( 'AUTO' )
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1267:2: 'AUTO'
        {
        match(input,23,FollowSets000.FOLLOW_23_in_synpred4_InternalOil2536); if (state.failed) return ;

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


    protected DFA39 dfa39 = new DFA39(this);
    static final String DFA39_eotS =
        "\12\uffff";
    static final String DFA39_eofS =
        "\4\uffff\2\6\1\uffff\2\6\1\uffff";
    static final String DFA39_minS =
        "\1\4\1\uffff\3\6\1\17\1\uffff\2\6\1\uffff";
    static final String DFA39_maxS =
        "\1\77\1\uffff\2\10\2\100\1\uffff\2\100\1\uffff";
    static final String DFA39_acceptS =
        "\1\uffff\1\1\4\uffff\1\2\2\uffff\1\3";
    static final String DFA39_specialS =
        "\12\uffff}>";
    static final String[] DFA39_transitionS = {
            "\1\1\1\uffff\1\4\1\5\1\6\65\uffff\1\2\1\3",
            "",
            "\1\4\1\5\1\6",
            "\1\4\1\5\1\6",
            "\1\10\1\7\7\uffff\1\6\1\uffff\1\6\1\uffff\1\6\54\uffff\1\11",
            "\1\6\1\uffff\1\6\1\uffff\1\6\54\uffff\1\11",
            "",
            "\1\10\1\7\7\uffff\1\6\1\uffff\1\6\1\uffff\1\6\54\uffff\1\11",
            "\1\10\1\7\7\uffff\1\6\1\uffff\1\6\1\uffff\1\6\54\uffff\1\11",
            ""
    };

    static final short[] DFA39_eot = DFA.unpackEncodedString(DFA39_eotS);
    static final short[] DFA39_eof = DFA.unpackEncodedString(DFA39_eofS);
    static final char[] DFA39_min = DFA.unpackEncodedStringToUnsignedChars(DFA39_minS);
    static final char[] DFA39_max = DFA.unpackEncodedStringToUnsignedChars(DFA39_maxS);
    static final short[] DFA39_accept = DFA.unpackEncodedString(DFA39_acceptS);
    static final short[] DFA39_special = DFA.unpackEncodedString(DFA39_specialS);
    static final short[][] DFA39_transition;

    static {
        int numStates = DFA39_transitionS.length;
        DFA39_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA39_transition[i] = DFA.unpackEncodedString(DFA39_transitionS[i]);
        }
    }

    class DFA39 extends DFA {

        public DFA39(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 39;
            this.eot = DFA39_eot;
            this.eof = DFA39_eof;
            this.min = DFA39_min;
            this.max = DFA39_max;
            this.accept = DFA39_accept;
            this.special = DFA39_special;
            this.transition = DFA39_transition;
        }
        public String getDescription() {
            return "1667:1: (this_STRING_0= RULE_STRING | this_INT_1= ruleINT | this_DOUBLE_2= ruleDOUBLE )";
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
        public static final BitSet FOLLOW_17_in_ruleOilImplementation341 = new BitSet(new long[]{0x0001FFF000040000L});
        public static final BitSet FOLLOW_ruleOilObjectImpl_in_ruleOilImplementation362 = new BitSet(new long[]{0x0001FFF000040000L});
        public static final BitSet FOLLOW_18_in_ruleOilImplementation375 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleOilImplementation387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilObjectImpl_in_entryRuleOilObjectImpl423 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOilObjectImpl433 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectType_in_ruleOilObjectImpl479 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleOilObjectImpl491 = new BitSet(new long[]{0x3FFE000FF8040000L});
        public static final BitSet FOLLOW_ruleParameterType_in_ruleOilObjectImpl512 = new BitSet(new long[]{0x3FFE000FF8040000L});
        public static final BitSet FOLLOW_18_in_ruleOilObjectImpl525 = new BitSet(new long[]{0x0000000000088000L});
        public static final BitSet FOLLOW_19_in_ruleOilObjectImpl538 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleOilObjectImpl555 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleOilObjectImpl574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilApplication_in_entryRuleOilApplication610 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOilApplication620 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleOilApplication657 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOilApplication674 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleOilApplication691 = new BitSet(new long[]{0x0001FFF000040000L});
        public static final BitSet FOLLOW_ruleOilObject_in_ruleOilApplication712 = new BitSet(new long[]{0x0001FFF000040000L});
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
        public static final BitSet FOLLOW_ruleVType_in_ruleValueType1021 = new BitSet(new long[]{0x3FFFFFFFF8200020L});
        public static final BitSet FOLLOW_21_in_ruleValueType1039 = new BitSet(new long[]{0x3FFFFFFFF8200020L});
        public static final BitSet FOLLOW_ruleSpecialId_in_ruleValueType1074 = new BitSet(new long[]{0x000000000048C000L});
        public static final BitSet FOLLOW_22_in_ruleValueType1092 = new BitSet(new long[]{0x000000000008C000L});
        public static final BitSet FOLLOW_14_in_ruleValueType1119 = new BitSet(new long[]{0xC0000000008001F0L});
        public static final BitSet FOLLOW_23_in_ruleValueType1153 = new BitSet(new long[]{0x0000000000088000L});
        public static final BitSet FOLLOW_ruleGenericValue_in_ruleValueType1195 = new BitSet(new long[]{0x0000000000088000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleValueType1210 = new BitSet(new long[]{0x0000000000088000L});
        public static final BitSet FOLLOW_19_in_ruleValueType1234 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleValueType1251 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleValueType1270 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariantType_in_entryRuleVariantType1306 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVariantType1316 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEType_in_ruleVariantType1371 = new BitSet(new long[]{0x3FFFFFFFF9200020L});
        public static final BitSet FOLLOW_21_in_ruleVariantType1389 = new BitSet(new long[]{0x3FFFFFFFF9200020L});
        public static final BitSet FOLLOW_24_in_ruleVariantType1416 = new BitSet(new long[]{0x3FFFFFFFFC200020L});
        public static final BitSet FOLLOW_ruleEnumeratorType_in_ruleVariantType1438 = new BitSet(new long[]{0x0000000006000000L});
        public static final BitSet FOLLOW_25_in_ruleVariantType1451 = new BitSet(new long[]{0x3FFFFFFFF8200020L});
        public static final BitSet FOLLOW_ruleEnumeratorType_in_ruleVariantType1472 = new BitSet(new long[]{0x0000000006000000L});
        public static final BitSet FOLLOW_26_in_ruleVariantType1488 = new BitSet(new long[]{0x3FFFFFFFF8200020L});
        public static final BitSet FOLLOW_ruleSpecialId_in_ruleVariantType1511 = new BitSet(new long[]{0x000000000048C000L});
        public static final BitSet FOLLOW_22_in_ruleVariantType1529 = new BitSet(new long[]{0x000000000008C000L});
        public static final BitSet FOLLOW_14_in_ruleVariantType1556 = new BitSet(new long[]{0x0000000000800020L});
        public static final BitSet FOLLOW_23_in_ruleVariantType1590 = new BitSet(new long[]{0x0000000000088000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleVariantType1626 = new BitSet(new long[]{0x0000000000088000L});
        public static final BitSet FOLLOW_19_in_ruleVariantType1647 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleVariantType1664 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleVariantType1683 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumeratorType_in_entryRuleEnumeratorType1719 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumeratorType1729 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecialId_in_ruleEnumeratorType1784 = new BitSet(new long[]{0x00000000000A0002L});
        public static final BitSet FOLLOW_17_in_ruleEnumeratorType1797 = new BitSet(new long[]{0x3FFE000FF8040000L});
        public static final BitSet FOLLOW_ruleParameterType_in_ruleEnumeratorType1818 = new BitSet(new long[]{0x3FFE000FF8040000L});
        public static final BitSet FOLLOW_18_in_ruleEnumeratorType1831 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleEnumeratorType1846 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEnumeratorType1863 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceType_in_entryRuleReferenceType1906 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceType1916 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectTypeRef_in_ruleReferenceType1971 = new BitSet(new long[]{0x3FFFFFFFF8200020L});
        public static final BitSet FOLLOW_21_in_ruleReferenceType1989 = new BitSet(new long[]{0x3FFFFFFFF8200020L});
        public static final BitSet FOLLOW_ruleSpecialId_in_ruleReferenceType2024 = new BitSet(new long[]{0x000000000048C000L});
        public static final BitSet FOLLOW_22_in_ruleReferenceType2042 = new BitSet(new long[]{0x000000000008C000L});
        public static final BitSet FOLLOW_14_in_ruleReferenceType2069 = new BitSet(new long[]{0x0000000000800020L});
        public static final BitSet FOLLOW_23_in_ruleReferenceType2103 = new BitSet(new long[]{0x0000000000088000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceType2139 = new BitSet(new long[]{0x0000000000088000L});
        public static final BitSet FOLLOW_19_in_ruleReferenceType2160 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleReferenceType2177 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleReferenceType2196 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilObject_in_entryRuleOilObject2232 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOilObject2242 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectType_in_ruleOilObject2288 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOilObject2305 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleOilObject2322 = new BitSet(new long[]{0x3FFFFFFFF8240020L});
        public static final BitSet FOLLOW_ruleParameter_in_ruleOilObject2343 = new BitSet(new long[]{0x3FFFFFFFF8240020L});
        public static final BitSet FOLLOW_18_in_ruleOilObject2356 = new BitSet(new long[]{0x0000000000088000L});
        public static final BitSet FOLLOW_19_in_ruleOilObject2369 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleOilObject2386 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleOilObject2405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter2441 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParameter2451 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecialId_in_ruleParameter2508 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleParameter2520 = new BitSet(new long[]{0xFFFFFFFFF8A001F0L});
        public static final BitSet FOLLOW_23_in_ruleParameter2554 = new BitSet(new long[]{0x00000000000A8000L});
        public static final BitSet FOLLOW_ruleGenericValue_in_ruleParameter2594 = new BitSet(new long[]{0x00000000000A8000L});
        public static final BitSet FOLLOW_ruleSpecialId_in_ruleParameter2623 = new BitSet(new long[]{0x00000000000A8000L});
        public static final BitSet FOLLOW_17_in_ruleParameter2637 = new BitSet(new long[]{0x3FFFFFFFF8240020L});
        public static final BitSet FOLLOW_ruleParameter_in_ruleParameter2658 = new BitSet(new long[]{0x3FFFFFFFF8240020L});
        public static final BitSet FOLLOW_18_in_ruleParameter2671 = new BitSet(new long[]{0x0000000000088000L});
        public static final BitSet FOLLOW_19_in_ruleParameter2686 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleParameter2703 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleParameter2722 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecialId_in_entryRuleSpecialId2759 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpecialId2770 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSpecialId2810 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleSpecialId2834 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleSpecialId2853 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleSpecialId2872 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleSpecialId2891 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleSpecialId2910 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleSpecialId2929 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleSpecialId2948 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleSpecialId2967 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleSpecialId2986 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleSpecialId3005 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleSpecialId3024 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleSpecialId3043 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleSpecialId3062 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleSpecialId3081 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleSpecialId3100 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleSpecialId3119 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleSpecialId3138 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleSpecialId3157 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleSpecialId3176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_ruleSpecialId3195 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_ruleSpecialId3214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_ruleSpecialId3233 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_ruleSpecialId3252 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleSpecialId3271 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_ruleSpecialId3290 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_ruleSpecialId3309 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_ruleSpecialId3328 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_ruleSpecialId3347 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_ruleSpecialId3366 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_ruleSpecialId3385 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_ruleSpecialId3404 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_ruleSpecialId3423 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_59_in_ruleSpecialId3442 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_ruleSpecialId3461 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_ruleSpecialId3480 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGenericValue_in_entryRuleGenericValue3521 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGenericValue3532 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleGenericValue3572 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleINT_in_ruleGenericValue3605 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDOUBLE_in_ruleGenericValue3638 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleINT_in_entryRuleINT3684 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleINT3695 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_ruleINT3734 = new BitSet(new long[]{0x00000000000001C0L});
        public static final BitSet FOLLOW_63_in_ruleINT3753 = new BitSet(new long[]{0x00000000000001C0L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_ruleINT3772 = new BitSet(new long[]{0x00000000000000C2L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_ruleINT3793 = new BitSet(new long[]{0x00000000000000C2L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_ruleINT3819 = new BitSet(new long[]{0x00000000000000C2L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_ruleINT3848 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_HEX_in_ruleINT3874 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDOUBLE_in_entryRuleDOUBLE3921 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDOUBLE3932 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_ruleDOUBLE3971 = new BitSet(new long[]{0x00000000000000C0L});
        public static final BitSet FOLLOW_63_in_ruleDOUBLE3990 = new BitSet(new long[]{0x00000000000000C0L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_ruleDOUBLE4008 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_ruleDOUBLE4035 = new BitSet(new long[]{0x00000000000000C0L,0x0000000000000001L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_ruleDOUBLE4056 = new BitSet(new long[]{0x00000000000000C0L,0x0000000000000001L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_ruleDOUBLE4082 = new BitSet(new long[]{0x00000000000000C0L,0x0000000000000001L});
        public static final BitSet FOLLOW_64_in_ruleDOUBLE4113 = new BitSet(new long[]{0x00000000000000C0L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_ruleDOUBLE4130 = new BitSet(new long[]{0x00000000000000C2L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_ruleDOUBLE4156 = new BitSet(new long[]{0x00000000000000C2L});
        public static final BitSet FOLLOW_27_in_ruleVType4217 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleVType4234 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleVType4251 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleVType4268 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleVType4285 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleVType4302 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleVType4319 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleEType4364 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleEType4381 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleObjectType4426 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleObjectType4443 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleObjectType4460 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleObjectType4477 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleObjectType4494 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleObjectType4511 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleObjectType4528 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleObjectType4545 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleObjectType4562 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleObjectType4579 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_ruleObjectType4596 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_ruleObjectType4613 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_ruleObjectType4630 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_ruleObjectTypeRef4675 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleObjectTypeRef4692 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_ruleObjectTypeRef4709 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_ruleObjectTypeRef4726 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_ruleObjectTypeRef4743 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_ruleObjectTypeRef4760 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_ruleObjectTypeRef4777 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_ruleObjectTypeRef4794 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_ruleObjectTypeRef4811 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_ruleObjectTypeRef4828 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_59_in_ruleObjectTypeRef4845 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_ruleObjectTypeRef4862 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_ruleObjectTypeRef4879 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_synpred1_InternalOil1135 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_synpred2_InternalOil1572 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_synpred3_InternalOil2085 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_synpred4_InternalOil2536 = new BitSet(new long[]{0x0000000000000002L});
    }


}