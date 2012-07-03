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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_NON_ZERO_INT", "RULE_ZERO_INT", "RULE_HEX", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'IMPLEMENTATION'", "'{'", "'}'", "';'", "':'", "'CPU'", "'WITH_AUTO'", "'[]'", "'='", "'AUTO'", "','", "'+'", "'-'", "'.'", "'STRING'", "'UINT32'", "'INT32'", "'UINT64'", "'INT64'", "'FLOAT'", "'DOUBLE'", "'BOOLEAN'", "'ENUM'", "'OS'", "'ALARM'", "'APPMODE'", "'COUNTER'", "'COM'", "'EVENT'", "'IPDU'", "'ISR'", "'MESSAGE'", "'NETWORKMESSAGE'", "'NM'", "'RESOURCE'", "'TASK'", "'OS_TYPE'", "'ALARM_TYPE'", "'APPMODE_TYPE'", "'COUNTER_TYPE'", "'COM_TYPE'", "'EVENT_TYPE'", "'IPDU_TYPE'", "'ISR_TYPE'", "'MESSAGE_TYPE'", "'NETWORKMESSAGE_TYPE'", "'NM_TYPE'", "'RESOURCE_TYPE'", "'TASK_TYPE'"
    };
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
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
    public static final int RULE_STRING=5;
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:77:1: ruleOilFile returns [EObject current=null] : ( ( (lv_Implementation_0_0= ruleOilImplementation ) )? ( (lv_Application_1_0= ruleOilApplication ) ) ) ;
    public final EObject ruleOilFile() throws RecognitionException {
        EObject current = null;

        EObject lv_Implementation_0_0 = null;

        EObject lv_Application_1_0 = null;


         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:80:28: ( ( ( (lv_Implementation_0_0= ruleOilImplementation ) )? ( (lv_Application_1_0= ruleOilApplication ) ) ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:81:1: ( ( (lv_Implementation_0_0= ruleOilImplementation ) )? ( (lv_Application_1_0= ruleOilApplication ) ) )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:81:1: ( ( (lv_Implementation_0_0= ruleOilImplementation ) )? ( (lv_Application_1_0= ruleOilApplication ) ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:81:2: ( (lv_Implementation_0_0= ruleOilImplementation ) )? ( (lv_Application_1_0= ruleOilApplication ) )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:81:2: ( (lv_Implementation_0_0= ruleOilImplementation ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==13) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:82:1: (lv_Implementation_0_0= ruleOilImplementation )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:82:1: (lv_Implementation_0_0= ruleOilImplementation )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:83:3: lv_Implementation_0_0= ruleOilImplementation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOilFileAccess().getImplementationOilImplementationParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleOilImplementation_in_ruleOilFile131);
                    lv_Implementation_0_0=ruleOilImplementation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getOilFileRule());
                      	        }
                             		set(
                             			current, 
                             			"Implementation",
                              		lv_Implementation_0_0, 
                              		"OilImplementation");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:99:3: ( (lv_Application_1_0= ruleOilApplication ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:100:1: (lv_Application_1_0= ruleOilApplication )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:100:1: (lv_Application_1_0= ruleOilApplication )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:101:3: lv_Application_1_0= ruleOilApplication
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOilFileAccess().getApplicationOilApplicationParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleOilApplication_in_ruleOilFile153);
            lv_Application_1_0=ruleOilApplication();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getOilFileRule());
              	        }
                     		set(
                     			current, 
                     			"Application",
                      		lv_Application_1_0, 
                      		"OilApplication");
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
    // $ANTLR end "ruleOilFile"


    // $ANTLR start "entryRuleOilImplementation"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:125:1: entryRuleOilImplementation returns [EObject current=null] : iv_ruleOilImplementation= ruleOilImplementation EOF ;
    public final EObject entryRuleOilImplementation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOilImplementation = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:126:2: (iv_ruleOilImplementation= ruleOilImplementation EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:127:2: iv_ruleOilImplementation= ruleOilImplementation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOilImplementationRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOilImplementation_in_entryRuleOilImplementation189);
            iv_ruleOilImplementation=ruleOilImplementation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOilImplementation; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOilImplementation199); if (state.failed) return current;

            }

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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:134:1: ruleOilImplementation returns [EObject current=null] : (otherlv_0= 'IMPLEMENTATION' ( (lv_Name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_OilObjects_3_0= ruleOilObjectImpl ) )* otherlv_4= '}' otherlv_5= ';' ) ;
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
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:137:28: ( (otherlv_0= 'IMPLEMENTATION' ( (lv_Name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_OilObjects_3_0= ruleOilObjectImpl ) )* otherlv_4= '}' otherlv_5= ';' ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:138:1: (otherlv_0= 'IMPLEMENTATION' ( (lv_Name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_OilObjects_3_0= ruleOilObjectImpl ) )* otherlv_4= '}' otherlv_5= ';' )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:138:1: (otherlv_0= 'IMPLEMENTATION' ( (lv_Name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_OilObjects_3_0= ruleOilObjectImpl ) )* otherlv_4= '}' otherlv_5= ';' )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:138:3: otherlv_0= 'IMPLEMENTATION' ( (lv_Name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_OilObjects_3_0= ruleOilObjectImpl ) )* otherlv_4= '}' otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleOilImplementation236); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getOilImplementationAccess().getIMPLEMENTATIONKeyword_0());
                  
            }
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:142:1: ( (lv_Name_1_0= RULE_ID ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:143:1: (lv_Name_1_0= RULE_ID )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:143:1: (lv_Name_1_0= RULE_ID )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:144:3: lv_Name_1_0= RULE_ID
            {
            lv_Name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOilImplementation253); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleOilImplementation270); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getOilImplementationAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:164:1: ( (lv_OilObjects_3_0= ruleOilObjectImpl ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=36 && LA2_0<=48)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:165:1: (lv_OilObjects_3_0= ruleOilObjectImpl )
            	    {
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:165:1: (lv_OilObjects_3_0= ruleOilObjectImpl )
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:166:3: lv_OilObjects_3_0= ruleOilObjectImpl
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOilImplementationAccess().getOilObjectsOilObjectImplParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleOilObjectImpl_in_ruleOilImplementation291);
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
            	    break loop2;
                }
            } while (true);

            otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleOilImplementation304); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getOilImplementationAccess().getRightCurlyBracketKeyword_4());
                  
            }
            otherlv_5=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleOilImplementation316); if (state.failed) return current;
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:198:1: entryRuleOilObjectImpl returns [EObject current=null] : iv_ruleOilObjectImpl= ruleOilObjectImpl EOF ;
    public final EObject entryRuleOilObjectImpl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOilObjectImpl = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:199:2: (iv_ruleOilObjectImpl= ruleOilObjectImpl EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:200:2: iv_ruleOilObjectImpl= ruleOilObjectImpl EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOilObjectImplRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOilObjectImpl_in_entryRuleOilObjectImpl352);
            iv_ruleOilObjectImpl=ruleOilObjectImpl();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOilObjectImpl; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOilObjectImpl362); if (state.failed) return current;

            }

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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:207:1: ruleOilObjectImpl returns [EObject current=null] : ( ( (lv_Type_0_0= ruleObjectType ) ) otherlv_1= '{' ( (lv_Parameters_2_0= ruleParameterType ) )* otherlv_3= '}' (otherlv_4= ':' ( (lv_Description_5_0= RULE_STRING ) ) )? otherlv_6= ';' ) ;
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
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:210:28: ( ( ( (lv_Type_0_0= ruleObjectType ) ) otherlv_1= '{' ( (lv_Parameters_2_0= ruleParameterType ) )* otherlv_3= '}' (otherlv_4= ':' ( (lv_Description_5_0= RULE_STRING ) ) )? otherlv_6= ';' ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:211:1: ( ( (lv_Type_0_0= ruleObjectType ) ) otherlv_1= '{' ( (lv_Parameters_2_0= ruleParameterType ) )* otherlv_3= '}' (otherlv_4= ':' ( (lv_Description_5_0= RULE_STRING ) ) )? otherlv_6= ';' )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:211:1: ( ( (lv_Type_0_0= ruleObjectType ) ) otherlv_1= '{' ( (lv_Parameters_2_0= ruleParameterType ) )* otherlv_3= '}' (otherlv_4= ':' ( (lv_Description_5_0= RULE_STRING ) ) )? otherlv_6= ';' )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:211:2: ( (lv_Type_0_0= ruleObjectType ) ) otherlv_1= '{' ( (lv_Parameters_2_0= ruleParameterType ) )* otherlv_3= '}' (otherlv_4= ':' ( (lv_Description_5_0= RULE_STRING ) ) )? otherlv_6= ';'
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:211:2: ( (lv_Type_0_0= ruleObjectType ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:212:1: (lv_Type_0_0= ruleObjectType )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:212:1: (lv_Type_0_0= ruleObjectType )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:213:3: lv_Type_0_0= ruleObjectType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOilObjectImplAccess().getTypeObjectTypeEnumRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleObjectType_in_ruleOilObjectImpl408);
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

            otherlv_1=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleOilObjectImpl420); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getOilObjectImplAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:233:1: ( (lv_Parameters_2_0= ruleParameterType ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=27 && LA3_0<=35)||(LA3_0>=49 && LA3_0<=61)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:234:1: (lv_Parameters_2_0= ruleParameterType )
            	    {
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:234:1: (lv_Parameters_2_0= ruleParameterType )
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:235:3: lv_Parameters_2_0= ruleParameterType
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOilObjectImplAccess().getParametersParameterTypeParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleParameterType_in_ruleOilObjectImpl441);
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
            	    break loop3;
                }
            } while (true);

            otherlv_3=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleOilObjectImpl454); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getOilObjectImplAccess().getRightCurlyBracketKeyword_3());
                  
            }
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:255:1: (otherlv_4= ':' ( (lv_Description_5_0= RULE_STRING ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==17) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:255:3: otherlv_4= ':' ( (lv_Description_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleOilObjectImpl467); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getOilObjectImplAccess().getColonKeyword_4_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:259:1: ( (lv_Description_5_0= RULE_STRING ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:260:1: (lv_Description_5_0= RULE_STRING )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:260:1: (lv_Description_5_0= RULE_STRING )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:261:3: lv_Description_5_0= RULE_STRING
                    {
                    lv_Description_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleOilObjectImpl484); if (state.failed) return current;
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

            otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleOilObjectImpl503); if (state.failed) return current;
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:289:1: entryRuleOilApplication returns [EObject current=null] : iv_ruleOilApplication= ruleOilApplication EOF ;
    public final EObject entryRuleOilApplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOilApplication = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:290:2: (iv_ruleOilApplication= ruleOilApplication EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:291:2: iv_ruleOilApplication= ruleOilApplication EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOilApplicationRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOilApplication_in_entryRuleOilApplication539);
            iv_ruleOilApplication=ruleOilApplication();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOilApplication; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOilApplication549); if (state.failed) return current;

            }

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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:298:1: ruleOilApplication returns [EObject current=null] : (otherlv_0= 'CPU' ( (lv_Name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_OilObjects_3_0= ruleOilObject ) )* otherlv_4= '}' (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )? otherlv_7= ';' ) ;
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
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:301:28: ( (otherlv_0= 'CPU' ( (lv_Name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_OilObjects_3_0= ruleOilObject ) )* otherlv_4= '}' (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )? otherlv_7= ';' ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:302:1: (otherlv_0= 'CPU' ( (lv_Name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_OilObjects_3_0= ruleOilObject ) )* otherlv_4= '}' (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )? otherlv_7= ';' )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:302:1: (otherlv_0= 'CPU' ( (lv_Name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_OilObjects_3_0= ruleOilObject ) )* otherlv_4= '}' (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )? otherlv_7= ';' )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:302:3: otherlv_0= 'CPU' ( (lv_Name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_OilObjects_3_0= ruleOilObject ) )* otherlv_4= '}' (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )? otherlv_7= ';'
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleOilApplication586); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getOilApplicationAccess().getCPUKeyword_0());
                  
            }
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:306:1: ( (lv_Name_1_0= RULE_ID ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:307:1: (lv_Name_1_0= RULE_ID )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:307:1: (lv_Name_1_0= RULE_ID )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:308:3: lv_Name_1_0= RULE_ID
            {
            lv_Name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOilApplication603); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleOilApplication620); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getOilApplicationAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:328:1: ( (lv_OilObjects_3_0= ruleOilObject ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=36 && LA5_0<=48)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:329:1: (lv_OilObjects_3_0= ruleOilObject )
            	    {
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:329:1: (lv_OilObjects_3_0= ruleOilObject )
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:330:3: lv_OilObjects_3_0= ruleOilObject
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOilApplicationAccess().getOilObjectsOilObjectParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleOilObject_in_ruleOilApplication641);
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
            	    break loop5;
                }
            } while (true);

            otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleOilApplication654); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getOilApplicationAccess().getRightCurlyBracketKeyword_4());
                  
            }
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:350:1: (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:350:3: otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleOilApplication667); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getOilApplicationAccess().getColonKeyword_5_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:354:1: ( (lv_Description_6_0= RULE_STRING ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:355:1: (lv_Description_6_0= RULE_STRING )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:355:1: (lv_Description_6_0= RULE_STRING )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:356:3: lv_Description_6_0= RULE_STRING
                    {
                    lv_Description_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleOilApplication684); if (state.failed) return current;
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

            otherlv_7=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleOilApplication703); if (state.failed) return current;
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:384:1: entryRuleParameterType returns [EObject current=null] : iv_ruleParameterType= ruleParameterType EOF ;
    public final EObject entryRuleParameterType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterType = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:385:2: (iv_ruleParameterType= ruleParameterType EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:386:2: iv_ruleParameterType= ruleParameterType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameterType_in_entryRuleParameterType739);
            iv_ruleParameterType=ruleParameterType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterType; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParameterType749); if (state.failed) return current;

            }

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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:393:1: ruleParameterType returns [EObject current=null] : (this_ValueType_0= ruleValueType | this_VariantType_1= ruleVariantType | this_ReferenceType_2= ruleReferenceType ) ;
    public final EObject ruleParameterType() throws RecognitionException {
        EObject current = null;

        EObject this_ValueType_0 = null;

        EObject this_VariantType_1 = null;

        EObject this_ReferenceType_2 = null;


         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:396:28: ( (this_ValueType_0= ruleValueType | this_VariantType_1= ruleVariantType | this_ReferenceType_2= ruleReferenceType ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:397:1: (this_ValueType_0= ruleValueType | this_VariantType_1= ruleVariantType | this_ReferenceType_2= ruleReferenceType )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:397:1: (this_ValueType_0= ruleValueType | this_VariantType_1= ruleVariantType | this_ReferenceType_2= ruleReferenceType )
            int alt7=3;
            switch ( input.LA(1) ) {
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
                {
                alt7=1;
                }
                break;
            case 34:
            case 35:
                {
                alt7=2;
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
                alt7=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:398:5: this_ValueType_0= ruleValueType
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getParameterTypeAccess().getValueTypeParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleValueType_in_ruleParameterType796);
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
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:408:5: this_VariantType_1= ruleVariantType
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getParameterTypeAccess().getVariantTypeParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleVariantType_in_ruleParameterType823);
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
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:418:5: this_ReferenceType_2= ruleReferenceType
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getParameterTypeAccess().getReferenceTypeParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleReferenceType_in_ruleParameterType850);
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:434:1: entryRuleValueType returns [EObject current=null] : iv_ruleValueType= ruleValueType EOF ;
    public final EObject entryRuleValueType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueType = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:435:2: (iv_ruleValueType= ruleValueType EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:436:2: iv_ruleValueType= ruleValueType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleValueType_in_entryRuleValueType885);
            iv_ruleValueType=ruleValueType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValueType; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleValueType895); if (state.failed) return current;

            }

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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:443:1: ruleValueType returns [EObject current=null] : ( () ( (lv_Type_1_0= ruleVType ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? ( (lv_Name_3_0= RULE_ID ) ) ( (lv_MultiValue_4_0= '[]' ) )? (otherlv_5= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( ( (lv_DefaultValue_7_1= ruleGenericValue | lv_DefaultValue_7_2= RULE_ID ) ) ) ) )? (otherlv_8= ':' ( (lv_Description_9_0= RULE_STRING ) ) )? otherlv_10= ';' ) ;
    public final EObject ruleValueType() throws RecognitionException {
        EObject current = null;

        Token lv_WithAuto_2_0=null;
        Token lv_Name_3_0=null;
        Token lv_MultiValue_4_0=null;
        Token otherlv_5=null;
        Token lv_DefaultAuto_6_0=null;
        Token lv_DefaultValue_7_2=null;
        Token otherlv_8=null;
        Token lv_Description_9_0=null;
        Token otherlv_10=null;
        Enumerator lv_Type_1_0 = null;

        AntlrDatatypeRuleToken lv_DefaultValue_7_1 = null;


         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:446:28: ( ( () ( (lv_Type_1_0= ruleVType ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? ( (lv_Name_3_0= RULE_ID ) ) ( (lv_MultiValue_4_0= '[]' ) )? (otherlv_5= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( ( (lv_DefaultValue_7_1= ruleGenericValue | lv_DefaultValue_7_2= RULE_ID ) ) ) ) )? (otherlv_8= ':' ( (lv_Description_9_0= RULE_STRING ) ) )? otherlv_10= ';' ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:447:1: ( () ( (lv_Type_1_0= ruleVType ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? ( (lv_Name_3_0= RULE_ID ) ) ( (lv_MultiValue_4_0= '[]' ) )? (otherlv_5= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( ( (lv_DefaultValue_7_1= ruleGenericValue | lv_DefaultValue_7_2= RULE_ID ) ) ) ) )? (otherlv_8= ':' ( (lv_Description_9_0= RULE_STRING ) ) )? otherlv_10= ';' )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:447:1: ( () ( (lv_Type_1_0= ruleVType ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? ( (lv_Name_3_0= RULE_ID ) ) ( (lv_MultiValue_4_0= '[]' ) )? (otherlv_5= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( ( (lv_DefaultValue_7_1= ruleGenericValue | lv_DefaultValue_7_2= RULE_ID ) ) ) ) )? (otherlv_8= ':' ( (lv_Description_9_0= RULE_STRING ) ) )? otherlv_10= ';' )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:447:2: () ( (lv_Type_1_0= ruleVType ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? ( (lv_Name_3_0= RULE_ID ) ) ( (lv_MultiValue_4_0= '[]' ) )? (otherlv_5= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( ( (lv_DefaultValue_7_1= ruleGenericValue | lv_DefaultValue_7_2= RULE_ID ) ) ) ) )? (otherlv_8= ':' ( (lv_Description_9_0= RULE_STRING ) ) )? otherlv_10= ';'
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:447:2: ()
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:448:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getValueTypeAccess().getValueTypeAction_0(),
                          current);
                  
            }

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:453:2: ( (lv_Type_1_0= ruleVType ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:454:1: (lv_Type_1_0= ruleVType )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:454:1: (lv_Type_1_0= ruleVType )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:455:3: lv_Type_1_0= ruleVType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getValueTypeAccess().getTypeVTypeEnumRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVType_in_ruleValueType950);
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

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:471:2: ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==19) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:472:1: (lv_WithAuto_2_0= 'WITH_AUTO' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:472:1: (lv_WithAuto_2_0= 'WITH_AUTO' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:473:3: lv_WithAuto_2_0= 'WITH_AUTO'
                    {
                    lv_WithAuto_2_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleValueType968); if (state.failed) return current;
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

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:486:3: ( (lv_Name_3_0= RULE_ID ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:487:1: (lv_Name_3_0= RULE_ID )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:487:1: (lv_Name_3_0= RULE_ID )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:488:3: lv_Name_3_0= RULE_ID
            {
            lv_Name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleValueType999); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_Name_3_0, grammarAccess.getValueTypeAccess().getNameIDTerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getValueTypeRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"Name",
                      		lv_Name_3_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:504:2: ( (lv_MultiValue_4_0= '[]' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==20) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:505:1: (lv_MultiValue_4_0= '[]' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:505:1: (lv_MultiValue_4_0= '[]' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:506:3: lv_MultiValue_4_0= '[]'
                    {
                    lv_MultiValue_4_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleValueType1022); if (state.failed) return current;
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

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:519:3: (otherlv_5= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( ( (lv_DefaultValue_7_1= ruleGenericValue | lv_DefaultValue_7_2= RULE_ID ) ) ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==21) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:519:5: otherlv_5= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( ( (lv_DefaultValue_7_1= ruleGenericValue | lv_DefaultValue_7_2= RULE_ID ) ) ) )
                    {
                    otherlv_5=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleValueType1049); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getValueTypeAccess().getEqualsSignKeyword_5_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:523:1: ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( ( (lv_DefaultValue_7_1= ruleGenericValue | lv_DefaultValue_7_2= RULE_ID ) ) ) )
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==22) && (synpred1_InternalOil())) {
                        alt11=1;
                    }
                    else if ( ((LA11_0>=RULE_ID && LA11_0<=RULE_NON_ZERO_INT)||LA11_0==RULE_HEX||(LA11_0>=24 && LA11_0<=25)) ) {
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
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:523:2: ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:523:2: ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:523:3: ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:530:1: (lv_DefaultAuto_6_0= 'AUTO' )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:531:3: lv_DefaultAuto_6_0= 'AUTO'
                            {
                            lv_DefaultAuto_6_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleValueType1083); if (state.failed) return current;
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
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:545:6: ( ( (lv_DefaultValue_7_1= ruleGenericValue | lv_DefaultValue_7_2= RULE_ID ) ) )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:545:6: ( ( (lv_DefaultValue_7_1= ruleGenericValue | lv_DefaultValue_7_2= RULE_ID ) ) )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:546:1: ( (lv_DefaultValue_7_1= ruleGenericValue | lv_DefaultValue_7_2= RULE_ID ) )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:546:1: ( (lv_DefaultValue_7_1= ruleGenericValue | lv_DefaultValue_7_2= RULE_ID ) )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:547:1: (lv_DefaultValue_7_1= ruleGenericValue | lv_DefaultValue_7_2= RULE_ID )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:547:1: (lv_DefaultValue_7_1= ruleGenericValue | lv_DefaultValue_7_2= RULE_ID )
                            int alt10=2;
                            int LA10_0 = input.LA(1);

                            if ( ((LA10_0>=RULE_STRING && LA10_0<=RULE_NON_ZERO_INT)||LA10_0==RULE_HEX||(LA10_0>=24 && LA10_0<=25)) ) {
                                alt10=1;
                            }
                            else if ( (LA10_0==RULE_ID) ) {
                                alt10=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 10, 0, input);

                                throw nvae;
                            }
                            switch (alt10) {
                                case 1 :
                                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:548:3: lv_DefaultValue_7_1= ruleGenericValue
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getValueTypeAccess().getDefaultValueGenericValueParserRuleCall_5_1_1_0_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleGenericValue_in_ruleValueType1125);
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
                                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:563:8: lv_DefaultValue_7_2= RULE_ID
                                    {
                                    lv_DefaultValue_7_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleValueType1140); if (state.failed) return current;
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

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:581:5: (otherlv_8= ':' ( (lv_Description_9_0= RULE_STRING ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==17) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:581:7: otherlv_8= ':' ( (lv_Description_9_0= RULE_STRING ) )
                    {
                    otherlv_8=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleValueType1164); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getValueTypeAccess().getColonKeyword_6_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:585:1: ( (lv_Description_9_0= RULE_STRING ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:586:1: (lv_Description_9_0= RULE_STRING )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:586:1: (lv_Description_9_0= RULE_STRING )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:587:3: lv_Description_9_0= RULE_STRING
                    {
                    lv_Description_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleValueType1181); if (state.failed) return current;
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

            otherlv_10=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleValueType1200); if (state.failed) return current;
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:615:1: entryRuleVariantType returns [EObject current=null] : iv_ruleVariantType= ruleVariantType EOF ;
    public final EObject entryRuleVariantType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariantType = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:616:2: (iv_ruleVariantType= ruleVariantType EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:617:2: iv_ruleVariantType= ruleVariantType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariantTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVariantType_in_entryRuleVariantType1236);
            iv_ruleVariantType=ruleVariantType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariantType; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVariantType1246); if (state.failed) return current;

            }

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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:624:1: ruleVariantType returns [EObject current=null] : ( () ( (lv_Type_1_0= ruleEType ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? ( (lv_Name_3_0= RULE_ID ) ) ( (lv_MultiValue_4_0= '[]' ) )? (otherlv_5= '{' ( ( (lv_Values_6_0= ruleEnumeratorType ) ) (otherlv_7= ',' ( (lv_Values_8_0= ruleEnumeratorType ) ) )* )? otherlv_9= '}' )? (otherlv_10= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_11_0= 'AUTO' ) ) | ( (lv_DefaultValue_12_0= RULE_ID ) ) ) )? (otherlv_13= ':' ( (lv_Description_14_0= RULE_STRING ) ) )? otherlv_15= ';' ) ;
    public final EObject ruleVariantType() throws RecognitionException {
        EObject current = null;

        Token lv_WithAuto_2_0=null;
        Token lv_Name_3_0=null;
        Token lv_MultiValue_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token lv_DefaultAuto_11_0=null;
        Token lv_DefaultValue_12_0=null;
        Token otherlv_13=null;
        Token lv_Description_14_0=null;
        Token otherlv_15=null;
        Enumerator lv_Type_1_0 = null;

        EObject lv_Values_6_0 = null;

        EObject lv_Values_8_0 = null;


         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:627:28: ( ( () ( (lv_Type_1_0= ruleEType ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? ( (lv_Name_3_0= RULE_ID ) ) ( (lv_MultiValue_4_0= '[]' ) )? (otherlv_5= '{' ( ( (lv_Values_6_0= ruleEnumeratorType ) ) (otherlv_7= ',' ( (lv_Values_8_0= ruleEnumeratorType ) ) )* )? otherlv_9= '}' )? (otherlv_10= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_11_0= 'AUTO' ) ) | ( (lv_DefaultValue_12_0= RULE_ID ) ) ) )? (otherlv_13= ':' ( (lv_Description_14_0= RULE_STRING ) ) )? otherlv_15= ';' ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:628:1: ( () ( (lv_Type_1_0= ruleEType ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? ( (lv_Name_3_0= RULE_ID ) ) ( (lv_MultiValue_4_0= '[]' ) )? (otherlv_5= '{' ( ( (lv_Values_6_0= ruleEnumeratorType ) ) (otherlv_7= ',' ( (lv_Values_8_0= ruleEnumeratorType ) ) )* )? otherlv_9= '}' )? (otherlv_10= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_11_0= 'AUTO' ) ) | ( (lv_DefaultValue_12_0= RULE_ID ) ) ) )? (otherlv_13= ':' ( (lv_Description_14_0= RULE_STRING ) ) )? otherlv_15= ';' )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:628:1: ( () ( (lv_Type_1_0= ruleEType ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? ( (lv_Name_3_0= RULE_ID ) ) ( (lv_MultiValue_4_0= '[]' ) )? (otherlv_5= '{' ( ( (lv_Values_6_0= ruleEnumeratorType ) ) (otherlv_7= ',' ( (lv_Values_8_0= ruleEnumeratorType ) ) )* )? otherlv_9= '}' )? (otherlv_10= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_11_0= 'AUTO' ) ) | ( (lv_DefaultValue_12_0= RULE_ID ) ) ) )? (otherlv_13= ':' ( (lv_Description_14_0= RULE_STRING ) ) )? otherlv_15= ';' )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:628:2: () ( (lv_Type_1_0= ruleEType ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? ( (lv_Name_3_0= RULE_ID ) ) ( (lv_MultiValue_4_0= '[]' ) )? (otherlv_5= '{' ( ( (lv_Values_6_0= ruleEnumeratorType ) ) (otherlv_7= ',' ( (lv_Values_8_0= ruleEnumeratorType ) ) )* )? otherlv_9= '}' )? (otherlv_10= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_11_0= 'AUTO' ) ) | ( (lv_DefaultValue_12_0= RULE_ID ) ) ) )? (otherlv_13= ':' ( (lv_Description_14_0= RULE_STRING ) ) )? otherlv_15= ';'
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:628:2: ()
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:629:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getVariantTypeAccess().getVariantTypeAction_0(),
                          current);
                  
            }

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:634:2: ( (lv_Type_1_0= ruleEType ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:635:1: (lv_Type_1_0= ruleEType )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:635:1: (lv_Type_1_0= ruleEType )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:636:3: lv_Type_1_0= ruleEType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariantTypeAccess().getTypeETypeEnumRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleEType_in_ruleVariantType1301);
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

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:652:2: ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==19) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:653:1: (lv_WithAuto_2_0= 'WITH_AUTO' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:653:1: (lv_WithAuto_2_0= 'WITH_AUTO' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:654:3: lv_WithAuto_2_0= 'WITH_AUTO'
                    {
                    lv_WithAuto_2_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleVariantType1319); if (state.failed) return current;
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

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:667:3: ( (lv_Name_3_0= RULE_ID ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:668:1: (lv_Name_3_0= RULE_ID )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:668:1: (lv_Name_3_0= RULE_ID )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:669:3: lv_Name_3_0= RULE_ID
            {
            lv_Name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleVariantType1350); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_Name_3_0, grammarAccess.getVariantTypeAccess().getNameIDTerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getVariantTypeRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"Name",
                      		lv_Name_3_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:685:2: ( (lv_MultiValue_4_0= '[]' ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==20) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:686:1: (lv_MultiValue_4_0= '[]' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:686:1: (lv_MultiValue_4_0= '[]' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:687:3: lv_MultiValue_4_0= '[]'
                    {
                    lv_MultiValue_4_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleVariantType1373); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_MultiValue_4_0, grammarAccess.getVariantTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_4_0());
                          
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

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:700:3: (otherlv_5= '{' ( ( (lv_Values_6_0= ruleEnumeratorType ) ) (otherlv_7= ',' ( (lv_Values_8_0= ruleEnumeratorType ) ) )* )? otherlv_9= '}' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==14) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:700:5: otherlv_5= '{' ( ( (lv_Values_6_0= ruleEnumeratorType ) ) (otherlv_7= ',' ( (lv_Values_8_0= ruleEnumeratorType ) ) )* )? otherlv_9= '}'
                    {
                    otherlv_5=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleVariantType1400); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getVariantTypeAccess().getLeftCurlyBracketKeyword_5_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:704:1: ( ( (lv_Values_6_0= ruleEnumeratorType ) ) (otherlv_7= ',' ( (lv_Values_8_0= ruleEnumeratorType ) ) )* )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==RULE_ID) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:704:2: ( (lv_Values_6_0= ruleEnumeratorType ) ) (otherlv_7= ',' ( (lv_Values_8_0= ruleEnumeratorType ) ) )*
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:704:2: ( (lv_Values_6_0= ruleEnumeratorType ) )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:705:1: (lv_Values_6_0= ruleEnumeratorType )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:705:1: (lv_Values_6_0= ruleEnumeratorType )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:706:3: lv_Values_6_0= ruleEnumeratorType
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getVariantTypeAccess().getValuesEnumeratorTypeParserRuleCall_5_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleEnumeratorType_in_ruleVariantType1422);
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

                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:722:2: (otherlv_7= ',' ( (lv_Values_8_0= ruleEnumeratorType ) ) )*
                            loop16:
                            do {
                                int alt16=2;
                                int LA16_0 = input.LA(1);

                                if ( (LA16_0==23) ) {
                                    alt16=1;
                                }


                                switch (alt16) {
                            	case 1 :
                            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:722:4: otherlv_7= ',' ( (lv_Values_8_0= ruleEnumeratorType ) )
                            	    {
                            	    otherlv_7=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleVariantType1435); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_7, grammarAccess.getVariantTypeAccess().getCommaKeyword_5_1_1_0());
                            	          
                            	    }
                            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:726:1: ( (lv_Values_8_0= ruleEnumeratorType ) )
                            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:727:1: (lv_Values_8_0= ruleEnumeratorType )
                            	    {
                            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:727:1: (lv_Values_8_0= ruleEnumeratorType )
                            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:728:3: lv_Values_8_0= ruleEnumeratorType
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getVariantTypeAccess().getValuesEnumeratorTypeParserRuleCall_5_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleEnumeratorType_in_ruleVariantType1456);
                            	    lv_Values_8_0=ruleEnumeratorType();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getVariantTypeRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"Values",
                            	              		lv_Values_8_0, 
                            	              		"EnumeratorType");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop16;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleVariantType1472); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getVariantTypeAccess().getRightCurlyBracketKeyword_5_2());
                          
                    }

                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:748:3: (otherlv_10= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_11_0= 'AUTO' ) ) | ( (lv_DefaultValue_12_0= RULE_ID ) ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==21) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:748:5: otherlv_10= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_11_0= 'AUTO' ) ) | ( (lv_DefaultValue_12_0= RULE_ID ) ) )
                    {
                    otherlv_10=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleVariantType1487); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getVariantTypeAccess().getEqualsSignKeyword_6_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:752:1: ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_11_0= 'AUTO' ) ) | ( (lv_DefaultValue_12_0= RULE_ID ) ) )
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==22) && (synpred2_InternalOil())) {
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
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:752:2: ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_11_0= 'AUTO' ) )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:752:2: ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_11_0= 'AUTO' ) )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:752:3: ( ( 'AUTO' ) )=> (lv_DefaultAuto_11_0= 'AUTO' )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:759:1: (lv_DefaultAuto_11_0= 'AUTO' )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:760:3: lv_DefaultAuto_11_0= 'AUTO'
                            {
                            lv_DefaultAuto_11_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleVariantType1521); if (state.failed) return current;
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
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:774:6: ( (lv_DefaultValue_12_0= RULE_ID ) )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:774:6: ( (lv_DefaultValue_12_0= RULE_ID ) )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:775:1: (lv_DefaultValue_12_0= RULE_ID )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:775:1: (lv_DefaultValue_12_0= RULE_ID )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:776:3: lv_DefaultValue_12_0= RULE_ID
                            {
                            lv_DefaultValue_12_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleVariantType1557); if (state.failed) return current;
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

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:792:5: (otherlv_13= ':' ( (lv_Description_14_0= RULE_STRING ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==17) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:792:7: otherlv_13= ':' ( (lv_Description_14_0= RULE_STRING ) )
                    {
                    otherlv_13=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleVariantType1578); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getVariantTypeAccess().getColonKeyword_7_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:796:1: ( (lv_Description_14_0= RULE_STRING ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:797:1: (lv_Description_14_0= RULE_STRING )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:797:1: (lv_Description_14_0= RULE_STRING )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:798:3: lv_Description_14_0= RULE_STRING
                    {
                    lv_Description_14_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleVariantType1595); if (state.failed) return current;
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

            otherlv_15=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleVariantType1614); if (state.failed) return current;
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:826:1: entryRuleEnumeratorType returns [EObject current=null] : iv_ruleEnumeratorType= ruleEnumeratorType EOF ;
    public final EObject entryRuleEnumeratorType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumeratorType = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:827:2: (iv_ruleEnumeratorType= ruleEnumeratorType EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:828:2: iv_ruleEnumeratorType= ruleEnumeratorType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumeratorTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEnumeratorType_in_entryRuleEnumeratorType1650);
            iv_ruleEnumeratorType=ruleEnumeratorType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumeratorType; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumeratorType1660); if (state.failed) return current;

            }

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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:835:1: ruleEnumeratorType returns [EObject current=null] : ( () ( (lv_Name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameterType ) )* otherlv_4= '}' )? (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleEnumeratorType() throws RecognitionException {
        EObject current = null;

        Token lv_Name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_Description_6_0=null;
        EObject lv_Parameters_3_0 = null;


         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:838:28: ( ( () ( (lv_Name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameterType ) )* otherlv_4= '}' )? (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )? ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:839:1: ( () ( (lv_Name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameterType ) )* otherlv_4= '}' )? (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )? )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:839:1: ( () ( (lv_Name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameterType ) )* otherlv_4= '}' )? (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )? )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:839:2: () ( (lv_Name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameterType ) )* otherlv_4= '}' )? (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )?
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:839:2: ()
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:840:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getEnumeratorTypeAccess().getEnumeratorTypeAction_0(),
                          current);
                  
            }

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:845:2: ( (lv_Name_1_0= RULE_ID ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:846:1: (lv_Name_1_0= RULE_ID )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:846:1: (lv_Name_1_0= RULE_ID )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:847:3: lv_Name_1_0= RULE_ID
            {
            lv_Name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEnumeratorType1711); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_Name_1_0, grammarAccess.getEnumeratorTypeAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getEnumeratorTypeRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"Name",
                      		lv_Name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:863:2: (otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameterType ) )* otherlv_4= '}' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==14) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:863:4: otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameterType ) )* otherlv_4= '}'
                    {
                    otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleEnumeratorType1729); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getEnumeratorTypeAccess().getLeftCurlyBracketKeyword_2_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:867:1: ( (lv_Parameters_3_0= ruleParameterType ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( ((LA22_0>=27 && LA22_0<=35)||(LA22_0>=49 && LA22_0<=61)) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:868:1: (lv_Parameters_3_0= ruleParameterType )
                    	    {
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:868:1: (lv_Parameters_3_0= ruleParameterType )
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:869:3: lv_Parameters_3_0= ruleParameterType
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getEnumeratorTypeAccess().getParametersParameterTypeParserRuleCall_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleParameterType_in_ruleEnumeratorType1750);
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
                    	    break loop22;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEnumeratorType1763); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getEnumeratorTypeAccess().getRightCurlyBracketKeyword_2_2());
                          
                    }

                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:889:3: (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==17) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:889:5: otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleEnumeratorType1778); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getEnumeratorTypeAccess().getColonKeyword_3_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:893:1: ( (lv_Description_6_0= RULE_STRING ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:894:1: (lv_Description_6_0= RULE_STRING )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:894:1: (lv_Description_6_0= RULE_STRING )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:895:3: lv_Description_6_0= RULE_STRING
                    {
                    lv_Description_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEnumeratorType1795); if (state.failed) return current;
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:919:1: entryRuleReferenceType returns [EObject current=null] : iv_ruleReferenceType= ruleReferenceType EOF ;
    public final EObject entryRuleReferenceType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceType = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:920:2: (iv_ruleReferenceType= ruleReferenceType EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:921:2: iv_ruleReferenceType= ruleReferenceType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReferenceTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleReferenceType_in_entryRuleReferenceType1838);
            iv_ruleReferenceType=ruleReferenceType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReferenceType; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceType1848); if (state.failed) return current;

            }

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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:928:1: ruleReferenceType returns [EObject current=null] : ( () ( (lv_Type_1_0= ruleObjectTypeRef ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? ( (lv_Name_3_0= RULE_ID ) ) ( (lv_MultiValue_4_0= '[]' ) )? (otherlv_5= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( (lv_DefaultValue_7_0= RULE_ID ) ) ) )? (otherlv_8= ':' ( (lv_Description_9_0= RULE_STRING ) ) )? otherlv_10= ';' ) ;
    public final EObject ruleReferenceType() throws RecognitionException {
        EObject current = null;

        Token lv_WithAuto_2_0=null;
        Token lv_Name_3_0=null;
        Token lv_MultiValue_4_0=null;
        Token otherlv_5=null;
        Token lv_DefaultAuto_6_0=null;
        Token lv_DefaultValue_7_0=null;
        Token otherlv_8=null;
        Token lv_Description_9_0=null;
        Token otherlv_10=null;
        Enumerator lv_Type_1_0 = null;


         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:931:28: ( ( () ( (lv_Type_1_0= ruleObjectTypeRef ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? ( (lv_Name_3_0= RULE_ID ) ) ( (lv_MultiValue_4_0= '[]' ) )? (otherlv_5= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( (lv_DefaultValue_7_0= RULE_ID ) ) ) )? (otherlv_8= ':' ( (lv_Description_9_0= RULE_STRING ) ) )? otherlv_10= ';' ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:932:1: ( () ( (lv_Type_1_0= ruleObjectTypeRef ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? ( (lv_Name_3_0= RULE_ID ) ) ( (lv_MultiValue_4_0= '[]' ) )? (otherlv_5= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( (lv_DefaultValue_7_0= RULE_ID ) ) ) )? (otherlv_8= ':' ( (lv_Description_9_0= RULE_STRING ) ) )? otherlv_10= ';' )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:932:1: ( () ( (lv_Type_1_0= ruleObjectTypeRef ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? ( (lv_Name_3_0= RULE_ID ) ) ( (lv_MultiValue_4_0= '[]' ) )? (otherlv_5= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( (lv_DefaultValue_7_0= RULE_ID ) ) ) )? (otherlv_8= ':' ( (lv_Description_9_0= RULE_STRING ) ) )? otherlv_10= ';' )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:932:2: () ( (lv_Type_1_0= ruleObjectTypeRef ) ) ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )? ( (lv_Name_3_0= RULE_ID ) ) ( (lv_MultiValue_4_0= '[]' ) )? (otherlv_5= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( (lv_DefaultValue_7_0= RULE_ID ) ) ) )? (otherlv_8= ':' ( (lv_Description_9_0= RULE_STRING ) ) )? otherlv_10= ';'
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:932:2: ()
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:933:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getReferenceTypeAccess().getReferenceTypeAction_0(),
                          current);
                  
            }

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:938:2: ( (lv_Type_1_0= ruleObjectTypeRef ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:939:1: (lv_Type_1_0= ruleObjectTypeRef )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:939:1: (lv_Type_1_0= ruleObjectTypeRef )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:940:3: lv_Type_1_0= ruleObjectTypeRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getReferenceTypeAccess().getTypeObjectTypeRefEnumRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleObjectTypeRef_in_ruleReferenceType1903);
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

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:956:2: ( (lv_WithAuto_2_0= 'WITH_AUTO' ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==19) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:957:1: (lv_WithAuto_2_0= 'WITH_AUTO' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:957:1: (lv_WithAuto_2_0= 'WITH_AUTO' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:958:3: lv_WithAuto_2_0= 'WITH_AUTO'
                    {
                    lv_WithAuto_2_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleReferenceType1921); if (state.failed) return current;
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

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:971:3: ( (lv_Name_3_0= RULE_ID ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:972:1: (lv_Name_3_0= RULE_ID )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:972:1: (lv_Name_3_0= RULE_ID )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:973:3: lv_Name_3_0= RULE_ID
            {
            lv_Name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceType1952); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_Name_3_0, grammarAccess.getReferenceTypeAccess().getNameIDTerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getReferenceTypeRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"Name",
                      		lv_Name_3_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:989:2: ( (lv_MultiValue_4_0= '[]' ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==20) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:990:1: (lv_MultiValue_4_0= '[]' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:990:1: (lv_MultiValue_4_0= '[]' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:991:3: lv_MultiValue_4_0= '[]'
                    {
                    lv_MultiValue_4_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleReferenceType1975); if (state.failed) return current;
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

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1004:3: (otherlv_5= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( (lv_DefaultValue_7_0= RULE_ID ) ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==21) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1004:5: otherlv_5= '=' ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( (lv_DefaultValue_7_0= RULE_ID ) ) )
                    {
                    otherlv_5=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleReferenceType2002); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getReferenceTypeAccess().getEqualsSignKeyword_5_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1008:1: ( ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) ) | ( (lv_DefaultValue_7_0= RULE_ID ) ) )
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==22) && (synpred3_InternalOil())) {
                        alt27=1;
                    }
                    else if ( (LA27_0==RULE_ID) ) {
                        alt27=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 27, 0, input);

                        throw nvae;
                    }
                    switch (alt27) {
                        case 1 :
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1008:2: ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1008:2: ( ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' ) )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1008:3: ( ( 'AUTO' ) )=> (lv_DefaultAuto_6_0= 'AUTO' )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1015:1: (lv_DefaultAuto_6_0= 'AUTO' )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1016:3: lv_DefaultAuto_6_0= 'AUTO'
                            {
                            lv_DefaultAuto_6_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleReferenceType2036); if (state.failed) return current;
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
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1030:6: ( (lv_DefaultValue_7_0= RULE_ID ) )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1030:6: ( (lv_DefaultValue_7_0= RULE_ID ) )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1031:1: (lv_DefaultValue_7_0= RULE_ID )
                            {
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1031:1: (lv_DefaultValue_7_0= RULE_ID )
                            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1032:3: lv_DefaultValue_7_0= RULE_ID
                            {
                            lv_DefaultValue_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceType2072); if (state.failed) return current;
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

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1048:5: (otherlv_8= ':' ( (lv_Description_9_0= RULE_STRING ) ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==17) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1048:7: otherlv_8= ':' ( (lv_Description_9_0= RULE_STRING ) )
                    {
                    otherlv_8=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleReferenceType2093); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getReferenceTypeAccess().getColonKeyword_6_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1052:1: ( (lv_Description_9_0= RULE_STRING ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1053:1: (lv_Description_9_0= RULE_STRING )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1053:1: (lv_Description_9_0= RULE_STRING )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1054:3: lv_Description_9_0= RULE_STRING
                    {
                    lv_Description_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleReferenceType2110); if (state.failed) return current;
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

            otherlv_10=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleReferenceType2129); if (state.failed) return current;
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1082:1: entryRuleOilObject returns [EObject current=null] : iv_ruleOilObject= ruleOilObject EOF ;
    public final EObject entryRuleOilObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOilObject = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1083:2: (iv_ruleOilObject= ruleOilObject EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1084:2: iv_ruleOilObject= ruleOilObject EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOilObjectRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOilObject_in_entryRuleOilObject2165);
            iv_ruleOilObject=ruleOilObject();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOilObject; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOilObject2175); if (state.failed) return current;

            }

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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1091:1: ruleOilObject returns [EObject current=null] : ( ( (lv_Type_0_0= ruleObjectType ) ) ( (lv_Name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameter ) )* otherlv_4= '}' (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )? otherlv_7= ';' ) ;
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
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1094:28: ( ( ( (lv_Type_0_0= ruleObjectType ) ) ( (lv_Name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameter ) )* otherlv_4= '}' (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )? otherlv_7= ';' ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1095:1: ( ( (lv_Type_0_0= ruleObjectType ) ) ( (lv_Name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameter ) )* otherlv_4= '}' (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )? otherlv_7= ';' )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1095:1: ( ( (lv_Type_0_0= ruleObjectType ) ) ( (lv_Name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameter ) )* otherlv_4= '}' (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )? otherlv_7= ';' )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1095:2: ( (lv_Type_0_0= ruleObjectType ) ) ( (lv_Name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_Parameters_3_0= ruleParameter ) )* otherlv_4= '}' (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )? otherlv_7= ';'
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1095:2: ( (lv_Type_0_0= ruleObjectType ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1096:1: (lv_Type_0_0= ruleObjectType )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1096:1: (lv_Type_0_0= ruleObjectType )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1097:3: lv_Type_0_0= ruleObjectType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOilObjectAccess().getTypeObjectTypeEnumRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleObjectType_in_ruleOilObject2221);
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

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1113:2: ( (lv_Name_1_0= RULE_ID ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1114:1: (lv_Name_1_0= RULE_ID )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1114:1: (lv_Name_1_0= RULE_ID )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1115:3: lv_Name_1_0= RULE_ID
            {
            lv_Name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOilObject2238); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleOilObject2255); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getOilObjectAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1135:1: ( (lv_Parameters_3_0= ruleParameter ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_ID) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1136:1: (lv_Parameters_3_0= ruleParameter )
            	    {
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1136:1: (lv_Parameters_3_0= ruleParameter )
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1137:3: lv_Parameters_3_0= ruleParameter
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOilObjectAccess().getParametersParameterParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleParameter_in_ruleOilObject2276);
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
            	    break loop30;
                }
            } while (true);

            otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleOilObject2289); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getOilObjectAccess().getRightCurlyBracketKeyword_4());
                  
            }
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1157:1: (otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==17) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1157:3: otherlv_5= ':' ( (lv_Description_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleOilObject2302); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getOilObjectAccess().getColonKeyword_5_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1161:1: ( (lv_Description_6_0= RULE_STRING ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1162:1: (lv_Description_6_0= RULE_STRING )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1162:1: (lv_Description_6_0= RULE_STRING )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1163:3: lv_Description_6_0= RULE_STRING
                    {
                    lv_Description_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleOilObject2319); if (state.failed) return current;
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

            otherlv_7=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleOilObject2338); if (state.failed) return current;
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1191:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1192:2: (iv_ruleParameter= ruleParameter EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1193:2: iv_ruleParameter= ruleParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_entryRuleParameter2374);
            iv_ruleParameter=ruleParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameter; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParameter2384); if (state.failed) return current;

            }

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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1200:1: ruleParameter returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( ( ( ( 'AUTO' ) )=> (lv_Auto_3_0= 'AUTO' ) ) | ( (lv_Value_4_0= ruleGenericValue ) ) | ( (otherlv_5= RULE_ID ) ) ) (otherlv_6= '{' ( (lv_Parameters_7_0= ruleParameter ) )* otherlv_8= '}' )? (otherlv_9= ':' ( (lv_Description_10_0= RULE_STRING ) ) )? otherlv_11= ';' ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_Auto_3_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token lv_Description_10_0=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_Value_4_0 = null;

        EObject lv_Parameters_7_0 = null;


         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1203:28: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( ( ( ( 'AUTO' ) )=> (lv_Auto_3_0= 'AUTO' ) ) | ( (lv_Value_4_0= ruleGenericValue ) ) | ( (otherlv_5= RULE_ID ) ) ) (otherlv_6= '{' ( (lv_Parameters_7_0= ruleParameter ) )* otherlv_8= '}' )? (otherlv_9= ':' ( (lv_Description_10_0= RULE_STRING ) ) )? otherlv_11= ';' ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1204:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( ( ( ( 'AUTO' ) )=> (lv_Auto_3_0= 'AUTO' ) ) | ( (lv_Value_4_0= ruleGenericValue ) ) | ( (otherlv_5= RULE_ID ) ) ) (otherlv_6= '{' ( (lv_Parameters_7_0= ruleParameter ) )* otherlv_8= '}' )? (otherlv_9= ':' ( (lv_Description_10_0= RULE_STRING ) ) )? otherlv_11= ';' )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1204:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( ( ( ( 'AUTO' ) )=> (lv_Auto_3_0= 'AUTO' ) ) | ( (lv_Value_4_0= ruleGenericValue ) ) | ( (otherlv_5= RULE_ID ) ) ) (otherlv_6= '{' ( (lv_Parameters_7_0= ruleParameter ) )* otherlv_8= '}' )? (otherlv_9= ':' ( (lv_Description_10_0= RULE_STRING ) ) )? otherlv_11= ';' )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1204:2: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( ( ( ( 'AUTO' ) )=> (lv_Auto_3_0= 'AUTO' ) ) | ( (lv_Value_4_0= ruleGenericValue ) ) | ( (otherlv_5= RULE_ID ) ) ) (otherlv_6= '{' ( (lv_Parameters_7_0= ruleParameter ) )* otherlv_8= '}' )? (otherlv_9= ':' ( (lv_Description_10_0= RULE_STRING ) ) )? otherlv_11= ';'
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1204:2: ()
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1205:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getParameterAccess().getParameterAction_0(),
                          current);
                  
            }

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1210:2: ( (otherlv_1= RULE_ID ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1211:1: (otherlv_1= RULE_ID )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1211:1: (otherlv_1= RULE_ID )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1212:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getParameterRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParameter2438); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getParameterAccess().getTypeParameterTypeCrossReference_1_0()); 
              	
            }

            }


            }

            otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleParameter2450); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getEqualsSignKeyword_2());
                  
            }
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1227:1: ( ( ( ( 'AUTO' ) )=> (lv_Auto_3_0= 'AUTO' ) ) | ( (lv_Value_4_0= ruleGenericValue ) ) | ( (otherlv_5= RULE_ID ) ) )
            int alt32=3;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==22) && (synpred4_InternalOil())) {
                alt32=1;
            }
            else if ( ((LA32_0>=RULE_STRING && LA32_0<=RULE_NON_ZERO_INT)||LA32_0==RULE_HEX||(LA32_0>=24 && LA32_0<=25)) ) {
                alt32=2;
            }
            else if ( (LA32_0==RULE_ID) ) {
                alt32=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1227:2: ( ( ( 'AUTO' ) )=> (lv_Auto_3_0= 'AUTO' ) )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1227:2: ( ( ( 'AUTO' ) )=> (lv_Auto_3_0= 'AUTO' ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1227:3: ( ( 'AUTO' ) )=> (lv_Auto_3_0= 'AUTO' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1234:1: (lv_Auto_3_0= 'AUTO' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1235:3: lv_Auto_3_0= 'AUTO'
                    {
                    lv_Auto_3_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleParameter2484); if (state.failed) return current;
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
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1249:6: ( (lv_Value_4_0= ruleGenericValue ) )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1249:6: ( (lv_Value_4_0= ruleGenericValue ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1250:1: (lv_Value_4_0= ruleGenericValue )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1250:1: (lv_Value_4_0= ruleGenericValue )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1251:3: lv_Value_4_0= ruleGenericValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParameterAccess().getValueGenericValueParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleGenericValue_in_ruleParameter2524);
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
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1268:6: ( (otherlv_5= RULE_ID ) )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1268:6: ( (otherlv_5= RULE_ID ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1269:1: (otherlv_5= RULE_ID )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1269:1: (otherlv_5= RULE_ID )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1270:3: otherlv_5= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getParameterRule());
                      	        }
                              
                    }
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParameter2550); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_5, grammarAccess.getParameterAccess().getValueRefParameterRefCrossReference_3_2_0()); 
                      	
                    }

                    }


                    }


                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1281:3: (otherlv_6= '{' ( (lv_Parameters_7_0= ruleParameter ) )* otherlv_8= '}' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==14) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1281:5: otherlv_6= '{' ( (lv_Parameters_7_0= ruleParameter ) )* otherlv_8= '}'
                    {
                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleParameter2564); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getParameterAccess().getLeftCurlyBracketKeyword_4_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1285:1: ( (lv_Parameters_7_0= ruleParameter ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==RULE_ID) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1286:1: (lv_Parameters_7_0= ruleParameter )
                    	    {
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1286:1: (lv_Parameters_7_0= ruleParameter )
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1287:3: lv_Parameters_7_0= ruleParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getParameterAccess().getParametersParameterParserRuleCall_4_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleParameter_in_ruleParameter2585);
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
                    	    break loop33;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleParameter2598); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getParameterAccess().getRightCurlyBracketKeyword_4_2());
                          
                    }

                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1307:3: (otherlv_9= ':' ( (lv_Description_10_0= RULE_STRING ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==17) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1307:5: otherlv_9= ':' ( (lv_Description_10_0= RULE_STRING ) )
                    {
                    otherlv_9=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleParameter2613); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getParameterAccess().getColonKeyword_5_0());
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1311:1: ( (lv_Description_10_0= RULE_STRING ) )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1312:1: (lv_Description_10_0= RULE_STRING )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1312:1: (lv_Description_10_0= RULE_STRING )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1313:3: lv_Description_10_0= RULE_STRING
                    {
                    lv_Description_10_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleParameter2630); if (state.failed) return current;
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

            otherlv_11=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleParameter2649); if (state.failed) return current;
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


    // $ANTLR start "entryRuleGenericValue"
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1341:1: entryRuleGenericValue returns [String current=null] : iv_ruleGenericValue= ruleGenericValue EOF ;
    public final String entryRuleGenericValue() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleGenericValue = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1342:2: (iv_ruleGenericValue= ruleGenericValue EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1343:2: iv_ruleGenericValue= ruleGenericValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGenericValueRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleGenericValue_in_entryRuleGenericValue2686);
            iv_ruleGenericValue=ruleGenericValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGenericValue.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGenericValue2697); if (state.failed) return current;

            }

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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1350:1: ruleGenericValue returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_INT_1= ruleINT | this_DOUBLE_2= ruleDOUBLE ) ;
    public final AntlrDatatypeRuleToken ruleGenericValue() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        AntlrDatatypeRuleToken this_INT_1 = null;

        AntlrDatatypeRuleToken this_DOUBLE_2 = null;


         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1353:28: ( (this_STRING_0= RULE_STRING | this_INT_1= ruleINT | this_DOUBLE_2= ruleDOUBLE ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1354:1: (this_STRING_0= RULE_STRING | this_INT_1= ruleINT | this_DOUBLE_2= ruleDOUBLE )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1354:1: (this_STRING_0= RULE_STRING | this_INT_1= ruleINT | this_DOUBLE_2= ruleDOUBLE )
            int alt36=3;
            alt36 = dfa36.predict(input);
            switch (alt36) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1354:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleGenericValue2737); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_STRING_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_STRING_0, grammarAccess.getGenericValueAccess().getSTRINGTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1363:5: this_INT_1= ruleINT
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getGenericValueAccess().getINTParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleINT_in_ruleGenericValue2770);
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
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1375:5: this_DOUBLE_2= ruleDOUBLE
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getGenericValueAccess().getDOUBLEParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleDOUBLE_in_ruleGenericValue2803);
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1393:1: entryRuleINT returns [String current=null] : iv_ruleINT= ruleINT EOF ;
    public final String entryRuleINT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINT = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1394:2: (iv_ruleINT= ruleINT EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1395:2: iv_ruleINT= ruleINT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getINTRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleINT_in_entryRuleINT2849);
            iv_ruleINT=ruleINT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleINT.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleINT2860); if (state.failed) return current;

            }

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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1402:1: ruleINT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? ( (this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )* ) | this_HEX_5= RULE_HEX ) ) ;
    public final AntlrDatatypeRuleToken ruleINT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_NON_ZERO_INT_2=null;
        Token this_ZERO_INT_3=null;
        Token this_NON_ZERO_INT_4=null;
        Token this_HEX_5=null;

         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1405:28: ( ( (kw= '+' | kw= '-' )? ( (this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )* ) | this_HEX_5= RULE_HEX ) ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1406:1: ( (kw= '+' | kw= '-' )? ( (this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )* ) | this_HEX_5= RULE_HEX ) )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1406:1: ( (kw= '+' | kw= '-' )? ( (this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )* ) | this_HEX_5= RULE_HEX ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1406:2: (kw= '+' | kw= '-' )? ( (this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )* ) | this_HEX_5= RULE_HEX )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1406:2: (kw= '+' | kw= '-' )?
            int alt37=3;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==24) ) {
                alt37=1;
            }
            else if ( (LA37_0==25) ) {
                alt37=2;
            }
            switch (alt37) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1407:2: kw= '+'
                    {
                    kw=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleINT2899); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getINTAccess().getPlusSignKeyword_0_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1414:2: kw= '-'
                    {
                    kw=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleINT2918); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getINTAccess().getHyphenMinusKeyword_0_1()); 
                          
                    }

                    }
                    break;

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1419:3: ( (this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )* ) | this_HEX_5= RULE_HEX )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==RULE_NON_ZERO_INT) ) {
                alt39=1;
            }
            else if ( (LA39_0==RULE_HEX) ) {
                alt39=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1419:4: (this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )* )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1419:4: (this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )* )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1419:9: this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )*
                    {
                    this_NON_ZERO_INT_2=(Token)match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_ruleINT2937); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_NON_ZERO_INT_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_NON_ZERO_INT_2, grammarAccess.getINTAccess().getNON_ZERO_INTTerminalRuleCall_1_0_0()); 
                          
                    }
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1426:1: (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )*
                    loop38:
                    do {
                        int alt38=3;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==RULE_ZERO_INT) ) {
                            alt38=1;
                        }
                        else if ( (LA38_0==RULE_NON_ZERO_INT) ) {
                            alt38=2;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1426:6: this_ZERO_INT_3= RULE_ZERO_INT
                    	    {
                    	    this_ZERO_INT_3=(Token)match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_ruleINT2958); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		current.merge(this_ZERO_INT_3);
                    	          
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_ZERO_INT_3, grammarAccess.getINTAccess().getZERO_INTTerminalRuleCall_1_0_1_0()); 
                    	          
                    	    }

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1434:10: this_NON_ZERO_INT_4= RULE_NON_ZERO_INT
                    	    {
                    	    this_NON_ZERO_INT_4=(Token)match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_ruleINT2984); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		current.merge(this_NON_ZERO_INT_4);
                    	          
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_NON_ZERO_INT_4, grammarAccess.getINTAccess().getNON_ZERO_INTTerminalRuleCall_1_0_1_1()); 
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop38;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1442:10: this_HEX_5= RULE_HEX
                    {
                    this_HEX_5=(Token)match(input,RULE_HEX,FollowSets000.FOLLOW_RULE_HEX_in_ruleINT3013); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_HEX_5);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_HEX_5, grammarAccess.getINTAccess().getHEXTerminalRuleCall_1_1()); 
                          
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1457:1: entryRuleDOUBLE returns [String current=null] : iv_ruleDOUBLE= ruleDOUBLE EOF ;
    public final String entryRuleDOUBLE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDOUBLE = null;


        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1458:2: (iv_ruleDOUBLE= ruleDOUBLE EOF )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1459:2: iv_ruleDOUBLE= ruleDOUBLE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDOUBLERule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleDOUBLE_in_entryRuleDOUBLE3060);
            iv_ruleDOUBLE=ruleDOUBLE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDOUBLE.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDOUBLE3071); if (state.failed) return current;

            }

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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1466:1: ruleDOUBLE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )* ( ( '.' )=>kw= '.' ) (this_ZERO_INT_6= RULE_ZERO_INT | this_NON_ZERO_INT_7= RULE_NON_ZERO_INT )+ ) ;
    public final AntlrDatatypeRuleToken ruleDOUBLE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_NON_ZERO_INT_2=null;
        Token this_ZERO_INT_3=null;
        Token this_NON_ZERO_INT_4=null;
        Token this_ZERO_INT_6=null;
        Token this_NON_ZERO_INT_7=null;

         enterRule(); 
            
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1469:28: ( ( (kw= '+' | kw= '-' )? this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )* ( ( '.' )=>kw= '.' ) (this_ZERO_INT_6= RULE_ZERO_INT | this_NON_ZERO_INT_7= RULE_NON_ZERO_INT )+ ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1470:1: ( (kw= '+' | kw= '-' )? this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )* ( ( '.' )=>kw= '.' ) (this_ZERO_INT_6= RULE_ZERO_INT | this_NON_ZERO_INT_7= RULE_NON_ZERO_INT )+ )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1470:1: ( (kw= '+' | kw= '-' )? this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )* ( ( '.' )=>kw= '.' ) (this_ZERO_INT_6= RULE_ZERO_INT | this_NON_ZERO_INT_7= RULE_NON_ZERO_INT )+ )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1470:2: (kw= '+' | kw= '-' )? this_NON_ZERO_INT_2= RULE_NON_ZERO_INT (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )* ( ( '.' )=>kw= '.' ) (this_ZERO_INT_6= RULE_ZERO_INT | this_NON_ZERO_INT_7= RULE_NON_ZERO_INT )+
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1470:2: (kw= '+' | kw= '-' )?
            int alt40=3;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==24) ) {
                alt40=1;
            }
            else if ( (LA40_0==25) ) {
                alt40=2;
            }
            switch (alt40) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1471:2: kw= '+'
                    {
                    kw=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleDOUBLE3110); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getDOUBLEAccess().getPlusSignKeyword_0_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1478:2: kw= '-'
                    {
                    kw=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleDOUBLE3129); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getDOUBLEAccess().getHyphenMinusKeyword_0_1()); 
                          
                    }

                    }
                    break;

            }

            this_NON_ZERO_INT_2=(Token)match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_ruleDOUBLE3146); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_NON_ZERO_INT_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NON_ZERO_INT_2, grammarAccess.getDOUBLEAccess().getNON_ZERO_INTTerminalRuleCall_1()); 
                  
            }
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1490:1: (this_ZERO_INT_3= RULE_ZERO_INT | this_NON_ZERO_INT_4= RULE_NON_ZERO_INT )*
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
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1490:6: this_ZERO_INT_3= RULE_ZERO_INT
            	    {
            	    this_ZERO_INT_3=(Token)match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_ruleDOUBLE3167); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ZERO_INT_3);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ZERO_INT_3, grammarAccess.getDOUBLEAccess().getZERO_INTTerminalRuleCall_2_0()); 
            	          
            	    }

            	    }
            	    break;
            	case 2 :
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1498:10: this_NON_ZERO_INT_4= RULE_NON_ZERO_INT
            	    {
            	    this_NON_ZERO_INT_4=(Token)match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_ruleDOUBLE3193); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_NON_ZERO_INT_4);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NON_ZERO_INT_4, grammarAccess.getDOUBLEAccess().getNON_ZERO_INTTerminalRuleCall_2_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1505:3: ( ( '.' )=>kw= '.' )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1505:4: ( '.' )=>kw= '.'
            {
            kw=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleDOUBLE3222); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getDOUBLEAccess().getFullStopKeyword_3()); 
                  
            }

            }

            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1513:2: (this_ZERO_INT_6= RULE_ZERO_INT | this_NON_ZERO_INT_7= RULE_NON_ZERO_INT )+
            int cnt42=0;
            loop42:
            do {
                int alt42=3;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==RULE_ZERO_INT) ) {
                    alt42=1;
                }
                else if ( (LA42_0==RULE_NON_ZERO_INT) ) {
                    alt42=2;
                }


                switch (alt42) {
            	case 1 :
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1513:7: this_ZERO_INT_6= RULE_ZERO_INT
            	    {
            	    this_ZERO_INT_6=(Token)match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_ruleDOUBLE3239); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ZERO_INT_6);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ZERO_INT_6, grammarAccess.getDOUBLEAccess().getZERO_INTTerminalRuleCall_4_0()); 
            	          
            	    }

            	    }
            	    break;
            	case 2 :
            	    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1521:10: this_NON_ZERO_INT_7= RULE_NON_ZERO_INT
            	    {
            	    this_NON_ZERO_INT_7=(Token)match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_ruleDOUBLE3265); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_NON_ZERO_INT_7);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NON_ZERO_INT_7, grammarAccess.getDOUBLEAccess().getNON_ZERO_INTTerminalRuleCall_4_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt42 >= 1 ) break loop42;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(42, input);
                        throw eee;
                }
                cnt42++;
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1536:1: ruleVType returns [Enumerator current=null] : ( (enumLiteral_0= 'STRING' ) | (enumLiteral_1= 'UINT32' ) | (enumLiteral_2= 'INT32' ) | (enumLiteral_3= 'UINT64' ) | (enumLiteral_4= 'INT64' ) | (enumLiteral_5= 'FLOAT' ) | (enumLiteral_6= 'DOUBLE' ) ) ;
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
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1538:28: ( ( (enumLiteral_0= 'STRING' ) | (enumLiteral_1= 'UINT32' ) | (enumLiteral_2= 'INT32' ) | (enumLiteral_3= 'UINT64' ) | (enumLiteral_4= 'INT64' ) | (enumLiteral_5= 'FLOAT' ) | (enumLiteral_6= 'DOUBLE' ) ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1539:1: ( (enumLiteral_0= 'STRING' ) | (enumLiteral_1= 'UINT32' ) | (enumLiteral_2= 'INT32' ) | (enumLiteral_3= 'UINT64' ) | (enumLiteral_4= 'INT64' ) | (enumLiteral_5= 'FLOAT' ) | (enumLiteral_6= 'DOUBLE' ) )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1539:1: ( (enumLiteral_0= 'STRING' ) | (enumLiteral_1= 'UINT32' ) | (enumLiteral_2= 'INT32' ) | (enumLiteral_3= 'UINT64' ) | (enumLiteral_4= 'INT64' ) | (enumLiteral_5= 'FLOAT' ) | (enumLiteral_6= 'DOUBLE' ) )
            int alt43=7;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt43=1;
                }
                break;
            case 28:
                {
                alt43=2;
                }
                break;
            case 29:
                {
                alt43=3;
                }
                break;
            case 30:
                {
                alt43=4;
                }
                break;
            case 31:
                {
                alt43=5;
                }
                break;
            case 32:
                {
                alt43=6;
                }
                break;
            case 33:
                {
                alt43=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1539:2: (enumLiteral_0= 'STRING' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1539:2: (enumLiteral_0= 'STRING' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1539:4: enumLiteral_0= 'STRING'
                    {
                    enumLiteral_0=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleVType3326); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVTypeAccess().getSTRINGEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getVTypeAccess().getSTRINGEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1545:6: (enumLiteral_1= 'UINT32' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1545:6: (enumLiteral_1= 'UINT32' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1545:8: enumLiteral_1= 'UINT32'
                    {
                    enumLiteral_1=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleVType3343); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVTypeAccess().getUINT32EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getVTypeAccess().getUINT32EnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1551:6: (enumLiteral_2= 'INT32' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1551:6: (enumLiteral_2= 'INT32' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1551:8: enumLiteral_2= 'INT32'
                    {
                    enumLiteral_2=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleVType3360); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVTypeAccess().getINT32EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getVTypeAccess().getINT32EnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1557:6: (enumLiteral_3= 'UINT64' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1557:6: (enumLiteral_3= 'UINT64' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1557:8: enumLiteral_3= 'UINT64'
                    {
                    enumLiteral_3=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleVType3377); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVTypeAccess().getUINT64EnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getVTypeAccess().getUINT64EnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1563:6: (enumLiteral_4= 'INT64' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1563:6: (enumLiteral_4= 'INT64' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1563:8: enumLiteral_4= 'INT64'
                    {
                    enumLiteral_4=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleVType3394); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVTypeAccess().getINT64EnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getVTypeAccess().getINT64EnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1569:6: (enumLiteral_5= 'FLOAT' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1569:6: (enumLiteral_5= 'FLOAT' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1569:8: enumLiteral_5= 'FLOAT'
                    {
                    enumLiteral_5=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleVType3411); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVTypeAccess().getFLOATEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getVTypeAccess().getFLOATEnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1575:6: (enumLiteral_6= 'DOUBLE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1575:6: (enumLiteral_6= 'DOUBLE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1575:8: enumLiteral_6= 'DOUBLE'
                    {
                    enumLiteral_6=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleVType3428); if (state.failed) return current;
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1585:1: ruleEType returns [Enumerator current=null] : ( (enumLiteral_0= 'BOOLEAN' ) | (enumLiteral_1= 'ENUM' ) ) ;
    public final Enumerator ruleEType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1587:28: ( ( (enumLiteral_0= 'BOOLEAN' ) | (enumLiteral_1= 'ENUM' ) ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1588:1: ( (enumLiteral_0= 'BOOLEAN' ) | (enumLiteral_1= 'ENUM' ) )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1588:1: ( (enumLiteral_0= 'BOOLEAN' ) | (enumLiteral_1= 'ENUM' ) )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==34) ) {
                alt44=1;
            }
            else if ( (LA44_0==35) ) {
                alt44=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1588:2: (enumLiteral_0= 'BOOLEAN' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1588:2: (enumLiteral_0= 'BOOLEAN' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1588:4: enumLiteral_0= 'BOOLEAN'
                    {
                    enumLiteral_0=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleEType3473); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getETypeAccess().getBOOLEANEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getETypeAccess().getBOOLEANEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1594:6: (enumLiteral_1= 'ENUM' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1594:6: (enumLiteral_1= 'ENUM' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1594:8: enumLiteral_1= 'ENUM'
                    {
                    enumLiteral_1=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleEType3490); if (state.failed) return current;
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1604:1: ruleObjectType returns [Enumerator current=null] : ( (enumLiteral_0= 'OS' ) | (enumLiteral_1= 'ALARM' ) | (enumLiteral_2= 'APPMODE' ) | (enumLiteral_3= 'COUNTER' ) | (enumLiteral_4= 'COM' ) | (enumLiteral_5= 'EVENT' ) | (enumLiteral_6= 'IPDU' ) | (enumLiteral_7= 'ISR' ) | (enumLiteral_8= 'MESSAGE' ) | (enumLiteral_9= 'NETWORKMESSAGE' ) | (enumLiteral_10= 'NM' ) | (enumLiteral_11= 'RESOURCE' ) | (enumLiteral_12= 'TASK' ) ) ;
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
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1606:28: ( ( (enumLiteral_0= 'OS' ) | (enumLiteral_1= 'ALARM' ) | (enumLiteral_2= 'APPMODE' ) | (enumLiteral_3= 'COUNTER' ) | (enumLiteral_4= 'COM' ) | (enumLiteral_5= 'EVENT' ) | (enumLiteral_6= 'IPDU' ) | (enumLiteral_7= 'ISR' ) | (enumLiteral_8= 'MESSAGE' ) | (enumLiteral_9= 'NETWORKMESSAGE' ) | (enumLiteral_10= 'NM' ) | (enumLiteral_11= 'RESOURCE' ) | (enumLiteral_12= 'TASK' ) ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1607:1: ( (enumLiteral_0= 'OS' ) | (enumLiteral_1= 'ALARM' ) | (enumLiteral_2= 'APPMODE' ) | (enumLiteral_3= 'COUNTER' ) | (enumLiteral_4= 'COM' ) | (enumLiteral_5= 'EVENT' ) | (enumLiteral_6= 'IPDU' ) | (enumLiteral_7= 'ISR' ) | (enumLiteral_8= 'MESSAGE' ) | (enumLiteral_9= 'NETWORKMESSAGE' ) | (enumLiteral_10= 'NM' ) | (enumLiteral_11= 'RESOURCE' ) | (enumLiteral_12= 'TASK' ) )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1607:1: ( (enumLiteral_0= 'OS' ) | (enumLiteral_1= 'ALARM' ) | (enumLiteral_2= 'APPMODE' ) | (enumLiteral_3= 'COUNTER' ) | (enumLiteral_4= 'COM' ) | (enumLiteral_5= 'EVENT' ) | (enumLiteral_6= 'IPDU' ) | (enumLiteral_7= 'ISR' ) | (enumLiteral_8= 'MESSAGE' ) | (enumLiteral_9= 'NETWORKMESSAGE' ) | (enumLiteral_10= 'NM' ) | (enumLiteral_11= 'RESOURCE' ) | (enumLiteral_12= 'TASK' ) )
            int alt45=13;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt45=1;
                }
                break;
            case 37:
                {
                alt45=2;
                }
                break;
            case 38:
                {
                alt45=3;
                }
                break;
            case 39:
                {
                alt45=4;
                }
                break;
            case 40:
                {
                alt45=5;
                }
                break;
            case 41:
                {
                alt45=6;
                }
                break;
            case 42:
                {
                alt45=7;
                }
                break;
            case 43:
                {
                alt45=8;
                }
                break;
            case 44:
                {
                alt45=9;
                }
                break;
            case 45:
                {
                alt45=10;
                }
                break;
            case 46:
                {
                alt45=11;
                }
                break;
            case 47:
                {
                alt45=12;
                }
                break;
            case 48:
                {
                alt45=13;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1607:2: (enumLiteral_0= 'OS' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1607:2: (enumLiteral_0= 'OS' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1607:4: enumLiteral_0= 'OS'
                    {
                    enumLiteral_0=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleObjectType3535); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getOSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getObjectTypeAccess().getOSEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1613:6: (enumLiteral_1= 'ALARM' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1613:6: (enumLiteral_1= 'ALARM' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1613:8: enumLiteral_1= 'ALARM'
                    {
                    enumLiteral_1=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleObjectType3552); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getALARMEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getObjectTypeAccess().getALARMEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1619:6: (enumLiteral_2= 'APPMODE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1619:6: (enumLiteral_2= 'APPMODE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1619:8: enumLiteral_2= 'APPMODE'
                    {
                    enumLiteral_2=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleObjectType3569); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getAPPMODEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getObjectTypeAccess().getAPPMODEEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1625:6: (enumLiteral_3= 'COUNTER' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1625:6: (enumLiteral_3= 'COUNTER' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1625:8: enumLiteral_3= 'COUNTER'
                    {
                    enumLiteral_3=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleObjectType3586); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getCOUNTEREnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getObjectTypeAccess().getCOUNTEREnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1631:6: (enumLiteral_4= 'COM' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1631:6: (enumLiteral_4= 'COM' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1631:8: enumLiteral_4= 'COM'
                    {
                    enumLiteral_4=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleObjectType3603); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getCOMEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getObjectTypeAccess().getCOMEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1637:6: (enumLiteral_5= 'EVENT' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1637:6: (enumLiteral_5= 'EVENT' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1637:8: enumLiteral_5= 'EVENT'
                    {
                    enumLiteral_5=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleObjectType3620); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getEVENTEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getObjectTypeAccess().getEVENTEnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1643:6: (enumLiteral_6= 'IPDU' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1643:6: (enumLiteral_6= 'IPDU' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1643:8: enumLiteral_6= 'IPDU'
                    {
                    enumLiteral_6=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleObjectType3637); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getIPDUEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_6, grammarAccess.getObjectTypeAccess().getIPDUEnumLiteralDeclaration_6()); 
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1649:6: (enumLiteral_7= 'ISR' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1649:6: (enumLiteral_7= 'ISR' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1649:8: enumLiteral_7= 'ISR'
                    {
                    enumLiteral_7=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleObjectType3654); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getISREnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_7, grammarAccess.getObjectTypeAccess().getISREnumLiteralDeclaration_7()); 
                          
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1655:6: (enumLiteral_8= 'MESSAGE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1655:6: (enumLiteral_8= 'MESSAGE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1655:8: enumLiteral_8= 'MESSAGE'
                    {
                    enumLiteral_8=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleObjectType3671); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getMESSAGEEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_8, grammarAccess.getObjectTypeAccess().getMESSAGEEnumLiteralDeclaration_8()); 
                          
                    }

                    }


                    }
                    break;
                case 10 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1661:6: (enumLiteral_9= 'NETWORKMESSAGE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1661:6: (enumLiteral_9= 'NETWORKMESSAGE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1661:8: enumLiteral_9= 'NETWORKMESSAGE'
                    {
                    enumLiteral_9=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleObjectType3688); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getNETWORKMESSAGEEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_9, grammarAccess.getObjectTypeAccess().getNETWORKMESSAGEEnumLiteralDeclaration_9()); 
                          
                    }

                    }


                    }
                    break;
                case 11 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1667:6: (enumLiteral_10= 'NM' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1667:6: (enumLiteral_10= 'NM' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1667:8: enumLiteral_10= 'NM'
                    {
                    enumLiteral_10=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleObjectType3705); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getNMEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_10, grammarAccess.getObjectTypeAccess().getNMEnumLiteralDeclaration_10()); 
                          
                    }

                    }


                    }
                    break;
                case 12 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1673:6: (enumLiteral_11= 'RESOURCE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1673:6: (enumLiteral_11= 'RESOURCE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1673:8: enumLiteral_11= 'RESOURCE'
                    {
                    enumLiteral_11=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleObjectType3722); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeAccess().getRESOURCEEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_11, grammarAccess.getObjectTypeAccess().getRESOURCEEnumLiteralDeclaration_11()); 
                          
                    }

                    }


                    }
                    break;
                case 13 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1679:6: (enumLiteral_12= 'TASK' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1679:6: (enumLiteral_12= 'TASK' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1679:8: enumLiteral_12= 'TASK'
                    {
                    enumLiteral_12=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleObjectType3739); if (state.failed) return current;
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
    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1689:1: ruleObjectTypeRef returns [Enumerator current=null] : ( (enumLiteral_0= 'OS_TYPE' ) | (enumLiteral_1= 'ALARM_TYPE' ) | (enumLiteral_2= 'APPMODE_TYPE' ) | (enumLiteral_3= 'COUNTER_TYPE' ) | (enumLiteral_4= 'COM_TYPE' ) | (enumLiteral_5= 'EVENT_TYPE' ) | (enumLiteral_6= 'IPDU_TYPE' ) | (enumLiteral_7= 'ISR_TYPE' ) | (enumLiteral_8= 'MESSAGE_TYPE' ) | (enumLiteral_9= 'NETWORKMESSAGE_TYPE' ) | (enumLiteral_10= 'NM_TYPE' ) | (enumLiteral_11= 'RESOURCE_TYPE' ) | (enumLiteral_12= 'TASK_TYPE' ) ) ;
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
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1691:28: ( ( (enumLiteral_0= 'OS_TYPE' ) | (enumLiteral_1= 'ALARM_TYPE' ) | (enumLiteral_2= 'APPMODE_TYPE' ) | (enumLiteral_3= 'COUNTER_TYPE' ) | (enumLiteral_4= 'COM_TYPE' ) | (enumLiteral_5= 'EVENT_TYPE' ) | (enumLiteral_6= 'IPDU_TYPE' ) | (enumLiteral_7= 'ISR_TYPE' ) | (enumLiteral_8= 'MESSAGE_TYPE' ) | (enumLiteral_9= 'NETWORKMESSAGE_TYPE' ) | (enumLiteral_10= 'NM_TYPE' ) | (enumLiteral_11= 'RESOURCE_TYPE' ) | (enumLiteral_12= 'TASK_TYPE' ) ) )
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1692:1: ( (enumLiteral_0= 'OS_TYPE' ) | (enumLiteral_1= 'ALARM_TYPE' ) | (enumLiteral_2= 'APPMODE_TYPE' ) | (enumLiteral_3= 'COUNTER_TYPE' ) | (enumLiteral_4= 'COM_TYPE' ) | (enumLiteral_5= 'EVENT_TYPE' ) | (enumLiteral_6= 'IPDU_TYPE' ) | (enumLiteral_7= 'ISR_TYPE' ) | (enumLiteral_8= 'MESSAGE_TYPE' ) | (enumLiteral_9= 'NETWORKMESSAGE_TYPE' ) | (enumLiteral_10= 'NM_TYPE' ) | (enumLiteral_11= 'RESOURCE_TYPE' ) | (enumLiteral_12= 'TASK_TYPE' ) )
            {
            // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1692:1: ( (enumLiteral_0= 'OS_TYPE' ) | (enumLiteral_1= 'ALARM_TYPE' ) | (enumLiteral_2= 'APPMODE_TYPE' ) | (enumLiteral_3= 'COUNTER_TYPE' ) | (enumLiteral_4= 'COM_TYPE' ) | (enumLiteral_5= 'EVENT_TYPE' ) | (enumLiteral_6= 'IPDU_TYPE' ) | (enumLiteral_7= 'ISR_TYPE' ) | (enumLiteral_8= 'MESSAGE_TYPE' ) | (enumLiteral_9= 'NETWORKMESSAGE_TYPE' ) | (enumLiteral_10= 'NM_TYPE' ) | (enumLiteral_11= 'RESOURCE_TYPE' ) | (enumLiteral_12= 'TASK_TYPE' ) )
            int alt46=13;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt46=1;
                }
                break;
            case 50:
                {
                alt46=2;
                }
                break;
            case 51:
                {
                alt46=3;
                }
                break;
            case 52:
                {
                alt46=4;
                }
                break;
            case 53:
                {
                alt46=5;
                }
                break;
            case 54:
                {
                alt46=6;
                }
                break;
            case 55:
                {
                alt46=7;
                }
                break;
            case 56:
                {
                alt46=8;
                }
                break;
            case 57:
                {
                alt46=9;
                }
                break;
            case 58:
                {
                alt46=10;
                }
                break;
            case 59:
                {
                alt46=11;
                }
                break;
            case 60:
                {
                alt46=12;
                }
                break;
            case 61:
                {
                alt46=13;
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
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1692:2: (enumLiteral_0= 'OS_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1692:2: (enumLiteral_0= 'OS_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1692:4: enumLiteral_0= 'OS_TYPE'
                    {
                    enumLiteral_0=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleObjectTypeRef3784); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getOSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getObjectTypeRefAccess().getOSEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1698:6: (enumLiteral_1= 'ALARM_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1698:6: (enumLiteral_1= 'ALARM_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1698:8: enumLiteral_1= 'ALARM_TYPE'
                    {
                    enumLiteral_1=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleObjectTypeRef3801); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getALARMEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getObjectTypeRefAccess().getALARMEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1704:6: (enumLiteral_2= 'APPMODE_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1704:6: (enumLiteral_2= 'APPMODE_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1704:8: enumLiteral_2= 'APPMODE_TYPE'
                    {
                    enumLiteral_2=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleObjectTypeRef3818); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getAPPMODEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getObjectTypeRefAccess().getAPPMODEEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1710:6: (enumLiteral_3= 'COUNTER_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1710:6: (enumLiteral_3= 'COUNTER_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1710:8: enumLiteral_3= 'COUNTER_TYPE'
                    {
                    enumLiteral_3=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleObjectTypeRef3835); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getCOUNTEREnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getObjectTypeRefAccess().getCOUNTEREnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1716:6: (enumLiteral_4= 'COM_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1716:6: (enumLiteral_4= 'COM_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1716:8: enumLiteral_4= 'COM_TYPE'
                    {
                    enumLiteral_4=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleObjectTypeRef3852); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getCOMEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getObjectTypeRefAccess().getCOMEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1722:6: (enumLiteral_5= 'EVENT_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1722:6: (enumLiteral_5= 'EVENT_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1722:8: enumLiteral_5= 'EVENT_TYPE'
                    {
                    enumLiteral_5=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleObjectTypeRef3869); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getEVENTEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getObjectTypeRefAccess().getEVENTEnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1728:6: (enumLiteral_6= 'IPDU_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1728:6: (enumLiteral_6= 'IPDU_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1728:8: enumLiteral_6= 'IPDU_TYPE'
                    {
                    enumLiteral_6=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleObjectTypeRef3886); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getIPDUEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_6, grammarAccess.getObjectTypeRefAccess().getIPDUEnumLiteralDeclaration_6()); 
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1734:6: (enumLiteral_7= 'ISR_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1734:6: (enumLiteral_7= 'ISR_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1734:8: enumLiteral_7= 'ISR_TYPE'
                    {
                    enumLiteral_7=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleObjectTypeRef3903); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getISREnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_7, grammarAccess.getObjectTypeRefAccess().getISREnumLiteralDeclaration_7()); 
                          
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1740:6: (enumLiteral_8= 'MESSAGE_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1740:6: (enumLiteral_8= 'MESSAGE_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1740:8: enumLiteral_8= 'MESSAGE_TYPE'
                    {
                    enumLiteral_8=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleObjectTypeRef3920); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getMESSAGEEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_8, grammarAccess.getObjectTypeRefAccess().getMESSAGEEnumLiteralDeclaration_8()); 
                          
                    }

                    }


                    }
                    break;
                case 10 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1746:6: (enumLiteral_9= 'NETWORKMESSAGE_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1746:6: (enumLiteral_9= 'NETWORKMESSAGE_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1746:8: enumLiteral_9= 'NETWORKMESSAGE_TYPE'
                    {
                    enumLiteral_9=(Token)match(input,58,FollowSets000.FOLLOW_58_in_ruleObjectTypeRef3937); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getNETWORKMESSAGEEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_9, grammarAccess.getObjectTypeRefAccess().getNETWORKMESSAGEEnumLiteralDeclaration_9()); 
                          
                    }

                    }


                    }
                    break;
                case 11 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1752:6: (enumLiteral_10= 'NM_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1752:6: (enumLiteral_10= 'NM_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1752:8: enumLiteral_10= 'NM_TYPE'
                    {
                    enumLiteral_10=(Token)match(input,59,FollowSets000.FOLLOW_59_in_ruleObjectTypeRef3954); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getNMEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_10, grammarAccess.getObjectTypeRefAccess().getNMEnumLiteralDeclaration_10()); 
                          
                    }

                    }


                    }
                    break;
                case 12 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1758:6: (enumLiteral_11= 'RESOURCE_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1758:6: (enumLiteral_11= 'RESOURCE_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1758:8: enumLiteral_11= 'RESOURCE_TYPE'
                    {
                    enumLiteral_11=(Token)match(input,60,FollowSets000.FOLLOW_60_in_ruleObjectTypeRef3971); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getObjectTypeRefAccess().getRESOURCEEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_11, grammarAccess.getObjectTypeRefAccess().getRESOURCEEnumLiteralDeclaration_11()); 
                          
                    }

                    }


                    }
                    break;
                case 13 :
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1764:6: (enumLiteral_12= 'TASK_TYPE' )
                    {
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1764:6: (enumLiteral_12= 'TASK_TYPE' )
                    // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1764:8: enumLiteral_12= 'TASK_TYPE'
                    {
                    enumLiteral_12=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleObjectTypeRef3988); if (state.failed) return current;
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
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:523:3: ( ( 'AUTO' ) )
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:524:1: ( 'AUTO' )
        {
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:524:1: ( 'AUTO' )
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:525:2: 'AUTO'
        {
        match(input,22,FollowSets000.FOLLOW_22_in_synpred1_InternalOil1065); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred1_InternalOil

    // $ANTLR start synpred2_InternalOil
    public final void synpred2_InternalOil_fragment() throws RecognitionException {   
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:752:3: ( ( 'AUTO' ) )
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:753:1: ( 'AUTO' )
        {
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:753:1: ( 'AUTO' )
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:754:2: 'AUTO'
        {
        match(input,22,FollowSets000.FOLLOW_22_in_synpred2_InternalOil1503); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred2_InternalOil

    // $ANTLR start synpred3_InternalOil
    public final void synpred3_InternalOil_fragment() throws RecognitionException {   
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1008:3: ( ( 'AUTO' ) )
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1009:1: ( 'AUTO' )
        {
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1009:1: ( 'AUTO' )
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1010:2: 'AUTO'
        {
        match(input,22,FollowSets000.FOLLOW_22_in_synpred3_InternalOil2018); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred3_InternalOil

    // $ANTLR start synpred4_InternalOil
    public final void synpred4_InternalOil_fragment() throws RecognitionException {   
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1227:3: ( ( 'AUTO' ) )
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1228:1: ( 'AUTO' )
        {
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1228:1: ( 'AUTO' )
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1229:2: 'AUTO'
        {
        match(input,22,FollowSets000.FOLLOW_22_in_synpred4_InternalOil2466); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred4_InternalOil

    // $ANTLR start synpred5_InternalOil
    public final void synpred5_InternalOil_fragment() throws RecognitionException {   
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1505:4: ( '.' )
        // ../plugin_rtd_oil_core/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/parser/antlr/internal/InternalOil.g:1506:2: '.'
        {
        match(input,26,FollowSets000.FOLLOW_26_in_synpred5_InternalOil3213); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_InternalOil

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
    public final boolean synpred5_InternalOil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalOil_fragment(); // can never throw exception
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


    protected DFA36 dfa36 = new DFA36(this);
    static final String DFA36_eotS =
        "\11\uffff";
    static final String DFA36_eofS =
        "\4\uffff\1\5\1\uffff\2\5\1\uffff";
    static final String DFA36_minS =
        "\1\5\1\uffff\3\6\1\uffff\2\6\1\uffff";
    static final String DFA36_maxS =
        "\1\31\1\uffff\2\10\1\32\1\uffff\2\32\1\uffff";
    static final String DFA36_acceptS =
        "\1\uffff\1\1\3\uffff\1\2\2\uffff\1\3";
    static final String DFA36_specialS =
        "\11\uffff}>";
    static final String[] DFA36_transitionS = {
            "\1\1\1\4\1\uffff\1\5\17\uffff\1\2\1\3",
            "",
            "\1\4\1\uffff\1\5",
            "\1\4\1\uffff\1\5",
            "\1\7\1\6\6\uffff\1\5\1\uffff\2\5\10\uffff\1\10",
            "",
            "\1\7\1\6\6\uffff\1\5\1\uffff\2\5\10\uffff\1\10",
            "\1\7\1\6\6\uffff\1\5\1\uffff\2\5\10\uffff\1\10",
            ""
    };

    static final short[] DFA36_eot = DFA.unpackEncodedString(DFA36_eotS);
    static final short[] DFA36_eof = DFA.unpackEncodedString(DFA36_eofS);
    static final char[] DFA36_min = DFA.unpackEncodedStringToUnsignedChars(DFA36_minS);
    static final char[] DFA36_max = DFA.unpackEncodedStringToUnsignedChars(DFA36_maxS);
    static final short[] DFA36_accept = DFA.unpackEncodedString(DFA36_acceptS);
    static final short[] DFA36_special = DFA.unpackEncodedString(DFA36_specialS);
    static final short[][] DFA36_transition;

    static {
        int numStates = DFA36_transitionS.length;
        DFA36_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA36_transition[i] = DFA.unpackEncodedString(DFA36_transitionS[i]);
        }
    }

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = DFA36_eot;
            this.eof = DFA36_eof;
            this.min = DFA36_min;
            this.max = DFA36_max;
            this.accept = DFA36_accept;
            this.special = DFA36_special;
            this.transition = DFA36_transition;
        }
        public String getDescription() {
            return "1354:1: (this_STRING_0= RULE_STRING | this_INT_1= ruleINT | this_DOUBLE_2= ruleDOUBLE )";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleOilFile_in_entryRuleOilFile75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOilFile85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilImplementation_in_ruleOilFile131 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_ruleOilApplication_in_ruleOilFile153 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilImplementation_in_entryRuleOilImplementation189 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOilImplementation199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleOilImplementation236 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOilImplementation253 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleOilImplementation270 = new BitSet(new long[]{0x0001FFF000008000L});
        public static final BitSet FOLLOW_ruleOilObjectImpl_in_ruleOilImplementation291 = new BitSet(new long[]{0x0001FFF000008000L});
        public static final BitSet FOLLOW_15_in_ruleOilImplementation304 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleOilImplementation316 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilObjectImpl_in_entryRuleOilObjectImpl352 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOilObjectImpl362 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectType_in_ruleOilObjectImpl408 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleOilObjectImpl420 = new BitSet(new long[]{0x3FFE000FF8008000L});
        public static final BitSet FOLLOW_ruleParameterType_in_ruleOilObjectImpl441 = new BitSet(new long[]{0x3FFE000FF8008000L});
        public static final BitSet FOLLOW_15_in_ruleOilObjectImpl454 = new BitSet(new long[]{0x0000000000030000L});
        public static final BitSet FOLLOW_17_in_ruleOilObjectImpl467 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleOilObjectImpl484 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleOilObjectImpl503 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilApplication_in_entryRuleOilApplication539 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOilApplication549 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleOilApplication586 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOilApplication603 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleOilApplication620 = new BitSet(new long[]{0x0001FFF000008000L});
        public static final BitSet FOLLOW_ruleOilObject_in_ruleOilApplication641 = new BitSet(new long[]{0x0001FFF000008000L});
        public static final BitSet FOLLOW_15_in_ruleOilApplication654 = new BitSet(new long[]{0x0000000000030000L});
        public static final BitSet FOLLOW_17_in_ruleOilApplication667 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleOilApplication684 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleOilApplication703 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameterType_in_entryRuleParameterType739 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParameterType749 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueType_in_ruleParameterType796 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariantType_in_ruleParameterType823 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceType_in_ruleParameterType850 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueType_in_entryRuleValueType885 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleValueType895 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVType_in_ruleValueType950 = new BitSet(new long[]{0x0000000000080010L});
        public static final BitSet FOLLOW_19_in_ruleValueType968 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleValueType999 = new BitSet(new long[]{0x0000000000330000L});
        public static final BitSet FOLLOW_20_in_ruleValueType1022 = new BitSet(new long[]{0x0000000000230000L});
        public static final BitSet FOLLOW_21_in_ruleValueType1049 = new BitSet(new long[]{0x0000000003400170L});
        public static final BitSet FOLLOW_22_in_ruleValueType1083 = new BitSet(new long[]{0x0000000000030000L});
        public static final BitSet FOLLOW_ruleGenericValue_in_ruleValueType1125 = new BitSet(new long[]{0x0000000000030000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleValueType1140 = new BitSet(new long[]{0x0000000000030000L});
        public static final BitSet FOLLOW_17_in_ruleValueType1164 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleValueType1181 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleValueType1200 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariantType_in_entryRuleVariantType1236 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVariantType1246 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEType_in_ruleVariantType1301 = new BitSet(new long[]{0x0000000000080010L});
        public static final BitSet FOLLOW_19_in_ruleVariantType1319 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleVariantType1350 = new BitSet(new long[]{0x0000000000334000L});
        public static final BitSet FOLLOW_20_in_ruleVariantType1373 = new BitSet(new long[]{0x0000000000234000L});
        public static final BitSet FOLLOW_14_in_ruleVariantType1400 = new BitSet(new long[]{0x0000000000008010L});
        public static final BitSet FOLLOW_ruleEnumeratorType_in_ruleVariantType1422 = new BitSet(new long[]{0x0000000000808000L});
        public static final BitSet FOLLOW_23_in_ruleVariantType1435 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleEnumeratorType_in_ruleVariantType1456 = new BitSet(new long[]{0x0000000000808000L});
        public static final BitSet FOLLOW_15_in_ruleVariantType1472 = new BitSet(new long[]{0x0000000000230000L});
        public static final BitSet FOLLOW_21_in_ruleVariantType1487 = new BitSet(new long[]{0x0000000000400010L});
        public static final BitSet FOLLOW_22_in_ruleVariantType1521 = new BitSet(new long[]{0x0000000000030000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleVariantType1557 = new BitSet(new long[]{0x0000000000030000L});
        public static final BitSet FOLLOW_17_in_ruleVariantType1578 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleVariantType1595 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleVariantType1614 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumeratorType_in_entryRuleEnumeratorType1650 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumeratorType1660 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEnumeratorType1711 = new BitSet(new long[]{0x0000000000024002L});
        public static final BitSet FOLLOW_14_in_ruleEnumeratorType1729 = new BitSet(new long[]{0x3FFE000FF8008000L});
        public static final BitSet FOLLOW_ruleParameterType_in_ruleEnumeratorType1750 = new BitSet(new long[]{0x3FFE000FF8008000L});
        public static final BitSet FOLLOW_15_in_ruleEnumeratorType1763 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_17_in_ruleEnumeratorType1778 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEnumeratorType1795 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceType_in_entryRuleReferenceType1838 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceType1848 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectTypeRef_in_ruleReferenceType1903 = new BitSet(new long[]{0x0000000000080010L});
        public static final BitSet FOLLOW_19_in_ruleReferenceType1921 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceType1952 = new BitSet(new long[]{0x0000000000330000L});
        public static final BitSet FOLLOW_20_in_ruleReferenceType1975 = new BitSet(new long[]{0x0000000000230000L});
        public static final BitSet FOLLOW_21_in_ruleReferenceType2002 = new BitSet(new long[]{0x0000000000400010L});
        public static final BitSet FOLLOW_22_in_ruleReferenceType2036 = new BitSet(new long[]{0x0000000000030000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceType2072 = new BitSet(new long[]{0x0000000000030000L});
        public static final BitSet FOLLOW_17_in_ruleReferenceType2093 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleReferenceType2110 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleReferenceType2129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilObject_in_entryRuleOilObject2165 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOilObject2175 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectType_in_ruleOilObject2221 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOilObject2238 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleOilObject2255 = new BitSet(new long[]{0x0000000000008010L});
        public static final BitSet FOLLOW_ruleParameter_in_ruleOilObject2276 = new BitSet(new long[]{0x0000000000008010L});
        public static final BitSet FOLLOW_15_in_ruleOilObject2289 = new BitSet(new long[]{0x0000000000030000L});
        public static final BitSet FOLLOW_17_in_ruleOilObject2302 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleOilObject2319 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleOilObject2338 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter2374 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParameter2384 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleParameter2438 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleParameter2450 = new BitSet(new long[]{0x0000000003400170L});
        public static final BitSet FOLLOW_22_in_ruleParameter2484 = new BitSet(new long[]{0x0000000000034000L});
        public static final BitSet FOLLOW_ruleGenericValue_in_ruleParameter2524 = new BitSet(new long[]{0x0000000000034000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleParameter2550 = new BitSet(new long[]{0x0000000000034000L});
        public static final BitSet FOLLOW_14_in_ruleParameter2564 = new BitSet(new long[]{0x0000000000008010L});
        public static final BitSet FOLLOW_ruleParameter_in_ruleParameter2585 = new BitSet(new long[]{0x0000000000008010L});
        public static final BitSet FOLLOW_15_in_ruleParameter2598 = new BitSet(new long[]{0x0000000000030000L});
        public static final BitSet FOLLOW_17_in_ruleParameter2613 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleParameter2630 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleParameter2649 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGenericValue_in_entryRuleGenericValue2686 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGenericValue2697 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleGenericValue2737 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleINT_in_ruleGenericValue2770 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDOUBLE_in_ruleGenericValue2803 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleINT_in_entryRuleINT2849 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleINT2860 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleINT2899 = new BitSet(new long[]{0x0000000000000140L});
        public static final BitSet FOLLOW_25_in_ruleINT2918 = new BitSet(new long[]{0x0000000000000140L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_ruleINT2937 = new BitSet(new long[]{0x00000000000000C2L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_ruleINT2958 = new BitSet(new long[]{0x00000000000000C2L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_ruleINT2984 = new BitSet(new long[]{0x00000000000000C2L});
        public static final BitSet FOLLOW_RULE_HEX_in_ruleINT3013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDOUBLE_in_entryRuleDOUBLE3060 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDOUBLE3071 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleDOUBLE3110 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_25_in_ruleDOUBLE3129 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_ruleDOUBLE3146 = new BitSet(new long[]{0x00000000040000C0L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_ruleDOUBLE3167 = new BitSet(new long[]{0x00000000040000C0L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_ruleDOUBLE3193 = new BitSet(new long[]{0x00000000040000C0L});
        public static final BitSet FOLLOW_26_in_ruleDOUBLE3222 = new BitSet(new long[]{0x00000000000000C0L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_ruleDOUBLE3239 = new BitSet(new long[]{0x00000000000000C2L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_ruleDOUBLE3265 = new BitSet(new long[]{0x00000000000000C2L});
        public static final BitSet FOLLOW_27_in_ruleVType3326 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleVType3343 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleVType3360 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleVType3377 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleVType3394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleVType3411 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleVType3428 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleEType3473 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleEType3490 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleObjectType3535 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleObjectType3552 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleObjectType3569 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleObjectType3586 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleObjectType3603 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleObjectType3620 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleObjectType3637 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleObjectType3654 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleObjectType3671 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleObjectType3688 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_ruleObjectType3705 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_ruleObjectType3722 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_ruleObjectType3739 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_ruleObjectTypeRef3784 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleObjectTypeRef3801 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_ruleObjectTypeRef3818 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_ruleObjectTypeRef3835 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_ruleObjectTypeRef3852 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_ruleObjectTypeRef3869 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_ruleObjectTypeRef3886 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_ruleObjectTypeRef3903 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_ruleObjectTypeRef3920 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_ruleObjectTypeRef3937 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_59_in_ruleObjectTypeRef3954 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_ruleObjectTypeRef3971 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_ruleObjectTypeRef3988 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_synpred1_InternalOil1065 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_synpred2_InternalOil1503 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_synpred3_InternalOil2018 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_synpred4_InternalOil2466 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_synpred5_InternalOil3213 = new BitSet(new long[]{0x0000000000000002L});
    }


}