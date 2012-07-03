package com.eu.evidence.rtdruid.oil.xtext.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import com.eu.evidence.rtdruid.oil.xtext.services.OilGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalOilParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_HEX", "RULE_ZERO_INT", "RULE_NON_ZERO_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'+'", "'-'", "'STRING'", "'UINT32'", "'INT32'", "'UINT64'", "'INT64'", "'FLOAT'", "'DOUBLE'", "'BOOLEAN'", "'ENUM'", "'OS'", "'ALARM'", "'APPMODE'", "'COUNTER'", "'COM'", "'EVENT'", "'IPDU'", "'ISR'", "'MESSAGE'", "'NETWORKMESSAGE'", "'NM'", "'RESOURCE'", "'TASK'", "'OS_TYPE'", "'ALARM_TYPE'", "'APPMODE_TYPE'", "'COUNTER_TYPE'", "'COM_TYPE'", "'EVENT_TYPE'", "'IPDU_TYPE'", "'ISR_TYPE'", "'MESSAGE_TYPE'", "'NETWORKMESSAGE_TYPE'", "'NM_TYPE'", "'RESOURCE_TYPE'", "'TASK_TYPE'", "'IMPLEMENTATION'", "'{'", "'}'", "';'", "':'", "'CPU'", "'='", "','", "'.'", "'WITH_AUTO'", "'[]'", "'AUTO'"
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
    public static final int RULE_HEX=6;
    public static final int T__58=58;
    public static final int T__16=16;
    public static final int T__51=51;
    public static final int T__15=15;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__18=18;
    public static final int T__54=54;
    public static final int T__17=17;
    public static final int RULE_NON_ZERO_INT=8;
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
    public String getGrammarFileName() { return "../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g"; }


     
     	private OilGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(OilGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleOilFile"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:61:1: entryRuleOilFile : ruleOilFile EOF ;
    public final void entryRuleOilFile() throws RecognitionException {
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:62:1: ( ruleOilFile EOF )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:63:1: ruleOilFile EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOilFile_in_entryRuleOilFile67);
            ruleOilFile();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilFileRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOilFile74); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOilFile"


    // $ANTLR start "ruleOilFile"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:70:1: ruleOilFile : ( ( rule__OilFile__Group__0 ) ) ;
    public final void ruleOilFile() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:74:2: ( ( ( rule__OilFile__Group__0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:75:1: ( ( rule__OilFile__Group__0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:75:1: ( ( rule__OilFile__Group__0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:76:1: ( rule__OilFile__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getGroup()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:77:1: ( rule__OilFile__Group__0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:77:2: rule__OilFile__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group__0_in_ruleOilFile100);
            rule__OilFile__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilFileAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOilFile"


    // $ANTLR start "entryRuleOilImplementation"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:89:1: entryRuleOilImplementation : ruleOilImplementation EOF ;
    public final void entryRuleOilImplementation() throws RecognitionException {
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:90:1: ( ruleOilImplementation EOF )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:91:1: ruleOilImplementation EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOilImplementation_in_entryRuleOilImplementation127);
            ruleOilImplementation();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilImplementationRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOilImplementation134); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOilImplementation"


    // $ANTLR start "ruleOilImplementation"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:98:1: ruleOilImplementation : ( ( rule__OilImplementation__Group__0 ) ) ;
    public final void ruleOilImplementation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:102:2: ( ( ( rule__OilImplementation__Group__0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:103:1: ( ( rule__OilImplementation__Group__0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:103:1: ( ( rule__OilImplementation__Group__0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:104:1: ( rule__OilImplementation__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getGroup()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:105:1: ( rule__OilImplementation__Group__0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:105:2: rule__OilImplementation__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__0_in_ruleOilImplementation160);
            rule__OilImplementation__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilImplementationAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOilImplementation"


    // $ANTLR start "entryRuleOilObjectImpl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:117:1: entryRuleOilObjectImpl : ruleOilObjectImpl EOF ;
    public final void entryRuleOilObjectImpl() throws RecognitionException {
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:118:1: ( ruleOilObjectImpl EOF )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:119:1: ruleOilObjectImpl EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOilObjectImpl_in_entryRuleOilObjectImpl187);
            ruleOilObjectImpl();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectImplRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOilObjectImpl194); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOilObjectImpl"


    // $ANTLR start "ruleOilObjectImpl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:126:1: ruleOilObjectImpl : ( ( rule__OilObjectImpl__Group__0 ) ) ;
    public final void ruleOilObjectImpl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:130:2: ( ( ( rule__OilObjectImpl__Group__0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:131:1: ( ( rule__OilObjectImpl__Group__0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:131:1: ( ( rule__OilObjectImpl__Group__0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:132:1: ( rule__OilObjectImpl__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getGroup()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:133:1: ( rule__OilObjectImpl__Group__0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:133:2: rule__OilObjectImpl__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__0_in_ruleOilObjectImpl220);
            rule__OilObjectImpl__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectImplAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOilObjectImpl"


    // $ANTLR start "entryRuleOilApplication"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:145:1: entryRuleOilApplication : ruleOilApplication EOF ;
    public final void entryRuleOilApplication() throws RecognitionException {
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:146:1: ( ruleOilApplication EOF )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:147:1: ruleOilApplication EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOilApplication_in_entryRuleOilApplication247);
            ruleOilApplication();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilApplicationRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOilApplication254); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOilApplication"


    // $ANTLR start "ruleOilApplication"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:154:1: ruleOilApplication : ( ( rule__OilApplication__Group__0 ) ) ;
    public final void ruleOilApplication() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:158:2: ( ( ( rule__OilApplication__Group__0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:159:1: ( ( rule__OilApplication__Group__0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:159:1: ( ( rule__OilApplication__Group__0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:160:1: ( rule__OilApplication__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getGroup()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:161:1: ( rule__OilApplication__Group__0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:161:2: rule__OilApplication__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__0_in_ruleOilApplication280);
            rule__OilApplication__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilApplicationAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOilApplication"


    // $ANTLR start "entryRuleParameterType"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:173:1: entryRuleParameterType : ruleParameterType EOF ;
    public final void entryRuleParameterType() throws RecognitionException {
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:174:1: ( ruleParameterType EOF )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:175:1: ruleParameterType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameterType_in_entryRuleParameterType307);
            ruleParameterType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterTypeRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParameterType314); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterType"


    // $ANTLR start "ruleParameterType"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:182:1: ruleParameterType : ( ( rule__ParameterType__Alternatives ) ) ;
    public final void ruleParameterType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:186:2: ( ( ( rule__ParameterType__Alternatives ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:187:1: ( ( rule__ParameterType__Alternatives ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:187:1: ( ( rule__ParameterType__Alternatives ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:188:1: ( rule__ParameterType__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterTypeAccess().getAlternatives()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:189:1: ( rule__ParameterType__Alternatives )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:189:2: rule__ParameterType__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__ParameterType__Alternatives_in_ruleParameterType340);
            rule__ParameterType__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterTypeAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameterType"


    // $ANTLR start "entryRuleValueType"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:201:1: entryRuleValueType : ruleValueType EOF ;
    public final void entryRuleValueType() throws RecognitionException {
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:202:1: ( ruleValueType EOF )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:203:1: ruleValueType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleValueType_in_entryRuleValueType367);
            ruleValueType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleValueType374); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleValueType"


    // $ANTLR start "ruleValueType"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:210:1: ruleValueType : ( ( rule__ValueType__Group__0 ) ) ;
    public final void ruleValueType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:214:2: ( ( ( rule__ValueType__Group__0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:215:1: ( ( rule__ValueType__Group__0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:215:1: ( ( rule__ValueType__Group__0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:216:1: ( rule__ValueType__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getGroup()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:217:1: ( rule__ValueType__Group__0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:217:2: rule__ValueType__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__0_in_ruleValueType400);
            rule__ValueType__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleValueType"


    // $ANTLR start "entryRuleVariantType"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:229:1: entryRuleVariantType : ruleVariantType EOF ;
    public final void entryRuleVariantType() throws RecognitionException {
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:230:1: ( ruleVariantType EOF )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:231:1: ruleVariantType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVariantType_in_entryRuleVariantType427);
            ruleVariantType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVariantType434); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVariantType"


    // $ANTLR start "ruleVariantType"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:238:1: ruleVariantType : ( ( rule__VariantType__Group__0 ) ) ;
    public final void ruleVariantType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:242:2: ( ( ( rule__VariantType__Group__0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:243:1: ( ( rule__VariantType__Group__0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:243:1: ( ( rule__VariantType__Group__0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:244:1: ( rule__VariantType__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getGroup()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:245:1: ( rule__VariantType__Group__0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:245:2: rule__VariantType__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__0_in_ruleVariantType460);
            rule__VariantType__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVariantType"


    // $ANTLR start "entryRuleEnumeratorType"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:257:1: entryRuleEnumeratorType : ruleEnumeratorType EOF ;
    public final void entryRuleEnumeratorType() throws RecognitionException {
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:258:1: ( ruleEnumeratorType EOF )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:259:1: ruleEnumeratorType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEnumeratorType_in_entryRuleEnumeratorType487);
            ruleEnumeratorType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumeratorTypeRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumeratorType494); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEnumeratorType"


    // $ANTLR start "ruleEnumeratorType"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:266:1: ruleEnumeratorType : ( ( rule__EnumeratorType__Group__0 ) ) ;
    public final void ruleEnumeratorType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:270:2: ( ( ( rule__EnumeratorType__Group__0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:271:1: ( ( rule__EnumeratorType__Group__0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:271:1: ( ( rule__EnumeratorType__Group__0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:272:1: ( rule__EnumeratorType__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getGroup()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:273:1: ( rule__EnumeratorType__Group__0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:273:2: rule__EnumeratorType__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group__0_in_ruleEnumeratorType520);
            rule__EnumeratorType__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumeratorTypeAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEnumeratorType"


    // $ANTLR start "entryRuleReferenceType"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:285:1: entryRuleReferenceType : ruleReferenceType EOF ;
    public final void entryRuleReferenceType() throws RecognitionException {
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:286:1: ( ruleReferenceType EOF )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:287:1: ruleReferenceType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleReferenceType_in_entryRuleReferenceType547);
            ruleReferenceType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceType554); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleReferenceType"


    // $ANTLR start "ruleReferenceType"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:294:1: ruleReferenceType : ( ( rule__ReferenceType__Group__0 ) ) ;
    public final void ruleReferenceType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:298:2: ( ( ( rule__ReferenceType__Group__0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:299:1: ( ( rule__ReferenceType__Group__0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:299:1: ( ( rule__ReferenceType__Group__0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:300:1: ( rule__ReferenceType__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getGroup()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:301:1: ( rule__ReferenceType__Group__0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:301:2: rule__ReferenceType__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__0_in_ruleReferenceType580);
            rule__ReferenceType__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleReferenceType"


    // $ANTLR start "entryRuleOilObject"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:313:1: entryRuleOilObject : ruleOilObject EOF ;
    public final void entryRuleOilObject() throws RecognitionException {
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:314:1: ( ruleOilObject EOF )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:315:1: ruleOilObject EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOilObject_in_entryRuleOilObject607);
            ruleOilObject();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOilObject614); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOilObject"


    // $ANTLR start "ruleOilObject"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:322:1: ruleOilObject : ( ( rule__OilObject__Group__0 ) ) ;
    public final void ruleOilObject() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:326:2: ( ( ( rule__OilObject__Group__0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:327:1: ( ( rule__OilObject__Group__0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:327:1: ( ( rule__OilObject__Group__0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:328:1: ( rule__OilObject__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getGroup()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:329:1: ( rule__OilObject__Group__0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:329:2: rule__OilObject__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__0_in_ruleOilObject640);
            rule__OilObject__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOilObject"


    // $ANTLR start "entryRuleParameter"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:341:1: entryRuleParameter : ruleParameter EOF ;
    public final void entryRuleParameter() throws RecognitionException {
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:342:1: ( ruleParameter EOF )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:343:1: ruleParameter EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_entryRuleParameter667);
            ruleParameter();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParameter674); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:350:1: ruleParameter : ( ( rule__Parameter__Group__0 ) ) ;
    public final void ruleParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:354:2: ( ( ( rule__Parameter__Group__0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:355:1: ( ( rule__Parameter__Group__0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:355:1: ( ( rule__Parameter__Group__0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:356:1: ( rule__Parameter__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getGroup()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:357:1: ( rule__Parameter__Group__0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:357:2: rule__Parameter__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__0_in_ruleParameter700);
            rule__Parameter__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleGenericValue"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:369:1: entryRuleGenericValue : ruleGenericValue EOF ;
    public final void entryRuleGenericValue() throws RecognitionException {
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:370:1: ( ruleGenericValue EOF )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:371:1: ruleGenericValue EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGenericValueRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleGenericValue_in_entryRuleGenericValue727);
            ruleGenericValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getGenericValueRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGenericValue734); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGenericValue"


    // $ANTLR start "ruleGenericValue"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:378:1: ruleGenericValue : ( ( rule__GenericValue__Alternatives ) ) ;
    public final void ruleGenericValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:382:2: ( ( ( rule__GenericValue__Alternatives ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:383:1: ( ( rule__GenericValue__Alternatives ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:383:1: ( ( rule__GenericValue__Alternatives ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:384:1: ( rule__GenericValue__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGenericValueAccess().getAlternatives()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:385:1: ( rule__GenericValue__Alternatives )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:385:2: rule__GenericValue__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__GenericValue__Alternatives_in_ruleGenericValue760);
            rule__GenericValue__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getGenericValueAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGenericValue"


    // $ANTLR start "entryRuleINT"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:397:1: entryRuleINT : ruleINT EOF ;
    public final void entryRuleINT() throws RecognitionException {
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:398:1: ( ruleINT EOF )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:399:1: ruleINT EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getINTRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleINT_in_entryRuleINT787);
            ruleINT();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getINTRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleINT794); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleINT"


    // $ANTLR start "ruleINT"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:406:1: ruleINT : ( ( rule__INT__Group__0 ) ) ;
    public final void ruleINT() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:410:2: ( ( ( rule__INT__Group__0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:411:1: ( ( rule__INT__Group__0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:411:1: ( ( rule__INT__Group__0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:412:1: ( rule__INT__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getINTAccess().getGroup()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:413:1: ( rule__INT__Group__0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:413:2: rule__INT__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__INT__Group__0_in_ruleINT820);
            rule__INT__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getINTAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleINT"


    // $ANTLR start "entryRuleDOUBLE"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:425:1: entryRuleDOUBLE : ruleDOUBLE EOF ;
    public final void entryRuleDOUBLE() throws RecognitionException {
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:426:1: ( ruleDOUBLE EOF )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:427:1: ruleDOUBLE EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDOUBLERule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleDOUBLE_in_entryRuleDOUBLE847);
            ruleDOUBLE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDOUBLERule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDOUBLE854); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDOUBLE"


    // $ANTLR start "ruleDOUBLE"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:434:1: ruleDOUBLE : ( ( rule__DOUBLE__Group__0 ) ) ;
    public final void ruleDOUBLE() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:438:2: ( ( ( rule__DOUBLE__Group__0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:439:1: ( ( rule__DOUBLE__Group__0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:439:1: ( ( rule__DOUBLE__Group__0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:440:1: ( rule__DOUBLE__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDOUBLEAccess().getGroup()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:441:1: ( rule__DOUBLE__Group__0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:441:2: rule__DOUBLE__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Group__0_in_ruleDOUBLE880);
            rule__DOUBLE__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDOUBLEAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDOUBLE"


    // $ANTLR start "ruleVType"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:454:1: ruleVType : ( ( rule__VType__Alternatives ) ) ;
    public final void ruleVType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:458:1: ( ( ( rule__VType__Alternatives ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:459:1: ( ( rule__VType__Alternatives ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:459:1: ( ( rule__VType__Alternatives ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:460:1: ( rule__VType__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVTypeAccess().getAlternatives()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:461:1: ( rule__VType__Alternatives )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:461:2: rule__VType__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__VType__Alternatives_in_ruleVType917);
            rule__VType__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVTypeAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVType"


    // $ANTLR start "ruleEType"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:473:1: ruleEType : ( ( rule__EType__Alternatives ) ) ;
    public final void ruleEType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:477:1: ( ( ( rule__EType__Alternatives ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:478:1: ( ( rule__EType__Alternatives ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:478:1: ( ( rule__EType__Alternatives ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:479:1: ( rule__EType__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getETypeAccess().getAlternatives()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:480:1: ( rule__EType__Alternatives )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:480:2: rule__EType__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__EType__Alternatives_in_ruleEType953);
            rule__EType__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getETypeAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEType"


    // $ANTLR start "ruleObjectType"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:492:1: ruleObjectType : ( ( rule__ObjectType__Alternatives ) ) ;
    public final void ruleObjectType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:496:1: ( ( ( rule__ObjectType__Alternatives ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:497:1: ( ( rule__ObjectType__Alternatives ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:497:1: ( ( rule__ObjectType__Alternatives ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:498:1: ( rule__ObjectType__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectTypeAccess().getAlternatives()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:499:1: ( rule__ObjectType__Alternatives )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:499:2: rule__ObjectType__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__ObjectType__Alternatives_in_ruleObjectType989);
            rule__ObjectType__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectTypeAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleObjectType"


    // $ANTLR start "ruleObjectTypeRef"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:511:1: ruleObjectTypeRef : ( ( rule__ObjectTypeRef__Alternatives ) ) ;
    public final void ruleObjectTypeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:515:1: ( ( ( rule__ObjectTypeRef__Alternatives ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:516:1: ( ( rule__ObjectTypeRef__Alternatives ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:516:1: ( ( rule__ObjectTypeRef__Alternatives ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:517:1: ( rule__ObjectTypeRef__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectTypeRefAccess().getAlternatives()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:518:1: ( rule__ObjectTypeRef__Alternatives )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:518:2: rule__ObjectTypeRef__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__ObjectTypeRef__Alternatives_in_ruleObjectTypeRef1025);
            rule__ObjectTypeRef__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectTypeRefAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleObjectTypeRef"


    // $ANTLR start "rule__ParameterType__Alternatives"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:529:1: rule__ParameterType__Alternatives : ( ( ruleValueType ) | ( ruleVariantType ) | ( ruleReferenceType ) );
    public final void rule__ParameterType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:533:1: ( ( ruleValueType ) | ( ruleVariantType ) | ( ruleReferenceType ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                {
                alt1=1;
                }
                break;
            case 22:
            case 23:
                {
                alt1=2;
                }
                break;
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                {
                alt1=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:534:1: ( ruleValueType )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:534:1: ( ruleValueType )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:535:1: ruleValueType
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getParameterTypeAccess().getValueTypeParserRuleCall_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleValueType_in_rule__ParameterType__Alternatives1060);
                    ruleValueType();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getParameterTypeAccess().getValueTypeParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:540:6: ( ruleVariantType )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:540:6: ( ruleVariantType )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:541:1: ruleVariantType
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getParameterTypeAccess().getVariantTypeParserRuleCall_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleVariantType_in_rule__ParameterType__Alternatives1077);
                    ruleVariantType();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getParameterTypeAccess().getVariantTypeParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:546:6: ( ruleReferenceType )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:546:6: ( ruleReferenceType )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:547:1: ruleReferenceType
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getParameterTypeAccess().getReferenceTypeParserRuleCall_2()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleReferenceType_in_rule__ParameterType__Alternatives1094);
                    ruleReferenceType();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getParameterTypeAccess().getReferenceTypeParserRuleCall_2()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterType__Alternatives"


    // $ANTLR start "rule__ValueType__Alternatives_5_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:557:1: rule__ValueType__Alternatives_5_1 : ( ( ( rule__ValueType__DefaultAutoAssignment_5_1_0 ) ) | ( ( rule__ValueType__DefaultValueAssignment_5_1_1 ) ) );
    public final void rule__ValueType__Alternatives_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:561:1: ( ( ( rule__ValueType__DefaultAutoAssignment_5_1_0 ) ) | ( ( rule__ValueType__DefaultValueAssignment_5_1_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==61) ) {
                alt2=1;
            }
            else if ( ((LA2_0>=RULE_ID && LA2_0<=RULE_HEX)||LA2_0==RULE_NON_ZERO_INT||(LA2_0>=13 && LA2_0<=14)) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:562:1: ( ( rule__ValueType__DefaultAutoAssignment_5_1_0 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:562:1: ( ( rule__ValueType__DefaultAutoAssignment_5_1_0 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:563:1: ( rule__ValueType__DefaultAutoAssignment_5_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getDefaultAutoAssignment_5_1_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:564:1: ( rule__ValueType__DefaultAutoAssignment_5_1_0 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:564:2: rule__ValueType__DefaultAutoAssignment_5_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ValueType__DefaultAutoAssignment_5_1_0_in_rule__ValueType__Alternatives_5_11126);
                    rule__ValueType__DefaultAutoAssignment_5_1_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueTypeAccess().getDefaultAutoAssignment_5_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:568:6: ( ( rule__ValueType__DefaultValueAssignment_5_1_1 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:568:6: ( ( rule__ValueType__DefaultValueAssignment_5_1_1 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:569:1: ( rule__ValueType__DefaultValueAssignment_5_1_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getDefaultValueAssignment_5_1_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:570:1: ( rule__ValueType__DefaultValueAssignment_5_1_1 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:570:2: rule__ValueType__DefaultValueAssignment_5_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ValueType__DefaultValueAssignment_5_1_1_in_rule__ValueType__Alternatives_5_11144);
                    rule__ValueType__DefaultValueAssignment_5_1_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueTypeAccess().getDefaultValueAssignment_5_1_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Alternatives_5_1"


    // $ANTLR start "rule__ValueType__DefaultValueAlternatives_5_1_1_0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:579:1: rule__ValueType__DefaultValueAlternatives_5_1_1_0 : ( ( ruleGenericValue ) | ( RULE_ID ) );
    public final void rule__ValueType__DefaultValueAlternatives_5_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:583:1: ( ( ruleGenericValue ) | ( RULE_ID ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=RULE_STRING && LA3_0<=RULE_HEX)||LA3_0==RULE_NON_ZERO_INT||(LA3_0>=13 && LA3_0<=14)) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_ID) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:584:1: ( ruleGenericValue )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:584:1: ( ruleGenericValue )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:585:1: ruleGenericValue
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getDefaultValueGenericValueParserRuleCall_5_1_1_0_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleGenericValue_in_rule__ValueType__DefaultValueAlternatives_5_1_1_01177);
                    ruleGenericValue();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueTypeAccess().getDefaultValueGenericValueParserRuleCall_5_1_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:590:6: ( RULE_ID )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:590:6: ( RULE_ID )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:591:1: RULE_ID
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getDefaultValueIDTerminalRuleCall_5_1_1_0_1()); 
                    }
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ValueType__DefaultValueAlternatives_5_1_1_01194); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueTypeAccess().getDefaultValueIDTerminalRuleCall_5_1_1_0_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__DefaultValueAlternatives_5_1_1_0"


    // $ANTLR start "rule__VariantType__Alternatives_6_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:601:1: rule__VariantType__Alternatives_6_1 : ( ( ( rule__VariantType__DefaultAutoAssignment_6_1_0 ) ) | ( ( rule__VariantType__DefaultValueAssignment_6_1_1 ) ) );
    public final void rule__VariantType__Alternatives_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:605:1: ( ( ( rule__VariantType__DefaultAutoAssignment_6_1_0 ) ) | ( ( rule__VariantType__DefaultValueAssignment_6_1_1 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==61) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_ID) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:606:1: ( ( rule__VariantType__DefaultAutoAssignment_6_1_0 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:606:1: ( ( rule__VariantType__DefaultAutoAssignment_6_1_0 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:607:1: ( rule__VariantType__DefaultAutoAssignment_6_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVariantTypeAccess().getDefaultAutoAssignment_6_1_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:608:1: ( rule__VariantType__DefaultAutoAssignment_6_1_0 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:608:2: rule__VariantType__DefaultAutoAssignment_6_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__VariantType__DefaultAutoAssignment_6_1_0_in_rule__VariantType__Alternatives_6_11226);
                    rule__VariantType__DefaultAutoAssignment_6_1_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVariantTypeAccess().getDefaultAutoAssignment_6_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:612:6: ( ( rule__VariantType__DefaultValueAssignment_6_1_1 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:612:6: ( ( rule__VariantType__DefaultValueAssignment_6_1_1 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:613:1: ( rule__VariantType__DefaultValueAssignment_6_1_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVariantTypeAccess().getDefaultValueAssignment_6_1_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:614:1: ( rule__VariantType__DefaultValueAssignment_6_1_1 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:614:2: rule__VariantType__DefaultValueAssignment_6_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__VariantType__DefaultValueAssignment_6_1_1_in_rule__VariantType__Alternatives_6_11244);
                    rule__VariantType__DefaultValueAssignment_6_1_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVariantTypeAccess().getDefaultValueAssignment_6_1_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Alternatives_6_1"


    // $ANTLR start "rule__ReferenceType__Alternatives_5_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:623:1: rule__ReferenceType__Alternatives_5_1 : ( ( ( rule__ReferenceType__DefaultAutoAssignment_5_1_0 ) ) | ( ( rule__ReferenceType__DefaultValueAssignment_5_1_1 ) ) );
    public final void rule__ReferenceType__Alternatives_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:627:1: ( ( ( rule__ReferenceType__DefaultAutoAssignment_5_1_0 ) ) | ( ( rule__ReferenceType__DefaultValueAssignment_5_1_1 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==61) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_ID) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:628:1: ( ( rule__ReferenceType__DefaultAutoAssignment_5_1_0 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:628:1: ( ( rule__ReferenceType__DefaultAutoAssignment_5_1_0 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:629:1: ( rule__ReferenceType__DefaultAutoAssignment_5_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReferenceTypeAccess().getDefaultAutoAssignment_5_1_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:630:1: ( rule__ReferenceType__DefaultAutoAssignment_5_1_0 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:630:2: rule__ReferenceType__DefaultAutoAssignment_5_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__DefaultAutoAssignment_5_1_0_in_rule__ReferenceType__Alternatives_5_11277);
                    rule__ReferenceType__DefaultAutoAssignment_5_1_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getReferenceTypeAccess().getDefaultAutoAssignment_5_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:634:6: ( ( rule__ReferenceType__DefaultValueAssignment_5_1_1 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:634:6: ( ( rule__ReferenceType__DefaultValueAssignment_5_1_1 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:635:1: ( rule__ReferenceType__DefaultValueAssignment_5_1_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReferenceTypeAccess().getDefaultValueAssignment_5_1_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:636:1: ( rule__ReferenceType__DefaultValueAssignment_5_1_1 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:636:2: rule__ReferenceType__DefaultValueAssignment_5_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__DefaultValueAssignment_5_1_1_in_rule__ReferenceType__Alternatives_5_11295);
                    rule__ReferenceType__DefaultValueAssignment_5_1_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getReferenceTypeAccess().getDefaultValueAssignment_5_1_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__Alternatives_5_1"


    // $ANTLR start "rule__Parameter__Alternatives_3"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:645:1: rule__Parameter__Alternatives_3 : ( ( ( rule__Parameter__AutoAssignment_3_0 ) ) | ( ( rule__Parameter__ValueAssignment_3_1 ) ) | ( ( rule__Parameter__ValueRefAssignment_3_2 ) ) );
    public final void rule__Parameter__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:649:1: ( ( ( rule__Parameter__AutoAssignment_3_0 ) ) | ( ( rule__Parameter__ValueAssignment_3_1 ) ) | ( ( rule__Parameter__ValueRefAssignment_3_2 ) ) )
            int alt6=3;
            switch ( input.LA(1) ) {
            case 61:
                {
                alt6=1;
                }
                break;
            case RULE_STRING:
            case RULE_HEX:
            case RULE_NON_ZERO_INT:
            case 13:
            case 14:
                {
                alt6=2;
                }
                break;
            case RULE_ID:
                {
                alt6=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:650:1: ( ( rule__Parameter__AutoAssignment_3_0 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:650:1: ( ( rule__Parameter__AutoAssignment_3_0 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:651:1: ( rule__Parameter__AutoAssignment_3_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getParameterAccess().getAutoAssignment_3_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:652:1: ( rule__Parameter__AutoAssignment_3_0 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:652:2: rule__Parameter__AutoAssignment_3_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Parameter__AutoAssignment_3_0_in_rule__Parameter__Alternatives_31328);
                    rule__Parameter__AutoAssignment_3_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getParameterAccess().getAutoAssignment_3_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:656:6: ( ( rule__Parameter__ValueAssignment_3_1 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:656:6: ( ( rule__Parameter__ValueAssignment_3_1 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:657:1: ( rule__Parameter__ValueAssignment_3_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getParameterAccess().getValueAssignment_3_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:658:1: ( rule__Parameter__ValueAssignment_3_1 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:658:2: rule__Parameter__ValueAssignment_3_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Parameter__ValueAssignment_3_1_in_rule__Parameter__Alternatives_31346);
                    rule__Parameter__ValueAssignment_3_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getParameterAccess().getValueAssignment_3_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:662:6: ( ( rule__Parameter__ValueRefAssignment_3_2 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:662:6: ( ( rule__Parameter__ValueRefAssignment_3_2 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:663:1: ( rule__Parameter__ValueRefAssignment_3_2 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getParameterAccess().getValueRefAssignment_3_2()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:664:1: ( rule__Parameter__ValueRefAssignment_3_2 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:664:2: rule__Parameter__ValueRefAssignment_3_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Parameter__ValueRefAssignment_3_2_in_rule__Parameter__Alternatives_31364);
                    rule__Parameter__ValueRefAssignment_3_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getParameterAccess().getValueRefAssignment_3_2()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Alternatives_3"


    // $ANTLR start "rule__GenericValue__Alternatives"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:673:1: rule__GenericValue__Alternatives : ( ( RULE_STRING ) | ( ruleINT ) | ( ruleDOUBLE ) );
    public final void rule__GenericValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:677:1: ( ( RULE_STRING ) | ( ruleINT ) | ( ruleDOUBLE ) )
            int alt7=3;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:678:1: ( RULE_STRING )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:678:1: ( RULE_STRING )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:679:1: RULE_STRING
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getGenericValueAccess().getSTRINGTerminalRuleCall_0()); 
                    }
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__GenericValue__Alternatives1397); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getGenericValueAccess().getSTRINGTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:684:6: ( ruleINT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:684:6: ( ruleINT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:685:1: ruleINT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getGenericValueAccess().getINTParserRuleCall_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleINT_in_rule__GenericValue__Alternatives1414);
                    ruleINT();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getGenericValueAccess().getINTParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:690:6: ( ruleDOUBLE )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:690:6: ( ruleDOUBLE )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:691:1: ruleDOUBLE
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getGenericValueAccess().getDOUBLEParserRuleCall_2()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleDOUBLE_in_rule__GenericValue__Alternatives1431);
                    ruleDOUBLE();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getGenericValueAccess().getDOUBLEParserRuleCall_2()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenericValue__Alternatives"


    // $ANTLR start "rule__INT__Alternatives_0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:701:1: rule__INT__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__INT__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:705:1: ( ( '+' ) | ( '-' ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==13) ) {
                alt8=1;
            }
            else if ( (LA8_0==14) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:706:1: ( '+' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:706:1: ( '+' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:707:1: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getINTAccess().getPlusSignKeyword_0_0()); 
                    }
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__INT__Alternatives_01464); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getINTAccess().getPlusSignKeyword_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:714:6: ( '-' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:714:6: ( '-' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:715:1: '-'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getINTAccess().getHyphenMinusKeyword_0_1()); 
                    }
                    match(input,14,FollowSets000.FOLLOW_14_in_rule__INT__Alternatives_01484); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getINTAccess().getHyphenMinusKeyword_0_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INT__Alternatives_0"


    // $ANTLR start "rule__INT__Alternatives_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:727:1: rule__INT__Alternatives_1 : ( ( ( rule__INT__Group_1_0__0 ) ) | ( RULE_HEX ) );
    public final void rule__INT__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:731:1: ( ( ( rule__INT__Group_1_0__0 ) ) | ( RULE_HEX ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_NON_ZERO_INT) ) {
                alt9=1;
            }
            else if ( (LA9_0==RULE_HEX) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:732:1: ( ( rule__INT__Group_1_0__0 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:732:1: ( ( rule__INT__Group_1_0__0 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:733:1: ( rule__INT__Group_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getINTAccess().getGroup_1_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:734:1: ( rule__INT__Group_1_0__0 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:734:2: rule__INT__Group_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__INT__Group_1_0__0_in_rule__INT__Alternatives_11518);
                    rule__INT__Group_1_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getINTAccess().getGroup_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:738:6: ( RULE_HEX )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:738:6: ( RULE_HEX )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:739:1: RULE_HEX
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getINTAccess().getHEXTerminalRuleCall_1_1()); 
                    }
                    match(input,RULE_HEX,FollowSets000.FOLLOW_RULE_HEX_in_rule__INT__Alternatives_11536); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getINTAccess().getHEXTerminalRuleCall_1_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INT__Alternatives_1"


    // $ANTLR start "rule__INT__Alternatives_1_0_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:749:1: rule__INT__Alternatives_1_0_1 : ( ( RULE_ZERO_INT ) | ( RULE_NON_ZERO_INT ) );
    public final void rule__INT__Alternatives_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:753:1: ( ( RULE_ZERO_INT ) | ( RULE_NON_ZERO_INT ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ZERO_INT) ) {
                alt10=1;
            }
            else if ( (LA10_0==RULE_NON_ZERO_INT) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:754:1: ( RULE_ZERO_INT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:754:1: ( RULE_ZERO_INT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:755:1: RULE_ZERO_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getINTAccess().getZERO_INTTerminalRuleCall_1_0_1_0()); 
                    }
                    match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_rule__INT__Alternatives_1_0_11568); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getINTAccess().getZERO_INTTerminalRuleCall_1_0_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:760:6: ( RULE_NON_ZERO_INT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:760:6: ( RULE_NON_ZERO_INT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:761:1: RULE_NON_ZERO_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getINTAccess().getNON_ZERO_INTTerminalRuleCall_1_0_1_1()); 
                    }
                    match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_rule__INT__Alternatives_1_0_11585); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getINTAccess().getNON_ZERO_INTTerminalRuleCall_1_0_1_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INT__Alternatives_1_0_1"


    // $ANTLR start "rule__DOUBLE__Alternatives_0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:771:1: rule__DOUBLE__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__DOUBLE__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:775:1: ( ( '+' ) | ( '-' ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==13) ) {
                alt11=1;
            }
            else if ( (LA11_0==14) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:776:1: ( '+' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:776:1: ( '+' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:777:1: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDOUBLEAccess().getPlusSignKeyword_0_0()); 
                    }
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__DOUBLE__Alternatives_01618); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDOUBLEAccess().getPlusSignKeyword_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:784:6: ( '-' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:784:6: ( '-' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:785:1: '-'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDOUBLEAccess().getHyphenMinusKeyword_0_1()); 
                    }
                    match(input,14,FollowSets000.FOLLOW_14_in_rule__DOUBLE__Alternatives_01638); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDOUBLEAccess().getHyphenMinusKeyword_0_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DOUBLE__Alternatives_0"


    // $ANTLR start "rule__DOUBLE__Alternatives_2"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:797:1: rule__DOUBLE__Alternatives_2 : ( ( RULE_ZERO_INT ) | ( RULE_NON_ZERO_INT ) );
    public final void rule__DOUBLE__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:801:1: ( ( RULE_ZERO_INT ) | ( RULE_NON_ZERO_INT ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ZERO_INT) ) {
                alt12=1;
            }
            else if ( (LA12_0==RULE_NON_ZERO_INT) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:802:1: ( RULE_ZERO_INT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:802:1: ( RULE_ZERO_INT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:803:1: RULE_ZERO_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDOUBLEAccess().getZERO_INTTerminalRuleCall_2_0()); 
                    }
                    match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_rule__DOUBLE__Alternatives_21672); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDOUBLEAccess().getZERO_INTTerminalRuleCall_2_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:808:6: ( RULE_NON_ZERO_INT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:808:6: ( RULE_NON_ZERO_INT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:809:1: RULE_NON_ZERO_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDOUBLEAccess().getNON_ZERO_INTTerminalRuleCall_2_1()); 
                    }
                    match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_rule__DOUBLE__Alternatives_21689); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDOUBLEAccess().getNON_ZERO_INTTerminalRuleCall_2_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DOUBLE__Alternatives_2"


    // $ANTLR start "rule__DOUBLE__Alternatives_4"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:819:1: rule__DOUBLE__Alternatives_4 : ( ( RULE_ZERO_INT ) | ( RULE_NON_ZERO_INT ) );
    public final void rule__DOUBLE__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:823:1: ( ( RULE_ZERO_INT ) | ( RULE_NON_ZERO_INT ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ZERO_INT) ) {
                alt13=1;
            }
            else if ( (LA13_0==RULE_NON_ZERO_INT) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:824:1: ( RULE_ZERO_INT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:824:1: ( RULE_ZERO_INT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:825:1: RULE_ZERO_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDOUBLEAccess().getZERO_INTTerminalRuleCall_4_0()); 
                    }
                    match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_rule__DOUBLE__Alternatives_41721); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDOUBLEAccess().getZERO_INTTerminalRuleCall_4_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:830:6: ( RULE_NON_ZERO_INT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:830:6: ( RULE_NON_ZERO_INT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:831:1: RULE_NON_ZERO_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDOUBLEAccess().getNON_ZERO_INTTerminalRuleCall_4_1()); 
                    }
                    match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_rule__DOUBLE__Alternatives_41738); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDOUBLEAccess().getNON_ZERO_INTTerminalRuleCall_4_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DOUBLE__Alternatives_4"


    // $ANTLR start "rule__VType__Alternatives"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:841:1: rule__VType__Alternatives : ( ( ( 'STRING' ) ) | ( ( 'UINT32' ) ) | ( ( 'INT32' ) ) | ( ( 'UINT64' ) ) | ( ( 'INT64' ) ) | ( ( 'FLOAT' ) ) | ( ( 'DOUBLE' ) ) );
    public final void rule__VType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:845:1: ( ( ( 'STRING' ) ) | ( ( 'UINT32' ) ) | ( ( 'INT32' ) ) | ( ( 'UINT64' ) ) | ( ( 'INT64' ) ) | ( ( 'FLOAT' ) ) | ( ( 'DOUBLE' ) ) )
            int alt14=7;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt14=1;
                }
                break;
            case 16:
                {
                alt14=2;
                }
                break;
            case 17:
                {
                alt14=3;
                }
                break;
            case 18:
                {
                alt14=4;
                }
                break;
            case 19:
                {
                alt14=5;
                }
                break;
            case 20:
                {
                alt14=6;
                }
                break;
            case 21:
                {
                alt14=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:846:1: ( ( 'STRING' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:846:1: ( ( 'STRING' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:847:1: ( 'STRING' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVTypeAccess().getSTRINGEnumLiteralDeclaration_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:848:1: ( 'STRING' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:848:3: 'STRING'
                    {
                    match(input,15,FollowSets000.FOLLOW_15_in_rule__VType__Alternatives1771); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVTypeAccess().getSTRINGEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:853:6: ( ( 'UINT32' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:853:6: ( ( 'UINT32' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:854:1: ( 'UINT32' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVTypeAccess().getUINT32EnumLiteralDeclaration_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:855:1: ( 'UINT32' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:855:3: 'UINT32'
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__VType__Alternatives1792); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVTypeAccess().getUINT32EnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:860:6: ( ( 'INT32' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:860:6: ( ( 'INT32' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:861:1: ( 'INT32' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVTypeAccess().getINT32EnumLiteralDeclaration_2()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:862:1: ( 'INT32' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:862:3: 'INT32'
                    {
                    match(input,17,FollowSets000.FOLLOW_17_in_rule__VType__Alternatives1813); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVTypeAccess().getINT32EnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:867:6: ( ( 'UINT64' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:867:6: ( ( 'UINT64' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:868:1: ( 'UINT64' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVTypeAccess().getUINT64EnumLiteralDeclaration_3()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:869:1: ( 'UINT64' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:869:3: 'UINT64'
                    {
                    match(input,18,FollowSets000.FOLLOW_18_in_rule__VType__Alternatives1834); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVTypeAccess().getUINT64EnumLiteralDeclaration_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:874:6: ( ( 'INT64' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:874:6: ( ( 'INT64' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:875:1: ( 'INT64' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVTypeAccess().getINT64EnumLiteralDeclaration_4()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:876:1: ( 'INT64' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:876:3: 'INT64'
                    {
                    match(input,19,FollowSets000.FOLLOW_19_in_rule__VType__Alternatives1855); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVTypeAccess().getINT64EnumLiteralDeclaration_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:881:6: ( ( 'FLOAT' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:881:6: ( ( 'FLOAT' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:882:1: ( 'FLOAT' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVTypeAccess().getFLOATEnumLiteralDeclaration_5()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:883:1: ( 'FLOAT' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:883:3: 'FLOAT'
                    {
                    match(input,20,FollowSets000.FOLLOW_20_in_rule__VType__Alternatives1876); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVTypeAccess().getFLOATEnumLiteralDeclaration_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:888:6: ( ( 'DOUBLE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:888:6: ( ( 'DOUBLE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:889:1: ( 'DOUBLE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVTypeAccess().getDOUBLEEnumLiteralDeclaration_6()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:890:1: ( 'DOUBLE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:890:3: 'DOUBLE'
                    {
                    match(input,21,FollowSets000.FOLLOW_21_in_rule__VType__Alternatives1897); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVTypeAccess().getDOUBLEEnumLiteralDeclaration_6()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VType__Alternatives"


    // $ANTLR start "rule__EType__Alternatives"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:900:1: rule__EType__Alternatives : ( ( ( 'BOOLEAN' ) ) | ( ( 'ENUM' ) ) );
    public final void rule__EType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:904:1: ( ( ( 'BOOLEAN' ) ) | ( ( 'ENUM' ) ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==22) ) {
                alt15=1;
            }
            else if ( (LA15_0==23) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:905:1: ( ( 'BOOLEAN' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:905:1: ( ( 'BOOLEAN' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:906:1: ( 'BOOLEAN' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getETypeAccess().getBOOLEANEnumLiteralDeclaration_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:907:1: ( 'BOOLEAN' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:907:3: 'BOOLEAN'
                    {
                    match(input,22,FollowSets000.FOLLOW_22_in_rule__EType__Alternatives1933); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getETypeAccess().getBOOLEANEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:912:6: ( ( 'ENUM' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:912:6: ( ( 'ENUM' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:913:1: ( 'ENUM' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getETypeAccess().getENUMEnumLiteralDeclaration_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:914:1: ( 'ENUM' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:914:3: 'ENUM'
                    {
                    match(input,23,FollowSets000.FOLLOW_23_in_rule__EType__Alternatives1954); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getETypeAccess().getENUMEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EType__Alternatives"


    // $ANTLR start "rule__ObjectType__Alternatives"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:924:1: rule__ObjectType__Alternatives : ( ( ( 'OS' ) ) | ( ( 'ALARM' ) ) | ( ( 'APPMODE' ) ) | ( ( 'COUNTER' ) ) | ( ( 'COM' ) ) | ( ( 'EVENT' ) ) | ( ( 'IPDU' ) ) | ( ( 'ISR' ) ) | ( ( 'MESSAGE' ) ) | ( ( 'NETWORKMESSAGE' ) ) | ( ( 'NM' ) ) | ( ( 'RESOURCE' ) ) | ( ( 'TASK' ) ) );
    public final void rule__ObjectType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:928:1: ( ( ( 'OS' ) ) | ( ( 'ALARM' ) ) | ( ( 'APPMODE' ) ) | ( ( 'COUNTER' ) ) | ( ( 'COM' ) ) | ( ( 'EVENT' ) ) | ( ( 'IPDU' ) ) | ( ( 'ISR' ) ) | ( ( 'MESSAGE' ) ) | ( ( 'NETWORKMESSAGE' ) ) | ( ( 'NM' ) ) | ( ( 'RESOURCE' ) ) | ( ( 'TASK' ) ) )
            int alt16=13;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt16=1;
                }
                break;
            case 25:
                {
                alt16=2;
                }
                break;
            case 26:
                {
                alt16=3;
                }
                break;
            case 27:
                {
                alt16=4;
                }
                break;
            case 28:
                {
                alt16=5;
                }
                break;
            case 29:
                {
                alt16=6;
                }
                break;
            case 30:
                {
                alt16=7;
                }
                break;
            case 31:
                {
                alt16=8;
                }
                break;
            case 32:
                {
                alt16=9;
                }
                break;
            case 33:
                {
                alt16=10;
                }
                break;
            case 34:
                {
                alt16=11;
                }
                break;
            case 35:
                {
                alt16=12;
                }
                break;
            case 36:
                {
                alt16=13;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:929:1: ( ( 'OS' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:929:1: ( ( 'OS' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:930:1: ( 'OS' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getOSEnumLiteralDeclaration_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:931:1: ( 'OS' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:931:3: 'OS'
                    {
                    match(input,24,FollowSets000.FOLLOW_24_in_rule__ObjectType__Alternatives1990); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getOSEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:936:6: ( ( 'ALARM' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:936:6: ( ( 'ALARM' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:937:1: ( 'ALARM' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getALARMEnumLiteralDeclaration_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:938:1: ( 'ALARM' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:938:3: 'ALARM'
                    {
                    match(input,25,FollowSets000.FOLLOW_25_in_rule__ObjectType__Alternatives2011); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getALARMEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:943:6: ( ( 'APPMODE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:943:6: ( ( 'APPMODE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:944:1: ( 'APPMODE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getAPPMODEEnumLiteralDeclaration_2()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:945:1: ( 'APPMODE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:945:3: 'APPMODE'
                    {
                    match(input,26,FollowSets000.FOLLOW_26_in_rule__ObjectType__Alternatives2032); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getAPPMODEEnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:950:6: ( ( 'COUNTER' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:950:6: ( ( 'COUNTER' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:951:1: ( 'COUNTER' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getCOUNTEREnumLiteralDeclaration_3()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:952:1: ( 'COUNTER' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:952:3: 'COUNTER'
                    {
                    match(input,27,FollowSets000.FOLLOW_27_in_rule__ObjectType__Alternatives2053); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getCOUNTEREnumLiteralDeclaration_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:957:6: ( ( 'COM' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:957:6: ( ( 'COM' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:958:1: ( 'COM' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getCOMEnumLiteralDeclaration_4()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:959:1: ( 'COM' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:959:3: 'COM'
                    {
                    match(input,28,FollowSets000.FOLLOW_28_in_rule__ObjectType__Alternatives2074); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getCOMEnumLiteralDeclaration_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:964:6: ( ( 'EVENT' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:964:6: ( ( 'EVENT' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:965:1: ( 'EVENT' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getEVENTEnumLiteralDeclaration_5()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:966:1: ( 'EVENT' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:966:3: 'EVENT'
                    {
                    match(input,29,FollowSets000.FOLLOW_29_in_rule__ObjectType__Alternatives2095); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getEVENTEnumLiteralDeclaration_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:971:6: ( ( 'IPDU' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:971:6: ( ( 'IPDU' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:972:1: ( 'IPDU' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getIPDUEnumLiteralDeclaration_6()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:973:1: ( 'IPDU' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:973:3: 'IPDU'
                    {
                    match(input,30,FollowSets000.FOLLOW_30_in_rule__ObjectType__Alternatives2116); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getIPDUEnumLiteralDeclaration_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:978:6: ( ( 'ISR' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:978:6: ( ( 'ISR' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:979:1: ( 'ISR' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getISREnumLiteralDeclaration_7()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:980:1: ( 'ISR' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:980:3: 'ISR'
                    {
                    match(input,31,FollowSets000.FOLLOW_31_in_rule__ObjectType__Alternatives2137); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getISREnumLiteralDeclaration_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:985:6: ( ( 'MESSAGE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:985:6: ( ( 'MESSAGE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:986:1: ( 'MESSAGE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getMESSAGEEnumLiteralDeclaration_8()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:987:1: ( 'MESSAGE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:987:3: 'MESSAGE'
                    {
                    match(input,32,FollowSets000.FOLLOW_32_in_rule__ObjectType__Alternatives2158); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getMESSAGEEnumLiteralDeclaration_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:992:6: ( ( 'NETWORKMESSAGE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:992:6: ( ( 'NETWORKMESSAGE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:993:1: ( 'NETWORKMESSAGE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getNETWORKMESSAGEEnumLiteralDeclaration_9()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:994:1: ( 'NETWORKMESSAGE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:994:3: 'NETWORKMESSAGE'
                    {
                    match(input,33,FollowSets000.FOLLOW_33_in_rule__ObjectType__Alternatives2179); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getNETWORKMESSAGEEnumLiteralDeclaration_9()); 
                    }

                    }


                    }
                    break;
                case 11 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:999:6: ( ( 'NM' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:999:6: ( ( 'NM' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1000:1: ( 'NM' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getNMEnumLiteralDeclaration_10()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1001:1: ( 'NM' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1001:3: 'NM'
                    {
                    match(input,34,FollowSets000.FOLLOW_34_in_rule__ObjectType__Alternatives2200); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getNMEnumLiteralDeclaration_10()); 
                    }

                    }


                    }
                    break;
                case 12 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1006:6: ( ( 'RESOURCE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1006:6: ( ( 'RESOURCE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1007:1: ( 'RESOURCE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getRESOURCEEnumLiteralDeclaration_11()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1008:1: ( 'RESOURCE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1008:3: 'RESOURCE'
                    {
                    match(input,35,FollowSets000.FOLLOW_35_in_rule__ObjectType__Alternatives2221); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getRESOURCEEnumLiteralDeclaration_11()); 
                    }

                    }


                    }
                    break;
                case 13 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1013:6: ( ( 'TASK' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1013:6: ( ( 'TASK' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1014:1: ( 'TASK' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getTASKEnumLiteralDeclaration_12()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1015:1: ( 'TASK' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1015:3: 'TASK'
                    {
                    match(input,36,FollowSets000.FOLLOW_36_in_rule__ObjectType__Alternatives2242); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getTASKEnumLiteralDeclaration_12()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectType__Alternatives"


    // $ANTLR start "rule__ObjectTypeRef__Alternatives"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1025:1: rule__ObjectTypeRef__Alternatives : ( ( ( 'OS_TYPE' ) ) | ( ( 'ALARM_TYPE' ) ) | ( ( 'APPMODE_TYPE' ) ) | ( ( 'COUNTER_TYPE' ) ) | ( ( 'COM_TYPE' ) ) | ( ( 'EVENT_TYPE' ) ) | ( ( 'IPDU_TYPE' ) ) | ( ( 'ISR_TYPE' ) ) | ( ( 'MESSAGE_TYPE' ) ) | ( ( 'NETWORKMESSAGE_TYPE' ) ) | ( ( 'NM_TYPE' ) ) | ( ( 'RESOURCE_TYPE' ) ) | ( ( 'TASK_TYPE' ) ) );
    public final void rule__ObjectTypeRef__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1029:1: ( ( ( 'OS_TYPE' ) ) | ( ( 'ALARM_TYPE' ) ) | ( ( 'APPMODE_TYPE' ) ) | ( ( 'COUNTER_TYPE' ) ) | ( ( 'COM_TYPE' ) ) | ( ( 'EVENT_TYPE' ) ) | ( ( 'IPDU_TYPE' ) ) | ( ( 'ISR_TYPE' ) ) | ( ( 'MESSAGE_TYPE' ) ) | ( ( 'NETWORKMESSAGE_TYPE' ) ) | ( ( 'NM_TYPE' ) ) | ( ( 'RESOURCE_TYPE' ) ) | ( ( 'TASK_TYPE' ) ) )
            int alt17=13;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt17=1;
                }
                break;
            case 38:
                {
                alt17=2;
                }
                break;
            case 39:
                {
                alt17=3;
                }
                break;
            case 40:
                {
                alt17=4;
                }
                break;
            case 41:
                {
                alt17=5;
                }
                break;
            case 42:
                {
                alt17=6;
                }
                break;
            case 43:
                {
                alt17=7;
                }
                break;
            case 44:
                {
                alt17=8;
                }
                break;
            case 45:
                {
                alt17=9;
                }
                break;
            case 46:
                {
                alt17=10;
                }
                break;
            case 47:
                {
                alt17=11;
                }
                break;
            case 48:
                {
                alt17=12;
                }
                break;
            case 49:
                {
                alt17=13;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1030:1: ( ( 'OS_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1030:1: ( ( 'OS_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1031:1: ( 'OS_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getOSEnumLiteralDeclaration_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1032:1: ( 'OS_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1032:3: 'OS_TYPE'
                    {
                    match(input,37,FollowSets000.FOLLOW_37_in_rule__ObjectTypeRef__Alternatives2278); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getOSEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1037:6: ( ( 'ALARM_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1037:6: ( ( 'ALARM_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1038:1: ( 'ALARM_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getALARMEnumLiteralDeclaration_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1039:1: ( 'ALARM_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1039:3: 'ALARM_TYPE'
                    {
                    match(input,38,FollowSets000.FOLLOW_38_in_rule__ObjectTypeRef__Alternatives2299); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getALARMEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1044:6: ( ( 'APPMODE_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1044:6: ( ( 'APPMODE_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1045:1: ( 'APPMODE_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getAPPMODEEnumLiteralDeclaration_2()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1046:1: ( 'APPMODE_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1046:3: 'APPMODE_TYPE'
                    {
                    match(input,39,FollowSets000.FOLLOW_39_in_rule__ObjectTypeRef__Alternatives2320); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getAPPMODEEnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1051:6: ( ( 'COUNTER_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1051:6: ( ( 'COUNTER_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1052:1: ( 'COUNTER_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getCOUNTEREnumLiteralDeclaration_3()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1053:1: ( 'COUNTER_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1053:3: 'COUNTER_TYPE'
                    {
                    match(input,40,FollowSets000.FOLLOW_40_in_rule__ObjectTypeRef__Alternatives2341); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getCOUNTEREnumLiteralDeclaration_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1058:6: ( ( 'COM_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1058:6: ( ( 'COM_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1059:1: ( 'COM_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getCOMEnumLiteralDeclaration_4()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1060:1: ( 'COM_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1060:3: 'COM_TYPE'
                    {
                    match(input,41,FollowSets000.FOLLOW_41_in_rule__ObjectTypeRef__Alternatives2362); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getCOMEnumLiteralDeclaration_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1065:6: ( ( 'EVENT_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1065:6: ( ( 'EVENT_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1066:1: ( 'EVENT_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getEVENTEnumLiteralDeclaration_5()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1067:1: ( 'EVENT_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1067:3: 'EVENT_TYPE'
                    {
                    match(input,42,FollowSets000.FOLLOW_42_in_rule__ObjectTypeRef__Alternatives2383); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getEVENTEnumLiteralDeclaration_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1072:6: ( ( 'IPDU_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1072:6: ( ( 'IPDU_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1073:1: ( 'IPDU_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getIPDUEnumLiteralDeclaration_6()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1074:1: ( 'IPDU_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1074:3: 'IPDU_TYPE'
                    {
                    match(input,43,FollowSets000.FOLLOW_43_in_rule__ObjectTypeRef__Alternatives2404); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getIPDUEnumLiteralDeclaration_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1079:6: ( ( 'ISR_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1079:6: ( ( 'ISR_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1080:1: ( 'ISR_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getISREnumLiteralDeclaration_7()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1081:1: ( 'ISR_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1081:3: 'ISR_TYPE'
                    {
                    match(input,44,FollowSets000.FOLLOW_44_in_rule__ObjectTypeRef__Alternatives2425); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getISREnumLiteralDeclaration_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1086:6: ( ( 'MESSAGE_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1086:6: ( ( 'MESSAGE_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1087:1: ( 'MESSAGE_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getMESSAGEEnumLiteralDeclaration_8()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1088:1: ( 'MESSAGE_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1088:3: 'MESSAGE_TYPE'
                    {
                    match(input,45,FollowSets000.FOLLOW_45_in_rule__ObjectTypeRef__Alternatives2446); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getMESSAGEEnumLiteralDeclaration_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1093:6: ( ( 'NETWORKMESSAGE_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1093:6: ( ( 'NETWORKMESSAGE_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1094:1: ( 'NETWORKMESSAGE_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getNETWORKMESSAGEEnumLiteralDeclaration_9()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1095:1: ( 'NETWORKMESSAGE_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1095:3: 'NETWORKMESSAGE_TYPE'
                    {
                    match(input,46,FollowSets000.FOLLOW_46_in_rule__ObjectTypeRef__Alternatives2467); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getNETWORKMESSAGEEnumLiteralDeclaration_9()); 
                    }

                    }


                    }
                    break;
                case 11 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1100:6: ( ( 'NM_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1100:6: ( ( 'NM_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1101:1: ( 'NM_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getNMEnumLiteralDeclaration_10()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1102:1: ( 'NM_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1102:3: 'NM_TYPE'
                    {
                    match(input,47,FollowSets000.FOLLOW_47_in_rule__ObjectTypeRef__Alternatives2488); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getNMEnumLiteralDeclaration_10()); 
                    }

                    }


                    }
                    break;
                case 12 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1107:6: ( ( 'RESOURCE_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1107:6: ( ( 'RESOURCE_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1108:1: ( 'RESOURCE_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getRESOURCEEnumLiteralDeclaration_11()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1109:1: ( 'RESOURCE_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1109:3: 'RESOURCE_TYPE'
                    {
                    match(input,48,FollowSets000.FOLLOW_48_in_rule__ObjectTypeRef__Alternatives2509); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getRESOURCEEnumLiteralDeclaration_11()); 
                    }

                    }


                    }
                    break;
                case 13 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1114:6: ( ( 'TASK_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1114:6: ( ( 'TASK_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1115:1: ( 'TASK_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getTASKEnumLiteralDeclaration_12()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1116:1: ( 'TASK_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1116:3: 'TASK_TYPE'
                    {
                    match(input,49,FollowSets000.FOLLOW_49_in_rule__ObjectTypeRef__Alternatives2530); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getTASKEnumLiteralDeclaration_12()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectTypeRef__Alternatives"


    // $ANTLR start "rule__OilFile__Group__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1128:1: rule__OilFile__Group__0 : rule__OilFile__Group__0__Impl rule__OilFile__Group__1 ;
    public final void rule__OilFile__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1132:1: ( rule__OilFile__Group__0__Impl rule__OilFile__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1133:2: rule__OilFile__Group__0__Impl rule__OilFile__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group__0__Impl_in_rule__OilFile__Group__02563);
            rule__OilFile__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group__1_in_rule__OilFile__Group__02566);
            rule__OilFile__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilFile__Group__0"


    // $ANTLR start "rule__OilFile__Group__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1140:1: rule__OilFile__Group__0__Impl : ( ( rule__OilFile__ImplementationAssignment_0 )? ) ;
    public final void rule__OilFile__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1144:1: ( ( ( rule__OilFile__ImplementationAssignment_0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1145:1: ( ( rule__OilFile__ImplementationAssignment_0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1145:1: ( ( rule__OilFile__ImplementationAssignment_0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1146:1: ( rule__OilFile__ImplementationAssignment_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getImplementationAssignment_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1147:1: ( rule__OilFile__ImplementationAssignment_0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==50) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1147:2: rule__OilFile__ImplementationAssignment_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__OilFile__ImplementationAssignment_0_in_rule__OilFile__Group__0__Impl2593);
                    rule__OilFile__ImplementationAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilFileAccess().getImplementationAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilFile__Group__0__Impl"


    // $ANTLR start "rule__OilFile__Group__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1157:1: rule__OilFile__Group__1 : rule__OilFile__Group__1__Impl ;
    public final void rule__OilFile__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1161:1: ( rule__OilFile__Group__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1162:2: rule__OilFile__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group__1__Impl_in_rule__OilFile__Group__12624);
            rule__OilFile__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilFile__Group__1"


    // $ANTLR start "rule__OilFile__Group__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1168:1: rule__OilFile__Group__1__Impl : ( ( rule__OilFile__ApplicationAssignment_1 ) ) ;
    public final void rule__OilFile__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1172:1: ( ( ( rule__OilFile__ApplicationAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1173:1: ( ( rule__OilFile__ApplicationAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1173:1: ( ( rule__OilFile__ApplicationAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1174:1: ( rule__OilFile__ApplicationAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getApplicationAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1175:1: ( rule__OilFile__ApplicationAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1175:2: rule__OilFile__ApplicationAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__ApplicationAssignment_1_in_rule__OilFile__Group__1__Impl2651);
            rule__OilFile__ApplicationAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilFileAccess().getApplicationAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilFile__Group__1__Impl"


    // $ANTLR start "rule__OilImplementation__Group__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1189:1: rule__OilImplementation__Group__0 : rule__OilImplementation__Group__0__Impl rule__OilImplementation__Group__1 ;
    public final void rule__OilImplementation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1193:1: ( rule__OilImplementation__Group__0__Impl rule__OilImplementation__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1194:2: rule__OilImplementation__Group__0__Impl rule__OilImplementation__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__0__Impl_in_rule__OilImplementation__Group__02685);
            rule__OilImplementation__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__1_in_rule__OilImplementation__Group__02688);
            rule__OilImplementation__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilImplementation__Group__0"


    // $ANTLR start "rule__OilImplementation__Group__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1201:1: rule__OilImplementation__Group__0__Impl : ( 'IMPLEMENTATION' ) ;
    public final void rule__OilImplementation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1205:1: ( ( 'IMPLEMENTATION' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1206:1: ( 'IMPLEMENTATION' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1206:1: ( 'IMPLEMENTATION' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1207:1: 'IMPLEMENTATION'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getIMPLEMENTATIONKeyword_0()); 
            }
            match(input,50,FollowSets000.FOLLOW_50_in_rule__OilImplementation__Group__0__Impl2716); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilImplementationAccess().getIMPLEMENTATIONKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilImplementation__Group__0__Impl"


    // $ANTLR start "rule__OilImplementation__Group__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1220:1: rule__OilImplementation__Group__1 : rule__OilImplementation__Group__1__Impl rule__OilImplementation__Group__2 ;
    public final void rule__OilImplementation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1224:1: ( rule__OilImplementation__Group__1__Impl rule__OilImplementation__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1225:2: rule__OilImplementation__Group__1__Impl rule__OilImplementation__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__1__Impl_in_rule__OilImplementation__Group__12747);
            rule__OilImplementation__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__2_in_rule__OilImplementation__Group__12750);
            rule__OilImplementation__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilImplementation__Group__1"


    // $ANTLR start "rule__OilImplementation__Group__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1232:1: rule__OilImplementation__Group__1__Impl : ( ( rule__OilImplementation__NameAssignment_1 ) ) ;
    public final void rule__OilImplementation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1236:1: ( ( ( rule__OilImplementation__NameAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1237:1: ( ( rule__OilImplementation__NameAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1237:1: ( ( rule__OilImplementation__NameAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1238:1: ( rule__OilImplementation__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getNameAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1239:1: ( rule__OilImplementation__NameAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1239:2: rule__OilImplementation__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__NameAssignment_1_in_rule__OilImplementation__Group__1__Impl2777);
            rule__OilImplementation__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilImplementationAccess().getNameAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilImplementation__Group__1__Impl"


    // $ANTLR start "rule__OilImplementation__Group__2"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1249:1: rule__OilImplementation__Group__2 : rule__OilImplementation__Group__2__Impl rule__OilImplementation__Group__3 ;
    public final void rule__OilImplementation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1253:1: ( rule__OilImplementation__Group__2__Impl rule__OilImplementation__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1254:2: rule__OilImplementation__Group__2__Impl rule__OilImplementation__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__2__Impl_in_rule__OilImplementation__Group__22807);
            rule__OilImplementation__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__3_in_rule__OilImplementation__Group__22810);
            rule__OilImplementation__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilImplementation__Group__2"


    // $ANTLR start "rule__OilImplementation__Group__2__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1261:1: rule__OilImplementation__Group__2__Impl : ( '{' ) ;
    public final void rule__OilImplementation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1265:1: ( ( '{' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1266:1: ( '{' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1266:1: ( '{' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1267:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,51,FollowSets000.FOLLOW_51_in_rule__OilImplementation__Group__2__Impl2838); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilImplementationAccess().getLeftCurlyBracketKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilImplementation__Group__2__Impl"


    // $ANTLR start "rule__OilImplementation__Group__3"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1280:1: rule__OilImplementation__Group__3 : rule__OilImplementation__Group__3__Impl rule__OilImplementation__Group__4 ;
    public final void rule__OilImplementation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1284:1: ( rule__OilImplementation__Group__3__Impl rule__OilImplementation__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1285:2: rule__OilImplementation__Group__3__Impl rule__OilImplementation__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__3__Impl_in_rule__OilImplementation__Group__32869);
            rule__OilImplementation__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__4_in_rule__OilImplementation__Group__32872);
            rule__OilImplementation__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilImplementation__Group__3"


    // $ANTLR start "rule__OilImplementation__Group__3__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1292:1: rule__OilImplementation__Group__3__Impl : ( ( rule__OilImplementation__OilObjectsAssignment_3 )* ) ;
    public final void rule__OilImplementation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1296:1: ( ( ( rule__OilImplementation__OilObjectsAssignment_3 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1297:1: ( ( rule__OilImplementation__OilObjectsAssignment_3 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1297:1: ( ( rule__OilImplementation__OilObjectsAssignment_3 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1298:1: ( rule__OilImplementation__OilObjectsAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getOilObjectsAssignment_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1299:1: ( rule__OilImplementation__OilObjectsAssignment_3 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=24 && LA19_0<=36)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1299:2: rule__OilImplementation__OilObjectsAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__OilObjectsAssignment_3_in_rule__OilImplementation__Group__3__Impl2899);
            	    rule__OilImplementation__OilObjectsAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilImplementationAccess().getOilObjectsAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilImplementation__Group__3__Impl"


    // $ANTLR start "rule__OilImplementation__Group__4"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1309:1: rule__OilImplementation__Group__4 : rule__OilImplementation__Group__4__Impl rule__OilImplementation__Group__5 ;
    public final void rule__OilImplementation__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1313:1: ( rule__OilImplementation__Group__4__Impl rule__OilImplementation__Group__5 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1314:2: rule__OilImplementation__Group__4__Impl rule__OilImplementation__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__4__Impl_in_rule__OilImplementation__Group__42930);
            rule__OilImplementation__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__5_in_rule__OilImplementation__Group__42933);
            rule__OilImplementation__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilImplementation__Group__4"


    // $ANTLR start "rule__OilImplementation__Group__4__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1321:1: rule__OilImplementation__Group__4__Impl : ( '}' ) ;
    public final void rule__OilImplementation__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1325:1: ( ( '}' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1326:1: ( '}' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1326:1: ( '}' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1327:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,52,FollowSets000.FOLLOW_52_in_rule__OilImplementation__Group__4__Impl2961); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilImplementationAccess().getRightCurlyBracketKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilImplementation__Group__4__Impl"


    // $ANTLR start "rule__OilImplementation__Group__5"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1340:1: rule__OilImplementation__Group__5 : rule__OilImplementation__Group__5__Impl ;
    public final void rule__OilImplementation__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1344:1: ( rule__OilImplementation__Group__5__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1345:2: rule__OilImplementation__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__5__Impl_in_rule__OilImplementation__Group__52992);
            rule__OilImplementation__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilImplementation__Group__5"


    // $ANTLR start "rule__OilImplementation__Group__5__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1351:1: rule__OilImplementation__Group__5__Impl : ( ';' ) ;
    public final void rule__OilImplementation__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1355:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1356:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1356:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1357:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getSemicolonKeyword_5()); 
            }
            match(input,53,FollowSets000.FOLLOW_53_in_rule__OilImplementation__Group__5__Impl3020); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilImplementationAccess().getSemicolonKeyword_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilImplementation__Group__5__Impl"


    // $ANTLR start "rule__OilObjectImpl__Group__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1382:1: rule__OilObjectImpl__Group__0 : rule__OilObjectImpl__Group__0__Impl rule__OilObjectImpl__Group__1 ;
    public final void rule__OilObjectImpl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1386:1: ( rule__OilObjectImpl__Group__0__Impl rule__OilObjectImpl__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1387:2: rule__OilObjectImpl__Group__0__Impl rule__OilObjectImpl__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__0__Impl_in_rule__OilObjectImpl__Group__03063);
            rule__OilObjectImpl__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__1_in_rule__OilObjectImpl__Group__03066);
            rule__OilObjectImpl__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObjectImpl__Group__0"


    // $ANTLR start "rule__OilObjectImpl__Group__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1394:1: rule__OilObjectImpl__Group__0__Impl : ( ( rule__OilObjectImpl__TypeAssignment_0 ) ) ;
    public final void rule__OilObjectImpl__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1398:1: ( ( ( rule__OilObjectImpl__TypeAssignment_0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1399:1: ( ( rule__OilObjectImpl__TypeAssignment_0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1399:1: ( ( rule__OilObjectImpl__TypeAssignment_0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1400:1: ( rule__OilObjectImpl__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getTypeAssignment_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1401:1: ( rule__OilObjectImpl__TypeAssignment_0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1401:2: rule__OilObjectImpl__TypeAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__TypeAssignment_0_in_rule__OilObjectImpl__Group__0__Impl3093);
            rule__OilObjectImpl__TypeAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectImplAccess().getTypeAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObjectImpl__Group__0__Impl"


    // $ANTLR start "rule__OilObjectImpl__Group__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1411:1: rule__OilObjectImpl__Group__1 : rule__OilObjectImpl__Group__1__Impl rule__OilObjectImpl__Group__2 ;
    public final void rule__OilObjectImpl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1415:1: ( rule__OilObjectImpl__Group__1__Impl rule__OilObjectImpl__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1416:2: rule__OilObjectImpl__Group__1__Impl rule__OilObjectImpl__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__1__Impl_in_rule__OilObjectImpl__Group__13123);
            rule__OilObjectImpl__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__2_in_rule__OilObjectImpl__Group__13126);
            rule__OilObjectImpl__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObjectImpl__Group__1"


    // $ANTLR start "rule__OilObjectImpl__Group__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1423:1: rule__OilObjectImpl__Group__1__Impl : ( '{' ) ;
    public final void rule__OilObjectImpl__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1427:1: ( ( '{' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1428:1: ( '{' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1428:1: ( '{' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1429:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,51,FollowSets000.FOLLOW_51_in_rule__OilObjectImpl__Group__1__Impl3154); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectImplAccess().getLeftCurlyBracketKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObjectImpl__Group__1__Impl"


    // $ANTLR start "rule__OilObjectImpl__Group__2"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1442:1: rule__OilObjectImpl__Group__2 : rule__OilObjectImpl__Group__2__Impl rule__OilObjectImpl__Group__3 ;
    public final void rule__OilObjectImpl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1446:1: ( rule__OilObjectImpl__Group__2__Impl rule__OilObjectImpl__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1447:2: rule__OilObjectImpl__Group__2__Impl rule__OilObjectImpl__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__2__Impl_in_rule__OilObjectImpl__Group__23185);
            rule__OilObjectImpl__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__3_in_rule__OilObjectImpl__Group__23188);
            rule__OilObjectImpl__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObjectImpl__Group__2"


    // $ANTLR start "rule__OilObjectImpl__Group__2__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1454:1: rule__OilObjectImpl__Group__2__Impl : ( ( rule__OilObjectImpl__ParametersAssignment_2 )* ) ;
    public final void rule__OilObjectImpl__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1458:1: ( ( ( rule__OilObjectImpl__ParametersAssignment_2 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1459:1: ( ( rule__OilObjectImpl__ParametersAssignment_2 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1459:1: ( ( rule__OilObjectImpl__ParametersAssignment_2 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1460:1: ( rule__OilObjectImpl__ParametersAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getParametersAssignment_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1461:1: ( rule__OilObjectImpl__ParametersAssignment_2 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=15 && LA20_0<=23)||(LA20_0>=37 && LA20_0<=49)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1461:2: rule__OilObjectImpl__ParametersAssignment_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__ParametersAssignment_2_in_rule__OilObjectImpl__Group__2__Impl3215);
            	    rule__OilObjectImpl__ParametersAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectImplAccess().getParametersAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObjectImpl__Group__2__Impl"


    // $ANTLR start "rule__OilObjectImpl__Group__3"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1471:1: rule__OilObjectImpl__Group__3 : rule__OilObjectImpl__Group__3__Impl rule__OilObjectImpl__Group__4 ;
    public final void rule__OilObjectImpl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1475:1: ( rule__OilObjectImpl__Group__3__Impl rule__OilObjectImpl__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1476:2: rule__OilObjectImpl__Group__3__Impl rule__OilObjectImpl__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__3__Impl_in_rule__OilObjectImpl__Group__33246);
            rule__OilObjectImpl__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__4_in_rule__OilObjectImpl__Group__33249);
            rule__OilObjectImpl__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObjectImpl__Group__3"


    // $ANTLR start "rule__OilObjectImpl__Group__3__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1483:1: rule__OilObjectImpl__Group__3__Impl : ( '}' ) ;
    public final void rule__OilObjectImpl__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1487:1: ( ( '}' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1488:1: ( '}' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1488:1: ( '}' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1489:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getRightCurlyBracketKeyword_3()); 
            }
            match(input,52,FollowSets000.FOLLOW_52_in_rule__OilObjectImpl__Group__3__Impl3277); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectImplAccess().getRightCurlyBracketKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObjectImpl__Group__3__Impl"


    // $ANTLR start "rule__OilObjectImpl__Group__4"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1502:1: rule__OilObjectImpl__Group__4 : rule__OilObjectImpl__Group__4__Impl rule__OilObjectImpl__Group__5 ;
    public final void rule__OilObjectImpl__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1506:1: ( rule__OilObjectImpl__Group__4__Impl rule__OilObjectImpl__Group__5 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1507:2: rule__OilObjectImpl__Group__4__Impl rule__OilObjectImpl__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__4__Impl_in_rule__OilObjectImpl__Group__43308);
            rule__OilObjectImpl__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__5_in_rule__OilObjectImpl__Group__43311);
            rule__OilObjectImpl__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObjectImpl__Group__4"


    // $ANTLR start "rule__OilObjectImpl__Group__4__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1514:1: rule__OilObjectImpl__Group__4__Impl : ( ( rule__OilObjectImpl__Group_4__0 )? ) ;
    public final void rule__OilObjectImpl__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1518:1: ( ( ( rule__OilObjectImpl__Group_4__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1519:1: ( ( rule__OilObjectImpl__Group_4__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1519:1: ( ( rule__OilObjectImpl__Group_4__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1520:1: ( rule__OilObjectImpl__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getGroup_4()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1521:1: ( rule__OilObjectImpl__Group_4__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==54) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1521:2: rule__OilObjectImpl__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group_4__0_in_rule__OilObjectImpl__Group__4__Impl3338);
                    rule__OilObjectImpl__Group_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectImplAccess().getGroup_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObjectImpl__Group__4__Impl"


    // $ANTLR start "rule__OilObjectImpl__Group__5"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1531:1: rule__OilObjectImpl__Group__5 : rule__OilObjectImpl__Group__5__Impl ;
    public final void rule__OilObjectImpl__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1535:1: ( rule__OilObjectImpl__Group__5__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1536:2: rule__OilObjectImpl__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__5__Impl_in_rule__OilObjectImpl__Group__53369);
            rule__OilObjectImpl__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObjectImpl__Group__5"


    // $ANTLR start "rule__OilObjectImpl__Group__5__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1542:1: rule__OilObjectImpl__Group__5__Impl : ( ';' ) ;
    public final void rule__OilObjectImpl__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1546:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1547:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1547:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1548:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getSemicolonKeyword_5()); 
            }
            match(input,53,FollowSets000.FOLLOW_53_in_rule__OilObjectImpl__Group__5__Impl3397); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectImplAccess().getSemicolonKeyword_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObjectImpl__Group__5__Impl"


    // $ANTLR start "rule__OilObjectImpl__Group_4__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1573:1: rule__OilObjectImpl__Group_4__0 : rule__OilObjectImpl__Group_4__0__Impl rule__OilObjectImpl__Group_4__1 ;
    public final void rule__OilObjectImpl__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1577:1: ( rule__OilObjectImpl__Group_4__0__Impl rule__OilObjectImpl__Group_4__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1578:2: rule__OilObjectImpl__Group_4__0__Impl rule__OilObjectImpl__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group_4__0__Impl_in_rule__OilObjectImpl__Group_4__03440);
            rule__OilObjectImpl__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group_4__1_in_rule__OilObjectImpl__Group_4__03443);
            rule__OilObjectImpl__Group_4__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObjectImpl__Group_4__0"


    // $ANTLR start "rule__OilObjectImpl__Group_4__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1585:1: rule__OilObjectImpl__Group_4__0__Impl : ( ':' ) ;
    public final void rule__OilObjectImpl__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1589:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1590:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1590:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1591:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getColonKeyword_4_0()); 
            }
            match(input,54,FollowSets000.FOLLOW_54_in_rule__OilObjectImpl__Group_4__0__Impl3471); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectImplAccess().getColonKeyword_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObjectImpl__Group_4__0__Impl"


    // $ANTLR start "rule__OilObjectImpl__Group_4__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1604:1: rule__OilObjectImpl__Group_4__1 : rule__OilObjectImpl__Group_4__1__Impl ;
    public final void rule__OilObjectImpl__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1608:1: ( rule__OilObjectImpl__Group_4__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1609:2: rule__OilObjectImpl__Group_4__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group_4__1__Impl_in_rule__OilObjectImpl__Group_4__13502);
            rule__OilObjectImpl__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObjectImpl__Group_4__1"


    // $ANTLR start "rule__OilObjectImpl__Group_4__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1615:1: rule__OilObjectImpl__Group_4__1__Impl : ( ( rule__OilObjectImpl__DescriptionAssignment_4_1 ) ) ;
    public final void rule__OilObjectImpl__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1619:1: ( ( ( rule__OilObjectImpl__DescriptionAssignment_4_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1620:1: ( ( rule__OilObjectImpl__DescriptionAssignment_4_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1620:1: ( ( rule__OilObjectImpl__DescriptionAssignment_4_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1621:1: ( rule__OilObjectImpl__DescriptionAssignment_4_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getDescriptionAssignment_4_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1622:1: ( rule__OilObjectImpl__DescriptionAssignment_4_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1622:2: rule__OilObjectImpl__DescriptionAssignment_4_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__DescriptionAssignment_4_1_in_rule__OilObjectImpl__Group_4__1__Impl3529);
            rule__OilObjectImpl__DescriptionAssignment_4_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectImplAccess().getDescriptionAssignment_4_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObjectImpl__Group_4__1__Impl"


    // $ANTLR start "rule__OilApplication__Group__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1636:1: rule__OilApplication__Group__0 : rule__OilApplication__Group__0__Impl rule__OilApplication__Group__1 ;
    public final void rule__OilApplication__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1640:1: ( rule__OilApplication__Group__0__Impl rule__OilApplication__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1641:2: rule__OilApplication__Group__0__Impl rule__OilApplication__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__0__Impl_in_rule__OilApplication__Group__03563);
            rule__OilApplication__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__1_in_rule__OilApplication__Group__03566);
            rule__OilApplication__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilApplication__Group__0"


    // $ANTLR start "rule__OilApplication__Group__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1648:1: rule__OilApplication__Group__0__Impl : ( 'CPU' ) ;
    public final void rule__OilApplication__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1652:1: ( ( 'CPU' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1653:1: ( 'CPU' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1653:1: ( 'CPU' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1654:1: 'CPU'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getCPUKeyword_0()); 
            }
            match(input,55,FollowSets000.FOLLOW_55_in_rule__OilApplication__Group__0__Impl3594); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilApplicationAccess().getCPUKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilApplication__Group__0__Impl"


    // $ANTLR start "rule__OilApplication__Group__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1667:1: rule__OilApplication__Group__1 : rule__OilApplication__Group__1__Impl rule__OilApplication__Group__2 ;
    public final void rule__OilApplication__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1671:1: ( rule__OilApplication__Group__1__Impl rule__OilApplication__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1672:2: rule__OilApplication__Group__1__Impl rule__OilApplication__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__1__Impl_in_rule__OilApplication__Group__13625);
            rule__OilApplication__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__2_in_rule__OilApplication__Group__13628);
            rule__OilApplication__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilApplication__Group__1"


    // $ANTLR start "rule__OilApplication__Group__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1679:1: rule__OilApplication__Group__1__Impl : ( ( rule__OilApplication__NameAssignment_1 ) ) ;
    public final void rule__OilApplication__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1683:1: ( ( ( rule__OilApplication__NameAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1684:1: ( ( rule__OilApplication__NameAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1684:1: ( ( rule__OilApplication__NameAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1685:1: ( rule__OilApplication__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getNameAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1686:1: ( rule__OilApplication__NameAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1686:2: rule__OilApplication__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__NameAssignment_1_in_rule__OilApplication__Group__1__Impl3655);
            rule__OilApplication__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilApplicationAccess().getNameAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilApplication__Group__1__Impl"


    // $ANTLR start "rule__OilApplication__Group__2"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1696:1: rule__OilApplication__Group__2 : rule__OilApplication__Group__2__Impl rule__OilApplication__Group__3 ;
    public final void rule__OilApplication__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1700:1: ( rule__OilApplication__Group__2__Impl rule__OilApplication__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1701:2: rule__OilApplication__Group__2__Impl rule__OilApplication__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__2__Impl_in_rule__OilApplication__Group__23685);
            rule__OilApplication__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__3_in_rule__OilApplication__Group__23688);
            rule__OilApplication__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilApplication__Group__2"


    // $ANTLR start "rule__OilApplication__Group__2__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1708:1: rule__OilApplication__Group__2__Impl : ( '{' ) ;
    public final void rule__OilApplication__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1712:1: ( ( '{' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1713:1: ( '{' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1713:1: ( '{' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1714:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,51,FollowSets000.FOLLOW_51_in_rule__OilApplication__Group__2__Impl3716); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilApplicationAccess().getLeftCurlyBracketKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilApplication__Group__2__Impl"


    // $ANTLR start "rule__OilApplication__Group__3"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1727:1: rule__OilApplication__Group__3 : rule__OilApplication__Group__3__Impl rule__OilApplication__Group__4 ;
    public final void rule__OilApplication__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1731:1: ( rule__OilApplication__Group__3__Impl rule__OilApplication__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1732:2: rule__OilApplication__Group__3__Impl rule__OilApplication__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__3__Impl_in_rule__OilApplication__Group__33747);
            rule__OilApplication__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__4_in_rule__OilApplication__Group__33750);
            rule__OilApplication__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilApplication__Group__3"


    // $ANTLR start "rule__OilApplication__Group__3__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1739:1: rule__OilApplication__Group__3__Impl : ( ( rule__OilApplication__OilObjectsAssignment_3 )* ) ;
    public final void rule__OilApplication__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1743:1: ( ( ( rule__OilApplication__OilObjectsAssignment_3 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1744:1: ( ( rule__OilApplication__OilObjectsAssignment_3 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1744:1: ( ( rule__OilApplication__OilObjectsAssignment_3 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1745:1: ( rule__OilApplication__OilObjectsAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getOilObjectsAssignment_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1746:1: ( rule__OilApplication__OilObjectsAssignment_3 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=24 && LA22_0<=36)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1746:2: rule__OilApplication__OilObjectsAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__OilApplication__OilObjectsAssignment_3_in_rule__OilApplication__Group__3__Impl3777);
            	    rule__OilApplication__OilObjectsAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilApplicationAccess().getOilObjectsAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilApplication__Group__3__Impl"


    // $ANTLR start "rule__OilApplication__Group__4"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1756:1: rule__OilApplication__Group__4 : rule__OilApplication__Group__4__Impl rule__OilApplication__Group__5 ;
    public final void rule__OilApplication__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1760:1: ( rule__OilApplication__Group__4__Impl rule__OilApplication__Group__5 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1761:2: rule__OilApplication__Group__4__Impl rule__OilApplication__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__4__Impl_in_rule__OilApplication__Group__43808);
            rule__OilApplication__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__5_in_rule__OilApplication__Group__43811);
            rule__OilApplication__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilApplication__Group__4"


    // $ANTLR start "rule__OilApplication__Group__4__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1768:1: rule__OilApplication__Group__4__Impl : ( '}' ) ;
    public final void rule__OilApplication__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1772:1: ( ( '}' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1773:1: ( '}' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1773:1: ( '}' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1774:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,52,FollowSets000.FOLLOW_52_in_rule__OilApplication__Group__4__Impl3839); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilApplicationAccess().getRightCurlyBracketKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilApplication__Group__4__Impl"


    // $ANTLR start "rule__OilApplication__Group__5"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1787:1: rule__OilApplication__Group__5 : rule__OilApplication__Group__5__Impl rule__OilApplication__Group__6 ;
    public final void rule__OilApplication__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1791:1: ( rule__OilApplication__Group__5__Impl rule__OilApplication__Group__6 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1792:2: rule__OilApplication__Group__5__Impl rule__OilApplication__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__5__Impl_in_rule__OilApplication__Group__53870);
            rule__OilApplication__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__6_in_rule__OilApplication__Group__53873);
            rule__OilApplication__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilApplication__Group__5"


    // $ANTLR start "rule__OilApplication__Group__5__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1799:1: rule__OilApplication__Group__5__Impl : ( ( rule__OilApplication__Group_5__0 )? ) ;
    public final void rule__OilApplication__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1803:1: ( ( ( rule__OilApplication__Group_5__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1804:1: ( ( rule__OilApplication__Group_5__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1804:1: ( ( rule__OilApplication__Group_5__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1805:1: ( rule__OilApplication__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getGroup_5()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1806:1: ( rule__OilApplication__Group_5__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==54) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1806:2: rule__OilApplication__Group_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group_5__0_in_rule__OilApplication__Group__5__Impl3900);
                    rule__OilApplication__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilApplicationAccess().getGroup_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilApplication__Group__5__Impl"


    // $ANTLR start "rule__OilApplication__Group__6"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1816:1: rule__OilApplication__Group__6 : rule__OilApplication__Group__6__Impl ;
    public final void rule__OilApplication__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1820:1: ( rule__OilApplication__Group__6__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1821:2: rule__OilApplication__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__6__Impl_in_rule__OilApplication__Group__63931);
            rule__OilApplication__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilApplication__Group__6"


    // $ANTLR start "rule__OilApplication__Group__6__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1827:1: rule__OilApplication__Group__6__Impl : ( ';' ) ;
    public final void rule__OilApplication__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1831:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1832:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1832:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1833:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getSemicolonKeyword_6()); 
            }
            match(input,53,FollowSets000.FOLLOW_53_in_rule__OilApplication__Group__6__Impl3959); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilApplicationAccess().getSemicolonKeyword_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilApplication__Group__6__Impl"


    // $ANTLR start "rule__OilApplication__Group_5__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1860:1: rule__OilApplication__Group_5__0 : rule__OilApplication__Group_5__0__Impl rule__OilApplication__Group_5__1 ;
    public final void rule__OilApplication__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1864:1: ( rule__OilApplication__Group_5__0__Impl rule__OilApplication__Group_5__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1865:2: rule__OilApplication__Group_5__0__Impl rule__OilApplication__Group_5__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group_5__0__Impl_in_rule__OilApplication__Group_5__04004);
            rule__OilApplication__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group_5__1_in_rule__OilApplication__Group_5__04007);
            rule__OilApplication__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilApplication__Group_5__0"


    // $ANTLR start "rule__OilApplication__Group_5__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1872:1: rule__OilApplication__Group_5__0__Impl : ( ':' ) ;
    public final void rule__OilApplication__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1876:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1877:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1877:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1878:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getColonKeyword_5_0()); 
            }
            match(input,54,FollowSets000.FOLLOW_54_in_rule__OilApplication__Group_5__0__Impl4035); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilApplicationAccess().getColonKeyword_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilApplication__Group_5__0__Impl"


    // $ANTLR start "rule__OilApplication__Group_5__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1891:1: rule__OilApplication__Group_5__1 : rule__OilApplication__Group_5__1__Impl ;
    public final void rule__OilApplication__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1895:1: ( rule__OilApplication__Group_5__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1896:2: rule__OilApplication__Group_5__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group_5__1__Impl_in_rule__OilApplication__Group_5__14066);
            rule__OilApplication__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilApplication__Group_5__1"


    // $ANTLR start "rule__OilApplication__Group_5__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1902:1: rule__OilApplication__Group_5__1__Impl : ( ( rule__OilApplication__DescriptionAssignment_5_1 ) ) ;
    public final void rule__OilApplication__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1906:1: ( ( ( rule__OilApplication__DescriptionAssignment_5_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1907:1: ( ( rule__OilApplication__DescriptionAssignment_5_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1907:1: ( ( rule__OilApplication__DescriptionAssignment_5_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1908:1: ( rule__OilApplication__DescriptionAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getDescriptionAssignment_5_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1909:1: ( rule__OilApplication__DescriptionAssignment_5_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1909:2: rule__OilApplication__DescriptionAssignment_5_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__DescriptionAssignment_5_1_in_rule__OilApplication__Group_5__1__Impl4093);
            rule__OilApplication__DescriptionAssignment_5_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilApplicationAccess().getDescriptionAssignment_5_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilApplication__Group_5__1__Impl"


    // $ANTLR start "rule__ValueType__Group__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1923:1: rule__ValueType__Group__0 : rule__ValueType__Group__0__Impl rule__ValueType__Group__1 ;
    public final void rule__ValueType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1927:1: ( rule__ValueType__Group__0__Impl rule__ValueType__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1928:2: rule__ValueType__Group__0__Impl rule__ValueType__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__0__Impl_in_rule__ValueType__Group__04127);
            rule__ValueType__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__1_in_rule__ValueType__Group__04130);
            rule__ValueType__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group__0"


    // $ANTLR start "rule__ValueType__Group__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1935:1: rule__ValueType__Group__0__Impl : ( () ) ;
    public final void rule__ValueType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1939:1: ( ( () ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1940:1: ( () )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1940:1: ( () )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1941:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getValueTypeAction_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1942:1: ()
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1944:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getValueTypeAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group__0__Impl"


    // $ANTLR start "rule__ValueType__Group__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1954:1: rule__ValueType__Group__1 : rule__ValueType__Group__1__Impl rule__ValueType__Group__2 ;
    public final void rule__ValueType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1958:1: ( rule__ValueType__Group__1__Impl rule__ValueType__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1959:2: rule__ValueType__Group__1__Impl rule__ValueType__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__1__Impl_in_rule__ValueType__Group__14188);
            rule__ValueType__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__2_in_rule__ValueType__Group__14191);
            rule__ValueType__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group__1"


    // $ANTLR start "rule__ValueType__Group__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1966:1: rule__ValueType__Group__1__Impl : ( ( rule__ValueType__TypeAssignment_1 ) ) ;
    public final void rule__ValueType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1970:1: ( ( ( rule__ValueType__TypeAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1971:1: ( ( rule__ValueType__TypeAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1971:1: ( ( rule__ValueType__TypeAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1972:1: ( rule__ValueType__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getTypeAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1973:1: ( rule__ValueType__TypeAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1973:2: rule__ValueType__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__TypeAssignment_1_in_rule__ValueType__Group__1__Impl4218);
            rule__ValueType__TypeAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getTypeAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group__1__Impl"


    // $ANTLR start "rule__ValueType__Group__2"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1983:1: rule__ValueType__Group__2 : rule__ValueType__Group__2__Impl rule__ValueType__Group__3 ;
    public final void rule__ValueType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1987:1: ( rule__ValueType__Group__2__Impl rule__ValueType__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1988:2: rule__ValueType__Group__2__Impl rule__ValueType__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__2__Impl_in_rule__ValueType__Group__24248);
            rule__ValueType__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__3_in_rule__ValueType__Group__24251);
            rule__ValueType__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group__2"


    // $ANTLR start "rule__ValueType__Group__2__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1995:1: rule__ValueType__Group__2__Impl : ( ( rule__ValueType__WithAutoAssignment_2 )? ) ;
    public final void rule__ValueType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1999:1: ( ( ( rule__ValueType__WithAutoAssignment_2 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2000:1: ( ( rule__ValueType__WithAutoAssignment_2 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2000:1: ( ( rule__ValueType__WithAutoAssignment_2 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2001:1: ( rule__ValueType__WithAutoAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getWithAutoAssignment_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2002:1: ( rule__ValueType__WithAutoAssignment_2 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==59) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2002:2: rule__ValueType__WithAutoAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ValueType__WithAutoAssignment_2_in_rule__ValueType__Group__2__Impl4278);
                    rule__ValueType__WithAutoAssignment_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getWithAutoAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group__2__Impl"


    // $ANTLR start "rule__ValueType__Group__3"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2012:1: rule__ValueType__Group__3 : rule__ValueType__Group__3__Impl rule__ValueType__Group__4 ;
    public final void rule__ValueType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2016:1: ( rule__ValueType__Group__3__Impl rule__ValueType__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2017:2: rule__ValueType__Group__3__Impl rule__ValueType__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__3__Impl_in_rule__ValueType__Group__34309);
            rule__ValueType__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__4_in_rule__ValueType__Group__34312);
            rule__ValueType__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group__3"


    // $ANTLR start "rule__ValueType__Group__3__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2024:1: rule__ValueType__Group__3__Impl : ( ( rule__ValueType__NameAssignment_3 ) ) ;
    public final void rule__ValueType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2028:1: ( ( ( rule__ValueType__NameAssignment_3 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2029:1: ( ( rule__ValueType__NameAssignment_3 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2029:1: ( ( rule__ValueType__NameAssignment_3 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2030:1: ( rule__ValueType__NameAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getNameAssignment_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2031:1: ( rule__ValueType__NameAssignment_3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2031:2: rule__ValueType__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__NameAssignment_3_in_rule__ValueType__Group__3__Impl4339);
            rule__ValueType__NameAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getNameAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group__3__Impl"


    // $ANTLR start "rule__ValueType__Group__4"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2041:1: rule__ValueType__Group__4 : rule__ValueType__Group__4__Impl rule__ValueType__Group__5 ;
    public final void rule__ValueType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2045:1: ( rule__ValueType__Group__4__Impl rule__ValueType__Group__5 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2046:2: rule__ValueType__Group__4__Impl rule__ValueType__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__4__Impl_in_rule__ValueType__Group__44369);
            rule__ValueType__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__5_in_rule__ValueType__Group__44372);
            rule__ValueType__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group__4"


    // $ANTLR start "rule__ValueType__Group__4__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2053:1: rule__ValueType__Group__4__Impl : ( ( rule__ValueType__MultiValueAssignment_4 )? ) ;
    public final void rule__ValueType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2057:1: ( ( ( rule__ValueType__MultiValueAssignment_4 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2058:1: ( ( rule__ValueType__MultiValueAssignment_4 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2058:1: ( ( rule__ValueType__MultiValueAssignment_4 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2059:1: ( rule__ValueType__MultiValueAssignment_4 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getMultiValueAssignment_4()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2060:1: ( rule__ValueType__MultiValueAssignment_4 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==60) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2060:2: rule__ValueType__MultiValueAssignment_4
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ValueType__MultiValueAssignment_4_in_rule__ValueType__Group__4__Impl4399);
                    rule__ValueType__MultiValueAssignment_4();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getMultiValueAssignment_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group__4__Impl"


    // $ANTLR start "rule__ValueType__Group__5"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2070:1: rule__ValueType__Group__5 : rule__ValueType__Group__5__Impl rule__ValueType__Group__6 ;
    public final void rule__ValueType__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2074:1: ( rule__ValueType__Group__5__Impl rule__ValueType__Group__6 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2075:2: rule__ValueType__Group__5__Impl rule__ValueType__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__5__Impl_in_rule__ValueType__Group__54430);
            rule__ValueType__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__6_in_rule__ValueType__Group__54433);
            rule__ValueType__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group__5"


    // $ANTLR start "rule__ValueType__Group__5__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2082:1: rule__ValueType__Group__5__Impl : ( ( rule__ValueType__Group_5__0 )? ) ;
    public final void rule__ValueType__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2086:1: ( ( ( rule__ValueType__Group_5__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2087:1: ( ( rule__ValueType__Group_5__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2087:1: ( ( rule__ValueType__Group_5__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2088:1: ( rule__ValueType__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getGroup_5()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2089:1: ( rule__ValueType__Group_5__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==56) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2089:2: rule__ValueType__Group_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_5__0_in_rule__ValueType__Group__5__Impl4460);
                    rule__ValueType__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getGroup_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group__5__Impl"


    // $ANTLR start "rule__ValueType__Group__6"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2099:1: rule__ValueType__Group__6 : rule__ValueType__Group__6__Impl rule__ValueType__Group__7 ;
    public final void rule__ValueType__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2103:1: ( rule__ValueType__Group__6__Impl rule__ValueType__Group__7 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2104:2: rule__ValueType__Group__6__Impl rule__ValueType__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__6__Impl_in_rule__ValueType__Group__64491);
            rule__ValueType__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__7_in_rule__ValueType__Group__64494);
            rule__ValueType__Group__7();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group__6"


    // $ANTLR start "rule__ValueType__Group__6__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2111:1: rule__ValueType__Group__6__Impl : ( ( rule__ValueType__Group_6__0 )? ) ;
    public final void rule__ValueType__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2115:1: ( ( ( rule__ValueType__Group_6__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2116:1: ( ( rule__ValueType__Group_6__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2116:1: ( ( rule__ValueType__Group_6__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2117:1: ( rule__ValueType__Group_6__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getGroup_6()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2118:1: ( rule__ValueType__Group_6__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==54) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2118:2: rule__ValueType__Group_6__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_6__0_in_rule__ValueType__Group__6__Impl4521);
                    rule__ValueType__Group_6__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getGroup_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group__6__Impl"


    // $ANTLR start "rule__ValueType__Group__7"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2128:1: rule__ValueType__Group__7 : rule__ValueType__Group__7__Impl ;
    public final void rule__ValueType__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2132:1: ( rule__ValueType__Group__7__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2133:2: rule__ValueType__Group__7__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__7__Impl_in_rule__ValueType__Group__74552);
            rule__ValueType__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group__7"


    // $ANTLR start "rule__ValueType__Group__7__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2139:1: rule__ValueType__Group__7__Impl : ( ';' ) ;
    public final void rule__ValueType__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2143:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2144:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2144:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2145:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getSemicolonKeyword_7()); 
            }
            match(input,53,FollowSets000.FOLLOW_53_in_rule__ValueType__Group__7__Impl4580); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getSemicolonKeyword_7()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group__7__Impl"


    // $ANTLR start "rule__ValueType__Group_5__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2174:1: rule__ValueType__Group_5__0 : rule__ValueType__Group_5__0__Impl rule__ValueType__Group_5__1 ;
    public final void rule__ValueType__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2178:1: ( rule__ValueType__Group_5__0__Impl rule__ValueType__Group_5__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2179:2: rule__ValueType__Group_5__0__Impl rule__ValueType__Group_5__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_5__0__Impl_in_rule__ValueType__Group_5__04627);
            rule__ValueType__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_5__1_in_rule__ValueType__Group_5__04630);
            rule__ValueType__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group_5__0"


    // $ANTLR start "rule__ValueType__Group_5__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2186:1: rule__ValueType__Group_5__0__Impl : ( '=' ) ;
    public final void rule__ValueType__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2190:1: ( ( '=' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2191:1: ( '=' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2191:1: ( '=' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2192:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getEqualsSignKeyword_5_0()); 
            }
            match(input,56,FollowSets000.FOLLOW_56_in_rule__ValueType__Group_5__0__Impl4658); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getEqualsSignKeyword_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group_5__0__Impl"


    // $ANTLR start "rule__ValueType__Group_5__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2205:1: rule__ValueType__Group_5__1 : rule__ValueType__Group_5__1__Impl ;
    public final void rule__ValueType__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2209:1: ( rule__ValueType__Group_5__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2210:2: rule__ValueType__Group_5__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_5__1__Impl_in_rule__ValueType__Group_5__14689);
            rule__ValueType__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group_5__1"


    // $ANTLR start "rule__ValueType__Group_5__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2216:1: rule__ValueType__Group_5__1__Impl : ( ( rule__ValueType__Alternatives_5_1 ) ) ;
    public final void rule__ValueType__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2220:1: ( ( ( rule__ValueType__Alternatives_5_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2221:1: ( ( rule__ValueType__Alternatives_5_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2221:1: ( ( rule__ValueType__Alternatives_5_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2222:1: ( rule__ValueType__Alternatives_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getAlternatives_5_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2223:1: ( rule__ValueType__Alternatives_5_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2223:2: rule__ValueType__Alternatives_5_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Alternatives_5_1_in_rule__ValueType__Group_5__1__Impl4716);
            rule__ValueType__Alternatives_5_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getAlternatives_5_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group_5__1__Impl"


    // $ANTLR start "rule__ValueType__Group_6__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2237:1: rule__ValueType__Group_6__0 : rule__ValueType__Group_6__0__Impl rule__ValueType__Group_6__1 ;
    public final void rule__ValueType__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2241:1: ( rule__ValueType__Group_6__0__Impl rule__ValueType__Group_6__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2242:2: rule__ValueType__Group_6__0__Impl rule__ValueType__Group_6__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_6__0__Impl_in_rule__ValueType__Group_6__04750);
            rule__ValueType__Group_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_6__1_in_rule__ValueType__Group_6__04753);
            rule__ValueType__Group_6__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group_6__0"


    // $ANTLR start "rule__ValueType__Group_6__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2249:1: rule__ValueType__Group_6__0__Impl : ( ':' ) ;
    public final void rule__ValueType__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2253:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2254:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2254:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2255:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getColonKeyword_6_0()); 
            }
            match(input,54,FollowSets000.FOLLOW_54_in_rule__ValueType__Group_6__0__Impl4781); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getColonKeyword_6_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group_6__0__Impl"


    // $ANTLR start "rule__ValueType__Group_6__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2268:1: rule__ValueType__Group_6__1 : rule__ValueType__Group_6__1__Impl ;
    public final void rule__ValueType__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2272:1: ( rule__ValueType__Group_6__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2273:2: rule__ValueType__Group_6__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_6__1__Impl_in_rule__ValueType__Group_6__14812);
            rule__ValueType__Group_6__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group_6__1"


    // $ANTLR start "rule__ValueType__Group_6__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2279:1: rule__ValueType__Group_6__1__Impl : ( ( rule__ValueType__DescriptionAssignment_6_1 ) ) ;
    public final void rule__ValueType__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2283:1: ( ( ( rule__ValueType__DescriptionAssignment_6_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2284:1: ( ( rule__ValueType__DescriptionAssignment_6_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2284:1: ( ( rule__ValueType__DescriptionAssignment_6_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2285:1: ( rule__ValueType__DescriptionAssignment_6_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getDescriptionAssignment_6_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2286:1: ( rule__ValueType__DescriptionAssignment_6_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2286:2: rule__ValueType__DescriptionAssignment_6_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__DescriptionAssignment_6_1_in_rule__ValueType__Group_6__1__Impl4839);
            rule__ValueType__DescriptionAssignment_6_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getDescriptionAssignment_6_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group_6__1__Impl"


    // $ANTLR start "rule__VariantType__Group__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2300:1: rule__VariantType__Group__0 : rule__VariantType__Group__0__Impl rule__VariantType__Group__1 ;
    public final void rule__VariantType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2304:1: ( rule__VariantType__Group__0__Impl rule__VariantType__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2305:2: rule__VariantType__Group__0__Impl rule__VariantType__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__0__Impl_in_rule__VariantType__Group__04873);
            rule__VariantType__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__1_in_rule__VariantType__Group__04876);
            rule__VariantType__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group__0"


    // $ANTLR start "rule__VariantType__Group__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2312:1: rule__VariantType__Group__0__Impl : ( () ) ;
    public final void rule__VariantType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2316:1: ( ( () ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2317:1: ( () )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2317:1: ( () )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2318:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getVariantTypeAction_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2319:1: ()
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2321:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getVariantTypeAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group__0__Impl"


    // $ANTLR start "rule__VariantType__Group__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2331:1: rule__VariantType__Group__1 : rule__VariantType__Group__1__Impl rule__VariantType__Group__2 ;
    public final void rule__VariantType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2335:1: ( rule__VariantType__Group__1__Impl rule__VariantType__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2336:2: rule__VariantType__Group__1__Impl rule__VariantType__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__1__Impl_in_rule__VariantType__Group__14934);
            rule__VariantType__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__2_in_rule__VariantType__Group__14937);
            rule__VariantType__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group__1"


    // $ANTLR start "rule__VariantType__Group__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2343:1: rule__VariantType__Group__1__Impl : ( ( rule__VariantType__TypeAssignment_1 ) ) ;
    public final void rule__VariantType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2347:1: ( ( ( rule__VariantType__TypeAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2348:1: ( ( rule__VariantType__TypeAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2348:1: ( ( rule__VariantType__TypeAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2349:1: ( rule__VariantType__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getTypeAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2350:1: ( rule__VariantType__TypeAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2350:2: rule__VariantType__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__TypeAssignment_1_in_rule__VariantType__Group__1__Impl4964);
            rule__VariantType__TypeAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getTypeAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group__1__Impl"


    // $ANTLR start "rule__VariantType__Group__2"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2360:1: rule__VariantType__Group__2 : rule__VariantType__Group__2__Impl rule__VariantType__Group__3 ;
    public final void rule__VariantType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2364:1: ( rule__VariantType__Group__2__Impl rule__VariantType__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2365:2: rule__VariantType__Group__2__Impl rule__VariantType__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__2__Impl_in_rule__VariantType__Group__24994);
            rule__VariantType__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__3_in_rule__VariantType__Group__24997);
            rule__VariantType__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group__2"


    // $ANTLR start "rule__VariantType__Group__2__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2372:1: rule__VariantType__Group__2__Impl : ( ( rule__VariantType__WithAutoAssignment_2 )? ) ;
    public final void rule__VariantType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2376:1: ( ( ( rule__VariantType__WithAutoAssignment_2 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2377:1: ( ( rule__VariantType__WithAutoAssignment_2 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2377:1: ( ( rule__VariantType__WithAutoAssignment_2 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2378:1: ( rule__VariantType__WithAutoAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getWithAutoAssignment_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2379:1: ( rule__VariantType__WithAutoAssignment_2 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==59) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2379:2: rule__VariantType__WithAutoAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__VariantType__WithAutoAssignment_2_in_rule__VariantType__Group__2__Impl5024);
                    rule__VariantType__WithAutoAssignment_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getWithAutoAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group__2__Impl"


    // $ANTLR start "rule__VariantType__Group__3"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2389:1: rule__VariantType__Group__3 : rule__VariantType__Group__3__Impl rule__VariantType__Group__4 ;
    public final void rule__VariantType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2393:1: ( rule__VariantType__Group__3__Impl rule__VariantType__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2394:2: rule__VariantType__Group__3__Impl rule__VariantType__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__3__Impl_in_rule__VariantType__Group__35055);
            rule__VariantType__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__4_in_rule__VariantType__Group__35058);
            rule__VariantType__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group__3"


    // $ANTLR start "rule__VariantType__Group__3__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2401:1: rule__VariantType__Group__3__Impl : ( ( rule__VariantType__NameAssignment_3 ) ) ;
    public final void rule__VariantType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2405:1: ( ( ( rule__VariantType__NameAssignment_3 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2406:1: ( ( rule__VariantType__NameAssignment_3 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2406:1: ( ( rule__VariantType__NameAssignment_3 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2407:1: ( rule__VariantType__NameAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getNameAssignment_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2408:1: ( rule__VariantType__NameAssignment_3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2408:2: rule__VariantType__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__NameAssignment_3_in_rule__VariantType__Group__3__Impl5085);
            rule__VariantType__NameAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getNameAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group__3__Impl"


    // $ANTLR start "rule__VariantType__Group__4"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2418:1: rule__VariantType__Group__4 : rule__VariantType__Group__4__Impl rule__VariantType__Group__5 ;
    public final void rule__VariantType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2422:1: ( rule__VariantType__Group__4__Impl rule__VariantType__Group__5 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2423:2: rule__VariantType__Group__4__Impl rule__VariantType__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__4__Impl_in_rule__VariantType__Group__45115);
            rule__VariantType__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__5_in_rule__VariantType__Group__45118);
            rule__VariantType__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group__4"


    // $ANTLR start "rule__VariantType__Group__4__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2430:1: rule__VariantType__Group__4__Impl : ( ( rule__VariantType__MultiValueAssignment_4 )? ) ;
    public final void rule__VariantType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2434:1: ( ( ( rule__VariantType__MultiValueAssignment_4 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2435:1: ( ( rule__VariantType__MultiValueAssignment_4 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2435:1: ( ( rule__VariantType__MultiValueAssignment_4 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2436:1: ( rule__VariantType__MultiValueAssignment_4 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getMultiValueAssignment_4()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2437:1: ( rule__VariantType__MultiValueAssignment_4 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==60) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2437:2: rule__VariantType__MultiValueAssignment_4
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__VariantType__MultiValueAssignment_4_in_rule__VariantType__Group__4__Impl5145);
                    rule__VariantType__MultiValueAssignment_4();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getMultiValueAssignment_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group__4__Impl"


    // $ANTLR start "rule__VariantType__Group__5"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2447:1: rule__VariantType__Group__5 : rule__VariantType__Group__5__Impl rule__VariantType__Group__6 ;
    public final void rule__VariantType__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2451:1: ( rule__VariantType__Group__5__Impl rule__VariantType__Group__6 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2452:2: rule__VariantType__Group__5__Impl rule__VariantType__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__5__Impl_in_rule__VariantType__Group__55176);
            rule__VariantType__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__6_in_rule__VariantType__Group__55179);
            rule__VariantType__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group__5"


    // $ANTLR start "rule__VariantType__Group__5__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2459:1: rule__VariantType__Group__5__Impl : ( ( rule__VariantType__Group_5__0 )? ) ;
    public final void rule__VariantType__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2463:1: ( ( ( rule__VariantType__Group_5__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2464:1: ( ( rule__VariantType__Group_5__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2464:1: ( ( rule__VariantType__Group_5__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2465:1: ( rule__VariantType__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getGroup_5()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2466:1: ( rule__VariantType__Group_5__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==51) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2466:2: rule__VariantType__Group_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_5__0_in_rule__VariantType__Group__5__Impl5206);
                    rule__VariantType__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getGroup_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group__5__Impl"


    // $ANTLR start "rule__VariantType__Group__6"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2476:1: rule__VariantType__Group__6 : rule__VariantType__Group__6__Impl rule__VariantType__Group__7 ;
    public final void rule__VariantType__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2480:1: ( rule__VariantType__Group__6__Impl rule__VariantType__Group__7 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2481:2: rule__VariantType__Group__6__Impl rule__VariantType__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__6__Impl_in_rule__VariantType__Group__65237);
            rule__VariantType__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__7_in_rule__VariantType__Group__65240);
            rule__VariantType__Group__7();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group__6"


    // $ANTLR start "rule__VariantType__Group__6__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2488:1: rule__VariantType__Group__6__Impl : ( ( rule__VariantType__Group_6__0 )? ) ;
    public final void rule__VariantType__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2492:1: ( ( ( rule__VariantType__Group_6__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2493:1: ( ( rule__VariantType__Group_6__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2493:1: ( ( rule__VariantType__Group_6__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2494:1: ( rule__VariantType__Group_6__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getGroup_6()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2495:1: ( rule__VariantType__Group_6__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==56) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2495:2: rule__VariantType__Group_6__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_6__0_in_rule__VariantType__Group__6__Impl5267);
                    rule__VariantType__Group_6__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getGroup_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group__6__Impl"


    // $ANTLR start "rule__VariantType__Group__7"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2505:1: rule__VariantType__Group__7 : rule__VariantType__Group__7__Impl rule__VariantType__Group__8 ;
    public final void rule__VariantType__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2509:1: ( rule__VariantType__Group__7__Impl rule__VariantType__Group__8 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2510:2: rule__VariantType__Group__7__Impl rule__VariantType__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__7__Impl_in_rule__VariantType__Group__75298);
            rule__VariantType__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__8_in_rule__VariantType__Group__75301);
            rule__VariantType__Group__8();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group__7"


    // $ANTLR start "rule__VariantType__Group__7__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2517:1: rule__VariantType__Group__7__Impl : ( ( rule__VariantType__Group_7__0 )? ) ;
    public final void rule__VariantType__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2521:1: ( ( ( rule__VariantType__Group_7__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2522:1: ( ( rule__VariantType__Group_7__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2522:1: ( ( rule__VariantType__Group_7__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2523:1: ( rule__VariantType__Group_7__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getGroup_7()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2524:1: ( rule__VariantType__Group_7__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==54) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2524:2: rule__VariantType__Group_7__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_7__0_in_rule__VariantType__Group__7__Impl5328);
                    rule__VariantType__Group_7__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getGroup_7()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group__7__Impl"


    // $ANTLR start "rule__VariantType__Group__8"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2534:1: rule__VariantType__Group__8 : rule__VariantType__Group__8__Impl ;
    public final void rule__VariantType__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2538:1: ( rule__VariantType__Group__8__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2539:2: rule__VariantType__Group__8__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__8__Impl_in_rule__VariantType__Group__85359);
            rule__VariantType__Group__8__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group__8"


    // $ANTLR start "rule__VariantType__Group__8__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2545:1: rule__VariantType__Group__8__Impl : ( ';' ) ;
    public final void rule__VariantType__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2549:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2550:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2550:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2551:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getSemicolonKeyword_8()); 
            }
            match(input,53,FollowSets000.FOLLOW_53_in_rule__VariantType__Group__8__Impl5387); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getSemicolonKeyword_8()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group__8__Impl"


    // $ANTLR start "rule__VariantType__Group_5__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2582:1: rule__VariantType__Group_5__0 : rule__VariantType__Group_5__0__Impl rule__VariantType__Group_5__1 ;
    public final void rule__VariantType__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2586:1: ( rule__VariantType__Group_5__0__Impl rule__VariantType__Group_5__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2587:2: rule__VariantType__Group_5__0__Impl rule__VariantType__Group_5__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_5__0__Impl_in_rule__VariantType__Group_5__05436);
            rule__VariantType__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_5__1_in_rule__VariantType__Group_5__05439);
            rule__VariantType__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group_5__0"


    // $ANTLR start "rule__VariantType__Group_5__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2594:1: rule__VariantType__Group_5__0__Impl : ( '{' ) ;
    public final void rule__VariantType__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2598:1: ( ( '{' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2599:1: ( '{' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2599:1: ( '{' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2600:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getLeftCurlyBracketKeyword_5_0()); 
            }
            match(input,51,FollowSets000.FOLLOW_51_in_rule__VariantType__Group_5__0__Impl5467); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getLeftCurlyBracketKeyword_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group_5__0__Impl"


    // $ANTLR start "rule__VariantType__Group_5__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2613:1: rule__VariantType__Group_5__1 : rule__VariantType__Group_5__1__Impl rule__VariantType__Group_5__2 ;
    public final void rule__VariantType__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2617:1: ( rule__VariantType__Group_5__1__Impl rule__VariantType__Group_5__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2618:2: rule__VariantType__Group_5__1__Impl rule__VariantType__Group_5__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_5__1__Impl_in_rule__VariantType__Group_5__15498);
            rule__VariantType__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_5__2_in_rule__VariantType__Group_5__15501);
            rule__VariantType__Group_5__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group_5__1"


    // $ANTLR start "rule__VariantType__Group_5__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2625:1: rule__VariantType__Group_5__1__Impl : ( ( rule__VariantType__Group_5_1__0 )? ) ;
    public final void rule__VariantType__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2629:1: ( ( ( rule__VariantType__Group_5_1__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2630:1: ( ( rule__VariantType__Group_5_1__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2630:1: ( ( rule__VariantType__Group_5_1__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2631:1: ( rule__VariantType__Group_5_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getGroup_5_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2632:1: ( rule__VariantType__Group_5_1__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_ID) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2632:2: rule__VariantType__Group_5_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_5_1__0_in_rule__VariantType__Group_5__1__Impl5528);
                    rule__VariantType__Group_5_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getGroup_5_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group_5__1__Impl"


    // $ANTLR start "rule__VariantType__Group_5__2"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2642:1: rule__VariantType__Group_5__2 : rule__VariantType__Group_5__2__Impl ;
    public final void rule__VariantType__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2646:1: ( rule__VariantType__Group_5__2__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2647:2: rule__VariantType__Group_5__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_5__2__Impl_in_rule__VariantType__Group_5__25559);
            rule__VariantType__Group_5__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group_5__2"


    // $ANTLR start "rule__VariantType__Group_5__2__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2653:1: rule__VariantType__Group_5__2__Impl : ( '}' ) ;
    public final void rule__VariantType__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2657:1: ( ( '}' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2658:1: ( '}' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2658:1: ( '}' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2659:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getRightCurlyBracketKeyword_5_2()); 
            }
            match(input,52,FollowSets000.FOLLOW_52_in_rule__VariantType__Group_5__2__Impl5587); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getRightCurlyBracketKeyword_5_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group_5__2__Impl"


    // $ANTLR start "rule__VariantType__Group_5_1__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2678:1: rule__VariantType__Group_5_1__0 : rule__VariantType__Group_5_1__0__Impl rule__VariantType__Group_5_1__1 ;
    public final void rule__VariantType__Group_5_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2682:1: ( rule__VariantType__Group_5_1__0__Impl rule__VariantType__Group_5_1__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2683:2: rule__VariantType__Group_5_1__0__Impl rule__VariantType__Group_5_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_5_1__0__Impl_in_rule__VariantType__Group_5_1__05624);
            rule__VariantType__Group_5_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_5_1__1_in_rule__VariantType__Group_5_1__05627);
            rule__VariantType__Group_5_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group_5_1__0"


    // $ANTLR start "rule__VariantType__Group_5_1__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2690:1: rule__VariantType__Group_5_1__0__Impl : ( ( rule__VariantType__ValuesAssignment_5_1_0 ) ) ;
    public final void rule__VariantType__Group_5_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2694:1: ( ( ( rule__VariantType__ValuesAssignment_5_1_0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2695:1: ( ( rule__VariantType__ValuesAssignment_5_1_0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2695:1: ( ( rule__VariantType__ValuesAssignment_5_1_0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2696:1: ( rule__VariantType__ValuesAssignment_5_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getValuesAssignment_5_1_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2697:1: ( rule__VariantType__ValuesAssignment_5_1_0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2697:2: rule__VariantType__ValuesAssignment_5_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__ValuesAssignment_5_1_0_in_rule__VariantType__Group_5_1__0__Impl5654);
            rule__VariantType__ValuesAssignment_5_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getValuesAssignment_5_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group_5_1__0__Impl"


    // $ANTLR start "rule__VariantType__Group_5_1__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2707:1: rule__VariantType__Group_5_1__1 : rule__VariantType__Group_5_1__1__Impl ;
    public final void rule__VariantType__Group_5_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2711:1: ( rule__VariantType__Group_5_1__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2712:2: rule__VariantType__Group_5_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_5_1__1__Impl_in_rule__VariantType__Group_5_1__15684);
            rule__VariantType__Group_5_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group_5_1__1"


    // $ANTLR start "rule__VariantType__Group_5_1__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2718:1: rule__VariantType__Group_5_1__1__Impl : ( ( rule__VariantType__Group_5_1_1__0 )* ) ;
    public final void rule__VariantType__Group_5_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2722:1: ( ( ( rule__VariantType__Group_5_1_1__0 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2723:1: ( ( rule__VariantType__Group_5_1_1__0 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2723:1: ( ( rule__VariantType__Group_5_1_1__0 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2724:1: ( rule__VariantType__Group_5_1_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getGroup_5_1_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2725:1: ( rule__VariantType__Group_5_1_1__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==57) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2725:2: rule__VariantType__Group_5_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_5_1_1__0_in_rule__VariantType__Group_5_1__1__Impl5711);
            	    rule__VariantType__Group_5_1_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getGroup_5_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group_5_1__1__Impl"


    // $ANTLR start "rule__VariantType__Group_5_1_1__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2739:1: rule__VariantType__Group_5_1_1__0 : rule__VariantType__Group_5_1_1__0__Impl rule__VariantType__Group_5_1_1__1 ;
    public final void rule__VariantType__Group_5_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2743:1: ( rule__VariantType__Group_5_1_1__0__Impl rule__VariantType__Group_5_1_1__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2744:2: rule__VariantType__Group_5_1_1__0__Impl rule__VariantType__Group_5_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_5_1_1__0__Impl_in_rule__VariantType__Group_5_1_1__05746);
            rule__VariantType__Group_5_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_5_1_1__1_in_rule__VariantType__Group_5_1_1__05749);
            rule__VariantType__Group_5_1_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group_5_1_1__0"


    // $ANTLR start "rule__VariantType__Group_5_1_1__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2751:1: rule__VariantType__Group_5_1_1__0__Impl : ( ',' ) ;
    public final void rule__VariantType__Group_5_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2755:1: ( ( ',' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2756:1: ( ',' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2756:1: ( ',' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2757:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getCommaKeyword_5_1_1_0()); 
            }
            match(input,57,FollowSets000.FOLLOW_57_in_rule__VariantType__Group_5_1_1__0__Impl5777); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getCommaKeyword_5_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group_5_1_1__0__Impl"


    // $ANTLR start "rule__VariantType__Group_5_1_1__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2770:1: rule__VariantType__Group_5_1_1__1 : rule__VariantType__Group_5_1_1__1__Impl ;
    public final void rule__VariantType__Group_5_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2774:1: ( rule__VariantType__Group_5_1_1__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2775:2: rule__VariantType__Group_5_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_5_1_1__1__Impl_in_rule__VariantType__Group_5_1_1__15808);
            rule__VariantType__Group_5_1_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group_5_1_1__1"


    // $ANTLR start "rule__VariantType__Group_5_1_1__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2781:1: rule__VariantType__Group_5_1_1__1__Impl : ( ( rule__VariantType__ValuesAssignment_5_1_1_1 ) ) ;
    public final void rule__VariantType__Group_5_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2785:1: ( ( ( rule__VariantType__ValuesAssignment_5_1_1_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2786:1: ( ( rule__VariantType__ValuesAssignment_5_1_1_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2786:1: ( ( rule__VariantType__ValuesAssignment_5_1_1_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2787:1: ( rule__VariantType__ValuesAssignment_5_1_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getValuesAssignment_5_1_1_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2788:1: ( rule__VariantType__ValuesAssignment_5_1_1_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2788:2: rule__VariantType__ValuesAssignment_5_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__ValuesAssignment_5_1_1_1_in_rule__VariantType__Group_5_1_1__1__Impl5835);
            rule__VariantType__ValuesAssignment_5_1_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getValuesAssignment_5_1_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group_5_1_1__1__Impl"


    // $ANTLR start "rule__VariantType__Group_6__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2802:1: rule__VariantType__Group_6__0 : rule__VariantType__Group_6__0__Impl rule__VariantType__Group_6__1 ;
    public final void rule__VariantType__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2806:1: ( rule__VariantType__Group_6__0__Impl rule__VariantType__Group_6__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2807:2: rule__VariantType__Group_6__0__Impl rule__VariantType__Group_6__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_6__0__Impl_in_rule__VariantType__Group_6__05869);
            rule__VariantType__Group_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_6__1_in_rule__VariantType__Group_6__05872);
            rule__VariantType__Group_6__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group_6__0"


    // $ANTLR start "rule__VariantType__Group_6__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2814:1: rule__VariantType__Group_6__0__Impl : ( '=' ) ;
    public final void rule__VariantType__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2818:1: ( ( '=' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2819:1: ( '=' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2819:1: ( '=' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2820:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getEqualsSignKeyword_6_0()); 
            }
            match(input,56,FollowSets000.FOLLOW_56_in_rule__VariantType__Group_6__0__Impl5900); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getEqualsSignKeyword_6_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group_6__0__Impl"


    // $ANTLR start "rule__VariantType__Group_6__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2833:1: rule__VariantType__Group_6__1 : rule__VariantType__Group_6__1__Impl ;
    public final void rule__VariantType__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2837:1: ( rule__VariantType__Group_6__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2838:2: rule__VariantType__Group_6__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_6__1__Impl_in_rule__VariantType__Group_6__15931);
            rule__VariantType__Group_6__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group_6__1"


    // $ANTLR start "rule__VariantType__Group_6__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2844:1: rule__VariantType__Group_6__1__Impl : ( ( rule__VariantType__Alternatives_6_1 ) ) ;
    public final void rule__VariantType__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2848:1: ( ( ( rule__VariantType__Alternatives_6_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2849:1: ( ( rule__VariantType__Alternatives_6_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2849:1: ( ( rule__VariantType__Alternatives_6_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2850:1: ( rule__VariantType__Alternatives_6_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getAlternatives_6_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2851:1: ( rule__VariantType__Alternatives_6_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2851:2: rule__VariantType__Alternatives_6_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Alternatives_6_1_in_rule__VariantType__Group_6__1__Impl5958);
            rule__VariantType__Alternatives_6_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getAlternatives_6_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group_6__1__Impl"


    // $ANTLR start "rule__VariantType__Group_7__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2865:1: rule__VariantType__Group_7__0 : rule__VariantType__Group_7__0__Impl rule__VariantType__Group_7__1 ;
    public final void rule__VariantType__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2869:1: ( rule__VariantType__Group_7__0__Impl rule__VariantType__Group_7__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2870:2: rule__VariantType__Group_7__0__Impl rule__VariantType__Group_7__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_7__0__Impl_in_rule__VariantType__Group_7__05992);
            rule__VariantType__Group_7__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_7__1_in_rule__VariantType__Group_7__05995);
            rule__VariantType__Group_7__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group_7__0"


    // $ANTLR start "rule__VariantType__Group_7__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2877:1: rule__VariantType__Group_7__0__Impl : ( ':' ) ;
    public final void rule__VariantType__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2881:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2882:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2882:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2883:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getColonKeyword_7_0()); 
            }
            match(input,54,FollowSets000.FOLLOW_54_in_rule__VariantType__Group_7__0__Impl6023); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getColonKeyword_7_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group_7__0__Impl"


    // $ANTLR start "rule__VariantType__Group_7__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2896:1: rule__VariantType__Group_7__1 : rule__VariantType__Group_7__1__Impl ;
    public final void rule__VariantType__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2900:1: ( rule__VariantType__Group_7__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2901:2: rule__VariantType__Group_7__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_7__1__Impl_in_rule__VariantType__Group_7__16054);
            rule__VariantType__Group_7__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group_7__1"


    // $ANTLR start "rule__VariantType__Group_7__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2907:1: rule__VariantType__Group_7__1__Impl : ( ( rule__VariantType__DescriptionAssignment_7_1 ) ) ;
    public final void rule__VariantType__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2911:1: ( ( ( rule__VariantType__DescriptionAssignment_7_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2912:1: ( ( rule__VariantType__DescriptionAssignment_7_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2912:1: ( ( rule__VariantType__DescriptionAssignment_7_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2913:1: ( rule__VariantType__DescriptionAssignment_7_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getDescriptionAssignment_7_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2914:1: ( rule__VariantType__DescriptionAssignment_7_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2914:2: rule__VariantType__DescriptionAssignment_7_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__DescriptionAssignment_7_1_in_rule__VariantType__Group_7__1__Impl6081);
            rule__VariantType__DescriptionAssignment_7_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getDescriptionAssignment_7_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__Group_7__1__Impl"


    // $ANTLR start "rule__EnumeratorType__Group__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2928:1: rule__EnumeratorType__Group__0 : rule__EnumeratorType__Group__0__Impl rule__EnumeratorType__Group__1 ;
    public final void rule__EnumeratorType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2932:1: ( rule__EnumeratorType__Group__0__Impl rule__EnumeratorType__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2933:2: rule__EnumeratorType__Group__0__Impl rule__EnumeratorType__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group__0__Impl_in_rule__EnumeratorType__Group__06115);
            rule__EnumeratorType__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group__1_in_rule__EnumeratorType__Group__06118);
            rule__EnumeratorType__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumeratorType__Group__0"


    // $ANTLR start "rule__EnumeratorType__Group__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2940:1: rule__EnumeratorType__Group__0__Impl : ( () ) ;
    public final void rule__EnumeratorType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2944:1: ( ( () ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2945:1: ( () )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2945:1: ( () )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2946:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getEnumeratorTypeAction_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2947:1: ()
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2949:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumeratorTypeAccess().getEnumeratorTypeAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumeratorType__Group__0__Impl"


    // $ANTLR start "rule__EnumeratorType__Group__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2959:1: rule__EnumeratorType__Group__1 : rule__EnumeratorType__Group__1__Impl rule__EnumeratorType__Group__2 ;
    public final void rule__EnumeratorType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2963:1: ( rule__EnumeratorType__Group__1__Impl rule__EnumeratorType__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2964:2: rule__EnumeratorType__Group__1__Impl rule__EnumeratorType__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group__1__Impl_in_rule__EnumeratorType__Group__16176);
            rule__EnumeratorType__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group__2_in_rule__EnumeratorType__Group__16179);
            rule__EnumeratorType__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumeratorType__Group__1"


    // $ANTLR start "rule__EnumeratorType__Group__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2971:1: rule__EnumeratorType__Group__1__Impl : ( ( rule__EnumeratorType__NameAssignment_1 ) ) ;
    public final void rule__EnumeratorType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2975:1: ( ( ( rule__EnumeratorType__NameAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2976:1: ( ( rule__EnumeratorType__NameAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2976:1: ( ( rule__EnumeratorType__NameAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2977:1: ( rule__EnumeratorType__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getNameAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2978:1: ( rule__EnumeratorType__NameAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2978:2: rule__EnumeratorType__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__NameAssignment_1_in_rule__EnumeratorType__Group__1__Impl6206);
            rule__EnumeratorType__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumeratorTypeAccess().getNameAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumeratorType__Group__1__Impl"


    // $ANTLR start "rule__EnumeratorType__Group__2"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2988:1: rule__EnumeratorType__Group__2 : rule__EnumeratorType__Group__2__Impl rule__EnumeratorType__Group__3 ;
    public final void rule__EnumeratorType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2992:1: ( rule__EnumeratorType__Group__2__Impl rule__EnumeratorType__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2993:2: rule__EnumeratorType__Group__2__Impl rule__EnumeratorType__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group__2__Impl_in_rule__EnumeratorType__Group__26236);
            rule__EnumeratorType__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group__3_in_rule__EnumeratorType__Group__26239);
            rule__EnumeratorType__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumeratorType__Group__2"


    // $ANTLR start "rule__EnumeratorType__Group__2__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3000:1: rule__EnumeratorType__Group__2__Impl : ( ( rule__EnumeratorType__Group_2__0 )? ) ;
    public final void rule__EnumeratorType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3004:1: ( ( ( rule__EnumeratorType__Group_2__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3005:1: ( ( rule__EnumeratorType__Group_2__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3005:1: ( ( rule__EnumeratorType__Group_2__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3006:1: ( rule__EnumeratorType__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getGroup_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3007:1: ( rule__EnumeratorType__Group_2__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==51) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3007:2: rule__EnumeratorType__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_2__0_in_rule__EnumeratorType__Group__2__Impl6266);
                    rule__EnumeratorType__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumeratorTypeAccess().getGroup_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumeratorType__Group__2__Impl"


    // $ANTLR start "rule__EnumeratorType__Group__3"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3017:1: rule__EnumeratorType__Group__3 : rule__EnumeratorType__Group__3__Impl ;
    public final void rule__EnumeratorType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3021:1: ( rule__EnumeratorType__Group__3__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3022:2: rule__EnumeratorType__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group__3__Impl_in_rule__EnumeratorType__Group__36297);
            rule__EnumeratorType__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumeratorType__Group__3"


    // $ANTLR start "rule__EnumeratorType__Group__3__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3028:1: rule__EnumeratorType__Group__3__Impl : ( ( rule__EnumeratorType__Group_3__0 )? ) ;
    public final void rule__EnumeratorType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3032:1: ( ( ( rule__EnumeratorType__Group_3__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3033:1: ( ( rule__EnumeratorType__Group_3__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3033:1: ( ( rule__EnumeratorType__Group_3__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3034:1: ( rule__EnumeratorType__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getGroup_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3035:1: ( rule__EnumeratorType__Group_3__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==54) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3035:2: rule__EnumeratorType__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_3__0_in_rule__EnumeratorType__Group__3__Impl6324);
                    rule__EnumeratorType__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumeratorTypeAccess().getGroup_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumeratorType__Group__3__Impl"


    // $ANTLR start "rule__EnumeratorType__Group_2__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3053:1: rule__EnumeratorType__Group_2__0 : rule__EnumeratorType__Group_2__0__Impl rule__EnumeratorType__Group_2__1 ;
    public final void rule__EnumeratorType__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3057:1: ( rule__EnumeratorType__Group_2__0__Impl rule__EnumeratorType__Group_2__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3058:2: rule__EnumeratorType__Group_2__0__Impl rule__EnumeratorType__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_2__0__Impl_in_rule__EnumeratorType__Group_2__06363);
            rule__EnumeratorType__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_2__1_in_rule__EnumeratorType__Group_2__06366);
            rule__EnumeratorType__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumeratorType__Group_2__0"


    // $ANTLR start "rule__EnumeratorType__Group_2__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3065:1: rule__EnumeratorType__Group_2__0__Impl : ( '{' ) ;
    public final void rule__EnumeratorType__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3069:1: ( ( '{' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3070:1: ( '{' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3070:1: ( '{' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3071:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getLeftCurlyBracketKeyword_2_0()); 
            }
            match(input,51,FollowSets000.FOLLOW_51_in_rule__EnumeratorType__Group_2__0__Impl6394); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumeratorTypeAccess().getLeftCurlyBracketKeyword_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumeratorType__Group_2__0__Impl"


    // $ANTLR start "rule__EnumeratorType__Group_2__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3084:1: rule__EnumeratorType__Group_2__1 : rule__EnumeratorType__Group_2__1__Impl rule__EnumeratorType__Group_2__2 ;
    public final void rule__EnumeratorType__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3088:1: ( rule__EnumeratorType__Group_2__1__Impl rule__EnumeratorType__Group_2__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3089:2: rule__EnumeratorType__Group_2__1__Impl rule__EnumeratorType__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_2__1__Impl_in_rule__EnumeratorType__Group_2__16425);
            rule__EnumeratorType__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_2__2_in_rule__EnumeratorType__Group_2__16428);
            rule__EnumeratorType__Group_2__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumeratorType__Group_2__1"


    // $ANTLR start "rule__EnumeratorType__Group_2__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3096:1: rule__EnumeratorType__Group_2__1__Impl : ( ( rule__EnumeratorType__ParametersAssignment_2_1 )* ) ;
    public final void rule__EnumeratorType__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3100:1: ( ( ( rule__EnumeratorType__ParametersAssignment_2_1 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3101:1: ( ( rule__EnumeratorType__ParametersAssignment_2_1 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3101:1: ( ( rule__EnumeratorType__ParametersAssignment_2_1 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3102:1: ( rule__EnumeratorType__ParametersAssignment_2_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getParametersAssignment_2_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3103:1: ( rule__EnumeratorType__ParametersAssignment_2_1 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( ((LA37_0>=15 && LA37_0<=23)||(LA37_0>=37 && LA37_0<=49)) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3103:2: rule__EnumeratorType__ParametersAssignment_2_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__ParametersAssignment_2_1_in_rule__EnumeratorType__Group_2__1__Impl6455);
            	    rule__EnumeratorType__ParametersAssignment_2_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumeratorTypeAccess().getParametersAssignment_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumeratorType__Group_2__1__Impl"


    // $ANTLR start "rule__EnumeratorType__Group_2__2"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3113:1: rule__EnumeratorType__Group_2__2 : rule__EnumeratorType__Group_2__2__Impl ;
    public final void rule__EnumeratorType__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3117:1: ( rule__EnumeratorType__Group_2__2__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3118:2: rule__EnumeratorType__Group_2__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_2__2__Impl_in_rule__EnumeratorType__Group_2__26486);
            rule__EnumeratorType__Group_2__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumeratorType__Group_2__2"


    // $ANTLR start "rule__EnumeratorType__Group_2__2__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3124:1: rule__EnumeratorType__Group_2__2__Impl : ( '}' ) ;
    public final void rule__EnumeratorType__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3128:1: ( ( '}' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3129:1: ( '}' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3129:1: ( '}' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3130:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getRightCurlyBracketKeyword_2_2()); 
            }
            match(input,52,FollowSets000.FOLLOW_52_in_rule__EnumeratorType__Group_2__2__Impl6514); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumeratorTypeAccess().getRightCurlyBracketKeyword_2_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumeratorType__Group_2__2__Impl"


    // $ANTLR start "rule__EnumeratorType__Group_3__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3149:1: rule__EnumeratorType__Group_3__0 : rule__EnumeratorType__Group_3__0__Impl rule__EnumeratorType__Group_3__1 ;
    public final void rule__EnumeratorType__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3153:1: ( rule__EnumeratorType__Group_3__0__Impl rule__EnumeratorType__Group_3__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3154:2: rule__EnumeratorType__Group_3__0__Impl rule__EnumeratorType__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_3__0__Impl_in_rule__EnumeratorType__Group_3__06551);
            rule__EnumeratorType__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_3__1_in_rule__EnumeratorType__Group_3__06554);
            rule__EnumeratorType__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumeratorType__Group_3__0"


    // $ANTLR start "rule__EnumeratorType__Group_3__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3161:1: rule__EnumeratorType__Group_3__0__Impl : ( ':' ) ;
    public final void rule__EnumeratorType__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3165:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3166:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3166:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3167:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getColonKeyword_3_0()); 
            }
            match(input,54,FollowSets000.FOLLOW_54_in_rule__EnumeratorType__Group_3__0__Impl6582); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumeratorTypeAccess().getColonKeyword_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumeratorType__Group_3__0__Impl"


    // $ANTLR start "rule__EnumeratorType__Group_3__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3180:1: rule__EnumeratorType__Group_3__1 : rule__EnumeratorType__Group_3__1__Impl ;
    public final void rule__EnumeratorType__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3184:1: ( rule__EnumeratorType__Group_3__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3185:2: rule__EnumeratorType__Group_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_3__1__Impl_in_rule__EnumeratorType__Group_3__16613);
            rule__EnumeratorType__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumeratorType__Group_3__1"


    // $ANTLR start "rule__EnumeratorType__Group_3__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3191:1: rule__EnumeratorType__Group_3__1__Impl : ( ( rule__EnumeratorType__DescriptionAssignment_3_1 ) ) ;
    public final void rule__EnumeratorType__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3195:1: ( ( ( rule__EnumeratorType__DescriptionAssignment_3_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3196:1: ( ( rule__EnumeratorType__DescriptionAssignment_3_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3196:1: ( ( rule__EnumeratorType__DescriptionAssignment_3_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3197:1: ( rule__EnumeratorType__DescriptionAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getDescriptionAssignment_3_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3198:1: ( rule__EnumeratorType__DescriptionAssignment_3_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3198:2: rule__EnumeratorType__DescriptionAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__DescriptionAssignment_3_1_in_rule__EnumeratorType__Group_3__1__Impl6640);
            rule__EnumeratorType__DescriptionAssignment_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumeratorTypeAccess().getDescriptionAssignment_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumeratorType__Group_3__1__Impl"


    // $ANTLR start "rule__ReferenceType__Group__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3212:1: rule__ReferenceType__Group__0 : rule__ReferenceType__Group__0__Impl rule__ReferenceType__Group__1 ;
    public final void rule__ReferenceType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3216:1: ( rule__ReferenceType__Group__0__Impl rule__ReferenceType__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3217:2: rule__ReferenceType__Group__0__Impl rule__ReferenceType__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__0__Impl_in_rule__ReferenceType__Group__06674);
            rule__ReferenceType__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__1_in_rule__ReferenceType__Group__06677);
            rule__ReferenceType__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__Group__0"


    // $ANTLR start "rule__ReferenceType__Group__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3224:1: rule__ReferenceType__Group__0__Impl : ( () ) ;
    public final void rule__ReferenceType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3228:1: ( ( () ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3229:1: ( () )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3229:1: ( () )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3230:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getReferenceTypeAction_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3231:1: ()
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3233:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getReferenceTypeAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__Group__0__Impl"


    // $ANTLR start "rule__ReferenceType__Group__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3243:1: rule__ReferenceType__Group__1 : rule__ReferenceType__Group__1__Impl rule__ReferenceType__Group__2 ;
    public final void rule__ReferenceType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3247:1: ( rule__ReferenceType__Group__1__Impl rule__ReferenceType__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3248:2: rule__ReferenceType__Group__1__Impl rule__ReferenceType__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__1__Impl_in_rule__ReferenceType__Group__16735);
            rule__ReferenceType__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__2_in_rule__ReferenceType__Group__16738);
            rule__ReferenceType__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__Group__1"


    // $ANTLR start "rule__ReferenceType__Group__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3255:1: rule__ReferenceType__Group__1__Impl : ( ( rule__ReferenceType__TypeAssignment_1 ) ) ;
    public final void rule__ReferenceType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3259:1: ( ( ( rule__ReferenceType__TypeAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3260:1: ( ( rule__ReferenceType__TypeAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3260:1: ( ( rule__ReferenceType__TypeAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3261:1: ( rule__ReferenceType__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getTypeAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3262:1: ( rule__ReferenceType__TypeAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3262:2: rule__ReferenceType__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__TypeAssignment_1_in_rule__ReferenceType__Group__1__Impl6765);
            rule__ReferenceType__TypeAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getTypeAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__Group__1__Impl"


    // $ANTLR start "rule__ReferenceType__Group__2"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3272:1: rule__ReferenceType__Group__2 : rule__ReferenceType__Group__2__Impl rule__ReferenceType__Group__3 ;
    public final void rule__ReferenceType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3276:1: ( rule__ReferenceType__Group__2__Impl rule__ReferenceType__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3277:2: rule__ReferenceType__Group__2__Impl rule__ReferenceType__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__2__Impl_in_rule__ReferenceType__Group__26795);
            rule__ReferenceType__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__3_in_rule__ReferenceType__Group__26798);
            rule__ReferenceType__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__Group__2"


    // $ANTLR start "rule__ReferenceType__Group__2__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3284:1: rule__ReferenceType__Group__2__Impl : ( ( rule__ReferenceType__WithAutoAssignment_2 )? ) ;
    public final void rule__ReferenceType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3288:1: ( ( ( rule__ReferenceType__WithAutoAssignment_2 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3289:1: ( ( rule__ReferenceType__WithAutoAssignment_2 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3289:1: ( ( rule__ReferenceType__WithAutoAssignment_2 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3290:1: ( rule__ReferenceType__WithAutoAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getWithAutoAssignment_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3291:1: ( rule__ReferenceType__WithAutoAssignment_2 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==59) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3291:2: rule__ReferenceType__WithAutoAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__WithAutoAssignment_2_in_rule__ReferenceType__Group__2__Impl6825);
                    rule__ReferenceType__WithAutoAssignment_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getWithAutoAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__Group__2__Impl"


    // $ANTLR start "rule__ReferenceType__Group__3"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3301:1: rule__ReferenceType__Group__3 : rule__ReferenceType__Group__3__Impl rule__ReferenceType__Group__4 ;
    public final void rule__ReferenceType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3305:1: ( rule__ReferenceType__Group__3__Impl rule__ReferenceType__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3306:2: rule__ReferenceType__Group__3__Impl rule__ReferenceType__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__3__Impl_in_rule__ReferenceType__Group__36856);
            rule__ReferenceType__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__4_in_rule__ReferenceType__Group__36859);
            rule__ReferenceType__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__Group__3"


    // $ANTLR start "rule__ReferenceType__Group__3__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3313:1: rule__ReferenceType__Group__3__Impl : ( ( rule__ReferenceType__NameAssignment_3 ) ) ;
    public final void rule__ReferenceType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3317:1: ( ( ( rule__ReferenceType__NameAssignment_3 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3318:1: ( ( rule__ReferenceType__NameAssignment_3 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3318:1: ( ( rule__ReferenceType__NameAssignment_3 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3319:1: ( rule__ReferenceType__NameAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getNameAssignment_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3320:1: ( rule__ReferenceType__NameAssignment_3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3320:2: rule__ReferenceType__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__NameAssignment_3_in_rule__ReferenceType__Group__3__Impl6886);
            rule__ReferenceType__NameAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getNameAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__Group__3__Impl"


    // $ANTLR start "rule__ReferenceType__Group__4"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3330:1: rule__ReferenceType__Group__4 : rule__ReferenceType__Group__4__Impl rule__ReferenceType__Group__5 ;
    public final void rule__ReferenceType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3334:1: ( rule__ReferenceType__Group__4__Impl rule__ReferenceType__Group__5 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3335:2: rule__ReferenceType__Group__4__Impl rule__ReferenceType__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__4__Impl_in_rule__ReferenceType__Group__46916);
            rule__ReferenceType__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__5_in_rule__ReferenceType__Group__46919);
            rule__ReferenceType__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__Group__4"


    // $ANTLR start "rule__ReferenceType__Group__4__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3342:1: rule__ReferenceType__Group__4__Impl : ( ( rule__ReferenceType__MultiValueAssignment_4 )? ) ;
    public final void rule__ReferenceType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3346:1: ( ( ( rule__ReferenceType__MultiValueAssignment_4 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3347:1: ( ( rule__ReferenceType__MultiValueAssignment_4 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3347:1: ( ( rule__ReferenceType__MultiValueAssignment_4 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3348:1: ( rule__ReferenceType__MultiValueAssignment_4 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getMultiValueAssignment_4()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3349:1: ( rule__ReferenceType__MultiValueAssignment_4 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==60) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3349:2: rule__ReferenceType__MultiValueAssignment_4
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__MultiValueAssignment_4_in_rule__ReferenceType__Group__4__Impl6946);
                    rule__ReferenceType__MultiValueAssignment_4();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getMultiValueAssignment_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__Group__4__Impl"


    // $ANTLR start "rule__ReferenceType__Group__5"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3359:1: rule__ReferenceType__Group__5 : rule__ReferenceType__Group__5__Impl rule__ReferenceType__Group__6 ;
    public final void rule__ReferenceType__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3363:1: ( rule__ReferenceType__Group__5__Impl rule__ReferenceType__Group__6 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3364:2: rule__ReferenceType__Group__5__Impl rule__ReferenceType__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__5__Impl_in_rule__ReferenceType__Group__56977);
            rule__ReferenceType__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__6_in_rule__ReferenceType__Group__56980);
            rule__ReferenceType__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__Group__5"


    // $ANTLR start "rule__ReferenceType__Group__5__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3371:1: rule__ReferenceType__Group__5__Impl : ( ( rule__ReferenceType__Group_5__0 )? ) ;
    public final void rule__ReferenceType__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3375:1: ( ( ( rule__ReferenceType__Group_5__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3376:1: ( ( rule__ReferenceType__Group_5__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3376:1: ( ( rule__ReferenceType__Group_5__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3377:1: ( rule__ReferenceType__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getGroup_5()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3378:1: ( rule__ReferenceType__Group_5__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==56) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3378:2: rule__ReferenceType__Group_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_5__0_in_rule__ReferenceType__Group__5__Impl7007);
                    rule__ReferenceType__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getGroup_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__Group__5__Impl"


    // $ANTLR start "rule__ReferenceType__Group__6"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3388:1: rule__ReferenceType__Group__6 : rule__ReferenceType__Group__6__Impl rule__ReferenceType__Group__7 ;
    public final void rule__ReferenceType__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3392:1: ( rule__ReferenceType__Group__6__Impl rule__ReferenceType__Group__7 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3393:2: rule__ReferenceType__Group__6__Impl rule__ReferenceType__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__6__Impl_in_rule__ReferenceType__Group__67038);
            rule__ReferenceType__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__7_in_rule__ReferenceType__Group__67041);
            rule__ReferenceType__Group__7();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__Group__6"


    // $ANTLR start "rule__ReferenceType__Group__6__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3400:1: rule__ReferenceType__Group__6__Impl : ( ( rule__ReferenceType__Group_6__0 )? ) ;
    public final void rule__ReferenceType__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3404:1: ( ( ( rule__ReferenceType__Group_6__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3405:1: ( ( rule__ReferenceType__Group_6__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3405:1: ( ( rule__ReferenceType__Group_6__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3406:1: ( rule__ReferenceType__Group_6__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getGroup_6()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3407:1: ( rule__ReferenceType__Group_6__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==54) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3407:2: rule__ReferenceType__Group_6__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_6__0_in_rule__ReferenceType__Group__6__Impl7068);
                    rule__ReferenceType__Group_6__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getGroup_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__Group__6__Impl"


    // $ANTLR start "rule__ReferenceType__Group__7"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3417:1: rule__ReferenceType__Group__7 : rule__ReferenceType__Group__7__Impl ;
    public final void rule__ReferenceType__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3421:1: ( rule__ReferenceType__Group__7__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3422:2: rule__ReferenceType__Group__7__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__7__Impl_in_rule__ReferenceType__Group__77099);
            rule__ReferenceType__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__Group__7"


    // $ANTLR start "rule__ReferenceType__Group__7__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3428:1: rule__ReferenceType__Group__7__Impl : ( ';' ) ;
    public final void rule__ReferenceType__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3432:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3433:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3433:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3434:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getSemicolonKeyword_7()); 
            }
            match(input,53,FollowSets000.FOLLOW_53_in_rule__ReferenceType__Group__7__Impl7127); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getSemicolonKeyword_7()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__Group__7__Impl"


    // $ANTLR start "rule__ReferenceType__Group_5__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3463:1: rule__ReferenceType__Group_5__0 : rule__ReferenceType__Group_5__0__Impl rule__ReferenceType__Group_5__1 ;
    public final void rule__ReferenceType__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3467:1: ( rule__ReferenceType__Group_5__0__Impl rule__ReferenceType__Group_5__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3468:2: rule__ReferenceType__Group_5__0__Impl rule__ReferenceType__Group_5__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_5__0__Impl_in_rule__ReferenceType__Group_5__07174);
            rule__ReferenceType__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_5__1_in_rule__ReferenceType__Group_5__07177);
            rule__ReferenceType__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__Group_5__0"


    // $ANTLR start "rule__ReferenceType__Group_5__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3475:1: rule__ReferenceType__Group_5__0__Impl : ( '=' ) ;
    public final void rule__ReferenceType__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3479:1: ( ( '=' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3480:1: ( '=' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3480:1: ( '=' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3481:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getEqualsSignKeyword_5_0()); 
            }
            match(input,56,FollowSets000.FOLLOW_56_in_rule__ReferenceType__Group_5__0__Impl7205); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getEqualsSignKeyword_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__Group_5__0__Impl"


    // $ANTLR start "rule__ReferenceType__Group_5__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3494:1: rule__ReferenceType__Group_5__1 : rule__ReferenceType__Group_5__1__Impl ;
    public final void rule__ReferenceType__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3498:1: ( rule__ReferenceType__Group_5__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3499:2: rule__ReferenceType__Group_5__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_5__1__Impl_in_rule__ReferenceType__Group_5__17236);
            rule__ReferenceType__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__Group_5__1"


    // $ANTLR start "rule__ReferenceType__Group_5__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3505:1: rule__ReferenceType__Group_5__1__Impl : ( ( rule__ReferenceType__Alternatives_5_1 ) ) ;
    public final void rule__ReferenceType__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3509:1: ( ( ( rule__ReferenceType__Alternatives_5_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3510:1: ( ( rule__ReferenceType__Alternatives_5_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3510:1: ( ( rule__ReferenceType__Alternatives_5_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3511:1: ( rule__ReferenceType__Alternatives_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getAlternatives_5_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3512:1: ( rule__ReferenceType__Alternatives_5_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3512:2: rule__ReferenceType__Alternatives_5_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Alternatives_5_1_in_rule__ReferenceType__Group_5__1__Impl7263);
            rule__ReferenceType__Alternatives_5_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getAlternatives_5_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__Group_5__1__Impl"


    // $ANTLR start "rule__ReferenceType__Group_6__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3526:1: rule__ReferenceType__Group_6__0 : rule__ReferenceType__Group_6__0__Impl rule__ReferenceType__Group_6__1 ;
    public final void rule__ReferenceType__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3530:1: ( rule__ReferenceType__Group_6__0__Impl rule__ReferenceType__Group_6__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3531:2: rule__ReferenceType__Group_6__0__Impl rule__ReferenceType__Group_6__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_6__0__Impl_in_rule__ReferenceType__Group_6__07297);
            rule__ReferenceType__Group_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_6__1_in_rule__ReferenceType__Group_6__07300);
            rule__ReferenceType__Group_6__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__Group_6__0"


    // $ANTLR start "rule__ReferenceType__Group_6__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3538:1: rule__ReferenceType__Group_6__0__Impl : ( ':' ) ;
    public final void rule__ReferenceType__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3542:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3543:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3543:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3544:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getColonKeyword_6_0()); 
            }
            match(input,54,FollowSets000.FOLLOW_54_in_rule__ReferenceType__Group_6__0__Impl7328); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getColonKeyword_6_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__Group_6__0__Impl"


    // $ANTLR start "rule__ReferenceType__Group_6__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3557:1: rule__ReferenceType__Group_6__1 : rule__ReferenceType__Group_6__1__Impl ;
    public final void rule__ReferenceType__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3561:1: ( rule__ReferenceType__Group_6__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3562:2: rule__ReferenceType__Group_6__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_6__1__Impl_in_rule__ReferenceType__Group_6__17359);
            rule__ReferenceType__Group_6__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__Group_6__1"


    // $ANTLR start "rule__ReferenceType__Group_6__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3568:1: rule__ReferenceType__Group_6__1__Impl : ( ( rule__ReferenceType__DescriptionAssignment_6_1 ) ) ;
    public final void rule__ReferenceType__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3572:1: ( ( ( rule__ReferenceType__DescriptionAssignment_6_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3573:1: ( ( rule__ReferenceType__DescriptionAssignment_6_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3573:1: ( ( rule__ReferenceType__DescriptionAssignment_6_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3574:1: ( rule__ReferenceType__DescriptionAssignment_6_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getDescriptionAssignment_6_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3575:1: ( rule__ReferenceType__DescriptionAssignment_6_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3575:2: rule__ReferenceType__DescriptionAssignment_6_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__DescriptionAssignment_6_1_in_rule__ReferenceType__Group_6__1__Impl7386);
            rule__ReferenceType__DescriptionAssignment_6_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getDescriptionAssignment_6_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__Group_6__1__Impl"


    // $ANTLR start "rule__OilObject__Group__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3589:1: rule__OilObject__Group__0 : rule__OilObject__Group__0__Impl rule__OilObject__Group__1 ;
    public final void rule__OilObject__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3593:1: ( rule__OilObject__Group__0__Impl rule__OilObject__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3594:2: rule__OilObject__Group__0__Impl rule__OilObject__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__0__Impl_in_rule__OilObject__Group__07420);
            rule__OilObject__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__1_in_rule__OilObject__Group__07423);
            rule__OilObject__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObject__Group__0"


    // $ANTLR start "rule__OilObject__Group__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3601:1: rule__OilObject__Group__0__Impl : ( ( rule__OilObject__TypeAssignment_0 ) ) ;
    public final void rule__OilObject__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3605:1: ( ( ( rule__OilObject__TypeAssignment_0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3606:1: ( ( rule__OilObject__TypeAssignment_0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3606:1: ( ( rule__OilObject__TypeAssignment_0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3607:1: ( rule__OilObject__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getTypeAssignment_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3608:1: ( rule__OilObject__TypeAssignment_0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3608:2: rule__OilObject__TypeAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__TypeAssignment_0_in_rule__OilObject__Group__0__Impl7450);
            rule__OilObject__TypeAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectAccess().getTypeAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObject__Group__0__Impl"


    // $ANTLR start "rule__OilObject__Group__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3618:1: rule__OilObject__Group__1 : rule__OilObject__Group__1__Impl rule__OilObject__Group__2 ;
    public final void rule__OilObject__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3622:1: ( rule__OilObject__Group__1__Impl rule__OilObject__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3623:2: rule__OilObject__Group__1__Impl rule__OilObject__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__1__Impl_in_rule__OilObject__Group__17480);
            rule__OilObject__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__2_in_rule__OilObject__Group__17483);
            rule__OilObject__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObject__Group__1"


    // $ANTLR start "rule__OilObject__Group__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3630:1: rule__OilObject__Group__1__Impl : ( ( rule__OilObject__NameAssignment_1 ) ) ;
    public final void rule__OilObject__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3634:1: ( ( ( rule__OilObject__NameAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3635:1: ( ( rule__OilObject__NameAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3635:1: ( ( rule__OilObject__NameAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3636:1: ( rule__OilObject__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getNameAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3637:1: ( rule__OilObject__NameAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3637:2: rule__OilObject__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__NameAssignment_1_in_rule__OilObject__Group__1__Impl7510);
            rule__OilObject__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectAccess().getNameAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObject__Group__1__Impl"


    // $ANTLR start "rule__OilObject__Group__2"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3647:1: rule__OilObject__Group__2 : rule__OilObject__Group__2__Impl rule__OilObject__Group__3 ;
    public final void rule__OilObject__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3651:1: ( rule__OilObject__Group__2__Impl rule__OilObject__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3652:2: rule__OilObject__Group__2__Impl rule__OilObject__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__2__Impl_in_rule__OilObject__Group__27540);
            rule__OilObject__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__3_in_rule__OilObject__Group__27543);
            rule__OilObject__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObject__Group__2"


    // $ANTLR start "rule__OilObject__Group__2__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3659:1: rule__OilObject__Group__2__Impl : ( '{' ) ;
    public final void rule__OilObject__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3663:1: ( ( '{' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3664:1: ( '{' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3664:1: ( '{' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3665:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,51,FollowSets000.FOLLOW_51_in_rule__OilObject__Group__2__Impl7571); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectAccess().getLeftCurlyBracketKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObject__Group__2__Impl"


    // $ANTLR start "rule__OilObject__Group__3"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3678:1: rule__OilObject__Group__3 : rule__OilObject__Group__3__Impl rule__OilObject__Group__4 ;
    public final void rule__OilObject__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3682:1: ( rule__OilObject__Group__3__Impl rule__OilObject__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3683:2: rule__OilObject__Group__3__Impl rule__OilObject__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__3__Impl_in_rule__OilObject__Group__37602);
            rule__OilObject__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__4_in_rule__OilObject__Group__37605);
            rule__OilObject__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObject__Group__3"


    // $ANTLR start "rule__OilObject__Group__3__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3690:1: rule__OilObject__Group__3__Impl : ( ( rule__OilObject__ParametersAssignment_3 )* ) ;
    public final void rule__OilObject__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3694:1: ( ( ( rule__OilObject__ParametersAssignment_3 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3695:1: ( ( rule__OilObject__ParametersAssignment_3 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3695:1: ( ( rule__OilObject__ParametersAssignment_3 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3696:1: ( rule__OilObject__ParametersAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getParametersAssignment_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3697:1: ( rule__OilObject__ParametersAssignment_3 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==RULE_ID) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3697:2: rule__OilObject__ParametersAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__OilObject__ParametersAssignment_3_in_rule__OilObject__Group__3__Impl7632);
            	    rule__OilObject__ParametersAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectAccess().getParametersAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObject__Group__3__Impl"


    // $ANTLR start "rule__OilObject__Group__4"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3707:1: rule__OilObject__Group__4 : rule__OilObject__Group__4__Impl rule__OilObject__Group__5 ;
    public final void rule__OilObject__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3711:1: ( rule__OilObject__Group__4__Impl rule__OilObject__Group__5 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3712:2: rule__OilObject__Group__4__Impl rule__OilObject__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__4__Impl_in_rule__OilObject__Group__47663);
            rule__OilObject__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__5_in_rule__OilObject__Group__47666);
            rule__OilObject__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObject__Group__4"


    // $ANTLR start "rule__OilObject__Group__4__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3719:1: rule__OilObject__Group__4__Impl : ( '}' ) ;
    public final void rule__OilObject__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3723:1: ( ( '}' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3724:1: ( '}' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3724:1: ( '}' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3725:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,52,FollowSets000.FOLLOW_52_in_rule__OilObject__Group__4__Impl7694); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectAccess().getRightCurlyBracketKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObject__Group__4__Impl"


    // $ANTLR start "rule__OilObject__Group__5"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3738:1: rule__OilObject__Group__5 : rule__OilObject__Group__5__Impl rule__OilObject__Group__6 ;
    public final void rule__OilObject__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3742:1: ( rule__OilObject__Group__5__Impl rule__OilObject__Group__6 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3743:2: rule__OilObject__Group__5__Impl rule__OilObject__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__5__Impl_in_rule__OilObject__Group__57725);
            rule__OilObject__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__6_in_rule__OilObject__Group__57728);
            rule__OilObject__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObject__Group__5"


    // $ANTLR start "rule__OilObject__Group__5__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3750:1: rule__OilObject__Group__5__Impl : ( ( rule__OilObject__Group_5__0 )? ) ;
    public final void rule__OilObject__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3754:1: ( ( ( rule__OilObject__Group_5__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3755:1: ( ( rule__OilObject__Group_5__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3755:1: ( ( rule__OilObject__Group_5__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3756:1: ( rule__OilObject__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getGroup_5()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3757:1: ( rule__OilObject__Group_5__0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==54) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3757:2: rule__OilObject__Group_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group_5__0_in_rule__OilObject__Group__5__Impl7755);
                    rule__OilObject__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectAccess().getGroup_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObject__Group__5__Impl"


    // $ANTLR start "rule__OilObject__Group__6"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3767:1: rule__OilObject__Group__6 : rule__OilObject__Group__6__Impl ;
    public final void rule__OilObject__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3771:1: ( rule__OilObject__Group__6__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3772:2: rule__OilObject__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__6__Impl_in_rule__OilObject__Group__67786);
            rule__OilObject__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObject__Group__6"


    // $ANTLR start "rule__OilObject__Group__6__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3778:1: rule__OilObject__Group__6__Impl : ( ';' ) ;
    public final void rule__OilObject__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3782:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3783:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3783:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3784:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getSemicolonKeyword_6()); 
            }
            match(input,53,FollowSets000.FOLLOW_53_in_rule__OilObject__Group__6__Impl7814); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectAccess().getSemicolonKeyword_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObject__Group__6__Impl"


    // $ANTLR start "rule__OilObject__Group_5__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3811:1: rule__OilObject__Group_5__0 : rule__OilObject__Group_5__0__Impl rule__OilObject__Group_5__1 ;
    public final void rule__OilObject__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3815:1: ( rule__OilObject__Group_5__0__Impl rule__OilObject__Group_5__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3816:2: rule__OilObject__Group_5__0__Impl rule__OilObject__Group_5__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group_5__0__Impl_in_rule__OilObject__Group_5__07859);
            rule__OilObject__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group_5__1_in_rule__OilObject__Group_5__07862);
            rule__OilObject__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObject__Group_5__0"


    // $ANTLR start "rule__OilObject__Group_5__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3823:1: rule__OilObject__Group_5__0__Impl : ( ':' ) ;
    public final void rule__OilObject__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3827:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3828:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3828:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3829:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getColonKeyword_5_0()); 
            }
            match(input,54,FollowSets000.FOLLOW_54_in_rule__OilObject__Group_5__0__Impl7890); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectAccess().getColonKeyword_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObject__Group_5__0__Impl"


    // $ANTLR start "rule__OilObject__Group_5__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3842:1: rule__OilObject__Group_5__1 : rule__OilObject__Group_5__1__Impl ;
    public final void rule__OilObject__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3846:1: ( rule__OilObject__Group_5__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3847:2: rule__OilObject__Group_5__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group_5__1__Impl_in_rule__OilObject__Group_5__17921);
            rule__OilObject__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObject__Group_5__1"


    // $ANTLR start "rule__OilObject__Group_5__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3853:1: rule__OilObject__Group_5__1__Impl : ( ( rule__OilObject__DescriptionAssignment_5_1 ) ) ;
    public final void rule__OilObject__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3857:1: ( ( ( rule__OilObject__DescriptionAssignment_5_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3858:1: ( ( rule__OilObject__DescriptionAssignment_5_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3858:1: ( ( rule__OilObject__DescriptionAssignment_5_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3859:1: ( rule__OilObject__DescriptionAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getDescriptionAssignment_5_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3860:1: ( rule__OilObject__DescriptionAssignment_5_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3860:2: rule__OilObject__DescriptionAssignment_5_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__DescriptionAssignment_5_1_in_rule__OilObject__Group_5__1__Impl7948);
            rule__OilObject__DescriptionAssignment_5_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectAccess().getDescriptionAssignment_5_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObject__Group_5__1__Impl"


    // $ANTLR start "rule__Parameter__Group__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3874:1: rule__Parameter__Group__0 : rule__Parameter__Group__0__Impl rule__Parameter__Group__1 ;
    public final void rule__Parameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3878:1: ( rule__Parameter__Group__0__Impl rule__Parameter__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3879:2: rule__Parameter__Group__0__Impl rule__Parameter__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__0__Impl_in_rule__Parameter__Group__07982);
            rule__Parameter__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__1_in_rule__Parameter__Group__07985);
            rule__Parameter__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__0"


    // $ANTLR start "rule__Parameter__Group__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3886:1: rule__Parameter__Group__0__Impl : ( () ) ;
    public final void rule__Parameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3890:1: ( ( () ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3891:1: ( () )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3891:1: ( () )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3892:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getParameterAction_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3893:1: ()
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3895:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getParameterAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__0__Impl"


    // $ANTLR start "rule__Parameter__Group__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3905:1: rule__Parameter__Group__1 : rule__Parameter__Group__1__Impl rule__Parameter__Group__2 ;
    public final void rule__Parameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3909:1: ( rule__Parameter__Group__1__Impl rule__Parameter__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3910:2: rule__Parameter__Group__1__Impl rule__Parameter__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__1__Impl_in_rule__Parameter__Group__18043);
            rule__Parameter__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__2_in_rule__Parameter__Group__18046);
            rule__Parameter__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__1"


    // $ANTLR start "rule__Parameter__Group__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3917:1: rule__Parameter__Group__1__Impl : ( ( rule__Parameter__TypeAssignment_1 ) ) ;
    public final void rule__Parameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3921:1: ( ( ( rule__Parameter__TypeAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3922:1: ( ( rule__Parameter__TypeAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3922:1: ( ( rule__Parameter__TypeAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3923:1: ( rule__Parameter__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getTypeAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3924:1: ( rule__Parameter__TypeAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3924:2: rule__Parameter__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__TypeAssignment_1_in_rule__Parameter__Group__1__Impl8073);
            rule__Parameter__TypeAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getTypeAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__1__Impl"


    // $ANTLR start "rule__Parameter__Group__2"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3934:1: rule__Parameter__Group__2 : rule__Parameter__Group__2__Impl rule__Parameter__Group__3 ;
    public final void rule__Parameter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3938:1: ( rule__Parameter__Group__2__Impl rule__Parameter__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3939:2: rule__Parameter__Group__2__Impl rule__Parameter__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__2__Impl_in_rule__Parameter__Group__28103);
            rule__Parameter__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__3_in_rule__Parameter__Group__28106);
            rule__Parameter__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__2"


    // $ANTLR start "rule__Parameter__Group__2__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3946:1: rule__Parameter__Group__2__Impl : ( '=' ) ;
    public final void rule__Parameter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3950:1: ( ( '=' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3951:1: ( '=' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3951:1: ( '=' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3952:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getEqualsSignKeyword_2()); 
            }
            match(input,56,FollowSets000.FOLLOW_56_in_rule__Parameter__Group__2__Impl8134); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getEqualsSignKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__2__Impl"


    // $ANTLR start "rule__Parameter__Group__3"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3965:1: rule__Parameter__Group__3 : rule__Parameter__Group__3__Impl rule__Parameter__Group__4 ;
    public final void rule__Parameter__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3969:1: ( rule__Parameter__Group__3__Impl rule__Parameter__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3970:2: rule__Parameter__Group__3__Impl rule__Parameter__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__3__Impl_in_rule__Parameter__Group__38165);
            rule__Parameter__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__4_in_rule__Parameter__Group__38168);
            rule__Parameter__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__3"


    // $ANTLR start "rule__Parameter__Group__3__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3977:1: rule__Parameter__Group__3__Impl : ( ( rule__Parameter__Alternatives_3 ) ) ;
    public final void rule__Parameter__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3981:1: ( ( ( rule__Parameter__Alternatives_3 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3982:1: ( ( rule__Parameter__Alternatives_3 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3982:1: ( ( rule__Parameter__Alternatives_3 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3983:1: ( rule__Parameter__Alternatives_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getAlternatives_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3984:1: ( rule__Parameter__Alternatives_3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3984:2: rule__Parameter__Alternatives_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Alternatives_3_in_rule__Parameter__Group__3__Impl8195);
            rule__Parameter__Alternatives_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getAlternatives_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__3__Impl"


    // $ANTLR start "rule__Parameter__Group__4"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3994:1: rule__Parameter__Group__4 : rule__Parameter__Group__4__Impl rule__Parameter__Group__5 ;
    public final void rule__Parameter__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3998:1: ( rule__Parameter__Group__4__Impl rule__Parameter__Group__5 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3999:2: rule__Parameter__Group__4__Impl rule__Parameter__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__4__Impl_in_rule__Parameter__Group__48225);
            rule__Parameter__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__5_in_rule__Parameter__Group__48228);
            rule__Parameter__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__4"


    // $ANTLR start "rule__Parameter__Group__4__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4006:1: rule__Parameter__Group__4__Impl : ( ( rule__Parameter__Group_4__0 )? ) ;
    public final void rule__Parameter__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4010:1: ( ( ( rule__Parameter__Group_4__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4011:1: ( ( rule__Parameter__Group_4__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4011:1: ( ( rule__Parameter__Group_4__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4012:1: ( rule__Parameter__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getGroup_4()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4013:1: ( rule__Parameter__Group_4__0 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==51) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4013:2: rule__Parameter__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_4__0_in_rule__Parameter__Group__4__Impl8255);
                    rule__Parameter__Group_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getGroup_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__4__Impl"


    // $ANTLR start "rule__Parameter__Group__5"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4023:1: rule__Parameter__Group__5 : rule__Parameter__Group__5__Impl rule__Parameter__Group__6 ;
    public final void rule__Parameter__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4027:1: ( rule__Parameter__Group__5__Impl rule__Parameter__Group__6 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4028:2: rule__Parameter__Group__5__Impl rule__Parameter__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__5__Impl_in_rule__Parameter__Group__58286);
            rule__Parameter__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__6_in_rule__Parameter__Group__58289);
            rule__Parameter__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__5"


    // $ANTLR start "rule__Parameter__Group__5__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4035:1: rule__Parameter__Group__5__Impl : ( ( rule__Parameter__Group_5__0 )? ) ;
    public final void rule__Parameter__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4039:1: ( ( ( rule__Parameter__Group_5__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4040:1: ( ( rule__Parameter__Group_5__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4040:1: ( ( rule__Parameter__Group_5__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4041:1: ( rule__Parameter__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getGroup_5()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4042:1: ( rule__Parameter__Group_5__0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==54) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4042:2: rule__Parameter__Group_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_5__0_in_rule__Parameter__Group__5__Impl8316);
                    rule__Parameter__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getGroup_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__5__Impl"


    // $ANTLR start "rule__Parameter__Group__6"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4052:1: rule__Parameter__Group__6 : rule__Parameter__Group__6__Impl ;
    public final void rule__Parameter__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4056:1: ( rule__Parameter__Group__6__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4057:2: rule__Parameter__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__6__Impl_in_rule__Parameter__Group__68347);
            rule__Parameter__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__6"


    // $ANTLR start "rule__Parameter__Group__6__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4063:1: rule__Parameter__Group__6__Impl : ( ';' ) ;
    public final void rule__Parameter__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4067:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4068:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4068:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4069:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getSemicolonKeyword_6()); 
            }
            match(input,53,FollowSets000.FOLLOW_53_in_rule__Parameter__Group__6__Impl8375); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getSemicolonKeyword_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__6__Impl"


    // $ANTLR start "rule__Parameter__Group_4__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4096:1: rule__Parameter__Group_4__0 : rule__Parameter__Group_4__0__Impl rule__Parameter__Group_4__1 ;
    public final void rule__Parameter__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4100:1: ( rule__Parameter__Group_4__0__Impl rule__Parameter__Group_4__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4101:2: rule__Parameter__Group_4__0__Impl rule__Parameter__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_4__0__Impl_in_rule__Parameter__Group_4__08420);
            rule__Parameter__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_4__1_in_rule__Parameter__Group_4__08423);
            rule__Parameter__Group_4__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4__0"


    // $ANTLR start "rule__Parameter__Group_4__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4108:1: rule__Parameter__Group_4__0__Impl : ( '{' ) ;
    public final void rule__Parameter__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4112:1: ( ( '{' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4113:1: ( '{' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4113:1: ( '{' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4114:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getLeftCurlyBracketKeyword_4_0()); 
            }
            match(input,51,FollowSets000.FOLLOW_51_in_rule__Parameter__Group_4__0__Impl8451); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getLeftCurlyBracketKeyword_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4__0__Impl"


    // $ANTLR start "rule__Parameter__Group_4__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4127:1: rule__Parameter__Group_4__1 : rule__Parameter__Group_4__1__Impl rule__Parameter__Group_4__2 ;
    public final void rule__Parameter__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4131:1: ( rule__Parameter__Group_4__1__Impl rule__Parameter__Group_4__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4132:2: rule__Parameter__Group_4__1__Impl rule__Parameter__Group_4__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_4__1__Impl_in_rule__Parameter__Group_4__18482);
            rule__Parameter__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_4__2_in_rule__Parameter__Group_4__18485);
            rule__Parameter__Group_4__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4__1"


    // $ANTLR start "rule__Parameter__Group_4__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4139:1: rule__Parameter__Group_4__1__Impl : ( ( rule__Parameter__ParametersAssignment_4_1 )* ) ;
    public final void rule__Parameter__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4143:1: ( ( ( rule__Parameter__ParametersAssignment_4_1 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4144:1: ( ( rule__Parameter__ParametersAssignment_4_1 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4144:1: ( ( rule__Parameter__ParametersAssignment_4_1 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4145:1: ( rule__Parameter__ParametersAssignment_4_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getParametersAssignment_4_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4146:1: ( rule__Parameter__ParametersAssignment_4_1 )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==RULE_ID) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4146:2: rule__Parameter__ParametersAssignment_4_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Parameter__ParametersAssignment_4_1_in_rule__Parameter__Group_4__1__Impl8512);
            	    rule__Parameter__ParametersAssignment_4_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getParametersAssignment_4_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4__1__Impl"


    // $ANTLR start "rule__Parameter__Group_4__2"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4156:1: rule__Parameter__Group_4__2 : rule__Parameter__Group_4__2__Impl ;
    public final void rule__Parameter__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4160:1: ( rule__Parameter__Group_4__2__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4161:2: rule__Parameter__Group_4__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_4__2__Impl_in_rule__Parameter__Group_4__28543);
            rule__Parameter__Group_4__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4__2"


    // $ANTLR start "rule__Parameter__Group_4__2__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4167:1: rule__Parameter__Group_4__2__Impl : ( '}' ) ;
    public final void rule__Parameter__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4171:1: ( ( '}' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4172:1: ( '}' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4172:1: ( '}' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4173:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getRightCurlyBracketKeyword_4_2()); 
            }
            match(input,52,FollowSets000.FOLLOW_52_in_rule__Parameter__Group_4__2__Impl8571); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getRightCurlyBracketKeyword_4_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4__2__Impl"


    // $ANTLR start "rule__Parameter__Group_5__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4192:1: rule__Parameter__Group_5__0 : rule__Parameter__Group_5__0__Impl rule__Parameter__Group_5__1 ;
    public final void rule__Parameter__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4196:1: ( rule__Parameter__Group_5__0__Impl rule__Parameter__Group_5__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4197:2: rule__Parameter__Group_5__0__Impl rule__Parameter__Group_5__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_5__0__Impl_in_rule__Parameter__Group_5__08608);
            rule__Parameter__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_5__1_in_rule__Parameter__Group_5__08611);
            rule__Parameter__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_5__0"


    // $ANTLR start "rule__Parameter__Group_5__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4204:1: rule__Parameter__Group_5__0__Impl : ( ':' ) ;
    public final void rule__Parameter__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4208:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4209:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4209:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4210:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getColonKeyword_5_0()); 
            }
            match(input,54,FollowSets000.FOLLOW_54_in_rule__Parameter__Group_5__0__Impl8639); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getColonKeyword_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_5__0__Impl"


    // $ANTLR start "rule__Parameter__Group_5__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4223:1: rule__Parameter__Group_5__1 : rule__Parameter__Group_5__1__Impl ;
    public final void rule__Parameter__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4227:1: ( rule__Parameter__Group_5__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4228:2: rule__Parameter__Group_5__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_5__1__Impl_in_rule__Parameter__Group_5__18670);
            rule__Parameter__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_5__1"


    // $ANTLR start "rule__Parameter__Group_5__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4234:1: rule__Parameter__Group_5__1__Impl : ( ( rule__Parameter__DescriptionAssignment_5_1 ) ) ;
    public final void rule__Parameter__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4238:1: ( ( ( rule__Parameter__DescriptionAssignment_5_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4239:1: ( ( rule__Parameter__DescriptionAssignment_5_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4239:1: ( ( rule__Parameter__DescriptionAssignment_5_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4240:1: ( rule__Parameter__DescriptionAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getDescriptionAssignment_5_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4241:1: ( rule__Parameter__DescriptionAssignment_5_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4241:2: rule__Parameter__DescriptionAssignment_5_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__DescriptionAssignment_5_1_in_rule__Parameter__Group_5__1__Impl8697);
            rule__Parameter__DescriptionAssignment_5_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getDescriptionAssignment_5_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_5__1__Impl"


    // $ANTLR start "rule__INT__Group__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4255:1: rule__INT__Group__0 : rule__INT__Group__0__Impl rule__INT__Group__1 ;
    public final void rule__INT__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4259:1: ( rule__INT__Group__0__Impl rule__INT__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4260:2: rule__INT__Group__0__Impl rule__INT__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__INT__Group__0__Impl_in_rule__INT__Group__08731);
            rule__INT__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__INT__Group__1_in_rule__INT__Group__08734);
            rule__INT__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INT__Group__0"


    // $ANTLR start "rule__INT__Group__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4267:1: rule__INT__Group__0__Impl : ( ( rule__INT__Alternatives_0 )? ) ;
    public final void rule__INT__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4271:1: ( ( ( rule__INT__Alternatives_0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4272:1: ( ( rule__INT__Alternatives_0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4272:1: ( ( rule__INT__Alternatives_0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4273:1: ( rule__INT__Alternatives_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getINTAccess().getAlternatives_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4274:1: ( rule__INT__Alternatives_0 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( ((LA47_0>=13 && LA47_0<=14)) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4274:2: rule__INT__Alternatives_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__INT__Alternatives_0_in_rule__INT__Group__0__Impl8761);
                    rule__INT__Alternatives_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getINTAccess().getAlternatives_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INT__Group__0__Impl"


    // $ANTLR start "rule__INT__Group__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4284:1: rule__INT__Group__1 : rule__INT__Group__1__Impl ;
    public final void rule__INT__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4288:1: ( rule__INT__Group__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4289:2: rule__INT__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__INT__Group__1__Impl_in_rule__INT__Group__18792);
            rule__INT__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INT__Group__1"


    // $ANTLR start "rule__INT__Group__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4295:1: rule__INT__Group__1__Impl : ( ( rule__INT__Alternatives_1 ) ) ;
    public final void rule__INT__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4299:1: ( ( ( rule__INT__Alternatives_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4300:1: ( ( rule__INT__Alternatives_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4300:1: ( ( rule__INT__Alternatives_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4301:1: ( rule__INT__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getINTAccess().getAlternatives_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4302:1: ( rule__INT__Alternatives_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4302:2: rule__INT__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__INT__Alternatives_1_in_rule__INT__Group__1__Impl8819);
            rule__INT__Alternatives_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getINTAccess().getAlternatives_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INT__Group__1__Impl"


    // $ANTLR start "rule__INT__Group_1_0__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4316:1: rule__INT__Group_1_0__0 : rule__INT__Group_1_0__0__Impl rule__INT__Group_1_0__1 ;
    public final void rule__INT__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4320:1: ( rule__INT__Group_1_0__0__Impl rule__INT__Group_1_0__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4321:2: rule__INT__Group_1_0__0__Impl rule__INT__Group_1_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__INT__Group_1_0__0__Impl_in_rule__INT__Group_1_0__08853);
            rule__INT__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__INT__Group_1_0__1_in_rule__INT__Group_1_0__08856);
            rule__INT__Group_1_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INT__Group_1_0__0"


    // $ANTLR start "rule__INT__Group_1_0__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4328:1: rule__INT__Group_1_0__0__Impl : ( RULE_NON_ZERO_INT ) ;
    public final void rule__INT__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4332:1: ( ( RULE_NON_ZERO_INT ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4333:1: ( RULE_NON_ZERO_INT )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4333:1: ( RULE_NON_ZERO_INT )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4334:1: RULE_NON_ZERO_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getINTAccess().getNON_ZERO_INTTerminalRuleCall_1_0_0()); 
            }
            match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_rule__INT__Group_1_0__0__Impl8883); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getINTAccess().getNON_ZERO_INTTerminalRuleCall_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INT__Group_1_0__0__Impl"


    // $ANTLR start "rule__INT__Group_1_0__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4345:1: rule__INT__Group_1_0__1 : rule__INT__Group_1_0__1__Impl ;
    public final void rule__INT__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4349:1: ( rule__INT__Group_1_0__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4350:2: rule__INT__Group_1_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__INT__Group_1_0__1__Impl_in_rule__INT__Group_1_0__18912);
            rule__INT__Group_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INT__Group_1_0__1"


    // $ANTLR start "rule__INT__Group_1_0__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4356:1: rule__INT__Group_1_0__1__Impl : ( ( rule__INT__Alternatives_1_0_1 )* ) ;
    public final void rule__INT__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4360:1: ( ( ( rule__INT__Alternatives_1_0_1 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4361:1: ( ( rule__INT__Alternatives_1_0_1 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4361:1: ( ( rule__INT__Alternatives_1_0_1 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4362:1: ( rule__INT__Alternatives_1_0_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getINTAccess().getAlternatives_1_0_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4363:1: ( rule__INT__Alternatives_1_0_1 )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( ((LA48_0>=RULE_ZERO_INT && LA48_0<=RULE_NON_ZERO_INT)) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4363:2: rule__INT__Alternatives_1_0_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__INT__Alternatives_1_0_1_in_rule__INT__Group_1_0__1__Impl8939);
            	    rule__INT__Alternatives_1_0_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getINTAccess().getAlternatives_1_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__INT__Group_1_0__1__Impl"


    // $ANTLR start "rule__DOUBLE__Group__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4377:1: rule__DOUBLE__Group__0 : rule__DOUBLE__Group__0__Impl rule__DOUBLE__Group__1 ;
    public final void rule__DOUBLE__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4381:1: ( rule__DOUBLE__Group__0__Impl rule__DOUBLE__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4382:2: rule__DOUBLE__Group__0__Impl rule__DOUBLE__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Group__0__Impl_in_rule__DOUBLE__Group__08974);
            rule__DOUBLE__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Group__1_in_rule__DOUBLE__Group__08977);
            rule__DOUBLE__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DOUBLE__Group__0"


    // $ANTLR start "rule__DOUBLE__Group__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4389:1: rule__DOUBLE__Group__0__Impl : ( ( rule__DOUBLE__Alternatives_0 )? ) ;
    public final void rule__DOUBLE__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4393:1: ( ( ( rule__DOUBLE__Alternatives_0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4394:1: ( ( rule__DOUBLE__Alternatives_0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4394:1: ( ( rule__DOUBLE__Alternatives_0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4395:1: ( rule__DOUBLE__Alternatives_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDOUBLEAccess().getAlternatives_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4396:1: ( rule__DOUBLE__Alternatives_0 )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( ((LA49_0>=13 && LA49_0<=14)) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4396:2: rule__DOUBLE__Alternatives_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Alternatives_0_in_rule__DOUBLE__Group__0__Impl9004);
                    rule__DOUBLE__Alternatives_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDOUBLEAccess().getAlternatives_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DOUBLE__Group__0__Impl"


    // $ANTLR start "rule__DOUBLE__Group__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4406:1: rule__DOUBLE__Group__1 : rule__DOUBLE__Group__1__Impl rule__DOUBLE__Group__2 ;
    public final void rule__DOUBLE__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4410:1: ( rule__DOUBLE__Group__1__Impl rule__DOUBLE__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4411:2: rule__DOUBLE__Group__1__Impl rule__DOUBLE__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Group__1__Impl_in_rule__DOUBLE__Group__19035);
            rule__DOUBLE__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Group__2_in_rule__DOUBLE__Group__19038);
            rule__DOUBLE__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DOUBLE__Group__1"


    // $ANTLR start "rule__DOUBLE__Group__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4418:1: rule__DOUBLE__Group__1__Impl : ( RULE_NON_ZERO_INT ) ;
    public final void rule__DOUBLE__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4422:1: ( ( RULE_NON_ZERO_INT ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4423:1: ( RULE_NON_ZERO_INT )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4423:1: ( RULE_NON_ZERO_INT )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4424:1: RULE_NON_ZERO_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDOUBLEAccess().getNON_ZERO_INTTerminalRuleCall_1()); 
            }
            match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_rule__DOUBLE__Group__1__Impl9065); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDOUBLEAccess().getNON_ZERO_INTTerminalRuleCall_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DOUBLE__Group__1__Impl"


    // $ANTLR start "rule__DOUBLE__Group__2"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4435:1: rule__DOUBLE__Group__2 : rule__DOUBLE__Group__2__Impl rule__DOUBLE__Group__3 ;
    public final void rule__DOUBLE__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4439:1: ( rule__DOUBLE__Group__2__Impl rule__DOUBLE__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4440:2: rule__DOUBLE__Group__2__Impl rule__DOUBLE__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Group__2__Impl_in_rule__DOUBLE__Group__29094);
            rule__DOUBLE__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Group__3_in_rule__DOUBLE__Group__29097);
            rule__DOUBLE__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DOUBLE__Group__2"


    // $ANTLR start "rule__DOUBLE__Group__2__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4447:1: rule__DOUBLE__Group__2__Impl : ( ( rule__DOUBLE__Alternatives_2 )* ) ;
    public final void rule__DOUBLE__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4451:1: ( ( ( rule__DOUBLE__Alternatives_2 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4452:1: ( ( rule__DOUBLE__Alternatives_2 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4452:1: ( ( rule__DOUBLE__Alternatives_2 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4453:1: ( rule__DOUBLE__Alternatives_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDOUBLEAccess().getAlternatives_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4454:1: ( rule__DOUBLE__Alternatives_2 )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( ((LA50_0>=RULE_ZERO_INT && LA50_0<=RULE_NON_ZERO_INT)) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4454:2: rule__DOUBLE__Alternatives_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Alternatives_2_in_rule__DOUBLE__Group__2__Impl9124);
            	    rule__DOUBLE__Alternatives_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDOUBLEAccess().getAlternatives_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DOUBLE__Group__2__Impl"


    // $ANTLR start "rule__DOUBLE__Group__3"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4464:1: rule__DOUBLE__Group__3 : rule__DOUBLE__Group__3__Impl rule__DOUBLE__Group__4 ;
    public final void rule__DOUBLE__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4468:1: ( rule__DOUBLE__Group__3__Impl rule__DOUBLE__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4469:2: rule__DOUBLE__Group__3__Impl rule__DOUBLE__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Group__3__Impl_in_rule__DOUBLE__Group__39155);
            rule__DOUBLE__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Group__4_in_rule__DOUBLE__Group__39158);
            rule__DOUBLE__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DOUBLE__Group__3"


    // $ANTLR start "rule__DOUBLE__Group__3__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4476:1: rule__DOUBLE__Group__3__Impl : ( ( '.' ) ) ;
    public final void rule__DOUBLE__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4480:1: ( ( ( '.' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4481:1: ( ( '.' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4481:1: ( ( '.' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4482:1: ( '.' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDOUBLEAccess().getFullStopKeyword_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4483:1: ( '.' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4484:2: '.'
            {
            match(input,58,FollowSets000.FOLLOW_58_in_rule__DOUBLE__Group__3__Impl9187); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDOUBLEAccess().getFullStopKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DOUBLE__Group__3__Impl"


    // $ANTLR start "rule__DOUBLE__Group__4"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4495:1: rule__DOUBLE__Group__4 : rule__DOUBLE__Group__4__Impl ;
    public final void rule__DOUBLE__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4499:1: ( rule__DOUBLE__Group__4__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4500:2: rule__DOUBLE__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Group__4__Impl_in_rule__DOUBLE__Group__49219);
            rule__DOUBLE__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DOUBLE__Group__4"


    // $ANTLR start "rule__DOUBLE__Group__4__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4506:1: rule__DOUBLE__Group__4__Impl : ( ( ( rule__DOUBLE__Alternatives_4 ) ) ( ( rule__DOUBLE__Alternatives_4 )* ) ) ;
    public final void rule__DOUBLE__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4510:1: ( ( ( ( rule__DOUBLE__Alternatives_4 ) ) ( ( rule__DOUBLE__Alternatives_4 )* ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4511:1: ( ( ( rule__DOUBLE__Alternatives_4 ) ) ( ( rule__DOUBLE__Alternatives_4 )* ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4511:1: ( ( ( rule__DOUBLE__Alternatives_4 ) ) ( ( rule__DOUBLE__Alternatives_4 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4512:1: ( ( rule__DOUBLE__Alternatives_4 ) ) ( ( rule__DOUBLE__Alternatives_4 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4512:1: ( ( rule__DOUBLE__Alternatives_4 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4513:1: ( rule__DOUBLE__Alternatives_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDOUBLEAccess().getAlternatives_4()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4514:1: ( rule__DOUBLE__Alternatives_4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4514:2: rule__DOUBLE__Alternatives_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Alternatives_4_in_rule__DOUBLE__Group__4__Impl9248);
            rule__DOUBLE__Alternatives_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDOUBLEAccess().getAlternatives_4()); 
            }

            }

            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4517:1: ( ( rule__DOUBLE__Alternatives_4 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4518:1: ( rule__DOUBLE__Alternatives_4 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDOUBLEAccess().getAlternatives_4()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4519:1: ( rule__DOUBLE__Alternatives_4 )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( ((LA51_0>=RULE_ZERO_INT && LA51_0<=RULE_NON_ZERO_INT)) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4519:2: rule__DOUBLE__Alternatives_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Alternatives_4_in_rule__DOUBLE__Group__4__Impl9260);
            	    rule__DOUBLE__Alternatives_4();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDOUBLEAccess().getAlternatives_4()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DOUBLE__Group__4__Impl"


    // $ANTLR start "rule__OilFile__ImplementationAssignment_0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4541:1: rule__OilFile__ImplementationAssignment_0 : ( ruleOilImplementation ) ;
    public final void rule__OilFile__ImplementationAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4545:1: ( ( ruleOilImplementation ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4546:1: ( ruleOilImplementation )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4546:1: ( ruleOilImplementation )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4547:1: ruleOilImplementation
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getImplementationOilImplementationParserRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOilImplementation_in_rule__OilFile__ImplementationAssignment_09308);
            ruleOilImplementation();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilFileAccess().getImplementationOilImplementationParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilFile__ImplementationAssignment_0"


    // $ANTLR start "rule__OilFile__ApplicationAssignment_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4556:1: rule__OilFile__ApplicationAssignment_1 : ( ruleOilApplication ) ;
    public final void rule__OilFile__ApplicationAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4560:1: ( ( ruleOilApplication ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4561:1: ( ruleOilApplication )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4561:1: ( ruleOilApplication )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4562:1: ruleOilApplication
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getApplicationOilApplicationParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOilApplication_in_rule__OilFile__ApplicationAssignment_19339);
            ruleOilApplication();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilFileAccess().getApplicationOilApplicationParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilFile__ApplicationAssignment_1"


    // $ANTLR start "rule__OilImplementation__NameAssignment_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4571:1: rule__OilImplementation__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__OilImplementation__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4575:1: ( ( RULE_ID ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4576:1: ( RULE_ID )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4576:1: ( RULE_ID )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4577:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__OilImplementation__NameAssignment_19370); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilImplementationAccess().getNameIDTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilImplementation__NameAssignment_1"


    // $ANTLR start "rule__OilImplementation__OilObjectsAssignment_3"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4586:1: rule__OilImplementation__OilObjectsAssignment_3 : ( ruleOilObjectImpl ) ;
    public final void rule__OilImplementation__OilObjectsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4590:1: ( ( ruleOilObjectImpl ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4591:1: ( ruleOilObjectImpl )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4591:1: ( ruleOilObjectImpl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4592:1: ruleOilObjectImpl
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getOilObjectsOilObjectImplParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOilObjectImpl_in_rule__OilImplementation__OilObjectsAssignment_39401);
            ruleOilObjectImpl();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilImplementationAccess().getOilObjectsOilObjectImplParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilImplementation__OilObjectsAssignment_3"


    // $ANTLR start "rule__OilObjectImpl__TypeAssignment_0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4601:1: rule__OilObjectImpl__TypeAssignment_0 : ( ruleObjectType ) ;
    public final void rule__OilObjectImpl__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4605:1: ( ( ruleObjectType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4606:1: ( ruleObjectType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4606:1: ( ruleObjectType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4607:1: ruleObjectType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getTypeObjectTypeEnumRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleObjectType_in_rule__OilObjectImpl__TypeAssignment_09432);
            ruleObjectType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectImplAccess().getTypeObjectTypeEnumRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObjectImpl__TypeAssignment_0"


    // $ANTLR start "rule__OilObjectImpl__ParametersAssignment_2"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4616:1: rule__OilObjectImpl__ParametersAssignment_2 : ( ruleParameterType ) ;
    public final void rule__OilObjectImpl__ParametersAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4620:1: ( ( ruleParameterType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4621:1: ( ruleParameterType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4621:1: ( ruleParameterType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4622:1: ruleParameterType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getParametersParameterTypeParserRuleCall_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameterType_in_rule__OilObjectImpl__ParametersAssignment_29463);
            ruleParameterType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectImplAccess().getParametersParameterTypeParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObjectImpl__ParametersAssignment_2"


    // $ANTLR start "rule__OilObjectImpl__DescriptionAssignment_4_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4631:1: rule__OilObjectImpl__DescriptionAssignment_4_1 : ( RULE_STRING ) ;
    public final void rule__OilObjectImpl__DescriptionAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4635:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4636:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4636:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4637:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getDescriptionSTRINGTerminalRuleCall_4_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__OilObjectImpl__DescriptionAssignment_4_19494); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectImplAccess().getDescriptionSTRINGTerminalRuleCall_4_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObjectImpl__DescriptionAssignment_4_1"


    // $ANTLR start "rule__OilApplication__NameAssignment_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4646:1: rule__OilApplication__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__OilApplication__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4650:1: ( ( RULE_ID ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4651:1: ( RULE_ID )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4651:1: ( RULE_ID )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4652:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__OilApplication__NameAssignment_19525); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilApplicationAccess().getNameIDTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilApplication__NameAssignment_1"


    // $ANTLR start "rule__OilApplication__OilObjectsAssignment_3"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4661:1: rule__OilApplication__OilObjectsAssignment_3 : ( ruleOilObject ) ;
    public final void rule__OilApplication__OilObjectsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4665:1: ( ( ruleOilObject ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4666:1: ( ruleOilObject )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4666:1: ( ruleOilObject )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4667:1: ruleOilObject
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getOilObjectsOilObjectParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOilObject_in_rule__OilApplication__OilObjectsAssignment_39556);
            ruleOilObject();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilApplicationAccess().getOilObjectsOilObjectParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilApplication__OilObjectsAssignment_3"


    // $ANTLR start "rule__OilApplication__DescriptionAssignment_5_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4676:1: rule__OilApplication__DescriptionAssignment_5_1 : ( RULE_STRING ) ;
    public final void rule__OilApplication__DescriptionAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4680:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4681:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4681:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4682:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getDescriptionSTRINGTerminalRuleCall_5_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__OilApplication__DescriptionAssignment_5_19587); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilApplicationAccess().getDescriptionSTRINGTerminalRuleCall_5_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilApplication__DescriptionAssignment_5_1"


    // $ANTLR start "rule__ValueType__TypeAssignment_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4691:1: rule__ValueType__TypeAssignment_1 : ( ruleVType ) ;
    public final void rule__ValueType__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4695:1: ( ( ruleVType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4696:1: ( ruleVType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4696:1: ( ruleVType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4697:1: ruleVType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getTypeVTypeEnumRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVType_in_rule__ValueType__TypeAssignment_19618);
            ruleVType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getTypeVTypeEnumRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__TypeAssignment_1"


    // $ANTLR start "rule__ValueType__WithAutoAssignment_2"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4706:1: rule__ValueType__WithAutoAssignment_2 : ( ( 'WITH_AUTO' ) ) ;
    public final void rule__ValueType__WithAutoAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4710:1: ( ( ( 'WITH_AUTO' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4711:1: ( ( 'WITH_AUTO' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4711:1: ( ( 'WITH_AUTO' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4712:1: ( 'WITH_AUTO' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getWithAutoWITH_AUTOKeyword_2_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4713:1: ( 'WITH_AUTO' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4714:1: 'WITH_AUTO'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getWithAutoWITH_AUTOKeyword_2_0()); 
            }
            match(input,59,FollowSets000.FOLLOW_59_in_rule__ValueType__WithAutoAssignment_29654); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getWithAutoWITH_AUTOKeyword_2_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getWithAutoWITH_AUTOKeyword_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__WithAutoAssignment_2"


    // $ANTLR start "rule__ValueType__NameAssignment_3"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4729:1: rule__ValueType__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__ValueType__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4733:1: ( ( RULE_ID ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4734:1: ( RULE_ID )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4734:1: ( RULE_ID )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4735:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getNameIDTerminalRuleCall_3_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ValueType__NameAssignment_39693); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getNameIDTerminalRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__NameAssignment_3"


    // $ANTLR start "rule__ValueType__MultiValueAssignment_4"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4744:1: rule__ValueType__MultiValueAssignment_4 : ( ( '[]' ) ) ;
    public final void rule__ValueType__MultiValueAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4748:1: ( ( ( '[]' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4749:1: ( ( '[]' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4749:1: ( ( '[]' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4750:1: ( '[]' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_4_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4751:1: ( '[]' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4752:1: '[]'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_4_0()); 
            }
            match(input,60,FollowSets000.FOLLOW_60_in_rule__ValueType__MultiValueAssignment_49729); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_4_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__MultiValueAssignment_4"


    // $ANTLR start "rule__ValueType__DefaultAutoAssignment_5_1_0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4767:1: rule__ValueType__DefaultAutoAssignment_5_1_0 : ( ( 'AUTO' ) ) ;
    public final void rule__ValueType__DefaultAutoAssignment_5_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4771:1: ( ( ( 'AUTO' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4772:1: ( ( 'AUTO' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4772:1: ( ( 'AUTO' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4773:1: ( 'AUTO' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getDefaultAutoAUTOKeyword_5_1_0_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4774:1: ( 'AUTO' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4775:1: 'AUTO'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getDefaultAutoAUTOKeyword_5_1_0_0()); 
            }
            match(input,61,FollowSets000.FOLLOW_61_in_rule__ValueType__DefaultAutoAssignment_5_1_09773); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getDefaultAutoAUTOKeyword_5_1_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getDefaultAutoAUTOKeyword_5_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__DefaultAutoAssignment_5_1_0"


    // $ANTLR start "rule__ValueType__DefaultValueAssignment_5_1_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4790:1: rule__ValueType__DefaultValueAssignment_5_1_1 : ( ( rule__ValueType__DefaultValueAlternatives_5_1_1_0 ) ) ;
    public final void rule__ValueType__DefaultValueAssignment_5_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4794:1: ( ( ( rule__ValueType__DefaultValueAlternatives_5_1_1_0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4795:1: ( ( rule__ValueType__DefaultValueAlternatives_5_1_1_0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4795:1: ( ( rule__ValueType__DefaultValueAlternatives_5_1_1_0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4796:1: ( rule__ValueType__DefaultValueAlternatives_5_1_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getDefaultValueAlternatives_5_1_1_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4797:1: ( rule__ValueType__DefaultValueAlternatives_5_1_1_0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4797:2: rule__ValueType__DefaultValueAlternatives_5_1_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__DefaultValueAlternatives_5_1_1_0_in_rule__ValueType__DefaultValueAssignment_5_1_19812);
            rule__ValueType__DefaultValueAlternatives_5_1_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getDefaultValueAlternatives_5_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__DefaultValueAssignment_5_1_1"


    // $ANTLR start "rule__ValueType__DescriptionAssignment_6_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4806:1: rule__ValueType__DescriptionAssignment_6_1 : ( RULE_STRING ) ;
    public final void rule__ValueType__DescriptionAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4810:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4811:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4811:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4812:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getDescriptionSTRINGTerminalRuleCall_6_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__ValueType__DescriptionAssignment_6_19845); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getDescriptionSTRINGTerminalRuleCall_6_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__DescriptionAssignment_6_1"


    // $ANTLR start "rule__VariantType__TypeAssignment_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4821:1: rule__VariantType__TypeAssignment_1 : ( ruleEType ) ;
    public final void rule__VariantType__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4825:1: ( ( ruleEType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4826:1: ( ruleEType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4826:1: ( ruleEType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4827:1: ruleEType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getTypeETypeEnumRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEType_in_rule__VariantType__TypeAssignment_19876);
            ruleEType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getTypeETypeEnumRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__TypeAssignment_1"


    // $ANTLR start "rule__VariantType__WithAutoAssignment_2"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4836:1: rule__VariantType__WithAutoAssignment_2 : ( ( 'WITH_AUTO' ) ) ;
    public final void rule__VariantType__WithAutoAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4840:1: ( ( ( 'WITH_AUTO' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4841:1: ( ( 'WITH_AUTO' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4841:1: ( ( 'WITH_AUTO' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4842:1: ( 'WITH_AUTO' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getWithAutoWITH_AUTOKeyword_2_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4843:1: ( 'WITH_AUTO' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4844:1: 'WITH_AUTO'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getWithAutoWITH_AUTOKeyword_2_0()); 
            }
            match(input,59,FollowSets000.FOLLOW_59_in_rule__VariantType__WithAutoAssignment_29912); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getWithAutoWITH_AUTOKeyword_2_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getWithAutoWITH_AUTOKeyword_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__WithAutoAssignment_2"


    // $ANTLR start "rule__VariantType__NameAssignment_3"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4859:1: rule__VariantType__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__VariantType__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4863:1: ( ( RULE_ID ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4864:1: ( RULE_ID )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4864:1: ( RULE_ID )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4865:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getNameIDTerminalRuleCall_3_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__VariantType__NameAssignment_39951); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getNameIDTerminalRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__NameAssignment_3"


    // $ANTLR start "rule__VariantType__MultiValueAssignment_4"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4874:1: rule__VariantType__MultiValueAssignment_4 : ( ( '[]' ) ) ;
    public final void rule__VariantType__MultiValueAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4878:1: ( ( ( '[]' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4879:1: ( ( '[]' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4879:1: ( ( '[]' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4880:1: ( '[]' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_4_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4881:1: ( '[]' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4882:1: '[]'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_4_0()); 
            }
            match(input,60,FollowSets000.FOLLOW_60_in_rule__VariantType__MultiValueAssignment_49987); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_4_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__MultiValueAssignment_4"


    // $ANTLR start "rule__VariantType__ValuesAssignment_5_1_0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4897:1: rule__VariantType__ValuesAssignment_5_1_0 : ( ruleEnumeratorType ) ;
    public final void rule__VariantType__ValuesAssignment_5_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4901:1: ( ( ruleEnumeratorType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4902:1: ( ruleEnumeratorType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4902:1: ( ruleEnumeratorType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4903:1: ruleEnumeratorType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getValuesEnumeratorTypeParserRuleCall_5_1_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEnumeratorType_in_rule__VariantType__ValuesAssignment_5_1_010026);
            ruleEnumeratorType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getValuesEnumeratorTypeParserRuleCall_5_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__ValuesAssignment_5_1_0"


    // $ANTLR start "rule__VariantType__ValuesAssignment_5_1_1_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4912:1: rule__VariantType__ValuesAssignment_5_1_1_1 : ( ruleEnumeratorType ) ;
    public final void rule__VariantType__ValuesAssignment_5_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4916:1: ( ( ruleEnumeratorType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4917:1: ( ruleEnumeratorType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4917:1: ( ruleEnumeratorType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4918:1: ruleEnumeratorType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getValuesEnumeratorTypeParserRuleCall_5_1_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEnumeratorType_in_rule__VariantType__ValuesAssignment_5_1_1_110057);
            ruleEnumeratorType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getValuesEnumeratorTypeParserRuleCall_5_1_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__ValuesAssignment_5_1_1_1"


    // $ANTLR start "rule__VariantType__DefaultAutoAssignment_6_1_0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4927:1: rule__VariantType__DefaultAutoAssignment_6_1_0 : ( ( 'AUTO' ) ) ;
    public final void rule__VariantType__DefaultAutoAssignment_6_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4931:1: ( ( ( 'AUTO' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4932:1: ( ( 'AUTO' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4932:1: ( ( 'AUTO' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4933:1: ( 'AUTO' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getDefaultAutoAUTOKeyword_6_1_0_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4934:1: ( 'AUTO' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4935:1: 'AUTO'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getDefaultAutoAUTOKeyword_6_1_0_0()); 
            }
            match(input,61,FollowSets000.FOLLOW_61_in_rule__VariantType__DefaultAutoAssignment_6_1_010093); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getDefaultAutoAUTOKeyword_6_1_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getDefaultAutoAUTOKeyword_6_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__DefaultAutoAssignment_6_1_0"


    // $ANTLR start "rule__VariantType__DefaultValueAssignment_6_1_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4950:1: rule__VariantType__DefaultValueAssignment_6_1_1 : ( RULE_ID ) ;
    public final void rule__VariantType__DefaultValueAssignment_6_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4954:1: ( ( RULE_ID ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4955:1: ( RULE_ID )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4955:1: ( RULE_ID )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4956:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getDefaultValueIDTerminalRuleCall_6_1_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__VariantType__DefaultValueAssignment_6_1_110132); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getDefaultValueIDTerminalRuleCall_6_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__DefaultValueAssignment_6_1_1"


    // $ANTLR start "rule__VariantType__DescriptionAssignment_7_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4965:1: rule__VariantType__DescriptionAssignment_7_1 : ( RULE_STRING ) ;
    public final void rule__VariantType__DescriptionAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4969:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4970:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4970:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4971:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getDescriptionSTRINGTerminalRuleCall_7_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__VariantType__DescriptionAssignment_7_110163); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getDescriptionSTRINGTerminalRuleCall_7_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariantType__DescriptionAssignment_7_1"


    // $ANTLR start "rule__EnumeratorType__NameAssignment_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4980:1: rule__EnumeratorType__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__EnumeratorType__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4984:1: ( ( RULE_ID ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4985:1: ( RULE_ID )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4985:1: ( RULE_ID )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4986:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EnumeratorType__NameAssignment_110194); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumeratorTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumeratorType__NameAssignment_1"


    // $ANTLR start "rule__EnumeratorType__ParametersAssignment_2_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4995:1: rule__EnumeratorType__ParametersAssignment_2_1 : ( ruleParameterType ) ;
    public final void rule__EnumeratorType__ParametersAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4999:1: ( ( ruleParameterType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5000:1: ( ruleParameterType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5000:1: ( ruleParameterType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5001:1: ruleParameterType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getParametersParameterTypeParserRuleCall_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameterType_in_rule__EnumeratorType__ParametersAssignment_2_110225);
            ruleParameterType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumeratorTypeAccess().getParametersParameterTypeParserRuleCall_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumeratorType__ParametersAssignment_2_1"


    // $ANTLR start "rule__EnumeratorType__DescriptionAssignment_3_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5010:1: rule__EnumeratorType__DescriptionAssignment_3_1 : ( RULE_STRING ) ;
    public final void rule__EnumeratorType__DescriptionAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5014:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5015:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5015:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5016:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getDescriptionSTRINGTerminalRuleCall_3_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__EnumeratorType__DescriptionAssignment_3_110256); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumeratorTypeAccess().getDescriptionSTRINGTerminalRuleCall_3_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumeratorType__DescriptionAssignment_3_1"


    // $ANTLR start "rule__ReferenceType__TypeAssignment_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5025:1: rule__ReferenceType__TypeAssignment_1 : ( ruleObjectTypeRef ) ;
    public final void rule__ReferenceType__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5029:1: ( ( ruleObjectTypeRef ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5030:1: ( ruleObjectTypeRef )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5030:1: ( ruleObjectTypeRef )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5031:1: ruleObjectTypeRef
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getTypeObjectTypeRefEnumRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleObjectTypeRef_in_rule__ReferenceType__TypeAssignment_110287);
            ruleObjectTypeRef();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getTypeObjectTypeRefEnumRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__TypeAssignment_1"


    // $ANTLR start "rule__ReferenceType__WithAutoAssignment_2"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5040:1: rule__ReferenceType__WithAutoAssignment_2 : ( ( 'WITH_AUTO' ) ) ;
    public final void rule__ReferenceType__WithAutoAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5044:1: ( ( ( 'WITH_AUTO' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5045:1: ( ( 'WITH_AUTO' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5045:1: ( ( 'WITH_AUTO' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5046:1: ( 'WITH_AUTO' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getWithAutoWITH_AUTOKeyword_2_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5047:1: ( 'WITH_AUTO' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5048:1: 'WITH_AUTO'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getWithAutoWITH_AUTOKeyword_2_0()); 
            }
            match(input,59,FollowSets000.FOLLOW_59_in_rule__ReferenceType__WithAutoAssignment_210323); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getWithAutoWITH_AUTOKeyword_2_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getWithAutoWITH_AUTOKeyword_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__WithAutoAssignment_2"


    // $ANTLR start "rule__ReferenceType__NameAssignment_3"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5063:1: rule__ReferenceType__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__ReferenceType__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5067:1: ( ( RULE_ID ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5068:1: ( RULE_ID )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5068:1: ( RULE_ID )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5069:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getNameIDTerminalRuleCall_3_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ReferenceType__NameAssignment_310362); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getNameIDTerminalRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__NameAssignment_3"


    // $ANTLR start "rule__ReferenceType__MultiValueAssignment_4"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5078:1: rule__ReferenceType__MultiValueAssignment_4 : ( ( '[]' ) ) ;
    public final void rule__ReferenceType__MultiValueAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5082:1: ( ( ( '[]' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5083:1: ( ( '[]' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5083:1: ( ( '[]' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5084:1: ( '[]' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_4_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5085:1: ( '[]' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5086:1: '[]'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_4_0()); 
            }
            match(input,60,FollowSets000.FOLLOW_60_in_rule__ReferenceType__MultiValueAssignment_410398); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_4_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__MultiValueAssignment_4"


    // $ANTLR start "rule__ReferenceType__DefaultAutoAssignment_5_1_0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5101:1: rule__ReferenceType__DefaultAutoAssignment_5_1_0 : ( ( 'AUTO' ) ) ;
    public final void rule__ReferenceType__DefaultAutoAssignment_5_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5105:1: ( ( ( 'AUTO' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5106:1: ( ( 'AUTO' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5106:1: ( ( 'AUTO' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5107:1: ( 'AUTO' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getDefaultAutoAUTOKeyword_5_1_0_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5108:1: ( 'AUTO' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5109:1: 'AUTO'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getDefaultAutoAUTOKeyword_5_1_0_0()); 
            }
            match(input,61,FollowSets000.FOLLOW_61_in_rule__ReferenceType__DefaultAutoAssignment_5_1_010442); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getDefaultAutoAUTOKeyword_5_1_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getDefaultAutoAUTOKeyword_5_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__DefaultAutoAssignment_5_1_0"


    // $ANTLR start "rule__ReferenceType__DefaultValueAssignment_5_1_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5124:1: rule__ReferenceType__DefaultValueAssignment_5_1_1 : ( RULE_ID ) ;
    public final void rule__ReferenceType__DefaultValueAssignment_5_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5128:1: ( ( RULE_ID ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5129:1: ( RULE_ID )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5129:1: ( RULE_ID )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5130:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getDefaultValueIDTerminalRuleCall_5_1_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ReferenceType__DefaultValueAssignment_5_1_110481); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getDefaultValueIDTerminalRuleCall_5_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__DefaultValueAssignment_5_1_1"


    // $ANTLR start "rule__ReferenceType__DescriptionAssignment_6_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5139:1: rule__ReferenceType__DescriptionAssignment_6_1 : ( RULE_STRING ) ;
    public final void rule__ReferenceType__DescriptionAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5143:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5144:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5144:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5145:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getDescriptionSTRINGTerminalRuleCall_6_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__ReferenceType__DescriptionAssignment_6_110512); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getDescriptionSTRINGTerminalRuleCall_6_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__DescriptionAssignment_6_1"


    // $ANTLR start "rule__OilObject__TypeAssignment_0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5154:1: rule__OilObject__TypeAssignment_0 : ( ruleObjectType ) ;
    public final void rule__OilObject__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5158:1: ( ( ruleObjectType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5159:1: ( ruleObjectType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5159:1: ( ruleObjectType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5160:1: ruleObjectType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getTypeObjectTypeEnumRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleObjectType_in_rule__OilObject__TypeAssignment_010543);
            ruleObjectType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectAccess().getTypeObjectTypeEnumRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObject__TypeAssignment_0"


    // $ANTLR start "rule__OilObject__NameAssignment_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5169:1: rule__OilObject__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__OilObject__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5173:1: ( ( RULE_ID ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5174:1: ( RULE_ID )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5174:1: ( RULE_ID )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5175:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__OilObject__NameAssignment_110574); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectAccess().getNameIDTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObject__NameAssignment_1"


    // $ANTLR start "rule__OilObject__ParametersAssignment_3"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5184:1: rule__OilObject__ParametersAssignment_3 : ( ruleParameter ) ;
    public final void rule__OilObject__ParametersAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5188:1: ( ( ruleParameter ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5189:1: ( ruleParameter )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5189:1: ( ruleParameter )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5190:1: ruleParameter
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getParametersParameterParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_rule__OilObject__ParametersAssignment_310605);
            ruleParameter();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectAccess().getParametersParameterParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObject__ParametersAssignment_3"


    // $ANTLR start "rule__OilObject__DescriptionAssignment_5_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5199:1: rule__OilObject__DescriptionAssignment_5_1 : ( RULE_STRING ) ;
    public final void rule__OilObject__DescriptionAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5203:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5204:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5204:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5205:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getDescriptionSTRINGTerminalRuleCall_5_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__OilObject__DescriptionAssignment_5_110636); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectAccess().getDescriptionSTRINGTerminalRuleCall_5_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObject__DescriptionAssignment_5_1"


    // $ANTLR start "rule__Parameter__TypeAssignment_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5214:1: rule__Parameter__TypeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Parameter__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5218:1: ( ( ( RULE_ID ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5219:1: ( ( RULE_ID ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5219:1: ( ( RULE_ID ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5220:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getTypeParameterTypeCrossReference_1_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5221:1: ( RULE_ID )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5222:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getTypeParameterTypeIDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Parameter__TypeAssignment_110671); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getTypeParameterTypeIDTerminalRuleCall_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getTypeParameterTypeCrossReference_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__TypeAssignment_1"


    // $ANTLR start "rule__Parameter__AutoAssignment_3_0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5233:1: rule__Parameter__AutoAssignment_3_0 : ( ( 'AUTO' ) ) ;
    public final void rule__Parameter__AutoAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5237:1: ( ( ( 'AUTO' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5238:1: ( ( 'AUTO' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5238:1: ( ( 'AUTO' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5239:1: ( 'AUTO' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getAutoAUTOKeyword_3_0_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5240:1: ( 'AUTO' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5241:1: 'AUTO'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getAutoAUTOKeyword_3_0_0()); 
            }
            match(input,61,FollowSets000.FOLLOW_61_in_rule__Parameter__AutoAssignment_3_010711); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getAutoAUTOKeyword_3_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getAutoAUTOKeyword_3_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__AutoAssignment_3_0"


    // $ANTLR start "rule__Parameter__ValueAssignment_3_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5256:1: rule__Parameter__ValueAssignment_3_1 : ( ruleGenericValue ) ;
    public final void rule__Parameter__ValueAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5260:1: ( ( ruleGenericValue ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5261:1: ( ruleGenericValue )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5261:1: ( ruleGenericValue )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5262:1: ruleGenericValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getValueGenericValueParserRuleCall_3_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleGenericValue_in_rule__Parameter__ValueAssignment_3_110750);
            ruleGenericValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getValueGenericValueParserRuleCall_3_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__ValueAssignment_3_1"


    // $ANTLR start "rule__Parameter__ValueRefAssignment_3_2"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5271:1: rule__Parameter__ValueRefAssignment_3_2 : ( ( RULE_ID ) ) ;
    public final void rule__Parameter__ValueRefAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5275:1: ( ( ( RULE_ID ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5276:1: ( ( RULE_ID ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5276:1: ( ( RULE_ID ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5277:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getValueRefParameterRefCrossReference_3_2_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5278:1: ( RULE_ID )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5279:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getValueRefParameterRefIDTerminalRuleCall_3_2_0_1()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Parameter__ValueRefAssignment_3_210785); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getValueRefParameterRefIDTerminalRuleCall_3_2_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getValueRefParameterRefCrossReference_3_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__ValueRefAssignment_3_2"


    // $ANTLR start "rule__Parameter__ParametersAssignment_4_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5290:1: rule__Parameter__ParametersAssignment_4_1 : ( ruleParameter ) ;
    public final void rule__Parameter__ParametersAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5294:1: ( ( ruleParameter ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5295:1: ( ruleParameter )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5295:1: ( ruleParameter )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5296:1: ruleParameter
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getParametersParameterParserRuleCall_4_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_rule__Parameter__ParametersAssignment_4_110820);
            ruleParameter();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getParametersParameterParserRuleCall_4_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__ParametersAssignment_4_1"


    // $ANTLR start "rule__Parameter__DescriptionAssignment_5_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5305:1: rule__Parameter__DescriptionAssignment_5_1 : ( RULE_STRING ) ;
    public final void rule__Parameter__DescriptionAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5309:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5310:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5310:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5311:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getDescriptionSTRINGTerminalRuleCall_5_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Parameter__DescriptionAssignment_5_110851); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getDescriptionSTRINGTerminalRuleCall_5_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__DescriptionAssignment_5_1"

    // Delegated rules


    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA7_eotS =
        "\11\uffff";
    static final String DFA7_eofS =
        "\4\uffff\1\5\1\uffff\2\5\1\uffff";
    static final String DFA7_minS =
        "\1\5\1\uffff\2\6\1\7\1\uffff\2\7\1\uffff";
    static final String DFA7_maxS =
        "\1\16\1\uffff\2\10\1\72\1\uffff\2\72\1\uffff";
    static final String DFA7_acceptS =
        "\1\uffff\1\1\3\uffff\1\2\2\uffff\1\3";
    static final String DFA7_specialS =
        "\11\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\1\1\5\1\uffff\1\4\4\uffff\1\2\1\3",
            "",
            "\1\5\1\uffff\1\4",
            "\1\5\1\uffff\1\4",
            "\1\6\1\7\52\uffff\1\5\1\uffff\2\5\3\uffff\1\10",
            "",
            "\1\6\1\7\52\uffff\1\5\1\uffff\2\5\3\uffff\1\10",
            "\1\6\1\7\52\uffff\1\5\1\uffff\2\5\3\uffff\1\10",
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "673:1: rule__GenericValue__Alternatives : ( ( RULE_STRING ) | ( ruleINT ) | ( ruleDOUBLE ) );";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleOilFile_in_entryRuleOilFile67 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOilFile74 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group__0_in_ruleOilFile100 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilImplementation_in_entryRuleOilImplementation127 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOilImplementation134 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__0_in_ruleOilImplementation160 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilObjectImpl_in_entryRuleOilObjectImpl187 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOilObjectImpl194 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__0_in_ruleOilObjectImpl220 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilApplication_in_entryRuleOilApplication247 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOilApplication254 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__0_in_ruleOilApplication280 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameterType_in_entryRuleParameterType307 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParameterType314 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ParameterType__Alternatives_in_ruleParameterType340 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueType_in_entryRuleValueType367 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleValueType374 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__0_in_ruleValueType400 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariantType_in_entryRuleVariantType427 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVariantType434 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__0_in_ruleVariantType460 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumeratorType_in_entryRuleEnumeratorType487 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumeratorType494 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group__0_in_ruleEnumeratorType520 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceType_in_entryRuleReferenceType547 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceType554 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__0_in_ruleReferenceType580 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilObject_in_entryRuleOilObject607 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOilObject614 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group__0_in_ruleOilObject640 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter667 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParameter674 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__0_in_ruleParameter700 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGenericValue_in_entryRuleGenericValue727 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGenericValue734 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GenericValue__Alternatives_in_ruleGenericValue760 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleINT_in_entryRuleINT787 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleINT794 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Group__0_in_ruleINT820 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDOUBLE_in_entryRuleDOUBLE847 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDOUBLE854 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DOUBLE__Group__0_in_ruleDOUBLE880 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VType__Alternatives_in_ruleVType917 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EType__Alternatives_in_ruleEType953 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ObjectType__Alternatives_in_ruleObjectType989 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ObjectTypeRef__Alternatives_in_ruleObjectTypeRef1025 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueType_in_rule__ParameterType__Alternatives1060 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariantType_in_rule__ParameterType__Alternatives1077 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceType_in_rule__ParameterType__Alternatives1094 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__DefaultAutoAssignment_5_1_0_in_rule__ValueType__Alternatives_5_11126 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__DefaultValueAssignment_5_1_1_in_rule__ValueType__Alternatives_5_11144 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGenericValue_in_rule__ValueType__DefaultValueAlternatives_5_1_1_01177 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ValueType__DefaultValueAlternatives_5_1_1_01194 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__DefaultAutoAssignment_6_1_0_in_rule__VariantType__Alternatives_6_11226 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__DefaultValueAssignment_6_1_1_in_rule__VariantType__Alternatives_6_11244 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__DefaultAutoAssignment_5_1_0_in_rule__ReferenceType__Alternatives_5_11277 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__DefaultValueAssignment_5_1_1_in_rule__ReferenceType__Alternatives_5_11295 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__AutoAssignment_3_0_in_rule__Parameter__Alternatives_31328 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__ValueAssignment_3_1_in_rule__Parameter__Alternatives_31346 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__ValueRefAssignment_3_2_in_rule__Parameter__Alternatives_31364 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__GenericValue__Alternatives1397 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleINT_in_rule__GenericValue__Alternatives1414 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDOUBLE_in_rule__GenericValue__Alternatives1431 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__INT__Alternatives_01464 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__INT__Alternatives_01484 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Group_1_0__0_in_rule__INT__Alternatives_11518 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_HEX_in_rule__INT__Alternatives_11536 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_rule__INT__Alternatives_1_0_11568 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_rule__INT__Alternatives_1_0_11585 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__DOUBLE__Alternatives_01618 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__DOUBLE__Alternatives_01638 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_rule__DOUBLE__Alternatives_21672 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_rule__DOUBLE__Alternatives_21689 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_rule__DOUBLE__Alternatives_41721 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_rule__DOUBLE__Alternatives_41738 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__VType__Alternatives1771 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__VType__Alternatives1792 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__VType__Alternatives1813 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__VType__Alternatives1834 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__VType__Alternatives1855 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__VType__Alternatives1876 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__VType__Alternatives1897 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__EType__Alternatives1933 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__EType__Alternatives1954 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__ObjectType__Alternatives1990 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__ObjectType__Alternatives2011 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__ObjectType__Alternatives2032 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__ObjectType__Alternatives2053 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__ObjectType__Alternatives2074 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__ObjectType__Alternatives2095 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__ObjectType__Alternatives2116 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__ObjectType__Alternatives2137 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__ObjectType__Alternatives2158 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__ObjectType__Alternatives2179 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__ObjectType__Alternatives2200 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__ObjectType__Alternatives2221 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_rule__ObjectType__Alternatives2242 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_rule__ObjectTypeRef__Alternatives2278 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_rule__ObjectTypeRef__Alternatives2299 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_rule__ObjectTypeRef__Alternatives2320 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_rule__ObjectTypeRef__Alternatives2341 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_rule__ObjectTypeRef__Alternatives2362 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_rule__ObjectTypeRef__Alternatives2383 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_rule__ObjectTypeRef__Alternatives2404 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_rule__ObjectTypeRef__Alternatives2425 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_rule__ObjectTypeRef__Alternatives2446 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_rule__ObjectTypeRef__Alternatives2467 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_rule__ObjectTypeRef__Alternatives2488 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_rule__ObjectTypeRef__Alternatives2509 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_rule__ObjectTypeRef__Alternatives2530 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group__0__Impl_in_rule__OilFile__Group__02563 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_rule__OilFile__Group__1_in_rule__OilFile__Group__02566 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__ImplementationAssignment_0_in_rule__OilFile__Group__0__Impl2593 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group__1__Impl_in_rule__OilFile__Group__12624 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__ApplicationAssignment_1_in_rule__OilFile__Group__1__Impl2651 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__0__Impl_in_rule__OilImplementation__Group__02685 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__1_in_rule__OilImplementation__Group__02688 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_rule__OilImplementation__Group__0__Impl2716 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__1__Impl_in_rule__OilImplementation__Group__12747 = new BitSet(new long[]{0x0008000000000000L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__2_in_rule__OilImplementation__Group__12750 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilImplementation__NameAssignment_1_in_rule__OilImplementation__Group__1__Impl2777 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__2__Impl_in_rule__OilImplementation__Group__22807 = new BitSet(new long[]{0x0010001FFF000000L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__3_in_rule__OilImplementation__Group__22810 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_rule__OilImplementation__Group__2__Impl2838 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__3__Impl_in_rule__OilImplementation__Group__32869 = new BitSet(new long[]{0x0010001FFF000000L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__4_in_rule__OilImplementation__Group__32872 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilImplementation__OilObjectsAssignment_3_in_rule__OilImplementation__Group__3__Impl2899 = new BitSet(new long[]{0x0000001FFF000002L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__4__Impl_in_rule__OilImplementation__Group__42930 = new BitSet(new long[]{0x0020000000000000L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__5_in_rule__OilImplementation__Group__42933 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_rule__OilImplementation__Group__4__Impl2961 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__5__Impl_in_rule__OilImplementation__Group__52992 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_rule__OilImplementation__Group__5__Impl3020 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__0__Impl_in_rule__OilObjectImpl__Group__03063 = new BitSet(new long[]{0x0008000000000000L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__1_in_rule__OilObjectImpl__Group__03066 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__TypeAssignment_0_in_rule__OilObjectImpl__Group__0__Impl3093 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__1__Impl_in_rule__OilObjectImpl__Group__13123 = new BitSet(new long[]{0x0013FFE000FF8000L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__2_in_rule__OilObjectImpl__Group__13126 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_rule__OilObjectImpl__Group__1__Impl3154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__2__Impl_in_rule__OilObjectImpl__Group__23185 = new BitSet(new long[]{0x0013FFE000FF8000L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__3_in_rule__OilObjectImpl__Group__23188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__ParametersAssignment_2_in_rule__OilObjectImpl__Group__2__Impl3215 = new BitSet(new long[]{0x0003FFE000FF8002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__3__Impl_in_rule__OilObjectImpl__Group__33246 = new BitSet(new long[]{0x0060000000000000L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__4_in_rule__OilObjectImpl__Group__33249 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_rule__OilObjectImpl__Group__3__Impl3277 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__4__Impl_in_rule__OilObjectImpl__Group__43308 = new BitSet(new long[]{0x0060000000000000L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__5_in_rule__OilObjectImpl__Group__43311 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group_4__0_in_rule__OilObjectImpl__Group__4__Impl3338 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__5__Impl_in_rule__OilObjectImpl__Group__53369 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_rule__OilObjectImpl__Group__5__Impl3397 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group_4__0__Impl_in_rule__OilObjectImpl__Group_4__03440 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group_4__1_in_rule__OilObjectImpl__Group_4__03443 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_rule__OilObjectImpl__Group_4__0__Impl3471 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group_4__1__Impl_in_rule__OilObjectImpl__Group_4__13502 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__DescriptionAssignment_4_1_in_rule__OilObjectImpl__Group_4__1__Impl3529 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__0__Impl_in_rule__OilApplication__Group__03563 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__1_in_rule__OilApplication__Group__03566 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_rule__OilApplication__Group__0__Impl3594 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__1__Impl_in_rule__OilApplication__Group__13625 = new BitSet(new long[]{0x0008000000000000L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__2_in_rule__OilApplication__Group__13628 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__NameAssignment_1_in_rule__OilApplication__Group__1__Impl3655 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__2__Impl_in_rule__OilApplication__Group__23685 = new BitSet(new long[]{0x0010001FFF000000L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__3_in_rule__OilApplication__Group__23688 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_rule__OilApplication__Group__2__Impl3716 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__3__Impl_in_rule__OilApplication__Group__33747 = new BitSet(new long[]{0x0010001FFF000000L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__4_in_rule__OilApplication__Group__33750 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__OilObjectsAssignment_3_in_rule__OilApplication__Group__3__Impl3777 = new BitSet(new long[]{0x0000001FFF000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__4__Impl_in_rule__OilApplication__Group__43808 = new BitSet(new long[]{0x0060000000000000L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__5_in_rule__OilApplication__Group__43811 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_rule__OilApplication__Group__4__Impl3839 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__5__Impl_in_rule__OilApplication__Group__53870 = new BitSet(new long[]{0x0060000000000000L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__6_in_rule__OilApplication__Group__53873 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group_5__0_in_rule__OilApplication__Group__5__Impl3900 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__6__Impl_in_rule__OilApplication__Group__63931 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_rule__OilApplication__Group__6__Impl3959 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group_5__0__Impl_in_rule__OilApplication__Group_5__04004 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__OilApplication__Group_5__1_in_rule__OilApplication__Group_5__04007 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_rule__OilApplication__Group_5__0__Impl4035 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group_5__1__Impl_in_rule__OilApplication__Group_5__14066 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__DescriptionAssignment_5_1_in_rule__OilApplication__Group_5__1__Impl4093 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__0__Impl_in_rule__ValueType__Group__04127 = new BitSet(new long[]{0x00000000003F8000L});
        public static final BitSet FOLLOW_rule__ValueType__Group__1_in_rule__ValueType__Group__04130 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__1__Impl_in_rule__ValueType__Group__14188 = new BitSet(new long[]{0x0800000000000010L});
        public static final BitSet FOLLOW_rule__ValueType__Group__2_in_rule__ValueType__Group__14191 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__TypeAssignment_1_in_rule__ValueType__Group__1__Impl4218 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__2__Impl_in_rule__ValueType__Group__24248 = new BitSet(new long[]{0x0800000000000010L});
        public static final BitSet FOLLOW_rule__ValueType__Group__3_in_rule__ValueType__Group__24251 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__WithAutoAssignment_2_in_rule__ValueType__Group__2__Impl4278 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__3__Impl_in_rule__ValueType__Group__34309 = new BitSet(new long[]{0x1160000000000000L});
        public static final BitSet FOLLOW_rule__ValueType__Group__4_in_rule__ValueType__Group__34312 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__NameAssignment_3_in_rule__ValueType__Group__3__Impl4339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__4__Impl_in_rule__ValueType__Group__44369 = new BitSet(new long[]{0x1160000000000000L});
        public static final BitSet FOLLOW_rule__ValueType__Group__5_in_rule__ValueType__Group__44372 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__MultiValueAssignment_4_in_rule__ValueType__Group__4__Impl4399 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__5__Impl_in_rule__ValueType__Group__54430 = new BitSet(new long[]{0x1160000000000000L});
        public static final BitSet FOLLOW_rule__ValueType__Group__6_in_rule__ValueType__Group__54433 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_5__0_in_rule__ValueType__Group__5__Impl4460 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__6__Impl_in_rule__ValueType__Group__64491 = new BitSet(new long[]{0x1160000000000000L});
        public static final BitSet FOLLOW_rule__ValueType__Group__7_in_rule__ValueType__Group__64494 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_6__0_in_rule__ValueType__Group__6__Impl4521 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__7__Impl_in_rule__ValueType__Group__74552 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_rule__ValueType__Group__7__Impl4580 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_5__0__Impl_in_rule__ValueType__Group_5__04627 = new BitSet(new long[]{0x2000000000006170L});
        public static final BitSet FOLLOW_rule__ValueType__Group_5__1_in_rule__ValueType__Group_5__04630 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_rule__ValueType__Group_5__0__Impl4658 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_5__1__Impl_in_rule__ValueType__Group_5__14689 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Alternatives_5_1_in_rule__ValueType__Group_5__1__Impl4716 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_6__0__Impl_in_rule__ValueType__Group_6__04750 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__ValueType__Group_6__1_in_rule__ValueType__Group_6__04753 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_rule__ValueType__Group_6__0__Impl4781 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_6__1__Impl_in_rule__ValueType__Group_6__14812 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__DescriptionAssignment_6_1_in_rule__ValueType__Group_6__1__Impl4839 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__0__Impl_in_rule__VariantType__Group__04873 = new BitSet(new long[]{0x0000000000C00000L});
        public static final BitSet FOLLOW_rule__VariantType__Group__1_in_rule__VariantType__Group__04876 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__1__Impl_in_rule__VariantType__Group__14934 = new BitSet(new long[]{0x0800000000000010L});
        public static final BitSet FOLLOW_rule__VariantType__Group__2_in_rule__VariantType__Group__14937 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__TypeAssignment_1_in_rule__VariantType__Group__1__Impl4964 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__2__Impl_in_rule__VariantType__Group__24994 = new BitSet(new long[]{0x0800000000000010L});
        public static final BitSet FOLLOW_rule__VariantType__Group__3_in_rule__VariantType__Group__24997 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__WithAutoAssignment_2_in_rule__VariantType__Group__2__Impl5024 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__3__Impl_in_rule__VariantType__Group__35055 = new BitSet(new long[]{0x1168000000000000L});
        public static final BitSet FOLLOW_rule__VariantType__Group__4_in_rule__VariantType__Group__35058 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__NameAssignment_3_in_rule__VariantType__Group__3__Impl5085 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__4__Impl_in_rule__VariantType__Group__45115 = new BitSet(new long[]{0x1168000000000000L});
        public static final BitSet FOLLOW_rule__VariantType__Group__5_in_rule__VariantType__Group__45118 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__MultiValueAssignment_4_in_rule__VariantType__Group__4__Impl5145 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__5__Impl_in_rule__VariantType__Group__55176 = new BitSet(new long[]{0x1168000000000000L});
        public static final BitSet FOLLOW_rule__VariantType__Group__6_in_rule__VariantType__Group__55179 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_5__0_in_rule__VariantType__Group__5__Impl5206 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__6__Impl_in_rule__VariantType__Group__65237 = new BitSet(new long[]{0x1168000000000000L});
        public static final BitSet FOLLOW_rule__VariantType__Group__7_in_rule__VariantType__Group__65240 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_6__0_in_rule__VariantType__Group__6__Impl5267 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__7__Impl_in_rule__VariantType__Group__75298 = new BitSet(new long[]{0x1168000000000000L});
        public static final BitSet FOLLOW_rule__VariantType__Group__8_in_rule__VariantType__Group__75301 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_7__0_in_rule__VariantType__Group__7__Impl5328 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__8__Impl_in_rule__VariantType__Group__85359 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_rule__VariantType__Group__8__Impl5387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_5__0__Impl_in_rule__VariantType__Group_5__05436 = new BitSet(new long[]{0x0010000000000010L});
        public static final BitSet FOLLOW_rule__VariantType__Group_5__1_in_rule__VariantType__Group_5__05439 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_rule__VariantType__Group_5__0__Impl5467 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_5__1__Impl_in_rule__VariantType__Group_5__15498 = new BitSet(new long[]{0x0010000000000010L});
        public static final BitSet FOLLOW_rule__VariantType__Group_5__2_in_rule__VariantType__Group_5__15501 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_5_1__0_in_rule__VariantType__Group_5__1__Impl5528 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_5__2__Impl_in_rule__VariantType__Group_5__25559 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_rule__VariantType__Group_5__2__Impl5587 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_5_1__0__Impl_in_rule__VariantType__Group_5_1__05624 = new BitSet(new long[]{0x0200000000000000L});
        public static final BitSet FOLLOW_rule__VariantType__Group_5_1__1_in_rule__VariantType__Group_5_1__05627 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__ValuesAssignment_5_1_0_in_rule__VariantType__Group_5_1__0__Impl5654 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_5_1__1__Impl_in_rule__VariantType__Group_5_1__15684 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_5_1_1__0_in_rule__VariantType__Group_5_1__1__Impl5711 = new BitSet(new long[]{0x0200000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_5_1_1__0__Impl_in_rule__VariantType__Group_5_1_1__05746 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__VariantType__Group_5_1_1__1_in_rule__VariantType__Group_5_1_1__05749 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_rule__VariantType__Group_5_1_1__0__Impl5777 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_5_1_1__1__Impl_in_rule__VariantType__Group_5_1_1__15808 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__ValuesAssignment_5_1_1_1_in_rule__VariantType__Group_5_1_1__1__Impl5835 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_6__0__Impl_in_rule__VariantType__Group_6__05869 = new BitSet(new long[]{0x2000000000000010L});
        public static final BitSet FOLLOW_rule__VariantType__Group_6__1_in_rule__VariantType__Group_6__05872 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_rule__VariantType__Group_6__0__Impl5900 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_6__1__Impl_in_rule__VariantType__Group_6__15931 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Alternatives_6_1_in_rule__VariantType__Group_6__1__Impl5958 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_7__0__Impl_in_rule__VariantType__Group_7__05992 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__VariantType__Group_7__1_in_rule__VariantType__Group_7__05995 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_rule__VariantType__Group_7__0__Impl6023 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_7__1__Impl_in_rule__VariantType__Group_7__16054 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__DescriptionAssignment_7_1_in_rule__VariantType__Group_7__1__Impl6081 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group__0__Impl_in_rule__EnumeratorType__Group__06115 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group__1_in_rule__EnumeratorType__Group__06118 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group__1__Impl_in_rule__EnumeratorType__Group__16176 = new BitSet(new long[]{0x0048000000000000L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group__2_in_rule__EnumeratorType__Group__16179 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__NameAssignment_1_in_rule__EnumeratorType__Group__1__Impl6206 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group__2__Impl_in_rule__EnumeratorType__Group__26236 = new BitSet(new long[]{0x0048000000000000L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group__3_in_rule__EnumeratorType__Group__26239 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_2__0_in_rule__EnumeratorType__Group__2__Impl6266 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group__3__Impl_in_rule__EnumeratorType__Group__36297 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_3__0_in_rule__EnumeratorType__Group__3__Impl6324 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_2__0__Impl_in_rule__EnumeratorType__Group_2__06363 = new BitSet(new long[]{0x0013FFE000FF8000L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_2__1_in_rule__EnumeratorType__Group_2__06366 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_rule__EnumeratorType__Group_2__0__Impl6394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_2__1__Impl_in_rule__EnumeratorType__Group_2__16425 = new BitSet(new long[]{0x0013FFE000FF8000L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_2__2_in_rule__EnumeratorType__Group_2__16428 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__ParametersAssignment_2_1_in_rule__EnumeratorType__Group_2__1__Impl6455 = new BitSet(new long[]{0x0003FFE000FF8002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_2__2__Impl_in_rule__EnumeratorType__Group_2__26486 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_rule__EnumeratorType__Group_2__2__Impl6514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_3__0__Impl_in_rule__EnumeratorType__Group_3__06551 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_3__1_in_rule__EnumeratorType__Group_3__06554 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_rule__EnumeratorType__Group_3__0__Impl6582 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_3__1__Impl_in_rule__EnumeratorType__Group_3__16613 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__DescriptionAssignment_3_1_in_rule__EnumeratorType__Group_3__1__Impl6640 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__0__Impl_in_rule__ReferenceType__Group__06674 = new BitSet(new long[]{0x0003FFE000FF8000L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__1_in_rule__ReferenceType__Group__06677 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__1__Impl_in_rule__ReferenceType__Group__16735 = new BitSet(new long[]{0x0800000000000010L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__2_in_rule__ReferenceType__Group__16738 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__TypeAssignment_1_in_rule__ReferenceType__Group__1__Impl6765 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__2__Impl_in_rule__ReferenceType__Group__26795 = new BitSet(new long[]{0x0800000000000010L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__3_in_rule__ReferenceType__Group__26798 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__WithAutoAssignment_2_in_rule__ReferenceType__Group__2__Impl6825 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__3__Impl_in_rule__ReferenceType__Group__36856 = new BitSet(new long[]{0x1160000000000000L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__4_in_rule__ReferenceType__Group__36859 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__NameAssignment_3_in_rule__ReferenceType__Group__3__Impl6886 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__4__Impl_in_rule__ReferenceType__Group__46916 = new BitSet(new long[]{0x1160000000000000L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__5_in_rule__ReferenceType__Group__46919 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__MultiValueAssignment_4_in_rule__ReferenceType__Group__4__Impl6946 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__5__Impl_in_rule__ReferenceType__Group__56977 = new BitSet(new long[]{0x1160000000000000L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__6_in_rule__ReferenceType__Group__56980 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_5__0_in_rule__ReferenceType__Group__5__Impl7007 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__6__Impl_in_rule__ReferenceType__Group__67038 = new BitSet(new long[]{0x1160000000000000L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__7_in_rule__ReferenceType__Group__67041 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_6__0_in_rule__ReferenceType__Group__6__Impl7068 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__7__Impl_in_rule__ReferenceType__Group__77099 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_rule__ReferenceType__Group__7__Impl7127 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_5__0__Impl_in_rule__ReferenceType__Group_5__07174 = new BitSet(new long[]{0x2000000000000010L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_5__1_in_rule__ReferenceType__Group_5__07177 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_rule__ReferenceType__Group_5__0__Impl7205 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_5__1__Impl_in_rule__ReferenceType__Group_5__17236 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Alternatives_5_1_in_rule__ReferenceType__Group_5__1__Impl7263 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_6__0__Impl_in_rule__ReferenceType__Group_6__07297 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_6__1_in_rule__ReferenceType__Group_6__07300 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_rule__ReferenceType__Group_6__0__Impl7328 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_6__1__Impl_in_rule__ReferenceType__Group_6__17359 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__DescriptionAssignment_6_1_in_rule__ReferenceType__Group_6__1__Impl7386 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group__0__Impl_in_rule__OilObject__Group__07420 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__OilObject__Group__1_in_rule__OilObject__Group__07423 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__TypeAssignment_0_in_rule__OilObject__Group__0__Impl7450 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group__1__Impl_in_rule__OilObject__Group__17480 = new BitSet(new long[]{0x0008000000000000L});
        public static final BitSet FOLLOW_rule__OilObject__Group__2_in_rule__OilObject__Group__17483 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__NameAssignment_1_in_rule__OilObject__Group__1__Impl7510 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group__2__Impl_in_rule__OilObject__Group__27540 = new BitSet(new long[]{0x0010000000000010L});
        public static final BitSet FOLLOW_rule__OilObject__Group__3_in_rule__OilObject__Group__27543 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_rule__OilObject__Group__2__Impl7571 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group__3__Impl_in_rule__OilObject__Group__37602 = new BitSet(new long[]{0x0010000000000010L});
        public static final BitSet FOLLOW_rule__OilObject__Group__4_in_rule__OilObject__Group__37605 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__ParametersAssignment_3_in_rule__OilObject__Group__3__Impl7632 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__OilObject__Group__4__Impl_in_rule__OilObject__Group__47663 = new BitSet(new long[]{0x0060000000000000L});
        public static final BitSet FOLLOW_rule__OilObject__Group__5_in_rule__OilObject__Group__47666 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_rule__OilObject__Group__4__Impl7694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group__5__Impl_in_rule__OilObject__Group__57725 = new BitSet(new long[]{0x0060000000000000L});
        public static final BitSet FOLLOW_rule__OilObject__Group__6_in_rule__OilObject__Group__57728 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group_5__0_in_rule__OilObject__Group__5__Impl7755 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group__6__Impl_in_rule__OilObject__Group__67786 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_rule__OilObject__Group__6__Impl7814 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group_5__0__Impl_in_rule__OilObject__Group_5__07859 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__OilObject__Group_5__1_in_rule__OilObject__Group_5__07862 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_rule__OilObject__Group_5__0__Impl7890 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group_5__1__Impl_in_rule__OilObject__Group_5__17921 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__DescriptionAssignment_5_1_in_rule__OilObject__Group_5__1__Impl7948 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__0__Impl_in_rule__Parameter__Group__07982 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Parameter__Group__1_in_rule__Parameter__Group__07985 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__1__Impl_in_rule__Parameter__Group__18043 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_rule__Parameter__Group__2_in_rule__Parameter__Group__18046 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__TypeAssignment_1_in_rule__Parameter__Group__1__Impl8073 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__2__Impl_in_rule__Parameter__Group__28103 = new BitSet(new long[]{0x2000000000006170L});
        public static final BitSet FOLLOW_rule__Parameter__Group__3_in_rule__Parameter__Group__28106 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_rule__Parameter__Group__2__Impl8134 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__3__Impl_in_rule__Parameter__Group__38165 = new BitSet(new long[]{0x0068000000000000L});
        public static final BitSet FOLLOW_rule__Parameter__Group__4_in_rule__Parameter__Group__38168 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Alternatives_3_in_rule__Parameter__Group__3__Impl8195 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__4__Impl_in_rule__Parameter__Group__48225 = new BitSet(new long[]{0x0068000000000000L});
        public static final BitSet FOLLOW_rule__Parameter__Group__5_in_rule__Parameter__Group__48228 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group_4__0_in_rule__Parameter__Group__4__Impl8255 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__5__Impl_in_rule__Parameter__Group__58286 = new BitSet(new long[]{0x0068000000000000L});
        public static final BitSet FOLLOW_rule__Parameter__Group__6_in_rule__Parameter__Group__58289 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group_5__0_in_rule__Parameter__Group__5__Impl8316 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__6__Impl_in_rule__Parameter__Group__68347 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_rule__Parameter__Group__6__Impl8375 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group_4__0__Impl_in_rule__Parameter__Group_4__08420 = new BitSet(new long[]{0x0010000000000010L});
        public static final BitSet FOLLOW_rule__Parameter__Group_4__1_in_rule__Parameter__Group_4__08423 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_rule__Parameter__Group_4__0__Impl8451 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group_4__1__Impl_in_rule__Parameter__Group_4__18482 = new BitSet(new long[]{0x0010000000000010L});
        public static final BitSet FOLLOW_rule__Parameter__Group_4__2_in_rule__Parameter__Group_4__18485 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__ParametersAssignment_4_1_in_rule__Parameter__Group_4__1__Impl8512 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__Parameter__Group_4__2__Impl_in_rule__Parameter__Group_4__28543 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_rule__Parameter__Group_4__2__Impl8571 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group_5__0__Impl_in_rule__Parameter__Group_5__08608 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Parameter__Group_5__1_in_rule__Parameter__Group_5__08611 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_rule__Parameter__Group_5__0__Impl8639 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group_5__1__Impl_in_rule__Parameter__Group_5__18670 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__DescriptionAssignment_5_1_in_rule__Parameter__Group_5__1__Impl8697 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Group__0__Impl_in_rule__INT__Group__08731 = new BitSet(new long[]{0x0000000000006140L});
        public static final BitSet FOLLOW_rule__INT__Group__1_in_rule__INT__Group__08734 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Alternatives_0_in_rule__INT__Group__0__Impl8761 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Group__1__Impl_in_rule__INT__Group__18792 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Alternatives_1_in_rule__INT__Group__1__Impl8819 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Group_1_0__0__Impl_in_rule__INT__Group_1_0__08853 = new BitSet(new long[]{0x0000000000000180L});
        public static final BitSet FOLLOW_rule__INT__Group_1_0__1_in_rule__INT__Group_1_0__08856 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_rule__INT__Group_1_0__0__Impl8883 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Group_1_0__1__Impl_in_rule__INT__Group_1_0__18912 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Alternatives_1_0_1_in_rule__INT__Group_1_0__1__Impl8939 = new BitSet(new long[]{0x0000000000000182L});
        public static final BitSet FOLLOW_rule__DOUBLE__Group__0__Impl_in_rule__DOUBLE__Group__08974 = new BitSet(new long[]{0x0000000000006160L});
        public static final BitSet FOLLOW_rule__DOUBLE__Group__1_in_rule__DOUBLE__Group__08977 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DOUBLE__Alternatives_0_in_rule__DOUBLE__Group__0__Impl9004 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DOUBLE__Group__1__Impl_in_rule__DOUBLE__Group__19035 = new BitSet(new long[]{0x0400000000000180L});
        public static final BitSet FOLLOW_rule__DOUBLE__Group__2_in_rule__DOUBLE__Group__19038 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_rule__DOUBLE__Group__1__Impl9065 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DOUBLE__Group__2__Impl_in_rule__DOUBLE__Group__29094 = new BitSet(new long[]{0x0400000000000180L});
        public static final BitSet FOLLOW_rule__DOUBLE__Group__3_in_rule__DOUBLE__Group__29097 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DOUBLE__Alternatives_2_in_rule__DOUBLE__Group__2__Impl9124 = new BitSet(new long[]{0x0000000000000182L});
        public static final BitSet FOLLOW_rule__DOUBLE__Group__3__Impl_in_rule__DOUBLE__Group__39155 = new BitSet(new long[]{0x0000000000000180L});
        public static final BitSet FOLLOW_rule__DOUBLE__Group__4_in_rule__DOUBLE__Group__39158 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_rule__DOUBLE__Group__3__Impl9187 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DOUBLE__Group__4__Impl_in_rule__DOUBLE__Group__49219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DOUBLE__Alternatives_4_in_rule__DOUBLE__Group__4__Impl9248 = new BitSet(new long[]{0x0000000000000182L});
        public static final BitSet FOLLOW_rule__DOUBLE__Alternatives_4_in_rule__DOUBLE__Group__4__Impl9260 = new BitSet(new long[]{0x0000000000000182L});
        public static final BitSet FOLLOW_ruleOilImplementation_in_rule__OilFile__ImplementationAssignment_09308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilApplication_in_rule__OilFile__ApplicationAssignment_19339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__OilImplementation__NameAssignment_19370 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilObjectImpl_in_rule__OilImplementation__OilObjectsAssignment_39401 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectType_in_rule__OilObjectImpl__TypeAssignment_09432 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameterType_in_rule__OilObjectImpl__ParametersAssignment_29463 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__OilObjectImpl__DescriptionAssignment_4_19494 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__OilApplication__NameAssignment_19525 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilObject_in_rule__OilApplication__OilObjectsAssignment_39556 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__OilApplication__DescriptionAssignment_5_19587 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVType_in_rule__ValueType__TypeAssignment_19618 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_59_in_rule__ValueType__WithAutoAssignment_29654 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ValueType__NameAssignment_39693 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_rule__ValueType__MultiValueAssignment_49729 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_rule__ValueType__DefaultAutoAssignment_5_1_09773 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__DefaultValueAlternatives_5_1_1_0_in_rule__ValueType__DefaultValueAssignment_5_1_19812 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__ValueType__DescriptionAssignment_6_19845 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEType_in_rule__VariantType__TypeAssignment_19876 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_59_in_rule__VariantType__WithAutoAssignment_29912 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__VariantType__NameAssignment_39951 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_rule__VariantType__MultiValueAssignment_49987 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumeratorType_in_rule__VariantType__ValuesAssignment_5_1_010026 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumeratorType_in_rule__VariantType__ValuesAssignment_5_1_1_110057 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_rule__VariantType__DefaultAutoAssignment_6_1_010093 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__VariantType__DefaultValueAssignment_6_1_110132 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__VariantType__DescriptionAssignment_7_110163 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EnumeratorType__NameAssignment_110194 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameterType_in_rule__EnumeratorType__ParametersAssignment_2_110225 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__EnumeratorType__DescriptionAssignment_3_110256 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectTypeRef_in_rule__ReferenceType__TypeAssignment_110287 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_59_in_rule__ReferenceType__WithAutoAssignment_210323 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ReferenceType__NameAssignment_310362 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_rule__ReferenceType__MultiValueAssignment_410398 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_rule__ReferenceType__DefaultAutoAssignment_5_1_010442 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ReferenceType__DefaultValueAssignment_5_1_110481 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__ReferenceType__DescriptionAssignment_6_110512 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectType_in_rule__OilObject__TypeAssignment_010543 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__OilObject__NameAssignment_110574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameter_in_rule__OilObject__ParametersAssignment_310605 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__OilObject__DescriptionAssignment_5_110636 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Parameter__TypeAssignment_110671 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_rule__Parameter__AutoAssignment_3_010711 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGenericValue_in_rule__Parameter__ValueAssignment_3_110750 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Parameter__ValueRefAssignment_3_210785 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameter_in_rule__Parameter__ParametersAssignment_4_110820 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Parameter__DescriptionAssignment_5_110851 = new BitSet(new long[]{0x0000000000000002L});
    }


}