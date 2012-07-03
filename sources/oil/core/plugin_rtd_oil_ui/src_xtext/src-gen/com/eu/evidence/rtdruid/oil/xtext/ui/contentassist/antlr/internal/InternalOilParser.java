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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_ZERO_INT", "RULE_HEX", "RULE_NON_ZERO_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'STRING'", "'UINT32'", "'INT32'", "'UINT64'", "'INT64'", "'FLOAT'", "'DOUBLE'", "'BOOLEAN'", "'ENUM'", "'OS'", "'ALARM'", "'APPMODE'", "'COUNTER'", "'COM'", "'EVENT'", "'IPDU'", "'ISR'", "'MESSAGE'", "'NETWORKMESSAGE'", "'NM'", "'RESOURCE'", "'TASK'", "'OS_TYPE'", "'ALARM_TYPE'", "'APPMODE_TYPE'", "'COUNTER_TYPE'", "'COM_TYPE'", "'EVENT_TYPE'", "'IPDU_TYPE'", "'ISR_TYPE'", "'MESSAGE_TYPE'", "'NETWORKMESSAGE_TYPE'", "'NM_TYPE'", "'RESOURCE_TYPE'", "'TASK_TYPE'", "'+'", "'-'", "'OIL_VERSION'", "'='", "';'", "'IMPLEMENTATION'", "'{'", "'}'", "':'", "'CPU'", "'['", "']'", "','", "'.'", "'WITH_AUTO'", "'[]'", "'AUTO'"
    };
    public static final int RULE_ID=4;
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
    public static final int RULE_ZERO_INT=6;
    public static final int T__20=20;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__19=19;
    public static final int T__57=57;
    public static final int RULE_HEX=7;
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


    // $ANTLR start "entryRuleSpecialId"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:369:1: entryRuleSpecialId : ruleSpecialId EOF ;
    public final void entryRuleSpecialId() throws RecognitionException {
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:370:1: ( ruleSpecialId EOF )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:371:1: ruleSpecialId EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSpecialIdRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_entryRuleSpecialId727);
            ruleSpecialId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSpecialIdRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpecialId734); if (state.failed) return ;

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
    // $ANTLR end "entryRuleSpecialId"


    // $ANTLR start "ruleSpecialId"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:378:1: ruleSpecialId : ( ( rule__SpecialId__Alternatives ) ) ;
    public final void ruleSpecialId() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:382:2: ( ( ( rule__SpecialId__Alternatives ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:383:1: ( ( rule__SpecialId__Alternatives ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:383:1: ( ( rule__SpecialId__Alternatives ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:384:1: ( rule__SpecialId__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSpecialIdAccess().getAlternatives()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:385:1: ( rule__SpecialId__Alternatives )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:385:2: rule__SpecialId__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__SpecialId__Alternatives_in_ruleSpecialId760);
            rule__SpecialId__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSpecialIdAccess().getAlternatives()); 
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
    // $ANTLR end "ruleSpecialId"


    // $ANTLR start "entryRuleGenericValue"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:397:1: entryRuleGenericValue : ruleGenericValue EOF ;
    public final void entryRuleGenericValue() throws RecognitionException {
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:398:1: ( ruleGenericValue EOF )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:399:1: ruleGenericValue EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGenericValueRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleGenericValue_in_entryRuleGenericValue787);
            ruleGenericValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getGenericValueRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGenericValue794); if (state.failed) return ;

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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:406:1: ruleGenericValue : ( ( rule__GenericValue__Alternatives ) ) ;
    public final void ruleGenericValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:410:2: ( ( ( rule__GenericValue__Alternatives ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:411:1: ( ( rule__GenericValue__Alternatives ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:411:1: ( ( rule__GenericValue__Alternatives ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:412:1: ( rule__GenericValue__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGenericValueAccess().getAlternatives()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:413:1: ( rule__GenericValue__Alternatives )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:413:2: rule__GenericValue__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__GenericValue__Alternatives_in_ruleGenericValue820);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:425:1: entryRuleINT : ruleINT EOF ;
    public final void entryRuleINT() throws RecognitionException {
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:426:1: ( ruleINT EOF )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:427:1: ruleINT EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getINTRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleINT_in_entryRuleINT847);
            ruleINT();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getINTRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleINT854); if (state.failed) return ;

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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:434:1: ruleINT : ( ( rule__INT__Group__0 ) ) ;
    public final void ruleINT() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:438:2: ( ( ( rule__INT__Group__0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:439:1: ( ( rule__INT__Group__0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:439:1: ( ( rule__INT__Group__0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:440:1: ( rule__INT__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getINTAccess().getGroup()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:441:1: ( rule__INT__Group__0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:441:2: rule__INT__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__INT__Group__0_in_ruleINT880);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:453:1: entryRuleDOUBLE : ruleDOUBLE EOF ;
    public final void entryRuleDOUBLE() throws RecognitionException {
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:454:1: ( ruleDOUBLE EOF )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:455:1: ruleDOUBLE EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDOUBLERule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleDOUBLE_in_entryRuleDOUBLE907);
            ruleDOUBLE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDOUBLERule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDOUBLE914); if (state.failed) return ;

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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:462:1: ruleDOUBLE : ( ( rule__DOUBLE__Group__0 ) ) ;
    public final void ruleDOUBLE() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:466:2: ( ( ( rule__DOUBLE__Group__0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:467:1: ( ( rule__DOUBLE__Group__0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:467:1: ( ( rule__DOUBLE__Group__0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:468:1: ( rule__DOUBLE__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDOUBLEAccess().getGroup()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:469:1: ( rule__DOUBLE__Group__0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:469:2: rule__DOUBLE__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Group__0_in_ruleDOUBLE940);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:482:1: ruleVType : ( ( rule__VType__Alternatives ) ) ;
    public final void ruleVType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:486:1: ( ( ( rule__VType__Alternatives ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:487:1: ( ( rule__VType__Alternatives ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:487:1: ( ( rule__VType__Alternatives ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:488:1: ( rule__VType__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVTypeAccess().getAlternatives()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:489:1: ( rule__VType__Alternatives )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:489:2: rule__VType__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__VType__Alternatives_in_ruleVType977);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:501:1: ruleEType : ( ( rule__EType__Alternatives ) ) ;
    public final void ruleEType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:505:1: ( ( ( rule__EType__Alternatives ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:506:1: ( ( rule__EType__Alternatives ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:506:1: ( ( rule__EType__Alternatives ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:507:1: ( rule__EType__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getETypeAccess().getAlternatives()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:508:1: ( rule__EType__Alternatives )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:508:2: rule__EType__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__EType__Alternatives_in_ruleEType1013);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:520:1: ruleObjectType : ( ( rule__ObjectType__Alternatives ) ) ;
    public final void ruleObjectType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:524:1: ( ( ( rule__ObjectType__Alternatives ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:525:1: ( ( rule__ObjectType__Alternatives ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:525:1: ( ( rule__ObjectType__Alternatives ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:526:1: ( rule__ObjectType__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectTypeAccess().getAlternatives()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:527:1: ( rule__ObjectType__Alternatives )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:527:2: rule__ObjectType__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__ObjectType__Alternatives_in_ruleObjectType1049);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:539:1: ruleObjectTypeRef : ( ( rule__ObjectTypeRef__Alternatives ) ) ;
    public final void ruleObjectTypeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:543:1: ( ( ( rule__ObjectTypeRef__Alternatives ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:544:1: ( ( rule__ObjectTypeRef__Alternatives ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:544:1: ( ( rule__ObjectTypeRef__Alternatives ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:545:1: ( rule__ObjectTypeRef__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectTypeRefAccess().getAlternatives()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:546:1: ( rule__ObjectTypeRef__Alternatives )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:546:2: rule__ObjectTypeRef__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__ObjectTypeRef__Alternatives_in_ruleObjectTypeRef1085);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:557:1: rule__ParameterType__Alternatives : ( ( ruleValueType ) | ( ruleVariantType ) | ( ruleReferenceType ) );
    public final void rule__ParameterType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:561:1: ( ( ruleValueType ) | ( ruleVariantType ) | ( ruleReferenceType ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                {
                alt1=1;
                }
                break;
            case 20:
            case 21:
                {
                alt1=2;
                }
                break;
            case 35:
            case 36:
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:562:1: ( ruleValueType )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:562:1: ( ruleValueType )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:563:1: ruleValueType
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getParameterTypeAccess().getValueTypeParserRuleCall_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleValueType_in_rule__ParameterType__Alternatives1120);
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:568:6: ( ruleVariantType )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:568:6: ( ruleVariantType )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:569:1: ruleVariantType
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getParameterTypeAccess().getVariantTypeParserRuleCall_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleVariantType_in_rule__ParameterType__Alternatives1137);
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:574:6: ( ruleReferenceType )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:574:6: ( ruleReferenceType )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:575:1: ruleReferenceType
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getParameterTypeAccess().getReferenceTypeParserRuleCall_2()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleReferenceType_in_rule__ParameterType__Alternatives1154);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:585:1: rule__ValueType__Alternatives_5_1 : ( ( ( rule__ValueType__DefaultAutoAssignment_5_1_0 ) ) | ( ( rule__ValueType__DefaultValueAssignment_5_1_1 ) ) );
    public final void rule__ValueType__Alternatives_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:589:1: ( ( ( rule__ValueType__DefaultAutoAssignment_5_1_0 ) ) | ( ( rule__ValueType__DefaultValueAssignment_5_1_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==64) ) {
                alt2=1;
            }
            else if ( ((LA2_0>=RULE_ID && LA2_0<=RULE_NON_ZERO_INT)||(LA2_0>=48 && LA2_0<=49)) ) {
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:590:1: ( ( rule__ValueType__DefaultAutoAssignment_5_1_0 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:590:1: ( ( rule__ValueType__DefaultAutoAssignment_5_1_0 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:591:1: ( rule__ValueType__DefaultAutoAssignment_5_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getDefaultAutoAssignment_5_1_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:592:1: ( rule__ValueType__DefaultAutoAssignment_5_1_0 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:592:2: rule__ValueType__DefaultAutoAssignment_5_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ValueType__DefaultAutoAssignment_5_1_0_in_rule__ValueType__Alternatives_5_11186);
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:596:6: ( ( rule__ValueType__DefaultValueAssignment_5_1_1 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:596:6: ( ( rule__ValueType__DefaultValueAssignment_5_1_1 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:597:1: ( rule__ValueType__DefaultValueAssignment_5_1_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getDefaultValueAssignment_5_1_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:598:1: ( rule__ValueType__DefaultValueAssignment_5_1_1 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:598:2: rule__ValueType__DefaultValueAssignment_5_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ValueType__DefaultValueAssignment_5_1_1_in_rule__ValueType__Alternatives_5_11204);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:607:1: rule__ValueType__DefaultValueAlternatives_5_1_1_0 : ( ( ruleGenericValue ) | ( RULE_ID ) );
    public final void rule__ValueType__DefaultValueAlternatives_5_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:611:1: ( ( ruleGenericValue ) | ( RULE_ID ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=RULE_STRING && LA3_0<=RULE_NON_ZERO_INT)||(LA3_0>=48 && LA3_0<=49)) ) {
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:612:1: ( ruleGenericValue )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:612:1: ( ruleGenericValue )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:613:1: ruleGenericValue
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getDefaultValueGenericValueParserRuleCall_5_1_1_0_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleGenericValue_in_rule__ValueType__DefaultValueAlternatives_5_1_1_01237);
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:618:6: ( RULE_ID )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:618:6: ( RULE_ID )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:619:1: RULE_ID
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getDefaultValueIDTerminalRuleCall_5_1_1_0_1()); 
                    }
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ValueType__DefaultValueAlternatives_5_1_1_01254); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:629:1: rule__VariantType__Alternatives_6_1 : ( ( ( rule__VariantType__DefaultAutoAssignment_6_1_0 ) ) | ( ( rule__VariantType__DefaultValueAssignment_6_1_1 ) ) );
    public final void rule__VariantType__Alternatives_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:633:1: ( ( ( rule__VariantType__DefaultAutoAssignment_6_1_0 ) ) | ( ( rule__VariantType__DefaultValueAssignment_6_1_1 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==64) ) {
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:634:1: ( ( rule__VariantType__DefaultAutoAssignment_6_1_0 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:634:1: ( ( rule__VariantType__DefaultAutoAssignment_6_1_0 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:635:1: ( rule__VariantType__DefaultAutoAssignment_6_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVariantTypeAccess().getDefaultAutoAssignment_6_1_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:636:1: ( rule__VariantType__DefaultAutoAssignment_6_1_0 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:636:2: rule__VariantType__DefaultAutoAssignment_6_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__VariantType__DefaultAutoAssignment_6_1_0_in_rule__VariantType__Alternatives_6_11286);
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:640:6: ( ( rule__VariantType__DefaultValueAssignment_6_1_1 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:640:6: ( ( rule__VariantType__DefaultValueAssignment_6_1_1 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:641:1: ( rule__VariantType__DefaultValueAssignment_6_1_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVariantTypeAccess().getDefaultValueAssignment_6_1_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:642:1: ( rule__VariantType__DefaultValueAssignment_6_1_1 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:642:2: rule__VariantType__DefaultValueAssignment_6_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__VariantType__DefaultValueAssignment_6_1_1_in_rule__VariantType__Alternatives_6_11304);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:651:1: rule__ReferenceType__Alternatives_5_1 : ( ( ( rule__ReferenceType__DefaultAutoAssignment_5_1_0 ) ) | ( ( rule__ReferenceType__DefaultValueAssignment_5_1_1 ) ) );
    public final void rule__ReferenceType__Alternatives_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:655:1: ( ( ( rule__ReferenceType__DefaultAutoAssignment_5_1_0 ) ) | ( ( rule__ReferenceType__DefaultValueAssignment_5_1_1 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==64) ) {
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:656:1: ( ( rule__ReferenceType__DefaultAutoAssignment_5_1_0 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:656:1: ( ( rule__ReferenceType__DefaultAutoAssignment_5_1_0 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:657:1: ( rule__ReferenceType__DefaultAutoAssignment_5_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReferenceTypeAccess().getDefaultAutoAssignment_5_1_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:658:1: ( rule__ReferenceType__DefaultAutoAssignment_5_1_0 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:658:2: rule__ReferenceType__DefaultAutoAssignment_5_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__DefaultAutoAssignment_5_1_0_in_rule__ReferenceType__Alternatives_5_11337);
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:662:6: ( ( rule__ReferenceType__DefaultValueAssignment_5_1_1 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:662:6: ( ( rule__ReferenceType__DefaultValueAssignment_5_1_1 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:663:1: ( rule__ReferenceType__DefaultValueAssignment_5_1_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReferenceTypeAccess().getDefaultValueAssignment_5_1_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:664:1: ( rule__ReferenceType__DefaultValueAssignment_5_1_1 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:664:2: rule__ReferenceType__DefaultValueAssignment_5_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__DefaultValueAssignment_5_1_1_in_rule__ReferenceType__Alternatives_5_11355);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:673:1: rule__Parameter__Alternatives_3 : ( ( ( rule__Parameter__AutoAssignment_3_0 ) ) | ( ( rule__Parameter__ValueAssignment_3_1 ) ) | ( ( rule__Parameter__ValueRefAssignment_3_2 ) ) );
    public final void rule__Parameter__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:677:1: ( ( ( rule__Parameter__AutoAssignment_3_0 ) ) | ( ( rule__Parameter__ValueAssignment_3_1 ) ) | ( ( rule__Parameter__ValueRefAssignment_3_2 ) ) )
            int alt6=3;
            switch ( input.LA(1) ) {
            case 64:
                {
                alt6=1;
                }
                break;
            case RULE_STRING:
            case RULE_ZERO_INT:
            case RULE_HEX:
            case RULE_NON_ZERO_INT:
            case 48:
            case 49:
                {
                alt6=2;
                }
                break;
            case RULE_ID:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:678:1: ( ( rule__Parameter__AutoAssignment_3_0 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:678:1: ( ( rule__Parameter__AutoAssignment_3_0 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:679:1: ( rule__Parameter__AutoAssignment_3_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getParameterAccess().getAutoAssignment_3_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:680:1: ( rule__Parameter__AutoAssignment_3_0 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:680:2: rule__Parameter__AutoAssignment_3_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Parameter__AutoAssignment_3_0_in_rule__Parameter__Alternatives_31388);
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:684:6: ( ( rule__Parameter__ValueAssignment_3_1 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:684:6: ( ( rule__Parameter__ValueAssignment_3_1 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:685:1: ( rule__Parameter__ValueAssignment_3_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getParameterAccess().getValueAssignment_3_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:686:1: ( rule__Parameter__ValueAssignment_3_1 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:686:2: rule__Parameter__ValueAssignment_3_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Parameter__ValueAssignment_3_1_in_rule__Parameter__Alternatives_31406);
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:690:6: ( ( rule__Parameter__ValueRefAssignment_3_2 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:690:6: ( ( rule__Parameter__ValueRefAssignment_3_2 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:691:1: ( rule__Parameter__ValueRefAssignment_3_2 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getParameterAccess().getValueRefAssignment_3_2()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:692:1: ( rule__Parameter__ValueRefAssignment_3_2 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:692:2: rule__Parameter__ValueRefAssignment_3_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Parameter__ValueRefAssignment_3_2_in_rule__Parameter__Alternatives_31424);
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


    // $ANTLR start "rule__SpecialId__Alternatives"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:701:1: rule__SpecialId__Alternatives : ( ( RULE_ID ) | ( 'STRING' ) | ( 'UINT32' ) | ( 'INT32' ) | ( 'UINT64' ) | ( 'INT64' ) | ( 'FLOAT' ) | ( 'DOUBLE' ) | ( 'BOOLEAN' ) | ( 'ENUM' ) | ( 'OS' ) | ( 'ALARM' ) | ( 'APPMODE' ) | ( 'COUNTER' ) | ( 'COM' ) | ( 'EVENT' ) | ( 'IPDU' ) | ( 'ISR' ) | ( 'MESSAGE' ) | ( 'NETWORKMESSAGE' ) | ( 'NM' ) | ( 'RESOURCE' ) | ( 'TASK' ) | ( 'OS_TYPE' ) | ( 'ALARM_TYPE' ) | ( 'APPMODE_TYPE' ) | ( 'COUNTER_TYPE' ) | ( 'COM_TYPE' ) | ( 'EVENT_TYPE' ) | ( 'IPDU_TYPE' ) | ( 'ISR_TYPE' ) | ( 'MESSAGE_TYPE' ) | ( 'NETWORKMESSAGE_TYPE' ) | ( 'NM_TYPE' ) | ( 'RESOURCE_TYPE' ) | ( 'TASK_TYPE' ) );
    public final void rule__SpecialId__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:705:1: ( ( RULE_ID ) | ( 'STRING' ) | ( 'UINT32' ) | ( 'INT32' ) | ( 'UINT64' ) | ( 'INT64' ) | ( 'FLOAT' ) | ( 'DOUBLE' ) | ( 'BOOLEAN' ) | ( 'ENUM' ) | ( 'OS' ) | ( 'ALARM' ) | ( 'APPMODE' ) | ( 'COUNTER' ) | ( 'COM' ) | ( 'EVENT' ) | ( 'IPDU' ) | ( 'ISR' ) | ( 'MESSAGE' ) | ( 'NETWORKMESSAGE' ) | ( 'NM' ) | ( 'RESOURCE' ) | ( 'TASK' ) | ( 'OS_TYPE' ) | ( 'ALARM_TYPE' ) | ( 'APPMODE_TYPE' ) | ( 'COUNTER_TYPE' ) | ( 'COM_TYPE' ) | ( 'EVENT_TYPE' ) | ( 'IPDU_TYPE' ) | ( 'ISR_TYPE' ) | ( 'MESSAGE_TYPE' ) | ( 'NETWORKMESSAGE_TYPE' ) | ( 'NM_TYPE' ) | ( 'RESOURCE_TYPE' ) | ( 'TASK_TYPE' ) )
            int alt7=36;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt7=1;
                }
                break;
            case 13:
                {
                alt7=2;
                }
                break;
            case 14:
                {
                alt7=3;
                }
                break;
            case 15:
                {
                alt7=4;
                }
                break;
            case 16:
                {
                alt7=5;
                }
                break;
            case 17:
                {
                alt7=6;
                }
                break;
            case 18:
                {
                alt7=7;
                }
                break;
            case 19:
                {
                alt7=8;
                }
                break;
            case 20:
                {
                alt7=9;
                }
                break;
            case 21:
                {
                alt7=10;
                }
                break;
            case 22:
                {
                alt7=11;
                }
                break;
            case 23:
                {
                alt7=12;
                }
                break;
            case 24:
                {
                alt7=13;
                }
                break;
            case 25:
                {
                alt7=14;
                }
                break;
            case 26:
                {
                alt7=15;
                }
                break;
            case 27:
                {
                alt7=16;
                }
                break;
            case 28:
                {
                alt7=17;
                }
                break;
            case 29:
                {
                alt7=18;
                }
                break;
            case 30:
                {
                alt7=19;
                }
                break;
            case 31:
                {
                alt7=20;
                }
                break;
            case 32:
                {
                alt7=21;
                }
                break;
            case 33:
                {
                alt7=22;
                }
                break;
            case 34:
                {
                alt7=23;
                }
                break;
            case 35:
                {
                alt7=24;
                }
                break;
            case 36:
                {
                alt7=25;
                }
                break;
            case 37:
                {
                alt7=26;
                }
                break;
            case 38:
                {
                alt7=27;
                }
                break;
            case 39:
                {
                alt7=28;
                }
                break;
            case 40:
                {
                alt7=29;
                }
                break;
            case 41:
                {
                alt7=30;
                }
                break;
            case 42:
                {
                alt7=31;
                }
                break;
            case 43:
                {
                alt7=32;
                }
                break;
            case 44:
                {
                alt7=33;
                }
                break;
            case 45:
                {
                alt7=34;
                }
                break;
            case 46:
                {
                alt7=35;
                }
                break;
            case 47:
                {
                alt7=36;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:706:1: ( RULE_ID )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:706:1: ( RULE_ID )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:707:1: RULE_ID
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getIDTerminalRuleCall_0()); 
                    }
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__SpecialId__Alternatives1457); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getIDTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:712:6: ( 'STRING' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:712:6: ( 'STRING' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:713:1: 'STRING'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getSTRINGKeyword_1()); 
                    }
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__SpecialId__Alternatives1475); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getSTRINGKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:720:6: ( 'UINT32' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:720:6: ( 'UINT32' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:721:1: 'UINT32'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getUINT32Keyword_2()); 
                    }
                    match(input,14,FollowSets000.FOLLOW_14_in_rule__SpecialId__Alternatives1495); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getUINT32Keyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:728:6: ( 'INT32' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:728:6: ( 'INT32' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:729:1: 'INT32'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getINT32Keyword_3()); 
                    }
                    match(input,15,FollowSets000.FOLLOW_15_in_rule__SpecialId__Alternatives1515); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getINT32Keyword_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:736:6: ( 'UINT64' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:736:6: ( 'UINT64' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:737:1: 'UINT64'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getUINT64Keyword_4()); 
                    }
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__SpecialId__Alternatives1535); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getUINT64Keyword_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:744:6: ( 'INT64' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:744:6: ( 'INT64' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:745:1: 'INT64'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getINT64Keyword_5()); 
                    }
                    match(input,17,FollowSets000.FOLLOW_17_in_rule__SpecialId__Alternatives1555); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getINT64Keyword_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:752:6: ( 'FLOAT' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:752:6: ( 'FLOAT' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:753:1: 'FLOAT'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getFLOATKeyword_6()); 
                    }
                    match(input,18,FollowSets000.FOLLOW_18_in_rule__SpecialId__Alternatives1575); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getFLOATKeyword_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:760:6: ( 'DOUBLE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:760:6: ( 'DOUBLE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:761:1: 'DOUBLE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getDOUBLEKeyword_7()); 
                    }
                    match(input,19,FollowSets000.FOLLOW_19_in_rule__SpecialId__Alternatives1595); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getDOUBLEKeyword_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:768:6: ( 'BOOLEAN' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:768:6: ( 'BOOLEAN' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:769:1: 'BOOLEAN'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getBOOLEANKeyword_8()); 
                    }
                    match(input,20,FollowSets000.FOLLOW_20_in_rule__SpecialId__Alternatives1615); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getBOOLEANKeyword_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:776:6: ( 'ENUM' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:776:6: ( 'ENUM' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:777:1: 'ENUM'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getENUMKeyword_9()); 
                    }
                    match(input,21,FollowSets000.FOLLOW_21_in_rule__SpecialId__Alternatives1635); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getENUMKeyword_9()); 
                    }

                    }


                    }
                    break;
                case 11 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:784:6: ( 'OS' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:784:6: ( 'OS' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:785:1: 'OS'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getOSKeyword_10()); 
                    }
                    match(input,22,FollowSets000.FOLLOW_22_in_rule__SpecialId__Alternatives1655); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getOSKeyword_10()); 
                    }

                    }


                    }
                    break;
                case 12 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:792:6: ( 'ALARM' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:792:6: ( 'ALARM' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:793:1: 'ALARM'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getALARMKeyword_11()); 
                    }
                    match(input,23,FollowSets000.FOLLOW_23_in_rule__SpecialId__Alternatives1675); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getALARMKeyword_11()); 
                    }

                    }


                    }
                    break;
                case 13 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:800:6: ( 'APPMODE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:800:6: ( 'APPMODE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:801:1: 'APPMODE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getAPPMODEKeyword_12()); 
                    }
                    match(input,24,FollowSets000.FOLLOW_24_in_rule__SpecialId__Alternatives1695); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getAPPMODEKeyword_12()); 
                    }

                    }


                    }
                    break;
                case 14 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:808:6: ( 'COUNTER' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:808:6: ( 'COUNTER' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:809:1: 'COUNTER'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getCOUNTERKeyword_13()); 
                    }
                    match(input,25,FollowSets000.FOLLOW_25_in_rule__SpecialId__Alternatives1715); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getCOUNTERKeyword_13()); 
                    }

                    }


                    }
                    break;
                case 15 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:816:6: ( 'COM' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:816:6: ( 'COM' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:817:1: 'COM'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getCOMKeyword_14()); 
                    }
                    match(input,26,FollowSets000.FOLLOW_26_in_rule__SpecialId__Alternatives1735); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getCOMKeyword_14()); 
                    }

                    }


                    }
                    break;
                case 16 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:824:6: ( 'EVENT' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:824:6: ( 'EVENT' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:825:1: 'EVENT'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getEVENTKeyword_15()); 
                    }
                    match(input,27,FollowSets000.FOLLOW_27_in_rule__SpecialId__Alternatives1755); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getEVENTKeyword_15()); 
                    }

                    }


                    }
                    break;
                case 17 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:832:6: ( 'IPDU' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:832:6: ( 'IPDU' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:833:1: 'IPDU'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getIPDUKeyword_16()); 
                    }
                    match(input,28,FollowSets000.FOLLOW_28_in_rule__SpecialId__Alternatives1775); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getIPDUKeyword_16()); 
                    }

                    }


                    }
                    break;
                case 18 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:840:6: ( 'ISR' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:840:6: ( 'ISR' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:841:1: 'ISR'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getISRKeyword_17()); 
                    }
                    match(input,29,FollowSets000.FOLLOW_29_in_rule__SpecialId__Alternatives1795); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getISRKeyword_17()); 
                    }

                    }


                    }
                    break;
                case 19 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:848:6: ( 'MESSAGE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:848:6: ( 'MESSAGE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:849:1: 'MESSAGE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getMESSAGEKeyword_18()); 
                    }
                    match(input,30,FollowSets000.FOLLOW_30_in_rule__SpecialId__Alternatives1815); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getMESSAGEKeyword_18()); 
                    }

                    }


                    }
                    break;
                case 20 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:856:6: ( 'NETWORKMESSAGE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:856:6: ( 'NETWORKMESSAGE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:857:1: 'NETWORKMESSAGE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getNETWORKMESSAGEKeyword_19()); 
                    }
                    match(input,31,FollowSets000.FOLLOW_31_in_rule__SpecialId__Alternatives1835); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getNETWORKMESSAGEKeyword_19()); 
                    }

                    }


                    }
                    break;
                case 21 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:864:6: ( 'NM' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:864:6: ( 'NM' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:865:1: 'NM'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getNMKeyword_20()); 
                    }
                    match(input,32,FollowSets000.FOLLOW_32_in_rule__SpecialId__Alternatives1855); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getNMKeyword_20()); 
                    }

                    }


                    }
                    break;
                case 22 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:872:6: ( 'RESOURCE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:872:6: ( 'RESOURCE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:873:1: 'RESOURCE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getRESOURCEKeyword_21()); 
                    }
                    match(input,33,FollowSets000.FOLLOW_33_in_rule__SpecialId__Alternatives1875); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getRESOURCEKeyword_21()); 
                    }

                    }


                    }
                    break;
                case 23 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:880:6: ( 'TASK' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:880:6: ( 'TASK' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:881:1: 'TASK'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getTASKKeyword_22()); 
                    }
                    match(input,34,FollowSets000.FOLLOW_34_in_rule__SpecialId__Alternatives1895); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getTASKKeyword_22()); 
                    }

                    }


                    }
                    break;
                case 24 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:888:6: ( 'OS_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:888:6: ( 'OS_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:889:1: 'OS_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getOS_TYPEKeyword_23()); 
                    }
                    match(input,35,FollowSets000.FOLLOW_35_in_rule__SpecialId__Alternatives1915); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getOS_TYPEKeyword_23()); 
                    }

                    }


                    }
                    break;
                case 25 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:896:6: ( 'ALARM_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:896:6: ( 'ALARM_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:897:1: 'ALARM_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getALARM_TYPEKeyword_24()); 
                    }
                    match(input,36,FollowSets000.FOLLOW_36_in_rule__SpecialId__Alternatives1935); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getALARM_TYPEKeyword_24()); 
                    }

                    }


                    }
                    break;
                case 26 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:904:6: ( 'APPMODE_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:904:6: ( 'APPMODE_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:905:1: 'APPMODE_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getAPPMODE_TYPEKeyword_25()); 
                    }
                    match(input,37,FollowSets000.FOLLOW_37_in_rule__SpecialId__Alternatives1955); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getAPPMODE_TYPEKeyword_25()); 
                    }

                    }


                    }
                    break;
                case 27 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:912:6: ( 'COUNTER_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:912:6: ( 'COUNTER_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:913:1: 'COUNTER_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getCOUNTER_TYPEKeyword_26()); 
                    }
                    match(input,38,FollowSets000.FOLLOW_38_in_rule__SpecialId__Alternatives1975); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getCOUNTER_TYPEKeyword_26()); 
                    }

                    }


                    }
                    break;
                case 28 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:920:6: ( 'COM_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:920:6: ( 'COM_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:921:1: 'COM_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getCOM_TYPEKeyword_27()); 
                    }
                    match(input,39,FollowSets000.FOLLOW_39_in_rule__SpecialId__Alternatives1995); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getCOM_TYPEKeyword_27()); 
                    }

                    }


                    }
                    break;
                case 29 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:928:6: ( 'EVENT_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:928:6: ( 'EVENT_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:929:1: 'EVENT_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getEVENT_TYPEKeyword_28()); 
                    }
                    match(input,40,FollowSets000.FOLLOW_40_in_rule__SpecialId__Alternatives2015); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getEVENT_TYPEKeyword_28()); 
                    }

                    }


                    }
                    break;
                case 30 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:936:6: ( 'IPDU_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:936:6: ( 'IPDU_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:937:1: 'IPDU_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getIPDU_TYPEKeyword_29()); 
                    }
                    match(input,41,FollowSets000.FOLLOW_41_in_rule__SpecialId__Alternatives2035); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getIPDU_TYPEKeyword_29()); 
                    }

                    }


                    }
                    break;
                case 31 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:944:6: ( 'ISR_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:944:6: ( 'ISR_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:945:1: 'ISR_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getISR_TYPEKeyword_30()); 
                    }
                    match(input,42,FollowSets000.FOLLOW_42_in_rule__SpecialId__Alternatives2055); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getISR_TYPEKeyword_30()); 
                    }

                    }


                    }
                    break;
                case 32 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:952:6: ( 'MESSAGE_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:952:6: ( 'MESSAGE_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:953:1: 'MESSAGE_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getMESSAGE_TYPEKeyword_31()); 
                    }
                    match(input,43,FollowSets000.FOLLOW_43_in_rule__SpecialId__Alternatives2075); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getMESSAGE_TYPEKeyword_31()); 
                    }

                    }


                    }
                    break;
                case 33 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:960:6: ( 'NETWORKMESSAGE_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:960:6: ( 'NETWORKMESSAGE_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:961:1: 'NETWORKMESSAGE_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getNETWORKMESSAGE_TYPEKeyword_32()); 
                    }
                    match(input,44,FollowSets000.FOLLOW_44_in_rule__SpecialId__Alternatives2095); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getNETWORKMESSAGE_TYPEKeyword_32()); 
                    }

                    }


                    }
                    break;
                case 34 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:968:6: ( 'NM_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:968:6: ( 'NM_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:969:1: 'NM_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getNM_TYPEKeyword_33()); 
                    }
                    match(input,45,FollowSets000.FOLLOW_45_in_rule__SpecialId__Alternatives2115); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getNM_TYPEKeyword_33()); 
                    }

                    }


                    }
                    break;
                case 35 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:976:6: ( 'RESOURCE_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:976:6: ( 'RESOURCE_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:977:1: 'RESOURCE_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getRESOURCE_TYPEKeyword_34()); 
                    }
                    match(input,46,FollowSets000.FOLLOW_46_in_rule__SpecialId__Alternatives2135); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getRESOURCE_TYPEKeyword_34()); 
                    }

                    }


                    }
                    break;
                case 36 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:984:6: ( 'TASK_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:984:6: ( 'TASK_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:985:1: 'TASK_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getTASK_TYPEKeyword_35()); 
                    }
                    match(input,47,FollowSets000.FOLLOW_47_in_rule__SpecialId__Alternatives2155); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getTASK_TYPEKeyword_35()); 
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
    // $ANTLR end "rule__SpecialId__Alternatives"


    // $ANTLR start "rule__GenericValue__Alternatives"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:997:1: rule__GenericValue__Alternatives : ( ( RULE_STRING ) | ( ruleINT ) | ( ruleDOUBLE ) );
    public final void rule__GenericValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1001:1: ( ( RULE_STRING ) | ( ruleINT ) | ( ruleDOUBLE ) )
            int alt8=3;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1002:1: ( RULE_STRING )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1002:1: ( RULE_STRING )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1003:1: RULE_STRING
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getGenericValueAccess().getSTRINGTerminalRuleCall_0()); 
                    }
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__GenericValue__Alternatives2189); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getGenericValueAccess().getSTRINGTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1008:6: ( ruleINT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1008:6: ( ruleINT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1009:1: ruleINT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getGenericValueAccess().getINTParserRuleCall_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleINT_in_rule__GenericValue__Alternatives2206);
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1014:6: ( ruleDOUBLE )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1014:6: ( ruleDOUBLE )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1015:1: ruleDOUBLE
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getGenericValueAccess().getDOUBLEParserRuleCall_2()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleDOUBLE_in_rule__GenericValue__Alternatives2223);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1025:1: rule__INT__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__INT__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1029:1: ( ( '+' ) | ( '-' ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==48) ) {
                alt9=1;
            }
            else if ( (LA9_0==49) ) {
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1030:1: ( '+' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1030:1: ( '+' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1031:1: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getINTAccess().getPlusSignKeyword_0_0()); 
                    }
                    match(input,48,FollowSets000.FOLLOW_48_in_rule__INT__Alternatives_02256); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getINTAccess().getPlusSignKeyword_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1038:6: ( '-' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1038:6: ( '-' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1039:1: '-'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getINTAccess().getHyphenMinusKeyword_0_1()); 
                    }
                    match(input,49,FollowSets000.FOLLOW_49_in_rule__INT__Alternatives_02276); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1051:1: rule__INT__Alternatives_1 : ( ( ( rule__INT__Group_1_0__0 ) ) | ( RULE_ZERO_INT ) | ( RULE_HEX ) );
    public final void rule__INT__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1055:1: ( ( ( rule__INT__Group_1_0__0 ) ) | ( RULE_ZERO_INT ) | ( RULE_HEX ) )
            int alt10=3;
            switch ( input.LA(1) ) {
            case RULE_NON_ZERO_INT:
                {
                alt10=1;
                }
                break;
            case RULE_ZERO_INT:
                {
                alt10=2;
                }
                break;
            case RULE_HEX:
                {
                alt10=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1056:1: ( ( rule__INT__Group_1_0__0 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1056:1: ( ( rule__INT__Group_1_0__0 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1057:1: ( rule__INT__Group_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getINTAccess().getGroup_1_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1058:1: ( rule__INT__Group_1_0__0 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1058:2: rule__INT__Group_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__INT__Group_1_0__0_in_rule__INT__Alternatives_12310);
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1062:6: ( RULE_ZERO_INT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1062:6: ( RULE_ZERO_INT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1063:1: RULE_ZERO_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getINTAccess().getZERO_INTTerminalRuleCall_1_1()); 
                    }
                    match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_rule__INT__Alternatives_12328); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getINTAccess().getZERO_INTTerminalRuleCall_1_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1068:6: ( RULE_HEX )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1068:6: ( RULE_HEX )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1069:1: RULE_HEX
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getINTAccess().getHEXTerminalRuleCall_1_2()); 
                    }
                    match(input,RULE_HEX,FollowSets000.FOLLOW_RULE_HEX_in_rule__INT__Alternatives_12345); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getINTAccess().getHEXTerminalRuleCall_1_2()); 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1079:1: rule__INT__Alternatives_1_0_1 : ( ( RULE_ZERO_INT ) | ( RULE_NON_ZERO_INT ) );
    public final void rule__INT__Alternatives_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1083:1: ( ( RULE_ZERO_INT ) | ( RULE_NON_ZERO_INT ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ZERO_INT) ) {
                alt11=1;
            }
            else if ( (LA11_0==RULE_NON_ZERO_INT) ) {
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1084:1: ( RULE_ZERO_INT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1084:1: ( RULE_ZERO_INT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1085:1: RULE_ZERO_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getINTAccess().getZERO_INTTerminalRuleCall_1_0_1_0()); 
                    }
                    match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_rule__INT__Alternatives_1_0_12377); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getINTAccess().getZERO_INTTerminalRuleCall_1_0_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1090:6: ( RULE_NON_ZERO_INT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1090:6: ( RULE_NON_ZERO_INT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1091:1: RULE_NON_ZERO_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getINTAccess().getNON_ZERO_INTTerminalRuleCall_1_0_1_1()); 
                    }
                    match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_rule__INT__Alternatives_1_0_12394); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1101:1: rule__DOUBLE__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__DOUBLE__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1105:1: ( ( '+' ) | ( '-' ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==48) ) {
                alt12=1;
            }
            else if ( (LA12_0==49) ) {
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1106:1: ( '+' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1106:1: ( '+' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1107:1: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDOUBLEAccess().getPlusSignKeyword_0_0()); 
                    }
                    match(input,48,FollowSets000.FOLLOW_48_in_rule__DOUBLE__Alternatives_02427); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDOUBLEAccess().getPlusSignKeyword_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1114:6: ( '-' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1114:6: ( '-' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1115:1: '-'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDOUBLEAccess().getHyphenMinusKeyword_0_1()); 
                    }
                    match(input,49,FollowSets000.FOLLOW_49_in_rule__DOUBLE__Alternatives_02447); if (state.failed) return ;
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


    // $ANTLR start "rule__DOUBLE__Alternatives_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1127:1: rule__DOUBLE__Alternatives_1 : ( ( RULE_ZERO_INT ) | ( ( rule__DOUBLE__Group_1_1__0 ) ) );
    public final void rule__DOUBLE__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1131:1: ( ( RULE_ZERO_INT ) | ( ( rule__DOUBLE__Group_1_1__0 ) ) )
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1132:1: ( RULE_ZERO_INT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1132:1: ( RULE_ZERO_INT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1133:1: RULE_ZERO_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDOUBLEAccess().getZERO_INTTerminalRuleCall_1_0()); 
                    }
                    match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_rule__DOUBLE__Alternatives_12481); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDOUBLEAccess().getZERO_INTTerminalRuleCall_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1138:6: ( ( rule__DOUBLE__Group_1_1__0 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1138:6: ( ( rule__DOUBLE__Group_1_1__0 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1139:1: ( rule__DOUBLE__Group_1_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDOUBLEAccess().getGroup_1_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1140:1: ( rule__DOUBLE__Group_1_1__0 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1140:2: rule__DOUBLE__Group_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Group_1_1__0_in_rule__DOUBLE__Alternatives_12498);
                    rule__DOUBLE__Group_1_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDOUBLEAccess().getGroup_1_1()); 
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
    // $ANTLR end "rule__DOUBLE__Alternatives_1"


    // $ANTLR start "rule__DOUBLE__Alternatives_1_1_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1149:1: rule__DOUBLE__Alternatives_1_1_1 : ( ( RULE_ZERO_INT ) | ( RULE_NON_ZERO_INT ) );
    public final void rule__DOUBLE__Alternatives_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1153:1: ( ( RULE_ZERO_INT ) | ( RULE_NON_ZERO_INT ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ZERO_INT) ) {
                alt14=1;
            }
            else if ( (LA14_0==RULE_NON_ZERO_INT) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1154:1: ( RULE_ZERO_INT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1154:1: ( RULE_ZERO_INT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1155:1: RULE_ZERO_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDOUBLEAccess().getZERO_INTTerminalRuleCall_1_1_1_0()); 
                    }
                    match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_rule__DOUBLE__Alternatives_1_1_12531); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDOUBLEAccess().getZERO_INTTerminalRuleCall_1_1_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1160:6: ( RULE_NON_ZERO_INT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1160:6: ( RULE_NON_ZERO_INT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1161:1: RULE_NON_ZERO_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDOUBLEAccess().getNON_ZERO_INTTerminalRuleCall_1_1_1_1()); 
                    }
                    match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_rule__DOUBLE__Alternatives_1_1_12548); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDOUBLEAccess().getNON_ZERO_INTTerminalRuleCall_1_1_1_1()); 
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
    // $ANTLR end "rule__DOUBLE__Alternatives_1_1_1"


    // $ANTLR start "rule__DOUBLE__Alternatives_3"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1171:1: rule__DOUBLE__Alternatives_3 : ( ( RULE_ZERO_INT ) | ( RULE_NON_ZERO_INT ) );
    public final void rule__DOUBLE__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1175:1: ( ( RULE_ZERO_INT ) | ( RULE_NON_ZERO_INT ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_ZERO_INT) ) {
                alt15=1;
            }
            else if ( (LA15_0==RULE_NON_ZERO_INT) ) {
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1176:1: ( RULE_ZERO_INT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1176:1: ( RULE_ZERO_INT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1177:1: RULE_ZERO_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDOUBLEAccess().getZERO_INTTerminalRuleCall_3_0()); 
                    }
                    match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_rule__DOUBLE__Alternatives_32580); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDOUBLEAccess().getZERO_INTTerminalRuleCall_3_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1182:6: ( RULE_NON_ZERO_INT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1182:6: ( RULE_NON_ZERO_INT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1183:1: RULE_NON_ZERO_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDOUBLEAccess().getNON_ZERO_INTTerminalRuleCall_3_1()); 
                    }
                    match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_rule__DOUBLE__Alternatives_32597); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDOUBLEAccess().getNON_ZERO_INTTerminalRuleCall_3_1()); 
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
    // $ANTLR end "rule__DOUBLE__Alternatives_3"


    // $ANTLR start "rule__VType__Alternatives"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1193:1: rule__VType__Alternatives : ( ( ( 'STRING' ) ) | ( ( 'UINT32' ) ) | ( ( 'INT32' ) ) | ( ( 'UINT64' ) ) | ( ( 'INT64' ) ) | ( ( 'FLOAT' ) ) | ( ( 'DOUBLE' ) ) );
    public final void rule__VType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1197:1: ( ( ( 'STRING' ) ) | ( ( 'UINT32' ) ) | ( ( 'INT32' ) ) | ( ( 'UINT64' ) ) | ( ( 'INT64' ) ) | ( ( 'FLOAT' ) ) | ( ( 'DOUBLE' ) ) )
            int alt16=7;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt16=1;
                }
                break;
            case 14:
                {
                alt16=2;
                }
                break;
            case 15:
                {
                alt16=3;
                }
                break;
            case 16:
                {
                alt16=4;
                }
                break;
            case 17:
                {
                alt16=5;
                }
                break;
            case 18:
                {
                alt16=6;
                }
                break;
            case 19:
                {
                alt16=7;
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1198:1: ( ( 'STRING' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1198:1: ( ( 'STRING' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1199:1: ( 'STRING' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVTypeAccess().getSTRINGEnumLiteralDeclaration_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1200:1: ( 'STRING' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1200:3: 'STRING'
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__VType__Alternatives2630); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVTypeAccess().getSTRINGEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1205:6: ( ( 'UINT32' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1205:6: ( ( 'UINT32' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1206:1: ( 'UINT32' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVTypeAccess().getUINT32EnumLiteralDeclaration_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1207:1: ( 'UINT32' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1207:3: 'UINT32'
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_rule__VType__Alternatives2651); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVTypeAccess().getUINT32EnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1212:6: ( ( 'INT32' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1212:6: ( ( 'INT32' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1213:1: ( 'INT32' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVTypeAccess().getINT32EnumLiteralDeclaration_2()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1214:1: ( 'INT32' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1214:3: 'INT32'
                    {
                    match(input,15,FollowSets000.FOLLOW_15_in_rule__VType__Alternatives2672); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVTypeAccess().getINT32EnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1219:6: ( ( 'UINT64' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1219:6: ( ( 'UINT64' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1220:1: ( 'UINT64' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVTypeAccess().getUINT64EnumLiteralDeclaration_3()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1221:1: ( 'UINT64' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1221:3: 'UINT64'
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__VType__Alternatives2693); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVTypeAccess().getUINT64EnumLiteralDeclaration_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1226:6: ( ( 'INT64' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1226:6: ( ( 'INT64' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1227:1: ( 'INT64' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVTypeAccess().getINT64EnumLiteralDeclaration_4()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1228:1: ( 'INT64' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1228:3: 'INT64'
                    {
                    match(input,17,FollowSets000.FOLLOW_17_in_rule__VType__Alternatives2714); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVTypeAccess().getINT64EnumLiteralDeclaration_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1233:6: ( ( 'FLOAT' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1233:6: ( ( 'FLOAT' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1234:1: ( 'FLOAT' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVTypeAccess().getFLOATEnumLiteralDeclaration_5()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1235:1: ( 'FLOAT' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1235:3: 'FLOAT'
                    {
                    match(input,18,FollowSets000.FOLLOW_18_in_rule__VType__Alternatives2735); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVTypeAccess().getFLOATEnumLiteralDeclaration_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1240:6: ( ( 'DOUBLE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1240:6: ( ( 'DOUBLE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1241:1: ( 'DOUBLE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVTypeAccess().getDOUBLEEnumLiteralDeclaration_6()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1242:1: ( 'DOUBLE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1242:3: 'DOUBLE'
                    {
                    match(input,19,FollowSets000.FOLLOW_19_in_rule__VType__Alternatives2756); if (state.failed) return ;

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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1252:1: rule__EType__Alternatives : ( ( ( 'BOOLEAN' ) ) | ( ( 'ENUM' ) ) );
    public final void rule__EType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1256:1: ( ( ( 'BOOLEAN' ) ) | ( ( 'ENUM' ) ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==20) ) {
                alt17=1;
            }
            else if ( (LA17_0==21) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1257:1: ( ( 'BOOLEAN' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1257:1: ( ( 'BOOLEAN' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1258:1: ( 'BOOLEAN' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getETypeAccess().getBOOLEANEnumLiteralDeclaration_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1259:1: ( 'BOOLEAN' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1259:3: 'BOOLEAN'
                    {
                    match(input,20,FollowSets000.FOLLOW_20_in_rule__EType__Alternatives2792); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getETypeAccess().getBOOLEANEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1264:6: ( ( 'ENUM' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1264:6: ( ( 'ENUM' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1265:1: ( 'ENUM' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getETypeAccess().getENUMEnumLiteralDeclaration_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1266:1: ( 'ENUM' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1266:3: 'ENUM'
                    {
                    match(input,21,FollowSets000.FOLLOW_21_in_rule__EType__Alternatives2813); if (state.failed) return ;

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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1276:1: rule__ObjectType__Alternatives : ( ( ( 'OS' ) ) | ( ( 'ALARM' ) ) | ( ( 'APPMODE' ) ) | ( ( 'COUNTER' ) ) | ( ( 'COM' ) ) | ( ( 'EVENT' ) ) | ( ( 'IPDU' ) ) | ( ( 'ISR' ) ) | ( ( 'MESSAGE' ) ) | ( ( 'NETWORKMESSAGE' ) ) | ( ( 'NM' ) ) | ( ( 'RESOURCE' ) ) | ( ( 'TASK' ) ) );
    public final void rule__ObjectType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1280:1: ( ( ( 'OS' ) ) | ( ( 'ALARM' ) ) | ( ( 'APPMODE' ) ) | ( ( 'COUNTER' ) ) | ( ( 'COM' ) ) | ( ( 'EVENT' ) ) | ( ( 'IPDU' ) ) | ( ( 'ISR' ) ) | ( ( 'MESSAGE' ) ) | ( ( 'NETWORKMESSAGE' ) ) | ( ( 'NM' ) ) | ( ( 'RESOURCE' ) ) | ( ( 'TASK' ) ) )
            int alt18=13;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt18=1;
                }
                break;
            case 23:
                {
                alt18=2;
                }
                break;
            case 24:
                {
                alt18=3;
                }
                break;
            case 25:
                {
                alt18=4;
                }
                break;
            case 26:
                {
                alt18=5;
                }
                break;
            case 27:
                {
                alt18=6;
                }
                break;
            case 28:
                {
                alt18=7;
                }
                break;
            case 29:
                {
                alt18=8;
                }
                break;
            case 30:
                {
                alt18=9;
                }
                break;
            case 31:
                {
                alt18=10;
                }
                break;
            case 32:
                {
                alt18=11;
                }
                break;
            case 33:
                {
                alt18=12;
                }
                break;
            case 34:
                {
                alt18=13;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1281:1: ( ( 'OS' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1281:1: ( ( 'OS' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1282:1: ( 'OS' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getOSEnumLiteralDeclaration_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1283:1: ( 'OS' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1283:3: 'OS'
                    {
                    match(input,22,FollowSets000.FOLLOW_22_in_rule__ObjectType__Alternatives2849); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getOSEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1288:6: ( ( 'ALARM' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1288:6: ( ( 'ALARM' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1289:1: ( 'ALARM' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getALARMEnumLiteralDeclaration_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1290:1: ( 'ALARM' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1290:3: 'ALARM'
                    {
                    match(input,23,FollowSets000.FOLLOW_23_in_rule__ObjectType__Alternatives2870); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getALARMEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1295:6: ( ( 'APPMODE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1295:6: ( ( 'APPMODE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1296:1: ( 'APPMODE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getAPPMODEEnumLiteralDeclaration_2()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1297:1: ( 'APPMODE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1297:3: 'APPMODE'
                    {
                    match(input,24,FollowSets000.FOLLOW_24_in_rule__ObjectType__Alternatives2891); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getAPPMODEEnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1302:6: ( ( 'COUNTER' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1302:6: ( ( 'COUNTER' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1303:1: ( 'COUNTER' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getCOUNTEREnumLiteralDeclaration_3()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1304:1: ( 'COUNTER' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1304:3: 'COUNTER'
                    {
                    match(input,25,FollowSets000.FOLLOW_25_in_rule__ObjectType__Alternatives2912); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getCOUNTEREnumLiteralDeclaration_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1309:6: ( ( 'COM' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1309:6: ( ( 'COM' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1310:1: ( 'COM' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getCOMEnumLiteralDeclaration_4()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1311:1: ( 'COM' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1311:3: 'COM'
                    {
                    match(input,26,FollowSets000.FOLLOW_26_in_rule__ObjectType__Alternatives2933); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getCOMEnumLiteralDeclaration_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1316:6: ( ( 'EVENT' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1316:6: ( ( 'EVENT' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1317:1: ( 'EVENT' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getEVENTEnumLiteralDeclaration_5()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1318:1: ( 'EVENT' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1318:3: 'EVENT'
                    {
                    match(input,27,FollowSets000.FOLLOW_27_in_rule__ObjectType__Alternatives2954); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getEVENTEnumLiteralDeclaration_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1323:6: ( ( 'IPDU' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1323:6: ( ( 'IPDU' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1324:1: ( 'IPDU' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getIPDUEnumLiteralDeclaration_6()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1325:1: ( 'IPDU' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1325:3: 'IPDU'
                    {
                    match(input,28,FollowSets000.FOLLOW_28_in_rule__ObjectType__Alternatives2975); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getIPDUEnumLiteralDeclaration_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1330:6: ( ( 'ISR' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1330:6: ( ( 'ISR' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1331:1: ( 'ISR' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getISREnumLiteralDeclaration_7()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1332:1: ( 'ISR' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1332:3: 'ISR'
                    {
                    match(input,29,FollowSets000.FOLLOW_29_in_rule__ObjectType__Alternatives2996); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getISREnumLiteralDeclaration_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1337:6: ( ( 'MESSAGE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1337:6: ( ( 'MESSAGE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1338:1: ( 'MESSAGE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getMESSAGEEnumLiteralDeclaration_8()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1339:1: ( 'MESSAGE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1339:3: 'MESSAGE'
                    {
                    match(input,30,FollowSets000.FOLLOW_30_in_rule__ObjectType__Alternatives3017); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getMESSAGEEnumLiteralDeclaration_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1344:6: ( ( 'NETWORKMESSAGE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1344:6: ( ( 'NETWORKMESSAGE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1345:1: ( 'NETWORKMESSAGE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getNETWORKMESSAGEEnumLiteralDeclaration_9()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1346:1: ( 'NETWORKMESSAGE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1346:3: 'NETWORKMESSAGE'
                    {
                    match(input,31,FollowSets000.FOLLOW_31_in_rule__ObjectType__Alternatives3038); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getNETWORKMESSAGEEnumLiteralDeclaration_9()); 
                    }

                    }


                    }
                    break;
                case 11 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1351:6: ( ( 'NM' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1351:6: ( ( 'NM' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1352:1: ( 'NM' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getNMEnumLiteralDeclaration_10()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1353:1: ( 'NM' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1353:3: 'NM'
                    {
                    match(input,32,FollowSets000.FOLLOW_32_in_rule__ObjectType__Alternatives3059); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getNMEnumLiteralDeclaration_10()); 
                    }

                    }


                    }
                    break;
                case 12 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1358:6: ( ( 'RESOURCE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1358:6: ( ( 'RESOURCE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1359:1: ( 'RESOURCE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getRESOURCEEnumLiteralDeclaration_11()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1360:1: ( 'RESOURCE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1360:3: 'RESOURCE'
                    {
                    match(input,33,FollowSets000.FOLLOW_33_in_rule__ObjectType__Alternatives3080); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getRESOURCEEnumLiteralDeclaration_11()); 
                    }

                    }


                    }
                    break;
                case 13 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1365:6: ( ( 'TASK' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1365:6: ( ( 'TASK' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1366:1: ( 'TASK' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getTASKEnumLiteralDeclaration_12()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1367:1: ( 'TASK' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1367:3: 'TASK'
                    {
                    match(input,34,FollowSets000.FOLLOW_34_in_rule__ObjectType__Alternatives3101); if (state.failed) return ;

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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1377:1: rule__ObjectTypeRef__Alternatives : ( ( ( 'OS_TYPE' ) ) | ( ( 'ALARM_TYPE' ) ) | ( ( 'APPMODE_TYPE' ) ) | ( ( 'COUNTER_TYPE' ) ) | ( ( 'COM_TYPE' ) ) | ( ( 'EVENT_TYPE' ) ) | ( ( 'IPDU_TYPE' ) ) | ( ( 'ISR_TYPE' ) ) | ( ( 'MESSAGE_TYPE' ) ) | ( ( 'NETWORKMESSAGE_TYPE' ) ) | ( ( 'NM_TYPE' ) ) | ( ( 'RESOURCE_TYPE' ) ) | ( ( 'TASK_TYPE' ) ) );
    public final void rule__ObjectTypeRef__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1381:1: ( ( ( 'OS_TYPE' ) ) | ( ( 'ALARM_TYPE' ) ) | ( ( 'APPMODE_TYPE' ) ) | ( ( 'COUNTER_TYPE' ) ) | ( ( 'COM_TYPE' ) ) | ( ( 'EVENT_TYPE' ) ) | ( ( 'IPDU_TYPE' ) ) | ( ( 'ISR_TYPE' ) ) | ( ( 'MESSAGE_TYPE' ) ) | ( ( 'NETWORKMESSAGE_TYPE' ) ) | ( ( 'NM_TYPE' ) ) | ( ( 'RESOURCE_TYPE' ) ) | ( ( 'TASK_TYPE' ) ) )
            int alt19=13;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt19=1;
                }
                break;
            case 36:
                {
                alt19=2;
                }
                break;
            case 37:
                {
                alt19=3;
                }
                break;
            case 38:
                {
                alt19=4;
                }
                break;
            case 39:
                {
                alt19=5;
                }
                break;
            case 40:
                {
                alt19=6;
                }
                break;
            case 41:
                {
                alt19=7;
                }
                break;
            case 42:
                {
                alt19=8;
                }
                break;
            case 43:
                {
                alt19=9;
                }
                break;
            case 44:
                {
                alt19=10;
                }
                break;
            case 45:
                {
                alt19=11;
                }
                break;
            case 46:
                {
                alt19=12;
                }
                break;
            case 47:
                {
                alt19=13;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1382:1: ( ( 'OS_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1382:1: ( ( 'OS_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1383:1: ( 'OS_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getOSEnumLiteralDeclaration_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1384:1: ( 'OS_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1384:3: 'OS_TYPE'
                    {
                    match(input,35,FollowSets000.FOLLOW_35_in_rule__ObjectTypeRef__Alternatives3137); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getOSEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1389:6: ( ( 'ALARM_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1389:6: ( ( 'ALARM_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1390:1: ( 'ALARM_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getALARMEnumLiteralDeclaration_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1391:1: ( 'ALARM_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1391:3: 'ALARM_TYPE'
                    {
                    match(input,36,FollowSets000.FOLLOW_36_in_rule__ObjectTypeRef__Alternatives3158); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getALARMEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1396:6: ( ( 'APPMODE_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1396:6: ( ( 'APPMODE_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1397:1: ( 'APPMODE_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getAPPMODEEnumLiteralDeclaration_2()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1398:1: ( 'APPMODE_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1398:3: 'APPMODE_TYPE'
                    {
                    match(input,37,FollowSets000.FOLLOW_37_in_rule__ObjectTypeRef__Alternatives3179); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getAPPMODEEnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1403:6: ( ( 'COUNTER_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1403:6: ( ( 'COUNTER_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1404:1: ( 'COUNTER_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getCOUNTEREnumLiteralDeclaration_3()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1405:1: ( 'COUNTER_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1405:3: 'COUNTER_TYPE'
                    {
                    match(input,38,FollowSets000.FOLLOW_38_in_rule__ObjectTypeRef__Alternatives3200); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getCOUNTEREnumLiteralDeclaration_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1410:6: ( ( 'COM_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1410:6: ( ( 'COM_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1411:1: ( 'COM_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getCOMEnumLiteralDeclaration_4()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1412:1: ( 'COM_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1412:3: 'COM_TYPE'
                    {
                    match(input,39,FollowSets000.FOLLOW_39_in_rule__ObjectTypeRef__Alternatives3221); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getCOMEnumLiteralDeclaration_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1417:6: ( ( 'EVENT_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1417:6: ( ( 'EVENT_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1418:1: ( 'EVENT_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getEVENTEnumLiteralDeclaration_5()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1419:1: ( 'EVENT_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1419:3: 'EVENT_TYPE'
                    {
                    match(input,40,FollowSets000.FOLLOW_40_in_rule__ObjectTypeRef__Alternatives3242); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getEVENTEnumLiteralDeclaration_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1424:6: ( ( 'IPDU_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1424:6: ( ( 'IPDU_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1425:1: ( 'IPDU_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getIPDUEnumLiteralDeclaration_6()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1426:1: ( 'IPDU_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1426:3: 'IPDU_TYPE'
                    {
                    match(input,41,FollowSets000.FOLLOW_41_in_rule__ObjectTypeRef__Alternatives3263); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getIPDUEnumLiteralDeclaration_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1431:6: ( ( 'ISR_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1431:6: ( ( 'ISR_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1432:1: ( 'ISR_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getISREnumLiteralDeclaration_7()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1433:1: ( 'ISR_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1433:3: 'ISR_TYPE'
                    {
                    match(input,42,FollowSets000.FOLLOW_42_in_rule__ObjectTypeRef__Alternatives3284); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getISREnumLiteralDeclaration_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1438:6: ( ( 'MESSAGE_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1438:6: ( ( 'MESSAGE_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1439:1: ( 'MESSAGE_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getMESSAGEEnumLiteralDeclaration_8()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1440:1: ( 'MESSAGE_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1440:3: 'MESSAGE_TYPE'
                    {
                    match(input,43,FollowSets000.FOLLOW_43_in_rule__ObjectTypeRef__Alternatives3305); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getMESSAGEEnumLiteralDeclaration_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1445:6: ( ( 'NETWORKMESSAGE_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1445:6: ( ( 'NETWORKMESSAGE_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1446:1: ( 'NETWORKMESSAGE_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getNETWORKMESSAGEEnumLiteralDeclaration_9()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1447:1: ( 'NETWORKMESSAGE_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1447:3: 'NETWORKMESSAGE_TYPE'
                    {
                    match(input,44,FollowSets000.FOLLOW_44_in_rule__ObjectTypeRef__Alternatives3326); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getNETWORKMESSAGEEnumLiteralDeclaration_9()); 
                    }

                    }


                    }
                    break;
                case 11 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1452:6: ( ( 'NM_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1452:6: ( ( 'NM_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1453:1: ( 'NM_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getNMEnumLiteralDeclaration_10()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1454:1: ( 'NM_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1454:3: 'NM_TYPE'
                    {
                    match(input,45,FollowSets000.FOLLOW_45_in_rule__ObjectTypeRef__Alternatives3347); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getNMEnumLiteralDeclaration_10()); 
                    }

                    }


                    }
                    break;
                case 12 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1459:6: ( ( 'RESOURCE_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1459:6: ( ( 'RESOURCE_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1460:1: ( 'RESOURCE_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getRESOURCEEnumLiteralDeclaration_11()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1461:1: ( 'RESOURCE_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1461:3: 'RESOURCE_TYPE'
                    {
                    match(input,46,FollowSets000.FOLLOW_46_in_rule__ObjectTypeRef__Alternatives3368); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getRESOURCEEnumLiteralDeclaration_11()); 
                    }

                    }


                    }
                    break;
                case 13 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1466:6: ( ( 'TASK_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1466:6: ( ( 'TASK_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1467:1: ( 'TASK_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getTASKEnumLiteralDeclaration_12()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1468:1: ( 'TASK_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1468:3: 'TASK_TYPE'
                    {
                    match(input,47,FollowSets000.FOLLOW_47_in_rule__ObjectTypeRef__Alternatives3389); if (state.failed) return ;

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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1480:1: rule__OilFile__Group__0 : rule__OilFile__Group__0__Impl rule__OilFile__Group__1 ;
    public final void rule__OilFile__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1484:1: ( rule__OilFile__Group__0__Impl rule__OilFile__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1485:2: rule__OilFile__Group__0__Impl rule__OilFile__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group__0__Impl_in_rule__OilFile__Group__03422);
            rule__OilFile__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group__1_in_rule__OilFile__Group__03425);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1492:1: rule__OilFile__Group__0__Impl : ( () ) ;
    public final void rule__OilFile__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1496:1: ( ( () ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1497:1: ( () )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1497:1: ( () )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1498:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getOilFileAction_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1499:1: ()
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1501:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilFileAccess().getOilFileAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilFile__Group__0__Impl"


    // $ANTLR start "rule__OilFile__Group__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1511:1: rule__OilFile__Group__1 : rule__OilFile__Group__1__Impl rule__OilFile__Group__2 ;
    public final void rule__OilFile__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1515:1: ( rule__OilFile__Group__1__Impl rule__OilFile__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1516:2: rule__OilFile__Group__1__Impl rule__OilFile__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group__1__Impl_in_rule__OilFile__Group__13483);
            rule__OilFile__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group__2_in_rule__OilFile__Group__13486);
            rule__OilFile__Group__2();

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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1523:1: rule__OilFile__Group__1__Impl : ( ( rule__OilFile__Group_1__0 )? ) ;
    public final void rule__OilFile__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1527:1: ( ( ( rule__OilFile__Group_1__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1528:1: ( ( rule__OilFile__Group_1__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1528:1: ( ( rule__OilFile__Group_1__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1529:1: ( rule__OilFile__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getGroup_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1530:1: ( rule__OilFile__Group_1__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==50) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1530:2: rule__OilFile__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group_1__0_in_rule__OilFile__Group__1__Impl3513);
                    rule__OilFile__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilFileAccess().getGroup_1()); 
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


    // $ANTLR start "rule__OilFile__Group__2"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1540:1: rule__OilFile__Group__2 : rule__OilFile__Group__2__Impl rule__OilFile__Group__3 ;
    public final void rule__OilFile__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1544:1: ( rule__OilFile__Group__2__Impl rule__OilFile__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1545:2: rule__OilFile__Group__2__Impl rule__OilFile__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group__2__Impl_in_rule__OilFile__Group__23544);
            rule__OilFile__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group__3_in_rule__OilFile__Group__23547);
            rule__OilFile__Group__3();

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
    // $ANTLR end "rule__OilFile__Group__2"


    // $ANTLR start "rule__OilFile__Group__2__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1552:1: rule__OilFile__Group__2__Impl : ( ( rule__OilFile__ImplementationAssignment_2 )? ) ;
    public final void rule__OilFile__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1556:1: ( ( ( rule__OilFile__ImplementationAssignment_2 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1557:1: ( ( rule__OilFile__ImplementationAssignment_2 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1557:1: ( ( rule__OilFile__ImplementationAssignment_2 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1558:1: ( rule__OilFile__ImplementationAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getImplementationAssignment_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1559:1: ( rule__OilFile__ImplementationAssignment_2 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==53) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1559:2: rule__OilFile__ImplementationAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__OilFile__ImplementationAssignment_2_in_rule__OilFile__Group__2__Impl3574);
                    rule__OilFile__ImplementationAssignment_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilFileAccess().getImplementationAssignment_2()); 
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
    // $ANTLR end "rule__OilFile__Group__2__Impl"


    // $ANTLR start "rule__OilFile__Group__3"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1569:1: rule__OilFile__Group__3 : rule__OilFile__Group__3__Impl ;
    public final void rule__OilFile__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1573:1: ( rule__OilFile__Group__3__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1574:2: rule__OilFile__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group__3__Impl_in_rule__OilFile__Group__33605);
            rule__OilFile__Group__3__Impl();

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
    // $ANTLR end "rule__OilFile__Group__3"


    // $ANTLR start "rule__OilFile__Group__3__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1580:1: rule__OilFile__Group__3__Impl : ( ( rule__OilFile__ApplicationAssignment_3 )? ) ;
    public final void rule__OilFile__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1584:1: ( ( ( rule__OilFile__ApplicationAssignment_3 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1585:1: ( ( rule__OilFile__ApplicationAssignment_3 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1585:1: ( ( rule__OilFile__ApplicationAssignment_3 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1586:1: ( rule__OilFile__ApplicationAssignment_3 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getApplicationAssignment_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1587:1: ( rule__OilFile__ApplicationAssignment_3 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==57) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1587:2: rule__OilFile__ApplicationAssignment_3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__OilFile__ApplicationAssignment_3_in_rule__OilFile__Group__3__Impl3632);
                    rule__OilFile__ApplicationAssignment_3();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilFileAccess().getApplicationAssignment_3()); 
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
    // $ANTLR end "rule__OilFile__Group__3__Impl"


    // $ANTLR start "rule__OilFile__Group_1__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1605:1: rule__OilFile__Group_1__0 : rule__OilFile__Group_1__0__Impl rule__OilFile__Group_1__1 ;
    public final void rule__OilFile__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1609:1: ( rule__OilFile__Group_1__0__Impl rule__OilFile__Group_1__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1610:2: rule__OilFile__Group_1__0__Impl rule__OilFile__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group_1__0__Impl_in_rule__OilFile__Group_1__03671);
            rule__OilFile__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group_1__1_in_rule__OilFile__Group_1__03674);
            rule__OilFile__Group_1__1();

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
    // $ANTLR end "rule__OilFile__Group_1__0"


    // $ANTLR start "rule__OilFile__Group_1__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1617:1: rule__OilFile__Group_1__0__Impl : ( 'OIL_VERSION' ) ;
    public final void rule__OilFile__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1621:1: ( ( 'OIL_VERSION' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1622:1: ( 'OIL_VERSION' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1622:1: ( 'OIL_VERSION' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1623:1: 'OIL_VERSION'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getOIL_VERSIONKeyword_1_0()); 
            }
            match(input,50,FollowSets000.FOLLOW_50_in_rule__OilFile__Group_1__0__Impl3702); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilFileAccess().getOIL_VERSIONKeyword_1_0()); 
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
    // $ANTLR end "rule__OilFile__Group_1__0__Impl"


    // $ANTLR start "rule__OilFile__Group_1__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1636:1: rule__OilFile__Group_1__1 : rule__OilFile__Group_1__1__Impl rule__OilFile__Group_1__2 ;
    public final void rule__OilFile__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1640:1: ( rule__OilFile__Group_1__1__Impl rule__OilFile__Group_1__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1641:2: rule__OilFile__Group_1__1__Impl rule__OilFile__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group_1__1__Impl_in_rule__OilFile__Group_1__13733);
            rule__OilFile__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group_1__2_in_rule__OilFile__Group_1__13736);
            rule__OilFile__Group_1__2();

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
    // $ANTLR end "rule__OilFile__Group_1__1"


    // $ANTLR start "rule__OilFile__Group_1__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1648:1: rule__OilFile__Group_1__1__Impl : ( '=' ) ;
    public final void rule__OilFile__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1652:1: ( ( '=' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1653:1: ( '=' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1653:1: ( '=' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1654:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getEqualsSignKeyword_1_1()); 
            }
            match(input,51,FollowSets000.FOLLOW_51_in_rule__OilFile__Group_1__1__Impl3764); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilFileAccess().getEqualsSignKeyword_1_1()); 
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
    // $ANTLR end "rule__OilFile__Group_1__1__Impl"


    // $ANTLR start "rule__OilFile__Group_1__2"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1667:1: rule__OilFile__Group_1__2 : rule__OilFile__Group_1__2__Impl rule__OilFile__Group_1__3 ;
    public final void rule__OilFile__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1671:1: ( rule__OilFile__Group_1__2__Impl rule__OilFile__Group_1__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1672:2: rule__OilFile__Group_1__2__Impl rule__OilFile__Group_1__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group_1__2__Impl_in_rule__OilFile__Group_1__23795);
            rule__OilFile__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group_1__3_in_rule__OilFile__Group_1__23798);
            rule__OilFile__Group_1__3();

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
    // $ANTLR end "rule__OilFile__Group_1__2"


    // $ANTLR start "rule__OilFile__Group_1__2__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1679:1: rule__OilFile__Group_1__2__Impl : ( ( rule__OilFile__OilVersionAssignment_1_2 ) ) ;
    public final void rule__OilFile__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1683:1: ( ( ( rule__OilFile__OilVersionAssignment_1_2 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1684:1: ( ( rule__OilFile__OilVersionAssignment_1_2 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1684:1: ( ( rule__OilFile__OilVersionAssignment_1_2 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1685:1: ( rule__OilFile__OilVersionAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getOilVersionAssignment_1_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1686:1: ( rule__OilFile__OilVersionAssignment_1_2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1686:2: rule__OilFile__OilVersionAssignment_1_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__OilVersionAssignment_1_2_in_rule__OilFile__Group_1__2__Impl3825);
            rule__OilFile__OilVersionAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilFileAccess().getOilVersionAssignment_1_2()); 
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
    // $ANTLR end "rule__OilFile__Group_1__2__Impl"


    // $ANTLR start "rule__OilFile__Group_1__3"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1696:1: rule__OilFile__Group_1__3 : rule__OilFile__Group_1__3__Impl ;
    public final void rule__OilFile__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1700:1: ( rule__OilFile__Group_1__3__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1701:2: rule__OilFile__Group_1__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group_1__3__Impl_in_rule__OilFile__Group_1__33855);
            rule__OilFile__Group_1__3__Impl();

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
    // $ANTLR end "rule__OilFile__Group_1__3"


    // $ANTLR start "rule__OilFile__Group_1__3__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1707:1: rule__OilFile__Group_1__3__Impl : ( ';' ) ;
    public final void rule__OilFile__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1711:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1712:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1712:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1713:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getSemicolonKeyword_1_3()); 
            }
            match(input,52,FollowSets000.FOLLOW_52_in_rule__OilFile__Group_1__3__Impl3883); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilFileAccess().getSemicolonKeyword_1_3()); 
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
    // $ANTLR end "rule__OilFile__Group_1__3__Impl"


    // $ANTLR start "rule__OilImplementation__Group__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1734:1: rule__OilImplementation__Group__0 : rule__OilImplementation__Group__0__Impl rule__OilImplementation__Group__1 ;
    public final void rule__OilImplementation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1738:1: ( rule__OilImplementation__Group__0__Impl rule__OilImplementation__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1739:2: rule__OilImplementation__Group__0__Impl rule__OilImplementation__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__0__Impl_in_rule__OilImplementation__Group__03922);
            rule__OilImplementation__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__1_in_rule__OilImplementation__Group__03925);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1746:1: rule__OilImplementation__Group__0__Impl : ( 'IMPLEMENTATION' ) ;
    public final void rule__OilImplementation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1750:1: ( ( 'IMPLEMENTATION' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1751:1: ( 'IMPLEMENTATION' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1751:1: ( 'IMPLEMENTATION' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1752:1: 'IMPLEMENTATION'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getIMPLEMENTATIONKeyword_0()); 
            }
            match(input,53,FollowSets000.FOLLOW_53_in_rule__OilImplementation__Group__0__Impl3953); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1765:1: rule__OilImplementation__Group__1 : rule__OilImplementation__Group__1__Impl rule__OilImplementation__Group__2 ;
    public final void rule__OilImplementation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1769:1: ( rule__OilImplementation__Group__1__Impl rule__OilImplementation__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1770:2: rule__OilImplementation__Group__1__Impl rule__OilImplementation__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__1__Impl_in_rule__OilImplementation__Group__13984);
            rule__OilImplementation__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__2_in_rule__OilImplementation__Group__13987);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1777:1: rule__OilImplementation__Group__1__Impl : ( ( rule__OilImplementation__NameAssignment_1 ) ) ;
    public final void rule__OilImplementation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1781:1: ( ( ( rule__OilImplementation__NameAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1782:1: ( ( rule__OilImplementation__NameAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1782:1: ( ( rule__OilImplementation__NameAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1783:1: ( rule__OilImplementation__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getNameAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1784:1: ( rule__OilImplementation__NameAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1784:2: rule__OilImplementation__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__NameAssignment_1_in_rule__OilImplementation__Group__1__Impl4014);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1794:1: rule__OilImplementation__Group__2 : rule__OilImplementation__Group__2__Impl rule__OilImplementation__Group__3 ;
    public final void rule__OilImplementation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1798:1: ( rule__OilImplementation__Group__2__Impl rule__OilImplementation__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1799:2: rule__OilImplementation__Group__2__Impl rule__OilImplementation__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__2__Impl_in_rule__OilImplementation__Group__24044);
            rule__OilImplementation__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__3_in_rule__OilImplementation__Group__24047);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1806:1: rule__OilImplementation__Group__2__Impl : ( '{' ) ;
    public final void rule__OilImplementation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1810:1: ( ( '{' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1811:1: ( '{' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1811:1: ( '{' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1812:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,54,FollowSets000.FOLLOW_54_in_rule__OilImplementation__Group__2__Impl4075); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1825:1: rule__OilImplementation__Group__3 : rule__OilImplementation__Group__3__Impl rule__OilImplementation__Group__4 ;
    public final void rule__OilImplementation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1829:1: ( rule__OilImplementation__Group__3__Impl rule__OilImplementation__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1830:2: rule__OilImplementation__Group__3__Impl rule__OilImplementation__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__3__Impl_in_rule__OilImplementation__Group__34106);
            rule__OilImplementation__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__4_in_rule__OilImplementation__Group__34109);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1837:1: rule__OilImplementation__Group__3__Impl : ( ( rule__OilImplementation__OilObjectsAssignment_3 )* ) ;
    public final void rule__OilImplementation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1841:1: ( ( ( rule__OilImplementation__OilObjectsAssignment_3 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1842:1: ( ( rule__OilImplementation__OilObjectsAssignment_3 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1842:1: ( ( rule__OilImplementation__OilObjectsAssignment_3 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1843:1: ( rule__OilImplementation__OilObjectsAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getOilObjectsAssignment_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1844:1: ( rule__OilImplementation__OilObjectsAssignment_3 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=22 && LA23_0<=34)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1844:2: rule__OilImplementation__OilObjectsAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__OilObjectsAssignment_3_in_rule__OilImplementation__Group__3__Impl4136);
            	    rule__OilImplementation__OilObjectsAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop23;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1854:1: rule__OilImplementation__Group__4 : rule__OilImplementation__Group__4__Impl rule__OilImplementation__Group__5 ;
    public final void rule__OilImplementation__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1858:1: ( rule__OilImplementation__Group__4__Impl rule__OilImplementation__Group__5 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1859:2: rule__OilImplementation__Group__4__Impl rule__OilImplementation__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__4__Impl_in_rule__OilImplementation__Group__44167);
            rule__OilImplementation__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__5_in_rule__OilImplementation__Group__44170);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1866:1: rule__OilImplementation__Group__4__Impl : ( '}' ) ;
    public final void rule__OilImplementation__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1870:1: ( ( '}' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1871:1: ( '}' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1871:1: ( '}' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1872:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,55,FollowSets000.FOLLOW_55_in_rule__OilImplementation__Group__4__Impl4198); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1885:1: rule__OilImplementation__Group__5 : rule__OilImplementation__Group__5__Impl ;
    public final void rule__OilImplementation__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1889:1: ( rule__OilImplementation__Group__5__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1890:2: rule__OilImplementation__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__5__Impl_in_rule__OilImplementation__Group__54229);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1896:1: rule__OilImplementation__Group__5__Impl : ( ';' ) ;
    public final void rule__OilImplementation__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1900:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1901:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1901:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1902:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getSemicolonKeyword_5()); 
            }
            match(input,52,FollowSets000.FOLLOW_52_in_rule__OilImplementation__Group__5__Impl4257); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1927:1: rule__OilObjectImpl__Group__0 : rule__OilObjectImpl__Group__0__Impl rule__OilObjectImpl__Group__1 ;
    public final void rule__OilObjectImpl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1931:1: ( rule__OilObjectImpl__Group__0__Impl rule__OilObjectImpl__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1932:2: rule__OilObjectImpl__Group__0__Impl rule__OilObjectImpl__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__0__Impl_in_rule__OilObjectImpl__Group__04300);
            rule__OilObjectImpl__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__1_in_rule__OilObjectImpl__Group__04303);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1939:1: rule__OilObjectImpl__Group__0__Impl : ( ( rule__OilObjectImpl__TypeAssignment_0 ) ) ;
    public final void rule__OilObjectImpl__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1943:1: ( ( ( rule__OilObjectImpl__TypeAssignment_0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1944:1: ( ( rule__OilObjectImpl__TypeAssignment_0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1944:1: ( ( rule__OilObjectImpl__TypeAssignment_0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1945:1: ( rule__OilObjectImpl__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getTypeAssignment_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1946:1: ( rule__OilObjectImpl__TypeAssignment_0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1946:2: rule__OilObjectImpl__TypeAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__TypeAssignment_0_in_rule__OilObjectImpl__Group__0__Impl4330);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1956:1: rule__OilObjectImpl__Group__1 : rule__OilObjectImpl__Group__1__Impl rule__OilObjectImpl__Group__2 ;
    public final void rule__OilObjectImpl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1960:1: ( rule__OilObjectImpl__Group__1__Impl rule__OilObjectImpl__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1961:2: rule__OilObjectImpl__Group__1__Impl rule__OilObjectImpl__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__1__Impl_in_rule__OilObjectImpl__Group__14360);
            rule__OilObjectImpl__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__2_in_rule__OilObjectImpl__Group__14363);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1968:1: rule__OilObjectImpl__Group__1__Impl : ( '{' ) ;
    public final void rule__OilObjectImpl__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1972:1: ( ( '{' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1973:1: ( '{' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1973:1: ( '{' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1974:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,54,FollowSets000.FOLLOW_54_in_rule__OilObjectImpl__Group__1__Impl4391); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1987:1: rule__OilObjectImpl__Group__2 : rule__OilObjectImpl__Group__2__Impl rule__OilObjectImpl__Group__3 ;
    public final void rule__OilObjectImpl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1991:1: ( rule__OilObjectImpl__Group__2__Impl rule__OilObjectImpl__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1992:2: rule__OilObjectImpl__Group__2__Impl rule__OilObjectImpl__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__2__Impl_in_rule__OilObjectImpl__Group__24422);
            rule__OilObjectImpl__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__3_in_rule__OilObjectImpl__Group__24425);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1999:1: rule__OilObjectImpl__Group__2__Impl : ( ( rule__OilObjectImpl__ParametersAssignment_2 )* ) ;
    public final void rule__OilObjectImpl__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2003:1: ( ( ( rule__OilObjectImpl__ParametersAssignment_2 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2004:1: ( ( rule__OilObjectImpl__ParametersAssignment_2 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2004:1: ( ( rule__OilObjectImpl__ParametersAssignment_2 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2005:1: ( rule__OilObjectImpl__ParametersAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getParametersAssignment_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2006:1: ( rule__OilObjectImpl__ParametersAssignment_2 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=13 && LA24_0<=21)||(LA24_0>=35 && LA24_0<=47)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2006:2: rule__OilObjectImpl__ParametersAssignment_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__ParametersAssignment_2_in_rule__OilObjectImpl__Group__2__Impl4452);
            	    rule__OilObjectImpl__ParametersAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop24;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2016:1: rule__OilObjectImpl__Group__3 : rule__OilObjectImpl__Group__3__Impl rule__OilObjectImpl__Group__4 ;
    public final void rule__OilObjectImpl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2020:1: ( rule__OilObjectImpl__Group__3__Impl rule__OilObjectImpl__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2021:2: rule__OilObjectImpl__Group__3__Impl rule__OilObjectImpl__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__3__Impl_in_rule__OilObjectImpl__Group__34483);
            rule__OilObjectImpl__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__4_in_rule__OilObjectImpl__Group__34486);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2028:1: rule__OilObjectImpl__Group__3__Impl : ( '}' ) ;
    public final void rule__OilObjectImpl__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2032:1: ( ( '}' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2033:1: ( '}' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2033:1: ( '}' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2034:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getRightCurlyBracketKeyword_3()); 
            }
            match(input,55,FollowSets000.FOLLOW_55_in_rule__OilObjectImpl__Group__3__Impl4514); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2047:1: rule__OilObjectImpl__Group__4 : rule__OilObjectImpl__Group__4__Impl rule__OilObjectImpl__Group__5 ;
    public final void rule__OilObjectImpl__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2051:1: ( rule__OilObjectImpl__Group__4__Impl rule__OilObjectImpl__Group__5 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2052:2: rule__OilObjectImpl__Group__4__Impl rule__OilObjectImpl__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__4__Impl_in_rule__OilObjectImpl__Group__44545);
            rule__OilObjectImpl__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__5_in_rule__OilObjectImpl__Group__44548);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2059:1: rule__OilObjectImpl__Group__4__Impl : ( ( rule__OilObjectImpl__Group_4__0 )? ) ;
    public final void rule__OilObjectImpl__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2063:1: ( ( ( rule__OilObjectImpl__Group_4__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2064:1: ( ( rule__OilObjectImpl__Group_4__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2064:1: ( ( rule__OilObjectImpl__Group_4__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2065:1: ( rule__OilObjectImpl__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getGroup_4()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2066:1: ( rule__OilObjectImpl__Group_4__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==56) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2066:2: rule__OilObjectImpl__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group_4__0_in_rule__OilObjectImpl__Group__4__Impl4575);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2076:1: rule__OilObjectImpl__Group__5 : rule__OilObjectImpl__Group__5__Impl ;
    public final void rule__OilObjectImpl__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2080:1: ( rule__OilObjectImpl__Group__5__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2081:2: rule__OilObjectImpl__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__5__Impl_in_rule__OilObjectImpl__Group__54606);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2087:1: rule__OilObjectImpl__Group__5__Impl : ( ';' ) ;
    public final void rule__OilObjectImpl__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2091:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2092:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2092:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2093:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getSemicolonKeyword_5()); 
            }
            match(input,52,FollowSets000.FOLLOW_52_in_rule__OilObjectImpl__Group__5__Impl4634); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2118:1: rule__OilObjectImpl__Group_4__0 : rule__OilObjectImpl__Group_4__0__Impl rule__OilObjectImpl__Group_4__1 ;
    public final void rule__OilObjectImpl__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2122:1: ( rule__OilObjectImpl__Group_4__0__Impl rule__OilObjectImpl__Group_4__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2123:2: rule__OilObjectImpl__Group_4__0__Impl rule__OilObjectImpl__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group_4__0__Impl_in_rule__OilObjectImpl__Group_4__04677);
            rule__OilObjectImpl__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group_4__1_in_rule__OilObjectImpl__Group_4__04680);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2130:1: rule__OilObjectImpl__Group_4__0__Impl : ( ':' ) ;
    public final void rule__OilObjectImpl__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2134:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2135:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2135:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2136:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getColonKeyword_4_0()); 
            }
            match(input,56,FollowSets000.FOLLOW_56_in_rule__OilObjectImpl__Group_4__0__Impl4708); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2149:1: rule__OilObjectImpl__Group_4__1 : rule__OilObjectImpl__Group_4__1__Impl ;
    public final void rule__OilObjectImpl__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2153:1: ( rule__OilObjectImpl__Group_4__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2154:2: rule__OilObjectImpl__Group_4__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group_4__1__Impl_in_rule__OilObjectImpl__Group_4__14739);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2160:1: rule__OilObjectImpl__Group_4__1__Impl : ( ( rule__OilObjectImpl__DescriptionAssignment_4_1 ) ) ;
    public final void rule__OilObjectImpl__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2164:1: ( ( ( rule__OilObjectImpl__DescriptionAssignment_4_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2165:1: ( ( rule__OilObjectImpl__DescriptionAssignment_4_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2165:1: ( ( rule__OilObjectImpl__DescriptionAssignment_4_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2166:1: ( rule__OilObjectImpl__DescriptionAssignment_4_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getDescriptionAssignment_4_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2167:1: ( rule__OilObjectImpl__DescriptionAssignment_4_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2167:2: rule__OilObjectImpl__DescriptionAssignment_4_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__DescriptionAssignment_4_1_in_rule__OilObjectImpl__Group_4__1__Impl4766);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2181:1: rule__OilApplication__Group__0 : rule__OilApplication__Group__0__Impl rule__OilApplication__Group__1 ;
    public final void rule__OilApplication__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2185:1: ( rule__OilApplication__Group__0__Impl rule__OilApplication__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2186:2: rule__OilApplication__Group__0__Impl rule__OilApplication__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__0__Impl_in_rule__OilApplication__Group__04800);
            rule__OilApplication__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__1_in_rule__OilApplication__Group__04803);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2193:1: rule__OilApplication__Group__0__Impl : ( 'CPU' ) ;
    public final void rule__OilApplication__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2197:1: ( ( 'CPU' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2198:1: ( 'CPU' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2198:1: ( 'CPU' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2199:1: 'CPU'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getCPUKeyword_0()); 
            }
            match(input,57,FollowSets000.FOLLOW_57_in_rule__OilApplication__Group__0__Impl4831); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2212:1: rule__OilApplication__Group__1 : rule__OilApplication__Group__1__Impl rule__OilApplication__Group__2 ;
    public final void rule__OilApplication__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2216:1: ( rule__OilApplication__Group__1__Impl rule__OilApplication__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2217:2: rule__OilApplication__Group__1__Impl rule__OilApplication__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__1__Impl_in_rule__OilApplication__Group__14862);
            rule__OilApplication__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__2_in_rule__OilApplication__Group__14865);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2224:1: rule__OilApplication__Group__1__Impl : ( ( rule__OilApplication__NameAssignment_1 ) ) ;
    public final void rule__OilApplication__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2228:1: ( ( ( rule__OilApplication__NameAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2229:1: ( ( rule__OilApplication__NameAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2229:1: ( ( rule__OilApplication__NameAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2230:1: ( rule__OilApplication__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getNameAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2231:1: ( rule__OilApplication__NameAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2231:2: rule__OilApplication__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__NameAssignment_1_in_rule__OilApplication__Group__1__Impl4892);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2241:1: rule__OilApplication__Group__2 : rule__OilApplication__Group__2__Impl rule__OilApplication__Group__3 ;
    public final void rule__OilApplication__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2245:1: ( rule__OilApplication__Group__2__Impl rule__OilApplication__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2246:2: rule__OilApplication__Group__2__Impl rule__OilApplication__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__2__Impl_in_rule__OilApplication__Group__24922);
            rule__OilApplication__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__3_in_rule__OilApplication__Group__24925);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2253:1: rule__OilApplication__Group__2__Impl : ( '{' ) ;
    public final void rule__OilApplication__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2257:1: ( ( '{' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2258:1: ( '{' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2258:1: ( '{' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2259:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,54,FollowSets000.FOLLOW_54_in_rule__OilApplication__Group__2__Impl4953); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2272:1: rule__OilApplication__Group__3 : rule__OilApplication__Group__3__Impl rule__OilApplication__Group__4 ;
    public final void rule__OilApplication__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2276:1: ( rule__OilApplication__Group__3__Impl rule__OilApplication__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2277:2: rule__OilApplication__Group__3__Impl rule__OilApplication__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__3__Impl_in_rule__OilApplication__Group__34984);
            rule__OilApplication__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__4_in_rule__OilApplication__Group__34987);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2284:1: rule__OilApplication__Group__3__Impl : ( ( rule__OilApplication__OilObjectsAssignment_3 )* ) ;
    public final void rule__OilApplication__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2288:1: ( ( ( rule__OilApplication__OilObjectsAssignment_3 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2289:1: ( ( rule__OilApplication__OilObjectsAssignment_3 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2289:1: ( ( rule__OilApplication__OilObjectsAssignment_3 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2290:1: ( rule__OilApplication__OilObjectsAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getOilObjectsAssignment_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2291:1: ( rule__OilApplication__OilObjectsAssignment_3 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=22 && LA26_0<=34)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2291:2: rule__OilApplication__OilObjectsAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__OilApplication__OilObjectsAssignment_3_in_rule__OilApplication__Group__3__Impl5014);
            	    rule__OilApplication__OilObjectsAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop26;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2301:1: rule__OilApplication__Group__4 : rule__OilApplication__Group__4__Impl rule__OilApplication__Group__5 ;
    public final void rule__OilApplication__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2305:1: ( rule__OilApplication__Group__4__Impl rule__OilApplication__Group__5 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2306:2: rule__OilApplication__Group__4__Impl rule__OilApplication__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__4__Impl_in_rule__OilApplication__Group__45045);
            rule__OilApplication__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__5_in_rule__OilApplication__Group__45048);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2313:1: rule__OilApplication__Group__4__Impl : ( '}' ) ;
    public final void rule__OilApplication__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2317:1: ( ( '}' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2318:1: ( '}' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2318:1: ( '}' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2319:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,55,FollowSets000.FOLLOW_55_in_rule__OilApplication__Group__4__Impl5076); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2332:1: rule__OilApplication__Group__5 : rule__OilApplication__Group__5__Impl rule__OilApplication__Group__6 ;
    public final void rule__OilApplication__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2336:1: ( rule__OilApplication__Group__5__Impl rule__OilApplication__Group__6 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2337:2: rule__OilApplication__Group__5__Impl rule__OilApplication__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__5__Impl_in_rule__OilApplication__Group__55107);
            rule__OilApplication__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__6_in_rule__OilApplication__Group__55110);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2344:1: rule__OilApplication__Group__5__Impl : ( ( rule__OilApplication__Group_5__0 )? ) ;
    public final void rule__OilApplication__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2348:1: ( ( ( rule__OilApplication__Group_5__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2349:1: ( ( rule__OilApplication__Group_5__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2349:1: ( ( rule__OilApplication__Group_5__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2350:1: ( rule__OilApplication__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getGroup_5()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2351:1: ( rule__OilApplication__Group_5__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==56) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2351:2: rule__OilApplication__Group_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group_5__0_in_rule__OilApplication__Group__5__Impl5137);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2361:1: rule__OilApplication__Group__6 : rule__OilApplication__Group__6__Impl ;
    public final void rule__OilApplication__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2365:1: ( rule__OilApplication__Group__6__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2366:2: rule__OilApplication__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__6__Impl_in_rule__OilApplication__Group__65168);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2372:1: rule__OilApplication__Group__6__Impl : ( ';' ) ;
    public final void rule__OilApplication__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2376:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2377:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2377:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2378:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getSemicolonKeyword_6()); 
            }
            match(input,52,FollowSets000.FOLLOW_52_in_rule__OilApplication__Group__6__Impl5196); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2405:1: rule__OilApplication__Group_5__0 : rule__OilApplication__Group_5__0__Impl rule__OilApplication__Group_5__1 ;
    public final void rule__OilApplication__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2409:1: ( rule__OilApplication__Group_5__0__Impl rule__OilApplication__Group_5__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2410:2: rule__OilApplication__Group_5__0__Impl rule__OilApplication__Group_5__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group_5__0__Impl_in_rule__OilApplication__Group_5__05241);
            rule__OilApplication__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group_5__1_in_rule__OilApplication__Group_5__05244);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2417:1: rule__OilApplication__Group_5__0__Impl : ( ':' ) ;
    public final void rule__OilApplication__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2421:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2422:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2422:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2423:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getColonKeyword_5_0()); 
            }
            match(input,56,FollowSets000.FOLLOW_56_in_rule__OilApplication__Group_5__0__Impl5272); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2436:1: rule__OilApplication__Group_5__1 : rule__OilApplication__Group_5__1__Impl ;
    public final void rule__OilApplication__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2440:1: ( rule__OilApplication__Group_5__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2441:2: rule__OilApplication__Group_5__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group_5__1__Impl_in_rule__OilApplication__Group_5__15303);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2447:1: rule__OilApplication__Group_5__1__Impl : ( ( rule__OilApplication__DescriptionAssignment_5_1 ) ) ;
    public final void rule__OilApplication__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2451:1: ( ( ( rule__OilApplication__DescriptionAssignment_5_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2452:1: ( ( rule__OilApplication__DescriptionAssignment_5_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2452:1: ( ( rule__OilApplication__DescriptionAssignment_5_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2453:1: ( rule__OilApplication__DescriptionAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getDescriptionAssignment_5_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2454:1: ( rule__OilApplication__DescriptionAssignment_5_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2454:2: rule__OilApplication__DescriptionAssignment_5_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__DescriptionAssignment_5_1_in_rule__OilApplication__Group_5__1__Impl5330);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2468:1: rule__ValueType__Group__0 : rule__ValueType__Group__0__Impl rule__ValueType__Group__1 ;
    public final void rule__ValueType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2472:1: ( rule__ValueType__Group__0__Impl rule__ValueType__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2473:2: rule__ValueType__Group__0__Impl rule__ValueType__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__0__Impl_in_rule__ValueType__Group__05364);
            rule__ValueType__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__1_in_rule__ValueType__Group__05367);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2480:1: rule__ValueType__Group__0__Impl : ( () ) ;
    public final void rule__ValueType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2484:1: ( ( () ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2485:1: ( () )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2485:1: ( () )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2486:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getValueTypeAction_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2487:1: ()
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2489:1: 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2499:1: rule__ValueType__Group__1 : rule__ValueType__Group__1__Impl rule__ValueType__Group__2 ;
    public final void rule__ValueType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2503:1: ( rule__ValueType__Group__1__Impl rule__ValueType__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2504:2: rule__ValueType__Group__1__Impl rule__ValueType__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__1__Impl_in_rule__ValueType__Group__15425);
            rule__ValueType__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__2_in_rule__ValueType__Group__15428);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2511:1: rule__ValueType__Group__1__Impl : ( ( rule__ValueType__TypeAssignment_1 ) ) ;
    public final void rule__ValueType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2515:1: ( ( ( rule__ValueType__TypeAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2516:1: ( ( rule__ValueType__TypeAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2516:1: ( ( rule__ValueType__TypeAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2517:1: ( rule__ValueType__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getTypeAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2518:1: ( rule__ValueType__TypeAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2518:2: rule__ValueType__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__TypeAssignment_1_in_rule__ValueType__Group__1__Impl5455);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2528:1: rule__ValueType__Group__2 : rule__ValueType__Group__2__Impl rule__ValueType__Group__3 ;
    public final void rule__ValueType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2532:1: ( rule__ValueType__Group__2__Impl rule__ValueType__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2533:2: rule__ValueType__Group__2__Impl rule__ValueType__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__2__Impl_in_rule__ValueType__Group__25485);
            rule__ValueType__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__3_in_rule__ValueType__Group__25488);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2540:1: rule__ValueType__Group__2__Impl : ( ( rule__ValueType__WithAutoAssignment_2 )? ) ;
    public final void rule__ValueType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2544:1: ( ( ( rule__ValueType__WithAutoAssignment_2 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2545:1: ( ( rule__ValueType__WithAutoAssignment_2 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2545:1: ( ( rule__ValueType__WithAutoAssignment_2 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2546:1: ( rule__ValueType__WithAutoAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getWithAutoAssignment_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2547:1: ( rule__ValueType__WithAutoAssignment_2 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==62) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2547:2: rule__ValueType__WithAutoAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ValueType__WithAutoAssignment_2_in_rule__ValueType__Group__2__Impl5515);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2557:1: rule__ValueType__Group__3 : rule__ValueType__Group__3__Impl rule__ValueType__Group__4 ;
    public final void rule__ValueType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2561:1: ( rule__ValueType__Group__3__Impl rule__ValueType__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2562:2: rule__ValueType__Group__3__Impl rule__ValueType__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__3__Impl_in_rule__ValueType__Group__35546);
            rule__ValueType__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__4_in_rule__ValueType__Group__35549);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2569:1: rule__ValueType__Group__3__Impl : ( ( rule__ValueType__NameAssignment_3 ) ) ;
    public final void rule__ValueType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2573:1: ( ( ( rule__ValueType__NameAssignment_3 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2574:1: ( ( rule__ValueType__NameAssignment_3 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2574:1: ( ( rule__ValueType__NameAssignment_3 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2575:1: ( rule__ValueType__NameAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getNameAssignment_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2576:1: ( rule__ValueType__NameAssignment_3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2576:2: rule__ValueType__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__NameAssignment_3_in_rule__ValueType__Group__3__Impl5576);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2586:1: rule__ValueType__Group__4 : rule__ValueType__Group__4__Impl rule__ValueType__Group__5 ;
    public final void rule__ValueType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2590:1: ( rule__ValueType__Group__4__Impl rule__ValueType__Group__5 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2591:2: rule__ValueType__Group__4__Impl rule__ValueType__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__4__Impl_in_rule__ValueType__Group__45606);
            rule__ValueType__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__5_in_rule__ValueType__Group__45609);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2598:1: rule__ValueType__Group__4__Impl : ( ( rule__ValueType__MultiValueAssignment_4 )? ) ;
    public final void rule__ValueType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2602:1: ( ( ( rule__ValueType__MultiValueAssignment_4 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2603:1: ( ( rule__ValueType__MultiValueAssignment_4 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2603:1: ( ( rule__ValueType__MultiValueAssignment_4 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2604:1: ( rule__ValueType__MultiValueAssignment_4 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getMultiValueAssignment_4()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2605:1: ( rule__ValueType__MultiValueAssignment_4 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==63) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2605:2: rule__ValueType__MultiValueAssignment_4
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ValueType__MultiValueAssignment_4_in_rule__ValueType__Group__4__Impl5636);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2615:1: rule__ValueType__Group__5 : rule__ValueType__Group__5__Impl rule__ValueType__Group__6 ;
    public final void rule__ValueType__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2619:1: ( rule__ValueType__Group__5__Impl rule__ValueType__Group__6 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2620:2: rule__ValueType__Group__5__Impl rule__ValueType__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__5__Impl_in_rule__ValueType__Group__55667);
            rule__ValueType__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__6_in_rule__ValueType__Group__55670);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2627:1: rule__ValueType__Group__5__Impl : ( ( rule__ValueType__Group_5__0 )? ) ;
    public final void rule__ValueType__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2631:1: ( ( ( rule__ValueType__Group_5__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2632:1: ( ( rule__ValueType__Group_5__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2632:1: ( ( rule__ValueType__Group_5__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2633:1: ( rule__ValueType__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getGroup_5()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2634:1: ( rule__ValueType__Group_5__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==51) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2634:2: rule__ValueType__Group_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_5__0_in_rule__ValueType__Group__5__Impl5697);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2644:1: rule__ValueType__Group__6 : rule__ValueType__Group__6__Impl rule__ValueType__Group__7 ;
    public final void rule__ValueType__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2648:1: ( rule__ValueType__Group__6__Impl rule__ValueType__Group__7 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2649:2: rule__ValueType__Group__6__Impl rule__ValueType__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__6__Impl_in_rule__ValueType__Group__65728);
            rule__ValueType__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__7_in_rule__ValueType__Group__65731);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2656:1: rule__ValueType__Group__6__Impl : ( ( rule__ValueType__Group_6__0 )? ) ;
    public final void rule__ValueType__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2660:1: ( ( ( rule__ValueType__Group_6__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2661:1: ( ( rule__ValueType__Group_6__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2661:1: ( ( rule__ValueType__Group_6__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2662:1: ( rule__ValueType__Group_6__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getGroup_6()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2663:1: ( rule__ValueType__Group_6__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==56) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2663:2: rule__ValueType__Group_6__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_6__0_in_rule__ValueType__Group__6__Impl5758);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2673:1: rule__ValueType__Group__7 : rule__ValueType__Group__7__Impl ;
    public final void rule__ValueType__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2677:1: ( rule__ValueType__Group__7__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2678:2: rule__ValueType__Group__7__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__7__Impl_in_rule__ValueType__Group__75789);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2684:1: rule__ValueType__Group__7__Impl : ( ';' ) ;
    public final void rule__ValueType__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2688:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2689:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2689:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2690:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getSemicolonKeyword_7()); 
            }
            match(input,52,FollowSets000.FOLLOW_52_in_rule__ValueType__Group__7__Impl5817); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2719:1: rule__ValueType__Group_5__0 : rule__ValueType__Group_5__0__Impl rule__ValueType__Group_5__1 ;
    public final void rule__ValueType__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2723:1: ( rule__ValueType__Group_5__0__Impl rule__ValueType__Group_5__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2724:2: rule__ValueType__Group_5__0__Impl rule__ValueType__Group_5__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_5__0__Impl_in_rule__ValueType__Group_5__05864);
            rule__ValueType__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_5__1_in_rule__ValueType__Group_5__05867);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2731:1: rule__ValueType__Group_5__0__Impl : ( '=' ) ;
    public final void rule__ValueType__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2735:1: ( ( '=' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2736:1: ( '=' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2736:1: ( '=' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2737:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getEqualsSignKeyword_5_0()); 
            }
            match(input,51,FollowSets000.FOLLOW_51_in_rule__ValueType__Group_5__0__Impl5895); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2750:1: rule__ValueType__Group_5__1 : rule__ValueType__Group_5__1__Impl ;
    public final void rule__ValueType__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2754:1: ( rule__ValueType__Group_5__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2755:2: rule__ValueType__Group_5__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_5__1__Impl_in_rule__ValueType__Group_5__15926);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2761:1: rule__ValueType__Group_5__1__Impl : ( ( rule__ValueType__Alternatives_5_1 ) ) ;
    public final void rule__ValueType__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2765:1: ( ( ( rule__ValueType__Alternatives_5_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2766:1: ( ( rule__ValueType__Alternatives_5_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2766:1: ( ( rule__ValueType__Alternatives_5_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2767:1: ( rule__ValueType__Alternatives_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getAlternatives_5_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2768:1: ( rule__ValueType__Alternatives_5_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2768:2: rule__ValueType__Alternatives_5_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Alternatives_5_1_in_rule__ValueType__Group_5__1__Impl5953);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2782:1: rule__ValueType__Group_6__0 : rule__ValueType__Group_6__0__Impl rule__ValueType__Group_6__1 ;
    public final void rule__ValueType__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2786:1: ( rule__ValueType__Group_6__0__Impl rule__ValueType__Group_6__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2787:2: rule__ValueType__Group_6__0__Impl rule__ValueType__Group_6__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_6__0__Impl_in_rule__ValueType__Group_6__05987);
            rule__ValueType__Group_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_6__1_in_rule__ValueType__Group_6__05990);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2794:1: rule__ValueType__Group_6__0__Impl : ( ':' ) ;
    public final void rule__ValueType__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2798:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2799:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2799:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2800:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getColonKeyword_6_0()); 
            }
            match(input,56,FollowSets000.FOLLOW_56_in_rule__ValueType__Group_6__0__Impl6018); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2813:1: rule__ValueType__Group_6__1 : rule__ValueType__Group_6__1__Impl ;
    public final void rule__ValueType__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2817:1: ( rule__ValueType__Group_6__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2818:2: rule__ValueType__Group_6__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_6__1__Impl_in_rule__ValueType__Group_6__16049);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2824:1: rule__ValueType__Group_6__1__Impl : ( ( rule__ValueType__DescriptionAssignment_6_1 ) ) ;
    public final void rule__ValueType__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2828:1: ( ( ( rule__ValueType__DescriptionAssignment_6_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2829:1: ( ( rule__ValueType__DescriptionAssignment_6_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2829:1: ( ( rule__ValueType__DescriptionAssignment_6_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2830:1: ( rule__ValueType__DescriptionAssignment_6_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getDescriptionAssignment_6_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2831:1: ( rule__ValueType__DescriptionAssignment_6_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2831:2: rule__ValueType__DescriptionAssignment_6_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__DescriptionAssignment_6_1_in_rule__ValueType__Group_6__1__Impl6076);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2845:1: rule__VariantType__Group__0 : rule__VariantType__Group__0__Impl rule__VariantType__Group__1 ;
    public final void rule__VariantType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2849:1: ( rule__VariantType__Group__0__Impl rule__VariantType__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2850:2: rule__VariantType__Group__0__Impl rule__VariantType__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__0__Impl_in_rule__VariantType__Group__06110);
            rule__VariantType__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__1_in_rule__VariantType__Group__06113);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2857:1: rule__VariantType__Group__0__Impl : ( () ) ;
    public final void rule__VariantType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2861:1: ( ( () ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2862:1: ( () )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2862:1: ( () )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2863:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getVariantTypeAction_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2864:1: ()
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2866:1: 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2876:1: rule__VariantType__Group__1 : rule__VariantType__Group__1__Impl rule__VariantType__Group__2 ;
    public final void rule__VariantType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2880:1: ( rule__VariantType__Group__1__Impl rule__VariantType__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2881:2: rule__VariantType__Group__1__Impl rule__VariantType__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__1__Impl_in_rule__VariantType__Group__16171);
            rule__VariantType__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__2_in_rule__VariantType__Group__16174);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2888:1: rule__VariantType__Group__1__Impl : ( ( rule__VariantType__TypeAssignment_1 ) ) ;
    public final void rule__VariantType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2892:1: ( ( ( rule__VariantType__TypeAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2893:1: ( ( rule__VariantType__TypeAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2893:1: ( ( rule__VariantType__TypeAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2894:1: ( rule__VariantType__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getTypeAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2895:1: ( rule__VariantType__TypeAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2895:2: rule__VariantType__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__TypeAssignment_1_in_rule__VariantType__Group__1__Impl6201);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2905:1: rule__VariantType__Group__2 : rule__VariantType__Group__2__Impl rule__VariantType__Group__3 ;
    public final void rule__VariantType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2909:1: ( rule__VariantType__Group__2__Impl rule__VariantType__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2910:2: rule__VariantType__Group__2__Impl rule__VariantType__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__2__Impl_in_rule__VariantType__Group__26231);
            rule__VariantType__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__3_in_rule__VariantType__Group__26234);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2917:1: rule__VariantType__Group__2__Impl : ( ( rule__VariantType__WithAutoAssignment_2 )? ) ;
    public final void rule__VariantType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2921:1: ( ( ( rule__VariantType__WithAutoAssignment_2 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2922:1: ( ( rule__VariantType__WithAutoAssignment_2 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2922:1: ( ( rule__VariantType__WithAutoAssignment_2 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2923:1: ( rule__VariantType__WithAutoAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getWithAutoAssignment_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2924:1: ( rule__VariantType__WithAutoAssignment_2 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==62) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2924:2: rule__VariantType__WithAutoAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__VariantType__WithAutoAssignment_2_in_rule__VariantType__Group__2__Impl6261);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2934:1: rule__VariantType__Group__3 : rule__VariantType__Group__3__Impl rule__VariantType__Group__4 ;
    public final void rule__VariantType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2938:1: ( rule__VariantType__Group__3__Impl rule__VariantType__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2939:2: rule__VariantType__Group__3__Impl rule__VariantType__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__3__Impl_in_rule__VariantType__Group__36292);
            rule__VariantType__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__4_in_rule__VariantType__Group__36295);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2946:1: rule__VariantType__Group__3__Impl : ( ( rule__VariantType__Group_3__0 )? ) ;
    public final void rule__VariantType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2950:1: ( ( ( rule__VariantType__Group_3__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2951:1: ( ( rule__VariantType__Group_3__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2951:1: ( ( rule__VariantType__Group_3__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2952:1: ( rule__VariantType__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getGroup_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2953:1: ( rule__VariantType__Group_3__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==58) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2953:2: rule__VariantType__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3__0_in_rule__VariantType__Group__3__Impl6322);
                    rule__VariantType__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getGroup_3()); 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2963:1: rule__VariantType__Group__4 : rule__VariantType__Group__4__Impl rule__VariantType__Group__5 ;
    public final void rule__VariantType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2967:1: ( rule__VariantType__Group__4__Impl rule__VariantType__Group__5 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2968:2: rule__VariantType__Group__4__Impl rule__VariantType__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__4__Impl_in_rule__VariantType__Group__46353);
            rule__VariantType__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__5_in_rule__VariantType__Group__46356);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2975:1: rule__VariantType__Group__4__Impl : ( ( rule__VariantType__NameAssignment_4 ) ) ;
    public final void rule__VariantType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2979:1: ( ( ( rule__VariantType__NameAssignment_4 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2980:1: ( ( rule__VariantType__NameAssignment_4 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2980:1: ( ( rule__VariantType__NameAssignment_4 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2981:1: ( rule__VariantType__NameAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getNameAssignment_4()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2982:1: ( rule__VariantType__NameAssignment_4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2982:2: rule__VariantType__NameAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__NameAssignment_4_in_rule__VariantType__Group__4__Impl6383);
            rule__VariantType__NameAssignment_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getNameAssignment_4()); 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2992:1: rule__VariantType__Group__5 : rule__VariantType__Group__5__Impl rule__VariantType__Group__6 ;
    public final void rule__VariantType__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2996:1: ( rule__VariantType__Group__5__Impl rule__VariantType__Group__6 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2997:2: rule__VariantType__Group__5__Impl rule__VariantType__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__5__Impl_in_rule__VariantType__Group__56413);
            rule__VariantType__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__6_in_rule__VariantType__Group__56416);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3004:1: rule__VariantType__Group__5__Impl : ( ( rule__VariantType__MultiValueAssignment_5 )? ) ;
    public final void rule__VariantType__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3008:1: ( ( ( rule__VariantType__MultiValueAssignment_5 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3009:1: ( ( rule__VariantType__MultiValueAssignment_5 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3009:1: ( ( rule__VariantType__MultiValueAssignment_5 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3010:1: ( rule__VariantType__MultiValueAssignment_5 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getMultiValueAssignment_5()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3011:1: ( rule__VariantType__MultiValueAssignment_5 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==63) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3011:2: rule__VariantType__MultiValueAssignment_5
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__VariantType__MultiValueAssignment_5_in_rule__VariantType__Group__5__Impl6443);
                    rule__VariantType__MultiValueAssignment_5();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getMultiValueAssignment_5()); 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3021:1: rule__VariantType__Group__6 : rule__VariantType__Group__6__Impl rule__VariantType__Group__7 ;
    public final void rule__VariantType__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3025:1: ( rule__VariantType__Group__6__Impl rule__VariantType__Group__7 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3026:2: rule__VariantType__Group__6__Impl rule__VariantType__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__6__Impl_in_rule__VariantType__Group__66474);
            rule__VariantType__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__7_in_rule__VariantType__Group__66477);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3033:1: rule__VariantType__Group__6__Impl : ( ( rule__VariantType__Group_6__0 )? ) ;
    public final void rule__VariantType__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3037:1: ( ( ( rule__VariantType__Group_6__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3038:1: ( ( rule__VariantType__Group_6__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3038:1: ( ( rule__VariantType__Group_6__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3039:1: ( rule__VariantType__Group_6__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getGroup_6()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3040:1: ( rule__VariantType__Group_6__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==51) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3040:2: rule__VariantType__Group_6__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_6__0_in_rule__VariantType__Group__6__Impl6504);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3050:1: rule__VariantType__Group__7 : rule__VariantType__Group__7__Impl rule__VariantType__Group__8 ;
    public final void rule__VariantType__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3054:1: ( rule__VariantType__Group__7__Impl rule__VariantType__Group__8 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3055:2: rule__VariantType__Group__7__Impl rule__VariantType__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__7__Impl_in_rule__VariantType__Group__76535);
            rule__VariantType__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__8_in_rule__VariantType__Group__76538);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3062:1: rule__VariantType__Group__7__Impl : ( ( rule__VariantType__Group_7__0 )? ) ;
    public final void rule__VariantType__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3066:1: ( ( ( rule__VariantType__Group_7__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3067:1: ( ( rule__VariantType__Group_7__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3067:1: ( ( rule__VariantType__Group_7__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3068:1: ( rule__VariantType__Group_7__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getGroup_7()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3069:1: ( rule__VariantType__Group_7__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==56) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3069:2: rule__VariantType__Group_7__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_7__0_in_rule__VariantType__Group__7__Impl6565);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3079:1: rule__VariantType__Group__8 : rule__VariantType__Group__8__Impl ;
    public final void rule__VariantType__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3083:1: ( rule__VariantType__Group__8__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3084:2: rule__VariantType__Group__8__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__8__Impl_in_rule__VariantType__Group__86596);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3090:1: rule__VariantType__Group__8__Impl : ( ';' ) ;
    public final void rule__VariantType__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3094:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3095:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3095:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3096:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getSemicolonKeyword_8()); 
            }
            match(input,52,FollowSets000.FOLLOW_52_in_rule__VariantType__Group__8__Impl6624); if (state.failed) return ;
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


    // $ANTLR start "rule__VariantType__Group_3__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3127:1: rule__VariantType__Group_3__0 : rule__VariantType__Group_3__0__Impl rule__VariantType__Group_3__1 ;
    public final void rule__VariantType__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3131:1: ( rule__VariantType__Group_3__0__Impl rule__VariantType__Group_3__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3132:2: rule__VariantType__Group_3__0__Impl rule__VariantType__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3__0__Impl_in_rule__VariantType__Group_3__06673);
            rule__VariantType__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3__1_in_rule__VariantType__Group_3__06676);
            rule__VariantType__Group_3__1();

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
    // $ANTLR end "rule__VariantType__Group_3__0"


    // $ANTLR start "rule__VariantType__Group_3__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3139:1: rule__VariantType__Group_3__0__Impl : ( '[' ) ;
    public final void rule__VariantType__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3143:1: ( ( '[' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3144:1: ( '[' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3144:1: ( '[' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3145:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getLeftSquareBracketKeyword_3_0()); 
            }
            match(input,58,FollowSets000.FOLLOW_58_in_rule__VariantType__Group_3__0__Impl6704); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getLeftSquareBracketKeyword_3_0()); 
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
    // $ANTLR end "rule__VariantType__Group_3__0__Impl"


    // $ANTLR start "rule__VariantType__Group_3__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3158:1: rule__VariantType__Group_3__1 : rule__VariantType__Group_3__1__Impl rule__VariantType__Group_3__2 ;
    public final void rule__VariantType__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3162:1: ( rule__VariantType__Group_3__1__Impl rule__VariantType__Group_3__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3163:2: rule__VariantType__Group_3__1__Impl rule__VariantType__Group_3__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3__1__Impl_in_rule__VariantType__Group_3__16735);
            rule__VariantType__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3__2_in_rule__VariantType__Group_3__16738);
            rule__VariantType__Group_3__2();

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
    // $ANTLR end "rule__VariantType__Group_3__1"


    // $ANTLR start "rule__VariantType__Group_3__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3170:1: rule__VariantType__Group_3__1__Impl : ( ( rule__VariantType__Group_3_1__0 )? ) ;
    public final void rule__VariantType__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3174:1: ( ( ( rule__VariantType__Group_3_1__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3175:1: ( ( rule__VariantType__Group_3_1__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3175:1: ( ( rule__VariantType__Group_3_1__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3176:1: ( rule__VariantType__Group_3_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getGroup_3_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3177:1: ( rule__VariantType__Group_3_1__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_ID||(LA37_0>=13 && LA37_0<=47)) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3177:2: rule__VariantType__Group_3_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3_1__0_in_rule__VariantType__Group_3__1__Impl6765);
                    rule__VariantType__Group_3_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getGroup_3_1()); 
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
    // $ANTLR end "rule__VariantType__Group_3__1__Impl"


    // $ANTLR start "rule__VariantType__Group_3__2"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3187:1: rule__VariantType__Group_3__2 : rule__VariantType__Group_3__2__Impl ;
    public final void rule__VariantType__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3191:1: ( rule__VariantType__Group_3__2__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3192:2: rule__VariantType__Group_3__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3__2__Impl_in_rule__VariantType__Group_3__26796);
            rule__VariantType__Group_3__2__Impl();

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
    // $ANTLR end "rule__VariantType__Group_3__2"


    // $ANTLR start "rule__VariantType__Group_3__2__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3198:1: rule__VariantType__Group_3__2__Impl : ( ']' ) ;
    public final void rule__VariantType__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3202:1: ( ( ']' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3203:1: ( ']' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3203:1: ( ']' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3204:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getRightSquareBracketKeyword_3_2()); 
            }
            match(input,59,FollowSets000.FOLLOW_59_in_rule__VariantType__Group_3__2__Impl6824); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getRightSquareBracketKeyword_3_2()); 
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
    // $ANTLR end "rule__VariantType__Group_3__2__Impl"


    // $ANTLR start "rule__VariantType__Group_3_1__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3223:1: rule__VariantType__Group_3_1__0 : rule__VariantType__Group_3_1__0__Impl rule__VariantType__Group_3_1__1 ;
    public final void rule__VariantType__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3227:1: ( rule__VariantType__Group_3_1__0__Impl rule__VariantType__Group_3_1__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3228:2: rule__VariantType__Group_3_1__0__Impl rule__VariantType__Group_3_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3_1__0__Impl_in_rule__VariantType__Group_3_1__06861);
            rule__VariantType__Group_3_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3_1__1_in_rule__VariantType__Group_3_1__06864);
            rule__VariantType__Group_3_1__1();

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
    // $ANTLR end "rule__VariantType__Group_3_1__0"


    // $ANTLR start "rule__VariantType__Group_3_1__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3235:1: rule__VariantType__Group_3_1__0__Impl : ( ( rule__VariantType__ValuesAssignment_3_1_0 ) ) ;
    public final void rule__VariantType__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3239:1: ( ( ( rule__VariantType__ValuesAssignment_3_1_0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3240:1: ( ( rule__VariantType__ValuesAssignment_3_1_0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3240:1: ( ( rule__VariantType__ValuesAssignment_3_1_0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3241:1: ( rule__VariantType__ValuesAssignment_3_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getValuesAssignment_3_1_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3242:1: ( rule__VariantType__ValuesAssignment_3_1_0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3242:2: rule__VariantType__ValuesAssignment_3_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__ValuesAssignment_3_1_0_in_rule__VariantType__Group_3_1__0__Impl6891);
            rule__VariantType__ValuesAssignment_3_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getValuesAssignment_3_1_0()); 
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
    // $ANTLR end "rule__VariantType__Group_3_1__0__Impl"


    // $ANTLR start "rule__VariantType__Group_3_1__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3252:1: rule__VariantType__Group_3_1__1 : rule__VariantType__Group_3_1__1__Impl ;
    public final void rule__VariantType__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3256:1: ( rule__VariantType__Group_3_1__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3257:2: rule__VariantType__Group_3_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3_1__1__Impl_in_rule__VariantType__Group_3_1__16921);
            rule__VariantType__Group_3_1__1__Impl();

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
    // $ANTLR end "rule__VariantType__Group_3_1__1"


    // $ANTLR start "rule__VariantType__Group_3_1__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3263:1: rule__VariantType__Group_3_1__1__Impl : ( ( rule__VariantType__Group_3_1_1__0 )* ) ;
    public final void rule__VariantType__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3267:1: ( ( ( rule__VariantType__Group_3_1_1__0 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3268:1: ( ( rule__VariantType__Group_3_1_1__0 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3268:1: ( ( rule__VariantType__Group_3_1_1__0 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3269:1: ( rule__VariantType__Group_3_1_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getGroup_3_1_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3270:1: ( rule__VariantType__Group_3_1_1__0 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==60) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3270:2: rule__VariantType__Group_3_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3_1_1__0_in_rule__VariantType__Group_3_1__1__Impl6948);
            	    rule__VariantType__Group_3_1_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getGroup_3_1_1()); 
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
    // $ANTLR end "rule__VariantType__Group_3_1__1__Impl"


    // $ANTLR start "rule__VariantType__Group_3_1_1__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3284:1: rule__VariantType__Group_3_1_1__0 : rule__VariantType__Group_3_1_1__0__Impl rule__VariantType__Group_3_1_1__1 ;
    public final void rule__VariantType__Group_3_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3288:1: ( rule__VariantType__Group_3_1_1__0__Impl rule__VariantType__Group_3_1_1__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3289:2: rule__VariantType__Group_3_1_1__0__Impl rule__VariantType__Group_3_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3_1_1__0__Impl_in_rule__VariantType__Group_3_1_1__06983);
            rule__VariantType__Group_3_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3_1_1__1_in_rule__VariantType__Group_3_1_1__06986);
            rule__VariantType__Group_3_1_1__1();

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
    // $ANTLR end "rule__VariantType__Group_3_1_1__0"


    // $ANTLR start "rule__VariantType__Group_3_1_1__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3296:1: rule__VariantType__Group_3_1_1__0__Impl : ( ',' ) ;
    public final void rule__VariantType__Group_3_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3300:1: ( ( ',' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3301:1: ( ',' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3301:1: ( ',' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3302:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getCommaKeyword_3_1_1_0()); 
            }
            match(input,60,FollowSets000.FOLLOW_60_in_rule__VariantType__Group_3_1_1__0__Impl7014); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getCommaKeyword_3_1_1_0()); 
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
    // $ANTLR end "rule__VariantType__Group_3_1_1__0__Impl"


    // $ANTLR start "rule__VariantType__Group_3_1_1__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3315:1: rule__VariantType__Group_3_1_1__1 : rule__VariantType__Group_3_1_1__1__Impl ;
    public final void rule__VariantType__Group_3_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3319:1: ( rule__VariantType__Group_3_1_1__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3320:2: rule__VariantType__Group_3_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3_1_1__1__Impl_in_rule__VariantType__Group_3_1_1__17045);
            rule__VariantType__Group_3_1_1__1__Impl();

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
    // $ANTLR end "rule__VariantType__Group_3_1_1__1"


    // $ANTLR start "rule__VariantType__Group_3_1_1__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3326:1: rule__VariantType__Group_3_1_1__1__Impl : ( ( rule__VariantType__ValuesAssignment_3_1_1_1 ) ) ;
    public final void rule__VariantType__Group_3_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3330:1: ( ( ( rule__VariantType__ValuesAssignment_3_1_1_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3331:1: ( ( rule__VariantType__ValuesAssignment_3_1_1_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3331:1: ( ( rule__VariantType__ValuesAssignment_3_1_1_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3332:1: ( rule__VariantType__ValuesAssignment_3_1_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getValuesAssignment_3_1_1_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3333:1: ( rule__VariantType__ValuesAssignment_3_1_1_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3333:2: rule__VariantType__ValuesAssignment_3_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__ValuesAssignment_3_1_1_1_in_rule__VariantType__Group_3_1_1__1__Impl7072);
            rule__VariantType__ValuesAssignment_3_1_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getValuesAssignment_3_1_1_1()); 
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
    // $ANTLR end "rule__VariantType__Group_3_1_1__1__Impl"


    // $ANTLR start "rule__VariantType__Group_6__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3347:1: rule__VariantType__Group_6__0 : rule__VariantType__Group_6__0__Impl rule__VariantType__Group_6__1 ;
    public final void rule__VariantType__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3351:1: ( rule__VariantType__Group_6__0__Impl rule__VariantType__Group_6__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3352:2: rule__VariantType__Group_6__0__Impl rule__VariantType__Group_6__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_6__0__Impl_in_rule__VariantType__Group_6__07106);
            rule__VariantType__Group_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_6__1_in_rule__VariantType__Group_6__07109);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3359:1: rule__VariantType__Group_6__0__Impl : ( '=' ) ;
    public final void rule__VariantType__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3363:1: ( ( '=' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3364:1: ( '=' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3364:1: ( '=' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3365:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getEqualsSignKeyword_6_0()); 
            }
            match(input,51,FollowSets000.FOLLOW_51_in_rule__VariantType__Group_6__0__Impl7137); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3378:1: rule__VariantType__Group_6__1 : rule__VariantType__Group_6__1__Impl ;
    public final void rule__VariantType__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3382:1: ( rule__VariantType__Group_6__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3383:2: rule__VariantType__Group_6__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_6__1__Impl_in_rule__VariantType__Group_6__17168);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3389:1: rule__VariantType__Group_6__1__Impl : ( ( rule__VariantType__Alternatives_6_1 ) ) ;
    public final void rule__VariantType__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3393:1: ( ( ( rule__VariantType__Alternatives_6_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3394:1: ( ( rule__VariantType__Alternatives_6_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3394:1: ( ( rule__VariantType__Alternatives_6_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3395:1: ( rule__VariantType__Alternatives_6_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getAlternatives_6_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3396:1: ( rule__VariantType__Alternatives_6_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3396:2: rule__VariantType__Alternatives_6_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Alternatives_6_1_in_rule__VariantType__Group_6__1__Impl7195);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3410:1: rule__VariantType__Group_7__0 : rule__VariantType__Group_7__0__Impl rule__VariantType__Group_7__1 ;
    public final void rule__VariantType__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3414:1: ( rule__VariantType__Group_7__0__Impl rule__VariantType__Group_7__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3415:2: rule__VariantType__Group_7__0__Impl rule__VariantType__Group_7__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_7__0__Impl_in_rule__VariantType__Group_7__07229);
            rule__VariantType__Group_7__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_7__1_in_rule__VariantType__Group_7__07232);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3422:1: rule__VariantType__Group_7__0__Impl : ( ':' ) ;
    public final void rule__VariantType__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3426:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3427:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3427:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3428:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getColonKeyword_7_0()); 
            }
            match(input,56,FollowSets000.FOLLOW_56_in_rule__VariantType__Group_7__0__Impl7260); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3441:1: rule__VariantType__Group_7__1 : rule__VariantType__Group_7__1__Impl ;
    public final void rule__VariantType__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3445:1: ( rule__VariantType__Group_7__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3446:2: rule__VariantType__Group_7__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_7__1__Impl_in_rule__VariantType__Group_7__17291);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3452:1: rule__VariantType__Group_7__1__Impl : ( ( rule__VariantType__DescriptionAssignment_7_1 ) ) ;
    public final void rule__VariantType__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3456:1: ( ( ( rule__VariantType__DescriptionAssignment_7_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3457:1: ( ( rule__VariantType__DescriptionAssignment_7_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3457:1: ( ( rule__VariantType__DescriptionAssignment_7_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3458:1: ( rule__VariantType__DescriptionAssignment_7_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getDescriptionAssignment_7_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3459:1: ( rule__VariantType__DescriptionAssignment_7_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3459:2: rule__VariantType__DescriptionAssignment_7_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__DescriptionAssignment_7_1_in_rule__VariantType__Group_7__1__Impl7318);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3473:1: rule__EnumeratorType__Group__0 : rule__EnumeratorType__Group__0__Impl rule__EnumeratorType__Group__1 ;
    public final void rule__EnumeratorType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3477:1: ( rule__EnumeratorType__Group__0__Impl rule__EnumeratorType__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3478:2: rule__EnumeratorType__Group__0__Impl rule__EnumeratorType__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group__0__Impl_in_rule__EnumeratorType__Group__07352);
            rule__EnumeratorType__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group__1_in_rule__EnumeratorType__Group__07355);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3485:1: rule__EnumeratorType__Group__0__Impl : ( () ) ;
    public final void rule__EnumeratorType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3489:1: ( ( () ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3490:1: ( () )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3490:1: ( () )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3491:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getEnumeratorTypeAction_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3492:1: ()
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3494:1: 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3504:1: rule__EnumeratorType__Group__1 : rule__EnumeratorType__Group__1__Impl rule__EnumeratorType__Group__2 ;
    public final void rule__EnumeratorType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3508:1: ( rule__EnumeratorType__Group__1__Impl rule__EnumeratorType__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3509:2: rule__EnumeratorType__Group__1__Impl rule__EnumeratorType__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group__1__Impl_in_rule__EnumeratorType__Group__17413);
            rule__EnumeratorType__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group__2_in_rule__EnumeratorType__Group__17416);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3516:1: rule__EnumeratorType__Group__1__Impl : ( ( rule__EnumeratorType__NameAssignment_1 ) ) ;
    public final void rule__EnumeratorType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3520:1: ( ( ( rule__EnumeratorType__NameAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3521:1: ( ( rule__EnumeratorType__NameAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3521:1: ( ( rule__EnumeratorType__NameAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3522:1: ( rule__EnumeratorType__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getNameAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3523:1: ( rule__EnumeratorType__NameAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3523:2: rule__EnumeratorType__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__NameAssignment_1_in_rule__EnumeratorType__Group__1__Impl7443);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3533:1: rule__EnumeratorType__Group__2 : rule__EnumeratorType__Group__2__Impl rule__EnumeratorType__Group__3 ;
    public final void rule__EnumeratorType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3537:1: ( rule__EnumeratorType__Group__2__Impl rule__EnumeratorType__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3538:2: rule__EnumeratorType__Group__2__Impl rule__EnumeratorType__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group__2__Impl_in_rule__EnumeratorType__Group__27473);
            rule__EnumeratorType__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group__3_in_rule__EnumeratorType__Group__27476);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3545:1: rule__EnumeratorType__Group__2__Impl : ( ( rule__EnumeratorType__Group_2__0 )? ) ;
    public final void rule__EnumeratorType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3549:1: ( ( ( rule__EnumeratorType__Group_2__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3550:1: ( ( rule__EnumeratorType__Group_2__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3550:1: ( ( rule__EnumeratorType__Group_2__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3551:1: ( rule__EnumeratorType__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getGroup_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3552:1: ( rule__EnumeratorType__Group_2__0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==54) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3552:2: rule__EnumeratorType__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_2__0_in_rule__EnumeratorType__Group__2__Impl7503);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3562:1: rule__EnumeratorType__Group__3 : rule__EnumeratorType__Group__3__Impl ;
    public final void rule__EnumeratorType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3566:1: ( rule__EnumeratorType__Group__3__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3567:2: rule__EnumeratorType__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group__3__Impl_in_rule__EnumeratorType__Group__37534);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3573:1: rule__EnumeratorType__Group__3__Impl : ( ( rule__EnumeratorType__Group_3__0 )? ) ;
    public final void rule__EnumeratorType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3577:1: ( ( ( rule__EnumeratorType__Group_3__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3578:1: ( ( rule__EnumeratorType__Group_3__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3578:1: ( ( rule__EnumeratorType__Group_3__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3579:1: ( rule__EnumeratorType__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getGroup_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3580:1: ( rule__EnumeratorType__Group_3__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==56) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3580:2: rule__EnumeratorType__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_3__0_in_rule__EnumeratorType__Group__3__Impl7561);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3598:1: rule__EnumeratorType__Group_2__0 : rule__EnumeratorType__Group_2__0__Impl rule__EnumeratorType__Group_2__1 ;
    public final void rule__EnumeratorType__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3602:1: ( rule__EnumeratorType__Group_2__0__Impl rule__EnumeratorType__Group_2__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3603:2: rule__EnumeratorType__Group_2__0__Impl rule__EnumeratorType__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_2__0__Impl_in_rule__EnumeratorType__Group_2__07600);
            rule__EnumeratorType__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_2__1_in_rule__EnumeratorType__Group_2__07603);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3610:1: rule__EnumeratorType__Group_2__0__Impl : ( '{' ) ;
    public final void rule__EnumeratorType__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3614:1: ( ( '{' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3615:1: ( '{' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3615:1: ( '{' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3616:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getLeftCurlyBracketKeyword_2_0()); 
            }
            match(input,54,FollowSets000.FOLLOW_54_in_rule__EnumeratorType__Group_2__0__Impl7631); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3629:1: rule__EnumeratorType__Group_2__1 : rule__EnumeratorType__Group_2__1__Impl rule__EnumeratorType__Group_2__2 ;
    public final void rule__EnumeratorType__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3633:1: ( rule__EnumeratorType__Group_2__1__Impl rule__EnumeratorType__Group_2__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3634:2: rule__EnumeratorType__Group_2__1__Impl rule__EnumeratorType__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_2__1__Impl_in_rule__EnumeratorType__Group_2__17662);
            rule__EnumeratorType__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_2__2_in_rule__EnumeratorType__Group_2__17665);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3641:1: rule__EnumeratorType__Group_2__1__Impl : ( ( rule__EnumeratorType__ParametersAssignment_2_1 )* ) ;
    public final void rule__EnumeratorType__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3645:1: ( ( ( rule__EnumeratorType__ParametersAssignment_2_1 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3646:1: ( ( rule__EnumeratorType__ParametersAssignment_2_1 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3646:1: ( ( rule__EnumeratorType__ParametersAssignment_2_1 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3647:1: ( rule__EnumeratorType__ParametersAssignment_2_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getParametersAssignment_2_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3648:1: ( rule__EnumeratorType__ParametersAssignment_2_1 )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( ((LA41_0>=13 && LA41_0<=21)||(LA41_0>=35 && LA41_0<=47)) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3648:2: rule__EnumeratorType__ParametersAssignment_2_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__ParametersAssignment_2_1_in_rule__EnumeratorType__Group_2__1__Impl7692);
            	    rule__EnumeratorType__ParametersAssignment_2_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop41;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3658:1: rule__EnumeratorType__Group_2__2 : rule__EnumeratorType__Group_2__2__Impl ;
    public final void rule__EnumeratorType__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3662:1: ( rule__EnumeratorType__Group_2__2__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3663:2: rule__EnumeratorType__Group_2__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_2__2__Impl_in_rule__EnumeratorType__Group_2__27723);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3669:1: rule__EnumeratorType__Group_2__2__Impl : ( '}' ) ;
    public final void rule__EnumeratorType__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3673:1: ( ( '}' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3674:1: ( '}' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3674:1: ( '}' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3675:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getRightCurlyBracketKeyword_2_2()); 
            }
            match(input,55,FollowSets000.FOLLOW_55_in_rule__EnumeratorType__Group_2__2__Impl7751); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3694:1: rule__EnumeratorType__Group_3__0 : rule__EnumeratorType__Group_3__0__Impl rule__EnumeratorType__Group_3__1 ;
    public final void rule__EnumeratorType__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3698:1: ( rule__EnumeratorType__Group_3__0__Impl rule__EnumeratorType__Group_3__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3699:2: rule__EnumeratorType__Group_3__0__Impl rule__EnumeratorType__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_3__0__Impl_in_rule__EnumeratorType__Group_3__07788);
            rule__EnumeratorType__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_3__1_in_rule__EnumeratorType__Group_3__07791);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3706:1: rule__EnumeratorType__Group_3__0__Impl : ( ':' ) ;
    public final void rule__EnumeratorType__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3710:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3711:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3711:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3712:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getColonKeyword_3_0()); 
            }
            match(input,56,FollowSets000.FOLLOW_56_in_rule__EnumeratorType__Group_3__0__Impl7819); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3725:1: rule__EnumeratorType__Group_3__1 : rule__EnumeratorType__Group_3__1__Impl ;
    public final void rule__EnumeratorType__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3729:1: ( rule__EnumeratorType__Group_3__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3730:2: rule__EnumeratorType__Group_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_3__1__Impl_in_rule__EnumeratorType__Group_3__17850);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3736:1: rule__EnumeratorType__Group_3__1__Impl : ( ( rule__EnumeratorType__DescriptionAssignment_3_1 ) ) ;
    public final void rule__EnumeratorType__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3740:1: ( ( ( rule__EnumeratorType__DescriptionAssignment_3_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3741:1: ( ( rule__EnumeratorType__DescriptionAssignment_3_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3741:1: ( ( rule__EnumeratorType__DescriptionAssignment_3_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3742:1: ( rule__EnumeratorType__DescriptionAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getDescriptionAssignment_3_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3743:1: ( rule__EnumeratorType__DescriptionAssignment_3_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3743:2: rule__EnumeratorType__DescriptionAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__DescriptionAssignment_3_1_in_rule__EnumeratorType__Group_3__1__Impl7877);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3757:1: rule__ReferenceType__Group__0 : rule__ReferenceType__Group__0__Impl rule__ReferenceType__Group__1 ;
    public final void rule__ReferenceType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3761:1: ( rule__ReferenceType__Group__0__Impl rule__ReferenceType__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3762:2: rule__ReferenceType__Group__0__Impl rule__ReferenceType__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__0__Impl_in_rule__ReferenceType__Group__07911);
            rule__ReferenceType__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__1_in_rule__ReferenceType__Group__07914);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3769:1: rule__ReferenceType__Group__0__Impl : ( () ) ;
    public final void rule__ReferenceType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3773:1: ( ( () ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3774:1: ( () )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3774:1: ( () )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3775:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getReferenceTypeAction_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3776:1: ()
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3778:1: 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3788:1: rule__ReferenceType__Group__1 : rule__ReferenceType__Group__1__Impl rule__ReferenceType__Group__2 ;
    public final void rule__ReferenceType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3792:1: ( rule__ReferenceType__Group__1__Impl rule__ReferenceType__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3793:2: rule__ReferenceType__Group__1__Impl rule__ReferenceType__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__1__Impl_in_rule__ReferenceType__Group__17972);
            rule__ReferenceType__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__2_in_rule__ReferenceType__Group__17975);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3800:1: rule__ReferenceType__Group__1__Impl : ( ( rule__ReferenceType__TypeAssignment_1 ) ) ;
    public final void rule__ReferenceType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3804:1: ( ( ( rule__ReferenceType__TypeAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3805:1: ( ( rule__ReferenceType__TypeAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3805:1: ( ( rule__ReferenceType__TypeAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3806:1: ( rule__ReferenceType__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getTypeAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3807:1: ( rule__ReferenceType__TypeAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3807:2: rule__ReferenceType__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__TypeAssignment_1_in_rule__ReferenceType__Group__1__Impl8002);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3817:1: rule__ReferenceType__Group__2 : rule__ReferenceType__Group__2__Impl rule__ReferenceType__Group__3 ;
    public final void rule__ReferenceType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3821:1: ( rule__ReferenceType__Group__2__Impl rule__ReferenceType__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3822:2: rule__ReferenceType__Group__2__Impl rule__ReferenceType__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__2__Impl_in_rule__ReferenceType__Group__28032);
            rule__ReferenceType__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__3_in_rule__ReferenceType__Group__28035);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3829:1: rule__ReferenceType__Group__2__Impl : ( ( rule__ReferenceType__WithAutoAssignment_2 )? ) ;
    public final void rule__ReferenceType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3833:1: ( ( ( rule__ReferenceType__WithAutoAssignment_2 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3834:1: ( ( rule__ReferenceType__WithAutoAssignment_2 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3834:1: ( ( rule__ReferenceType__WithAutoAssignment_2 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3835:1: ( rule__ReferenceType__WithAutoAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getWithAutoAssignment_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3836:1: ( rule__ReferenceType__WithAutoAssignment_2 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==62) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3836:2: rule__ReferenceType__WithAutoAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__WithAutoAssignment_2_in_rule__ReferenceType__Group__2__Impl8062);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3846:1: rule__ReferenceType__Group__3 : rule__ReferenceType__Group__3__Impl rule__ReferenceType__Group__4 ;
    public final void rule__ReferenceType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3850:1: ( rule__ReferenceType__Group__3__Impl rule__ReferenceType__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3851:2: rule__ReferenceType__Group__3__Impl rule__ReferenceType__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__3__Impl_in_rule__ReferenceType__Group__38093);
            rule__ReferenceType__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__4_in_rule__ReferenceType__Group__38096);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3858:1: rule__ReferenceType__Group__3__Impl : ( ( rule__ReferenceType__NameAssignment_3 ) ) ;
    public final void rule__ReferenceType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3862:1: ( ( ( rule__ReferenceType__NameAssignment_3 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3863:1: ( ( rule__ReferenceType__NameAssignment_3 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3863:1: ( ( rule__ReferenceType__NameAssignment_3 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3864:1: ( rule__ReferenceType__NameAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getNameAssignment_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3865:1: ( rule__ReferenceType__NameAssignment_3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3865:2: rule__ReferenceType__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__NameAssignment_3_in_rule__ReferenceType__Group__3__Impl8123);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3875:1: rule__ReferenceType__Group__4 : rule__ReferenceType__Group__4__Impl rule__ReferenceType__Group__5 ;
    public final void rule__ReferenceType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3879:1: ( rule__ReferenceType__Group__4__Impl rule__ReferenceType__Group__5 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3880:2: rule__ReferenceType__Group__4__Impl rule__ReferenceType__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__4__Impl_in_rule__ReferenceType__Group__48153);
            rule__ReferenceType__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__5_in_rule__ReferenceType__Group__48156);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3887:1: rule__ReferenceType__Group__4__Impl : ( ( rule__ReferenceType__MultiValueAssignment_4 )? ) ;
    public final void rule__ReferenceType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3891:1: ( ( ( rule__ReferenceType__MultiValueAssignment_4 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3892:1: ( ( rule__ReferenceType__MultiValueAssignment_4 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3892:1: ( ( rule__ReferenceType__MultiValueAssignment_4 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3893:1: ( rule__ReferenceType__MultiValueAssignment_4 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getMultiValueAssignment_4()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3894:1: ( rule__ReferenceType__MultiValueAssignment_4 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==63) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3894:2: rule__ReferenceType__MultiValueAssignment_4
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__MultiValueAssignment_4_in_rule__ReferenceType__Group__4__Impl8183);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3904:1: rule__ReferenceType__Group__5 : rule__ReferenceType__Group__5__Impl rule__ReferenceType__Group__6 ;
    public final void rule__ReferenceType__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3908:1: ( rule__ReferenceType__Group__5__Impl rule__ReferenceType__Group__6 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3909:2: rule__ReferenceType__Group__5__Impl rule__ReferenceType__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__5__Impl_in_rule__ReferenceType__Group__58214);
            rule__ReferenceType__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__6_in_rule__ReferenceType__Group__58217);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3916:1: rule__ReferenceType__Group__5__Impl : ( ( rule__ReferenceType__Group_5__0 )? ) ;
    public final void rule__ReferenceType__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3920:1: ( ( ( rule__ReferenceType__Group_5__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3921:1: ( ( rule__ReferenceType__Group_5__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3921:1: ( ( rule__ReferenceType__Group_5__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3922:1: ( rule__ReferenceType__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getGroup_5()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3923:1: ( rule__ReferenceType__Group_5__0 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==51) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3923:2: rule__ReferenceType__Group_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_5__0_in_rule__ReferenceType__Group__5__Impl8244);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3933:1: rule__ReferenceType__Group__6 : rule__ReferenceType__Group__6__Impl rule__ReferenceType__Group__7 ;
    public final void rule__ReferenceType__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3937:1: ( rule__ReferenceType__Group__6__Impl rule__ReferenceType__Group__7 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3938:2: rule__ReferenceType__Group__6__Impl rule__ReferenceType__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__6__Impl_in_rule__ReferenceType__Group__68275);
            rule__ReferenceType__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__7_in_rule__ReferenceType__Group__68278);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3945:1: rule__ReferenceType__Group__6__Impl : ( ( rule__ReferenceType__Group_6__0 )? ) ;
    public final void rule__ReferenceType__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3949:1: ( ( ( rule__ReferenceType__Group_6__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3950:1: ( ( rule__ReferenceType__Group_6__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3950:1: ( ( rule__ReferenceType__Group_6__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3951:1: ( rule__ReferenceType__Group_6__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getGroup_6()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3952:1: ( rule__ReferenceType__Group_6__0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==56) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3952:2: rule__ReferenceType__Group_6__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_6__0_in_rule__ReferenceType__Group__6__Impl8305);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3962:1: rule__ReferenceType__Group__7 : rule__ReferenceType__Group__7__Impl ;
    public final void rule__ReferenceType__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3966:1: ( rule__ReferenceType__Group__7__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3967:2: rule__ReferenceType__Group__7__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__7__Impl_in_rule__ReferenceType__Group__78336);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3973:1: rule__ReferenceType__Group__7__Impl : ( ';' ) ;
    public final void rule__ReferenceType__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3977:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3978:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3978:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3979:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getSemicolonKeyword_7()); 
            }
            match(input,52,FollowSets000.FOLLOW_52_in_rule__ReferenceType__Group__7__Impl8364); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4008:1: rule__ReferenceType__Group_5__0 : rule__ReferenceType__Group_5__0__Impl rule__ReferenceType__Group_5__1 ;
    public final void rule__ReferenceType__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4012:1: ( rule__ReferenceType__Group_5__0__Impl rule__ReferenceType__Group_5__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4013:2: rule__ReferenceType__Group_5__0__Impl rule__ReferenceType__Group_5__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_5__0__Impl_in_rule__ReferenceType__Group_5__08411);
            rule__ReferenceType__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_5__1_in_rule__ReferenceType__Group_5__08414);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4020:1: rule__ReferenceType__Group_5__0__Impl : ( '=' ) ;
    public final void rule__ReferenceType__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4024:1: ( ( '=' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4025:1: ( '=' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4025:1: ( '=' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4026:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getEqualsSignKeyword_5_0()); 
            }
            match(input,51,FollowSets000.FOLLOW_51_in_rule__ReferenceType__Group_5__0__Impl8442); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4039:1: rule__ReferenceType__Group_5__1 : rule__ReferenceType__Group_5__1__Impl ;
    public final void rule__ReferenceType__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4043:1: ( rule__ReferenceType__Group_5__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4044:2: rule__ReferenceType__Group_5__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_5__1__Impl_in_rule__ReferenceType__Group_5__18473);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4050:1: rule__ReferenceType__Group_5__1__Impl : ( ( rule__ReferenceType__Alternatives_5_1 ) ) ;
    public final void rule__ReferenceType__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4054:1: ( ( ( rule__ReferenceType__Alternatives_5_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4055:1: ( ( rule__ReferenceType__Alternatives_5_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4055:1: ( ( rule__ReferenceType__Alternatives_5_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4056:1: ( rule__ReferenceType__Alternatives_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getAlternatives_5_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4057:1: ( rule__ReferenceType__Alternatives_5_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4057:2: rule__ReferenceType__Alternatives_5_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Alternatives_5_1_in_rule__ReferenceType__Group_5__1__Impl8500);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4071:1: rule__ReferenceType__Group_6__0 : rule__ReferenceType__Group_6__0__Impl rule__ReferenceType__Group_6__1 ;
    public final void rule__ReferenceType__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4075:1: ( rule__ReferenceType__Group_6__0__Impl rule__ReferenceType__Group_6__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4076:2: rule__ReferenceType__Group_6__0__Impl rule__ReferenceType__Group_6__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_6__0__Impl_in_rule__ReferenceType__Group_6__08534);
            rule__ReferenceType__Group_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_6__1_in_rule__ReferenceType__Group_6__08537);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4083:1: rule__ReferenceType__Group_6__0__Impl : ( ':' ) ;
    public final void rule__ReferenceType__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4087:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4088:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4088:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4089:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getColonKeyword_6_0()); 
            }
            match(input,56,FollowSets000.FOLLOW_56_in_rule__ReferenceType__Group_6__0__Impl8565); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4102:1: rule__ReferenceType__Group_6__1 : rule__ReferenceType__Group_6__1__Impl ;
    public final void rule__ReferenceType__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4106:1: ( rule__ReferenceType__Group_6__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4107:2: rule__ReferenceType__Group_6__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_6__1__Impl_in_rule__ReferenceType__Group_6__18596);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4113:1: rule__ReferenceType__Group_6__1__Impl : ( ( rule__ReferenceType__DescriptionAssignment_6_1 ) ) ;
    public final void rule__ReferenceType__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4117:1: ( ( ( rule__ReferenceType__DescriptionAssignment_6_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4118:1: ( ( rule__ReferenceType__DescriptionAssignment_6_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4118:1: ( ( rule__ReferenceType__DescriptionAssignment_6_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4119:1: ( rule__ReferenceType__DescriptionAssignment_6_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getDescriptionAssignment_6_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4120:1: ( rule__ReferenceType__DescriptionAssignment_6_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4120:2: rule__ReferenceType__DescriptionAssignment_6_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__DescriptionAssignment_6_1_in_rule__ReferenceType__Group_6__1__Impl8623);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4134:1: rule__OilObject__Group__0 : rule__OilObject__Group__0__Impl rule__OilObject__Group__1 ;
    public final void rule__OilObject__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4138:1: ( rule__OilObject__Group__0__Impl rule__OilObject__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4139:2: rule__OilObject__Group__0__Impl rule__OilObject__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__0__Impl_in_rule__OilObject__Group__08657);
            rule__OilObject__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__1_in_rule__OilObject__Group__08660);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4146:1: rule__OilObject__Group__0__Impl : ( ( rule__OilObject__TypeAssignment_0 ) ) ;
    public final void rule__OilObject__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4150:1: ( ( ( rule__OilObject__TypeAssignment_0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4151:1: ( ( rule__OilObject__TypeAssignment_0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4151:1: ( ( rule__OilObject__TypeAssignment_0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4152:1: ( rule__OilObject__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getTypeAssignment_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4153:1: ( rule__OilObject__TypeAssignment_0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4153:2: rule__OilObject__TypeAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__TypeAssignment_0_in_rule__OilObject__Group__0__Impl8687);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4163:1: rule__OilObject__Group__1 : rule__OilObject__Group__1__Impl rule__OilObject__Group__2 ;
    public final void rule__OilObject__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4167:1: ( rule__OilObject__Group__1__Impl rule__OilObject__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4168:2: rule__OilObject__Group__1__Impl rule__OilObject__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__1__Impl_in_rule__OilObject__Group__18717);
            rule__OilObject__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__2_in_rule__OilObject__Group__18720);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4175:1: rule__OilObject__Group__1__Impl : ( ( rule__OilObject__NameAssignment_1 ) ) ;
    public final void rule__OilObject__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4179:1: ( ( ( rule__OilObject__NameAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4180:1: ( ( rule__OilObject__NameAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4180:1: ( ( rule__OilObject__NameAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4181:1: ( rule__OilObject__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getNameAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4182:1: ( rule__OilObject__NameAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4182:2: rule__OilObject__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__NameAssignment_1_in_rule__OilObject__Group__1__Impl8747);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4192:1: rule__OilObject__Group__2 : rule__OilObject__Group__2__Impl rule__OilObject__Group__3 ;
    public final void rule__OilObject__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4196:1: ( rule__OilObject__Group__2__Impl rule__OilObject__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4197:2: rule__OilObject__Group__2__Impl rule__OilObject__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__2__Impl_in_rule__OilObject__Group__28777);
            rule__OilObject__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__3_in_rule__OilObject__Group__28780);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4204:1: rule__OilObject__Group__2__Impl : ( '{' ) ;
    public final void rule__OilObject__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4208:1: ( ( '{' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4209:1: ( '{' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4209:1: ( '{' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4210:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,54,FollowSets000.FOLLOW_54_in_rule__OilObject__Group__2__Impl8808); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4223:1: rule__OilObject__Group__3 : rule__OilObject__Group__3__Impl rule__OilObject__Group__4 ;
    public final void rule__OilObject__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4227:1: ( rule__OilObject__Group__3__Impl rule__OilObject__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4228:2: rule__OilObject__Group__3__Impl rule__OilObject__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__3__Impl_in_rule__OilObject__Group__38839);
            rule__OilObject__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__4_in_rule__OilObject__Group__38842);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4235:1: rule__OilObject__Group__3__Impl : ( ( rule__OilObject__ParametersAssignment_3 )* ) ;
    public final void rule__OilObject__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4239:1: ( ( ( rule__OilObject__ParametersAssignment_3 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4240:1: ( ( rule__OilObject__ParametersAssignment_3 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4240:1: ( ( rule__OilObject__ParametersAssignment_3 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4241:1: ( rule__OilObject__ParametersAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getParametersAssignment_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4242:1: ( rule__OilObject__ParametersAssignment_3 )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==RULE_ID||(LA46_0>=13 && LA46_0<=47)) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4242:2: rule__OilObject__ParametersAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__OilObject__ParametersAssignment_3_in_rule__OilObject__Group__3__Impl8869);
            	    rule__OilObject__ParametersAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop46;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4252:1: rule__OilObject__Group__4 : rule__OilObject__Group__4__Impl rule__OilObject__Group__5 ;
    public final void rule__OilObject__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4256:1: ( rule__OilObject__Group__4__Impl rule__OilObject__Group__5 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4257:2: rule__OilObject__Group__4__Impl rule__OilObject__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__4__Impl_in_rule__OilObject__Group__48900);
            rule__OilObject__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__5_in_rule__OilObject__Group__48903);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4264:1: rule__OilObject__Group__4__Impl : ( '}' ) ;
    public final void rule__OilObject__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4268:1: ( ( '}' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4269:1: ( '}' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4269:1: ( '}' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4270:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,55,FollowSets000.FOLLOW_55_in_rule__OilObject__Group__4__Impl8931); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4283:1: rule__OilObject__Group__5 : rule__OilObject__Group__5__Impl rule__OilObject__Group__6 ;
    public final void rule__OilObject__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4287:1: ( rule__OilObject__Group__5__Impl rule__OilObject__Group__6 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4288:2: rule__OilObject__Group__5__Impl rule__OilObject__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__5__Impl_in_rule__OilObject__Group__58962);
            rule__OilObject__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__6_in_rule__OilObject__Group__58965);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4295:1: rule__OilObject__Group__5__Impl : ( ( rule__OilObject__Group_5__0 )? ) ;
    public final void rule__OilObject__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4299:1: ( ( ( rule__OilObject__Group_5__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4300:1: ( ( rule__OilObject__Group_5__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4300:1: ( ( rule__OilObject__Group_5__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4301:1: ( rule__OilObject__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getGroup_5()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4302:1: ( rule__OilObject__Group_5__0 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==56) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4302:2: rule__OilObject__Group_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group_5__0_in_rule__OilObject__Group__5__Impl8992);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4312:1: rule__OilObject__Group__6 : rule__OilObject__Group__6__Impl ;
    public final void rule__OilObject__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4316:1: ( rule__OilObject__Group__6__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4317:2: rule__OilObject__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__6__Impl_in_rule__OilObject__Group__69023);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4323:1: rule__OilObject__Group__6__Impl : ( ';' ) ;
    public final void rule__OilObject__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4327:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4328:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4328:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4329:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getSemicolonKeyword_6()); 
            }
            match(input,52,FollowSets000.FOLLOW_52_in_rule__OilObject__Group__6__Impl9051); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4356:1: rule__OilObject__Group_5__0 : rule__OilObject__Group_5__0__Impl rule__OilObject__Group_5__1 ;
    public final void rule__OilObject__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4360:1: ( rule__OilObject__Group_5__0__Impl rule__OilObject__Group_5__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4361:2: rule__OilObject__Group_5__0__Impl rule__OilObject__Group_5__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group_5__0__Impl_in_rule__OilObject__Group_5__09096);
            rule__OilObject__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group_5__1_in_rule__OilObject__Group_5__09099);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4368:1: rule__OilObject__Group_5__0__Impl : ( ':' ) ;
    public final void rule__OilObject__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4372:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4373:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4373:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4374:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getColonKeyword_5_0()); 
            }
            match(input,56,FollowSets000.FOLLOW_56_in_rule__OilObject__Group_5__0__Impl9127); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4387:1: rule__OilObject__Group_5__1 : rule__OilObject__Group_5__1__Impl ;
    public final void rule__OilObject__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4391:1: ( rule__OilObject__Group_5__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4392:2: rule__OilObject__Group_5__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group_5__1__Impl_in_rule__OilObject__Group_5__19158);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4398:1: rule__OilObject__Group_5__1__Impl : ( ( rule__OilObject__DescriptionAssignment_5_1 ) ) ;
    public final void rule__OilObject__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4402:1: ( ( ( rule__OilObject__DescriptionAssignment_5_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4403:1: ( ( rule__OilObject__DescriptionAssignment_5_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4403:1: ( ( rule__OilObject__DescriptionAssignment_5_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4404:1: ( rule__OilObject__DescriptionAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getDescriptionAssignment_5_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4405:1: ( rule__OilObject__DescriptionAssignment_5_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4405:2: rule__OilObject__DescriptionAssignment_5_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__DescriptionAssignment_5_1_in_rule__OilObject__Group_5__1__Impl9185);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4419:1: rule__Parameter__Group__0 : rule__Parameter__Group__0__Impl rule__Parameter__Group__1 ;
    public final void rule__Parameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4423:1: ( rule__Parameter__Group__0__Impl rule__Parameter__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4424:2: rule__Parameter__Group__0__Impl rule__Parameter__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__0__Impl_in_rule__Parameter__Group__09219);
            rule__Parameter__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__1_in_rule__Parameter__Group__09222);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4431:1: rule__Parameter__Group__0__Impl : ( () ) ;
    public final void rule__Parameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4435:1: ( ( () ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4436:1: ( () )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4436:1: ( () )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4437:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getParameterAction_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4438:1: ()
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4440:1: 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4450:1: rule__Parameter__Group__1 : rule__Parameter__Group__1__Impl rule__Parameter__Group__2 ;
    public final void rule__Parameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4454:1: ( rule__Parameter__Group__1__Impl rule__Parameter__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4455:2: rule__Parameter__Group__1__Impl rule__Parameter__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__1__Impl_in_rule__Parameter__Group__19280);
            rule__Parameter__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__2_in_rule__Parameter__Group__19283);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4462:1: rule__Parameter__Group__1__Impl : ( ( rule__Parameter__TypeAssignment_1 ) ) ;
    public final void rule__Parameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4466:1: ( ( ( rule__Parameter__TypeAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4467:1: ( ( rule__Parameter__TypeAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4467:1: ( ( rule__Parameter__TypeAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4468:1: ( rule__Parameter__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getTypeAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4469:1: ( rule__Parameter__TypeAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4469:2: rule__Parameter__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__TypeAssignment_1_in_rule__Parameter__Group__1__Impl9310);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4479:1: rule__Parameter__Group__2 : rule__Parameter__Group__2__Impl rule__Parameter__Group__3 ;
    public final void rule__Parameter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4483:1: ( rule__Parameter__Group__2__Impl rule__Parameter__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4484:2: rule__Parameter__Group__2__Impl rule__Parameter__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__2__Impl_in_rule__Parameter__Group__29340);
            rule__Parameter__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__3_in_rule__Parameter__Group__29343);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4491:1: rule__Parameter__Group__2__Impl : ( '=' ) ;
    public final void rule__Parameter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4495:1: ( ( '=' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4496:1: ( '=' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4496:1: ( '=' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4497:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getEqualsSignKeyword_2()); 
            }
            match(input,51,FollowSets000.FOLLOW_51_in_rule__Parameter__Group__2__Impl9371); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4510:1: rule__Parameter__Group__3 : rule__Parameter__Group__3__Impl rule__Parameter__Group__4 ;
    public final void rule__Parameter__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4514:1: ( rule__Parameter__Group__3__Impl rule__Parameter__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4515:2: rule__Parameter__Group__3__Impl rule__Parameter__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__3__Impl_in_rule__Parameter__Group__39402);
            rule__Parameter__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__4_in_rule__Parameter__Group__39405);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4522:1: rule__Parameter__Group__3__Impl : ( ( rule__Parameter__Alternatives_3 ) ) ;
    public final void rule__Parameter__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4526:1: ( ( ( rule__Parameter__Alternatives_3 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4527:1: ( ( rule__Parameter__Alternatives_3 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4527:1: ( ( rule__Parameter__Alternatives_3 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4528:1: ( rule__Parameter__Alternatives_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getAlternatives_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4529:1: ( rule__Parameter__Alternatives_3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4529:2: rule__Parameter__Alternatives_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Alternatives_3_in_rule__Parameter__Group__3__Impl9432);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4539:1: rule__Parameter__Group__4 : rule__Parameter__Group__4__Impl rule__Parameter__Group__5 ;
    public final void rule__Parameter__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4543:1: ( rule__Parameter__Group__4__Impl rule__Parameter__Group__5 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4544:2: rule__Parameter__Group__4__Impl rule__Parameter__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__4__Impl_in_rule__Parameter__Group__49462);
            rule__Parameter__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__5_in_rule__Parameter__Group__49465);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4551:1: rule__Parameter__Group__4__Impl : ( ( rule__Parameter__Group_4__0 )? ) ;
    public final void rule__Parameter__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4555:1: ( ( ( rule__Parameter__Group_4__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4556:1: ( ( rule__Parameter__Group_4__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4556:1: ( ( rule__Parameter__Group_4__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4557:1: ( rule__Parameter__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getGroup_4()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4558:1: ( rule__Parameter__Group_4__0 )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==54) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4558:2: rule__Parameter__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_4__0_in_rule__Parameter__Group__4__Impl9492);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4568:1: rule__Parameter__Group__5 : rule__Parameter__Group__5__Impl rule__Parameter__Group__6 ;
    public final void rule__Parameter__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4572:1: ( rule__Parameter__Group__5__Impl rule__Parameter__Group__6 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4573:2: rule__Parameter__Group__5__Impl rule__Parameter__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__5__Impl_in_rule__Parameter__Group__59523);
            rule__Parameter__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__6_in_rule__Parameter__Group__59526);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4580:1: rule__Parameter__Group__5__Impl : ( ( rule__Parameter__Group_5__0 )? ) ;
    public final void rule__Parameter__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4584:1: ( ( ( rule__Parameter__Group_5__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4585:1: ( ( rule__Parameter__Group_5__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4585:1: ( ( rule__Parameter__Group_5__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4586:1: ( rule__Parameter__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getGroup_5()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4587:1: ( rule__Parameter__Group_5__0 )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==56) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4587:2: rule__Parameter__Group_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_5__0_in_rule__Parameter__Group__5__Impl9553);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4597:1: rule__Parameter__Group__6 : rule__Parameter__Group__6__Impl ;
    public final void rule__Parameter__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4601:1: ( rule__Parameter__Group__6__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4602:2: rule__Parameter__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__6__Impl_in_rule__Parameter__Group__69584);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4608:1: rule__Parameter__Group__6__Impl : ( ';' ) ;
    public final void rule__Parameter__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4612:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4613:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4613:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4614:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getSemicolonKeyword_6()); 
            }
            match(input,52,FollowSets000.FOLLOW_52_in_rule__Parameter__Group__6__Impl9612); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4641:1: rule__Parameter__Group_4__0 : rule__Parameter__Group_4__0__Impl rule__Parameter__Group_4__1 ;
    public final void rule__Parameter__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4645:1: ( rule__Parameter__Group_4__0__Impl rule__Parameter__Group_4__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4646:2: rule__Parameter__Group_4__0__Impl rule__Parameter__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_4__0__Impl_in_rule__Parameter__Group_4__09657);
            rule__Parameter__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_4__1_in_rule__Parameter__Group_4__09660);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4653:1: rule__Parameter__Group_4__0__Impl : ( '{' ) ;
    public final void rule__Parameter__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4657:1: ( ( '{' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4658:1: ( '{' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4658:1: ( '{' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4659:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getLeftCurlyBracketKeyword_4_0()); 
            }
            match(input,54,FollowSets000.FOLLOW_54_in_rule__Parameter__Group_4__0__Impl9688); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4672:1: rule__Parameter__Group_4__1 : rule__Parameter__Group_4__1__Impl rule__Parameter__Group_4__2 ;
    public final void rule__Parameter__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4676:1: ( rule__Parameter__Group_4__1__Impl rule__Parameter__Group_4__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4677:2: rule__Parameter__Group_4__1__Impl rule__Parameter__Group_4__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_4__1__Impl_in_rule__Parameter__Group_4__19719);
            rule__Parameter__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_4__2_in_rule__Parameter__Group_4__19722);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4684:1: rule__Parameter__Group_4__1__Impl : ( ( rule__Parameter__ParametersAssignment_4_1 )* ) ;
    public final void rule__Parameter__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4688:1: ( ( ( rule__Parameter__ParametersAssignment_4_1 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4689:1: ( ( rule__Parameter__ParametersAssignment_4_1 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4689:1: ( ( rule__Parameter__ParametersAssignment_4_1 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4690:1: ( rule__Parameter__ParametersAssignment_4_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getParametersAssignment_4_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4691:1: ( rule__Parameter__ParametersAssignment_4_1 )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==RULE_ID||(LA50_0>=13 && LA50_0<=47)) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4691:2: rule__Parameter__ParametersAssignment_4_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Parameter__ParametersAssignment_4_1_in_rule__Parameter__Group_4__1__Impl9749);
            	    rule__Parameter__ParametersAssignment_4_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop50;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4701:1: rule__Parameter__Group_4__2 : rule__Parameter__Group_4__2__Impl ;
    public final void rule__Parameter__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4705:1: ( rule__Parameter__Group_4__2__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4706:2: rule__Parameter__Group_4__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_4__2__Impl_in_rule__Parameter__Group_4__29780);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4712:1: rule__Parameter__Group_4__2__Impl : ( '}' ) ;
    public final void rule__Parameter__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4716:1: ( ( '}' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4717:1: ( '}' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4717:1: ( '}' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4718:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getRightCurlyBracketKeyword_4_2()); 
            }
            match(input,55,FollowSets000.FOLLOW_55_in_rule__Parameter__Group_4__2__Impl9808); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4737:1: rule__Parameter__Group_5__0 : rule__Parameter__Group_5__0__Impl rule__Parameter__Group_5__1 ;
    public final void rule__Parameter__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4741:1: ( rule__Parameter__Group_5__0__Impl rule__Parameter__Group_5__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4742:2: rule__Parameter__Group_5__0__Impl rule__Parameter__Group_5__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_5__0__Impl_in_rule__Parameter__Group_5__09845);
            rule__Parameter__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_5__1_in_rule__Parameter__Group_5__09848);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4749:1: rule__Parameter__Group_5__0__Impl : ( ':' ) ;
    public final void rule__Parameter__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4753:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4754:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4754:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4755:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getColonKeyword_5_0()); 
            }
            match(input,56,FollowSets000.FOLLOW_56_in_rule__Parameter__Group_5__0__Impl9876); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4768:1: rule__Parameter__Group_5__1 : rule__Parameter__Group_5__1__Impl ;
    public final void rule__Parameter__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4772:1: ( rule__Parameter__Group_5__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4773:2: rule__Parameter__Group_5__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_5__1__Impl_in_rule__Parameter__Group_5__19907);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4779:1: rule__Parameter__Group_5__1__Impl : ( ( rule__Parameter__DescriptionAssignment_5_1 ) ) ;
    public final void rule__Parameter__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4783:1: ( ( ( rule__Parameter__DescriptionAssignment_5_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4784:1: ( ( rule__Parameter__DescriptionAssignment_5_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4784:1: ( ( rule__Parameter__DescriptionAssignment_5_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4785:1: ( rule__Parameter__DescriptionAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getDescriptionAssignment_5_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4786:1: ( rule__Parameter__DescriptionAssignment_5_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4786:2: rule__Parameter__DescriptionAssignment_5_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__DescriptionAssignment_5_1_in_rule__Parameter__Group_5__1__Impl9934);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4800:1: rule__INT__Group__0 : rule__INT__Group__0__Impl rule__INT__Group__1 ;
    public final void rule__INT__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4804:1: ( rule__INT__Group__0__Impl rule__INT__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4805:2: rule__INT__Group__0__Impl rule__INT__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__INT__Group__0__Impl_in_rule__INT__Group__09968);
            rule__INT__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__INT__Group__1_in_rule__INT__Group__09971);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4812:1: rule__INT__Group__0__Impl : ( ( rule__INT__Alternatives_0 )? ) ;
    public final void rule__INT__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4816:1: ( ( ( rule__INT__Alternatives_0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4817:1: ( ( rule__INT__Alternatives_0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4817:1: ( ( rule__INT__Alternatives_0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4818:1: ( rule__INT__Alternatives_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getINTAccess().getAlternatives_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4819:1: ( rule__INT__Alternatives_0 )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( ((LA51_0>=48 && LA51_0<=49)) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4819:2: rule__INT__Alternatives_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__INT__Alternatives_0_in_rule__INT__Group__0__Impl9998);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4829:1: rule__INT__Group__1 : rule__INT__Group__1__Impl ;
    public final void rule__INT__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4833:1: ( rule__INT__Group__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4834:2: rule__INT__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__INT__Group__1__Impl_in_rule__INT__Group__110029);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4840:1: rule__INT__Group__1__Impl : ( ( rule__INT__Alternatives_1 ) ) ;
    public final void rule__INT__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4844:1: ( ( ( rule__INT__Alternatives_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4845:1: ( ( rule__INT__Alternatives_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4845:1: ( ( rule__INT__Alternatives_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4846:1: ( rule__INT__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getINTAccess().getAlternatives_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4847:1: ( rule__INT__Alternatives_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4847:2: rule__INT__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__INT__Alternatives_1_in_rule__INT__Group__1__Impl10056);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4861:1: rule__INT__Group_1_0__0 : rule__INT__Group_1_0__0__Impl rule__INT__Group_1_0__1 ;
    public final void rule__INT__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4865:1: ( rule__INT__Group_1_0__0__Impl rule__INT__Group_1_0__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4866:2: rule__INT__Group_1_0__0__Impl rule__INT__Group_1_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__INT__Group_1_0__0__Impl_in_rule__INT__Group_1_0__010090);
            rule__INT__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__INT__Group_1_0__1_in_rule__INT__Group_1_0__010093);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4873:1: rule__INT__Group_1_0__0__Impl : ( RULE_NON_ZERO_INT ) ;
    public final void rule__INT__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4877:1: ( ( RULE_NON_ZERO_INT ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4878:1: ( RULE_NON_ZERO_INT )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4878:1: ( RULE_NON_ZERO_INT )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4879:1: RULE_NON_ZERO_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getINTAccess().getNON_ZERO_INTTerminalRuleCall_1_0_0()); 
            }
            match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_rule__INT__Group_1_0__0__Impl10120); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4890:1: rule__INT__Group_1_0__1 : rule__INT__Group_1_0__1__Impl ;
    public final void rule__INT__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4894:1: ( rule__INT__Group_1_0__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4895:2: rule__INT__Group_1_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__INT__Group_1_0__1__Impl_in_rule__INT__Group_1_0__110149);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4901:1: rule__INT__Group_1_0__1__Impl : ( ( rule__INT__Alternatives_1_0_1 )* ) ;
    public final void rule__INT__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4905:1: ( ( ( rule__INT__Alternatives_1_0_1 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4906:1: ( ( rule__INT__Alternatives_1_0_1 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4906:1: ( ( rule__INT__Alternatives_1_0_1 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4907:1: ( rule__INT__Alternatives_1_0_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getINTAccess().getAlternatives_1_0_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4908:1: ( rule__INT__Alternatives_1_0_1 )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==RULE_ZERO_INT||LA52_0==RULE_NON_ZERO_INT) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4908:2: rule__INT__Alternatives_1_0_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__INT__Alternatives_1_0_1_in_rule__INT__Group_1_0__1__Impl10176);
            	    rule__INT__Alternatives_1_0_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop52;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4922:1: rule__DOUBLE__Group__0 : rule__DOUBLE__Group__0__Impl rule__DOUBLE__Group__1 ;
    public final void rule__DOUBLE__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4926:1: ( rule__DOUBLE__Group__0__Impl rule__DOUBLE__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4927:2: rule__DOUBLE__Group__0__Impl rule__DOUBLE__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Group__0__Impl_in_rule__DOUBLE__Group__010211);
            rule__DOUBLE__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Group__1_in_rule__DOUBLE__Group__010214);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4934:1: rule__DOUBLE__Group__0__Impl : ( ( rule__DOUBLE__Alternatives_0 )? ) ;
    public final void rule__DOUBLE__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4938:1: ( ( ( rule__DOUBLE__Alternatives_0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4939:1: ( ( rule__DOUBLE__Alternatives_0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4939:1: ( ( rule__DOUBLE__Alternatives_0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4940:1: ( rule__DOUBLE__Alternatives_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDOUBLEAccess().getAlternatives_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4941:1: ( rule__DOUBLE__Alternatives_0 )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( ((LA53_0>=48 && LA53_0<=49)) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4941:2: rule__DOUBLE__Alternatives_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Alternatives_0_in_rule__DOUBLE__Group__0__Impl10241);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4951:1: rule__DOUBLE__Group__1 : rule__DOUBLE__Group__1__Impl rule__DOUBLE__Group__2 ;
    public final void rule__DOUBLE__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4955:1: ( rule__DOUBLE__Group__1__Impl rule__DOUBLE__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4956:2: rule__DOUBLE__Group__1__Impl rule__DOUBLE__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Group__1__Impl_in_rule__DOUBLE__Group__110272);
            rule__DOUBLE__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Group__2_in_rule__DOUBLE__Group__110275);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4963:1: rule__DOUBLE__Group__1__Impl : ( ( rule__DOUBLE__Alternatives_1 ) ) ;
    public final void rule__DOUBLE__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4967:1: ( ( ( rule__DOUBLE__Alternatives_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4968:1: ( ( rule__DOUBLE__Alternatives_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4968:1: ( ( rule__DOUBLE__Alternatives_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4969:1: ( rule__DOUBLE__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDOUBLEAccess().getAlternatives_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4970:1: ( rule__DOUBLE__Alternatives_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4970:2: rule__DOUBLE__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Alternatives_1_in_rule__DOUBLE__Group__1__Impl10302);
            rule__DOUBLE__Alternatives_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDOUBLEAccess().getAlternatives_1()); 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4980:1: rule__DOUBLE__Group__2 : rule__DOUBLE__Group__2__Impl rule__DOUBLE__Group__3 ;
    public final void rule__DOUBLE__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4984:1: ( rule__DOUBLE__Group__2__Impl rule__DOUBLE__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4985:2: rule__DOUBLE__Group__2__Impl rule__DOUBLE__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Group__2__Impl_in_rule__DOUBLE__Group__210332);
            rule__DOUBLE__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Group__3_in_rule__DOUBLE__Group__210335);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4992:1: rule__DOUBLE__Group__2__Impl : ( ( '.' ) ) ;
    public final void rule__DOUBLE__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4996:1: ( ( ( '.' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4997:1: ( ( '.' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4997:1: ( ( '.' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4998:1: ( '.' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDOUBLEAccess().getFullStopKeyword_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4999:1: ( '.' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5000:2: '.'
            {
            match(input,61,FollowSets000.FOLLOW_61_in_rule__DOUBLE__Group__2__Impl10364); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDOUBLEAccess().getFullStopKeyword_2()); 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5011:1: rule__DOUBLE__Group__3 : rule__DOUBLE__Group__3__Impl ;
    public final void rule__DOUBLE__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5015:1: ( rule__DOUBLE__Group__3__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5016:2: rule__DOUBLE__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Group__3__Impl_in_rule__DOUBLE__Group__310396);
            rule__DOUBLE__Group__3__Impl();

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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5022:1: rule__DOUBLE__Group__3__Impl : ( ( ( rule__DOUBLE__Alternatives_3 ) ) ( ( rule__DOUBLE__Alternatives_3 )* ) ) ;
    public final void rule__DOUBLE__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5026:1: ( ( ( ( rule__DOUBLE__Alternatives_3 ) ) ( ( rule__DOUBLE__Alternatives_3 )* ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5027:1: ( ( ( rule__DOUBLE__Alternatives_3 ) ) ( ( rule__DOUBLE__Alternatives_3 )* ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5027:1: ( ( ( rule__DOUBLE__Alternatives_3 ) ) ( ( rule__DOUBLE__Alternatives_3 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5028:1: ( ( rule__DOUBLE__Alternatives_3 ) ) ( ( rule__DOUBLE__Alternatives_3 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5028:1: ( ( rule__DOUBLE__Alternatives_3 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5029:1: ( rule__DOUBLE__Alternatives_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDOUBLEAccess().getAlternatives_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5030:1: ( rule__DOUBLE__Alternatives_3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5030:2: rule__DOUBLE__Alternatives_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Alternatives_3_in_rule__DOUBLE__Group__3__Impl10425);
            rule__DOUBLE__Alternatives_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDOUBLEAccess().getAlternatives_3()); 
            }

            }

            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5033:1: ( ( rule__DOUBLE__Alternatives_3 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5034:1: ( rule__DOUBLE__Alternatives_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDOUBLEAccess().getAlternatives_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5035:1: ( rule__DOUBLE__Alternatives_3 )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==RULE_ZERO_INT||LA54_0==RULE_NON_ZERO_INT) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5035:2: rule__DOUBLE__Alternatives_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Alternatives_3_in_rule__DOUBLE__Group__3__Impl10437);
            	    rule__DOUBLE__Alternatives_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDOUBLEAccess().getAlternatives_3()); 
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
    // $ANTLR end "rule__DOUBLE__Group__3__Impl"


    // $ANTLR start "rule__DOUBLE__Group_1_1__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5054:1: rule__DOUBLE__Group_1_1__0 : rule__DOUBLE__Group_1_1__0__Impl rule__DOUBLE__Group_1_1__1 ;
    public final void rule__DOUBLE__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5058:1: ( rule__DOUBLE__Group_1_1__0__Impl rule__DOUBLE__Group_1_1__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5059:2: rule__DOUBLE__Group_1_1__0__Impl rule__DOUBLE__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Group_1_1__0__Impl_in_rule__DOUBLE__Group_1_1__010478);
            rule__DOUBLE__Group_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Group_1_1__1_in_rule__DOUBLE__Group_1_1__010481);
            rule__DOUBLE__Group_1_1__1();

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
    // $ANTLR end "rule__DOUBLE__Group_1_1__0"


    // $ANTLR start "rule__DOUBLE__Group_1_1__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5066:1: rule__DOUBLE__Group_1_1__0__Impl : ( RULE_NON_ZERO_INT ) ;
    public final void rule__DOUBLE__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5070:1: ( ( RULE_NON_ZERO_INT ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5071:1: ( RULE_NON_ZERO_INT )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5071:1: ( RULE_NON_ZERO_INT )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5072:1: RULE_NON_ZERO_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDOUBLEAccess().getNON_ZERO_INTTerminalRuleCall_1_1_0()); 
            }
            match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_rule__DOUBLE__Group_1_1__0__Impl10508); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDOUBLEAccess().getNON_ZERO_INTTerminalRuleCall_1_1_0()); 
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
    // $ANTLR end "rule__DOUBLE__Group_1_1__0__Impl"


    // $ANTLR start "rule__DOUBLE__Group_1_1__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5083:1: rule__DOUBLE__Group_1_1__1 : rule__DOUBLE__Group_1_1__1__Impl ;
    public final void rule__DOUBLE__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5087:1: ( rule__DOUBLE__Group_1_1__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5088:2: rule__DOUBLE__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Group_1_1__1__Impl_in_rule__DOUBLE__Group_1_1__110537);
            rule__DOUBLE__Group_1_1__1__Impl();

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
    // $ANTLR end "rule__DOUBLE__Group_1_1__1"


    // $ANTLR start "rule__DOUBLE__Group_1_1__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5094:1: rule__DOUBLE__Group_1_1__1__Impl : ( ( rule__DOUBLE__Alternatives_1_1_1 )* ) ;
    public final void rule__DOUBLE__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5098:1: ( ( ( rule__DOUBLE__Alternatives_1_1_1 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5099:1: ( ( rule__DOUBLE__Alternatives_1_1_1 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5099:1: ( ( rule__DOUBLE__Alternatives_1_1_1 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5100:1: ( rule__DOUBLE__Alternatives_1_1_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDOUBLEAccess().getAlternatives_1_1_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5101:1: ( rule__DOUBLE__Alternatives_1_1_1 )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==RULE_ZERO_INT||LA55_0==RULE_NON_ZERO_INT) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5101:2: rule__DOUBLE__Alternatives_1_1_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Alternatives_1_1_1_in_rule__DOUBLE__Group_1_1__1__Impl10564);
            	    rule__DOUBLE__Alternatives_1_1_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDOUBLEAccess().getAlternatives_1_1_1()); 
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
    // $ANTLR end "rule__DOUBLE__Group_1_1__1__Impl"


    // $ANTLR start "rule__OilFile__OilVersionAssignment_1_2"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5116:1: rule__OilFile__OilVersionAssignment_1_2 : ( RULE_STRING ) ;
    public final void rule__OilFile__OilVersionAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5120:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5121:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5121:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5122:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getOilVersionSTRINGTerminalRuleCall_1_2_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__OilFile__OilVersionAssignment_1_210604); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilFileAccess().getOilVersionSTRINGTerminalRuleCall_1_2_0()); 
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
    // $ANTLR end "rule__OilFile__OilVersionAssignment_1_2"


    // $ANTLR start "rule__OilFile__ImplementationAssignment_2"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5131:1: rule__OilFile__ImplementationAssignment_2 : ( ruleOilImplementation ) ;
    public final void rule__OilFile__ImplementationAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5135:1: ( ( ruleOilImplementation ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5136:1: ( ruleOilImplementation )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5136:1: ( ruleOilImplementation )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5137:1: ruleOilImplementation
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getImplementationOilImplementationParserRuleCall_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOilImplementation_in_rule__OilFile__ImplementationAssignment_210635);
            ruleOilImplementation();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilFileAccess().getImplementationOilImplementationParserRuleCall_2_0()); 
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
    // $ANTLR end "rule__OilFile__ImplementationAssignment_2"


    // $ANTLR start "rule__OilFile__ApplicationAssignment_3"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5146:1: rule__OilFile__ApplicationAssignment_3 : ( ruleOilApplication ) ;
    public final void rule__OilFile__ApplicationAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5150:1: ( ( ruleOilApplication ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5151:1: ( ruleOilApplication )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5151:1: ( ruleOilApplication )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5152:1: ruleOilApplication
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getApplicationOilApplicationParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOilApplication_in_rule__OilFile__ApplicationAssignment_310666);
            ruleOilApplication();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilFileAccess().getApplicationOilApplicationParserRuleCall_3_0()); 
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
    // $ANTLR end "rule__OilFile__ApplicationAssignment_3"


    // $ANTLR start "rule__OilImplementation__NameAssignment_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5161:1: rule__OilImplementation__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__OilImplementation__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5165:1: ( ( RULE_ID ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5166:1: ( RULE_ID )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5166:1: ( RULE_ID )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5167:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__OilImplementation__NameAssignment_110697); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5176:1: rule__OilImplementation__OilObjectsAssignment_3 : ( ruleOilObjectImpl ) ;
    public final void rule__OilImplementation__OilObjectsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5180:1: ( ( ruleOilObjectImpl ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5181:1: ( ruleOilObjectImpl )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5181:1: ( ruleOilObjectImpl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5182:1: ruleOilObjectImpl
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getOilObjectsOilObjectImplParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOilObjectImpl_in_rule__OilImplementation__OilObjectsAssignment_310728);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5191:1: rule__OilObjectImpl__TypeAssignment_0 : ( ruleObjectType ) ;
    public final void rule__OilObjectImpl__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5195:1: ( ( ruleObjectType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5196:1: ( ruleObjectType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5196:1: ( ruleObjectType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5197:1: ruleObjectType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getTypeObjectTypeEnumRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleObjectType_in_rule__OilObjectImpl__TypeAssignment_010759);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5206:1: rule__OilObjectImpl__ParametersAssignment_2 : ( ruleParameterType ) ;
    public final void rule__OilObjectImpl__ParametersAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5210:1: ( ( ruleParameterType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5211:1: ( ruleParameterType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5211:1: ( ruleParameterType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5212:1: ruleParameterType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getParametersParameterTypeParserRuleCall_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameterType_in_rule__OilObjectImpl__ParametersAssignment_210790);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5221:1: rule__OilObjectImpl__DescriptionAssignment_4_1 : ( RULE_STRING ) ;
    public final void rule__OilObjectImpl__DescriptionAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5225:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5226:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5226:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5227:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getDescriptionSTRINGTerminalRuleCall_4_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__OilObjectImpl__DescriptionAssignment_4_110821); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5236:1: rule__OilApplication__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__OilApplication__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5240:1: ( ( RULE_ID ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5241:1: ( RULE_ID )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5241:1: ( RULE_ID )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5242:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__OilApplication__NameAssignment_110852); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5251:1: rule__OilApplication__OilObjectsAssignment_3 : ( ruleOilObject ) ;
    public final void rule__OilApplication__OilObjectsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5255:1: ( ( ruleOilObject ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5256:1: ( ruleOilObject )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5256:1: ( ruleOilObject )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5257:1: ruleOilObject
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getOilObjectsOilObjectParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOilObject_in_rule__OilApplication__OilObjectsAssignment_310883);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5266:1: rule__OilApplication__DescriptionAssignment_5_1 : ( RULE_STRING ) ;
    public final void rule__OilApplication__DescriptionAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5270:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5271:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5271:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5272:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getDescriptionSTRINGTerminalRuleCall_5_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__OilApplication__DescriptionAssignment_5_110914); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5281:1: rule__ValueType__TypeAssignment_1 : ( ruleVType ) ;
    public final void rule__ValueType__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5285:1: ( ( ruleVType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5286:1: ( ruleVType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5286:1: ( ruleVType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5287:1: ruleVType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getTypeVTypeEnumRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVType_in_rule__ValueType__TypeAssignment_110945);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5296:1: rule__ValueType__WithAutoAssignment_2 : ( ( 'WITH_AUTO' ) ) ;
    public final void rule__ValueType__WithAutoAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5300:1: ( ( ( 'WITH_AUTO' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5301:1: ( ( 'WITH_AUTO' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5301:1: ( ( 'WITH_AUTO' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5302:1: ( 'WITH_AUTO' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getWithAutoWITH_AUTOKeyword_2_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5303:1: ( 'WITH_AUTO' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5304:1: 'WITH_AUTO'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getWithAutoWITH_AUTOKeyword_2_0()); 
            }
            match(input,62,FollowSets000.FOLLOW_62_in_rule__ValueType__WithAutoAssignment_210981); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5319:1: rule__ValueType__NameAssignment_3 : ( ruleSpecialId ) ;
    public final void rule__ValueType__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5323:1: ( ( ruleSpecialId ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5324:1: ( ruleSpecialId )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5324:1: ( ruleSpecialId )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5325:1: ruleSpecialId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getNameSpecialIdParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_rule__ValueType__NameAssignment_311020);
            ruleSpecialId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getNameSpecialIdParserRuleCall_3_0()); 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5334:1: rule__ValueType__MultiValueAssignment_4 : ( ( '[]' ) ) ;
    public final void rule__ValueType__MultiValueAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5338:1: ( ( ( '[]' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5339:1: ( ( '[]' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5339:1: ( ( '[]' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5340:1: ( '[]' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_4_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5341:1: ( '[]' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5342:1: '[]'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_4_0()); 
            }
            match(input,63,FollowSets000.FOLLOW_63_in_rule__ValueType__MultiValueAssignment_411056); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5357:1: rule__ValueType__DefaultAutoAssignment_5_1_0 : ( ( 'AUTO' ) ) ;
    public final void rule__ValueType__DefaultAutoAssignment_5_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5361:1: ( ( ( 'AUTO' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5362:1: ( ( 'AUTO' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5362:1: ( ( 'AUTO' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5363:1: ( 'AUTO' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getDefaultAutoAUTOKeyword_5_1_0_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5364:1: ( 'AUTO' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5365:1: 'AUTO'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getDefaultAutoAUTOKeyword_5_1_0_0()); 
            }
            match(input,64,FollowSets000.FOLLOW_64_in_rule__ValueType__DefaultAutoAssignment_5_1_011100); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5380:1: rule__ValueType__DefaultValueAssignment_5_1_1 : ( ( rule__ValueType__DefaultValueAlternatives_5_1_1_0 ) ) ;
    public final void rule__ValueType__DefaultValueAssignment_5_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5384:1: ( ( ( rule__ValueType__DefaultValueAlternatives_5_1_1_0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5385:1: ( ( rule__ValueType__DefaultValueAlternatives_5_1_1_0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5385:1: ( ( rule__ValueType__DefaultValueAlternatives_5_1_1_0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5386:1: ( rule__ValueType__DefaultValueAlternatives_5_1_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getDefaultValueAlternatives_5_1_1_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5387:1: ( rule__ValueType__DefaultValueAlternatives_5_1_1_0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5387:2: rule__ValueType__DefaultValueAlternatives_5_1_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__DefaultValueAlternatives_5_1_1_0_in_rule__ValueType__DefaultValueAssignment_5_1_111139);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5396:1: rule__ValueType__DescriptionAssignment_6_1 : ( RULE_STRING ) ;
    public final void rule__ValueType__DescriptionAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5400:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5401:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5401:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5402:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getDescriptionSTRINGTerminalRuleCall_6_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__ValueType__DescriptionAssignment_6_111172); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5411:1: rule__VariantType__TypeAssignment_1 : ( ruleEType ) ;
    public final void rule__VariantType__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5415:1: ( ( ruleEType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5416:1: ( ruleEType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5416:1: ( ruleEType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5417:1: ruleEType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getTypeETypeEnumRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEType_in_rule__VariantType__TypeAssignment_111203);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5426:1: rule__VariantType__WithAutoAssignment_2 : ( ( 'WITH_AUTO' ) ) ;
    public final void rule__VariantType__WithAutoAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5430:1: ( ( ( 'WITH_AUTO' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5431:1: ( ( 'WITH_AUTO' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5431:1: ( ( 'WITH_AUTO' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5432:1: ( 'WITH_AUTO' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getWithAutoWITH_AUTOKeyword_2_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5433:1: ( 'WITH_AUTO' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5434:1: 'WITH_AUTO'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getWithAutoWITH_AUTOKeyword_2_0()); 
            }
            match(input,62,FollowSets000.FOLLOW_62_in_rule__VariantType__WithAutoAssignment_211239); if (state.failed) return ;
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


    // $ANTLR start "rule__VariantType__ValuesAssignment_3_1_0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5449:1: rule__VariantType__ValuesAssignment_3_1_0 : ( ruleEnumeratorType ) ;
    public final void rule__VariantType__ValuesAssignment_3_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5453:1: ( ( ruleEnumeratorType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5454:1: ( ruleEnumeratorType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5454:1: ( ruleEnumeratorType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5455:1: ruleEnumeratorType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getValuesEnumeratorTypeParserRuleCall_3_1_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEnumeratorType_in_rule__VariantType__ValuesAssignment_3_1_011278);
            ruleEnumeratorType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getValuesEnumeratorTypeParserRuleCall_3_1_0_0()); 
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
    // $ANTLR end "rule__VariantType__ValuesAssignment_3_1_0"


    // $ANTLR start "rule__VariantType__ValuesAssignment_3_1_1_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5464:1: rule__VariantType__ValuesAssignment_3_1_1_1 : ( ruleEnumeratorType ) ;
    public final void rule__VariantType__ValuesAssignment_3_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5468:1: ( ( ruleEnumeratorType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5469:1: ( ruleEnumeratorType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5469:1: ( ruleEnumeratorType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5470:1: ruleEnumeratorType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getValuesEnumeratorTypeParserRuleCall_3_1_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEnumeratorType_in_rule__VariantType__ValuesAssignment_3_1_1_111309);
            ruleEnumeratorType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getValuesEnumeratorTypeParserRuleCall_3_1_1_1_0()); 
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
    // $ANTLR end "rule__VariantType__ValuesAssignment_3_1_1_1"


    // $ANTLR start "rule__VariantType__NameAssignment_4"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5479:1: rule__VariantType__NameAssignment_4 : ( ruleSpecialId ) ;
    public final void rule__VariantType__NameAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5483:1: ( ( ruleSpecialId ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5484:1: ( ruleSpecialId )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5484:1: ( ruleSpecialId )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5485:1: ruleSpecialId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getNameSpecialIdParserRuleCall_4_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_rule__VariantType__NameAssignment_411340);
            ruleSpecialId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getNameSpecialIdParserRuleCall_4_0()); 
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
    // $ANTLR end "rule__VariantType__NameAssignment_4"


    // $ANTLR start "rule__VariantType__MultiValueAssignment_5"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5494:1: rule__VariantType__MultiValueAssignment_5 : ( ( '[]' ) ) ;
    public final void rule__VariantType__MultiValueAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5498:1: ( ( ( '[]' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5499:1: ( ( '[]' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5499:1: ( ( '[]' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5500:1: ( '[]' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_5_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5501:1: ( '[]' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5502:1: '[]'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_5_0()); 
            }
            match(input,63,FollowSets000.FOLLOW_63_in_rule__VariantType__MultiValueAssignment_511376); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_5_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_5_0()); 
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
    // $ANTLR end "rule__VariantType__MultiValueAssignment_5"


    // $ANTLR start "rule__VariantType__DefaultAutoAssignment_6_1_0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5517:1: rule__VariantType__DefaultAutoAssignment_6_1_0 : ( ( 'AUTO' ) ) ;
    public final void rule__VariantType__DefaultAutoAssignment_6_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5521:1: ( ( ( 'AUTO' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5522:1: ( ( 'AUTO' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5522:1: ( ( 'AUTO' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5523:1: ( 'AUTO' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getDefaultAutoAUTOKeyword_6_1_0_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5524:1: ( 'AUTO' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5525:1: 'AUTO'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getDefaultAutoAUTOKeyword_6_1_0_0()); 
            }
            match(input,64,FollowSets000.FOLLOW_64_in_rule__VariantType__DefaultAutoAssignment_6_1_011420); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5540:1: rule__VariantType__DefaultValueAssignment_6_1_1 : ( RULE_ID ) ;
    public final void rule__VariantType__DefaultValueAssignment_6_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5544:1: ( ( RULE_ID ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5545:1: ( RULE_ID )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5545:1: ( RULE_ID )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5546:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getDefaultValueIDTerminalRuleCall_6_1_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__VariantType__DefaultValueAssignment_6_1_111459); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5555:1: rule__VariantType__DescriptionAssignment_7_1 : ( RULE_STRING ) ;
    public final void rule__VariantType__DescriptionAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5559:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5560:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5560:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5561:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getDescriptionSTRINGTerminalRuleCall_7_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__VariantType__DescriptionAssignment_7_111490); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5570:1: rule__EnumeratorType__NameAssignment_1 : ( ruleSpecialId ) ;
    public final void rule__EnumeratorType__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5574:1: ( ( ruleSpecialId ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5575:1: ( ruleSpecialId )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5575:1: ( ruleSpecialId )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5576:1: ruleSpecialId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getNameSpecialIdParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_rule__EnumeratorType__NameAssignment_111521);
            ruleSpecialId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumeratorTypeAccess().getNameSpecialIdParserRuleCall_1_0()); 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5585:1: rule__EnumeratorType__ParametersAssignment_2_1 : ( ruleParameterType ) ;
    public final void rule__EnumeratorType__ParametersAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5589:1: ( ( ruleParameterType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5590:1: ( ruleParameterType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5590:1: ( ruleParameterType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5591:1: ruleParameterType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getParametersParameterTypeParserRuleCall_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameterType_in_rule__EnumeratorType__ParametersAssignment_2_111552);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5600:1: rule__EnumeratorType__DescriptionAssignment_3_1 : ( RULE_STRING ) ;
    public final void rule__EnumeratorType__DescriptionAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5604:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5605:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5605:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5606:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getDescriptionSTRINGTerminalRuleCall_3_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__EnumeratorType__DescriptionAssignment_3_111583); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5615:1: rule__ReferenceType__TypeAssignment_1 : ( ruleObjectTypeRef ) ;
    public final void rule__ReferenceType__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5619:1: ( ( ruleObjectTypeRef ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5620:1: ( ruleObjectTypeRef )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5620:1: ( ruleObjectTypeRef )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5621:1: ruleObjectTypeRef
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getTypeObjectTypeRefEnumRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleObjectTypeRef_in_rule__ReferenceType__TypeAssignment_111614);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5630:1: rule__ReferenceType__WithAutoAssignment_2 : ( ( 'WITH_AUTO' ) ) ;
    public final void rule__ReferenceType__WithAutoAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5634:1: ( ( ( 'WITH_AUTO' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5635:1: ( ( 'WITH_AUTO' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5635:1: ( ( 'WITH_AUTO' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5636:1: ( 'WITH_AUTO' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getWithAutoWITH_AUTOKeyword_2_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5637:1: ( 'WITH_AUTO' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5638:1: 'WITH_AUTO'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getWithAutoWITH_AUTOKeyword_2_0()); 
            }
            match(input,62,FollowSets000.FOLLOW_62_in_rule__ReferenceType__WithAutoAssignment_211650); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5653:1: rule__ReferenceType__NameAssignment_3 : ( ruleSpecialId ) ;
    public final void rule__ReferenceType__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5657:1: ( ( ruleSpecialId ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5658:1: ( ruleSpecialId )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5658:1: ( ruleSpecialId )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5659:1: ruleSpecialId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getNameSpecialIdParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_rule__ReferenceType__NameAssignment_311689);
            ruleSpecialId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getNameSpecialIdParserRuleCall_3_0()); 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5668:1: rule__ReferenceType__MultiValueAssignment_4 : ( ( '[]' ) ) ;
    public final void rule__ReferenceType__MultiValueAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5672:1: ( ( ( '[]' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5673:1: ( ( '[]' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5673:1: ( ( '[]' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5674:1: ( '[]' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_4_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5675:1: ( '[]' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5676:1: '[]'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_4_0()); 
            }
            match(input,63,FollowSets000.FOLLOW_63_in_rule__ReferenceType__MultiValueAssignment_411725); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5691:1: rule__ReferenceType__DefaultAutoAssignment_5_1_0 : ( ( 'AUTO' ) ) ;
    public final void rule__ReferenceType__DefaultAutoAssignment_5_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5695:1: ( ( ( 'AUTO' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5696:1: ( ( 'AUTO' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5696:1: ( ( 'AUTO' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5697:1: ( 'AUTO' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getDefaultAutoAUTOKeyword_5_1_0_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5698:1: ( 'AUTO' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5699:1: 'AUTO'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getDefaultAutoAUTOKeyword_5_1_0_0()); 
            }
            match(input,64,FollowSets000.FOLLOW_64_in_rule__ReferenceType__DefaultAutoAssignment_5_1_011769); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5714:1: rule__ReferenceType__DefaultValueAssignment_5_1_1 : ( RULE_ID ) ;
    public final void rule__ReferenceType__DefaultValueAssignment_5_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5718:1: ( ( RULE_ID ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5719:1: ( RULE_ID )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5719:1: ( RULE_ID )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5720:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getDefaultValueIDTerminalRuleCall_5_1_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ReferenceType__DefaultValueAssignment_5_1_111808); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5729:1: rule__ReferenceType__DescriptionAssignment_6_1 : ( RULE_STRING ) ;
    public final void rule__ReferenceType__DescriptionAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5733:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5734:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5734:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5735:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getDescriptionSTRINGTerminalRuleCall_6_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__ReferenceType__DescriptionAssignment_6_111839); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5744:1: rule__OilObject__TypeAssignment_0 : ( ruleObjectType ) ;
    public final void rule__OilObject__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5748:1: ( ( ruleObjectType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5749:1: ( ruleObjectType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5749:1: ( ruleObjectType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5750:1: ruleObjectType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getTypeObjectTypeEnumRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleObjectType_in_rule__OilObject__TypeAssignment_011870);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5759:1: rule__OilObject__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__OilObject__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5763:1: ( ( RULE_ID ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5764:1: ( RULE_ID )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5764:1: ( RULE_ID )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5765:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__OilObject__NameAssignment_111901); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5774:1: rule__OilObject__ParametersAssignment_3 : ( ruleParameter ) ;
    public final void rule__OilObject__ParametersAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5778:1: ( ( ruleParameter ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5779:1: ( ruleParameter )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5779:1: ( ruleParameter )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5780:1: ruleParameter
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getParametersParameterParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_rule__OilObject__ParametersAssignment_311932);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5789:1: rule__OilObject__DescriptionAssignment_5_1 : ( RULE_STRING ) ;
    public final void rule__OilObject__DescriptionAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5793:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5794:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5794:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5795:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getDescriptionSTRINGTerminalRuleCall_5_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__OilObject__DescriptionAssignment_5_111963); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5804:1: rule__Parameter__TypeAssignment_1 : ( ( ruleSpecialId ) ) ;
    public final void rule__Parameter__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5808:1: ( ( ( ruleSpecialId ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5809:1: ( ( ruleSpecialId ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5809:1: ( ( ruleSpecialId ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5810:1: ( ruleSpecialId )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getTypeParameterTypeCrossReference_1_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5811:1: ( ruleSpecialId )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5812:1: ruleSpecialId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getTypeParameterTypeSpecialIdParserRuleCall_1_0_1()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_rule__Parameter__TypeAssignment_111998);
            ruleSpecialId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getTypeParameterTypeSpecialIdParserRuleCall_1_0_1()); 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5823:1: rule__Parameter__AutoAssignment_3_0 : ( ( 'AUTO' ) ) ;
    public final void rule__Parameter__AutoAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5827:1: ( ( ( 'AUTO' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5828:1: ( ( 'AUTO' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5828:1: ( ( 'AUTO' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5829:1: ( 'AUTO' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getAutoAUTOKeyword_3_0_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5830:1: ( 'AUTO' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5831:1: 'AUTO'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getAutoAUTOKeyword_3_0_0()); 
            }
            match(input,64,FollowSets000.FOLLOW_64_in_rule__Parameter__AutoAssignment_3_012038); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5846:1: rule__Parameter__ValueAssignment_3_1 : ( ruleGenericValue ) ;
    public final void rule__Parameter__ValueAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5850:1: ( ( ruleGenericValue ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5851:1: ( ruleGenericValue )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5851:1: ( ruleGenericValue )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5852:1: ruleGenericValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getValueGenericValueParserRuleCall_3_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleGenericValue_in_rule__Parameter__ValueAssignment_3_112077);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5861:1: rule__Parameter__ValueRefAssignment_3_2 : ( ( ruleSpecialId ) ) ;
    public final void rule__Parameter__ValueRefAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5865:1: ( ( ( ruleSpecialId ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5866:1: ( ( ruleSpecialId ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5866:1: ( ( ruleSpecialId ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5867:1: ( ruleSpecialId )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getValueRefParameterRefCrossReference_3_2_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5868:1: ( ruleSpecialId )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5869:1: ruleSpecialId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getValueRefParameterRefSpecialIdParserRuleCall_3_2_0_1()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_rule__Parameter__ValueRefAssignment_3_212112);
            ruleSpecialId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getValueRefParameterRefSpecialIdParserRuleCall_3_2_0_1()); 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5880:1: rule__Parameter__ParametersAssignment_4_1 : ( ruleParameter ) ;
    public final void rule__Parameter__ParametersAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5884:1: ( ( ruleParameter ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5885:1: ( ruleParameter )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5885:1: ( ruleParameter )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5886:1: ruleParameter
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getParametersParameterParserRuleCall_4_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_rule__Parameter__ParametersAssignment_4_112147);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5895:1: rule__Parameter__DescriptionAssignment_5_1 : ( RULE_STRING ) ;
    public final void rule__Parameter__DescriptionAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5899:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5900:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5900:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5901:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getDescriptionSTRINGTerminalRuleCall_5_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Parameter__DescriptionAssignment_5_112178); if (state.failed) return ;
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


    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA8_eotS =
        "\12\uffff";
    static final String DFA8_eofS =
        "\4\uffff\2\6\1\uffff\2\6\1\uffff";
    static final String DFA8_minS =
        "\1\5\1\uffff\3\6\1\64\1\uffff\2\6\1\uffff";
    static final String DFA8_maxS =
        "\1\61\1\uffff\2\10\2\75\1\uffff\2\75\1\uffff";
    static final String DFA8_acceptS =
        "\1\uffff\1\1\4\uffff\1\2\2\uffff\1\3";
    static final String DFA8_specialS =
        "\12\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\1\1\5\1\6\1\4\47\uffff\1\2\1\3",
            "",
            "\1\5\1\6\1\4",
            "\1\5\1\6\1\4",
            "\1\7\1\uffff\1\10\53\uffff\1\6\1\uffff\1\6\1\uffff\1\6\4\uffff"+
            "\1\11",
            "\1\6\1\uffff\1\6\1\uffff\1\6\4\uffff\1\11",
            "",
            "\1\7\1\uffff\1\10\53\uffff\1\6\1\uffff\1\6\1\uffff\1\6\4\uffff"+
            "\1\11",
            "\1\7\1\uffff\1\10\53\uffff\1\6\1\uffff\1\6\1\uffff\1\6\4\uffff"+
            "\1\11",
            ""
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "997:1: rule__GenericValue__Alternatives : ( ( RULE_STRING ) | ( ruleINT ) | ( ruleDOUBLE ) );";
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
        public static final BitSet FOLLOW_ruleSpecialId_in_entryRuleSpecialId727 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpecialId734 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SpecialId__Alternatives_in_ruleSpecialId760 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGenericValue_in_entryRuleGenericValue787 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGenericValue794 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GenericValue__Alternatives_in_ruleGenericValue820 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleINT_in_entryRuleINT847 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleINT854 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Group__0_in_ruleINT880 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDOUBLE_in_entryRuleDOUBLE907 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDOUBLE914 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DOUBLE__Group__0_in_ruleDOUBLE940 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VType__Alternatives_in_ruleVType977 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EType__Alternatives_in_ruleEType1013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ObjectType__Alternatives_in_ruleObjectType1049 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ObjectTypeRef__Alternatives_in_ruleObjectTypeRef1085 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueType_in_rule__ParameterType__Alternatives1120 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariantType_in_rule__ParameterType__Alternatives1137 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceType_in_rule__ParameterType__Alternatives1154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__DefaultAutoAssignment_5_1_0_in_rule__ValueType__Alternatives_5_11186 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__DefaultValueAssignment_5_1_1_in_rule__ValueType__Alternatives_5_11204 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGenericValue_in_rule__ValueType__DefaultValueAlternatives_5_1_1_01237 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ValueType__DefaultValueAlternatives_5_1_1_01254 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__DefaultAutoAssignment_6_1_0_in_rule__VariantType__Alternatives_6_11286 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__DefaultValueAssignment_6_1_1_in_rule__VariantType__Alternatives_6_11304 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__DefaultAutoAssignment_5_1_0_in_rule__ReferenceType__Alternatives_5_11337 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__DefaultValueAssignment_5_1_1_in_rule__ReferenceType__Alternatives_5_11355 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__AutoAssignment_3_0_in_rule__Parameter__Alternatives_31388 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__ValueAssignment_3_1_in_rule__Parameter__Alternatives_31406 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__ValueRefAssignment_3_2_in_rule__Parameter__Alternatives_31424 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__SpecialId__Alternatives1457 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__SpecialId__Alternatives1475 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__SpecialId__Alternatives1495 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__SpecialId__Alternatives1515 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__SpecialId__Alternatives1535 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__SpecialId__Alternatives1555 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__SpecialId__Alternatives1575 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__SpecialId__Alternatives1595 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__SpecialId__Alternatives1615 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__SpecialId__Alternatives1635 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__SpecialId__Alternatives1655 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__SpecialId__Alternatives1675 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__SpecialId__Alternatives1695 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__SpecialId__Alternatives1715 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__SpecialId__Alternatives1735 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__SpecialId__Alternatives1755 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__SpecialId__Alternatives1775 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__SpecialId__Alternatives1795 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__SpecialId__Alternatives1815 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__SpecialId__Alternatives1835 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__SpecialId__Alternatives1855 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__SpecialId__Alternatives1875 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__SpecialId__Alternatives1895 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__SpecialId__Alternatives1915 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_rule__SpecialId__Alternatives1935 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_rule__SpecialId__Alternatives1955 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_rule__SpecialId__Alternatives1975 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_rule__SpecialId__Alternatives1995 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_rule__SpecialId__Alternatives2015 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_rule__SpecialId__Alternatives2035 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_rule__SpecialId__Alternatives2055 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_rule__SpecialId__Alternatives2075 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_rule__SpecialId__Alternatives2095 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_rule__SpecialId__Alternatives2115 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_rule__SpecialId__Alternatives2135 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_rule__SpecialId__Alternatives2155 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__GenericValue__Alternatives2189 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleINT_in_rule__GenericValue__Alternatives2206 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDOUBLE_in_rule__GenericValue__Alternatives2223 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_rule__INT__Alternatives_02256 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_rule__INT__Alternatives_02276 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Group_1_0__0_in_rule__INT__Alternatives_12310 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_rule__INT__Alternatives_12328 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_HEX_in_rule__INT__Alternatives_12345 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_rule__INT__Alternatives_1_0_12377 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_rule__INT__Alternatives_1_0_12394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_rule__DOUBLE__Alternatives_02427 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_rule__DOUBLE__Alternatives_02447 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_rule__DOUBLE__Alternatives_12481 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DOUBLE__Group_1_1__0_in_rule__DOUBLE__Alternatives_12498 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_rule__DOUBLE__Alternatives_1_1_12531 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_rule__DOUBLE__Alternatives_1_1_12548 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_rule__DOUBLE__Alternatives_32580 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_rule__DOUBLE__Alternatives_32597 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__VType__Alternatives2630 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__VType__Alternatives2651 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__VType__Alternatives2672 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__VType__Alternatives2693 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__VType__Alternatives2714 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__VType__Alternatives2735 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__VType__Alternatives2756 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__EType__Alternatives2792 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__EType__Alternatives2813 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__ObjectType__Alternatives2849 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__ObjectType__Alternatives2870 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__ObjectType__Alternatives2891 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__ObjectType__Alternatives2912 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__ObjectType__Alternatives2933 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__ObjectType__Alternatives2954 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__ObjectType__Alternatives2975 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__ObjectType__Alternatives2996 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__ObjectType__Alternatives3017 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__ObjectType__Alternatives3038 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__ObjectType__Alternatives3059 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__ObjectType__Alternatives3080 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__ObjectType__Alternatives3101 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__ObjectTypeRef__Alternatives3137 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_rule__ObjectTypeRef__Alternatives3158 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_rule__ObjectTypeRef__Alternatives3179 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_rule__ObjectTypeRef__Alternatives3200 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_rule__ObjectTypeRef__Alternatives3221 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_rule__ObjectTypeRef__Alternatives3242 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_rule__ObjectTypeRef__Alternatives3263 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_rule__ObjectTypeRef__Alternatives3284 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_rule__ObjectTypeRef__Alternatives3305 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_rule__ObjectTypeRef__Alternatives3326 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_rule__ObjectTypeRef__Alternatives3347 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_rule__ObjectTypeRef__Alternatives3368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_rule__ObjectTypeRef__Alternatives3389 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group__0__Impl_in_rule__OilFile__Group__03422 = new BitSet(new long[]{0x0224000000000000L});
        public static final BitSet FOLLOW_rule__OilFile__Group__1_in_rule__OilFile__Group__03425 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group__1__Impl_in_rule__OilFile__Group__13483 = new BitSet(new long[]{0x0224000000000000L});
        public static final BitSet FOLLOW_rule__OilFile__Group__2_in_rule__OilFile__Group__13486 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group_1__0_in_rule__OilFile__Group__1__Impl3513 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group__2__Impl_in_rule__OilFile__Group__23544 = new BitSet(new long[]{0x0224000000000000L});
        public static final BitSet FOLLOW_rule__OilFile__Group__3_in_rule__OilFile__Group__23547 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__ImplementationAssignment_2_in_rule__OilFile__Group__2__Impl3574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group__3__Impl_in_rule__OilFile__Group__33605 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__ApplicationAssignment_3_in_rule__OilFile__Group__3__Impl3632 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group_1__0__Impl_in_rule__OilFile__Group_1__03671 = new BitSet(new long[]{0x0008000000000000L});
        public static final BitSet FOLLOW_rule__OilFile__Group_1__1_in_rule__OilFile__Group_1__03674 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_rule__OilFile__Group_1__0__Impl3702 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group_1__1__Impl_in_rule__OilFile__Group_1__13733 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__OilFile__Group_1__2_in_rule__OilFile__Group_1__13736 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_rule__OilFile__Group_1__1__Impl3764 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group_1__2__Impl_in_rule__OilFile__Group_1__23795 = new BitSet(new long[]{0x0010000000000000L});
        public static final BitSet FOLLOW_rule__OilFile__Group_1__3_in_rule__OilFile__Group_1__23798 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__OilVersionAssignment_1_2_in_rule__OilFile__Group_1__2__Impl3825 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group_1__3__Impl_in_rule__OilFile__Group_1__33855 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_rule__OilFile__Group_1__3__Impl3883 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__0__Impl_in_rule__OilImplementation__Group__03922 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__1_in_rule__OilImplementation__Group__03925 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_rule__OilImplementation__Group__0__Impl3953 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__1__Impl_in_rule__OilImplementation__Group__13984 = new BitSet(new long[]{0x0040000000000000L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__2_in_rule__OilImplementation__Group__13987 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilImplementation__NameAssignment_1_in_rule__OilImplementation__Group__1__Impl4014 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__2__Impl_in_rule__OilImplementation__Group__24044 = new BitSet(new long[]{0x00800007FFC00000L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__3_in_rule__OilImplementation__Group__24047 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_rule__OilImplementation__Group__2__Impl4075 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__3__Impl_in_rule__OilImplementation__Group__34106 = new BitSet(new long[]{0x00800007FFC00000L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__4_in_rule__OilImplementation__Group__34109 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilImplementation__OilObjectsAssignment_3_in_rule__OilImplementation__Group__3__Impl4136 = new BitSet(new long[]{0x00000007FFC00002L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__4__Impl_in_rule__OilImplementation__Group__44167 = new BitSet(new long[]{0x0010000000000000L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__5_in_rule__OilImplementation__Group__44170 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_rule__OilImplementation__Group__4__Impl4198 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__5__Impl_in_rule__OilImplementation__Group__54229 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_rule__OilImplementation__Group__5__Impl4257 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__0__Impl_in_rule__OilObjectImpl__Group__04300 = new BitSet(new long[]{0x0040000000000000L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__1_in_rule__OilObjectImpl__Group__04303 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__TypeAssignment_0_in_rule__OilObjectImpl__Group__0__Impl4330 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__1__Impl_in_rule__OilObjectImpl__Group__14360 = new BitSet(new long[]{0x0080FFF8003FE000L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__2_in_rule__OilObjectImpl__Group__14363 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_rule__OilObjectImpl__Group__1__Impl4391 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__2__Impl_in_rule__OilObjectImpl__Group__24422 = new BitSet(new long[]{0x0080FFF8003FE000L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__3_in_rule__OilObjectImpl__Group__24425 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__ParametersAssignment_2_in_rule__OilObjectImpl__Group__2__Impl4452 = new BitSet(new long[]{0x0000FFF8003FE002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__3__Impl_in_rule__OilObjectImpl__Group__34483 = new BitSet(new long[]{0x0110000000000000L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__4_in_rule__OilObjectImpl__Group__34486 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_rule__OilObjectImpl__Group__3__Impl4514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__4__Impl_in_rule__OilObjectImpl__Group__44545 = new BitSet(new long[]{0x0110000000000000L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__5_in_rule__OilObjectImpl__Group__44548 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group_4__0_in_rule__OilObjectImpl__Group__4__Impl4575 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__5__Impl_in_rule__OilObjectImpl__Group__54606 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_rule__OilObjectImpl__Group__5__Impl4634 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group_4__0__Impl_in_rule__OilObjectImpl__Group_4__04677 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group_4__1_in_rule__OilObjectImpl__Group_4__04680 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_rule__OilObjectImpl__Group_4__0__Impl4708 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group_4__1__Impl_in_rule__OilObjectImpl__Group_4__14739 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__DescriptionAssignment_4_1_in_rule__OilObjectImpl__Group_4__1__Impl4766 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__0__Impl_in_rule__OilApplication__Group__04800 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__1_in_rule__OilApplication__Group__04803 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_rule__OilApplication__Group__0__Impl4831 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__1__Impl_in_rule__OilApplication__Group__14862 = new BitSet(new long[]{0x0040000000000000L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__2_in_rule__OilApplication__Group__14865 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__NameAssignment_1_in_rule__OilApplication__Group__1__Impl4892 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__2__Impl_in_rule__OilApplication__Group__24922 = new BitSet(new long[]{0x00800007FFC00000L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__3_in_rule__OilApplication__Group__24925 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_rule__OilApplication__Group__2__Impl4953 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__3__Impl_in_rule__OilApplication__Group__34984 = new BitSet(new long[]{0x00800007FFC00000L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__4_in_rule__OilApplication__Group__34987 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__OilObjectsAssignment_3_in_rule__OilApplication__Group__3__Impl5014 = new BitSet(new long[]{0x00000007FFC00002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__4__Impl_in_rule__OilApplication__Group__45045 = new BitSet(new long[]{0x0110000000000000L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__5_in_rule__OilApplication__Group__45048 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_rule__OilApplication__Group__4__Impl5076 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__5__Impl_in_rule__OilApplication__Group__55107 = new BitSet(new long[]{0x0110000000000000L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__6_in_rule__OilApplication__Group__55110 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group_5__0_in_rule__OilApplication__Group__5__Impl5137 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__6__Impl_in_rule__OilApplication__Group__65168 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_rule__OilApplication__Group__6__Impl5196 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group_5__0__Impl_in_rule__OilApplication__Group_5__05241 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__OilApplication__Group_5__1_in_rule__OilApplication__Group_5__05244 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_rule__OilApplication__Group_5__0__Impl5272 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group_5__1__Impl_in_rule__OilApplication__Group_5__15303 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__DescriptionAssignment_5_1_in_rule__OilApplication__Group_5__1__Impl5330 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__0__Impl_in_rule__ValueType__Group__05364 = new BitSet(new long[]{0x00000000000FE000L});
        public static final BitSet FOLLOW_rule__ValueType__Group__1_in_rule__ValueType__Group__05367 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__1__Impl_in_rule__ValueType__Group__15425 = new BitSet(new long[]{0x4000FFFFFFFFE010L});
        public static final BitSet FOLLOW_rule__ValueType__Group__2_in_rule__ValueType__Group__15428 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__TypeAssignment_1_in_rule__ValueType__Group__1__Impl5455 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__2__Impl_in_rule__ValueType__Group__25485 = new BitSet(new long[]{0x4000FFFFFFFFE010L});
        public static final BitSet FOLLOW_rule__ValueType__Group__3_in_rule__ValueType__Group__25488 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__WithAutoAssignment_2_in_rule__ValueType__Group__2__Impl5515 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__3__Impl_in_rule__ValueType__Group__35546 = new BitSet(new long[]{0x8118000000000000L});
        public static final BitSet FOLLOW_rule__ValueType__Group__4_in_rule__ValueType__Group__35549 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__NameAssignment_3_in_rule__ValueType__Group__3__Impl5576 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__4__Impl_in_rule__ValueType__Group__45606 = new BitSet(new long[]{0x8118000000000000L});
        public static final BitSet FOLLOW_rule__ValueType__Group__5_in_rule__ValueType__Group__45609 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__MultiValueAssignment_4_in_rule__ValueType__Group__4__Impl5636 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__5__Impl_in_rule__ValueType__Group__55667 = new BitSet(new long[]{0x8118000000000000L});
        public static final BitSet FOLLOW_rule__ValueType__Group__6_in_rule__ValueType__Group__55670 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_5__0_in_rule__ValueType__Group__5__Impl5697 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__6__Impl_in_rule__ValueType__Group__65728 = new BitSet(new long[]{0x8118000000000000L});
        public static final BitSet FOLLOW_rule__ValueType__Group__7_in_rule__ValueType__Group__65731 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_6__0_in_rule__ValueType__Group__6__Impl5758 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__7__Impl_in_rule__ValueType__Group__75789 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_rule__ValueType__Group__7__Impl5817 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_5__0__Impl_in_rule__ValueType__Group_5__05864 = new BitSet(new long[]{0x00030000000001F0L,0x0000000000000001L});
        public static final BitSet FOLLOW_rule__ValueType__Group_5__1_in_rule__ValueType__Group_5__05867 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_rule__ValueType__Group_5__0__Impl5895 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_5__1__Impl_in_rule__ValueType__Group_5__15926 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Alternatives_5_1_in_rule__ValueType__Group_5__1__Impl5953 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_6__0__Impl_in_rule__ValueType__Group_6__05987 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__ValueType__Group_6__1_in_rule__ValueType__Group_6__05990 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_rule__ValueType__Group_6__0__Impl6018 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_6__1__Impl_in_rule__ValueType__Group_6__16049 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__DescriptionAssignment_6_1_in_rule__ValueType__Group_6__1__Impl6076 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__0__Impl_in_rule__VariantType__Group__06110 = new BitSet(new long[]{0x0000000000300000L});
        public static final BitSet FOLLOW_rule__VariantType__Group__1_in_rule__VariantType__Group__06113 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__1__Impl_in_rule__VariantType__Group__16171 = new BitSet(new long[]{0x4400FFFFFFFFE010L});
        public static final BitSet FOLLOW_rule__VariantType__Group__2_in_rule__VariantType__Group__16174 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__TypeAssignment_1_in_rule__VariantType__Group__1__Impl6201 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__2__Impl_in_rule__VariantType__Group__26231 = new BitSet(new long[]{0x4400FFFFFFFFE010L});
        public static final BitSet FOLLOW_rule__VariantType__Group__3_in_rule__VariantType__Group__26234 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__WithAutoAssignment_2_in_rule__VariantType__Group__2__Impl6261 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__3__Impl_in_rule__VariantType__Group__36292 = new BitSet(new long[]{0x4400FFFFFFFFE010L});
        public static final BitSet FOLLOW_rule__VariantType__Group__4_in_rule__VariantType__Group__36295 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3__0_in_rule__VariantType__Group__3__Impl6322 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__4__Impl_in_rule__VariantType__Group__46353 = new BitSet(new long[]{0x8118000000000000L});
        public static final BitSet FOLLOW_rule__VariantType__Group__5_in_rule__VariantType__Group__46356 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__NameAssignment_4_in_rule__VariantType__Group__4__Impl6383 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__5__Impl_in_rule__VariantType__Group__56413 = new BitSet(new long[]{0x8118000000000000L});
        public static final BitSet FOLLOW_rule__VariantType__Group__6_in_rule__VariantType__Group__56416 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__MultiValueAssignment_5_in_rule__VariantType__Group__5__Impl6443 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__6__Impl_in_rule__VariantType__Group__66474 = new BitSet(new long[]{0x8118000000000000L});
        public static final BitSet FOLLOW_rule__VariantType__Group__7_in_rule__VariantType__Group__66477 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_6__0_in_rule__VariantType__Group__6__Impl6504 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__7__Impl_in_rule__VariantType__Group__76535 = new BitSet(new long[]{0x8118000000000000L});
        public static final BitSet FOLLOW_rule__VariantType__Group__8_in_rule__VariantType__Group__76538 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_7__0_in_rule__VariantType__Group__7__Impl6565 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__8__Impl_in_rule__VariantType__Group__86596 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_rule__VariantType__Group__8__Impl6624 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3__0__Impl_in_rule__VariantType__Group_3__06673 = new BitSet(new long[]{0x4800FFFFFFFFE010L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3__1_in_rule__VariantType__Group_3__06676 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_rule__VariantType__Group_3__0__Impl6704 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3__1__Impl_in_rule__VariantType__Group_3__16735 = new BitSet(new long[]{0x4800FFFFFFFFE010L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3__2_in_rule__VariantType__Group_3__16738 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3_1__0_in_rule__VariantType__Group_3__1__Impl6765 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3__2__Impl_in_rule__VariantType__Group_3__26796 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_59_in_rule__VariantType__Group_3__2__Impl6824 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3_1__0__Impl_in_rule__VariantType__Group_3_1__06861 = new BitSet(new long[]{0x1000000000000000L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3_1__1_in_rule__VariantType__Group_3_1__06864 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__ValuesAssignment_3_1_0_in_rule__VariantType__Group_3_1__0__Impl6891 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3_1__1__Impl_in_rule__VariantType__Group_3_1__16921 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3_1_1__0_in_rule__VariantType__Group_3_1__1__Impl6948 = new BitSet(new long[]{0x1000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3_1_1__0__Impl_in_rule__VariantType__Group_3_1_1__06983 = new BitSet(new long[]{0x4000FFFFFFFFE010L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3_1_1__1_in_rule__VariantType__Group_3_1_1__06986 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_rule__VariantType__Group_3_1_1__0__Impl7014 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3_1_1__1__Impl_in_rule__VariantType__Group_3_1_1__17045 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__ValuesAssignment_3_1_1_1_in_rule__VariantType__Group_3_1_1__1__Impl7072 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_6__0__Impl_in_rule__VariantType__Group_6__07106 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000001L});
        public static final BitSet FOLLOW_rule__VariantType__Group_6__1_in_rule__VariantType__Group_6__07109 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_rule__VariantType__Group_6__0__Impl7137 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_6__1__Impl_in_rule__VariantType__Group_6__17168 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Alternatives_6_1_in_rule__VariantType__Group_6__1__Impl7195 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_7__0__Impl_in_rule__VariantType__Group_7__07229 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__VariantType__Group_7__1_in_rule__VariantType__Group_7__07232 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_rule__VariantType__Group_7__0__Impl7260 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_7__1__Impl_in_rule__VariantType__Group_7__17291 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__DescriptionAssignment_7_1_in_rule__VariantType__Group_7__1__Impl7318 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group__0__Impl_in_rule__EnumeratorType__Group__07352 = new BitSet(new long[]{0x4000FFFFFFFFE010L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group__1_in_rule__EnumeratorType__Group__07355 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group__1__Impl_in_rule__EnumeratorType__Group__17413 = new BitSet(new long[]{0x0140000000000000L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group__2_in_rule__EnumeratorType__Group__17416 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__NameAssignment_1_in_rule__EnumeratorType__Group__1__Impl7443 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group__2__Impl_in_rule__EnumeratorType__Group__27473 = new BitSet(new long[]{0x0140000000000000L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group__3_in_rule__EnumeratorType__Group__27476 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_2__0_in_rule__EnumeratorType__Group__2__Impl7503 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group__3__Impl_in_rule__EnumeratorType__Group__37534 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_3__0_in_rule__EnumeratorType__Group__3__Impl7561 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_2__0__Impl_in_rule__EnumeratorType__Group_2__07600 = new BitSet(new long[]{0x0080FFF8003FE000L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_2__1_in_rule__EnumeratorType__Group_2__07603 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_rule__EnumeratorType__Group_2__0__Impl7631 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_2__1__Impl_in_rule__EnumeratorType__Group_2__17662 = new BitSet(new long[]{0x0080FFF8003FE000L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_2__2_in_rule__EnumeratorType__Group_2__17665 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__ParametersAssignment_2_1_in_rule__EnumeratorType__Group_2__1__Impl7692 = new BitSet(new long[]{0x0000FFF8003FE002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_2__2__Impl_in_rule__EnumeratorType__Group_2__27723 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_rule__EnumeratorType__Group_2__2__Impl7751 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_3__0__Impl_in_rule__EnumeratorType__Group_3__07788 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_3__1_in_rule__EnumeratorType__Group_3__07791 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_rule__EnumeratorType__Group_3__0__Impl7819 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_3__1__Impl_in_rule__EnumeratorType__Group_3__17850 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__DescriptionAssignment_3_1_in_rule__EnumeratorType__Group_3__1__Impl7877 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__0__Impl_in_rule__ReferenceType__Group__07911 = new BitSet(new long[]{0x0000FFF8003FE000L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__1_in_rule__ReferenceType__Group__07914 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__1__Impl_in_rule__ReferenceType__Group__17972 = new BitSet(new long[]{0x4000FFFFFFFFE010L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__2_in_rule__ReferenceType__Group__17975 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__TypeAssignment_1_in_rule__ReferenceType__Group__1__Impl8002 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__2__Impl_in_rule__ReferenceType__Group__28032 = new BitSet(new long[]{0x4000FFFFFFFFE010L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__3_in_rule__ReferenceType__Group__28035 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__WithAutoAssignment_2_in_rule__ReferenceType__Group__2__Impl8062 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__3__Impl_in_rule__ReferenceType__Group__38093 = new BitSet(new long[]{0x8118000000000000L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__4_in_rule__ReferenceType__Group__38096 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__NameAssignment_3_in_rule__ReferenceType__Group__3__Impl8123 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__4__Impl_in_rule__ReferenceType__Group__48153 = new BitSet(new long[]{0x8118000000000000L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__5_in_rule__ReferenceType__Group__48156 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__MultiValueAssignment_4_in_rule__ReferenceType__Group__4__Impl8183 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__5__Impl_in_rule__ReferenceType__Group__58214 = new BitSet(new long[]{0x8118000000000000L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__6_in_rule__ReferenceType__Group__58217 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_5__0_in_rule__ReferenceType__Group__5__Impl8244 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__6__Impl_in_rule__ReferenceType__Group__68275 = new BitSet(new long[]{0x8118000000000000L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__7_in_rule__ReferenceType__Group__68278 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_6__0_in_rule__ReferenceType__Group__6__Impl8305 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__7__Impl_in_rule__ReferenceType__Group__78336 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_rule__ReferenceType__Group__7__Impl8364 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_5__0__Impl_in_rule__ReferenceType__Group_5__08411 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000001L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_5__1_in_rule__ReferenceType__Group_5__08414 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_rule__ReferenceType__Group_5__0__Impl8442 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_5__1__Impl_in_rule__ReferenceType__Group_5__18473 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Alternatives_5_1_in_rule__ReferenceType__Group_5__1__Impl8500 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_6__0__Impl_in_rule__ReferenceType__Group_6__08534 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_6__1_in_rule__ReferenceType__Group_6__08537 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_rule__ReferenceType__Group_6__0__Impl8565 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_6__1__Impl_in_rule__ReferenceType__Group_6__18596 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__DescriptionAssignment_6_1_in_rule__ReferenceType__Group_6__1__Impl8623 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group__0__Impl_in_rule__OilObject__Group__08657 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__OilObject__Group__1_in_rule__OilObject__Group__08660 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__TypeAssignment_0_in_rule__OilObject__Group__0__Impl8687 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group__1__Impl_in_rule__OilObject__Group__18717 = new BitSet(new long[]{0x0040000000000000L});
        public static final BitSet FOLLOW_rule__OilObject__Group__2_in_rule__OilObject__Group__18720 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__NameAssignment_1_in_rule__OilObject__Group__1__Impl8747 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group__2__Impl_in_rule__OilObject__Group__28777 = new BitSet(new long[]{0x4080FFFFFFFFE010L});
        public static final BitSet FOLLOW_rule__OilObject__Group__3_in_rule__OilObject__Group__28780 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_rule__OilObject__Group__2__Impl8808 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group__3__Impl_in_rule__OilObject__Group__38839 = new BitSet(new long[]{0x4080FFFFFFFFE010L});
        public static final BitSet FOLLOW_rule__OilObject__Group__4_in_rule__OilObject__Group__38842 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__ParametersAssignment_3_in_rule__OilObject__Group__3__Impl8869 = new BitSet(new long[]{0x4000FFFFFFFFE012L});
        public static final BitSet FOLLOW_rule__OilObject__Group__4__Impl_in_rule__OilObject__Group__48900 = new BitSet(new long[]{0x0110000000000000L});
        public static final BitSet FOLLOW_rule__OilObject__Group__5_in_rule__OilObject__Group__48903 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_rule__OilObject__Group__4__Impl8931 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group__5__Impl_in_rule__OilObject__Group__58962 = new BitSet(new long[]{0x0110000000000000L});
        public static final BitSet FOLLOW_rule__OilObject__Group__6_in_rule__OilObject__Group__58965 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group_5__0_in_rule__OilObject__Group__5__Impl8992 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group__6__Impl_in_rule__OilObject__Group__69023 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_rule__OilObject__Group__6__Impl9051 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group_5__0__Impl_in_rule__OilObject__Group_5__09096 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__OilObject__Group_5__1_in_rule__OilObject__Group_5__09099 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_rule__OilObject__Group_5__0__Impl9127 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group_5__1__Impl_in_rule__OilObject__Group_5__19158 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__DescriptionAssignment_5_1_in_rule__OilObject__Group_5__1__Impl9185 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__0__Impl_in_rule__Parameter__Group__09219 = new BitSet(new long[]{0x4000FFFFFFFFE010L});
        public static final BitSet FOLLOW_rule__Parameter__Group__1_in_rule__Parameter__Group__09222 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__1__Impl_in_rule__Parameter__Group__19280 = new BitSet(new long[]{0x0008000000000000L});
        public static final BitSet FOLLOW_rule__Parameter__Group__2_in_rule__Parameter__Group__19283 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__TypeAssignment_1_in_rule__Parameter__Group__1__Impl9310 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__2__Impl_in_rule__Parameter__Group__29340 = new BitSet(new long[]{0x4003FFFFFFFFE1F0L,0x0000000000000001L});
        public static final BitSet FOLLOW_rule__Parameter__Group__3_in_rule__Parameter__Group__29343 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_rule__Parameter__Group__2__Impl9371 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__3__Impl_in_rule__Parameter__Group__39402 = new BitSet(new long[]{0x0150000000000000L});
        public static final BitSet FOLLOW_rule__Parameter__Group__4_in_rule__Parameter__Group__39405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Alternatives_3_in_rule__Parameter__Group__3__Impl9432 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__4__Impl_in_rule__Parameter__Group__49462 = new BitSet(new long[]{0x0150000000000000L});
        public static final BitSet FOLLOW_rule__Parameter__Group__5_in_rule__Parameter__Group__49465 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group_4__0_in_rule__Parameter__Group__4__Impl9492 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__5__Impl_in_rule__Parameter__Group__59523 = new BitSet(new long[]{0x0150000000000000L});
        public static final BitSet FOLLOW_rule__Parameter__Group__6_in_rule__Parameter__Group__59526 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group_5__0_in_rule__Parameter__Group__5__Impl9553 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__6__Impl_in_rule__Parameter__Group__69584 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_rule__Parameter__Group__6__Impl9612 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group_4__0__Impl_in_rule__Parameter__Group_4__09657 = new BitSet(new long[]{0x4080FFFFFFFFE010L});
        public static final BitSet FOLLOW_rule__Parameter__Group_4__1_in_rule__Parameter__Group_4__09660 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_rule__Parameter__Group_4__0__Impl9688 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group_4__1__Impl_in_rule__Parameter__Group_4__19719 = new BitSet(new long[]{0x4080FFFFFFFFE010L});
        public static final BitSet FOLLOW_rule__Parameter__Group_4__2_in_rule__Parameter__Group_4__19722 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__ParametersAssignment_4_1_in_rule__Parameter__Group_4__1__Impl9749 = new BitSet(new long[]{0x4000FFFFFFFFE012L});
        public static final BitSet FOLLOW_rule__Parameter__Group_4__2__Impl_in_rule__Parameter__Group_4__29780 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_rule__Parameter__Group_4__2__Impl9808 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group_5__0__Impl_in_rule__Parameter__Group_5__09845 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Parameter__Group_5__1_in_rule__Parameter__Group_5__09848 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_rule__Parameter__Group_5__0__Impl9876 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group_5__1__Impl_in_rule__Parameter__Group_5__19907 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__DescriptionAssignment_5_1_in_rule__Parameter__Group_5__1__Impl9934 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Group__0__Impl_in_rule__INT__Group__09968 = new BitSet(new long[]{0x00030000000001C0L});
        public static final BitSet FOLLOW_rule__INT__Group__1_in_rule__INT__Group__09971 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Alternatives_0_in_rule__INT__Group__0__Impl9998 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Group__1__Impl_in_rule__INT__Group__110029 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Alternatives_1_in_rule__INT__Group__1__Impl10056 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Group_1_0__0__Impl_in_rule__INT__Group_1_0__010090 = new BitSet(new long[]{0x0000000000000140L});
        public static final BitSet FOLLOW_rule__INT__Group_1_0__1_in_rule__INT__Group_1_0__010093 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_rule__INT__Group_1_0__0__Impl10120 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Group_1_0__1__Impl_in_rule__INT__Group_1_0__110149 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Alternatives_1_0_1_in_rule__INT__Group_1_0__1__Impl10176 = new BitSet(new long[]{0x0000000000000142L});
        public static final BitSet FOLLOW_rule__DOUBLE__Group__0__Impl_in_rule__DOUBLE__Group__010211 = new BitSet(new long[]{0x00030000000001E0L});
        public static final BitSet FOLLOW_rule__DOUBLE__Group__1_in_rule__DOUBLE__Group__010214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DOUBLE__Alternatives_0_in_rule__DOUBLE__Group__0__Impl10241 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DOUBLE__Group__1__Impl_in_rule__DOUBLE__Group__110272 = new BitSet(new long[]{0x2000000000000000L});
        public static final BitSet FOLLOW_rule__DOUBLE__Group__2_in_rule__DOUBLE__Group__110275 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DOUBLE__Alternatives_1_in_rule__DOUBLE__Group__1__Impl10302 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DOUBLE__Group__2__Impl_in_rule__DOUBLE__Group__210332 = new BitSet(new long[]{0x0000000000000140L});
        public static final BitSet FOLLOW_rule__DOUBLE__Group__3_in_rule__DOUBLE__Group__210335 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_rule__DOUBLE__Group__2__Impl10364 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DOUBLE__Group__3__Impl_in_rule__DOUBLE__Group__310396 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DOUBLE__Alternatives_3_in_rule__DOUBLE__Group__3__Impl10425 = new BitSet(new long[]{0x0000000000000142L});
        public static final BitSet FOLLOW_rule__DOUBLE__Alternatives_3_in_rule__DOUBLE__Group__3__Impl10437 = new BitSet(new long[]{0x0000000000000142L});
        public static final BitSet FOLLOW_rule__DOUBLE__Group_1_1__0__Impl_in_rule__DOUBLE__Group_1_1__010478 = new BitSet(new long[]{0x0000000000000140L});
        public static final BitSet FOLLOW_rule__DOUBLE__Group_1_1__1_in_rule__DOUBLE__Group_1_1__010481 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_rule__DOUBLE__Group_1_1__0__Impl10508 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DOUBLE__Group_1_1__1__Impl_in_rule__DOUBLE__Group_1_1__110537 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DOUBLE__Alternatives_1_1_1_in_rule__DOUBLE__Group_1_1__1__Impl10564 = new BitSet(new long[]{0x0000000000000142L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__OilFile__OilVersionAssignment_1_210604 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilImplementation_in_rule__OilFile__ImplementationAssignment_210635 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilApplication_in_rule__OilFile__ApplicationAssignment_310666 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__OilImplementation__NameAssignment_110697 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilObjectImpl_in_rule__OilImplementation__OilObjectsAssignment_310728 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectType_in_rule__OilObjectImpl__TypeAssignment_010759 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameterType_in_rule__OilObjectImpl__ParametersAssignment_210790 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__OilObjectImpl__DescriptionAssignment_4_110821 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__OilApplication__NameAssignment_110852 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilObject_in_rule__OilApplication__OilObjectsAssignment_310883 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__OilApplication__DescriptionAssignment_5_110914 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVType_in_rule__ValueType__TypeAssignment_110945 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_rule__ValueType__WithAutoAssignment_210981 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecialId_in_rule__ValueType__NameAssignment_311020 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_63_in_rule__ValueType__MultiValueAssignment_411056 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_64_in_rule__ValueType__DefaultAutoAssignment_5_1_011100 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__DefaultValueAlternatives_5_1_1_0_in_rule__ValueType__DefaultValueAssignment_5_1_111139 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__ValueType__DescriptionAssignment_6_111172 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEType_in_rule__VariantType__TypeAssignment_111203 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_rule__VariantType__WithAutoAssignment_211239 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumeratorType_in_rule__VariantType__ValuesAssignment_3_1_011278 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumeratorType_in_rule__VariantType__ValuesAssignment_3_1_1_111309 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecialId_in_rule__VariantType__NameAssignment_411340 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_63_in_rule__VariantType__MultiValueAssignment_511376 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_64_in_rule__VariantType__DefaultAutoAssignment_6_1_011420 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__VariantType__DefaultValueAssignment_6_1_111459 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__VariantType__DescriptionAssignment_7_111490 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecialId_in_rule__EnumeratorType__NameAssignment_111521 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameterType_in_rule__EnumeratorType__ParametersAssignment_2_111552 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__EnumeratorType__DescriptionAssignment_3_111583 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectTypeRef_in_rule__ReferenceType__TypeAssignment_111614 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_rule__ReferenceType__WithAutoAssignment_211650 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecialId_in_rule__ReferenceType__NameAssignment_311689 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_63_in_rule__ReferenceType__MultiValueAssignment_411725 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_64_in_rule__ReferenceType__DefaultAutoAssignment_5_1_011769 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ReferenceType__DefaultValueAssignment_5_1_111808 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__ReferenceType__DescriptionAssignment_6_111839 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectType_in_rule__OilObject__TypeAssignment_011870 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__OilObject__NameAssignment_111901 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameter_in_rule__OilObject__ParametersAssignment_311932 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__OilObject__DescriptionAssignment_5_111963 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecialId_in_rule__Parameter__TypeAssignment_111998 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_64_in_rule__Parameter__AutoAssignment_3_012038 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGenericValue_in_rule__Parameter__ValueAssignment_3_112077 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecialId_in_rule__Parameter__ValueRefAssignment_3_212112 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameter_in_rule__Parameter__ParametersAssignment_4_112147 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Parameter__DescriptionAssignment_5_112178 = new BitSet(new long[]{0x0000000000000002L});
    }


}