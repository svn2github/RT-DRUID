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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_NON_ZERO_INT", "RULE_ZERO_INT", "RULE_HEX", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_INCLUDE", "RULE_WS", "RULE_ANY_OTHER", "'OIL_VERSION'", "'='", "';'", "'IMPLEMENTATION'", "'{'", "'}'", "':'", "'CPU'", "','", "'..'", "'WITH_AUTO'", "'['", "']'", "'[]'", "'AUTO'", "'STRING'", "'UINT32'", "'INT32'", "'UINT64'", "'INT64'", "'FLOAT'", "'BOOLEAN'", "'ENUM'", "'OS'", "'ALARM'", "'APPMODE'", "'COUNTER'", "'COM'", "'EVENT'", "'IPDU'", "'ISR'", "'MESSAGE'", "'NETWORKMESSAGE'", "'NM'", "'RESOURCE'", "'TASK'", "'SPINLOCK'", "'SCHEDULETABLE'", "'OS_TYPE'", "'ALARM_TYPE'", "'APPMODE_TYPE'", "'COUNTER_TYPE'", "'COM_TYPE'", "'EVENT_TYPE'", "'IPDU_TYPE'", "'ISR_TYPE'", "'MESSAGE_TYPE'", "'NETWORKMESSAGE_TYPE'", "'NM_TYPE'", "'RESOURCE_TYPE'", "'TASK_TYPE'", "'SPINLOCK_TYPE'", "'SCHEDULETABLE_TYPE'", "'+'", "'-'", "'.'", "'APPLICATION'", "'APPLICATION_TYPE'"
    };
    public static final int T__68=68;
    public static final int T__69=69;
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
    public static final int RULE_ANY_OTHER=13;
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
    public static final int T__71=71;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__70=70;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_INCLUDE=11;
    public static final int RULE_WS=12;

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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:77:1: ruleOilFile returns [EObject current=null] : ( () (otherlv_1= 'OIL_VERSION' otherlv_2= '=' ( (lv_oilVersion_3_0= RULE_STRING ) ) otherlv_4= ';' )? ( (lv_Implementation_5_0= ruleOilImplementation ) )? ( (lv_Application_6_0= ruleOilApplication ) )? ) ;
    public final EObject ruleOilFile() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_oilVersion_3_0=null;
        Token otherlv_4=null;
        EObject lv_Implementation_5_0 = null;

        EObject lv_Application_6_0 = null;


         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:80:28: ( ( () (otherlv_1= 'OIL_VERSION' otherlv_2= '=' ( (lv_oilVersion_3_0= RULE_STRING ) ) otherlv_4= ';' )? ( (lv_Implementation_5_0= ruleOilImplementation ) )? ( (lv_Application_6_0= ruleOilApplication ) )? ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:81:1: ( () (otherlv_1= 'OIL_VERSION' otherlv_2= '=' ( (lv_oilVersion_3_0= RULE_STRING ) ) otherlv_4= ';' )? ( (lv_Implementation_5_0= ruleOilImplementation ) )? ( (lv_Application_6_0= ruleOilApplication ) )? )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:81:1: ( () (otherlv_1= 'OIL_VERSION' otherlv_2= '=' ( (lv_oilVersion_3_0= RULE_STRING ) ) otherlv_4= ';' )? ( (lv_Implementation_5_0= ruleOilImplementation ) )? ( (lv_Application_6_0= ruleOilApplication ) )? )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:81:2: () (otherlv_1= 'OIL_VERSION' otherlv_2= '=' ( (lv_oilVersion_3_0= RULE_STRING ) ) otherlv_4= ';' )? ( (lv_Implementation_5_0= ruleOilImplementation ) )? ( (lv_Application_6_0= ruleOilApplication ) )?
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

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:87:2: (otherlv_1= 'OIL_VERSION' otherlv_2= '=' ( (lv_oilVersion_3_0= RULE_STRING ) ) otherlv_4= ';' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==14) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:87:4: otherlv_1= 'OIL_VERSION' otherlv_2= '=' ( (lv_oilVersion_3_0= RULE_STRING ) ) otherlv_4= ';'
                    {
                    otherlv_1=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleOilFile132); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getOilFileAccess().getOIL_VERSIONKeyword_1_0());
                          
                    }
                    otherlv_2=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleOilFile144); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getOilFileAccess().getEqualsSignKeyword_1_1());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:95:1: ( (lv_oilVersion_3_0= RULE_STRING ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:96:1: (lv_oilVersion_3_0= RULE_STRING )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:96:1: (lv_oilVersion_3_0= RULE_STRING )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:97:3: lv_oilVersion_3_0= RULE_STRING
                    {
                    lv_oilVersion_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleOilFile161); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_oilVersion_3_0, grammarAccess.getOilFileAccess().getOilVersionSTRINGTerminalRuleCall_1_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getOilFileRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"oilVersion",
                              		lv_oilVersion_3_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleOilFile178); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getOilFileAccess().getSemicolonKeyword_1_3());
                          
                    }

                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:117:3: ( (lv_Implementation_5_0= ruleOilImplementation ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==17) ) {
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

            if ( (LA3_0==21) ) {
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:170:1: ruleOilImplementation returns [EObject current=null] : (otherlv_0= 'IMPLEMENTATION' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_OilObjects_3_0= ruleOilObjectImpl ) )* otherlv_4= '}' otherlv_5= ';' ) ;
    public final EObject ruleOilImplementation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_OilObjects_3_0 = null;


         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:173:28: ( (otherlv_0= 'IMPLEMENTATION' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_OilObjects_3_0= ruleOilObjectImpl ) )* otherlv_4= '}' otherlv_5= ';' ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:174:1: (otherlv_0= 'IMPLEMENTATION' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_OilObjects_3_0= ruleOilObjectImpl ) )* otherlv_4= '}' otherlv_5= ';' )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:174:1: (otherlv_0= 'IMPLEMENTATION' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_OilObjects_3_0= ruleOilObjectImpl ) )* otherlv_4= '}' otherlv_5= ';' )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:174:3: otherlv_0= 'IMPLEMENTATION' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_OilObjects_3_0= ruleOilObjectImpl ) )* otherlv_4= '}' otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleOilImplementation307); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getOilImplementationAccess().getIMPLEMENTATIONKeyword_0());
                  
            }
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:178:1: ( (lv_name_1_0= RULE_ID ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:179:1: (lv_name_1_0= RULE_ID )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:179:1: (lv_name_1_0= RULE_ID )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:180:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOilImplementation324); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getOilImplementationAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getOilImplementationRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleOilImplementation341); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getOilImplementationAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:200:1: ( (lv_OilObjects_3_0= ruleOilObjectImpl ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=37 && LA4_0<=51)||LA4_0==70) ) {
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

            otherlv_4=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleOilImplementation375); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getOilImplementationAccess().getRightCurlyBracketKeyword_4());
                  
            }
            otherlv_5=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleOilImplementation387); if (state.failed) return current;
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:243:1: ruleOilObjectImpl returns [EObject current=null] : ( ( (lv_type_0_0= ruleObjectType ) ) otherlv_1= '{' ( (lv_Parameters_2_0= ruleParameterType ) )* otherlv_3= '}' (otherlv_4= ':' ( (lv_description_5_0= RULE_STRING ) ) )? otherlv_6= ';' ) ;
    public final EObject ruleOilObjectImpl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_description_5_0=null;
        Token otherlv_6=null;
        Enumerator lv_type_0_0 = null;

        EObject lv_Parameters_2_0 = null;


         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:246:28: ( ( ( (lv_type_0_0= ruleObjectType ) ) otherlv_1= '{' ( (lv_Parameters_2_0= ruleParameterType ) )* otherlv_3= '}' (otherlv_4= ':' ( (lv_description_5_0= RULE_STRING ) ) )? otherlv_6= ';' ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:247:1: ( ( (lv_type_0_0= ruleObjectType ) ) otherlv_1= '{' ( (lv_Parameters_2_0= ruleParameterType ) )* otherlv_3= '}' (otherlv_4= ':' ( (lv_description_5_0= RULE_STRING ) ) )? otherlv_6= ';' )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:247:1: ( ( (lv_type_0_0= ruleObjectType ) ) otherlv_1= '{' ( (lv_Parameters_2_0= ruleParameterType ) )* otherlv_3= '}' (otherlv_4= ':' ( (lv_description_5_0= RULE_STRING ) ) )? otherlv_6= ';' )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:247:2: ( (lv_type_0_0= ruleObjectType ) ) otherlv_1= '{' ( (lv_Parameters_2_0= ruleParameterType ) )* otherlv_3= '}' (otherlv_4= ':' ( (lv_description_5_0= RULE_STRING ) ) )? otherlv_6= ';'
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:247:2: ( (lv_type_0_0= ruleObjectType ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:248:1: (lv_type_0_0= ruleObjectType )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:248:1: (lv_type_0_0= ruleObjectType )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:249:3: lv_type_0_0= ruleObjectType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOilObjectImplAccess().getTypeObjectTypeEnumRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleObjectType_in_ruleOilObjectImpl479);
            lv_type_0_0=ruleObjectType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getOilObjectImplRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_0_0, 
                      		"ObjectType");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleOilObjectImpl491); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getOilObjectImplAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:269:1: ( (lv_Parameters_2_0= ruleParameterType ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=29 && LA5_0<=36)||(LA5_0>=52 && LA5_0<=66)||LA5_0==71) ) {
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

            otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleOilObjectImpl525); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getOilObjectImplAccess().getRightCurlyBracketKeyword_3());
                  
            }
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:291:1: (otherlv_4= ':' ( (lv_description_5_0= RULE_STRING ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==20) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:291:3: otherlv_4= ':' ( (lv_description_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleOilObjectImpl538); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getOilObjectImplAccess().getColonKeyword_4_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:295:1: ( (lv_description_5_0= RULE_STRING ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:296:1: (lv_description_5_0= RULE_STRING )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:296:1: (lv_description_5_0= RULE_STRING )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:297:3: lv_description_5_0= RULE_STRING
                    {
                    lv_description_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleOilObjectImpl555); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_description_5_0, grammarAccess.getOilObjectImplAccess().getDescriptionSTRINGTerminalRuleCall_4_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getOilObjectImplRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"description",
                              		lv_description_5_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleOilObjectImpl574); if (state.failed) return current;
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:334:1: ruleOilApplication returns [EObject current=null] : (otherlv_0= 'CPU' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_OilObjects_3_0= ruleOilObject ) )* otherlv_4= '}' (otherlv_5= ':' ( (lv_description_6_0= RULE_STRING ) ) )? otherlv_7= ';' ) ;
    public final EObject ruleOilApplication() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_description_6_0=null;
        Token otherlv_7=null;
        EObject lv_OilObjects_3_0 = null;


         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:337:28: ( (otherlv_0= 'CPU' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_OilObjects_3_0= ruleOilObject ) )* otherlv_4= '}' (otherlv_5= ':' ( (lv_description_6_0= RULE_STRING ) ) )? otherlv_7= ';' ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:338:1: (otherlv_0= 'CPU' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_OilObjects_3_0= ruleOilObject ) )* otherlv_4= '}' (otherlv_5= ':' ( (lv_description_6_0= RULE_STRING ) ) )? otherlv_7= ';' )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:338:1: (otherlv_0= 'CPU' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_OilObjects_3_0= ruleOilObject ) )* otherlv_4= '}' (otherlv_5= ':' ( (lv_description_6_0= RULE_STRING ) ) )? otherlv_7= ';' )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:338:3: otherlv_0= 'CPU' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_OilObjects_3_0= ruleOilObject ) )* otherlv_4= '}' (otherlv_5= ':' ( (lv_description_6_0= RULE_STRING ) ) )? otherlv_7= ';'
            {
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleOilApplication657); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getOilApplicationAccess().getCPUKeyword_0());
                  
            }
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:342:1: ( (lv_name_1_0= RULE_ID ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:343:1: (lv_name_1_0= RULE_ID )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:343:1: (lv_name_1_0= RULE_ID )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:344:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOilApplication674); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getOilApplicationAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getOilApplicationRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleOilApplication691); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getOilApplicationAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:364:1: ( (lv_OilObjects_3_0= ruleOilObject ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=37 && LA7_0<=51)||LA7_0==70) ) {
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

            otherlv_4=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleOilApplication725); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getOilApplicationAccess().getRightCurlyBracketKeyword_4());
                  
            }
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:386:1: (otherlv_5= ':' ( (lv_description_6_0= RULE_STRING ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==20) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:386:3: otherlv_5= ':' ( (lv_description_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleOilApplication738); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getOilApplicationAccess().getColonKeyword_5_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:390:1: ( (lv_description_6_0= RULE_STRING ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:391:1: (lv_description_6_0= RULE_STRING )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:391:1: (lv_description_6_0= RULE_STRING )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:392:3: lv_description_6_0= RULE_STRING
                    {
                    lv_description_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleOilApplication755); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_description_6_0, grammarAccess.getOilApplicationAccess().getDescriptionSTRINGTerminalRuleCall_5_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getOilApplicationRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"description",
                              		lv_description_6_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleOilApplication774); if (state.failed) return current;
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
            case 63:
            case 64:
            case 65:
            case 66:
            case 71:
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


    // $ANTLR start "entryRuleValidValues"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:470:1: entryRuleValidValues returns [EObject current=null] : iv_ruleValidValues= ruleValidValues EOF ;
    public final EObject entryRuleValidValues() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValidValues = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:471:2: (iv_ruleValidValues= ruleValidValues EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:472:2: iv_ruleValidValues= ruleValidValues EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValidValuesRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleValidValues_in_entryRuleValidValues956);
            iv_ruleValidValues=ruleValidValues();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValidValues; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleValidValues966); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValidValues"


    // $ANTLR start "ruleValidValues"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:479:1: ruleValidValues returns [EObject current=null] : (this_Range_0= ruleRange | this_ValueList_1= ruleValueList ) ;
    public final EObject ruleValidValues() throws RecognitionException {
        EObject current = null;

        EObject this_Range_0 = null;

        EObject this_ValueList_1 = null;


         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:482:28: ( (this_Range_0= ruleRange | this_ValueList_1= ruleValueList ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:483:1: (this_Range_0= ruleRange | this_ValueList_1= ruleValueList )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:483:1: (this_Range_0= ruleRange | this_ValueList_1= ruleValueList )
            int alt10=2;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:484:5: this_Range_0= ruleRange
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getValidValuesAccess().getRangeParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleRange_in_ruleValidValues1013);
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
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:494:5: this_ValueList_1= ruleValueList
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getValidValuesAccess().getValueListParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleValueList_in_ruleValidValues1040);
                    this_ValueList_1=ruleValueList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ValueList_1; 
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
    // $ANTLR end "ruleValidValues"


    // $ANTLR start "entryRuleValueList"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:510:1: entryRuleValueList returns [EObject current=null] : iv_ruleValueList= ruleValueList EOF ;
    public final EObject entryRuleValueList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueList = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:511:2: (iv_ruleValueList= ruleValueList EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:512:2: iv_ruleValueList= ruleValueList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueListRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleValueList_in_entryRuleValueList1075);
            iv_ruleValueList=ruleValueList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValueList; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleValueList1085); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValueList"


    // $ANTLR start "ruleValueList"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:519:1: ruleValueList returns [EObject current=null] : ( () ( (lv_values_1_0= ruleGenericNumber ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleGenericNumber ) ) )* ) ;
    public final EObject ruleValueList() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_values_1_0 = null;

        AntlrDatatypeRuleToken lv_values_3_0 = null;


         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:522:28: ( ( () ( (lv_values_1_0= ruleGenericNumber ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleGenericNumber ) ) )* ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:523:1: ( () ( (lv_values_1_0= ruleGenericNumber ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleGenericNumber ) ) )* )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:523:1: ( () ( (lv_values_1_0= ruleGenericNumber ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleGenericNumber ) ) )* )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:523:2: () ( (lv_values_1_0= ruleGenericNumber ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleGenericNumber ) ) )*
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:523:2: ()
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:524:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getValueListAccess().getValueListAction_0(),
                          current);
                  
            }

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:529:2: ( (lv_values_1_0= ruleGenericNumber ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:530:1: (lv_values_1_0= ruleGenericNumber )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:530:1: (lv_values_1_0= ruleGenericNumber )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:531:3: lv_values_1_0= ruleGenericNumber
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getValueListAccess().getValuesGenericNumberParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleGenericNumber_in_ruleValueList1140);
            lv_values_1_0=ruleGenericNumber();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getValueListRule());
              	        }
                     		add(
                     			current, 
                     			"values",
                      		lv_values_1_0, 
                      		"GenericNumber");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:547:2: (otherlv_2= ',' ( (lv_values_3_0= ruleGenericNumber ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==22) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:547:4: otherlv_2= ',' ( (lv_values_3_0= ruleGenericNumber ) )
            	    {
            	    otherlv_2=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleValueList1153); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getValueListAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:551:1: ( (lv_values_3_0= ruleGenericNumber ) )
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:552:1: (lv_values_3_0= ruleGenericNumber )
            	    {
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:552:1: (lv_values_3_0= ruleGenericNumber )
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:553:3: lv_values_3_0= ruleGenericNumber
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getValueListAccess().getValuesGenericNumberParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleGenericNumber_in_ruleValueList1174);
            	    lv_values_3_0=ruleGenericNumber();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getValueListRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"values",
            	              		lv_values_3_0, 
            	              		"GenericNumber");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
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
    // $ANTLR end "ruleValueList"


    // $ANTLR start "entryRuleRange"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:577:1: entryRuleRange returns [EObject current=null] : iv_ruleRange= ruleRange EOF ;
    public final EObject entryRuleRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRange = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:578:2: (iv_ruleRange= ruleRange EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:579:2: iv_ruleRange= ruleRange EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRangeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleRange_in_entryRuleRange1212);
            iv_ruleRange=ruleRange();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRange; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRange1222); if (state.failed) return current;

            }

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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:586:1: ruleRange returns [EObject current=null] : ( () ( (lv_min_1_0= ruleGenericNumber ) ) otherlv_2= '..' ( (lv_max_3_0= ruleGenericNumber ) ) ) ;
    public final EObject ruleRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_min_1_0 = null;

        AntlrDatatypeRuleToken lv_max_3_0 = null;


         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:589:28: ( ( () ( (lv_min_1_0= ruleGenericNumber ) ) otherlv_2= '..' ( (lv_max_3_0= ruleGenericNumber ) ) ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:590:1: ( () ( (lv_min_1_0= ruleGenericNumber ) ) otherlv_2= '..' ( (lv_max_3_0= ruleGenericNumber ) ) )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:590:1: ( () ( (lv_min_1_0= ruleGenericNumber ) ) otherlv_2= '..' ( (lv_max_3_0= ruleGenericNumber ) ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:590:2: () ( (lv_min_1_0= ruleGenericNumber ) ) otherlv_2= '..' ( (lv_max_3_0= ruleGenericNumber ) )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:590:2: ()
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:591:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getRangeAccess().getRangeAction_0(),
                          current);
                  
            }

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:596:2: ( (lv_min_1_0= ruleGenericNumber ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:597:1: (lv_min_1_0= ruleGenericNumber )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:597:1: (lv_min_1_0= ruleGenericNumber )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:598:3: lv_min_1_0= ruleGenericNumber
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRangeAccess().getMinGenericNumberParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleGenericNumber_in_ruleRange1277);
            lv_min_1_0=ruleGenericNumber();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRangeRule());
              	        }
                     		set(
                     			current, 
                     			"min",
                      		lv_min_1_0, 
                      		"GenericNumber");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleRange1289); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getRangeAccess().getFullStopFullStopKeyword_2());
                  
            }
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:618:1: ( (lv_max_3_0= ruleGenericNumber ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:619:1: (lv_max_3_0= ruleGenericNumber )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:619:1: (lv_max_3_0= ruleGenericNumber )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:620:3: lv_max_3_0= ruleGenericNumber
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRangeAccess().getMaxGenericNumberParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleGenericNumber_in_ruleRange1310);
            lv_max_3_0=ruleGenericNumber();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRangeRule());
              	        }
                     		set(
                     			current, 
                     			"max",
                      		lv_max_3_0, 
                      		"GenericNumber");
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
    // $ANTLR end "ruleRange"


    // $ANTLR start "entryRuleValueType"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:644:1: entryRuleValueType returns [EObject current=null] : iv_ruleValueType= ruleValueType EOF ;
    public final EObject entryRuleValueType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueType = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:645:2: (iv_ruleValueType= ruleValueType EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:646:2: iv_ruleValueType= ruleValueType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleValueType_in_entryRuleValueType1346);
            iv_ruleValueType=ruleValueType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValueType; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleValueType1356); if (state.failed) return current;

            }

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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:653:1: ruleValueType returns [EObject current=null] : ( () ( (lv_type_1_0= ruleVType ) ) ( (lv_withAuto_2_0= 'WITH_AUTO' ) )? (otherlv_3= '[' ( (lv_ValidValues_4_0= ruleValidValues ) ) otherlv_5= ']' )? ( (lv_name_6_0= ruleSpecialId ) ) ( (lv_multiValue_7_0= '[]' ) )? (otherlv_8= '=' ( ( ( ( 'AUTO' ) )=> (lv_defaultAuto_9_0= 'AUTO' ) ) | ( ( (lv_defaultValue_10_1= ruleGenericValue | lv_defaultValue_10_2= RULE_ID ) ) ) ) )? (otherlv_11= ':' ( (lv_description_12_0= RULE_STRING ) ) )? otherlv_13= ';' ) ;
    public final EObject ruleValueType() throws RecognitionException {
        EObject current = null;

        Token lv_withAuto_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_multiValue_7_0=null;
        Token otherlv_8=null;
        Token lv_defaultAuto_9_0=null;
        Token lv_defaultValue_10_2=null;
        Token otherlv_11=null;
        Token lv_description_12_0=null;
        Token otherlv_13=null;
        Enumerator lv_type_1_0 = null;

        EObject lv_ValidValues_4_0 = null;

        AntlrDatatypeRuleToken lv_name_6_0 = null;

        AntlrDatatypeRuleToken lv_defaultValue_10_1 = null;


         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:656:28: ( ( () ( (lv_type_1_0= ruleVType ) ) ( (lv_withAuto_2_0= 'WITH_AUTO' ) )? (otherlv_3= '[' ( (lv_ValidValues_4_0= ruleValidValues ) ) otherlv_5= ']' )? ( (lv_name_6_0= ruleSpecialId ) ) ( (lv_multiValue_7_0= '[]' ) )? (otherlv_8= '=' ( ( ( ( 'AUTO' ) )=> (lv_defaultAuto_9_0= 'AUTO' ) ) | ( ( (lv_defaultValue_10_1= ruleGenericValue | lv_defaultValue_10_2= RULE_ID ) ) ) ) )? (otherlv_11= ':' ( (lv_description_12_0= RULE_STRING ) ) )? otherlv_13= ';' ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:657:1: ( () ( (lv_type_1_0= ruleVType ) ) ( (lv_withAuto_2_0= 'WITH_AUTO' ) )? (otherlv_3= '[' ( (lv_ValidValues_4_0= ruleValidValues ) ) otherlv_5= ']' )? ( (lv_name_6_0= ruleSpecialId ) ) ( (lv_multiValue_7_0= '[]' ) )? (otherlv_8= '=' ( ( ( ( 'AUTO' ) )=> (lv_defaultAuto_9_0= 'AUTO' ) ) | ( ( (lv_defaultValue_10_1= ruleGenericValue | lv_defaultValue_10_2= RULE_ID ) ) ) ) )? (otherlv_11= ':' ( (lv_description_12_0= RULE_STRING ) ) )? otherlv_13= ';' )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:657:1: ( () ( (lv_type_1_0= ruleVType ) ) ( (lv_withAuto_2_0= 'WITH_AUTO' ) )? (otherlv_3= '[' ( (lv_ValidValues_4_0= ruleValidValues ) ) otherlv_5= ']' )? ( (lv_name_6_0= ruleSpecialId ) ) ( (lv_multiValue_7_0= '[]' ) )? (otherlv_8= '=' ( ( ( ( 'AUTO' ) )=> (lv_defaultAuto_9_0= 'AUTO' ) ) | ( ( (lv_defaultValue_10_1= ruleGenericValue | lv_defaultValue_10_2= RULE_ID ) ) ) ) )? (otherlv_11= ':' ( (lv_description_12_0= RULE_STRING ) ) )? otherlv_13= ';' )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:657:2: () ( (lv_type_1_0= ruleVType ) ) ( (lv_withAuto_2_0= 'WITH_AUTO' ) )? (otherlv_3= '[' ( (lv_ValidValues_4_0= ruleValidValues ) ) otherlv_5= ']' )? ( (lv_name_6_0= ruleSpecialId ) ) ( (lv_multiValue_7_0= '[]' ) )? (otherlv_8= '=' ( ( ( ( 'AUTO' ) )=> (lv_defaultAuto_9_0= 'AUTO' ) ) | ( ( (lv_defaultValue_10_1= ruleGenericValue | lv_defaultValue_10_2= RULE_ID ) ) ) ) )? (otherlv_11= ':' ( (lv_description_12_0= RULE_STRING ) ) )? otherlv_13= ';'
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:657:2: ()
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:658:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getValueTypeAccess().getValueTypeAction_0(),
                          current);
                  
            }

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:663:2: ( (lv_type_1_0= ruleVType ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:664:1: (lv_type_1_0= ruleVType )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:664:1: (lv_type_1_0= ruleVType )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:665:3: lv_type_1_0= ruleVType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getValueTypeAccess().getTypeVTypeEnumRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVType_in_ruleValueType1411);
            lv_type_1_0=ruleVType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getValueTypeRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_1_0, 
                      		"VType");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:681:2: ( (lv_withAuto_2_0= 'WITH_AUTO' ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==24) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:682:1: (lv_withAuto_2_0= 'WITH_AUTO' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:682:1: (lv_withAuto_2_0= 'WITH_AUTO' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:683:3: lv_withAuto_2_0= 'WITH_AUTO'
                    {
                    lv_withAuto_2_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleValueType1429); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_withAuto_2_0, grammarAccess.getValueTypeAccess().getWithAutoWITH_AUTOKeyword_2_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getValueTypeRule());
                      	        }
                             		setWithLastConsumed(current, "withAuto", true, "WITH_AUTO");
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:696:3: (otherlv_3= '[' ( (lv_ValidValues_4_0= ruleValidValues ) ) otherlv_5= ']' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==25) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:696:5: otherlv_3= '[' ( (lv_ValidValues_4_0= ruleValidValues ) ) otherlv_5= ']'
                    {
                    otherlv_3=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleValueType1456); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getValueTypeAccess().getLeftSquareBracketKeyword_3_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:700:1: ( (lv_ValidValues_4_0= ruleValidValues ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:701:1: (lv_ValidValues_4_0= ruleValidValues )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:701:1: (lv_ValidValues_4_0= ruleValidValues )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:702:3: lv_ValidValues_4_0= ruleValidValues
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueTypeAccess().getValidValuesValidValuesParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleValidValues_in_ruleValueType1477);
                    lv_ValidValues_4_0=ruleValidValues();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getValueTypeRule());
                      	        }
                             		set(
                             			current, 
                             			"ValidValues",
                              		lv_ValidValues_4_0, 
                              		"ValidValues");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_5=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleValueType1489); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getValueTypeAccess().getRightSquareBracketKeyword_3_2());
                          
                    }

                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:722:3: ( (lv_name_6_0= ruleSpecialId ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:723:1: (lv_name_6_0= ruleSpecialId )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:723:1: (lv_name_6_0= ruleSpecialId )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:724:3: lv_name_6_0= ruleSpecialId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getValueTypeAccess().getNameSpecialIdParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_ruleValueType1512);
            lv_name_6_0=ruleSpecialId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getValueTypeRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_6_0, 
                      		"SpecialId");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:740:2: ( (lv_multiValue_7_0= '[]' ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==27) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:741:1: (lv_multiValue_7_0= '[]' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:741:1: (lv_multiValue_7_0= '[]' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:742:3: lv_multiValue_7_0= '[]'
                    {
                    lv_multiValue_7_0=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleValueType1530); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_multiValue_7_0, grammarAccess.getValueTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_5_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getValueTypeRule());
                      	        }
                             		setWithLastConsumed(current, "multiValue", true, "[]");
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:755:3: (otherlv_8= '=' ( ( ( ( 'AUTO' ) )=> (lv_defaultAuto_9_0= 'AUTO' ) ) | ( ( (lv_defaultValue_10_1= ruleGenericValue | lv_defaultValue_10_2= RULE_ID ) ) ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==15) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:755:5: otherlv_8= '=' ( ( ( ( 'AUTO' ) )=> (lv_defaultAuto_9_0= 'AUTO' ) ) | ( ( (lv_defaultValue_10_1= ruleGenericValue | lv_defaultValue_10_2= RULE_ID ) ) ) )
                    {
                    otherlv_8=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleValueType1557); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getValueTypeAccess().getEqualsSignKeyword_6_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:759:1: ( ( ( ( 'AUTO' ) )=> (lv_defaultAuto_9_0= 'AUTO' ) ) | ( ( (lv_defaultValue_10_1= ruleGenericValue | lv_defaultValue_10_2= RULE_ID ) ) ) )
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==28) && (synpred1_InternalOil())) {
                        alt16=1;
                    }
                    else if ( ((LA16_0>=RULE_STRING && LA16_0<=RULE_HEX)||(LA16_0>=67 && LA16_0<=68)) ) {
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
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:759:2: ( ( ( 'AUTO' ) )=> (lv_defaultAuto_9_0= 'AUTO' ) )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:759:2: ( ( ( 'AUTO' ) )=> (lv_defaultAuto_9_0= 'AUTO' ) )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:759:3: ( ( 'AUTO' ) )=> (lv_defaultAuto_9_0= 'AUTO' )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:766:1: (lv_defaultAuto_9_0= 'AUTO' )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:767:3: lv_defaultAuto_9_0= 'AUTO'
                            {
                            lv_defaultAuto_9_0=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleValueType1591); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_defaultAuto_9_0, grammarAccess.getValueTypeAccess().getDefaultAutoAUTOKeyword_6_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getValueTypeRule());
                              	        }
                                     		setWithLastConsumed(current, "defaultAuto", true, "AUTO");
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:781:6: ( ( (lv_defaultValue_10_1= ruleGenericValue | lv_defaultValue_10_2= RULE_ID ) ) )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:781:6: ( ( (lv_defaultValue_10_1= ruleGenericValue | lv_defaultValue_10_2= RULE_ID ) ) )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:782:1: ( (lv_defaultValue_10_1= ruleGenericValue | lv_defaultValue_10_2= RULE_ID ) )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:782:1: ( (lv_defaultValue_10_1= ruleGenericValue | lv_defaultValue_10_2= RULE_ID ) )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:783:1: (lv_defaultValue_10_1= ruleGenericValue | lv_defaultValue_10_2= RULE_ID )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:783:1: (lv_defaultValue_10_1= ruleGenericValue | lv_defaultValue_10_2= RULE_ID )
                            int alt15=2;
                            int LA15_0 = input.LA(1);

                            if ( (LA15_0==RULE_STRING||(LA15_0>=RULE_NON_ZERO_INT && LA15_0<=RULE_HEX)||(LA15_0>=67 && LA15_0<=68)) ) {
                                alt15=1;
                            }
                            else if ( (LA15_0==RULE_ID) ) {
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
                                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:784:3: lv_defaultValue_10_1= ruleGenericValue
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getValueTypeAccess().getDefaultValueGenericValueParserRuleCall_6_1_1_0_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleGenericValue_in_ruleValueType1633);
                                    lv_defaultValue_10_1=ruleGenericValue();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElementForParent(grammarAccess.getValueTypeRule());
                                      	        }
                                             		set(
                                             			current, 
                                             			"defaultValue",
                                              		lv_defaultValue_10_1, 
                                              		"GenericValue");
                                      	        afterParserOrEnumRuleCall();
                                      	    
                                    }

                                    }
                                    break;
                                case 2 :
                                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:799:8: lv_defaultValue_10_2= RULE_ID
                                    {
                                    lv_defaultValue_10_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleValueType1648); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      			newLeafNode(lv_defaultValue_10_2, grammarAccess.getValueTypeAccess().getDefaultValueIDTerminalRuleCall_6_1_1_0_1()); 
                                      		
                                    }
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElement(grammarAccess.getValueTypeRule());
                                      	        }
                                             		setWithLastConsumed(
                                             			current, 
                                             			"defaultValue",
                                              		lv_defaultValue_10_2, 
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

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:817:5: (otherlv_11= ':' ( (lv_description_12_0= RULE_STRING ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==20) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:817:7: otherlv_11= ':' ( (lv_description_12_0= RULE_STRING ) )
                    {
                    otherlv_11=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleValueType1672); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getValueTypeAccess().getColonKeyword_7_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:821:1: ( (lv_description_12_0= RULE_STRING ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:822:1: (lv_description_12_0= RULE_STRING )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:822:1: (lv_description_12_0= RULE_STRING )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:823:3: lv_description_12_0= RULE_STRING
                    {
                    lv_description_12_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleValueType1689); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_description_12_0, grammarAccess.getValueTypeAccess().getDescriptionSTRINGTerminalRuleCall_7_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getValueTypeRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"description",
                              		lv_description_12_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_13=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleValueType1708); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_13, grammarAccess.getValueTypeAccess().getSemicolonKeyword_8());
                  
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:851:1: entryRuleVariantType returns [EObject current=null] : iv_ruleVariantType= ruleVariantType EOF ;
    public final EObject entryRuleVariantType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariantType = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:852:2: (iv_ruleVariantType= ruleVariantType EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:853:2: iv_ruleVariantType= ruleVariantType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariantTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVariantType_in_entryRuleVariantType1744);
            iv_ruleVariantType=ruleVariantType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariantType; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVariantType1754); if (state.failed) return current;

            }

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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:860:1: ruleVariantType returns [EObject current=null] : ( () ( (lv_type_1_0= ruleEType ) ) ( (lv_withAuto_2_0= 'WITH_AUTO' ) )? (otherlv_3= '[' ( ( (lv_Values_4_0= ruleEnumeratorType ) ) (otherlv_5= ',' ( (lv_Values_6_0= ruleEnumeratorType ) ) )* )? otherlv_7= ']' )? ( (lv_name_8_0= ruleSpecialId ) ) ( (lv_multiValue_9_0= '[]' ) )? (otherlv_10= '=' ( ( ( ( 'AUTO' ) )=> (lv_defaultAuto_11_0= 'AUTO' ) ) | ( (lv_defaultValue_12_0= RULE_ID ) ) ) )? (otherlv_13= ':' ( (lv_description_14_0= RULE_STRING ) ) )? otherlv_15= ';' ) ;
    public final EObject ruleVariantType() throws RecognitionException {
        EObject current = null;

        Token lv_withAuto_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_multiValue_9_0=null;
        Token otherlv_10=null;
        Token lv_defaultAuto_11_0=null;
        Token lv_defaultValue_12_0=null;
        Token otherlv_13=null;
        Token lv_description_14_0=null;
        Token otherlv_15=null;
        Enumerator lv_type_1_0 = null;

        EObject lv_Values_4_0 = null;

        EObject lv_Values_6_0 = null;

        AntlrDatatypeRuleToken lv_name_8_0 = null;


         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:863:28: ( ( () ( (lv_type_1_0= ruleEType ) ) ( (lv_withAuto_2_0= 'WITH_AUTO' ) )? (otherlv_3= '[' ( ( (lv_Values_4_0= ruleEnumeratorType ) ) (otherlv_5= ',' ( (lv_Values_6_0= ruleEnumeratorType ) ) )* )? otherlv_7= ']' )? ( (lv_name_8_0= ruleSpecialId ) ) ( (lv_multiValue_9_0= '[]' ) )? (otherlv_10= '=' ( ( ( ( 'AUTO' ) )=> (lv_defaultAuto_11_0= 'AUTO' ) ) | ( (lv_defaultValue_12_0= RULE_ID ) ) ) )? (otherlv_13= ':' ( (lv_description_14_0= RULE_STRING ) ) )? otherlv_15= ';' ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:864:1: ( () ( (lv_type_1_0= ruleEType ) ) ( (lv_withAuto_2_0= 'WITH_AUTO' ) )? (otherlv_3= '[' ( ( (lv_Values_4_0= ruleEnumeratorType ) ) (otherlv_5= ',' ( (lv_Values_6_0= ruleEnumeratorType ) ) )* )? otherlv_7= ']' )? ( (lv_name_8_0= ruleSpecialId ) ) ( (lv_multiValue_9_0= '[]' ) )? (otherlv_10= '=' ( ( ( ( 'AUTO' ) )=> (lv_defaultAuto_11_0= 'AUTO' ) ) | ( (lv_defaultValue_12_0= RULE_ID ) ) ) )? (otherlv_13= ':' ( (lv_description_14_0= RULE_STRING ) ) )? otherlv_15= ';' )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:864:1: ( () ( (lv_type_1_0= ruleEType ) ) ( (lv_withAuto_2_0= 'WITH_AUTO' ) )? (otherlv_3= '[' ( ( (lv_Values_4_0= ruleEnumeratorType ) ) (otherlv_5= ',' ( (lv_Values_6_0= ruleEnumeratorType ) ) )* )? otherlv_7= ']' )? ( (lv_name_8_0= ruleSpecialId ) ) ( (lv_multiValue_9_0= '[]' ) )? (otherlv_10= '=' ( ( ( ( 'AUTO' ) )=> (lv_defaultAuto_11_0= 'AUTO' ) ) | ( (lv_defaultValue_12_0= RULE_ID ) ) ) )? (otherlv_13= ':' ( (lv_description_14_0= RULE_STRING ) ) )? otherlv_15= ';' )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:864:2: () ( (lv_type_1_0= ruleEType ) ) ( (lv_withAuto_2_0= 'WITH_AUTO' ) )? (otherlv_3= '[' ( ( (lv_Values_4_0= ruleEnumeratorType ) ) (otherlv_5= ',' ( (lv_Values_6_0= ruleEnumeratorType ) ) )* )? otherlv_7= ']' )? ( (lv_name_8_0= ruleSpecialId ) ) ( (lv_multiValue_9_0= '[]' ) )? (otherlv_10= '=' ( ( ( ( 'AUTO' ) )=> (lv_defaultAuto_11_0= 'AUTO' ) ) | ( (lv_defaultValue_12_0= RULE_ID ) ) ) )? (otherlv_13= ':' ( (lv_description_14_0= RULE_STRING ) ) )? otherlv_15= ';'
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:864:2: ()
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:865:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getVariantTypeAccess().getVariantTypeAction_0(),
                          current);
                  
            }

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:870:2: ( (lv_type_1_0= ruleEType ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:871:1: (lv_type_1_0= ruleEType )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:871:1: (lv_type_1_0= ruleEType )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:872:3: lv_type_1_0= ruleEType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariantTypeAccess().getTypeETypeEnumRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleEType_in_ruleVariantType1809);
            lv_type_1_0=ruleEType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVariantTypeRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_1_0, 
                      		"EType");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:888:2: ( (lv_withAuto_2_0= 'WITH_AUTO' ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==24) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:889:1: (lv_withAuto_2_0= 'WITH_AUTO' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:889:1: (lv_withAuto_2_0= 'WITH_AUTO' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:890:3: lv_withAuto_2_0= 'WITH_AUTO'
                    {
                    lv_withAuto_2_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleVariantType1827); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_withAuto_2_0, grammarAccess.getVariantTypeAccess().getWithAutoWITH_AUTOKeyword_2_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getVariantTypeRule());
                      	        }
                             		setWithLastConsumed(current, "withAuto", true, "WITH_AUTO");
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:903:3: (otherlv_3= '[' ( ( (lv_Values_4_0= ruleEnumeratorType ) ) (otherlv_5= ',' ( (lv_Values_6_0= ruleEnumeratorType ) ) )* )? otherlv_7= ']' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==25) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:903:5: otherlv_3= '[' ( ( (lv_Values_4_0= ruleEnumeratorType ) ) (otherlv_5= ',' ( (lv_Values_6_0= ruleEnumeratorType ) ) )* )? otherlv_7= ']'
                    {
                    otherlv_3=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleVariantType1854); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getVariantTypeAccess().getLeftSquareBracketKeyword_3_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:907:1: ( ( (lv_Values_4_0= ruleEnumeratorType ) ) (otherlv_5= ',' ( (lv_Values_6_0= ruleEnumeratorType ) ) )* )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==RULE_ID||(LA21_0>=29 && LA21_0<=66)) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:907:2: ( (lv_Values_4_0= ruleEnumeratorType ) ) (otherlv_5= ',' ( (lv_Values_6_0= ruleEnumeratorType ) ) )*
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:907:2: ( (lv_Values_4_0= ruleEnumeratorType ) )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:908:1: (lv_Values_4_0= ruleEnumeratorType )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:908:1: (lv_Values_4_0= ruleEnumeratorType )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:909:3: lv_Values_4_0= ruleEnumeratorType
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getVariantTypeAccess().getValuesEnumeratorTypeParserRuleCall_3_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleEnumeratorType_in_ruleVariantType1876);
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

                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:925:2: (otherlv_5= ',' ( (lv_Values_6_0= ruleEnumeratorType ) ) )*
                            loop20:
                            do {
                                int alt20=2;
                                int LA20_0 = input.LA(1);

                                if ( (LA20_0==22) ) {
                                    alt20=1;
                                }


                                switch (alt20) {
                            	case 1 :
                            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:925:4: otherlv_5= ',' ( (lv_Values_6_0= ruleEnumeratorType ) )
                            	    {
                            	    otherlv_5=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleVariantType1889); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_5, grammarAccess.getVariantTypeAccess().getCommaKeyword_3_1_1_0());
                            	          
                            	    }
                            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:929:1: ( (lv_Values_6_0= ruleEnumeratorType ) )
                            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:930:1: (lv_Values_6_0= ruleEnumeratorType )
                            	    {
                            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:930:1: (lv_Values_6_0= ruleEnumeratorType )
                            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:931:3: lv_Values_6_0= ruleEnumeratorType
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getVariantTypeAccess().getValuesEnumeratorTypeParserRuleCall_3_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleEnumeratorType_in_ruleVariantType1910);
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
                            	    break loop20;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_7=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleVariantType1926); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getVariantTypeAccess().getRightSquareBracketKeyword_3_2());
                          
                    }

                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:951:3: ( (lv_name_8_0= ruleSpecialId ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:952:1: (lv_name_8_0= ruleSpecialId )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:952:1: (lv_name_8_0= ruleSpecialId )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:953:3: lv_name_8_0= ruleSpecialId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariantTypeAccess().getNameSpecialIdParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_ruleVariantType1949);
            lv_name_8_0=ruleSpecialId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVariantTypeRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_8_0, 
                      		"SpecialId");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:969:2: ( (lv_multiValue_9_0= '[]' ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==27) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:970:1: (lv_multiValue_9_0= '[]' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:970:1: (lv_multiValue_9_0= '[]' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:971:3: lv_multiValue_9_0= '[]'
                    {
                    lv_multiValue_9_0=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleVariantType1967); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_multiValue_9_0, grammarAccess.getVariantTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_5_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getVariantTypeRule());
                      	        }
                             		setWithLastConsumed(current, "multiValue", true, "[]");
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:984:3: (otherlv_10= '=' ( ( ( ( 'AUTO' ) )=> (lv_defaultAuto_11_0= 'AUTO' ) ) | ( (lv_defaultValue_12_0= RULE_ID ) ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==15) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:984:5: otherlv_10= '=' ( ( ( ( 'AUTO' ) )=> (lv_defaultAuto_11_0= 'AUTO' ) ) | ( (lv_defaultValue_12_0= RULE_ID ) ) )
                    {
                    otherlv_10=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleVariantType1994); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getVariantTypeAccess().getEqualsSignKeyword_6_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:988:1: ( ( ( ( 'AUTO' ) )=> (lv_defaultAuto_11_0= 'AUTO' ) ) | ( (lv_defaultValue_12_0= RULE_ID ) ) )
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==28) && (synpred2_InternalOil())) {
                        alt24=1;
                    }
                    else if ( (LA24_0==RULE_ID) ) {
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
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:988:2: ( ( ( 'AUTO' ) )=> (lv_defaultAuto_11_0= 'AUTO' ) )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:988:2: ( ( ( 'AUTO' ) )=> (lv_defaultAuto_11_0= 'AUTO' ) )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:988:3: ( ( 'AUTO' ) )=> (lv_defaultAuto_11_0= 'AUTO' )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:995:1: (lv_defaultAuto_11_0= 'AUTO' )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:996:3: lv_defaultAuto_11_0= 'AUTO'
                            {
                            lv_defaultAuto_11_0=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleVariantType2028); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_defaultAuto_11_0, grammarAccess.getVariantTypeAccess().getDefaultAutoAUTOKeyword_6_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getVariantTypeRule());
                              	        }
                                     		setWithLastConsumed(current, "defaultAuto", true, "AUTO");
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1010:6: ( (lv_defaultValue_12_0= RULE_ID ) )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1010:6: ( (lv_defaultValue_12_0= RULE_ID ) )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1011:1: (lv_defaultValue_12_0= RULE_ID )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1011:1: (lv_defaultValue_12_0= RULE_ID )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1012:3: lv_defaultValue_12_0= RULE_ID
                            {
                            lv_defaultValue_12_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleVariantType2064); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_defaultValue_12_0, grammarAccess.getVariantTypeAccess().getDefaultValueIDTerminalRuleCall_6_1_1_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getVariantTypeRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"defaultValue",
                                      		lv_defaultValue_12_0, 
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

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1028:5: (otherlv_13= ':' ( (lv_description_14_0= RULE_STRING ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==20) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1028:7: otherlv_13= ':' ( (lv_description_14_0= RULE_STRING ) )
                    {
                    otherlv_13=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleVariantType2085); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getVariantTypeAccess().getColonKeyword_7_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1032:1: ( (lv_description_14_0= RULE_STRING ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1033:1: (lv_description_14_0= RULE_STRING )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1033:1: (lv_description_14_0= RULE_STRING )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1034:3: lv_description_14_0= RULE_STRING
                    {
                    lv_description_14_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleVariantType2102); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_description_14_0, grammarAccess.getVariantTypeAccess().getDescriptionSTRINGTerminalRuleCall_7_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getVariantTypeRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"description",
                              		lv_description_14_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_15=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleVariantType2121); if (state.failed) return current;
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1062:1: entryRuleEnumeratorType returns [EObject current=null] : iv_ruleEnumeratorType= ruleEnumeratorType EOF ;
    public final EObject entryRuleEnumeratorType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumeratorType = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1063:2: (iv_ruleEnumeratorType= ruleEnumeratorType EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1064:2: iv_ruleEnumeratorType= ruleEnumeratorType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumeratorTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEnumeratorType_in_entryRuleEnumeratorType2157);
            iv_ruleEnumeratorType=ruleEnumeratorType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumeratorType; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumeratorType2167); if (state.failed) return current;

            }

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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1071:1: ruleEnumeratorType returns [EObject current=null] : ( () ( (lv_name_1_0= ruleSpecialId ) ) (otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameterType ) )* otherlv_4= '}' )? (otherlv_5= ':' ( (lv_description_6_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleEnumeratorType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_description_6_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_Parameters_3_0 = null;


         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1074:28: ( ( () ( (lv_name_1_0= ruleSpecialId ) ) (otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameterType ) )* otherlv_4= '}' )? (otherlv_5= ':' ( (lv_description_6_0= RULE_STRING ) ) )? ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1075:1: ( () ( (lv_name_1_0= ruleSpecialId ) ) (otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameterType ) )* otherlv_4= '}' )? (otherlv_5= ':' ( (lv_description_6_0= RULE_STRING ) ) )? )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1075:1: ( () ( (lv_name_1_0= ruleSpecialId ) ) (otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameterType ) )* otherlv_4= '}' )? (otherlv_5= ':' ( (lv_description_6_0= RULE_STRING ) ) )? )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1075:2: () ( (lv_name_1_0= ruleSpecialId ) ) (otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameterType ) )* otherlv_4= '}' )? (otherlv_5= ':' ( (lv_description_6_0= RULE_STRING ) ) )?
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1075:2: ()
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1076:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getEnumeratorTypeAccess().getEnumeratorTypeAction_0(),
                          current);
                  
            }

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1081:2: ( (lv_name_1_0= ruleSpecialId ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1082:1: (lv_name_1_0= ruleSpecialId )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1082:1: (lv_name_1_0= ruleSpecialId )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1083:3: lv_name_1_0= ruleSpecialId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEnumeratorTypeAccess().getNameSpecialIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_ruleEnumeratorType2222);
            lv_name_1_0=ruleSpecialId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getEnumeratorTypeRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"SpecialId");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1099:2: (otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameterType ) )* otherlv_4= '}' )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==18) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1099:4: otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameterType ) )* otherlv_4= '}'
                    {
                    otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleEnumeratorType2235); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getEnumeratorTypeAccess().getLeftCurlyBracketKeyword_2_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1103:1: ( (lv_Parameters_3_0= ruleParameterType ) )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( ((LA27_0>=29 && LA27_0<=36)||(LA27_0>=52 && LA27_0<=66)||LA27_0==71) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1104:1: (lv_Parameters_3_0= ruleParameterType )
                    	    {
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1104:1: (lv_Parameters_3_0= ruleParameterType )
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1105:3: lv_Parameters_3_0= ruleParameterType
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getEnumeratorTypeAccess().getParametersParameterTypeParserRuleCall_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleParameterType_in_ruleEnumeratorType2256);
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
                    	    break loop27;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleEnumeratorType2269); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getEnumeratorTypeAccess().getRightCurlyBracketKeyword_2_2());
                          
                    }

                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1125:3: (otherlv_5= ':' ( (lv_description_6_0= RULE_STRING ) ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==20) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1125:5: otherlv_5= ':' ( (lv_description_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleEnumeratorType2284); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getEnumeratorTypeAccess().getColonKeyword_3_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1129:1: ( (lv_description_6_0= RULE_STRING ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1130:1: (lv_description_6_0= RULE_STRING )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1130:1: (lv_description_6_0= RULE_STRING )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1131:3: lv_description_6_0= RULE_STRING
                    {
                    lv_description_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEnumeratorType2301); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_description_6_0, grammarAccess.getEnumeratorTypeAccess().getDescriptionSTRINGTerminalRuleCall_3_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getEnumeratorTypeRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"description",
                              		lv_description_6_0, 
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1155:1: entryRuleReferenceType returns [EObject current=null] : iv_ruleReferenceType= ruleReferenceType EOF ;
    public final EObject entryRuleReferenceType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceType = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1156:2: (iv_ruleReferenceType= ruleReferenceType EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1157:2: iv_ruleReferenceType= ruleReferenceType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReferenceTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleReferenceType_in_entryRuleReferenceType2344);
            iv_ruleReferenceType=ruleReferenceType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReferenceType; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceType2354); if (state.failed) return current;

            }

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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1164:1: ruleReferenceType returns [EObject current=null] : ( () ( (lv_type_1_0= ruleObjectTypeRef ) ) ( (lv_name_2_0= ruleSpecialId ) ) ( (lv_multiValue_3_0= '[]' ) )? (otherlv_4= '=' ( ( ( ( 'AUTO' ) )=> (lv_defaultAuto_5_0= 'AUTO' ) ) | ( (lv_defaultValue_6_0= RULE_ID ) ) ) )? (otherlv_7= ':' ( (lv_description_8_0= RULE_STRING ) ) )? otherlv_9= ';' ) ;
    public final EObject ruleReferenceType() throws RecognitionException {
        EObject current = null;

        Token lv_multiValue_3_0=null;
        Token otherlv_4=null;
        Token lv_defaultAuto_5_0=null;
        Token lv_defaultValue_6_0=null;
        Token otherlv_7=null;
        Token lv_description_8_0=null;
        Token otherlv_9=null;
        Enumerator lv_type_1_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;


         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1167:28: ( ( () ( (lv_type_1_0= ruleObjectTypeRef ) ) ( (lv_name_2_0= ruleSpecialId ) ) ( (lv_multiValue_3_0= '[]' ) )? (otherlv_4= '=' ( ( ( ( 'AUTO' ) )=> (lv_defaultAuto_5_0= 'AUTO' ) ) | ( (lv_defaultValue_6_0= RULE_ID ) ) ) )? (otherlv_7= ':' ( (lv_description_8_0= RULE_STRING ) ) )? otherlv_9= ';' ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1168:1: ( () ( (lv_type_1_0= ruleObjectTypeRef ) ) ( (lv_name_2_0= ruleSpecialId ) ) ( (lv_multiValue_3_0= '[]' ) )? (otherlv_4= '=' ( ( ( ( 'AUTO' ) )=> (lv_defaultAuto_5_0= 'AUTO' ) ) | ( (lv_defaultValue_6_0= RULE_ID ) ) ) )? (otherlv_7= ':' ( (lv_description_8_0= RULE_STRING ) ) )? otherlv_9= ';' )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1168:1: ( () ( (lv_type_1_0= ruleObjectTypeRef ) ) ( (lv_name_2_0= ruleSpecialId ) ) ( (lv_multiValue_3_0= '[]' ) )? (otherlv_4= '=' ( ( ( ( 'AUTO' ) )=> (lv_defaultAuto_5_0= 'AUTO' ) ) | ( (lv_defaultValue_6_0= RULE_ID ) ) ) )? (otherlv_7= ':' ( (lv_description_8_0= RULE_STRING ) ) )? otherlv_9= ';' )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1168:2: () ( (lv_type_1_0= ruleObjectTypeRef ) ) ( (lv_name_2_0= ruleSpecialId ) ) ( (lv_multiValue_3_0= '[]' ) )? (otherlv_4= '=' ( ( ( ( 'AUTO' ) )=> (lv_defaultAuto_5_0= 'AUTO' ) ) | ( (lv_defaultValue_6_0= RULE_ID ) ) ) )? (otherlv_7= ':' ( (lv_description_8_0= RULE_STRING ) ) )? otherlv_9= ';'
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1168:2: ()
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1169:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getReferenceTypeAccess().getReferenceTypeAction_0(),
                          current);
                  
            }

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1174:2: ( (lv_type_1_0= ruleObjectTypeRef ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1175:1: (lv_type_1_0= ruleObjectTypeRef )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1175:1: (lv_type_1_0= ruleObjectTypeRef )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1176:3: lv_type_1_0= ruleObjectTypeRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getReferenceTypeAccess().getTypeObjectTypeRefEnumRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleObjectTypeRef_in_ruleReferenceType2409);
            lv_type_1_0=ruleObjectTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getReferenceTypeRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_1_0, 
                      		"ObjectTypeRef");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1192:2: ( (lv_name_2_0= ruleSpecialId ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1193:1: (lv_name_2_0= ruleSpecialId )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1193:1: (lv_name_2_0= ruleSpecialId )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1194:3: lv_name_2_0= ruleSpecialId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getReferenceTypeAccess().getNameSpecialIdParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_ruleReferenceType2430);
            lv_name_2_0=ruleSpecialId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getReferenceTypeRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"SpecialId");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1210:2: ( (lv_multiValue_3_0= '[]' ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==27) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1211:1: (lv_multiValue_3_0= '[]' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1211:1: (lv_multiValue_3_0= '[]' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1212:3: lv_multiValue_3_0= '[]'
                    {
                    lv_multiValue_3_0=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleReferenceType2448); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_multiValue_3_0, grammarAccess.getReferenceTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_3_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getReferenceTypeRule());
                      	        }
                             		setWithLastConsumed(current, "multiValue", true, "[]");
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1225:3: (otherlv_4= '=' ( ( ( ( 'AUTO' ) )=> (lv_defaultAuto_5_0= 'AUTO' ) ) | ( (lv_defaultValue_6_0= RULE_ID ) ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==15) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1225:5: otherlv_4= '=' ( ( ( ( 'AUTO' ) )=> (lv_defaultAuto_5_0= 'AUTO' ) ) | ( (lv_defaultValue_6_0= RULE_ID ) ) )
                    {
                    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleReferenceType2475); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getReferenceTypeAccess().getEqualsSignKeyword_4_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1229:1: ( ( ( ( 'AUTO' ) )=> (lv_defaultAuto_5_0= 'AUTO' ) ) | ( (lv_defaultValue_6_0= RULE_ID ) ) )
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==28) && (synpred3_InternalOil())) {
                        alt31=1;
                    }
                    else if ( (LA31_0==RULE_ID) ) {
                        alt31=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 31, 0, input);

                        throw nvae;
                    }
                    switch (alt31) {
                        case 1 :
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1229:2: ( ( ( 'AUTO' ) )=> (lv_defaultAuto_5_0= 'AUTO' ) )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1229:2: ( ( ( 'AUTO' ) )=> (lv_defaultAuto_5_0= 'AUTO' ) )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1229:3: ( ( 'AUTO' ) )=> (lv_defaultAuto_5_0= 'AUTO' )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1236:1: (lv_defaultAuto_5_0= 'AUTO' )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1237:3: lv_defaultAuto_5_0= 'AUTO'
                            {
                            lv_defaultAuto_5_0=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleReferenceType2509); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_defaultAuto_5_0, grammarAccess.getReferenceTypeAccess().getDefaultAutoAUTOKeyword_4_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getReferenceTypeRule());
                              	        }
                                     		setWithLastConsumed(current, "defaultAuto", true, "AUTO");
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1251:6: ( (lv_defaultValue_6_0= RULE_ID ) )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1251:6: ( (lv_defaultValue_6_0= RULE_ID ) )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1252:1: (lv_defaultValue_6_0= RULE_ID )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1252:1: (lv_defaultValue_6_0= RULE_ID )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1253:3: lv_defaultValue_6_0= RULE_ID
                            {
                            lv_defaultValue_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceType2545); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_defaultValue_6_0, grammarAccess.getReferenceTypeAccess().getDefaultValueIDTerminalRuleCall_4_1_1_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getReferenceTypeRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"defaultValue",
                                      		lv_defaultValue_6_0, 
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

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1269:5: (otherlv_7= ':' ( (lv_description_8_0= RULE_STRING ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==20) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1269:7: otherlv_7= ':' ( (lv_description_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleReferenceType2566); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getReferenceTypeAccess().getColonKeyword_5_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1273:1: ( (lv_description_8_0= RULE_STRING ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1274:1: (lv_description_8_0= RULE_STRING )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1274:1: (lv_description_8_0= RULE_STRING )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1275:3: lv_description_8_0= RULE_STRING
                    {
                    lv_description_8_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleReferenceType2583); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_description_8_0, grammarAccess.getReferenceTypeAccess().getDescriptionSTRINGTerminalRuleCall_5_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getReferenceTypeRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"description",
                              		lv_description_8_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleReferenceType2602); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getReferenceTypeAccess().getSemicolonKeyword_6());
                  
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1303:1: entryRuleOilObject returns [EObject current=null] : iv_ruleOilObject= ruleOilObject EOF ;
    public final EObject entryRuleOilObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOilObject = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1304:2: (iv_ruleOilObject= ruleOilObject EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1305:2: iv_ruleOilObject= ruleOilObject EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOilObjectRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOilObject_in_entryRuleOilObject2638);
            iv_ruleOilObject=ruleOilObject();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOilObject; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOilObject2648); if (state.failed) return current;

            }

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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1312:1: ruleOilObject returns [EObject current=null] : ( ( (lv_type_0_0= ruleObjectType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameter ) )* otherlv_4= '}' )? (otherlv_5= ':' ( (lv_description_6_0= RULE_STRING ) ) )? otherlv_7= ';' ) ;
    public final EObject ruleOilObject() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_description_6_0=null;
        Token otherlv_7=null;
        Enumerator lv_type_0_0 = null;

        EObject lv_Parameters_3_0 = null;


         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1315:28: ( ( ( (lv_type_0_0= ruleObjectType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameter ) )* otherlv_4= '}' )? (otherlv_5= ':' ( (lv_description_6_0= RULE_STRING ) ) )? otherlv_7= ';' ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1316:1: ( ( (lv_type_0_0= ruleObjectType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameter ) )* otherlv_4= '}' )? (otherlv_5= ':' ( (lv_description_6_0= RULE_STRING ) ) )? otherlv_7= ';' )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1316:1: ( ( (lv_type_0_0= ruleObjectType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameter ) )* otherlv_4= '}' )? (otherlv_5= ':' ( (lv_description_6_0= RULE_STRING ) ) )? otherlv_7= ';' )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1316:2: ( (lv_type_0_0= ruleObjectType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameter ) )* otherlv_4= '}' )? (otherlv_5= ':' ( (lv_description_6_0= RULE_STRING ) ) )? otherlv_7= ';'
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1316:2: ( (lv_type_0_0= ruleObjectType ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1317:1: (lv_type_0_0= ruleObjectType )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1317:1: (lv_type_0_0= ruleObjectType )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1318:3: lv_type_0_0= ruleObjectType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOilObjectAccess().getTypeObjectTypeEnumRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleObjectType_in_ruleOilObject2694);
            lv_type_0_0=ruleObjectType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getOilObjectRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_0_0, 
                      		"ObjectType");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1334:2: ( (lv_name_1_0= RULE_ID ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1335:1: (lv_name_1_0= RULE_ID )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1335:1: (lv_name_1_0= RULE_ID )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1336:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOilObject2711); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getOilObjectAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getOilObjectRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1352:2: (otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameter ) )* otherlv_4= '}' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==18) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1352:4: otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameter ) )* otherlv_4= '}'
                    {
                    otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleOilObject2729); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getOilObjectAccess().getLeftCurlyBracketKeyword_2_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1356:1: ( (lv_Parameters_3_0= ruleParameter ) )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==RULE_ID||(LA34_0>=29 && LA34_0<=66)) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1357:1: (lv_Parameters_3_0= ruleParameter )
                    	    {
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1357:1: (lv_Parameters_3_0= ruleParameter )
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1358:3: lv_Parameters_3_0= ruleParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getOilObjectAccess().getParametersParameterParserRuleCall_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleParameter_in_ruleOilObject2750);
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
                    	    break loop34;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleOilObject2763); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getOilObjectAccess().getRightCurlyBracketKeyword_2_2());
                          
                    }

                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1378:3: (otherlv_5= ':' ( (lv_description_6_0= RULE_STRING ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==20) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1378:5: otherlv_5= ':' ( (lv_description_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleOilObject2778); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getOilObjectAccess().getColonKeyword_3_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1382:1: ( (lv_description_6_0= RULE_STRING ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1383:1: (lv_description_6_0= RULE_STRING )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1383:1: (lv_description_6_0= RULE_STRING )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1384:3: lv_description_6_0= RULE_STRING
                    {
                    lv_description_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleOilObject2795); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_description_6_0, grammarAccess.getOilObjectAccess().getDescriptionSTRINGTerminalRuleCall_3_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getOilObjectRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"description",
                              		lv_description_6_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleOilObject2814); if (state.failed) return current;
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1412:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1413:2: (iv_ruleParameter= ruleParameter EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1414:2: iv_ruleParameter= ruleParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_entryRuleParameter2850);
            iv_ruleParameter=ruleParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameter; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParameter2860); if (state.failed) return current;

            }

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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1421:1: ruleParameter returns [EObject current=null] : ( () ( ( ruleSpecialId ) ) otherlv_2= '=' ( ( ( ( 'AUTO' ) )=> (lv_auto_3_0= 'AUTO' ) ) | ( (lv_value_4_0= ruleGenericValue ) ) | ( ( ruleSpecialId ) ) ) (otherlv_6= '{' ( (lv_Parameters_7_0= ruleParameter ) )* otherlv_8= '}' )? (otherlv_9= ':' ( (lv_description_10_0= RULE_STRING ) ) )? otherlv_11= ';' ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_auto_3_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token lv_description_10_0=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_value_4_0 = null;

        EObject lv_Parameters_7_0 = null;


         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1424:28: ( ( () ( ( ruleSpecialId ) ) otherlv_2= '=' ( ( ( ( 'AUTO' ) )=> (lv_auto_3_0= 'AUTO' ) ) | ( (lv_value_4_0= ruleGenericValue ) ) | ( ( ruleSpecialId ) ) ) (otherlv_6= '{' ( (lv_Parameters_7_0= ruleParameter ) )* otherlv_8= '}' )? (otherlv_9= ':' ( (lv_description_10_0= RULE_STRING ) ) )? otherlv_11= ';' ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1425:1: ( () ( ( ruleSpecialId ) ) otherlv_2= '=' ( ( ( ( 'AUTO' ) )=> (lv_auto_3_0= 'AUTO' ) ) | ( (lv_value_4_0= ruleGenericValue ) ) | ( ( ruleSpecialId ) ) ) (otherlv_6= '{' ( (lv_Parameters_7_0= ruleParameter ) )* otherlv_8= '}' )? (otherlv_9= ':' ( (lv_description_10_0= RULE_STRING ) ) )? otherlv_11= ';' )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1425:1: ( () ( ( ruleSpecialId ) ) otherlv_2= '=' ( ( ( ( 'AUTO' ) )=> (lv_auto_3_0= 'AUTO' ) ) | ( (lv_value_4_0= ruleGenericValue ) ) | ( ( ruleSpecialId ) ) ) (otherlv_6= '{' ( (lv_Parameters_7_0= ruleParameter ) )* otherlv_8= '}' )? (otherlv_9= ':' ( (lv_description_10_0= RULE_STRING ) ) )? otherlv_11= ';' )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1425:2: () ( ( ruleSpecialId ) ) otherlv_2= '=' ( ( ( ( 'AUTO' ) )=> (lv_auto_3_0= 'AUTO' ) ) | ( (lv_value_4_0= ruleGenericValue ) ) | ( ( ruleSpecialId ) ) ) (otherlv_6= '{' ( (lv_Parameters_7_0= ruleParameter ) )* otherlv_8= '}' )? (otherlv_9= ':' ( (lv_description_10_0= RULE_STRING ) ) )? otherlv_11= ';'
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1425:2: ()
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1426:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getParameterAccess().getParameterAction_0(),
                          current);
                  
            }

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1431:2: ( ( ruleSpecialId ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1432:1: ( ruleSpecialId )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1432:1: ( ruleSpecialId )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1433:3: ruleSpecialId
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getParameterRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterAccess().getTypeParameterTypeCrossReference_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_ruleParameter2917);
            ruleSpecialId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleParameter2929); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getEqualsSignKeyword_2());
                  
            }
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1450:1: ( ( ( ( 'AUTO' ) )=> (lv_auto_3_0= 'AUTO' ) ) | ( (lv_value_4_0= ruleGenericValue ) ) | ( ( ruleSpecialId ) ) )
            int alt37=3;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==28) && (synpred4_InternalOil())) {
                alt37=1;
            }
            else if ( (LA37_0==RULE_STRING||(LA37_0>=RULE_NON_ZERO_INT && LA37_0<=RULE_HEX)||(LA37_0>=67 && LA37_0<=68)) ) {
                alt37=2;
            }
            else if ( (LA37_0==RULE_ID||(LA37_0>=29 && LA37_0<=66)) ) {
                alt37=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1450:2: ( ( ( 'AUTO' ) )=> (lv_auto_3_0= 'AUTO' ) )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1450:2: ( ( ( 'AUTO' ) )=> (lv_auto_3_0= 'AUTO' ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1450:3: ( ( 'AUTO' ) )=> (lv_auto_3_0= 'AUTO' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1457:1: (lv_auto_3_0= 'AUTO' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1458:3: lv_auto_3_0= 'AUTO'
                    {
                    lv_auto_3_0=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleParameter2963); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_auto_3_0, grammarAccess.getParameterAccess().getAutoAUTOKeyword_3_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getParameterRule());
                      	        }
                             		setWithLastConsumed(current, "auto", true, "AUTO");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1472:6: ( (lv_value_4_0= ruleGenericValue ) )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1472:6: ( (lv_value_4_0= ruleGenericValue ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1473:1: (lv_value_4_0= ruleGenericValue )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1473:1: (lv_value_4_0= ruleGenericValue )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1474:3: lv_value_4_0= ruleGenericValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParameterAccess().getValueGenericValueParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleGenericValue_in_ruleParameter3003);
                    lv_value_4_0=ruleGenericValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getParameterRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_4_0, 
                              		"GenericValue");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1491:6: ( ( ruleSpecialId ) )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1491:6: ( ( ruleSpecialId ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1492:1: ( ruleSpecialId )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1492:1: ( ruleSpecialId )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1493:3: ruleSpecialId
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getParameterRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParameterAccess().getValueRefParameterRefCrossReference_3_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_ruleParameter3032);
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

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1506:3: (otherlv_6= '{' ( (lv_Parameters_7_0= ruleParameter ) )* otherlv_8= '}' )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==18) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1506:5: otherlv_6= '{' ( (lv_Parameters_7_0= ruleParameter ) )* otherlv_8= '}'
                    {
                    otherlv_6=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleParameter3046); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getParameterAccess().getLeftCurlyBracketKeyword_4_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1510:1: ( (lv_Parameters_7_0= ruleParameter ) )*
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==RULE_ID||(LA38_0>=29 && LA38_0<=66)) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1511:1: (lv_Parameters_7_0= ruleParameter )
                    	    {
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1511:1: (lv_Parameters_7_0= ruleParameter )
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1512:3: lv_Parameters_7_0= ruleParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getParameterAccess().getParametersParameterParserRuleCall_4_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleParameter_in_ruleParameter3067);
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
                    	    break loop38;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleParameter3080); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getParameterAccess().getRightCurlyBracketKeyword_4_2());
                          
                    }

                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1532:3: (otherlv_9= ':' ( (lv_description_10_0= RULE_STRING ) ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==20) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1532:5: otherlv_9= ':' ( (lv_description_10_0= RULE_STRING ) )
                    {
                    otherlv_9=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleParameter3095); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getParameterAccess().getColonKeyword_5_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1536:1: ( (lv_description_10_0= RULE_STRING ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1537:1: (lv_description_10_0= RULE_STRING )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1537:1: (lv_description_10_0= RULE_STRING )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1538:3: lv_description_10_0= RULE_STRING
                    {
                    lv_description_10_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleParameter3112); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_description_10_0, grammarAccess.getParameterAccess().getDescriptionSTRINGTerminalRuleCall_5_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getParameterRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"description",
                              		lv_description_10_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleParameter3131); if (state.failed) return current;
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1566:1: entryRuleSpecialId returns [String current=null] : iv_ruleSpecialId= ruleSpecialId EOF ;
    public final String entryRuleSpecialId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSpecialId = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1567:2: (iv_ruleSpecialId= ruleSpecialId EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1568:2: iv_ruleSpecialId= ruleSpecialId EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSpecialIdRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_entryRuleSpecialId3168);
            iv_ruleSpecialId=ruleSpecialId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSpecialId.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpecialId3179); if (state.failed) return current;

            }

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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1575:1: ruleSpecialId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | kw= 'STRING' | kw= 'UINT32' | kw= 'INT32' | kw= 'UINT64' | kw= 'INT64' | kw= 'FLOAT' | kw= 'BOOLEAN' | kw= 'ENUM' | kw= 'OS' | kw= 'ALARM' | kw= 'APPMODE' | kw= 'COUNTER' | kw= 'COM' | kw= 'EVENT' | kw= 'IPDU' | kw= 'ISR' | kw= 'MESSAGE' | kw= 'NETWORKMESSAGE' | kw= 'NM' | kw= 'RESOURCE' | kw= 'TASK' | kw= 'SPINLOCK' | kw= 'SCHEDULETABLE' | kw= 'OS_TYPE' | kw= 'ALARM_TYPE' | kw= 'APPMODE_TYPE' | kw= 'COUNTER_TYPE' | kw= 'COM_TYPE' | kw= 'EVENT_TYPE' | kw= 'IPDU_TYPE' | kw= 'ISR_TYPE' | kw= 'MESSAGE_TYPE' | kw= 'NETWORKMESSAGE_TYPE' | kw= 'NM_TYPE' | kw= 'RESOURCE_TYPE' | kw= 'TASK_TYPE' | kw= 'SPINLOCK_TYPE' | kw= 'SCHEDULETABLE_TYPE' ) ;
    public final AntlrDatatypeRuleToken ruleSpecialId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1578:28: ( (this_ID_0= RULE_ID | kw= 'STRING' | kw= 'UINT32' | kw= 'INT32' | kw= 'UINT64' | kw= 'INT64' | kw= 'FLOAT' | kw= 'BOOLEAN' | kw= 'ENUM' | kw= 'OS' | kw= 'ALARM' | kw= 'APPMODE' | kw= 'COUNTER' | kw= 'COM' | kw= 'EVENT' | kw= 'IPDU' | kw= 'ISR' | kw= 'MESSAGE' | kw= 'NETWORKMESSAGE' | kw= 'NM' | kw= 'RESOURCE' | kw= 'TASK' | kw= 'SPINLOCK' | kw= 'SCHEDULETABLE' | kw= 'OS_TYPE' | kw= 'ALARM_TYPE' | kw= 'APPMODE_TYPE' | kw= 'COUNTER_TYPE' | kw= 'COM_TYPE' | kw= 'EVENT_TYPE' | kw= 'IPDU_TYPE' | kw= 'ISR_TYPE' | kw= 'MESSAGE_TYPE' | kw= 'NETWORKMESSAGE_TYPE' | kw= 'NM_TYPE' | kw= 'RESOURCE_TYPE' | kw= 'TASK_TYPE' | kw= 'SPINLOCK_TYPE' | kw= 'SCHEDULETABLE_TYPE' ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1579:1: (this_ID_0= RULE_ID | kw= 'STRING' | kw= 'UINT32' | kw= 'INT32' | kw= 'UINT64' | kw= 'INT64' | kw= 'FLOAT' | kw= 'BOOLEAN' | kw= 'ENUM' | kw= 'OS' | kw= 'ALARM' | kw= 'APPMODE' | kw= 'COUNTER' | kw= 'COM' | kw= 'EVENT' | kw= 'IPDU' | kw= 'ISR' | kw= 'MESSAGE' | kw= 'NETWORKMESSAGE' | kw= 'NM' | kw= 'RESOURCE' | kw= 'TASK' | kw= 'SPINLOCK' | kw= 'SCHEDULETABLE' | kw= 'OS_TYPE' | kw= 'ALARM_TYPE' | kw= 'APPMODE_TYPE' | kw= 'COUNTER_TYPE' | kw= 'COM_TYPE' | kw= 'EVENT_TYPE' | kw= 'IPDU_TYPE' | kw= 'ISR_TYPE' | kw= 'MESSAGE_TYPE' | kw= 'NETWORKMESSAGE_TYPE' | kw= 'NM_TYPE' | kw= 'RESOURCE_TYPE' | kw= 'TASK_TYPE' | kw= 'SPINLOCK_TYPE' | kw= 'SCHEDULETABLE_TYPE' )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1579:1: (this_ID_0= RULE_ID | kw= 'STRING' | kw= 'UINT32' | kw= 'INT32' | kw= 'UINT64' | kw= 'INT64' | kw= 'FLOAT' | kw= 'BOOLEAN' | kw= 'ENUM' | kw= 'OS' | kw= 'ALARM' | kw= 'APPMODE' | kw= 'COUNTER' | kw= 'COM' | kw= 'EVENT' | kw= 'IPDU' | kw= 'ISR' | kw= 'MESSAGE' | kw= 'NETWORKMESSAGE' | kw= 'NM' | kw= 'RESOURCE' | kw= 'TASK' | kw= 'SPINLOCK' | kw= 'SCHEDULETABLE' | kw= 'OS_TYPE' | kw= 'ALARM_TYPE' | kw= 'APPMODE_TYPE' | kw= 'COUNTER_TYPE' | kw= 'COM_TYPE' | kw= 'EVENT_TYPE' | kw= 'IPDU_TYPE' | kw= 'ISR_TYPE' | kw= 'MESSAGE_TYPE' | kw= 'NETWORKMESSAGE_TYPE' | kw= 'NM_TYPE' | kw= 'RESOURCE_TYPE' | kw= 'TASK_TYPE' | kw= 'SPINLOCK_TYPE' | kw= 'SCHEDULETABLE_TYPE' )
            int alt41=39;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt41=1;
                }
                break;
            case 29:
                {
                alt41=2;
                }
                break;
            case 30:
                {
                alt41=3;
                }
                break;
            case 31:
                {
                alt41=4;
                }
                break;
            case 32:
                {
                alt41=5;
                }
                break;
            case 33:
                {
                alt41=6;
                }
                break;
            case 34:
                {
                alt41=7;
                }
                break;
            case 35:
                {
                alt41=8;
                }
                break;
            case 36:
                {
                alt41=9;
                }
                break;
            case 37:
                {
                alt41=10;
                }
                break;
            case 38:
                {
                alt41=11;
                }
                break;
            case 39:
                {
                alt41=12;
                }
                break;
            case 40:
                {
                alt41=13;
                }
                break;
            case 41:
                {
                alt41=14;
                }
                break;
            case 42:
                {
                alt41=15;
                }
                break;
            case 43:
                {
                alt41=16;
                }
                break;
            case 44:
                {
                alt41=17;
                }
                break;
            case 45:
                {
                alt41=18;
                }
                break;
            case 46:
                {
                alt41=19;
                }
                break;
            case 47:
                {
                alt41=20;
                }
                break;
            case 48:
                {
                alt41=21;
                }
                break;
            case 49:
                {
                alt41=22;
                }
                break;
            case 50:
                {
                alt41=23;
                }
                break;
            case 51:
                {
                alt41=24;
                }
                break;
            case 52:
                {
                alt41=25;
                }
                break;
            case 53:
                {
                alt41=26;
                }
                break;
            case 54:
                {
                alt41=27;
                }
                break;
            case 55:
                {
                alt41=28;
                }
                break;
            case 56:
                {
                alt41=29;
                }
                break;
            case 57:
                {
                alt41=30;
                }
                break;
            case 58:
                {
                alt41=31;
                }
                break;
            case 59:
                {
                alt41=32;
                }
                break;
            case 60:
                {
                alt41=33;
                }
                break;
            case 61:
                {
                alt41=34;
                }
                break;
            case 62:
                {
                alt41=35;
                }
                break;
            case 63:
                {
                alt41=36;
                }
                break;
            case 64:
                {
                alt41=37;
                }
                break;
            case 65:
                {
                alt41=38;
                }
                break;
            case 66:
                {
                alt41=39;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1579:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSpecialId3219); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_0, grammarAccess.getSpecialIdAccess().getIDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1588:2: kw= 'STRING'
                    {
                    kw=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleSpecialId3243); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getSTRINGKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1595:2: kw= 'UINT32'
                    {
                    kw=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleSpecialId3262); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getUINT32Keyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1602:2: kw= 'INT32'
                    {
                    kw=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleSpecialId3281); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getINT32Keyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1609:2: kw= 'UINT64'
                    {
                    kw=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleSpecialId3300); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getUINT64Keyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1616:2: kw= 'INT64'
                    {
                    kw=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleSpecialId3319); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getINT64Keyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1623:2: kw= 'FLOAT'
                    {
                    kw=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleSpecialId3338); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getFLOATKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1630:2: kw= 'BOOLEAN'
                    {
                    kw=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleSpecialId3357); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getBOOLEANKeyword_7()); 
                          
                    }

                    }
                    break;
                case 9 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1637:2: kw= 'ENUM'
                    {
                    kw=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleSpecialId3376); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getENUMKeyword_8()); 
                          
                    }

                    }
                    break;
                case 10 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1644:2: kw= 'OS'
                    {
                    kw=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleSpecialId3395); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getOSKeyword_9()); 
                          
                    }

                    }
                    break;
                case 11 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1651:2: kw= 'ALARM'
                    {
                    kw=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleSpecialId3414); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getALARMKeyword_10()); 
                          
                    }

                    }
                    break;
                case 12 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1658:2: kw= 'APPMODE'
                    {
                    kw=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleSpecialId3433); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getAPPMODEKeyword_11()); 
                          
                    }

                    }
                    break;
                case 13 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1665:2: kw= 'COUNTER'
                    {
                    kw=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleSpecialId3452); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getCOUNTERKeyword_12()); 
                          
                    }

                    }
                    break;
                case 14 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1672:2: kw= 'COM'
                    {
                    kw=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleSpecialId3471); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getCOMKeyword_13()); 
                          
                    }

                    }
                    break;
                case 15 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1679:2: kw= 'EVENT'
                    {
                    kw=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleSpecialId3490); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getEVENTKeyword_14()); 
                          
                    }

                    }
                    break;
                case 16 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1686:2: kw= 'IPDU'
                    {
                    kw=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleSpecialId3509); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getIPDUKeyword_15()); 
                          
                    }

                    }
                    break;
                case 17 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1693:2: kw= 'ISR'
                    {
                    kw=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleSpecialId3528); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getISRKeyword_16()); 
                          
                    }

                    }
                    break;
                case 18 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1700:2: kw= 'MESSAGE'
                    {
                    kw=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleSpecialId3547); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getMESSAGEKeyword_17()); 
                          
                    }

                    }
                    break;
                case 19 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1707:2: kw= 'NETWORKMESSAGE'
                    {
                    kw=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleSpecialId3566); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getNETWORKMESSAGEKeyword_18()); 
                          
                    }

                    }
                    break;
                case 20 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1714:2: kw= 'NM'
                    {
                    kw=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleSpecialId3585); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getNMKeyword_19()); 
                          
                    }

                    }
                    break;
                case 21 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1721:2: kw= 'RESOURCE'
                    {
                    kw=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleSpecialId3604); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getRESOURCEKeyword_20()); 
                          
                    }

                    }
                    break;
                case 22 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1728:2: kw= 'TASK'
                    {
                    kw=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleSpecialId3623); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getTASKKeyword_21()); 
                          
                    }

                    }
                    break;
                case 23 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1735:2: kw= 'SPINLOCK'
                    {
                    kw=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleSpecialId3642); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getSPINLOCKKeyword_22()); 
                          
                    }

                    }
                    break;
                case 24 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1742:2: kw= 'SCHEDULETABLE'
                    {
                    kw=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleSpecialId3661); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getSCHEDULETABLEKeyword_23()); 
                          
                    }

                    }
                    break;
                case 25 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1749:2: kw= 'OS_TYPE'
                    {
                    kw=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleSpecialId3680); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getOS_TYPEKeyword_24()); 
                          
                    }

                    }
                    break;
                case 26 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1756:2: kw= 'ALARM_TYPE'
                    {
                    kw=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleSpecialId3699); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getALARM_TYPEKeyword_25()); 
                          
                    }

                    }
                    break;
                case 27 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1763:2: kw= 'APPMODE_TYPE'
                    {
                    kw=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleSpecialId3718); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getAPPMODE_TYPEKeyword_26()); 
                          
                    }

                    }
                    break;
                case 28 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1770:2: kw= 'COUNTER_TYPE'
                    {
                    kw=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleSpecialId3737); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getCOUNTER_TYPEKeyword_27()); 
                          
                    }

                    }
                    break;
                case 29 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1777:2: kw= 'COM_TYPE'
                    {
                    kw=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleSpecialId3756); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getCOM_TYPEKeyword_28()); 
                          
                    }

                    }
                    break;
                case 30 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1784:2: kw= 'EVENT_TYPE'
                    {
                    kw=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleSpecialId3775); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getEVENT_TYPEKeyword_29()); 
                          
                    }

                    }
                    break;
                case 31 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1791:2: kw= 'IPDU_TYPE'
                    {
                    kw=(Token)match(input,58,FollowSets000.FOLLOW_58_in_ruleSpecialId3794); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getIPDU_TYPEKeyword_30()); 
                          
                    }

                    }
                    break;
                case 32 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1798:2: kw= 'ISR_TYPE'
                    {
                    kw=(Token)match(input,59,FollowSets000.FOLLOW_59_in_ruleSpecialId3813); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getISR_TYPEKeyword_31()); 
                          
                    }

                    }
                    break;
                case 33 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1805:2: kw= 'MESSAGE_TYPE'
                    {
                    kw=(Token)match(input,60,FollowSets000.FOLLOW_60_in_ruleSpecialId3832); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getMESSAGE_TYPEKeyword_32()); 
                          
                    }

                    }
                    break;
                case 34 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1812:2: kw= 'NETWORKMESSAGE_TYPE'
                    {
                    kw=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleSpecialId3851); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getNETWORKMESSAGE_TYPEKeyword_33()); 
                          
                    }

                    }
                    break;
                case 35 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1819:2: kw= 'NM_TYPE'
                    {
                    kw=(Token)match(input,62,FollowSets000.FOLLOW_62_in_ruleSpecialId3870); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getNM_TYPEKeyword_34()); 
                          
                    }

                    }
                    break;
                case 36 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1826:2: kw= 'RESOURCE_TYPE'
                    {
                    kw=(Token)match(input,63,FollowSets000.FOLLOW_63_in_ruleSpecialId3889); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getRESOURCE_TYPEKeyword_35()); 
                          
                    }

                    }
                    break;
                case 37 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1833:2: kw= 'TASK_TYPE'
                    {
                    kw=(Token)match(input,64,FollowSets000.FOLLOW_64_in_ruleSpecialId3908); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getTASK_TYPEKeyword_36()); 
                          
                    }

                    }
                    break;
                case 38 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1840:2: kw= 'SPINLOCK_TYPE'
                    {
                    kw=(Token)match(input,65,FollowSets000.FOLLOW_65_in_ruleSpecialId3927); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getSPINLOCK_TYPEKeyword_37()); 
                          
                    }

                    }
                    break;
                case 39 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1847:2: kw= 'SCHEDULETABLE_TYPE'
                    {
                    kw=(Token)match(input,66,FollowSets000.FOLLOW_66_in_ruleSpecialId3946); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSpecialIdAccess().getSCHEDULETABLE_TYPEKeyword_38()); 
                          
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1860:1: entryRuleGenericValue returns [String current=null] : iv_ruleGenericValue= ruleGenericValue EOF ;
    public final String entryRuleGenericValue() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleGenericValue = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1861:2: (iv_ruleGenericValue= ruleGenericValue EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1862:2: iv_ruleGenericValue= ruleGenericValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGenericValueRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleGenericValue_in_entryRuleGenericValue3987);
            iv_ruleGenericValue=ruleGenericValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGenericValue.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGenericValue3998); if (state.failed) return current;

            }

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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1869:1: ruleGenericValue returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_INT_1= ruleINT | this_FLOAT_2= ruleFLOAT ) ;
    public final AntlrDatatypeRuleToken ruleGenericValue() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        AntlrDatatypeRuleToken this_INT_1 = null;

        AntlrDatatypeRuleToken this_FLOAT_2 = null;


         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1872:28: ( (this_STRING_0= RULE_STRING | this_INT_1= ruleINT | this_FLOAT_2= ruleFLOAT ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1873:1: (this_STRING_0= RULE_STRING | this_INT_1= ruleINT | this_FLOAT_2= ruleFLOAT )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1873:1: (this_STRING_0= RULE_STRING | this_INT_1= ruleINT | this_FLOAT_2= ruleFLOAT )
            int alt42=3;
            alt42 = dfa42.predict(input);
            switch (alt42) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1873:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleGenericValue4038); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_STRING_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_STRING_0, grammarAccess.getGenericValueAccess().getSTRINGTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1882:5: this_INT_1= ruleINT
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getGenericValueAccess().getINTParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleINT_in_ruleGenericValue4071);
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
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1894:5: this_FLOAT_2= ruleFLOAT
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getGenericValueAccess().getFLOATParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFLOAT_in_ruleGenericValue4104);
                    this_FLOAT_2=ruleFLOAT();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_FLOAT_2);
                          
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


    // $ANTLR start "entryRuleGenericNumber"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1912:1: entryRuleGenericNumber returns [String current=null] : iv_ruleGenericNumber= ruleGenericNumber EOF ;
    public final String entryRuleGenericNumber() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleGenericNumber = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1913:2: (iv_ruleGenericNumber= ruleGenericNumber EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1914:2: iv_ruleGenericNumber= ruleGenericNumber EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGenericNumberRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleGenericNumber_in_entryRuleGenericNumber4150);
            iv_ruleGenericNumber=ruleGenericNumber();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGenericNumber.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGenericNumber4161); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGenericNumber"


    // $ANTLR start "ruleGenericNumber"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1921:1: ruleGenericNumber returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= ruleINT | this_FLOAT_1= ruleFLOAT ) ;
    public final AntlrDatatypeRuleToken ruleGenericNumber() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_INT_0 = null;

        AntlrDatatypeRuleToken this_FLOAT_1 = null;


         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1924:28: ( (this_INT_0= ruleINT | this_FLOAT_1= ruleFLOAT ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1925:1: (this_INT_0= ruleINT | this_FLOAT_1= ruleFLOAT )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1925:1: (this_INT_0= ruleINT | this_FLOAT_1= ruleFLOAT )
            int alt43=2;
            alt43 = dfa43.predict(input);
            switch (alt43) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1926:5: this_INT_0= ruleINT
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getGenericNumberAccess().getINTParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleINT_in_ruleGenericNumber4208);
                    this_INT_0=ruleINT();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_INT_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1938:5: this_FLOAT_1= ruleFLOAT
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getGenericNumberAccess().getFLOATParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFLOAT_in_ruleGenericNumber4241);
                    this_FLOAT_1=ruleFLOAT();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_FLOAT_1);
                          
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
    // $ANTLR end "ruleGenericNumber"


    // $ANTLR start "entryRuleINT"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1956:1: entryRuleINT returns [String current=null] : iv_ruleINT= ruleINT EOF ;
    public final String entryRuleINT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINT = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1957:2: (iv_ruleINT= ruleINT EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1958:2: iv_ruleINT= ruleINT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getINTRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleINT_in_entryRuleINT4287);
            iv_ruleINT=ruleINT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleINT.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleINT4298); if (state.failed) return current;

            }

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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1965:1: ruleINT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? ( (this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )* ) | this_ZERO_INT_5= RULE_ZERO_INT | this_HEX_6= RULE_HEX ) ) ;
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
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1968:28: ( ( (kw= '+' | kw= '-' )? ( (this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )* ) | this_ZERO_INT_5= RULE_ZERO_INT | this_HEX_6= RULE_HEX ) ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1969:1: ( (kw= '+' | kw= '-' )? ( (this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )* ) | this_ZERO_INT_5= RULE_ZERO_INT | this_HEX_6= RULE_HEX ) )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1969:1: ( (kw= '+' | kw= '-' )? ( (this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )* ) | this_ZERO_INT_5= RULE_ZERO_INT | this_HEX_6= RULE_HEX ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1969:2: (kw= '+' | kw= '-' )? ( (this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )* ) | this_ZERO_INT_5= RULE_ZERO_INT | this_HEX_6= RULE_HEX )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1969:2: (kw= '+' | kw= '-' )?
            int alt44=3;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==67) ) {
                alt44=1;
            }
            else if ( (LA44_0==68) ) {
                alt44=2;
            }
            switch (alt44) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1970:2: kw= '+'
                    {
                    kw=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleINT4337); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getINTAccess().getPlusSignKeyword_0_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1977:2: kw= '-'
                    {
                    kw=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleINT4356); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getINTAccess().getHyphenMinusKeyword_0_1()); 
                          
                    }

                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1982:3: ( (this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )* ) | this_ZERO_INT_5= RULE_ZERO_INT | this_HEX_6= RULE_HEX )
            int alt46=3;
            switch ( input.LA(1) ) {
            case RULE_NON_ZERO_INT:
                {
                alt46=1;
                }
                break;
            case RULE_ZERO_INT:
                {
                alt46=2;
                }
                break;
            case RULE_HEX:
                {
                alt46=3;
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
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1982:4: (this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )* )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1982:4: (this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )* )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1982:9: this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )*
                    {
                    this_NON_ZERO_INT_2=(Token)match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_ruleINT4375); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_NON_ZERO_INT_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_NON_ZERO_INT_2, grammarAccess.getINTAccess().getNON_ZERO_INTTerminalRuleCall_1_0_0()); 
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1989:1: (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )*
                    loop45:
                    do {
                        int alt45=3;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==RULE_ZERO_INT) ) {
                            alt45=1;
                        }
                        else if ( (LA45_0==RULE_NON_ZERO_INT) ) {
                            alt45=2;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1989:6: this_ZERO_INT_3= RULE_ZERO_INT
                    	    {
                    	    this_ZERO_INT_3=(Token)match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_ruleINT4396); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		current.merge(this_ZERO_INT_3);
                    	          
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_ZERO_INT_3, grammarAccess.getINTAccess().getZERO_INTTerminalRuleCall_1_0_1_0()); 
                    	          
                    	    }

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1997:10: this_NON_ZERO_INT_4= RULE_NON_ZERO_INT
                    	    {
                    	    this_NON_ZERO_INT_4=(Token)match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_ruleINT4422); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		current.merge(this_NON_ZERO_INT_4);
                    	          
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_NON_ZERO_INT_4, grammarAccess.getINTAccess().getNON_ZERO_INTTerminalRuleCall_1_0_1_1()); 
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop45;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2005:10: this_ZERO_INT_5= RULE_ZERO_INT
                    {
                    this_ZERO_INT_5=(Token)match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_ruleINT4451); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ZERO_INT_5);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ZERO_INT_5, grammarAccess.getINTAccess().getZERO_INTTerminalRuleCall_1_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2013:10: this_HEX_6= RULE_HEX
                    {
                    this_HEX_6=(Token)match(input,RULE_HEX,FollowSets000.FOLLOW_RULE_HEX_in_ruleINT4477); if (state.failed) return current;
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


    // $ANTLR start "entryRuleFLOAT"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2028:1: entryRuleFLOAT returns [String current=null] : iv_ruleFLOAT= ruleFLOAT EOF ;
    public final String entryRuleFLOAT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFLOAT = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2029:2: (iv_ruleFLOAT= ruleFLOAT EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2030:2: iv_ruleFLOAT= ruleFLOAT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFLOATRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFLOAT_in_entryRuleFLOAT4524);
            iv_ruleFLOAT=ruleFLOAT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFLOAT.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFLOAT4535); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFLOAT"


    // $ANTLR start "ruleFLOAT"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2037:1: ruleFLOAT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? (this_ZERO_INT_2= RULE_ZERO_INT | (this_NON_ZERO_INT_3= RULE_NON_ZERO_INT (this_ZERO_INT_4= RULE_ZERO_INT | this_NON_ZERO_INT_5= RULE_NON_ZERO_INT )* ) ) ( ( '.' )=>kw= '.' ) (this_ZERO_INT_7= RULE_ZERO_INT | this_NON_ZERO_INT_8= RULE_NON_ZERO_INT )+ ) ;
    public final AntlrDatatypeRuleToken ruleFLOAT() throws RecognitionException {
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
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2040:28: ( ( (kw= '+' | kw= '-' )? (this_ZERO_INT_2= RULE_ZERO_INT | (this_NON_ZERO_INT_3= RULE_NON_ZERO_INT (this_ZERO_INT_4= RULE_ZERO_INT | this_NON_ZERO_INT_5= RULE_NON_ZERO_INT )* ) ) ( ( '.' )=>kw= '.' ) (this_ZERO_INT_7= RULE_ZERO_INT | this_NON_ZERO_INT_8= RULE_NON_ZERO_INT )+ ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2041:1: ( (kw= '+' | kw= '-' )? (this_ZERO_INT_2= RULE_ZERO_INT | (this_NON_ZERO_INT_3= RULE_NON_ZERO_INT (this_ZERO_INT_4= RULE_ZERO_INT | this_NON_ZERO_INT_5= RULE_NON_ZERO_INT )* ) ) ( ( '.' )=>kw= '.' ) (this_ZERO_INT_7= RULE_ZERO_INT | this_NON_ZERO_INT_8= RULE_NON_ZERO_INT )+ )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2041:1: ( (kw= '+' | kw= '-' )? (this_ZERO_INT_2= RULE_ZERO_INT | (this_NON_ZERO_INT_3= RULE_NON_ZERO_INT (this_ZERO_INT_4= RULE_ZERO_INT | this_NON_ZERO_INT_5= RULE_NON_ZERO_INT )* ) ) ( ( '.' )=>kw= '.' ) (this_ZERO_INT_7= RULE_ZERO_INT | this_NON_ZERO_INT_8= RULE_NON_ZERO_INT )+ )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2041:2: (kw= '+' | kw= '-' )? (this_ZERO_INT_2= RULE_ZERO_INT | (this_NON_ZERO_INT_3= RULE_NON_ZERO_INT (this_ZERO_INT_4= RULE_ZERO_INT | this_NON_ZERO_INT_5= RULE_NON_ZERO_INT )* ) ) ( ( '.' )=>kw= '.' ) (this_ZERO_INT_7= RULE_ZERO_INT | this_NON_ZERO_INT_8= RULE_NON_ZERO_INT )+
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2041:2: (kw= '+' | kw= '-' )?
            int alt47=3;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==67) ) {
                alt47=1;
            }
            else if ( (LA47_0==68) ) {
                alt47=2;
            }
            switch (alt47) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2042:2: kw= '+'
                    {
                    kw=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleFLOAT4574); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getFLOATAccess().getPlusSignKeyword_0_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2049:2: kw= '-'
                    {
                    kw=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleFLOAT4593); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getFLOATAccess().getHyphenMinusKeyword_0_1()); 
                          
                    }

                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2054:3: (this_ZERO_INT_2= RULE_ZERO_INT | (this_NON_ZERO_INT_3= RULE_NON_ZERO_INT (this_ZERO_INT_4= RULE_ZERO_INT | this_NON_ZERO_INT_5= RULE_NON_ZERO_INT )* ) )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_ZERO_INT) ) {
                alt49=1;
            }
            else if ( (LA49_0==RULE_NON_ZERO_INT) ) {
                alt49=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2054:8: this_ZERO_INT_2= RULE_ZERO_INT
                    {
                    this_ZERO_INT_2=(Token)match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_ruleFLOAT4611); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ZERO_INT_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ZERO_INT_2, grammarAccess.getFLOATAccess().getZERO_INTTerminalRuleCall_1_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2062:6: (this_NON_ZERO_INT_3= RULE_NON_ZERO_INT (this_ZERO_INT_4= RULE_ZERO_INT | this_NON_ZERO_INT_5= RULE_NON_ZERO_INT )* )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2062:6: (this_NON_ZERO_INT_3= RULE_NON_ZERO_INT (this_ZERO_INT_4= RULE_ZERO_INT | this_NON_ZERO_INT_5= RULE_NON_ZERO_INT )* )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2062:11: this_NON_ZERO_INT_3= RULE_NON_ZERO_INT (this_ZERO_INT_4= RULE_ZERO_INT | this_NON_ZERO_INT_5= RULE_NON_ZERO_INT )*
                    {
                    this_NON_ZERO_INT_3=(Token)match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_ruleFLOAT4638); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_NON_ZERO_INT_3);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_NON_ZERO_INT_3, grammarAccess.getFLOATAccess().getNON_ZERO_INTTerminalRuleCall_1_1_0()); 
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2069:1: (this_ZERO_INT_4= RULE_ZERO_INT | this_NON_ZERO_INT_5= RULE_NON_ZERO_INT )*
                    loop48:
                    do {
                        int alt48=3;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==RULE_ZERO_INT) ) {
                            alt48=1;
                        }
                        else if ( (LA48_0==RULE_NON_ZERO_INT) ) {
                            alt48=2;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2069:6: this_ZERO_INT_4= RULE_ZERO_INT
                    	    {
                    	    this_ZERO_INT_4=(Token)match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_ruleFLOAT4659); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		current.merge(this_ZERO_INT_4);
                    	          
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_ZERO_INT_4, grammarAccess.getFLOATAccess().getZERO_INTTerminalRuleCall_1_1_1_0()); 
                    	          
                    	    }

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2077:10: this_NON_ZERO_INT_5= RULE_NON_ZERO_INT
                    	    {
                    	    this_NON_ZERO_INT_5=(Token)match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_ruleFLOAT4685); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		current.merge(this_NON_ZERO_INT_5);
                    	          
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_NON_ZERO_INT_5, grammarAccess.getFLOATAccess().getNON_ZERO_INTTerminalRuleCall_1_1_1_1()); 
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop48;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2084:5: ( ( '.' )=>kw= '.' )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2084:6: ( '.' )=>kw= '.'
            {
            kw=(Token)match(input,69,FollowSets000.FOLLOW_69_in_ruleFLOAT4716); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getFLOATAccess().getFullStopKeyword_2()); 
                  
            }

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2092:2: (this_ZERO_INT_7= RULE_ZERO_INT | this_NON_ZERO_INT_8= RULE_NON_ZERO_INT )+
            int cnt50=0;
            loop50:
            do {
                int alt50=3;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==RULE_ZERO_INT) ) {
                    alt50=1;
                }
                else if ( (LA50_0==RULE_NON_ZERO_INT) ) {
                    alt50=2;
                }


                switch (alt50) {
            	case 1 :
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2092:7: this_ZERO_INT_7= RULE_ZERO_INT
            	    {
            	    this_ZERO_INT_7=(Token)match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_ruleFLOAT4733); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ZERO_INT_7);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ZERO_INT_7, grammarAccess.getFLOATAccess().getZERO_INTTerminalRuleCall_3_0()); 
            	          
            	    }

            	    }
            	    break;
            	case 2 :
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2100:10: this_NON_ZERO_INT_8= RULE_NON_ZERO_INT
            	    {
            	    this_NON_ZERO_INT_8=(Token)match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_ruleFLOAT4759); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_NON_ZERO_INT_8);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NON_ZERO_INT_8, grammarAccess.getFLOATAccess().getNON_ZERO_INTTerminalRuleCall_3_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt50 >= 1 ) break loop50;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(50, input);
                        throw eee;
                }
                cnt50++;
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
    // $ANTLR end "ruleFLOAT"


    // $ANTLR start "ruleVType"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2115:1: ruleVType returns [Enumerator current=null] : ( (enumLiteral_0= 'STRING' ) | (enumLiteral_1= 'UINT32' ) | (enumLiteral_2= 'INT32' ) | (enumLiteral_3= 'UINT64' ) | (enumLiteral_4= 'INT64' ) | (enumLiteral_5= 'FLOAT' ) ) ;
    public final Enumerator ruleVType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;

         enterRule(); 
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2117:28: ( ( (enumLiteral_0= 'STRING' ) | (enumLiteral_1= 'UINT32' ) | (enumLiteral_2= 'INT32' ) | (enumLiteral_3= 'UINT64' ) | (enumLiteral_4= 'INT64' ) | (enumLiteral_5= 'FLOAT' ) ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2118:1: ( (enumLiteral_0= 'STRING' ) | (enumLiteral_1= 'UINT32' ) | (enumLiteral_2= 'INT32' ) | (enumLiteral_3= 'UINT64' ) | (enumLiteral_4= 'INT64' ) | (enumLiteral_5= 'FLOAT' ) )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2118:1: ( (enumLiteral_0= 'STRING' ) | (enumLiteral_1= 'UINT32' ) | (enumLiteral_2= 'INT32' ) | (enumLiteral_3= 'UINT64' ) | (enumLiteral_4= 'INT64' ) | (enumLiteral_5= 'FLOAT' ) )
            int alt51=6;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt51=1;
                }
                break;
            case 30:
                {
                alt51=2;
                }
                break;
            case 31:
                {
                alt51=3;
                }
                break;
            case 32:
                {
                alt51=4;
                }
                break;
            case 33:
                {
                alt51=5;
                }
                break;
            case 34:
                {
                alt51=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2118:2: (enumLiteral_0= 'STRING' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2118:2: (enumLiteral_0= 'STRING' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2118:4: enumLiteral_0= 'STRING'
                    {
                    enumLiteral_0=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleVType4820); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVTypeAccess().getSTRINGEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getVTypeAccess().getSTRINGEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2124:6: (enumLiteral_1= 'UINT32' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2124:6: (enumLiteral_1= 'UINT32' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2124:8: enumLiteral_1= 'UINT32'
                    {
                    enumLiteral_1=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleVType4837); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVTypeAccess().getUINT32EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getVTypeAccess().getUINT32EnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2130:6: (enumLiteral_2= 'INT32' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2130:6: (enumLiteral_2= 'INT32' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2130:8: enumLiteral_2= 'INT32'
                    {
                    enumLiteral_2=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleVType4854); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVTypeAccess().getINT32EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getVTypeAccess().getINT32EnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2136:6: (enumLiteral_3= 'UINT64' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2136:6: (enumLiteral_3= 'UINT64' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2136:8: enumLiteral_3= 'UINT64'
                    {
                    enumLiteral_3=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleVType4871); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVTypeAccess().getUINT64EnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getVTypeAccess().getUINT64EnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2142:6: (enumLiteral_4= 'INT64' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2142:6: (enumLiteral_4= 'INT64' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2142:8: enumLiteral_4= 'INT64'
                    {
                    enumLiteral_4=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleVType4888); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVTypeAccess().getINT64EnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getVTypeAccess().getINT64EnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2148:6: (enumLiteral_5= 'FLOAT' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2148:6: (enumLiteral_5= 'FLOAT' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2148:8: enumLiteral_5= 'FLOAT'
                    {
                    enumLiteral_5=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleVType4905); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVTypeAccess().getFLOATEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getVTypeAccess().getFLOATEnumLiteralDeclaration_5()); 
                          
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2158:1: ruleEType returns [Enumerator current=null] : ( (enumLiteral_0= 'BOOLEAN' ) | (enumLiteral_1= 'ENUM' ) ) ;
    public final Enumerator ruleEType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2160:28: ( ( (enumLiteral_0= 'BOOLEAN' ) | (enumLiteral_1= 'ENUM' ) ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2161:1: ( (enumLiteral_0= 'BOOLEAN' ) | (enumLiteral_1= 'ENUM' ) )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2161:1: ( (enumLiteral_0= 'BOOLEAN' ) | (enumLiteral_1= 'ENUM' ) )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==35) ) {
                alt52=1;
            }
            else if ( (LA52_0==36) ) {
                alt52=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2161:2: (enumLiteral_0= 'BOOLEAN' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2161:2: (enumLiteral_0= 'BOOLEAN' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2161:4: enumLiteral_0= 'BOOLEAN'
                    {
                    enumLiteral_0=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleEType4950); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getETypeAccess().getBOOLEANEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getETypeAccess().getBOOLEANEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2167:6: (enumLiteral_1= 'ENUM' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2167:6: (enumLiteral_1= 'ENUM' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2167:8: enumLiteral_1= 'ENUM'
                    {
                    enumLiteral_1=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleEType4967); if (state.failed) return current;
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2177:1: ruleObjectType returns [Enumerator current=null] : ( (enumLiteral_0= 'OS' ) | (enumLiteral_1= 'ALARM' ) | (enumLiteral_2= 'APPMODE' ) | (enumLiteral_3= 'COUNTER' ) | (enumLiteral_4= 'COM' ) | (enumLiteral_5= 'EVENT' ) | (enumLiteral_6= 'IPDU' ) | (enumLiteral_7= 'ISR' ) | (enumLiteral_8= 'MESSAGE' ) | (enumLiteral_9= 'NETWORKMESSAGE' ) | (enumLiteral_10= 'NM' ) | (enumLiteral_11= 'RESOURCE' ) | (enumLiteral_12= 'TASK' ) | (enumLiteral_13= 'APPLICATION' ) | (enumLiteral_14= 'SPINLOCK' ) | (enumLiteral_15= 'SCHEDULETABLE' ) ) ;
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
        Token enumLiteral_14=null;
        Token enumLiteral_15=null;

         enterRule(); 
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2179:28: ( ( (enumLiteral_0= 'OS' ) | (enumLiteral_1= 'ALARM' ) | (enumLiteral_2= 'APPMODE' ) | (enumLiteral_3= 'COUNTER' ) | (enumLiteral_4= 'COM' ) | (enumLiteral_5= 'EVENT' ) | (enumLiteral_6= 'IPDU' ) | (enumLiteral_7= 'ISR' ) | (enumLiteral_8= 'MESSAGE' ) | (enumLiteral_9= 'NETWORKMESSAGE' ) | (enumLiteral_10= 'NM' ) | (enumLiteral_11= 'RESOURCE' ) | (enumLiteral_12= 'TASK' ) | (enumLiteral_13= 'APPLICATION' ) | (enumLiteral_14= 'SPINLOCK' ) | (enumLiteral_15= 'SCHEDULETABLE' ) ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2180:1: ( (enumLiteral_0= 'OS' ) | (enumLiteral_1= 'ALARM' ) | (enumLiteral_2= 'APPMODE' ) | (enumLiteral_3= 'COUNTER' ) | (enumLiteral_4= 'COM' ) | (enumLiteral_5= 'EVENT' ) | (enumLiteral_6= 'IPDU' ) | (enumLiteral_7= 'ISR' ) | (enumLiteral_8= 'MESSAGE' ) | (enumLiteral_9= 'NETWORKMESSAGE' ) | (enumLiteral_10= 'NM' ) | (enumLiteral_11= 'RESOURCE' ) | (enumLiteral_12= 'TASK' ) | (enumLiteral_13= 'APPLICATION' ) | (enumLiteral_14= 'SPINLOCK' ) | (enumLiteral_15= 'SCHEDULETABLE' ) )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2180:1: ( (enumLiteral_0= 'OS' ) | (enumLiteral_1= 'ALARM' ) | (enumLiteral_2= 'APPMODE' ) | (enumLiteral_3= 'COUNTER' ) | (enumLiteral_4= 'COM' ) | (enumLiteral_5= 'EVENT' ) | (enumLiteral_6= 'IPDU' ) | (enumLiteral_7= 'ISR' ) | (enumLiteral_8= 'MESSAGE' ) | (enumLiteral_9= 'NETWORKMESSAGE' ) | (enumLiteral_10= 'NM' ) | (enumLiteral_11= 'RESOURCE' ) | (enumLiteral_12= 'TASK' ) | (enumLiteral_13= 'APPLICATION' ) | (enumLiteral_14= 'SPINLOCK' ) | (enumLiteral_15= 'SCHEDULETABLE' ) )
            int alt53=16;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt53=1;
                }
                break;
            case 38:
                {
                alt53=2;
                }
                break;
            case 39:
                {
                alt53=3;
                }
                break;
            case 40:
                {
                alt53=4;
                }
                break;
            case 41:
                {
                alt53=5;
                }
                break;
            case 42:
                {
                alt53=6;
                }
                break;
            case 43:
                {
                alt53=7;
                }
                break;
            case 44:
                {
                alt53=8;
                }
                break;
            case 45:
                {
                alt53=9;
                }
                break;
            case 46:
                {
                alt53=10;
                }
                break;
            case 47:
                {
                alt53=11;
                }
                break;
            case 48:
                {
                alt53=12;
                }
                break;
            case 49:
                {
                alt53=13;
                }
                break;
            case 70:
                {
                alt53=14;
                }
                break;
            case 50:
                {
                alt53=15;
                }
                break;
            case 51:
                {
                alt53=16;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }

            switch (alt53) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2180:2: (enumLiteral_0= 'OS' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2180:2: (enumLiteral_0= 'OS' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2180:4: enumLiteral_0= 'OS'
                    {
                    enumLiteral_0=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleObjectType5012); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getOSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getObjectTypeAccess().getOSEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2186:6: (enumLiteral_1= 'ALARM' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2186:6: (enumLiteral_1= 'ALARM' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2186:8: enumLiteral_1= 'ALARM'
                    {
                    enumLiteral_1=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleObjectType5029); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getALARMEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getObjectTypeAccess().getALARMEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2192:6: (enumLiteral_2= 'APPMODE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2192:6: (enumLiteral_2= 'APPMODE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2192:8: enumLiteral_2= 'APPMODE'
                    {
                    enumLiteral_2=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleObjectType5046); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getAPPMODEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getObjectTypeAccess().getAPPMODEEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2198:6: (enumLiteral_3= 'COUNTER' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2198:6: (enumLiteral_3= 'COUNTER' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2198:8: enumLiteral_3= 'COUNTER'
                    {
                    enumLiteral_3=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleObjectType5063); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getCOUNTEREnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getObjectTypeAccess().getCOUNTEREnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2204:6: (enumLiteral_4= 'COM' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2204:6: (enumLiteral_4= 'COM' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2204:8: enumLiteral_4= 'COM'
                    {
                    enumLiteral_4=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleObjectType5080); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getCOMEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getObjectTypeAccess().getCOMEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2210:6: (enumLiteral_5= 'EVENT' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2210:6: (enumLiteral_5= 'EVENT' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2210:8: enumLiteral_5= 'EVENT'
                    {
                    enumLiteral_5=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleObjectType5097); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getEVENTEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getObjectTypeAccess().getEVENTEnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2216:6: (enumLiteral_6= 'IPDU' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2216:6: (enumLiteral_6= 'IPDU' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2216:8: enumLiteral_6= 'IPDU'
                    {
                    enumLiteral_6=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleObjectType5114); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getIPDUEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_6, grammarAccess.getObjectTypeAccess().getIPDUEnumLiteralDeclaration_6()); 
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2222:6: (enumLiteral_7= 'ISR' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2222:6: (enumLiteral_7= 'ISR' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2222:8: enumLiteral_7= 'ISR'
                    {
                    enumLiteral_7=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleObjectType5131); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getISREnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_7, grammarAccess.getObjectTypeAccess().getISREnumLiteralDeclaration_7()); 
                          
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2228:6: (enumLiteral_8= 'MESSAGE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2228:6: (enumLiteral_8= 'MESSAGE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2228:8: enumLiteral_8= 'MESSAGE'
                    {
                    enumLiteral_8=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleObjectType5148); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getMESSAGEEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_8, grammarAccess.getObjectTypeAccess().getMESSAGEEnumLiteralDeclaration_8()); 
                          
                    }

                    }


                    }
                    break;
                case 10 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2234:6: (enumLiteral_9= 'NETWORKMESSAGE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2234:6: (enumLiteral_9= 'NETWORKMESSAGE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2234:8: enumLiteral_9= 'NETWORKMESSAGE'
                    {
                    enumLiteral_9=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleObjectType5165); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getNETWORKMESSAGEEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_9, grammarAccess.getObjectTypeAccess().getNETWORKMESSAGEEnumLiteralDeclaration_9()); 
                          
                    }

                    }


                    }
                    break;
                case 11 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2240:6: (enumLiteral_10= 'NM' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2240:6: (enumLiteral_10= 'NM' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2240:8: enumLiteral_10= 'NM'
                    {
                    enumLiteral_10=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleObjectType5182); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getNMEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_10, grammarAccess.getObjectTypeAccess().getNMEnumLiteralDeclaration_10()); 
                          
                    }

                    }


                    }
                    break;
                case 12 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2246:6: (enumLiteral_11= 'RESOURCE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2246:6: (enumLiteral_11= 'RESOURCE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2246:8: enumLiteral_11= 'RESOURCE'
                    {
                    enumLiteral_11=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleObjectType5199); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getRESOURCEEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_11, grammarAccess.getObjectTypeAccess().getRESOURCEEnumLiteralDeclaration_11()); 
                          
                    }

                    }


                    }
                    break;
                case 13 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2252:6: (enumLiteral_12= 'TASK' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2252:6: (enumLiteral_12= 'TASK' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2252:8: enumLiteral_12= 'TASK'
                    {
                    enumLiteral_12=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleObjectType5216); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getTASKEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_12, grammarAccess.getObjectTypeAccess().getTASKEnumLiteralDeclaration_12()); 
                          
                    }

                    }


                    }
                    break;
                case 14 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2258:6: (enumLiteral_13= 'APPLICATION' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2258:6: (enumLiteral_13= 'APPLICATION' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2258:8: enumLiteral_13= 'APPLICATION'
                    {
                    enumLiteral_13=(Token)match(input,70,FollowSets000.FOLLOW_70_in_ruleObjectType5233); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getAPPLICATIONEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_13, grammarAccess.getObjectTypeAccess().getAPPLICATIONEnumLiteralDeclaration_13()); 
                          
                    }

                    }


                    }
                    break;
                case 15 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2264:6: (enumLiteral_14= 'SPINLOCK' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2264:6: (enumLiteral_14= 'SPINLOCK' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2264:8: enumLiteral_14= 'SPINLOCK'
                    {
                    enumLiteral_14=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleObjectType5250); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getSPINLOCKEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_14, grammarAccess.getObjectTypeAccess().getSPINLOCKEnumLiteralDeclaration_14()); 
                          
                    }

                    }


                    }
                    break;
                case 16 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2270:6: (enumLiteral_15= 'SCHEDULETABLE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2270:6: (enumLiteral_15= 'SCHEDULETABLE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2270:8: enumLiteral_15= 'SCHEDULETABLE'
                    {
                    enumLiteral_15=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleObjectType5267); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getSCHEDULETABLEEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_15, grammarAccess.getObjectTypeAccess().getSCHEDULETABLEEnumLiteralDeclaration_15()); 
                          
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2280:1: ruleObjectTypeRef returns [Enumerator current=null] : ( (enumLiteral_0= 'OS_TYPE' ) | (enumLiteral_1= 'ALARM_TYPE' ) | (enumLiteral_2= 'APPMODE_TYPE' ) | (enumLiteral_3= 'COUNTER_TYPE' ) | (enumLiteral_4= 'COM_TYPE' ) | (enumLiteral_5= 'EVENT_TYPE' ) | (enumLiteral_6= 'IPDU_TYPE' ) | (enumLiteral_7= 'ISR_TYPE' ) | (enumLiteral_8= 'MESSAGE_TYPE' ) | (enumLiteral_9= 'NETWORKMESSAGE_TYPE' ) | (enumLiteral_10= 'NM_TYPE' ) | (enumLiteral_11= 'RESOURCE_TYPE' ) | (enumLiteral_12= 'TASK_TYPE' ) | (enumLiteral_13= 'APPLICATION_TYPE' ) | (enumLiteral_14= 'SPINLOCK_TYPE' ) | (enumLiteral_15= 'SCHEDULETABLE_TYPE' ) ) ;
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
        Token enumLiteral_14=null;
        Token enumLiteral_15=null;

         enterRule(); 
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2282:28: ( ( (enumLiteral_0= 'OS_TYPE' ) | (enumLiteral_1= 'ALARM_TYPE' ) | (enumLiteral_2= 'APPMODE_TYPE' ) | (enumLiteral_3= 'COUNTER_TYPE' ) | (enumLiteral_4= 'COM_TYPE' ) | (enumLiteral_5= 'EVENT_TYPE' ) | (enumLiteral_6= 'IPDU_TYPE' ) | (enumLiteral_7= 'ISR_TYPE' ) | (enumLiteral_8= 'MESSAGE_TYPE' ) | (enumLiteral_9= 'NETWORKMESSAGE_TYPE' ) | (enumLiteral_10= 'NM_TYPE' ) | (enumLiteral_11= 'RESOURCE_TYPE' ) | (enumLiteral_12= 'TASK_TYPE' ) | (enumLiteral_13= 'APPLICATION_TYPE' ) | (enumLiteral_14= 'SPINLOCK_TYPE' ) | (enumLiteral_15= 'SCHEDULETABLE_TYPE' ) ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2283:1: ( (enumLiteral_0= 'OS_TYPE' ) | (enumLiteral_1= 'ALARM_TYPE' ) | (enumLiteral_2= 'APPMODE_TYPE' ) | (enumLiteral_3= 'COUNTER_TYPE' ) | (enumLiteral_4= 'COM_TYPE' ) | (enumLiteral_5= 'EVENT_TYPE' ) | (enumLiteral_6= 'IPDU_TYPE' ) | (enumLiteral_7= 'ISR_TYPE' ) | (enumLiteral_8= 'MESSAGE_TYPE' ) | (enumLiteral_9= 'NETWORKMESSAGE_TYPE' ) | (enumLiteral_10= 'NM_TYPE' ) | (enumLiteral_11= 'RESOURCE_TYPE' ) | (enumLiteral_12= 'TASK_TYPE' ) | (enumLiteral_13= 'APPLICATION_TYPE' ) | (enumLiteral_14= 'SPINLOCK_TYPE' ) | (enumLiteral_15= 'SCHEDULETABLE_TYPE' ) )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2283:1: ( (enumLiteral_0= 'OS_TYPE' ) | (enumLiteral_1= 'ALARM_TYPE' ) | (enumLiteral_2= 'APPMODE_TYPE' ) | (enumLiteral_3= 'COUNTER_TYPE' ) | (enumLiteral_4= 'COM_TYPE' ) | (enumLiteral_5= 'EVENT_TYPE' ) | (enumLiteral_6= 'IPDU_TYPE' ) | (enumLiteral_7= 'ISR_TYPE' ) | (enumLiteral_8= 'MESSAGE_TYPE' ) | (enumLiteral_9= 'NETWORKMESSAGE_TYPE' ) | (enumLiteral_10= 'NM_TYPE' ) | (enumLiteral_11= 'RESOURCE_TYPE' ) | (enumLiteral_12= 'TASK_TYPE' ) | (enumLiteral_13= 'APPLICATION_TYPE' ) | (enumLiteral_14= 'SPINLOCK_TYPE' ) | (enumLiteral_15= 'SCHEDULETABLE_TYPE' ) )
            int alt54=16;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt54=1;
                }
                break;
            case 53:
                {
                alt54=2;
                }
                break;
            case 54:
                {
                alt54=3;
                }
                break;
            case 55:
                {
                alt54=4;
                }
                break;
            case 56:
                {
                alt54=5;
                }
                break;
            case 57:
                {
                alt54=6;
                }
                break;
            case 58:
                {
                alt54=7;
                }
                break;
            case 59:
                {
                alt54=8;
                }
                break;
            case 60:
                {
                alt54=9;
                }
                break;
            case 61:
                {
                alt54=10;
                }
                break;
            case 62:
                {
                alt54=11;
                }
                break;
            case 63:
                {
                alt54=12;
                }
                break;
            case 64:
                {
                alt54=13;
                }
                break;
            case 71:
                {
                alt54=14;
                }
                break;
            case 65:
                {
                alt54=15;
                }
                break;
            case 66:
                {
                alt54=16;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }

            switch (alt54) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2283:2: (enumLiteral_0= 'OS_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2283:2: (enumLiteral_0= 'OS_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2283:4: enumLiteral_0= 'OS_TYPE'
                    {
                    enumLiteral_0=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleObjectTypeRef5312); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getOSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getObjectTypeRefAccess().getOSEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2289:6: (enumLiteral_1= 'ALARM_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2289:6: (enumLiteral_1= 'ALARM_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2289:8: enumLiteral_1= 'ALARM_TYPE'
                    {
                    enumLiteral_1=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleObjectTypeRef5329); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getALARMEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getObjectTypeRefAccess().getALARMEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2295:6: (enumLiteral_2= 'APPMODE_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2295:6: (enumLiteral_2= 'APPMODE_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2295:8: enumLiteral_2= 'APPMODE_TYPE'
                    {
                    enumLiteral_2=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleObjectTypeRef5346); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getAPPMODEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getObjectTypeRefAccess().getAPPMODEEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2301:6: (enumLiteral_3= 'COUNTER_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2301:6: (enumLiteral_3= 'COUNTER_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2301:8: enumLiteral_3= 'COUNTER_TYPE'
                    {
                    enumLiteral_3=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleObjectTypeRef5363); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getCOUNTEREnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getObjectTypeRefAccess().getCOUNTEREnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2307:6: (enumLiteral_4= 'COM_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2307:6: (enumLiteral_4= 'COM_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2307:8: enumLiteral_4= 'COM_TYPE'
                    {
                    enumLiteral_4=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleObjectTypeRef5380); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getCOMEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getObjectTypeRefAccess().getCOMEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2313:6: (enumLiteral_5= 'EVENT_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2313:6: (enumLiteral_5= 'EVENT_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2313:8: enumLiteral_5= 'EVENT_TYPE'
                    {
                    enumLiteral_5=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleObjectTypeRef5397); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getEVENTEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getObjectTypeRefAccess().getEVENTEnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2319:6: (enumLiteral_6= 'IPDU_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2319:6: (enumLiteral_6= 'IPDU_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2319:8: enumLiteral_6= 'IPDU_TYPE'
                    {
                    enumLiteral_6=(Token)match(input,58,FollowSets000.FOLLOW_58_in_ruleObjectTypeRef5414); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getIPDUEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_6, grammarAccess.getObjectTypeRefAccess().getIPDUEnumLiteralDeclaration_6()); 
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2325:6: (enumLiteral_7= 'ISR_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2325:6: (enumLiteral_7= 'ISR_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2325:8: enumLiteral_7= 'ISR_TYPE'
                    {
                    enumLiteral_7=(Token)match(input,59,FollowSets000.FOLLOW_59_in_ruleObjectTypeRef5431); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getISREnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_7, grammarAccess.getObjectTypeRefAccess().getISREnumLiteralDeclaration_7()); 
                          
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2331:6: (enumLiteral_8= 'MESSAGE_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2331:6: (enumLiteral_8= 'MESSAGE_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2331:8: enumLiteral_8= 'MESSAGE_TYPE'
                    {
                    enumLiteral_8=(Token)match(input,60,FollowSets000.FOLLOW_60_in_ruleObjectTypeRef5448); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getMESSAGEEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_8, grammarAccess.getObjectTypeRefAccess().getMESSAGEEnumLiteralDeclaration_8()); 
                          
                    }

                    }


                    }
                    break;
                case 10 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2337:6: (enumLiteral_9= 'NETWORKMESSAGE_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2337:6: (enumLiteral_9= 'NETWORKMESSAGE_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2337:8: enumLiteral_9= 'NETWORKMESSAGE_TYPE'
                    {
                    enumLiteral_9=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleObjectTypeRef5465); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getNETWORKMESSAGEEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_9, grammarAccess.getObjectTypeRefAccess().getNETWORKMESSAGEEnumLiteralDeclaration_9()); 
                          
                    }

                    }


                    }
                    break;
                case 11 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2343:6: (enumLiteral_10= 'NM_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2343:6: (enumLiteral_10= 'NM_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2343:8: enumLiteral_10= 'NM_TYPE'
                    {
                    enumLiteral_10=(Token)match(input,62,FollowSets000.FOLLOW_62_in_ruleObjectTypeRef5482); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getNMEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_10, grammarAccess.getObjectTypeRefAccess().getNMEnumLiteralDeclaration_10()); 
                          
                    }

                    }


                    }
                    break;
                case 12 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2349:6: (enumLiteral_11= 'RESOURCE_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2349:6: (enumLiteral_11= 'RESOURCE_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2349:8: enumLiteral_11= 'RESOURCE_TYPE'
                    {
                    enumLiteral_11=(Token)match(input,63,FollowSets000.FOLLOW_63_in_ruleObjectTypeRef5499); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getRESOURCEEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_11, grammarAccess.getObjectTypeRefAccess().getRESOURCEEnumLiteralDeclaration_11()); 
                          
                    }

                    }


                    }
                    break;
                case 13 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2355:6: (enumLiteral_12= 'TASK_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2355:6: (enumLiteral_12= 'TASK_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2355:8: enumLiteral_12= 'TASK_TYPE'
                    {
                    enumLiteral_12=(Token)match(input,64,FollowSets000.FOLLOW_64_in_ruleObjectTypeRef5516); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getTASKEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_12, grammarAccess.getObjectTypeRefAccess().getTASKEnumLiteralDeclaration_12()); 
                          
                    }

                    }


                    }
                    break;
                case 14 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2361:6: (enumLiteral_13= 'APPLICATION_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2361:6: (enumLiteral_13= 'APPLICATION_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2361:8: enumLiteral_13= 'APPLICATION_TYPE'
                    {
                    enumLiteral_13=(Token)match(input,71,FollowSets000.FOLLOW_71_in_ruleObjectTypeRef5533); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getAPPLICATIONEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_13, grammarAccess.getObjectTypeRefAccess().getAPPLICATIONEnumLiteralDeclaration_13()); 
                          
                    }

                    }


                    }
                    break;
                case 15 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2367:6: (enumLiteral_14= 'SPINLOCK_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2367:6: (enumLiteral_14= 'SPINLOCK_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2367:8: enumLiteral_14= 'SPINLOCK_TYPE'
                    {
                    enumLiteral_14=(Token)match(input,65,FollowSets000.FOLLOW_65_in_ruleObjectTypeRef5550); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getSPINLOCKEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_14, grammarAccess.getObjectTypeRefAccess().getSPINLOCKEnumLiteralDeclaration_14()); 
                          
                    }

                    }


                    }
                    break;
                case 16 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2373:6: (enumLiteral_15= 'SCHEDULETABLE_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2373:6: (enumLiteral_15= 'SCHEDULETABLE_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:2373:8: enumLiteral_15= 'SCHEDULETABLE_TYPE'
                    {
                    enumLiteral_15=(Token)match(input,66,FollowSets000.FOLLOW_66_in_ruleObjectTypeRef5567); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getSCHEDULETABLEEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_15, grammarAccess.getObjectTypeRefAccess().getSCHEDULETABLEEnumLiteralDeclaration_15()); 
                          
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
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:759:3: ( ( 'AUTO' ) )
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:760:1: ( 'AUTO' )
        {
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:760:1: ( 'AUTO' )
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:761:2: 'AUTO'
        {
        match(input,28,FollowSets000.FOLLOW_28_in_synpred1_InternalOil1573); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred1_InternalOil

    // $ANTLR start synpred2_InternalOil
    public final void synpred2_InternalOil_fragment() throws RecognitionException {   
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:988:3: ( ( 'AUTO' ) )
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:989:1: ( 'AUTO' )
        {
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:989:1: ( 'AUTO' )
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:990:2: 'AUTO'
        {
        match(input,28,FollowSets000.FOLLOW_28_in_synpred2_InternalOil2010); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred2_InternalOil

    // $ANTLR start synpred3_InternalOil
    public final void synpred3_InternalOil_fragment() throws RecognitionException {   
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1229:3: ( ( 'AUTO' ) )
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1230:1: ( 'AUTO' )
        {
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1230:1: ( 'AUTO' )
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1231:2: 'AUTO'
        {
        match(input,28,FollowSets000.FOLLOW_28_in_synpred3_InternalOil2491); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred3_InternalOil

    // $ANTLR start synpred4_InternalOil
    public final void synpred4_InternalOil_fragment() throws RecognitionException {   
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1450:3: ( ( 'AUTO' ) )
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1451:1: ( 'AUTO' )
        {
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1451:1: ( 'AUTO' )
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1452:2: 'AUTO'
        {
        match(input,28,FollowSets000.FOLLOW_28_in_synpred4_InternalOil2945); if (state.failed) return ;

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


    protected DFA10 dfa10 = new DFA10(this);
    protected DFA42 dfa42 = new DFA42(this);
    protected DFA43 dfa43 = new DFA43(this);
    static final String DFA10_eotS =
        "\15\uffff";
    static final String DFA10_eofS =
        "\3\uffff\5\10\3\uffff\2\10";
    static final String DFA10_minS =
        "\4\6\2\26\2\6\1\uffff\1\6\1\uffff\2\6";
    static final String DFA10_maxS =
        "\1\104\2\10\2\105\1\32\2\105\1\uffff\1\7\1\uffff\2\32";
    static final String DFA10_acceptS =
        "\10\uffff\1\2\1\uffff\1\1\2\uffff";
    static final String DFA10_specialS =
        "\15\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\3\1\4\1\5\72\uffff\1\1\1\2",
            "\1\3\1\4\1\5",
            "\1\3\1\4\1\5",
            "\1\7\1\6\16\uffff\1\10\1\12\2\uffff\1\10\52\uffff\1\11",
            "\1\10\1\12\2\uffff\1\10\52\uffff\1\11",
            "\1\10\1\12\2\uffff\1\10",
            "\1\7\1\6\16\uffff\1\10\1\12\2\uffff\1\10\52\uffff\1\11",
            "\1\7\1\6\16\uffff\1\10\1\12\2\uffff\1\10\52\uffff\1\11",
            "",
            "\1\14\1\13",
            "",
            "\1\14\1\13\16\uffff\1\10\1\12\2\uffff\1\10",
            "\1\14\1\13\16\uffff\1\10\1\12\2\uffff\1\10"
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "483:1: (this_Range_0= ruleRange | this_ValueList_1= ruleValueList )";
        }
    }
    static final String DFA42_eotS =
        "\12\uffff";
    static final String DFA42_eofS =
        "\4\uffff\2\6\1\uffff\2\6\1\uffff";
    static final String DFA42_minS =
        "\1\4\1\uffff\3\6\1\20\1\uffff\2\6\1\uffff";
    static final String DFA42_maxS =
        "\1\104\1\uffff\2\10\2\105\1\uffff\2\105\1\uffff";
    static final String DFA42_acceptS =
        "\1\uffff\1\1\4\uffff\1\2\2\uffff\1\3";
    static final String DFA42_specialS =
        "\12\uffff}>";
    static final String[] DFA42_transitionS = {
            "\1\1\1\uffff\1\4\1\5\1\6\72\uffff\1\2\1\3",
            "",
            "\1\4\1\5\1\6",
            "\1\4\1\5\1\6",
            "\1\10\1\7\10\uffff\1\6\1\uffff\1\6\1\uffff\1\6\60\uffff\1"+
            "\11",
            "\1\6\1\uffff\1\6\1\uffff\1\6\60\uffff\1\11",
            "",
            "\1\10\1\7\10\uffff\1\6\1\uffff\1\6\1\uffff\1\6\60\uffff\1"+
            "\11",
            "\1\10\1\7\10\uffff\1\6\1\uffff\1\6\1\uffff\1\6\60\uffff\1"+
            "\11",
            ""
    };

    static final short[] DFA42_eot = DFA.unpackEncodedString(DFA42_eotS);
    static final short[] DFA42_eof = DFA.unpackEncodedString(DFA42_eofS);
    static final char[] DFA42_min = DFA.unpackEncodedStringToUnsignedChars(DFA42_minS);
    static final char[] DFA42_max = DFA.unpackEncodedStringToUnsignedChars(DFA42_maxS);
    static final short[] DFA42_accept = DFA.unpackEncodedString(DFA42_acceptS);
    static final short[] DFA42_special = DFA.unpackEncodedString(DFA42_specialS);
    static final short[][] DFA42_transition;

    static {
        int numStates = DFA42_transitionS.length;
        DFA42_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA42_transition[i] = DFA.unpackEncodedString(DFA42_transitionS[i]);
        }
    }

    class DFA42 extends DFA {

        public DFA42(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 42;
            this.eot = DFA42_eot;
            this.eof = DFA42_eof;
            this.min = DFA42_min;
            this.max = DFA42_max;
            this.accept = DFA42_accept;
            this.special = DFA42_special;
            this.transition = DFA42_transition;
        }
        public String getDescription() {
            return "1873:1: (this_STRING_0= RULE_STRING | this_INT_1= ruleINT | this_FLOAT_2= ruleFLOAT )";
        }
    }
    static final String DFA43_eotS =
        "\11\uffff";
    static final String DFA43_eofS =
        "\3\uffff\2\5\1\uffff\2\5\1\uffff";
    static final String DFA43_minS =
        "\4\6\1\26\1\uffff\2\6\1\uffff";
    static final String DFA43_maxS =
        "\1\104\2\10\2\105\1\uffff\2\105\1\uffff";
    static final String DFA43_acceptS =
        "\5\uffff\1\1\2\uffff\1\2";
    static final String DFA43_specialS =
        "\11\uffff}>";
    static final String[] DFA43_transitionS = {
            "\1\3\1\4\1\5\72\uffff\1\1\1\2",
            "\1\3\1\4\1\5",
            "\1\3\1\4\1\5",
            "\1\7\1\6\16\uffff\2\5\2\uffff\1\5\52\uffff\1\10",
            "\2\5\2\uffff\1\5\52\uffff\1\10",
            "",
            "\1\7\1\6\16\uffff\2\5\2\uffff\1\5\52\uffff\1\10",
            "\1\7\1\6\16\uffff\2\5\2\uffff\1\5\52\uffff\1\10",
            ""
    };

    static final short[] DFA43_eot = DFA.unpackEncodedString(DFA43_eotS);
    static final short[] DFA43_eof = DFA.unpackEncodedString(DFA43_eofS);
    static final char[] DFA43_min = DFA.unpackEncodedStringToUnsignedChars(DFA43_minS);
    static final char[] DFA43_max = DFA.unpackEncodedStringToUnsignedChars(DFA43_maxS);
    static final short[] DFA43_accept = DFA.unpackEncodedString(DFA43_acceptS);
    static final short[] DFA43_special = DFA.unpackEncodedString(DFA43_specialS);
    static final short[][] DFA43_transition;

    static {
        int numStates = DFA43_transitionS.length;
        DFA43_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA43_transition[i] = DFA.unpackEncodedString(DFA43_transitionS[i]);
        }
    }

    class DFA43 extends DFA {

        public DFA43(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 43;
            this.eot = DFA43_eot;
            this.eof = DFA43_eof;
            this.min = DFA43_min;
            this.max = DFA43_max;
            this.accept = DFA43_accept;
            this.special = DFA43_special;
            this.transition = DFA43_transition;
        }
        public String getDescription() {
            return "1925:1: (this_INT_0= ruleINT | this_FLOAT_1= ruleFLOAT )";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleOilFile_in_entryRuleOilFile75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOilFile85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleOilFile132 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleOilFile144 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleOilFile161 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleOilFile178 = new BitSet(new long[]{0x0000000000220002L});
        public static final BitSet FOLLOW_ruleOilImplementation_in_ruleOilFile201 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_ruleOilApplication_in_ruleOilFile223 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilImplementation_in_entryRuleOilImplementation260 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOilImplementation270 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleOilImplementation307 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOilImplementation324 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleOilImplementation341 = new BitSet(new long[]{0x000FFFE000080000L,0x0000000000000040L});
        public static final BitSet FOLLOW_ruleOilObjectImpl_in_ruleOilImplementation362 = new BitSet(new long[]{0x000FFFE000080000L,0x0000000000000040L});
        public static final BitSet FOLLOW_19_in_ruleOilImplementation375 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleOilImplementation387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilObjectImpl_in_entryRuleOilObjectImpl423 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOilObjectImpl433 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectType_in_ruleOilObjectImpl479 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleOilObjectImpl491 = new BitSet(new long[]{0xFFF0001FE0080000L,0x0000000000000087L});
        public static final BitSet FOLLOW_ruleParameterType_in_ruleOilObjectImpl512 = new BitSet(new long[]{0xFFF0001FE0080000L,0x0000000000000087L});
        public static final BitSet FOLLOW_19_in_ruleOilObjectImpl525 = new BitSet(new long[]{0x0000000000110000L});
        public static final BitSet FOLLOW_20_in_ruleOilObjectImpl538 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleOilObjectImpl555 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleOilObjectImpl574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilApplication_in_entryRuleOilApplication610 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOilApplication620 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleOilApplication657 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOilApplication674 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleOilApplication691 = new BitSet(new long[]{0x000FFFE000080000L,0x0000000000000040L});
        public static final BitSet FOLLOW_ruleOilObject_in_ruleOilApplication712 = new BitSet(new long[]{0x000FFFE000080000L,0x0000000000000040L});
        public static final BitSet FOLLOW_19_in_ruleOilApplication725 = new BitSet(new long[]{0x0000000000110000L});
        public static final BitSet FOLLOW_20_in_ruleOilApplication738 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleOilApplication755 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleOilApplication774 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameterType_in_entryRuleParameterType810 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParameterType820 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueType_in_ruleParameterType867 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariantType_in_ruleParameterType894 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceType_in_ruleParameterType921 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValidValues_in_entryRuleValidValues956 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleValidValues966 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRange_in_ruleValidValues1013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueList_in_ruleValidValues1040 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueList_in_entryRuleValueList1075 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleValueList1085 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGenericNumber_in_ruleValueList1140 = new BitSet(new long[]{0x0000000000400002L});
        public static final BitSet FOLLOW_22_in_ruleValueList1153 = new BitSet(new long[]{0x00000000000001C0L,0x0000000000000018L});
        public static final BitSet FOLLOW_ruleGenericNumber_in_ruleValueList1174 = new BitSet(new long[]{0x0000000000400002L});
        public static final BitSet FOLLOW_ruleRange_in_entryRuleRange1212 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRange1222 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGenericNumber_in_ruleRange1277 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleRange1289 = new BitSet(new long[]{0x00000000000001C0L,0x0000000000000018L});
        public static final BitSet FOLLOW_ruleGenericNumber_in_ruleRange1310 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueType_in_entryRuleValueType1346 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleValueType1356 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVType_in_ruleValueType1411 = new BitSet(new long[]{0xFFFFFFFFE3000020L,0x0000000000000007L});
        public static final BitSet FOLLOW_24_in_ruleValueType1429 = new BitSet(new long[]{0xFFFFFFFFE3000020L,0x0000000000000007L});
        public static final BitSet FOLLOW_25_in_ruleValueType1456 = new BitSet(new long[]{0x00000000000001C0L,0x0000000000000018L});
        public static final BitSet FOLLOW_ruleValidValues_in_ruleValueType1477 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleValueType1489 = new BitSet(new long[]{0xFFFFFFFFE3000020L,0x0000000000000007L});
        public static final BitSet FOLLOW_ruleSpecialId_in_ruleValueType1512 = new BitSet(new long[]{0x0000000008118000L});
        public static final BitSet FOLLOW_27_in_ruleValueType1530 = new BitSet(new long[]{0x0000000000118000L});
        public static final BitSet FOLLOW_15_in_ruleValueType1557 = new BitSet(new long[]{0x00000000100001F0L,0x0000000000000018L});
        public static final BitSet FOLLOW_28_in_ruleValueType1591 = new BitSet(new long[]{0x0000000000110000L});
        public static final BitSet FOLLOW_ruleGenericValue_in_ruleValueType1633 = new BitSet(new long[]{0x0000000000110000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleValueType1648 = new BitSet(new long[]{0x0000000000110000L});
        public static final BitSet FOLLOW_20_in_ruleValueType1672 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleValueType1689 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleValueType1708 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariantType_in_entryRuleVariantType1744 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVariantType1754 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEType_in_ruleVariantType1809 = new BitSet(new long[]{0xFFFFFFFFE3000020L,0x0000000000000007L});
        public static final BitSet FOLLOW_24_in_ruleVariantType1827 = new BitSet(new long[]{0xFFFFFFFFE3000020L,0x0000000000000007L});
        public static final BitSet FOLLOW_25_in_ruleVariantType1854 = new BitSet(new long[]{0xFFFFFFFFE7000020L,0x0000000000000007L});
        public static final BitSet FOLLOW_ruleEnumeratorType_in_ruleVariantType1876 = new BitSet(new long[]{0x0000000004400000L});
        public static final BitSet FOLLOW_22_in_ruleVariantType1889 = new BitSet(new long[]{0xFFFFFFFFE3000020L,0x0000000000000007L});
        public static final BitSet FOLLOW_ruleEnumeratorType_in_ruleVariantType1910 = new BitSet(new long[]{0x0000000004400000L});
        public static final BitSet FOLLOW_26_in_ruleVariantType1926 = new BitSet(new long[]{0xFFFFFFFFE3000020L,0x0000000000000007L});
        public static final BitSet FOLLOW_ruleSpecialId_in_ruleVariantType1949 = new BitSet(new long[]{0x0000000008118000L});
        public static final BitSet FOLLOW_27_in_ruleVariantType1967 = new BitSet(new long[]{0x0000000000118000L});
        public static final BitSet FOLLOW_15_in_ruleVariantType1994 = new BitSet(new long[]{0x0000000010000020L});
        public static final BitSet FOLLOW_28_in_ruleVariantType2028 = new BitSet(new long[]{0x0000000000110000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleVariantType2064 = new BitSet(new long[]{0x0000000000110000L});
        public static final BitSet FOLLOW_20_in_ruleVariantType2085 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleVariantType2102 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleVariantType2121 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumeratorType_in_entryRuleEnumeratorType2157 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumeratorType2167 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecialId_in_ruleEnumeratorType2222 = new BitSet(new long[]{0x0000000000140002L});
        public static final BitSet FOLLOW_18_in_ruleEnumeratorType2235 = new BitSet(new long[]{0xFFF0001FE0080000L,0x0000000000000087L});
        public static final BitSet FOLLOW_ruleParameterType_in_ruleEnumeratorType2256 = new BitSet(new long[]{0xFFF0001FE0080000L,0x0000000000000087L});
        public static final BitSet FOLLOW_19_in_ruleEnumeratorType2269 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_20_in_ruleEnumeratorType2284 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEnumeratorType2301 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceType_in_entryRuleReferenceType2344 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceType2354 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectTypeRef_in_ruleReferenceType2409 = new BitSet(new long[]{0xFFFFFFFFE3000020L,0x0000000000000007L});
        public static final BitSet FOLLOW_ruleSpecialId_in_ruleReferenceType2430 = new BitSet(new long[]{0x0000000008118000L});
        public static final BitSet FOLLOW_27_in_ruleReferenceType2448 = new BitSet(new long[]{0x0000000000118000L});
        public static final BitSet FOLLOW_15_in_ruleReferenceType2475 = new BitSet(new long[]{0x0000000010000020L});
        public static final BitSet FOLLOW_28_in_ruleReferenceType2509 = new BitSet(new long[]{0x0000000000110000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceType2545 = new BitSet(new long[]{0x0000000000110000L});
        public static final BitSet FOLLOW_20_in_ruleReferenceType2566 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleReferenceType2583 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleReferenceType2602 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilObject_in_entryRuleOilObject2638 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOilObject2648 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectType_in_ruleOilObject2694 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOilObject2711 = new BitSet(new long[]{0x0000000000150000L});
        public static final BitSet FOLLOW_18_in_ruleOilObject2729 = new BitSet(new long[]{0xFFFFFFFFE3080020L,0x0000000000000007L});
        public static final BitSet FOLLOW_ruleParameter_in_ruleOilObject2750 = new BitSet(new long[]{0xFFFFFFFFE3080020L,0x0000000000000007L});
        public static final BitSet FOLLOW_19_in_ruleOilObject2763 = new BitSet(new long[]{0x0000000000110000L});
        public static final BitSet FOLLOW_20_in_ruleOilObject2778 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleOilObject2795 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleOilObject2814 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter2850 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParameter2860 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecialId_in_ruleParameter2917 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleParameter2929 = new BitSet(new long[]{0xFFFFFFFFF30001F0L,0x000000000000001FL});
        public static final BitSet FOLLOW_28_in_ruleParameter2963 = new BitSet(new long[]{0x0000000000150000L});
        public static final BitSet FOLLOW_ruleGenericValue_in_ruleParameter3003 = new BitSet(new long[]{0x0000000000150000L});
        public static final BitSet FOLLOW_ruleSpecialId_in_ruleParameter3032 = new BitSet(new long[]{0x0000000000150000L});
        public static final BitSet FOLLOW_18_in_ruleParameter3046 = new BitSet(new long[]{0xFFFFFFFFE3080020L,0x0000000000000007L});
        public static final BitSet FOLLOW_ruleParameter_in_ruleParameter3067 = new BitSet(new long[]{0xFFFFFFFFE3080020L,0x0000000000000007L});
        public static final BitSet FOLLOW_19_in_ruleParameter3080 = new BitSet(new long[]{0x0000000000110000L});
        public static final BitSet FOLLOW_20_in_ruleParameter3095 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleParameter3112 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleParameter3131 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecialId_in_entryRuleSpecialId3168 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpecialId3179 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSpecialId3219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleSpecialId3243 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleSpecialId3262 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleSpecialId3281 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleSpecialId3300 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleSpecialId3319 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleSpecialId3338 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleSpecialId3357 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleSpecialId3376 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleSpecialId3395 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleSpecialId3414 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleSpecialId3433 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleSpecialId3452 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleSpecialId3471 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleSpecialId3490 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleSpecialId3509 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleSpecialId3528 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleSpecialId3547 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_ruleSpecialId3566 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_ruleSpecialId3585 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_ruleSpecialId3604 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_ruleSpecialId3623 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleSpecialId3642 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_ruleSpecialId3661 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_ruleSpecialId3680 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_ruleSpecialId3699 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_ruleSpecialId3718 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_ruleSpecialId3737 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_ruleSpecialId3756 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_ruleSpecialId3775 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_ruleSpecialId3794 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_59_in_ruleSpecialId3813 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_ruleSpecialId3832 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_ruleSpecialId3851 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_ruleSpecialId3870 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_63_in_ruleSpecialId3889 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_64_in_ruleSpecialId3908 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_ruleSpecialId3927 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_ruleSpecialId3946 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGenericValue_in_entryRuleGenericValue3987 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGenericValue3998 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleGenericValue4038 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleINT_in_ruleGenericValue4071 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFLOAT_in_ruleGenericValue4104 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGenericNumber_in_entryRuleGenericNumber4150 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGenericNumber4161 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleINT_in_ruleGenericNumber4208 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFLOAT_in_ruleGenericNumber4241 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleINT_in_entryRuleINT4287 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleINT4298 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_67_in_ruleINT4337 = new BitSet(new long[]{0x00000000000001C0L});
        public static final BitSet FOLLOW_68_in_ruleINT4356 = new BitSet(new long[]{0x00000000000001C0L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_ruleINT4375 = new BitSet(new long[]{0x00000000000000C2L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_ruleINT4396 = new BitSet(new long[]{0x00000000000000C2L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_ruleINT4422 = new BitSet(new long[]{0x00000000000000C2L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_ruleINT4451 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_HEX_in_ruleINT4477 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFLOAT_in_entryRuleFLOAT4524 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFLOAT4535 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_67_in_ruleFLOAT4574 = new BitSet(new long[]{0x00000000000000C0L});
        public static final BitSet FOLLOW_68_in_ruleFLOAT4593 = new BitSet(new long[]{0x00000000000000C0L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_ruleFLOAT4611 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_ruleFLOAT4638 = new BitSet(new long[]{0x00000000000000C0L,0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_ruleFLOAT4659 = new BitSet(new long[]{0x00000000000000C0L,0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_ruleFLOAT4685 = new BitSet(new long[]{0x00000000000000C0L,0x0000000000000020L});
        public static final BitSet FOLLOW_69_in_ruleFLOAT4716 = new BitSet(new long[]{0x00000000000000C0L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_ruleFLOAT4733 = new BitSet(new long[]{0x00000000000000C2L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_ruleFLOAT4759 = new BitSet(new long[]{0x00000000000000C2L});
        public static final BitSet FOLLOW_29_in_ruleVType4820 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleVType4837 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleVType4854 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleVType4871 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleVType4888 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleVType4905 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleEType4950 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleEType4967 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleObjectType5012 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleObjectType5029 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleObjectType5046 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleObjectType5063 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleObjectType5080 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleObjectType5097 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleObjectType5114 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleObjectType5131 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleObjectType5148 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_ruleObjectType5165 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_ruleObjectType5182 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_ruleObjectType5199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_ruleObjectType5216 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_70_in_ruleObjectType5233 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleObjectType5250 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_ruleObjectType5267 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_ruleObjectTypeRef5312 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_ruleObjectTypeRef5329 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_ruleObjectTypeRef5346 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_ruleObjectTypeRef5363 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_ruleObjectTypeRef5380 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_ruleObjectTypeRef5397 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_ruleObjectTypeRef5414 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_59_in_ruleObjectTypeRef5431 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_ruleObjectTypeRef5448 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_ruleObjectTypeRef5465 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_ruleObjectTypeRef5482 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_63_in_ruleObjectTypeRef5499 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_64_in_ruleObjectTypeRef5516 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_71_in_ruleObjectTypeRef5533 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_ruleObjectTypeRef5550 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_ruleObjectTypeRef5567 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_synpred1_InternalOil1573 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_synpred2_InternalOil2010 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_synpred3_InternalOil2491 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_synpred4_InternalOil2945 = new BitSet(new long[]{0x0000000000000002L});
    }


}