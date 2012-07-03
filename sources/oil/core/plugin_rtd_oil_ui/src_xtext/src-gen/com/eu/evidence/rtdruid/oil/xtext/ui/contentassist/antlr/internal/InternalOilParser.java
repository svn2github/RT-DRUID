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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_ZERO_INT", "RULE_HEX", "RULE_NON_ZERO_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'STRING'", "'UINT32'", "'INT32'", "'UINT64'", "'INT64'", "'FLOAT'", "'DOUBLE'", "'BOOLEAN'", "'ENUM'", "'OS'", "'ALARM'", "'APPMODE'", "'COUNTER'", "'COM'", "'EVENT'", "'IPDU'", "'ISR'", "'MESSAGE'", "'NETWORKMESSAGE'", "'NM'", "'RESOURCE'", "'TASK'", "'OS_TYPE'", "'ALARM_TYPE'", "'APPMODE_TYPE'", "'COUNTER_TYPE'", "'COM_TYPE'", "'EVENT_TYPE'", "'IPDU_TYPE'", "'ISR_TYPE'", "'MESSAGE_TYPE'", "'NETWORKMESSAGE_TYPE'", "'NM_TYPE'", "'RESOURCE_TYPE'", "'TASK_TYPE'", "'+'", "'-'", "'APPLICATION'", "'APPLICATION_TYPE'", "'OIL_VERSION'", "'='", "';'", "'IMPLEMENTATION'", "'{'", "'}'", "':'", "'CPU'", "'['", "']'", "'..'", "','", "'.'", "'WITH_AUTO'", "'[]'", "'AUTO'"
    };
    public static final int RULE_ID=4;
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
            case 51:
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


    // $ANTLR start "rule__ValueType__Alternatives_3_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:585:1: rule__ValueType__Alternatives_3_1 : ( ( ( rule__ValueType__Group_3_1_0__0 ) ) | ( ( rule__ValueType__Group_3_1_1__0 ) ) );
    public final void rule__ValueType__Alternatives_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:589:1: ( ( ( rule__ValueType__Group_3_1_0__0 ) ) | ( ( rule__ValueType__Group_3_1_1__0 ) ) )
            int alt2=2;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:590:1: ( ( rule__ValueType__Group_3_1_0__0 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:590:1: ( ( rule__ValueType__Group_3_1_0__0 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:591:1: ( rule__ValueType__Group_3_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getGroup_3_1_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:592:1: ( rule__ValueType__Group_3_1_0__0 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:592:2: rule__ValueType__Group_3_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_3_1_0__0_in_rule__ValueType__Alternatives_3_11186);
                    rule__ValueType__Group_3_1_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueTypeAccess().getGroup_3_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:596:6: ( ( rule__ValueType__Group_3_1_1__0 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:596:6: ( ( rule__ValueType__Group_3_1_1__0 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:597:1: ( rule__ValueType__Group_3_1_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getGroup_3_1_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:598:1: ( rule__ValueType__Group_3_1_1__0 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:598:2: rule__ValueType__Group_3_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_3_1_1__0_in_rule__ValueType__Alternatives_3_11204);
                    rule__ValueType__Group_3_1_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueTypeAccess().getGroup_3_1_1()); 
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
    // $ANTLR end "rule__ValueType__Alternatives_3_1"


    // $ANTLR start "rule__ValueType__Alternatives_3_1_0_0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:607:1: rule__ValueType__Alternatives_3_1_0_0 : ( ( ruleINT ) | ( ruleDOUBLE ) );
    public final void rule__ValueType__Alternatives_3_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:611:1: ( ( ruleINT ) | ( ruleDOUBLE ) )
            int alt3=2;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:612:1: ( ruleINT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:612:1: ( ruleINT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:613:1: ruleINT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getINTParserRuleCall_3_1_0_0_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleINT_in_rule__ValueType__Alternatives_3_1_0_01237);
                    ruleINT();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueTypeAccess().getINTParserRuleCall_3_1_0_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:618:6: ( ruleDOUBLE )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:618:6: ( ruleDOUBLE )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:619:1: ruleDOUBLE
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getDOUBLEParserRuleCall_3_1_0_0_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleDOUBLE_in_rule__ValueType__Alternatives_3_1_0_01254);
                    ruleDOUBLE();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueTypeAccess().getDOUBLEParserRuleCall_3_1_0_0_1()); 
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
    // $ANTLR end "rule__ValueType__Alternatives_3_1_0_0"


    // $ANTLR start "rule__ValueType__Alternatives_3_1_0_2"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:629:1: rule__ValueType__Alternatives_3_1_0_2 : ( ( ruleINT ) | ( ruleDOUBLE ) );
    public final void rule__ValueType__Alternatives_3_1_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:633:1: ( ( ruleINT ) | ( ruleDOUBLE ) )
            int alt4=2;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:634:1: ( ruleINT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:634:1: ( ruleINT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:635:1: ruleINT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getINTParserRuleCall_3_1_0_2_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleINT_in_rule__ValueType__Alternatives_3_1_0_21286);
                    ruleINT();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueTypeAccess().getINTParserRuleCall_3_1_0_2_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:640:6: ( ruleDOUBLE )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:640:6: ( ruleDOUBLE )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:641:1: ruleDOUBLE
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getDOUBLEParserRuleCall_3_1_0_2_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleDOUBLE_in_rule__ValueType__Alternatives_3_1_0_21303);
                    ruleDOUBLE();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueTypeAccess().getDOUBLEParserRuleCall_3_1_0_2_1()); 
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
    // $ANTLR end "rule__ValueType__Alternatives_3_1_0_2"


    // $ANTLR start "rule__ValueType__Alternatives_3_1_1_0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:651:1: rule__ValueType__Alternatives_3_1_1_0 : ( ( ruleINT ) | ( ruleDOUBLE ) );
    public final void rule__ValueType__Alternatives_3_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:655:1: ( ( ruleINT ) | ( ruleDOUBLE ) )
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:656:1: ( ruleINT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:656:1: ( ruleINT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:657:1: ruleINT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getINTParserRuleCall_3_1_1_0_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleINT_in_rule__ValueType__Alternatives_3_1_1_01335);
                    ruleINT();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueTypeAccess().getINTParserRuleCall_3_1_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:662:6: ( ruleDOUBLE )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:662:6: ( ruleDOUBLE )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:663:1: ruleDOUBLE
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getDOUBLEParserRuleCall_3_1_1_0_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleDOUBLE_in_rule__ValueType__Alternatives_3_1_1_01352);
                    ruleDOUBLE();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueTypeAccess().getDOUBLEParserRuleCall_3_1_1_0_1()); 
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
    // $ANTLR end "rule__ValueType__Alternatives_3_1_1_0"


    // $ANTLR start "rule__ValueType__Alternatives_3_1_1_1_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:673:1: rule__ValueType__Alternatives_3_1_1_1_1 : ( ( ruleINT ) | ( ruleDOUBLE ) );
    public final void rule__ValueType__Alternatives_3_1_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:677:1: ( ( ruleINT ) | ( ruleDOUBLE ) )
            int alt6=2;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:678:1: ( ruleINT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:678:1: ( ruleINT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:679:1: ruleINT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getINTParserRuleCall_3_1_1_1_1_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleINT_in_rule__ValueType__Alternatives_3_1_1_1_11384);
                    ruleINT();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueTypeAccess().getINTParserRuleCall_3_1_1_1_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:684:6: ( ruleDOUBLE )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:684:6: ( ruleDOUBLE )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:685:1: ruleDOUBLE
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getDOUBLEParserRuleCall_3_1_1_1_1_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleDOUBLE_in_rule__ValueType__Alternatives_3_1_1_1_11401);
                    ruleDOUBLE();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueTypeAccess().getDOUBLEParserRuleCall_3_1_1_1_1_1()); 
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
    // $ANTLR end "rule__ValueType__Alternatives_3_1_1_1_1"


    // $ANTLR start "rule__ValueType__Alternatives_6_1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:695:1: rule__ValueType__Alternatives_6_1 : ( ( ( rule__ValueType__DefaultAutoAssignment_6_1_0 ) ) | ( ( rule__ValueType__DefaultValueAssignment_6_1_1 ) ) );
    public final void rule__ValueType__Alternatives_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:699:1: ( ( ( rule__ValueType__DefaultAutoAssignment_6_1_0 ) ) | ( ( rule__ValueType__DefaultValueAssignment_6_1_1 ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==67) ) {
                alt7=1;
            }
            else if ( ((LA7_0>=RULE_ID && LA7_0<=RULE_NON_ZERO_INT)||(LA7_0>=48 && LA7_0<=49)) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:700:1: ( ( rule__ValueType__DefaultAutoAssignment_6_1_0 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:700:1: ( ( rule__ValueType__DefaultAutoAssignment_6_1_0 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:701:1: ( rule__ValueType__DefaultAutoAssignment_6_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getDefaultAutoAssignment_6_1_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:702:1: ( rule__ValueType__DefaultAutoAssignment_6_1_0 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:702:2: rule__ValueType__DefaultAutoAssignment_6_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ValueType__DefaultAutoAssignment_6_1_0_in_rule__ValueType__Alternatives_6_11433);
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:706:6: ( ( rule__ValueType__DefaultValueAssignment_6_1_1 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:706:6: ( ( rule__ValueType__DefaultValueAssignment_6_1_1 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:707:1: ( rule__ValueType__DefaultValueAssignment_6_1_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getDefaultValueAssignment_6_1_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:708:1: ( rule__ValueType__DefaultValueAssignment_6_1_1 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:708:2: rule__ValueType__DefaultValueAssignment_6_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ValueType__DefaultValueAssignment_6_1_1_in_rule__ValueType__Alternatives_6_11451);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:717:1: rule__ValueType__DefaultValueAlternatives_6_1_1_0 : ( ( ruleGenericValue ) | ( RULE_ID ) );
    public final void rule__ValueType__DefaultValueAlternatives_6_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:721:1: ( ( ruleGenericValue ) | ( RULE_ID ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=RULE_STRING && LA8_0<=RULE_NON_ZERO_INT)||(LA8_0>=48 && LA8_0<=49)) ) {
                alt8=1;
            }
            else if ( (LA8_0==RULE_ID) ) {
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:722:1: ( ruleGenericValue )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:722:1: ( ruleGenericValue )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:723:1: ruleGenericValue
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getDefaultValueGenericValueParserRuleCall_6_1_1_0_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleGenericValue_in_rule__ValueType__DefaultValueAlternatives_6_1_1_01484);
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:728:6: ( RULE_ID )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:728:6: ( RULE_ID )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:729:1: RULE_ID
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getDefaultValueIDTerminalRuleCall_6_1_1_0_1()); 
                    }
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ValueType__DefaultValueAlternatives_6_1_1_01501); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:739:1: rule__VariantType__Alternatives_6_1 : ( ( ( rule__VariantType__DefaultAutoAssignment_6_1_0 ) ) | ( ( rule__VariantType__DefaultValueAssignment_6_1_1 ) ) );
    public final void rule__VariantType__Alternatives_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:743:1: ( ( ( rule__VariantType__DefaultAutoAssignment_6_1_0 ) ) | ( ( rule__VariantType__DefaultValueAssignment_6_1_1 ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==67) ) {
                alt9=1;
            }
            else if ( (LA9_0==RULE_ID) ) {
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:744:1: ( ( rule__VariantType__DefaultAutoAssignment_6_1_0 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:744:1: ( ( rule__VariantType__DefaultAutoAssignment_6_1_0 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:745:1: ( rule__VariantType__DefaultAutoAssignment_6_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVariantTypeAccess().getDefaultAutoAssignment_6_1_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:746:1: ( rule__VariantType__DefaultAutoAssignment_6_1_0 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:746:2: rule__VariantType__DefaultAutoAssignment_6_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__VariantType__DefaultAutoAssignment_6_1_0_in_rule__VariantType__Alternatives_6_11533);
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:750:6: ( ( rule__VariantType__DefaultValueAssignment_6_1_1 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:750:6: ( ( rule__VariantType__DefaultValueAssignment_6_1_1 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:751:1: ( rule__VariantType__DefaultValueAssignment_6_1_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVariantTypeAccess().getDefaultValueAssignment_6_1_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:752:1: ( rule__VariantType__DefaultValueAssignment_6_1_1 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:752:2: rule__VariantType__DefaultValueAssignment_6_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__VariantType__DefaultValueAssignment_6_1_1_in_rule__VariantType__Alternatives_6_11551);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:761:1: rule__ReferenceType__Alternatives_5_1 : ( ( ( rule__ReferenceType__DefaultAutoAssignment_5_1_0 ) ) | ( ( rule__ReferenceType__DefaultValueAssignment_5_1_1 ) ) );
    public final void rule__ReferenceType__Alternatives_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:765:1: ( ( ( rule__ReferenceType__DefaultAutoAssignment_5_1_0 ) ) | ( ( rule__ReferenceType__DefaultValueAssignment_5_1_1 ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==67) ) {
                alt10=1;
            }
            else if ( (LA10_0==RULE_ID) ) {
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:766:1: ( ( rule__ReferenceType__DefaultAutoAssignment_5_1_0 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:766:1: ( ( rule__ReferenceType__DefaultAutoAssignment_5_1_0 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:767:1: ( rule__ReferenceType__DefaultAutoAssignment_5_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReferenceTypeAccess().getDefaultAutoAssignment_5_1_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:768:1: ( rule__ReferenceType__DefaultAutoAssignment_5_1_0 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:768:2: rule__ReferenceType__DefaultAutoAssignment_5_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__DefaultAutoAssignment_5_1_0_in_rule__ReferenceType__Alternatives_5_11584);
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:772:6: ( ( rule__ReferenceType__DefaultValueAssignment_5_1_1 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:772:6: ( ( rule__ReferenceType__DefaultValueAssignment_5_1_1 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:773:1: ( rule__ReferenceType__DefaultValueAssignment_5_1_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReferenceTypeAccess().getDefaultValueAssignment_5_1_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:774:1: ( rule__ReferenceType__DefaultValueAssignment_5_1_1 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:774:2: rule__ReferenceType__DefaultValueAssignment_5_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__DefaultValueAssignment_5_1_1_in_rule__ReferenceType__Alternatives_5_11602);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:783:1: rule__Parameter__Alternatives_3 : ( ( ( rule__Parameter__AutoAssignment_3_0 ) ) | ( ( rule__Parameter__ValueAssignment_3_1 ) ) | ( ( rule__Parameter__ValueRefAssignment_3_2 ) ) );
    public final void rule__Parameter__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:787:1: ( ( ( rule__Parameter__AutoAssignment_3_0 ) ) | ( ( rule__Parameter__ValueAssignment_3_1 ) ) | ( ( rule__Parameter__ValueRefAssignment_3_2 ) ) )
            int alt11=3;
            switch ( input.LA(1) ) {
            case 67:
                {
                alt11=1;
                }
                break;
            case RULE_STRING:
            case RULE_ZERO_INT:
            case RULE_HEX:
            case RULE_NON_ZERO_INT:
            case 48:
            case 49:
                {
                alt11=2;
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
                alt11=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:788:1: ( ( rule__Parameter__AutoAssignment_3_0 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:788:1: ( ( rule__Parameter__AutoAssignment_3_0 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:789:1: ( rule__Parameter__AutoAssignment_3_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getParameterAccess().getAutoAssignment_3_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:790:1: ( rule__Parameter__AutoAssignment_3_0 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:790:2: rule__Parameter__AutoAssignment_3_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Parameter__AutoAssignment_3_0_in_rule__Parameter__Alternatives_31635);
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:794:6: ( ( rule__Parameter__ValueAssignment_3_1 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:794:6: ( ( rule__Parameter__ValueAssignment_3_1 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:795:1: ( rule__Parameter__ValueAssignment_3_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getParameterAccess().getValueAssignment_3_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:796:1: ( rule__Parameter__ValueAssignment_3_1 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:796:2: rule__Parameter__ValueAssignment_3_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Parameter__ValueAssignment_3_1_in_rule__Parameter__Alternatives_31653);
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:800:6: ( ( rule__Parameter__ValueRefAssignment_3_2 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:800:6: ( ( rule__Parameter__ValueRefAssignment_3_2 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:801:1: ( rule__Parameter__ValueRefAssignment_3_2 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getParameterAccess().getValueRefAssignment_3_2()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:802:1: ( rule__Parameter__ValueRefAssignment_3_2 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:802:2: rule__Parameter__ValueRefAssignment_3_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Parameter__ValueRefAssignment_3_2_in_rule__Parameter__Alternatives_31671);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:811:1: rule__SpecialId__Alternatives : ( ( RULE_ID ) | ( 'STRING' ) | ( 'UINT32' ) | ( 'INT32' ) | ( 'UINT64' ) | ( 'INT64' ) | ( 'FLOAT' ) | ( 'DOUBLE' ) | ( 'BOOLEAN' ) | ( 'ENUM' ) | ( 'OS' ) | ( 'ALARM' ) | ( 'APPMODE' ) | ( 'COUNTER' ) | ( 'COM' ) | ( 'EVENT' ) | ( 'IPDU' ) | ( 'ISR' ) | ( 'MESSAGE' ) | ( 'NETWORKMESSAGE' ) | ( 'NM' ) | ( 'RESOURCE' ) | ( 'TASK' ) | ( 'OS_TYPE' ) | ( 'ALARM_TYPE' ) | ( 'APPMODE_TYPE' ) | ( 'COUNTER_TYPE' ) | ( 'COM_TYPE' ) | ( 'EVENT_TYPE' ) | ( 'IPDU_TYPE' ) | ( 'ISR_TYPE' ) | ( 'MESSAGE_TYPE' ) | ( 'NETWORKMESSAGE_TYPE' ) | ( 'NM_TYPE' ) | ( 'RESOURCE_TYPE' ) | ( 'TASK_TYPE' ) );
    public final void rule__SpecialId__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:815:1: ( ( RULE_ID ) | ( 'STRING' ) | ( 'UINT32' ) | ( 'INT32' ) | ( 'UINT64' ) | ( 'INT64' ) | ( 'FLOAT' ) | ( 'DOUBLE' ) | ( 'BOOLEAN' ) | ( 'ENUM' ) | ( 'OS' ) | ( 'ALARM' ) | ( 'APPMODE' ) | ( 'COUNTER' ) | ( 'COM' ) | ( 'EVENT' ) | ( 'IPDU' ) | ( 'ISR' ) | ( 'MESSAGE' ) | ( 'NETWORKMESSAGE' ) | ( 'NM' ) | ( 'RESOURCE' ) | ( 'TASK' ) | ( 'OS_TYPE' ) | ( 'ALARM_TYPE' ) | ( 'APPMODE_TYPE' ) | ( 'COUNTER_TYPE' ) | ( 'COM_TYPE' ) | ( 'EVENT_TYPE' ) | ( 'IPDU_TYPE' ) | ( 'ISR_TYPE' ) | ( 'MESSAGE_TYPE' ) | ( 'NETWORKMESSAGE_TYPE' ) | ( 'NM_TYPE' ) | ( 'RESOURCE_TYPE' ) | ( 'TASK_TYPE' ) )
            int alt12=36;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt12=1;
                }
                break;
            case 13:
                {
                alt12=2;
                }
                break;
            case 14:
                {
                alt12=3;
                }
                break;
            case 15:
                {
                alt12=4;
                }
                break;
            case 16:
                {
                alt12=5;
                }
                break;
            case 17:
                {
                alt12=6;
                }
                break;
            case 18:
                {
                alt12=7;
                }
                break;
            case 19:
                {
                alt12=8;
                }
                break;
            case 20:
                {
                alt12=9;
                }
                break;
            case 21:
                {
                alt12=10;
                }
                break;
            case 22:
                {
                alt12=11;
                }
                break;
            case 23:
                {
                alt12=12;
                }
                break;
            case 24:
                {
                alt12=13;
                }
                break;
            case 25:
                {
                alt12=14;
                }
                break;
            case 26:
                {
                alt12=15;
                }
                break;
            case 27:
                {
                alt12=16;
                }
                break;
            case 28:
                {
                alt12=17;
                }
                break;
            case 29:
                {
                alt12=18;
                }
                break;
            case 30:
                {
                alt12=19;
                }
                break;
            case 31:
                {
                alt12=20;
                }
                break;
            case 32:
                {
                alt12=21;
                }
                break;
            case 33:
                {
                alt12=22;
                }
                break;
            case 34:
                {
                alt12=23;
                }
                break;
            case 35:
                {
                alt12=24;
                }
                break;
            case 36:
                {
                alt12=25;
                }
                break;
            case 37:
                {
                alt12=26;
                }
                break;
            case 38:
                {
                alt12=27;
                }
                break;
            case 39:
                {
                alt12=28;
                }
                break;
            case 40:
                {
                alt12=29;
                }
                break;
            case 41:
                {
                alt12=30;
                }
                break;
            case 42:
                {
                alt12=31;
                }
                break;
            case 43:
                {
                alt12=32;
                }
                break;
            case 44:
                {
                alt12=33;
                }
                break;
            case 45:
                {
                alt12=34;
                }
                break;
            case 46:
                {
                alt12=35;
                }
                break;
            case 47:
                {
                alt12=36;
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:816:1: ( RULE_ID )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:816:1: ( RULE_ID )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:817:1: RULE_ID
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getIDTerminalRuleCall_0()); 
                    }
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__SpecialId__Alternatives1704); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getIDTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:822:6: ( 'STRING' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:822:6: ( 'STRING' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:823:1: 'STRING'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getSTRINGKeyword_1()); 
                    }
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__SpecialId__Alternatives1722); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getSTRINGKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:830:6: ( 'UINT32' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:830:6: ( 'UINT32' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:831:1: 'UINT32'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getUINT32Keyword_2()); 
                    }
                    match(input,14,FollowSets000.FOLLOW_14_in_rule__SpecialId__Alternatives1742); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getUINT32Keyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:838:6: ( 'INT32' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:838:6: ( 'INT32' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:839:1: 'INT32'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getINT32Keyword_3()); 
                    }
                    match(input,15,FollowSets000.FOLLOW_15_in_rule__SpecialId__Alternatives1762); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getINT32Keyword_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:846:6: ( 'UINT64' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:846:6: ( 'UINT64' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:847:1: 'UINT64'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getUINT64Keyword_4()); 
                    }
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__SpecialId__Alternatives1782); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getUINT64Keyword_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:854:6: ( 'INT64' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:854:6: ( 'INT64' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:855:1: 'INT64'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getINT64Keyword_5()); 
                    }
                    match(input,17,FollowSets000.FOLLOW_17_in_rule__SpecialId__Alternatives1802); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getINT64Keyword_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:862:6: ( 'FLOAT' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:862:6: ( 'FLOAT' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:863:1: 'FLOAT'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getFLOATKeyword_6()); 
                    }
                    match(input,18,FollowSets000.FOLLOW_18_in_rule__SpecialId__Alternatives1822); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getFLOATKeyword_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:870:6: ( 'DOUBLE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:870:6: ( 'DOUBLE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:871:1: 'DOUBLE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getDOUBLEKeyword_7()); 
                    }
                    match(input,19,FollowSets000.FOLLOW_19_in_rule__SpecialId__Alternatives1842); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getDOUBLEKeyword_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:878:6: ( 'BOOLEAN' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:878:6: ( 'BOOLEAN' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:879:1: 'BOOLEAN'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getBOOLEANKeyword_8()); 
                    }
                    match(input,20,FollowSets000.FOLLOW_20_in_rule__SpecialId__Alternatives1862); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getBOOLEANKeyword_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:886:6: ( 'ENUM' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:886:6: ( 'ENUM' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:887:1: 'ENUM'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getENUMKeyword_9()); 
                    }
                    match(input,21,FollowSets000.FOLLOW_21_in_rule__SpecialId__Alternatives1882); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getENUMKeyword_9()); 
                    }

                    }


                    }
                    break;
                case 11 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:894:6: ( 'OS' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:894:6: ( 'OS' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:895:1: 'OS'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getOSKeyword_10()); 
                    }
                    match(input,22,FollowSets000.FOLLOW_22_in_rule__SpecialId__Alternatives1902); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getOSKeyword_10()); 
                    }

                    }


                    }
                    break;
                case 12 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:902:6: ( 'ALARM' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:902:6: ( 'ALARM' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:903:1: 'ALARM'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getALARMKeyword_11()); 
                    }
                    match(input,23,FollowSets000.FOLLOW_23_in_rule__SpecialId__Alternatives1922); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getALARMKeyword_11()); 
                    }

                    }


                    }
                    break;
                case 13 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:910:6: ( 'APPMODE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:910:6: ( 'APPMODE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:911:1: 'APPMODE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getAPPMODEKeyword_12()); 
                    }
                    match(input,24,FollowSets000.FOLLOW_24_in_rule__SpecialId__Alternatives1942); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getAPPMODEKeyword_12()); 
                    }

                    }


                    }
                    break;
                case 14 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:918:6: ( 'COUNTER' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:918:6: ( 'COUNTER' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:919:1: 'COUNTER'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getCOUNTERKeyword_13()); 
                    }
                    match(input,25,FollowSets000.FOLLOW_25_in_rule__SpecialId__Alternatives1962); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getCOUNTERKeyword_13()); 
                    }

                    }


                    }
                    break;
                case 15 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:926:6: ( 'COM' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:926:6: ( 'COM' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:927:1: 'COM'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getCOMKeyword_14()); 
                    }
                    match(input,26,FollowSets000.FOLLOW_26_in_rule__SpecialId__Alternatives1982); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getCOMKeyword_14()); 
                    }

                    }


                    }
                    break;
                case 16 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:934:6: ( 'EVENT' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:934:6: ( 'EVENT' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:935:1: 'EVENT'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getEVENTKeyword_15()); 
                    }
                    match(input,27,FollowSets000.FOLLOW_27_in_rule__SpecialId__Alternatives2002); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getEVENTKeyword_15()); 
                    }

                    }


                    }
                    break;
                case 17 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:942:6: ( 'IPDU' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:942:6: ( 'IPDU' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:943:1: 'IPDU'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getIPDUKeyword_16()); 
                    }
                    match(input,28,FollowSets000.FOLLOW_28_in_rule__SpecialId__Alternatives2022); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getIPDUKeyword_16()); 
                    }

                    }


                    }
                    break;
                case 18 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:950:6: ( 'ISR' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:950:6: ( 'ISR' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:951:1: 'ISR'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getISRKeyword_17()); 
                    }
                    match(input,29,FollowSets000.FOLLOW_29_in_rule__SpecialId__Alternatives2042); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getISRKeyword_17()); 
                    }

                    }


                    }
                    break;
                case 19 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:958:6: ( 'MESSAGE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:958:6: ( 'MESSAGE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:959:1: 'MESSAGE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getMESSAGEKeyword_18()); 
                    }
                    match(input,30,FollowSets000.FOLLOW_30_in_rule__SpecialId__Alternatives2062); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getMESSAGEKeyword_18()); 
                    }

                    }


                    }
                    break;
                case 20 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:966:6: ( 'NETWORKMESSAGE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:966:6: ( 'NETWORKMESSAGE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:967:1: 'NETWORKMESSAGE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getNETWORKMESSAGEKeyword_19()); 
                    }
                    match(input,31,FollowSets000.FOLLOW_31_in_rule__SpecialId__Alternatives2082); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getNETWORKMESSAGEKeyword_19()); 
                    }

                    }


                    }
                    break;
                case 21 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:974:6: ( 'NM' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:974:6: ( 'NM' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:975:1: 'NM'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getNMKeyword_20()); 
                    }
                    match(input,32,FollowSets000.FOLLOW_32_in_rule__SpecialId__Alternatives2102); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getNMKeyword_20()); 
                    }

                    }


                    }
                    break;
                case 22 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:982:6: ( 'RESOURCE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:982:6: ( 'RESOURCE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:983:1: 'RESOURCE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getRESOURCEKeyword_21()); 
                    }
                    match(input,33,FollowSets000.FOLLOW_33_in_rule__SpecialId__Alternatives2122); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getRESOURCEKeyword_21()); 
                    }

                    }


                    }
                    break;
                case 23 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:990:6: ( 'TASK' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:990:6: ( 'TASK' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:991:1: 'TASK'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getTASKKeyword_22()); 
                    }
                    match(input,34,FollowSets000.FOLLOW_34_in_rule__SpecialId__Alternatives2142); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getTASKKeyword_22()); 
                    }

                    }


                    }
                    break;
                case 24 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:998:6: ( 'OS_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:998:6: ( 'OS_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:999:1: 'OS_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getOS_TYPEKeyword_23()); 
                    }
                    match(input,35,FollowSets000.FOLLOW_35_in_rule__SpecialId__Alternatives2162); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getOS_TYPEKeyword_23()); 
                    }

                    }


                    }
                    break;
                case 25 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1006:6: ( 'ALARM_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1006:6: ( 'ALARM_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1007:1: 'ALARM_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getALARM_TYPEKeyword_24()); 
                    }
                    match(input,36,FollowSets000.FOLLOW_36_in_rule__SpecialId__Alternatives2182); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getALARM_TYPEKeyword_24()); 
                    }

                    }


                    }
                    break;
                case 26 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1014:6: ( 'APPMODE_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1014:6: ( 'APPMODE_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1015:1: 'APPMODE_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getAPPMODE_TYPEKeyword_25()); 
                    }
                    match(input,37,FollowSets000.FOLLOW_37_in_rule__SpecialId__Alternatives2202); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getAPPMODE_TYPEKeyword_25()); 
                    }

                    }


                    }
                    break;
                case 27 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1022:6: ( 'COUNTER_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1022:6: ( 'COUNTER_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1023:1: 'COUNTER_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getCOUNTER_TYPEKeyword_26()); 
                    }
                    match(input,38,FollowSets000.FOLLOW_38_in_rule__SpecialId__Alternatives2222); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getCOUNTER_TYPEKeyword_26()); 
                    }

                    }


                    }
                    break;
                case 28 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1030:6: ( 'COM_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1030:6: ( 'COM_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1031:1: 'COM_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getCOM_TYPEKeyword_27()); 
                    }
                    match(input,39,FollowSets000.FOLLOW_39_in_rule__SpecialId__Alternatives2242); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getCOM_TYPEKeyword_27()); 
                    }

                    }


                    }
                    break;
                case 29 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1038:6: ( 'EVENT_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1038:6: ( 'EVENT_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1039:1: 'EVENT_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getEVENT_TYPEKeyword_28()); 
                    }
                    match(input,40,FollowSets000.FOLLOW_40_in_rule__SpecialId__Alternatives2262); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getEVENT_TYPEKeyword_28()); 
                    }

                    }


                    }
                    break;
                case 30 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1046:6: ( 'IPDU_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1046:6: ( 'IPDU_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1047:1: 'IPDU_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getIPDU_TYPEKeyword_29()); 
                    }
                    match(input,41,FollowSets000.FOLLOW_41_in_rule__SpecialId__Alternatives2282); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getIPDU_TYPEKeyword_29()); 
                    }

                    }


                    }
                    break;
                case 31 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1054:6: ( 'ISR_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1054:6: ( 'ISR_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1055:1: 'ISR_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getISR_TYPEKeyword_30()); 
                    }
                    match(input,42,FollowSets000.FOLLOW_42_in_rule__SpecialId__Alternatives2302); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getISR_TYPEKeyword_30()); 
                    }

                    }


                    }
                    break;
                case 32 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1062:6: ( 'MESSAGE_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1062:6: ( 'MESSAGE_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1063:1: 'MESSAGE_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getMESSAGE_TYPEKeyword_31()); 
                    }
                    match(input,43,FollowSets000.FOLLOW_43_in_rule__SpecialId__Alternatives2322); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getMESSAGE_TYPEKeyword_31()); 
                    }

                    }


                    }
                    break;
                case 33 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1070:6: ( 'NETWORKMESSAGE_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1070:6: ( 'NETWORKMESSAGE_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1071:1: 'NETWORKMESSAGE_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getNETWORKMESSAGE_TYPEKeyword_32()); 
                    }
                    match(input,44,FollowSets000.FOLLOW_44_in_rule__SpecialId__Alternatives2342); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getNETWORKMESSAGE_TYPEKeyword_32()); 
                    }

                    }


                    }
                    break;
                case 34 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1078:6: ( 'NM_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1078:6: ( 'NM_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1079:1: 'NM_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getNM_TYPEKeyword_33()); 
                    }
                    match(input,45,FollowSets000.FOLLOW_45_in_rule__SpecialId__Alternatives2362); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getNM_TYPEKeyword_33()); 
                    }

                    }


                    }
                    break;
                case 35 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1086:6: ( 'RESOURCE_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1086:6: ( 'RESOURCE_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1087:1: 'RESOURCE_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getRESOURCE_TYPEKeyword_34()); 
                    }
                    match(input,46,FollowSets000.FOLLOW_46_in_rule__SpecialId__Alternatives2382); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getRESOURCE_TYPEKeyword_34()); 
                    }

                    }


                    }
                    break;
                case 36 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1094:6: ( 'TASK_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1094:6: ( 'TASK_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1095:1: 'TASK_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getTASK_TYPEKeyword_35()); 
                    }
                    match(input,47,FollowSets000.FOLLOW_47_in_rule__SpecialId__Alternatives2402); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1107:1: rule__GenericValue__Alternatives : ( ( RULE_STRING ) | ( ruleINT ) | ( ruleDOUBLE ) );
    public final void rule__GenericValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1111:1: ( ( RULE_STRING ) | ( ruleINT ) | ( ruleDOUBLE ) )
            int alt13=3;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1112:1: ( RULE_STRING )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1112:1: ( RULE_STRING )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1113:1: RULE_STRING
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getGenericValueAccess().getSTRINGTerminalRuleCall_0()); 
                    }
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__GenericValue__Alternatives2436); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getGenericValueAccess().getSTRINGTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1118:6: ( ruleINT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1118:6: ( ruleINT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1119:1: ruleINT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getGenericValueAccess().getINTParserRuleCall_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleINT_in_rule__GenericValue__Alternatives2453);
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1124:6: ( ruleDOUBLE )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1124:6: ( ruleDOUBLE )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1125:1: ruleDOUBLE
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getGenericValueAccess().getDOUBLEParserRuleCall_2()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleDOUBLE_in_rule__GenericValue__Alternatives2470);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1135:1: rule__INT__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__INT__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1139:1: ( ( '+' ) | ( '-' ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==48) ) {
                alt14=1;
            }
            else if ( (LA14_0==49) ) {
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1140:1: ( '+' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1140:1: ( '+' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1141:1: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getINTAccess().getPlusSignKeyword_0_0()); 
                    }
                    match(input,48,FollowSets000.FOLLOW_48_in_rule__INT__Alternatives_02503); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getINTAccess().getPlusSignKeyword_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1148:6: ( '-' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1148:6: ( '-' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1149:1: '-'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getINTAccess().getHyphenMinusKeyword_0_1()); 
                    }
                    match(input,49,FollowSets000.FOLLOW_49_in_rule__INT__Alternatives_02523); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1161:1: rule__INT__Alternatives_1 : ( ( ( rule__INT__Group_1_0__0 ) ) | ( RULE_ZERO_INT ) | ( RULE_HEX ) );
    public final void rule__INT__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1165:1: ( ( ( rule__INT__Group_1_0__0 ) ) | ( RULE_ZERO_INT ) | ( RULE_HEX ) )
            int alt15=3;
            switch ( input.LA(1) ) {
            case RULE_NON_ZERO_INT:
                {
                alt15=1;
                }
                break;
            case RULE_ZERO_INT:
                {
                alt15=2;
                }
                break;
            case RULE_HEX:
                {
                alt15=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1166:1: ( ( rule__INT__Group_1_0__0 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1166:1: ( ( rule__INT__Group_1_0__0 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1167:1: ( rule__INT__Group_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getINTAccess().getGroup_1_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1168:1: ( rule__INT__Group_1_0__0 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1168:2: rule__INT__Group_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__INT__Group_1_0__0_in_rule__INT__Alternatives_12557);
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1172:6: ( RULE_ZERO_INT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1172:6: ( RULE_ZERO_INT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1173:1: RULE_ZERO_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getINTAccess().getZERO_INTTerminalRuleCall_1_1()); 
                    }
                    match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_rule__INT__Alternatives_12575); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getINTAccess().getZERO_INTTerminalRuleCall_1_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1178:6: ( RULE_HEX )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1178:6: ( RULE_HEX )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1179:1: RULE_HEX
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getINTAccess().getHEXTerminalRuleCall_1_2()); 
                    }
                    match(input,RULE_HEX,FollowSets000.FOLLOW_RULE_HEX_in_rule__INT__Alternatives_12592); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1189:1: rule__INT__Alternatives_1_0_1 : ( ( RULE_ZERO_INT ) | ( RULE_NON_ZERO_INT ) );
    public final void rule__INT__Alternatives_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1193:1: ( ( RULE_ZERO_INT ) | ( RULE_NON_ZERO_INT ) )
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1194:1: ( RULE_ZERO_INT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1194:1: ( RULE_ZERO_INT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1195:1: RULE_ZERO_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getINTAccess().getZERO_INTTerminalRuleCall_1_0_1_0()); 
                    }
                    match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_rule__INT__Alternatives_1_0_12624); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getINTAccess().getZERO_INTTerminalRuleCall_1_0_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1200:6: ( RULE_NON_ZERO_INT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1200:6: ( RULE_NON_ZERO_INT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1201:1: RULE_NON_ZERO_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getINTAccess().getNON_ZERO_INTTerminalRuleCall_1_0_1_1()); 
                    }
                    match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_rule__INT__Alternatives_1_0_12641); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1211:1: rule__DOUBLE__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__DOUBLE__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1215:1: ( ( '+' ) | ( '-' ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==48) ) {
                alt17=1;
            }
            else if ( (LA17_0==49) ) {
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1216:1: ( '+' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1216:1: ( '+' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1217:1: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDOUBLEAccess().getPlusSignKeyword_0_0()); 
                    }
                    match(input,48,FollowSets000.FOLLOW_48_in_rule__DOUBLE__Alternatives_02674); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDOUBLEAccess().getPlusSignKeyword_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1224:6: ( '-' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1224:6: ( '-' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1225:1: '-'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDOUBLEAccess().getHyphenMinusKeyword_0_1()); 
                    }
                    match(input,49,FollowSets000.FOLLOW_49_in_rule__DOUBLE__Alternatives_02694); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1237:1: rule__DOUBLE__Alternatives_1 : ( ( RULE_ZERO_INT ) | ( ( rule__DOUBLE__Group_1_1__0 ) ) );
    public final void rule__DOUBLE__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1241:1: ( ( RULE_ZERO_INT ) | ( ( rule__DOUBLE__Group_1_1__0 ) ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ZERO_INT) ) {
                alt18=1;
            }
            else if ( (LA18_0==RULE_NON_ZERO_INT) ) {
                alt18=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1242:1: ( RULE_ZERO_INT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1242:1: ( RULE_ZERO_INT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1243:1: RULE_ZERO_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDOUBLEAccess().getZERO_INTTerminalRuleCall_1_0()); 
                    }
                    match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_rule__DOUBLE__Alternatives_12728); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDOUBLEAccess().getZERO_INTTerminalRuleCall_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1248:6: ( ( rule__DOUBLE__Group_1_1__0 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1248:6: ( ( rule__DOUBLE__Group_1_1__0 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1249:1: ( rule__DOUBLE__Group_1_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDOUBLEAccess().getGroup_1_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1250:1: ( rule__DOUBLE__Group_1_1__0 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1250:2: rule__DOUBLE__Group_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Group_1_1__0_in_rule__DOUBLE__Alternatives_12745);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1259:1: rule__DOUBLE__Alternatives_1_1_1 : ( ( RULE_ZERO_INT ) | ( RULE_NON_ZERO_INT ) );
    public final void rule__DOUBLE__Alternatives_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1263:1: ( ( RULE_ZERO_INT ) | ( RULE_NON_ZERO_INT ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ZERO_INT) ) {
                alt19=1;
            }
            else if ( (LA19_0==RULE_NON_ZERO_INT) ) {
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1264:1: ( RULE_ZERO_INT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1264:1: ( RULE_ZERO_INT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1265:1: RULE_ZERO_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDOUBLEAccess().getZERO_INTTerminalRuleCall_1_1_1_0()); 
                    }
                    match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_rule__DOUBLE__Alternatives_1_1_12778); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDOUBLEAccess().getZERO_INTTerminalRuleCall_1_1_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1270:6: ( RULE_NON_ZERO_INT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1270:6: ( RULE_NON_ZERO_INT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1271:1: RULE_NON_ZERO_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDOUBLEAccess().getNON_ZERO_INTTerminalRuleCall_1_1_1_1()); 
                    }
                    match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_rule__DOUBLE__Alternatives_1_1_12795); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1281:1: rule__DOUBLE__Alternatives_3 : ( ( RULE_ZERO_INT ) | ( RULE_NON_ZERO_INT ) );
    public final void rule__DOUBLE__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1285:1: ( ( RULE_ZERO_INT ) | ( RULE_NON_ZERO_INT ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ZERO_INT) ) {
                alt20=1;
            }
            else if ( (LA20_0==RULE_NON_ZERO_INT) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1286:1: ( RULE_ZERO_INT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1286:1: ( RULE_ZERO_INT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1287:1: RULE_ZERO_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDOUBLEAccess().getZERO_INTTerminalRuleCall_3_0()); 
                    }
                    match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_rule__DOUBLE__Alternatives_32827); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDOUBLEAccess().getZERO_INTTerminalRuleCall_3_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1292:6: ( RULE_NON_ZERO_INT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1292:6: ( RULE_NON_ZERO_INT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1293:1: RULE_NON_ZERO_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDOUBLEAccess().getNON_ZERO_INTTerminalRuleCall_3_1()); 
                    }
                    match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_rule__DOUBLE__Alternatives_32844); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1303:1: rule__VType__Alternatives : ( ( ( 'STRING' ) ) | ( ( 'UINT32' ) ) | ( ( 'INT32' ) ) | ( ( 'UINT64' ) ) | ( ( 'INT64' ) ) | ( ( 'FLOAT' ) ) | ( ( 'DOUBLE' ) ) );
    public final void rule__VType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1307:1: ( ( ( 'STRING' ) ) | ( ( 'UINT32' ) ) | ( ( 'INT32' ) ) | ( ( 'UINT64' ) ) | ( ( 'INT64' ) ) | ( ( 'FLOAT' ) ) | ( ( 'DOUBLE' ) ) )
            int alt21=7;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt21=1;
                }
                break;
            case 14:
                {
                alt21=2;
                }
                break;
            case 15:
                {
                alt21=3;
                }
                break;
            case 16:
                {
                alt21=4;
                }
                break;
            case 17:
                {
                alt21=5;
                }
                break;
            case 18:
                {
                alt21=6;
                }
                break;
            case 19:
                {
                alt21=7;
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1308:1: ( ( 'STRING' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1308:1: ( ( 'STRING' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1309:1: ( 'STRING' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVTypeAccess().getSTRINGEnumLiteralDeclaration_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1310:1: ( 'STRING' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1310:3: 'STRING'
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__VType__Alternatives2877); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVTypeAccess().getSTRINGEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1315:6: ( ( 'UINT32' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1315:6: ( ( 'UINT32' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1316:1: ( 'UINT32' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVTypeAccess().getUINT32EnumLiteralDeclaration_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1317:1: ( 'UINT32' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1317:3: 'UINT32'
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_rule__VType__Alternatives2898); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVTypeAccess().getUINT32EnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1322:6: ( ( 'INT32' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1322:6: ( ( 'INT32' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1323:1: ( 'INT32' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVTypeAccess().getINT32EnumLiteralDeclaration_2()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1324:1: ( 'INT32' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1324:3: 'INT32'
                    {
                    match(input,15,FollowSets000.FOLLOW_15_in_rule__VType__Alternatives2919); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVTypeAccess().getINT32EnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1329:6: ( ( 'UINT64' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1329:6: ( ( 'UINT64' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1330:1: ( 'UINT64' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVTypeAccess().getUINT64EnumLiteralDeclaration_3()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1331:1: ( 'UINT64' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1331:3: 'UINT64'
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__VType__Alternatives2940); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVTypeAccess().getUINT64EnumLiteralDeclaration_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1336:6: ( ( 'INT64' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1336:6: ( ( 'INT64' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1337:1: ( 'INT64' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVTypeAccess().getINT64EnumLiteralDeclaration_4()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1338:1: ( 'INT64' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1338:3: 'INT64'
                    {
                    match(input,17,FollowSets000.FOLLOW_17_in_rule__VType__Alternatives2961); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVTypeAccess().getINT64EnumLiteralDeclaration_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1343:6: ( ( 'FLOAT' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1343:6: ( ( 'FLOAT' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1344:1: ( 'FLOAT' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVTypeAccess().getFLOATEnumLiteralDeclaration_5()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1345:1: ( 'FLOAT' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1345:3: 'FLOAT'
                    {
                    match(input,18,FollowSets000.FOLLOW_18_in_rule__VType__Alternatives2982); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVTypeAccess().getFLOATEnumLiteralDeclaration_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1350:6: ( ( 'DOUBLE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1350:6: ( ( 'DOUBLE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1351:1: ( 'DOUBLE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVTypeAccess().getDOUBLEEnumLiteralDeclaration_6()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1352:1: ( 'DOUBLE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1352:3: 'DOUBLE'
                    {
                    match(input,19,FollowSets000.FOLLOW_19_in_rule__VType__Alternatives3003); if (state.failed) return ;

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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1362:1: rule__EType__Alternatives : ( ( ( 'BOOLEAN' ) ) | ( ( 'ENUM' ) ) );
    public final void rule__EType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1366:1: ( ( ( 'BOOLEAN' ) ) | ( ( 'ENUM' ) ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==20) ) {
                alt22=1;
            }
            else if ( (LA22_0==21) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1367:1: ( ( 'BOOLEAN' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1367:1: ( ( 'BOOLEAN' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1368:1: ( 'BOOLEAN' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getETypeAccess().getBOOLEANEnumLiteralDeclaration_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1369:1: ( 'BOOLEAN' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1369:3: 'BOOLEAN'
                    {
                    match(input,20,FollowSets000.FOLLOW_20_in_rule__EType__Alternatives3039); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getETypeAccess().getBOOLEANEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1374:6: ( ( 'ENUM' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1374:6: ( ( 'ENUM' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1375:1: ( 'ENUM' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getETypeAccess().getENUMEnumLiteralDeclaration_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1376:1: ( 'ENUM' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1376:3: 'ENUM'
                    {
                    match(input,21,FollowSets000.FOLLOW_21_in_rule__EType__Alternatives3060); if (state.failed) return ;

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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1386:1: rule__ObjectType__Alternatives : ( ( ( 'OS' ) ) | ( ( 'ALARM' ) ) | ( ( 'APPMODE' ) ) | ( ( 'COUNTER' ) ) | ( ( 'COM' ) ) | ( ( 'EVENT' ) ) | ( ( 'IPDU' ) ) | ( ( 'ISR' ) ) | ( ( 'MESSAGE' ) ) | ( ( 'NETWORKMESSAGE' ) ) | ( ( 'NM' ) ) | ( ( 'RESOURCE' ) ) | ( ( 'TASK' ) ) | ( ( 'APPLICATION' ) ) );
    public final void rule__ObjectType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1390:1: ( ( ( 'OS' ) ) | ( ( 'ALARM' ) ) | ( ( 'APPMODE' ) ) | ( ( 'COUNTER' ) ) | ( ( 'COM' ) ) | ( ( 'EVENT' ) ) | ( ( 'IPDU' ) ) | ( ( 'ISR' ) ) | ( ( 'MESSAGE' ) ) | ( ( 'NETWORKMESSAGE' ) ) | ( ( 'NM' ) ) | ( ( 'RESOURCE' ) ) | ( ( 'TASK' ) ) | ( ( 'APPLICATION' ) ) )
            int alt23=14;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt23=1;
                }
                break;
            case 23:
                {
                alt23=2;
                }
                break;
            case 24:
                {
                alt23=3;
                }
                break;
            case 25:
                {
                alt23=4;
                }
                break;
            case 26:
                {
                alt23=5;
                }
                break;
            case 27:
                {
                alt23=6;
                }
                break;
            case 28:
                {
                alt23=7;
                }
                break;
            case 29:
                {
                alt23=8;
                }
                break;
            case 30:
                {
                alt23=9;
                }
                break;
            case 31:
                {
                alt23=10;
                }
                break;
            case 32:
                {
                alt23=11;
                }
                break;
            case 33:
                {
                alt23=12;
                }
                break;
            case 34:
                {
                alt23=13;
                }
                break;
            case 50:
                {
                alt23=14;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1391:1: ( ( 'OS' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1391:1: ( ( 'OS' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1392:1: ( 'OS' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getOSEnumLiteralDeclaration_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1393:1: ( 'OS' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1393:3: 'OS'
                    {
                    match(input,22,FollowSets000.FOLLOW_22_in_rule__ObjectType__Alternatives3096); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getOSEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1398:6: ( ( 'ALARM' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1398:6: ( ( 'ALARM' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1399:1: ( 'ALARM' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getALARMEnumLiteralDeclaration_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1400:1: ( 'ALARM' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1400:3: 'ALARM'
                    {
                    match(input,23,FollowSets000.FOLLOW_23_in_rule__ObjectType__Alternatives3117); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getALARMEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1405:6: ( ( 'APPMODE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1405:6: ( ( 'APPMODE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1406:1: ( 'APPMODE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getAPPMODEEnumLiteralDeclaration_2()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1407:1: ( 'APPMODE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1407:3: 'APPMODE'
                    {
                    match(input,24,FollowSets000.FOLLOW_24_in_rule__ObjectType__Alternatives3138); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getAPPMODEEnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1412:6: ( ( 'COUNTER' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1412:6: ( ( 'COUNTER' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1413:1: ( 'COUNTER' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getCOUNTEREnumLiteralDeclaration_3()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1414:1: ( 'COUNTER' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1414:3: 'COUNTER'
                    {
                    match(input,25,FollowSets000.FOLLOW_25_in_rule__ObjectType__Alternatives3159); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getCOUNTEREnumLiteralDeclaration_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1419:6: ( ( 'COM' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1419:6: ( ( 'COM' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1420:1: ( 'COM' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getCOMEnumLiteralDeclaration_4()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1421:1: ( 'COM' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1421:3: 'COM'
                    {
                    match(input,26,FollowSets000.FOLLOW_26_in_rule__ObjectType__Alternatives3180); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getCOMEnumLiteralDeclaration_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1426:6: ( ( 'EVENT' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1426:6: ( ( 'EVENT' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1427:1: ( 'EVENT' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getEVENTEnumLiteralDeclaration_5()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1428:1: ( 'EVENT' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1428:3: 'EVENT'
                    {
                    match(input,27,FollowSets000.FOLLOW_27_in_rule__ObjectType__Alternatives3201); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getEVENTEnumLiteralDeclaration_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1433:6: ( ( 'IPDU' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1433:6: ( ( 'IPDU' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1434:1: ( 'IPDU' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getIPDUEnumLiteralDeclaration_6()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1435:1: ( 'IPDU' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1435:3: 'IPDU'
                    {
                    match(input,28,FollowSets000.FOLLOW_28_in_rule__ObjectType__Alternatives3222); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getIPDUEnumLiteralDeclaration_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1440:6: ( ( 'ISR' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1440:6: ( ( 'ISR' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1441:1: ( 'ISR' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getISREnumLiteralDeclaration_7()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1442:1: ( 'ISR' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1442:3: 'ISR'
                    {
                    match(input,29,FollowSets000.FOLLOW_29_in_rule__ObjectType__Alternatives3243); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getISREnumLiteralDeclaration_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1447:6: ( ( 'MESSAGE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1447:6: ( ( 'MESSAGE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1448:1: ( 'MESSAGE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getMESSAGEEnumLiteralDeclaration_8()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1449:1: ( 'MESSAGE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1449:3: 'MESSAGE'
                    {
                    match(input,30,FollowSets000.FOLLOW_30_in_rule__ObjectType__Alternatives3264); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getMESSAGEEnumLiteralDeclaration_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1454:6: ( ( 'NETWORKMESSAGE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1454:6: ( ( 'NETWORKMESSAGE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1455:1: ( 'NETWORKMESSAGE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getNETWORKMESSAGEEnumLiteralDeclaration_9()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1456:1: ( 'NETWORKMESSAGE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1456:3: 'NETWORKMESSAGE'
                    {
                    match(input,31,FollowSets000.FOLLOW_31_in_rule__ObjectType__Alternatives3285); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getNETWORKMESSAGEEnumLiteralDeclaration_9()); 
                    }

                    }


                    }
                    break;
                case 11 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1461:6: ( ( 'NM' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1461:6: ( ( 'NM' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1462:1: ( 'NM' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getNMEnumLiteralDeclaration_10()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1463:1: ( 'NM' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1463:3: 'NM'
                    {
                    match(input,32,FollowSets000.FOLLOW_32_in_rule__ObjectType__Alternatives3306); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getNMEnumLiteralDeclaration_10()); 
                    }

                    }


                    }
                    break;
                case 12 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1468:6: ( ( 'RESOURCE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1468:6: ( ( 'RESOURCE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1469:1: ( 'RESOURCE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getRESOURCEEnumLiteralDeclaration_11()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1470:1: ( 'RESOURCE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1470:3: 'RESOURCE'
                    {
                    match(input,33,FollowSets000.FOLLOW_33_in_rule__ObjectType__Alternatives3327); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getRESOURCEEnumLiteralDeclaration_11()); 
                    }

                    }


                    }
                    break;
                case 13 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1475:6: ( ( 'TASK' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1475:6: ( ( 'TASK' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1476:1: ( 'TASK' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getTASKEnumLiteralDeclaration_12()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1477:1: ( 'TASK' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1477:3: 'TASK'
                    {
                    match(input,34,FollowSets000.FOLLOW_34_in_rule__ObjectType__Alternatives3348); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getTASKEnumLiteralDeclaration_12()); 
                    }

                    }


                    }
                    break;
                case 14 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1482:6: ( ( 'APPLICATION' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1482:6: ( ( 'APPLICATION' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1483:1: ( 'APPLICATION' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getAPPLICATIONEnumLiteralDeclaration_13()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1484:1: ( 'APPLICATION' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1484:3: 'APPLICATION'
                    {
                    match(input,50,FollowSets000.FOLLOW_50_in_rule__ObjectType__Alternatives3369); if (state.failed) return ;

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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1494:1: rule__ObjectTypeRef__Alternatives : ( ( ( 'OS_TYPE' ) ) | ( ( 'ALARM_TYPE' ) ) | ( ( 'APPMODE_TYPE' ) ) | ( ( 'COUNTER_TYPE' ) ) | ( ( 'COM_TYPE' ) ) | ( ( 'EVENT_TYPE' ) ) | ( ( 'IPDU_TYPE' ) ) | ( ( 'ISR_TYPE' ) ) | ( ( 'MESSAGE_TYPE' ) ) | ( ( 'NETWORKMESSAGE_TYPE' ) ) | ( ( 'NM_TYPE' ) ) | ( ( 'RESOURCE_TYPE' ) ) | ( ( 'TASK_TYPE' ) ) | ( ( 'APPLICATION_TYPE' ) ) );
    public final void rule__ObjectTypeRef__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1498:1: ( ( ( 'OS_TYPE' ) ) | ( ( 'ALARM_TYPE' ) ) | ( ( 'APPMODE_TYPE' ) ) | ( ( 'COUNTER_TYPE' ) ) | ( ( 'COM_TYPE' ) ) | ( ( 'EVENT_TYPE' ) ) | ( ( 'IPDU_TYPE' ) ) | ( ( 'ISR_TYPE' ) ) | ( ( 'MESSAGE_TYPE' ) ) | ( ( 'NETWORKMESSAGE_TYPE' ) ) | ( ( 'NM_TYPE' ) ) | ( ( 'RESOURCE_TYPE' ) ) | ( ( 'TASK_TYPE' ) ) | ( ( 'APPLICATION_TYPE' ) ) )
            int alt24=14;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt24=1;
                }
                break;
            case 36:
                {
                alt24=2;
                }
                break;
            case 37:
                {
                alt24=3;
                }
                break;
            case 38:
                {
                alt24=4;
                }
                break;
            case 39:
                {
                alt24=5;
                }
                break;
            case 40:
                {
                alt24=6;
                }
                break;
            case 41:
                {
                alt24=7;
                }
                break;
            case 42:
                {
                alt24=8;
                }
                break;
            case 43:
                {
                alt24=9;
                }
                break;
            case 44:
                {
                alt24=10;
                }
                break;
            case 45:
                {
                alt24=11;
                }
                break;
            case 46:
                {
                alt24=12;
                }
                break;
            case 47:
                {
                alt24=13;
                }
                break;
            case 51:
                {
                alt24=14;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1499:1: ( ( 'OS_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1499:1: ( ( 'OS_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1500:1: ( 'OS_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getOSEnumLiteralDeclaration_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1501:1: ( 'OS_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1501:3: 'OS_TYPE'
                    {
                    match(input,35,FollowSets000.FOLLOW_35_in_rule__ObjectTypeRef__Alternatives3405); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getOSEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1506:6: ( ( 'ALARM_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1506:6: ( ( 'ALARM_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1507:1: ( 'ALARM_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getALARMEnumLiteralDeclaration_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1508:1: ( 'ALARM_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1508:3: 'ALARM_TYPE'
                    {
                    match(input,36,FollowSets000.FOLLOW_36_in_rule__ObjectTypeRef__Alternatives3426); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getALARMEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1513:6: ( ( 'APPMODE_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1513:6: ( ( 'APPMODE_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1514:1: ( 'APPMODE_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getAPPMODEEnumLiteralDeclaration_2()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1515:1: ( 'APPMODE_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1515:3: 'APPMODE_TYPE'
                    {
                    match(input,37,FollowSets000.FOLLOW_37_in_rule__ObjectTypeRef__Alternatives3447); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getAPPMODEEnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1520:6: ( ( 'COUNTER_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1520:6: ( ( 'COUNTER_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1521:1: ( 'COUNTER_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getCOUNTEREnumLiteralDeclaration_3()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1522:1: ( 'COUNTER_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1522:3: 'COUNTER_TYPE'
                    {
                    match(input,38,FollowSets000.FOLLOW_38_in_rule__ObjectTypeRef__Alternatives3468); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getCOUNTEREnumLiteralDeclaration_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1527:6: ( ( 'COM_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1527:6: ( ( 'COM_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1528:1: ( 'COM_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getCOMEnumLiteralDeclaration_4()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1529:1: ( 'COM_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1529:3: 'COM_TYPE'
                    {
                    match(input,39,FollowSets000.FOLLOW_39_in_rule__ObjectTypeRef__Alternatives3489); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getCOMEnumLiteralDeclaration_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1534:6: ( ( 'EVENT_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1534:6: ( ( 'EVENT_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1535:1: ( 'EVENT_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getEVENTEnumLiteralDeclaration_5()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1536:1: ( 'EVENT_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1536:3: 'EVENT_TYPE'
                    {
                    match(input,40,FollowSets000.FOLLOW_40_in_rule__ObjectTypeRef__Alternatives3510); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getEVENTEnumLiteralDeclaration_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1541:6: ( ( 'IPDU_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1541:6: ( ( 'IPDU_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1542:1: ( 'IPDU_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getIPDUEnumLiteralDeclaration_6()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1543:1: ( 'IPDU_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1543:3: 'IPDU_TYPE'
                    {
                    match(input,41,FollowSets000.FOLLOW_41_in_rule__ObjectTypeRef__Alternatives3531); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getIPDUEnumLiteralDeclaration_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1548:6: ( ( 'ISR_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1548:6: ( ( 'ISR_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1549:1: ( 'ISR_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getISREnumLiteralDeclaration_7()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1550:1: ( 'ISR_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1550:3: 'ISR_TYPE'
                    {
                    match(input,42,FollowSets000.FOLLOW_42_in_rule__ObjectTypeRef__Alternatives3552); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getISREnumLiteralDeclaration_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1555:6: ( ( 'MESSAGE_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1555:6: ( ( 'MESSAGE_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1556:1: ( 'MESSAGE_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getMESSAGEEnumLiteralDeclaration_8()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1557:1: ( 'MESSAGE_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1557:3: 'MESSAGE_TYPE'
                    {
                    match(input,43,FollowSets000.FOLLOW_43_in_rule__ObjectTypeRef__Alternatives3573); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getMESSAGEEnumLiteralDeclaration_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1562:6: ( ( 'NETWORKMESSAGE_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1562:6: ( ( 'NETWORKMESSAGE_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1563:1: ( 'NETWORKMESSAGE_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getNETWORKMESSAGEEnumLiteralDeclaration_9()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1564:1: ( 'NETWORKMESSAGE_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1564:3: 'NETWORKMESSAGE_TYPE'
                    {
                    match(input,44,FollowSets000.FOLLOW_44_in_rule__ObjectTypeRef__Alternatives3594); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getNETWORKMESSAGEEnumLiteralDeclaration_9()); 
                    }

                    }


                    }
                    break;
                case 11 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1569:6: ( ( 'NM_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1569:6: ( ( 'NM_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1570:1: ( 'NM_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getNMEnumLiteralDeclaration_10()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1571:1: ( 'NM_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1571:3: 'NM_TYPE'
                    {
                    match(input,45,FollowSets000.FOLLOW_45_in_rule__ObjectTypeRef__Alternatives3615); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getNMEnumLiteralDeclaration_10()); 
                    }

                    }


                    }
                    break;
                case 12 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1576:6: ( ( 'RESOURCE_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1576:6: ( ( 'RESOURCE_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1577:1: ( 'RESOURCE_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getRESOURCEEnumLiteralDeclaration_11()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1578:1: ( 'RESOURCE_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1578:3: 'RESOURCE_TYPE'
                    {
                    match(input,46,FollowSets000.FOLLOW_46_in_rule__ObjectTypeRef__Alternatives3636); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getRESOURCEEnumLiteralDeclaration_11()); 
                    }

                    }


                    }
                    break;
                case 13 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1583:6: ( ( 'TASK_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1583:6: ( ( 'TASK_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1584:1: ( 'TASK_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getTASKEnumLiteralDeclaration_12()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1585:1: ( 'TASK_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1585:3: 'TASK_TYPE'
                    {
                    match(input,47,FollowSets000.FOLLOW_47_in_rule__ObjectTypeRef__Alternatives3657); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getTASKEnumLiteralDeclaration_12()); 
                    }

                    }


                    }
                    break;
                case 14 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1590:6: ( ( 'APPLICATION_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1590:6: ( ( 'APPLICATION_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1591:1: ( 'APPLICATION_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getAPPLICATIONEnumLiteralDeclaration_13()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1592:1: ( 'APPLICATION_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1592:3: 'APPLICATION_TYPE'
                    {
                    match(input,51,FollowSets000.FOLLOW_51_in_rule__ObjectTypeRef__Alternatives3678); if (state.failed) return ;

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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1604:1: rule__OilFile__Group__0 : rule__OilFile__Group__0__Impl rule__OilFile__Group__1 ;
    public final void rule__OilFile__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1608:1: ( rule__OilFile__Group__0__Impl rule__OilFile__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1609:2: rule__OilFile__Group__0__Impl rule__OilFile__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group__0__Impl_in_rule__OilFile__Group__03711);
            rule__OilFile__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group__1_in_rule__OilFile__Group__03714);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1616:1: rule__OilFile__Group__0__Impl : ( () ) ;
    public final void rule__OilFile__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1620:1: ( ( () ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1621:1: ( () )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1621:1: ( () )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1622:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getOilFileAction_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1623:1: ()
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1625:1: 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1635:1: rule__OilFile__Group__1 : rule__OilFile__Group__1__Impl rule__OilFile__Group__2 ;
    public final void rule__OilFile__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1639:1: ( rule__OilFile__Group__1__Impl rule__OilFile__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1640:2: rule__OilFile__Group__1__Impl rule__OilFile__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group__1__Impl_in_rule__OilFile__Group__13772);
            rule__OilFile__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group__2_in_rule__OilFile__Group__13775);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1647:1: rule__OilFile__Group__1__Impl : ( ( rule__OilFile__Group_1__0 )? ) ;
    public final void rule__OilFile__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1651:1: ( ( ( rule__OilFile__Group_1__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1652:1: ( ( rule__OilFile__Group_1__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1652:1: ( ( rule__OilFile__Group_1__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1653:1: ( rule__OilFile__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getGroup_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1654:1: ( rule__OilFile__Group_1__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==52) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1654:2: rule__OilFile__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group_1__0_in_rule__OilFile__Group__1__Impl3802);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1664:1: rule__OilFile__Group__2 : rule__OilFile__Group__2__Impl rule__OilFile__Group__3 ;
    public final void rule__OilFile__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1668:1: ( rule__OilFile__Group__2__Impl rule__OilFile__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1669:2: rule__OilFile__Group__2__Impl rule__OilFile__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group__2__Impl_in_rule__OilFile__Group__23833);
            rule__OilFile__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group__3_in_rule__OilFile__Group__23836);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1676:1: rule__OilFile__Group__2__Impl : ( ( rule__OilFile__ImplementationAssignment_2 )? ) ;
    public final void rule__OilFile__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1680:1: ( ( ( rule__OilFile__ImplementationAssignment_2 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1681:1: ( ( rule__OilFile__ImplementationAssignment_2 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1681:1: ( ( rule__OilFile__ImplementationAssignment_2 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1682:1: ( rule__OilFile__ImplementationAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getImplementationAssignment_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1683:1: ( rule__OilFile__ImplementationAssignment_2 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==55) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1683:2: rule__OilFile__ImplementationAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__OilFile__ImplementationAssignment_2_in_rule__OilFile__Group__2__Impl3863);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1693:1: rule__OilFile__Group__3 : rule__OilFile__Group__3__Impl ;
    public final void rule__OilFile__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1697:1: ( rule__OilFile__Group__3__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1698:2: rule__OilFile__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group__3__Impl_in_rule__OilFile__Group__33894);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1704:1: rule__OilFile__Group__3__Impl : ( ( rule__OilFile__ApplicationAssignment_3 )? ) ;
    public final void rule__OilFile__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1708:1: ( ( ( rule__OilFile__ApplicationAssignment_3 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1709:1: ( ( rule__OilFile__ApplicationAssignment_3 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1709:1: ( ( rule__OilFile__ApplicationAssignment_3 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1710:1: ( rule__OilFile__ApplicationAssignment_3 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getApplicationAssignment_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1711:1: ( rule__OilFile__ApplicationAssignment_3 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==59) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1711:2: rule__OilFile__ApplicationAssignment_3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__OilFile__ApplicationAssignment_3_in_rule__OilFile__Group__3__Impl3921);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1729:1: rule__OilFile__Group_1__0 : rule__OilFile__Group_1__0__Impl rule__OilFile__Group_1__1 ;
    public final void rule__OilFile__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1733:1: ( rule__OilFile__Group_1__0__Impl rule__OilFile__Group_1__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1734:2: rule__OilFile__Group_1__0__Impl rule__OilFile__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group_1__0__Impl_in_rule__OilFile__Group_1__03960);
            rule__OilFile__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group_1__1_in_rule__OilFile__Group_1__03963);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1741:1: rule__OilFile__Group_1__0__Impl : ( 'OIL_VERSION' ) ;
    public final void rule__OilFile__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1745:1: ( ( 'OIL_VERSION' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1746:1: ( 'OIL_VERSION' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1746:1: ( 'OIL_VERSION' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1747:1: 'OIL_VERSION'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getOIL_VERSIONKeyword_1_0()); 
            }
            match(input,52,FollowSets000.FOLLOW_52_in_rule__OilFile__Group_1__0__Impl3991); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1760:1: rule__OilFile__Group_1__1 : rule__OilFile__Group_1__1__Impl rule__OilFile__Group_1__2 ;
    public final void rule__OilFile__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1764:1: ( rule__OilFile__Group_1__1__Impl rule__OilFile__Group_1__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1765:2: rule__OilFile__Group_1__1__Impl rule__OilFile__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group_1__1__Impl_in_rule__OilFile__Group_1__14022);
            rule__OilFile__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group_1__2_in_rule__OilFile__Group_1__14025);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1772:1: rule__OilFile__Group_1__1__Impl : ( '=' ) ;
    public final void rule__OilFile__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1776:1: ( ( '=' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1777:1: ( '=' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1777:1: ( '=' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1778:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getEqualsSignKeyword_1_1()); 
            }
            match(input,53,FollowSets000.FOLLOW_53_in_rule__OilFile__Group_1__1__Impl4053); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1791:1: rule__OilFile__Group_1__2 : rule__OilFile__Group_1__2__Impl rule__OilFile__Group_1__3 ;
    public final void rule__OilFile__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1795:1: ( rule__OilFile__Group_1__2__Impl rule__OilFile__Group_1__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1796:2: rule__OilFile__Group_1__2__Impl rule__OilFile__Group_1__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group_1__2__Impl_in_rule__OilFile__Group_1__24084);
            rule__OilFile__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group_1__3_in_rule__OilFile__Group_1__24087);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1803:1: rule__OilFile__Group_1__2__Impl : ( ( rule__OilFile__OilVersionAssignment_1_2 ) ) ;
    public final void rule__OilFile__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1807:1: ( ( ( rule__OilFile__OilVersionAssignment_1_2 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1808:1: ( ( rule__OilFile__OilVersionAssignment_1_2 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1808:1: ( ( rule__OilFile__OilVersionAssignment_1_2 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1809:1: ( rule__OilFile__OilVersionAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getOilVersionAssignment_1_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1810:1: ( rule__OilFile__OilVersionAssignment_1_2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1810:2: rule__OilFile__OilVersionAssignment_1_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__OilVersionAssignment_1_2_in_rule__OilFile__Group_1__2__Impl4114);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1820:1: rule__OilFile__Group_1__3 : rule__OilFile__Group_1__3__Impl ;
    public final void rule__OilFile__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1824:1: ( rule__OilFile__Group_1__3__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1825:2: rule__OilFile__Group_1__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group_1__3__Impl_in_rule__OilFile__Group_1__34144);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1831:1: rule__OilFile__Group_1__3__Impl : ( ';' ) ;
    public final void rule__OilFile__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1835:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1836:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1836:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1837:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getSemicolonKeyword_1_3()); 
            }
            match(input,54,FollowSets000.FOLLOW_54_in_rule__OilFile__Group_1__3__Impl4172); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1858:1: rule__OilImplementation__Group__0 : rule__OilImplementation__Group__0__Impl rule__OilImplementation__Group__1 ;
    public final void rule__OilImplementation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1862:1: ( rule__OilImplementation__Group__0__Impl rule__OilImplementation__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1863:2: rule__OilImplementation__Group__0__Impl rule__OilImplementation__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__0__Impl_in_rule__OilImplementation__Group__04211);
            rule__OilImplementation__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__1_in_rule__OilImplementation__Group__04214);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1870:1: rule__OilImplementation__Group__0__Impl : ( 'IMPLEMENTATION' ) ;
    public final void rule__OilImplementation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1874:1: ( ( 'IMPLEMENTATION' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1875:1: ( 'IMPLEMENTATION' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1875:1: ( 'IMPLEMENTATION' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1876:1: 'IMPLEMENTATION'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getIMPLEMENTATIONKeyword_0()); 
            }
            match(input,55,FollowSets000.FOLLOW_55_in_rule__OilImplementation__Group__0__Impl4242); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1889:1: rule__OilImplementation__Group__1 : rule__OilImplementation__Group__1__Impl rule__OilImplementation__Group__2 ;
    public final void rule__OilImplementation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1893:1: ( rule__OilImplementation__Group__1__Impl rule__OilImplementation__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1894:2: rule__OilImplementation__Group__1__Impl rule__OilImplementation__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__1__Impl_in_rule__OilImplementation__Group__14273);
            rule__OilImplementation__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__2_in_rule__OilImplementation__Group__14276);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1901:1: rule__OilImplementation__Group__1__Impl : ( ( rule__OilImplementation__NameAssignment_1 ) ) ;
    public final void rule__OilImplementation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1905:1: ( ( ( rule__OilImplementation__NameAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1906:1: ( ( rule__OilImplementation__NameAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1906:1: ( ( rule__OilImplementation__NameAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1907:1: ( rule__OilImplementation__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getNameAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1908:1: ( rule__OilImplementation__NameAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1908:2: rule__OilImplementation__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__NameAssignment_1_in_rule__OilImplementation__Group__1__Impl4303);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1918:1: rule__OilImplementation__Group__2 : rule__OilImplementation__Group__2__Impl rule__OilImplementation__Group__3 ;
    public final void rule__OilImplementation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1922:1: ( rule__OilImplementation__Group__2__Impl rule__OilImplementation__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1923:2: rule__OilImplementation__Group__2__Impl rule__OilImplementation__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__2__Impl_in_rule__OilImplementation__Group__24333);
            rule__OilImplementation__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__3_in_rule__OilImplementation__Group__24336);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1930:1: rule__OilImplementation__Group__2__Impl : ( '{' ) ;
    public final void rule__OilImplementation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1934:1: ( ( '{' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1935:1: ( '{' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1935:1: ( '{' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1936:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,56,FollowSets000.FOLLOW_56_in_rule__OilImplementation__Group__2__Impl4364); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1949:1: rule__OilImplementation__Group__3 : rule__OilImplementation__Group__3__Impl rule__OilImplementation__Group__4 ;
    public final void rule__OilImplementation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1953:1: ( rule__OilImplementation__Group__3__Impl rule__OilImplementation__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1954:2: rule__OilImplementation__Group__3__Impl rule__OilImplementation__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__3__Impl_in_rule__OilImplementation__Group__34395);
            rule__OilImplementation__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__4_in_rule__OilImplementation__Group__34398);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1961:1: rule__OilImplementation__Group__3__Impl : ( ( rule__OilImplementation__OilObjectsAssignment_3 )* ) ;
    public final void rule__OilImplementation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1965:1: ( ( ( rule__OilImplementation__OilObjectsAssignment_3 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1966:1: ( ( rule__OilImplementation__OilObjectsAssignment_3 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1966:1: ( ( rule__OilImplementation__OilObjectsAssignment_3 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1967:1: ( rule__OilImplementation__OilObjectsAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getOilObjectsAssignment_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1968:1: ( rule__OilImplementation__OilObjectsAssignment_3 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>=22 && LA28_0<=34)||LA28_0==50) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1968:2: rule__OilImplementation__OilObjectsAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__OilObjectsAssignment_3_in_rule__OilImplementation__Group__3__Impl4425);
            	    rule__OilImplementation__OilObjectsAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop28;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1978:1: rule__OilImplementation__Group__4 : rule__OilImplementation__Group__4__Impl rule__OilImplementation__Group__5 ;
    public final void rule__OilImplementation__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1982:1: ( rule__OilImplementation__Group__4__Impl rule__OilImplementation__Group__5 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1983:2: rule__OilImplementation__Group__4__Impl rule__OilImplementation__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__4__Impl_in_rule__OilImplementation__Group__44456);
            rule__OilImplementation__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__5_in_rule__OilImplementation__Group__44459);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1990:1: rule__OilImplementation__Group__4__Impl : ( '}' ) ;
    public final void rule__OilImplementation__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1994:1: ( ( '}' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1995:1: ( '}' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1995:1: ( '}' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1996:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,57,FollowSets000.FOLLOW_57_in_rule__OilImplementation__Group__4__Impl4487); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2009:1: rule__OilImplementation__Group__5 : rule__OilImplementation__Group__5__Impl ;
    public final void rule__OilImplementation__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2013:1: ( rule__OilImplementation__Group__5__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2014:2: rule__OilImplementation__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__5__Impl_in_rule__OilImplementation__Group__54518);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2020:1: rule__OilImplementation__Group__5__Impl : ( ';' ) ;
    public final void rule__OilImplementation__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2024:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2025:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2025:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2026:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getSemicolonKeyword_5()); 
            }
            match(input,54,FollowSets000.FOLLOW_54_in_rule__OilImplementation__Group__5__Impl4546); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2051:1: rule__OilObjectImpl__Group__0 : rule__OilObjectImpl__Group__0__Impl rule__OilObjectImpl__Group__1 ;
    public final void rule__OilObjectImpl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2055:1: ( rule__OilObjectImpl__Group__0__Impl rule__OilObjectImpl__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2056:2: rule__OilObjectImpl__Group__0__Impl rule__OilObjectImpl__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__0__Impl_in_rule__OilObjectImpl__Group__04589);
            rule__OilObjectImpl__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__1_in_rule__OilObjectImpl__Group__04592);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2063:1: rule__OilObjectImpl__Group__0__Impl : ( ( rule__OilObjectImpl__TypeAssignment_0 ) ) ;
    public final void rule__OilObjectImpl__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2067:1: ( ( ( rule__OilObjectImpl__TypeAssignment_0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2068:1: ( ( rule__OilObjectImpl__TypeAssignment_0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2068:1: ( ( rule__OilObjectImpl__TypeAssignment_0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2069:1: ( rule__OilObjectImpl__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getTypeAssignment_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2070:1: ( rule__OilObjectImpl__TypeAssignment_0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2070:2: rule__OilObjectImpl__TypeAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__TypeAssignment_0_in_rule__OilObjectImpl__Group__0__Impl4619);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2080:1: rule__OilObjectImpl__Group__1 : rule__OilObjectImpl__Group__1__Impl rule__OilObjectImpl__Group__2 ;
    public final void rule__OilObjectImpl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2084:1: ( rule__OilObjectImpl__Group__1__Impl rule__OilObjectImpl__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2085:2: rule__OilObjectImpl__Group__1__Impl rule__OilObjectImpl__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__1__Impl_in_rule__OilObjectImpl__Group__14649);
            rule__OilObjectImpl__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__2_in_rule__OilObjectImpl__Group__14652);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2092:1: rule__OilObjectImpl__Group__1__Impl : ( '{' ) ;
    public final void rule__OilObjectImpl__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2096:1: ( ( '{' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2097:1: ( '{' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2097:1: ( '{' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2098:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,56,FollowSets000.FOLLOW_56_in_rule__OilObjectImpl__Group__1__Impl4680); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2111:1: rule__OilObjectImpl__Group__2 : rule__OilObjectImpl__Group__2__Impl rule__OilObjectImpl__Group__3 ;
    public final void rule__OilObjectImpl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2115:1: ( rule__OilObjectImpl__Group__2__Impl rule__OilObjectImpl__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2116:2: rule__OilObjectImpl__Group__2__Impl rule__OilObjectImpl__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__2__Impl_in_rule__OilObjectImpl__Group__24711);
            rule__OilObjectImpl__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__3_in_rule__OilObjectImpl__Group__24714);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2123:1: rule__OilObjectImpl__Group__2__Impl : ( ( rule__OilObjectImpl__ParametersAssignment_2 )* ) ;
    public final void rule__OilObjectImpl__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2127:1: ( ( ( rule__OilObjectImpl__ParametersAssignment_2 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2128:1: ( ( rule__OilObjectImpl__ParametersAssignment_2 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2128:1: ( ( rule__OilObjectImpl__ParametersAssignment_2 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2129:1: ( rule__OilObjectImpl__ParametersAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getParametersAssignment_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2130:1: ( rule__OilObjectImpl__ParametersAssignment_2 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=13 && LA29_0<=21)||(LA29_0>=35 && LA29_0<=47)||LA29_0==51) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2130:2: rule__OilObjectImpl__ParametersAssignment_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__ParametersAssignment_2_in_rule__OilObjectImpl__Group__2__Impl4741);
            	    rule__OilObjectImpl__ParametersAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop29;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2140:1: rule__OilObjectImpl__Group__3 : rule__OilObjectImpl__Group__3__Impl rule__OilObjectImpl__Group__4 ;
    public final void rule__OilObjectImpl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2144:1: ( rule__OilObjectImpl__Group__3__Impl rule__OilObjectImpl__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2145:2: rule__OilObjectImpl__Group__3__Impl rule__OilObjectImpl__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__3__Impl_in_rule__OilObjectImpl__Group__34772);
            rule__OilObjectImpl__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__4_in_rule__OilObjectImpl__Group__34775);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2152:1: rule__OilObjectImpl__Group__3__Impl : ( '}' ) ;
    public final void rule__OilObjectImpl__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2156:1: ( ( '}' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2157:1: ( '}' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2157:1: ( '}' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2158:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getRightCurlyBracketKeyword_3()); 
            }
            match(input,57,FollowSets000.FOLLOW_57_in_rule__OilObjectImpl__Group__3__Impl4803); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2171:1: rule__OilObjectImpl__Group__4 : rule__OilObjectImpl__Group__4__Impl rule__OilObjectImpl__Group__5 ;
    public final void rule__OilObjectImpl__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2175:1: ( rule__OilObjectImpl__Group__4__Impl rule__OilObjectImpl__Group__5 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2176:2: rule__OilObjectImpl__Group__4__Impl rule__OilObjectImpl__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__4__Impl_in_rule__OilObjectImpl__Group__44834);
            rule__OilObjectImpl__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__5_in_rule__OilObjectImpl__Group__44837);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2183:1: rule__OilObjectImpl__Group__4__Impl : ( ( rule__OilObjectImpl__Group_4__0 )? ) ;
    public final void rule__OilObjectImpl__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2187:1: ( ( ( rule__OilObjectImpl__Group_4__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2188:1: ( ( rule__OilObjectImpl__Group_4__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2188:1: ( ( rule__OilObjectImpl__Group_4__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2189:1: ( rule__OilObjectImpl__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getGroup_4()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2190:1: ( rule__OilObjectImpl__Group_4__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==58) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2190:2: rule__OilObjectImpl__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group_4__0_in_rule__OilObjectImpl__Group__4__Impl4864);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2200:1: rule__OilObjectImpl__Group__5 : rule__OilObjectImpl__Group__5__Impl ;
    public final void rule__OilObjectImpl__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2204:1: ( rule__OilObjectImpl__Group__5__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2205:2: rule__OilObjectImpl__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__5__Impl_in_rule__OilObjectImpl__Group__54895);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2211:1: rule__OilObjectImpl__Group__5__Impl : ( ';' ) ;
    public final void rule__OilObjectImpl__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2215:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2216:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2216:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2217:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getSemicolonKeyword_5()); 
            }
            match(input,54,FollowSets000.FOLLOW_54_in_rule__OilObjectImpl__Group__5__Impl4923); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2242:1: rule__OilObjectImpl__Group_4__0 : rule__OilObjectImpl__Group_4__0__Impl rule__OilObjectImpl__Group_4__1 ;
    public final void rule__OilObjectImpl__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2246:1: ( rule__OilObjectImpl__Group_4__0__Impl rule__OilObjectImpl__Group_4__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2247:2: rule__OilObjectImpl__Group_4__0__Impl rule__OilObjectImpl__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group_4__0__Impl_in_rule__OilObjectImpl__Group_4__04966);
            rule__OilObjectImpl__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group_4__1_in_rule__OilObjectImpl__Group_4__04969);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2254:1: rule__OilObjectImpl__Group_4__0__Impl : ( ':' ) ;
    public final void rule__OilObjectImpl__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2258:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2259:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2259:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2260:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getColonKeyword_4_0()); 
            }
            match(input,58,FollowSets000.FOLLOW_58_in_rule__OilObjectImpl__Group_4__0__Impl4997); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2273:1: rule__OilObjectImpl__Group_4__1 : rule__OilObjectImpl__Group_4__1__Impl ;
    public final void rule__OilObjectImpl__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2277:1: ( rule__OilObjectImpl__Group_4__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2278:2: rule__OilObjectImpl__Group_4__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group_4__1__Impl_in_rule__OilObjectImpl__Group_4__15028);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2284:1: rule__OilObjectImpl__Group_4__1__Impl : ( ( rule__OilObjectImpl__DescriptionAssignment_4_1 ) ) ;
    public final void rule__OilObjectImpl__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2288:1: ( ( ( rule__OilObjectImpl__DescriptionAssignment_4_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2289:1: ( ( rule__OilObjectImpl__DescriptionAssignment_4_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2289:1: ( ( rule__OilObjectImpl__DescriptionAssignment_4_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2290:1: ( rule__OilObjectImpl__DescriptionAssignment_4_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getDescriptionAssignment_4_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2291:1: ( rule__OilObjectImpl__DescriptionAssignment_4_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2291:2: rule__OilObjectImpl__DescriptionAssignment_4_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__DescriptionAssignment_4_1_in_rule__OilObjectImpl__Group_4__1__Impl5055);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2305:1: rule__OilApplication__Group__0 : rule__OilApplication__Group__0__Impl rule__OilApplication__Group__1 ;
    public final void rule__OilApplication__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2309:1: ( rule__OilApplication__Group__0__Impl rule__OilApplication__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2310:2: rule__OilApplication__Group__0__Impl rule__OilApplication__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__0__Impl_in_rule__OilApplication__Group__05089);
            rule__OilApplication__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__1_in_rule__OilApplication__Group__05092);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2317:1: rule__OilApplication__Group__0__Impl : ( 'CPU' ) ;
    public final void rule__OilApplication__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2321:1: ( ( 'CPU' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2322:1: ( 'CPU' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2322:1: ( 'CPU' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2323:1: 'CPU'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getCPUKeyword_0()); 
            }
            match(input,59,FollowSets000.FOLLOW_59_in_rule__OilApplication__Group__0__Impl5120); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2336:1: rule__OilApplication__Group__1 : rule__OilApplication__Group__1__Impl rule__OilApplication__Group__2 ;
    public final void rule__OilApplication__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2340:1: ( rule__OilApplication__Group__1__Impl rule__OilApplication__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2341:2: rule__OilApplication__Group__1__Impl rule__OilApplication__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__1__Impl_in_rule__OilApplication__Group__15151);
            rule__OilApplication__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__2_in_rule__OilApplication__Group__15154);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2348:1: rule__OilApplication__Group__1__Impl : ( ( rule__OilApplication__NameAssignment_1 ) ) ;
    public final void rule__OilApplication__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2352:1: ( ( ( rule__OilApplication__NameAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2353:1: ( ( rule__OilApplication__NameAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2353:1: ( ( rule__OilApplication__NameAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2354:1: ( rule__OilApplication__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getNameAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2355:1: ( rule__OilApplication__NameAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2355:2: rule__OilApplication__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__NameAssignment_1_in_rule__OilApplication__Group__1__Impl5181);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2365:1: rule__OilApplication__Group__2 : rule__OilApplication__Group__2__Impl rule__OilApplication__Group__3 ;
    public final void rule__OilApplication__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2369:1: ( rule__OilApplication__Group__2__Impl rule__OilApplication__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2370:2: rule__OilApplication__Group__2__Impl rule__OilApplication__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__2__Impl_in_rule__OilApplication__Group__25211);
            rule__OilApplication__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__3_in_rule__OilApplication__Group__25214);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2377:1: rule__OilApplication__Group__2__Impl : ( '{' ) ;
    public final void rule__OilApplication__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2381:1: ( ( '{' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2382:1: ( '{' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2382:1: ( '{' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2383:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,56,FollowSets000.FOLLOW_56_in_rule__OilApplication__Group__2__Impl5242); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2396:1: rule__OilApplication__Group__3 : rule__OilApplication__Group__3__Impl rule__OilApplication__Group__4 ;
    public final void rule__OilApplication__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2400:1: ( rule__OilApplication__Group__3__Impl rule__OilApplication__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2401:2: rule__OilApplication__Group__3__Impl rule__OilApplication__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__3__Impl_in_rule__OilApplication__Group__35273);
            rule__OilApplication__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__4_in_rule__OilApplication__Group__35276);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2408:1: rule__OilApplication__Group__3__Impl : ( ( rule__OilApplication__OilObjectsAssignment_3 )* ) ;
    public final void rule__OilApplication__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2412:1: ( ( ( rule__OilApplication__OilObjectsAssignment_3 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2413:1: ( ( rule__OilApplication__OilObjectsAssignment_3 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2413:1: ( ( rule__OilApplication__OilObjectsAssignment_3 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2414:1: ( rule__OilApplication__OilObjectsAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getOilObjectsAssignment_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2415:1: ( rule__OilApplication__OilObjectsAssignment_3 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=22 && LA31_0<=34)||LA31_0==50) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2415:2: rule__OilApplication__OilObjectsAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__OilApplication__OilObjectsAssignment_3_in_rule__OilApplication__Group__3__Impl5303);
            	    rule__OilApplication__OilObjectsAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop31;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2425:1: rule__OilApplication__Group__4 : rule__OilApplication__Group__4__Impl rule__OilApplication__Group__5 ;
    public final void rule__OilApplication__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2429:1: ( rule__OilApplication__Group__4__Impl rule__OilApplication__Group__5 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2430:2: rule__OilApplication__Group__4__Impl rule__OilApplication__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__4__Impl_in_rule__OilApplication__Group__45334);
            rule__OilApplication__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__5_in_rule__OilApplication__Group__45337);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2437:1: rule__OilApplication__Group__4__Impl : ( '}' ) ;
    public final void rule__OilApplication__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2441:1: ( ( '}' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2442:1: ( '}' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2442:1: ( '}' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2443:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,57,FollowSets000.FOLLOW_57_in_rule__OilApplication__Group__4__Impl5365); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2456:1: rule__OilApplication__Group__5 : rule__OilApplication__Group__5__Impl rule__OilApplication__Group__6 ;
    public final void rule__OilApplication__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2460:1: ( rule__OilApplication__Group__5__Impl rule__OilApplication__Group__6 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2461:2: rule__OilApplication__Group__5__Impl rule__OilApplication__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__5__Impl_in_rule__OilApplication__Group__55396);
            rule__OilApplication__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__6_in_rule__OilApplication__Group__55399);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2468:1: rule__OilApplication__Group__5__Impl : ( ( rule__OilApplication__Group_5__0 )? ) ;
    public final void rule__OilApplication__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2472:1: ( ( ( rule__OilApplication__Group_5__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2473:1: ( ( rule__OilApplication__Group_5__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2473:1: ( ( rule__OilApplication__Group_5__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2474:1: ( rule__OilApplication__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getGroup_5()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2475:1: ( rule__OilApplication__Group_5__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==58) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2475:2: rule__OilApplication__Group_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group_5__0_in_rule__OilApplication__Group__5__Impl5426);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2485:1: rule__OilApplication__Group__6 : rule__OilApplication__Group__6__Impl ;
    public final void rule__OilApplication__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2489:1: ( rule__OilApplication__Group__6__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2490:2: rule__OilApplication__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__6__Impl_in_rule__OilApplication__Group__65457);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2496:1: rule__OilApplication__Group__6__Impl : ( ';' ) ;
    public final void rule__OilApplication__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2500:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2501:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2501:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2502:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getSemicolonKeyword_6()); 
            }
            match(input,54,FollowSets000.FOLLOW_54_in_rule__OilApplication__Group__6__Impl5485); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2529:1: rule__OilApplication__Group_5__0 : rule__OilApplication__Group_5__0__Impl rule__OilApplication__Group_5__1 ;
    public final void rule__OilApplication__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2533:1: ( rule__OilApplication__Group_5__0__Impl rule__OilApplication__Group_5__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2534:2: rule__OilApplication__Group_5__0__Impl rule__OilApplication__Group_5__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group_5__0__Impl_in_rule__OilApplication__Group_5__05530);
            rule__OilApplication__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group_5__1_in_rule__OilApplication__Group_5__05533);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2541:1: rule__OilApplication__Group_5__0__Impl : ( ':' ) ;
    public final void rule__OilApplication__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2545:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2546:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2546:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2547:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getColonKeyword_5_0()); 
            }
            match(input,58,FollowSets000.FOLLOW_58_in_rule__OilApplication__Group_5__0__Impl5561); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2560:1: rule__OilApplication__Group_5__1 : rule__OilApplication__Group_5__1__Impl ;
    public final void rule__OilApplication__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2564:1: ( rule__OilApplication__Group_5__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2565:2: rule__OilApplication__Group_5__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group_5__1__Impl_in_rule__OilApplication__Group_5__15592);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2571:1: rule__OilApplication__Group_5__1__Impl : ( ( rule__OilApplication__DescriptionAssignment_5_1 ) ) ;
    public final void rule__OilApplication__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2575:1: ( ( ( rule__OilApplication__DescriptionAssignment_5_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2576:1: ( ( rule__OilApplication__DescriptionAssignment_5_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2576:1: ( ( rule__OilApplication__DescriptionAssignment_5_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2577:1: ( rule__OilApplication__DescriptionAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getDescriptionAssignment_5_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2578:1: ( rule__OilApplication__DescriptionAssignment_5_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2578:2: rule__OilApplication__DescriptionAssignment_5_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__DescriptionAssignment_5_1_in_rule__OilApplication__Group_5__1__Impl5619);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2592:1: rule__ValueType__Group__0 : rule__ValueType__Group__0__Impl rule__ValueType__Group__1 ;
    public final void rule__ValueType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2596:1: ( rule__ValueType__Group__0__Impl rule__ValueType__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2597:2: rule__ValueType__Group__0__Impl rule__ValueType__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__0__Impl_in_rule__ValueType__Group__05653);
            rule__ValueType__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__1_in_rule__ValueType__Group__05656);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2604:1: rule__ValueType__Group__0__Impl : ( () ) ;
    public final void rule__ValueType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2608:1: ( ( () ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2609:1: ( () )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2609:1: ( () )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2610:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getValueTypeAction_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2611:1: ()
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2613:1: 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2623:1: rule__ValueType__Group__1 : rule__ValueType__Group__1__Impl rule__ValueType__Group__2 ;
    public final void rule__ValueType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2627:1: ( rule__ValueType__Group__1__Impl rule__ValueType__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2628:2: rule__ValueType__Group__1__Impl rule__ValueType__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__1__Impl_in_rule__ValueType__Group__15714);
            rule__ValueType__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__2_in_rule__ValueType__Group__15717);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2635:1: rule__ValueType__Group__1__Impl : ( ( rule__ValueType__TypeAssignment_1 ) ) ;
    public final void rule__ValueType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2639:1: ( ( ( rule__ValueType__TypeAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2640:1: ( ( rule__ValueType__TypeAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2640:1: ( ( rule__ValueType__TypeAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2641:1: ( rule__ValueType__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getTypeAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2642:1: ( rule__ValueType__TypeAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2642:2: rule__ValueType__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__TypeAssignment_1_in_rule__ValueType__Group__1__Impl5744);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2652:1: rule__ValueType__Group__2 : rule__ValueType__Group__2__Impl rule__ValueType__Group__3 ;
    public final void rule__ValueType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2656:1: ( rule__ValueType__Group__2__Impl rule__ValueType__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2657:2: rule__ValueType__Group__2__Impl rule__ValueType__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__2__Impl_in_rule__ValueType__Group__25774);
            rule__ValueType__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__3_in_rule__ValueType__Group__25777);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2664:1: rule__ValueType__Group__2__Impl : ( ( rule__ValueType__WithAutoAssignment_2 )? ) ;
    public final void rule__ValueType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2668:1: ( ( ( rule__ValueType__WithAutoAssignment_2 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2669:1: ( ( rule__ValueType__WithAutoAssignment_2 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2669:1: ( ( rule__ValueType__WithAutoAssignment_2 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2670:1: ( rule__ValueType__WithAutoAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getWithAutoAssignment_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2671:1: ( rule__ValueType__WithAutoAssignment_2 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==65) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2671:2: rule__ValueType__WithAutoAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ValueType__WithAutoAssignment_2_in_rule__ValueType__Group__2__Impl5804);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2681:1: rule__ValueType__Group__3 : rule__ValueType__Group__3__Impl rule__ValueType__Group__4 ;
    public final void rule__ValueType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2685:1: ( rule__ValueType__Group__3__Impl rule__ValueType__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2686:2: rule__ValueType__Group__3__Impl rule__ValueType__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__3__Impl_in_rule__ValueType__Group__35835);
            rule__ValueType__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__4_in_rule__ValueType__Group__35838);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2693:1: rule__ValueType__Group__3__Impl : ( ( rule__ValueType__Group_3__0 )? ) ;
    public final void rule__ValueType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2697:1: ( ( ( rule__ValueType__Group_3__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2698:1: ( ( rule__ValueType__Group_3__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2698:1: ( ( rule__ValueType__Group_3__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2699:1: ( rule__ValueType__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getGroup_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2700:1: ( rule__ValueType__Group_3__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==60) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2700:2: rule__ValueType__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_3__0_in_rule__ValueType__Group__3__Impl5865);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2710:1: rule__ValueType__Group__4 : rule__ValueType__Group__4__Impl rule__ValueType__Group__5 ;
    public final void rule__ValueType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2714:1: ( rule__ValueType__Group__4__Impl rule__ValueType__Group__5 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2715:2: rule__ValueType__Group__4__Impl rule__ValueType__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__4__Impl_in_rule__ValueType__Group__45896);
            rule__ValueType__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__5_in_rule__ValueType__Group__45899);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2722:1: rule__ValueType__Group__4__Impl : ( ( rule__ValueType__NameAssignment_4 ) ) ;
    public final void rule__ValueType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2726:1: ( ( ( rule__ValueType__NameAssignment_4 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2727:1: ( ( rule__ValueType__NameAssignment_4 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2727:1: ( ( rule__ValueType__NameAssignment_4 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2728:1: ( rule__ValueType__NameAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getNameAssignment_4()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2729:1: ( rule__ValueType__NameAssignment_4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2729:2: rule__ValueType__NameAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__NameAssignment_4_in_rule__ValueType__Group__4__Impl5926);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2739:1: rule__ValueType__Group__5 : rule__ValueType__Group__5__Impl rule__ValueType__Group__6 ;
    public final void rule__ValueType__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2743:1: ( rule__ValueType__Group__5__Impl rule__ValueType__Group__6 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2744:2: rule__ValueType__Group__5__Impl rule__ValueType__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__5__Impl_in_rule__ValueType__Group__55956);
            rule__ValueType__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__6_in_rule__ValueType__Group__55959);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2751:1: rule__ValueType__Group__5__Impl : ( ( rule__ValueType__MultiValueAssignment_5 )? ) ;
    public final void rule__ValueType__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2755:1: ( ( ( rule__ValueType__MultiValueAssignment_5 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2756:1: ( ( rule__ValueType__MultiValueAssignment_5 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2756:1: ( ( rule__ValueType__MultiValueAssignment_5 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2757:1: ( rule__ValueType__MultiValueAssignment_5 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getMultiValueAssignment_5()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2758:1: ( rule__ValueType__MultiValueAssignment_5 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==66) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2758:2: rule__ValueType__MultiValueAssignment_5
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ValueType__MultiValueAssignment_5_in_rule__ValueType__Group__5__Impl5986);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2768:1: rule__ValueType__Group__6 : rule__ValueType__Group__6__Impl rule__ValueType__Group__7 ;
    public final void rule__ValueType__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2772:1: ( rule__ValueType__Group__6__Impl rule__ValueType__Group__7 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2773:2: rule__ValueType__Group__6__Impl rule__ValueType__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__6__Impl_in_rule__ValueType__Group__66017);
            rule__ValueType__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__7_in_rule__ValueType__Group__66020);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2780:1: rule__ValueType__Group__6__Impl : ( ( rule__ValueType__Group_6__0 )? ) ;
    public final void rule__ValueType__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2784:1: ( ( ( rule__ValueType__Group_6__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2785:1: ( ( rule__ValueType__Group_6__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2785:1: ( ( rule__ValueType__Group_6__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2786:1: ( rule__ValueType__Group_6__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getGroup_6()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2787:1: ( rule__ValueType__Group_6__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==53) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2787:2: rule__ValueType__Group_6__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_6__0_in_rule__ValueType__Group__6__Impl6047);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2797:1: rule__ValueType__Group__7 : rule__ValueType__Group__7__Impl rule__ValueType__Group__8 ;
    public final void rule__ValueType__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2801:1: ( rule__ValueType__Group__7__Impl rule__ValueType__Group__8 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2802:2: rule__ValueType__Group__7__Impl rule__ValueType__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__7__Impl_in_rule__ValueType__Group__76078);
            rule__ValueType__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__8_in_rule__ValueType__Group__76081);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2809:1: rule__ValueType__Group__7__Impl : ( ( rule__ValueType__Group_7__0 )? ) ;
    public final void rule__ValueType__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2813:1: ( ( ( rule__ValueType__Group_7__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2814:1: ( ( rule__ValueType__Group_7__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2814:1: ( ( rule__ValueType__Group_7__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2815:1: ( rule__ValueType__Group_7__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getGroup_7()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2816:1: ( rule__ValueType__Group_7__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==58) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2816:2: rule__ValueType__Group_7__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_7__0_in_rule__ValueType__Group__7__Impl6108);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2826:1: rule__ValueType__Group__8 : rule__ValueType__Group__8__Impl ;
    public final void rule__ValueType__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2830:1: ( rule__ValueType__Group__8__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2831:2: rule__ValueType__Group__8__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__8__Impl_in_rule__ValueType__Group__86139);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2837:1: rule__ValueType__Group__8__Impl : ( ';' ) ;
    public final void rule__ValueType__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2841:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2842:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2842:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2843:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getSemicolonKeyword_8()); 
            }
            match(input,54,FollowSets000.FOLLOW_54_in_rule__ValueType__Group__8__Impl6167); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2874:1: rule__ValueType__Group_3__0 : rule__ValueType__Group_3__0__Impl rule__ValueType__Group_3__1 ;
    public final void rule__ValueType__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2878:1: ( rule__ValueType__Group_3__0__Impl rule__ValueType__Group_3__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2879:2: rule__ValueType__Group_3__0__Impl rule__ValueType__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_3__0__Impl_in_rule__ValueType__Group_3__06216);
            rule__ValueType__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_3__1_in_rule__ValueType__Group_3__06219);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2886:1: rule__ValueType__Group_3__0__Impl : ( '[' ) ;
    public final void rule__ValueType__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2890:1: ( ( '[' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2891:1: ( '[' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2891:1: ( '[' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2892:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getLeftSquareBracketKeyword_3_0()); 
            }
            match(input,60,FollowSets000.FOLLOW_60_in_rule__ValueType__Group_3__0__Impl6247); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2905:1: rule__ValueType__Group_3__1 : rule__ValueType__Group_3__1__Impl rule__ValueType__Group_3__2 ;
    public final void rule__ValueType__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2909:1: ( rule__ValueType__Group_3__1__Impl rule__ValueType__Group_3__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2910:2: rule__ValueType__Group_3__1__Impl rule__ValueType__Group_3__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_3__1__Impl_in_rule__ValueType__Group_3__16278);
            rule__ValueType__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_3__2_in_rule__ValueType__Group_3__16281);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2917:1: rule__ValueType__Group_3__1__Impl : ( ( rule__ValueType__Alternatives_3_1 ) ) ;
    public final void rule__ValueType__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2921:1: ( ( ( rule__ValueType__Alternatives_3_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2922:1: ( ( rule__ValueType__Alternatives_3_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2922:1: ( ( rule__ValueType__Alternatives_3_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2923:1: ( rule__ValueType__Alternatives_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getAlternatives_3_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2924:1: ( rule__ValueType__Alternatives_3_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2924:2: rule__ValueType__Alternatives_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Alternatives_3_1_in_rule__ValueType__Group_3__1__Impl6308);
            rule__ValueType__Alternatives_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getAlternatives_3_1()); 
            }

            }


            }

        }
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2934:1: rule__ValueType__Group_3__2 : rule__ValueType__Group_3__2__Impl ;
    public final void rule__ValueType__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2938:1: ( rule__ValueType__Group_3__2__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2939:2: rule__ValueType__Group_3__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_3__2__Impl_in_rule__ValueType__Group_3__26338);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2945:1: rule__ValueType__Group_3__2__Impl : ( ']' ) ;
    public final void rule__ValueType__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2949:1: ( ( ']' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2950:1: ( ']' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2950:1: ( ']' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2951:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getRightSquareBracketKeyword_3_2()); 
            }
            match(input,61,FollowSets000.FOLLOW_61_in_rule__ValueType__Group_3__2__Impl6366); if (state.failed) return ;
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


    // $ANTLR start "rule__ValueType__Group_3_1_0__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2970:1: rule__ValueType__Group_3_1_0__0 : rule__ValueType__Group_3_1_0__0__Impl rule__ValueType__Group_3_1_0__1 ;
    public final void rule__ValueType__Group_3_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2974:1: ( rule__ValueType__Group_3_1_0__0__Impl rule__ValueType__Group_3_1_0__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2975:2: rule__ValueType__Group_3_1_0__0__Impl rule__ValueType__Group_3_1_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_3_1_0__0__Impl_in_rule__ValueType__Group_3_1_0__06403);
            rule__ValueType__Group_3_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_3_1_0__1_in_rule__ValueType__Group_3_1_0__06406);
            rule__ValueType__Group_3_1_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group_3_1_0__0"


    // $ANTLR start "rule__ValueType__Group_3_1_0__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2982:1: rule__ValueType__Group_3_1_0__0__Impl : ( ( rule__ValueType__Alternatives_3_1_0_0 ) ) ;
    public final void rule__ValueType__Group_3_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2986:1: ( ( ( rule__ValueType__Alternatives_3_1_0_0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2987:1: ( ( rule__ValueType__Alternatives_3_1_0_0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2987:1: ( ( rule__ValueType__Alternatives_3_1_0_0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2988:1: ( rule__ValueType__Alternatives_3_1_0_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getAlternatives_3_1_0_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2989:1: ( rule__ValueType__Alternatives_3_1_0_0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2989:2: rule__ValueType__Alternatives_3_1_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Alternatives_3_1_0_0_in_rule__ValueType__Group_3_1_0__0__Impl6433);
            rule__ValueType__Alternatives_3_1_0_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getAlternatives_3_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group_3_1_0__0__Impl"


    // $ANTLR start "rule__ValueType__Group_3_1_0__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2999:1: rule__ValueType__Group_3_1_0__1 : rule__ValueType__Group_3_1_0__1__Impl rule__ValueType__Group_3_1_0__2 ;
    public final void rule__ValueType__Group_3_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3003:1: ( rule__ValueType__Group_3_1_0__1__Impl rule__ValueType__Group_3_1_0__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3004:2: rule__ValueType__Group_3_1_0__1__Impl rule__ValueType__Group_3_1_0__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_3_1_0__1__Impl_in_rule__ValueType__Group_3_1_0__16463);
            rule__ValueType__Group_3_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_3_1_0__2_in_rule__ValueType__Group_3_1_0__16466);
            rule__ValueType__Group_3_1_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group_3_1_0__1"


    // $ANTLR start "rule__ValueType__Group_3_1_0__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3011:1: rule__ValueType__Group_3_1_0__1__Impl : ( '..' ) ;
    public final void rule__ValueType__Group_3_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3015:1: ( ( '..' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3016:1: ( '..' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3016:1: ( '..' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3017:1: '..'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getFullStopFullStopKeyword_3_1_0_1()); 
            }
            match(input,62,FollowSets000.FOLLOW_62_in_rule__ValueType__Group_3_1_0__1__Impl6494); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getFullStopFullStopKeyword_3_1_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group_3_1_0__1__Impl"


    // $ANTLR start "rule__ValueType__Group_3_1_0__2"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3030:1: rule__ValueType__Group_3_1_0__2 : rule__ValueType__Group_3_1_0__2__Impl ;
    public final void rule__ValueType__Group_3_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3034:1: ( rule__ValueType__Group_3_1_0__2__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3035:2: rule__ValueType__Group_3_1_0__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_3_1_0__2__Impl_in_rule__ValueType__Group_3_1_0__26525);
            rule__ValueType__Group_3_1_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group_3_1_0__2"


    // $ANTLR start "rule__ValueType__Group_3_1_0__2__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3041:1: rule__ValueType__Group_3_1_0__2__Impl : ( ( rule__ValueType__Alternatives_3_1_0_2 ) ) ;
    public final void rule__ValueType__Group_3_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3045:1: ( ( ( rule__ValueType__Alternatives_3_1_0_2 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3046:1: ( ( rule__ValueType__Alternatives_3_1_0_2 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3046:1: ( ( rule__ValueType__Alternatives_3_1_0_2 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3047:1: ( rule__ValueType__Alternatives_3_1_0_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getAlternatives_3_1_0_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3048:1: ( rule__ValueType__Alternatives_3_1_0_2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3048:2: rule__ValueType__Alternatives_3_1_0_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Alternatives_3_1_0_2_in_rule__ValueType__Group_3_1_0__2__Impl6552);
            rule__ValueType__Alternatives_3_1_0_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getAlternatives_3_1_0_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group_3_1_0__2__Impl"


    // $ANTLR start "rule__ValueType__Group_3_1_1__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3064:1: rule__ValueType__Group_3_1_1__0 : rule__ValueType__Group_3_1_1__0__Impl rule__ValueType__Group_3_1_1__1 ;
    public final void rule__ValueType__Group_3_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3068:1: ( rule__ValueType__Group_3_1_1__0__Impl rule__ValueType__Group_3_1_1__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3069:2: rule__ValueType__Group_3_1_1__0__Impl rule__ValueType__Group_3_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_3_1_1__0__Impl_in_rule__ValueType__Group_3_1_1__06588);
            rule__ValueType__Group_3_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_3_1_1__1_in_rule__ValueType__Group_3_1_1__06591);
            rule__ValueType__Group_3_1_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group_3_1_1__0"


    // $ANTLR start "rule__ValueType__Group_3_1_1__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3076:1: rule__ValueType__Group_3_1_1__0__Impl : ( ( rule__ValueType__Alternatives_3_1_1_0 ) ) ;
    public final void rule__ValueType__Group_3_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3080:1: ( ( ( rule__ValueType__Alternatives_3_1_1_0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3081:1: ( ( rule__ValueType__Alternatives_3_1_1_0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3081:1: ( ( rule__ValueType__Alternatives_3_1_1_0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3082:1: ( rule__ValueType__Alternatives_3_1_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getAlternatives_3_1_1_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3083:1: ( rule__ValueType__Alternatives_3_1_1_0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3083:2: rule__ValueType__Alternatives_3_1_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Alternatives_3_1_1_0_in_rule__ValueType__Group_3_1_1__0__Impl6618);
            rule__ValueType__Alternatives_3_1_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getAlternatives_3_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group_3_1_1__0__Impl"


    // $ANTLR start "rule__ValueType__Group_3_1_1__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3093:1: rule__ValueType__Group_3_1_1__1 : rule__ValueType__Group_3_1_1__1__Impl ;
    public final void rule__ValueType__Group_3_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3097:1: ( rule__ValueType__Group_3_1_1__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3098:2: rule__ValueType__Group_3_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_3_1_1__1__Impl_in_rule__ValueType__Group_3_1_1__16648);
            rule__ValueType__Group_3_1_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group_3_1_1__1"


    // $ANTLR start "rule__ValueType__Group_3_1_1__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3104:1: rule__ValueType__Group_3_1_1__1__Impl : ( ( rule__ValueType__Group_3_1_1_1__0 )* ) ;
    public final void rule__ValueType__Group_3_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3108:1: ( ( ( rule__ValueType__Group_3_1_1_1__0 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3109:1: ( ( rule__ValueType__Group_3_1_1_1__0 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3109:1: ( ( rule__ValueType__Group_3_1_1_1__0 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3110:1: ( rule__ValueType__Group_3_1_1_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getGroup_3_1_1_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3111:1: ( rule__ValueType__Group_3_1_1_1__0 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==63) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3111:2: rule__ValueType__Group_3_1_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_3_1_1_1__0_in_rule__ValueType__Group_3_1_1__1__Impl6675);
            	    rule__ValueType__Group_3_1_1_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getGroup_3_1_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group_3_1_1__1__Impl"


    // $ANTLR start "rule__ValueType__Group_3_1_1_1__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3125:1: rule__ValueType__Group_3_1_1_1__0 : rule__ValueType__Group_3_1_1_1__0__Impl rule__ValueType__Group_3_1_1_1__1 ;
    public final void rule__ValueType__Group_3_1_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3129:1: ( rule__ValueType__Group_3_1_1_1__0__Impl rule__ValueType__Group_3_1_1_1__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3130:2: rule__ValueType__Group_3_1_1_1__0__Impl rule__ValueType__Group_3_1_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_3_1_1_1__0__Impl_in_rule__ValueType__Group_3_1_1_1__06710);
            rule__ValueType__Group_3_1_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_3_1_1_1__1_in_rule__ValueType__Group_3_1_1_1__06713);
            rule__ValueType__Group_3_1_1_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group_3_1_1_1__0"


    // $ANTLR start "rule__ValueType__Group_3_1_1_1__0__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3137:1: rule__ValueType__Group_3_1_1_1__0__Impl : ( ',' ) ;
    public final void rule__ValueType__Group_3_1_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3141:1: ( ( ',' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3142:1: ( ',' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3142:1: ( ',' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3143:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getCommaKeyword_3_1_1_1_0()); 
            }
            match(input,63,FollowSets000.FOLLOW_63_in_rule__ValueType__Group_3_1_1_1__0__Impl6741); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getCommaKeyword_3_1_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group_3_1_1_1__0__Impl"


    // $ANTLR start "rule__ValueType__Group_3_1_1_1__1"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3156:1: rule__ValueType__Group_3_1_1_1__1 : rule__ValueType__Group_3_1_1_1__1__Impl ;
    public final void rule__ValueType__Group_3_1_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3160:1: ( rule__ValueType__Group_3_1_1_1__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3161:2: rule__ValueType__Group_3_1_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_3_1_1_1__1__Impl_in_rule__ValueType__Group_3_1_1_1__16772);
            rule__ValueType__Group_3_1_1_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group_3_1_1_1__1"


    // $ANTLR start "rule__ValueType__Group_3_1_1_1__1__Impl"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3167:1: rule__ValueType__Group_3_1_1_1__1__Impl : ( ( rule__ValueType__Alternatives_3_1_1_1_1 ) ) ;
    public final void rule__ValueType__Group_3_1_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3171:1: ( ( ( rule__ValueType__Alternatives_3_1_1_1_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3172:1: ( ( rule__ValueType__Alternatives_3_1_1_1_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3172:1: ( ( rule__ValueType__Alternatives_3_1_1_1_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3173:1: ( rule__ValueType__Alternatives_3_1_1_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getAlternatives_3_1_1_1_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3174:1: ( rule__ValueType__Alternatives_3_1_1_1_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3174:2: rule__ValueType__Alternatives_3_1_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Alternatives_3_1_1_1_1_in_rule__ValueType__Group_3_1_1_1__1__Impl6799);
            rule__ValueType__Alternatives_3_1_1_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getAlternatives_3_1_1_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group_3_1_1_1__1__Impl"


    // $ANTLR start "rule__ValueType__Group_6__0"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3188:1: rule__ValueType__Group_6__0 : rule__ValueType__Group_6__0__Impl rule__ValueType__Group_6__1 ;
    public final void rule__ValueType__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3192:1: ( rule__ValueType__Group_6__0__Impl rule__ValueType__Group_6__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3193:2: rule__ValueType__Group_6__0__Impl rule__ValueType__Group_6__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_6__0__Impl_in_rule__ValueType__Group_6__06833);
            rule__ValueType__Group_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_6__1_in_rule__ValueType__Group_6__06836);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3200:1: rule__ValueType__Group_6__0__Impl : ( '=' ) ;
    public final void rule__ValueType__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3204:1: ( ( '=' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3205:1: ( '=' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3205:1: ( '=' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3206:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getEqualsSignKeyword_6_0()); 
            }
            match(input,53,FollowSets000.FOLLOW_53_in_rule__ValueType__Group_6__0__Impl6864); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3219:1: rule__ValueType__Group_6__1 : rule__ValueType__Group_6__1__Impl ;
    public final void rule__ValueType__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3223:1: ( rule__ValueType__Group_6__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3224:2: rule__ValueType__Group_6__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_6__1__Impl_in_rule__ValueType__Group_6__16895);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3230:1: rule__ValueType__Group_6__1__Impl : ( ( rule__ValueType__Alternatives_6_1 ) ) ;
    public final void rule__ValueType__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3234:1: ( ( ( rule__ValueType__Alternatives_6_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3235:1: ( ( rule__ValueType__Alternatives_6_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3235:1: ( ( rule__ValueType__Alternatives_6_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3236:1: ( rule__ValueType__Alternatives_6_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getAlternatives_6_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3237:1: ( rule__ValueType__Alternatives_6_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3237:2: rule__ValueType__Alternatives_6_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Alternatives_6_1_in_rule__ValueType__Group_6__1__Impl6922);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3251:1: rule__ValueType__Group_7__0 : rule__ValueType__Group_7__0__Impl rule__ValueType__Group_7__1 ;
    public final void rule__ValueType__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3255:1: ( rule__ValueType__Group_7__0__Impl rule__ValueType__Group_7__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3256:2: rule__ValueType__Group_7__0__Impl rule__ValueType__Group_7__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_7__0__Impl_in_rule__ValueType__Group_7__06956);
            rule__ValueType__Group_7__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_7__1_in_rule__ValueType__Group_7__06959);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3263:1: rule__ValueType__Group_7__0__Impl : ( ':' ) ;
    public final void rule__ValueType__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3267:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3268:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3268:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3269:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getColonKeyword_7_0()); 
            }
            match(input,58,FollowSets000.FOLLOW_58_in_rule__ValueType__Group_7__0__Impl6987); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3282:1: rule__ValueType__Group_7__1 : rule__ValueType__Group_7__1__Impl ;
    public final void rule__ValueType__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3286:1: ( rule__ValueType__Group_7__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3287:2: rule__ValueType__Group_7__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_7__1__Impl_in_rule__ValueType__Group_7__17018);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3293:1: rule__ValueType__Group_7__1__Impl : ( ( rule__ValueType__DescriptionAssignment_7_1 ) ) ;
    public final void rule__ValueType__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3297:1: ( ( ( rule__ValueType__DescriptionAssignment_7_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3298:1: ( ( rule__ValueType__DescriptionAssignment_7_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3298:1: ( ( rule__ValueType__DescriptionAssignment_7_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3299:1: ( rule__ValueType__DescriptionAssignment_7_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getDescriptionAssignment_7_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3300:1: ( rule__ValueType__DescriptionAssignment_7_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3300:2: rule__ValueType__DescriptionAssignment_7_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__DescriptionAssignment_7_1_in_rule__ValueType__Group_7__1__Impl7045);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3314:1: rule__VariantType__Group__0 : rule__VariantType__Group__0__Impl rule__VariantType__Group__1 ;
    public final void rule__VariantType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3318:1: ( rule__VariantType__Group__0__Impl rule__VariantType__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3319:2: rule__VariantType__Group__0__Impl rule__VariantType__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__0__Impl_in_rule__VariantType__Group__07079);
            rule__VariantType__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__1_in_rule__VariantType__Group__07082);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3326:1: rule__VariantType__Group__0__Impl : ( () ) ;
    public final void rule__VariantType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3330:1: ( ( () ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3331:1: ( () )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3331:1: ( () )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3332:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getVariantTypeAction_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3333:1: ()
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3335:1: 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3345:1: rule__VariantType__Group__1 : rule__VariantType__Group__1__Impl rule__VariantType__Group__2 ;
    public final void rule__VariantType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3349:1: ( rule__VariantType__Group__1__Impl rule__VariantType__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3350:2: rule__VariantType__Group__1__Impl rule__VariantType__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__1__Impl_in_rule__VariantType__Group__17140);
            rule__VariantType__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__2_in_rule__VariantType__Group__17143);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3357:1: rule__VariantType__Group__1__Impl : ( ( rule__VariantType__TypeAssignment_1 ) ) ;
    public final void rule__VariantType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3361:1: ( ( ( rule__VariantType__TypeAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3362:1: ( ( rule__VariantType__TypeAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3362:1: ( ( rule__VariantType__TypeAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3363:1: ( rule__VariantType__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getTypeAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3364:1: ( rule__VariantType__TypeAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3364:2: rule__VariantType__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__TypeAssignment_1_in_rule__VariantType__Group__1__Impl7170);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3374:1: rule__VariantType__Group__2 : rule__VariantType__Group__2__Impl rule__VariantType__Group__3 ;
    public final void rule__VariantType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3378:1: ( rule__VariantType__Group__2__Impl rule__VariantType__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3379:2: rule__VariantType__Group__2__Impl rule__VariantType__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__2__Impl_in_rule__VariantType__Group__27200);
            rule__VariantType__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__3_in_rule__VariantType__Group__27203);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3386:1: rule__VariantType__Group__2__Impl : ( ( rule__VariantType__WithAutoAssignment_2 )? ) ;
    public final void rule__VariantType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3390:1: ( ( ( rule__VariantType__WithAutoAssignment_2 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3391:1: ( ( rule__VariantType__WithAutoAssignment_2 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3391:1: ( ( rule__VariantType__WithAutoAssignment_2 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3392:1: ( rule__VariantType__WithAutoAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getWithAutoAssignment_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3393:1: ( rule__VariantType__WithAutoAssignment_2 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==65) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3393:2: rule__VariantType__WithAutoAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__VariantType__WithAutoAssignment_2_in_rule__VariantType__Group__2__Impl7230);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3403:1: rule__VariantType__Group__3 : rule__VariantType__Group__3__Impl rule__VariantType__Group__4 ;
    public final void rule__VariantType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3407:1: ( rule__VariantType__Group__3__Impl rule__VariantType__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3408:2: rule__VariantType__Group__3__Impl rule__VariantType__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__3__Impl_in_rule__VariantType__Group__37261);
            rule__VariantType__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__4_in_rule__VariantType__Group__37264);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3415:1: rule__VariantType__Group__3__Impl : ( ( rule__VariantType__Group_3__0 )? ) ;
    public final void rule__VariantType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3419:1: ( ( ( rule__VariantType__Group_3__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3420:1: ( ( rule__VariantType__Group_3__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3420:1: ( ( rule__VariantType__Group_3__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3421:1: ( rule__VariantType__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getGroup_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3422:1: ( rule__VariantType__Group_3__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==60) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3422:2: rule__VariantType__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3__0_in_rule__VariantType__Group__3__Impl7291);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3432:1: rule__VariantType__Group__4 : rule__VariantType__Group__4__Impl rule__VariantType__Group__5 ;
    public final void rule__VariantType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3436:1: ( rule__VariantType__Group__4__Impl rule__VariantType__Group__5 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3437:2: rule__VariantType__Group__4__Impl rule__VariantType__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__4__Impl_in_rule__VariantType__Group__47322);
            rule__VariantType__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__5_in_rule__VariantType__Group__47325);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3444:1: rule__VariantType__Group__4__Impl : ( ( rule__VariantType__NameAssignment_4 ) ) ;
    public final void rule__VariantType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3448:1: ( ( ( rule__VariantType__NameAssignment_4 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3449:1: ( ( rule__VariantType__NameAssignment_4 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3449:1: ( ( rule__VariantType__NameAssignment_4 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3450:1: ( rule__VariantType__NameAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getNameAssignment_4()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3451:1: ( rule__VariantType__NameAssignment_4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3451:2: rule__VariantType__NameAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__NameAssignment_4_in_rule__VariantType__Group__4__Impl7352);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3461:1: rule__VariantType__Group__5 : rule__VariantType__Group__5__Impl rule__VariantType__Group__6 ;
    public final void rule__VariantType__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3465:1: ( rule__VariantType__Group__5__Impl rule__VariantType__Group__6 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3466:2: rule__VariantType__Group__5__Impl rule__VariantType__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__5__Impl_in_rule__VariantType__Group__57382);
            rule__VariantType__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__6_in_rule__VariantType__Group__57385);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3473:1: rule__VariantType__Group__5__Impl : ( ( rule__VariantType__MultiValueAssignment_5 )? ) ;
    public final void rule__VariantType__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3477:1: ( ( ( rule__VariantType__MultiValueAssignment_5 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3478:1: ( ( rule__VariantType__MultiValueAssignment_5 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3478:1: ( ( rule__VariantType__MultiValueAssignment_5 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3479:1: ( rule__VariantType__MultiValueAssignment_5 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getMultiValueAssignment_5()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3480:1: ( rule__VariantType__MultiValueAssignment_5 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==66) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3480:2: rule__VariantType__MultiValueAssignment_5
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__VariantType__MultiValueAssignment_5_in_rule__VariantType__Group__5__Impl7412);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3490:1: rule__VariantType__Group__6 : rule__VariantType__Group__6__Impl rule__VariantType__Group__7 ;
    public final void rule__VariantType__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3494:1: ( rule__VariantType__Group__6__Impl rule__VariantType__Group__7 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3495:2: rule__VariantType__Group__6__Impl rule__VariantType__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__6__Impl_in_rule__VariantType__Group__67443);
            rule__VariantType__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__7_in_rule__VariantType__Group__67446);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3502:1: rule__VariantType__Group__6__Impl : ( ( rule__VariantType__Group_6__0 )? ) ;
    public final void rule__VariantType__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3506:1: ( ( ( rule__VariantType__Group_6__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3507:1: ( ( rule__VariantType__Group_6__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3507:1: ( ( rule__VariantType__Group_6__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3508:1: ( rule__VariantType__Group_6__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getGroup_6()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3509:1: ( rule__VariantType__Group_6__0 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==53) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3509:2: rule__VariantType__Group_6__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_6__0_in_rule__VariantType__Group__6__Impl7473);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3519:1: rule__VariantType__Group__7 : rule__VariantType__Group__7__Impl rule__VariantType__Group__8 ;
    public final void rule__VariantType__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3523:1: ( rule__VariantType__Group__7__Impl rule__VariantType__Group__8 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3524:2: rule__VariantType__Group__7__Impl rule__VariantType__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__7__Impl_in_rule__VariantType__Group__77504);
            rule__VariantType__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__8_in_rule__VariantType__Group__77507);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3531:1: rule__VariantType__Group__7__Impl : ( ( rule__VariantType__Group_7__0 )? ) ;
    public final void rule__VariantType__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3535:1: ( ( ( rule__VariantType__Group_7__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3536:1: ( ( rule__VariantType__Group_7__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3536:1: ( ( rule__VariantType__Group_7__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3537:1: ( rule__VariantType__Group_7__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getGroup_7()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3538:1: ( rule__VariantType__Group_7__0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==58) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3538:2: rule__VariantType__Group_7__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_7__0_in_rule__VariantType__Group__7__Impl7534);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3548:1: rule__VariantType__Group__8 : rule__VariantType__Group__8__Impl ;
    public final void rule__VariantType__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3552:1: ( rule__VariantType__Group__8__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3553:2: rule__VariantType__Group__8__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__8__Impl_in_rule__VariantType__Group__87565);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3559:1: rule__VariantType__Group__8__Impl : ( ';' ) ;
    public final void rule__VariantType__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3563:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3564:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3564:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3565:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getSemicolonKeyword_8()); 
            }
            match(input,54,FollowSets000.FOLLOW_54_in_rule__VariantType__Group__8__Impl7593); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3596:1: rule__VariantType__Group_3__0 : rule__VariantType__Group_3__0__Impl rule__VariantType__Group_3__1 ;
    public final void rule__VariantType__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3600:1: ( rule__VariantType__Group_3__0__Impl rule__VariantType__Group_3__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3601:2: rule__VariantType__Group_3__0__Impl rule__VariantType__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3__0__Impl_in_rule__VariantType__Group_3__07642);
            rule__VariantType__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3__1_in_rule__VariantType__Group_3__07645);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3608:1: rule__VariantType__Group_3__0__Impl : ( '[' ) ;
    public final void rule__VariantType__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3612:1: ( ( '[' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3613:1: ( '[' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3613:1: ( '[' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3614:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getLeftSquareBracketKeyword_3_0()); 
            }
            match(input,60,FollowSets000.FOLLOW_60_in_rule__VariantType__Group_3__0__Impl7673); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3627:1: rule__VariantType__Group_3__1 : rule__VariantType__Group_3__1__Impl rule__VariantType__Group_3__2 ;
    public final void rule__VariantType__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3631:1: ( rule__VariantType__Group_3__1__Impl rule__VariantType__Group_3__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3632:2: rule__VariantType__Group_3__1__Impl rule__VariantType__Group_3__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3__1__Impl_in_rule__VariantType__Group_3__17704);
            rule__VariantType__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3__2_in_rule__VariantType__Group_3__17707);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3639:1: rule__VariantType__Group_3__1__Impl : ( ( rule__VariantType__Group_3_1__0 )? ) ;
    public final void rule__VariantType__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3643:1: ( ( ( rule__VariantType__Group_3_1__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3644:1: ( ( rule__VariantType__Group_3_1__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3644:1: ( ( rule__VariantType__Group_3_1__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3645:1: ( rule__VariantType__Group_3_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getGroup_3_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3646:1: ( rule__VariantType__Group_3_1__0 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==RULE_ID||(LA44_0>=13 && LA44_0<=47)) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3646:2: rule__VariantType__Group_3_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3_1__0_in_rule__VariantType__Group_3__1__Impl7734);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3656:1: rule__VariantType__Group_3__2 : rule__VariantType__Group_3__2__Impl ;
    public final void rule__VariantType__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3660:1: ( rule__VariantType__Group_3__2__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3661:2: rule__VariantType__Group_3__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3__2__Impl_in_rule__VariantType__Group_3__27765);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3667:1: rule__VariantType__Group_3__2__Impl : ( ']' ) ;
    public final void rule__VariantType__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3671:1: ( ( ']' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3672:1: ( ']' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3672:1: ( ']' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3673:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getRightSquareBracketKeyword_3_2()); 
            }
            match(input,61,FollowSets000.FOLLOW_61_in_rule__VariantType__Group_3__2__Impl7793); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3692:1: rule__VariantType__Group_3_1__0 : rule__VariantType__Group_3_1__0__Impl rule__VariantType__Group_3_1__1 ;
    public final void rule__VariantType__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3696:1: ( rule__VariantType__Group_3_1__0__Impl rule__VariantType__Group_3_1__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3697:2: rule__VariantType__Group_3_1__0__Impl rule__VariantType__Group_3_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3_1__0__Impl_in_rule__VariantType__Group_3_1__07830);
            rule__VariantType__Group_3_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3_1__1_in_rule__VariantType__Group_3_1__07833);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3704:1: rule__VariantType__Group_3_1__0__Impl : ( ( rule__VariantType__ValuesAssignment_3_1_0 ) ) ;
    public final void rule__VariantType__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3708:1: ( ( ( rule__VariantType__ValuesAssignment_3_1_0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3709:1: ( ( rule__VariantType__ValuesAssignment_3_1_0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3709:1: ( ( rule__VariantType__ValuesAssignment_3_1_0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3710:1: ( rule__VariantType__ValuesAssignment_3_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getValuesAssignment_3_1_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3711:1: ( rule__VariantType__ValuesAssignment_3_1_0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3711:2: rule__VariantType__ValuesAssignment_3_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__ValuesAssignment_3_1_0_in_rule__VariantType__Group_3_1__0__Impl7860);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3721:1: rule__VariantType__Group_3_1__1 : rule__VariantType__Group_3_1__1__Impl ;
    public final void rule__VariantType__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3725:1: ( rule__VariantType__Group_3_1__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3726:2: rule__VariantType__Group_3_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3_1__1__Impl_in_rule__VariantType__Group_3_1__17890);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3732:1: rule__VariantType__Group_3_1__1__Impl : ( ( rule__VariantType__Group_3_1_1__0 )* ) ;
    public final void rule__VariantType__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3736:1: ( ( ( rule__VariantType__Group_3_1_1__0 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3737:1: ( ( rule__VariantType__Group_3_1_1__0 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3737:1: ( ( rule__VariantType__Group_3_1_1__0 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3738:1: ( rule__VariantType__Group_3_1_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getGroup_3_1_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3739:1: ( rule__VariantType__Group_3_1_1__0 )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==63) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3739:2: rule__VariantType__Group_3_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3_1_1__0_in_rule__VariantType__Group_3_1__1__Impl7917);
            	    rule__VariantType__Group_3_1_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop45;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3753:1: rule__VariantType__Group_3_1_1__0 : rule__VariantType__Group_3_1_1__0__Impl rule__VariantType__Group_3_1_1__1 ;
    public final void rule__VariantType__Group_3_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3757:1: ( rule__VariantType__Group_3_1_1__0__Impl rule__VariantType__Group_3_1_1__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3758:2: rule__VariantType__Group_3_1_1__0__Impl rule__VariantType__Group_3_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3_1_1__0__Impl_in_rule__VariantType__Group_3_1_1__07952);
            rule__VariantType__Group_3_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3_1_1__1_in_rule__VariantType__Group_3_1_1__07955);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3765:1: rule__VariantType__Group_3_1_1__0__Impl : ( ',' ) ;
    public final void rule__VariantType__Group_3_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3769:1: ( ( ',' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3770:1: ( ',' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3770:1: ( ',' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3771:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getCommaKeyword_3_1_1_0()); 
            }
            match(input,63,FollowSets000.FOLLOW_63_in_rule__VariantType__Group_3_1_1__0__Impl7983); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3784:1: rule__VariantType__Group_3_1_1__1 : rule__VariantType__Group_3_1_1__1__Impl ;
    public final void rule__VariantType__Group_3_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3788:1: ( rule__VariantType__Group_3_1_1__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3789:2: rule__VariantType__Group_3_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3_1_1__1__Impl_in_rule__VariantType__Group_3_1_1__18014);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3795:1: rule__VariantType__Group_3_1_1__1__Impl : ( ( rule__VariantType__ValuesAssignment_3_1_1_1 ) ) ;
    public final void rule__VariantType__Group_3_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3799:1: ( ( ( rule__VariantType__ValuesAssignment_3_1_1_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3800:1: ( ( rule__VariantType__ValuesAssignment_3_1_1_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3800:1: ( ( rule__VariantType__ValuesAssignment_3_1_1_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3801:1: ( rule__VariantType__ValuesAssignment_3_1_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getValuesAssignment_3_1_1_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3802:1: ( rule__VariantType__ValuesAssignment_3_1_1_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3802:2: rule__VariantType__ValuesAssignment_3_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__ValuesAssignment_3_1_1_1_in_rule__VariantType__Group_3_1_1__1__Impl8041);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3816:1: rule__VariantType__Group_6__0 : rule__VariantType__Group_6__0__Impl rule__VariantType__Group_6__1 ;
    public final void rule__VariantType__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3820:1: ( rule__VariantType__Group_6__0__Impl rule__VariantType__Group_6__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3821:2: rule__VariantType__Group_6__0__Impl rule__VariantType__Group_6__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_6__0__Impl_in_rule__VariantType__Group_6__08075);
            rule__VariantType__Group_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_6__1_in_rule__VariantType__Group_6__08078);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3828:1: rule__VariantType__Group_6__0__Impl : ( '=' ) ;
    public final void rule__VariantType__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3832:1: ( ( '=' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3833:1: ( '=' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3833:1: ( '=' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3834:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getEqualsSignKeyword_6_0()); 
            }
            match(input,53,FollowSets000.FOLLOW_53_in_rule__VariantType__Group_6__0__Impl8106); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3847:1: rule__VariantType__Group_6__1 : rule__VariantType__Group_6__1__Impl ;
    public final void rule__VariantType__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3851:1: ( rule__VariantType__Group_6__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3852:2: rule__VariantType__Group_6__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_6__1__Impl_in_rule__VariantType__Group_6__18137);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3858:1: rule__VariantType__Group_6__1__Impl : ( ( rule__VariantType__Alternatives_6_1 ) ) ;
    public final void rule__VariantType__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3862:1: ( ( ( rule__VariantType__Alternatives_6_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3863:1: ( ( rule__VariantType__Alternatives_6_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3863:1: ( ( rule__VariantType__Alternatives_6_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3864:1: ( rule__VariantType__Alternatives_6_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getAlternatives_6_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3865:1: ( rule__VariantType__Alternatives_6_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3865:2: rule__VariantType__Alternatives_6_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Alternatives_6_1_in_rule__VariantType__Group_6__1__Impl8164);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3879:1: rule__VariantType__Group_7__0 : rule__VariantType__Group_7__0__Impl rule__VariantType__Group_7__1 ;
    public final void rule__VariantType__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3883:1: ( rule__VariantType__Group_7__0__Impl rule__VariantType__Group_7__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3884:2: rule__VariantType__Group_7__0__Impl rule__VariantType__Group_7__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_7__0__Impl_in_rule__VariantType__Group_7__08198);
            rule__VariantType__Group_7__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_7__1_in_rule__VariantType__Group_7__08201);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3891:1: rule__VariantType__Group_7__0__Impl : ( ':' ) ;
    public final void rule__VariantType__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3895:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3896:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3896:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3897:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getColonKeyword_7_0()); 
            }
            match(input,58,FollowSets000.FOLLOW_58_in_rule__VariantType__Group_7__0__Impl8229); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3910:1: rule__VariantType__Group_7__1 : rule__VariantType__Group_7__1__Impl ;
    public final void rule__VariantType__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3914:1: ( rule__VariantType__Group_7__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3915:2: rule__VariantType__Group_7__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_7__1__Impl_in_rule__VariantType__Group_7__18260);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3921:1: rule__VariantType__Group_7__1__Impl : ( ( rule__VariantType__DescriptionAssignment_7_1 ) ) ;
    public final void rule__VariantType__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3925:1: ( ( ( rule__VariantType__DescriptionAssignment_7_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3926:1: ( ( rule__VariantType__DescriptionAssignment_7_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3926:1: ( ( rule__VariantType__DescriptionAssignment_7_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3927:1: ( rule__VariantType__DescriptionAssignment_7_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getDescriptionAssignment_7_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3928:1: ( rule__VariantType__DescriptionAssignment_7_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3928:2: rule__VariantType__DescriptionAssignment_7_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__DescriptionAssignment_7_1_in_rule__VariantType__Group_7__1__Impl8287);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3942:1: rule__EnumeratorType__Group__0 : rule__EnumeratorType__Group__0__Impl rule__EnumeratorType__Group__1 ;
    public final void rule__EnumeratorType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3946:1: ( rule__EnumeratorType__Group__0__Impl rule__EnumeratorType__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3947:2: rule__EnumeratorType__Group__0__Impl rule__EnumeratorType__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group__0__Impl_in_rule__EnumeratorType__Group__08321);
            rule__EnumeratorType__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group__1_in_rule__EnumeratorType__Group__08324);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3954:1: rule__EnumeratorType__Group__0__Impl : ( () ) ;
    public final void rule__EnumeratorType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3958:1: ( ( () ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3959:1: ( () )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3959:1: ( () )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3960:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getEnumeratorTypeAction_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3961:1: ()
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3963:1: 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3973:1: rule__EnumeratorType__Group__1 : rule__EnumeratorType__Group__1__Impl rule__EnumeratorType__Group__2 ;
    public final void rule__EnumeratorType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3977:1: ( rule__EnumeratorType__Group__1__Impl rule__EnumeratorType__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3978:2: rule__EnumeratorType__Group__1__Impl rule__EnumeratorType__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group__1__Impl_in_rule__EnumeratorType__Group__18382);
            rule__EnumeratorType__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group__2_in_rule__EnumeratorType__Group__18385);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3985:1: rule__EnumeratorType__Group__1__Impl : ( ( rule__EnumeratorType__NameAssignment_1 ) ) ;
    public final void rule__EnumeratorType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3989:1: ( ( ( rule__EnumeratorType__NameAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3990:1: ( ( rule__EnumeratorType__NameAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3990:1: ( ( rule__EnumeratorType__NameAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3991:1: ( rule__EnumeratorType__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getNameAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3992:1: ( rule__EnumeratorType__NameAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3992:2: rule__EnumeratorType__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__NameAssignment_1_in_rule__EnumeratorType__Group__1__Impl8412);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4002:1: rule__EnumeratorType__Group__2 : rule__EnumeratorType__Group__2__Impl rule__EnumeratorType__Group__3 ;
    public final void rule__EnumeratorType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4006:1: ( rule__EnumeratorType__Group__2__Impl rule__EnumeratorType__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4007:2: rule__EnumeratorType__Group__2__Impl rule__EnumeratorType__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group__2__Impl_in_rule__EnumeratorType__Group__28442);
            rule__EnumeratorType__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group__3_in_rule__EnumeratorType__Group__28445);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4014:1: rule__EnumeratorType__Group__2__Impl : ( ( rule__EnumeratorType__Group_2__0 )? ) ;
    public final void rule__EnumeratorType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4018:1: ( ( ( rule__EnumeratorType__Group_2__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4019:1: ( ( rule__EnumeratorType__Group_2__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4019:1: ( ( rule__EnumeratorType__Group_2__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4020:1: ( rule__EnumeratorType__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getGroup_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4021:1: ( rule__EnumeratorType__Group_2__0 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==56) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4021:2: rule__EnumeratorType__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_2__0_in_rule__EnumeratorType__Group__2__Impl8472);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4031:1: rule__EnumeratorType__Group__3 : rule__EnumeratorType__Group__3__Impl ;
    public final void rule__EnumeratorType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4035:1: ( rule__EnumeratorType__Group__3__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4036:2: rule__EnumeratorType__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group__3__Impl_in_rule__EnumeratorType__Group__38503);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4042:1: rule__EnumeratorType__Group__3__Impl : ( ( rule__EnumeratorType__Group_3__0 )? ) ;
    public final void rule__EnumeratorType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4046:1: ( ( ( rule__EnumeratorType__Group_3__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4047:1: ( ( rule__EnumeratorType__Group_3__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4047:1: ( ( rule__EnumeratorType__Group_3__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4048:1: ( rule__EnumeratorType__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getGroup_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4049:1: ( rule__EnumeratorType__Group_3__0 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==58) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4049:2: rule__EnumeratorType__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_3__0_in_rule__EnumeratorType__Group__3__Impl8530);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4067:1: rule__EnumeratorType__Group_2__0 : rule__EnumeratorType__Group_2__0__Impl rule__EnumeratorType__Group_2__1 ;
    public final void rule__EnumeratorType__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4071:1: ( rule__EnumeratorType__Group_2__0__Impl rule__EnumeratorType__Group_2__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4072:2: rule__EnumeratorType__Group_2__0__Impl rule__EnumeratorType__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_2__0__Impl_in_rule__EnumeratorType__Group_2__08569);
            rule__EnumeratorType__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_2__1_in_rule__EnumeratorType__Group_2__08572);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4079:1: rule__EnumeratorType__Group_2__0__Impl : ( '{' ) ;
    public final void rule__EnumeratorType__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4083:1: ( ( '{' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4084:1: ( '{' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4084:1: ( '{' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4085:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getLeftCurlyBracketKeyword_2_0()); 
            }
            match(input,56,FollowSets000.FOLLOW_56_in_rule__EnumeratorType__Group_2__0__Impl8600); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4098:1: rule__EnumeratorType__Group_2__1 : rule__EnumeratorType__Group_2__1__Impl rule__EnumeratorType__Group_2__2 ;
    public final void rule__EnumeratorType__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4102:1: ( rule__EnumeratorType__Group_2__1__Impl rule__EnumeratorType__Group_2__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4103:2: rule__EnumeratorType__Group_2__1__Impl rule__EnumeratorType__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_2__1__Impl_in_rule__EnumeratorType__Group_2__18631);
            rule__EnumeratorType__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_2__2_in_rule__EnumeratorType__Group_2__18634);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4110:1: rule__EnumeratorType__Group_2__1__Impl : ( ( rule__EnumeratorType__ParametersAssignment_2_1 )* ) ;
    public final void rule__EnumeratorType__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4114:1: ( ( ( rule__EnumeratorType__ParametersAssignment_2_1 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4115:1: ( ( rule__EnumeratorType__ParametersAssignment_2_1 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4115:1: ( ( rule__EnumeratorType__ParametersAssignment_2_1 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4116:1: ( rule__EnumeratorType__ParametersAssignment_2_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getParametersAssignment_2_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4117:1: ( rule__EnumeratorType__ParametersAssignment_2_1 )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( ((LA48_0>=13 && LA48_0<=21)||(LA48_0>=35 && LA48_0<=47)||LA48_0==51) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4117:2: rule__EnumeratorType__ParametersAssignment_2_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__ParametersAssignment_2_1_in_rule__EnumeratorType__Group_2__1__Impl8661);
            	    rule__EnumeratorType__ParametersAssignment_2_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop48;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4127:1: rule__EnumeratorType__Group_2__2 : rule__EnumeratorType__Group_2__2__Impl ;
    public final void rule__EnumeratorType__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4131:1: ( rule__EnumeratorType__Group_2__2__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4132:2: rule__EnumeratorType__Group_2__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_2__2__Impl_in_rule__EnumeratorType__Group_2__28692);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4138:1: rule__EnumeratorType__Group_2__2__Impl : ( '}' ) ;
    public final void rule__EnumeratorType__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4142:1: ( ( '}' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4143:1: ( '}' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4143:1: ( '}' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4144:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getRightCurlyBracketKeyword_2_2()); 
            }
            match(input,57,FollowSets000.FOLLOW_57_in_rule__EnumeratorType__Group_2__2__Impl8720); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4163:1: rule__EnumeratorType__Group_3__0 : rule__EnumeratorType__Group_3__0__Impl rule__EnumeratorType__Group_3__1 ;
    public final void rule__EnumeratorType__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4167:1: ( rule__EnumeratorType__Group_3__0__Impl rule__EnumeratorType__Group_3__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4168:2: rule__EnumeratorType__Group_3__0__Impl rule__EnumeratorType__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_3__0__Impl_in_rule__EnumeratorType__Group_3__08757);
            rule__EnumeratorType__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_3__1_in_rule__EnumeratorType__Group_3__08760);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4175:1: rule__EnumeratorType__Group_3__0__Impl : ( ':' ) ;
    public final void rule__EnumeratorType__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4179:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4180:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4180:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4181:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getColonKeyword_3_0()); 
            }
            match(input,58,FollowSets000.FOLLOW_58_in_rule__EnumeratorType__Group_3__0__Impl8788); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4194:1: rule__EnumeratorType__Group_3__1 : rule__EnumeratorType__Group_3__1__Impl ;
    public final void rule__EnumeratorType__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4198:1: ( rule__EnumeratorType__Group_3__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4199:2: rule__EnumeratorType__Group_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_3__1__Impl_in_rule__EnumeratorType__Group_3__18819);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4205:1: rule__EnumeratorType__Group_3__1__Impl : ( ( rule__EnumeratorType__DescriptionAssignment_3_1 ) ) ;
    public final void rule__EnumeratorType__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4209:1: ( ( ( rule__EnumeratorType__DescriptionAssignment_3_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4210:1: ( ( rule__EnumeratorType__DescriptionAssignment_3_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4210:1: ( ( rule__EnumeratorType__DescriptionAssignment_3_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4211:1: ( rule__EnumeratorType__DescriptionAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getDescriptionAssignment_3_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4212:1: ( rule__EnumeratorType__DescriptionAssignment_3_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4212:2: rule__EnumeratorType__DescriptionAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__DescriptionAssignment_3_1_in_rule__EnumeratorType__Group_3__1__Impl8846);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4226:1: rule__ReferenceType__Group__0 : rule__ReferenceType__Group__0__Impl rule__ReferenceType__Group__1 ;
    public final void rule__ReferenceType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4230:1: ( rule__ReferenceType__Group__0__Impl rule__ReferenceType__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4231:2: rule__ReferenceType__Group__0__Impl rule__ReferenceType__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__0__Impl_in_rule__ReferenceType__Group__08880);
            rule__ReferenceType__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__1_in_rule__ReferenceType__Group__08883);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4238:1: rule__ReferenceType__Group__0__Impl : ( () ) ;
    public final void rule__ReferenceType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4242:1: ( ( () ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4243:1: ( () )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4243:1: ( () )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4244:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getReferenceTypeAction_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4245:1: ()
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4247:1: 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4257:1: rule__ReferenceType__Group__1 : rule__ReferenceType__Group__1__Impl rule__ReferenceType__Group__2 ;
    public final void rule__ReferenceType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4261:1: ( rule__ReferenceType__Group__1__Impl rule__ReferenceType__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4262:2: rule__ReferenceType__Group__1__Impl rule__ReferenceType__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__1__Impl_in_rule__ReferenceType__Group__18941);
            rule__ReferenceType__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__2_in_rule__ReferenceType__Group__18944);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4269:1: rule__ReferenceType__Group__1__Impl : ( ( rule__ReferenceType__TypeAssignment_1 ) ) ;
    public final void rule__ReferenceType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4273:1: ( ( ( rule__ReferenceType__TypeAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4274:1: ( ( rule__ReferenceType__TypeAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4274:1: ( ( rule__ReferenceType__TypeAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4275:1: ( rule__ReferenceType__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getTypeAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4276:1: ( rule__ReferenceType__TypeAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4276:2: rule__ReferenceType__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__TypeAssignment_1_in_rule__ReferenceType__Group__1__Impl8971);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4286:1: rule__ReferenceType__Group__2 : rule__ReferenceType__Group__2__Impl rule__ReferenceType__Group__3 ;
    public final void rule__ReferenceType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4290:1: ( rule__ReferenceType__Group__2__Impl rule__ReferenceType__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4291:2: rule__ReferenceType__Group__2__Impl rule__ReferenceType__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__2__Impl_in_rule__ReferenceType__Group__29001);
            rule__ReferenceType__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__3_in_rule__ReferenceType__Group__29004);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4298:1: rule__ReferenceType__Group__2__Impl : ( ( rule__ReferenceType__WithAutoAssignment_2 )? ) ;
    public final void rule__ReferenceType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4302:1: ( ( ( rule__ReferenceType__WithAutoAssignment_2 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4303:1: ( ( rule__ReferenceType__WithAutoAssignment_2 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4303:1: ( ( rule__ReferenceType__WithAutoAssignment_2 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4304:1: ( rule__ReferenceType__WithAutoAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getWithAutoAssignment_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4305:1: ( rule__ReferenceType__WithAutoAssignment_2 )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==65) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4305:2: rule__ReferenceType__WithAutoAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__WithAutoAssignment_2_in_rule__ReferenceType__Group__2__Impl9031);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4315:1: rule__ReferenceType__Group__3 : rule__ReferenceType__Group__3__Impl rule__ReferenceType__Group__4 ;
    public final void rule__ReferenceType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4319:1: ( rule__ReferenceType__Group__3__Impl rule__ReferenceType__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4320:2: rule__ReferenceType__Group__3__Impl rule__ReferenceType__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__3__Impl_in_rule__ReferenceType__Group__39062);
            rule__ReferenceType__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__4_in_rule__ReferenceType__Group__39065);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4327:1: rule__ReferenceType__Group__3__Impl : ( ( rule__ReferenceType__NameAssignment_3 ) ) ;
    public final void rule__ReferenceType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4331:1: ( ( ( rule__ReferenceType__NameAssignment_3 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4332:1: ( ( rule__ReferenceType__NameAssignment_3 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4332:1: ( ( rule__ReferenceType__NameAssignment_3 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4333:1: ( rule__ReferenceType__NameAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getNameAssignment_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4334:1: ( rule__ReferenceType__NameAssignment_3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4334:2: rule__ReferenceType__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__NameAssignment_3_in_rule__ReferenceType__Group__3__Impl9092);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4344:1: rule__ReferenceType__Group__4 : rule__ReferenceType__Group__4__Impl rule__ReferenceType__Group__5 ;
    public final void rule__ReferenceType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4348:1: ( rule__ReferenceType__Group__4__Impl rule__ReferenceType__Group__5 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4349:2: rule__ReferenceType__Group__4__Impl rule__ReferenceType__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__4__Impl_in_rule__ReferenceType__Group__49122);
            rule__ReferenceType__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__5_in_rule__ReferenceType__Group__49125);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4356:1: rule__ReferenceType__Group__4__Impl : ( ( rule__ReferenceType__MultiValueAssignment_4 )? ) ;
    public final void rule__ReferenceType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4360:1: ( ( ( rule__ReferenceType__MultiValueAssignment_4 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4361:1: ( ( rule__ReferenceType__MultiValueAssignment_4 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4361:1: ( ( rule__ReferenceType__MultiValueAssignment_4 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4362:1: ( rule__ReferenceType__MultiValueAssignment_4 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getMultiValueAssignment_4()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4363:1: ( rule__ReferenceType__MultiValueAssignment_4 )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==66) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4363:2: rule__ReferenceType__MultiValueAssignment_4
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__MultiValueAssignment_4_in_rule__ReferenceType__Group__4__Impl9152);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4373:1: rule__ReferenceType__Group__5 : rule__ReferenceType__Group__5__Impl rule__ReferenceType__Group__6 ;
    public final void rule__ReferenceType__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4377:1: ( rule__ReferenceType__Group__5__Impl rule__ReferenceType__Group__6 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4378:2: rule__ReferenceType__Group__5__Impl rule__ReferenceType__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__5__Impl_in_rule__ReferenceType__Group__59183);
            rule__ReferenceType__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__6_in_rule__ReferenceType__Group__59186);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4385:1: rule__ReferenceType__Group__5__Impl : ( ( rule__ReferenceType__Group_5__0 )? ) ;
    public final void rule__ReferenceType__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4389:1: ( ( ( rule__ReferenceType__Group_5__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4390:1: ( ( rule__ReferenceType__Group_5__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4390:1: ( ( rule__ReferenceType__Group_5__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4391:1: ( rule__ReferenceType__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getGroup_5()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4392:1: ( rule__ReferenceType__Group_5__0 )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==53) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4392:2: rule__ReferenceType__Group_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_5__0_in_rule__ReferenceType__Group__5__Impl9213);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4402:1: rule__ReferenceType__Group__6 : rule__ReferenceType__Group__6__Impl rule__ReferenceType__Group__7 ;
    public final void rule__ReferenceType__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4406:1: ( rule__ReferenceType__Group__6__Impl rule__ReferenceType__Group__7 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4407:2: rule__ReferenceType__Group__6__Impl rule__ReferenceType__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__6__Impl_in_rule__ReferenceType__Group__69244);
            rule__ReferenceType__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__7_in_rule__ReferenceType__Group__69247);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4414:1: rule__ReferenceType__Group__6__Impl : ( ( rule__ReferenceType__Group_6__0 )? ) ;
    public final void rule__ReferenceType__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4418:1: ( ( ( rule__ReferenceType__Group_6__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4419:1: ( ( rule__ReferenceType__Group_6__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4419:1: ( ( rule__ReferenceType__Group_6__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4420:1: ( rule__ReferenceType__Group_6__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getGroup_6()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4421:1: ( rule__ReferenceType__Group_6__0 )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==58) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4421:2: rule__ReferenceType__Group_6__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_6__0_in_rule__ReferenceType__Group__6__Impl9274);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4431:1: rule__ReferenceType__Group__7 : rule__ReferenceType__Group__7__Impl ;
    public final void rule__ReferenceType__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4435:1: ( rule__ReferenceType__Group__7__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4436:2: rule__ReferenceType__Group__7__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__7__Impl_in_rule__ReferenceType__Group__79305);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4442:1: rule__ReferenceType__Group__7__Impl : ( ';' ) ;
    public final void rule__ReferenceType__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4446:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4447:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4447:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4448:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getSemicolonKeyword_7()); 
            }
            match(input,54,FollowSets000.FOLLOW_54_in_rule__ReferenceType__Group__7__Impl9333); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4477:1: rule__ReferenceType__Group_5__0 : rule__ReferenceType__Group_5__0__Impl rule__ReferenceType__Group_5__1 ;
    public final void rule__ReferenceType__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4481:1: ( rule__ReferenceType__Group_5__0__Impl rule__ReferenceType__Group_5__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4482:2: rule__ReferenceType__Group_5__0__Impl rule__ReferenceType__Group_5__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_5__0__Impl_in_rule__ReferenceType__Group_5__09380);
            rule__ReferenceType__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_5__1_in_rule__ReferenceType__Group_5__09383);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4489:1: rule__ReferenceType__Group_5__0__Impl : ( '=' ) ;
    public final void rule__ReferenceType__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4493:1: ( ( '=' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4494:1: ( '=' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4494:1: ( '=' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4495:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getEqualsSignKeyword_5_0()); 
            }
            match(input,53,FollowSets000.FOLLOW_53_in_rule__ReferenceType__Group_5__0__Impl9411); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4508:1: rule__ReferenceType__Group_5__1 : rule__ReferenceType__Group_5__1__Impl ;
    public final void rule__ReferenceType__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4512:1: ( rule__ReferenceType__Group_5__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4513:2: rule__ReferenceType__Group_5__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_5__1__Impl_in_rule__ReferenceType__Group_5__19442);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4519:1: rule__ReferenceType__Group_5__1__Impl : ( ( rule__ReferenceType__Alternatives_5_1 ) ) ;
    public final void rule__ReferenceType__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4523:1: ( ( ( rule__ReferenceType__Alternatives_5_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4524:1: ( ( rule__ReferenceType__Alternatives_5_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4524:1: ( ( rule__ReferenceType__Alternatives_5_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4525:1: ( rule__ReferenceType__Alternatives_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getAlternatives_5_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4526:1: ( rule__ReferenceType__Alternatives_5_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4526:2: rule__ReferenceType__Alternatives_5_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Alternatives_5_1_in_rule__ReferenceType__Group_5__1__Impl9469);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4540:1: rule__ReferenceType__Group_6__0 : rule__ReferenceType__Group_6__0__Impl rule__ReferenceType__Group_6__1 ;
    public final void rule__ReferenceType__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4544:1: ( rule__ReferenceType__Group_6__0__Impl rule__ReferenceType__Group_6__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4545:2: rule__ReferenceType__Group_6__0__Impl rule__ReferenceType__Group_6__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_6__0__Impl_in_rule__ReferenceType__Group_6__09503);
            rule__ReferenceType__Group_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_6__1_in_rule__ReferenceType__Group_6__09506);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4552:1: rule__ReferenceType__Group_6__0__Impl : ( ':' ) ;
    public final void rule__ReferenceType__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4556:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4557:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4557:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4558:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getColonKeyword_6_0()); 
            }
            match(input,58,FollowSets000.FOLLOW_58_in_rule__ReferenceType__Group_6__0__Impl9534); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4571:1: rule__ReferenceType__Group_6__1 : rule__ReferenceType__Group_6__1__Impl ;
    public final void rule__ReferenceType__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4575:1: ( rule__ReferenceType__Group_6__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4576:2: rule__ReferenceType__Group_6__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_6__1__Impl_in_rule__ReferenceType__Group_6__19565);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4582:1: rule__ReferenceType__Group_6__1__Impl : ( ( rule__ReferenceType__DescriptionAssignment_6_1 ) ) ;
    public final void rule__ReferenceType__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4586:1: ( ( ( rule__ReferenceType__DescriptionAssignment_6_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4587:1: ( ( rule__ReferenceType__DescriptionAssignment_6_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4587:1: ( ( rule__ReferenceType__DescriptionAssignment_6_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4588:1: ( rule__ReferenceType__DescriptionAssignment_6_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getDescriptionAssignment_6_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4589:1: ( rule__ReferenceType__DescriptionAssignment_6_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4589:2: rule__ReferenceType__DescriptionAssignment_6_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__DescriptionAssignment_6_1_in_rule__ReferenceType__Group_6__1__Impl9592);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4603:1: rule__OilObject__Group__0 : rule__OilObject__Group__0__Impl rule__OilObject__Group__1 ;
    public final void rule__OilObject__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4607:1: ( rule__OilObject__Group__0__Impl rule__OilObject__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4608:2: rule__OilObject__Group__0__Impl rule__OilObject__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__0__Impl_in_rule__OilObject__Group__09626);
            rule__OilObject__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__1_in_rule__OilObject__Group__09629);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4615:1: rule__OilObject__Group__0__Impl : ( ( rule__OilObject__TypeAssignment_0 ) ) ;
    public final void rule__OilObject__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4619:1: ( ( ( rule__OilObject__TypeAssignment_0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4620:1: ( ( rule__OilObject__TypeAssignment_0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4620:1: ( ( rule__OilObject__TypeAssignment_0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4621:1: ( rule__OilObject__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getTypeAssignment_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4622:1: ( rule__OilObject__TypeAssignment_0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4622:2: rule__OilObject__TypeAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__TypeAssignment_0_in_rule__OilObject__Group__0__Impl9656);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4632:1: rule__OilObject__Group__1 : rule__OilObject__Group__1__Impl rule__OilObject__Group__2 ;
    public final void rule__OilObject__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4636:1: ( rule__OilObject__Group__1__Impl rule__OilObject__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4637:2: rule__OilObject__Group__1__Impl rule__OilObject__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__1__Impl_in_rule__OilObject__Group__19686);
            rule__OilObject__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__2_in_rule__OilObject__Group__19689);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4644:1: rule__OilObject__Group__1__Impl : ( ( rule__OilObject__NameAssignment_1 ) ) ;
    public final void rule__OilObject__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4648:1: ( ( ( rule__OilObject__NameAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4649:1: ( ( rule__OilObject__NameAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4649:1: ( ( rule__OilObject__NameAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4650:1: ( rule__OilObject__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getNameAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4651:1: ( rule__OilObject__NameAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4651:2: rule__OilObject__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__NameAssignment_1_in_rule__OilObject__Group__1__Impl9716);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4661:1: rule__OilObject__Group__2 : rule__OilObject__Group__2__Impl rule__OilObject__Group__3 ;
    public final void rule__OilObject__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4665:1: ( rule__OilObject__Group__2__Impl rule__OilObject__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4666:2: rule__OilObject__Group__2__Impl rule__OilObject__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__2__Impl_in_rule__OilObject__Group__29746);
            rule__OilObject__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__3_in_rule__OilObject__Group__29749);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4673:1: rule__OilObject__Group__2__Impl : ( ( rule__OilObject__Group_2__0 )? ) ;
    public final void rule__OilObject__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4677:1: ( ( ( rule__OilObject__Group_2__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4678:1: ( ( rule__OilObject__Group_2__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4678:1: ( ( rule__OilObject__Group_2__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4679:1: ( rule__OilObject__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getGroup_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4680:1: ( rule__OilObject__Group_2__0 )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==56) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4680:2: rule__OilObject__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group_2__0_in_rule__OilObject__Group__2__Impl9776);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4690:1: rule__OilObject__Group__3 : rule__OilObject__Group__3__Impl rule__OilObject__Group__4 ;
    public final void rule__OilObject__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4694:1: ( rule__OilObject__Group__3__Impl rule__OilObject__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4695:2: rule__OilObject__Group__3__Impl rule__OilObject__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__3__Impl_in_rule__OilObject__Group__39807);
            rule__OilObject__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__4_in_rule__OilObject__Group__39810);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4702:1: rule__OilObject__Group__3__Impl : ( ( rule__OilObject__Group_3__0 )? ) ;
    public final void rule__OilObject__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4706:1: ( ( ( rule__OilObject__Group_3__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4707:1: ( ( rule__OilObject__Group_3__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4707:1: ( ( rule__OilObject__Group_3__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4708:1: ( rule__OilObject__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getGroup_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4709:1: ( rule__OilObject__Group_3__0 )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==58) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4709:2: rule__OilObject__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group_3__0_in_rule__OilObject__Group__3__Impl9837);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4719:1: rule__OilObject__Group__4 : rule__OilObject__Group__4__Impl ;
    public final void rule__OilObject__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4723:1: ( rule__OilObject__Group__4__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4724:2: rule__OilObject__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__4__Impl_in_rule__OilObject__Group__49868);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4730:1: rule__OilObject__Group__4__Impl : ( ';' ) ;
    public final void rule__OilObject__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4734:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4735:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4735:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4736:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getSemicolonKeyword_4()); 
            }
            match(input,54,FollowSets000.FOLLOW_54_in_rule__OilObject__Group__4__Impl9896); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4759:1: rule__OilObject__Group_2__0 : rule__OilObject__Group_2__0__Impl rule__OilObject__Group_2__1 ;
    public final void rule__OilObject__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4763:1: ( rule__OilObject__Group_2__0__Impl rule__OilObject__Group_2__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4764:2: rule__OilObject__Group_2__0__Impl rule__OilObject__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group_2__0__Impl_in_rule__OilObject__Group_2__09937);
            rule__OilObject__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group_2__1_in_rule__OilObject__Group_2__09940);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4771:1: rule__OilObject__Group_2__0__Impl : ( '{' ) ;
    public final void rule__OilObject__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4775:1: ( ( '{' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4776:1: ( '{' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4776:1: ( '{' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4777:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getLeftCurlyBracketKeyword_2_0()); 
            }
            match(input,56,FollowSets000.FOLLOW_56_in_rule__OilObject__Group_2__0__Impl9968); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4790:1: rule__OilObject__Group_2__1 : rule__OilObject__Group_2__1__Impl rule__OilObject__Group_2__2 ;
    public final void rule__OilObject__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4794:1: ( rule__OilObject__Group_2__1__Impl rule__OilObject__Group_2__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4795:2: rule__OilObject__Group_2__1__Impl rule__OilObject__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group_2__1__Impl_in_rule__OilObject__Group_2__19999);
            rule__OilObject__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group_2__2_in_rule__OilObject__Group_2__110002);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4802:1: rule__OilObject__Group_2__1__Impl : ( ( rule__OilObject__ParametersAssignment_2_1 )* ) ;
    public final void rule__OilObject__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4806:1: ( ( ( rule__OilObject__ParametersAssignment_2_1 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4807:1: ( ( rule__OilObject__ParametersAssignment_2_1 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4807:1: ( ( rule__OilObject__ParametersAssignment_2_1 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4808:1: ( rule__OilObject__ParametersAssignment_2_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getParametersAssignment_2_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4809:1: ( rule__OilObject__ParametersAssignment_2_1 )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==RULE_ID||(LA55_0>=13 && LA55_0<=47)) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4809:2: rule__OilObject__ParametersAssignment_2_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__OilObject__ParametersAssignment_2_1_in_rule__OilObject__Group_2__1__Impl10029);
            	    rule__OilObject__ParametersAssignment_2_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop55;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4819:1: rule__OilObject__Group_2__2 : rule__OilObject__Group_2__2__Impl ;
    public final void rule__OilObject__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4823:1: ( rule__OilObject__Group_2__2__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4824:2: rule__OilObject__Group_2__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group_2__2__Impl_in_rule__OilObject__Group_2__210060);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4830:1: rule__OilObject__Group_2__2__Impl : ( '}' ) ;
    public final void rule__OilObject__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4834:1: ( ( '}' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4835:1: ( '}' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4835:1: ( '}' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4836:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getRightCurlyBracketKeyword_2_2()); 
            }
            match(input,57,FollowSets000.FOLLOW_57_in_rule__OilObject__Group_2__2__Impl10088); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4855:1: rule__OilObject__Group_3__0 : rule__OilObject__Group_3__0__Impl rule__OilObject__Group_3__1 ;
    public final void rule__OilObject__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4859:1: ( rule__OilObject__Group_3__0__Impl rule__OilObject__Group_3__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4860:2: rule__OilObject__Group_3__0__Impl rule__OilObject__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group_3__0__Impl_in_rule__OilObject__Group_3__010125);
            rule__OilObject__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group_3__1_in_rule__OilObject__Group_3__010128);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4867:1: rule__OilObject__Group_3__0__Impl : ( ':' ) ;
    public final void rule__OilObject__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4871:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4872:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4872:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4873:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getColonKeyword_3_0()); 
            }
            match(input,58,FollowSets000.FOLLOW_58_in_rule__OilObject__Group_3__0__Impl10156); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4886:1: rule__OilObject__Group_3__1 : rule__OilObject__Group_3__1__Impl ;
    public final void rule__OilObject__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4890:1: ( rule__OilObject__Group_3__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4891:2: rule__OilObject__Group_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group_3__1__Impl_in_rule__OilObject__Group_3__110187);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4897:1: rule__OilObject__Group_3__1__Impl : ( ( rule__OilObject__DescriptionAssignment_3_1 ) ) ;
    public final void rule__OilObject__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4901:1: ( ( ( rule__OilObject__DescriptionAssignment_3_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4902:1: ( ( rule__OilObject__DescriptionAssignment_3_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4902:1: ( ( rule__OilObject__DescriptionAssignment_3_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4903:1: ( rule__OilObject__DescriptionAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getDescriptionAssignment_3_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4904:1: ( rule__OilObject__DescriptionAssignment_3_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4904:2: rule__OilObject__DescriptionAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__DescriptionAssignment_3_1_in_rule__OilObject__Group_3__1__Impl10214);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4918:1: rule__Parameter__Group__0 : rule__Parameter__Group__0__Impl rule__Parameter__Group__1 ;
    public final void rule__Parameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4922:1: ( rule__Parameter__Group__0__Impl rule__Parameter__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4923:2: rule__Parameter__Group__0__Impl rule__Parameter__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__0__Impl_in_rule__Parameter__Group__010248);
            rule__Parameter__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__1_in_rule__Parameter__Group__010251);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4930:1: rule__Parameter__Group__0__Impl : ( () ) ;
    public final void rule__Parameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4934:1: ( ( () ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4935:1: ( () )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4935:1: ( () )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4936:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getParameterAction_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4937:1: ()
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4939:1: 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4949:1: rule__Parameter__Group__1 : rule__Parameter__Group__1__Impl rule__Parameter__Group__2 ;
    public final void rule__Parameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4953:1: ( rule__Parameter__Group__1__Impl rule__Parameter__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4954:2: rule__Parameter__Group__1__Impl rule__Parameter__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__1__Impl_in_rule__Parameter__Group__110309);
            rule__Parameter__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__2_in_rule__Parameter__Group__110312);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4961:1: rule__Parameter__Group__1__Impl : ( ( rule__Parameter__TypeAssignment_1 ) ) ;
    public final void rule__Parameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4965:1: ( ( ( rule__Parameter__TypeAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4966:1: ( ( rule__Parameter__TypeAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4966:1: ( ( rule__Parameter__TypeAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4967:1: ( rule__Parameter__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getTypeAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4968:1: ( rule__Parameter__TypeAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4968:2: rule__Parameter__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__TypeAssignment_1_in_rule__Parameter__Group__1__Impl10339);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4978:1: rule__Parameter__Group__2 : rule__Parameter__Group__2__Impl rule__Parameter__Group__3 ;
    public final void rule__Parameter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4982:1: ( rule__Parameter__Group__2__Impl rule__Parameter__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4983:2: rule__Parameter__Group__2__Impl rule__Parameter__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__2__Impl_in_rule__Parameter__Group__210369);
            rule__Parameter__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__3_in_rule__Parameter__Group__210372);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4990:1: rule__Parameter__Group__2__Impl : ( '=' ) ;
    public final void rule__Parameter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4994:1: ( ( '=' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4995:1: ( '=' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4995:1: ( '=' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4996:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getEqualsSignKeyword_2()); 
            }
            match(input,53,FollowSets000.FOLLOW_53_in_rule__Parameter__Group__2__Impl10400); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5009:1: rule__Parameter__Group__3 : rule__Parameter__Group__3__Impl rule__Parameter__Group__4 ;
    public final void rule__Parameter__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5013:1: ( rule__Parameter__Group__3__Impl rule__Parameter__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5014:2: rule__Parameter__Group__3__Impl rule__Parameter__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__3__Impl_in_rule__Parameter__Group__310431);
            rule__Parameter__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__4_in_rule__Parameter__Group__310434);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5021:1: rule__Parameter__Group__3__Impl : ( ( rule__Parameter__Alternatives_3 ) ) ;
    public final void rule__Parameter__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5025:1: ( ( ( rule__Parameter__Alternatives_3 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5026:1: ( ( rule__Parameter__Alternatives_3 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5026:1: ( ( rule__Parameter__Alternatives_3 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5027:1: ( rule__Parameter__Alternatives_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getAlternatives_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5028:1: ( rule__Parameter__Alternatives_3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5028:2: rule__Parameter__Alternatives_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Alternatives_3_in_rule__Parameter__Group__3__Impl10461);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5038:1: rule__Parameter__Group__4 : rule__Parameter__Group__4__Impl rule__Parameter__Group__5 ;
    public final void rule__Parameter__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5042:1: ( rule__Parameter__Group__4__Impl rule__Parameter__Group__5 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5043:2: rule__Parameter__Group__4__Impl rule__Parameter__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__4__Impl_in_rule__Parameter__Group__410491);
            rule__Parameter__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__5_in_rule__Parameter__Group__410494);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5050:1: rule__Parameter__Group__4__Impl : ( ( rule__Parameter__Group_4__0 )? ) ;
    public final void rule__Parameter__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5054:1: ( ( ( rule__Parameter__Group_4__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5055:1: ( ( rule__Parameter__Group_4__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5055:1: ( ( rule__Parameter__Group_4__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5056:1: ( rule__Parameter__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getGroup_4()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5057:1: ( rule__Parameter__Group_4__0 )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==56) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5057:2: rule__Parameter__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_4__0_in_rule__Parameter__Group__4__Impl10521);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5067:1: rule__Parameter__Group__5 : rule__Parameter__Group__5__Impl rule__Parameter__Group__6 ;
    public final void rule__Parameter__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5071:1: ( rule__Parameter__Group__5__Impl rule__Parameter__Group__6 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5072:2: rule__Parameter__Group__5__Impl rule__Parameter__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__5__Impl_in_rule__Parameter__Group__510552);
            rule__Parameter__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__6_in_rule__Parameter__Group__510555);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5079:1: rule__Parameter__Group__5__Impl : ( ( rule__Parameter__Group_5__0 )? ) ;
    public final void rule__Parameter__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5083:1: ( ( ( rule__Parameter__Group_5__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5084:1: ( ( rule__Parameter__Group_5__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5084:1: ( ( rule__Parameter__Group_5__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5085:1: ( rule__Parameter__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getGroup_5()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5086:1: ( rule__Parameter__Group_5__0 )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==58) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5086:2: rule__Parameter__Group_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_5__0_in_rule__Parameter__Group__5__Impl10582);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5096:1: rule__Parameter__Group__6 : rule__Parameter__Group__6__Impl ;
    public final void rule__Parameter__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5100:1: ( rule__Parameter__Group__6__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5101:2: rule__Parameter__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__6__Impl_in_rule__Parameter__Group__610613);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5107:1: rule__Parameter__Group__6__Impl : ( ';' ) ;
    public final void rule__Parameter__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5111:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5112:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5112:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5113:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getSemicolonKeyword_6()); 
            }
            match(input,54,FollowSets000.FOLLOW_54_in_rule__Parameter__Group__6__Impl10641); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5140:1: rule__Parameter__Group_4__0 : rule__Parameter__Group_4__0__Impl rule__Parameter__Group_4__1 ;
    public final void rule__Parameter__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5144:1: ( rule__Parameter__Group_4__0__Impl rule__Parameter__Group_4__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5145:2: rule__Parameter__Group_4__0__Impl rule__Parameter__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_4__0__Impl_in_rule__Parameter__Group_4__010686);
            rule__Parameter__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_4__1_in_rule__Parameter__Group_4__010689);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5152:1: rule__Parameter__Group_4__0__Impl : ( '{' ) ;
    public final void rule__Parameter__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5156:1: ( ( '{' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5157:1: ( '{' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5157:1: ( '{' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5158:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getLeftCurlyBracketKeyword_4_0()); 
            }
            match(input,56,FollowSets000.FOLLOW_56_in_rule__Parameter__Group_4__0__Impl10717); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5171:1: rule__Parameter__Group_4__1 : rule__Parameter__Group_4__1__Impl rule__Parameter__Group_4__2 ;
    public final void rule__Parameter__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5175:1: ( rule__Parameter__Group_4__1__Impl rule__Parameter__Group_4__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5176:2: rule__Parameter__Group_4__1__Impl rule__Parameter__Group_4__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_4__1__Impl_in_rule__Parameter__Group_4__110748);
            rule__Parameter__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_4__2_in_rule__Parameter__Group_4__110751);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5183:1: rule__Parameter__Group_4__1__Impl : ( ( rule__Parameter__ParametersAssignment_4_1 )* ) ;
    public final void rule__Parameter__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5187:1: ( ( ( rule__Parameter__ParametersAssignment_4_1 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5188:1: ( ( rule__Parameter__ParametersAssignment_4_1 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5188:1: ( ( rule__Parameter__ParametersAssignment_4_1 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5189:1: ( rule__Parameter__ParametersAssignment_4_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getParametersAssignment_4_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5190:1: ( rule__Parameter__ParametersAssignment_4_1 )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==RULE_ID||(LA58_0>=13 && LA58_0<=47)) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5190:2: rule__Parameter__ParametersAssignment_4_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Parameter__ParametersAssignment_4_1_in_rule__Parameter__Group_4__1__Impl10778);
            	    rule__Parameter__ParametersAssignment_4_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop58;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5200:1: rule__Parameter__Group_4__2 : rule__Parameter__Group_4__2__Impl ;
    public final void rule__Parameter__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5204:1: ( rule__Parameter__Group_4__2__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5205:2: rule__Parameter__Group_4__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_4__2__Impl_in_rule__Parameter__Group_4__210809);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5211:1: rule__Parameter__Group_4__2__Impl : ( '}' ) ;
    public final void rule__Parameter__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5215:1: ( ( '}' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5216:1: ( '}' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5216:1: ( '}' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5217:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getRightCurlyBracketKeyword_4_2()); 
            }
            match(input,57,FollowSets000.FOLLOW_57_in_rule__Parameter__Group_4__2__Impl10837); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5236:1: rule__Parameter__Group_5__0 : rule__Parameter__Group_5__0__Impl rule__Parameter__Group_5__1 ;
    public final void rule__Parameter__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5240:1: ( rule__Parameter__Group_5__0__Impl rule__Parameter__Group_5__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5241:2: rule__Parameter__Group_5__0__Impl rule__Parameter__Group_5__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_5__0__Impl_in_rule__Parameter__Group_5__010874);
            rule__Parameter__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_5__1_in_rule__Parameter__Group_5__010877);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5248:1: rule__Parameter__Group_5__0__Impl : ( ':' ) ;
    public final void rule__Parameter__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5252:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5253:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5253:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5254:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getColonKeyword_5_0()); 
            }
            match(input,58,FollowSets000.FOLLOW_58_in_rule__Parameter__Group_5__0__Impl10905); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5267:1: rule__Parameter__Group_5__1 : rule__Parameter__Group_5__1__Impl ;
    public final void rule__Parameter__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5271:1: ( rule__Parameter__Group_5__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5272:2: rule__Parameter__Group_5__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_5__1__Impl_in_rule__Parameter__Group_5__110936);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5278:1: rule__Parameter__Group_5__1__Impl : ( ( rule__Parameter__DescriptionAssignment_5_1 ) ) ;
    public final void rule__Parameter__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5282:1: ( ( ( rule__Parameter__DescriptionAssignment_5_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5283:1: ( ( rule__Parameter__DescriptionAssignment_5_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5283:1: ( ( rule__Parameter__DescriptionAssignment_5_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5284:1: ( rule__Parameter__DescriptionAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getDescriptionAssignment_5_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5285:1: ( rule__Parameter__DescriptionAssignment_5_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5285:2: rule__Parameter__DescriptionAssignment_5_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__DescriptionAssignment_5_1_in_rule__Parameter__Group_5__1__Impl10963);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5299:1: rule__INT__Group__0 : rule__INT__Group__0__Impl rule__INT__Group__1 ;
    public final void rule__INT__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5303:1: ( rule__INT__Group__0__Impl rule__INT__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5304:2: rule__INT__Group__0__Impl rule__INT__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__INT__Group__0__Impl_in_rule__INT__Group__010997);
            rule__INT__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__INT__Group__1_in_rule__INT__Group__011000);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5311:1: rule__INT__Group__0__Impl : ( ( rule__INT__Alternatives_0 )? ) ;
    public final void rule__INT__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5315:1: ( ( ( rule__INT__Alternatives_0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5316:1: ( ( rule__INT__Alternatives_0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5316:1: ( ( rule__INT__Alternatives_0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5317:1: ( rule__INT__Alternatives_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getINTAccess().getAlternatives_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5318:1: ( rule__INT__Alternatives_0 )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( ((LA59_0>=48 && LA59_0<=49)) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5318:2: rule__INT__Alternatives_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__INT__Alternatives_0_in_rule__INT__Group__0__Impl11027);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5328:1: rule__INT__Group__1 : rule__INT__Group__1__Impl ;
    public final void rule__INT__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5332:1: ( rule__INT__Group__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5333:2: rule__INT__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__INT__Group__1__Impl_in_rule__INT__Group__111058);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5339:1: rule__INT__Group__1__Impl : ( ( rule__INT__Alternatives_1 ) ) ;
    public final void rule__INT__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5343:1: ( ( ( rule__INT__Alternatives_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5344:1: ( ( rule__INT__Alternatives_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5344:1: ( ( rule__INT__Alternatives_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5345:1: ( rule__INT__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getINTAccess().getAlternatives_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5346:1: ( rule__INT__Alternatives_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5346:2: rule__INT__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__INT__Alternatives_1_in_rule__INT__Group__1__Impl11085);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5360:1: rule__INT__Group_1_0__0 : rule__INT__Group_1_0__0__Impl rule__INT__Group_1_0__1 ;
    public final void rule__INT__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5364:1: ( rule__INT__Group_1_0__0__Impl rule__INT__Group_1_0__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5365:2: rule__INT__Group_1_0__0__Impl rule__INT__Group_1_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__INT__Group_1_0__0__Impl_in_rule__INT__Group_1_0__011119);
            rule__INT__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__INT__Group_1_0__1_in_rule__INT__Group_1_0__011122);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5372:1: rule__INT__Group_1_0__0__Impl : ( RULE_NON_ZERO_INT ) ;
    public final void rule__INT__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5376:1: ( ( RULE_NON_ZERO_INT ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5377:1: ( RULE_NON_ZERO_INT )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5377:1: ( RULE_NON_ZERO_INT )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5378:1: RULE_NON_ZERO_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getINTAccess().getNON_ZERO_INTTerminalRuleCall_1_0_0()); 
            }
            match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_rule__INT__Group_1_0__0__Impl11149); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5389:1: rule__INT__Group_1_0__1 : rule__INT__Group_1_0__1__Impl ;
    public final void rule__INT__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5393:1: ( rule__INT__Group_1_0__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5394:2: rule__INT__Group_1_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__INT__Group_1_0__1__Impl_in_rule__INT__Group_1_0__111178);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5400:1: rule__INT__Group_1_0__1__Impl : ( ( rule__INT__Alternatives_1_0_1 )* ) ;
    public final void rule__INT__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5404:1: ( ( ( rule__INT__Alternatives_1_0_1 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5405:1: ( ( rule__INT__Alternatives_1_0_1 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5405:1: ( ( rule__INT__Alternatives_1_0_1 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5406:1: ( rule__INT__Alternatives_1_0_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getINTAccess().getAlternatives_1_0_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5407:1: ( rule__INT__Alternatives_1_0_1 )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==RULE_ZERO_INT||LA60_0==RULE_NON_ZERO_INT) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5407:2: rule__INT__Alternatives_1_0_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__INT__Alternatives_1_0_1_in_rule__INT__Group_1_0__1__Impl11205);
            	    rule__INT__Alternatives_1_0_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop60;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5421:1: rule__DOUBLE__Group__0 : rule__DOUBLE__Group__0__Impl rule__DOUBLE__Group__1 ;
    public final void rule__DOUBLE__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5425:1: ( rule__DOUBLE__Group__0__Impl rule__DOUBLE__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5426:2: rule__DOUBLE__Group__0__Impl rule__DOUBLE__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Group__0__Impl_in_rule__DOUBLE__Group__011240);
            rule__DOUBLE__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Group__1_in_rule__DOUBLE__Group__011243);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5433:1: rule__DOUBLE__Group__0__Impl : ( ( rule__DOUBLE__Alternatives_0 )? ) ;
    public final void rule__DOUBLE__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5437:1: ( ( ( rule__DOUBLE__Alternatives_0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5438:1: ( ( rule__DOUBLE__Alternatives_0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5438:1: ( ( rule__DOUBLE__Alternatives_0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5439:1: ( rule__DOUBLE__Alternatives_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDOUBLEAccess().getAlternatives_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5440:1: ( rule__DOUBLE__Alternatives_0 )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( ((LA61_0>=48 && LA61_0<=49)) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5440:2: rule__DOUBLE__Alternatives_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Alternatives_0_in_rule__DOUBLE__Group__0__Impl11270);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5450:1: rule__DOUBLE__Group__1 : rule__DOUBLE__Group__1__Impl rule__DOUBLE__Group__2 ;
    public final void rule__DOUBLE__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5454:1: ( rule__DOUBLE__Group__1__Impl rule__DOUBLE__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5455:2: rule__DOUBLE__Group__1__Impl rule__DOUBLE__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Group__1__Impl_in_rule__DOUBLE__Group__111301);
            rule__DOUBLE__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Group__2_in_rule__DOUBLE__Group__111304);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5462:1: rule__DOUBLE__Group__1__Impl : ( ( rule__DOUBLE__Alternatives_1 ) ) ;
    public final void rule__DOUBLE__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5466:1: ( ( ( rule__DOUBLE__Alternatives_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5467:1: ( ( rule__DOUBLE__Alternatives_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5467:1: ( ( rule__DOUBLE__Alternatives_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5468:1: ( rule__DOUBLE__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDOUBLEAccess().getAlternatives_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5469:1: ( rule__DOUBLE__Alternatives_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5469:2: rule__DOUBLE__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Alternatives_1_in_rule__DOUBLE__Group__1__Impl11331);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5479:1: rule__DOUBLE__Group__2 : rule__DOUBLE__Group__2__Impl rule__DOUBLE__Group__3 ;
    public final void rule__DOUBLE__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5483:1: ( rule__DOUBLE__Group__2__Impl rule__DOUBLE__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5484:2: rule__DOUBLE__Group__2__Impl rule__DOUBLE__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Group__2__Impl_in_rule__DOUBLE__Group__211361);
            rule__DOUBLE__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Group__3_in_rule__DOUBLE__Group__211364);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5491:1: rule__DOUBLE__Group__2__Impl : ( ( '.' ) ) ;
    public final void rule__DOUBLE__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5495:1: ( ( ( '.' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5496:1: ( ( '.' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5496:1: ( ( '.' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5497:1: ( '.' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDOUBLEAccess().getFullStopKeyword_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5498:1: ( '.' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5499:2: '.'
            {
            match(input,64,FollowSets000.FOLLOW_64_in_rule__DOUBLE__Group__2__Impl11393); if (state.failed) return ;

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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5510:1: rule__DOUBLE__Group__3 : rule__DOUBLE__Group__3__Impl ;
    public final void rule__DOUBLE__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5514:1: ( rule__DOUBLE__Group__3__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5515:2: rule__DOUBLE__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Group__3__Impl_in_rule__DOUBLE__Group__311425);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5521:1: rule__DOUBLE__Group__3__Impl : ( ( ( rule__DOUBLE__Alternatives_3 ) ) ( ( rule__DOUBLE__Alternatives_3 )* ) ) ;
    public final void rule__DOUBLE__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5525:1: ( ( ( ( rule__DOUBLE__Alternatives_3 ) ) ( ( rule__DOUBLE__Alternatives_3 )* ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5526:1: ( ( ( rule__DOUBLE__Alternatives_3 ) ) ( ( rule__DOUBLE__Alternatives_3 )* ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5526:1: ( ( ( rule__DOUBLE__Alternatives_3 ) ) ( ( rule__DOUBLE__Alternatives_3 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5527:1: ( ( rule__DOUBLE__Alternatives_3 ) ) ( ( rule__DOUBLE__Alternatives_3 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5527:1: ( ( rule__DOUBLE__Alternatives_3 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5528:1: ( rule__DOUBLE__Alternatives_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDOUBLEAccess().getAlternatives_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5529:1: ( rule__DOUBLE__Alternatives_3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5529:2: rule__DOUBLE__Alternatives_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Alternatives_3_in_rule__DOUBLE__Group__3__Impl11454);
            rule__DOUBLE__Alternatives_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDOUBLEAccess().getAlternatives_3()); 
            }

            }

            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5532:1: ( ( rule__DOUBLE__Alternatives_3 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5533:1: ( rule__DOUBLE__Alternatives_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDOUBLEAccess().getAlternatives_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5534:1: ( rule__DOUBLE__Alternatives_3 )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==RULE_ZERO_INT||LA62_0==RULE_NON_ZERO_INT) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5534:2: rule__DOUBLE__Alternatives_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Alternatives_3_in_rule__DOUBLE__Group__3__Impl11466);
            	    rule__DOUBLE__Alternatives_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop62;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5553:1: rule__DOUBLE__Group_1_1__0 : rule__DOUBLE__Group_1_1__0__Impl rule__DOUBLE__Group_1_1__1 ;
    public final void rule__DOUBLE__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5557:1: ( rule__DOUBLE__Group_1_1__0__Impl rule__DOUBLE__Group_1_1__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5558:2: rule__DOUBLE__Group_1_1__0__Impl rule__DOUBLE__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Group_1_1__0__Impl_in_rule__DOUBLE__Group_1_1__011507);
            rule__DOUBLE__Group_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Group_1_1__1_in_rule__DOUBLE__Group_1_1__011510);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5565:1: rule__DOUBLE__Group_1_1__0__Impl : ( RULE_NON_ZERO_INT ) ;
    public final void rule__DOUBLE__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5569:1: ( ( RULE_NON_ZERO_INT ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5570:1: ( RULE_NON_ZERO_INT )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5570:1: ( RULE_NON_ZERO_INT )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5571:1: RULE_NON_ZERO_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDOUBLEAccess().getNON_ZERO_INTTerminalRuleCall_1_1_0()); 
            }
            match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_rule__DOUBLE__Group_1_1__0__Impl11537); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5582:1: rule__DOUBLE__Group_1_1__1 : rule__DOUBLE__Group_1_1__1__Impl ;
    public final void rule__DOUBLE__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5586:1: ( rule__DOUBLE__Group_1_1__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5587:2: rule__DOUBLE__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Group_1_1__1__Impl_in_rule__DOUBLE__Group_1_1__111566);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5593:1: rule__DOUBLE__Group_1_1__1__Impl : ( ( rule__DOUBLE__Alternatives_1_1_1 )* ) ;
    public final void rule__DOUBLE__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5597:1: ( ( ( rule__DOUBLE__Alternatives_1_1_1 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5598:1: ( ( rule__DOUBLE__Alternatives_1_1_1 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5598:1: ( ( rule__DOUBLE__Alternatives_1_1_1 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5599:1: ( rule__DOUBLE__Alternatives_1_1_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDOUBLEAccess().getAlternatives_1_1_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5600:1: ( rule__DOUBLE__Alternatives_1_1_1 )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==RULE_ZERO_INT||LA63_0==RULE_NON_ZERO_INT) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5600:2: rule__DOUBLE__Alternatives_1_1_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__DOUBLE__Alternatives_1_1_1_in_rule__DOUBLE__Group_1_1__1__Impl11593);
            	    rule__DOUBLE__Alternatives_1_1_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop63;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5615:1: rule__OilFile__OilVersionAssignment_1_2 : ( RULE_STRING ) ;
    public final void rule__OilFile__OilVersionAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5619:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5620:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5620:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5621:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getOilVersionSTRINGTerminalRuleCall_1_2_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__OilFile__OilVersionAssignment_1_211633); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5630:1: rule__OilFile__ImplementationAssignment_2 : ( ruleOilImplementation ) ;
    public final void rule__OilFile__ImplementationAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5634:1: ( ( ruleOilImplementation ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5635:1: ( ruleOilImplementation )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5635:1: ( ruleOilImplementation )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5636:1: ruleOilImplementation
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getImplementationOilImplementationParserRuleCall_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOilImplementation_in_rule__OilFile__ImplementationAssignment_211664);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5645:1: rule__OilFile__ApplicationAssignment_3 : ( ruleOilApplication ) ;
    public final void rule__OilFile__ApplicationAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5649:1: ( ( ruleOilApplication ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5650:1: ( ruleOilApplication )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5650:1: ( ruleOilApplication )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5651:1: ruleOilApplication
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getApplicationOilApplicationParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOilApplication_in_rule__OilFile__ApplicationAssignment_311695);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5660:1: rule__OilImplementation__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__OilImplementation__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5664:1: ( ( RULE_ID ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5665:1: ( RULE_ID )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5665:1: ( RULE_ID )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5666:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__OilImplementation__NameAssignment_111726); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5675:1: rule__OilImplementation__OilObjectsAssignment_3 : ( ruleOilObjectImpl ) ;
    public final void rule__OilImplementation__OilObjectsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5679:1: ( ( ruleOilObjectImpl ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5680:1: ( ruleOilObjectImpl )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5680:1: ( ruleOilObjectImpl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5681:1: ruleOilObjectImpl
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getOilObjectsOilObjectImplParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOilObjectImpl_in_rule__OilImplementation__OilObjectsAssignment_311757);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5690:1: rule__OilObjectImpl__TypeAssignment_0 : ( ruleObjectType ) ;
    public final void rule__OilObjectImpl__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5694:1: ( ( ruleObjectType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5695:1: ( ruleObjectType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5695:1: ( ruleObjectType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5696:1: ruleObjectType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getTypeObjectTypeEnumRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleObjectType_in_rule__OilObjectImpl__TypeAssignment_011788);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5705:1: rule__OilObjectImpl__ParametersAssignment_2 : ( ruleParameterType ) ;
    public final void rule__OilObjectImpl__ParametersAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5709:1: ( ( ruleParameterType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5710:1: ( ruleParameterType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5710:1: ( ruleParameterType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5711:1: ruleParameterType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getParametersParameterTypeParserRuleCall_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameterType_in_rule__OilObjectImpl__ParametersAssignment_211819);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5720:1: rule__OilObjectImpl__DescriptionAssignment_4_1 : ( RULE_STRING ) ;
    public final void rule__OilObjectImpl__DescriptionAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5724:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5725:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5725:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5726:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getDescriptionSTRINGTerminalRuleCall_4_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__OilObjectImpl__DescriptionAssignment_4_111850); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5735:1: rule__OilApplication__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__OilApplication__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5739:1: ( ( RULE_ID ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5740:1: ( RULE_ID )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5740:1: ( RULE_ID )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5741:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__OilApplication__NameAssignment_111881); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5750:1: rule__OilApplication__OilObjectsAssignment_3 : ( ruleOilObject ) ;
    public final void rule__OilApplication__OilObjectsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5754:1: ( ( ruleOilObject ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5755:1: ( ruleOilObject )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5755:1: ( ruleOilObject )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5756:1: ruleOilObject
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getOilObjectsOilObjectParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOilObject_in_rule__OilApplication__OilObjectsAssignment_311912);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5765:1: rule__OilApplication__DescriptionAssignment_5_1 : ( RULE_STRING ) ;
    public final void rule__OilApplication__DescriptionAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5769:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5770:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5770:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5771:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getDescriptionSTRINGTerminalRuleCall_5_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__OilApplication__DescriptionAssignment_5_111943); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5780:1: rule__ValueType__TypeAssignment_1 : ( ruleVType ) ;
    public final void rule__ValueType__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5784:1: ( ( ruleVType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5785:1: ( ruleVType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5785:1: ( ruleVType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5786:1: ruleVType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getTypeVTypeEnumRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVType_in_rule__ValueType__TypeAssignment_111974);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5795:1: rule__ValueType__WithAutoAssignment_2 : ( ( 'WITH_AUTO' ) ) ;
    public final void rule__ValueType__WithAutoAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5799:1: ( ( ( 'WITH_AUTO' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5800:1: ( ( 'WITH_AUTO' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5800:1: ( ( 'WITH_AUTO' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5801:1: ( 'WITH_AUTO' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getWithAutoWITH_AUTOKeyword_2_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5802:1: ( 'WITH_AUTO' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5803:1: 'WITH_AUTO'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getWithAutoWITH_AUTOKeyword_2_0()); 
            }
            match(input,65,FollowSets000.FOLLOW_65_in_rule__ValueType__WithAutoAssignment_212010); if (state.failed) return ;
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


    // $ANTLR start "rule__ValueType__NameAssignment_4"
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5818:1: rule__ValueType__NameAssignment_4 : ( ruleSpecialId ) ;
    public final void rule__ValueType__NameAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5822:1: ( ( ruleSpecialId ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5823:1: ( ruleSpecialId )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5823:1: ( ruleSpecialId )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5824:1: ruleSpecialId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getNameSpecialIdParserRuleCall_4_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_rule__ValueType__NameAssignment_412049);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5833:1: rule__ValueType__MultiValueAssignment_5 : ( ( '[]' ) ) ;
    public final void rule__ValueType__MultiValueAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5837:1: ( ( ( '[]' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5838:1: ( ( '[]' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5838:1: ( ( '[]' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5839:1: ( '[]' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_5_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5840:1: ( '[]' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5841:1: '[]'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_5_0()); 
            }
            match(input,66,FollowSets000.FOLLOW_66_in_rule__ValueType__MultiValueAssignment_512085); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5856:1: rule__ValueType__DefaultAutoAssignment_6_1_0 : ( ( 'AUTO' ) ) ;
    public final void rule__ValueType__DefaultAutoAssignment_6_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5860:1: ( ( ( 'AUTO' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5861:1: ( ( 'AUTO' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5861:1: ( ( 'AUTO' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5862:1: ( 'AUTO' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getDefaultAutoAUTOKeyword_6_1_0_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5863:1: ( 'AUTO' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5864:1: 'AUTO'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getDefaultAutoAUTOKeyword_6_1_0_0()); 
            }
            match(input,67,FollowSets000.FOLLOW_67_in_rule__ValueType__DefaultAutoAssignment_6_1_012129); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5879:1: rule__ValueType__DefaultValueAssignment_6_1_1 : ( ( rule__ValueType__DefaultValueAlternatives_6_1_1_0 ) ) ;
    public final void rule__ValueType__DefaultValueAssignment_6_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5883:1: ( ( ( rule__ValueType__DefaultValueAlternatives_6_1_1_0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5884:1: ( ( rule__ValueType__DefaultValueAlternatives_6_1_1_0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5884:1: ( ( rule__ValueType__DefaultValueAlternatives_6_1_1_0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5885:1: ( rule__ValueType__DefaultValueAlternatives_6_1_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getDefaultValueAlternatives_6_1_1_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5886:1: ( rule__ValueType__DefaultValueAlternatives_6_1_1_0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5886:2: rule__ValueType__DefaultValueAlternatives_6_1_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__DefaultValueAlternatives_6_1_1_0_in_rule__ValueType__DefaultValueAssignment_6_1_112168);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5895:1: rule__ValueType__DescriptionAssignment_7_1 : ( RULE_STRING ) ;
    public final void rule__ValueType__DescriptionAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5899:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5900:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5900:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5901:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getDescriptionSTRINGTerminalRuleCall_7_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__ValueType__DescriptionAssignment_7_112201); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5910:1: rule__VariantType__TypeAssignment_1 : ( ruleEType ) ;
    public final void rule__VariantType__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5914:1: ( ( ruleEType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5915:1: ( ruleEType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5915:1: ( ruleEType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5916:1: ruleEType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getTypeETypeEnumRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEType_in_rule__VariantType__TypeAssignment_112232);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5925:1: rule__VariantType__WithAutoAssignment_2 : ( ( 'WITH_AUTO' ) ) ;
    public final void rule__VariantType__WithAutoAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5929:1: ( ( ( 'WITH_AUTO' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5930:1: ( ( 'WITH_AUTO' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5930:1: ( ( 'WITH_AUTO' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5931:1: ( 'WITH_AUTO' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getWithAutoWITH_AUTOKeyword_2_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5932:1: ( 'WITH_AUTO' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5933:1: 'WITH_AUTO'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getWithAutoWITH_AUTOKeyword_2_0()); 
            }
            match(input,65,FollowSets000.FOLLOW_65_in_rule__VariantType__WithAutoAssignment_212268); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5948:1: rule__VariantType__ValuesAssignment_3_1_0 : ( ruleEnumeratorType ) ;
    public final void rule__VariantType__ValuesAssignment_3_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5952:1: ( ( ruleEnumeratorType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5953:1: ( ruleEnumeratorType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5953:1: ( ruleEnumeratorType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5954:1: ruleEnumeratorType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getValuesEnumeratorTypeParserRuleCall_3_1_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEnumeratorType_in_rule__VariantType__ValuesAssignment_3_1_012307);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5963:1: rule__VariantType__ValuesAssignment_3_1_1_1 : ( ruleEnumeratorType ) ;
    public final void rule__VariantType__ValuesAssignment_3_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5967:1: ( ( ruleEnumeratorType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5968:1: ( ruleEnumeratorType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5968:1: ( ruleEnumeratorType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5969:1: ruleEnumeratorType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getValuesEnumeratorTypeParserRuleCall_3_1_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEnumeratorType_in_rule__VariantType__ValuesAssignment_3_1_1_112338);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5978:1: rule__VariantType__NameAssignment_4 : ( ruleSpecialId ) ;
    public final void rule__VariantType__NameAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5982:1: ( ( ruleSpecialId ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5983:1: ( ruleSpecialId )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5983:1: ( ruleSpecialId )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5984:1: ruleSpecialId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getNameSpecialIdParserRuleCall_4_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_rule__VariantType__NameAssignment_412369);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5993:1: rule__VariantType__MultiValueAssignment_5 : ( ( '[]' ) ) ;
    public final void rule__VariantType__MultiValueAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5997:1: ( ( ( '[]' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5998:1: ( ( '[]' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5998:1: ( ( '[]' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5999:1: ( '[]' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_5_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6000:1: ( '[]' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6001:1: '[]'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_5_0()); 
            }
            match(input,66,FollowSets000.FOLLOW_66_in_rule__VariantType__MultiValueAssignment_512405); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6016:1: rule__VariantType__DefaultAutoAssignment_6_1_0 : ( ( 'AUTO' ) ) ;
    public final void rule__VariantType__DefaultAutoAssignment_6_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6020:1: ( ( ( 'AUTO' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6021:1: ( ( 'AUTO' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6021:1: ( ( 'AUTO' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6022:1: ( 'AUTO' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getDefaultAutoAUTOKeyword_6_1_0_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6023:1: ( 'AUTO' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6024:1: 'AUTO'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getDefaultAutoAUTOKeyword_6_1_0_0()); 
            }
            match(input,67,FollowSets000.FOLLOW_67_in_rule__VariantType__DefaultAutoAssignment_6_1_012449); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6039:1: rule__VariantType__DefaultValueAssignment_6_1_1 : ( RULE_ID ) ;
    public final void rule__VariantType__DefaultValueAssignment_6_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6043:1: ( ( RULE_ID ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6044:1: ( RULE_ID )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6044:1: ( RULE_ID )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6045:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getDefaultValueIDTerminalRuleCall_6_1_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__VariantType__DefaultValueAssignment_6_1_112488); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6054:1: rule__VariantType__DescriptionAssignment_7_1 : ( RULE_STRING ) ;
    public final void rule__VariantType__DescriptionAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6058:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6059:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6059:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6060:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getDescriptionSTRINGTerminalRuleCall_7_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__VariantType__DescriptionAssignment_7_112519); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6069:1: rule__EnumeratorType__NameAssignment_1 : ( ruleSpecialId ) ;
    public final void rule__EnumeratorType__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6073:1: ( ( ruleSpecialId ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6074:1: ( ruleSpecialId )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6074:1: ( ruleSpecialId )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6075:1: ruleSpecialId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getNameSpecialIdParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_rule__EnumeratorType__NameAssignment_112550);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6084:1: rule__EnumeratorType__ParametersAssignment_2_1 : ( ruleParameterType ) ;
    public final void rule__EnumeratorType__ParametersAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6088:1: ( ( ruleParameterType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6089:1: ( ruleParameterType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6089:1: ( ruleParameterType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6090:1: ruleParameterType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getParametersParameterTypeParserRuleCall_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameterType_in_rule__EnumeratorType__ParametersAssignment_2_112581);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6099:1: rule__EnumeratorType__DescriptionAssignment_3_1 : ( RULE_STRING ) ;
    public final void rule__EnumeratorType__DescriptionAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6103:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6104:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6104:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6105:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getDescriptionSTRINGTerminalRuleCall_3_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__EnumeratorType__DescriptionAssignment_3_112612); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6114:1: rule__ReferenceType__TypeAssignment_1 : ( ruleObjectTypeRef ) ;
    public final void rule__ReferenceType__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6118:1: ( ( ruleObjectTypeRef ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6119:1: ( ruleObjectTypeRef )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6119:1: ( ruleObjectTypeRef )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6120:1: ruleObjectTypeRef
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getTypeObjectTypeRefEnumRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleObjectTypeRef_in_rule__ReferenceType__TypeAssignment_112643);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6129:1: rule__ReferenceType__WithAutoAssignment_2 : ( ( 'WITH_AUTO' ) ) ;
    public final void rule__ReferenceType__WithAutoAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6133:1: ( ( ( 'WITH_AUTO' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6134:1: ( ( 'WITH_AUTO' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6134:1: ( ( 'WITH_AUTO' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6135:1: ( 'WITH_AUTO' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getWithAutoWITH_AUTOKeyword_2_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6136:1: ( 'WITH_AUTO' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6137:1: 'WITH_AUTO'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getWithAutoWITH_AUTOKeyword_2_0()); 
            }
            match(input,65,FollowSets000.FOLLOW_65_in_rule__ReferenceType__WithAutoAssignment_212679); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6152:1: rule__ReferenceType__NameAssignment_3 : ( ruleSpecialId ) ;
    public final void rule__ReferenceType__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6156:1: ( ( ruleSpecialId ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6157:1: ( ruleSpecialId )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6157:1: ( ruleSpecialId )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6158:1: ruleSpecialId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getNameSpecialIdParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_rule__ReferenceType__NameAssignment_312718);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6167:1: rule__ReferenceType__MultiValueAssignment_4 : ( ( '[]' ) ) ;
    public final void rule__ReferenceType__MultiValueAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6171:1: ( ( ( '[]' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6172:1: ( ( '[]' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6172:1: ( ( '[]' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6173:1: ( '[]' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_4_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6174:1: ( '[]' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6175:1: '[]'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_4_0()); 
            }
            match(input,66,FollowSets000.FOLLOW_66_in_rule__ReferenceType__MultiValueAssignment_412754); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6190:1: rule__ReferenceType__DefaultAutoAssignment_5_1_0 : ( ( 'AUTO' ) ) ;
    public final void rule__ReferenceType__DefaultAutoAssignment_5_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6194:1: ( ( ( 'AUTO' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6195:1: ( ( 'AUTO' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6195:1: ( ( 'AUTO' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6196:1: ( 'AUTO' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getDefaultAutoAUTOKeyword_5_1_0_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6197:1: ( 'AUTO' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6198:1: 'AUTO'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getDefaultAutoAUTOKeyword_5_1_0_0()); 
            }
            match(input,67,FollowSets000.FOLLOW_67_in_rule__ReferenceType__DefaultAutoAssignment_5_1_012798); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6213:1: rule__ReferenceType__DefaultValueAssignment_5_1_1 : ( RULE_ID ) ;
    public final void rule__ReferenceType__DefaultValueAssignment_5_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6217:1: ( ( RULE_ID ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6218:1: ( RULE_ID )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6218:1: ( RULE_ID )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6219:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getDefaultValueIDTerminalRuleCall_5_1_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ReferenceType__DefaultValueAssignment_5_1_112837); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6228:1: rule__ReferenceType__DescriptionAssignment_6_1 : ( RULE_STRING ) ;
    public final void rule__ReferenceType__DescriptionAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6232:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6233:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6233:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6234:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getDescriptionSTRINGTerminalRuleCall_6_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__ReferenceType__DescriptionAssignment_6_112868); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6243:1: rule__OilObject__TypeAssignment_0 : ( ruleObjectType ) ;
    public final void rule__OilObject__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6247:1: ( ( ruleObjectType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6248:1: ( ruleObjectType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6248:1: ( ruleObjectType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6249:1: ruleObjectType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getTypeObjectTypeEnumRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleObjectType_in_rule__OilObject__TypeAssignment_012899);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6258:1: rule__OilObject__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__OilObject__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6262:1: ( ( RULE_ID ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6263:1: ( RULE_ID )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6263:1: ( RULE_ID )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6264:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__OilObject__NameAssignment_112930); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6273:1: rule__OilObject__ParametersAssignment_2_1 : ( ruleParameter ) ;
    public final void rule__OilObject__ParametersAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6277:1: ( ( ruleParameter ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6278:1: ( ruleParameter )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6278:1: ( ruleParameter )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6279:1: ruleParameter
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getParametersParameterParserRuleCall_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_rule__OilObject__ParametersAssignment_2_112961);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6288:1: rule__OilObject__DescriptionAssignment_3_1 : ( RULE_STRING ) ;
    public final void rule__OilObject__DescriptionAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6292:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6293:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6293:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6294:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getDescriptionSTRINGTerminalRuleCall_3_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__OilObject__DescriptionAssignment_3_112992); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6303:1: rule__Parameter__TypeAssignment_1 : ( ( ruleSpecialId ) ) ;
    public final void rule__Parameter__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6307:1: ( ( ( ruleSpecialId ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6308:1: ( ( ruleSpecialId ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6308:1: ( ( ruleSpecialId ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6309:1: ( ruleSpecialId )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getTypeParameterTypeCrossReference_1_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6310:1: ( ruleSpecialId )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6311:1: ruleSpecialId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getTypeParameterTypeSpecialIdParserRuleCall_1_0_1()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_rule__Parameter__TypeAssignment_113027);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6322:1: rule__Parameter__AutoAssignment_3_0 : ( ( 'AUTO' ) ) ;
    public final void rule__Parameter__AutoAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6326:1: ( ( ( 'AUTO' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6327:1: ( ( 'AUTO' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6327:1: ( ( 'AUTO' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6328:1: ( 'AUTO' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getAutoAUTOKeyword_3_0_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6329:1: ( 'AUTO' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6330:1: 'AUTO'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getAutoAUTOKeyword_3_0_0()); 
            }
            match(input,67,FollowSets000.FOLLOW_67_in_rule__Parameter__AutoAssignment_3_013067); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6345:1: rule__Parameter__ValueAssignment_3_1 : ( ruleGenericValue ) ;
    public final void rule__Parameter__ValueAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6349:1: ( ( ruleGenericValue ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6350:1: ( ruleGenericValue )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6350:1: ( ruleGenericValue )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6351:1: ruleGenericValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getValueGenericValueParserRuleCall_3_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleGenericValue_in_rule__Parameter__ValueAssignment_3_113106);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6360:1: rule__Parameter__ValueRefAssignment_3_2 : ( ( ruleSpecialId ) ) ;
    public final void rule__Parameter__ValueRefAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6364:1: ( ( ( ruleSpecialId ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6365:1: ( ( ruleSpecialId ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6365:1: ( ( ruleSpecialId ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6366:1: ( ruleSpecialId )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getValueRefParameterRefCrossReference_3_2_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6367:1: ( ruleSpecialId )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6368:1: ruleSpecialId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getValueRefParameterRefSpecialIdParserRuleCall_3_2_0_1()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_rule__Parameter__ValueRefAssignment_3_213141);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6379:1: rule__Parameter__ParametersAssignment_4_1 : ( ruleParameter ) ;
    public final void rule__Parameter__ParametersAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6383:1: ( ( ruleParameter ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6384:1: ( ruleParameter )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6384:1: ( ruleParameter )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6385:1: ruleParameter
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getParametersParameterParserRuleCall_4_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_rule__Parameter__ParametersAssignment_4_113176);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6394:1: rule__Parameter__DescriptionAssignment_5_1 : ( RULE_STRING ) ;
    public final void rule__Parameter__DescriptionAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6398:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6399:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6399:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6400:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getDescriptionSTRINGTerminalRuleCall_5_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Parameter__DescriptionAssignment_5_113207); if (state.failed) return ;
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
    protected DFA3 dfa3 = new DFA3(this);
    protected DFA4 dfa4 = new DFA4(this);
    protected DFA5 dfa5 = new DFA5(this);
    protected DFA6 dfa6 = new DFA6(this);
    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA2_eotS =
        "\17\uffff";
    static final String DFA2_eofS =
        "\17\uffff";
    static final String DFA2_minS =
        "\4\6\2\75\3\6\2\uffff\4\6";
    static final String DFA2_maxS =
        "\1\61\2\10\2\100\1\77\2\100\1\10\2\uffff\4\77";
    static final String DFA2_acceptS =
        "\11\uffff\1\1\1\2\4\uffff";
    static final String DFA2_specialS =
        "\17\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\4\1\5\1\3\47\uffff\1\1\1\2",
            "\1\4\1\5\1\3",
            "\1\4\1\5\1\3",
            "\1\6\1\uffff\1\7\64\uffff\1\12\1\11\1\12\1\10",
            "\1\12\1\11\1\12\1\10",
            "\1\12\1\11\1\12",
            "\1\6\1\uffff\1\7\64\uffff\1\12\1\11\1\12\1\10",
            "\1\6\1\uffff\1\7\64\uffff\1\12\1\11\1\12\1\10",
            "\1\13\1\uffff\1\14",
            "",
            "",
            "\1\15\1\uffff\1\16\64\uffff\1\12\1\11\1\12",
            "\1\15\1\uffff\1\16\64\uffff\1\12\1\11\1\12",
            "\1\15\1\uffff\1\16\64\uffff\1\12\1\11\1\12",
            "\1\15\1\uffff\1\16\64\uffff\1\12\1\11\1\12"
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
            return "585:1: rule__ValueType__Alternatives_3_1 : ( ( ( rule__ValueType__Group_3_1_0__0 ) ) | ( ( rule__ValueType__Group_3_1_1__0 ) ) );";
        }
    }
    static final String DFA3_eotS =
        "\11\uffff";
    static final String DFA3_eofS =
        "\11\uffff";
    static final String DFA3_minS =
        "\4\6\1\76\1\uffff\2\6\1\uffff";
    static final String DFA3_maxS =
        "\1\61\2\10\2\100\1\uffff\2\100\1\uffff";
    static final String DFA3_acceptS =
        "\5\uffff\1\1\2\uffff\1\2";
    static final String DFA3_specialS =
        "\11\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\4\1\5\1\3\47\uffff\1\1\1\2",
            "\1\4\1\5\1\3",
            "\1\4\1\5\1\3",
            "\1\6\1\uffff\1\7\65\uffff\1\5\1\uffff\1\10",
            "\1\5\1\uffff\1\10",
            "",
            "\1\6\1\uffff\1\7\65\uffff\1\5\1\uffff\1\10",
            "\1\6\1\uffff\1\7\65\uffff\1\5\1\uffff\1\10",
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "607:1: rule__ValueType__Alternatives_3_1_0_0 : ( ( ruleINT ) | ( ruleDOUBLE ) );";
        }
    }
    static final String DFA4_eotS =
        "\11\uffff";
    static final String DFA4_eofS =
        "\3\uffff\2\5\1\uffff\2\5\1\uffff";
    static final String DFA4_minS =
        "\4\6\1\75\1\uffff\2\6\1\uffff";
    static final String DFA4_maxS =
        "\1\61\2\10\2\100\1\uffff\2\100\1\uffff";
    static final String DFA4_acceptS =
        "\5\uffff\1\1\2\uffff\1\2";
    static final String DFA4_specialS =
        "\11\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\4\1\5\1\3\47\uffff\1\1\1\2",
            "\1\4\1\5\1\3",
            "\1\4\1\5\1\3",
            "\1\6\1\uffff\1\7\64\uffff\1\5\2\uffff\1\10",
            "\1\5\2\uffff\1\10",
            "",
            "\1\6\1\uffff\1\7\64\uffff\1\5\2\uffff\1\10",
            "\1\6\1\uffff\1\7\64\uffff\1\5\2\uffff\1\10",
            ""
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "629:1: rule__ValueType__Alternatives_3_1_0_2 : ( ( ruleINT ) | ( ruleDOUBLE ) );";
        }
    }
    static final String DFA5_eotS =
        "\11\uffff";
    static final String DFA5_eofS =
        "\11\uffff";
    static final String DFA5_minS =
        "\4\6\1\75\1\uffff\2\6\1\uffff";
    static final String DFA5_maxS =
        "\1\61\2\10\2\100\1\uffff\2\100\1\uffff";
    static final String DFA5_acceptS =
        "\5\uffff\1\1\2\uffff\1\2";
    static final String DFA5_specialS =
        "\11\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\4\1\5\1\3\47\uffff\1\1\1\2",
            "\1\4\1\5\1\3",
            "\1\4\1\5\1\3",
            "\1\6\1\uffff\1\7\64\uffff\1\5\1\uffff\1\5\1\10",
            "\1\5\1\uffff\1\5\1\10",
            "",
            "\1\6\1\uffff\1\7\64\uffff\1\5\1\uffff\1\5\1\10",
            "\1\6\1\uffff\1\7\64\uffff\1\5\1\uffff\1\5\1\10",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "651:1: rule__ValueType__Alternatives_3_1_1_0 : ( ( ruleINT ) | ( ruleDOUBLE ) );";
        }
    }
    static final String DFA6_eotS =
        "\11\uffff";
    static final String DFA6_eofS =
        "\3\uffff\2\5\1\uffff\2\5\1\uffff";
    static final String DFA6_minS =
        "\4\6\1\75\1\uffff\2\6\1\uffff";
    static final String DFA6_maxS =
        "\1\61\2\10\2\100\1\uffff\2\100\1\uffff";
    static final String DFA6_acceptS =
        "\5\uffff\1\1\2\uffff\1\2";
    static final String DFA6_specialS =
        "\11\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\4\1\5\1\3\47\uffff\1\1\1\2",
            "\1\4\1\5\1\3",
            "\1\4\1\5\1\3",
            "\1\6\1\uffff\1\7\64\uffff\1\5\1\uffff\1\5\1\10",
            "\1\5\1\uffff\1\5\1\10",
            "",
            "\1\6\1\uffff\1\7\64\uffff\1\5\1\uffff\1\5\1\10",
            "\1\6\1\uffff\1\7\64\uffff\1\5\1\uffff\1\5\1\10",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "673:1: rule__ValueType__Alternatives_3_1_1_1_1 : ( ( ruleINT ) | ( ruleDOUBLE ) );";
        }
    }
    static final String DFA13_eotS =
        "\12\uffff";
    static final String DFA13_eofS =
        "\4\uffff\2\6\1\uffff\2\6\1\uffff";
    static final String DFA13_minS =
        "\1\5\1\uffff\3\6\1\66\1\uffff\2\6\1\uffff";
    static final String DFA13_maxS =
        "\1\61\1\uffff\2\10\2\100\1\uffff\2\100\1\uffff";
    static final String DFA13_acceptS =
        "\1\uffff\1\1\4\uffff\1\2\2\uffff\1\3";
    static final String DFA13_specialS =
        "\12\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\1\1\5\1\6\1\4\47\uffff\1\2\1\3",
            "",
            "\1\5\1\6\1\4",
            "\1\5\1\6\1\4",
            "\1\7\1\uffff\1\10\55\uffff\1\6\1\uffff\1\6\1\uffff\1\6\5\uffff"+
            "\1\11",
            "\1\6\1\uffff\1\6\1\uffff\1\6\5\uffff\1\11",
            "",
            "\1\7\1\uffff\1\10\55\uffff\1\6\1\uffff\1\6\1\uffff\1\6\5\uffff"+
            "\1\11",
            "\1\7\1\uffff\1\10\55\uffff\1\6\1\uffff\1\6\1\uffff\1\6\5\uffff"+
            "\1\11",
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
            return "1107:1: rule__GenericValue__Alternatives : ( ( RULE_STRING ) | ( ruleINT ) | ( ruleDOUBLE ) );";
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
        public static final BitSet FOLLOW_rule__ValueType__Group_3_1_0__0_in_rule__ValueType__Alternatives_3_11186 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_3_1_1__0_in_rule__ValueType__Alternatives_3_11204 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleINT_in_rule__ValueType__Alternatives_3_1_0_01237 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDOUBLE_in_rule__ValueType__Alternatives_3_1_0_01254 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleINT_in_rule__ValueType__Alternatives_3_1_0_21286 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDOUBLE_in_rule__ValueType__Alternatives_3_1_0_21303 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleINT_in_rule__ValueType__Alternatives_3_1_1_01335 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDOUBLE_in_rule__ValueType__Alternatives_3_1_1_01352 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleINT_in_rule__ValueType__Alternatives_3_1_1_1_11384 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDOUBLE_in_rule__ValueType__Alternatives_3_1_1_1_11401 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__DefaultAutoAssignment_6_1_0_in_rule__ValueType__Alternatives_6_11433 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__DefaultValueAssignment_6_1_1_in_rule__ValueType__Alternatives_6_11451 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGenericValue_in_rule__ValueType__DefaultValueAlternatives_6_1_1_01484 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ValueType__DefaultValueAlternatives_6_1_1_01501 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__DefaultAutoAssignment_6_1_0_in_rule__VariantType__Alternatives_6_11533 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__DefaultValueAssignment_6_1_1_in_rule__VariantType__Alternatives_6_11551 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__DefaultAutoAssignment_5_1_0_in_rule__ReferenceType__Alternatives_5_11584 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__DefaultValueAssignment_5_1_1_in_rule__ReferenceType__Alternatives_5_11602 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__AutoAssignment_3_0_in_rule__Parameter__Alternatives_31635 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__ValueAssignment_3_1_in_rule__Parameter__Alternatives_31653 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__ValueRefAssignment_3_2_in_rule__Parameter__Alternatives_31671 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__SpecialId__Alternatives1704 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__SpecialId__Alternatives1722 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__SpecialId__Alternatives1742 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__SpecialId__Alternatives1762 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__SpecialId__Alternatives1782 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__SpecialId__Alternatives1802 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__SpecialId__Alternatives1822 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__SpecialId__Alternatives1842 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__SpecialId__Alternatives1862 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__SpecialId__Alternatives1882 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__SpecialId__Alternatives1902 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__SpecialId__Alternatives1922 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__SpecialId__Alternatives1942 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__SpecialId__Alternatives1962 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__SpecialId__Alternatives1982 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__SpecialId__Alternatives2002 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__SpecialId__Alternatives2022 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__SpecialId__Alternatives2042 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__SpecialId__Alternatives2062 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__SpecialId__Alternatives2082 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__SpecialId__Alternatives2102 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__SpecialId__Alternatives2122 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__SpecialId__Alternatives2142 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__SpecialId__Alternatives2162 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_rule__SpecialId__Alternatives2182 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_rule__SpecialId__Alternatives2202 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_rule__SpecialId__Alternatives2222 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_rule__SpecialId__Alternatives2242 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_rule__SpecialId__Alternatives2262 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_rule__SpecialId__Alternatives2282 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_rule__SpecialId__Alternatives2302 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_rule__SpecialId__Alternatives2322 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_rule__SpecialId__Alternatives2342 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_rule__SpecialId__Alternatives2362 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_rule__SpecialId__Alternatives2382 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_rule__SpecialId__Alternatives2402 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__GenericValue__Alternatives2436 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleINT_in_rule__GenericValue__Alternatives2453 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDOUBLE_in_rule__GenericValue__Alternatives2470 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_rule__INT__Alternatives_02503 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_rule__INT__Alternatives_02523 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Group_1_0__0_in_rule__INT__Alternatives_12557 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_rule__INT__Alternatives_12575 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_HEX_in_rule__INT__Alternatives_12592 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_rule__INT__Alternatives_1_0_12624 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_rule__INT__Alternatives_1_0_12641 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_rule__DOUBLE__Alternatives_02674 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_rule__DOUBLE__Alternatives_02694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_rule__DOUBLE__Alternatives_12728 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DOUBLE__Group_1_1__0_in_rule__DOUBLE__Alternatives_12745 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_rule__DOUBLE__Alternatives_1_1_12778 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_rule__DOUBLE__Alternatives_1_1_12795 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_rule__DOUBLE__Alternatives_32827 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_rule__DOUBLE__Alternatives_32844 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__VType__Alternatives2877 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__VType__Alternatives2898 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__VType__Alternatives2919 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__VType__Alternatives2940 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__VType__Alternatives2961 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__VType__Alternatives2982 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__VType__Alternatives3003 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__EType__Alternatives3039 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__EType__Alternatives3060 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__ObjectType__Alternatives3096 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__ObjectType__Alternatives3117 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__ObjectType__Alternatives3138 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__ObjectType__Alternatives3159 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__ObjectType__Alternatives3180 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__ObjectType__Alternatives3201 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__ObjectType__Alternatives3222 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__ObjectType__Alternatives3243 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__ObjectType__Alternatives3264 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__ObjectType__Alternatives3285 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__ObjectType__Alternatives3306 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__ObjectType__Alternatives3327 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__ObjectType__Alternatives3348 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_rule__ObjectType__Alternatives3369 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__ObjectTypeRef__Alternatives3405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_rule__ObjectTypeRef__Alternatives3426 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_rule__ObjectTypeRef__Alternatives3447 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_rule__ObjectTypeRef__Alternatives3468 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_rule__ObjectTypeRef__Alternatives3489 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_rule__ObjectTypeRef__Alternatives3510 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_rule__ObjectTypeRef__Alternatives3531 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_rule__ObjectTypeRef__Alternatives3552 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_rule__ObjectTypeRef__Alternatives3573 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_rule__ObjectTypeRef__Alternatives3594 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_rule__ObjectTypeRef__Alternatives3615 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_rule__ObjectTypeRef__Alternatives3636 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_rule__ObjectTypeRef__Alternatives3657 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_rule__ObjectTypeRef__Alternatives3678 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group__0__Impl_in_rule__OilFile__Group__03711 = new BitSet(new long[]{0x0890000000000000L});
        public static final BitSet FOLLOW_rule__OilFile__Group__1_in_rule__OilFile__Group__03714 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group__1__Impl_in_rule__OilFile__Group__13772 = new BitSet(new long[]{0x0890000000000000L});
        public static final BitSet FOLLOW_rule__OilFile__Group__2_in_rule__OilFile__Group__13775 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group_1__0_in_rule__OilFile__Group__1__Impl3802 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group__2__Impl_in_rule__OilFile__Group__23833 = new BitSet(new long[]{0x0890000000000000L});
        public static final BitSet FOLLOW_rule__OilFile__Group__3_in_rule__OilFile__Group__23836 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__ImplementationAssignment_2_in_rule__OilFile__Group__2__Impl3863 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group__3__Impl_in_rule__OilFile__Group__33894 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__ApplicationAssignment_3_in_rule__OilFile__Group__3__Impl3921 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group_1__0__Impl_in_rule__OilFile__Group_1__03960 = new BitSet(new long[]{0x0020000000000000L});
        public static final BitSet FOLLOW_rule__OilFile__Group_1__1_in_rule__OilFile__Group_1__03963 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_rule__OilFile__Group_1__0__Impl3991 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group_1__1__Impl_in_rule__OilFile__Group_1__14022 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__OilFile__Group_1__2_in_rule__OilFile__Group_1__14025 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_rule__OilFile__Group_1__1__Impl4053 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group_1__2__Impl_in_rule__OilFile__Group_1__24084 = new BitSet(new long[]{0x0040000000000000L});
        public static final BitSet FOLLOW_rule__OilFile__Group_1__3_in_rule__OilFile__Group_1__24087 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__OilVersionAssignment_1_2_in_rule__OilFile__Group_1__2__Impl4114 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group_1__3__Impl_in_rule__OilFile__Group_1__34144 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_rule__OilFile__Group_1__3__Impl4172 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__0__Impl_in_rule__OilImplementation__Group__04211 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__1_in_rule__OilImplementation__Group__04214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_rule__OilImplementation__Group__0__Impl4242 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__1__Impl_in_rule__OilImplementation__Group__14273 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__2_in_rule__OilImplementation__Group__14276 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilImplementation__NameAssignment_1_in_rule__OilImplementation__Group__1__Impl4303 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__2__Impl_in_rule__OilImplementation__Group__24333 = new BitSet(new long[]{0x02040007FFC00000L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__3_in_rule__OilImplementation__Group__24336 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_rule__OilImplementation__Group__2__Impl4364 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__3__Impl_in_rule__OilImplementation__Group__34395 = new BitSet(new long[]{0x02040007FFC00000L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__4_in_rule__OilImplementation__Group__34398 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilImplementation__OilObjectsAssignment_3_in_rule__OilImplementation__Group__3__Impl4425 = new BitSet(new long[]{0x00040007FFC00002L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__4__Impl_in_rule__OilImplementation__Group__44456 = new BitSet(new long[]{0x0040000000000000L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__5_in_rule__OilImplementation__Group__44459 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_rule__OilImplementation__Group__4__Impl4487 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__5__Impl_in_rule__OilImplementation__Group__54518 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_rule__OilImplementation__Group__5__Impl4546 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__0__Impl_in_rule__OilObjectImpl__Group__04589 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__1_in_rule__OilObjectImpl__Group__04592 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__TypeAssignment_0_in_rule__OilObjectImpl__Group__0__Impl4619 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__1__Impl_in_rule__OilObjectImpl__Group__14649 = new BitSet(new long[]{0x0208FFF8003FE000L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__2_in_rule__OilObjectImpl__Group__14652 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_rule__OilObjectImpl__Group__1__Impl4680 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__2__Impl_in_rule__OilObjectImpl__Group__24711 = new BitSet(new long[]{0x0208FFF8003FE000L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__3_in_rule__OilObjectImpl__Group__24714 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__ParametersAssignment_2_in_rule__OilObjectImpl__Group__2__Impl4741 = new BitSet(new long[]{0x0008FFF8003FE002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__3__Impl_in_rule__OilObjectImpl__Group__34772 = new BitSet(new long[]{0x0440000000000000L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__4_in_rule__OilObjectImpl__Group__34775 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_rule__OilObjectImpl__Group__3__Impl4803 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__4__Impl_in_rule__OilObjectImpl__Group__44834 = new BitSet(new long[]{0x0440000000000000L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__5_in_rule__OilObjectImpl__Group__44837 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group_4__0_in_rule__OilObjectImpl__Group__4__Impl4864 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__5__Impl_in_rule__OilObjectImpl__Group__54895 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_rule__OilObjectImpl__Group__5__Impl4923 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group_4__0__Impl_in_rule__OilObjectImpl__Group_4__04966 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group_4__1_in_rule__OilObjectImpl__Group_4__04969 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_rule__OilObjectImpl__Group_4__0__Impl4997 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group_4__1__Impl_in_rule__OilObjectImpl__Group_4__15028 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__DescriptionAssignment_4_1_in_rule__OilObjectImpl__Group_4__1__Impl5055 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__0__Impl_in_rule__OilApplication__Group__05089 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__1_in_rule__OilApplication__Group__05092 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_59_in_rule__OilApplication__Group__0__Impl5120 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__1__Impl_in_rule__OilApplication__Group__15151 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__2_in_rule__OilApplication__Group__15154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__NameAssignment_1_in_rule__OilApplication__Group__1__Impl5181 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__2__Impl_in_rule__OilApplication__Group__25211 = new BitSet(new long[]{0x02040007FFC00000L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__3_in_rule__OilApplication__Group__25214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_rule__OilApplication__Group__2__Impl5242 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__3__Impl_in_rule__OilApplication__Group__35273 = new BitSet(new long[]{0x02040007FFC00000L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__4_in_rule__OilApplication__Group__35276 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__OilObjectsAssignment_3_in_rule__OilApplication__Group__3__Impl5303 = new BitSet(new long[]{0x00040007FFC00002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__4__Impl_in_rule__OilApplication__Group__45334 = new BitSet(new long[]{0x0440000000000000L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__5_in_rule__OilApplication__Group__45337 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_rule__OilApplication__Group__4__Impl5365 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__5__Impl_in_rule__OilApplication__Group__55396 = new BitSet(new long[]{0x0440000000000000L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__6_in_rule__OilApplication__Group__55399 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group_5__0_in_rule__OilApplication__Group__5__Impl5426 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__6__Impl_in_rule__OilApplication__Group__65457 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_rule__OilApplication__Group__6__Impl5485 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group_5__0__Impl_in_rule__OilApplication__Group_5__05530 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__OilApplication__Group_5__1_in_rule__OilApplication__Group_5__05533 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_rule__OilApplication__Group_5__0__Impl5561 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group_5__1__Impl_in_rule__OilApplication__Group_5__15592 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__DescriptionAssignment_5_1_in_rule__OilApplication__Group_5__1__Impl5619 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__0__Impl_in_rule__ValueType__Group__05653 = new BitSet(new long[]{0x00000000000FE000L});
        public static final BitSet FOLLOW_rule__ValueType__Group__1_in_rule__ValueType__Group__05656 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__1__Impl_in_rule__ValueType__Group__15714 = new BitSet(new long[]{0x1000FFFFFFFFE010L,0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__2_in_rule__ValueType__Group__15717 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__TypeAssignment_1_in_rule__ValueType__Group__1__Impl5744 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__2__Impl_in_rule__ValueType__Group__25774 = new BitSet(new long[]{0x1000FFFFFFFFE010L,0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__3_in_rule__ValueType__Group__25777 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__WithAutoAssignment_2_in_rule__ValueType__Group__2__Impl5804 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__3__Impl_in_rule__ValueType__Group__35835 = new BitSet(new long[]{0x1000FFFFFFFFE010L,0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__4_in_rule__ValueType__Group__35838 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_3__0_in_rule__ValueType__Group__3__Impl5865 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__4__Impl_in_rule__ValueType__Group__45896 = new BitSet(new long[]{0x0460000000000000L,0x0000000000000004L});
        public static final BitSet FOLLOW_rule__ValueType__Group__5_in_rule__ValueType__Group__45899 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__NameAssignment_4_in_rule__ValueType__Group__4__Impl5926 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__5__Impl_in_rule__ValueType__Group__55956 = new BitSet(new long[]{0x0460000000000000L,0x0000000000000004L});
        public static final BitSet FOLLOW_rule__ValueType__Group__6_in_rule__ValueType__Group__55959 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__MultiValueAssignment_5_in_rule__ValueType__Group__5__Impl5986 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__6__Impl_in_rule__ValueType__Group__66017 = new BitSet(new long[]{0x0460000000000000L,0x0000000000000004L});
        public static final BitSet FOLLOW_rule__ValueType__Group__7_in_rule__ValueType__Group__66020 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_6__0_in_rule__ValueType__Group__6__Impl6047 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__7__Impl_in_rule__ValueType__Group__76078 = new BitSet(new long[]{0x0460000000000000L,0x0000000000000004L});
        public static final BitSet FOLLOW_rule__ValueType__Group__8_in_rule__ValueType__Group__76081 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_7__0_in_rule__ValueType__Group__7__Impl6108 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__8__Impl_in_rule__ValueType__Group__86139 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_rule__ValueType__Group__8__Impl6167 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_3__0__Impl_in_rule__ValueType__Group_3__06216 = new BitSet(new long[]{0x00030000000001C0L});
        public static final BitSet FOLLOW_rule__ValueType__Group_3__1_in_rule__ValueType__Group_3__06219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_rule__ValueType__Group_3__0__Impl6247 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_3__1__Impl_in_rule__ValueType__Group_3__16278 = new BitSet(new long[]{0x2000000000000000L});
        public static final BitSet FOLLOW_rule__ValueType__Group_3__2_in_rule__ValueType__Group_3__16281 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Alternatives_3_1_in_rule__ValueType__Group_3__1__Impl6308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_3__2__Impl_in_rule__ValueType__Group_3__26338 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_rule__ValueType__Group_3__2__Impl6366 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_3_1_0__0__Impl_in_rule__ValueType__Group_3_1_0__06403 = new BitSet(new long[]{0x4000000000000000L});
        public static final BitSet FOLLOW_rule__ValueType__Group_3_1_0__1_in_rule__ValueType__Group_3_1_0__06406 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Alternatives_3_1_0_0_in_rule__ValueType__Group_3_1_0__0__Impl6433 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_3_1_0__1__Impl_in_rule__ValueType__Group_3_1_0__16463 = new BitSet(new long[]{0x00030000000001C0L});
        public static final BitSet FOLLOW_rule__ValueType__Group_3_1_0__2_in_rule__ValueType__Group_3_1_0__16466 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_rule__ValueType__Group_3_1_0__1__Impl6494 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_3_1_0__2__Impl_in_rule__ValueType__Group_3_1_0__26525 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Alternatives_3_1_0_2_in_rule__ValueType__Group_3_1_0__2__Impl6552 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_3_1_1__0__Impl_in_rule__ValueType__Group_3_1_1__06588 = new BitSet(new long[]{0x8000000000000000L});
        public static final BitSet FOLLOW_rule__ValueType__Group_3_1_1__1_in_rule__ValueType__Group_3_1_1__06591 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Alternatives_3_1_1_0_in_rule__ValueType__Group_3_1_1__0__Impl6618 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_3_1_1__1__Impl_in_rule__ValueType__Group_3_1_1__16648 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_3_1_1_1__0_in_rule__ValueType__Group_3_1_1__1__Impl6675 = new BitSet(new long[]{0x8000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_3_1_1_1__0__Impl_in_rule__ValueType__Group_3_1_1_1__06710 = new BitSet(new long[]{0x00030000000001C0L});
        public static final BitSet FOLLOW_rule__ValueType__Group_3_1_1_1__1_in_rule__ValueType__Group_3_1_1_1__06713 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_63_in_rule__ValueType__Group_3_1_1_1__0__Impl6741 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_3_1_1_1__1__Impl_in_rule__ValueType__Group_3_1_1_1__16772 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Alternatives_3_1_1_1_1_in_rule__ValueType__Group_3_1_1_1__1__Impl6799 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_6__0__Impl_in_rule__ValueType__Group_6__06833 = new BitSet(new long[]{0x00030000000001F0L,0x0000000000000008L});
        public static final BitSet FOLLOW_rule__ValueType__Group_6__1_in_rule__ValueType__Group_6__06836 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_rule__ValueType__Group_6__0__Impl6864 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_6__1__Impl_in_rule__ValueType__Group_6__16895 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Alternatives_6_1_in_rule__ValueType__Group_6__1__Impl6922 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_7__0__Impl_in_rule__ValueType__Group_7__06956 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__ValueType__Group_7__1_in_rule__ValueType__Group_7__06959 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_rule__ValueType__Group_7__0__Impl6987 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_7__1__Impl_in_rule__ValueType__Group_7__17018 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__DescriptionAssignment_7_1_in_rule__ValueType__Group_7__1__Impl7045 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__0__Impl_in_rule__VariantType__Group__07079 = new BitSet(new long[]{0x0000000000300000L});
        public static final BitSet FOLLOW_rule__VariantType__Group__1_in_rule__VariantType__Group__07082 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__1__Impl_in_rule__VariantType__Group__17140 = new BitSet(new long[]{0x1000FFFFFFFFE010L,0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__2_in_rule__VariantType__Group__17143 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__TypeAssignment_1_in_rule__VariantType__Group__1__Impl7170 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__2__Impl_in_rule__VariantType__Group__27200 = new BitSet(new long[]{0x1000FFFFFFFFE010L,0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__3_in_rule__VariantType__Group__27203 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__WithAutoAssignment_2_in_rule__VariantType__Group__2__Impl7230 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__3__Impl_in_rule__VariantType__Group__37261 = new BitSet(new long[]{0x1000FFFFFFFFE010L,0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__4_in_rule__VariantType__Group__37264 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3__0_in_rule__VariantType__Group__3__Impl7291 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__4__Impl_in_rule__VariantType__Group__47322 = new BitSet(new long[]{0x0460000000000000L,0x0000000000000004L});
        public static final BitSet FOLLOW_rule__VariantType__Group__5_in_rule__VariantType__Group__47325 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__NameAssignment_4_in_rule__VariantType__Group__4__Impl7352 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__5__Impl_in_rule__VariantType__Group__57382 = new BitSet(new long[]{0x0460000000000000L,0x0000000000000004L});
        public static final BitSet FOLLOW_rule__VariantType__Group__6_in_rule__VariantType__Group__57385 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__MultiValueAssignment_5_in_rule__VariantType__Group__5__Impl7412 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__6__Impl_in_rule__VariantType__Group__67443 = new BitSet(new long[]{0x0460000000000000L,0x0000000000000004L});
        public static final BitSet FOLLOW_rule__VariantType__Group__7_in_rule__VariantType__Group__67446 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_6__0_in_rule__VariantType__Group__6__Impl7473 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__7__Impl_in_rule__VariantType__Group__77504 = new BitSet(new long[]{0x0460000000000000L,0x0000000000000004L});
        public static final BitSet FOLLOW_rule__VariantType__Group__8_in_rule__VariantType__Group__77507 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_7__0_in_rule__VariantType__Group__7__Impl7534 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__8__Impl_in_rule__VariantType__Group__87565 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_rule__VariantType__Group__8__Impl7593 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3__0__Impl_in_rule__VariantType__Group_3__07642 = new BitSet(new long[]{0x3000FFFFFFFFE010L,0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3__1_in_rule__VariantType__Group_3__07645 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_rule__VariantType__Group_3__0__Impl7673 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3__1__Impl_in_rule__VariantType__Group_3__17704 = new BitSet(new long[]{0x3000FFFFFFFFE010L,0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3__2_in_rule__VariantType__Group_3__17707 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3_1__0_in_rule__VariantType__Group_3__1__Impl7734 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3__2__Impl_in_rule__VariantType__Group_3__27765 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_rule__VariantType__Group_3__2__Impl7793 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3_1__0__Impl_in_rule__VariantType__Group_3_1__07830 = new BitSet(new long[]{0x8000000000000000L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3_1__1_in_rule__VariantType__Group_3_1__07833 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__ValuesAssignment_3_1_0_in_rule__VariantType__Group_3_1__0__Impl7860 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3_1__1__Impl_in_rule__VariantType__Group_3_1__17890 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3_1_1__0_in_rule__VariantType__Group_3_1__1__Impl7917 = new BitSet(new long[]{0x8000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3_1_1__0__Impl_in_rule__VariantType__Group_3_1_1__07952 = new BitSet(new long[]{0x1000FFFFFFFFE010L,0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3_1_1__1_in_rule__VariantType__Group_3_1_1__07955 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_63_in_rule__VariantType__Group_3_1_1__0__Impl7983 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3_1_1__1__Impl_in_rule__VariantType__Group_3_1_1__18014 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__ValuesAssignment_3_1_1_1_in_rule__VariantType__Group_3_1_1__1__Impl8041 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_6__0__Impl_in_rule__VariantType__Group_6__08075 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000008L});
        public static final BitSet FOLLOW_rule__VariantType__Group_6__1_in_rule__VariantType__Group_6__08078 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_rule__VariantType__Group_6__0__Impl8106 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_6__1__Impl_in_rule__VariantType__Group_6__18137 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Alternatives_6_1_in_rule__VariantType__Group_6__1__Impl8164 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_7__0__Impl_in_rule__VariantType__Group_7__08198 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__VariantType__Group_7__1_in_rule__VariantType__Group_7__08201 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_rule__VariantType__Group_7__0__Impl8229 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_7__1__Impl_in_rule__VariantType__Group_7__18260 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__DescriptionAssignment_7_1_in_rule__VariantType__Group_7__1__Impl8287 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group__0__Impl_in_rule__EnumeratorType__Group__08321 = new BitSet(new long[]{0x1000FFFFFFFFE010L,0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group__1_in_rule__EnumeratorType__Group__08324 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group__1__Impl_in_rule__EnumeratorType__Group__18382 = new BitSet(new long[]{0x0500000000000000L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group__2_in_rule__EnumeratorType__Group__18385 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__NameAssignment_1_in_rule__EnumeratorType__Group__1__Impl8412 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group__2__Impl_in_rule__EnumeratorType__Group__28442 = new BitSet(new long[]{0x0500000000000000L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group__3_in_rule__EnumeratorType__Group__28445 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_2__0_in_rule__EnumeratorType__Group__2__Impl8472 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group__3__Impl_in_rule__EnumeratorType__Group__38503 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_3__0_in_rule__EnumeratorType__Group__3__Impl8530 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_2__0__Impl_in_rule__EnumeratorType__Group_2__08569 = new BitSet(new long[]{0x0208FFF8003FE000L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_2__1_in_rule__EnumeratorType__Group_2__08572 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_rule__EnumeratorType__Group_2__0__Impl8600 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_2__1__Impl_in_rule__EnumeratorType__Group_2__18631 = new BitSet(new long[]{0x0208FFF8003FE000L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_2__2_in_rule__EnumeratorType__Group_2__18634 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__ParametersAssignment_2_1_in_rule__EnumeratorType__Group_2__1__Impl8661 = new BitSet(new long[]{0x0008FFF8003FE002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_2__2__Impl_in_rule__EnumeratorType__Group_2__28692 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_rule__EnumeratorType__Group_2__2__Impl8720 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_3__0__Impl_in_rule__EnumeratorType__Group_3__08757 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_3__1_in_rule__EnumeratorType__Group_3__08760 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_rule__EnumeratorType__Group_3__0__Impl8788 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_3__1__Impl_in_rule__EnumeratorType__Group_3__18819 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__DescriptionAssignment_3_1_in_rule__EnumeratorType__Group_3__1__Impl8846 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__0__Impl_in_rule__ReferenceType__Group__08880 = new BitSet(new long[]{0x0008FFF8003FE000L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__1_in_rule__ReferenceType__Group__08883 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__1__Impl_in_rule__ReferenceType__Group__18941 = new BitSet(new long[]{0x1000FFFFFFFFE010L,0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__2_in_rule__ReferenceType__Group__18944 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__TypeAssignment_1_in_rule__ReferenceType__Group__1__Impl8971 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__2__Impl_in_rule__ReferenceType__Group__29001 = new BitSet(new long[]{0x1000FFFFFFFFE010L,0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__3_in_rule__ReferenceType__Group__29004 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__WithAutoAssignment_2_in_rule__ReferenceType__Group__2__Impl9031 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__3__Impl_in_rule__ReferenceType__Group__39062 = new BitSet(new long[]{0x0460000000000000L,0x0000000000000004L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__4_in_rule__ReferenceType__Group__39065 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__NameAssignment_3_in_rule__ReferenceType__Group__3__Impl9092 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__4__Impl_in_rule__ReferenceType__Group__49122 = new BitSet(new long[]{0x0460000000000000L,0x0000000000000004L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__5_in_rule__ReferenceType__Group__49125 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__MultiValueAssignment_4_in_rule__ReferenceType__Group__4__Impl9152 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__5__Impl_in_rule__ReferenceType__Group__59183 = new BitSet(new long[]{0x0460000000000000L,0x0000000000000004L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__6_in_rule__ReferenceType__Group__59186 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_5__0_in_rule__ReferenceType__Group__5__Impl9213 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__6__Impl_in_rule__ReferenceType__Group__69244 = new BitSet(new long[]{0x0460000000000000L,0x0000000000000004L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__7_in_rule__ReferenceType__Group__69247 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_6__0_in_rule__ReferenceType__Group__6__Impl9274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__7__Impl_in_rule__ReferenceType__Group__79305 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_rule__ReferenceType__Group__7__Impl9333 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_5__0__Impl_in_rule__ReferenceType__Group_5__09380 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000008L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_5__1_in_rule__ReferenceType__Group_5__09383 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_rule__ReferenceType__Group_5__0__Impl9411 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_5__1__Impl_in_rule__ReferenceType__Group_5__19442 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Alternatives_5_1_in_rule__ReferenceType__Group_5__1__Impl9469 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_6__0__Impl_in_rule__ReferenceType__Group_6__09503 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_6__1_in_rule__ReferenceType__Group_6__09506 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_rule__ReferenceType__Group_6__0__Impl9534 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_6__1__Impl_in_rule__ReferenceType__Group_6__19565 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__DescriptionAssignment_6_1_in_rule__ReferenceType__Group_6__1__Impl9592 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group__0__Impl_in_rule__OilObject__Group__09626 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__OilObject__Group__1_in_rule__OilObject__Group__09629 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__TypeAssignment_0_in_rule__OilObject__Group__0__Impl9656 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group__1__Impl_in_rule__OilObject__Group__19686 = new BitSet(new long[]{0x0540000000000000L});
        public static final BitSet FOLLOW_rule__OilObject__Group__2_in_rule__OilObject__Group__19689 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__NameAssignment_1_in_rule__OilObject__Group__1__Impl9716 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group__2__Impl_in_rule__OilObject__Group__29746 = new BitSet(new long[]{0x0540000000000000L});
        public static final BitSet FOLLOW_rule__OilObject__Group__3_in_rule__OilObject__Group__29749 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group_2__0_in_rule__OilObject__Group__2__Impl9776 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group__3__Impl_in_rule__OilObject__Group__39807 = new BitSet(new long[]{0x0540000000000000L});
        public static final BitSet FOLLOW_rule__OilObject__Group__4_in_rule__OilObject__Group__39810 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group_3__0_in_rule__OilObject__Group__3__Impl9837 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group__4__Impl_in_rule__OilObject__Group__49868 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_rule__OilObject__Group__4__Impl9896 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group_2__0__Impl_in_rule__OilObject__Group_2__09937 = new BitSet(new long[]{0x1200FFFFFFFFE010L,0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group_2__1_in_rule__OilObject__Group_2__09940 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_rule__OilObject__Group_2__0__Impl9968 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group_2__1__Impl_in_rule__OilObject__Group_2__19999 = new BitSet(new long[]{0x1200FFFFFFFFE010L,0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group_2__2_in_rule__OilObject__Group_2__110002 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__ParametersAssignment_2_1_in_rule__OilObject__Group_2__1__Impl10029 = new BitSet(new long[]{0x1000FFFFFFFFE012L,0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group_2__2__Impl_in_rule__OilObject__Group_2__210060 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_rule__OilObject__Group_2__2__Impl10088 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group_3__0__Impl_in_rule__OilObject__Group_3__010125 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__OilObject__Group_3__1_in_rule__OilObject__Group_3__010128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_rule__OilObject__Group_3__0__Impl10156 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group_3__1__Impl_in_rule__OilObject__Group_3__110187 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__DescriptionAssignment_3_1_in_rule__OilObject__Group_3__1__Impl10214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__0__Impl_in_rule__Parameter__Group__010248 = new BitSet(new long[]{0x1000FFFFFFFFE010L,0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__1_in_rule__Parameter__Group__010251 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__1__Impl_in_rule__Parameter__Group__110309 = new BitSet(new long[]{0x0020000000000000L});
        public static final BitSet FOLLOW_rule__Parameter__Group__2_in_rule__Parameter__Group__110312 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__TypeAssignment_1_in_rule__Parameter__Group__1__Impl10339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__2__Impl_in_rule__Parameter__Group__210369 = new BitSet(new long[]{0x1003FFFFFFFFE1F0L,0x000000000000000AL});
        public static final BitSet FOLLOW_rule__Parameter__Group__3_in_rule__Parameter__Group__210372 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_rule__Parameter__Group__2__Impl10400 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__3__Impl_in_rule__Parameter__Group__310431 = new BitSet(new long[]{0x0540000000000000L});
        public static final BitSet FOLLOW_rule__Parameter__Group__4_in_rule__Parameter__Group__310434 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Alternatives_3_in_rule__Parameter__Group__3__Impl10461 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__4__Impl_in_rule__Parameter__Group__410491 = new BitSet(new long[]{0x0540000000000000L});
        public static final BitSet FOLLOW_rule__Parameter__Group__5_in_rule__Parameter__Group__410494 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group_4__0_in_rule__Parameter__Group__4__Impl10521 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__5__Impl_in_rule__Parameter__Group__510552 = new BitSet(new long[]{0x0540000000000000L});
        public static final BitSet FOLLOW_rule__Parameter__Group__6_in_rule__Parameter__Group__510555 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group_5__0_in_rule__Parameter__Group__5__Impl10582 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__6__Impl_in_rule__Parameter__Group__610613 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_rule__Parameter__Group__6__Impl10641 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group_4__0__Impl_in_rule__Parameter__Group_4__010686 = new BitSet(new long[]{0x1200FFFFFFFFE010L,0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group_4__1_in_rule__Parameter__Group_4__010689 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_rule__Parameter__Group_4__0__Impl10717 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group_4__1__Impl_in_rule__Parameter__Group_4__110748 = new BitSet(new long[]{0x1200FFFFFFFFE010L,0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group_4__2_in_rule__Parameter__Group_4__110751 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__ParametersAssignment_4_1_in_rule__Parameter__Group_4__1__Impl10778 = new BitSet(new long[]{0x1000FFFFFFFFE012L,0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group_4__2__Impl_in_rule__Parameter__Group_4__210809 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_rule__Parameter__Group_4__2__Impl10837 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group_5__0__Impl_in_rule__Parameter__Group_5__010874 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Parameter__Group_5__1_in_rule__Parameter__Group_5__010877 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_rule__Parameter__Group_5__0__Impl10905 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group_5__1__Impl_in_rule__Parameter__Group_5__110936 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__DescriptionAssignment_5_1_in_rule__Parameter__Group_5__1__Impl10963 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Group__0__Impl_in_rule__INT__Group__010997 = new BitSet(new long[]{0x00030000000001C0L});
        public static final BitSet FOLLOW_rule__INT__Group__1_in_rule__INT__Group__011000 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Alternatives_0_in_rule__INT__Group__0__Impl11027 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Group__1__Impl_in_rule__INT__Group__111058 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Alternatives_1_in_rule__INT__Group__1__Impl11085 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Group_1_0__0__Impl_in_rule__INT__Group_1_0__011119 = new BitSet(new long[]{0x0000000000000140L});
        public static final BitSet FOLLOW_rule__INT__Group_1_0__1_in_rule__INT__Group_1_0__011122 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_rule__INT__Group_1_0__0__Impl11149 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Group_1_0__1__Impl_in_rule__INT__Group_1_0__111178 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Alternatives_1_0_1_in_rule__INT__Group_1_0__1__Impl11205 = new BitSet(new long[]{0x0000000000000142L});
        public static final BitSet FOLLOW_rule__DOUBLE__Group__0__Impl_in_rule__DOUBLE__Group__011240 = new BitSet(new long[]{0x00030000000001C0L});
        public static final BitSet FOLLOW_rule__DOUBLE__Group__1_in_rule__DOUBLE__Group__011243 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DOUBLE__Alternatives_0_in_rule__DOUBLE__Group__0__Impl11270 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DOUBLE__Group__1__Impl_in_rule__DOUBLE__Group__111301 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
        public static final BitSet FOLLOW_rule__DOUBLE__Group__2_in_rule__DOUBLE__Group__111304 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DOUBLE__Alternatives_1_in_rule__DOUBLE__Group__1__Impl11331 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DOUBLE__Group__2__Impl_in_rule__DOUBLE__Group__211361 = new BitSet(new long[]{0x0000000000000140L});
        public static final BitSet FOLLOW_rule__DOUBLE__Group__3_in_rule__DOUBLE__Group__211364 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_64_in_rule__DOUBLE__Group__2__Impl11393 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DOUBLE__Group__3__Impl_in_rule__DOUBLE__Group__311425 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DOUBLE__Alternatives_3_in_rule__DOUBLE__Group__3__Impl11454 = new BitSet(new long[]{0x0000000000000142L});
        public static final BitSet FOLLOW_rule__DOUBLE__Alternatives_3_in_rule__DOUBLE__Group__3__Impl11466 = new BitSet(new long[]{0x0000000000000142L});
        public static final BitSet FOLLOW_rule__DOUBLE__Group_1_1__0__Impl_in_rule__DOUBLE__Group_1_1__011507 = new BitSet(new long[]{0x0000000000000140L});
        public static final BitSet FOLLOW_rule__DOUBLE__Group_1_1__1_in_rule__DOUBLE__Group_1_1__011510 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_rule__DOUBLE__Group_1_1__0__Impl11537 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DOUBLE__Group_1_1__1__Impl_in_rule__DOUBLE__Group_1_1__111566 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__DOUBLE__Alternatives_1_1_1_in_rule__DOUBLE__Group_1_1__1__Impl11593 = new BitSet(new long[]{0x0000000000000142L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__OilFile__OilVersionAssignment_1_211633 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilImplementation_in_rule__OilFile__ImplementationAssignment_211664 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilApplication_in_rule__OilFile__ApplicationAssignment_311695 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__OilImplementation__NameAssignment_111726 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilObjectImpl_in_rule__OilImplementation__OilObjectsAssignment_311757 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectType_in_rule__OilObjectImpl__TypeAssignment_011788 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameterType_in_rule__OilObjectImpl__ParametersAssignment_211819 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__OilObjectImpl__DescriptionAssignment_4_111850 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__OilApplication__NameAssignment_111881 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilObject_in_rule__OilApplication__OilObjectsAssignment_311912 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__OilApplication__DescriptionAssignment_5_111943 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVType_in_rule__ValueType__TypeAssignment_111974 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_rule__ValueType__WithAutoAssignment_212010 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecialId_in_rule__ValueType__NameAssignment_412049 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_rule__ValueType__MultiValueAssignment_512085 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_67_in_rule__ValueType__DefaultAutoAssignment_6_1_012129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__DefaultValueAlternatives_6_1_1_0_in_rule__ValueType__DefaultValueAssignment_6_1_112168 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__ValueType__DescriptionAssignment_7_112201 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEType_in_rule__VariantType__TypeAssignment_112232 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_rule__VariantType__WithAutoAssignment_212268 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumeratorType_in_rule__VariantType__ValuesAssignment_3_1_012307 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumeratorType_in_rule__VariantType__ValuesAssignment_3_1_1_112338 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecialId_in_rule__VariantType__NameAssignment_412369 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_rule__VariantType__MultiValueAssignment_512405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_67_in_rule__VariantType__DefaultAutoAssignment_6_1_012449 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__VariantType__DefaultValueAssignment_6_1_112488 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__VariantType__DescriptionAssignment_7_112519 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecialId_in_rule__EnumeratorType__NameAssignment_112550 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameterType_in_rule__EnumeratorType__ParametersAssignment_2_112581 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__EnumeratorType__DescriptionAssignment_3_112612 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectTypeRef_in_rule__ReferenceType__TypeAssignment_112643 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_rule__ReferenceType__WithAutoAssignment_212679 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecialId_in_rule__ReferenceType__NameAssignment_312718 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_rule__ReferenceType__MultiValueAssignment_412754 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_67_in_rule__ReferenceType__DefaultAutoAssignment_5_1_012798 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ReferenceType__DefaultValueAssignment_5_1_112837 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__ReferenceType__DescriptionAssignment_6_112868 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectType_in_rule__OilObject__TypeAssignment_012899 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__OilObject__NameAssignment_112930 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameter_in_rule__OilObject__ParametersAssignment_2_112961 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__OilObject__DescriptionAssignment_3_112992 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecialId_in_rule__Parameter__TypeAssignment_113027 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_67_in_rule__Parameter__AutoAssignment_3_013067 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGenericValue_in_rule__Parameter__ValueAssignment_3_113106 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecialId_in_rule__Parameter__ValueRefAssignment_3_213141 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameter_in_rule__Parameter__ParametersAssignment_4_113176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Parameter__DescriptionAssignment_5_113207 = new BitSet(new long[]{0x0000000000000002L});
    }


}