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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_ZERO_INT", "RULE_HEX", "RULE_NON_ZERO_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'STRING'", "'UINT32'", "'INT32'", "'UINT64'", "'INT64'", "'FLOAT'", "'BOOLEAN'", "'ENUM'", "'OS'", "'ALARM'", "'APPMODE'", "'COUNTER'", "'COM'", "'EVENT'", "'IPDU'", "'ISR'", "'MESSAGE'", "'NETWORKMESSAGE'", "'NM'", "'RESOURCE'", "'TASK'", "'OS_TYPE'", "'ALARM_TYPE'", "'APPMODE_TYPE'", "'COUNTER_TYPE'", "'COM_TYPE'", "'EVENT_TYPE'", "'IPDU_TYPE'", "'ISR_TYPE'", "'MESSAGE_TYPE'", "'NETWORKMESSAGE_TYPE'", "'NM_TYPE'", "'RESOURCE_TYPE'", "'TASK_TYPE'", "'+'", "'-'", "'APPLICATION'", "'APPLICATION_TYPE'", "'OIL_VERSION'", "'='", "';'", "'IMPLEMENTATION'", "'{'", "'}'", "':'", "'CPU'", "','", "'..'", "'['", "']'", "'.'", "'WITH_AUTO'", "'[]'", "'AUTO'"
    };
    public static final int RULE_ID=4;
    public static final int T__66=66;
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


    // $ANTLR start "entryRuleValidValues"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:201:1: entryRuleValidValues : ruleValidValues EOF ;
    public final void entryRuleValidValues() throws RecognitionException {
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:202:1: ( ruleValidValues EOF )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:203:1: ruleValidValues EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValidValuesRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleValidValues_in_entryRuleValidValues367);
            ruleValidValues();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValidValuesRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleValidValues374); if (state.failed) return ;

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
    // $ANTLR end "entryRuleValidValues"


    // $ANTLR start "ruleValidValues"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:210:1: ruleValidValues : ( ( rule__ValidValues__Alternatives ) ) ;
    public final void ruleValidValues() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:214:2: ( ( ( rule__ValidValues__Alternatives ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:215:1: ( ( rule__ValidValues__Alternatives ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:215:1: ( ( rule__ValidValues__Alternatives ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:216:1: ( rule__ValidValues__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValidValuesAccess().getAlternatives()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:217:1: ( rule__ValidValues__Alternatives )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:217:2: rule__ValidValues__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValidValues__Alternatives_in_ruleValidValues400);
            rule__ValidValues__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValidValuesAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleValidValues"


    // $ANTLR start "entryRuleValueList"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:229:1: entryRuleValueList : ruleValueList EOF ;
    public final void entryRuleValueList() throws RecognitionException {
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:230:1: ( ruleValueList EOF )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:231:1: ruleValueList EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueListRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleValueList_in_entryRuleValueList427);
            ruleValueList();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueListRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleValueList434); if (state.failed) return ;

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
    // $ANTLR end "entryRuleValueList"


    // $ANTLR start "ruleValueList"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:238:1: ruleValueList : ( ( rule__ValueList__Group__0 ) ) ;
    public final void ruleValueList() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:242:2: ( ( ( rule__ValueList__Group__0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:243:1: ( ( rule__ValueList__Group__0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:243:1: ( ( rule__ValueList__Group__0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:244:1: ( rule__ValueList__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueListAccess().getGroup()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:245:1: ( rule__ValueList__Group__0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:245:2: rule__ValueList__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueList__Group__0_in_ruleValueList460);
            rule__ValueList__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueListAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleValueList"


    // $ANTLR start "entryRuleRange"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:257:1: entryRuleRange : ruleRange EOF ;
    public final void entryRuleRange() throws RecognitionException {
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:258:1: ( ruleRange EOF )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:259:1: ruleRange EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleRange_in_entryRuleRange487);
            ruleRange();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRangeRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRange494); if (state.failed) return ;

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
    // $ANTLR end "entryRuleRange"


    // $ANTLR start "ruleRange"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:266:1: ruleRange : ( ( rule__Range__Group__0 ) ) ;
    public final void ruleRange() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:270:2: ( ( ( rule__Range__Group__0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:271:1: ( ( rule__Range__Group__0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:271:1: ( ( rule__Range__Group__0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:272:1: ( rule__Range__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeAccess().getGroup()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:273:1: ( rule__Range__Group__0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:273:2: rule__Range__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Range__Group__0_in_ruleRange520);
            rule__Range__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRangeAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRange"


    // $ANTLR start "entryRuleValueType"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:285:1: entryRuleValueType : ruleValueType EOF ;
    public final void entryRuleValueType() throws RecognitionException {
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:286:1: ( ruleValueType EOF )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:287:1: ruleValueType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleValueType_in_entryRuleValueType547);
            ruleValueType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleValueType554); if (state.failed) return ;

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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:294:1: ruleValueType : ( ( rule__ValueType__Group__0 ) ) ;
    public final void ruleValueType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:298:2: ( ( ( rule__ValueType__Group__0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:299:1: ( ( rule__ValueType__Group__0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:299:1: ( ( rule__ValueType__Group__0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:300:1: ( rule__ValueType__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getGroup()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:301:1: ( rule__ValueType__Group__0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:301:2: rule__ValueType__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__0_in_ruleValueType580);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:313:1: entryRuleVariantType : ruleVariantType EOF ;
    public final void entryRuleVariantType() throws RecognitionException {
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:314:1: ( ruleVariantType EOF )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:315:1: ruleVariantType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVariantType_in_entryRuleVariantType607);
            ruleVariantType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariantTypeRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVariantType614); if (state.failed) return ;

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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:322:1: ruleVariantType : ( ( rule__VariantType__Group__0 ) ) ;
    public final void ruleVariantType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:326:2: ( ( ( rule__VariantType__Group__0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:327:1: ( ( rule__VariantType__Group__0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:327:1: ( ( rule__VariantType__Group__0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:328:1: ( rule__VariantType__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getGroup()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:329:1: ( rule__VariantType__Group__0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:329:2: rule__VariantType__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__0_in_ruleVariantType640);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:341:1: entryRuleEnumeratorType : ruleEnumeratorType EOF ;
    public final void entryRuleEnumeratorType() throws RecognitionException {
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:342:1: ( ruleEnumeratorType EOF )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:343:1: ruleEnumeratorType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEnumeratorType_in_entryRuleEnumeratorType667);
            ruleEnumeratorType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEnumeratorTypeRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumeratorType674); if (state.failed) return ;

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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:350:1: ruleEnumeratorType : ( ( rule__EnumeratorType__Group__0 ) ) ;
    public final void ruleEnumeratorType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:354:2: ( ( ( rule__EnumeratorType__Group__0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:355:1: ( ( rule__EnumeratorType__Group__0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:355:1: ( ( rule__EnumeratorType__Group__0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:356:1: ( rule__EnumeratorType__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getGroup()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:357:1: ( rule__EnumeratorType__Group__0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:357:2: rule__EnumeratorType__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group__0_in_ruleEnumeratorType700);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:369:1: entryRuleReferenceType : ruleReferenceType EOF ;
    public final void entryRuleReferenceType() throws RecognitionException {
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:370:1: ( ruleReferenceType EOF )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:371:1: ruleReferenceType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleReferenceType_in_entryRuleReferenceType727);
            ruleReferenceType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceType734); if (state.failed) return ;

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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:378:1: ruleReferenceType : ( ( rule__ReferenceType__Group__0 ) ) ;
    public final void ruleReferenceType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:382:2: ( ( ( rule__ReferenceType__Group__0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:383:1: ( ( rule__ReferenceType__Group__0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:383:1: ( ( rule__ReferenceType__Group__0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:384:1: ( rule__ReferenceType__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getGroup()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:385:1: ( rule__ReferenceType__Group__0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:385:2: rule__ReferenceType__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__0_in_ruleReferenceType760);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:397:1: entryRuleOilObject : ruleOilObject EOF ;
    public final void entryRuleOilObject() throws RecognitionException {
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:398:1: ( ruleOilObject EOF )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:399:1: ruleOilObject EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOilObject_in_entryRuleOilObject787);
            ruleOilObject();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOilObject794); if (state.failed) return ;

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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:406:1: ruleOilObject : ( ( rule__OilObject__Group__0 ) ) ;
    public final void ruleOilObject() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:410:2: ( ( ( rule__OilObject__Group__0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:411:1: ( ( rule__OilObject__Group__0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:411:1: ( ( rule__OilObject__Group__0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:412:1: ( rule__OilObject__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getGroup()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:413:1: ( rule__OilObject__Group__0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:413:2: rule__OilObject__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__0_in_ruleOilObject820);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:425:1: entryRuleParameter : ruleParameter EOF ;
    public final void entryRuleParameter() throws RecognitionException {
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:426:1: ( ruleParameter EOF )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:427:1: ruleParameter EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_entryRuleParameter847);
            ruleParameter();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParameter854); if (state.failed) return ;

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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:434:1: ruleParameter : ( ( rule__Parameter__Group__0 ) ) ;
    public final void ruleParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:438:2: ( ( ( rule__Parameter__Group__0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:439:1: ( ( rule__Parameter__Group__0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:439:1: ( ( rule__Parameter__Group__0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:440:1: ( rule__Parameter__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getGroup()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:441:1: ( rule__Parameter__Group__0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:441:2: rule__Parameter__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__0_in_ruleParameter880);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:453:1: entryRuleSpecialId : ruleSpecialId EOF ;
    public final void entryRuleSpecialId() throws RecognitionException {
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:454:1: ( ruleSpecialId EOF )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:455:1: ruleSpecialId EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSpecialIdRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_entryRuleSpecialId907);
            ruleSpecialId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSpecialIdRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpecialId914); if (state.failed) return ;

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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:462:1: ruleSpecialId : ( ( rule__SpecialId__Alternatives ) ) ;
    public final void ruleSpecialId() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:466:2: ( ( ( rule__SpecialId__Alternatives ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:467:1: ( ( rule__SpecialId__Alternatives ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:467:1: ( ( rule__SpecialId__Alternatives ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:468:1: ( rule__SpecialId__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSpecialIdAccess().getAlternatives()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:469:1: ( rule__SpecialId__Alternatives )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:469:2: rule__SpecialId__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__SpecialId__Alternatives_in_ruleSpecialId940);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:481:1: entryRuleGenericValue : ruleGenericValue EOF ;
    public final void entryRuleGenericValue() throws RecognitionException {
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:482:1: ( ruleGenericValue EOF )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:483:1: ruleGenericValue EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGenericValueRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleGenericValue_in_entryRuleGenericValue967);
            ruleGenericValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getGenericValueRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGenericValue974); if (state.failed) return ;

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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:490:1: ruleGenericValue : ( ( rule__GenericValue__Alternatives ) ) ;
    public final void ruleGenericValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:494:2: ( ( ( rule__GenericValue__Alternatives ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:495:1: ( ( rule__GenericValue__Alternatives ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:495:1: ( ( rule__GenericValue__Alternatives ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:496:1: ( rule__GenericValue__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGenericValueAccess().getAlternatives()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:497:1: ( rule__GenericValue__Alternatives )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:497:2: rule__GenericValue__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__GenericValue__Alternatives_in_ruleGenericValue1000);
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


    // $ANTLR start "entryRuleGenericNumber"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:509:1: entryRuleGenericNumber : ruleGenericNumber EOF ;
    public final void entryRuleGenericNumber() throws RecognitionException {
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:510:1: ( ruleGenericNumber EOF )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:511:1: ruleGenericNumber EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGenericNumberRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleGenericNumber_in_entryRuleGenericNumber1027);
            ruleGenericNumber();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getGenericNumberRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGenericNumber1034); if (state.failed) return ;

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
    // $ANTLR end "entryRuleGenericNumber"


    // $ANTLR start "ruleGenericNumber"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:518:1: ruleGenericNumber : ( ( rule__GenericNumber__Alternatives ) ) ;
    public final void ruleGenericNumber() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:522:2: ( ( ( rule__GenericNumber__Alternatives ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:523:1: ( ( rule__GenericNumber__Alternatives ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:523:1: ( ( rule__GenericNumber__Alternatives ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:524:1: ( rule__GenericNumber__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGenericNumberAccess().getAlternatives()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:525:1: ( rule__GenericNumber__Alternatives )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:525:2: rule__GenericNumber__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__GenericNumber__Alternatives_in_ruleGenericNumber1060);
            rule__GenericNumber__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getGenericNumberAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGenericNumber"


    // $ANTLR start "entryRuleINT"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:537:1: entryRuleINT : ruleINT EOF ;
    public final void entryRuleINT() throws RecognitionException {
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:538:1: ( ruleINT EOF )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:539:1: ruleINT EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getINTRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleINT_in_entryRuleINT1087);
            ruleINT();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getINTRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleINT1094); if (state.failed) return ;

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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:546:1: ruleINT : ( ( rule__INT__Group__0 ) ) ;
    public final void ruleINT() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:550:2: ( ( ( rule__INT__Group__0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:551:1: ( ( rule__INT__Group__0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:551:1: ( ( rule__INT__Group__0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:552:1: ( rule__INT__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getINTAccess().getGroup()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:553:1: ( rule__INT__Group__0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:553:2: rule__INT__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__INT__Group__0_in_ruleINT1120);
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


    // $ANTLR start "entryRuleFLOAT"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:565:1: entryRuleFLOAT : ruleFLOAT EOF ;
    public final void entryRuleFLOAT() throws RecognitionException {
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:566:1: ( ruleFLOAT EOF )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:567:1: ruleFLOAT EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFLOATRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFLOAT_in_entryRuleFLOAT1147);
            ruleFLOAT();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFLOATRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFLOAT1154); if (state.failed) return ;

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
    // $ANTLR end "entryRuleFLOAT"


    // $ANTLR start "ruleFLOAT"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:574:1: ruleFLOAT : ( ( rule__FLOAT__Group__0 ) ) ;
    public final void ruleFLOAT() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:578:2: ( ( ( rule__FLOAT__Group__0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:579:1: ( ( rule__FLOAT__Group__0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:579:1: ( ( rule__FLOAT__Group__0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:580:1: ( rule__FLOAT__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFLOATAccess().getGroup()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:581:1: ( rule__FLOAT__Group__0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:581:2: rule__FLOAT__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__FLOAT__Group__0_in_ruleFLOAT1180);
            rule__FLOAT__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFLOATAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFLOAT"


    // $ANTLR start "ruleVType"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:594:1: ruleVType : ( ( rule__VType__Alternatives ) ) ;
    public final void ruleVType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:598:1: ( ( ( rule__VType__Alternatives ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:599:1: ( ( rule__VType__Alternatives ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:599:1: ( ( rule__VType__Alternatives ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:600:1: ( rule__VType__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVTypeAccess().getAlternatives()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:601:1: ( rule__VType__Alternatives )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:601:2: rule__VType__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__VType__Alternatives_in_ruleVType1217);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:613:1: ruleEType : ( ( rule__EType__Alternatives ) ) ;
    public final void ruleEType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:617:1: ( ( ( rule__EType__Alternatives ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:618:1: ( ( rule__EType__Alternatives ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:618:1: ( ( rule__EType__Alternatives ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:619:1: ( rule__EType__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getETypeAccess().getAlternatives()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:620:1: ( rule__EType__Alternatives )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:620:2: rule__EType__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__EType__Alternatives_in_ruleEType1253);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:632:1: ruleObjectType : ( ( rule__ObjectType__Alternatives ) ) ;
    public final void ruleObjectType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:636:1: ( ( ( rule__ObjectType__Alternatives ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:637:1: ( ( rule__ObjectType__Alternatives ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:637:1: ( ( rule__ObjectType__Alternatives ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:638:1: ( rule__ObjectType__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectTypeAccess().getAlternatives()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:639:1: ( rule__ObjectType__Alternatives )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:639:2: rule__ObjectType__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__ObjectType__Alternatives_in_ruleObjectType1289);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:651:1: ruleObjectTypeRef : ( ( rule__ObjectTypeRef__Alternatives ) ) ;
    public final void ruleObjectTypeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:655:1: ( ( ( rule__ObjectTypeRef__Alternatives ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:656:1: ( ( rule__ObjectTypeRef__Alternatives ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:656:1: ( ( rule__ObjectTypeRef__Alternatives ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:657:1: ( rule__ObjectTypeRef__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectTypeRefAccess().getAlternatives()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:658:1: ( rule__ObjectTypeRef__Alternatives )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:658:2: rule__ObjectTypeRef__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__ObjectTypeRef__Alternatives_in_ruleObjectTypeRef1325);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:669:1: rule__ParameterType__Alternatives : ( ( ruleValueType ) | ( ruleVariantType ) | ( ruleReferenceType ) );
    public final void rule__ParameterType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:673:1: ( ( ruleValueType ) | ( ruleVariantType ) | ( ruleReferenceType ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                {
                alt1=1;
                }
                break;
            case 19:
            case 20:
                {
                alt1=2;
                }
                break;
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
            case 50:
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:674:1: ( ruleValueType )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:674:1: ( ruleValueType )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:675:1: ruleValueType
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getParameterTypeAccess().getValueTypeParserRuleCall_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleValueType_in_rule__ParameterType__Alternatives1360);
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:680:6: ( ruleVariantType )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:680:6: ( ruleVariantType )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:681:1: ruleVariantType
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getParameterTypeAccess().getVariantTypeParserRuleCall_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleVariantType_in_rule__ParameterType__Alternatives1377);
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:686:6: ( ruleReferenceType )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:686:6: ( ruleReferenceType )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:687:1: ruleReferenceType
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getParameterTypeAccess().getReferenceTypeParserRuleCall_2()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleReferenceType_in_rule__ParameterType__Alternatives1394);
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


    // $ANTLR start "rule__ValidValues__Alternatives"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:697:1: rule__ValidValues__Alternatives : ( ( ruleRange ) | ( ruleValueList ) );
    public final void rule__ValidValues__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:701:1: ( ( ruleRange ) | ( ruleValueList ) )
            int alt2=2;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:702:1: ( ruleRange )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:702:1: ( ruleRange )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:703:1: ruleRange
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValidValuesAccess().getRangeParserRuleCall_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleRange_in_rule__ValidValues__Alternatives1426);
                    ruleRange();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValidValuesAccess().getRangeParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:708:6: ( ruleValueList )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:708:6: ( ruleValueList )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:709:1: ruleValueList
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValidValuesAccess().getValueListParserRuleCall_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleValueList_in_rule__ValidValues__Alternatives1443);
                    ruleValueList();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValidValuesAccess().getValueListParserRuleCall_1()); 
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
    // $ANTLR end "rule__ValidValues__Alternatives"


    // $ANTLR start "rule__ValueType__Alternatives_6_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:719:1: rule__ValueType__Alternatives_6_1 : ( ( ( rule__ValueType__DefaultAutoAssignment_6_1_0 ) ) | ( ( rule__ValueType__DefaultValueAssignment_6_1_1 ) ) );
    public final void rule__ValueType__Alternatives_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:723:1: ( ( ( rule__ValueType__DefaultAutoAssignment_6_1_0 ) ) | ( ( rule__ValueType__DefaultValueAssignment_6_1_1 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==66) ) {
                alt3=1;
            }
            else if ( ((LA3_0>=RULE_ID && LA3_0<=RULE_NON_ZERO_INT)||(LA3_0>=47 && LA3_0<=48)) ) {
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:724:1: ( ( rule__ValueType__DefaultAutoAssignment_6_1_0 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:724:1: ( ( rule__ValueType__DefaultAutoAssignment_6_1_0 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:725:1: ( rule__ValueType__DefaultAutoAssignment_6_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getDefaultAutoAssignment_6_1_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:726:1: ( rule__ValueType__DefaultAutoAssignment_6_1_0 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:726:2: rule__ValueType__DefaultAutoAssignment_6_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ValueType__DefaultAutoAssignment_6_1_0_in_rule__ValueType__Alternatives_6_11475);
                    rule__ValueType__DefaultAutoAssignment_6_1_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueTypeAccess().getDefaultAutoAssignment_6_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:730:6: ( ( rule__ValueType__DefaultValueAssignment_6_1_1 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:730:6: ( ( rule__ValueType__DefaultValueAssignment_6_1_1 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:731:1: ( rule__ValueType__DefaultValueAssignment_6_1_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getDefaultValueAssignment_6_1_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:732:1: ( rule__ValueType__DefaultValueAssignment_6_1_1 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:732:2: rule__ValueType__DefaultValueAssignment_6_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ValueType__DefaultValueAssignment_6_1_1_in_rule__ValueType__Alternatives_6_11493);
                    rule__ValueType__DefaultValueAssignment_6_1_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueTypeAccess().getDefaultValueAssignment_6_1_1()); 
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
    // $ANTLR end "rule__ValueType__Alternatives_6_1"


    // $ANTLR start "rule__ValueType__DefaultValueAlternatives_6_1_1_0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:741:1: rule__ValueType__DefaultValueAlternatives_6_1_1_0 : ( ( ruleGenericValue ) | ( RULE_ID ) );
    public final void rule__ValueType__DefaultValueAlternatives_6_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:745:1: ( ( ruleGenericValue ) | ( RULE_ID ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=RULE_STRING && LA4_0<=RULE_NON_ZERO_INT)||(LA4_0>=47 && LA4_0<=48)) ) {
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:746:1: ( ruleGenericValue )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:746:1: ( ruleGenericValue )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:747:1: ruleGenericValue
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getDefaultValueGenericValueParserRuleCall_6_1_1_0_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleGenericValue_in_rule__ValueType__DefaultValueAlternatives_6_1_1_01526);
                    ruleGenericValue();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueTypeAccess().getDefaultValueGenericValueParserRuleCall_6_1_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:752:6: ( RULE_ID )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:752:6: ( RULE_ID )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:753:1: RULE_ID
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getDefaultValueIDTerminalRuleCall_6_1_1_0_1()); 
                    }
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ValueType__DefaultValueAlternatives_6_1_1_01543); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueTypeAccess().getDefaultValueIDTerminalRuleCall_6_1_1_0_1()); 
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
    // $ANTLR end "rule__ValueType__DefaultValueAlternatives_6_1_1_0"


    // $ANTLR start "rule__VariantType__Alternatives_6_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:763:1: rule__VariantType__Alternatives_6_1 : ( ( ( rule__VariantType__DefaultAutoAssignment_6_1_0 ) ) | ( ( rule__VariantType__DefaultValueAssignment_6_1_1 ) ) );
    public final void rule__VariantType__Alternatives_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:767:1: ( ( ( rule__VariantType__DefaultAutoAssignment_6_1_0 ) ) | ( ( rule__VariantType__DefaultValueAssignment_6_1_1 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==66) ) {
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:768:1: ( ( rule__VariantType__DefaultAutoAssignment_6_1_0 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:768:1: ( ( rule__VariantType__DefaultAutoAssignment_6_1_0 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:769:1: ( rule__VariantType__DefaultAutoAssignment_6_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVariantTypeAccess().getDefaultAutoAssignment_6_1_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:770:1: ( rule__VariantType__DefaultAutoAssignment_6_1_0 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:770:2: rule__VariantType__DefaultAutoAssignment_6_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__VariantType__DefaultAutoAssignment_6_1_0_in_rule__VariantType__Alternatives_6_11575);
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:774:6: ( ( rule__VariantType__DefaultValueAssignment_6_1_1 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:774:6: ( ( rule__VariantType__DefaultValueAssignment_6_1_1 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:775:1: ( rule__VariantType__DefaultValueAssignment_6_1_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVariantTypeAccess().getDefaultValueAssignment_6_1_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:776:1: ( rule__VariantType__DefaultValueAssignment_6_1_1 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:776:2: rule__VariantType__DefaultValueAssignment_6_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__VariantType__DefaultValueAssignment_6_1_1_in_rule__VariantType__Alternatives_6_11593);
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


    // $ANTLR start "rule__ReferenceType__Alternatives_4_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:785:1: rule__ReferenceType__Alternatives_4_1 : ( ( ( rule__ReferenceType__DefaultAutoAssignment_4_1_0 ) ) | ( ( rule__ReferenceType__DefaultValueAssignment_4_1_1 ) ) );
    public final void rule__ReferenceType__Alternatives_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:789:1: ( ( ( rule__ReferenceType__DefaultAutoAssignment_4_1_0 ) ) | ( ( rule__ReferenceType__DefaultValueAssignment_4_1_1 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==66) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_ID) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:790:1: ( ( rule__ReferenceType__DefaultAutoAssignment_4_1_0 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:790:1: ( ( rule__ReferenceType__DefaultAutoAssignment_4_1_0 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:791:1: ( rule__ReferenceType__DefaultAutoAssignment_4_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReferenceTypeAccess().getDefaultAutoAssignment_4_1_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:792:1: ( rule__ReferenceType__DefaultAutoAssignment_4_1_0 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:792:2: rule__ReferenceType__DefaultAutoAssignment_4_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__DefaultAutoAssignment_4_1_0_in_rule__ReferenceType__Alternatives_4_11626);
                    rule__ReferenceType__DefaultAutoAssignment_4_1_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getReferenceTypeAccess().getDefaultAutoAssignment_4_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:796:6: ( ( rule__ReferenceType__DefaultValueAssignment_4_1_1 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:796:6: ( ( rule__ReferenceType__DefaultValueAssignment_4_1_1 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:797:1: ( rule__ReferenceType__DefaultValueAssignment_4_1_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReferenceTypeAccess().getDefaultValueAssignment_4_1_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:798:1: ( rule__ReferenceType__DefaultValueAssignment_4_1_1 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:798:2: rule__ReferenceType__DefaultValueAssignment_4_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__DefaultValueAssignment_4_1_1_in_rule__ReferenceType__Alternatives_4_11644);
                    rule__ReferenceType__DefaultValueAssignment_4_1_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getReferenceTypeAccess().getDefaultValueAssignment_4_1_1()); 
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
    // $ANTLR end "rule__ReferenceType__Alternatives_4_1"


    // $ANTLR start "rule__Parameter__Alternatives_3"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:807:1: rule__Parameter__Alternatives_3 : ( ( ( rule__Parameter__AutoAssignment_3_0 ) ) | ( ( rule__Parameter__ValueAssignment_3_1 ) ) | ( ( rule__Parameter__ValueRefAssignment_3_2 ) ) );
    public final void rule__Parameter__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:811:1: ( ( ( rule__Parameter__AutoAssignment_3_0 ) ) | ( ( rule__Parameter__ValueAssignment_3_1 ) ) | ( ( rule__Parameter__ValueRefAssignment_3_2 ) ) )
            int alt7=3;
            switch ( input.LA(1) ) {
            case 66:
                {
                alt7=1;
                }
                break;
            case RULE_STRING:
            case RULE_ZERO_INT:
            case RULE_HEX:
            case RULE_NON_ZERO_INT:
            case 47:
            case 48:
                {
                alt7=2;
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
                {
                alt7=3;
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:812:1: ( ( rule__Parameter__AutoAssignment_3_0 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:812:1: ( ( rule__Parameter__AutoAssignment_3_0 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:813:1: ( rule__Parameter__AutoAssignment_3_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getParameterAccess().getAutoAssignment_3_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:814:1: ( rule__Parameter__AutoAssignment_3_0 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:814:2: rule__Parameter__AutoAssignment_3_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Parameter__AutoAssignment_3_0_in_rule__Parameter__Alternatives_31677);
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:818:6: ( ( rule__Parameter__ValueAssignment_3_1 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:818:6: ( ( rule__Parameter__ValueAssignment_3_1 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:819:1: ( rule__Parameter__ValueAssignment_3_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getParameterAccess().getValueAssignment_3_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:820:1: ( rule__Parameter__ValueAssignment_3_1 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:820:2: rule__Parameter__ValueAssignment_3_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Parameter__ValueAssignment_3_1_in_rule__Parameter__Alternatives_31695);
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:824:6: ( ( rule__Parameter__ValueRefAssignment_3_2 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:824:6: ( ( rule__Parameter__ValueRefAssignment_3_2 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:825:1: ( rule__Parameter__ValueRefAssignment_3_2 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getParameterAccess().getValueRefAssignment_3_2()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:826:1: ( rule__Parameter__ValueRefAssignment_3_2 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:826:2: rule__Parameter__ValueRefAssignment_3_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Parameter__ValueRefAssignment_3_2_in_rule__Parameter__Alternatives_31713);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:835:1: rule__SpecialId__Alternatives : ( ( RULE_ID ) | ( 'STRING' ) | ( 'UINT32' ) | ( 'INT32' ) | ( 'UINT64' ) | ( 'INT64' ) | ( 'FLOAT' ) | ( 'BOOLEAN' ) | ( 'ENUM' ) | ( 'OS' ) | ( 'ALARM' ) | ( 'APPMODE' ) | ( 'COUNTER' ) | ( 'COM' ) | ( 'EVENT' ) | ( 'IPDU' ) | ( 'ISR' ) | ( 'MESSAGE' ) | ( 'NETWORKMESSAGE' ) | ( 'NM' ) | ( 'RESOURCE' ) | ( 'TASK' ) | ( 'OS_TYPE' ) | ( 'ALARM_TYPE' ) | ( 'APPMODE_TYPE' ) | ( 'COUNTER_TYPE' ) | ( 'COM_TYPE' ) | ( 'EVENT_TYPE' ) | ( 'IPDU_TYPE' ) | ( 'ISR_TYPE' ) | ( 'MESSAGE_TYPE' ) | ( 'NETWORKMESSAGE_TYPE' ) | ( 'NM_TYPE' ) | ( 'RESOURCE_TYPE' ) | ( 'TASK_TYPE' ) );
    public final void rule__SpecialId__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:839:1: ( ( RULE_ID ) | ( 'STRING' ) | ( 'UINT32' ) | ( 'INT32' ) | ( 'UINT64' ) | ( 'INT64' ) | ( 'FLOAT' ) | ( 'BOOLEAN' ) | ( 'ENUM' ) | ( 'OS' ) | ( 'ALARM' ) | ( 'APPMODE' ) | ( 'COUNTER' ) | ( 'COM' ) | ( 'EVENT' ) | ( 'IPDU' ) | ( 'ISR' ) | ( 'MESSAGE' ) | ( 'NETWORKMESSAGE' ) | ( 'NM' ) | ( 'RESOURCE' ) | ( 'TASK' ) | ( 'OS_TYPE' ) | ( 'ALARM_TYPE' ) | ( 'APPMODE_TYPE' ) | ( 'COUNTER_TYPE' ) | ( 'COM_TYPE' ) | ( 'EVENT_TYPE' ) | ( 'IPDU_TYPE' ) | ( 'ISR_TYPE' ) | ( 'MESSAGE_TYPE' ) | ( 'NETWORKMESSAGE_TYPE' ) | ( 'NM_TYPE' ) | ( 'RESOURCE_TYPE' ) | ( 'TASK_TYPE' ) )
            int alt8=35;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt8=1;
                }
                break;
            case 13:
                {
                alt8=2;
                }
                break;
            case 14:
                {
                alt8=3;
                }
                break;
            case 15:
                {
                alt8=4;
                }
                break;
            case 16:
                {
                alt8=5;
                }
                break;
            case 17:
                {
                alt8=6;
                }
                break;
            case 18:
                {
                alt8=7;
                }
                break;
            case 19:
                {
                alt8=8;
                }
                break;
            case 20:
                {
                alt8=9;
                }
                break;
            case 21:
                {
                alt8=10;
                }
                break;
            case 22:
                {
                alt8=11;
                }
                break;
            case 23:
                {
                alt8=12;
                }
                break;
            case 24:
                {
                alt8=13;
                }
                break;
            case 25:
                {
                alt8=14;
                }
                break;
            case 26:
                {
                alt8=15;
                }
                break;
            case 27:
                {
                alt8=16;
                }
                break;
            case 28:
                {
                alt8=17;
                }
                break;
            case 29:
                {
                alt8=18;
                }
                break;
            case 30:
                {
                alt8=19;
                }
                break;
            case 31:
                {
                alt8=20;
                }
                break;
            case 32:
                {
                alt8=21;
                }
                break;
            case 33:
                {
                alt8=22;
                }
                break;
            case 34:
                {
                alt8=23;
                }
                break;
            case 35:
                {
                alt8=24;
                }
                break;
            case 36:
                {
                alt8=25;
                }
                break;
            case 37:
                {
                alt8=26;
                }
                break;
            case 38:
                {
                alt8=27;
                }
                break;
            case 39:
                {
                alt8=28;
                }
                break;
            case 40:
                {
                alt8=29;
                }
                break;
            case 41:
                {
                alt8=30;
                }
                break;
            case 42:
                {
                alt8=31;
                }
                break;
            case 43:
                {
                alt8=32;
                }
                break;
            case 44:
                {
                alt8=33;
                }
                break;
            case 45:
                {
                alt8=34;
                }
                break;
            case 46:
                {
                alt8=35;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:840:1: ( RULE_ID )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:840:1: ( RULE_ID )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:841:1: RULE_ID
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getIDTerminalRuleCall_0()); 
                    }
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__SpecialId__Alternatives1746); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getIDTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:846:6: ( 'STRING' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:846:6: ( 'STRING' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:847:1: 'STRING'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getSTRINGKeyword_1()); 
                    }
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__SpecialId__Alternatives1764); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getSTRINGKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:854:6: ( 'UINT32' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:854:6: ( 'UINT32' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:855:1: 'UINT32'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getUINT32Keyword_2()); 
                    }
                    match(input,14,FollowSets000.FOLLOW_14_in_rule__SpecialId__Alternatives1784); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getUINT32Keyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:862:6: ( 'INT32' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:862:6: ( 'INT32' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:863:1: 'INT32'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getINT32Keyword_3()); 
                    }
                    match(input,15,FollowSets000.FOLLOW_15_in_rule__SpecialId__Alternatives1804); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getINT32Keyword_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:870:6: ( 'UINT64' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:870:6: ( 'UINT64' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:871:1: 'UINT64'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getUINT64Keyword_4()); 
                    }
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__SpecialId__Alternatives1824); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getUINT64Keyword_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:878:6: ( 'INT64' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:878:6: ( 'INT64' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:879:1: 'INT64'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getINT64Keyword_5()); 
                    }
                    match(input,17,FollowSets000.FOLLOW_17_in_rule__SpecialId__Alternatives1844); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getINT64Keyword_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:886:6: ( 'FLOAT' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:886:6: ( 'FLOAT' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:887:1: 'FLOAT'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getFLOATKeyword_6()); 
                    }
                    match(input,18,FollowSets000.FOLLOW_18_in_rule__SpecialId__Alternatives1864); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getFLOATKeyword_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:894:6: ( 'BOOLEAN' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:894:6: ( 'BOOLEAN' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:895:1: 'BOOLEAN'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getBOOLEANKeyword_7()); 
                    }
                    match(input,19,FollowSets000.FOLLOW_19_in_rule__SpecialId__Alternatives1884); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getBOOLEANKeyword_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:902:6: ( 'ENUM' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:902:6: ( 'ENUM' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:903:1: 'ENUM'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getENUMKeyword_8()); 
                    }
                    match(input,20,FollowSets000.FOLLOW_20_in_rule__SpecialId__Alternatives1904); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getENUMKeyword_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:910:6: ( 'OS' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:910:6: ( 'OS' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:911:1: 'OS'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getOSKeyword_9()); 
                    }
                    match(input,21,FollowSets000.FOLLOW_21_in_rule__SpecialId__Alternatives1924); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getOSKeyword_9()); 
                    }

                    }


                    }
                    break;
                case 11 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:918:6: ( 'ALARM' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:918:6: ( 'ALARM' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:919:1: 'ALARM'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getALARMKeyword_10()); 
                    }
                    match(input,22,FollowSets000.FOLLOW_22_in_rule__SpecialId__Alternatives1944); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getALARMKeyword_10()); 
                    }

                    }


                    }
                    break;
                case 12 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:926:6: ( 'APPMODE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:926:6: ( 'APPMODE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:927:1: 'APPMODE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getAPPMODEKeyword_11()); 
                    }
                    match(input,23,FollowSets000.FOLLOW_23_in_rule__SpecialId__Alternatives1964); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getAPPMODEKeyword_11()); 
                    }

                    }


                    }
                    break;
                case 13 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:934:6: ( 'COUNTER' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:934:6: ( 'COUNTER' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:935:1: 'COUNTER'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getCOUNTERKeyword_12()); 
                    }
                    match(input,24,FollowSets000.FOLLOW_24_in_rule__SpecialId__Alternatives1984); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getCOUNTERKeyword_12()); 
                    }

                    }


                    }
                    break;
                case 14 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:942:6: ( 'COM' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:942:6: ( 'COM' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:943:1: 'COM'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getCOMKeyword_13()); 
                    }
                    match(input,25,FollowSets000.FOLLOW_25_in_rule__SpecialId__Alternatives2004); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getCOMKeyword_13()); 
                    }

                    }


                    }
                    break;
                case 15 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:950:6: ( 'EVENT' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:950:6: ( 'EVENT' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:951:1: 'EVENT'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getEVENTKeyword_14()); 
                    }
                    match(input,26,FollowSets000.FOLLOW_26_in_rule__SpecialId__Alternatives2024); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getEVENTKeyword_14()); 
                    }

                    }


                    }
                    break;
                case 16 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:958:6: ( 'IPDU' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:958:6: ( 'IPDU' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:959:1: 'IPDU'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getIPDUKeyword_15()); 
                    }
                    match(input,27,FollowSets000.FOLLOW_27_in_rule__SpecialId__Alternatives2044); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getIPDUKeyword_15()); 
                    }

                    }


                    }
                    break;
                case 17 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:966:6: ( 'ISR' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:966:6: ( 'ISR' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:967:1: 'ISR'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getISRKeyword_16()); 
                    }
                    match(input,28,FollowSets000.FOLLOW_28_in_rule__SpecialId__Alternatives2064); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getISRKeyword_16()); 
                    }

                    }


                    }
                    break;
                case 18 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:974:6: ( 'MESSAGE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:974:6: ( 'MESSAGE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:975:1: 'MESSAGE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getMESSAGEKeyword_17()); 
                    }
                    match(input,29,FollowSets000.FOLLOW_29_in_rule__SpecialId__Alternatives2084); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getMESSAGEKeyword_17()); 
                    }

                    }


                    }
                    break;
                case 19 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:982:6: ( 'NETWORKMESSAGE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:982:6: ( 'NETWORKMESSAGE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:983:1: 'NETWORKMESSAGE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getNETWORKMESSAGEKeyword_18()); 
                    }
                    match(input,30,FollowSets000.FOLLOW_30_in_rule__SpecialId__Alternatives2104); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getNETWORKMESSAGEKeyword_18()); 
                    }

                    }


                    }
                    break;
                case 20 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:990:6: ( 'NM' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:990:6: ( 'NM' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:991:1: 'NM'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getNMKeyword_19()); 
                    }
                    match(input,31,FollowSets000.FOLLOW_31_in_rule__SpecialId__Alternatives2124); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getNMKeyword_19()); 
                    }

                    }


                    }
                    break;
                case 21 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:998:6: ( 'RESOURCE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:998:6: ( 'RESOURCE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:999:1: 'RESOURCE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getRESOURCEKeyword_20()); 
                    }
                    match(input,32,FollowSets000.FOLLOW_32_in_rule__SpecialId__Alternatives2144); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getRESOURCEKeyword_20()); 
                    }

                    }


                    }
                    break;
                case 22 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1006:6: ( 'TASK' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1006:6: ( 'TASK' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1007:1: 'TASK'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getTASKKeyword_21()); 
                    }
                    match(input,33,FollowSets000.FOLLOW_33_in_rule__SpecialId__Alternatives2164); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getTASKKeyword_21()); 
                    }

                    }


                    }
                    break;
                case 23 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1014:6: ( 'OS_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1014:6: ( 'OS_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1015:1: 'OS_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getOS_TYPEKeyword_22()); 
                    }
                    match(input,34,FollowSets000.FOLLOW_34_in_rule__SpecialId__Alternatives2184); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getOS_TYPEKeyword_22()); 
                    }

                    }


                    }
                    break;
                case 24 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1022:6: ( 'ALARM_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1022:6: ( 'ALARM_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1023:1: 'ALARM_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getALARM_TYPEKeyword_23()); 
                    }
                    match(input,35,FollowSets000.FOLLOW_35_in_rule__SpecialId__Alternatives2204); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getALARM_TYPEKeyword_23()); 
                    }

                    }


                    }
                    break;
                case 25 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1030:6: ( 'APPMODE_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1030:6: ( 'APPMODE_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1031:1: 'APPMODE_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getAPPMODE_TYPEKeyword_24()); 
                    }
                    match(input,36,FollowSets000.FOLLOW_36_in_rule__SpecialId__Alternatives2224); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getAPPMODE_TYPEKeyword_24()); 
                    }

                    }


                    }
                    break;
                case 26 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1038:6: ( 'COUNTER_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1038:6: ( 'COUNTER_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1039:1: 'COUNTER_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getCOUNTER_TYPEKeyword_25()); 
                    }
                    match(input,37,FollowSets000.FOLLOW_37_in_rule__SpecialId__Alternatives2244); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getCOUNTER_TYPEKeyword_25()); 
                    }

                    }


                    }
                    break;
                case 27 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1046:6: ( 'COM_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1046:6: ( 'COM_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1047:1: 'COM_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getCOM_TYPEKeyword_26()); 
                    }
                    match(input,38,FollowSets000.FOLLOW_38_in_rule__SpecialId__Alternatives2264); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getCOM_TYPEKeyword_26()); 
                    }

                    }


                    }
                    break;
                case 28 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1054:6: ( 'EVENT_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1054:6: ( 'EVENT_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1055:1: 'EVENT_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getEVENT_TYPEKeyword_27()); 
                    }
                    match(input,39,FollowSets000.FOLLOW_39_in_rule__SpecialId__Alternatives2284); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getEVENT_TYPEKeyword_27()); 
                    }

                    }


                    }
                    break;
                case 29 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1062:6: ( 'IPDU_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1062:6: ( 'IPDU_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1063:1: 'IPDU_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getIPDU_TYPEKeyword_28()); 
                    }
                    match(input,40,FollowSets000.FOLLOW_40_in_rule__SpecialId__Alternatives2304); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getIPDU_TYPEKeyword_28()); 
                    }

                    }


                    }
                    break;
                case 30 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1070:6: ( 'ISR_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1070:6: ( 'ISR_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1071:1: 'ISR_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getISR_TYPEKeyword_29()); 
                    }
                    match(input,41,FollowSets000.FOLLOW_41_in_rule__SpecialId__Alternatives2324); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getISR_TYPEKeyword_29()); 
                    }

                    }


                    }
                    break;
                case 31 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1078:6: ( 'MESSAGE_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1078:6: ( 'MESSAGE_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1079:1: 'MESSAGE_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getMESSAGE_TYPEKeyword_30()); 
                    }
                    match(input,42,FollowSets000.FOLLOW_42_in_rule__SpecialId__Alternatives2344); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getMESSAGE_TYPEKeyword_30()); 
                    }

                    }


                    }
                    break;
                case 32 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1086:6: ( 'NETWORKMESSAGE_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1086:6: ( 'NETWORKMESSAGE_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1087:1: 'NETWORKMESSAGE_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getNETWORKMESSAGE_TYPEKeyword_31()); 
                    }
                    match(input,43,FollowSets000.FOLLOW_43_in_rule__SpecialId__Alternatives2364); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getNETWORKMESSAGE_TYPEKeyword_31()); 
                    }

                    }


                    }
                    break;
                case 33 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1094:6: ( 'NM_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1094:6: ( 'NM_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1095:1: 'NM_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getNM_TYPEKeyword_32()); 
                    }
                    match(input,44,FollowSets000.FOLLOW_44_in_rule__SpecialId__Alternatives2384); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getNM_TYPEKeyword_32()); 
                    }

                    }


                    }
                    break;
                case 34 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1102:6: ( 'RESOURCE_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1102:6: ( 'RESOURCE_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1103:1: 'RESOURCE_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getRESOURCE_TYPEKeyword_33()); 
                    }
                    match(input,45,FollowSets000.FOLLOW_45_in_rule__SpecialId__Alternatives2404); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getRESOURCE_TYPEKeyword_33()); 
                    }

                    }


                    }
                    break;
                case 35 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1110:6: ( 'TASK_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1110:6: ( 'TASK_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1111:1: 'TASK_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getTASK_TYPEKeyword_34()); 
                    }
                    match(input,46,FollowSets000.FOLLOW_46_in_rule__SpecialId__Alternatives2424); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getTASK_TYPEKeyword_34()); 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1123:1: rule__GenericValue__Alternatives : ( ( RULE_STRING ) | ( ruleINT ) | ( ruleFLOAT ) );
    public final void rule__GenericValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1127:1: ( ( RULE_STRING ) | ( ruleINT ) | ( ruleFLOAT ) )
            int alt9=3;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1128:1: ( RULE_STRING )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1128:1: ( RULE_STRING )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1129:1: RULE_STRING
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getGenericValueAccess().getSTRINGTerminalRuleCall_0()); 
                    }
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__GenericValue__Alternatives2458); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getGenericValueAccess().getSTRINGTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1134:6: ( ruleINT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1134:6: ( ruleINT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1135:1: ruleINT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getGenericValueAccess().getINTParserRuleCall_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleINT_in_rule__GenericValue__Alternatives2475);
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1140:6: ( ruleFLOAT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1140:6: ( ruleFLOAT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1141:1: ruleFLOAT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getGenericValueAccess().getFLOATParserRuleCall_2()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFLOAT_in_rule__GenericValue__Alternatives2492);
                    ruleFLOAT();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getGenericValueAccess().getFLOATParserRuleCall_2()); 
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


    // $ANTLR start "rule__GenericNumber__Alternatives"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1151:1: rule__GenericNumber__Alternatives : ( ( ruleINT ) | ( ruleFLOAT ) );
    public final void rule__GenericNumber__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1155:1: ( ( ruleINT ) | ( ruleFLOAT ) )
            int alt10=2;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1156:1: ( ruleINT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1156:1: ( ruleINT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1157:1: ruleINT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getGenericNumberAccess().getINTParserRuleCall_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleINT_in_rule__GenericNumber__Alternatives2524);
                    ruleINT();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getGenericNumberAccess().getINTParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1162:6: ( ruleFLOAT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1162:6: ( ruleFLOAT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1163:1: ruleFLOAT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getGenericNumberAccess().getFLOATParserRuleCall_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFLOAT_in_rule__GenericNumber__Alternatives2541);
                    ruleFLOAT();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getGenericNumberAccess().getFLOATParserRuleCall_1()); 
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
    // $ANTLR end "rule__GenericNumber__Alternatives"


    // $ANTLR start "rule__INT__Alternatives_0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1173:1: rule__INT__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__INT__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1177:1: ( ( '+' ) | ( '-' ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==47) ) {
                alt11=1;
            }
            else if ( (LA11_0==48) ) {
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1178:1: ( '+' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1178:1: ( '+' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1179:1: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getINTAccess().getPlusSignKeyword_0_0()); 
                    }
                    match(input,47,FollowSets000.FOLLOW_47_in_rule__INT__Alternatives_02574); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getINTAccess().getPlusSignKeyword_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1186:6: ( '-' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1186:6: ( '-' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1187:1: '-'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getINTAccess().getHyphenMinusKeyword_0_1()); 
                    }
                    match(input,48,FollowSets000.FOLLOW_48_in_rule__INT__Alternatives_02594); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1199:1: rule__INT__Alternatives_1 : ( ( ( rule__INT__Group_1_0__0 ) ) | ( RULE_ZERO_INT ) | ( RULE_HEX ) );
    public final void rule__INT__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1203:1: ( ( ( rule__INT__Group_1_0__0 ) ) | ( RULE_ZERO_INT ) | ( RULE_HEX ) )
            int alt12=3;
            switch ( input.LA(1) ) {
            case RULE_NON_ZERO_INT:
                {
                alt12=1;
                }
                break;
            case RULE_ZERO_INT:
                {
                alt12=2;
                }
                break;
            case RULE_HEX:
                {
                alt12=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1204:1: ( ( rule__INT__Group_1_0__0 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1204:1: ( ( rule__INT__Group_1_0__0 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1205:1: ( rule__INT__Group_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getINTAccess().getGroup_1_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1206:1: ( rule__INT__Group_1_0__0 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1206:2: rule__INT__Group_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__INT__Group_1_0__0_in_rule__INT__Alternatives_12628);
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1210:6: ( RULE_ZERO_INT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1210:6: ( RULE_ZERO_INT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1211:1: RULE_ZERO_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getINTAccess().getZERO_INTTerminalRuleCall_1_1()); 
                    }
                    match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_rule__INT__Alternatives_12646); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getINTAccess().getZERO_INTTerminalRuleCall_1_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1216:6: ( RULE_HEX )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1216:6: ( RULE_HEX )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1217:1: RULE_HEX
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getINTAccess().getHEXTerminalRuleCall_1_2()); 
                    }
                    match(input,RULE_HEX,FollowSets000.FOLLOW_RULE_HEX_in_rule__INT__Alternatives_12663); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1227:1: rule__INT__Alternatives_1_0_1 : ( ( RULE_ZERO_INT ) | ( RULE_NON_ZERO_INT ) );
    public final void rule__INT__Alternatives_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1231:1: ( ( RULE_ZERO_INT ) | ( RULE_NON_ZERO_INT ) )
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1232:1: ( RULE_ZERO_INT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1232:1: ( RULE_ZERO_INT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1233:1: RULE_ZERO_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getINTAccess().getZERO_INTTerminalRuleCall_1_0_1_0()); 
                    }
                    match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_rule__INT__Alternatives_1_0_12695); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getINTAccess().getZERO_INTTerminalRuleCall_1_0_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1238:6: ( RULE_NON_ZERO_INT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1238:6: ( RULE_NON_ZERO_INT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1239:1: RULE_NON_ZERO_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getINTAccess().getNON_ZERO_INTTerminalRuleCall_1_0_1_1()); 
                    }
                    match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_rule__INT__Alternatives_1_0_12712); if (state.failed) return ;
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


    // $ANTLR start "rule__FLOAT__Alternatives_0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1249:1: rule__FLOAT__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__FLOAT__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1253:1: ( ( '+' ) | ( '-' ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==47) ) {
                alt14=1;
            }
            else if ( (LA14_0==48) ) {
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1254:1: ( '+' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1254:1: ( '+' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1255:1: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFLOATAccess().getPlusSignKeyword_0_0()); 
                    }
                    match(input,47,FollowSets000.FOLLOW_47_in_rule__FLOAT__Alternatives_02745); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFLOATAccess().getPlusSignKeyword_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1262:6: ( '-' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1262:6: ( '-' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1263:1: '-'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFLOATAccess().getHyphenMinusKeyword_0_1()); 
                    }
                    match(input,48,FollowSets000.FOLLOW_48_in_rule__FLOAT__Alternatives_02765); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFLOATAccess().getHyphenMinusKeyword_0_1()); 
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
    // $ANTLR end "rule__FLOAT__Alternatives_0"


    // $ANTLR start "rule__FLOAT__Alternatives_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1275:1: rule__FLOAT__Alternatives_1 : ( ( RULE_ZERO_INT ) | ( ( rule__FLOAT__Group_1_1__0 ) ) );
    public final void rule__FLOAT__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1279:1: ( ( RULE_ZERO_INT ) | ( ( rule__FLOAT__Group_1_1__0 ) ) )
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1280:1: ( RULE_ZERO_INT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1280:1: ( RULE_ZERO_INT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1281:1: RULE_ZERO_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFLOATAccess().getZERO_INTTerminalRuleCall_1_0()); 
                    }
                    match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_rule__FLOAT__Alternatives_12799); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFLOATAccess().getZERO_INTTerminalRuleCall_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1286:6: ( ( rule__FLOAT__Group_1_1__0 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1286:6: ( ( rule__FLOAT__Group_1_1__0 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1287:1: ( rule__FLOAT__Group_1_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFLOATAccess().getGroup_1_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1288:1: ( rule__FLOAT__Group_1_1__0 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1288:2: rule__FLOAT__Group_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__FLOAT__Group_1_1__0_in_rule__FLOAT__Alternatives_12816);
                    rule__FLOAT__Group_1_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFLOATAccess().getGroup_1_1()); 
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
    // $ANTLR end "rule__FLOAT__Alternatives_1"


    // $ANTLR start "rule__FLOAT__Alternatives_1_1_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1297:1: rule__FLOAT__Alternatives_1_1_1 : ( ( RULE_ZERO_INT ) | ( RULE_NON_ZERO_INT ) );
    public final void rule__FLOAT__Alternatives_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1301:1: ( ( RULE_ZERO_INT ) | ( RULE_NON_ZERO_INT ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ZERO_INT) ) {
                alt16=1;
            }
            else if ( (LA16_0==RULE_NON_ZERO_INT) ) {
                alt16=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1302:1: ( RULE_ZERO_INT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1302:1: ( RULE_ZERO_INT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1303:1: RULE_ZERO_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFLOATAccess().getZERO_INTTerminalRuleCall_1_1_1_0()); 
                    }
                    match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_rule__FLOAT__Alternatives_1_1_12849); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFLOATAccess().getZERO_INTTerminalRuleCall_1_1_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1308:6: ( RULE_NON_ZERO_INT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1308:6: ( RULE_NON_ZERO_INT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1309:1: RULE_NON_ZERO_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFLOATAccess().getNON_ZERO_INTTerminalRuleCall_1_1_1_1()); 
                    }
                    match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_rule__FLOAT__Alternatives_1_1_12866); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFLOATAccess().getNON_ZERO_INTTerminalRuleCall_1_1_1_1()); 
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
    // $ANTLR end "rule__FLOAT__Alternatives_1_1_1"


    // $ANTLR start "rule__FLOAT__Alternatives_3"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1319:1: rule__FLOAT__Alternatives_3 : ( ( RULE_ZERO_INT ) | ( RULE_NON_ZERO_INT ) );
    public final void rule__FLOAT__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1323:1: ( ( RULE_ZERO_INT ) | ( RULE_NON_ZERO_INT ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ZERO_INT) ) {
                alt17=1;
            }
            else if ( (LA17_0==RULE_NON_ZERO_INT) ) {
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1324:1: ( RULE_ZERO_INT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1324:1: ( RULE_ZERO_INT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1325:1: RULE_ZERO_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFLOATAccess().getZERO_INTTerminalRuleCall_3_0()); 
                    }
                    match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_rule__FLOAT__Alternatives_32898); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFLOATAccess().getZERO_INTTerminalRuleCall_3_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1330:6: ( RULE_NON_ZERO_INT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1330:6: ( RULE_NON_ZERO_INT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1331:1: RULE_NON_ZERO_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFLOATAccess().getNON_ZERO_INTTerminalRuleCall_3_1()); 
                    }
                    match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_rule__FLOAT__Alternatives_32915); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFLOATAccess().getNON_ZERO_INTTerminalRuleCall_3_1()); 
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
    // $ANTLR end "rule__FLOAT__Alternatives_3"


    // $ANTLR start "rule__VType__Alternatives"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1341:1: rule__VType__Alternatives : ( ( ( 'STRING' ) ) | ( ( 'UINT32' ) ) | ( ( 'INT32' ) ) | ( ( 'UINT64' ) ) | ( ( 'INT64' ) ) | ( ( 'FLOAT' ) ) );
    public final void rule__VType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1345:1: ( ( ( 'STRING' ) ) | ( ( 'UINT32' ) ) | ( ( 'INT32' ) ) | ( ( 'UINT64' ) ) | ( ( 'INT64' ) ) | ( ( 'FLOAT' ) ) )
            int alt18=6;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt18=1;
                }
                break;
            case 14:
                {
                alt18=2;
                }
                break;
            case 15:
                {
                alt18=3;
                }
                break;
            case 16:
                {
                alt18=4;
                }
                break;
            case 17:
                {
                alt18=5;
                }
                break;
            case 18:
                {
                alt18=6;
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1346:1: ( ( 'STRING' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1346:1: ( ( 'STRING' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1347:1: ( 'STRING' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVTypeAccess().getSTRINGEnumLiteralDeclaration_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1348:1: ( 'STRING' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1348:3: 'STRING'
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__VType__Alternatives2948); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVTypeAccess().getSTRINGEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1353:6: ( ( 'UINT32' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1353:6: ( ( 'UINT32' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1354:1: ( 'UINT32' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVTypeAccess().getUINT32EnumLiteralDeclaration_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1355:1: ( 'UINT32' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1355:3: 'UINT32'
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_rule__VType__Alternatives2969); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVTypeAccess().getUINT32EnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1360:6: ( ( 'INT32' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1360:6: ( ( 'INT32' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1361:1: ( 'INT32' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVTypeAccess().getINT32EnumLiteralDeclaration_2()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1362:1: ( 'INT32' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1362:3: 'INT32'
                    {
                    match(input,15,FollowSets000.FOLLOW_15_in_rule__VType__Alternatives2990); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVTypeAccess().getINT32EnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1367:6: ( ( 'UINT64' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1367:6: ( ( 'UINT64' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1368:1: ( 'UINT64' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVTypeAccess().getUINT64EnumLiteralDeclaration_3()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1369:1: ( 'UINT64' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1369:3: 'UINT64'
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__VType__Alternatives3011); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVTypeAccess().getUINT64EnumLiteralDeclaration_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1374:6: ( ( 'INT64' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1374:6: ( ( 'INT64' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1375:1: ( 'INT64' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVTypeAccess().getINT64EnumLiteralDeclaration_4()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1376:1: ( 'INT64' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1376:3: 'INT64'
                    {
                    match(input,17,FollowSets000.FOLLOW_17_in_rule__VType__Alternatives3032); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVTypeAccess().getINT64EnumLiteralDeclaration_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1381:6: ( ( 'FLOAT' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1381:6: ( ( 'FLOAT' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1382:1: ( 'FLOAT' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVTypeAccess().getFLOATEnumLiteralDeclaration_5()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1383:1: ( 'FLOAT' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1383:3: 'FLOAT'
                    {
                    match(input,18,FollowSets000.FOLLOW_18_in_rule__VType__Alternatives3053); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVTypeAccess().getFLOATEnumLiteralDeclaration_5()); 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1393:1: rule__EType__Alternatives : ( ( ( 'BOOLEAN' ) ) | ( ( 'ENUM' ) ) );
    public final void rule__EType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1397:1: ( ( ( 'BOOLEAN' ) ) | ( ( 'ENUM' ) ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==19) ) {
                alt19=1;
            }
            else if ( (LA19_0==20) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1398:1: ( ( 'BOOLEAN' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1398:1: ( ( 'BOOLEAN' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1399:1: ( 'BOOLEAN' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getETypeAccess().getBOOLEANEnumLiteralDeclaration_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1400:1: ( 'BOOLEAN' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1400:3: 'BOOLEAN'
                    {
                    match(input,19,FollowSets000.FOLLOW_19_in_rule__EType__Alternatives3089); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getETypeAccess().getBOOLEANEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1405:6: ( ( 'ENUM' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1405:6: ( ( 'ENUM' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1406:1: ( 'ENUM' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getETypeAccess().getENUMEnumLiteralDeclaration_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1407:1: ( 'ENUM' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1407:3: 'ENUM'
                    {
                    match(input,20,FollowSets000.FOLLOW_20_in_rule__EType__Alternatives3110); if (state.failed) return ;

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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1417:1: rule__ObjectType__Alternatives : ( ( ( 'OS' ) ) | ( ( 'ALARM' ) ) | ( ( 'APPMODE' ) ) | ( ( 'COUNTER' ) ) | ( ( 'COM' ) ) | ( ( 'EVENT' ) ) | ( ( 'IPDU' ) ) | ( ( 'ISR' ) ) | ( ( 'MESSAGE' ) ) | ( ( 'NETWORKMESSAGE' ) ) | ( ( 'NM' ) ) | ( ( 'RESOURCE' ) ) | ( ( 'TASK' ) ) | ( ( 'APPLICATION' ) ) );
    public final void rule__ObjectType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1421:1: ( ( ( 'OS' ) ) | ( ( 'ALARM' ) ) | ( ( 'APPMODE' ) ) | ( ( 'COUNTER' ) ) | ( ( 'COM' ) ) | ( ( 'EVENT' ) ) | ( ( 'IPDU' ) ) | ( ( 'ISR' ) ) | ( ( 'MESSAGE' ) ) | ( ( 'NETWORKMESSAGE' ) ) | ( ( 'NM' ) ) | ( ( 'RESOURCE' ) ) | ( ( 'TASK' ) ) | ( ( 'APPLICATION' ) ) )
            int alt20=14;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt20=1;
                }
                break;
            case 22:
                {
                alt20=2;
                }
                break;
            case 23:
                {
                alt20=3;
                }
                break;
            case 24:
                {
                alt20=4;
                }
                break;
            case 25:
                {
                alt20=5;
                }
                break;
            case 26:
                {
                alt20=6;
                }
                break;
            case 27:
                {
                alt20=7;
                }
                break;
            case 28:
                {
                alt20=8;
                }
                break;
            case 29:
                {
                alt20=9;
                }
                break;
            case 30:
                {
                alt20=10;
                }
                break;
            case 31:
                {
                alt20=11;
                }
                break;
            case 32:
                {
                alt20=12;
                }
                break;
            case 33:
                {
                alt20=13;
                }
                break;
            case 49:
                {
                alt20=14;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1422:1: ( ( 'OS' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1422:1: ( ( 'OS' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1423:1: ( 'OS' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getOSEnumLiteralDeclaration_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1424:1: ( 'OS' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1424:3: 'OS'
                    {
                    match(input,21,FollowSets000.FOLLOW_21_in_rule__ObjectType__Alternatives3146); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getOSEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1429:6: ( ( 'ALARM' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1429:6: ( ( 'ALARM' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1430:1: ( 'ALARM' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getALARMEnumLiteralDeclaration_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1431:1: ( 'ALARM' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1431:3: 'ALARM'
                    {
                    match(input,22,FollowSets000.FOLLOW_22_in_rule__ObjectType__Alternatives3167); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getALARMEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1436:6: ( ( 'APPMODE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1436:6: ( ( 'APPMODE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1437:1: ( 'APPMODE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getAPPMODEEnumLiteralDeclaration_2()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1438:1: ( 'APPMODE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1438:3: 'APPMODE'
                    {
                    match(input,23,FollowSets000.FOLLOW_23_in_rule__ObjectType__Alternatives3188); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getAPPMODEEnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1443:6: ( ( 'COUNTER' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1443:6: ( ( 'COUNTER' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1444:1: ( 'COUNTER' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getCOUNTEREnumLiteralDeclaration_3()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1445:1: ( 'COUNTER' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1445:3: 'COUNTER'
                    {
                    match(input,24,FollowSets000.FOLLOW_24_in_rule__ObjectType__Alternatives3209); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getCOUNTEREnumLiteralDeclaration_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1450:6: ( ( 'COM' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1450:6: ( ( 'COM' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1451:1: ( 'COM' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getCOMEnumLiteralDeclaration_4()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1452:1: ( 'COM' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1452:3: 'COM'
                    {
                    match(input,25,FollowSets000.FOLLOW_25_in_rule__ObjectType__Alternatives3230); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getCOMEnumLiteralDeclaration_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1457:6: ( ( 'EVENT' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1457:6: ( ( 'EVENT' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1458:1: ( 'EVENT' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getEVENTEnumLiteralDeclaration_5()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1459:1: ( 'EVENT' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1459:3: 'EVENT'
                    {
                    match(input,26,FollowSets000.FOLLOW_26_in_rule__ObjectType__Alternatives3251); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getEVENTEnumLiteralDeclaration_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1464:6: ( ( 'IPDU' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1464:6: ( ( 'IPDU' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1465:1: ( 'IPDU' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getIPDUEnumLiteralDeclaration_6()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1466:1: ( 'IPDU' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1466:3: 'IPDU'
                    {
                    match(input,27,FollowSets000.FOLLOW_27_in_rule__ObjectType__Alternatives3272); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getIPDUEnumLiteralDeclaration_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1471:6: ( ( 'ISR' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1471:6: ( ( 'ISR' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1472:1: ( 'ISR' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getISREnumLiteralDeclaration_7()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1473:1: ( 'ISR' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1473:3: 'ISR'
                    {
                    match(input,28,FollowSets000.FOLLOW_28_in_rule__ObjectType__Alternatives3293); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getISREnumLiteralDeclaration_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1478:6: ( ( 'MESSAGE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1478:6: ( ( 'MESSAGE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1479:1: ( 'MESSAGE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getMESSAGEEnumLiteralDeclaration_8()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1480:1: ( 'MESSAGE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1480:3: 'MESSAGE'
                    {
                    match(input,29,FollowSets000.FOLLOW_29_in_rule__ObjectType__Alternatives3314); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getMESSAGEEnumLiteralDeclaration_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1485:6: ( ( 'NETWORKMESSAGE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1485:6: ( ( 'NETWORKMESSAGE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1486:1: ( 'NETWORKMESSAGE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getNETWORKMESSAGEEnumLiteralDeclaration_9()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1487:1: ( 'NETWORKMESSAGE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1487:3: 'NETWORKMESSAGE'
                    {
                    match(input,30,FollowSets000.FOLLOW_30_in_rule__ObjectType__Alternatives3335); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getNETWORKMESSAGEEnumLiteralDeclaration_9()); 
                    }

                    }


                    }
                    break;
                case 11 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1492:6: ( ( 'NM' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1492:6: ( ( 'NM' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1493:1: ( 'NM' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getNMEnumLiteralDeclaration_10()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1494:1: ( 'NM' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1494:3: 'NM'
                    {
                    match(input,31,FollowSets000.FOLLOW_31_in_rule__ObjectType__Alternatives3356); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getNMEnumLiteralDeclaration_10()); 
                    }

                    }


                    }
                    break;
                case 12 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1499:6: ( ( 'RESOURCE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1499:6: ( ( 'RESOURCE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1500:1: ( 'RESOURCE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getRESOURCEEnumLiteralDeclaration_11()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1501:1: ( 'RESOURCE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1501:3: 'RESOURCE'
                    {
                    match(input,32,FollowSets000.FOLLOW_32_in_rule__ObjectType__Alternatives3377); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getRESOURCEEnumLiteralDeclaration_11()); 
                    }

                    }


                    }
                    break;
                case 13 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1506:6: ( ( 'TASK' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1506:6: ( ( 'TASK' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1507:1: ( 'TASK' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getTASKEnumLiteralDeclaration_12()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1508:1: ( 'TASK' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1508:3: 'TASK'
                    {
                    match(input,33,FollowSets000.FOLLOW_33_in_rule__ObjectType__Alternatives3398); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getTASKEnumLiteralDeclaration_12()); 
                    }

                    }


                    }
                    break;
                case 14 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1513:6: ( ( 'APPLICATION' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1513:6: ( ( 'APPLICATION' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1514:1: ( 'APPLICATION' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getAPPLICATIONEnumLiteralDeclaration_13()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1515:1: ( 'APPLICATION' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1515:3: 'APPLICATION'
                    {
                    match(input,49,FollowSets000.FOLLOW_49_in_rule__ObjectType__Alternatives3419); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getAPPLICATIONEnumLiteralDeclaration_13()); 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1525:1: rule__ObjectTypeRef__Alternatives : ( ( ( 'OS_TYPE' ) ) | ( ( 'ALARM_TYPE' ) ) | ( ( 'APPMODE_TYPE' ) ) | ( ( 'COUNTER_TYPE' ) ) | ( ( 'COM_TYPE' ) ) | ( ( 'EVENT_TYPE' ) ) | ( ( 'IPDU_TYPE' ) ) | ( ( 'ISR_TYPE' ) ) | ( ( 'MESSAGE_TYPE' ) ) | ( ( 'NETWORKMESSAGE_TYPE' ) ) | ( ( 'NM_TYPE' ) ) | ( ( 'RESOURCE_TYPE' ) ) | ( ( 'TASK_TYPE' ) ) | ( ( 'APPLICATION_TYPE' ) ) );
    public final void rule__ObjectTypeRef__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1529:1: ( ( ( 'OS_TYPE' ) ) | ( ( 'ALARM_TYPE' ) ) | ( ( 'APPMODE_TYPE' ) ) | ( ( 'COUNTER_TYPE' ) ) | ( ( 'COM_TYPE' ) ) | ( ( 'EVENT_TYPE' ) ) | ( ( 'IPDU_TYPE' ) ) | ( ( 'ISR_TYPE' ) ) | ( ( 'MESSAGE_TYPE' ) ) | ( ( 'NETWORKMESSAGE_TYPE' ) ) | ( ( 'NM_TYPE' ) ) | ( ( 'RESOURCE_TYPE' ) ) | ( ( 'TASK_TYPE' ) ) | ( ( 'APPLICATION_TYPE' ) ) )
            int alt21=14;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt21=1;
                }
                break;
            case 35:
                {
                alt21=2;
                }
                break;
            case 36:
                {
                alt21=3;
                }
                break;
            case 37:
                {
                alt21=4;
                }
                break;
            case 38:
                {
                alt21=5;
                }
                break;
            case 39:
                {
                alt21=6;
                }
                break;
            case 40:
                {
                alt21=7;
                }
                break;
            case 41:
                {
                alt21=8;
                }
                break;
            case 42:
                {
                alt21=9;
                }
                break;
            case 43:
                {
                alt21=10;
                }
                break;
            case 44:
                {
                alt21=11;
                }
                break;
            case 45:
                {
                alt21=12;
                }
                break;
            case 46:
                {
                alt21=13;
                }
                break;
            case 50:
                {
                alt21=14;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1530:1: ( ( 'OS_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1530:1: ( ( 'OS_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1531:1: ( 'OS_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getOSEnumLiteralDeclaration_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1532:1: ( 'OS_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1532:3: 'OS_TYPE'
                    {
                    match(input,34,FollowSets000.FOLLOW_34_in_rule__ObjectTypeRef__Alternatives3455); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getOSEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1537:6: ( ( 'ALARM_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1537:6: ( ( 'ALARM_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1538:1: ( 'ALARM_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getALARMEnumLiteralDeclaration_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1539:1: ( 'ALARM_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1539:3: 'ALARM_TYPE'
                    {
                    match(input,35,FollowSets000.FOLLOW_35_in_rule__ObjectTypeRef__Alternatives3476); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getALARMEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1544:6: ( ( 'APPMODE_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1544:6: ( ( 'APPMODE_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1545:1: ( 'APPMODE_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getAPPMODEEnumLiteralDeclaration_2()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1546:1: ( 'APPMODE_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1546:3: 'APPMODE_TYPE'
                    {
                    match(input,36,FollowSets000.FOLLOW_36_in_rule__ObjectTypeRef__Alternatives3497); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getAPPMODEEnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1551:6: ( ( 'COUNTER_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1551:6: ( ( 'COUNTER_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1552:1: ( 'COUNTER_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getCOUNTEREnumLiteralDeclaration_3()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1553:1: ( 'COUNTER_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1553:3: 'COUNTER_TYPE'
                    {
                    match(input,37,FollowSets000.FOLLOW_37_in_rule__ObjectTypeRef__Alternatives3518); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getCOUNTEREnumLiteralDeclaration_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1558:6: ( ( 'COM_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1558:6: ( ( 'COM_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1559:1: ( 'COM_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getCOMEnumLiteralDeclaration_4()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1560:1: ( 'COM_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1560:3: 'COM_TYPE'
                    {
                    match(input,38,FollowSets000.FOLLOW_38_in_rule__ObjectTypeRef__Alternatives3539); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getCOMEnumLiteralDeclaration_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1565:6: ( ( 'EVENT_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1565:6: ( ( 'EVENT_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1566:1: ( 'EVENT_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getEVENTEnumLiteralDeclaration_5()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1567:1: ( 'EVENT_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1567:3: 'EVENT_TYPE'
                    {
                    match(input,39,FollowSets000.FOLLOW_39_in_rule__ObjectTypeRef__Alternatives3560); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getEVENTEnumLiteralDeclaration_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1572:6: ( ( 'IPDU_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1572:6: ( ( 'IPDU_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1573:1: ( 'IPDU_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getIPDUEnumLiteralDeclaration_6()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1574:1: ( 'IPDU_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1574:3: 'IPDU_TYPE'
                    {
                    match(input,40,FollowSets000.FOLLOW_40_in_rule__ObjectTypeRef__Alternatives3581); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getIPDUEnumLiteralDeclaration_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1579:6: ( ( 'ISR_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1579:6: ( ( 'ISR_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1580:1: ( 'ISR_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getISREnumLiteralDeclaration_7()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1581:1: ( 'ISR_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1581:3: 'ISR_TYPE'
                    {
                    match(input,41,FollowSets000.FOLLOW_41_in_rule__ObjectTypeRef__Alternatives3602); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getISREnumLiteralDeclaration_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1586:6: ( ( 'MESSAGE_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1586:6: ( ( 'MESSAGE_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1587:1: ( 'MESSAGE_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getMESSAGEEnumLiteralDeclaration_8()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1588:1: ( 'MESSAGE_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1588:3: 'MESSAGE_TYPE'
                    {
                    match(input,42,FollowSets000.FOLLOW_42_in_rule__ObjectTypeRef__Alternatives3623); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getMESSAGEEnumLiteralDeclaration_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1593:6: ( ( 'NETWORKMESSAGE_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1593:6: ( ( 'NETWORKMESSAGE_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1594:1: ( 'NETWORKMESSAGE_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getNETWORKMESSAGEEnumLiteralDeclaration_9()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1595:1: ( 'NETWORKMESSAGE_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1595:3: 'NETWORKMESSAGE_TYPE'
                    {
                    match(input,43,FollowSets000.FOLLOW_43_in_rule__ObjectTypeRef__Alternatives3644); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getNETWORKMESSAGEEnumLiteralDeclaration_9()); 
                    }

                    }


                    }
                    break;
                case 11 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1600:6: ( ( 'NM_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1600:6: ( ( 'NM_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1601:1: ( 'NM_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getNMEnumLiteralDeclaration_10()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1602:1: ( 'NM_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1602:3: 'NM_TYPE'
                    {
                    match(input,44,FollowSets000.FOLLOW_44_in_rule__ObjectTypeRef__Alternatives3665); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getNMEnumLiteralDeclaration_10()); 
                    }

                    }


                    }
                    break;
                case 12 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1607:6: ( ( 'RESOURCE_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1607:6: ( ( 'RESOURCE_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1608:1: ( 'RESOURCE_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getRESOURCEEnumLiteralDeclaration_11()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1609:1: ( 'RESOURCE_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1609:3: 'RESOURCE_TYPE'
                    {
                    match(input,45,FollowSets000.FOLLOW_45_in_rule__ObjectTypeRef__Alternatives3686); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getRESOURCEEnumLiteralDeclaration_11()); 
                    }

                    }


                    }
                    break;
                case 13 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1614:6: ( ( 'TASK_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1614:6: ( ( 'TASK_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1615:1: ( 'TASK_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getTASKEnumLiteralDeclaration_12()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1616:1: ( 'TASK_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1616:3: 'TASK_TYPE'
                    {
                    match(input,46,FollowSets000.FOLLOW_46_in_rule__ObjectTypeRef__Alternatives3707); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getTASKEnumLiteralDeclaration_12()); 
                    }

                    }


                    }
                    break;
                case 14 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1621:6: ( ( 'APPLICATION_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1621:6: ( ( 'APPLICATION_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1622:1: ( 'APPLICATION_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getAPPLICATIONEnumLiteralDeclaration_13()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1623:1: ( 'APPLICATION_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1623:3: 'APPLICATION_TYPE'
                    {
                    match(input,50,FollowSets000.FOLLOW_50_in_rule__ObjectTypeRef__Alternatives3728); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getAPPLICATIONEnumLiteralDeclaration_13()); 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1635:1: rule__OilFile__Group__0 : rule__OilFile__Group__0__Impl rule__OilFile__Group__1 ;
    public final void rule__OilFile__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1639:1: ( rule__OilFile__Group__0__Impl rule__OilFile__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1640:2: rule__OilFile__Group__0__Impl rule__OilFile__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group__0__Impl_in_rule__OilFile__Group__03761);
            rule__OilFile__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group__1_in_rule__OilFile__Group__03764);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1647:1: rule__OilFile__Group__0__Impl : ( () ) ;
    public final void rule__OilFile__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1651:1: ( ( () ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1652:1: ( () )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1652:1: ( () )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1653:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getOilFileAction_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1654:1: ()
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1656:1: 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1666:1: rule__OilFile__Group__1 : rule__OilFile__Group__1__Impl rule__OilFile__Group__2 ;
    public final void rule__OilFile__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1670:1: ( rule__OilFile__Group__1__Impl rule__OilFile__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1671:2: rule__OilFile__Group__1__Impl rule__OilFile__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group__1__Impl_in_rule__OilFile__Group__13822);
            rule__OilFile__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group__2_in_rule__OilFile__Group__13825);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1678:1: rule__OilFile__Group__1__Impl : ( ( rule__OilFile__Group_1__0 )? ) ;
    public final void rule__OilFile__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1682:1: ( ( ( rule__OilFile__Group_1__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1683:1: ( ( rule__OilFile__Group_1__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1683:1: ( ( rule__OilFile__Group_1__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1684:1: ( rule__OilFile__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getGroup_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1685:1: ( rule__OilFile__Group_1__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==51) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1685:2: rule__OilFile__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group_1__0_in_rule__OilFile__Group__1__Impl3852);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1695:1: rule__OilFile__Group__2 : rule__OilFile__Group__2__Impl rule__OilFile__Group__3 ;
    public final void rule__OilFile__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1699:1: ( rule__OilFile__Group__2__Impl rule__OilFile__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1700:2: rule__OilFile__Group__2__Impl rule__OilFile__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group__2__Impl_in_rule__OilFile__Group__23883);
            rule__OilFile__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group__3_in_rule__OilFile__Group__23886);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1707:1: rule__OilFile__Group__2__Impl : ( ( rule__OilFile__ImplementationAssignment_2 )? ) ;
    public final void rule__OilFile__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1711:1: ( ( ( rule__OilFile__ImplementationAssignment_2 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1712:1: ( ( rule__OilFile__ImplementationAssignment_2 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1712:1: ( ( rule__OilFile__ImplementationAssignment_2 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1713:1: ( rule__OilFile__ImplementationAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getImplementationAssignment_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1714:1: ( rule__OilFile__ImplementationAssignment_2 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==54) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1714:2: rule__OilFile__ImplementationAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__OilFile__ImplementationAssignment_2_in_rule__OilFile__Group__2__Impl3913);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1724:1: rule__OilFile__Group__3 : rule__OilFile__Group__3__Impl ;
    public final void rule__OilFile__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1728:1: ( rule__OilFile__Group__3__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1729:2: rule__OilFile__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group__3__Impl_in_rule__OilFile__Group__33944);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1735:1: rule__OilFile__Group__3__Impl : ( ( rule__OilFile__ApplicationAssignment_3 )? ) ;
    public final void rule__OilFile__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1739:1: ( ( ( rule__OilFile__ApplicationAssignment_3 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1740:1: ( ( rule__OilFile__ApplicationAssignment_3 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1740:1: ( ( rule__OilFile__ApplicationAssignment_3 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1741:1: ( rule__OilFile__ApplicationAssignment_3 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getApplicationAssignment_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1742:1: ( rule__OilFile__ApplicationAssignment_3 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==58) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1742:2: rule__OilFile__ApplicationAssignment_3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__OilFile__ApplicationAssignment_3_in_rule__OilFile__Group__3__Impl3971);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1760:1: rule__OilFile__Group_1__0 : rule__OilFile__Group_1__0__Impl rule__OilFile__Group_1__1 ;
    public final void rule__OilFile__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1764:1: ( rule__OilFile__Group_1__0__Impl rule__OilFile__Group_1__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1765:2: rule__OilFile__Group_1__0__Impl rule__OilFile__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group_1__0__Impl_in_rule__OilFile__Group_1__04010);
            rule__OilFile__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group_1__1_in_rule__OilFile__Group_1__04013);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1772:1: rule__OilFile__Group_1__0__Impl : ( 'OIL_VERSION' ) ;
    public final void rule__OilFile__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1776:1: ( ( 'OIL_VERSION' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1777:1: ( 'OIL_VERSION' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1777:1: ( 'OIL_VERSION' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1778:1: 'OIL_VERSION'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getOIL_VERSIONKeyword_1_0()); 
            }
            match(input,51,FollowSets000.FOLLOW_51_in_rule__OilFile__Group_1__0__Impl4041); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1791:1: rule__OilFile__Group_1__1 : rule__OilFile__Group_1__1__Impl rule__OilFile__Group_1__2 ;
    public final void rule__OilFile__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1795:1: ( rule__OilFile__Group_1__1__Impl rule__OilFile__Group_1__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1796:2: rule__OilFile__Group_1__1__Impl rule__OilFile__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group_1__1__Impl_in_rule__OilFile__Group_1__14072);
            rule__OilFile__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group_1__2_in_rule__OilFile__Group_1__14075);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1803:1: rule__OilFile__Group_1__1__Impl : ( '=' ) ;
    public final void rule__OilFile__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1807:1: ( ( '=' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1808:1: ( '=' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1808:1: ( '=' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1809:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getEqualsSignKeyword_1_1()); 
            }
            match(input,52,FollowSets000.FOLLOW_52_in_rule__OilFile__Group_1__1__Impl4103); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1822:1: rule__OilFile__Group_1__2 : rule__OilFile__Group_1__2__Impl rule__OilFile__Group_1__3 ;
    public final void rule__OilFile__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1826:1: ( rule__OilFile__Group_1__2__Impl rule__OilFile__Group_1__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1827:2: rule__OilFile__Group_1__2__Impl rule__OilFile__Group_1__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group_1__2__Impl_in_rule__OilFile__Group_1__24134);
            rule__OilFile__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group_1__3_in_rule__OilFile__Group_1__24137);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1834:1: rule__OilFile__Group_1__2__Impl : ( ( rule__OilFile__OilVersionAssignment_1_2 ) ) ;
    public final void rule__OilFile__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1838:1: ( ( ( rule__OilFile__OilVersionAssignment_1_2 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1839:1: ( ( rule__OilFile__OilVersionAssignment_1_2 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1839:1: ( ( rule__OilFile__OilVersionAssignment_1_2 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1840:1: ( rule__OilFile__OilVersionAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getOilVersionAssignment_1_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1841:1: ( rule__OilFile__OilVersionAssignment_1_2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1841:2: rule__OilFile__OilVersionAssignment_1_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__OilVersionAssignment_1_2_in_rule__OilFile__Group_1__2__Impl4164);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1851:1: rule__OilFile__Group_1__3 : rule__OilFile__Group_1__3__Impl ;
    public final void rule__OilFile__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1855:1: ( rule__OilFile__Group_1__3__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1856:2: rule__OilFile__Group_1__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group_1__3__Impl_in_rule__OilFile__Group_1__34194);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1862:1: rule__OilFile__Group_1__3__Impl : ( ';' ) ;
    public final void rule__OilFile__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1866:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1867:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1867:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1868:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getSemicolonKeyword_1_3()); 
            }
            match(input,53,FollowSets000.FOLLOW_53_in_rule__OilFile__Group_1__3__Impl4222); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1889:1: rule__OilImplementation__Group__0 : rule__OilImplementation__Group__0__Impl rule__OilImplementation__Group__1 ;
    public final void rule__OilImplementation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1893:1: ( rule__OilImplementation__Group__0__Impl rule__OilImplementation__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1894:2: rule__OilImplementation__Group__0__Impl rule__OilImplementation__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__0__Impl_in_rule__OilImplementation__Group__04261);
            rule__OilImplementation__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__1_in_rule__OilImplementation__Group__04264);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1901:1: rule__OilImplementation__Group__0__Impl : ( 'IMPLEMENTATION' ) ;
    public final void rule__OilImplementation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1905:1: ( ( 'IMPLEMENTATION' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1906:1: ( 'IMPLEMENTATION' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1906:1: ( 'IMPLEMENTATION' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1907:1: 'IMPLEMENTATION'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getIMPLEMENTATIONKeyword_0()); 
            }
            match(input,54,FollowSets000.FOLLOW_54_in_rule__OilImplementation__Group__0__Impl4292); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1920:1: rule__OilImplementation__Group__1 : rule__OilImplementation__Group__1__Impl rule__OilImplementation__Group__2 ;
    public final void rule__OilImplementation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1924:1: ( rule__OilImplementation__Group__1__Impl rule__OilImplementation__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1925:2: rule__OilImplementation__Group__1__Impl rule__OilImplementation__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__1__Impl_in_rule__OilImplementation__Group__14323);
            rule__OilImplementation__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__2_in_rule__OilImplementation__Group__14326);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1932:1: rule__OilImplementation__Group__1__Impl : ( ( rule__OilImplementation__NameAssignment_1 ) ) ;
    public final void rule__OilImplementation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1936:1: ( ( ( rule__OilImplementation__NameAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1937:1: ( ( rule__OilImplementation__NameAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1937:1: ( ( rule__OilImplementation__NameAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1938:1: ( rule__OilImplementation__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getNameAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1939:1: ( rule__OilImplementation__NameAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1939:2: rule__OilImplementation__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__NameAssignment_1_in_rule__OilImplementation__Group__1__Impl4353);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1949:1: rule__OilImplementation__Group__2 : rule__OilImplementation__Group__2__Impl rule__OilImplementation__Group__3 ;
    public final void rule__OilImplementation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1953:1: ( rule__OilImplementation__Group__2__Impl rule__OilImplementation__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1954:2: rule__OilImplementation__Group__2__Impl rule__OilImplementation__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__2__Impl_in_rule__OilImplementation__Group__24383);
            rule__OilImplementation__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__3_in_rule__OilImplementation__Group__24386);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1961:1: rule__OilImplementation__Group__2__Impl : ( '{' ) ;
    public final void rule__OilImplementation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1965:1: ( ( '{' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1966:1: ( '{' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1966:1: ( '{' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1967:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,55,FollowSets000.FOLLOW_55_in_rule__OilImplementation__Group__2__Impl4414); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1980:1: rule__OilImplementation__Group__3 : rule__OilImplementation__Group__3__Impl rule__OilImplementation__Group__4 ;
    public final void rule__OilImplementation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1984:1: ( rule__OilImplementation__Group__3__Impl rule__OilImplementation__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1985:2: rule__OilImplementation__Group__3__Impl rule__OilImplementation__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__3__Impl_in_rule__OilImplementation__Group__34445);
            rule__OilImplementation__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__4_in_rule__OilImplementation__Group__34448);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1992:1: rule__OilImplementation__Group__3__Impl : ( ( rule__OilImplementation__OilObjectsAssignment_3 )* ) ;
    public final void rule__OilImplementation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1996:1: ( ( ( rule__OilImplementation__OilObjectsAssignment_3 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1997:1: ( ( rule__OilImplementation__OilObjectsAssignment_3 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1997:1: ( ( rule__OilImplementation__OilObjectsAssignment_3 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1998:1: ( rule__OilImplementation__OilObjectsAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getOilObjectsAssignment_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1999:1: ( rule__OilImplementation__OilObjectsAssignment_3 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=21 && LA25_0<=33)||LA25_0==49) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1999:2: rule__OilImplementation__OilObjectsAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__OilObjectsAssignment_3_in_rule__OilImplementation__Group__3__Impl4475);
            	    rule__OilImplementation__OilObjectsAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop25;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2009:1: rule__OilImplementation__Group__4 : rule__OilImplementation__Group__4__Impl rule__OilImplementation__Group__5 ;
    public final void rule__OilImplementation__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2013:1: ( rule__OilImplementation__Group__4__Impl rule__OilImplementation__Group__5 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2014:2: rule__OilImplementation__Group__4__Impl rule__OilImplementation__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__4__Impl_in_rule__OilImplementation__Group__44506);
            rule__OilImplementation__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__5_in_rule__OilImplementation__Group__44509);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2021:1: rule__OilImplementation__Group__4__Impl : ( '}' ) ;
    public final void rule__OilImplementation__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2025:1: ( ( '}' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2026:1: ( '}' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2026:1: ( '}' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2027:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,56,FollowSets000.FOLLOW_56_in_rule__OilImplementation__Group__4__Impl4537); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2040:1: rule__OilImplementation__Group__5 : rule__OilImplementation__Group__5__Impl ;
    public final void rule__OilImplementation__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2044:1: ( rule__OilImplementation__Group__5__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2045:2: rule__OilImplementation__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__5__Impl_in_rule__OilImplementation__Group__54568);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2051:1: rule__OilImplementation__Group__5__Impl : ( ';' ) ;
    public final void rule__OilImplementation__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2055:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2056:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2056:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2057:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getSemicolonKeyword_5()); 
            }
            match(input,53,FollowSets000.FOLLOW_53_in_rule__OilImplementation__Group__5__Impl4596); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2082:1: rule__OilObjectImpl__Group__0 : rule__OilObjectImpl__Group__0__Impl rule__OilObjectImpl__Group__1 ;
    public final void rule__OilObjectImpl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2086:1: ( rule__OilObjectImpl__Group__0__Impl rule__OilObjectImpl__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2087:2: rule__OilObjectImpl__Group__0__Impl rule__OilObjectImpl__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__0__Impl_in_rule__OilObjectImpl__Group__04639);
            rule__OilObjectImpl__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__1_in_rule__OilObjectImpl__Group__04642);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2094:1: rule__OilObjectImpl__Group__0__Impl : ( ( rule__OilObjectImpl__TypeAssignment_0 ) ) ;
    public final void rule__OilObjectImpl__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2098:1: ( ( ( rule__OilObjectImpl__TypeAssignment_0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2099:1: ( ( rule__OilObjectImpl__TypeAssignment_0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2099:1: ( ( rule__OilObjectImpl__TypeAssignment_0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2100:1: ( rule__OilObjectImpl__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getTypeAssignment_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2101:1: ( rule__OilObjectImpl__TypeAssignment_0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2101:2: rule__OilObjectImpl__TypeAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__TypeAssignment_0_in_rule__OilObjectImpl__Group__0__Impl4669);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2111:1: rule__OilObjectImpl__Group__1 : rule__OilObjectImpl__Group__1__Impl rule__OilObjectImpl__Group__2 ;
    public final void rule__OilObjectImpl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2115:1: ( rule__OilObjectImpl__Group__1__Impl rule__OilObjectImpl__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2116:2: rule__OilObjectImpl__Group__1__Impl rule__OilObjectImpl__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__1__Impl_in_rule__OilObjectImpl__Group__14699);
            rule__OilObjectImpl__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__2_in_rule__OilObjectImpl__Group__14702);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2123:1: rule__OilObjectImpl__Group__1__Impl : ( '{' ) ;
    public final void rule__OilObjectImpl__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2127:1: ( ( '{' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2128:1: ( '{' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2128:1: ( '{' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2129:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,55,FollowSets000.FOLLOW_55_in_rule__OilObjectImpl__Group__1__Impl4730); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2142:1: rule__OilObjectImpl__Group__2 : rule__OilObjectImpl__Group__2__Impl rule__OilObjectImpl__Group__3 ;
    public final void rule__OilObjectImpl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2146:1: ( rule__OilObjectImpl__Group__2__Impl rule__OilObjectImpl__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2147:2: rule__OilObjectImpl__Group__2__Impl rule__OilObjectImpl__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__2__Impl_in_rule__OilObjectImpl__Group__24761);
            rule__OilObjectImpl__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__3_in_rule__OilObjectImpl__Group__24764);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2154:1: rule__OilObjectImpl__Group__2__Impl : ( ( rule__OilObjectImpl__ParametersAssignment_2 )* ) ;
    public final void rule__OilObjectImpl__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2158:1: ( ( ( rule__OilObjectImpl__ParametersAssignment_2 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2159:1: ( ( rule__OilObjectImpl__ParametersAssignment_2 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2159:1: ( ( rule__OilObjectImpl__ParametersAssignment_2 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2160:1: ( rule__OilObjectImpl__ParametersAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getParametersAssignment_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2161:1: ( rule__OilObjectImpl__ParametersAssignment_2 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=13 && LA26_0<=20)||(LA26_0>=34 && LA26_0<=46)||LA26_0==50) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2161:2: rule__OilObjectImpl__ParametersAssignment_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__ParametersAssignment_2_in_rule__OilObjectImpl__Group__2__Impl4791);
            	    rule__OilObjectImpl__ParametersAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop26;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2171:1: rule__OilObjectImpl__Group__3 : rule__OilObjectImpl__Group__3__Impl rule__OilObjectImpl__Group__4 ;
    public final void rule__OilObjectImpl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2175:1: ( rule__OilObjectImpl__Group__3__Impl rule__OilObjectImpl__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2176:2: rule__OilObjectImpl__Group__3__Impl rule__OilObjectImpl__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__3__Impl_in_rule__OilObjectImpl__Group__34822);
            rule__OilObjectImpl__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__4_in_rule__OilObjectImpl__Group__34825);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2183:1: rule__OilObjectImpl__Group__3__Impl : ( '}' ) ;
    public final void rule__OilObjectImpl__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2187:1: ( ( '}' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2188:1: ( '}' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2188:1: ( '}' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2189:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getRightCurlyBracketKeyword_3()); 
            }
            match(input,56,FollowSets000.FOLLOW_56_in_rule__OilObjectImpl__Group__3__Impl4853); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2202:1: rule__OilObjectImpl__Group__4 : rule__OilObjectImpl__Group__4__Impl rule__OilObjectImpl__Group__5 ;
    public final void rule__OilObjectImpl__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2206:1: ( rule__OilObjectImpl__Group__4__Impl rule__OilObjectImpl__Group__5 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2207:2: rule__OilObjectImpl__Group__4__Impl rule__OilObjectImpl__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__4__Impl_in_rule__OilObjectImpl__Group__44884);
            rule__OilObjectImpl__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__5_in_rule__OilObjectImpl__Group__44887);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2214:1: rule__OilObjectImpl__Group__4__Impl : ( ( rule__OilObjectImpl__Group_4__0 )? ) ;
    public final void rule__OilObjectImpl__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2218:1: ( ( ( rule__OilObjectImpl__Group_4__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2219:1: ( ( rule__OilObjectImpl__Group_4__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2219:1: ( ( rule__OilObjectImpl__Group_4__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2220:1: ( rule__OilObjectImpl__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getGroup_4()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2221:1: ( rule__OilObjectImpl__Group_4__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==57) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2221:2: rule__OilObjectImpl__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group_4__0_in_rule__OilObjectImpl__Group__4__Impl4914);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2231:1: rule__OilObjectImpl__Group__5 : rule__OilObjectImpl__Group__5__Impl ;
    public final void rule__OilObjectImpl__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2235:1: ( rule__OilObjectImpl__Group__5__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2236:2: rule__OilObjectImpl__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__5__Impl_in_rule__OilObjectImpl__Group__54945);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2242:1: rule__OilObjectImpl__Group__5__Impl : ( ';' ) ;
    public final void rule__OilObjectImpl__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2246:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2247:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2247:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2248:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getSemicolonKeyword_5()); 
            }
            match(input,53,FollowSets000.FOLLOW_53_in_rule__OilObjectImpl__Group__5__Impl4973); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2273:1: rule__OilObjectImpl__Group_4__0 : rule__OilObjectImpl__Group_4__0__Impl rule__OilObjectImpl__Group_4__1 ;
    public final void rule__OilObjectImpl__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2277:1: ( rule__OilObjectImpl__Group_4__0__Impl rule__OilObjectImpl__Group_4__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2278:2: rule__OilObjectImpl__Group_4__0__Impl rule__OilObjectImpl__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group_4__0__Impl_in_rule__OilObjectImpl__Group_4__05016);
            rule__OilObjectImpl__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group_4__1_in_rule__OilObjectImpl__Group_4__05019);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2285:1: rule__OilObjectImpl__Group_4__0__Impl : ( ':' ) ;
    public final void rule__OilObjectImpl__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2289:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2290:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2290:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2291:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getColonKeyword_4_0()); 
            }
            match(input,57,FollowSets000.FOLLOW_57_in_rule__OilObjectImpl__Group_4__0__Impl5047); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2304:1: rule__OilObjectImpl__Group_4__1 : rule__OilObjectImpl__Group_4__1__Impl ;
    public final void rule__OilObjectImpl__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2308:1: ( rule__OilObjectImpl__Group_4__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2309:2: rule__OilObjectImpl__Group_4__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group_4__1__Impl_in_rule__OilObjectImpl__Group_4__15078);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2315:1: rule__OilObjectImpl__Group_4__1__Impl : ( ( rule__OilObjectImpl__DescriptionAssignment_4_1 ) ) ;
    public final void rule__OilObjectImpl__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2319:1: ( ( ( rule__OilObjectImpl__DescriptionAssignment_4_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2320:1: ( ( rule__OilObjectImpl__DescriptionAssignment_4_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2320:1: ( ( rule__OilObjectImpl__DescriptionAssignment_4_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2321:1: ( rule__OilObjectImpl__DescriptionAssignment_4_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getDescriptionAssignment_4_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2322:1: ( rule__OilObjectImpl__DescriptionAssignment_4_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2322:2: rule__OilObjectImpl__DescriptionAssignment_4_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__DescriptionAssignment_4_1_in_rule__OilObjectImpl__Group_4__1__Impl5105);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2336:1: rule__OilApplication__Group__0 : rule__OilApplication__Group__0__Impl rule__OilApplication__Group__1 ;
    public final void rule__OilApplication__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2340:1: ( rule__OilApplication__Group__0__Impl rule__OilApplication__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2341:2: rule__OilApplication__Group__0__Impl rule__OilApplication__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__0__Impl_in_rule__OilApplication__Group__05139);
            rule__OilApplication__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__1_in_rule__OilApplication__Group__05142);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2348:1: rule__OilApplication__Group__0__Impl : ( 'CPU' ) ;
    public final void rule__OilApplication__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2352:1: ( ( 'CPU' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2353:1: ( 'CPU' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2353:1: ( 'CPU' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2354:1: 'CPU'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getCPUKeyword_0()); 
            }
            match(input,58,FollowSets000.FOLLOW_58_in_rule__OilApplication__Group__0__Impl5170); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2367:1: rule__OilApplication__Group__1 : rule__OilApplication__Group__1__Impl rule__OilApplication__Group__2 ;
    public final void rule__OilApplication__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2371:1: ( rule__OilApplication__Group__1__Impl rule__OilApplication__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2372:2: rule__OilApplication__Group__1__Impl rule__OilApplication__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__1__Impl_in_rule__OilApplication__Group__15201);
            rule__OilApplication__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__2_in_rule__OilApplication__Group__15204);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2379:1: rule__OilApplication__Group__1__Impl : ( ( rule__OilApplication__NameAssignment_1 ) ) ;
    public final void rule__OilApplication__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2383:1: ( ( ( rule__OilApplication__NameAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2384:1: ( ( rule__OilApplication__NameAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2384:1: ( ( rule__OilApplication__NameAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2385:1: ( rule__OilApplication__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getNameAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2386:1: ( rule__OilApplication__NameAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2386:2: rule__OilApplication__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__NameAssignment_1_in_rule__OilApplication__Group__1__Impl5231);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2396:1: rule__OilApplication__Group__2 : rule__OilApplication__Group__2__Impl rule__OilApplication__Group__3 ;
    public final void rule__OilApplication__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2400:1: ( rule__OilApplication__Group__2__Impl rule__OilApplication__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2401:2: rule__OilApplication__Group__2__Impl rule__OilApplication__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__2__Impl_in_rule__OilApplication__Group__25261);
            rule__OilApplication__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__3_in_rule__OilApplication__Group__25264);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2408:1: rule__OilApplication__Group__2__Impl : ( '{' ) ;
    public final void rule__OilApplication__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2412:1: ( ( '{' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2413:1: ( '{' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2413:1: ( '{' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2414:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,55,FollowSets000.FOLLOW_55_in_rule__OilApplication__Group__2__Impl5292); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2427:1: rule__OilApplication__Group__3 : rule__OilApplication__Group__3__Impl rule__OilApplication__Group__4 ;
    public final void rule__OilApplication__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2431:1: ( rule__OilApplication__Group__3__Impl rule__OilApplication__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2432:2: rule__OilApplication__Group__3__Impl rule__OilApplication__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__3__Impl_in_rule__OilApplication__Group__35323);
            rule__OilApplication__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__4_in_rule__OilApplication__Group__35326);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2439:1: rule__OilApplication__Group__3__Impl : ( ( rule__OilApplication__OilObjectsAssignment_3 )* ) ;
    public final void rule__OilApplication__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2443:1: ( ( ( rule__OilApplication__OilObjectsAssignment_3 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2444:1: ( ( rule__OilApplication__OilObjectsAssignment_3 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2444:1: ( ( rule__OilApplication__OilObjectsAssignment_3 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2445:1: ( rule__OilApplication__OilObjectsAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getOilObjectsAssignment_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2446:1: ( rule__OilApplication__OilObjectsAssignment_3 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>=21 && LA28_0<=33)||LA28_0==49) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2446:2: rule__OilApplication__OilObjectsAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__OilApplication__OilObjectsAssignment_3_in_rule__OilApplication__Group__3__Impl5353);
            	    rule__OilApplication__OilObjectsAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop28;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2456:1: rule__OilApplication__Group__4 : rule__OilApplication__Group__4__Impl rule__OilApplication__Group__5 ;
    public final void rule__OilApplication__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2460:1: ( rule__OilApplication__Group__4__Impl rule__OilApplication__Group__5 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2461:2: rule__OilApplication__Group__4__Impl rule__OilApplication__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__4__Impl_in_rule__OilApplication__Group__45384);
            rule__OilApplication__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__5_in_rule__OilApplication__Group__45387);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2468:1: rule__OilApplication__Group__4__Impl : ( '}' ) ;
    public final void rule__OilApplication__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2472:1: ( ( '}' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2473:1: ( '}' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2473:1: ( '}' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2474:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,56,FollowSets000.FOLLOW_56_in_rule__OilApplication__Group__4__Impl5415); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2487:1: rule__OilApplication__Group__5 : rule__OilApplication__Group__5__Impl rule__OilApplication__Group__6 ;
    public final void rule__OilApplication__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2491:1: ( rule__OilApplication__Group__5__Impl rule__OilApplication__Group__6 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2492:2: rule__OilApplication__Group__5__Impl rule__OilApplication__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__5__Impl_in_rule__OilApplication__Group__55446);
            rule__OilApplication__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__6_in_rule__OilApplication__Group__55449);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2499:1: rule__OilApplication__Group__5__Impl : ( ( rule__OilApplication__Group_5__0 )? ) ;
    public final void rule__OilApplication__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2503:1: ( ( ( rule__OilApplication__Group_5__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2504:1: ( ( rule__OilApplication__Group_5__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2504:1: ( ( rule__OilApplication__Group_5__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2505:1: ( rule__OilApplication__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getGroup_5()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2506:1: ( rule__OilApplication__Group_5__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==57) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2506:2: rule__OilApplication__Group_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group_5__0_in_rule__OilApplication__Group__5__Impl5476);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2516:1: rule__OilApplication__Group__6 : rule__OilApplication__Group__6__Impl ;
    public final void rule__OilApplication__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2520:1: ( rule__OilApplication__Group__6__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2521:2: rule__OilApplication__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__6__Impl_in_rule__OilApplication__Group__65507);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2527:1: rule__OilApplication__Group__6__Impl : ( ';' ) ;
    public final void rule__OilApplication__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2531:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2532:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2532:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2533:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getSemicolonKeyword_6()); 
            }
            match(input,53,FollowSets000.FOLLOW_53_in_rule__OilApplication__Group__6__Impl5535); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2560:1: rule__OilApplication__Group_5__0 : rule__OilApplication__Group_5__0__Impl rule__OilApplication__Group_5__1 ;
    public final void rule__OilApplication__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2564:1: ( rule__OilApplication__Group_5__0__Impl rule__OilApplication__Group_5__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2565:2: rule__OilApplication__Group_5__0__Impl rule__OilApplication__Group_5__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group_5__0__Impl_in_rule__OilApplication__Group_5__05580);
            rule__OilApplication__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group_5__1_in_rule__OilApplication__Group_5__05583);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2572:1: rule__OilApplication__Group_5__0__Impl : ( ':' ) ;
    public final void rule__OilApplication__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2576:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2577:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2577:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2578:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getColonKeyword_5_0()); 
            }
            match(input,57,FollowSets000.FOLLOW_57_in_rule__OilApplication__Group_5__0__Impl5611); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2591:1: rule__OilApplication__Group_5__1 : rule__OilApplication__Group_5__1__Impl ;
    public final void rule__OilApplication__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2595:1: ( rule__OilApplication__Group_5__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2596:2: rule__OilApplication__Group_5__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group_5__1__Impl_in_rule__OilApplication__Group_5__15642);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2602:1: rule__OilApplication__Group_5__1__Impl : ( ( rule__OilApplication__DescriptionAssignment_5_1 ) ) ;
    public final void rule__OilApplication__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2606:1: ( ( ( rule__OilApplication__DescriptionAssignment_5_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2607:1: ( ( rule__OilApplication__DescriptionAssignment_5_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2607:1: ( ( rule__OilApplication__DescriptionAssignment_5_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2608:1: ( rule__OilApplication__DescriptionAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getDescriptionAssignment_5_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2609:1: ( rule__OilApplication__DescriptionAssignment_5_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2609:2: rule__OilApplication__DescriptionAssignment_5_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__DescriptionAssignment_5_1_in_rule__OilApplication__Group_5__1__Impl5669);
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


    // $ANTLR start "rule__ValueList__Group__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2623:1: rule__ValueList__Group__0 : rule__ValueList__Group__0__Impl rule__ValueList__Group__1 ;
    public final void rule__ValueList__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2627:1: ( rule__ValueList__Group__0__Impl rule__ValueList__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2628:2: rule__ValueList__Group__0__Impl rule__ValueList__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueList__Group__0__Impl_in_rule__ValueList__Group__05703);
            rule__ValueList__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueList__Group__1_in_rule__ValueList__Group__05706);
            rule__ValueList__Group__1();

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
    // $ANTLR end "rule__ValueList__Group__0"


    // $ANTLR start "rule__ValueList__Group__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2635:1: rule__ValueList__Group__0__Impl : ( () ) ;
    public final void rule__ValueList__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2639:1: ( ( () ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2640:1: ( () )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2640:1: ( () )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2641:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueListAccess().getValueListAction_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2642:1: ()
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2644:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueListAccess().getValueListAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueList__Group__0__Impl"


    // $ANTLR start "rule__ValueList__Group__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2654:1: rule__ValueList__Group__1 : rule__ValueList__Group__1__Impl rule__ValueList__Group__2 ;
    public final void rule__ValueList__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2658:1: ( rule__ValueList__Group__1__Impl rule__ValueList__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2659:2: rule__ValueList__Group__1__Impl rule__ValueList__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueList__Group__1__Impl_in_rule__ValueList__Group__15764);
            rule__ValueList__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueList__Group__2_in_rule__ValueList__Group__15767);
            rule__ValueList__Group__2();

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
    // $ANTLR end "rule__ValueList__Group__1"


    // $ANTLR start "rule__ValueList__Group__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2666:1: rule__ValueList__Group__1__Impl : ( ( rule__ValueList__ValuesAssignment_1 ) ) ;
    public final void rule__ValueList__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2670:1: ( ( ( rule__ValueList__ValuesAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2671:1: ( ( rule__ValueList__ValuesAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2671:1: ( ( rule__ValueList__ValuesAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2672:1: ( rule__ValueList__ValuesAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueListAccess().getValuesAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2673:1: ( rule__ValueList__ValuesAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2673:2: rule__ValueList__ValuesAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueList__ValuesAssignment_1_in_rule__ValueList__Group__1__Impl5794);
            rule__ValueList__ValuesAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueListAccess().getValuesAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueList__Group__1__Impl"


    // $ANTLR start "rule__ValueList__Group__2"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2683:1: rule__ValueList__Group__2 : rule__ValueList__Group__2__Impl ;
    public final void rule__ValueList__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2687:1: ( rule__ValueList__Group__2__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2688:2: rule__ValueList__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueList__Group__2__Impl_in_rule__ValueList__Group__25824);
            rule__ValueList__Group__2__Impl();

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
    // $ANTLR end "rule__ValueList__Group__2"


    // $ANTLR start "rule__ValueList__Group__2__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2694:1: rule__ValueList__Group__2__Impl : ( ( rule__ValueList__Group_2__0 )* ) ;
    public final void rule__ValueList__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2698:1: ( ( ( rule__ValueList__Group_2__0 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2699:1: ( ( rule__ValueList__Group_2__0 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2699:1: ( ( rule__ValueList__Group_2__0 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2700:1: ( rule__ValueList__Group_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueListAccess().getGroup_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2701:1: ( rule__ValueList__Group_2__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==59) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2701:2: rule__ValueList__Group_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__ValueList__Group_2__0_in_rule__ValueList__Group__2__Impl5851);
            	    rule__ValueList__Group_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueListAccess().getGroup_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueList__Group__2__Impl"


    // $ANTLR start "rule__ValueList__Group_2__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2717:1: rule__ValueList__Group_2__0 : rule__ValueList__Group_2__0__Impl rule__ValueList__Group_2__1 ;
    public final void rule__ValueList__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2721:1: ( rule__ValueList__Group_2__0__Impl rule__ValueList__Group_2__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2722:2: rule__ValueList__Group_2__0__Impl rule__ValueList__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueList__Group_2__0__Impl_in_rule__ValueList__Group_2__05888);
            rule__ValueList__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueList__Group_2__1_in_rule__ValueList__Group_2__05891);
            rule__ValueList__Group_2__1();

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
    // $ANTLR end "rule__ValueList__Group_2__0"


    // $ANTLR start "rule__ValueList__Group_2__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2729:1: rule__ValueList__Group_2__0__Impl : ( ',' ) ;
    public final void rule__ValueList__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2733:1: ( ( ',' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2734:1: ( ',' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2734:1: ( ',' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2735:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueListAccess().getCommaKeyword_2_0()); 
            }
            match(input,59,FollowSets000.FOLLOW_59_in_rule__ValueList__Group_2__0__Impl5919); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueListAccess().getCommaKeyword_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueList__Group_2__0__Impl"


    // $ANTLR start "rule__ValueList__Group_2__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2748:1: rule__ValueList__Group_2__1 : rule__ValueList__Group_2__1__Impl ;
    public final void rule__ValueList__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2752:1: ( rule__ValueList__Group_2__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2753:2: rule__ValueList__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueList__Group_2__1__Impl_in_rule__ValueList__Group_2__15950);
            rule__ValueList__Group_2__1__Impl();

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
    // $ANTLR end "rule__ValueList__Group_2__1"


    // $ANTLR start "rule__ValueList__Group_2__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2759:1: rule__ValueList__Group_2__1__Impl : ( ( rule__ValueList__ValuesAssignment_2_1 ) ) ;
    public final void rule__ValueList__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2763:1: ( ( ( rule__ValueList__ValuesAssignment_2_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2764:1: ( ( rule__ValueList__ValuesAssignment_2_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2764:1: ( ( rule__ValueList__ValuesAssignment_2_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2765:1: ( rule__ValueList__ValuesAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueListAccess().getValuesAssignment_2_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2766:1: ( rule__ValueList__ValuesAssignment_2_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2766:2: rule__ValueList__ValuesAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueList__ValuesAssignment_2_1_in_rule__ValueList__Group_2__1__Impl5977);
            rule__ValueList__ValuesAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueListAccess().getValuesAssignment_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueList__Group_2__1__Impl"


    // $ANTLR start "rule__Range__Group__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2780:1: rule__Range__Group__0 : rule__Range__Group__0__Impl rule__Range__Group__1 ;
    public final void rule__Range__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2784:1: ( rule__Range__Group__0__Impl rule__Range__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2785:2: rule__Range__Group__0__Impl rule__Range__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Range__Group__0__Impl_in_rule__Range__Group__06011);
            rule__Range__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Range__Group__1_in_rule__Range__Group__06014);
            rule__Range__Group__1();

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
    // $ANTLR end "rule__Range__Group__0"


    // $ANTLR start "rule__Range__Group__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2792:1: rule__Range__Group__0__Impl : ( () ) ;
    public final void rule__Range__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2796:1: ( ( () ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2797:1: ( () )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2797:1: ( () )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2798:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeAccess().getRangeAction_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2799:1: ()
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2801:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRangeAccess().getRangeAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Range__Group__0__Impl"


    // $ANTLR start "rule__Range__Group__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2811:1: rule__Range__Group__1 : rule__Range__Group__1__Impl rule__Range__Group__2 ;
    public final void rule__Range__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2815:1: ( rule__Range__Group__1__Impl rule__Range__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2816:2: rule__Range__Group__1__Impl rule__Range__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Range__Group__1__Impl_in_rule__Range__Group__16072);
            rule__Range__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Range__Group__2_in_rule__Range__Group__16075);
            rule__Range__Group__2();

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
    // $ANTLR end "rule__Range__Group__1"


    // $ANTLR start "rule__Range__Group__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2823:1: rule__Range__Group__1__Impl : ( ( rule__Range__MinAssignment_1 ) ) ;
    public final void rule__Range__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2827:1: ( ( ( rule__Range__MinAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2828:1: ( ( rule__Range__MinAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2828:1: ( ( rule__Range__MinAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2829:1: ( rule__Range__MinAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeAccess().getMinAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2830:1: ( rule__Range__MinAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2830:2: rule__Range__MinAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Range__MinAssignment_1_in_rule__Range__Group__1__Impl6102);
            rule__Range__MinAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRangeAccess().getMinAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Range__Group__1__Impl"


    // $ANTLR start "rule__Range__Group__2"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2840:1: rule__Range__Group__2 : rule__Range__Group__2__Impl rule__Range__Group__3 ;
    public final void rule__Range__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2844:1: ( rule__Range__Group__2__Impl rule__Range__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2845:2: rule__Range__Group__2__Impl rule__Range__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Range__Group__2__Impl_in_rule__Range__Group__26132);
            rule__Range__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Range__Group__3_in_rule__Range__Group__26135);
            rule__Range__Group__3();

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
    // $ANTLR end "rule__Range__Group__2"


    // $ANTLR start "rule__Range__Group__2__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2852:1: rule__Range__Group__2__Impl : ( '..' ) ;
    public final void rule__Range__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2856:1: ( ( '..' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2857:1: ( '..' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2857:1: ( '..' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2858:1: '..'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeAccess().getFullStopFullStopKeyword_2()); 
            }
            match(input,60,FollowSets000.FOLLOW_60_in_rule__Range__Group__2__Impl6163); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRangeAccess().getFullStopFullStopKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Range__Group__2__Impl"


    // $ANTLR start "rule__Range__Group__3"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2871:1: rule__Range__Group__3 : rule__Range__Group__3__Impl ;
    public final void rule__Range__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2875:1: ( rule__Range__Group__3__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2876:2: rule__Range__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Range__Group__3__Impl_in_rule__Range__Group__36194);
            rule__Range__Group__3__Impl();

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
    // $ANTLR end "rule__Range__Group__3"


    // $ANTLR start "rule__Range__Group__3__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2882:1: rule__Range__Group__3__Impl : ( ( rule__Range__MaxAssignment_3 ) ) ;
    public final void rule__Range__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2886:1: ( ( ( rule__Range__MaxAssignment_3 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2887:1: ( ( rule__Range__MaxAssignment_3 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2887:1: ( ( rule__Range__MaxAssignment_3 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2888:1: ( rule__Range__MaxAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeAccess().getMaxAssignment_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2889:1: ( rule__Range__MaxAssignment_3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2889:2: rule__Range__MaxAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Range__MaxAssignment_3_in_rule__Range__Group__3__Impl6221);
            rule__Range__MaxAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRangeAccess().getMaxAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Range__Group__3__Impl"


    // $ANTLR start "rule__ValueType__Group__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2907:1: rule__ValueType__Group__0 : rule__ValueType__Group__0__Impl rule__ValueType__Group__1 ;
    public final void rule__ValueType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2911:1: ( rule__ValueType__Group__0__Impl rule__ValueType__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2912:2: rule__ValueType__Group__0__Impl rule__ValueType__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__0__Impl_in_rule__ValueType__Group__06259);
            rule__ValueType__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__1_in_rule__ValueType__Group__06262);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2919:1: rule__ValueType__Group__0__Impl : ( () ) ;
    public final void rule__ValueType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2923:1: ( ( () ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2924:1: ( () )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2924:1: ( () )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2925:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getValueTypeAction_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2926:1: ()
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2928:1: 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2938:1: rule__ValueType__Group__1 : rule__ValueType__Group__1__Impl rule__ValueType__Group__2 ;
    public final void rule__ValueType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2942:1: ( rule__ValueType__Group__1__Impl rule__ValueType__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2943:2: rule__ValueType__Group__1__Impl rule__ValueType__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__1__Impl_in_rule__ValueType__Group__16320);
            rule__ValueType__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__2_in_rule__ValueType__Group__16323);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2950:1: rule__ValueType__Group__1__Impl : ( ( rule__ValueType__TypeAssignment_1 ) ) ;
    public final void rule__ValueType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2954:1: ( ( ( rule__ValueType__TypeAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2955:1: ( ( rule__ValueType__TypeAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2955:1: ( ( rule__ValueType__TypeAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2956:1: ( rule__ValueType__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getTypeAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2957:1: ( rule__ValueType__TypeAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2957:2: rule__ValueType__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__TypeAssignment_1_in_rule__ValueType__Group__1__Impl6350);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2967:1: rule__ValueType__Group__2 : rule__ValueType__Group__2__Impl rule__ValueType__Group__3 ;
    public final void rule__ValueType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2971:1: ( rule__ValueType__Group__2__Impl rule__ValueType__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2972:2: rule__ValueType__Group__2__Impl rule__ValueType__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__2__Impl_in_rule__ValueType__Group__26380);
            rule__ValueType__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__3_in_rule__ValueType__Group__26383);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2979:1: rule__ValueType__Group__2__Impl : ( ( rule__ValueType__WithAutoAssignment_2 )? ) ;
    public final void rule__ValueType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2983:1: ( ( ( rule__ValueType__WithAutoAssignment_2 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2984:1: ( ( rule__ValueType__WithAutoAssignment_2 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2984:1: ( ( rule__ValueType__WithAutoAssignment_2 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2985:1: ( rule__ValueType__WithAutoAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getWithAutoAssignment_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2986:1: ( rule__ValueType__WithAutoAssignment_2 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==64) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2986:2: rule__ValueType__WithAutoAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ValueType__WithAutoAssignment_2_in_rule__ValueType__Group__2__Impl6410);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2996:1: rule__ValueType__Group__3 : rule__ValueType__Group__3__Impl rule__ValueType__Group__4 ;
    public final void rule__ValueType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3000:1: ( rule__ValueType__Group__3__Impl rule__ValueType__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3001:2: rule__ValueType__Group__3__Impl rule__ValueType__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__3__Impl_in_rule__ValueType__Group__36441);
            rule__ValueType__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__4_in_rule__ValueType__Group__36444);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3008:1: rule__ValueType__Group__3__Impl : ( ( rule__ValueType__Group_3__0 )? ) ;
    public final void rule__ValueType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3012:1: ( ( ( rule__ValueType__Group_3__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3013:1: ( ( rule__ValueType__Group_3__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3013:1: ( ( rule__ValueType__Group_3__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3014:1: ( rule__ValueType__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getGroup_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3015:1: ( rule__ValueType__Group_3__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==61) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3015:2: rule__ValueType__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_3__0_in_rule__ValueType__Group__3__Impl6471);
                    rule__ValueType__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getGroup_3()); 
            }

            }


            }

        }
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3025:1: rule__ValueType__Group__4 : rule__ValueType__Group__4__Impl rule__ValueType__Group__5 ;
    public final void rule__ValueType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3029:1: ( rule__ValueType__Group__4__Impl rule__ValueType__Group__5 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3030:2: rule__ValueType__Group__4__Impl rule__ValueType__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__4__Impl_in_rule__ValueType__Group__46502);
            rule__ValueType__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__5_in_rule__ValueType__Group__46505);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3037:1: rule__ValueType__Group__4__Impl : ( ( rule__ValueType__NameAssignment_4 ) ) ;
    public final void rule__ValueType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3041:1: ( ( ( rule__ValueType__NameAssignment_4 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3042:1: ( ( rule__ValueType__NameAssignment_4 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3042:1: ( ( rule__ValueType__NameAssignment_4 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3043:1: ( rule__ValueType__NameAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getNameAssignment_4()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3044:1: ( rule__ValueType__NameAssignment_4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3044:2: rule__ValueType__NameAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__NameAssignment_4_in_rule__ValueType__Group__4__Impl6532);
            rule__ValueType__NameAssignment_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getNameAssignment_4()); 
            }

            }


            }

        }
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3054:1: rule__ValueType__Group__5 : rule__ValueType__Group__5__Impl rule__ValueType__Group__6 ;
    public final void rule__ValueType__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3058:1: ( rule__ValueType__Group__5__Impl rule__ValueType__Group__6 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3059:2: rule__ValueType__Group__5__Impl rule__ValueType__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__5__Impl_in_rule__ValueType__Group__56562);
            rule__ValueType__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__6_in_rule__ValueType__Group__56565);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3066:1: rule__ValueType__Group__5__Impl : ( ( rule__ValueType__MultiValueAssignment_5 )? ) ;
    public final void rule__ValueType__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3070:1: ( ( ( rule__ValueType__MultiValueAssignment_5 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3071:1: ( ( rule__ValueType__MultiValueAssignment_5 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3071:1: ( ( rule__ValueType__MultiValueAssignment_5 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3072:1: ( rule__ValueType__MultiValueAssignment_5 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getMultiValueAssignment_5()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3073:1: ( rule__ValueType__MultiValueAssignment_5 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==65) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3073:2: rule__ValueType__MultiValueAssignment_5
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ValueType__MultiValueAssignment_5_in_rule__ValueType__Group__5__Impl6592);
                    rule__ValueType__MultiValueAssignment_5();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getMultiValueAssignment_5()); 
            }

            }


            }

        }
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3083:1: rule__ValueType__Group__6 : rule__ValueType__Group__6__Impl rule__ValueType__Group__7 ;
    public final void rule__ValueType__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3087:1: ( rule__ValueType__Group__6__Impl rule__ValueType__Group__7 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3088:2: rule__ValueType__Group__6__Impl rule__ValueType__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__6__Impl_in_rule__ValueType__Group__66623);
            rule__ValueType__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__7_in_rule__ValueType__Group__66626);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3095:1: rule__ValueType__Group__6__Impl : ( ( rule__ValueType__Group_6__0 )? ) ;
    public final void rule__ValueType__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3099:1: ( ( ( rule__ValueType__Group_6__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3100:1: ( ( rule__ValueType__Group_6__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3100:1: ( ( rule__ValueType__Group_6__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3101:1: ( rule__ValueType__Group_6__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getGroup_6()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3102:1: ( rule__ValueType__Group_6__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==52) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3102:2: rule__ValueType__Group_6__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_6__0_in_rule__ValueType__Group__6__Impl6653);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3112:1: rule__ValueType__Group__7 : rule__ValueType__Group__7__Impl rule__ValueType__Group__8 ;
    public final void rule__ValueType__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3116:1: ( rule__ValueType__Group__7__Impl rule__ValueType__Group__8 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3117:2: rule__ValueType__Group__7__Impl rule__ValueType__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__7__Impl_in_rule__ValueType__Group__76684);
            rule__ValueType__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__8_in_rule__ValueType__Group__76687);
            rule__ValueType__Group__8();

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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3124:1: rule__ValueType__Group__7__Impl : ( ( rule__ValueType__Group_7__0 )? ) ;
    public final void rule__ValueType__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3128:1: ( ( ( rule__ValueType__Group_7__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3129:1: ( ( rule__ValueType__Group_7__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3129:1: ( ( rule__ValueType__Group_7__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3130:1: ( rule__ValueType__Group_7__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getGroup_7()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3131:1: ( rule__ValueType__Group_7__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==57) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3131:2: rule__ValueType__Group_7__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_7__0_in_rule__ValueType__Group__7__Impl6714);
                    rule__ValueType__Group_7__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getGroup_7()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__ValueType__Group__8"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3141:1: rule__ValueType__Group__8 : rule__ValueType__Group__8__Impl ;
    public final void rule__ValueType__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3145:1: ( rule__ValueType__Group__8__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3146:2: rule__ValueType__Group__8__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__8__Impl_in_rule__ValueType__Group__86745);
            rule__ValueType__Group__8__Impl();

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
    // $ANTLR end "rule__ValueType__Group__8"


    // $ANTLR start "rule__ValueType__Group__8__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3152:1: rule__ValueType__Group__8__Impl : ( ';' ) ;
    public final void rule__ValueType__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3156:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3157:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3157:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3158:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getSemicolonKeyword_8()); 
            }
            match(input,53,FollowSets000.FOLLOW_53_in_rule__ValueType__Group__8__Impl6773); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getSemicolonKeyword_8()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group__8__Impl"


    // $ANTLR start "rule__ValueType__Group_3__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3189:1: rule__ValueType__Group_3__0 : rule__ValueType__Group_3__0__Impl rule__ValueType__Group_3__1 ;
    public final void rule__ValueType__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3193:1: ( rule__ValueType__Group_3__0__Impl rule__ValueType__Group_3__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3194:2: rule__ValueType__Group_3__0__Impl rule__ValueType__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_3__0__Impl_in_rule__ValueType__Group_3__06822);
            rule__ValueType__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_3__1_in_rule__ValueType__Group_3__06825);
            rule__ValueType__Group_3__1();

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
    // $ANTLR end "rule__ValueType__Group_3__0"


    // $ANTLR start "rule__ValueType__Group_3__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3201:1: rule__ValueType__Group_3__0__Impl : ( '[' ) ;
    public final void rule__ValueType__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3205:1: ( ( '[' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3206:1: ( '[' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3206:1: ( '[' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3207:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getLeftSquareBracketKeyword_3_0()); 
            }
            match(input,61,FollowSets000.FOLLOW_61_in_rule__ValueType__Group_3__0__Impl6853); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getLeftSquareBracketKeyword_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group_3__0__Impl"


    // $ANTLR start "rule__ValueType__Group_3__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3220:1: rule__ValueType__Group_3__1 : rule__ValueType__Group_3__1__Impl rule__ValueType__Group_3__2 ;
    public final void rule__ValueType__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3224:1: ( rule__ValueType__Group_3__1__Impl rule__ValueType__Group_3__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3225:2: rule__ValueType__Group_3__1__Impl rule__ValueType__Group_3__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_3__1__Impl_in_rule__ValueType__Group_3__16884);
            rule__ValueType__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_3__2_in_rule__ValueType__Group_3__16887);
            rule__ValueType__Group_3__2();

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
    // $ANTLR end "rule__ValueType__Group_3__1"


    // $ANTLR start "rule__ValueType__Group_3__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3232:1: rule__ValueType__Group_3__1__Impl : ( ( rule__ValueType__ValidValuesAssignment_3_1 ) ) ;
    public final void rule__ValueType__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3236:1: ( ( ( rule__ValueType__ValidValuesAssignment_3_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3237:1: ( ( rule__ValueType__ValidValuesAssignment_3_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3237:1: ( ( rule__ValueType__ValidValuesAssignment_3_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3238:1: ( rule__ValueType__ValidValuesAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getValidValuesAssignment_3_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3239:1: ( rule__ValueType__ValidValuesAssignment_3_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3239:2: rule__ValueType__ValidValuesAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__ValidValuesAssignment_3_1_in_rule__ValueType__Group_3__1__Impl6914);
            rule__ValueType__ValidValuesAssignment_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getValidValuesAssignment_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group_3__1__Impl"


    // $ANTLR start "rule__ValueType__Group_3__2"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3249:1: rule__ValueType__Group_3__2 : rule__ValueType__Group_3__2__Impl ;
    public final void rule__ValueType__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3253:1: ( rule__ValueType__Group_3__2__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3254:2: rule__ValueType__Group_3__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_3__2__Impl_in_rule__ValueType__Group_3__26944);
            rule__ValueType__Group_3__2__Impl();

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
    // $ANTLR end "rule__ValueType__Group_3__2"


    // $ANTLR start "rule__ValueType__Group_3__2__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3260:1: rule__ValueType__Group_3__2__Impl : ( ']' ) ;
    public final void rule__ValueType__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3264:1: ( ( ']' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3265:1: ( ']' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3265:1: ( ']' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3266:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getRightSquareBracketKeyword_3_2()); 
            }
            match(input,62,FollowSets000.FOLLOW_62_in_rule__ValueType__Group_3__2__Impl6972); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getRightSquareBracketKeyword_3_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group_3__2__Impl"


    // $ANTLR start "rule__ValueType__Group_6__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3285:1: rule__ValueType__Group_6__0 : rule__ValueType__Group_6__0__Impl rule__ValueType__Group_6__1 ;
    public final void rule__ValueType__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3289:1: ( rule__ValueType__Group_6__0__Impl rule__ValueType__Group_6__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3290:2: rule__ValueType__Group_6__0__Impl rule__ValueType__Group_6__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_6__0__Impl_in_rule__ValueType__Group_6__07009);
            rule__ValueType__Group_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_6__1_in_rule__ValueType__Group_6__07012);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3297:1: rule__ValueType__Group_6__0__Impl : ( '=' ) ;
    public final void rule__ValueType__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3301:1: ( ( '=' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3302:1: ( '=' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3302:1: ( '=' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3303:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getEqualsSignKeyword_6_0()); 
            }
            match(input,52,FollowSets000.FOLLOW_52_in_rule__ValueType__Group_6__0__Impl7040); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getEqualsSignKeyword_6_0()); 
            }

            }


            }

        }
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3316:1: rule__ValueType__Group_6__1 : rule__ValueType__Group_6__1__Impl ;
    public final void rule__ValueType__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3320:1: ( rule__ValueType__Group_6__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3321:2: rule__ValueType__Group_6__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_6__1__Impl_in_rule__ValueType__Group_6__17071);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3327:1: rule__ValueType__Group_6__1__Impl : ( ( rule__ValueType__Alternatives_6_1 ) ) ;
    public final void rule__ValueType__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3331:1: ( ( ( rule__ValueType__Alternatives_6_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3332:1: ( ( rule__ValueType__Alternatives_6_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3332:1: ( ( rule__ValueType__Alternatives_6_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3333:1: ( rule__ValueType__Alternatives_6_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getAlternatives_6_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3334:1: ( rule__ValueType__Alternatives_6_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3334:2: rule__ValueType__Alternatives_6_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Alternatives_6_1_in_rule__ValueType__Group_6__1__Impl7098);
            rule__ValueType__Alternatives_6_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getAlternatives_6_1()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__ValueType__Group_7__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3348:1: rule__ValueType__Group_7__0 : rule__ValueType__Group_7__0__Impl rule__ValueType__Group_7__1 ;
    public final void rule__ValueType__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3352:1: ( rule__ValueType__Group_7__0__Impl rule__ValueType__Group_7__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3353:2: rule__ValueType__Group_7__0__Impl rule__ValueType__Group_7__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_7__0__Impl_in_rule__ValueType__Group_7__07132);
            rule__ValueType__Group_7__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_7__1_in_rule__ValueType__Group_7__07135);
            rule__ValueType__Group_7__1();

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
    // $ANTLR end "rule__ValueType__Group_7__0"


    // $ANTLR start "rule__ValueType__Group_7__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3360:1: rule__ValueType__Group_7__0__Impl : ( ':' ) ;
    public final void rule__ValueType__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3364:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3365:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3365:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3366:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getColonKeyword_7_0()); 
            }
            match(input,57,FollowSets000.FOLLOW_57_in_rule__ValueType__Group_7__0__Impl7163); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getColonKeyword_7_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group_7__0__Impl"


    // $ANTLR start "rule__ValueType__Group_7__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3379:1: rule__ValueType__Group_7__1 : rule__ValueType__Group_7__1__Impl ;
    public final void rule__ValueType__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3383:1: ( rule__ValueType__Group_7__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3384:2: rule__ValueType__Group_7__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_7__1__Impl_in_rule__ValueType__Group_7__17194);
            rule__ValueType__Group_7__1__Impl();

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
    // $ANTLR end "rule__ValueType__Group_7__1"


    // $ANTLR start "rule__ValueType__Group_7__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3390:1: rule__ValueType__Group_7__1__Impl : ( ( rule__ValueType__DescriptionAssignment_7_1 ) ) ;
    public final void rule__ValueType__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3394:1: ( ( ( rule__ValueType__DescriptionAssignment_7_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3395:1: ( ( rule__ValueType__DescriptionAssignment_7_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3395:1: ( ( rule__ValueType__DescriptionAssignment_7_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3396:1: ( rule__ValueType__DescriptionAssignment_7_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getDescriptionAssignment_7_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3397:1: ( rule__ValueType__DescriptionAssignment_7_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3397:2: rule__ValueType__DescriptionAssignment_7_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__DescriptionAssignment_7_1_in_rule__ValueType__Group_7__1__Impl7221);
            rule__ValueType__DescriptionAssignment_7_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getDescriptionAssignment_7_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group_7__1__Impl"


    // $ANTLR start "rule__VariantType__Group__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3411:1: rule__VariantType__Group__0 : rule__VariantType__Group__0__Impl rule__VariantType__Group__1 ;
    public final void rule__VariantType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3415:1: ( rule__VariantType__Group__0__Impl rule__VariantType__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3416:2: rule__VariantType__Group__0__Impl rule__VariantType__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__0__Impl_in_rule__VariantType__Group__07255);
            rule__VariantType__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__1_in_rule__VariantType__Group__07258);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3423:1: rule__VariantType__Group__0__Impl : ( () ) ;
    public final void rule__VariantType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3427:1: ( ( () ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3428:1: ( () )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3428:1: ( () )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3429:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getVariantTypeAction_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3430:1: ()
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3432:1: 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3442:1: rule__VariantType__Group__1 : rule__VariantType__Group__1__Impl rule__VariantType__Group__2 ;
    public final void rule__VariantType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3446:1: ( rule__VariantType__Group__1__Impl rule__VariantType__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3447:2: rule__VariantType__Group__1__Impl rule__VariantType__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__1__Impl_in_rule__VariantType__Group__17316);
            rule__VariantType__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__2_in_rule__VariantType__Group__17319);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3454:1: rule__VariantType__Group__1__Impl : ( ( rule__VariantType__TypeAssignment_1 ) ) ;
    public final void rule__VariantType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3458:1: ( ( ( rule__VariantType__TypeAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3459:1: ( ( rule__VariantType__TypeAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3459:1: ( ( rule__VariantType__TypeAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3460:1: ( rule__VariantType__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getTypeAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3461:1: ( rule__VariantType__TypeAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3461:2: rule__VariantType__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__TypeAssignment_1_in_rule__VariantType__Group__1__Impl7346);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3471:1: rule__VariantType__Group__2 : rule__VariantType__Group__2__Impl rule__VariantType__Group__3 ;
    public final void rule__VariantType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3475:1: ( rule__VariantType__Group__2__Impl rule__VariantType__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3476:2: rule__VariantType__Group__2__Impl rule__VariantType__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__2__Impl_in_rule__VariantType__Group__27376);
            rule__VariantType__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__3_in_rule__VariantType__Group__27379);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3483:1: rule__VariantType__Group__2__Impl : ( ( rule__VariantType__WithAutoAssignment_2 )? ) ;
    public final void rule__VariantType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3487:1: ( ( ( rule__VariantType__WithAutoAssignment_2 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3488:1: ( ( rule__VariantType__WithAutoAssignment_2 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3488:1: ( ( rule__VariantType__WithAutoAssignment_2 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3489:1: ( rule__VariantType__WithAutoAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getWithAutoAssignment_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3490:1: ( rule__VariantType__WithAutoAssignment_2 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==64) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3490:2: rule__VariantType__WithAutoAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__VariantType__WithAutoAssignment_2_in_rule__VariantType__Group__2__Impl7406);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3500:1: rule__VariantType__Group__3 : rule__VariantType__Group__3__Impl rule__VariantType__Group__4 ;
    public final void rule__VariantType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3504:1: ( rule__VariantType__Group__3__Impl rule__VariantType__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3505:2: rule__VariantType__Group__3__Impl rule__VariantType__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__3__Impl_in_rule__VariantType__Group__37437);
            rule__VariantType__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__4_in_rule__VariantType__Group__37440);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3512:1: rule__VariantType__Group__3__Impl : ( ( rule__VariantType__Group_3__0 )? ) ;
    public final void rule__VariantType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3516:1: ( ( ( rule__VariantType__Group_3__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3517:1: ( ( rule__VariantType__Group_3__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3517:1: ( ( rule__VariantType__Group_3__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3518:1: ( rule__VariantType__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getGroup_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3519:1: ( rule__VariantType__Group_3__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==61) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3519:2: rule__VariantType__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3__0_in_rule__VariantType__Group__3__Impl7467);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3529:1: rule__VariantType__Group__4 : rule__VariantType__Group__4__Impl rule__VariantType__Group__5 ;
    public final void rule__VariantType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3533:1: ( rule__VariantType__Group__4__Impl rule__VariantType__Group__5 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3534:2: rule__VariantType__Group__4__Impl rule__VariantType__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__4__Impl_in_rule__VariantType__Group__47498);
            rule__VariantType__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__5_in_rule__VariantType__Group__47501);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3541:1: rule__VariantType__Group__4__Impl : ( ( rule__VariantType__NameAssignment_4 ) ) ;
    public final void rule__VariantType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3545:1: ( ( ( rule__VariantType__NameAssignment_4 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3546:1: ( ( rule__VariantType__NameAssignment_4 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3546:1: ( ( rule__VariantType__NameAssignment_4 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3547:1: ( rule__VariantType__NameAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getNameAssignment_4()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3548:1: ( rule__VariantType__NameAssignment_4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3548:2: rule__VariantType__NameAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__NameAssignment_4_in_rule__VariantType__Group__4__Impl7528);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3558:1: rule__VariantType__Group__5 : rule__VariantType__Group__5__Impl rule__VariantType__Group__6 ;
    public final void rule__VariantType__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3562:1: ( rule__VariantType__Group__5__Impl rule__VariantType__Group__6 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3563:2: rule__VariantType__Group__5__Impl rule__VariantType__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__5__Impl_in_rule__VariantType__Group__57558);
            rule__VariantType__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__6_in_rule__VariantType__Group__57561);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3570:1: rule__VariantType__Group__5__Impl : ( ( rule__VariantType__MultiValueAssignment_5 )? ) ;
    public final void rule__VariantType__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3574:1: ( ( ( rule__VariantType__MultiValueAssignment_5 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3575:1: ( ( rule__VariantType__MultiValueAssignment_5 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3575:1: ( ( rule__VariantType__MultiValueAssignment_5 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3576:1: ( rule__VariantType__MultiValueAssignment_5 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getMultiValueAssignment_5()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3577:1: ( rule__VariantType__MultiValueAssignment_5 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==65) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3577:2: rule__VariantType__MultiValueAssignment_5
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__VariantType__MultiValueAssignment_5_in_rule__VariantType__Group__5__Impl7588);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3587:1: rule__VariantType__Group__6 : rule__VariantType__Group__6__Impl rule__VariantType__Group__7 ;
    public final void rule__VariantType__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3591:1: ( rule__VariantType__Group__6__Impl rule__VariantType__Group__7 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3592:2: rule__VariantType__Group__6__Impl rule__VariantType__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__6__Impl_in_rule__VariantType__Group__67619);
            rule__VariantType__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__7_in_rule__VariantType__Group__67622);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3599:1: rule__VariantType__Group__6__Impl : ( ( rule__VariantType__Group_6__0 )? ) ;
    public final void rule__VariantType__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3603:1: ( ( ( rule__VariantType__Group_6__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3604:1: ( ( rule__VariantType__Group_6__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3604:1: ( ( rule__VariantType__Group_6__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3605:1: ( rule__VariantType__Group_6__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getGroup_6()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3606:1: ( rule__VariantType__Group_6__0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==52) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3606:2: rule__VariantType__Group_6__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_6__0_in_rule__VariantType__Group__6__Impl7649);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3616:1: rule__VariantType__Group__7 : rule__VariantType__Group__7__Impl rule__VariantType__Group__8 ;
    public final void rule__VariantType__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3620:1: ( rule__VariantType__Group__7__Impl rule__VariantType__Group__8 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3621:2: rule__VariantType__Group__7__Impl rule__VariantType__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__7__Impl_in_rule__VariantType__Group__77680);
            rule__VariantType__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__8_in_rule__VariantType__Group__77683);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3628:1: rule__VariantType__Group__7__Impl : ( ( rule__VariantType__Group_7__0 )? ) ;
    public final void rule__VariantType__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3632:1: ( ( ( rule__VariantType__Group_7__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3633:1: ( ( rule__VariantType__Group_7__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3633:1: ( ( rule__VariantType__Group_7__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3634:1: ( rule__VariantType__Group_7__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getGroup_7()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3635:1: ( rule__VariantType__Group_7__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==57) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3635:2: rule__VariantType__Group_7__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_7__0_in_rule__VariantType__Group__7__Impl7710);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3645:1: rule__VariantType__Group__8 : rule__VariantType__Group__8__Impl ;
    public final void rule__VariantType__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3649:1: ( rule__VariantType__Group__8__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3650:2: rule__VariantType__Group__8__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__8__Impl_in_rule__VariantType__Group__87741);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3656:1: rule__VariantType__Group__8__Impl : ( ';' ) ;
    public final void rule__VariantType__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3660:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3661:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3661:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3662:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getSemicolonKeyword_8()); 
            }
            match(input,53,FollowSets000.FOLLOW_53_in_rule__VariantType__Group__8__Impl7769); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3693:1: rule__VariantType__Group_3__0 : rule__VariantType__Group_3__0__Impl rule__VariantType__Group_3__1 ;
    public final void rule__VariantType__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3697:1: ( rule__VariantType__Group_3__0__Impl rule__VariantType__Group_3__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3698:2: rule__VariantType__Group_3__0__Impl rule__VariantType__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3__0__Impl_in_rule__VariantType__Group_3__07818);
            rule__VariantType__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3__1_in_rule__VariantType__Group_3__07821);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3705:1: rule__VariantType__Group_3__0__Impl : ( '[' ) ;
    public final void rule__VariantType__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3709:1: ( ( '[' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3710:1: ( '[' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3710:1: ( '[' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3711:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getLeftSquareBracketKeyword_3_0()); 
            }
            match(input,61,FollowSets000.FOLLOW_61_in_rule__VariantType__Group_3__0__Impl7849); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3724:1: rule__VariantType__Group_3__1 : rule__VariantType__Group_3__1__Impl rule__VariantType__Group_3__2 ;
    public final void rule__VariantType__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3728:1: ( rule__VariantType__Group_3__1__Impl rule__VariantType__Group_3__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3729:2: rule__VariantType__Group_3__1__Impl rule__VariantType__Group_3__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3__1__Impl_in_rule__VariantType__Group_3__17880);
            rule__VariantType__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3__2_in_rule__VariantType__Group_3__17883);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3736:1: rule__VariantType__Group_3__1__Impl : ( ( rule__VariantType__Group_3_1__0 )? ) ;
    public final void rule__VariantType__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3740:1: ( ( ( rule__VariantType__Group_3_1__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3741:1: ( ( rule__VariantType__Group_3_1__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3741:1: ( ( rule__VariantType__Group_3_1__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3742:1: ( rule__VariantType__Group_3_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getGroup_3_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3743:1: ( rule__VariantType__Group_3_1__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_ID||(LA41_0>=13 && LA41_0<=46)) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3743:2: rule__VariantType__Group_3_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3_1__0_in_rule__VariantType__Group_3__1__Impl7910);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3753:1: rule__VariantType__Group_3__2 : rule__VariantType__Group_3__2__Impl ;
    public final void rule__VariantType__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3757:1: ( rule__VariantType__Group_3__2__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3758:2: rule__VariantType__Group_3__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3__2__Impl_in_rule__VariantType__Group_3__27941);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3764:1: rule__VariantType__Group_3__2__Impl : ( ']' ) ;
    public final void rule__VariantType__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3768:1: ( ( ']' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3769:1: ( ']' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3769:1: ( ']' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3770:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getRightSquareBracketKeyword_3_2()); 
            }
            match(input,62,FollowSets000.FOLLOW_62_in_rule__VariantType__Group_3__2__Impl7969); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3789:1: rule__VariantType__Group_3_1__0 : rule__VariantType__Group_3_1__0__Impl rule__VariantType__Group_3_1__1 ;
    public final void rule__VariantType__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3793:1: ( rule__VariantType__Group_3_1__0__Impl rule__VariantType__Group_3_1__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3794:2: rule__VariantType__Group_3_1__0__Impl rule__VariantType__Group_3_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3_1__0__Impl_in_rule__VariantType__Group_3_1__08006);
            rule__VariantType__Group_3_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3_1__1_in_rule__VariantType__Group_3_1__08009);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3801:1: rule__VariantType__Group_3_1__0__Impl : ( ( rule__VariantType__ValuesAssignment_3_1_0 ) ) ;
    public final void rule__VariantType__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3805:1: ( ( ( rule__VariantType__ValuesAssignment_3_1_0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3806:1: ( ( rule__VariantType__ValuesAssignment_3_1_0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3806:1: ( ( rule__VariantType__ValuesAssignment_3_1_0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3807:1: ( rule__VariantType__ValuesAssignment_3_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getValuesAssignment_3_1_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3808:1: ( rule__VariantType__ValuesAssignment_3_1_0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3808:2: rule__VariantType__ValuesAssignment_3_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__ValuesAssignment_3_1_0_in_rule__VariantType__Group_3_1__0__Impl8036);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3818:1: rule__VariantType__Group_3_1__1 : rule__VariantType__Group_3_1__1__Impl ;
    public final void rule__VariantType__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3822:1: ( rule__VariantType__Group_3_1__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3823:2: rule__VariantType__Group_3_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3_1__1__Impl_in_rule__VariantType__Group_3_1__18066);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3829:1: rule__VariantType__Group_3_1__1__Impl : ( ( rule__VariantType__Group_3_1_1__0 )* ) ;
    public final void rule__VariantType__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3833:1: ( ( ( rule__VariantType__Group_3_1_1__0 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3834:1: ( ( rule__VariantType__Group_3_1_1__0 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3834:1: ( ( rule__VariantType__Group_3_1_1__0 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3835:1: ( rule__VariantType__Group_3_1_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getGroup_3_1_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3836:1: ( rule__VariantType__Group_3_1_1__0 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==59) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3836:2: rule__VariantType__Group_3_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3_1_1__0_in_rule__VariantType__Group_3_1__1__Impl8093);
            	    rule__VariantType__Group_3_1_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop42;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3850:1: rule__VariantType__Group_3_1_1__0 : rule__VariantType__Group_3_1_1__0__Impl rule__VariantType__Group_3_1_1__1 ;
    public final void rule__VariantType__Group_3_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3854:1: ( rule__VariantType__Group_3_1_1__0__Impl rule__VariantType__Group_3_1_1__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3855:2: rule__VariantType__Group_3_1_1__0__Impl rule__VariantType__Group_3_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3_1_1__0__Impl_in_rule__VariantType__Group_3_1_1__08128);
            rule__VariantType__Group_3_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3_1_1__1_in_rule__VariantType__Group_3_1_1__08131);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3862:1: rule__VariantType__Group_3_1_1__0__Impl : ( ',' ) ;
    public final void rule__VariantType__Group_3_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3866:1: ( ( ',' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3867:1: ( ',' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3867:1: ( ',' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3868:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getCommaKeyword_3_1_1_0()); 
            }
            match(input,59,FollowSets000.FOLLOW_59_in_rule__VariantType__Group_3_1_1__0__Impl8159); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3881:1: rule__VariantType__Group_3_1_1__1 : rule__VariantType__Group_3_1_1__1__Impl ;
    public final void rule__VariantType__Group_3_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3885:1: ( rule__VariantType__Group_3_1_1__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3886:2: rule__VariantType__Group_3_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3_1_1__1__Impl_in_rule__VariantType__Group_3_1_1__18190);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3892:1: rule__VariantType__Group_3_1_1__1__Impl : ( ( rule__VariantType__ValuesAssignment_3_1_1_1 ) ) ;
    public final void rule__VariantType__Group_3_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3896:1: ( ( ( rule__VariantType__ValuesAssignment_3_1_1_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3897:1: ( ( rule__VariantType__ValuesAssignment_3_1_1_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3897:1: ( ( rule__VariantType__ValuesAssignment_3_1_1_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3898:1: ( rule__VariantType__ValuesAssignment_3_1_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getValuesAssignment_3_1_1_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3899:1: ( rule__VariantType__ValuesAssignment_3_1_1_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3899:2: rule__VariantType__ValuesAssignment_3_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__ValuesAssignment_3_1_1_1_in_rule__VariantType__Group_3_1_1__1__Impl8217);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3913:1: rule__VariantType__Group_6__0 : rule__VariantType__Group_6__0__Impl rule__VariantType__Group_6__1 ;
    public final void rule__VariantType__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3917:1: ( rule__VariantType__Group_6__0__Impl rule__VariantType__Group_6__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3918:2: rule__VariantType__Group_6__0__Impl rule__VariantType__Group_6__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_6__0__Impl_in_rule__VariantType__Group_6__08251);
            rule__VariantType__Group_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_6__1_in_rule__VariantType__Group_6__08254);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3925:1: rule__VariantType__Group_6__0__Impl : ( '=' ) ;
    public final void rule__VariantType__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3929:1: ( ( '=' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3930:1: ( '=' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3930:1: ( '=' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3931:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getEqualsSignKeyword_6_0()); 
            }
            match(input,52,FollowSets000.FOLLOW_52_in_rule__VariantType__Group_6__0__Impl8282); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3944:1: rule__VariantType__Group_6__1 : rule__VariantType__Group_6__1__Impl ;
    public final void rule__VariantType__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3948:1: ( rule__VariantType__Group_6__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3949:2: rule__VariantType__Group_6__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_6__1__Impl_in_rule__VariantType__Group_6__18313);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3955:1: rule__VariantType__Group_6__1__Impl : ( ( rule__VariantType__Alternatives_6_1 ) ) ;
    public final void rule__VariantType__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3959:1: ( ( ( rule__VariantType__Alternatives_6_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3960:1: ( ( rule__VariantType__Alternatives_6_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3960:1: ( ( rule__VariantType__Alternatives_6_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3961:1: ( rule__VariantType__Alternatives_6_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getAlternatives_6_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3962:1: ( rule__VariantType__Alternatives_6_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3962:2: rule__VariantType__Alternatives_6_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Alternatives_6_1_in_rule__VariantType__Group_6__1__Impl8340);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3976:1: rule__VariantType__Group_7__0 : rule__VariantType__Group_7__0__Impl rule__VariantType__Group_7__1 ;
    public final void rule__VariantType__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3980:1: ( rule__VariantType__Group_7__0__Impl rule__VariantType__Group_7__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3981:2: rule__VariantType__Group_7__0__Impl rule__VariantType__Group_7__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_7__0__Impl_in_rule__VariantType__Group_7__08374);
            rule__VariantType__Group_7__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_7__1_in_rule__VariantType__Group_7__08377);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3988:1: rule__VariantType__Group_7__0__Impl : ( ':' ) ;
    public final void rule__VariantType__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3992:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3993:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3993:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3994:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getColonKeyword_7_0()); 
            }
            match(input,57,FollowSets000.FOLLOW_57_in_rule__VariantType__Group_7__0__Impl8405); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4007:1: rule__VariantType__Group_7__1 : rule__VariantType__Group_7__1__Impl ;
    public final void rule__VariantType__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4011:1: ( rule__VariantType__Group_7__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4012:2: rule__VariantType__Group_7__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_7__1__Impl_in_rule__VariantType__Group_7__18436);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4018:1: rule__VariantType__Group_7__1__Impl : ( ( rule__VariantType__DescriptionAssignment_7_1 ) ) ;
    public final void rule__VariantType__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4022:1: ( ( ( rule__VariantType__DescriptionAssignment_7_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4023:1: ( ( rule__VariantType__DescriptionAssignment_7_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4023:1: ( ( rule__VariantType__DescriptionAssignment_7_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4024:1: ( rule__VariantType__DescriptionAssignment_7_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getDescriptionAssignment_7_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4025:1: ( rule__VariantType__DescriptionAssignment_7_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4025:2: rule__VariantType__DescriptionAssignment_7_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__DescriptionAssignment_7_1_in_rule__VariantType__Group_7__1__Impl8463);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4039:1: rule__EnumeratorType__Group__0 : rule__EnumeratorType__Group__0__Impl rule__EnumeratorType__Group__1 ;
    public final void rule__EnumeratorType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4043:1: ( rule__EnumeratorType__Group__0__Impl rule__EnumeratorType__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4044:2: rule__EnumeratorType__Group__0__Impl rule__EnumeratorType__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group__0__Impl_in_rule__EnumeratorType__Group__08497);
            rule__EnumeratorType__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group__1_in_rule__EnumeratorType__Group__08500);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4051:1: rule__EnumeratorType__Group__0__Impl : ( () ) ;
    public final void rule__EnumeratorType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4055:1: ( ( () ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4056:1: ( () )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4056:1: ( () )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4057:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getEnumeratorTypeAction_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4058:1: ()
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4060:1: 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4070:1: rule__EnumeratorType__Group__1 : rule__EnumeratorType__Group__1__Impl rule__EnumeratorType__Group__2 ;
    public final void rule__EnumeratorType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4074:1: ( rule__EnumeratorType__Group__1__Impl rule__EnumeratorType__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4075:2: rule__EnumeratorType__Group__1__Impl rule__EnumeratorType__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group__1__Impl_in_rule__EnumeratorType__Group__18558);
            rule__EnumeratorType__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group__2_in_rule__EnumeratorType__Group__18561);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4082:1: rule__EnumeratorType__Group__1__Impl : ( ( rule__EnumeratorType__NameAssignment_1 ) ) ;
    public final void rule__EnumeratorType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4086:1: ( ( ( rule__EnumeratorType__NameAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4087:1: ( ( rule__EnumeratorType__NameAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4087:1: ( ( rule__EnumeratorType__NameAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4088:1: ( rule__EnumeratorType__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getNameAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4089:1: ( rule__EnumeratorType__NameAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4089:2: rule__EnumeratorType__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__NameAssignment_1_in_rule__EnumeratorType__Group__1__Impl8588);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4099:1: rule__EnumeratorType__Group__2 : rule__EnumeratorType__Group__2__Impl rule__EnumeratorType__Group__3 ;
    public final void rule__EnumeratorType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4103:1: ( rule__EnumeratorType__Group__2__Impl rule__EnumeratorType__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4104:2: rule__EnumeratorType__Group__2__Impl rule__EnumeratorType__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group__2__Impl_in_rule__EnumeratorType__Group__28618);
            rule__EnumeratorType__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group__3_in_rule__EnumeratorType__Group__28621);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4111:1: rule__EnumeratorType__Group__2__Impl : ( ( rule__EnumeratorType__Group_2__0 )? ) ;
    public final void rule__EnumeratorType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4115:1: ( ( ( rule__EnumeratorType__Group_2__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4116:1: ( ( rule__EnumeratorType__Group_2__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4116:1: ( ( rule__EnumeratorType__Group_2__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4117:1: ( rule__EnumeratorType__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getGroup_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4118:1: ( rule__EnumeratorType__Group_2__0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==55) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4118:2: rule__EnumeratorType__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_2__0_in_rule__EnumeratorType__Group__2__Impl8648);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4128:1: rule__EnumeratorType__Group__3 : rule__EnumeratorType__Group__3__Impl ;
    public final void rule__EnumeratorType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4132:1: ( rule__EnumeratorType__Group__3__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4133:2: rule__EnumeratorType__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group__3__Impl_in_rule__EnumeratorType__Group__38679);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4139:1: rule__EnumeratorType__Group__3__Impl : ( ( rule__EnumeratorType__Group_3__0 )? ) ;
    public final void rule__EnumeratorType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4143:1: ( ( ( rule__EnumeratorType__Group_3__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4144:1: ( ( rule__EnumeratorType__Group_3__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4144:1: ( ( rule__EnumeratorType__Group_3__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4145:1: ( rule__EnumeratorType__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getGroup_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4146:1: ( rule__EnumeratorType__Group_3__0 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==57) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4146:2: rule__EnumeratorType__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_3__0_in_rule__EnumeratorType__Group__3__Impl8706);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4164:1: rule__EnumeratorType__Group_2__0 : rule__EnumeratorType__Group_2__0__Impl rule__EnumeratorType__Group_2__1 ;
    public final void rule__EnumeratorType__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4168:1: ( rule__EnumeratorType__Group_2__0__Impl rule__EnumeratorType__Group_2__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4169:2: rule__EnumeratorType__Group_2__0__Impl rule__EnumeratorType__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_2__0__Impl_in_rule__EnumeratorType__Group_2__08745);
            rule__EnumeratorType__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_2__1_in_rule__EnumeratorType__Group_2__08748);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4176:1: rule__EnumeratorType__Group_2__0__Impl : ( '{' ) ;
    public final void rule__EnumeratorType__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4180:1: ( ( '{' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4181:1: ( '{' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4181:1: ( '{' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4182:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getLeftCurlyBracketKeyword_2_0()); 
            }
            match(input,55,FollowSets000.FOLLOW_55_in_rule__EnumeratorType__Group_2__0__Impl8776); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4195:1: rule__EnumeratorType__Group_2__1 : rule__EnumeratorType__Group_2__1__Impl rule__EnumeratorType__Group_2__2 ;
    public final void rule__EnumeratorType__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4199:1: ( rule__EnumeratorType__Group_2__1__Impl rule__EnumeratorType__Group_2__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4200:2: rule__EnumeratorType__Group_2__1__Impl rule__EnumeratorType__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_2__1__Impl_in_rule__EnumeratorType__Group_2__18807);
            rule__EnumeratorType__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_2__2_in_rule__EnumeratorType__Group_2__18810);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4207:1: rule__EnumeratorType__Group_2__1__Impl : ( ( rule__EnumeratorType__ParametersAssignment_2_1 )* ) ;
    public final void rule__EnumeratorType__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4211:1: ( ( ( rule__EnumeratorType__ParametersAssignment_2_1 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4212:1: ( ( rule__EnumeratorType__ParametersAssignment_2_1 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4212:1: ( ( rule__EnumeratorType__ParametersAssignment_2_1 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4213:1: ( rule__EnumeratorType__ParametersAssignment_2_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getParametersAssignment_2_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4214:1: ( rule__EnumeratorType__ParametersAssignment_2_1 )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( ((LA45_0>=13 && LA45_0<=20)||(LA45_0>=34 && LA45_0<=46)||LA45_0==50) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4214:2: rule__EnumeratorType__ParametersAssignment_2_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__ParametersAssignment_2_1_in_rule__EnumeratorType__Group_2__1__Impl8837);
            	    rule__EnumeratorType__ParametersAssignment_2_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop45;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4224:1: rule__EnumeratorType__Group_2__2 : rule__EnumeratorType__Group_2__2__Impl ;
    public final void rule__EnumeratorType__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4228:1: ( rule__EnumeratorType__Group_2__2__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4229:2: rule__EnumeratorType__Group_2__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_2__2__Impl_in_rule__EnumeratorType__Group_2__28868);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4235:1: rule__EnumeratorType__Group_2__2__Impl : ( '}' ) ;
    public final void rule__EnumeratorType__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4239:1: ( ( '}' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4240:1: ( '}' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4240:1: ( '}' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4241:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getRightCurlyBracketKeyword_2_2()); 
            }
            match(input,56,FollowSets000.FOLLOW_56_in_rule__EnumeratorType__Group_2__2__Impl8896); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4260:1: rule__EnumeratorType__Group_3__0 : rule__EnumeratorType__Group_3__0__Impl rule__EnumeratorType__Group_3__1 ;
    public final void rule__EnumeratorType__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4264:1: ( rule__EnumeratorType__Group_3__0__Impl rule__EnumeratorType__Group_3__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4265:2: rule__EnumeratorType__Group_3__0__Impl rule__EnumeratorType__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_3__0__Impl_in_rule__EnumeratorType__Group_3__08933);
            rule__EnumeratorType__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_3__1_in_rule__EnumeratorType__Group_3__08936);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4272:1: rule__EnumeratorType__Group_3__0__Impl : ( ':' ) ;
    public final void rule__EnumeratorType__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4276:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4277:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4277:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4278:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getColonKeyword_3_0()); 
            }
            match(input,57,FollowSets000.FOLLOW_57_in_rule__EnumeratorType__Group_3__0__Impl8964); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4291:1: rule__EnumeratorType__Group_3__1 : rule__EnumeratorType__Group_3__1__Impl ;
    public final void rule__EnumeratorType__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4295:1: ( rule__EnumeratorType__Group_3__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4296:2: rule__EnumeratorType__Group_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_3__1__Impl_in_rule__EnumeratorType__Group_3__18995);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4302:1: rule__EnumeratorType__Group_3__1__Impl : ( ( rule__EnumeratorType__DescriptionAssignment_3_1 ) ) ;
    public final void rule__EnumeratorType__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4306:1: ( ( ( rule__EnumeratorType__DescriptionAssignment_3_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4307:1: ( ( rule__EnumeratorType__DescriptionAssignment_3_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4307:1: ( ( rule__EnumeratorType__DescriptionAssignment_3_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4308:1: ( rule__EnumeratorType__DescriptionAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getDescriptionAssignment_3_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4309:1: ( rule__EnumeratorType__DescriptionAssignment_3_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4309:2: rule__EnumeratorType__DescriptionAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__DescriptionAssignment_3_1_in_rule__EnumeratorType__Group_3__1__Impl9022);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4323:1: rule__ReferenceType__Group__0 : rule__ReferenceType__Group__0__Impl rule__ReferenceType__Group__1 ;
    public final void rule__ReferenceType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4327:1: ( rule__ReferenceType__Group__0__Impl rule__ReferenceType__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4328:2: rule__ReferenceType__Group__0__Impl rule__ReferenceType__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__0__Impl_in_rule__ReferenceType__Group__09056);
            rule__ReferenceType__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__1_in_rule__ReferenceType__Group__09059);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4335:1: rule__ReferenceType__Group__0__Impl : ( () ) ;
    public final void rule__ReferenceType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4339:1: ( ( () ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4340:1: ( () )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4340:1: ( () )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4341:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getReferenceTypeAction_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4342:1: ()
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4344:1: 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4354:1: rule__ReferenceType__Group__1 : rule__ReferenceType__Group__1__Impl rule__ReferenceType__Group__2 ;
    public final void rule__ReferenceType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4358:1: ( rule__ReferenceType__Group__1__Impl rule__ReferenceType__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4359:2: rule__ReferenceType__Group__1__Impl rule__ReferenceType__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__1__Impl_in_rule__ReferenceType__Group__19117);
            rule__ReferenceType__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__2_in_rule__ReferenceType__Group__19120);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4366:1: rule__ReferenceType__Group__1__Impl : ( ( rule__ReferenceType__TypeAssignment_1 ) ) ;
    public final void rule__ReferenceType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4370:1: ( ( ( rule__ReferenceType__TypeAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4371:1: ( ( rule__ReferenceType__TypeAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4371:1: ( ( rule__ReferenceType__TypeAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4372:1: ( rule__ReferenceType__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getTypeAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4373:1: ( rule__ReferenceType__TypeAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4373:2: rule__ReferenceType__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__TypeAssignment_1_in_rule__ReferenceType__Group__1__Impl9147);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4383:1: rule__ReferenceType__Group__2 : rule__ReferenceType__Group__2__Impl rule__ReferenceType__Group__3 ;
    public final void rule__ReferenceType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4387:1: ( rule__ReferenceType__Group__2__Impl rule__ReferenceType__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4388:2: rule__ReferenceType__Group__2__Impl rule__ReferenceType__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__2__Impl_in_rule__ReferenceType__Group__29177);
            rule__ReferenceType__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__3_in_rule__ReferenceType__Group__29180);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4395:1: rule__ReferenceType__Group__2__Impl : ( ( rule__ReferenceType__NameAssignment_2 ) ) ;
    public final void rule__ReferenceType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4399:1: ( ( ( rule__ReferenceType__NameAssignment_2 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4400:1: ( ( rule__ReferenceType__NameAssignment_2 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4400:1: ( ( rule__ReferenceType__NameAssignment_2 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4401:1: ( rule__ReferenceType__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getNameAssignment_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4402:1: ( rule__ReferenceType__NameAssignment_2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4402:2: rule__ReferenceType__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__NameAssignment_2_in_rule__ReferenceType__Group__2__Impl9207);
            rule__ReferenceType__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getNameAssignment_2()); 
            }

            }


            }

        }
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4412:1: rule__ReferenceType__Group__3 : rule__ReferenceType__Group__3__Impl rule__ReferenceType__Group__4 ;
    public final void rule__ReferenceType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4416:1: ( rule__ReferenceType__Group__3__Impl rule__ReferenceType__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4417:2: rule__ReferenceType__Group__3__Impl rule__ReferenceType__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__3__Impl_in_rule__ReferenceType__Group__39237);
            rule__ReferenceType__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__4_in_rule__ReferenceType__Group__39240);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4424:1: rule__ReferenceType__Group__3__Impl : ( ( rule__ReferenceType__MultiValueAssignment_3 )? ) ;
    public final void rule__ReferenceType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4428:1: ( ( ( rule__ReferenceType__MultiValueAssignment_3 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4429:1: ( ( rule__ReferenceType__MultiValueAssignment_3 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4429:1: ( ( rule__ReferenceType__MultiValueAssignment_3 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4430:1: ( rule__ReferenceType__MultiValueAssignment_3 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getMultiValueAssignment_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4431:1: ( rule__ReferenceType__MultiValueAssignment_3 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==65) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4431:2: rule__ReferenceType__MultiValueAssignment_3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__MultiValueAssignment_3_in_rule__ReferenceType__Group__3__Impl9267);
                    rule__ReferenceType__MultiValueAssignment_3();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getMultiValueAssignment_3()); 
            }

            }


            }

        }
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4441:1: rule__ReferenceType__Group__4 : rule__ReferenceType__Group__4__Impl rule__ReferenceType__Group__5 ;
    public final void rule__ReferenceType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4445:1: ( rule__ReferenceType__Group__4__Impl rule__ReferenceType__Group__5 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4446:2: rule__ReferenceType__Group__4__Impl rule__ReferenceType__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__4__Impl_in_rule__ReferenceType__Group__49298);
            rule__ReferenceType__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__5_in_rule__ReferenceType__Group__49301);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4453:1: rule__ReferenceType__Group__4__Impl : ( ( rule__ReferenceType__Group_4__0 )? ) ;
    public final void rule__ReferenceType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4457:1: ( ( ( rule__ReferenceType__Group_4__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4458:1: ( ( rule__ReferenceType__Group_4__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4458:1: ( ( rule__ReferenceType__Group_4__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4459:1: ( rule__ReferenceType__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getGroup_4()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4460:1: ( rule__ReferenceType__Group_4__0 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==52) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4460:2: rule__ReferenceType__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_4__0_in_rule__ReferenceType__Group__4__Impl9328);
                    rule__ReferenceType__Group_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getGroup_4()); 
            }

            }


            }

        }
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4470:1: rule__ReferenceType__Group__5 : rule__ReferenceType__Group__5__Impl rule__ReferenceType__Group__6 ;
    public final void rule__ReferenceType__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4474:1: ( rule__ReferenceType__Group__5__Impl rule__ReferenceType__Group__6 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4475:2: rule__ReferenceType__Group__5__Impl rule__ReferenceType__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__5__Impl_in_rule__ReferenceType__Group__59359);
            rule__ReferenceType__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__6_in_rule__ReferenceType__Group__59362);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4482:1: rule__ReferenceType__Group__5__Impl : ( ( rule__ReferenceType__Group_5__0 )? ) ;
    public final void rule__ReferenceType__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4486:1: ( ( ( rule__ReferenceType__Group_5__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4487:1: ( ( rule__ReferenceType__Group_5__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4487:1: ( ( rule__ReferenceType__Group_5__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4488:1: ( rule__ReferenceType__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getGroup_5()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4489:1: ( rule__ReferenceType__Group_5__0 )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==57) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4489:2: rule__ReferenceType__Group_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_5__0_in_rule__ReferenceType__Group__5__Impl9389);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4499:1: rule__ReferenceType__Group__6 : rule__ReferenceType__Group__6__Impl ;
    public final void rule__ReferenceType__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4503:1: ( rule__ReferenceType__Group__6__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4504:2: rule__ReferenceType__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__6__Impl_in_rule__ReferenceType__Group__69420);
            rule__ReferenceType__Group__6__Impl();

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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4510:1: rule__ReferenceType__Group__6__Impl : ( ';' ) ;
    public final void rule__ReferenceType__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4514:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4515:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4515:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4516:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getSemicolonKeyword_6()); 
            }
            match(input,53,FollowSets000.FOLLOW_53_in_rule__ReferenceType__Group__6__Impl9448); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getSemicolonKeyword_6()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__ReferenceType__Group_4__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4543:1: rule__ReferenceType__Group_4__0 : rule__ReferenceType__Group_4__0__Impl rule__ReferenceType__Group_4__1 ;
    public final void rule__ReferenceType__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4547:1: ( rule__ReferenceType__Group_4__0__Impl rule__ReferenceType__Group_4__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4548:2: rule__ReferenceType__Group_4__0__Impl rule__ReferenceType__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_4__0__Impl_in_rule__ReferenceType__Group_4__09493);
            rule__ReferenceType__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_4__1_in_rule__ReferenceType__Group_4__09496);
            rule__ReferenceType__Group_4__1();

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
    // $ANTLR end "rule__ReferenceType__Group_4__0"


    // $ANTLR start "rule__ReferenceType__Group_4__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4555:1: rule__ReferenceType__Group_4__0__Impl : ( '=' ) ;
    public final void rule__ReferenceType__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4559:1: ( ( '=' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4560:1: ( '=' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4560:1: ( '=' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4561:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getEqualsSignKeyword_4_0()); 
            }
            match(input,52,FollowSets000.FOLLOW_52_in_rule__ReferenceType__Group_4__0__Impl9524); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getEqualsSignKeyword_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__Group_4__0__Impl"


    // $ANTLR start "rule__ReferenceType__Group_4__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4574:1: rule__ReferenceType__Group_4__1 : rule__ReferenceType__Group_4__1__Impl ;
    public final void rule__ReferenceType__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4578:1: ( rule__ReferenceType__Group_4__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4579:2: rule__ReferenceType__Group_4__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_4__1__Impl_in_rule__ReferenceType__Group_4__19555);
            rule__ReferenceType__Group_4__1__Impl();

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
    // $ANTLR end "rule__ReferenceType__Group_4__1"


    // $ANTLR start "rule__ReferenceType__Group_4__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4585:1: rule__ReferenceType__Group_4__1__Impl : ( ( rule__ReferenceType__Alternatives_4_1 ) ) ;
    public final void rule__ReferenceType__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4589:1: ( ( ( rule__ReferenceType__Alternatives_4_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4590:1: ( ( rule__ReferenceType__Alternatives_4_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4590:1: ( ( rule__ReferenceType__Alternatives_4_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4591:1: ( rule__ReferenceType__Alternatives_4_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getAlternatives_4_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4592:1: ( rule__ReferenceType__Alternatives_4_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4592:2: rule__ReferenceType__Alternatives_4_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Alternatives_4_1_in_rule__ReferenceType__Group_4__1__Impl9582);
            rule__ReferenceType__Alternatives_4_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getAlternatives_4_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__Group_4__1__Impl"


    // $ANTLR start "rule__ReferenceType__Group_5__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4606:1: rule__ReferenceType__Group_5__0 : rule__ReferenceType__Group_5__0__Impl rule__ReferenceType__Group_5__1 ;
    public final void rule__ReferenceType__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4610:1: ( rule__ReferenceType__Group_5__0__Impl rule__ReferenceType__Group_5__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4611:2: rule__ReferenceType__Group_5__0__Impl rule__ReferenceType__Group_5__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_5__0__Impl_in_rule__ReferenceType__Group_5__09616);
            rule__ReferenceType__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_5__1_in_rule__ReferenceType__Group_5__09619);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4618:1: rule__ReferenceType__Group_5__0__Impl : ( ':' ) ;
    public final void rule__ReferenceType__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4622:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4623:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4623:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4624:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getColonKeyword_5_0()); 
            }
            match(input,57,FollowSets000.FOLLOW_57_in_rule__ReferenceType__Group_5__0__Impl9647); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getColonKeyword_5_0()); 
            }

            }


            }

        }
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4637:1: rule__ReferenceType__Group_5__1 : rule__ReferenceType__Group_5__1__Impl ;
    public final void rule__ReferenceType__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4641:1: ( rule__ReferenceType__Group_5__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4642:2: rule__ReferenceType__Group_5__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_5__1__Impl_in_rule__ReferenceType__Group_5__19678);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4648:1: rule__ReferenceType__Group_5__1__Impl : ( ( rule__ReferenceType__DescriptionAssignment_5_1 ) ) ;
    public final void rule__ReferenceType__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4652:1: ( ( ( rule__ReferenceType__DescriptionAssignment_5_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4653:1: ( ( rule__ReferenceType__DescriptionAssignment_5_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4653:1: ( ( rule__ReferenceType__DescriptionAssignment_5_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4654:1: ( rule__ReferenceType__DescriptionAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getDescriptionAssignment_5_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4655:1: ( rule__ReferenceType__DescriptionAssignment_5_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4655:2: rule__ReferenceType__DescriptionAssignment_5_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__DescriptionAssignment_5_1_in_rule__ReferenceType__Group_5__1__Impl9705);
            rule__ReferenceType__DescriptionAssignment_5_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getDescriptionAssignment_5_1()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__OilObject__Group__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4669:1: rule__OilObject__Group__0 : rule__OilObject__Group__0__Impl rule__OilObject__Group__1 ;
    public final void rule__OilObject__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4673:1: ( rule__OilObject__Group__0__Impl rule__OilObject__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4674:2: rule__OilObject__Group__0__Impl rule__OilObject__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__0__Impl_in_rule__OilObject__Group__09739);
            rule__OilObject__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__1_in_rule__OilObject__Group__09742);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4681:1: rule__OilObject__Group__0__Impl : ( ( rule__OilObject__TypeAssignment_0 ) ) ;
    public final void rule__OilObject__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4685:1: ( ( ( rule__OilObject__TypeAssignment_0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4686:1: ( ( rule__OilObject__TypeAssignment_0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4686:1: ( ( rule__OilObject__TypeAssignment_0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4687:1: ( rule__OilObject__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getTypeAssignment_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4688:1: ( rule__OilObject__TypeAssignment_0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4688:2: rule__OilObject__TypeAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__TypeAssignment_0_in_rule__OilObject__Group__0__Impl9769);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4698:1: rule__OilObject__Group__1 : rule__OilObject__Group__1__Impl rule__OilObject__Group__2 ;
    public final void rule__OilObject__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4702:1: ( rule__OilObject__Group__1__Impl rule__OilObject__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4703:2: rule__OilObject__Group__1__Impl rule__OilObject__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__1__Impl_in_rule__OilObject__Group__19799);
            rule__OilObject__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__2_in_rule__OilObject__Group__19802);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4710:1: rule__OilObject__Group__1__Impl : ( ( rule__OilObject__NameAssignment_1 ) ) ;
    public final void rule__OilObject__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4714:1: ( ( ( rule__OilObject__NameAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4715:1: ( ( rule__OilObject__NameAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4715:1: ( ( rule__OilObject__NameAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4716:1: ( rule__OilObject__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getNameAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4717:1: ( rule__OilObject__NameAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4717:2: rule__OilObject__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__NameAssignment_1_in_rule__OilObject__Group__1__Impl9829);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4727:1: rule__OilObject__Group__2 : rule__OilObject__Group__2__Impl rule__OilObject__Group__3 ;
    public final void rule__OilObject__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4731:1: ( rule__OilObject__Group__2__Impl rule__OilObject__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4732:2: rule__OilObject__Group__2__Impl rule__OilObject__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__2__Impl_in_rule__OilObject__Group__29859);
            rule__OilObject__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__3_in_rule__OilObject__Group__29862);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4739:1: rule__OilObject__Group__2__Impl : ( ( rule__OilObject__Group_2__0 )? ) ;
    public final void rule__OilObject__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4743:1: ( ( ( rule__OilObject__Group_2__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4744:1: ( ( rule__OilObject__Group_2__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4744:1: ( ( rule__OilObject__Group_2__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4745:1: ( rule__OilObject__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getGroup_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4746:1: ( rule__OilObject__Group_2__0 )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==55) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4746:2: rule__OilObject__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group_2__0_in_rule__OilObject__Group__2__Impl9889);
                    rule__OilObject__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectAccess().getGroup_2()); 
            }

            }


            }

        }
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4756:1: rule__OilObject__Group__3 : rule__OilObject__Group__3__Impl rule__OilObject__Group__4 ;
    public final void rule__OilObject__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4760:1: ( rule__OilObject__Group__3__Impl rule__OilObject__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4761:2: rule__OilObject__Group__3__Impl rule__OilObject__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__3__Impl_in_rule__OilObject__Group__39920);
            rule__OilObject__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__4_in_rule__OilObject__Group__39923);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4768:1: rule__OilObject__Group__3__Impl : ( ( rule__OilObject__Group_3__0 )? ) ;
    public final void rule__OilObject__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4772:1: ( ( ( rule__OilObject__Group_3__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4773:1: ( ( rule__OilObject__Group_3__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4773:1: ( ( rule__OilObject__Group_3__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4774:1: ( rule__OilObject__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getGroup_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4775:1: ( rule__OilObject__Group_3__0 )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==57) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4775:2: rule__OilObject__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group_3__0_in_rule__OilObject__Group__3__Impl9950);
                    rule__OilObject__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectAccess().getGroup_3()); 
            }

            }


            }

        }
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4785:1: rule__OilObject__Group__4 : rule__OilObject__Group__4__Impl ;
    public final void rule__OilObject__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4789:1: ( rule__OilObject__Group__4__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4790:2: rule__OilObject__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__4__Impl_in_rule__OilObject__Group__49981);
            rule__OilObject__Group__4__Impl();

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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4796:1: rule__OilObject__Group__4__Impl : ( ';' ) ;
    public final void rule__OilObject__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4800:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4801:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4801:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4802:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getSemicolonKeyword_4()); 
            }
            match(input,53,FollowSets000.FOLLOW_53_in_rule__OilObject__Group__4__Impl10009); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectAccess().getSemicolonKeyword_4()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__OilObject__Group_2__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4825:1: rule__OilObject__Group_2__0 : rule__OilObject__Group_2__0__Impl rule__OilObject__Group_2__1 ;
    public final void rule__OilObject__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4829:1: ( rule__OilObject__Group_2__0__Impl rule__OilObject__Group_2__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4830:2: rule__OilObject__Group_2__0__Impl rule__OilObject__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group_2__0__Impl_in_rule__OilObject__Group_2__010050);
            rule__OilObject__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group_2__1_in_rule__OilObject__Group_2__010053);
            rule__OilObject__Group_2__1();

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
    // $ANTLR end "rule__OilObject__Group_2__0"


    // $ANTLR start "rule__OilObject__Group_2__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4837:1: rule__OilObject__Group_2__0__Impl : ( '{' ) ;
    public final void rule__OilObject__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4841:1: ( ( '{' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4842:1: ( '{' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4842:1: ( '{' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4843:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getLeftCurlyBracketKeyword_2_0()); 
            }
            match(input,55,FollowSets000.FOLLOW_55_in_rule__OilObject__Group_2__0__Impl10081); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectAccess().getLeftCurlyBracketKeyword_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObject__Group_2__0__Impl"


    // $ANTLR start "rule__OilObject__Group_2__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4856:1: rule__OilObject__Group_2__1 : rule__OilObject__Group_2__1__Impl rule__OilObject__Group_2__2 ;
    public final void rule__OilObject__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4860:1: ( rule__OilObject__Group_2__1__Impl rule__OilObject__Group_2__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4861:2: rule__OilObject__Group_2__1__Impl rule__OilObject__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group_2__1__Impl_in_rule__OilObject__Group_2__110112);
            rule__OilObject__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group_2__2_in_rule__OilObject__Group_2__110115);
            rule__OilObject__Group_2__2();

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
    // $ANTLR end "rule__OilObject__Group_2__1"


    // $ANTLR start "rule__OilObject__Group_2__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4868:1: rule__OilObject__Group_2__1__Impl : ( ( rule__OilObject__ParametersAssignment_2_1 )* ) ;
    public final void rule__OilObject__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4872:1: ( ( ( rule__OilObject__ParametersAssignment_2_1 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4873:1: ( ( rule__OilObject__ParametersAssignment_2_1 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4873:1: ( ( rule__OilObject__ParametersAssignment_2_1 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4874:1: ( rule__OilObject__ParametersAssignment_2_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getParametersAssignment_2_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4875:1: ( rule__OilObject__ParametersAssignment_2_1 )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==RULE_ID||(LA51_0>=13 && LA51_0<=46)) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4875:2: rule__OilObject__ParametersAssignment_2_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__OilObject__ParametersAssignment_2_1_in_rule__OilObject__Group_2__1__Impl10142);
            	    rule__OilObject__ParametersAssignment_2_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectAccess().getParametersAssignment_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObject__Group_2__1__Impl"


    // $ANTLR start "rule__OilObject__Group_2__2"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4885:1: rule__OilObject__Group_2__2 : rule__OilObject__Group_2__2__Impl ;
    public final void rule__OilObject__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4889:1: ( rule__OilObject__Group_2__2__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4890:2: rule__OilObject__Group_2__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group_2__2__Impl_in_rule__OilObject__Group_2__210173);
            rule__OilObject__Group_2__2__Impl();

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
    // $ANTLR end "rule__OilObject__Group_2__2"


    // $ANTLR start "rule__OilObject__Group_2__2__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4896:1: rule__OilObject__Group_2__2__Impl : ( '}' ) ;
    public final void rule__OilObject__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4900:1: ( ( '}' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4901:1: ( '}' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4901:1: ( '}' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4902:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getRightCurlyBracketKeyword_2_2()); 
            }
            match(input,56,FollowSets000.FOLLOW_56_in_rule__OilObject__Group_2__2__Impl10201); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectAccess().getRightCurlyBracketKeyword_2_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObject__Group_2__2__Impl"


    // $ANTLR start "rule__OilObject__Group_3__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4921:1: rule__OilObject__Group_3__0 : rule__OilObject__Group_3__0__Impl rule__OilObject__Group_3__1 ;
    public final void rule__OilObject__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4925:1: ( rule__OilObject__Group_3__0__Impl rule__OilObject__Group_3__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4926:2: rule__OilObject__Group_3__0__Impl rule__OilObject__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group_3__0__Impl_in_rule__OilObject__Group_3__010238);
            rule__OilObject__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group_3__1_in_rule__OilObject__Group_3__010241);
            rule__OilObject__Group_3__1();

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
    // $ANTLR end "rule__OilObject__Group_3__0"


    // $ANTLR start "rule__OilObject__Group_3__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4933:1: rule__OilObject__Group_3__0__Impl : ( ':' ) ;
    public final void rule__OilObject__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4937:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4938:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4938:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4939:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getColonKeyword_3_0()); 
            }
            match(input,57,FollowSets000.FOLLOW_57_in_rule__OilObject__Group_3__0__Impl10269); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectAccess().getColonKeyword_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObject__Group_3__0__Impl"


    // $ANTLR start "rule__OilObject__Group_3__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4952:1: rule__OilObject__Group_3__1 : rule__OilObject__Group_3__1__Impl ;
    public final void rule__OilObject__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4956:1: ( rule__OilObject__Group_3__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4957:2: rule__OilObject__Group_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group_3__1__Impl_in_rule__OilObject__Group_3__110300);
            rule__OilObject__Group_3__1__Impl();

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
    // $ANTLR end "rule__OilObject__Group_3__1"


    // $ANTLR start "rule__OilObject__Group_3__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4963:1: rule__OilObject__Group_3__1__Impl : ( ( rule__OilObject__DescriptionAssignment_3_1 ) ) ;
    public final void rule__OilObject__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4967:1: ( ( ( rule__OilObject__DescriptionAssignment_3_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4968:1: ( ( rule__OilObject__DescriptionAssignment_3_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4968:1: ( ( rule__OilObject__DescriptionAssignment_3_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4969:1: ( rule__OilObject__DescriptionAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getDescriptionAssignment_3_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4970:1: ( rule__OilObject__DescriptionAssignment_3_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4970:2: rule__OilObject__DescriptionAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__DescriptionAssignment_3_1_in_rule__OilObject__Group_3__1__Impl10327);
            rule__OilObject__DescriptionAssignment_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectAccess().getDescriptionAssignment_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObject__Group_3__1__Impl"


    // $ANTLR start "rule__Parameter__Group__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4984:1: rule__Parameter__Group__0 : rule__Parameter__Group__0__Impl rule__Parameter__Group__1 ;
    public final void rule__Parameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4988:1: ( rule__Parameter__Group__0__Impl rule__Parameter__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4989:2: rule__Parameter__Group__0__Impl rule__Parameter__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__0__Impl_in_rule__Parameter__Group__010361);
            rule__Parameter__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__1_in_rule__Parameter__Group__010364);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4996:1: rule__Parameter__Group__0__Impl : ( () ) ;
    public final void rule__Parameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5000:1: ( ( () ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5001:1: ( () )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5001:1: ( () )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5002:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getParameterAction_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5003:1: ()
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5005:1: 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5015:1: rule__Parameter__Group__1 : rule__Parameter__Group__1__Impl rule__Parameter__Group__2 ;
    public final void rule__Parameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5019:1: ( rule__Parameter__Group__1__Impl rule__Parameter__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5020:2: rule__Parameter__Group__1__Impl rule__Parameter__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__1__Impl_in_rule__Parameter__Group__110422);
            rule__Parameter__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__2_in_rule__Parameter__Group__110425);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5027:1: rule__Parameter__Group__1__Impl : ( ( rule__Parameter__TypeAssignment_1 ) ) ;
    public final void rule__Parameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5031:1: ( ( ( rule__Parameter__TypeAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5032:1: ( ( rule__Parameter__TypeAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5032:1: ( ( rule__Parameter__TypeAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5033:1: ( rule__Parameter__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getTypeAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5034:1: ( rule__Parameter__TypeAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5034:2: rule__Parameter__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__TypeAssignment_1_in_rule__Parameter__Group__1__Impl10452);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5044:1: rule__Parameter__Group__2 : rule__Parameter__Group__2__Impl rule__Parameter__Group__3 ;
    public final void rule__Parameter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5048:1: ( rule__Parameter__Group__2__Impl rule__Parameter__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5049:2: rule__Parameter__Group__2__Impl rule__Parameter__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__2__Impl_in_rule__Parameter__Group__210482);
            rule__Parameter__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__3_in_rule__Parameter__Group__210485);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5056:1: rule__Parameter__Group__2__Impl : ( '=' ) ;
    public final void rule__Parameter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5060:1: ( ( '=' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5061:1: ( '=' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5061:1: ( '=' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5062:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getEqualsSignKeyword_2()); 
            }
            match(input,52,FollowSets000.FOLLOW_52_in_rule__Parameter__Group__2__Impl10513); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5075:1: rule__Parameter__Group__3 : rule__Parameter__Group__3__Impl rule__Parameter__Group__4 ;
    public final void rule__Parameter__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5079:1: ( rule__Parameter__Group__3__Impl rule__Parameter__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5080:2: rule__Parameter__Group__3__Impl rule__Parameter__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__3__Impl_in_rule__Parameter__Group__310544);
            rule__Parameter__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__4_in_rule__Parameter__Group__310547);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5087:1: rule__Parameter__Group__3__Impl : ( ( rule__Parameter__Alternatives_3 ) ) ;
    public final void rule__Parameter__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5091:1: ( ( ( rule__Parameter__Alternatives_3 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5092:1: ( ( rule__Parameter__Alternatives_3 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5092:1: ( ( rule__Parameter__Alternatives_3 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5093:1: ( rule__Parameter__Alternatives_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getAlternatives_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5094:1: ( rule__Parameter__Alternatives_3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5094:2: rule__Parameter__Alternatives_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Alternatives_3_in_rule__Parameter__Group__3__Impl10574);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5104:1: rule__Parameter__Group__4 : rule__Parameter__Group__4__Impl rule__Parameter__Group__5 ;
    public final void rule__Parameter__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5108:1: ( rule__Parameter__Group__4__Impl rule__Parameter__Group__5 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5109:2: rule__Parameter__Group__4__Impl rule__Parameter__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__4__Impl_in_rule__Parameter__Group__410604);
            rule__Parameter__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__5_in_rule__Parameter__Group__410607);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5116:1: rule__Parameter__Group__4__Impl : ( ( rule__Parameter__Group_4__0 )? ) ;
    public final void rule__Parameter__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5120:1: ( ( ( rule__Parameter__Group_4__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5121:1: ( ( rule__Parameter__Group_4__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5121:1: ( ( rule__Parameter__Group_4__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5122:1: ( rule__Parameter__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getGroup_4()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5123:1: ( rule__Parameter__Group_4__0 )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==55) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5123:2: rule__Parameter__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_4__0_in_rule__Parameter__Group__4__Impl10634);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5133:1: rule__Parameter__Group__5 : rule__Parameter__Group__5__Impl rule__Parameter__Group__6 ;
    public final void rule__Parameter__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5137:1: ( rule__Parameter__Group__5__Impl rule__Parameter__Group__6 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5138:2: rule__Parameter__Group__5__Impl rule__Parameter__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__5__Impl_in_rule__Parameter__Group__510665);
            rule__Parameter__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__6_in_rule__Parameter__Group__510668);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5145:1: rule__Parameter__Group__5__Impl : ( ( rule__Parameter__Group_5__0 )? ) ;
    public final void rule__Parameter__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5149:1: ( ( ( rule__Parameter__Group_5__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5150:1: ( ( rule__Parameter__Group_5__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5150:1: ( ( rule__Parameter__Group_5__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5151:1: ( rule__Parameter__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getGroup_5()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5152:1: ( rule__Parameter__Group_5__0 )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==57) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5152:2: rule__Parameter__Group_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_5__0_in_rule__Parameter__Group__5__Impl10695);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5162:1: rule__Parameter__Group__6 : rule__Parameter__Group__6__Impl ;
    public final void rule__Parameter__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5166:1: ( rule__Parameter__Group__6__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5167:2: rule__Parameter__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__6__Impl_in_rule__Parameter__Group__610726);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5173:1: rule__Parameter__Group__6__Impl : ( ';' ) ;
    public final void rule__Parameter__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5177:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5178:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5178:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5179:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getSemicolonKeyword_6()); 
            }
            match(input,53,FollowSets000.FOLLOW_53_in_rule__Parameter__Group__6__Impl10754); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5206:1: rule__Parameter__Group_4__0 : rule__Parameter__Group_4__0__Impl rule__Parameter__Group_4__1 ;
    public final void rule__Parameter__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5210:1: ( rule__Parameter__Group_4__0__Impl rule__Parameter__Group_4__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5211:2: rule__Parameter__Group_4__0__Impl rule__Parameter__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_4__0__Impl_in_rule__Parameter__Group_4__010799);
            rule__Parameter__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_4__1_in_rule__Parameter__Group_4__010802);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5218:1: rule__Parameter__Group_4__0__Impl : ( '{' ) ;
    public final void rule__Parameter__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5222:1: ( ( '{' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5223:1: ( '{' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5223:1: ( '{' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5224:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getLeftCurlyBracketKeyword_4_0()); 
            }
            match(input,55,FollowSets000.FOLLOW_55_in_rule__Parameter__Group_4__0__Impl10830); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5237:1: rule__Parameter__Group_4__1 : rule__Parameter__Group_4__1__Impl rule__Parameter__Group_4__2 ;
    public final void rule__Parameter__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5241:1: ( rule__Parameter__Group_4__1__Impl rule__Parameter__Group_4__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5242:2: rule__Parameter__Group_4__1__Impl rule__Parameter__Group_4__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_4__1__Impl_in_rule__Parameter__Group_4__110861);
            rule__Parameter__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_4__2_in_rule__Parameter__Group_4__110864);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5249:1: rule__Parameter__Group_4__1__Impl : ( ( rule__Parameter__ParametersAssignment_4_1 )* ) ;
    public final void rule__Parameter__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5253:1: ( ( ( rule__Parameter__ParametersAssignment_4_1 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5254:1: ( ( rule__Parameter__ParametersAssignment_4_1 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5254:1: ( ( rule__Parameter__ParametersAssignment_4_1 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5255:1: ( rule__Parameter__ParametersAssignment_4_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getParametersAssignment_4_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5256:1: ( rule__Parameter__ParametersAssignment_4_1 )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==RULE_ID||(LA54_0>=13 && LA54_0<=46)) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5256:2: rule__Parameter__ParametersAssignment_4_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Parameter__ParametersAssignment_4_1_in_rule__Parameter__Group_4__1__Impl10891);
            	    rule__Parameter__ParametersAssignment_4_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop54;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5266:1: rule__Parameter__Group_4__2 : rule__Parameter__Group_4__2__Impl ;
    public final void rule__Parameter__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5270:1: ( rule__Parameter__Group_4__2__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5271:2: rule__Parameter__Group_4__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_4__2__Impl_in_rule__Parameter__Group_4__210922);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5277:1: rule__Parameter__Group_4__2__Impl : ( '}' ) ;
    public final void rule__Parameter__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5281:1: ( ( '}' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5282:1: ( '}' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5282:1: ( '}' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5283:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getRightCurlyBracketKeyword_4_2()); 
            }
            match(input,56,FollowSets000.FOLLOW_56_in_rule__Parameter__Group_4__2__Impl10950); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5302:1: rule__Parameter__Group_5__0 : rule__Parameter__Group_5__0__Impl rule__Parameter__Group_5__1 ;
    public final void rule__Parameter__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5306:1: ( rule__Parameter__Group_5__0__Impl rule__Parameter__Group_5__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5307:2: rule__Parameter__Group_5__0__Impl rule__Parameter__Group_5__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_5__0__Impl_in_rule__Parameter__Group_5__010987);
            rule__Parameter__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_5__1_in_rule__Parameter__Group_5__010990);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5314:1: rule__Parameter__Group_5__0__Impl : ( ':' ) ;
    public final void rule__Parameter__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5318:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5319:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5319:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5320:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getColonKeyword_5_0()); 
            }
            match(input,57,FollowSets000.FOLLOW_57_in_rule__Parameter__Group_5__0__Impl11018); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5333:1: rule__Parameter__Group_5__1 : rule__Parameter__Group_5__1__Impl ;
    public final void rule__Parameter__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5337:1: ( rule__Parameter__Group_5__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5338:2: rule__Parameter__Group_5__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_5__1__Impl_in_rule__Parameter__Group_5__111049);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5344:1: rule__Parameter__Group_5__1__Impl : ( ( rule__Parameter__DescriptionAssignment_5_1 ) ) ;
    public final void rule__Parameter__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5348:1: ( ( ( rule__Parameter__DescriptionAssignment_5_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5349:1: ( ( rule__Parameter__DescriptionAssignment_5_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5349:1: ( ( rule__Parameter__DescriptionAssignment_5_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5350:1: ( rule__Parameter__DescriptionAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getDescriptionAssignment_5_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5351:1: ( rule__Parameter__DescriptionAssignment_5_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5351:2: rule__Parameter__DescriptionAssignment_5_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__DescriptionAssignment_5_1_in_rule__Parameter__Group_5__1__Impl11076);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5365:1: rule__INT__Group__0 : rule__INT__Group__0__Impl rule__INT__Group__1 ;
    public final void rule__INT__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5369:1: ( rule__INT__Group__0__Impl rule__INT__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5370:2: rule__INT__Group__0__Impl rule__INT__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__INT__Group__0__Impl_in_rule__INT__Group__011110);
            rule__INT__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__INT__Group__1_in_rule__INT__Group__011113);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5377:1: rule__INT__Group__0__Impl : ( ( rule__INT__Alternatives_0 )? ) ;
    public final void rule__INT__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5381:1: ( ( ( rule__INT__Alternatives_0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5382:1: ( ( rule__INT__Alternatives_0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5382:1: ( ( rule__INT__Alternatives_0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5383:1: ( rule__INT__Alternatives_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getINTAccess().getAlternatives_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5384:1: ( rule__INT__Alternatives_0 )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( ((LA55_0>=47 && LA55_0<=48)) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5384:2: rule__INT__Alternatives_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__INT__Alternatives_0_in_rule__INT__Group__0__Impl11140);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5394:1: rule__INT__Group__1 : rule__INT__Group__1__Impl ;
    public final void rule__INT__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5398:1: ( rule__INT__Group__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5399:2: rule__INT__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__INT__Group__1__Impl_in_rule__INT__Group__111171);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5405:1: rule__INT__Group__1__Impl : ( ( rule__INT__Alternatives_1 ) ) ;
    public final void rule__INT__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5409:1: ( ( ( rule__INT__Alternatives_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5410:1: ( ( rule__INT__Alternatives_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5410:1: ( ( rule__INT__Alternatives_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5411:1: ( rule__INT__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getINTAccess().getAlternatives_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5412:1: ( rule__INT__Alternatives_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5412:2: rule__INT__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__INT__Alternatives_1_in_rule__INT__Group__1__Impl11198);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5426:1: rule__INT__Group_1_0__0 : rule__INT__Group_1_0__0__Impl rule__INT__Group_1_0__1 ;
    public final void rule__INT__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5430:1: ( rule__INT__Group_1_0__0__Impl rule__INT__Group_1_0__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5431:2: rule__INT__Group_1_0__0__Impl rule__INT__Group_1_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__INT__Group_1_0__0__Impl_in_rule__INT__Group_1_0__011232);
            rule__INT__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__INT__Group_1_0__1_in_rule__INT__Group_1_0__011235);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5438:1: rule__INT__Group_1_0__0__Impl : ( RULE_NON_ZERO_INT ) ;
    public final void rule__INT__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5442:1: ( ( RULE_NON_ZERO_INT ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5443:1: ( RULE_NON_ZERO_INT )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5443:1: ( RULE_NON_ZERO_INT )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5444:1: RULE_NON_ZERO_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getINTAccess().getNON_ZERO_INTTerminalRuleCall_1_0_0()); 
            }
            match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_rule__INT__Group_1_0__0__Impl11262); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5455:1: rule__INT__Group_1_0__1 : rule__INT__Group_1_0__1__Impl ;
    public final void rule__INT__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5459:1: ( rule__INT__Group_1_0__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5460:2: rule__INT__Group_1_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__INT__Group_1_0__1__Impl_in_rule__INT__Group_1_0__111291);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5466:1: rule__INT__Group_1_0__1__Impl : ( ( rule__INT__Alternatives_1_0_1 )* ) ;
    public final void rule__INT__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5470:1: ( ( ( rule__INT__Alternatives_1_0_1 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5471:1: ( ( rule__INT__Alternatives_1_0_1 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5471:1: ( ( rule__INT__Alternatives_1_0_1 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5472:1: ( rule__INT__Alternatives_1_0_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getINTAccess().getAlternatives_1_0_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5473:1: ( rule__INT__Alternatives_1_0_1 )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==RULE_ZERO_INT||LA56_0==RULE_NON_ZERO_INT) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5473:2: rule__INT__Alternatives_1_0_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__INT__Alternatives_1_0_1_in_rule__INT__Group_1_0__1__Impl11318);
            	    rule__INT__Alternatives_1_0_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop56;
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


    // $ANTLR start "rule__FLOAT__Group__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5487:1: rule__FLOAT__Group__0 : rule__FLOAT__Group__0__Impl rule__FLOAT__Group__1 ;
    public final void rule__FLOAT__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5491:1: ( rule__FLOAT__Group__0__Impl rule__FLOAT__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5492:2: rule__FLOAT__Group__0__Impl rule__FLOAT__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FLOAT__Group__0__Impl_in_rule__FLOAT__Group__011353);
            rule__FLOAT__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__FLOAT__Group__1_in_rule__FLOAT__Group__011356);
            rule__FLOAT__Group__1();

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
    // $ANTLR end "rule__FLOAT__Group__0"


    // $ANTLR start "rule__FLOAT__Group__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5499:1: rule__FLOAT__Group__0__Impl : ( ( rule__FLOAT__Alternatives_0 )? ) ;
    public final void rule__FLOAT__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5503:1: ( ( ( rule__FLOAT__Alternatives_0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5504:1: ( ( rule__FLOAT__Alternatives_0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5504:1: ( ( rule__FLOAT__Alternatives_0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5505:1: ( rule__FLOAT__Alternatives_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFLOATAccess().getAlternatives_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5506:1: ( rule__FLOAT__Alternatives_0 )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( ((LA57_0>=47 && LA57_0<=48)) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5506:2: rule__FLOAT__Alternatives_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__FLOAT__Alternatives_0_in_rule__FLOAT__Group__0__Impl11383);
                    rule__FLOAT__Alternatives_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFLOATAccess().getAlternatives_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FLOAT__Group__0__Impl"


    // $ANTLR start "rule__FLOAT__Group__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5516:1: rule__FLOAT__Group__1 : rule__FLOAT__Group__1__Impl rule__FLOAT__Group__2 ;
    public final void rule__FLOAT__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5520:1: ( rule__FLOAT__Group__1__Impl rule__FLOAT__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5521:2: rule__FLOAT__Group__1__Impl rule__FLOAT__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__FLOAT__Group__1__Impl_in_rule__FLOAT__Group__111414);
            rule__FLOAT__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__FLOAT__Group__2_in_rule__FLOAT__Group__111417);
            rule__FLOAT__Group__2();

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
    // $ANTLR end "rule__FLOAT__Group__1"


    // $ANTLR start "rule__FLOAT__Group__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5528:1: rule__FLOAT__Group__1__Impl : ( ( rule__FLOAT__Alternatives_1 ) ) ;
    public final void rule__FLOAT__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5532:1: ( ( ( rule__FLOAT__Alternatives_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5533:1: ( ( rule__FLOAT__Alternatives_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5533:1: ( ( rule__FLOAT__Alternatives_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5534:1: ( rule__FLOAT__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFLOATAccess().getAlternatives_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5535:1: ( rule__FLOAT__Alternatives_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5535:2: rule__FLOAT__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FLOAT__Alternatives_1_in_rule__FLOAT__Group__1__Impl11444);
            rule__FLOAT__Alternatives_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFLOATAccess().getAlternatives_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FLOAT__Group__1__Impl"


    // $ANTLR start "rule__FLOAT__Group__2"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5545:1: rule__FLOAT__Group__2 : rule__FLOAT__Group__2__Impl rule__FLOAT__Group__3 ;
    public final void rule__FLOAT__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5549:1: ( rule__FLOAT__Group__2__Impl rule__FLOAT__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5550:2: rule__FLOAT__Group__2__Impl rule__FLOAT__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__FLOAT__Group__2__Impl_in_rule__FLOAT__Group__211474);
            rule__FLOAT__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__FLOAT__Group__3_in_rule__FLOAT__Group__211477);
            rule__FLOAT__Group__3();

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
    // $ANTLR end "rule__FLOAT__Group__2"


    // $ANTLR start "rule__FLOAT__Group__2__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5557:1: rule__FLOAT__Group__2__Impl : ( ( '.' ) ) ;
    public final void rule__FLOAT__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5561:1: ( ( ( '.' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5562:1: ( ( '.' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5562:1: ( ( '.' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5563:1: ( '.' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFLOATAccess().getFullStopKeyword_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5564:1: ( '.' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5565:2: '.'
            {
            match(input,63,FollowSets000.FOLLOW_63_in_rule__FLOAT__Group__2__Impl11506); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFLOATAccess().getFullStopKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FLOAT__Group__2__Impl"


    // $ANTLR start "rule__FLOAT__Group__3"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5576:1: rule__FLOAT__Group__3 : rule__FLOAT__Group__3__Impl ;
    public final void rule__FLOAT__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5580:1: ( rule__FLOAT__Group__3__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5581:2: rule__FLOAT__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__FLOAT__Group__3__Impl_in_rule__FLOAT__Group__311538);
            rule__FLOAT__Group__3__Impl();

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
    // $ANTLR end "rule__FLOAT__Group__3"


    // $ANTLR start "rule__FLOAT__Group__3__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5587:1: rule__FLOAT__Group__3__Impl : ( ( ( rule__FLOAT__Alternatives_3 ) ) ( ( rule__FLOAT__Alternatives_3 )* ) ) ;
    public final void rule__FLOAT__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5591:1: ( ( ( ( rule__FLOAT__Alternatives_3 ) ) ( ( rule__FLOAT__Alternatives_3 )* ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5592:1: ( ( ( rule__FLOAT__Alternatives_3 ) ) ( ( rule__FLOAT__Alternatives_3 )* ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5592:1: ( ( ( rule__FLOAT__Alternatives_3 ) ) ( ( rule__FLOAT__Alternatives_3 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5593:1: ( ( rule__FLOAT__Alternatives_3 ) ) ( ( rule__FLOAT__Alternatives_3 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5593:1: ( ( rule__FLOAT__Alternatives_3 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5594:1: ( rule__FLOAT__Alternatives_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFLOATAccess().getAlternatives_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5595:1: ( rule__FLOAT__Alternatives_3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5595:2: rule__FLOAT__Alternatives_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__FLOAT__Alternatives_3_in_rule__FLOAT__Group__3__Impl11567);
            rule__FLOAT__Alternatives_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFLOATAccess().getAlternatives_3()); 
            }

            }

            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5598:1: ( ( rule__FLOAT__Alternatives_3 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5599:1: ( rule__FLOAT__Alternatives_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFLOATAccess().getAlternatives_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5600:1: ( rule__FLOAT__Alternatives_3 )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==RULE_ZERO_INT||LA58_0==RULE_NON_ZERO_INT) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5600:2: rule__FLOAT__Alternatives_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__FLOAT__Alternatives_3_in_rule__FLOAT__Group__3__Impl11579);
            	    rule__FLOAT__Alternatives_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFLOATAccess().getAlternatives_3()); 
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
    // $ANTLR end "rule__FLOAT__Group__3__Impl"


    // $ANTLR start "rule__FLOAT__Group_1_1__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5619:1: rule__FLOAT__Group_1_1__0 : rule__FLOAT__Group_1_1__0__Impl rule__FLOAT__Group_1_1__1 ;
    public final void rule__FLOAT__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5623:1: ( rule__FLOAT__Group_1_1__0__Impl rule__FLOAT__Group_1_1__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5624:2: rule__FLOAT__Group_1_1__0__Impl rule__FLOAT__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FLOAT__Group_1_1__0__Impl_in_rule__FLOAT__Group_1_1__011620);
            rule__FLOAT__Group_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__FLOAT__Group_1_1__1_in_rule__FLOAT__Group_1_1__011623);
            rule__FLOAT__Group_1_1__1();

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
    // $ANTLR end "rule__FLOAT__Group_1_1__0"


    // $ANTLR start "rule__FLOAT__Group_1_1__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5631:1: rule__FLOAT__Group_1_1__0__Impl : ( RULE_NON_ZERO_INT ) ;
    public final void rule__FLOAT__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5635:1: ( ( RULE_NON_ZERO_INT ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5636:1: ( RULE_NON_ZERO_INT )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5636:1: ( RULE_NON_ZERO_INT )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5637:1: RULE_NON_ZERO_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFLOATAccess().getNON_ZERO_INTTerminalRuleCall_1_1_0()); 
            }
            match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_rule__FLOAT__Group_1_1__0__Impl11650); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFLOATAccess().getNON_ZERO_INTTerminalRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FLOAT__Group_1_1__0__Impl"


    // $ANTLR start "rule__FLOAT__Group_1_1__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5648:1: rule__FLOAT__Group_1_1__1 : rule__FLOAT__Group_1_1__1__Impl ;
    public final void rule__FLOAT__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5652:1: ( rule__FLOAT__Group_1_1__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5653:2: rule__FLOAT__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__FLOAT__Group_1_1__1__Impl_in_rule__FLOAT__Group_1_1__111679);
            rule__FLOAT__Group_1_1__1__Impl();

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
    // $ANTLR end "rule__FLOAT__Group_1_1__1"


    // $ANTLR start "rule__FLOAT__Group_1_1__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5659:1: rule__FLOAT__Group_1_1__1__Impl : ( ( rule__FLOAT__Alternatives_1_1_1 )* ) ;
    public final void rule__FLOAT__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5663:1: ( ( ( rule__FLOAT__Alternatives_1_1_1 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5664:1: ( ( rule__FLOAT__Alternatives_1_1_1 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5664:1: ( ( rule__FLOAT__Alternatives_1_1_1 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5665:1: ( rule__FLOAT__Alternatives_1_1_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFLOATAccess().getAlternatives_1_1_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5666:1: ( rule__FLOAT__Alternatives_1_1_1 )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==RULE_ZERO_INT||LA59_0==RULE_NON_ZERO_INT) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5666:2: rule__FLOAT__Alternatives_1_1_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__FLOAT__Alternatives_1_1_1_in_rule__FLOAT__Group_1_1__1__Impl11706);
            	    rule__FLOAT__Alternatives_1_1_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop59;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFLOATAccess().getAlternatives_1_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FLOAT__Group_1_1__1__Impl"


    // $ANTLR start "rule__OilFile__OilVersionAssignment_1_2"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5681:1: rule__OilFile__OilVersionAssignment_1_2 : ( RULE_STRING ) ;
    public final void rule__OilFile__OilVersionAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5685:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5686:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5686:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5687:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getOilVersionSTRINGTerminalRuleCall_1_2_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__OilFile__OilVersionAssignment_1_211746); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5696:1: rule__OilFile__ImplementationAssignment_2 : ( ruleOilImplementation ) ;
    public final void rule__OilFile__ImplementationAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5700:1: ( ( ruleOilImplementation ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5701:1: ( ruleOilImplementation )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5701:1: ( ruleOilImplementation )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5702:1: ruleOilImplementation
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getImplementationOilImplementationParserRuleCall_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOilImplementation_in_rule__OilFile__ImplementationAssignment_211777);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5711:1: rule__OilFile__ApplicationAssignment_3 : ( ruleOilApplication ) ;
    public final void rule__OilFile__ApplicationAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5715:1: ( ( ruleOilApplication ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5716:1: ( ruleOilApplication )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5716:1: ( ruleOilApplication )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5717:1: ruleOilApplication
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getApplicationOilApplicationParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOilApplication_in_rule__OilFile__ApplicationAssignment_311808);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5726:1: rule__OilImplementation__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__OilImplementation__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5730:1: ( ( RULE_ID ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5731:1: ( RULE_ID )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5731:1: ( RULE_ID )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5732:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__OilImplementation__NameAssignment_111839); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5741:1: rule__OilImplementation__OilObjectsAssignment_3 : ( ruleOilObjectImpl ) ;
    public final void rule__OilImplementation__OilObjectsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5745:1: ( ( ruleOilObjectImpl ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5746:1: ( ruleOilObjectImpl )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5746:1: ( ruleOilObjectImpl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5747:1: ruleOilObjectImpl
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getOilObjectsOilObjectImplParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOilObjectImpl_in_rule__OilImplementation__OilObjectsAssignment_311870);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5756:1: rule__OilObjectImpl__TypeAssignment_0 : ( ruleObjectType ) ;
    public final void rule__OilObjectImpl__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5760:1: ( ( ruleObjectType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5761:1: ( ruleObjectType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5761:1: ( ruleObjectType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5762:1: ruleObjectType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getTypeObjectTypeEnumRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleObjectType_in_rule__OilObjectImpl__TypeAssignment_011901);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5771:1: rule__OilObjectImpl__ParametersAssignment_2 : ( ruleParameterType ) ;
    public final void rule__OilObjectImpl__ParametersAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5775:1: ( ( ruleParameterType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5776:1: ( ruleParameterType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5776:1: ( ruleParameterType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5777:1: ruleParameterType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getParametersParameterTypeParserRuleCall_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameterType_in_rule__OilObjectImpl__ParametersAssignment_211932);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5786:1: rule__OilObjectImpl__DescriptionAssignment_4_1 : ( RULE_STRING ) ;
    public final void rule__OilObjectImpl__DescriptionAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5790:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5791:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5791:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5792:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getDescriptionSTRINGTerminalRuleCall_4_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__OilObjectImpl__DescriptionAssignment_4_111963); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5801:1: rule__OilApplication__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__OilApplication__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5805:1: ( ( RULE_ID ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5806:1: ( RULE_ID )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5806:1: ( RULE_ID )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5807:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__OilApplication__NameAssignment_111994); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5816:1: rule__OilApplication__OilObjectsAssignment_3 : ( ruleOilObject ) ;
    public final void rule__OilApplication__OilObjectsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5820:1: ( ( ruleOilObject ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5821:1: ( ruleOilObject )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5821:1: ( ruleOilObject )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5822:1: ruleOilObject
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getOilObjectsOilObjectParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOilObject_in_rule__OilApplication__OilObjectsAssignment_312025);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5831:1: rule__OilApplication__DescriptionAssignment_5_1 : ( RULE_STRING ) ;
    public final void rule__OilApplication__DescriptionAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5835:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5836:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5836:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5837:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getDescriptionSTRINGTerminalRuleCall_5_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__OilApplication__DescriptionAssignment_5_112056); if (state.failed) return ;
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


    // $ANTLR start "rule__ValueList__ValuesAssignment_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5846:1: rule__ValueList__ValuesAssignment_1 : ( ruleGenericNumber ) ;
    public final void rule__ValueList__ValuesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5850:1: ( ( ruleGenericNumber ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5851:1: ( ruleGenericNumber )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5851:1: ( ruleGenericNumber )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5852:1: ruleGenericNumber
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueListAccess().getValuesGenericNumberParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleGenericNumber_in_rule__ValueList__ValuesAssignment_112087);
            ruleGenericNumber();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueListAccess().getValuesGenericNumberParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueList__ValuesAssignment_1"


    // $ANTLR start "rule__ValueList__ValuesAssignment_2_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5861:1: rule__ValueList__ValuesAssignment_2_1 : ( ruleGenericNumber ) ;
    public final void rule__ValueList__ValuesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5865:1: ( ( ruleGenericNumber ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5866:1: ( ruleGenericNumber )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5866:1: ( ruleGenericNumber )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5867:1: ruleGenericNumber
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueListAccess().getValuesGenericNumberParserRuleCall_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleGenericNumber_in_rule__ValueList__ValuesAssignment_2_112118);
            ruleGenericNumber();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueListAccess().getValuesGenericNumberParserRuleCall_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueList__ValuesAssignment_2_1"


    // $ANTLR start "rule__Range__MinAssignment_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5876:1: rule__Range__MinAssignment_1 : ( ruleGenericNumber ) ;
    public final void rule__Range__MinAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5880:1: ( ( ruleGenericNumber ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5881:1: ( ruleGenericNumber )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5881:1: ( ruleGenericNumber )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5882:1: ruleGenericNumber
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeAccess().getMinGenericNumberParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleGenericNumber_in_rule__Range__MinAssignment_112149);
            ruleGenericNumber();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRangeAccess().getMinGenericNumberParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Range__MinAssignment_1"


    // $ANTLR start "rule__Range__MaxAssignment_3"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5891:1: rule__Range__MaxAssignment_3 : ( ruleGenericNumber ) ;
    public final void rule__Range__MaxAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5895:1: ( ( ruleGenericNumber ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5896:1: ( ruleGenericNumber )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5896:1: ( ruleGenericNumber )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5897:1: ruleGenericNumber
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeAccess().getMaxGenericNumberParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleGenericNumber_in_rule__Range__MaxAssignment_312180);
            ruleGenericNumber();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRangeAccess().getMaxGenericNumberParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Range__MaxAssignment_3"


    // $ANTLR start "rule__ValueType__TypeAssignment_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5906:1: rule__ValueType__TypeAssignment_1 : ( ruleVType ) ;
    public final void rule__ValueType__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5910:1: ( ( ruleVType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5911:1: ( ruleVType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5911:1: ( ruleVType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5912:1: ruleVType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getTypeVTypeEnumRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVType_in_rule__ValueType__TypeAssignment_112211);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5921:1: rule__ValueType__WithAutoAssignment_2 : ( ( 'WITH_AUTO' ) ) ;
    public final void rule__ValueType__WithAutoAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5925:1: ( ( ( 'WITH_AUTO' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5926:1: ( ( 'WITH_AUTO' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5926:1: ( ( 'WITH_AUTO' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5927:1: ( 'WITH_AUTO' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getWithAutoWITH_AUTOKeyword_2_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5928:1: ( 'WITH_AUTO' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5929:1: 'WITH_AUTO'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getWithAutoWITH_AUTOKeyword_2_0()); 
            }
            match(input,64,FollowSets000.FOLLOW_64_in_rule__ValueType__WithAutoAssignment_212247); if (state.failed) return ;
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


    // $ANTLR start "rule__ValueType__ValidValuesAssignment_3_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5944:1: rule__ValueType__ValidValuesAssignment_3_1 : ( ruleValidValues ) ;
    public final void rule__ValueType__ValidValuesAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5948:1: ( ( ruleValidValues ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5949:1: ( ruleValidValues )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5949:1: ( ruleValidValues )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5950:1: ruleValidValues
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getValidValuesValidValuesParserRuleCall_3_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleValidValues_in_rule__ValueType__ValidValuesAssignment_3_112286);
            ruleValidValues();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getValidValuesValidValuesParserRuleCall_3_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__ValidValuesAssignment_3_1"


    // $ANTLR start "rule__ValueType__NameAssignment_4"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5959:1: rule__ValueType__NameAssignment_4 : ( ruleSpecialId ) ;
    public final void rule__ValueType__NameAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5963:1: ( ( ruleSpecialId ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5964:1: ( ruleSpecialId )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5964:1: ( ruleSpecialId )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5965:1: ruleSpecialId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getNameSpecialIdParserRuleCall_4_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_rule__ValueType__NameAssignment_412317);
            ruleSpecialId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getNameSpecialIdParserRuleCall_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__NameAssignment_4"


    // $ANTLR start "rule__ValueType__MultiValueAssignment_5"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5974:1: rule__ValueType__MultiValueAssignment_5 : ( ( '[]' ) ) ;
    public final void rule__ValueType__MultiValueAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5978:1: ( ( ( '[]' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5979:1: ( ( '[]' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5979:1: ( ( '[]' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5980:1: ( '[]' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_5_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5981:1: ( '[]' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5982:1: '[]'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_5_0()); 
            }
            match(input,65,FollowSets000.FOLLOW_65_in_rule__ValueType__MultiValueAssignment_512353); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_5_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__MultiValueAssignment_5"


    // $ANTLR start "rule__ValueType__DefaultAutoAssignment_6_1_0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5997:1: rule__ValueType__DefaultAutoAssignment_6_1_0 : ( ( 'AUTO' ) ) ;
    public final void rule__ValueType__DefaultAutoAssignment_6_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6001:1: ( ( ( 'AUTO' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6002:1: ( ( 'AUTO' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6002:1: ( ( 'AUTO' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6003:1: ( 'AUTO' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getDefaultAutoAUTOKeyword_6_1_0_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6004:1: ( 'AUTO' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6005:1: 'AUTO'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getDefaultAutoAUTOKeyword_6_1_0_0()); 
            }
            match(input,66,FollowSets000.FOLLOW_66_in_rule__ValueType__DefaultAutoAssignment_6_1_012397); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getDefaultAutoAUTOKeyword_6_1_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getDefaultAutoAUTOKeyword_6_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__DefaultAutoAssignment_6_1_0"


    // $ANTLR start "rule__ValueType__DefaultValueAssignment_6_1_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6020:1: rule__ValueType__DefaultValueAssignment_6_1_1 : ( ( rule__ValueType__DefaultValueAlternatives_6_1_1_0 ) ) ;
    public final void rule__ValueType__DefaultValueAssignment_6_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6024:1: ( ( ( rule__ValueType__DefaultValueAlternatives_6_1_1_0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6025:1: ( ( rule__ValueType__DefaultValueAlternatives_6_1_1_0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6025:1: ( ( rule__ValueType__DefaultValueAlternatives_6_1_1_0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6026:1: ( rule__ValueType__DefaultValueAlternatives_6_1_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getDefaultValueAlternatives_6_1_1_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6027:1: ( rule__ValueType__DefaultValueAlternatives_6_1_1_0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6027:2: rule__ValueType__DefaultValueAlternatives_6_1_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__DefaultValueAlternatives_6_1_1_0_in_rule__ValueType__DefaultValueAssignment_6_1_112436);
            rule__ValueType__DefaultValueAlternatives_6_1_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getDefaultValueAlternatives_6_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__DefaultValueAssignment_6_1_1"


    // $ANTLR start "rule__ValueType__DescriptionAssignment_7_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6036:1: rule__ValueType__DescriptionAssignment_7_1 : ( RULE_STRING ) ;
    public final void rule__ValueType__DescriptionAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6040:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6041:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6041:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6042:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getDescriptionSTRINGTerminalRuleCall_7_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__ValueType__DescriptionAssignment_7_112469); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getDescriptionSTRINGTerminalRuleCall_7_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__DescriptionAssignment_7_1"


    // $ANTLR start "rule__VariantType__TypeAssignment_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6051:1: rule__VariantType__TypeAssignment_1 : ( ruleEType ) ;
    public final void rule__VariantType__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6055:1: ( ( ruleEType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6056:1: ( ruleEType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6056:1: ( ruleEType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6057:1: ruleEType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getTypeETypeEnumRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEType_in_rule__VariantType__TypeAssignment_112500);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6066:1: rule__VariantType__WithAutoAssignment_2 : ( ( 'WITH_AUTO' ) ) ;
    public final void rule__VariantType__WithAutoAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6070:1: ( ( ( 'WITH_AUTO' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6071:1: ( ( 'WITH_AUTO' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6071:1: ( ( 'WITH_AUTO' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6072:1: ( 'WITH_AUTO' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getWithAutoWITH_AUTOKeyword_2_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6073:1: ( 'WITH_AUTO' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6074:1: 'WITH_AUTO'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getWithAutoWITH_AUTOKeyword_2_0()); 
            }
            match(input,64,FollowSets000.FOLLOW_64_in_rule__VariantType__WithAutoAssignment_212536); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6089:1: rule__VariantType__ValuesAssignment_3_1_0 : ( ruleEnumeratorType ) ;
    public final void rule__VariantType__ValuesAssignment_3_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6093:1: ( ( ruleEnumeratorType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6094:1: ( ruleEnumeratorType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6094:1: ( ruleEnumeratorType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6095:1: ruleEnumeratorType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getValuesEnumeratorTypeParserRuleCall_3_1_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEnumeratorType_in_rule__VariantType__ValuesAssignment_3_1_012575);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6104:1: rule__VariantType__ValuesAssignment_3_1_1_1 : ( ruleEnumeratorType ) ;
    public final void rule__VariantType__ValuesAssignment_3_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6108:1: ( ( ruleEnumeratorType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6109:1: ( ruleEnumeratorType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6109:1: ( ruleEnumeratorType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6110:1: ruleEnumeratorType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getValuesEnumeratorTypeParserRuleCall_3_1_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEnumeratorType_in_rule__VariantType__ValuesAssignment_3_1_1_112606);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6119:1: rule__VariantType__NameAssignment_4 : ( ruleSpecialId ) ;
    public final void rule__VariantType__NameAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6123:1: ( ( ruleSpecialId ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6124:1: ( ruleSpecialId )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6124:1: ( ruleSpecialId )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6125:1: ruleSpecialId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getNameSpecialIdParserRuleCall_4_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_rule__VariantType__NameAssignment_412637);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6134:1: rule__VariantType__MultiValueAssignment_5 : ( ( '[]' ) ) ;
    public final void rule__VariantType__MultiValueAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6138:1: ( ( ( '[]' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6139:1: ( ( '[]' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6139:1: ( ( '[]' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6140:1: ( '[]' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_5_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6141:1: ( '[]' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6142:1: '[]'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_5_0()); 
            }
            match(input,65,FollowSets000.FOLLOW_65_in_rule__VariantType__MultiValueAssignment_512673); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6157:1: rule__VariantType__DefaultAutoAssignment_6_1_0 : ( ( 'AUTO' ) ) ;
    public final void rule__VariantType__DefaultAutoAssignment_6_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6161:1: ( ( ( 'AUTO' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6162:1: ( ( 'AUTO' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6162:1: ( ( 'AUTO' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6163:1: ( 'AUTO' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getDefaultAutoAUTOKeyword_6_1_0_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6164:1: ( 'AUTO' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6165:1: 'AUTO'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getDefaultAutoAUTOKeyword_6_1_0_0()); 
            }
            match(input,66,FollowSets000.FOLLOW_66_in_rule__VariantType__DefaultAutoAssignment_6_1_012717); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6180:1: rule__VariantType__DefaultValueAssignment_6_1_1 : ( RULE_ID ) ;
    public final void rule__VariantType__DefaultValueAssignment_6_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6184:1: ( ( RULE_ID ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6185:1: ( RULE_ID )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6185:1: ( RULE_ID )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6186:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getDefaultValueIDTerminalRuleCall_6_1_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__VariantType__DefaultValueAssignment_6_1_112756); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6195:1: rule__VariantType__DescriptionAssignment_7_1 : ( RULE_STRING ) ;
    public final void rule__VariantType__DescriptionAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6199:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6200:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6200:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6201:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getDescriptionSTRINGTerminalRuleCall_7_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__VariantType__DescriptionAssignment_7_112787); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6210:1: rule__EnumeratorType__NameAssignment_1 : ( ruleSpecialId ) ;
    public final void rule__EnumeratorType__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6214:1: ( ( ruleSpecialId ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6215:1: ( ruleSpecialId )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6215:1: ( ruleSpecialId )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6216:1: ruleSpecialId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getNameSpecialIdParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_rule__EnumeratorType__NameAssignment_112818);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6225:1: rule__EnumeratorType__ParametersAssignment_2_1 : ( ruleParameterType ) ;
    public final void rule__EnumeratorType__ParametersAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6229:1: ( ( ruleParameterType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6230:1: ( ruleParameterType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6230:1: ( ruleParameterType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6231:1: ruleParameterType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getParametersParameterTypeParserRuleCall_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameterType_in_rule__EnumeratorType__ParametersAssignment_2_112849);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6240:1: rule__EnumeratorType__DescriptionAssignment_3_1 : ( RULE_STRING ) ;
    public final void rule__EnumeratorType__DescriptionAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6244:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6245:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6245:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6246:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getDescriptionSTRINGTerminalRuleCall_3_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__EnumeratorType__DescriptionAssignment_3_112880); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6255:1: rule__ReferenceType__TypeAssignment_1 : ( ruleObjectTypeRef ) ;
    public final void rule__ReferenceType__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6259:1: ( ( ruleObjectTypeRef ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6260:1: ( ruleObjectTypeRef )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6260:1: ( ruleObjectTypeRef )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6261:1: ruleObjectTypeRef
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getTypeObjectTypeRefEnumRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleObjectTypeRef_in_rule__ReferenceType__TypeAssignment_112911);
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


    // $ANTLR start "rule__ReferenceType__NameAssignment_2"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6270:1: rule__ReferenceType__NameAssignment_2 : ( ruleSpecialId ) ;
    public final void rule__ReferenceType__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6274:1: ( ( ruleSpecialId ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6275:1: ( ruleSpecialId )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6275:1: ( ruleSpecialId )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6276:1: ruleSpecialId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getNameSpecialIdParserRuleCall_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_rule__ReferenceType__NameAssignment_212942);
            ruleSpecialId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getNameSpecialIdParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__NameAssignment_2"


    // $ANTLR start "rule__ReferenceType__MultiValueAssignment_3"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6285:1: rule__ReferenceType__MultiValueAssignment_3 : ( ( '[]' ) ) ;
    public final void rule__ReferenceType__MultiValueAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6289:1: ( ( ( '[]' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6290:1: ( ( '[]' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6290:1: ( ( '[]' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6291:1: ( '[]' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_3_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6292:1: ( '[]' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6293:1: '[]'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_3_0()); 
            }
            match(input,65,FollowSets000.FOLLOW_65_in_rule__ReferenceType__MultiValueAssignment_312978); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_3_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__MultiValueAssignment_3"


    // $ANTLR start "rule__ReferenceType__DefaultAutoAssignment_4_1_0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6308:1: rule__ReferenceType__DefaultAutoAssignment_4_1_0 : ( ( 'AUTO' ) ) ;
    public final void rule__ReferenceType__DefaultAutoAssignment_4_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6312:1: ( ( ( 'AUTO' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6313:1: ( ( 'AUTO' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6313:1: ( ( 'AUTO' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6314:1: ( 'AUTO' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getDefaultAutoAUTOKeyword_4_1_0_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6315:1: ( 'AUTO' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6316:1: 'AUTO'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getDefaultAutoAUTOKeyword_4_1_0_0()); 
            }
            match(input,66,FollowSets000.FOLLOW_66_in_rule__ReferenceType__DefaultAutoAssignment_4_1_013022); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getDefaultAutoAUTOKeyword_4_1_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getDefaultAutoAUTOKeyword_4_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__DefaultAutoAssignment_4_1_0"


    // $ANTLR start "rule__ReferenceType__DefaultValueAssignment_4_1_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6331:1: rule__ReferenceType__DefaultValueAssignment_4_1_1 : ( RULE_ID ) ;
    public final void rule__ReferenceType__DefaultValueAssignment_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6335:1: ( ( RULE_ID ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6336:1: ( RULE_ID )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6336:1: ( RULE_ID )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6337:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getDefaultValueIDTerminalRuleCall_4_1_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ReferenceType__DefaultValueAssignment_4_1_113061); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getDefaultValueIDTerminalRuleCall_4_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__DefaultValueAssignment_4_1_1"


    // $ANTLR start "rule__ReferenceType__DescriptionAssignment_5_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6346:1: rule__ReferenceType__DescriptionAssignment_5_1 : ( RULE_STRING ) ;
    public final void rule__ReferenceType__DescriptionAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6350:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6351:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6351:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6352:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getDescriptionSTRINGTerminalRuleCall_5_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__ReferenceType__DescriptionAssignment_5_113092); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceTypeAccess().getDescriptionSTRINGTerminalRuleCall_5_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceType__DescriptionAssignment_5_1"


    // $ANTLR start "rule__OilObject__TypeAssignment_0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6361:1: rule__OilObject__TypeAssignment_0 : ( ruleObjectType ) ;
    public final void rule__OilObject__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6365:1: ( ( ruleObjectType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6366:1: ( ruleObjectType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6366:1: ( ruleObjectType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6367:1: ruleObjectType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getTypeObjectTypeEnumRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleObjectType_in_rule__OilObject__TypeAssignment_013123);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6376:1: rule__OilObject__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__OilObject__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6380:1: ( ( RULE_ID ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6381:1: ( RULE_ID )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6381:1: ( RULE_ID )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6382:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__OilObject__NameAssignment_113154); if (state.failed) return ;
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


    // $ANTLR start "rule__OilObject__ParametersAssignment_2_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6391:1: rule__OilObject__ParametersAssignment_2_1 : ( ruleParameter ) ;
    public final void rule__OilObject__ParametersAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6395:1: ( ( ruleParameter ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6396:1: ( ruleParameter )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6396:1: ( ruleParameter )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6397:1: ruleParameter
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getParametersParameterParserRuleCall_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_rule__OilObject__ParametersAssignment_2_113185);
            ruleParameter();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectAccess().getParametersParameterParserRuleCall_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObject__ParametersAssignment_2_1"


    // $ANTLR start "rule__OilObject__DescriptionAssignment_3_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6406:1: rule__OilObject__DescriptionAssignment_3_1 : ( RULE_STRING ) ;
    public final void rule__OilObject__DescriptionAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6410:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6411:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6411:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6412:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getDescriptionSTRINGTerminalRuleCall_3_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__OilObject__DescriptionAssignment_3_113216); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOilObjectAccess().getDescriptionSTRINGTerminalRuleCall_3_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OilObject__DescriptionAssignment_3_1"


    // $ANTLR start "rule__Parameter__TypeAssignment_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6421:1: rule__Parameter__TypeAssignment_1 : ( ( ruleSpecialId ) ) ;
    public final void rule__Parameter__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6425:1: ( ( ( ruleSpecialId ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6426:1: ( ( ruleSpecialId ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6426:1: ( ( ruleSpecialId ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6427:1: ( ruleSpecialId )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getTypeParameterTypeCrossReference_1_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6428:1: ( ruleSpecialId )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6429:1: ruleSpecialId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getTypeParameterTypeSpecialIdParserRuleCall_1_0_1()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_rule__Parameter__TypeAssignment_113251);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6440:1: rule__Parameter__AutoAssignment_3_0 : ( ( 'AUTO' ) ) ;
    public final void rule__Parameter__AutoAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6444:1: ( ( ( 'AUTO' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6445:1: ( ( 'AUTO' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6445:1: ( ( 'AUTO' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6446:1: ( 'AUTO' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getAutoAUTOKeyword_3_0_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6447:1: ( 'AUTO' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6448:1: 'AUTO'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getAutoAUTOKeyword_3_0_0()); 
            }
            match(input,66,FollowSets000.FOLLOW_66_in_rule__Parameter__AutoAssignment_3_013291); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6463:1: rule__Parameter__ValueAssignment_3_1 : ( ruleGenericValue ) ;
    public final void rule__Parameter__ValueAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6467:1: ( ( ruleGenericValue ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6468:1: ( ruleGenericValue )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6468:1: ( ruleGenericValue )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6469:1: ruleGenericValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getValueGenericValueParserRuleCall_3_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleGenericValue_in_rule__Parameter__ValueAssignment_3_113330);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6478:1: rule__Parameter__ValueRefAssignment_3_2 : ( ( ruleSpecialId ) ) ;
    public final void rule__Parameter__ValueRefAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6482:1: ( ( ( ruleSpecialId ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6483:1: ( ( ruleSpecialId ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6483:1: ( ( ruleSpecialId ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6484:1: ( ruleSpecialId )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getValueRefParameterRefCrossReference_3_2_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6485:1: ( ruleSpecialId )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6486:1: ruleSpecialId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getValueRefParameterRefSpecialIdParserRuleCall_3_2_0_1()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_rule__Parameter__ValueRefAssignment_3_213365);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6497:1: rule__Parameter__ParametersAssignment_4_1 : ( ruleParameter ) ;
    public final void rule__Parameter__ParametersAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6501:1: ( ( ruleParameter ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6502:1: ( ruleParameter )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6502:1: ( ruleParameter )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6503:1: ruleParameter
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getParametersParameterParserRuleCall_4_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_rule__Parameter__ParametersAssignment_4_113400);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6512:1: rule__Parameter__DescriptionAssignment_5_1 : ( RULE_STRING ) ;
    public final void rule__Parameter__DescriptionAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6516:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6517:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6517:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6518:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getDescriptionSTRINGTerminalRuleCall_5_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Parameter__DescriptionAssignment_5_113431); if (state.failed) return ;
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


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA9 dfa9 = new DFA9(this);
    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA2_eotS =
        "\17\uffff";
    static final String DFA2_eofS =
        "\3\uffff\5\11\3\uffff\4\11";
    static final String DFA2_minS =
        "\4\6\2\73\2\6\2\uffff\5\6";
    static final String DFA2_maxS =
        "\1\60\2\10\2\77\1\76\2\77\2\uffff\1\10\4\76";
    static final String DFA2_acceptS =
        "\10\uffff\1\1\1\2\5\uffff";
    static final String DFA2_specialS =
        "\17\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\4\1\5\1\3\46\uffff\1\1\1\2",
            "\1\4\1\5\1\3",
            "\1\4\1\5\1\3",
            "\1\6\1\uffff\1\7\62\uffff\1\11\1\10\1\uffff\1\11\1\12",
            "\1\11\1\10\1\uffff\1\11\1\12",
            "\1\11\1\10\1\uffff\1\11",
            "\1\6\1\uffff\1\7\62\uffff\1\11\1\10\1\uffff\1\11\1\12",
            "\1\6\1\uffff\1\7\62\uffff\1\11\1\10\1\uffff\1\11\1\12",
            "",
            "",
            "\1\13\1\uffff\1\14",
            "\1\15\1\uffff\1\16\62\uffff\1\11\1\10\1\uffff\1\11",
            "\1\15\1\uffff\1\16\62\uffff\1\11\1\10\1\uffff\1\11",
            "\1\15\1\uffff\1\16\62\uffff\1\11\1\10\1\uffff\1\11",
            "\1\15\1\uffff\1\16\62\uffff\1\11\1\10\1\uffff\1\11"
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "697:1: rule__ValidValues__Alternatives : ( ( ruleRange ) | ( ruleValueList ) );";
        }
    }
    static final String DFA9_eotS =
        "\12\uffff";
    static final String DFA9_eofS =
        "\4\uffff\2\6\1\uffff\2\6\1\uffff";
    static final String DFA9_minS =
        "\1\5\1\uffff\3\6\1\65\1\uffff\2\6\1\uffff";
    static final String DFA9_maxS =
        "\1\60\1\uffff\2\10\2\77\1\uffff\2\77\1\uffff";
    static final String DFA9_acceptS =
        "\1\uffff\1\1\4\uffff\1\2\2\uffff\1\3";
    static final String DFA9_specialS =
        "\12\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\1\1\5\1\6\1\4\46\uffff\1\2\1\3",
            "",
            "\1\5\1\6\1\4",
            "\1\5\1\6\1\4",
            "\1\7\1\uffff\1\10\54\uffff\1\6\1\uffff\1\6\1\uffff\1\6\5\uffff"+
            "\1\11",
            "\1\6\1\uffff\1\6\1\uffff\1\6\5\uffff\1\11",
            "",
            "\1\7\1\uffff\1\10\54\uffff\1\6\1\uffff\1\6\1\uffff\1\6\5\uffff"+
            "\1\11",
            "\1\7\1\uffff\1\10\54\uffff\1\6\1\uffff\1\6\1\uffff\1\6\5\uffff"+
            "\1\11",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "1123:1: rule__GenericValue__Alternatives : ( ( RULE_STRING ) | ( ruleINT ) | ( ruleFLOAT ) );";
        }
    }
    static final String DFA10_eotS =
        "\11\uffff";
    static final String DFA10_eofS =
        "\3\uffff\2\5\1\uffff\2\5\1\uffff";
    static final String DFA10_minS =
        "\4\6\1\73\1\uffff\2\6\1\uffff";
    static final String DFA10_maxS =
        "\1\60\2\10\2\77\1\uffff\2\77\1\uffff";
    static final String DFA10_acceptS =
        "\5\uffff\1\1\2\uffff\1\2";
    static final String DFA10_specialS =
        "\11\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\4\1\5\1\3\46\uffff\1\1\1\2",
            "\1\4\1\5\1\3",
            "\1\4\1\5\1\3",
            "\1\6\1\uffff\1\7\62\uffff\2\5\1\uffff\1\5\1\10",
            "\2\5\1\uffff\1\5\1\10",
            "",
            "\1\6\1\uffff\1\7\62\uffff\2\5\1\uffff\1\5\1\10",
            "\1\6\1\uffff\1\7\62\uffff\2\5\1\uffff\1\5\1\10",
            ""
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
            return "1151:1: rule__GenericNumber__Alternatives : ( ( ruleINT ) | ( ruleFLOAT ) );";
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
        public static final BitSet FOLLOW_ruleValidValues_in_entryRuleValidValues367 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleValidValues374 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValidValues__Alternatives_in_ruleValidValues400 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueList_in_entryRuleValueList427 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleValueList434 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueList__Group__0_in_ruleValueList460 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRange_in_entryRuleRange487 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRange494 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Range__Group__0_in_ruleRange520 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueType_in_entryRuleValueType547 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleValueType554 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__0_in_ruleValueType580 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariantType_in_entryRuleVariantType607 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVariantType614 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__0_in_ruleVariantType640 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumeratorType_in_entryRuleEnumeratorType667 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumeratorType674 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group__0_in_ruleEnumeratorType700 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceType_in_entryRuleReferenceType727 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceType734 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__0_in_ruleReferenceType760 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilObject_in_entryRuleOilObject787 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOilObject794 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group__0_in_ruleOilObject820 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter847 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParameter854 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__0_in_ruleParameter880 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecialId_in_entryRuleSpecialId907 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpecialId914 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SpecialId__Alternatives_in_ruleSpecialId940 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGenericValue_in_entryRuleGenericValue967 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGenericValue974 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GenericValue__Alternatives_in_ruleGenericValue1000 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGenericNumber_in_entryRuleGenericNumber1027 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGenericNumber1034 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GenericNumber__Alternatives_in_ruleGenericNumber1060 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleINT_in_entryRuleINT1087 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleINT1094 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Group__0_in_ruleINT1120 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFLOAT_in_entryRuleFLOAT1147 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFLOAT1154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FLOAT__Group__0_in_ruleFLOAT1180 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VType__Alternatives_in_ruleVType1217 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EType__Alternatives_in_ruleEType1253 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ObjectType__Alternatives_in_ruleObjectType1289 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ObjectTypeRef__Alternatives_in_ruleObjectTypeRef1325 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueType_in_rule__ParameterType__Alternatives1360 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariantType_in_rule__ParameterType__Alternatives1377 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceType_in_rule__ParameterType__Alternatives1394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRange_in_rule__ValidValues__Alternatives1426 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueList_in_rule__ValidValues__Alternatives1443 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__DefaultAutoAssignment_6_1_0_in_rule__ValueType__Alternatives_6_11475 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__DefaultValueAssignment_6_1_1_in_rule__ValueType__Alternatives_6_11493 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGenericValue_in_rule__ValueType__DefaultValueAlternatives_6_1_1_01526 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ValueType__DefaultValueAlternatives_6_1_1_01543 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__DefaultAutoAssignment_6_1_0_in_rule__VariantType__Alternatives_6_11575 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__DefaultValueAssignment_6_1_1_in_rule__VariantType__Alternatives_6_11593 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__DefaultAutoAssignment_4_1_0_in_rule__ReferenceType__Alternatives_4_11626 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__DefaultValueAssignment_4_1_1_in_rule__ReferenceType__Alternatives_4_11644 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__AutoAssignment_3_0_in_rule__Parameter__Alternatives_31677 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__ValueAssignment_3_1_in_rule__Parameter__Alternatives_31695 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__ValueRefAssignment_3_2_in_rule__Parameter__Alternatives_31713 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__SpecialId__Alternatives1746 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__SpecialId__Alternatives1764 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__SpecialId__Alternatives1784 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__SpecialId__Alternatives1804 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__SpecialId__Alternatives1824 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__SpecialId__Alternatives1844 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__SpecialId__Alternatives1864 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__SpecialId__Alternatives1884 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__SpecialId__Alternatives1904 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__SpecialId__Alternatives1924 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__SpecialId__Alternatives1944 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__SpecialId__Alternatives1964 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__SpecialId__Alternatives1984 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__SpecialId__Alternatives2004 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__SpecialId__Alternatives2024 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__SpecialId__Alternatives2044 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__SpecialId__Alternatives2064 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__SpecialId__Alternatives2084 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__SpecialId__Alternatives2104 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__SpecialId__Alternatives2124 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__SpecialId__Alternatives2144 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__SpecialId__Alternatives2164 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__SpecialId__Alternatives2184 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__SpecialId__Alternatives2204 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_rule__SpecialId__Alternatives2224 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_rule__SpecialId__Alternatives2244 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_rule__SpecialId__Alternatives2264 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_rule__SpecialId__Alternatives2284 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_rule__SpecialId__Alternatives2304 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_rule__SpecialId__Alternatives2324 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_rule__SpecialId__Alternatives2344 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_rule__SpecialId__Alternatives2364 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_rule__SpecialId__Alternatives2384 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_rule__SpecialId__Alternatives2404 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_rule__SpecialId__Alternatives2424 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__GenericValue__Alternatives2458 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleINT_in_rule__GenericValue__Alternatives2475 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFLOAT_in_rule__GenericValue__Alternatives2492 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleINT_in_rule__GenericNumber__Alternatives2524 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFLOAT_in_rule__GenericNumber__Alternatives2541 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_rule__INT__Alternatives_02574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_rule__INT__Alternatives_02594 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Group_1_0__0_in_rule__INT__Alternatives_12628 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_rule__INT__Alternatives_12646 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_HEX_in_rule__INT__Alternatives_12663 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_rule__INT__Alternatives_1_0_12695 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_rule__INT__Alternatives_1_0_12712 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_rule__FLOAT__Alternatives_02745 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_rule__FLOAT__Alternatives_02765 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_rule__FLOAT__Alternatives_12799 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FLOAT__Group_1_1__0_in_rule__FLOAT__Alternatives_12816 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_rule__FLOAT__Alternatives_1_1_12849 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_rule__FLOAT__Alternatives_1_1_12866 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_rule__FLOAT__Alternatives_32898 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_rule__FLOAT__Alternatives_32915 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__VType__Alternatives2948 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__VType__Alternatives2969 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__VType__Alternatives2990 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__VType__Alternatives3011 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__VType__Alternatives3032 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__VType__Alternatives3053 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__EType__Alternatives3089 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__EType__Alternatives3110 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__ObjectType__Alternatives3146 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__ObjectType__Alternatives3167 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__ObjectType__Alternatives3188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__ObjectType__Alternatives3209 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__ObjectType__Alternatives3230 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__ObjectType__Alternatives3251 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__ObjectType__Alternatives3272 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__ObjectType__Alternatives3293 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__ObjectType__Alternatives3314 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__ObjectType__Alternatives3335 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__ObjectType__Alternatives3356 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__ObjectType__Alternatives3377 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__ObjectType__Alternatives3398 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_rule__ObjectType__Alternatives3419 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__ObjectTypeRef__Alternatives3455 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__ObjectTypeRef__Alternatives3476 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_rule__ObjectTypeRef__Alternatives3497 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_rule__ObjectTypeRef__Alternatives3518 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_rule__ObjectTypeRef__Alternatives3539 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_rule__ObjectTypeRef__Alternatives3560 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_rule__ObjectTypeRef__Alternatives3581 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_rule__ObjectTypeRef__Alternatives3602 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_rule__ObjectTypeRef__Alternatives3623 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_rule__ObjectTypeRef__Alternatives3644 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_rule__ObjectTypeRef__Alternatives3665 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_rule__ObjectTypeRef__Alternatives3686 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_rule__ObjectTypeRef__Alternatives3707 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_rule__ObjectTypeRef__Alternatives3728 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group__0__Impl_in_rule__OilFile__Group__03761 = new BitSet(new long[]{0x0448000000000000L});
        public static final BitSet FOLLOW_rule__OilFile__Group__1_in_rule__OilFile__Group__03764 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group__1__Impl_in_rule__OilFile__Group__13822 = new BitSet(new long[]{0x0448000000000000L});
        public static final BitSet FOLLOW_rule__OilFile__Group__2_in_rule__OilFile__Group__13825 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group_1__0_in_rule__OilFile__Group__1__Impl3852 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group__2__Impl_in_rule__OilFile__Group__23883 = new BitSet(new long[]{0x0448000000000000L});
        public static final BitSet FOLLOW_rule__OilFile__Group__3_in_rule__OilFile__Group__23886 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__ImplementationAssignment_2_in_rule__OilFile__Group__2__Impl3913 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group__3__Impl_in_rule__OilFile__Group__33944 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__ApplicationAssignment_3_in_rule__OilFile__Group__3__Impl3971 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group_1__0__Impl_in_rule__OilFile__Group_1__04010 = new BitSet(new long[]{0x0010000000000000L});
        public static final BitSet FOLLOW_rule__OilFile__Group_1__1_in_rule__OilFile__Group_1__04013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_rule__OilFile__Group_1__0__Impl4041 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group_1__1__Impl_in_rule__OilFile__Group_1__14072 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__OilFile__Group_1__2_in_rule__OilFile__Group_1__14075 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_rule__OilFile__Group_1__1__Impl4103 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group_1__2__Impl_in_rule__OilFile__Group_1__24134 = new BitSet(new long[]{0x0020000000000000L});
        public static final BitSet FOLLOW_rule__OilFile__Group_1__3_in_rule__OilFile__Group_1__24137 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__OilVersionAssignment_1_2_in_rule__OilFile__Group_1__2__Impl4164 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group_1__3__Impl_in_rule__OilFile__Group_1__34194 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_rule__OilFile__Group_1__3__Impl4222 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__0__Impl_in_rule__OilImplementation__Group__04261 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__1_in_rule__OilImplementation__Group__04264 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_rule__OilImplementation__Group__0__Impl4292 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__1__Impl_in_rule__OilImplementation__Group__14323 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__2_in_rule__OilImplementation__Group__14326 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilImplementation__NameAssignment_1_in_rule__OilImplementation__Group__1__Impl4353 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__2__Impl_in_rule__OilImplementation__Group__24383 = new BitSet(new long[]{0x01020003FFE00000L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__3_in_rule__OilImplementation__Group__24386 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_rule__OilImplementation__Group__2__Impl4414 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__3__Impl_in_rule__OilImplementation__Group__34445 = new BitSet(new long[]{0x01020003FFE00000L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__4_in_rule__OilImplementation__Group__34448 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilImplementation__OilObjectsAssignment_3_in_rule__OilImplementation__Group__3__Impl4475 = new BitSet(new long[]{0x00020003FFE00002L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__4__Impl_in_rule__OilImplementation__Group__44506 = new BitSet(new long[]{0x0020000000000000L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__5_in_rule__OilImplementation__Group__44509 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_rule__OilImplementation__Group__4__Impl4537 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__5__Impl_in_rule__OilImplementation__Group__54568 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_rule__OilImplementation__Group__5__Impl4596 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__0__Impl_in_rule__OilObjectImpl__Group__04639 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__1_in_rule__OilObjectImpl__Group__04642 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__TypeAssignment_0_in_rule__OilObjectImpl__Group__0__Impl4669 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__1__Impl_in_rule__OilObjectImpl__Group__14699 = new BitSet(new long[]{0x01047FFC001FE000L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__2_in_rule__OilObjectImpl__Group__14702 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_rule__OilObjectImpl__Group__1__Impl4730 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__2__Impl_in_rule__OilObjectImpl__Group__24761 = new BitSet(new long[]{0x01047FFC001FE000L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__3_in_rule__OilObjectImpl__Group__24764 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__ParametersAssignment_2_in_rule__OilObjectImpl__Group__2__Impl4791 = new BitSet(new long[]{0x00047FFC001FE002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__3__Impl_in_rule__OilObjectImpl__Group__34822 = new BitSet(new long[]{0x0220000000000000L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__4_in_rule__OilObjectImpl__Group__34825 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_rule__OilObjectImpl__Group__3__Impl4853 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__4__Impl_in_rule__OilObjectImpl__Group__44884 = new BitSet(new long[]{0x0220000000000000L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__5_in_rule__OilObjectImpl__Group__44887 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group_4__0_in_rule__OilObjectImpl__Group__4__Impl4914 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__5__Impl_in_rule__OilObjectImpl__Group__54945 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_rule__OilObjectImpl__Group__5__Impl4973 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group_4__0__Impl_in_rule__OilObjectImpl__Group_4__05016 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group_4__1_in_rule__OilObjectImpl__Group_4__05019 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_rule__OilObjectImpl__Group_4__0__Impl5047 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group_4__1__Impl_in_rule__OilObjectImpl__Group_4__15078 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__DescriptionAssignment_4_1_in_rule__OilObjectImpl__Group_4__1__Impl5105 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__0__Impl_in_rule__OilApplication__Group__05139 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__1_in_rule__OilApplication__Group__05142 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_rule__OilApplication__Group__0__Impl5170 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__1__Impl_in_rule__OilApplication__Group__15201 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__2_in_rule__OilApplication__Group__15204 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__NameAssignment_1_in_rule__OilApplication__Group__1__Impl5231 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__2__Impl_in_rule__OilApplication__Group__25261 = new BitSet(new long[]{0x01020003FFE00000L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__3_in_rule__OilApplication__Group__25264 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_rule__OilApplication__Group__2__Impl5292 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__3__Impl_in_rule__OilApplication__Group__35323 = new BitSet(new long[]{0x01020003FFE00000L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__4_in_rule__OilApplication__Group__35326 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__OilObjectsAssignment_3_in_rule__OilApplication__Group__3__Impl5353 = new BitSet(new long[]{0x00020003FFE00002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__4__Impl_in_rule__OilApplication__Group__45384 = new BitSet(new long[]{0x0220000000000000L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__5_in_rule__OilApplication__Group__45387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_rule__OilApplication__Group__4__Impl5415 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__5__Impl_in_rule__OilApplication__Group__55446 = new BitSet(new long[]{0x0220000000000000L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__6_in_rule__OilApplication__Group__55449 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group_5__0_in_rule__OilApplication__Group__5__Impl5476 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__6__Impl_in_rule__OilApplication__Group__65507 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_rule__OilApplication__Group__6__Impl5535 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group_5__0__Impl_in_rule__OilApplication__Group_5__05580 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__OilApplication__Group_5__1_in_rule__OilApplication__Group_5__05583 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_rule__OilApplication__Group_5__0__Impl5611 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group_5__1__Impl_in_rule__OilApplication__Group_5__15642 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__DescriptionAssignment_5_1_in_rule__OilApplication__Group_5__1__Impl5669 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueList__Group__0__Impl_in_rule__ValueList__Group__05703 = new BitSet(new long[]{0x00018000000001C0L});
        public static final BitSet FOLLOW_rule__ValueList__Group__1_in_rule__ValueList__Group__05706 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueList__Group__1__Impl_in_rule__ValueList__Group__15764 = new BitSet(new long[]{0x0800000000000000L});
        public static final BitSet FOLLOW_rule__ValueList__Group__2_in_rule__ValueList__Group__15767 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueList__ValuesAssignment_1_in_rule__ValueList__Group__1__Impl5794 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueList__Group__2__Impl_in_rule__ValueList__Group__25824 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueList__Group_2__0_in_rule__ValueList__Group__2__Impl5851 = new BitSet(new long[]{0x0800000000000002L});
        public static final BitSet FOLLOW_rule__ValueList__Group_2__0__Impl_in_rule__ValueList__Group_2__05888 = new BitSet(new long[]{0x00018000000001C0L});
        public static final BitSet FOLLOW_rule__ValueList__Group_2__1_in_rule__ValueList__Group_2__05891 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_59_in_rule__ValueList__Group_2__0__Impl5919 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueList__Group_2__1__Impl_in_rule__ValueList__Group_2__15950 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueList__ValuesAssignment_2_1_in_rule__ValueList__Group_2__1__Impl5977 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Range__Group__0__Impl_in_rule__Range__Group__06011 = new BitSet(new long[]{0x00018000000001C0L});
        public static final BitSet FOLLOW_rule__Range__Group__1_in_rule__Range__Group__06014 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Range__Group__1__Impl_in_rule__Range__Group__16072 = new BitSet(new long[]{0x1000000000000000L});
        public static final BitSet FOLLOW_rule__Range__Group__2_in_rule__Range__Group__16075 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Range__MinAssignment_1_in_rule__Range__Group__1__Impl6102 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Range__Group__2__Impl_in_rule__Range__Group__26132 = new BitSet(new long[]{0x00018000000001C0L});
        public static final BitSet FOLLOW_rule__Range__Group__3_in_rule__Range__Group__26135 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_rule__Range__Group__2__Impl6163 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Range__Group__3__Impl_in_rule__Range__Group__36194 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Range__MaxAssignment_3_in_rule__Range__Group__3__Impl6221 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__0__Impl_in_rule__ValueType__Group__06259 = new BitSet(new long[]{0x000000000007E000L});
        public static final BitSet FOLLOW_rule__ValueType__Group__1_in_rule__ValueType__Group__06262 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__1__Impl_in_rule__ValueType__Group__16320 = new BitSet(new long[]{0x20007FFFFFFFE010L,0x0000000000000001L});
        public static final BitSet FOLLOW_rule__ValueType__Group__2_in_rule__ValueType__Group__16323 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__TypeAssignment_1_in_rule__ValueType__Group__1__Impl6350 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__2__Impl_in_rule__ValueType__Group__26380 = new BitSet(new long[]{0x20007FFFFFFFE010L,0x0000000000000001L});
        public static final BitSet FOLLOW_rule__ValueType__Group__3_in_rule__ValueType__Group__26383 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__WithAutoAssignment_2_in_rule__ValueType__Group__2__Impl6410 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__3__Impl_in_rule__ValueType__Group__36441 = new BitSet(new long[]{0x20007FFFFFFFE010L,0x0000000000000001L});
        public static final BitSet FOLLOW_rule__ValueType__Group__4_in_rule__ValueType__Group__36444 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_3__0_in_rule__ValueType__Group__3__Impl6471 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__4__Impl_in_rule__ValueType__Group__46502 = new BitSet(new long[]{0x0230000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__5_in_rule__ValueType__Group__46505 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__NameAssignment_4_in_rule__ValueType__Group__4__Impl6532 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__5__Impl_in_rule__ValueType__Group__56562 = new BitSet(new long[]{0x0230000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__6_in_rule__ValueType__Group__56565 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__MultiValueAssignment_5_in_rule__ValueType__Group__5__Impl6592 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__6__Impl_in_rule__ValueType__Group__66623 = new BitSet(new long[]{0x0230000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__7_in_rule__ValueType__Group__66626 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_6__0_in_rule__ValueType__Group__6__Impl6653 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__7__Impl_in_rule__ValueType__Group__76684 = new BitSet(new long[]{0x0230000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__8_in_rule__ValueType__Group__76687 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_7__0_in_rule__ValueType__Group__7__Impl6714 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__8__Impl_in_rule__ValueType__Group__86745 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_rule__ValueType__Group__8__Impl6773 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_3__0__Impl_in_rule__ValueType__Group_3__06822 = new BitSet(new long[]{0x00018000000001C0L});
        public static final BitSet FOLLOW_rule__ValueType__Group_3__1_in_rule__ValueType__Group_3__06825 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_rule__ValueType__Group_3__0__Impl6853 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_3__1__Impl_in_rule__ValueType__Group_3__16884 = new BitSet(new long[]{0x4000000000000000L});
        public static final BitSet FOLLOW_rule__ValueType__Group_3__2_in_rule__ValueType__Group_3__16887 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__ValidValuesAssignment_3_1_in_rule__ValueType__Group_3__1__Impl6914 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_3__2__Impl_in_rule__ValueType__Group_3__26944 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_rule__ValueType__Group_3__2__Impl6972 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_6__0__Impl_in_rule__ValueType__Group_6__07009 = new BitSet(new long[]{0x00018000000001F0L,0x0000000000000004L});
        public static final BitSet FOLLOW_rule__ValueType__Group_6__1_in_rule__ValueType__Group_6__07012 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_rule__ValueType__Group_6__0__Impl7040 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_6__1__Impl_in_rule__ValueType__Group_6__17071 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Alternatives_6_1_in_rule__ValueType__Group_6__1__Impl7098 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_7__0__Impl_in_rule__ValueType__Group_7__07132 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__ValueType__Group_7__1_in_rule__ValueType__Group_7__07135 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_rule__ValueType__Group_7__0__Impl7163 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_7__1__Impl_in_rule__ValueType__Group_7__17194 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__DescriptionAssignment_7_1_in_rule__ValueType__Group_7__1__Impl7221 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__0__Impl_in_rule__VariantType__Group__07255 = new BitSet(new long[]{0x0000000000180000L});
        public static final BitSet FOLLOW_rule__VariantType__Group__1_in_rule__VariantType__Group__07258 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__1__Impl_in_rule__VariantType__Group__17316 = new BitSet(new long[]{0x20007FFFFFFFE010L,0x0000000000000001L});
        public static final BitSet FOLLOW_rule__VariantType__Group__2_in_rule__VariantType__Group__17319 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__TypeAssignment_1_in_rule__VariantType__Group__1__Impl7346 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__2__Impl_in_rule__VariantType__Group__27376 = new BitSet(new long[]{0x20007FFFFFFFE010L,0x0000000000000001L});
        public static final BitSet FOLLOW_rule__VariantType__Group__3_in_rule__VariantType__Group__27379 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__WithAutoAssignment_2_in_rule__VariantType__Group__2__Impl7406 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__3__Impl_in_rule__VariantType__Group__37437 = new BitSet(new long[]{0x20007FFFFFFFE010L,0x0000000000000001L});
        public static final BitSet FOLLOW_rule__VariantType__Group__4_in_rule__VariantType__Group__37440 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3__0_in_rule__VariantType__Group__3__Impl7467 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__4__Impl_in_rule__VariantType__Group__47498 = new BitSet(new long[]{0x0230000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__5_in_rule__VariantType__Group__47501 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__NameAssignment_4_in_rule__VariantType__Group__4__Impl7528 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__5__Impl_in_rule__VariantType__Group__57558 = new BitSet(new long[]{0x0230000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__6_in_rule__VariantType__Group__57561 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__MultiValueAssignment_5_in_rule__VariantType__Group__5__Impl7588 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__6__Impl_in_rule__VariantType__Group__67619 = new BitSet(new long[]{0x0230000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__7_in_rule__VariantType__Group__67622 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_6__0_in_rule__VariantType__Group__6__Impl7649 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__7__Impl_in_rule__VariantType__Group__77680 = new BitSet(new long[]{0x0230000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__8_in_rule__VariantType__Group__77683 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_7__0_in_rule__VariantType__Group__7__Impl7710 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__8__Impl_in_rule__VariantType__Group__87741 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_rule__VariantType__Group__8__Impl7769 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3__0__Impl_in_rule__VariantType__Group_3__07818 = new BitSet(new long[]{0x60007FFFFFFFE010L,0x0000000000000001L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3__1_in_rule__VariantType__Group_3__07821 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_rule__VariantType__Group_3__0__Impl7849 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3__1__Impl_in_rule__VariantType__Group_3__17880 = new BitSet(new long[]{0x60007FFFFFFFE010L,0x0000000000000001L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3__2_in_rule__VariantType__Group_3__17883 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3_1__0_in_rule__VariantType__Group_3__1__Impl7910 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3__2__Impl_in_rule__VariantType__Group_3__27941 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_rule__VariantType__Group_3__2__Impl7969 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3_1__0__Impl_in_rule__VariantType__Group_3_1__08006 = new BitSet(new long[]{0x0800000000000000L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3_1__1_in_rule__VariantType__Group_3_1__08009 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__ValuesAssignment_3_1_0_in_rule__VariantType__Group_3_1__0__Impl8036 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3_1__1__Impl_in_rule__VariantType__Group_3_1__18066 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3_1_1__0_in_rule__VariantType__Group_3_1__1__Impl8093 = new BitSet(new long[]{0x0800000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3_1_1__0__Impl_in_rule__VariantType__Group_3_1_1__08128 = new BitSet(new long[]{0x20007FFFFFFFE010L,0x0000000000000001L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3_1_1__1_in_rule__VariantType__Group_3_1_1__08131 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_59_in_rule__VariantType__Group_3_1_1__0__Impl8159 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3_1_1__1__Impl_in_rule__VariantType__Group_3_1_1__18190 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__ValuesAssignment_3_1_1_1_in_rule__VariantType__Group_3_1_1__1__Impl8217 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_6__0__Impl_in_rule__VariantType__Group_6__08251 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000004L});
        public static final BitSet FOLLOW_rule__VariantType__Group_6__1_in_rule__VariantType__Group_6__08254 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_rule__VariantType__Group_6__0__Impl8282 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_6__1__Impl_in_rule__VariantType__Group_6__18313 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Alternatives_6_1_in_rule__VariantType__Group_6__1__Impl8340 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_7__0__Impl_in_rule__VariantType__Group_7__08374 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__VariantType__Group_7__1_in_rule__VariantType__Group_7__08377 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_rule__VariantType__Group_7__0__Impl8405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_7__1__Impl_in_rule__VariantType__Group_7__18436 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__DescriptionAssignment_7_1_in_rule__VariantType__Group_7__1__Impl8463 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group__0__Impl_in_rule__EnumeratorType__Group__08497 = new BitSet(new long[]{0x20007FFFFFFFE010L,0x0000000000000001L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group__1_in_rule__EnumeratorType__Group__08500 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group__1__Impl_in_rule__EnumeratorType__Group__18558 = new BitSet(new long[]{0x0280000000000000L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group__2_in_rule__EnumeratorType__Group__18561 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__NameAssignment_1_in_rule__EnumeratorType__Group__1__Impl8588 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group__2__Impl_in_rule__EnumeratorType__Group__28618 = new BitSet(new long[]{0x0280000000000000L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group__3_in_rule__EnumeratorType__Group__28621 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_2__0_in_rule__EnumeratorType__Group__2__Impl8648 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group__3__Impl_in_rule__EnumeratorType__Group__38679 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_3__0_in_rule__EnumeratorType__Group__3__Impl8706 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_2__0__Impl_in_rule__EnumeratorType__Group_2__08745 = new BitSet(new long[]{0x01047FFC001FE000L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_2__1_in_rule__EnumeratorType__Group_2__08748 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_rule__EnumeratorType__Group_2__0__Impl8776 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_2__1__Impl_in_rule__EnumeratorType__Group_2__18807 = new BitSet(new long[]{0x01047FFC001FE000L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_2__2_in_rule__EnumeratorType__Group_2__18810 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__ParametersAssignment_2_1_in_rule__EnumeratorType__Group_2__1__Impl8837 = new BitSet(new long[]{0x00047FFC001FE002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_2__2__Impl_in_rule__EnumeratorType__Group_2__28868 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_rule__EnumeratorType__Group_2__2__Impl8896 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_3__0__Impl_in_rule__EnumeratorType__Group_3__08933 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_3__1_in_rule__EnumeratorType__Group_3__08936 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_rule__EnumeratorType__Group_3__0__Impl8964 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_3__1__Impl_in_rule__EnumeratorType__Group_3__18995 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__DescriptionAssignment_3_1_in_rule__EnumeratorType__Group_3__1__Impl9022 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__0__Impl_in_rule__ReferenceType__Group__09056 = new BitSet(new long[]{0x00047FFC001FE000L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__1_in_rule__ReferenceType__Group__09059 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__1__Impl_in_rule__ReferenceType__Group__19117 = new BitSet(new long[]{0x20007FFFFFFFE010L,0x0000000000000001L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__2_in_rule__ReferenceType__Group__19120 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__TypeAssignment_1_in_rule__ReferenceType__Group__1__Impl9147 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__2__Impl_in_rule__ReferenceType__Group__29177 = new BitSet(new long[]{0x0230000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__3_in_rule__ReferenceType__Group__29180 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__NameAssignment_2_in_rule__ReferenceType__Group__2__Impl9207 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__3__Impl_in_rule__ReferenceType__Group__39237 = new BitSet(new long[]{0x0230000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__4_in_rule__ReferenceType__Group__39240 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__MultiValueAssignment_3_in_rule__ReferenceType__Group__3__Impl9267 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__4__Impl_in_rule__ReferenceType__Group__49298 = new BitSet(new long[]{0x0230000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__5_in_rule__ReferenceType__Group__49301 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_4__0_in_rule__ReferenceType__Group__4__Impl9328 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__5__Impl_in_rule__ReferenceType__Group__59359 = new BitSet(new long[]{0x0230000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__6_in_rule__ReferenceType__Group__59362 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_5__0_in_rule__ReferenceType__Group__5__Impl9389 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__6__Impl_in_rule__ReferenceType__Group__69420 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_rule__ReferenceType__Group__6__Impl9448 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_4__0__Impl_in_rule__ReferenceType__Group_4__09493 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000004L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_4__1_in_rule__ReferenceType__Group_4__09496 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_rule__ReferenceType__Group_4__0__Impl9524 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_4__1__Impl_in_rule__ReferenceType__Group_4__19555 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Alternatives_4_1_in_rule__ReferenceType__Group_4__1__Impl9582 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_5__0__Impl_in_rule__ReferenceType__Group_5__09616 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_5__1_in_rule__ReferenceType__Group_5__09619 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_rule__ReferenceType__Group_5__0__Impl9647 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_5__1__Impl_in_rule__ReferenceType__Group_5__19678 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__DescriptionAssignment_5_1_in_rule__ReferenceType__Group_5__1__Impl9705 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group__0__Impl_in_rule__OilObject__Group__09739 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__OilObject__Group__1_in_rule__OilObject__Group__09742 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__TypeAssignment_0_in_rule__OilObject__Group__0__Impl9769 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group__1__Impl_in_rule__OilObject__Group__19799 = new BitSet(new long[]{0x02A0000000000000L});
        public static final BitSet FOLLOW_rule__OilObject__Group__2_in_rule__OilObject__Group__19802 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__NameAssignment_1_in_rule__OilObject__Group__1__Impl9829 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group__2__Impl_in_rule__OilObject__Group__29859 = new BitSet(new long[]{0x02A0000000000000L});
        public static final BitSet FOLLOW_rule__OilObject__Group__3_in_rule__OilObject__Group__29862 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group_2__0_in_rule__OilObject__Group__2__Impl9889 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group__3__Impl_in_rule__OilObject__Group__39920 = new BitSet(new long[]{0x02A0000000000000L});
        public static final BitSet FOLLOW_rule__OilObject__Group__4_in_rule__OilObject__Group__39923 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group_3__0_in_rule__OilObject__Group__3__Impl9950 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group__4__Impl_in_rule__OilObject__Group__49981 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_rule__OilObject__Group__4__Impl10009 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group_2__0__Impl_in_rule__OilObject__Group_2__010050 = new BitSet(new long[]{0x21007FFFFFFFE010L,0x0000000000000001L});
        public static final BitSet FOLLOW_rule__OilObject__Group_2__1_in_rule__OilObject__Group_2__010053 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_rule__OilObject__Group_2__0__Impl10081 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group_2__1__Impl_in_rule__OilObject__Group_2__110112 = new BitSet(new long[]{0x21007FFFFFFFE010L,0x0000000000000001L});
        public static final BitSet FOLLOW_rule__OilObject__Group_2__2_in_rule__OilObject__Group_2__110115 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__ParametersAssignment_2_1_in_rule__OilObject__Group_2__1__Impl10142 = new BitSet(new long[]{0x20007FFFFFFFE012L,0x0000000000000001L});
        public static final BitSet FOLLOW_rule__OilObject__Group_2__2__Impl_in_rule__OilObject__Group_2__210173 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_rule__OilObject__Group_2__2__Impl10201 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group_3__0__Impl_in_rule__OilObject__Group_3__010238 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__OilObject__Group_3__1_in_rule__OilObject__Group_3__010241 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_rule__OilObject__Group_3__0__Impl10269 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group_3__1__Impl_in_rule__OilObject__Group_3__110300 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__DescriptionAssignment_3_1_in_rule__OilObject__Group_3__1__Impl10327 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__0__Impl_in_rule__Parameter__Group__010361 = new BitSet(new long[]{0x20007FFFFFFFE010L,0x0000000000000001L});
        public static final BitSet FOLLOW_rule__Parameter__Group__1_in_rule__Parameter__Group__010364 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__1__Impl_in_rule__Parameter__Group__110422 = new BitSet(new long[]{0x0010000000000000L});
        public static final BitSet FOLLOW_rule__Parameter__Group__2_in_rule__Parameter__Group__110425 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__TypeAssignment_1_in_rule__Parameter__Group__1__Impl10452 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__2__Impl_in_rule__Parameter__Group__210482 = new BitSet(new long[]{0x2001FFFFFFFFE1F0L,0x0000000000000005L});
        public static final BitSet FOLLOW_rule__Parameter__Group__3_in_rule__Parameter__Group__210485 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_rule__Parameter__Group__2__Impl10513 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__3__Impl_in_rule__Parameter__Group__310544 = new BitSet(new long[]{0x02A0000000000000L});
        public static final BitSet FOLLOW_rule__Parameter__Group__4_in_rule__Parameter__Group__310547 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Alternatives_3_in_rule__Parameter__Group__3__Impl10574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__4__Impl_in_rule__Parameter__Group__410604 = new BitSet(new long[]{0x02A0000000000000L});
        public static final BitSet FOLLOW_rule__Parameter__Group__5_in_rule__Parameter__Group__410607 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group_4__0_in_rule__Parameter__Group__4__Impl10634 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__5__Impl_in_rule__Parameter__Group__510665 = new BitSet(new long[]{0x02A0000000000000L});
        public static final BitSet FOLLOW_rule__Parameter__Group__6_in_rule__Parameter__Group__510668 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group_5__0_in_rule__Parameter__Group__5__Impl10695 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__6__Impl_in_rule__Parameter__Group__610726 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_rule__Parameter__Group__6__Impl10754 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group_4__0__Impl_in_rule__Parameter__Group_4__010799 = new BitSet(new long[]{0x21007FFFFFFFE010L,0x0000000000000001L});
        public static final BitSet FOLLOW_rule__Parameter__Group_4__1_in_rule__Parameter__Group_4__010802 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_rule__Parameter__Group_4__0__Impl10830 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group_4__1__Impl_in_rule__Parameter__Group_4__110861 = new BitSet(new long[]{0x21007FFFFFFFE010L,0x0000000000000001L});
        public static final BitSet FOLLOW_rule__Parameter__Group_4__2_in_rule__Parameter__Group_4__110864 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__ParametersAssignment_4_1_in_rule__Parameter__Group_4__1__Impl10891 = new BitSet(new long[]{0x20007FFFFFFFE012L,0x0000000000000001L});
        public static final BitSet FOLLOW_rule__Parameter__Group_4__2__Impl_in_rule__Parameter__Group_4__210922 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_rule__Parameter__Group_4__2__Impl10950 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group_5__0__Impl_in_rule__Parameter__Group_5__010987 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Parameter__Group_5__1_in_rule__Parameter__Group_5__010990 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_rule__Parameter__Group_5__0__Impl11018 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group_5__1__Impl_in_rule__Parameter__Group_5__111049 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__DescriptionAssignment_5_1_in_rule__Parameter__Group_5__1__Impl11076 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Group__0__Impl_in_rule__INT__Group__011110 = new BitSet(new long[]{0x00018000000001C0L});
        public static final BitSet FOLLOW_rule__INT__Group__1_in_rule__INT__Group__011113 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Alternatives_0_in_rule__INT__Group__0__Impl11140 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Group__1__Impl_in_rule__INT__Group__111171 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Alternatives_1_in_rule__INT__Group__1__Impl11198 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Group_1_0__0__Impl_in_rule__INT__Group_1_0__011232 = new BitSet(new long[]{0x0000000000000140L});
        public static final BitSet FOLLOW_rule__INT__Group_1_0__1_in_rule__INT__Group_1_0__011235 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_rule__INT__Group_1_0__0__Impl11262 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Group_1_0__1__Impl_in_rule__INT__Group_1_0__111291 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Alternatives_1_0_1_in_rule__INT__Group_1_0__1__Impl11318 = new BitSet(new long[]{0x0000000000000142L});
        public static final BitSet FOLLOW_rule__FLOAT__Group__0__Impl_in_rule__FLOAT__Group__011353 = new BitSet(new long[]{0x00018000000001C0L});
        public static final BitSet FOLLOW_rule__FLOAT__Group__1_in_rule__FLOAT__Group__011356 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FLOAT__Alternatives_0_in_rule__FLOAT__Group__0__Impl11383 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FLOAT__Group__1__Impl_in_rule__FLOAT__Group__111414 = new BitSet(new long[]{0x8000000000000000L});
        public static final BitSet FOLLOW_rule__FLOAT__Group__2_in_rule__FLOAT__Group__111417 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FLOAT__Alternatives_1_in_rule__FLOAT__Group__1__Impl11444 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FLOAT__Group__2__Impl_in_rule__FLOAT__Group__211474 = new BitSet(new long[]{0x0000000000000140L});
        public static final BitSet FOLLOW_rule__FLOAT__Group__3_in_rule__FLOAT__Group__211477 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_63_in_rule__FLOAT__Group__2__Impl11506 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FLOAT__Group__3__Impl_in_rule__FLOAT__Group__311538 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FLOAT__Alternatives_3_in_rule__FLOAT__Group__3__Impl11567 = new BitSet(new long[]{0x0000000000000142L});
        public static final BitSet FOLLOW_rule__FLOAT__Alternatives_3_in_rule__FLOAT__Group__3__Impl11579 = new BitSet(new long[]{0x0000000000000142L});
        public static final BitSet FOLLOW_rule__FLOAT__Group_1_1__0__Impl_in_rule__FLOAT__Group_1_1__011620 = new BitSet(new long[]{0x0000000000000140L});
        public static final BitSet FOLLOW_rule__FLOAT__Group_1_1__1_in_rule__FLOAT__Group_1_1__011623 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_rule__FLOAT__Group_1_1__0__Impl11650 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FLOAT__Group_1_1__1__Impl_in_rule__FLOAT__Group_1_1__111679 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FLOAT__Alternatives_1_1_1_in_rule__FLOAT__Group_1_1__1__Impl11706 = new BitSet(new long[]{0x0000000000000142L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__OilFile__OilVersionAssignment_1_211746 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilImplementation_in_rule__OilFile__ImplementationAssignment_211777 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilApplication_in_rule__OilFile__ApplicationAssignment_311808 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__OilImplementation__NameAssignment_111839 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilObjectImpl_in_rule__OilImplementation__OilObjectsAssignment_311870 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectType_in_rule__OilObjectImpl__TypeAssignment_011901 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameterType_in_rule__OilObjectImpl__ParametersAssignment_211932 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__OilObjectImpl__DescriptionAssignment_4_111963 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__OilApplication__NameAssignment_111994 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilObject_in_rule__OilApplication__OilObjectsAssignment_312025 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__OilApplication__DescriptionAssignment_5_112056 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGenericNumber_in_rule__ValueList__ValuesAssignment_112087 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGenericNumber_in_rule__ValueList__ValuesAssignment_2_112118 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGenericNumber_in_rule__Range__MinAssignment_112149 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGenericNumber_in_rule__Range__MaxAssignment_312180 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVType_in_rule__ValueType__TypeAssignment_112211 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_64_in_rule__ValueType__WithAutoAssignment_212247 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValidValues_in_rule__ValueType__ValidValuesAssignment_3_112286 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecialId_in_rule__ValueType__NameAssignment_412317 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_rule__ValueType__MultiValueAssignment_512353 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_rule__ValueType__DefaultAutoAssignment_6_1_012397 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__DefaultValueAlternatives_6_1_1_0_in_rule__ValueType__DefaultValueAssignment_6_1_112436 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__ValueType__DescriptionAssignment_7_112469 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEType_in_rule__VariantType__TypeAssignment_112500 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_64_in_rule__VariantType__WithAutoAssignment_212536 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumeratorType_in_rule__VariantType__ValuesAssignment_3_1_012575 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumeratorType_in_rule__VariantType__ValuesAssignment_3_1_1_112606 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecialId_in_rule__VariantType__NameAssignment_412637 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_rule__VariantType__MultiValueAssignment_512673 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_rule__VariantType__DefaultAutoAssignment_6_1_012717 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__VariantType__DefaultValueAssignment_6_1_112756 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__VariantType__DescriptionAssignment_7_112787 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecialId_in_rule__EnumeratorType__NameAssignment_112818 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameterType_in_rule__EnumeratorType__ParametersAssignment_2_112849 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__EnumeratorType__DescriptionAssignment_3_112880 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectTypeRef_in_rule__ReferenceType__TypeAssignment_112911 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecialId_in_rule__ReferenceType__NameAssignment_212942 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_rule__ReferenceType__MultiValueAssignment_312978 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_rule__ReferenceType__DefaultAutoAssignment_4_1_013022 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ReferenceType__DefaultValueAssignment_4_1_113061 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__ReferenceType__DescriptionAssignment_5_113092 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectType_in_rule__OilObject__TypeAssignment_013123 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__OilObject__NameAssignment_113154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameter_in_rule__OilObject__ParametersAssignment_2_113185 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__OilObject__DescriptionAssignment_3_113216 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecialId_in_rule__Parameter__TypeAssignment_113251 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_rule__Parameter__AutoAssignment_3_013291 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGenericValue_in_rule__Parameter__ValueAssignment_3_113330 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecialId_in_rule__Parameter__ValueRefAssignment_3_213365 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameter_in_rule__Parameter__ParametersAssignment_4_113400 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Parameter__DescriptionAssignment_5_113431 = new BitSet(new long[]{0x0000000000000002L});
    }


}